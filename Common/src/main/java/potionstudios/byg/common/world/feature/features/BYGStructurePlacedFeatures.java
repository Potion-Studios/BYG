package potionstudios.byg.common.world.feature.features;

import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;

public class BYGStructurePlacedFeatures {

    public static final ResourceKey<PlacedFeature> ARCH_MOSS_PATCH_CEILING = BYGPlacedFeaturesUtil.createPlacedFeature("arch_moss_patch_ceiling", CaveFeatures.MOSS_PATCH_CEILING, () -> RarityFilter.onAverageOnceEvery(350), () -> RandomOffsetPlacement.vertical(UniformInt.of(-15, -10)));
    public static final ResourceKey<PlacedFeature> ARCH_MOSS_PATCH = BYGPlacedFeaturesUtil.createPlacedFeature("arch_moss_patch", CaveFeatures.MOSS_PATCH, () -> RarityFilter.onAverageOnceEvery(350), () -> PlacementUtils.HEIGHTMAP);

    public static void loadClass() {
    }
}
