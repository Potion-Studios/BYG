package corgiaoc.byg.config.json.endbiomedata.sub;

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
public class EndSubBiomeDataListHolderSerializer implements JsonSerializer<EndSubBiomeDataListHolder>, JsonDeserializer<EndSubBiomeDataListHolder> {

    @Override
    public JsonElement serialize(EndSubBiomeDataListHolder Src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject biomes = new JsonObject();
        JsonObject endBiomeObject = new JsonObject();
        JsonObject voidBiomeObject = new JsonObject();

        for (EndSubBiomeData endSubBiomeData : Src.getEndSubBiomeData()) {
            JsonObject object = new JsonObject();

            Identifier edgeKey = endSubBiomeData.getEdgeBiome();
            if (edgeKey != null)
                object.addProperty("edge", edgeKey.toString());
            else
                object.addProperty("edge", "");

            //This should never be null.
            Identifier location = endSubBiomeData.getBiome();
            if (location != null) {
                if (endSubBiomeData.isVoid())
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
            WeightedList<Identifier> weightedList = new WeightedList<>();

            String biomeName = elementEntry.getKey();
            JsonElement element = elementEntry.getValue();

            JsonObject elementObject = element.getAsJsonObject();

            String edge = elementObject.get("edge").getAsString();

            Identifier biomeKey = new Identifier(biomeName);
            if (BYG.EARLY_BIOME_REGISTRY_ACCESS.getIds().contains(biomeKey)) {
                endSubBiomeData.add(new EndSubBiomeData(biomeKey, new Identifier(edge)));
            } else
                BYG.LOGGER.error("The biome key: \"" + biomeName + "\" was not found in the dynamic registry, skipping entry...");
        }
    }
}