package potionstudios.byg.common.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.VegetationPlacementsAccess;

import java.util.ArrayList;
import java.util.List;

public class BYGPlacedFeatures {

    public static final PlacedFeature ALLIUM_FIELD_FLOWERS = createPlacedFeature("allium_field_flowers", BYGConfiguredFeatures.ALLIUM_FIELD_FLOWERS.placed(VegetationPlacements.worldSurfaceSquaredWithCount(20)));
    public static final PlacedFeature AMARANTH_FIELD_FLOWERS = createPlacedFeature("amaranth_field_flowers", BYGConfiguredFeatures.AMARANTH_FIELD_FLOWERS.placed(VegetationPlacements.worldSurfaceSquaredWithCount(20)));

    public static final PlacedFeature FIRECRACKER_BUSH = createPlacedFeature("firecracker_bush", BYGConfiguredFeatures.FIRECRACKER_BUSH.placed(VegetationPlacements.worldSurfaceSquaredWithCount(3)));
    public static final PlacedFeature SHORT_GRASS = createPlacedGroundVegetationFeature("short_grass", BYGConfiguredFeatures.SHORT_GRASS_PATCH);
    public static final PlacedFeature BYG_GRASS = createPlacedFeature("grass", BYGConfiguredFeatures.BYG_GRASS_EXTRA.placed(VegetationPlacements.worldSurfaceSquaredWithCount(8)));
    public static final PlacedFeature BLUE_BERRY_BUSH = createPlacedFeature("blue_berry_bush", BYGConfiguredFeatures.BYG_GRASS_EXTRA.placed(VegetationPlacements.worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature LEAF_PILES = createPlacedFeature("leaf_piles", BYGConfiguredFeatures.LEAF_PILE.placed(VegetationPlacements.worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature CLOVER_FLOWERS = createPlacedFeature("clover_flower_patch", BYGConfiguredFeatures.CLOVER_PATCH.placed(VegetationPlacements.worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature CROCUS = createPlacedFeature("crocus", BYGConfiguredFeatures.CROCUS.placed(VegetationPlacements.worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature ANEMONES = createPlacedFeature("anemones", BYGConfiguredFeatures.ANEMONES.placed(VegetationPlacements.worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature ROSES = createPlacedFeature("rose", BYGConfiguredFeatures.ROSE.placed(VegetationPlacements.worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature DAISY_ORANGE = createPlacedFeature("orange_daisy", BYGConfiguredFeatures.DAISY_ORANGE.placed(VegetationPlacements.worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature IRIS = createPlacedFeature("iris", BYGConfiguredFeatures.IRIS.placed(VegetationPlacements.worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature DAFFODIL_YELLOW = createPlacedFeature("yellow_daffodil", BYGConfiguredFeatures.DAFFODIL_YELLOW.placed(VegetationPlacements.worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature LARGE_PUMPKINS = createPlacedFeature("large_pumpkins", BYGConfiguredFeatures.LARGE_PUMPKINS.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1))));

    public static final PlacedFeature MUSHROOMS = createPlacedFeature("mushrooms", BYGConfiguredFeatures.MUSHROOMS.placed(VegetationPlacementsAccess.invokeGetMushroomPlacement(512, null)));
    public static final PlacedFeature ARAUCARIA_TREES = createPlacedFeature("araucaria_trees", BYGConfiguredFeatures.ARAUCARIA_TREES.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature ASPEN_SHRUBS = createPlacedFeature("aspen_shrubs", BYGConfiguredFeatures.ASPEN_SHRUBS.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));
    public static final PlacedFeature ASPEN_TREES = createPlacedFeature("aspen_trees", BYGConfiguredFeatures.ASPEN_TREES.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.25F, 3))));
    public static final PlacedFeature BAOBAB_TREES = createPlacedFeature("baobab_trees", BYGConfiguredFeatures.BAOBAB_TREES.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 1))));
    public static final PlacedFeature BOREAL_TREES = createPlacedFeature("boreal_trees", BYGConfiguredFeatures.BOREAL_TREES.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.2F, 2))));

    public static final PlacedFeature MEADOW_SHRUBS = createPlacedFeature("meadow_shrubs", BYGConfiguredFeatures.MEADOW_SHRUBS.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));

    public static final PlacedFeature SPARSE_RED_OAK_TREES = createPlacedFeature("sparse_red_oak_trees", BYGConfiguredFeatures.RED_OAK_TREES.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.2F, 1))));
    public static final PlacedFeature SPARSE_JACARANDA_TREES = createPlacedFeature("sparse_jacaranda_trees", BYGConfiguredFeatures.JACARANDA_TREES.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.2F, 2))));
    public static final PlacedFeature SPARSE_ARAUCARIA_TREES = createPlacedFeature("sparse_araucaria_trees", BYGConfiguredFeatures.ARAUCARIA_TREES.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.2F, 3))));

    public static PlacedFeature createPlacedGroundVegetationFeature(String id, ConfiguredFeature<?, ?> flowerConfiguredFeature, PlacementModifier... additionalModifiers) {
        List<PlacementModifier> spread = new ArrayList<>(List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        spread.addAll(List.of(additionalModifiers));
        return createPlacedFeature(id, flowerConfiguredFeature.placed(spread));
    }

    public static <PF extends PlacedFeature> PF createPlacedFeature(String id, PF placedFeature) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (BuiltinRegistries.PLACED_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Placed Feature ID: \"" + bygID.toString() + "\" already exists in the Placed Features registry!");

        Registry.register(BuiltinRegistries.PLACED_FEATURE, bygID, placedFeature);
        return placedFeature;
    }

    public static void bootStrap(){}
}
