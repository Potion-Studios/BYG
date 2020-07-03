package voronoiaoc.byg.common.world.dimension.nether.biome;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.ZoomLayer;
import voronoiaoc.byg.config.BYGWorldConfig;

import java.util.function.LongFunction;

public class BYGNetherLayerProvider {
    private static <A extends IArea, R extends IExtendedNoiseRandom<A>> IAreaFactory<A> stackLayers(LongFunction<R> randomProvider) {
        IAreaFactory<A> netherFactory = BYGNetherMasterLayer.INSTANCE.apply(randomProvider.apply(1000L));

        for (int netherBiomeSize = 0; netherBiomeSize <= BYGWorldConfig.netherBiomeSize.get(); netherBiomeSize++) {
            netherFactory = ZoomLayer.NORMAL.apply(randomProvider.apply(1000L + netherBiomeSize), netherFactory);
        }
        netherFactory = ZoomLayer.FUZZY.apply(randomProvider.apply(1000L), netherFactory);
        netherFactory = ZoomLayer.NORMAL.apply(randomProvider.apply(1000L), netherFactory);

        return netherFactory;
    }

    public static Layer build(long seed) {
        return new Layer(stackLayers(salt -> new LazyAreaLayerContext(25, seed, salt)));
    }
}
