package corgiaoc.byg.util;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;

public class LayerRandomWeightedListUtil {

    public static Biome getBiome(WeightedList<Biome> biomeWeightedList, INoiseRandom layerNoise) {
        return pickBiome(biomeWeightedList, layerNoise);
    }

    public static Biome pickBiome(WeightedList<Biome> biomeWeightedList, INoiseRandom rand) {
        double total = 0;

        for (WeightedList.Entry<Biome> biomeEntry : biomeWeightedList.entries)
            total = total + biomeEntry.weight;

        double randVal = target(rand, total);
        int i = -1;

        while (randVal >= 0) {
            ++i;
            randVal -= biomeWeightedList.entries.get(i).weight;
        }

        return biomeWeightedList.entries.get(i).getData();
    }

    private static double target(INoiseRandom random, double weightTotal) {
        return (double) random.nextRandom(Integer.MAX_VALUE) * weightTotal / Integer.MAX_VALUE;
    }

    public static ResourceLocation getBiomeFromID(WeightedList<ResourceLocation> biomeWeightedList, INoiseRandom layerNoise) {
        return pickBiomeFromID(biomeWeightedList, layerNoise);
    }

    public static ResourceLocation pickBiomeFromID(WeightedList<ResourceLocation> biomeWeightedList, INoiseRandom rand) {
        double total = 0;

        for (WeightedList.Entry biomeEntry : biomeWeightedList.entries)
            total = total + biomeEntry.weight;

        double randVal = target(rand, total);
        int i = -1;

        while (randVal >= 0) {
            ++i;
            randVal -= biomeWeightedList.entries.get(i).weight;
        }

        return biomeWeightedList.entries.get(i).getData();
    }
}