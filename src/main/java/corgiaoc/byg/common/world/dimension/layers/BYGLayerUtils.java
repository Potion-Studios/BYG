package corgiaoc.byg.common.world.dimension.layers;

import corgiaoc.byg.util.LayerRandomWeightedListUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.ImprovedNoiseGenerator;

import javax.annotation.Nullable;

public class BYGLayerUtils {

    @Nullable
    public static Biome getBiomeFromWeightedList(WeightedList<ResourceLocation> oceanBiomeList, INoiseRandom layerRandom, Registry<Biome> biomeRegistry) {
        if (oceanBiomeList.entries.size() > 0) {
            return biomeRegistry.get(LayerRandomWeightedListUtil.getBiomeFromID(oceanBiomeList, layerRandom));
        } else {
            return null;
        }
    }

    @Nullable
    public static Biome getBiomeFromWeightedListNoiseBased(WeightedList<ResourceLocation> oceanBiomeList, INoiseRandom layerRandom, Registry<Biome> biomeRegistry, ImprovedNoiseGenerator noiseGenerator, int x, int z) {
        double noise = noiseGenerator.noise(x / 8.0, z / 8.0, 0, 0, 0) + 1.0;

        double slide = noise / 2.0F;
        double newNoise = MathHelper.clamp(slide, 0.0, 2.0D);

        int totalWeight =
        oceanBiomeList.entries.stream().map()



        if (oceanBiomeList.entries.size() > 0) {
            return biomeRegistry.get(LayerRandomWeightedListUtil.getBiomeFromID(oceanBiomeList, layerRandom));
        } else {
            return null;
        }
    }
}
