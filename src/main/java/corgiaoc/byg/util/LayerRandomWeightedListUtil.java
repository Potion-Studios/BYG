package corgiaoc.byg.util;

import net.minecraft.util.collection.WeightedList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import java.util.Comparator;
import java.util.stream.Stream;

public class LayerRandomWeightedListUtil {

    public static Biome getBiome(WeightedList<Biome> biomeWeightedList, LayerRandomnessSource layerNoise) {
        return getShuffledStream(biomeWeightedList, layerNoise).findFirst().orElseThrow(RuntimeException::new);
    }

    private static Stream<Biome> getShuffledStream(WeightedList<Biome> biomeWeightedList, LayerRandomnessSource layerNoise) {
        biomeWeightedList.entries.stream().forEachOrdered((biomeEntry) -> {
            biomeEntry.shuffledOrder = (float) -Math.pow((double)layerNoise.nextInt(101) * 0.01F, 1.0F / (float)biomeEntry.weight);

        });
        biomeWeightedList.entries.sort(Comparator.comparingDouble((biomeEntry) -> biomeEntry.shuffledOrder));
        return biomeWeightedList.entries.stream().map(WeightedList.Entry::getElement);
    }
}
