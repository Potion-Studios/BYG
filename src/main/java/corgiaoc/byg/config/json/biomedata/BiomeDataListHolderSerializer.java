package corgiaoc.byg.config.json.biomedata;

import com.google.gson.*;
import corgiaoc.byg.BYG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class BiomeDataListHolderSerializer implements JsonSerializer<BiomeDataListHolder>, JsonDeserializer<BiomeDataListHolder> {

    @Override
    public JsonElement serialize(BiomeDataListHolder Src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject biomes = new JsonObject();
        JsonObject biomeObject = new JsonObject();

        for (BiomeData biomeData : Src.getBiomeData()) {

            JsonArray weightedListArray = new JsonArray();
            JsonObject object = new JsonObject();

            if (biomeData.getBiomeWeightedList() != null) {
                for (WeightedList.Entry<Biome> biomeEntry : biomeData.getBiomeWeightedList().field_220658_a) {
                    JsonObject object2 = new JsonObject();
                    ResourceLocation biomeEntryKey = WorldGenRegistries.BIOME.getKey(biomeEntry.func_220647_b());

                    if (biomeEntryKey != null) {
                        object2.addProperty("name", biomeEntryKey.toString());
                        object2.addProperty("weight", biomeEntry.field_220652_c);
                        weightedListArray.add(object2);
                    } else {
                        BYG.LOGGER.error("One or more \"hills\" \"name\" value was null/incorrect.");
                    }
                }
            }
            StringBuilder dictionaryString = new StringBuilder();

            for (BiomeDictionary.Type type : biomeData.getDictionaryTypes()) {
                if (!dictionaryString.toString().isEmpty())
                    dictionaryString.append(",");
                dictionaryString.append(type.toString());
            }


            object.addProperty("climate", biomeData.getBiomeType().toString().toUpperCase());
            object.addProperty("dictionary", dictionaryString.toString().toUpperCase());
            object.addProperty("weight", biomeData.getBiomeWeight());
            ResourceLocation riverKey = WorldGenRegistries.BIOME.getKey(biomeData.getRiverBiome());
            if (riverKey != null)
                object.addProperty("river", riverKey.toString());
            else
                object.addProperty("river", "");

            ResourceLocation beachKey = WorldGenRegistries.BIOME.getKey(biomeData.getBeachBiome());
            if (beachKey != null)
                object.addProperty("beach", beachKey.toString());
            else
                object.addProperty("beach", "");

            ResourceLocation edgeKey = WorldGenRegistries.BIOME.getKey(biomeData.getEdgeBiome());
            if (edgeKey != null)
                object.addProperty("edge", edgeKey.toString());
            else
                object.addProperty("edge", "");

            object.add("hills", weightedListArray);

            //This should never be null.
            ResourceLocation location = WorldGenRegistries.BIOME.getKey(biomeData.getBiome());
            if (location != null )
                biomeObject.add(location.toString(), object);
            else
                BYG.LOGGER.error("The Biome key was null! This should NEVER happen.");

        }
        biomes.add("biomes", biomeObject);

        return biomes;
    }

    @Override
    public BiomeDataListHolder deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        BYG.LOGGER.info("Reading json");

        JsonObject jsonObject = json.getAsJsonObject();
        List<BiomeData> biomeData = new ArrayList<>();

        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.get("biomes").getAsJsonObject().entrySet();

        for (Map.Entry<String, JsonElement> elementEntry : entrySet) {
            WeightedList<Biome> weightedList = new WeightedList<>();

            String biomeName = elementEntry.getKey();
            JsonElement element = elementEntry.getValue();

            JsonObject elementObject = element.getAsJsonObject();

            String climate = elementObject.get("climate").getAsString().toUpperCase();
            String edge = elementObject.get("edge").getAsString();
            String river = elementObject.get("river").getAsString();
            String beach = elementObject.get("beach").getAsString();

            int weight = elementObject.get("weight").getAsInt();

            List<String> defaultClimates = new ArrayList<>();
            defaultClimates.add("ICY");
            defaultClimates.add("COOL");
            defaultClimates.add("WARM");
            defaultClimates.add("DESERT");
            defaultClimates.add("DESERT_LEGACY");

            BiomeManager.BiomeType biomeType;

            if (!defaultClimates.contains(climate)) {
                BYG.LOGGER.error(elementEntry.getKey() + "'s \"climate\" value is incorrect you put: \"" + climate + "\". Defaulting climate to warm...");
                biomeType = BiomeManager.BiomeType.WARM;
            }
            else
                biomeType = BiomeManager.BiomeType.valueOf(climate);

            JsonArray hillLayerList = elementObject.get("hills").getAsJsonArray();

            String dictionary = elementObject.get("dictionary").getAsString();

            List<BiomeDictionary.Type> types = Arrays.stream(dictionary.trim().replace(" ", "").toUpperCase().split(",")).map(this::warnIfTagIsNotDefault).map(BiomeDictionary.Type::getType).collect(Collectors.toList());

            BiomeDictionary.Type[] typesArray = new BiomeDictionary.Type[types.size()];
            typesArray = types.toArray(typesArray);

            if (types.size() == 0) {
                types.add(BiomeDictionary.Type.OVERWORLD);
                BYG.LOGGER.warn("No dictionary entries were read...defaulting to: \"OVERWORLD\"");
            }

            for (JsonElement hillElement : hillLayerList) {
                JsonObject hillObject = hillElement.getAsJsonObject();

                String hillBiomeName = hillObject.get("name").getAsString();
                Integer hillWeight = hillObject.get("weight").getAsInt();

                if (hillBiomeName != null && hillWeight != null) {
                    ResourceLocation hillResourceLocation = new ResourceLocation(hillBiomeName);

                    if (hillResourceLocation != null) {
                        if (WorldGenRegistries.BIOME.keySet().contains(hillResourceLocation))
                            weightedList.func_226313_a_(Objects.requireNonNull(WorldGenRegistries.BIOME.getOrDefault(hillResourceLocation)), hillWeight);
                        else
                            BYG.LOGGER.error("Could not find: \"" + hillResourceLocation.toString() + "\" in the biome registry!\nEntry will not be added.");
                    }
                }
            }
            ResourceLocation biomeKey = new ResourceLocation(biomeName);
            if (WorldGenRegistries.BIOME.keySet().contains(biomeKey)) {
                if (biomeKey.getNamespace().equals(BYG.MOD_ID))
                    biomeData.add(new BiomeData(WorldGenRegistries.BIOME.getOrDefault(biomeKey), weight, biomeType, typesArray, weightedList, WorldGenRegistries.BIOME.getOrDefault(new ResourceLocation(edge)), WorldGenRegistries.BIOME.getOrDefault(new ResourceLocation(beach)), WorldGenRegistries.BIOME.getOrDefault(new ResourceLocation(river))));
                else
                    BYG.LOGGER.error("Biome key: \"" + biomeName + "\" is illegal. The mod id for the biome key MUST be \"byg\". Skipping entry...");
            }
            else
                BYG.LOGGER.error("THe biome key: \"" + biomeName + "\" was not found in the registry, skipping entry...");
        }
        return new BiomeDataListHolder(biomeData);
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
