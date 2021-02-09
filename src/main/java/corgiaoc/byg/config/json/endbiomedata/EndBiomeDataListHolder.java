package corgiaoc.byg.config.json.endbiomedata;

import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class EndBiomeDataListHolder {

    private final List<EndBiomeData> voidBiomeData;
    List<EndBiomeData> endBiomeData;

    public EndBiomeDataListHolder(List<EndBiomeData> endBiomeData, List<EndBiomeData> voidBiomeData) {
        this.endBiomeData = endBiomeData;
        this.voidBiomeData = voidBiomeData;
    }

    public static void createDefaults(Registry<Biome> biomeRegistry) {
        for (BYGEndBiome bygBiome : BYGEndBiome.BYG_END_BIOMES) {
            BYGEndBiome.endBiomeData.add(new EndBiomeData(BuiltinRegistries.BIOME.getId(bygBiome.getBiome()), bygBiome.getWeight(), bygBiome.getHills(), BuiltinRegistries.BIOME.getId(bygBiome.getEdge()), bygBiome.isVoid()));
        }

        for (Identifier location : biomeRegistry.getIds().stream().filter(location -> !location.toString().contains("byg") && !location.toString().equals("minecraft:the_end") && !location.toString().equals("minecraft:small_end_islands") && !location.toString().equals("minecraft:end_barrens")).collect(Collectors.toSet())) {
            if (biomeRegistry.getOrEmpty(location).get().getCategory() == Biome.Category.THEEND)
                BYGEndBiome.endBiomeData.add(new EndBiomeData(location, 5, new WeightedList<>(), null));

            BYGEndBiome.endBiomeData.removeIf(endBiomeData1 -> endBiomeData1.getBiome() == null);
            //Sort entries alphabetically
            BYGEndBiome.endBiomeData.sort(Comparator.comparing(data -> data.getBiome().toString()));
        }
    }

    public static void fillBiomeLists() {
        WeightedList<Identifier> end_biomes = new WeightedList<>();
        WeightedList<Identifier> void_biomes = new WeightedList<>();

        Map<Identifier, WeightedList<Identifier>> biome_to_hills = new HashMap<>();
        Map<Identifier, Identifier> biome_to_edge = new HashMap<>();

        for (EndBiomeData endBiomeData : BYGEndBiome.endBiomeData) {
            if (endBiomeData.getBiomeWeightedList() != null) {
                biome_to_hills.put(endBiomeData.getBiome(), endBiomeData.getBiomeWeightedList());
            }
            if (endBiomeData.getEdgeBiome() != null)
                biome_to_edge.put(endBiomeData.getBiome(), endBiomeData.getEdgeBiome());

            end_biomes.add(endBiomeData.getBiome(), endBiomeData.getBiomeWeight());
        }

        for (EndBiomeData endBiomeData : BYGEndBiome.voidBiomeData) {
            if (endBiomeData.getBiomeWeightedList() != null) {
                biome_to_hills.put(endBiomeData.getBiome(), endBiomeData.getBiomeWeightedList());
            }
            if (endBiomeData.getEdgeBiome() != null)
                biome_to_edge.put(endBiomeData.getBiome(), endBiomeData.getEdgeBiome());

            void_biomes.add(endBiomeData.getBiome(), endBiomeData.getBiomeWeight());
        }

        biome_to_hills.entrySet().removeIf(Objects::isNull);
        biome_to_edge.entrySet().removeIf(Objects::isNull);
        end_biomes.entries.removeIf(Objects::isNull);
        void_biomes.entries.removeIf(Objects::isNull);

        BYGEndBiomeProvider.END_BIOMES = end_biomes;
        BYGEndBiomeProvider.VOID_BIOMES = void_biomes;
        BYGEndBiome.BIOME_TO_HILLS = biome_to_hills;
        BYGEndBiome.BIOME_TO_EDGE = biome_to_edge;
    }

    public List<EndBiomeData> getEndBiomeData() {
        return endBiomeData;
    }

    public List<EndBiomeData> getVoidBiomeData() {
        return voidBiomeData;
    }
}
