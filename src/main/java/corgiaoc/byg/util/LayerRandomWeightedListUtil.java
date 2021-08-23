package corgiaoc.byg.util;

import corgiaoc.byg.mixin.access.WeightedListAccess;
import corgiaoc.byg.mixin.access.WeightedListEntryAccess;
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

        for (WeightedList.Entry<Biome> biomeEntry : ((WeightedListAccess<Biome>) biomeWeightedList).getEntries())
            total = total + ((WeightedListEntryAccess) biomeEntry).getWeight();

        double randVal = target(rand, total);
        int i = -1;

        while (randVal >= 0) {
            ++i;
            randVal -= ((WeightedListEntryAccess) ((WeightedListAccess<Biome>) biomeWeightedList).getEntries().get(i)).getWeight();
        }

        return ((WeightedListAccess<Biome>) biomeWeightedList).getEntries().get(i).getData();
    }

    private static double target(INoiseRandom random, double weightTotal) {
        return (double) random.nextRandom(Integer.MAX_VALUE) * weightTotal / Integer.MAX_VALUE;
    }

    public static ResourceLocation getBiomeFromID(WeightedList<ResourceLocation> biomeWeightedList, INoiseRandom layerNoise) {
        return pickBiomeFromID(biomeWeightedList, layerNoise);
    }

    public static ResourceLocation pickBiomeFromID(WeightedList<ResourceLocation> biomeWeightedList, INoiseRandom rand) {
        double total = 0;

        for (WeightedList.Entry biomeEntry : ((WeightedListAccess<ResourceLocation>) biomeWeightedList).getEntries())
            total = total + ((WeightedListEntryAccess) biomeEntry).getWeight();

        double randVal = target(rand, total);
        int i = -1;

        while (randVal >= 0) {
            ++i;
            randVal -= ((WeightedListEntryAccess) ((WeightedListAccess<ResourceLocation>) biomeWeightedList).getEntries().get(i)).getWeight();
        }

        return ((WeightedListAccess<ResourceLocation>) biomeWeightedList).getEntries().get(i).getData();
    }
}