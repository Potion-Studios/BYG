package corgiaoc.byg.util;

import net.minecraft.util.WeightedList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;

import java.util.Comparator;
import java.util.stream.Stream;

public class LayerRandomWeightedListUtil {

    public static Biome getBiome(WeightedList<Biome> biomeWeightedList, INoiseRandom layerNoise) {
        return getShuffledStream(biomeWeightedList, layerNoise).findFirst().orElseThrow(RuntimeException::new);
    }

    private static Stream<Biome> getShuffledStream(WeightedList<Biome> biomeWeightedList, INoiseRandom layerNoise) {
        biomeWeightedList.field_220658_a.stream().forEachOrdered((biomeEntry) -> {
            biomeEntry.field_220653_d = (float) -Math.pow((double)layerNoise.random(101) * 0.01F, 1.0F / (float)biomeEntry.field_220652_c);

        });
        biomeWeightedList.field_220658_a.sort(Comparator.comparingDouble((biomeEntry) -> biomeEntry.field_220653_d));
        return biomeWeightedList.field_220658_a.stream().map(WeightedList.Entry::func_220647_b);
    }
}
