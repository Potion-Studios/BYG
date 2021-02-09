package corgiaoc.byg.config.json.endbiomedata.sub;

import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.common.world.biome.BYGEndSubBiome;
import net.minecraft.util.registry.BuiltinRegistries;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class EndSubBiomeDataListHolder {

    private final List<EndSubBiomeData> voidSubBiomeData;
    List<EndSubBiomeData> endSubBiomeData;

    public EndSubBiomeDataListHolder(List<EndSubBiomeData> endSubBiomeData, List<EndSubBiomeData> voidSubBiomeData) {
        this.endSubBiomeData = endSubBiomeData;
        this.voidSubBiomeData = voidSubBiomeData;
    }

    public static void createDefaults() {
        for (BYGEndSubBiome bygBiome : BYGEndSubBiome.BYG_END_SUB_BIOMES) {
            BYGEndSubBiome.endSubBiomeData.add(new EndSubBiomeData(BuiltinRegistries.BIOME.getId(bygBiome.getBiome()), null, bygBiome.isVoid()));
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

    public List<EndSubBiomeData> getEndSubBiomeData() {
        return endSubBiomeData;
    }

    public List<EndSubBiomeData> getVoidSubBiomeData() {
        return voidSubBiomeData;
    }
}
