package corgiaoc.byg.config.json.endbiomedata;

import corgiaoc.byg.common.world.biome.BYGEndBiome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
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
public class EndBiomeDataListHolder {

    List<EndBiomeData> endBiomeData;

    public EndBiomeDataListHolder(List<EndBiomeData> endBiomeData) {
        this.endBiomeData = endBiomeData;
    }

    public List<EndBiomeData> getBiomeData() {
        return endBiomeData;
    }

    public static void createDefaults(Registry<Biome> biomeRegistry) {
        for (BYGEndBiome bygBiome : BYGEndBiome.BYG_END_BIOMES) {
            List<BiomeDictionary.Type> typeList = Arrays.asList(bygBiome.getBiomeDictionary());
            typeList.sort(Comparator.comparing(Object::toString));
            BYGEndBiome.endBiomeData.add(new EndBiomeData(WorldGenRegistries.BIOME.getKey(bygBiome.getBiome()), bygBiome.getWeight(), typeList.toArray(new BiomeDictionary.Type[0]), bygBiome.getHills(), WorldGenRegistries.BIOME.getKey(bygBiome.getEdge())));
        }

        for (ResourceLocation location : biomeRegistry.keySet().stream().filter(location -> !location.toString().contains("byg")).collect(Collectors.toSet())) {
            if (biomeRegistry.getOptional(location).get().getCategory() == Biome.Category.THEEND)
                BYGEndBiome.endBiomeData.add(new EndBiomeData(location, 5, new BiomeDictionary.Type[]{BiomeDictionary.Type.END}, new WeightedList<>(), null));

            BYGEndBiome.endBiomeData.removeIf(endBiomeData1 -> endBiomeData1.getBiome() == null);
            //Sort entries alphabetically
            BYGEndBiome.endBiomeData.sort(Comparator.comparing(data -> data.getBiome().toString()));
        }
    }

    public static void fillBiomeLists() {
        for (EndBiomeData endBiomeData : BYGEndBiome.endBiomeData) {
            if (endBiomeData.getBiomeWeightedList() != null) {
                BYGEndBiome.BIOME_TO_HILLS.put(endBiomeData.getBiome(), endBiomeData.getBiomeWeightedList());
            }
            if (endBiomeData.getEdgeBiome() != null)
                BYGEndBiome.BIOME_TO_EDGE.put(endBiomeData.getBiome(), endBiomeData.getEdgeBiome());
        }

        BYGEndBiome.BIOME_TO_EDGE.entrySet().removeIf(Objects::isNull);
        BYGEndBiome.BIOME_TO_HILLS.entrySet().removeIf(Objects::isNull);
    }
}
