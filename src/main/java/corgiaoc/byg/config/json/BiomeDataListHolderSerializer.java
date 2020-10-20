package corgiaoc.byg.config.json;

import com.google.gson.*;
import corgiaoc.byg.BYG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.*;

@SuppressWarnings("deprecation")
public class BiomeDataListHolderSerializer implements JsonSerializer<BiomeDataListHolder>, JsonDeserializer<BiomeDataListHolder> {

    @Override
    public JsonElement serialize(BiomeDataListHolder Src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject biomes = new JsonObject();
        JsonObject biomeObject = new JsonObject();

        for (BiomeData dataHolder : Src.getBiomeData()) {

            JsonArray weightedListArray = new JsonArray();
            JsonObject object = new JsonObject();
            if (dataHolder.getBiomeWeightedList() != null) {
                for (WeightedList.Entry<Biome> biomeEntry : dataHolder.getBiomeWeightedList().field_220658_a) {
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

            object.addProperty("weight", dataHolder.getBiomeWeight());
            ResourceLocation riverKey = WorldGenRegistries.BIOME.getKey(dataHolder.getRiverBiome());
            if (riverKey != null)
                object.addProperty("river", riverKey.toString());
            else
                object.addProperty("river", "");

            ResourceLocation beachKey = WorldGenRegistries.BIOME.getKey(dataHolder.getBeachBiome());
            if (beachKey != null)
                object.addProperty("beach", beachKey.toString());
            else
                object.addProperty("beach", "");

            ResourceLocation edgeKey = WorldGenRegistries.BIOME.getKey(dataHolder.getEdgeBiome());
            if (edgeKey != null)
                object.addProperty("edge", edgeKey.toString());
            else
                object.addProperty("edge", "");

            object.addProperty("hill_replacement_chance", dataHolder.getReplacementChance());
            object.add("hills", weightedListArray);

            //This should never be null.
            ResourceLocation location = WorldGenRegistries.BIOME.getKey(dataHolder.getBiome());
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
        JsonObject jsonObject = json.getAsJsonObject();

        List<BiomeData> biomeData = new ArrayList<>();

        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.get("biomes").getAsJsonObject().entrySet();

        for (Map.Entry<String, JsonElement> elementEntry : entrySet) {
            WeightedList<Biome> weightedList = new WeightedList<>();

            String biomeName = elementEntry.getKey();
            JsonElement element = elementEntry.getValue();

            JsonObject elementObject = element.getAsJsonObject();

            int replacementChance = elementObject.get("hill_replacement_chance").getAsInt();
            String edge = elementObject.get("edge").getAsString();
            String river = elementObject.get("river").getAsString();
            String beach = elementObject.get("beach").getAsString();


            JsonArray hillLayerList = elementObject.get("hills").getAsJsonArray();

            for (JsonElement hillElement : hillLayerList) {
                JsonObject hillObject = hillElement.getAsJsonObject();

                String hillBiomeName = hillObject.get("name").getAsString();
                Integer hillWeight = hillObject.get("weight").getAsInt();

                if (hillBiomeName != null && hillWeight != null) {
                    ResourceLocation hillResourceLocation = new ResourceLocation(hillBiomeName);

                    if (hillResourceLocation != null) {
                        if (WorldGenRegistries.BIOME.containsKey(hillResourceLocation))
                            weightedList.func_226313_a_(Objects.requireNonNull(WorldGenRegistries.BIOME.getOrDefault(hillResourceLocation)), hillWeight);
                        else
                            BYG.LOGGER.error("Could not find: \"" + hillResourceLocation.toString() + "\" in the biome registry!\nEntry will not be added.");
                    }
                }
            }
            biomeData.add(new BiomeData(WorldGenRegistries.BIOME.getOrDefault(new ResourceLocation(biomeName)), replacementChance, 5, weightedList, WorldGenRegistries.BIOME.getOrDefault(new ResourceLocation(edge)), WorldGenRegistries.BIOME.getOrDefault(new ResourceLocation(beach)), WorldGenRegistries.BIOME.getOrDefault(new ResourceLocation(river))));
        }
        return new BiomeDataListHolder(biomeData);
    }

    public static String getOrDefault(@Nullable String jsonString) {
        if (jsonString == null)
            return "";
        else
            return jsonString;
    }
}
