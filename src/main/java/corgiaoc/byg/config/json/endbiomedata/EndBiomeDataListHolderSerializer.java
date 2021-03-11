package corgiaoc.byg.config.json.endbiomedata;

import com.google.gson.*;
import corgiaoc.byg.BYG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraftforge.common.BiomeDictionary;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class EndBiomeDataListHolderSerializer implements JsonSerializer<EndBiomeDataListHolder>, JsonDeserializer<EndBiomeDataListHolder> {

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

        extractElements(endBiomeData, jsonObject.get("biomes").getAsJsonObject().entrySet());
        extractElements(voidBiomeData, jsonObject.get("void-biomes").getAsJsonObject().entrySet());
        return new EndBiomeDataListHolder(endBiomeData, voidBiomeData);
    }

    private void extractElements(List<EndBiomeData> endBiomeData, Set<Map.Entry<String, JsonElement>> entrySet) {
        for (Map.Entry<String, JsonElement> elementEntry : entrySet) {
            WeightedList<ResourceLocation> weightedList = new WeightedList<>();

            String biomeName = elementEntry.getKey();
            JsonElement element = elementEntry.getValue();

            JsonObject elementObject = element.getAsJsonObject();

            String edge = elementObject.get("edge").getAsString();

            int weight = elementObject.get("weight").getAsInt();

            JsonArray hillLayerList = elementObject.get("hills").getAsJsonArray();

            String dictionary = elementObject.get("dictionary").getAsString();

            List<BiomeDictionary.Type> types = Arrays.stream(dictionary.trim().replace(" ", "").toUpperCase().split(",")).map(this::warnIfTagIsNotDefault).map(BiomeDictionary.Type::getType).collect(Collectors.toList());

            BiomeDictionary.Type[] typesArray = new BiomeDictionary.Type[types.size()];
            typesArray = types.toArray(typesArray);

            if (types.size() == 0) {
                types.add(BiomeDictionary.Type.END);
                BYG.LOGGER.warn("No dictionary entries were read...defaulting to: \"END\"");
            }

            for (JsonElement hillElement : hillLayerList) {
                JsonObject hillObject = hillElement.getAsJsonObject();

                String hillBiomeName = hillObject.get("name").getAsString();
                Integer hillWeight = hillObject.get("weight").getAsInt();

                if (hillBiomeName != null && hillWeight != null) {
                    ResourceLocation hillResourceLocation = new ResourceLocation(hillBiomeName);

                    if (hillResourceLocation != null) {
                        if (BYG.EARLY_BIOME_REGISTRY_ACCESS.keySet().contains(hillResourceLocation))
                            weightedList.add(hillResourceLocation, hillWeight);
                        else
                            BYG.LOGGER.error("Could not find: \"" + hillResourceLocation.toString() + "\" in the biome registry!\nEntry will not be added. Skipping entry...");
                    }
                }
            }
            ResourceLocation biomeKey = new ResourceLocation(biomeName);
            if (BYG.EARLY_BIOME_REGISTRY_ACCESS.keySet().contains(biomeKey)) {
                endBiomeData.add(new EndBiomeData(biomeKey, weight, typesArray, weightedList, new ResourceLocation(edge)));
            } else
                BYG.LOGGER.error("The biome key: \"" + biomeName + "\" was not found in the registry, skipping entry...");
        }
    }

    public static List<BiomeDictionary.Type> defaultTypesList = new ArrayList<>();

    static {
        defaultTypesList.add(BiomeDictionary.Type.HOT);
        defaultTypesList.add(BiomeDictionary.Type.COLD);
        defaultTypesList.add(BiomeDictionary.Type.SPARSE);
        defaultTypesList.add(BiomeDictionary.Type.DENSE);
        defaultTypesList.add(BiomeDictionary.Type.WET);
        defaultTypesList.add(BiomeDictionary.Type.DRY);
        defaultTypesList.add(BiomeDictionary.Type.SAVANNA);
        defaultTypesList.add(BiomeDictionary.Type.CONIFEROUS);
        defaultTypesList.add(BiomeDictionary.Type.JUNGLE);
        defaultTypesList.add(BiomeDictionary.Type.SPOOKY);
        defaultTypesList.add(BiomeDictionary.Type.DEAD);
        defaultTypesList.add(BiomeDictionary.Type.LUSH);
        defaultTypesList.add(BiomeDictionary.Type.MUSHROOM);
        defaultTypesList.add(BiomeDictionary.Type.MAGICAL);
        defaultTypesList.add(BiomeDictionary.Type.RARE);
        defaultTypesList.add(BiomeDictionary.Type.PLATEAU);
        defaultTypesList.add(BiomeDictionary.Type.MODIFIED);
        defaultTypesList.add(BiomeDictionary.Type.OCEAN);
        defaultTypesList.add(BiomeDictionary.Type.RIVER);
        defaultTypesList.add(BiomeDictionary.Type.WATER);
        defaultTypesList.add(BiomeDictionary.Type.MESA);
        defaultTypesList.add(BiomeDictionary.Type.FOREST);
        defaultTypesList.add(BiomeDictionary.Type.PLAINS);
        defaultTypesList.add(BiomeDictionary.Type.MOUNTAIN);
        defaultTypesList.add(BiomeDictionary.Type.HILLS);
        defaultTypesList.add(BiomeDictionary.Type.SWAMP);
        defaultTypesList.add(BiomeDictionary.Type.SANDY);
        defaultTypesList.add(BiomeDictionary.Type.SNOWY);
        defaultTypesList.add(BiomeDictionary.Type.WASTELAND);
        defaultTypesList.add(BiomeDictionary.Type.VOID);
        defaultTypesList.add(BiomeDictionary.Type.OVERWORLD);
        defaultTypesList.add(BiomeDictionary.Type.BEACH);
        defaultTypesList.add(BiomeDictionary.Type.NETHER);
        defaultTypesList.add(BiomeDictionary.Type.END);
    }

    public static List<BiomeDictionary.Type> stopSpamLoggerSpam = new ArrayList<>();

    public String warnIfTagIsNotDefault(String string) {
        BiomeDictionary.Type type = BiomeDictionary.Type.getType(string);
        if (!defaultTypesList.contains(type) && !stopSpamLoggerSpam.contains(type)) {
            BYG.LOGGER.warn(type.toString() + " is not a default dictionary value.\nIgnore this msg if using modded biome dictionary values.");
            stopSpamLoggerSpam.add(type);
        }
        return string;
    }
}
