package potionstudios.byg.common.world.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.placement.ChunkCoveringPlacement;
import potionstudios.byg.common.world.placement.NearWaterPlacementFilter;
import potionstudios.byg.mixin.access.VegetationPlacementsAccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;
import static net.minecraft.data.worldgen.placement.VegetationPlacements.worldSurfaceSquaredWithCount;

public class BYGPlacedFeatures {

    public static final PlacedFeature ALLIUM_FIELD_FLOWERS = createPlacedFeature("allium_field_flowers", BYGConfiguredFeatures.ALLIUM_FIELD_FLOWERS.placed(worldSurfaceSquaredWithCount(20)));
    public static final PlacedFeature PINK_ALLIUMS = createPlacedFeature("pink_alliums", BYGConfiguredFeatures.ALLIUM_PINK.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature AMARANTH_FIELD_FLOWERS = createPlacedFeature("amaranth_field_flowers", BYGConfiguredFeatures.AMARANTH_FIELD_FLOWERS.placed(worldSurfaceSquaredWithCount(20)));

    public static final PlacedFeature SHRUB = createPlacedFeature("shrub", BYGConfiguredFeatures.SHRUB.placed(worldSurfaceSquaredWithCount(1)));

    public static final PlacedFeature FIRECRACKER_BUSH = createPlacedFeature("firecracker_bush", BYGConfiguredFeatures.FIRECRACKER_BUSH.placed(worldSurfaceSquaredWithCount(3)));
    public static final PlacedFeature BLUE_BERRY_BUSH = createPlacedFeature("blue_berry_bush", BYGConfiguredFeatures.BYG_GRASS_EXTRA.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature BLUE_BERRY_BUSH_LUSH = createPlacedFeature("blue_berry_bush_lush", BYGConfiguredFeatures.BYG_GRASS_EXTRA.placed(worldSurfaceSquaredWithCount(5)));

    public static final PlacedFeature CATTAIL = createPlacedFeature("cattails", BYGConfiguredFeatures.CATTAIL.placed(oceanFloorSquaredWithCountAndMaxDepth(25, OptionalInt.of(2))));
    public static final PlacedFeature LEATHER_FLOWERS = createPlacedFeature("leather_flowers", BYGConfiguredFeatures.LEATHER_FLOWERS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature LEAF_PILES = createPlacedFeature("leaf_piles", BYGConfiguredFeatures.LEAF_PILE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature LOLLIPOP_FLOWERS = createPlacedFeature("lollipop_flowers", BYGConfiguredFeatures.LOLLIPOP_FLOWER.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature CLOVER_FLOWERS = createPlacedFeature("clover_flower_patch", BYGConfiguredFeatures.CLOVER_PATCH.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature CROCUS = createPlacedFeature("crocus", BYGConfiguredFeatures.CROCUS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature ANEMONES = createPlacedFeature("anemones", BYGConfiguredFeatures.ANEMONES.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature ALPINE_BELLFLOWER = createPlacedFeature("alpine_bellflower", BYGConfiguredFeatures.ALPINE_BELLFLOWER.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature ROSES = createPlacedFeature("rose", BYGConfiguredFeatures.ROSE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature BLACK_ROSE = createPlacedFeature("black_rose", BYGConfiguredFeatures.BLACK_ROSE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature CYAN_ROSE = createPlacedFeature("cyan_rose", BYGConfiguredFeatures.CYAN_ROSE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature KOVAN_FLOWERS = createPlacedFeature("kovan_flowers", BYGConfiguredFeatures.KOVAN_FLOWER.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature DAISY_ORANGE = createPlacedFeature("orange_daisy", BYGConfiguredFeatures.DAISY_ORANGE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature JAPANESE_ORCHID = createPlacedFeature("japanese_orchid", BYGConfiguredFeatures.JAPANESE_ORCHID.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature FOXGLOVES = createPlacedFeature("foxgloves", BYGConfiguredFeatures.FOXGLOVE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature FAIRY_SLIPPER = createPlacedFeature("fairy_slipper", BYGConfiguredFeatures.FAIRY_SLIPPER.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature CHERRY_FOLIAGE = createPlacedFeature("cherry_foliage", BYGConfiguredFeatures.CHERRY_FOLIAGE.placed(worldSurfaceSquaredWithCount(6)));
    public static final PlacedFeature WINTER_ROSES = createPlacedFeature("winter_roses", BYGConfiguredFeatures.ROSE_WINTER.placed(worldSurfaceSquaredWithCount(6)));
    public static final PlacedFeature HORSEWEED = createPlacedFeature("horseweed", BYGConfiguredFeatures.HORSEWEED.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature PRAIRIE_GRASS = createPlacedFeature("prairie_grass", BYGConfiguredFeatures.PRAIRIE_GRASS.placed(CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    public static final PlacedFeature IRIS = createPlacedFeature("iris", BYGConfiguredFeatures.IRIS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature TULIPS = createPlacedFeature("tulips", BYGConfiguredFeatures.TULIPS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature WHITE_PUFFBALL = createPlacedFeature("white_puffball", BYGConfiguredFeatures.WHITE_PUFFBALL.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature SAGES = createPlacedFeature("sages", BYGConfiguredFeatures.SAGES.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature HYDRANGEAS = createPlacedFeature("hydrangeas", BYGConfiguredFeatures.HYDRANGEAS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature DESERT_VEGETATION = createPlacedFeature("desert_vegetation", BYGConfiguredFeatures.DESERT_VEGETATION.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature LUSH_DESERT_VEGETATION = createPlacedFeature("lush_desert_vegetation", BYGConfiguredFeatures.DESERT_VEGETATION.placed(worldSurfaceSquaredWithCount(10)));
    public static final PlacedFeature PATCH_BEACH_GRASS_NOISE = createPlacedFeature("patch_beach_grass_noise", BYGConfiguredFeatures.BEACH_GRASS.placed(NoiseThresholdCountPlacement.of(-0.45D, 7, 0), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    public static final PlacedFeature WINTER_SUCCULENT = createPlacedFeature("winter_succulent", BYGConfiguredFeatures.WINTER_SUCCULENT.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature DAFFODIL_YELLOW = createPlacedFeature("yellow_daffodil", BYGConfiguredFeatures.DAFFODIL_YELLOW.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature JUNGLE_FLOWERS = createPlacedFeature("jungle_flowers", BYGConfiguredFeatures.JUNGLE_FLOWERS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature LARGE_PUMPKINS = createPlacedFeature("large_pumpkins", BYGConfiguredFeatures.LARGE_PUMPKINS.placed(treePlacement(PlacementUtils.countExtra(1, 0.25F, 1))));
    public static final PlacedFeature SWAMP_WATER_VEGETATION = createPlacedFeature("swamp_water_vegetation", BYGConfiguredFeatures.SWAMP_WATER_VEGETATION.placed(worldSurfaceSquaredWithCount(25)));

    public static final PlacedFeature MUSHROOMS = createPlacedFeature("mushrooms", BYGConfiguredFeatures.MUSHROOMS.placed(VegetationPlacementsAccess.invokeGetMushroomPlacement(512, null)));
    public static final PlacedFeature ARAUCARIA_TREES = createPlacedFeature("araucaria_trees", BYGConfiguredFeatures.ARAUCARIA_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature ASPEN_SHRUBS = createPlacedFeature("aspen_shrubs", BYGConfiguredFeatures.ASPEN_SHRUBS.placed(treePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));
    public static final PlacedFeature ASPEN_TREES = createPlacedFeature("aspen_trees", BYGConfiguredFeatures.ASPEN_TREES.placed(treePlacement(PlacementUtils.countExtra(6, 0.25F, 3))));
    public static final PlacedFeature ASPEN_TREES_SPARSE = createPlacedFeature("aspen_trees_sparse", BYGConfiguredFeatures.ASPEN_TREES.placed(treePlacement(PlacementUtils.countExtra(0, 0.25F, 1))));
    public static final PlacedFeature BAOBAB_TREES = createPlacedFeature("baobab_trees", BYGConfiguredFeatures.BAOBAB_TREES.placed(treePlacement(PlacementUtils.countExtra(0, 0.25F, 1))));
    public static final PlacedFeature BOREAL_TREES = createPlacedFeature("boreal_trees", BYGConfiguredFeatures.BOREAL_TREES.placed(treePlacement(PlacementUtils.countExtra(4, 0.2F, 2))));
    public static final PlacedFeature BAYOU_TREES = createPlacedFeature("bayou_trees", BYGConfiguredFeatures.BAYOU_TREES.placed(treePlacementBaseOceanFloor(PlacementUtils.countExtra(4, 0.2F, 2))));
    public static final PlacedFeature BLACK_FOREST_TREES = createPlacedFeature("black_forest_trees", BYGConfiguredFeatures.BLACK_FOREST_TREES.placed(treePlacement(PlacementUtils.countExtra(8, 0.2F, 2))));
    public static final PlacedFeature CANADIAN_SHIELD_TREES = createPlacedFeature("canadian_shield_trees", BYGConfiguredFeatures.CANADIAN_SHIELD_TREES.placed(treePlacement(PlacementUtils.countExtra(4, 0.25F, 2))));
    public static final PlacedFeature CHERRY_TREES = createPlacedFeature("cherry_trees", BYGConfiguredFeatures.CHERRY_TREES.placed(treePlacement(PlacementUtils.countExtra(6, 0.25F, 2))));
    public static final PlacedFeature CIKA_TREES = createPlacedFeature("cika_trees", BYGConfiguredFeatures.CIKA_TREES.placed(treePlacement(PlacementUtils.countExtra(2, 0.25F, 2))));
    public static final PlacedFeature CONIFER_TREES = createPlacedFeature("conifer_trees", BYGConfiguredFeatures.CONIFER_TREES.placed(treePlacement(PlacementUtils.countExtra(7, 0.25F, 3))));
    public static final PlacedFeature CYPRESS_TREES = createPlacedFeature("cypress_trees", BYGConfiguredFeatures.CYPRESS_TREES.placed(treePlacementBaseOceanFloor(PlacementUtils.countExtra(4, 0.25F, 1))));
    public static final PlacedFeature DACITE_RIDGE_TREES = createPlacedFeature("dacite_ridge_trees", BYGConfiguredFeatures.DACITE_RIDGE_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature DECIDUOUS_TREES = createPlacedFeature("deciduous_trees", BYGConfiguredFeatures.DECIDUOUS_TREES.placed(treePlacement(PlacementUtils.countExtra(3, 0.25F, 2))));
    public static final PlacedFeature EBONY_TREES = createPlacedFeature("ebony_trees", BYGConfiguredFeatures.EBONY_TREES.placed(treePlacement(PlacementUtils.countExtra(4, 0.25F, 4))));
    public static final PlacedFeature ENCHANTED_TREES = createPlacedFeature("enchanted_trees", BYGConfiguredFeatures.ENCHANTED_TREES.placed(treePlacement(PlacementUtils.countExtra(5, 0.2F, 2))));
    public static final PlacedFeature TEMPERATE_GROVE_TREES = createPlacedFeature("temperate_grove_trees", BYGConfiguredFeatures.TEMPERATE_GROVE_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature JACARANDA_TREES = createPlacedFeature("jacaranda_trees", BYGConfiguredFeatures.JACARANDA_TREES.placed(treePlacement(PlacementUtils.countExtra(4, 0.2F, 2))));
    public static final PlacedFeature JACARANDA_BUSHES = createPlacedFeature("jacaranda_bushes", BYGConfiguredFeatures.JACARANDA_BUSHES.placed(treePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature JOSHUA_TREES = createPlacedFeature("joshua_tree", BYGConfiguredFeatures.JOSHUA_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.2F, 2))));
    public static final PlacedFeature MANGROVE_TREES = createPlacedFeature("mangrove_trees", BYGConfiguredFeatures.MANGROVE_TREES.placed(treePlacementBaseOceanFloor(PlacementUtils.countExtra(6, 0.25F, 2))));
    public static final PlacedFeature MAPLE_TREES = createPlacedFeature("maple_trees", BYGConfiguredFeatures.MAPLE_TREES.placed(treePlacement(PlacementUtils.countExtra(4, 0.25F, 2))));
    public static final PlacedFeature NORTHERN_FOREST_TREES = createPlacedFeature("northern_forest_trees", BYGConfiguredFeatures.NORTHERN_FOREST_TREES.placed(treePlacement(PlacementUtils.countExtra(3, 0.25F, 3))));
    public static final PlacedFeature ORCHARD_TREES = createPlacedFeature("orchard_trees", BYGConfiguredFeatures.ORCHARD_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature HOLLY_TREES = createPlacedFeature("holly_trees", BYGConfiguredFeatures.HOLLY_TREES.placed(treePlacement(PlacementUtils.countExtra(4, 0.25F, 4))));
    public static final PlacedFeature HAZEL_TREES = createPlacedFeature("hazel_trees", BYGConfiguredFeatures.HAZEL_TREES.placed(treePlacement(PlacementUtils.countExtra(6, 0.25F, 4))));
    public static final PlacedFeature SPARSE_OAK_TREES = createPlacedFeature("sparse_oak_trees", BYGConfiguredFeatures.OAK_TREES.placed(treePlacement(PlacementUtils.countExtra(0, 0.1F, 1))));
    public static final PlacedFeature OAK_TREES = createPlacedFeature("oak_trees", BYGConfiguredFeatures.OAK_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature PALO_VERDE_TREES = createPlacedFeature("palo_verde_trees", BYGConfiguredFeatures.PALO_VERDE_TREES.placed(treePlacement(PlacementUtils.countExtra(0, 0.2F, 1))));
    public static final PlacedFeature PALM_TREES = createPlacedFeature("palm_trees", BYGConfiguredFeatures.PALM_TREES.placed(Util.make(new ArrayList<>(treePlacement(PlacementUtils.countExtra(4, 0.2F, 1), BYGBlocks.PALM_SAPLING)), (list) -> {
        list.add(new NearWaterPlacementFilter(4));
    })));
    public static final PlacedFeature RED_OAK_TREES = createPlacedFeature("red_oak_trees", BYGConfiguredFeatures.RED_OAK_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature ORANGE_OAK_TREES = createPlacedFeature("orange_oak_trees", BYGConfiguredFeatures.ORANGE_OAK_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature BROWN_OAK_TREES = createPlacedFeature("brown_oak_trees", BYGConfiguredFeatures.BROWN_OAK_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature AUTUMNAL_OAK_TREES = createPlacedFeature("autumnal_oak_trees", BYGConfiguredFeatures.AUTUMNAL_OAK_TREES.placed(treePlacement(PlacementUtils.countExtra(4, 0.2F, 1))));
    public static final PlacedFeature AUTUMNAL_SPRUCE_TREES = createPlacedFeature("autumnal_spruce_trees", BYGConfiguredFeatures.AUTUMNAL_SPRUCE_TREES.placed(treePlacement(PlacementUtils.countExtra(4, 0.2F, 1))));
    public static final PlacedFeature PRAIRIE_SHRUBS = createPlacedFeature("prairie_shrubs", BYGConfiguredFeatures.PRAIRIE_SHRUBS.placed(treePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));
    public static final PlacedFeature GUIANA_SHIELD_TREES = createPlacedFeature("guiana_shield_trees", BYGConfiguredFeatures.GUIANA_SHIELD_TREES.placed(treePlacement(PlacementUtils.countExtra(15, 0.25F, 1))));
    public static final PlacedFeature RAINFOREST_TREES = createPlacedFeature("rainforest_trees", BYGConfiguredFeatures.RAINFOREST_TREES.placed(treePlacement(PlacementUtils.countExtra(15, 0.25F, 1))));
    public static final PlacedFeature REDWOOD_TREES = createPlacedFeature("redwood_trees", BYGConfiguredFeatures.REDWOOD_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature FRAGMENT_FOREST_TREES = createPlacedFeature("fragment_forest_trees", BYGConfiguredFeatures.FRAGMENT_FOREST_TREES.placed(treePlacement(PlacementUtils.countExtra(2, 0.25F, 2))));
    public static final PlacedFeature SKYRIS_TREES = createPlacedFeature("skyris_trees", BYGConfiguredFeatures.SKYRIS_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature RED_SPRUCE_TREES_SPARSE = createPlacedFeature("sparse_red_spruce_trees", BYGConfiguredFeatures.RED_SPRUCE_TREES.placed(treePlacement(PlacementUtils.countExtra(0, 0.25F, 1))));
    public static final PlacedFeature BLUE_SPRUCE_TREES = createPlacedFeature("blue_spruce_trees", BYGConfiguredFeatures.BLUE_SPRUCE_TREES.placed(treePlacement(PlacementUtils.countExtra(2, 0.1F, 1))));
    public static final PlacedFeature SPRUCE_TREES_SPARSE = createPlacedFeature("sparse_spruce_trees", BYGConfiguredFeatures.SPRUCE_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature BROWN_ZELKOVA_TREES = createPlacedFeature("brown_zelkova_trees", BYGConfiguredFeatures.BROWN_ZELKOVA_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature ZELKOVA_TREES = createPlacedFeature("zelkova_trees", BYGConfiguredFeatures.ZELKOVA_TREES.placed(treePlacement(PlacementUtils.countExtra(5, 0.2F, 2))));
    public static final PlacedFeature TEMPERATE_RAINFOREST_TREES = createPlacedFeature("temperate_rainforest_trees", BYGConfiguredFeatures.TEMPERATE_RAINFOREST_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.25F, 1))));
    public static final PlacedFeature MEADOW_TREES = createPlacedFeature("meadow_trees", BYGConfiguredFeatures.MEADOW_TREES.placed(treePlacement(PlacementUtils.countExtra(2, 0.25F, 3))));
    public static final PlacedFeature MEADOW_TREES_SPARSE = createPlacedFeature("sparse_meadow_trees", BYGConfiguredFeatures.MEADOW_TREES.placed(treePlacement(PlacementUtils.countExtra(0, 0.25F, 1))));
    public static final PlacedFeature LARGE_BOULDERS = createPlacedFeature("large_boulders", BYGConfiguredFeatures.LARGE_BOULDER.placed(oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(2))));
    public static final PlacedFeature LARGE_GRANITE_BOULDERS = createPlacedFeature("large_granite_boulders", BYGConfiguredFeatures.LARGE_GRANITE_BOULDER.placed(oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(2))));
    public static final PlacedFeature LARGE_WINDSWEPT_BOULDERS = createPlacedFeature("large_windswept_boulders", BYGConfiguredFeatures.LARGE_WINDSWEPT_BOULDER.placed(oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(4), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlock(BYGBlocks.WINDSWEPT_SAND, new BlockPos(0, -1, 0))), RandomOffsetPlacement.vertical(BiasedToBottomInt.of(-4, -3)))));
    public static final PlacedFeature ROSE_FIELD_FLOWERS = createPlacedFeature("rose_field_flowers", BYGConfiguredFeatures.ROSE_FIELD_FLOWERS.placed(worldSurfaceSquaredWithCount(20)));
    public static final PlacedFeature FROST_MAGMA_LAKE = createPlacedFeature("frost_magma_lake", BYGConfiguredFeatures.FROST_MAGMA_LAKE.placed(worldSurfaceSquaredWithCount(3)));

    public static final PlacedFeature SPARSE_HUGE_MUSHROOMS = createPlacedFeature("sparse_huge_mushrooms", BYGConfiguredFeatures.HUGE_MUSHROOMS.placed(treePlacement(PlacementUtils.countExtra(0, 0.2F, 2))));
    public static final PlacedFeature HUGE_MUSHROOMS = createPlacedFeature("huge_mushrooms", BYGConfiguredFeatures.HUGE_MUSHROOMS.placed(treePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));

    public static final PlacedFeature MEADOW_SHRUBS = createPlacedFeature("meadow_shrubs", BYGConfiguredFeatures.MEADOW_SHRUBS.placed(treePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));
    public static final PlacedFeature FIRECRACKER_SHRUBS = createPlacedFeature("firecracker_shrubs", BYGConfiguredFeatures.FIRECRACKER_SHRUBS.placed(treePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));

    public static final PlacedFeature SPARSE_RED_OAK_TREES = createPlacedFeature("sparse_red_oak_trees", BYGConfiguredFeatures.RED_OAK_TREES.placed(treePlacement(PlacementUtils.countExtra(0, 0.2F, 1))));

    public static final PlacedFeature SPARSE_JACARANDA_TREES = createPlacedFeature("sparse_jacaranda_trees", BYGConfiguredFeatures.JACARANDA_TREES.placed(treePlacement(PlacementUtils.countExtra(0, 0.2F, 2))));
    public static final PlacedFeature SPARSE_ARAUCARIA_TREES = createPlacedFeature("sparse_araucaria_trees", BYGConfiguredFeatures.ARAUCARIA_TREES.placed(treePlacement(PlacementUtils.countExtra(0, 0.2F, 3))));

    public static final PlacedFeature DISK_MUD = createPlacedFeature("disk_mud", BYGConfiguredFeatures.DISK_MUD.placed(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome()));

    public static final PlacedFeature MOSSY_STONE_BOULDER = createPlacedFeature("mossy_stone_boulder", BYGConfiguredFeatures.MOSSY_STONE_BOULDER.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final PlacedFeature BEEHIVES = createPlacedFeature("beehives", BYGConfiguredFeatures.BEEHIVES.placed(CountPlacement.of(2), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature ROCKY_STONE_BOULDER = createPlacedFeature("rocky_stone_boulder", BYGConfiguredFeatures.ROCKY_STONE_BOULDER.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final PlacedFeature BLACKSTONE_BOULDER = createPlacedFeature("blackstone_boulder", BYGConfiguredFeatures.BLACKSTONE_BOULDER.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final PlacedFeature ORANGE_TERRACOTTA_BOULDER = createPlacedFeature("orange_terracotta_boulder", BYGConfiguredFeatures.ORANGE_TERRACOTTA_BOULDER.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final PlacedFeature BLACK_ICE_SNOW = createPlacedFeature("black_ice_snow", BYGConfiguredFeatures.BLACK_ICE.placed(ChunkCoveringPlacement.INSTANCE, PlacementUtils.HEIGHTMAP_WORLD_SURFACE, RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlock(Blocks.WATER, BlockPos.ZERO)), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlock(Blocks.AIR, new BlockPos(0, 1, 0)))));
    public static final PlacedFeature STONE_FOREST_COLUMN = createPlacedFeature("stone_forest_column", BYGConfiguredFeatures.STONE_FOREST_COLUMN.placed(oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(2))));
    public static final PlacedFeature LARGE_WINDSWEPT_LAKE = createPlacedFeature("large_windswept_lake", BYGConfiguredFeatures.LARGE_WINDSWEPT_LAKE.placed(Util.make(new ArrayList<>(worldSurfaceSquaredWithCount(1)), list -> list.addAll(List.of(RarityFilter.onAverageOnceEvery(12), BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.anyOf(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0))))))))));

    public static final PlacedFeature DEAD_SEA_SPIKES = createPlacedFeature("dead_sea_spikes", BYGConfiguredFeatures.DEAD_SEA_SPIKES.placed(oceanFloorSquaredWithCount(3)));
    public static final PlacedFeature WINDSWEPT_SPIKES = createPlacedFeature("windswept_spikes", BYGConfiguredFeatures.WINDSWEPT_SPIKES.placed(NoiseThresholdCountPlacement.of(0.6, 0, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.anyOf(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0))))), BiomeFilter.biome()));

    private static List<PlacementModifier> treePlacementBaseOceanFloor(PlacementModifier $$0) {
        return ImmutableList.<PlacementModifier>builder().add($$0).add(InSquarePlacement.spread()).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome()).build();
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


    public static <PF extends PlacedFeature> PF createPlacedFeature(String id, PF placedFeature) {
        ResourceLocation bygID = BYG.createLocation(id);
        if (BuiltinRegistries.PLACED_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Placed Feature ID: \"" + bygID.toString() + "\" already exists in the Placed Features registry!");

        Registry.register(BuiltinRegistries.PLACED_FEATURE, bygID, placedFeature);
        return placedFeature;
    }
}
