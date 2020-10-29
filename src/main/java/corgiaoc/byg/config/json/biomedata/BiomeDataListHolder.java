package corgiaoc.byg.config.json.biomedata;

import corgiaoc.byg.common.world.biome.BYGBiome;
import net.minecraft.util.registry.BuiltinRegistries;

import java.util.Comparator;
import java.util.List;

@SuppressWarnings("deprecation")
public class BiomeDataListHolder {

    List<BiomeData> biomeData;


    public BiomeDataListHolder(List<BiomeData> biomeData) {
        this.biomeData = biomeData;
    }

    public List<BiomeData> getBiomeData() {
        return biomeData;
    }

    public static void createDefaults() {
        for (BYGBiome bygBiome : BYGBiome.BYG_BIOMES) {
            BYGBiome.biomeData.add(new BiomeData(bygBiome.getBiome(), bygBiome.getWeight(), bygBiome.getBiomeType(), bygBiome.getHills(), bygBiome.getEdge(), bygBiome.getBeach(), bygBiome.getRiver()));
        }

        //Sort entries alphabetically
        BYGBiome.biomeData.sort(Comparator.comparing(data -> BuiltinRegistries.BIOME.getId(data.getBiome()).toString()));
    }

    public static void fillBiomeLists() {
        for (BiomeData biomeData : BYGBiome.biomeData) {
            if (biomeData.getBiomeWeightedList() != null) {
                BYGBiome.BIOME_TO_HILLS_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getBiomeWeightedList());
            }
            if (biomeData.getBeachBiome() != null)
                BYGBiome.BIOME_TO_BEACH_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getBeachBiome());
            if (biomeData.getEdgeBiome() != null)
                BYGBiome.BIOME_TO_EDGE_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getEdgeBiome());
            if (biomeData.getRiverBiome() != null)
                BYGBiome.BIOME_TO_RIVER_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getRiverBiome());
        }

        BYGBiome.BIOME_TO_EDGE_LIST.remove(-1);
        BYGBiome.BIOME_TO_BEACH_LIST.remove(-1);
        BYGBiome.BIOME_TO_RIVER_LIST.remove(-1);
    }
}
