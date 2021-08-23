package corgiaoc.byg.config.json.endbiomedata.sub;

import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.common.world.biome.BYGEndSubBiome;
import net.minecraft.util.registry.WorldGenRegistries;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class EndSubBiomeDataListHolder {

    List<EndSubBiomeData> endSubBiomeData;
    private final List<EndSubBiomeData> voidSubBiomeData;

    public EndSubBiomeDataListHolder(List<EndSubBiomeData> endSubBiomeData, List<EndSubBiomeData> voidSubBiomeData) {
        this.endSubBiomeData = endSubBiomeData;
        this.voidSubBiomeData = voidSubBiomeData;
    }

    public List<EndSubBiomeData> getEndSubBiomeData() {
        return endSubBiomeData;
    }

    public List<EndSubBiomeData> getVoidSubBiomeData() {
        return voidSubBiomeData;
    }

    public static void createDefaults() {
        for (BYGEndSubBiome bygBiome : BYGEndSubBiome.BYG_END_SUB_BIOMES) {
            List<String> typeList = Arrays.asList(bygBiome.getBiomeDictionary());
            typeList.sort(Comparator.comparing(Object::toString));
            BYGEndSubBiome.endSubBiomeData.add(new EndSubBiomeData(WorldGenRegistries.BIOME.getKey(bygBiome.getBiome()), typeList.toArray(new String[0]), null));
        }
    }

    public static void fillBiomeLists() {
        for (EndSubBiomeData endSubBiomeData : BYGEndSubBiome.endSubBiomeData) {
            if (endSubBiomeData.getEdgeBiome() != null)
                BYGEndBiome.BIOME_TO_EDGE.put(endSubBiomeData.getBiome(), endSubBiomeData.getEdgeBiome());
        }

        for (EndSubBiomeData endSubBiomeData : BYGEndSubBiome.voidSubBiomeData) {
            if (endSubBiomeData.getEdgeBiome() != null)
                BYGEndBiome.BIOME_TO_EDGE.put(endSubBiomeData.getBiome(), endSubBiomeData.getEdgeBiome());
        }

        BYGEndBiome.BIOME_TO_EDGE.entrySet().removeIf(Objects::isNull);
        BYGEndBiome.BIOME_TO_HILLS.entrySet().removeIf(Objects::isNull);
    }
}
