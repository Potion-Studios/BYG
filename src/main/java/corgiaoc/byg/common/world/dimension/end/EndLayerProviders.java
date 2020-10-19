package corgiaoc.byg.common.world.dimension.end;


import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.config.BYGWorldConfig;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.ZoomLayer;

import java.util.function.LongFunction;

public class EndLayerProviders {
    public static DatapackLayer stackLayers(Registry<Biome> biomeRegistry, long seed) {
        LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);

        IAreaFactory<LazyArea> endLayer = new EndMasterLayer(biomeRegistry).apply(randomProvider.apply(1003958L));

        for (int endBiomeSize = 0; endBiomeSize <= BYGWorldConfig.BIOME_SIZE_END.get(); endBiomeSize++) {
            endLayer = ZoomLayer.NORMAL.apply(randomProvider.apply(49596L + endBiomeSize), endLayer);
        }
        endLayer = ZoomLayer.FUZZY.apply(randomProvider.apply(34885L), endLayer);
        endLayer = ZoomLayer.FUZZY.apply(randomProvider.apply(395885L), endLayer);
        endLayer = ZoomLayer.NORMAL.apply(randomProvider.apply(28475786L), endLayer);

        return new DatapackLayer(endLayer);
    }

    public static DatapackLayer stackVoidLayers(Registry<Biome> biomeRegistry, long seed) {
        LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);

        IAreaFactory<LazyArea> endLayer = new VoidMasterLayer(biomeRegistry).apply(randomProvider.apply(1003958L));

        for (int endBiomeSize = 0; endBiomeSize <= BYGWorldConfig.VOID_BIOME_SIZE.get(); endBiomeSize++) {
            endLayer = ZoomLayer.NORMAL.apply(randomProvider.apply(49596L + endBiomeSize), endLayer);
        }
        endLayer = ZoomLayer.FUZZY.apply(randomProvider.apply(34885L), endLayer);
        endLayer = ZoomLayer.FUZZY.apply(randomProvider.apply(395885L), endLayer);
        endLayer = ZoomLayer.NORMAL.apply(randomProvider.apply(28475786L), endLayer);

        return new DatapackLayer(endLayer);
    }
}
