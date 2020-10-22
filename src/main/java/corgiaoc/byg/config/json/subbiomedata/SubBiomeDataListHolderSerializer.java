package corgiaoc.byg.config.json.subbiomedata;

import com.google.gson.*;
import corgiaoc.byg.BYG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraftforge.common.BiomeDictionary;

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

            for (BiomeDictionary.Type type : biomeData.getDictionaryTypes()) {
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

            List<BiomeDictionary.Type> types = Arrays.stream(dictionary.trim().replace(" ", "").toUpperCase().split(",")).map(this::warnIfTagIsNotDefault).map(BiomeDictionary.Type::getType).collect(Collectors.toList());

            BiomeDictionary.Type[] typesArray = new BiomeDictionary.Type[types.size()];
            typesArray = types.toArray(typesArray);

            if (types.size() == 0) {
                types.add(BiomeDictionary.Type.OVERWORLD);
                BYG.LOGGER.warn("No dictionary entries were read...defaulting to: \"OVERWORLD\"");
            }

            ResourceLocation biomeKey = new ResourceLocation(biomeName);
            if (WorldGenRegistries.BIOME.keySet().contains(biomeKey)) {
                if (biomeKey.getNamespace().equals(BYG.MOD_ID))
                    biomeData.add(new SubBiomeData(WorldGenRegistries.BIOME.getOrDefault(biomeKey), typesArray, WorldGenRegistries.BIOME.getOrDefault(new ResourceLocation(edge)), WorldGenRegistries.BIOME.getOrDefault(new ResourceLocation(beach)), WorldGenRegistries.BIOME.getOrDefault(new ResourceLocation(river))));
                else
                    BYG.LOGGER.error("Biome key: \"" + biomeName + "\" is illegal. The mod id for the biome key MUST be \"byg\". Skipping entry...");
            }
            else
                BYG.LOGGER.error("THe biome key: \"" + biomeName + "\" was not found in the registry, skipping entry...");
        }
        return new SubBiomeDataListHolder(biomeData);
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
        defaultTypesList.add(BiomeDictionary.Type.BEACH);
        defaultTypesList.add(BiomeDictionary.Type.SANDY);
        defaultTypesList.add(BiomeDictionary.Type.SNOWY);
        defaultTypesList.add(BiomeDictionary.Type.WASTELAND);
        defaultTypesList.add(BiomeDictionary.Type.VOID);
        defaultTypesList.add(BiomeDictionary.Type.OVERWORLD);
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
