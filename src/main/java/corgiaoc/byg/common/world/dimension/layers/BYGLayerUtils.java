package corgiaoc.byg.common.world.dimension.layers;

import corgiaoc.byg.mixin.access.WeightedListAccess;
import corgiaoc.byg.util.LayerRandomWeightedListUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.context.Context;

public class BYGLayerUtils {

    @Nullable
    public static Biome getBiomeFromWeightedList(WeightedList<ResourceLocation> oceanBiomeList, Context layerRandom, Registry<Biome> biomeRegistry) {
        if (((WeightedListAccess<ResourceLocation>) oceanBiomeList).getEntries().size() > 0) {
            return biomeRegistry.get(LayerRandomWeightedListUtil.getBiomeFromID(oceanBiomeList, layerRandom));
        } else {
            return null;
        }
    }

//    @Nullable
//    public static Biome getBiomeFromWeightedListNoiseBased(WeightedList<ResourceLocation> oceanBiomeList, INoiseRandom layerRandom, Registry<Biome> biomeRegistry, ImprovedNoiseGenerator noiseGenerator, int x, int z) {
//        double noise = noiseGenerator.noise(x / 8.0, z / 8.0, 0, 0, 0) + 1.0;
//
//        double slide = noise / 2.0F;
//        double newNoise = MathHelper.clamp(slide, 0.0, 2.0D);
//
//        int totalWeight =
//        oceanBiomeList.entries.stream().map()
//
//
//
//        if (oceanBiomeList.entries.size() > 0) {
//            return biomeRegistry.get(LayerRandomWeightedListUtil.getBiomeFromID(oceanBiomeList, layerRandom));
//        } else {
//            return null;
//        }
//    }
}
