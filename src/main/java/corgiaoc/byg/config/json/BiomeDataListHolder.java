package corgiaoc.byg.config.json;

import corgiaoc.byg.common.world.biome.BYGBiome;
import net.minecraft.util.registry.WorldGenRegistries;

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
            BYGBiome.biomeData.add(new BiomeData(bygBiome.getBiome(), bygBiome.getWeight(), bygBiome.getBiomeType(), bygBiome.getBiomeDictionary(), bygBiome.getHills(), bygBiome.getEdge(), bygBiome.getBeach(), bygBiome.getRiver()));
        }
    }

    public static void fillBiomeLists() {
        for (BiomeData biomeData : BYGBiome.biomeData) {
            if (biomeData.getBiomeWeightedList() != null) {
                BYGBiome.BIOME_TO_HILLS_LIST.put(WorldGenRegistries.BIOME.getId(biomeData.getBiome()), biomeData.getBiomeWeightedList());
            }
            if (biomeData.getBeachBiome() != null)
                BYGBiome.BIOME_TO_BEACH_LIST.put(WorldGenRegistries.BIOME.getId(biomeData.getBiome()), biomeData.getBeachBiome());
            if (biomeData.getEdgeBiome() != null)
                BYGBiome.BIOME_TO_EDGE_LIST.put(WorldGenRegistries.BIOME.getId(biomeData.getBiome()), biomeData.getEdgeBiome());
            if (biomeData.getRiverBiome() != null)
                BYGBiome.BIOME_TO_RIVER_LIST.put(WorldGenRegistries.BIOME.getId(biomeData.getBiome()), biomeData.getRiverBiome());
        }

        BYGBiome.BIOME_TO_EDGE_LIST.remove(-1);
        BYGBiome.BIOME_TO_BEACH_LIST.remove(-1);
        BYGBiome.BIOME_TO_RIVER_LIST.remove(-1);
    }
}
