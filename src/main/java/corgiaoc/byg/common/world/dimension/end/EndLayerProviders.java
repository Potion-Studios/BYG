package corgiaoc.byg.common.world.dimension.end;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.common.world.dimension.layers.BYGEdgeLayer;
import corgiaoc.byg.common.world.dimension.layers.BYGHillsLayer;
import corgiaoc.byg.common.world.dimension.layers.WeightedMasterLayer;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.ScaleLayer;
import net.minecraft.world.biome.layer.util.CachingLayerContext;
import net.minecraft.world.biome.layer.util.CachingLayerSampler;
import net.minecraft.world.biome.layer.util.LayerFactory;
import net.minecraft.world.biome.layer.util.LayerSampleContext;

import java.util.function.LongFunction;

public class EndLayerProviders {
    public static DatapackLayer stackLayers(Registry<Biome> biomeRegistry, long seed) {
        LongFunction<LayerSampleContext<CachingLayerSampler>> randomProvider = salt -> new CachingLayerContext(1, seed, salt);

        LayerFactory<CachingLayerSampler> endLayer = new WeightedMasterLayer(biomeRegistry, BYGEndBiomeProvider.END_BIOMES).create(randomProvider.apply(1003958L));

        for (int endBiomeSize = 0; endBiomeSize <= BYG.DIMENSIONS_CONFIG.EndDimension.Islands.IslandBiomeSize; endBiomeSize++) {
            endLayer = ScaleLayer.NORMAL.create(randomProvider.apply(49596L + endBiomeSize), endLayer);
        }

        endLayer = new BYGHillsLayer(biomeRegistry, BYGEndBiome.BIOME_TO_HILLS, 3).create(randomProvider.apply(2848586786L), endLayer, endLayer);
        endLayer = ScaleLayer.NORMAL.create(randomProvider.apply(495949586L), endLayer);
        endLayer = ScaleLayer.FUZZY.create(randomProvider.apply(34885L), endLayer);
        endLayer = new BYGEdgeLayer(biomeRegistry, BYGEndBiome.BIOME_TO_EDGE).create(randomProvider.apply(2848586786L), endLayer);
        endLayer = ScaleLayer.FUZZY.create(randomProvider.apply(395885L), endLayer);
        endLayer = ScaleLayer.NORMAL.create(randomProvider.apply(28475786L), endLayer);
        return new DatapackLayer(endLayer);
    }

    public static DatapackLayer stackVoidLayers(Registry<Biome> biomeRegistry, long seed) {
        LongFunction<LayerSampleContext<CachingLayerSampler>> randomProvider = salt -> new CachingLayerContext(1, seed, salt);

        LayerFactory<CachingLayerSampler> endLayer = new WeightedMasterLayer(biomeRegistry, BYGEndBiomeProvider.VOID_BIOMES).create(randomProvider.apply(1003958L));

        for (int endBiomeSize = 0; endBiomeSize <= BYG.DIMENSIONS_CONFIG.EndDimension.Void.VoidBiomeSize; endBiomeSize++) {
            endLayer = ScaleLayer.NORMAL.create(randomProvider.apply(49596L + endBiomeSize), endLayer);
        }

        endLayer = new BYGHillsLayer(biomeRegistry, BYGEndBiome.BIOME_TO_HILLS, 3).create(randomProvider.apply(2848586786L), endLayer, endLayer);
        endLayer = ScaleLayer.NORMAL.create(randomProvider.apply(495949586L), endLayer);
        endLayer = ScaleLayer.FUZZY.create(randomProvider.apply(34885L), endLayer);
        endLayer = new BYGEdgeLayer(biomeRegistry, BYGEndBiome.BIOME_TO_EDGE).create(randomProvider.apply(2848586786L), endLayer);
        endLayer = ScaleLayer.FUZZY.create(randomProvider.apply(395885L), endLayer);
        endLayer = ScaleLayer.NORMAL.create(randomProvider.apply(28475786L), endLayer);

        return new DatapackLayer(endLayer);
    }
}
