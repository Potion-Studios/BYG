package corgiaoc.byg.config.json.biomedata;

import com.google.gson.*;
import corgiaoc.byg.BYG;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;

import java.lang.reflect.Type;
import java.util.*;

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
                for (WeightedList.Entry<Biome> biomeEntry : biomeData.getBiomeWeightedList().entries) {
                    JsonObject object2 = new JsonObject();
                    Identifier biomeEntryKey = BuiltinRegistries.BIOME.getId(biomeEntry.getElement());

                    if (biomeEntryKey != null) {
                        object2.addProperty("name", biomeEntryKey.toString());
                        object2.addProperty("weight", biomeEntry.weight);
                        weightedListArray.add(object2);
                    } else {
                        BYG.LOGGER.error("One or more \"hills\" \"name\" value was null/incorrect.");
                    }
                }
            }

            object.addProperty("climate", biomeData.getBiomeType().toString().toUpperCase());
            object.addProperty("weight", biomeData.getBiomeWeight());
            Identifier riverKey = BuiltinRegistries.BIOME.getId(biomeData.getRiverBiome());
            if (riverKey != null)
                object.addProperty("river", riverKey.toString());
            else
                object.addProperty("river", "");

            Identifier beachKey = BuiltinRegistries.BIOME.getId(biomeData.getBeachBiome());
            if (beachKey != null)
                object.addProperty("beach", beachKey.toString());
            else
                object.addProperty("beach", "");

            Identifier edgeKey = BuiltinRegistries.BIOME.getId(biomeData.getEdgeBiome());
            if (edgeKey != null)
                object.addProperty("edge", edgeKey.toString());
            else
                object.addProperty("edge", "");

            object.add("hills", weightedListArray);

            //This should never be null.
            Identifier location = BuiltinRegistries.BIOME.getId(biomeData.getBiome());
            if (location != null)
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
            defaultClimates.add("SNOWY");
            defaultClimates.add("COOL");
            defaultClimates.add("TEMPERATE");
            defaultClimates.add("DRY");

            OverworldClimate biomeType;

            if (!defaultClimates.contains(climate)) {
                BYG.LOGGER.error(elementEntry.getKey() + "'s \"climate\" value is incorrect you put: \"" + climate + "\". Defaulting climate to temperate...");
                biomeType = OverworldClimate.TEMPERATE;
            } else
                biomeType = OverworldClimate.valueOf(climate);

            JsonArray hillLayerList = elementObject.get("hills").getAsJsonArray();

            for (JsonElement hillElement : hillLayerList) {
                JsonObject hillObject = hillElement.getAsJsonObject();

                String hillBiomeName = hillObject.get("name").getAsString();
                Integer hillWeight = hillObject.get("weight").getAsInt();

                if (hillBiomeName != null && hillWeight != null) {
                    Identifier hillIdentifier = new Identifier(hillBiomeName);

                    if (hillIdentifier != null) {
                        if (BuiltinRegistries.BIOME.getIds().contains(hillIdentifier))
                            weightedList.add(Objects.requireNonNull(BuiltinRegistries.BIOME.get(hillIdentifier)), hillWeight);
                        else
                            BYG.LOGGER.error("Could not find: \"" + hillIdentifier.toString() + "\" in the biome registry!\nEntry will not be added. Skipping entry...");
                    }
                }
            }
            Identifier biomeKey = new Identifier(biomeName);
            if (BuiltinRegistries.BIOME.getIds().contains(biomeKey)) {
                if (biomeKey.getNamespace().equals(BYG.MOD_ID))
                    biomeData.add(new BiomeData(BuiltinRegistries.BIOME.get(biomeKey), weight, biomeType, weightedList, BuiltinRegistries.BIOME.get(new Identifier(edge)), BuiltinRegistries.BIOME.get(new Identifier(beach)), BuiltinRegistries.BIOME.get(new Identifier(river))));
                else
                    BYG.LOGGER.error("Biome key: \"" + biomeName + "\" is illegal. The mod id for the biome key MUST be \"byg\". Skipping entry...");
            } else
                BYG.LOGGER.error("The biome key: \"" + biomeName + "\" was not found in the registry, skipping entry...");
        }
        return new BiomeDataListHolder(biomeData);
    }
}
