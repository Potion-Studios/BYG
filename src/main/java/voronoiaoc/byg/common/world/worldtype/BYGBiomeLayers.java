package voronoiaoc.byg.common.world.worldtype;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.ZoomLayer;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;
import voronoiaoc.byg.common.world.worldtype.layers.AddContinentLayer;
import voronoiaoc.byg.common.world.worldtype.layers.BYGAddDeepOceanLayer;
import voronoiaoc.byg.common.world.worldtype.layers.BYGAddIslandLayer;
import voronoiaoc.byg.common.world.worldtype.layers.biomemix.*;
import voronoiaoc.byg.common.world.worldtype.math.BiomeGroupManager;
import voronoiaoc.byg.config.BYGWorldConfig;

import java.util.function.LongFunction;

public class BYGBiomeLayers {
    public static int continentSize = 8;
    public static int continentChance =/*1 over*/ 20;
    public static int continentBiomeSize = 0;

    public static int oceanSize = 5;
    public static int oceanBiomeSize = continentBiomeSize;

    public static int climateRegionSize = 0;

    static int configBiomeSize = BYGWorldConfig.biomeSize.get();

    public static Layer stackLayerTransformers(long seed) {
        LongFunction<IExtendedNoiseRandom<LazyArea>> contextProvider = salt -> new LazyAreaLayerContext(1, seed, salt);
        BiomeGroupManager manager = new BiomeGroupManager(seed);

        IAreaFactory<LazyArea> createOcean = new OceanInitLayer(manager).apply(contextProvider.apply(1L));
        createOcean = repeatOceanSize(1000L, ZoomLayer.NORMAL, createOcean, oceanSize, contextProvider);

        IAreaFactory<LazyArea> createContinent = new AddContinentLayer(manager).apply(contextProvider.apply(1L), createOcean);
        createContinent = repeatContinentSize(1000L, ZoomLayer.NORMAL, createContinent, continentSize, contextProvider);

        IAreaFactory<LazyArea> mixContinents = new MixContinentLayer(manager).apply(contextProvider.apply(1L));
        mixContinents = repeatContinentBiomeSize(1000L, ZoomLayer.NORMAL, mixContinents, continentBiomeSize, contextProvider);

        IAreaFactory<LazyArea> mixOceans = new MixOceansLayer(manager).apply(contextProvider.apply(1L));
        mixOceans = repeatOceanBiomeSize(1000L, ZoomLayer.NORMAL, mixOceans, oceanBiomeSize, contextProvider);

        //These 2 work separately.

        IAreaFactory<LazyArea> mergeContinentMix = new LandDoubleLayerMergerBYG(manager).apply(contextProvider.apply(1L), createContinent, mixContinents);
        IAreaFactory<LazyArea> mergeOceanMixToContinentMix = new OceanicDoubleLayerMergerBYG(manager).apply(contextProvider.apply(5L), mergeContinentMix, mixOceans);

        IAreaFactory<LazyArea> river = repeatOceanSize(1000L, ZoomLayer.NORMAL, mergeOceanMixToContinentMix, 0, contextProvider);


        mergeOceanMixToContinentMix = BYGAddDeepOceanLayer.INSTANCE.apply(contextProvider.apply(1005), mergeOceanMixToContinentMix);
        mergeOceanMixToContinentMix = ZoomLayer.NORMAL.apply(contextProvider.apply(1067L), mergeOceanMixToContinentMix);
        mergeOceanMixToContinentMix = ZoomLayer.NORMAL.apply(contextProvider.apply(1001L), mergeOceanMixToContinentMix);
        mergeOceanMixToContinentMix = BYGAddIslandLayer.INSTANCE.apply(contextProvider.apply(1005), mergeOceanMixToContinentMix);
        mergeOceanMixToContinentMix = ZoomLayer.FUZZY.apply(contextProvider.apply(1013562L), mergeOceanMixToContinentMix);
        mergeOceanMixToContinentMix = ZoomLayer.NORMAL.apply(contextProvider.apply(10029232L), mergeOceanMixToContinentMix);
        mergeOceanMixToContinentMix = ZoomLayer.NORMAL.apply(contextProvider.apply(1023302L), mergeOceanMixToContinentMix);
        mergeOceanMixToContinentMix = ZoomLayer.NORMAL.apply(contextProvider.apply(1022202L), mergeOceanMixToContinentMix);
//        mergeOceanMixToContinentMix = ZoomLayer.NORMAL.apply(contextProvider.apply(1003L), mergeOceanMixToContinentMix);
//        mergeOceanMixToContinentMix = BYGAddDeepOceanLayer.INSTANCE.apply(contextProvider.apply(1004), mergeOceanMixToContinentMix);
//        mergeOceanMixToContinentMix = new BYGAddHillsLayer(manager).apply(contextProvider.apply(1006), mergeOceanMixToContinentMix);
//        mergeOceanMixToContinentMix = ZoomLayer.FUZZY.apply(contextProvider.apply(1007L), mergeOceanMixToContinentMix);
//        mergeOceanMixToContinentMix = BYGShoreLayer.INSTANCE.apply(contextProvider.apply(1008), mergeOceanMixToContinentMix);
//        mergeOceanMixToContinentMix = ZoomLayer.NORMAL.apply(contextProvider.apply(1009L), mergeOceanMixToContinentMix);
//        mergeOceanMixToContinentMix = ZoomLayer.NORMAL.apply(contextProvider.apply(1010L), mergeOceanMixToContinentMix);
//        mergeOceanMixToContinentMix = ZoomLayer.FUZZY.apply(contextProvider.apply(1011L), mergeOceanMixToContinentMix);
        return new Layer(mergeOceanMixToContinentMix);
    }

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> repeatContinentSize(long seed, IAreaTransformer1 parent, IAreaFactory<T> layer, int count, LongFunction<C> contextFactory) {
        IAreaFactory<T> layer1 = layer;
        for(int i = 0; i < count; ++i) {
            layer1 = parent.apply(contextFactory.apply(seed + (long)i), layer1);
        }
        return layer1;
    }

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> repeatOceanSize(long seed, IAreaTransformer1 parent, IAreaFactory<T> layer, int count, LongFunction<C> contextFactory) {
        IAreaFactory<T> layer1 = layer;
        for(int i = 0; i < count; ++i) {
            layer1 = parent.apply(contextFactory.apply(seed + (long)i), layer1);
        }
        return layer1;
    }

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> repeatContinentBiomeSize(long seed, IAreaTransformer1 parent, IAreaFactory<T> layer, int count, LongFunction<C> contextFactory) {
        IAreaFactory<T> layer1 = layer;
        for(int i = 0; i < count; ++i) {
            layer1 = parent.apply(contextFactory.apply(seed + (long)i), layer1);
        }
        return layer1;
    }

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> repeatOceanBiomeSize(long seed, IAreaTransformer1 parent, IAreaFactory<T> layer, int count, LongFunction<C> contextFactory) {
        IAreaFactory<T> layer1 = layer;
        for(int i = 0; i < count; ++i) {
            layer1 = parent.apply(contextFactory.apply(seed + (long)i), layer1);
        }
        return layer1;
    }
}
