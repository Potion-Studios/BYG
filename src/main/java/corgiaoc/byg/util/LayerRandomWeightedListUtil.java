package corgiaoc.byg.util;

import net.minecraft.util.WeightedList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;

public class LayerRandomWeightedListUtil {

    public static Biome getBiome(WeightedList<Biome> biomeWeightedList, INoiseRandom layerNoise) {
        return pickBiome(biomeWeightedList, layerNoise);
    }

    public static Biome pickBiome(WeightedList<Biome> biomeWeightedList, INoiseRandom rand) {
        int total = biomeWeightedList.field_220658_a.stream().mapToInt(biomeEntry -> biomeEntry.field_220652_c).sum();

        double randVal = target(rand, total * 0.01);
        int i = -1;

        while (randVal >= 0) {
            ++i;
            randVal -= biomeWeightedList.field_220658_a.get(i).field_220652_c;
        }

        return biomeWeightedList.field_220658_a.get(i).func_220647_b();
    }

    private static double target(INoiseRandom random, double weightTotal) {
        return (double) random.random(Integer.MAX_VALUE) * weightTotal / Integer.MAX_VALUE;
    }
}
