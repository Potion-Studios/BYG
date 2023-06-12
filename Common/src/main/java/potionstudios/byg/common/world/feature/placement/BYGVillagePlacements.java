package potionstudios.byg.common.world.feature.placement;

import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class BYGVillagePlacements {

    public static final ResourceKey<PlacedFeature> BAMBOO_LIGHT = BYGPlacedFeaturesUtil.createPlacedFeature("village_bamboo_light", VegetationFeatures.BAMBOO_NO_PODZOL);
    public static final ResourceKey<PlacedFeature> RED_MUSHROOM_NORMAL = BYGPlacedFeaturesUtil.createPlacedFeature("village_red_mushroom_normal", VegetationFeatures.PATCH_RED_MUSHROOM);

    public static void loadClass(){
    }

}
