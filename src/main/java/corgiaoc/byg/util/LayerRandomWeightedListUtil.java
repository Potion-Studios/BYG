package corgiaoc.byg.util;

import net.minecraft.util.collection.WeightedList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public class LayerRandomWeightedListUtil {

    public static Biome getBiome(WeightedList<Biome> biomeWeightedList, LayerRandomnessSource layerNoise) {
        return pickBiome(biomeWeightedList, layerNoise);
    }

    public static Biome pickBiome(WeightedList<Biome> biomeWeightedList, LayerRandomnessSource rand) {
        int total = biomeWeightedList.entries.stream().mapToInt(biomeEntry -> biomeEntry.weight).sum();

        double randVal = target(rand, total * 0.1);
        int i = -1;

        while (randVal >= 0) {
            ++i;
            randVal -= biomeWeightedList.entries.get(i).weight;
        }

        return biomeWeightedList.entries.get(i).getElement();
    }

    private static double target(LayerRandomnessSource random, double weightTotal) {
        return (double) random.nextInt(Integer.MAX_VALUE) * weightTotal / Integer.MAX_VALUE;
    }
}
