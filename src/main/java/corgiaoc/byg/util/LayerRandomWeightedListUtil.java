package corgiaoc.byg.util;

import corgiaoc.byg.mixin.access.WeightedListAccess;
import corgiaoc.byg.mixin.access.WeightedListEntryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.newbiome.context.Context;

import java.util.List;

@SuppressWarnings("unchecked")
public class LayerRandomWeightedListUtil {

    private static double target(Context random, double weightTotal) {
        return (double) random.nextRandom(Integer.MAX_VALUE) * weightTotal / Integer.MAX_VALUE;
    }

    public static ResourceLocation getBiomeFromID(WeightedList<ResourceLocation> biomeWeightedList, Context layerNoise) {
        return pickBiomeFromID(biomeWeightedList, layerNoise);
    }

    public static ResourceLocation pickBiomeFromID(WeightedList<ResourceLocation> biomeWeightedList, Context rand) {
        double total = 0;

        // Make sure we remove unweighted entries.
        removeUnweightedEntries(biomeWeightedList);

        for (WeightedList.WeightedEntry<ResourceLocation> biomeEntry : ((WeightedListAccess<ResourceLocation>) biomeWeightedList).getEntries())
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
        List<WeightedList.WeightedEntry<T>> entries = ((WeightedListAccess<T>) weightedList).getEntries();
        for (int i = 0; i < entries.size(); i++) {
            WeightedList.WeightedEntry<T> biomeEntry = entries.get(i);
            if (((WeightedListEntryAccess) biomeEntry).getWeight() <= 0) {
                entries.remove(i);
            }
        }

        return weightedList;
    }
}