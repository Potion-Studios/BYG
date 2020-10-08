package corgiaoc.byg.common.world.dimension.end;


import corgiaoc.byg.config.BYGWorldConfig;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.ZoomLayer;

import java.util.function.LongFunction;

public class BYGEndLayerProvider {
    public static Layer stackLayers(long seed) {
        LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);

        IAreaFactory<LazyArea> endLayer = BYGEndMasterLayer.INSTANCE.apply(randomProvider.apply(1003958L));

        for (int endBiomeSize = 0; endBiomeSize <= BYGWorldConfig.biomeSizeEND.get(); endBiomeSize++) {
            endLayer = ZoomLayer.NORMAL.apply(randomProvider.apply(49596L + endBiomeSize), endLayer);
        }
        endLayer = ZoomLayer.FUZZY.apply(randomProvider.apply(34885L), endLayer);
        endLayer = ZoomLayer.FUZZY.apply(randomProvider.apply(395885L), endLayer);
        endLayer = ZoomLayer.NORMAL.apply(randomProvider.apply(28475786L), endLayer);

        return new Layer(endLayer);
    }
}
