package voronoiaoc.byg.common.world.feature.features.overworld.trees.util.mappings.foilageplacers115;

import com.mojang.datafixers.Dynamic;

import java.util.function.Function;

public class BYGMappedFoliagePlacerType<P extends BYGMappedFoilagePlacer> {
    public static final BYGMappedFoliagePlacerType<BYGMappedBlobFoilagePlacer> blob_foliage_placer = mFoilagePlacer(BYGMappedBlobFoilagePlacer::new);
    public final Function<Dynamic<?>, P> dynamicPFunction;

    private BYGMappedFoliagePlacerType(Function<Dynamic<?>, P> dynamicPFunction2) {
        this.dynamicPFunction = dynamicPFunction2;
    }

    private static <P extends BYGMappedFoilagePlacer> BYGMappedFoliagePlacerType<P> mFoilagePlacer(Function<Dynamic<?>, P> dynamicFunction) {
        return (new BYGMappedFoliagePlacerType<>(dynamicFunction));
    }

    public P PDynamic(Dynamic<?> dynamic) {
        return this.dynamicPFunction.apply(dynamic);
    }
}