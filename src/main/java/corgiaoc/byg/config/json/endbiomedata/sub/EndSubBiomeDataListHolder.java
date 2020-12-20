package corgiaoc.byg.config.json.endbiomedata.sub;

import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.common.world.biome.BYGEndSubBiome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class EndSubBiomeDataListHolder {

    List<EndSubBiomeData> endSubBiomeData;

    public EndSubBiomeDataListHolder(List<EndSubBiomeData> endSubBiomeData) {
        this.endSubBiomeData = endSubBiomeData;
    }

    public List<EndSubBiomeData> getBiomeData() {
        return endSubBiomeData;
    }

    public static void createDefaults() {
        for (BYGEndSubBiome bygBiome : BYGEndSubBiome.BYG_END_SUB_BIOMES) {
            List<BiomeDictionary.Type> typeList = Arrays.asList(bygBiome.getBiomeDictionary());
            typeList.sort(Comparator.comparing(Object::toString));
            BYGEndSubBiome.endSubBiomeData.add(new EndSubBiomeData(WorldGenRegistries.BIOME.getKey(bygBiome.getBiome()), typeList.toArray(new BiomeDictionary.Type[0]), null));
        }
    }

    public static void fillBiomeLists() {
        for (EndSubBiomeData endSubBiomeData : BYGEndSubBiome.endSubBiomeData) {
            if (endSubBiomeData.getEdgeBiome() != null)
                BYGEndBiome.BIOME_TO_EDGE.put(endSubBiomeData.getBiome(), endSubBiomeData.getEdgeBiome());
        }

        BYGEndBiome.BIOME_TO_EDGE.entrySet().removeIf(Objects::isNull);
        BYGEndBiome.BIOME_TO_HILLS.entrySet().removeIf(Objects::isNull);
    }
}
