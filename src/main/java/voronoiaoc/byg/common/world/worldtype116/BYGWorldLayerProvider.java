package voronoiaoc.byg.common.world.worldtype116;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

import java.util.function.LongFunction;

public class BYGWorldLayerProvider {
    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> repeat(long seed, IAreaTransformer1 parent, IAreaFactory<T> factory, int count, LongFunction<C> contextFactory) {
        IAreaFactory<T> iareafactory = factory;

        for(int i = 0; i < count; ++i) {
            iareafactory = parent.apply(contextFactory.apply(seed + (long)i), iareafactory);
        }

        return iareafactory;
    }
    
    
    public static Layer stackLayers(long seed) {
        LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);
        IAreaFactory<LazyArea> primaryFactory = IslandLayer.INSTANCE.apply(randomProvider.apply(1L));
        primaryFactory = ZoomLayer.FUZZY.apply(randomProvider.apply(2000L), primaryFactory);
        primaryFactory = AddIslandLayer.INSTANCE.apply(randomProvider.apply(1L), primaryFactory);
        primaryFactory = ZoomLayer.NORMAL.apply(randomProvider.apply(2001L), primaryFactory);
        primaryFactory = AddIslandLayer.INSTANCE.apply(randomProvider.apply(2L), primaryFactory);
        primaryFactory = AddIslandLayer.INSTANCE.apply(randomProvider.apply(50L), primaryFactory);
        primaryFactory = AddIslandLayer.INSTANCE.apply(randomProvider.apply(70L), primaryFactory);
        primaryFactory = RemoveTooMuchOceanLayer.INSTANCE.apply(randomProvider.apply(2L), primaryFactory);
        IAreaFactory<LazyArea> oceanFactory = OceanLayer.INSTANCE.apply(randomProvider.apply(2L));
        oceanFactory = repeat(2001L, ZoomLayer.NORMAL, oceanFactory, 6, randomProvider);
        primaryFactory = AddSnowLayer.INSTANCE.apply(randomProvider.apply(2L), primaryFactory);
        primaryFactory = AddIslandLayer.INSTANCE.apply(randomProvider.apply(3L), primaryFactory);
        primaryFactory = EdgeLayer.CoolWarm.INSTANCE.apply(randomProvider.apply(2L), primaryFactory);
        primaryFactory = EdgeLayer.HeatIce.INSTANCE.apply(randomProvider.apply(2L), primaryFactory);
        primaryFactory = EdgeLayer.Special.INSTANCE.apply(randomProvider.apply(3L), primaryFactory);
        primaryFactory = ZoomLayer.NORMAL.apply(randomProvider.apply(2002L), primaryFactory);
        primaryFactory = ZoomLayer.NORMAL.apply(randomProvider.apply(2003L), primaryFactory);
        primaryFactory = AddIslandLayer.INSTANCE.apply(randomProvider.apply(4L), primaryFactory);
        primaryFactory = AddMushroomIslandLayer.INSTANCE.apply(randomProvider.apply(5L), primaryFactory);
        primaryFactory = DeepOceanLayer.INSTANCE.apply(randomProvider.apply(4L), primaryFactory);
        primaryFactory = repeat(1000L, ZoomLayer.NORMAL, primaryFactory, 0, randomProvider);
        IAreaFactory<LazyArea> zoomFactory = repeat(1000L, ZoomLayer.NORMAL, primaryFactory, 0, randomProvider);
        zoomFactory = StartRiverLayer.INSTANCE.apply(randomProvider.apply(100L), zoomFactory);
        IAreaFactory<LazyArea> bambooFactory = (new BYGBiomeLayer(true)).apply(randomProvider.apply(200L), primaryFactory);
        bambooFactory = AddBambooForestLayer.INSTANCE.apply(randomProvider.apply(1001L), bambooFactory);
        bambooFactory = repeat(1000L, ZoomLayer.NORMAL, bambooFactory, 2, randomProvider);
        bambooFactory = EdgeBiomeLayer.INSTANCE.apply(randomProvider.apply(1000L), bambooFactory);
        IAreaFactory<LazyArea> lvt_8_1_ = repeat(1000L, ZoomLayer.NORMAL, zoomFactory, 2, randomProvider);
        bambooFactory = HillsLayer.INSTANCE.apply(randomProvider.apply(1000L), bambooFactory, lvt_8_1_);
        zoomFactory = repeat(1000L, ZoomLayer.NORMAL, zoomFactory, 2, randomProvider);
        zoomFactory = repeat(1000L, ZoomLayer.NORMAL, zoomFactory, 4, randomProvider);
        zoomFactory = RiverLayer.INSTANCE.apply(randomProvider.apply(1L), zoomFactory);
        zoomFactory = SmoothLayer.INSTANCE.apply(randomProvider.apply(1000L), zoomFactory);
        bambooFactory = RareBiomeLayer.INSTANCE.apply(randomProvider.apply(1001L), bambooFactory);

        for(int i = 0; i < 6; ++i) {
            bambooFactory = ZoomLayer.NORMAL.apply(randomProvider.apply((long)(1000 + i)), bambooFactory);
            if (i == 0) {
                bambooFactory = AddIslandLayer.INSTANCE.apply(randomProvider.apply(3L), bambooFactory);
            }

            if (i == 1) {
                bambooFactory = ShoreLayer.INSTANCE.apply(randomProvider.apply(1000L), bambooFactory);
            }
        }

        bambooFactory = SmoothLayer.INSTANCE.apply(randomProvider.apply(1000L), bambooFactory);
        bambooFactory = MixRiverLayer.INSTANCE.apply(randomProvider.apply(100L), bambooFactory, zoomFactory);
        IAreaFactory<LazyArea> finalFactory = MixOceansLayer.INSTANCE.apply(randomProvider.apply(100L), bambooFactory, oceanFactory);
        return new Layer(finalFactory);
    }
}
