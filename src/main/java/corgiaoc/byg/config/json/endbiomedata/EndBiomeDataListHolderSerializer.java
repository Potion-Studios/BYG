package corgiaoc.byg.config.json.endbiomedata;

import com.google.gson.*;
import corgiaoc.byg.BYG;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.WeightedList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
                for (WeightedList.Entry<Identifier> biomeEntry : endBiomeData.getBiomeWeightedList().entries) {
                    JsonObject object2 = new JsonObject();
                    Identifier biomeEntryKey = biomeEntry.getElement();

                    if (biomeEntryKey != null) {
                        object2.addProperty("name", biomeEntryKey.toString());
                        object2.addProperty("weight", biomeEntry.weight);
                        hillListArray.add(object2);
                    } else {
                        BYG.LOGGER.error("One or more \"hills\" \"name\" value was null/incorrect.");
                    }
                }
            }

            endBiome.addProperty("weight", endBiomeData.getBiomeWeight());
            Identifier edgeKey = endBiomeData.getEdgeBiome();
            if (edgeKey != null)
                endBiome.addProperty("edge", edgeKey.toString());
            else
                endBiome.addProperty("edge", "");

            endBiome.add("hills", hillListArray);

            //This should never be null.
            Identifier location = endBiomeData.getBiome();
            if (location != null) {
                if (endBiomeData.isVoid())
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
            WeightedList<Identifier> weightedList = new WeightedList<>();

            String biomeName = elementEntry.getKey();
            JsonElement element = elementEntry.getValue();

            JsonObject elementObject = element.getAsJsonObject();

            String edge = elementObject.get("edge").getAsString();

            int weight = elementObject.get("weight").getAsInt();

            JsonArray hillLayerList = elementObject.get("hills").getAsJsonArray();

            for (JsonElement hillElement : hillLayerList) {
                JsonObject hillObject = hillElement.getAsJsonObject();

                String hillBiomeName = hillObject.get("name").getAsString();
                Integer hillWeight = hillObject.get("weight").getAsInt();

                if (hillBiomeName != null && hillWeight != null) {
                    Identifier hillIdentifier = new Identifier(hillBiomeName);

                    if (hillIdentifier != null) {
                        if (BYG.EARLY_BIOME_REGISTRY_ACCESS.getIds().contains(hillIdentifier))
                            weightedList.add(hillIdentifier, hillWeight);
                        else
                            BYG.LOGGER.error("Could not find: \"" + hillIdentifier.toString() + "\" in the biome registry!\nEntry will not be added. Skipping entry...");
                    }
                }
            }
            Identifier biomeKey = new Identifier(biomeName);
            if (BYG.EARLY_BIOME_REGISTRY_ACCESS.getIds().contains(biomeKey)) {
                endBiomeData.add(new EndBiomeData(biomeKey, weight, weightedList, new Identifier(edge)));
            } else
                BYG.LOGGER.error("The biome key: \"" + biomeName + "\" was not found in the registry, skipping entry...");
        }
    }
}