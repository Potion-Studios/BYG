package voronoiaoc.byg.common.world.dimension.end;


import net.minecraft.world.biome.layer.ScaleLayer;
import net.minecraft.world.biome.layer.util.CachingLayerContext;
import net.minecraft.world.biome.layer.util.CachingLayerSampler;
import net.minecraft.world.biome.layer.util.LayerFactory;
import net.minecraft.world.biome.layer.util.LayerSampleContext;
import net.minecraft.world.biome.source.BiomeLayerSampler;

import java.util.function.LongFunction;

public class BYGEndLayerProvider {
    public static BiomeLayerSampler stackLayers(long seed) {
        LongFunction<LayerSampleContext<CachingLayerSampler>> randomProvider = salt -> new CachingLayerContext(1, seed, salt);

        LayerFactory<CachingLayerSampler> endFactory = BYGEndMasterLayer.INSTANCE.create(randomProvider.apply(1000L));

        for (int netherBiomeSize = 0; netherBiomeSize <= 3; netherBiomeSize++) {
            endFactory = ScaleLayer.NORMAL.create(randomProvider.apply(1000L + netherBiomeSize), endFactory);
        }
        endFactory = ScaleLayer.FUZZY.create(randomProvider.apply(1000L), endFactory);
        endFactory = ScaleLayer.NORMAL.create(randomProvider.apply(1000L), endFactory);

        return new BiomeLayerSampler(endFactory);
    }
}
