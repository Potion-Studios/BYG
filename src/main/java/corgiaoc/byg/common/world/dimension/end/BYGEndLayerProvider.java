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

        IAreaFactory<LazyArea> endFactory = BYGEndMasterLayer.INSTANCE.apply(randomProvider.apply(1000L));

        for (int netherBiomeSize = 0; netherBiomeSize <= BYGWorldConfig.biomeSizeEND.get(); netherBiomeSize++) {
            endFactory = ZoomLayer.NORMAL.apply(randomProvider.apply(1000L + netherBiomeSize), endFactory);
        }
        endFactory = ZoomLayer.FUZZY.apply(randomProvider.apply(1000L), endFactory);
        endFactory = ZoomLayer.NORMAL.apply(randomProvider.apply(1000L), endFactory);

        return new Layer(endFactory);
    }
}
