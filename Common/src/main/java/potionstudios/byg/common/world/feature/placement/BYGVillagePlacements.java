package potionstudios.byg.common.world.feature.placement;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class BYGVillagePlacements {

    public static final Holder<PlacedFeature> BAMBOO_LIGHT = BYGPlacedFeaturesUtil.createPlacedFeature("village_bamboo_light", VegetationFeatures.BAMBOO_NO_PODZOL);
    public static final Holder<PlacedFeature> RED_MUSHROOM_NORMAL = PlacementUtils.register("village_red_mushroom_normal", VegetationFeatures.PATCH_RED_MUSHROOM);


}
