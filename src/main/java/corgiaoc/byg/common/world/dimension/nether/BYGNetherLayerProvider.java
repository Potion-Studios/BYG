package corgiaoc.byg.common.world.dimension.nether;


import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.ScaleLayer;
import net.minecraft.world.biome.layer.util.CachingLayerContext;
import net.minecraft.world.biome.layer.util.CachingLayerSampler;
import net.minecraft.world.biome.layer.util.LayerFactory;
import net.minecraft.world.biome.layer.util.LayerSampleContext;

import java.util.function.LongFunction;

public class BYGNetherLayerProvider {
    public static DatapackLayer stackLayers(Registry<Biome> biomeRegistry, long seed) {
        LongFunction<LayerSampleContext<CachingLayerSampler>> randomProvider = salt -> new CachingLayerContext(1, seed, salt);

        LayerFactory<CachingLayerSampler> netherLayer = new BYGNetherMasterLayer(biomeRegistry).create(randomProvider.apply(485868686L));

        for (int netherBiomeSize = 0; netherBiomeSize <= BYG.DIMENSIONS_CONFIG.NetherDimension.BiomeSize; netherBiomeSize++) {
            netherLayer = ScaleLayer.NORMAL.create(randomProvider.apply(28585L + netherBiomeSize), netherLayer);
        }
        netherLayer = ScaleLayer.FUZZY.create(randomProvider.apply(958687L), netherLayer);
        netherLayer = ScaleLayer.NORMAL.create(randomProvider.apply(19375756L), netherLayer);

        return new DatapackLayer(netherLayer);
    }
}
