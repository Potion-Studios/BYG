package potionstudios.byg.common.world.feature.placement;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import potionstudios.byg.BYG;
import potionstudios.byg.reg.RegistrationProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Supplier;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;

public class BYGPlacedFeaturesUtil {
    public static final NoiseThresholdCountPlacement CLEARING_NOISE = NoiseThresholdCountPlacement.of(0.545, 1, 0);
    public static final RegistrationProvider<PlacedFeature> PLACED_FEATURES = RegistrationProvider.get(BuiltinRegistries.PLACED_FEATURE, BYG.MOD_ID);

    public static List<PlacementModifier> treePlacementBaseOceanFloor(PlacementModifier... $$0) {
        return treePlacementBaseOceanFloor(OptionalInt.empty(), $$0);
    }

    public static List<PlacementModifier> treePlacementBaseOceanFloor(OptionalInt maxDepth, PlacementModifier... $$0) {
        ImmutableList.Builder<PlacementModifier> placementModifierBuilder = ImmutableList.<PlacementModifier>builder().add($$0).add(InSquarePlacement.spread()).add(PlacementUtils.HEIGHTMAP_TOP_SOLID).add(BiomeFilter.biome());
        if (maxDepth.isPresent()) {
            placementModifierBuilder.add(SurfaceWaterDepthFilter.forMaxDepth(maxDepth.getAsInt()));
        }
        return placementModifierBuilder.build();
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


    @SafeVarargs
    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeature(String id, Holder<ConfiguredFeature<FC, ?>> feature, Supplier<PlacementModifier>... placementModifiers) {
        return createPlacedFeature(id, feature, () -> Arrays.stream(placementModifiers).map(Supplier::get).toList());
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeature(String id, Holder<ConfiguredFeature<FC, ?>> feature, Supplier<List<PlacementModifier>> placementModifiers) {
        return PLACED_FEATURES.register(id, () -> new PlacedFeature(Holder.hackyErase(feature), placementModifiers.get())).asHolder();
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeatureDirect(Holder<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
        return createPlacedFeatureDirect(feature, List.of(placementModifiers));
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeatureDirect(Holder<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
        return Holder.direct(new PlacedFeature(Holder.hackyErase(feature), List.copyOf(placementModifiers)));
    }


    public static String globalFeaturePath(String path) {
        return "global/placed_feature/" + path;
    }
}
