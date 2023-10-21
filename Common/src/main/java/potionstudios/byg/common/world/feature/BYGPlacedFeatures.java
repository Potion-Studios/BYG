package potionstudios.byg.common.world.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.world.feature.features.BYGGlobalFeatures;
import potionstudios.byg.common.world.feature.features.end.BYGEndFeatures;
import potionstudios.byg.common.world.feature.features.end.BYGEndVegetationFeatures;
import potionstudios.byg.common.world.feature.features.nether.BYGNetherFeatures;
import potionstudios.byg.common.world.feature.features.nether.BYGNetherVegetationFeatures;
import potionstudios.byg.common.world.feature.features.overworld.BYGOverworldFeatures;
import potionstudios.byg.common.world.feature.features.overworld.BYGOverworldTreeFeatures;
import potionstudios.byg.common.world.feature.features.overworld.BYGOverworldVegetationFeatures;
import potionstudios.byg.common.world.placement.AboveHeightmapFilter;
import potionstudios.byg.common.world.placement.ChunkCoveringPlacement;
import potionstudios.byg.common.world.placement.NearWaterPlacementFilter;
import potionstudios.byg.mixin.access.VegetationPlacementsAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;
import static net.minecraft.data.worldgen.placement.VegetationPlacements.worldSurfaceSquaredWithCount;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.globalGenStagePath;
import static potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil.*;
import static potionstudios.byg.mixin.access.OrePlacementsAccess.byg_invokeCommonOrePlacement;

public class BYGPlacedFeatures {

