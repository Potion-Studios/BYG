package voronoiaoc.byg.common.world.dimension.nether;

import java.util.function.LongFunction;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.area.LazyArea;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.context.LazyAreaContext;
import net.minecraft.world.level.newbiome.layer.Layer;
import net.minecraft.world.level.newbiome.layer.ZoomLayer;

public class BYGNetherLayerProvider {
    public static Layer stackLayers(long seed) {
        LongFunction<BigContext<LazyArea>> randomProvider = salt -> new LazyAreaContext(1, seed, salt);
        AreaFactory<LazyArea> netherFactory = BYGNetherMasterLayer.INSTANCE.run(randomProvider.apply(1000L));

        for (int netherBiomeSize = 0; netherBiomeSize <= 3; netherBiomeSize++) {
            netherFactory = ZoomLayer.NORMAL.run(randomProvider.apply(1000L + netherBiomeSize), netherFactory);
        }
        netherFactory = ZoomLayer.FUZZY.run(randomProvider.apply(1000L), netherFactory);
        netherFactory = ZoomLayer.NORMAL.run(randomProvider.apply(1000L), netherFactory);

        return new Layer(netherFactory);
    }
}
