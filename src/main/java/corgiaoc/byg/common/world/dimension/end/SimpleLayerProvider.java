package corgiaoc.byg.common.world.dimension.end;


import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.common.world.dimension.layers.BYGEdgeLayer;
import corgiaoc.byg.common.world.dimension.layers.BYGHillsLayer;
import corgiaoc.byg.common.world.dimension.layers.WeightedMasterLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.ZoomLayer;

import java.util.Map;
import java.util.function.LongFunction;

public class SimpleLayerProvider {
    public static DatapackLayer stackLayers(Registry<Biome> biomeRegistry, long seed, int biomeSize, WeightedList<ResourceLocation> endBiomes, Map<ResourceLocation, WeightedList<ResourceLocation>> hills, Map<ResourceLocation, ResourceLocation> edges) {
        LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);

        IAreaFactory<LazyArea> endLayer = new WeightedMasterLayer(biomeRegistry, endBiomes).run(randomProvider.apply(1003958L));

        for (int endBiomeSize = 0; endBiomeSize <= biomeSize; endBiomeSize++) {
            endLayer = ZoomLayer.NORMAL.run(randomProvider.apply(49596L + endBiomeSize), endLayer);
        }

        endLayer = new BYGHillsLayer(biomeRegistry, hills, 3).run(randomProvider.apply(2848586786L), endLayer, endLayer);
        endLayer = ZoomLayer.NORMAL.run(randomProvider.apply(495949586L), endLayer);
        endLayer = ZoomLayer.FUZZY.run(randomProvider.apply(34885L), endLayer);
        endLayer = new BYGEdgeLayer(biomeRegistry, edges).run(randomProvider.apply(2848586786L), endLayer);
        endLayer = ZoomLayer.FUZZY.run(randomProvider.apply(395885L), endLayer);
        endLayer = ZoomLayer.NORMAL.run(randomProvider.apply(28475786L), endLayer);
        return new DatapackLayer(endLayer);
    }
}
