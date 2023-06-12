package potionstudios.byg.common.world.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import potionstudios.byg.common.world.feature.features.BYGGlobalFeatureFeatures;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;
import potionstudios.byg.common.world.placement.IsDimensionFilter;
import potionstudios.byg.mixin.access.OrePlacementsAccess;

import java.util.List;

import static potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil.globalFeaturePath;

public class BYGGlobalPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ORE_SOAPSTONE_UPPER = BYGPlacedFeaturesUtil.createPlacedFeature(globalFeaturePath("ore_soapstone_upper"), BYGGlobalFeatureFeatures.ORE_SOAPSTONE,() ->  new ImmutableList.Builder<PlacementModifier>().addAll(OrePlacementsAccess.byg_invokeRareOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128)))).add(new IsDimensionFilter(List.of(Level.OVERWORLD))).build().stream().filter(placementModifier -> !(placementModifier instanceof BiomeFilter)).toList());
    public static final ResourceKey<PlacedFeature> ORE_SOAPSTONE_LOWER = BYGPlacedFeaturesUtil.createPlacedFeature(globalFeaturePath("ore_soapstone_lower"), BYGGlobalFeatureFeatures.ORE_SOAPSTONE,() ->  new ImmutableList.Builder<PlacementModifier>().addAll(OrePlacementsAccess.byg_invokeCommonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))).add(new IsDimensionFilter(List.of(Level.OVERWORLD))).build().stream().filter(placementModifier -> !(placementModifier instanceof BiomeFilter)).toList());
}
