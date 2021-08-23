package corgiaoc.byg.config.json.subbiomedata;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGSubBiome;
import net.minecraft.util.registry.WorldGenRegistries;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("deprecation")
public class SubBiomeDataListHolder {

    List<SubBiomeData> subBiomeData;


    public SubBiomeDataListHolder(List<SubBiomeData> subBiomeData) {
        this.subBiomeData = subBiomeData;
    }

    public List<SubBiomeData> getSubBiomeData() {
        return subBiomeData;
    }

    public static void createDefaults() {
        for (BYGSubBiome bygSubBiome : BYGSubBiome.BYG_SUB_BIOMES) {
            List<String> typeList = Arrays.asList(bygSubBiome.getBiomeDictionary());
            typeList.sort(Comparator.comparing(Object::toString));
            BYGSubBiome.subBiomeData.add(new SubBiomeData(bygSubBiome.getBiome(), typeList.toArray(new String[0]), bygSubBiome.getEdge(), bygSubBiome.getBeach(), bygSubBiome.getRiver()));
        }


        //Sort entries alphabetically
        BYGSubBiome.subBiomeData.sort(Comparator.comparing(data -> WorldGenRegistries.BIOME.getKey(data.getBiome()).toString()));
    }

    public static void fillBiomeLists() {
        for (SubBiomeData biomeData : BYGSubBiome.subBiomeData) {
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