    public static final ResourceKey<PlacedFeature> GLOBAL_RAW_GENERATION = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.RAW_GENERATION), BYGGlobalFeatures.GLOBAL_RAW_GENERATION);
    public static final ResourceKey<PlacedFeature> GLOBAL_LAKES = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.LAKES), BYGGlobalFeatures.GLOBAL_LAKES);
    public static final ResourceKey<PlacedFeature> GLOBAL_LOCAL_MODIFICATIONS = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.LOCAL_MODIFICATIONS), BYGGlobalFeatures.GLOBAL_LOCAL_MODIFICATIONS);
    public static final ResourceKey<PlacedFeature> GLOBAL_UNDERGROUND_STRUCTURES = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.UNDERGROUND_STRUCTURES), BYGGlobalFeatures.GLOBAL_UNDERGROUND_STRUCTURES);
    public static final ResourceKey<PlacedFeature> GLOBAL_SURFACE_STRUCTURES = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.SURFACE_STRUCTURES), BYGGlobalFeatures.GLOBAL_SURFACE_STRUCTURES);
    public static final ResourceKey<PlacedFeature> GLOBAL_STRONGHOLDS = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.STRONGHOLDS), BYGGlobalFeatures.GLOBAL_STRONGHOLDS);
    public static final ResourceKey<PlacedFeature> GLOBAL_UNDERGROUND_ORES = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.UNDERGROUND_ORES), BYGGlobalFeatures.GLOBAL_UNDERGROUND_ORES);
    public static final ResourceKey<PlacedFeature> GLOBAL_UNDERGROUND_DECORATION = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.UNDERGROUND_DECORATION), BYGGlobalFeatures.GLOBAL_UNDERGROUND_DECORATION);
    public static final ResourceKey<PlacedFeature> GLOBAL_FLUID_SPRINGS = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.FLUID_SPRINGS), BYGGlobalFeatures.GLOBAL_FLUID_SPRINGS);
    public static final ResourceKey<PlacedFeature> GLOBAL_VEGETAL_DECORATION = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.VEGETAL_DECORATION), BYGGlobalFeatures.GLOBAL_VEGETAL_DECORATION);
    public static final ResourceKey<PlacedFeature> GLOBAL_TOP_LAYER_MODIFICATION = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.TOP_LAYER_MODIFICATION), BYGGlobalFeatures.GLOBAL_TOP_LAYER_MODIFICATION);


    public static final NoiseThresholdCountPlacement CRAG_NOISE = NoiseThresholdCountPlacement.of(0, 1, 0);

    public static final NoiseThresholdCountPlacement DENSE_NOISE = NoiseThresholdCountPlacement.of(-0.545, 1, 2);
    public static final NoiseThresholdCountPlacement LUSH_STACKS_SPIKES_NOISE = NoiseThresholdCountPlacement.of(0.545, 1, 0);


    public static final ResourceKey<PlacedFeature> ALLIUM_FIELD_FLOWERS = createPlacedFeature("allium_field_flowers", BYGOverworldVegetationFeatures.ALLIUM_FIELD_FLOWERS, () -> worldSurfaceSquaredWithCount(20));
    public static final ResourceKey<PlacedFeature> PINK_ALLIUMS = createPlacedFeature("pink_alliums", BYGOverworldVegetationFeatures.ALLIUM_PINK, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> AMARANTH_FIELD_FLOWERS = createPlacedFeature("amaranth_field_flowers", BYGOverworldVegetationFeatures.AMARANTH_FIELD_FLOWERS, () -> worldSurfaceSquaredWithCount(20));
    public static final ResourceKey<PlacedFeature> DUNE_TERRAIN = createPlacedFeature("dune_terrain", BYGOverworldVegetationFeatures.DUNE_TERRAIN);

    public static final ResourceKey<PlacedFeature> SHRUB = createPlacedFeature("shrub", BYGOverworldVegetationFeatures.SHRUB, () -> worldSurfaceSquaredWithCount(1));

    public static final ResourceKey<PlacedFeature> FIRECRACKER_BUSH = createPlacedFeature("firecracker_bush", BYGOverworldVegetationFeatures.FIRECRACKER_BUSH, () -> worldSurfaceSquaredWithCount(3));
    public static final ResourceKey<PlacedFeature> BLUE_BERRY_BUSH = createPlacedFeature("blue_berry_bush", BYGOverworldVegetationFeatures.PATCH_BLUEBERRY, () -> RarityFilter.onAverageOnceEvery(32), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> BLUE_BERRY_BUSH_LUSH = createPlacedFeature("blue_berry_bush_lush", BYGOverworldVegetationFeatures.PATCH_BLUEBERRY, () -> RarityFilter.onAverageOnceEvery(24), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter::biome);

    public static final ResourceKey<PlacedFeature> CATTAIL = createPlacedFeature("cattails", BYGOverworldVegetationFeatures.CATTAIL, () -> oceanFloorSquaredWithCountAndMaxDepth(10, OptionalInt.of(2)));
    public static final ResourceKey<PlacedFeature> LUSH_CATTAIL = createPlacedFeature("lush_cattails", BYGOverworldVegetationFeatures.CATTAIL, () -> oceanFloorSquaredWithCountAndMaxDepth(16, OptionalInt.of(2)));
    public static final ResourceKey<PlacedFeature> LEATHER_FLOWERS = createPlacedFeature("leather_flowers", BYGOverworldVegetationFeatures.LEATHER_FLOWERS, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> LEAF_PILES = createPlacedFeature("leaf_piles", BYGOverworldVegetationFeatures.LEAF_PILE, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> LOLLIPOP_FLOWERS = createPlacedFeature("lollipop_flowers", BYGOverworldVegetationFeatures.LOLLIPOP_FLOWER, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> CLOVER_FLOWERS = createPlacedFeature("clover_flower_patch", BYGOverworldVegetationFeatures.CLOVER_AND_FLOWERS, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> CLOVER_PATCHES = createPlacedFeature("clover_patches", BYGOverworldVegetationFeatures.CLOVER_PATCH, () -> worldSurfaceSquaredWithCount(5));
    public static final ResourceKey<PlacedFeature> FLOWER_PATCHES = createPlacedFeature("flower_patches", BYGOverworldVegetationFeatures.FLOWER_PATCH, () -> worldSurfaceSquaredWithCount(5));
    public static final ResourceKey<PlacedFeature> CRYPTIC_BRAMBLE = createPlacedFeature("cryptic_bramble", BYGEndVegetationFeatures.CRYPTIC_BRAMBLE_PATCH, () -> new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(2)).build());
    public static final ResourceKey<PlacedFeature> CROCUS = createPlacedFeature("crocus", BYGOverworldVegetationFeatures.CROCUS, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> ANEMONES = createPlacedFeature("anemones", BYGOverworldVegetationFeatures.ANEMONES, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> MEADOW_GRASS = createPlacedFeature("meadow_grass", VegetationFeatures.PATCH_GRASS, () -> worldSurfaceSquaredWithCount(8));
    public static final ResourceKey<PlacedFeature> ALPINE_BELLFLOWER = createPlacedFeature("alpine_bellflower", BYGOverworldVegetationFeatures.ALPINE_BELLFLOWER, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> BLUE_ROSE_BUSH = createPlacedFeature("blue_rose_bush", BYGOverworldVegetationFeatures.BLUE_ROSE_BUSH, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> BLUE_ROSE_BUSH_LUSH = createPlacedFeature("blue_rose_bush_lush", BYGOverworldVegetationFeatures.BLUE_ROSE_BUSH, () -> worldSurfaceSquaredWithCount(6));
    public static final ResourceKey<PlacedFeature> ROSES = createPlacedFeature("rose", BYGOverworldVegetationFeatures.ROSE, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> BLACK_ROSE = createPlacedFeature("black_rose", BYGOverworldVegetationFeatures.BLACK_ROSE, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> BULBIS_ODDITIES = createPlacedFeature("bulbis_oddities", BYGEndVegetationFeatures.BULBIS_ODDITIES, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> BULBIS_SPROUTS = createPlacedFeature("bulbis_sprouts", BYGEndVegetationFeatures.BULBIS_SPROUTS, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> THEREAL_BELLFLOWER = createPlacedFeature("thereal_bellflower", BYGEndVegetationFeatures.THEREAL_BELLFLOWER, () -> worldSurfaceSquaredWithCount(6));
    public static final ResourceKey<PlacedFeature> IVIS_PLANTS = createPlacedFeature("ivis_plants", BYGEndVegetationFeatures.IVIS_PLANTS, () -> worldSurfaceSquaredWithCount(5));
    public static final ResourceKey<PlacedFeature> ETHER_PLANTS = createPlacedFeature("ether_plants", BYGEndVegetationFeatures.ETHER_PLANTS, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> ETHER_BULBS = createPlacedFeature("ether_bulbs", BYGEndVegetationFeatures.ETHER_BULB, () -> CountPlacement.of(UniformInt.of(15, 25)), () -> HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()));
    public static final ResourceKey<PlacedFeature> ENDER_LILY = createPlacedFeature("ender_lily", BYGEndVegetationFeatures.ENDER_LILY, () -> worldSurfaceSquaredWithCount(6));
    public static final ResourceKey<PlacedFeature> NIGHTSHADE_PLANTS = createPlacedFeature("nightshade_plants", BYGEndVegetationFeatures.NIGHTSHADE_PLANTS, () -> worldSurfaceSquaredWithCount(7));
    public static final ResourceKey<PlacedFeature> IMPARIUS_PLANTS = createPlacedFeature("imparius_plants", BYGEndVegetationFeatures.IMPARIUS_PLANTS, () -> worldSurfaceSquaredWithCount(12));
    public static final ResourceKey<PlacedFeature> SPARSE_BULBIS_ANOMALIES = createPlacedFeature("sparse_anomalies", BYGEndVegetationFeatures.BULBIS_ANOMALIES, () -> new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(1)).add(RarityFilter.onAverageOnceEvery(4)).build());
    public static final ResourceKey<PlacedFeature> BULBIS_ANOMALIES = createPlacedFeature("bulbis_anomalies", BYGEndVegetationFeatures.BULBIS_ANOMALIES, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> THERIUM_DEPOSIT = createPlacedFeature("therium_deposit", BYGEndFeatures.THERIUM_CRYSTAL_DEPOSIT_LARGE, () -> new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(1)).add(RarityFilter.onAverageOnceEvery(150)).add(BiomeFilter.biome()).build());
    public static final ResourceKey<PlacedFeature> CYAN_ROSE = createPlacedFeature("cyan_rose", BYGOverworldVegetationFeatures.CYAN_ROSE, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> CRYPTIC_FIRE = createPlacedFeature("cryptic_fire", BYGEndFeatures.CRYPTIC_FIRE_PATCH, () -> new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(2)).build());
    public static final ResourceKey<PlacedFeature> KOVAN_FLOWERS = createPlacedFeature("kovan_flowers", BYGOverworldVegetationFeatures.KOVAN_FLOWER, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> DAISY_ORANGE = createPlacedFeature("orange_daisy", BYGOverworldVegetationFeatures.DAISY_ORANGE, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> JAPANESE_ORCHID = createPlacedFeature("japanese_orchid", BYGOverworldVegetationFeatures.JAPANESE_ORCHID, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> FOXGLOVES = createPlacedFeature("foxgloves", BYGOverworldVegetationFeatures.FOXGLOVE, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> FAIRY_SLIPPER = createPlacedFeature("fairy_slipper", BYGOverworldVegetationFeatures.FAIRY_SLIPPER, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> CHERRY_FOLIAGE = createPlacedFeature("cherry_foliage", BYGOverworldVegetationFeatures.CHERRY_FOLIAGE, () -> worldSurfaceSquaredWithCount(9));
    public static final ResourceKey<PlacedFeature> WINTER_ROSES = createPlacedFeature("winter_roses", BYGOverworldVegetationFeatures.ROSE_WINTER, () -> worldSurfaceSquaredWithCount(3));
    public static final ResourceKey<PlacedFeature> HORSEWEED = createPlacedFeature("horseweed", BYGOverworldVegetationFeatures.HORSEWEED, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> PRAIRIE_GRASS = createPlacedFeature("prairie_grass", BYGOverworldVegetationFeatures.PRAIRIE_GRASS, () -> CountPlacement.of(25), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> BASALT_DELTA = createPlacedFeature("basalt_delta", BYGOverworldFeatures.BASALT_DELTA, () -> CountPlacement.of(1), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> LARGE_BASALT_COLUMN = createPlacedFeature("large_basalt_column", BYGOverworldFeatures.LARGE_BASALT_COLUMN, () -> CountPlacement.of(5), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> SMALL_BASALT_COLUMN = createPlacedFeature("small_basalt_column", BYGOverworldFeatures.SMALL_BASALT_COLUMN, () -> CountPlacement.of(3), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter::biome);

    public static final ResourceKey<PlacedFeature> IRIS = createPlacedFeature("iris", BYGOverworldVegetationFeatures.IRIS, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> TULIPS = createPlacedFeature("tulips", BYGOverworldVegetationFeatures.TULIPS, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> WHITE_PUFFBALL = createPlacedFeature("white_puffball", BYGOverworldVegetationFeatures.WHITE_PUFFBALL, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> SAGES = createPlacedFeature("sages", BYGOverworldVegetationFeatures.SAGES, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> HYDRANGEAS = createPlacedFeature("hydrangeas", BYGOverworldVegetationFeatures.HYDRANGEAS, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> DESERT_VEGETATION = createPlacedFeature("desert_vegetation", BYGOverworldVegetationFeatures.DESERT_VEGETATION, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> DESERT_VEGETATION_ATACAMA = createPlacedFeature("desert_vegetation_atacama", BYGOverworldVegetationFeatures.DESERT_VEGETATION_ATACAMA, () -> worldSurfaceSquaredWithCount(6));
    public static final ResourceKey<PlacedFeature> LUSH_DESERT_VEGETATION = createPlacedFeature("lush_desert_vegetation", BYGOverworldVegetationFeatures.DESERT_VEGETATION, () -> worldSurfaceSquaredWithCount(10));
    public static final ResourceKey<PlacedFeature> WINDSWEPT_DESERT_VEGETATION = createPlacedFeature("windswept_desert_vegetation", BYGOverworldVegetationFeatures.WINDSWEPT_DESERT_VEGETATION, () -> worldSurfaceSquaredWithCount(8));
    public static final ResourceKey<PlacedFeature> PATCH_BEACH_GRASS_NOISE = createPlacedFeature("patch_beach_grass_noise", BYGOverworldVegetationFeatures.BEACH_GRASSES, () -> NoiseThresholdCountPlacement.of(-0.45D, 7, 0), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> PATCH_BEACH_GRASS = createPlacedFeature("patch_beach_grass", BYGOverworldVegetationFeatures.BEACH_GRASSES, InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter::biome);

    public static final ResourceKey<PlacedFeature> WINTER_SUCCULENT = createPlacedFeature("winter_succulent", BYGOverworldVegetationFeatures.WINTER_SUCCULENT, () -> worldSurfaceSquaredWithCount(2));
    public static final ResourceKey<PlacedFeature> DAFFODIL_YELLOW = createPlacedFeature("yellow_daffodil", BYGOverworldVegetationFeatures.DAFFODIL_YELLOW, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> JUNGLE_FLOWERS = createPlacedFeature("jungle_flowers", BYGOverworldVegetationFeatures.JUNGLE_FLOWERS, () -> worldSurfaceSquaredWithCount(1));
    public static final ResourceKey<PlacedFeature> LARGE_PUMPKINS = createPlacedFeature("large_pumpkins", BYGOverworldVegetationFeatures.LARGE_PUMPKINS, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> SWAMP_WATER_VEGETATION = createPlacedFeature("swamp_water_vegetation", BYGOverworldVegetationFeatures.SWAMP_WATER_VEGETATION, () -> worldSurfaceSquaredWithCount(20));
    public static final ResourceKey<PlacedFeature> WHITE_MANGROVE_SWAMP_WATER_VEGETATION = createPlacedFeature("white_white_mangrove_swamp_water_vegetation", BYGOverworldVegetationFeatures.WHITE_MANGROVE_SWAMP_WATER_VEGETATION, () -> worldSurfaceSquaredWithCount(15));

    public static final ResourceKey<PlacedFeature> MUSHROOMS = createPlacedFeature("mushrooms", BYGOverworldVegetationFeatures.MUSHROOMS, () -> VegetationPlacementsAccess.byg_invokeGetMushroomPlacement(512, null));
    public static final ResourceKey<PlacedFeature> ARAUCARIA_TREES = createPlacedFeature("araucaria_trees", BYGOverworldTreeFeatures.ARAUCARIA_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> ASPEN_SHRUBS = createPlacedFeature("aspen_shrubs", BYGOverworldTreeFeatures.ASPEN_SHRUBS, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> ASPEN_TREES = createPlacedFeature("aspen_trees", BYGOverworldTreeFeatures.ASPEN_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(5, 0.25F, 3)));
    public static final ResourceKey<PlacedFeature> ASPEN_TREES_SPARSE = createPlacedFeature("aspen_trees_sparse", BYGOverworldTreeFeatures.ASPEN_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> BAOBAB_TREES = createPlacedFeature("baobab_trees", BYGOverworldTreeFeatures.BAOBAB_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> ORANGE_BIRCH_TREES = createPlacedFeature("orange_birch_trees", BYGOverworldTreeFeatures.ORANGE_BIRCH_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> YELLOW_BIRCH_TREES = createPlacedFeature("yellow_birch_trees", BYGOverworldTreeFeatures.YELLOW_BIRCH_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> BIRCH_TREES = createPlacedFeature("birch_trees", BYGOverworldTreeFeatures.BIRCH_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(5, 0.25F, 3)));
    public static final ResourceKey<PlacedFeature> SPARSE_BIRCH_TREES = createPlacedFeature("sparse_birch_trees", BYGOverworldTreeFeatures.BIRCH_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));


    public static final ResourceKey<PlacedFeature> NIGHTSHADE_TREES = createPlacedFeature("nightshade_tree", BYGEndVegetationFeatures.NIGHTSHADE_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> NIGHTSHADE_SHRUBS = createPlacedFeature("nightshade_shrubs", BYGEndVegetationFeatures.NIGHTSHADE_SHRUBS, () -> clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> BOREAL_TREES = createPlacedFeature("boreal_trees", BYGOverworldTreeFeatures.BOREAL_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 2)));
    public static final ResourceKey<PlacedFeature> BAYOU_TREES = createPlacedFeature("bayou_trees", BYGOverworldTreeFeatures.BAYOU_TREES, () -> treePlacementBaseOceanFloor(PlacementUtils.countExtra(4, 0.2F, 2), RandomOffsetPlacement.vertical(BiasedToBottomInt.of(3, 5))));
    public static final ResourceKey<PlacedFeature> BLACK_FOREST_TREES = createPlacedFeature("black_forest_trees", BYGOverworldTreeFeatures.BLACK_FOREST_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(8, 0.2F, 2)));
    public static final ResourceKey<PlacedFeature> CANADIAN_SHIELD_TREES = createPlacedFeature("canadian_shield_trees", BYGOverworldTreeFeatures.CANADIAN_SHIELD_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> CHERRY_TREES = createPlacedFeature("cherry_trees", BYGOverworldTreeFeatures.CHERRY_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(6, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> CIKA_TREES = createPlacedFeature("cika_trees", BYGOverworldTreeFeatures.CIKA_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(2, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> CONIFER_TREES = createPlacedFeature("conifer_trees", BYGOverworldTreeFeatures.CONIFER_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(7, 0.25F, 3)));
    public static final ResourceKey<PlacedFeature> CYPRESS_TREES = createPlacedFeature("cypress_trees", BYGOverworldTreeFeatures.CYPRESS_TREES, () -> treePlacementBaseOceanFloor(PlacementUtils.countExtra(2, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> DACITE_RIDGE_TREES = createPlacedFeature("dacite_ridge_trees", BYGOverworldTreeFeatures.DACITE_RIDGE_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> DECIDUOUS_TREES = createPlacedFeature("deciduous_trees", BYGOverworldTreeFeatures.DECIDUOUS_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> EBONY_TREES = createPlacedFeature("ebony_trees", BYGOverworldTreeFeatures.EBONY_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 4)));
    public static final ResourceKey<PlacedFeature> ENCHANTED_TREES = createPlacedFeature("enchanted_trees", BYGOverworldTreeFeatures.ENCHANTED_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(12, 0.25F, 3)));
    public static final ResourceKey<PlacedFeature> TEMPERATE_GROVE_TREES = createPlacedFeature("temperate_grove_trees", BYGOverworldTreeFeatures.TEMPERATE_GROVE_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> JACARANDA_TREES = createPlacedFeature("jacaranda_trees", BYGOverworldTreeFeatures.JACARANDA_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(13, 0.25F, 4)));
    public static final ResourceKey<PlacedFeature> IRONWOOD_TREES = createPlacedFeature("ironwood_trees", BYGOverworldTreeFeatures.IRONWOOD_TREE, () -> clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 2)));
    public static final ResourceKey<PlacedFeature> JACARANDA_BUSHES = createPlacedFeature("jacaranda_bushes", BYGOverworldVegetationFeatures.JACARANDA_BUSHES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> JOSHUA_TREES = createPlacedFeature("joshua_tree", BYGOverworldTreeFeatures.JOSHUA_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 2)));
    public static final ResourceKey<PlacedFeature> MANGROVE_TREES = createPlacedFeature("white_mangrove_trees", BYGOverworldTreeFeatures.MANGROVE_TREES, () -> treePlacementBaseOceanFloor(OptionalInt.of(5), PlacementUtils.countExtra(8, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> MAPLE_TAIGA_TREES = createPlacedFeature("maple_taiga_trees", BYGOverworldTreeFeatures.MAPLE_TAIGA_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> NORTHERN_FOREST_TREES = createPlacedFeature("northern_forest_trees", BYGOverworldTreeFeatures.NORTHERN_FOREST_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 3)));
    public static final ResourceKey<PlacedFeature> ORCHARD_TREES = createPlacedFeature("orchard_trees", BYGOverworldTreeFeatures.ORCHARD_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> HOLLY_TREES = createPlacedFeature("holly_trees", BYGOverworldTreeFeatures.HOLLY_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 4)));
    public static final ResourceKey<PlacedFeature> HOLLY_TREES_SPARSE = createPlacedFeature("holly_trees_sparse", BYGOverworldTreeFeatures.HOLLY_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> HAZEL_TREES = createPlacedFeature("hazel_trees", BYGOverworldTreeFeatures.WITCH_HAZEL_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> IMPARIUS_MUSHROOMS = createPlacedFeature("imparis_mushrooms", BYGEndVegetationFeatures.LARGE_IMPARIUS_MUSHROOMS, () -> treePlacement(PlacementUtils.countExtra(2, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> SPARSE_ETHER_TREES = createPlacedFeature("sparse_ether_trees", BYGEndVegetationFeatures.ETHER_TREES, () -> new ImmutableList.Builder<PlacementModifier>().addAll(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))).add(RarityFilter.onAverageOnceEvery(2)).add(DENSE_NOISE).build());
    public static final ResourceKey<PlacedFeature> DEAD_ETHER_TREES = createPlacedFeature("dead_ether_trees", BYGEndVegetationFeatures.DEAD_ETHER_TREES, () -> CountPlacement.of(7), () -> HeightRangePlacement.uniform(VerticalAnchor.absolute(200), VerticalAnchor.absolute(256)), () -> PlacementUtils.HEIGHTMAP, InSquarePlacement::spread, () -> RarityFilter.onAverageOnceEvery(2), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> HANGING_THERIUM_LANTERNS = createPlacedFeature("hanging_therium_lanterns", BYGEndFeatures.HANGING_THERIUM_LANTERNS, () -> CountPlacement.of(7), () -> HeightRangePlacement.uniform(VerticalAnchor.absolute(200), VerticalAnchor.absolute(256)), () -> RarityFilter.onAverageOnceEvery(4));
    public static final ResourceKey<PlacedFeature> ETHER_FOLIAGE = createPlacedFeature("ether_foliage", BYGEndVegetationFeatures.ETHER_FOLIAGE, () -> new ImmutableList.Builder<PlacementModifier>().addAll(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))).add(RarityFilter.onAverageOnceEvery(2)).add(DENSE_NOISE).build());
    public static final ResourceKey<PlacedFeature> ETHER_BUSHES = createPlacedFeature("ether_bushes", BYGEndVegetationFeatures.ETHER_BUSH1, () -> treePlacement(PlacementUtils.countExtra(0, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> FUNGAL_IMPARIUS = createPlacedFeature("fungal_imparis_mushrooms", BYGEndVegetationFeatures.FUNGAL_IMPARIUS, () -> treePlacement(PlacementUtils.countExtra(0, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> SPARSE_OAK_TREES = createPlacedFeature("sparse_oak_trees", BYGOverworldTreeFeatures.OAK_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final ResourceKey<PlacedFeature> OAK_TREES = createPlacedFeature("oak_trees", BYGOverworldTreeFeatures.OAK_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> OAK_TREES_SWAMP = createPlacedFeature("oak_trees_swamp", BYGOverworldTreeFeatures.OAK_TREES, () -> treePlacementBaseOceanFloor(PlacementUtils.countExtra(0, 0.2F, 1), RarityFilter.onAverageOnceEvery(2)));
    public static final ResourceKey<PlacedFeature> PALO_VERDE_TREES = createPlacedFeature("palo_verde_trees", BYGOverworldTreeFeatures.PALO_VERDE_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> MIXED_COLOR_BULBIS_TREES = createPlacedFeature("mixed_color_bulbis_trees", BYGEndVegetationFeatures.MIXED_COLOR_BULBIS_TREES, () -> treePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> SPARSE_PURPLE_BULBIS_TREES = createPlacedFeature("sparse_purple_bulbis_trees", BYGEndVegetationFeatures.PURPLE_BULBIS_TREES, () -> treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final ResourceKey<PlacedFeature> PALM_TREES = createPlacedFeature("palm_trees", BYGOverworldTreeFeatures.PALM_TREES, () -> Util.make(new ArrayList<>(clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 1), BYGWoodTypes.PALM.growerItem().get())), (list) -> {
        list.add(new NearWaterPlacementFilter(4));
    }));
    public static final ResourceKey<PlacedFeature> RED_OAK_TREES = createPlacedFeature("red_oak_trees", BYGOverworldTreeFeatures.RED_OAK_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> ORANGE_OAK_TREES = createPlacedFeature("orange_oak_trees", BYGOverworldTreeFeatures.ORANGE_OAK_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> BROWN_OAK_TREES = createPlacedFeature("brown_oak_trees", BYGOverworldTreeFeatures.BROWN_OAK_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> AUTUMNAL_OAK_TREES = createPlacedFeature("autumnal_oak_trees", BYGOverworldTreeFeatures.AUTUMNAL_OAK_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> AUTUMNAL_SPRUCE_TREES = createPlacedFeature("autumnal_spruce_trees", BYGOverworldTreeFeatures.AUTUMNAL_SPRUCE_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> ROSE_FIELD_SPRUCE_TREES = createPlacedFeature("rose_field_spruce_trees", BYGOverworldTreeFeatures.ROSE_FIELD_SPRUCE_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));

    public static final ResourceKey<PlacedFeature> PRAIRIE_SHRUBS = createPlacedFeature("prairie_shrubs", BYGOverworldTreeFeatures.PRAIRIE_SHRUBS, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> GUIANA_SHIELD_TREES = createPlacedFeature("guiana_shield_trees", BYGOverworldTreeFeatures.GUIANA_SHIELD_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(15, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> RAINFOREST_TREES = createPlacedFeature("rainforest_trees", BYGOverworldTreeFeatures.RAINFOREST_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(15, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> REDWOOD_TREES = createPlacedFeature("redwood_trees", BYGOverworldTreeFeatures.REDWOOD_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(2, 0.2F, 2)));
    public static final ResourceKey<PlacedFeature> FRAGMENT_FOREST_TREES = createPlacedFeature("fragment_forest_trees", BYGOverworldTreeFeatures.FRAGMENT_FOREST_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(2, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> SKYRIS_TREES = createPlacedFeature("skyris_trees", BYGOverworldTreeFeatures.SKYRIS_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> SPRUCE_TREES = createPlacedFeature("spruce_trees", BYGOverworldTreeFeatures.SPRUCE_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(3,0.2F, 1)));

    public static final ResourceKey<PlacedFeature> RED_SPRUCE_TREES_SPARSE = createPlacedFeature("sparse_red_spruce_trees", BYGOverworldTreeFeatures.RED_SPRUCE_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> BLUE_SPRUCE_TREES = createPlacedFeature("blue_spruce_trees", BYGOverworldTreeFeatures.BLUE_SPRUCE_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final ResourceKey<PlacedFeature> SPRUCE_TREES_SPARSE = createPlacedFeature("sparse_spruce_trees", BYGOverworldTreeFeatures.SPRUCE_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final ResourceKey<PlacedFeature> SPARSE_BLUE_SPRUCE_TREES = createPlacedFeature("sparse_blue_spruce_trees", BYGOverworldTreeFeatures.BLUE_SPRUCE_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 2)));
    public static final ResourceKey<PlacedFeature> BROWN_ZELKOVA_TREES = createPlacedFeature("brown_zelkova_trees", BYGOverworldTreeFeatures.BROWN_ZELKOVA_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> ZELKOVA_TREES = createPlacedFeature("zelkova_trees", BYGOverworldTreeFeatures.ZELKOVA_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(5, 0.2F, 2)));
    public static final ResourceKey<PlacedFeature> RAINBOW_EUCALYPTUS_TREES = createPlacedFeature("rainbow_eucalyptus_trees", BYGOverworldTreeFeatures.RAINBOW_EUCALYPTUS_TREES, () -> PlacementUtils.countExtra(6, 0.2F, 1), () -> HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> TEMPERATE_RAINFOREST_TREES = createPlacedFeature("temperate_rainforest_trees", BYGOverworldTreeFeatures.TEMPERATE_RAINFOREST_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));
    public static final ResourceKey<PlacedFeature> MEADOW_TREES = createPlacedFeature("meadow_trees", BYGOverworldTreeFeatures.MEADOW_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(2, 0.25F, 3)));
    public static final ResourceKey<PlacedFeature> MEADOW_TREES_SPARSE = createPlacedFeature("sparse_meadow_trees", BYGOverworldTreeFeatures.MEADOW_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
    private static final BlockPredicate DIRT_TAG = BlockPredicate.matchesTag(BlockPos.ZERO.relative(Direction.DOWN), BlockTags.DIRT);
    public static final ResourceKey<PlacedFeature> LARGE_BOULDERS = createPlacedFeature("large_boulders", BYGOverworldFeatures.LARGE_BOULDER, () -> oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(12), BlockPredicateFilter.forPredicate(DIRT_TAG)));
    public static final ResourceKey<PlacedFeature> LARGE_GRANITE_BOULDERS = createPlacedFeature("large_granite_boulders", BYGOverworldFeatures.LARGE_GRANITE_BOULDER, () -> oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(12), BlockPredicateFilter.forPredicate(DIRT_TAG)));
    public static final ResourceKey<PlacedFeature> LARGE_HOWLING_PEAKS_BOULDERS = createPlacedFeature("large_howling_peaks_boulders", BYGOverworldFeatures.LARGE_HOWLING_PEAKS_BOULDER, () -> oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(12), BlockPredicateFilter.forPredicate(DIRT_TAG)));

    public static final ResourceKey<PlacedFeature> LARGE_WINDSWEPT_BOULDERS = createPlacedFeature("large_windswept_boulders", BYGOverworldFeatures.LARGE_WINDSWEPT_BOULDER, () -> oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(5), BlockPredicateFilter.forPredicate(BlockPredicate.solid(new BlockPos(0, -1, 0))), RandomOffsetPlacement.vertical(BiasedToBottomInt.of(-3, -1))));
    public static final ResourceKey<PlacedFeature> ROSE_FIELD_FLOWERS = createPlacedFeature("rose_field_flowers", BYGOverworldVegetationFeatures.ROSE_FIELD_FLOWERS, () -> worldSurfaceSquaredWithCount(25));
    public static final ResourceKey<PlacedFeature> TINY_LILY_PAD = createPlacedFeature("tiny_lily_pad", BYGOverworldVegetationFeatures.TINY_LILY_PAD, () -> worldSurfaceSquaredWithCount(4));
    public static final ResourceKey<PlacedFeature> LILY_PAD = createPlacedFeature("lily_pad", VegetationFeatures.PATCH_WATERLILY, () -> CountPlacement.of(15), InSquarePlacement::spread, () -> HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> PATCH_GRASS_CRAG = createPlacedFeature("patch_grass_crag", VegetationFeatures.PATCH_GRASS_JUNGLE, () -> CountPlacement.of(25), InSquarePlacement::spread, () -> HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter::biome);

    public static final ResourceKey<PlacedFeature> SPARSE_HUGE_MUSHROOMS = createPlacedFeature("sparse_huge_mushrooms", BYGOverworldVegetationFeatures.HUGE_MUSHROOMS, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 2)));
    public static final ResourceKey<PlacedFeature> HUGE_MUSHROOMS = createPlacedFeature("huge_mushrooms", BYGOverworldVegetationFeatures.HUGE_MUSHROOMS, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));

    public static final ResourceKey<PlacedFeature> MEADOW_SHRUBS = createPlacedFeature("meadow_shrubs", BYGOverworldTreeFeatures.MEADOW_SHRUBS, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 2)));
    public static final ResourceKey<PlacedFeature> OAK_BUSHES = createPlacedFeature("oak_bushes", BYGOverworldTreeFeatures.OAK_BUSHES, () -> clearingTreePlacement(PlacementUtils.countExtra(2, 0.25F, 2)));

    public static final ResourceKey<PlacedFeature> FIRECRACKER_SHRUBS = createPlacedFeature("firecracker_shrubs", BYGOverworldTreeFeatures.FIRECRACKER_SHRUBS, () -> clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));

    public static final ResourceKey<PlacedFeature> SPARSE_RED_OAK_TREES = createPlacedFeature("sparse_red_oak_trees", BYGOverworldTreeFeatures.RED_OAK_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 1)));

    public static final ResourceKey<PlacedFeature> SPARSE_JACARANDA_TREES = createPlacedFeature("sparse_jacaranda_trees", BYGOverworldTreeFeatures.JACARANDA_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 2)));
    public static final ResourceKey<PlacedFeature> SPARSE_ARAUCARIA_TREES = createPlacedFeature("sparse_araucaria_trees", BYGOverworldTreeFeatures.ARAUCARIA_TREES, () -> clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 3)));

    public static final ResourceKey<PlacedFeature> DISK_MUD = createPlacedFeature("disk_mud", BYGOverworldFeatures.DISK_MUD, InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter::biome);

    public static final ResourceKey<PlacedFeature> MOSSY_STONE_BOULDER = createPlacedFeature("mossy_stone_boulder", BYGOverworldFeatures.MOSSY_STONE_BOULDER, () -> CountPlacement.of(2), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> BEEHIVES = createPlacedFeature("beehives", BYGOverworldFeatures.BEEHIVES, () -> CountPlacement.of(2), InSquarePlacement::spread, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> ROCKY_STONE_BOULDER = createPlacedFeature("rocky_stone_boulder", BYGOverworldFeatures.ROCKY_STONE_BOULDER, () -> CountPlacement.of(2), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> BLACKSTONE_BOULDER = createPlacedFeature("blackstone_boulder", BYGOverworldFeatures.BLACKSTONE_BOULDER, () -> CountPlacement.of(2), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> ORANGE_TERRACOTTA_BOULDER = createPlacedFeature("orange_terracotta_boulder", BYGOverworldFeatures.ORANGE_TERRACOTTA_BOULDER, () -> CountPlacement.of(2), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> BLACK_ICE_SNOW = createPlacedFeature("black_ice_snow", BYGOverworldFeatures.BLACK_ICE, () -> ChunkCoveringPlacement.INSTANCE, () -> PlacementUtils.HEIGHTMAP_WORLD_SURFACE, () -> RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter::biome, () -> BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(BlockPos.ZERO, Blocks.WATER)), () -> BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(new BlockPos(0, 1, 0), Blocks.AIR)));
    public static final ResourceKey<PlacedFeature> STONE_FOREST_COLUMN = createPlacedFeature("stone_forest_column", BYGOverworldFeatures.STONE_FOREST_COLUMN, () -> oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(2)));
    public static final ResourceKey<PlacedFeature> IVIS_FIELDS_SPIKE = createPlacedFeature("ivis_fields_spike", BYGEndFeatures.IVIS_FIELDS_SPIKE, () -> oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(9), BlockPredicateFilter.forPredicate(BlockPredicate.solid(new BlockPos(0, -1, 0)))));
    public static final ResourceKey<PlacedFeature> IVIS_FIELDS_COLUMN = createPlacedFeature("ivis_fields_column", BYGEndFeatures.IVIS_FIELDS_COLUMN, () -> oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(16), BlockPredicateFilter.forPredicate(BlockPredicate.solid(new BlockPos(0, -1, 0)))));
    public static final ResourceKey<PlacedFeature> LARGE_WINDSWEPT_LAKE = createPlacedFeature("large_windswept_lake", BYGOverworldFeatures.LARGE_WINDSWEPT_LAKE, () -> Util.make(new ArrayList<>(worldSurfaceSquaredWithCount(1)), list -> list.addAll(List.of(RarityFilter.onAverageOnceEvery(26), BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.anyOf(BlockPredicate.matchesFluids(new BlockPos(0, -1, 0), Fluids.WATER))))))));
    public static final ResourceKey<PlacedFeature> END_LAKE = createPlacedFeature("end_lake", BYGEndFeatures.END_LAKE, () -> Util.make(new ArrayList<>(worldSurfaceSquaredWithCount(1)), list -> list.addAll(List.of(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.solid(BlockPos.ZERO.relative(Direction.DOWN))), BiomeFilter.biome()))));

    public static final ResourceKey<PlacedFeature> LUSH_STACKS_SPIKES = createPlacedFeature("lush_stacks_spikes", BYGOverworldFeatures.LUSH_STACKS_SPIKES, () -> new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(1)).add(LUSH_STACKS_SPIKES_NOISE).build());
    public static final ResourceKey<PlacedFeature> DEAD_SEA_SPIKES = createPlacedFeature("dead_sea_spikes", BYGOverworldFeatures.DEAD_SEA_SPIKES, () -> new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(1)).add(LUSH_STACKS_SPIKES_NOISE).build());
    public static final ResourceKey<PlacedFeature> CRYPTIC_SPIKE = createPlacedFeature("cryptic_spikes", BYGEndFeatures.CRYPTIC_SPIKE, () -> new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(1)).add(RarityFilter.onAverageOnceEvery(3)).build());
    public static final ResourceKey<PlacedFeature> RED_ROCK_SPIKES = createPlacedFeature("red_rock_spikes", BYGOverworldFeatures.RED_ROCK_SPIKE, () -> new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(1)).add(RarityFilter.onAverageOnceEvery(24)).build());
    public static final ResourceKey<PlacedFeature> WINDSWEPT_SPIKES = createPlacedFeature("windswept_spikes", BYGOverworldFeatures.WINDSWEPT_SPIKES, () -> NoiseThresholdCountPlacement.of(0.6, 0, 1), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP_WORLD_SURFACE, () -> BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.anyOf(BlockPredicate.matchesFluids(new BlockPos(0, -1, 0), Fluids.WATER)))), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> CRYPTIC_REDSTONE = createPlacedFeature("cryptic_redstone", BYGEndFeatures.ORE_CRYPTIC_REDSTONE, () -> new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(8)).add(RandomOffsetPlacement.vertical(BiasedToBottomInt.of(-15, -2))).build());
//    public static final ResourceKey<PlacedFeature> BRIMSTONE_VENTS = createPlacedFeature("brimstone_vents", BYGNetherFeatures.BRIMSTONE_VENTS, CountOnEveryLayerPlacement () -> .of(4), BiomeFilter::biome);


    public static final ResourceKey<PlacedFeature> CRYPTIC_CAVE = createPlacedFeature("cryptic_caves", BYGEndFeatures.CRYPTIC_CAVES, () -> new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(2)).add(RandomOffsetPlacement.vertical(BiasedToBottomInt.of(-15, -7))).build());
    public static final ResourceKey<PlacedFeature> CRYPTIC_VENTS = createPlacedFeature("cryptic_vents", BYGEndFeatures.CRYPTIC_VENT_PATCHES, () -> new ImmutableList.Builder<PlacementModifier>().add(RarityFilter.onAverageOnceEvery(2)).addAll(oceanFloorSquaredWithCount(3)).build());


    public static final ResourceKey<PlacedFeature> QUARTZ_SPIKE = createPlacedFeature("quartz_spike", BYGNetherFeatures.QUARTZ_SPIKE, () -> NoiseThresholdCountPlacement.of(0.6, 0, 1), InSquarePlacement::spread, () -> PlacementUtils.HEIGHTMAP_WORLD_SURFACE, () -> BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.anyOf(BlockPredicate.matchesFluids(new BlockPos(0, -1, 0), Fluids.WATER)))), BiomeFilter::biome);

    public static final ResourceKey<PlacedFeature> ISLANDS = createPlacedFeature("islands", BYGEndFeatures.ISLANDS, () -> CountPlacement.of(1), () -> RarityFilter.onAverageOnceEvery(6), () -> HeightRangePlacement.uniform(VerticalAnchor.absolute(200), VerticalAnchor.absolute(230)), InSquarePlacement::spread, BiomeFilter::biome);

    public static final ResourceKey<PlacedFeature> ORE_GOLD_BRIMSTONE = createPlacedFeature("ore_gold_brimstone", BYGNetherFeatures.ORE_GOLD_BRIMSTONE, () -> byg_invokeCommonOrePlacement(10, PlacementUtils.RANGE_10_10));
    public static final ResourceKey<PlacedFeature> ORE_QUARTZ_BRIMSTONE = createPlacedFeature("ore_quartz_brimstone", BYGNetherFeatures.ORE_QUARTZ_BRIMSTONE, () -> byg_invokeCommonOrePlacement(16, PlacementUtils.RANGE_10_10));
    public static final ResourceKey<PlacedFeature> ORE_ANTHRACITE = createPlacedFeature("ore_anthracite", BYGNetherFeatures.ORE_ANTHRACITE, () -> byg_invokeCommonOrePlacement(20, PlacementUtils.RANGE_10_10));
    public static final ResourceKey<PlacedFeature> BORIC_FIRE = createPlacedFeature("patch_boric_fire", BYGNetherFeatures.BORIC_FIRE_PATCH, () -> CountOnEveryLayerPlacement.of(8), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> BRIMSTONE_VOLCANO = createPlacedFeature("brimstone_volcano", BYGNetherFeatures.BRIMSTONE_VOLCANO, () -> CountOnEveryLayerPlacement.of(3), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> CRAG_GEN = createPlacedFeature("crag_gen", BYGOverworldFeatures.CRAG_GEN, () -> CountOnEveryLayerPlacement.of(3), BiomeFilter::biome, () -> new AboveHeightmapFilter(Heightmap.Types.OCEAN_FLOOR_WG), () -> CRAG_NOISE);
    public static final ResourceKey<PlacedFeature> ARCH_FEATURE = createPlacedFeature("arch_feature", BYGOverworldFeatures.ARCH_FEATURE, InSquarePlacement::spread, () -> RarityFilter.onAverageOnceEvery(12), () -> PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> CRAG_DELTA = createPlacedFeature("crag_delta", BYGOverworldFeatures.CRAG_DELTA, () -> oceanFloorSquaredWithCount(1, RandomOffsetPlacement.vertical(ConstantInt.of(-1))));
    public static final ResourceKey<PlacedFeature> SWAMP_MOSS_DELTA = createPlacedFeature("swamp_moss_delta", BYGOverworldFeatures.SWAMP_MOSS_DELTA, () -> oceanFloorSquaredWithCount(1, RandomOffsetPlacement.vertical(ConstantInt.of(-1))));
    public static final ResourceKey<PlacedFeature> SWAMP_GRASS_BLOCK_DELTA = createPlacedFeature("swamp_grass_block_delta", BYGOverworldFeatures.SWAMP_GRASS_BLOCK_DELTA, () -> oceanFloorSquaredWithCount(1, RandomOffsetPlacement.vertical(ConstantInt.of(-1))));
    public static final ResourceKey<PlacedFeature> IMPARIUS_GROVE_DELTA = createPlacedFeature("imparius_grove_delta", BYGEndFeatures.IMPARIUS_GROVE_DELTA, () -> oceanFloorSquaredWithCount(1, RandomOffsetPlacement.vertical(ConstantInt.of(-1))));
    public static final ResourceKey<PlacedFeature> VINES_1 = createPlacedFeature("vines", VegetationFeatures.VINES, () -> CountPlacement.of(256), InSquarePlacement::spread, () -> HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> VINES_2 = createPlacedFeature("vines_2", VegetationFeatures.VINES, () -> CountPlacement.of(256), InSquarePlacement::spread, () -> HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)), BiomeFilter::biome);

    public static final ResourceKey<PlacedFeature> BRIMSTONE_PILLARS = createPlacedFeature("brimstone_pillars", BYGNetherFeatures.BRIMSTONE_PILLARS, () -> CountPlacement.of(10), InSquarePlacement::spread, () -> PlacementUtils.FULL_RANGE, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> MAGMA_PILLARS = createPlacedFeature("magma_pillars", BYGNetherFeatures.MAGMA_PILLARS, () -> CountPlacement.of(10), InSquarePlacement::spread, () -> PlacementUtils.FULL_RANGE, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> SOUL_SOIL_PILLARS = createPlacedFeature("soul_soil_pillars", BYGNetherFeatures.SOUL_SOIL_PILLARS, () -> CountPlacement.of(10), InSquarePlacement::spread, () -> PlacementUtils.FULL_RANGE, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> SYTHIAN_FUNGUS_PILLARS = createPlacedFeature("sythian_fungus_pillars", BYGNetherFeatures.SYTHIAN_FUNGUS_PILLARS, () -> CountPlacement.of(10), InSquarePlacement::spread, () -> PlacementUtils.FULL_RANGE, BiomeFilter::biome);

    public static final ResourceKey<PlacedFeature> SYTHIAN_ROOTS = createPlacedFeature("sythian_roots", BYGNetherVegetationFeatures.SYTHIAN_ROOTS, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> SYTHIAN_SPROUT = createPlacedFeature("sythian_sprout", BYGNetherVegetationFeatures.SYTHIAN_SPROUT, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> SYTHIAN_FUNGUS = createPlacedFeature("sythian_fungus", BYGNetherVegetationFeatures.SYTHIAN_FUNGUS, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> WARPED_CACTI = createPlacedFeature("warped_cacti", BYGNetherVegetationFeatures.WARPED_CACTI, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> WARPED_BUSH = createPlacedFeature("warped_bush", BYGNetherVegetationFeatures.WARPED_BUSH, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> WARPED_CORAL = createPlacedFeature("warped_coral", BYGNetherVegetationFeatures.WARPED_CORAL, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> WARPED_CORAL_FAN = createPlacedFeature("warped_coral_fan", BYGNetherVegetationFeatures.WARPED_CORAL_FAN, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> SYTHIAN_VEGETATION = createPlacedFeature("sythian_vegetation", BYGNetherVegetationFeatures.SYTHIAN_VEGETATION, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> BLACKSTONE_BOULDERS_NETHER = createPlacedFeature("blackstone_boulders_nether", BYGOverworldFeatures.BLACKSTONE_BOULDER, () -> CountOnEveryLayerPlacement.of(2), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> WAILING_VINES = createPlacedFeature("wailing_vines", BYGNetherVegetationFeatures.WAILING_VINE, () -> CountPlacement.of(10), InSquarePlacement::spread, () -> PlacementUtils.FULL_RANGE, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> HANGING_SYTHIAN_ROOTS = createPlacedFeature("hanging_sythian_roots", BYGNetherVegetationFeatures.HANGING_SYTHIAN_ROOTS, () -> CountPlacement.of(10), InSquarePlacement::spread, () -> PlacementUtils.FULL_RANGE, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> HANGING_BONE_FEATURE = createPlacedFeature("hanging_bone_feature", BYGNetherVegetationFeatures.HANGING_BONES, () -> CountPlacement.of(10), InSquarePlacement::spread, () -> PlacementUtils.FULL_RANGE, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> HANGING_SOUL_SHROOM_SPORES = createPlacedFeature("hanging_soul_shroom_spores", BYGNetherVegetationFeatures.HANGING_SOUL_SHROOM_SPORES, () -> CountPlacement.of(10), InSquarePlacement::spread, () -> PlacementUtils.FULL_RANGE, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> SOUL_SHROOM_TREES = createPlacedFeature("soul_shroom_trees", BYGNetherVegetationFeatures.SOUL_SHROOM_TREES, () -> CountOnEveryLayerPlacement.of(8), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> SYTHIAN_FUNGI_TREES = createPlacedFeature("sythian_fungi_trees", BYGNetherVegetationFeatures.SYTHIAN_FUNGI_TREES, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> SYTHIAN_STALK = createPlacedFeature("sythian_stalk", BYGNetherVegetationFeatures.SYTHIAN_STALK, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> DEATH_CAP_TREES = createPlacedFeature("death_cap_trees", BYGNetherVegetationFeatures.DEATH_CAP_TREES, () -> CountOnEveryLayerPlacement.of(6), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> QUARTZ_CRYSTALS = createPlacedFeature("quartz_crystals", BYGNetherFeatures.QUARTZ_CRYSTAL, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> QUARTZ_COLUMNS = createPlacedFeature("quartz_columns", BYGNetherFeatures.QUARTZ_COLUMNS, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> SCORCHED_PLANTS = createPlacedFeature("scorched_plants", BYGNetherVegetationFeatures.SCORCHED_PLANTS, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> WARPED_CORAL_PLANT = createPlacedFeature("warped_coral_plant", BYGNetherVegetationFeatures.WARPED_CORAL_PLANT, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> WARPED_DESERT_VEGETATION = createPlacedFeature("warped_desert_vegetation", BYGNetherVegetationFeatures.WARPED_DESERT_VEGETATION, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> WAILING_VEGETATION = createPlacedFeature("wailing_vegetation", BYGNetherVegetationFeatures.WAILING_VEGETATION, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> MINI_MUSHROOMS = createPlacedFeature("mini_mushrooms", BYGNetherVegetationFeatures.MINI_MUSHROOMS, () -> CountOnEveryLayerPlacement.of(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> WAILING_PILLARS = createPlacedFeature("wailing_pillar", BYGNetherFeatures.WAILING_PILLAR, () -> CountOnEveryLayerPlacement.of(1), () -> RarityFilter.onAverageOnceEvery(4), BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> MAGMA_PATCH_FIRE = createPlacedFeature("magma_patch_fire", BYGNetherFeatures.MAGMA_PATCH_FIRE, () -> CountPlacement.of(UniformInt.of(30, 45)), InSquarePlacement::spread, () -> PlacementUtils.RANGE_4_4, BiomeFilter::biome);
    public static final ResourceKey<PlacedFeature> NYLIUM_SOUL_PATCH_FIRE = createPlacedFeature("nylium_soul_patch_fire", BYGNetherFeatures.NYLIUM_SOUL_PATCH_FIRE, () -> CountPlacement.of(UniformInt.of(5, 10)), InSquarePlacement::spread, () -> PlacementUtils.RANGE_4_4, BiomeFilter::biome);

    public static void loadClass() {
    }
}
