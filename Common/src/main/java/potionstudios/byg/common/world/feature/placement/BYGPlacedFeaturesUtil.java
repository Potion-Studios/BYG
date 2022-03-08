package potionstudios.byg.common.world.feature.placement;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import potionstudios.byg.BYG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;

public class BYGPlacedFeaturesUtil {
    public static final NoiseThresholdCountPlacement CLEARING_NOISE = NoiseThresholdCountPlacement.of(0.545, 1, 0);

    public static List<PlacementModifier> clearingTreePlacementBaseOceanFloor(PlacementModifier $$0) {
        return ImmutableList.<PlacementModifier>builder().add($$0).add(InSquarePlacement.spread()).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(CLEARING_NOISE).add(BiomeFilter.biome()).build();
    }

    public static List<PlacementModifier> clearingTreePlacement(PlacementModifier placementModifier) {
        List<PlacementModifier> placementModifiers = new ArrayList<>(treePlacement(placementModifier));
        placementModifiers.add(CLEARING_NOISE);
        return placementModifiers;
    }

    public static List<PlacementModifier> clearingTreePlacement(PlacementModifier placementModifier, Block block) {
        List<PlacementModifier> placementModifiers = new ArrayList<>(treePlacement(placementModifier, block));
        placementModifiers.add(CLEARING_NOISE);
        return placementModifiers;
    }


    public static List<PlacementModifier> oceanFloorSquaredWithCount(int $$0, PlacementModifier... modifiers) {
        return oceanFloorSquaredWithCountAndMaxDepth($$0, OptionalInt.empty(), modifiers);
    }

    public static List<PlacementModifier> oceanFloorSquaredWithCountAndMaxDepth(int $$0, OptionalInt maxDepth, PlacementModifier... modifiers) {
        ArrayList<PlacementModifier> placementModifiers = new ArrayList<>(List.of(CountPlacement.of($$0), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome()));
        if (maxDepth.isPresent()) {
            placementModifiers.add(SurfaceWaterDepthFilter.forMaxDepth(maxDepth.getAsInt()));
        }
        placementModifiers.addAll(Arrays.asList(modifiers));
        return placementModifiers;
    }


    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeature(String id, Holder<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
        return createPlacedFeature(id, feature, List.of(placementModifiers));
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeature(String id, Holder<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
        ResourceLocation bygID = BYG.createLocation(id);
        if (BuiltinRegistries.PLACED_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Placed Feature ID: \"" + bygID.toString() + "\" already exists in the Placed Features registry!");

        return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, bygID, new PlacedFeature(Holder.hackyErase(feature), List.copyOf(placementModifiers)));
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeature(Holder<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
        return createPlacedFeature(feature, List.of(placementModifiers));
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeature(Holder<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
        return Holder.direct(new PlacedFeature(Holder.hackyErase(feature), List.copyOf(placementModifiers)));
    }
}
