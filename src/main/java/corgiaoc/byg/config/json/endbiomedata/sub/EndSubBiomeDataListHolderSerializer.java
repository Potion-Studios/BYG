package corgiaoc.byg.config.json.endbiomedata.sub;

import com.google.gson.*;
import corgiaoc.byg.BYG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class EndSubBiomeDataListHolderSerializer implements JsonSerializer<EndSubBiomeDataListHolder>, JsonDeserializer<EndSubBiomeDataListHolder> {

    private final Registry<Biome> biomeRegistry;

    public EndSubBiomeDataListHolderSerializer(Registry<Biome> biomeRegistry) {
        this.biomeRegistry = biomeRegistry;
    }

    @Override
    public JsonElement serialize(EndSubBiomeDataListHolder Src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject biomes = new JsonObject();
        JsonObject endBiomeObject = new JsonObject();
        JsonObject voidBiomeObject = new JsonObject();

        for (EndSubBiomeData endSubBiomeData : Src.getEndSubBiomeData()) {
            JsonObject object = new JsonObject();

            StringBuilder dictionaryString = new StringBuilder();

            for (String type : endSubBiomeData.getDictionaryTypes()) {
                if (!dictionaryString.toString().isEmpty())
                    dictionaryString.append(",");
                dictionaryString.append(type.toString());
            }


            object.addProperty("dictionary", dictionaryString.toString().toUpperCase());
            ResourceLocation edgeKey = endSubBiomeData.getEdgeBiome();
            if (edgeKey != null)
                object.addProperty("edge", edgeKey.toString());
            else
                object.addProperty("edge", "");

            //This should never be null.
            ResourceLocation location = endSubBiomeData.getBiome();
            if (location != null) {
                if (dictionaryString.toString().contains("VOID"))
                    voidBiomeObject.add(location.toString(), object);
                else
                    endBiomeObject.add(location.toString(), object);
            } else
                BYG.LOGGER.error("The Biome key was null! This should NEVER happen.");

        }
        biomes.add("biomes", endBiomeObject);
        biomes.add("void-biomes", voidBiomeObject);

        return biomes;
    }

    @Override
    public EndSubBiomeDataListHolder deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        BYG.LOGGER.info("Reading json");

        JsonObject jsonObject = json.getAsJsonObject();
        List<EndSubBiomeData> endSubBiomeData = new ArrayList<>();
        List<EndSubBiomeData> voidSubBiomeData = new ArrayList<>();

        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.get("biomes").getAsJsonObject().entrySet();
        Set<Map.Entry<String, JsonElement>> voidEntrySet = jsonObject.get("void-biomes").getAsJsonObject().entrySet();

        extractElements(endSubBiomeData, entrySet);
        extractElements(endSubBiomeData, voidEntrySet);
        return new EndSubBiomeDataListHolder(endSubBiomeData, voidSubBiomeData);
    }

    private void extractElements(List<EndSubBiomeData> endSubBiomeData, Set<Map.Entry<String, JsonElement>> entrySet) {
        for (Map.Entry<String, JsonElement> elementEntry : entrySet) {
            WeightedList<ResourceLocation> weightedList = new WeightedList<>();

            String biomeName = elementEntry.getKey();
            JsonElement element = elementEntry.getValue();

            JsonObject elementObject = element.getAsJsonObject();

            String edge = elementObject.get("edge").getAsString();

            String dictionary = elementObject.get("dictionary").getAsString();

            List<String> types = Arrays.stream(dictionary.trim().replace(" ", "").toUpperCase().split(",")).map(this::warnIfTagIsNotDefault).collect(Collectors.toList());

            String[] typesArray = new String[types.size()];
            typesArray = types.toArray(typesArray);

            if (types.size() == 0) {
                types.add("END");
                BYG.LOGGER.warn("No dictionary entries were read...defaulting to: \"END\"");
            }

            ResourceLocation biomeKey = new ResourceLocation(biomeName);
            if (biomeRegistry.keySet().contains(biomeKey)) {
                    endSubBiomeData.add(new EndSubBiomeData(biomeKey, typesArray, new ResourceLocation(edge)));
            }
            else
                BYG.LOGGER.error("The biome key: \"" + biomeName + "\" was not found in the dynamic registry, skipping entry...");
        }
    }

    public static List<String> defaultTypesList = new ArrayList<>();

    static {
        defaultTypesList.add("HOT");
        defaultTypesList.add("COLD");
        defaultTypesList.add("SPARSE");
        defaultTypesList.add("DENSE");
        defaultTypesList.add("WET");
        defaultTypesList.add("DRY");
        defaultTypesList.add("SAVANNA");
        defaultTypesList.add("CONIFEROUS");
        defaultTypesList.add("JUNGLE");
        defaultTypesList.add("SPOOKY");
        defaultTypesList.add("DEAD");
        defaultTypesList.add("LUSH");
        defaultTypesList.add("MUSHROOM");
        defaultTypesList.add("MAGICAL");
        defaultTypesList.add("RARE");
        defaultTypesList.add("PLATEAU");
        defaultTypesList.add("MODIFIED");
        defaultTypesList.add("OCEAN");
        defaultTypesList.add("RIVER");
        defaultTypesList.add("WATER");
        defaultTypesList.add("MESA");
        defaultTypesList.add("FOREST");
        defaultTypesList.add("PLAINS");
        defaultTypesList.add("MOUNTAIN");
        defaultTypesList.add("HILLS");
        defaultTypesList.add("SWAMP");
        defaultTypesList.add("SANDY");
        defaultTypesList.add("SNOWY");
        defaultTypesList.add("WASTELAND");
        defaultTypesList.add("VOID");
        defaultTypesList.add("OVERWORLD");
        defaultTypesList.add("BEACH");
        defaultTypesList.add("NETHER");
        defaultTypesList.add("END");
    }

    public static List<String> stopSpamLoggerSpam = new ArrayList<>();

    public String warnIfTagIsNotDefault(String type) {
        if (!defaultTypesList.contains(type) && !stopSpamLoggerSpam.contains(type)) {
            BYG.LOGGER.warn(type.toString() + " is not a default dictionary value.\nIgnore this msg if using modded biome dictionary values.");
            stopSpamLoggerSpam.add(type);
        }
        return type;
    }
}
