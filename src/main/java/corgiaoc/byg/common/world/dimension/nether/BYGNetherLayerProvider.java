package corgiaoc.byg.common.world.dimension.nether;


import corgiaoc.byg.config.BYGWorldConfig;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.ZoomLayer;

import java.util.function.LongFunction;

public class BYGNetherLayerProvider {
    public static Layer stackLayers(long seed) {
        LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);


        IAreaFactory<LazyArea> netherLayer = BYGNetherMasterLayer.INSTANCE.apply(randomProvider.apply(1000L));

        for (int netherBiomeSize = 0; netherBiomeSize <= BYGWorldConfig.biomeSizeNETHER.get(); netherBiomeSize++) {
            netherLayer = ZoomLayer.NORMAL.apply(randomProvider.apply(1000L + netherBiomeSize), netherLayer);
        }
        netherLayer = ZoomLayer.FUZZY.apply(randomProvider.apply(1000L), netherLayer);
        netherLayer = ZoomLayer.NORMAL.apply(randomProvider.apply(1000L), netherLayer);

        return new Layer(netherLayer);
    }
}
