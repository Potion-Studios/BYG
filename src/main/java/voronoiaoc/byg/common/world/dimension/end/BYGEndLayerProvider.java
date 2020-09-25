package voronoiaoc.byg.common.world.dimension.end;


import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.area.LazyArea;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.context.LazyAreaContext;
import net.minecraft.world.level.newbiome.layer.Layer;
import net.minecraft.world.level.newbiome.layer.ZoomLayer;

import java.util.function.LongFunction;

public class BYGEndLayerProvider {
    public static Layer stackLayers(long seed) {
        LongFunction<BigContext<LazyArea>> randomProvider = salt -> new LazyAreaContext(1, seed, salt);

        AreaFactory<LazyArea> endFactory = BYGEndMasterLayer.INSTANCE.run(randomProvider.apply(1000L));

        for (int netherBiomeSize = 0; netherBiomeSize <= 3; netherBiomeSize++) {
            endFactory = ZoomLayer.NORMAL.run(randomProvider.apply(1000L + netherBiomeSize), endFactory);
        }
        endFactory = ZoomLayer.FUZZY.run(randomProvider.apply(1000L), endFactory);
        endFactory = ZoomLayer.NORMAL.run(randomProvider.apply(1000L), endFactory);

        return new Layer(endFactory);
    }
}
