package corgiaoc.byg.config.json.endbiomedata;

import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeSource;
import corgiaoc.byg.mixin.access.WeightedListAccess;
import corgiaoc.byg.mixin.access.WeightedListEntryAccess;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class EndBiomeDataListHolder {

    List<EndBiomeData> endBiomeData;
    private final List<EndBiomeData> voidBiomeData;

    public EndBiomeDataListHolder(List<EndBiomeData> endBiomeData, List<EndBiomeData> voidBiomeData) {
        this.endBiomeData = endBiomeData;
        this.voidBiomeData = voidBiomeData;
    }

    public List<EndBiomeData> getEndBiomeData() {
        return endBiomeData;
    }

    public List<EndBiomeData> getVoidBiomeData() {
        return voidBiomeData;
    }

    public static void createDefaults(Registry<Biome> biomeRegistry) {
        for (BYGEndBiome bygBiome : BYGEndBiome.BYG_END_BIOMES) {
            List<String> typeList = Arrays.asList(bygBiome.getBiomeDictionary());
            typeList.sort(Comparator.comparing(Object::toString));
            BYGEndBiome.endBiomeData.add(new EndBiomeData(WorldGenRegistries.BIOME.getKey(bygBiome.getBiome()), bygBiome.getWeight(), typeList.toArray(new String[0]), bygBiome.getHills(), WorldGenRegistries.BIOME.getKey(bygBiome.getEdge())));
        }

        for (ResourceLocation location : biomeRegistry.keySet().stream().filter(location -> !location.toString().contains("byg") && !location.toString().equals("minecraft:the_end") && !location.toString().equals("minecraft:small_end_islands") && !location.toString().equals("minecraft:end_barrens")).collect(Collectors.toSet())) {
            if (biomeRegistry.getOptional(location).get().getBiomeCategory() == Biome.Category.THEEND)
                BYGEndBiome.endBiomeData.add(new EndBiomeData(location, 5, new String[]{"END"}, new WeightedList<>(), null));

            BYGEndBiome.endBiomeData.removeIf(endBiomeData1 -> endBiomeData1.getBiome() == null);
            //Sort entries alphabetically
            BYGEndBiome.endBiomeData.sort(Comparator.comparing(data -> data.getBiome().toString()));
        }
    }

    public static void fillBiomeLists() {
        WeightedList<ResourceLocation> end_biomes = new WeightedList<>();
        WeightedList<ResourceLocation> void_biomes = new WeightedList<>();

        Map<ResourceLocation, WeightedList<ResourceLocation>> biome_to_hills = new HashMap<>();
        Map<ResourceLocation, ResourceLocation> biome_to_edge = new HashMap<>();

        for (EndBiomeData endBiomeData : BYGEndBiome.endBiomeData) {
            WeightedList<ResourceLocation> biomeWeightedList = endBiomeData.getBiomeWeightedList();
            if (biomeWeightedList != null) {
                ((WeightedListAccess<ResourceLocation>) biomeWeightedList).getEntries().removeIf(biomeEntry -> ((WeightedListEntryAccess) biomeEntry).getWeight() <= 0);
                biome_to_hills.put(endBiomeData.getBiome(), biomeWeightedList);
            }
            if (endBiomeData.getEdgeBiome() != null)
                biome_to_edge.put(endBiomeData.getBiome(), endBiomeData.getEdgeBiome());

            end_biomes.add(endBiomeData.getBiome(), endBiomeData.getBiomeWeight());
        }

        for (EndBiomeData endBiomeData : BYGEndBiome.voidBiomeData) {
            WeightedList<ResourceLocation> biomeWeightedList = endBiomeData.getBiomeWeightedList();
            if (biomeWeightedList != null) {
                ((WeightedListAccess<ResourceLocation>) biomeWeightedList).getEntries().removeIf(biomeEntry -> ((WeightedListEntryAccess) biomeEntry).getWeight() <= 0);
                biome_to_hills.put(endBiomeData.getBiome(), biomeWeightedList);
            }
            if (endBiomeData.getEdgeBiome() != null)
                biome_to_edge.put(endBiomeData.getBiome(), endBiomeData.getEdgeBiome());

            void_biomes.add(endBiomeData.getBiome(), endBiomeData.getBiomeWeight());
        }

        biome_to_hills.entrySet().removeIf(Objects::isNull);
        biome_to_edge.entrySet().removeIf(Objects::isNull);
        ((WeightedListAccess<ResourceLocation>) end_biomes).getEntries().removeIf(Objects::isNull);
        ((WeightedListAccess<ResourceLocation>) void_biomes).getEntries().removeIf(Objects::isNull);

        ((WeightedListAccess<ResourceLocation>) end_biomes).getEntries().sort(Comparator.comparing(WeightedList.Entry::getData));
        ((WeightedListAccess<ResourceLocation>) void_biomes).getEntries().sort(Comparator.comparing(WeightedList.Entry::getData));

        BYGEndBiomeSource.END_BIOMES = end_biomes;
        BYGEndBiomeSource.VOID_BIOMES = void_biomes;
        BYGEndBiome.BIOME_TO_HILLS = biome_to_hills;
        BYGEndBiome.BIOME_TO_EDGE = biome_to_edge;
    }
}
