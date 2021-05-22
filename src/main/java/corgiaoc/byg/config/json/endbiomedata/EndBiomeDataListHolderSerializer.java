package corgiaoc.byg.config.json.endbiomedata;

import com.google.gson.*;
import corgiaoc.byg.BYG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class EndBiomeDataListHolderSerializer implements JsonSerializer<EndBiomeDataListHolder>, JsonDeserializer<EndBiomeDataListHolder> {


    private final Registry<Biome> biomeRegistry;

    public EndBiomeDataListHolderSerializer(Registry<Biome> biomeRegistry) {
        this.biomeRegistry = biomeRegistry;
    }

    @Override
    public JsonElement serialize(EndBiomeDataListHolder Src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject biomes = new JsonObject();
        JsonObject endBiomeObject = new JsonObject();
        JsonObject voidBiomeObject = new JsonObject();

        for (EndBiomeData endBiomeData : Src.getEndBiomeData()) {

            JsonArray hillListArray = new JsonArray();
            JsonObject endBiome = new JsonObject();

            if (endBiomeData.getBiomeWeightedList() != null) {
                for (WeightedList.Entry<ResourceLocation> biomeEntry : endBiomeData.getBiomeWeightedList().entries) {
                    JsonObject object2 = new JsonObject();
                    ResourceLocation biomeEntryKey = biomeEntry.getData();

                    if (biomeEntryKey != null) {
                        object2.addProperty("name", biomeEntryKey.toString());
                        object2.addProperty("weight", biomeEntry.weight);
                        hillListArray.add(object2);
                    } else {
                        BYG.LOGGER.error("One or more \"hills\" \"name\" value was null/incorrect.");
                    }
                }
            }
            StringBuilder dictionaryString = new StringBuilder();

            for (BiomeDictionary.Type type : endBiomeData.getDictionaryTypes()) {
                if (!dictionaryString.toString().isEmpty())
                    dictionaryString.append(",");
                dictionaryString.append(type.toString());
            }


            endBiome.addProperty("dictionary", dictionaryString.toString().toUpperCase());
            endBiome.addProperty("weight", endBiomeData.getBiomeWeight());
            ResourceLocation edgeKey = endBiomeData.getEdgeBiome();
            if (edgeKey != null)
                endBiome.addProperty("edge", edgeKey.toString());
            else
                endBiome.addProperty("edge", "");

            endBiome.add("hills", hillListArray);

            //This should never be null.
            ResourceLocation location = endBiomeData.getBiome();
            if (location != null) {
                if (dictionaryString.toString().contains("VOID"))
                    voidBiomeObject.add(location.toString(), endBiome);
                else
                    endBiomeObject.add(location.toString(), endBiome);
            } else
                BYG.LOGGER.error("The Biome key was null! This should NEVER happen.");

        }
        biomes.add("biomes", endBiomeObject);
        biomes.add("void-biomes", voidBiomeObject);

        return biomes;
    }

    @Override
    public EndBiomeDataListHolder deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        BYG.LOGGER.info("Reading json");

        JsonObject jsonObject = json.getAsJsonObject();
        List<EndBiomeData> endBiomeData = new ArrayList<>();
        List<EndBiomeData> voidBiomeData = new ArrayList<>();

        extractElements(endBiomeData, getOrDefault(jsonObject, "biomes", new JsonObject()).entrySet(), biomeRegistry);
        extractElements(voidBiomeData, getOrDefault(jsonObject, "void-biomes", new JsonObject()).entrySet(), biomeRegistry);
        return new EndBiomeDataListHolder(endBiomeData, voidBiomeData);
    }

    private static void extractElements(List<EndBiomeData> endBiomeData, Set<Map.Entry<String, JsonElement>> entrySet, Registry<Biome> biomeRegistry) {
        for (Map.Entry<String, JsonElement> elementEntry : entrySet) {

            JsonObject elementObject = elementEntry.getValue().getAsJsonObject();

            ResourceLocation biomeKey = new ResourceLocation(elementEntry.getKey());
            if (biomeRegistry.keySet().contains(biomeKey)) {
                endBiomeData.add(new EndBiomeData(biomeKey, getOrDefault(elementObject, "weight", 0), processBiomeDictionary(elementObject),
                        processHills(elementObject, biomeRegistry), new ResourceLocation(getOrDefault(elementObject, "edge", ""))));
            } else
                BYG.LOGGER.error("The biome key: \"" + elementEntry.getKey() + "\" was not found in the registry, skipping entry...");
        }
    }

    private static WeightedList<ResourceLocation> processHills(JsonObject elementObject, Registry<Biome> biomeRegistry) {
        WeightedList<ResourceLocation> hills = new WeightedList<>();
        for (JsonElement hillElement : getOrDefault(elementObject, "hills", new JsonArray())) {
            processHillData(hills, hillElement, biomeRegistry);
        }
        return hills;
    }

    private static void processHillData(WeightedList<ResourceLocation> weightedList, JsonElement hillElement, Registry<Biome> biomeRegistry) {
        JsonObject hillObject = hillElement.getAsJsonObject();

        String hillBiomeName = getOrDefault(hillObject, "name", "");

        @Nullable
        ResourceLocation hillResourceLocation = hillBiomeName.isEmpty() ? null : new ResourceLocation(hillBiomeName);

        if (hillResourceLocation != null) {
            if (biomeRegistry.keySet().contains(hillResourceLocation))
                weightedList.add(hillResourceLocation, getOrDefault(hillObject, "weight", 0));
            else
                BYG.LOGGER.error("Could not find: \"" + hillResourceLocation.toString() + "\" in the biome registry!\nEntry will not be added. Skipping entry...");
        }
    }

    private static BiomeDictionary.Type[] processBiomeDictionary(JsonObject elementObject) {
        List<BiomeDictionary.Type> types = Arrays.stream(getOrDefault(elementObject, "dictionary", "").trim().replace(" ", "").toUpperCase().split(",")).map(BiomeDictionary.Type::getType).collect(Collectors.toList());
        BiomeDictionary.Type[] typesArray = new BiomeDictionary.Type[types.size()];
        typesArray = types.toArray(typesArray);

        if (types.size() == 0) {
            types.add(BiomeDictionary.Type.END);
            BYG.LOGGER.warn("No dictionary entries were read...defaulting to: \"END\"");
        }
        return typesArray;
    }

    public static <T> T getOrDefault(JsonObject json, String key, T defaultValue) {
        if (json.has(key)) {
            if (defaultValue instanceof String) {
                try {
                    return (T) json.get(key).getAsString();
                } catch (Exception e) {
                    return defaultValue;
                }
            } else if (defaultValue instanceof JsonArray) {
                try {
                    return (T) json.get(key).getAsJsonArray();
                } catch (Exception e) {
                    return defaultValue;
                }
            } else if (defaultValue instanceof JsonObject) {
                try {
                    return (T) json.get(key).getAsJsonObject();
                } catch (Exception e) {
                    return defaultValue;
                }
            }
        }
        BYG.LOGGER.error("Could not find element for key: \"" + key + "\"");
        return defaultValue;
    }

    public static int getOrDefault(JsonObject json, String key, int defaultValue) {
        if (json.has(key)) {
            try {
                return json.get(key).getAsInt();
            } catch (Exception e) {
                return defaultValue;
            }
        }
        BYG.LOGGER.error("Could not find element for key: \"" + key + "\"");
        return defaultValue;
    }

    public static double getOrDefault(JsonObject json, String key, double defaultValue) {
        if (json.has(key)) {
            try {
                return json.get(key).getAsDouble();
            } catch (Exception e) {
                return defaultValue;
            }
        }
        BYG.LOGGER.error("Could not find element for key: \"" + key + "\"");
        return defaultValue;
    }

    public static float getOrDefault(JsonObject json, String key, float defaultValue) {
        if (json.has(key)) {
            try {
                return json.get(key).getAsFloat();
            } catch (Exception e) {
                return defaultValue;
            }
        }
        BYG.LOGGER.error("Could not find element for key: \"" + key + "\"");
        return defaultValue;
    }
}
