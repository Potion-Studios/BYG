package corgiaoc.byg.util;

import corgiaoc.byg.mixin.access.WeightedListAccess;
import corgiaoc.byg.mixin.access.WeightedListEntryAccess;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.world.gen.INoiseRandom;

import java.util.List;

@SuppressWarnings("unchecked")
public class LayerRandomWeightedListUtil {

    private static double target(INoiseRandom random, double weightTotal) {
        return (double) random.nextRandom(Integer.MAX_VALUE) * weightTotal / Integer.MAX_VALUE;
    }

    public static ResourceLocation getBiomeFromID(WeightedList<ResourceLocation> biomeWeightedList, INoiseRandom layerNoise) {
        return pickBiomeFromID(biomeWeightedList, layerNoise);
    }

    public static ResourceLocation pickBiomeFromID(WeightedList<ResourceLocation> biomeWeightedList, INoiseRandom rand) {
        double total = 0;

        // Make sure we remove unweighted entries.
        removeUnweightedEntries(biomeWeightedList);

        for (WeightedList.Entry<ResourceLocation> biomeEntry : ((WeightedListAccess<ResourceLocation>) biomeWeightedList).getEntries())
            total = total + ((WeightedListEntryAccess) biomeEntry).getWeight();

        double randVal = target(rand, total);
        int i = -1;

        while (randVal >= 0) {
            ++i;
            randVal -= ((WeightedListEntryAccess) ((WeightedListAccess<ResourceLocation>) biomeWeightedList).getEntries().get(i)).getWeight();
        }

        return ((WeightedListAccess<ResourceLocation>) biomeWeightedList).getEntries().get(i).getData();
    }


    public static <T> WeightedList<T> removeUnweightedEntries(WeightedList<T> weightedList) {
        List<WeightedList.Entry<T>> entries = ((WeightedListAccess<T>) weightedList).getEntries();
        for (int i = 0; i < entries.size(); i++) {
            WeightedList.Entry<T> biomeEntry = entries.get(i);
            if (((WeightedListEntryAccess) biomeEntry).getWeight() <= 0) {
                entries.remove(i);
            }
        }

        return weightedList;
    }
}