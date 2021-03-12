package corgiaoc.byg.common.world.dimension.layers;

import corgiaoc.byg.util.LayerRandomWeightedListUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;

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
}
