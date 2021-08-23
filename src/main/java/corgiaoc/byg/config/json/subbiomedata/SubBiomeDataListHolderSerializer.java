package corgiaoc.byg.config.json.subbiomedata;

import com.google.gson.*;
import corgiaoc.byg.BYG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class SubBiomeDataListHolderSerializer implements JsonSerializer<SubBiomeDataListHolder>, JsonDeserializer<SubBiomeDataListHolder> {

    @Override
    public JsonElement serialize(SubBiomeDataListHolder Src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject biomes = new JsonObject();
        JsonObject biomeObject = new JsonObject();

        for (SubBiomeData biomeData : Src.getSubBiomeData()) {
            JsonObject object = new JsonObject();

            StringBuilder dictionaryString = new StringBuilder();

            for (String type : biomeData.getDictionaryTypes()) {
                if (!dictionaryString.toString().isEmpty())
                    dictionaryString.append(",");
                dictionaryString.append(type.toString());
            }

            object.addProperty("dictionary", dictionaryString.toString().toUpperCase());

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

            //This should never be null.
            ResourceLocation location = WorldGenRegistries.BIOME.getKey(biomeData.getBiome());
            if (location != null )
                biomeObject.add(location.toString(), object);
            else
                BYG.LOGGER.error("The Biome key was null! This should NEVER happen.");

        }
        biomes.add("sub-biomes", biomeObject);

        return biomes;
    }

    @Override
    public SubBiomeDataListHolder deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        BYG.LOGGER.info("Reading Sub-Biomes json");

        JsonObject jsonObject = json.getAsJsonObject();
        List<SubBiomeData> biomeData = new ArrayList<>();

        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.get("sub-biomes").getAsJsonObject().entrySet();

        for (Map.Entry<String, JsonElement> elementEntry : entrySet) {

            String biomeName = elementEntry.getKey();
            JsonElement element = elementEntry.getValue();

            JsonObject elementObject = element.getAsJsonObject();

            String edge = elementObject.get("edge").getAsString();
            String river = elementObject.get("river").getAsString();
            String beach = elementObject.get("beach").getAsString();

            String dictionary = elementObject.get("dictionary").getAsString();

            List<String> types = Arrays.stream(dictionary.trim().replace(" ", "").toUpperCase().split(",")).map(this::warnIfTagIsNotDefault).collect(Collectors.toList());

            String[] typesArray = new String[types.size()];
            typesArray = types.toArray(typesArray);

            if (types.size() == 0) {
                types.add("OVERWORLD");
                BYG.LOGGER.warn("No dictionary entries were read...defaulting to: \"OVERWORLD\"");
            }

            ResourceLocation biomeKey = new ResourceLocation(biomeName);
            if (WorldGenRegistries.BIOME.keySet().contains(biomeKey)) {
                if (biomeKey.getNamespace().equals(BYG.MOD_ID))
                    biomeData.add(new SubBiomeData(WorldGenRegistries.BIOME.get(biomeKey), typesArray, WorldGenRegistries.BIOME.get(new ResourceLocation(edge)), WorldGenRegistries.BIOME.get(new ResourceLocation(beach)), WorldGenRegistries.BIOME.get(new ResourceLocation(river))));
                else
                    BYG.LOGGER.error("Biome key: \"" + biomeName + "\" is illegal. The mod id for the biome key MUST be \"byg\". Skipping entry...");
            }
            else
                BYG.LOGGER.error("The biome key: \"" + biomeName + "\" was not found in the registry, skipping entry...");
        }
        return new SubBiomeDataListHolder(biomeData);
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
        defaultTypesList.add("BEACH");
        defaultTypesList.add("SANDY");
        defaultTypesList.add("SNOWY");
        defaultTypesList.add("WASTELAND");
        defaultTypesList.add("VOID");
        defaultTypesList.add("OVERWORLD");
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
