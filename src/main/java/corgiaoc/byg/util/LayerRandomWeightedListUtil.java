package corgiaoc.byg.util;

import corgiaoc.byg.mixin.access.WeightedRandomListAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.context.Context;

@SuppressWarnings("unchecked")
public class LayerRandomWeightedListUtil {

    private static double target(Context random, double weightTotal) {
        return (double) random.nextRandom(Integer.MAX_VALUE) * weightTotal / Integer.MAX_VALUE;
    }

    public static ResourceKey<Biome> getBiomeFromID(WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> biomeWeightedList, Context layerNoise) {
        return pickBiomeFromID(biomeWeightedList, layerNoise);
    }

    public static ResourceKey<Biome> pickBiomeFromID(WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> biomeWeightedList, Context rand) {
        double total = 0;

        for (WeightedEntry.Wrapper<ResourceLocation> biomeEntry : ((WeightedRandomListAccess<WeightedEntry.Wrapper<ResourceLocation>>) biomeWeightedList).getItems())
            total = total + biomeEntry.getWeight().asInt();

        double randVal = target(rand, total);
        int i = -1;

        while (randVal >= 0) {
            ++i;
            randVal -= ((WeightedRandomListAccess<WeightedEntry.Wrapper<ResourceLocation>>) biomeWeightedList).getItems().get(i).getWeight().asInt();
        }

        return ((WeightedRandomListAccess<WeightedEntry.Wrapper<ResourceKey<Biome>>>) biomeWeightedList).getItems().get(i).getData();
    }
}