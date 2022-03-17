package potionstudios.byg.common.world.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
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
import potionstudios.byg.common.block.BYGBlocks;
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

    public static final Holder<PlacedFeature> GLOBAL_RAW_GENERATION = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.RAW_GENERATION), BYGGlobalFeatures.GLOBAL_RAW_GENERATION);
    public static final Holder<PlacedFeature> GLOBAL_LAKES = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.LAKES), BYGGlobalFeatures.GLOBAL_LAKES);
    public static final Holder<PlacedFeature> GLOBAL_LOCAL_MODIFICATIONS = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.LOCAL_MODIFICATIONS), BYGGlobalFeatures.GLOBAL_LOCAL_MODIFICATIONS);
    public static final Holder<PlacedFeature> GLOBAL_UNDERGROUND_STRUCTURES = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.UNDERGROUND_STRUCTURES), BYGGlobalFeatures.GLOBAL_UNDERGROUND_STRUCTURES);
    public static final Holder<PlacedFeature> GLOBAL_SURFACE_STRUCTURES = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.SURFACE_STRUCTURES), BYGGlobalFeatures.GLOBAL_SURFACE_STRUCTURES);
    public static final Holder<PlacedFeature> GLOBAL_STRONGHOLDS = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.STRONGHOLDS), BYGGlobalFeatures.GLOBAL_STRONGHOLDS);
    public static final Holder<PlacedFeature> GLOBAL_UNDERGROUND_ORES = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.UNDERGROUND_ORES), BYGGlobalFeatures.GLOBAL_UNDERGROUND_ORES);
    public static final Holder<PlacedFeature> GLOBAL_UNDERGROUND_DECORATION = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.UNDERGROUND_DECORATION), BYGGlobalFeatures.GLOBAL_UNDERGROUND_DECORATION);
    public static final Holder<PlacedFeature> GLOBAL_FLUID_SPRINGS = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.FLUID_SPRINGS), BYGGlobalFeatures.GLOBAL_FLUID_SPRINGS);
    public static final Holder<PlacedFeature> GLOBAL_VEGETAL_DECORATION = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.VEGETAL_DECORATION), BYGGlobalFeatures.GLOBAL_VEGETAL_DECORATION);
    public static final Holder<PlacedFeature> GLOBAL_TOP_LAYER_MODIFICATION = createPlacedFeature(globalGenStagePath(GenerationStep.Decoration.TOP_LAYER_MODIFICATION), BYGGlobalFeatures.GLOBAL_TOP_LAYER_MODIFICATION);


    public static final NoiseThresholdCountPlacement CRAG_NOISE = NoiseThresholdCountPlacement.of(0, 1, 0);

    public static final NoiseThresholdCountPlacement DENSE_NOISE = NoiseThresholdCountPlacement.of(-0.545, 1, 2);
    public static final NoiseThresholdCountPlacement LUSH_STACKS_SPIKES_NOISE = NoiseThresholdCountPlacement.of(0.545, 1, 0);


    public static final Holder<PlacedFeature> ALLIUM_FIELD_FLOWERS = createPlacedFeature("allium_field_flowers", BYGOverworldVegetationFeatures.ALLIUM_FIELD_FLOWERS, worldSurfaceSquaredWithCount(20));
    public static final Holder<PlacedFeature> PINK_ALLIUMS = createPlacedFeature("pink_alliums", BYGOverworldVegetationFeatures.ALLIUM_PINK, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> AMARANTH_FIELD_FLOWERS = createPlacedFeature("amaranth_field_flowers", BYGOverworldVegetationFeatures.AMARANTH_FIELD_FLOWERS, worldSurfaceSquaredWithCount(20));
    public static final Holder<PlacedFeature> DUNE_TERRAIN = createPlacedFeature("dune_terrain", BYGOverworldVegetationFeatures.DUNE_TERRAIN);

    public static final Holder<PlacedFeature> SHRUB = createPlacedFeature("shrub", BYGOverworldVegetationFeatures.SHRUB, worldSurfaceSquaredWithCount(1));

    public static final Holder<PlacedFeature> FIRECRACKER_BUSH = createPlacedFeature("firecracker_bush", BYGOverworldVegetationFeatures.FIRECRACKER_BUSH, worldSurfaceSquaredWithCount(3));
    public static final Holder<PlacedFeature> BLUE_BERRY_BUSH = createPlacedFeature("blue_berry_bush", BYGOverworldVegetationFeatures.BLUE_BERRY_BUSH, RarityFilter.onAverageOnceEvery(64), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> BLUE_BERRY_BUSH_LUSH = createPlacedFeature("blue_berry_bush_lush", BYGOverworldVegetationFeatures.BLUE_BERRY_BUSH, RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> CATTAIL = createPlacedFeature("cattails", BYGOverworldVegetationFeatures.CATTAIL, oceanFloorSquaredWithCountAndMaxDepth(25, OptionalInt.of(2)));
    public static final Holder<PlacedFeature> LEATHER_FLOWERS = createPlacedFeature("leather_flowers", BYGOverworldVegetationFeatures.LEATHER_FLOWERS, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> LEAF_PILES = createPlacedFeature("leaf_piles", BYGOverworldVegetationFeatures.LEAF_PILE, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> LOLLIPOP_FLOWERS = createPlacedFeature("lollipop_flowers", BYGOverworldVegetationFeatures.LOLLIPOP_FLOWER, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> CLOVER_FLOWERS = createPlacedFeature("clover_flower_patch", BYGOverworldVegetationFeatures.CLOVER_PATCH, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> CRYPTIC_BRAMBLE = createPlacedFeature("cryptic_bramble", BYGEndVegetationFeatures.CRYPTIC_BRAMBLE_PATCH, new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(2)).build());
    public static final Holder<PlacedFeature> CROCUS = createPlacedFeature("crocus", BYGOverworldVegetationFeatures.CROCUS, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> ANEMONES = createPlacedFeature("anemones", BYGOverworldVegetationFeatures.ANEMONES, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> MEADOW_GRASS = createPlacedFeature("meadow_grass", VegetationFeatures.PATCH_GRASS, worldSurfaceSquaredWithCount(8));
    public static final Holder<PlacedFeature> ALPINE_BELLFLOWER = createPlacedFeature("alpine_bellflower", BYGOverworldVegetationFeatures.ALPINE_BELLFLOWER, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> ROSES = createPlacedFeature("rose", BYGOverworldVegetationFeatures.ROSE, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> BLACK_ROSE = createPlacedFeature("black_rose", BYGOverworldVegetationFeatures.BLACK_ROSE, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> BULBIS_ODDITIES = createPlacedFeature("bulbis_oddities", BYGEndVegetationFeatures.BULBIS_ODDITIES, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> BULBIS_SPROUTS = createPlacedFeature("bulbis_sprouts", BYGEndVegetationFeatures.BULBIS_SPROUTS, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> THEREAL_BELLFLOWER = createPlacedFeature("thereal_bellflower", BYGEndVegetationFeatures.THEREAL_BELLFLOWER, worldSurfaceSquaredWithCount(6));
    public static final Holder<PlacedFeature> IVIS_PLANTS = createPlacedFeature("ivis_plants", BYGEndVegetationFeatures.IVIS_PLANTS, worldSurfaceSquaredWithCount(5));
    public static final Holder<PlacedFeature> ETHER_PLANTS = createPlacedFeature("ether_plants", BYGEndVegetationFeatures.ETHER_PLANTS, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> ETHER_BULBS = createPlacedFeature("ether_bulbs", BYGEndVegetationFeatures.ETHER_BULB, CountPlacement.of(UniformInt.of(15, 25)), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()));
    public static final Holder<PlacedFeature> ENDER_LILY = createPlacedFeature("ender_lily", BYGEndVegetationFeatures.ENDER_LILY, worldSurfaceSquaredWithCount(6));
    public static final Holder<PlacedFeature> NIGHTSHADE_PLANTS = createPlacedFeature("nightshade_plants", BYGEndVegetationFeatures.NIGHTSHADE_PLANTS, worldSurfaceSquaredWithCount(7));
    public static final Holder<PlacedFeature> IMPARIUS_PLANTS = createPlacedFeature("imparius_plants", BYGEndVegetationFeatures.IMPARIUS_PLANTS, worldSurfaceSquaredWithCount(12));
    public static final Holder<PlacedFeature> SPARSE_BULBIS_ANOMALIES = createPlacedFeature("sparse_anomalies", BYGEndVegetationFeatures.BULBIS_ANOMALIES, new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(1)).add(RarityFilter.onAverageOnceEvery(4)).build());
    public static final Holder<PlacedFeature> BULBIS_ANOMALIES = createPlacedFeature("bulbis_anomalies", BYGEndVegetationFeatures.BULBIS_ANOMALIES, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> SHULKREN_PLANTS = createPlacedFeature("shulkren_plants", BYGEndVegetationFeatures.SHULKREN_PLANTS, worldSurfaceSquaredWithCount(5));
    public static final Holder<PlacedFeature> SHULKREN_HANGING_VINES = createPlacedFeature("shulkren_hanging_vines", BYGEndVegetationFeatures.HANGING_SHULKREN_VINE, CountPlacement.of(6), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()));
    public static final Holder<PlacedFeature> THERIUM_DEPOSIT = createPlacedFeature("therium_deposit", BYGEndFeatures.THERIUM_CRYSTAL_DEPOSIT_LARGE, new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(1)).add(RarityFilter.onAverageOnceEvery(65)).add(BiomeFilter.biome()).build());
    public static final Holder<PlacedFeature> CYAN_ROSE = createPlacedFeature("cyan_rose", BYGOverworldVegetationFeatures.CYAN_ROSE, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> CRYPTIC_FIRE = createPlacedFeature("cryptic_fire", BYGEndFeatures.CRYPTIC_FIRE_PATCH, new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(2)).build());
    public static final Holder<PlacedFeature> KOVAN_FLOWERS = createPlacedFeature("kovan_flowers", BYGOverworldVegetationFeatures.KOVAN_FLOWER, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> DAISY_ORANGE = createPlacedFeature("orange_daisy", BYGOverworldVegetationFeatures.DAISY_ORANGE, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> JAPANESE_ORCHID = createPlacedFeature("japanese_orchid", BYGOverworldVegetationFeatures.JAPANESE_ORCHID, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> FOXGLOVES = createPlacedFeature("foxgloves", BYGOverworldVegetationFeatures.FOXGLOVE, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> FAIRY_SLIPPER = createPlacedFeature("fairy_slipper", BYGOverworldVegetationFeatures.FAIRY_SLIPPER, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> CHERRY_FOLIAGE = createPlacedFeature("cherry_foliage", BYGOverworldVegetationFeatures.CHERRY_FOLIAGE, worldSurfaceSquaredWithCount(6));
    public static final Holder<PlacedFeature> WINTER_ROSES = createPlacedFeature("winter_roses", BYGOverworldVegetationFeatures.ROSE_WINTER, worldSurfaceSquaredWithCount(6));
    public static final Holder<PlacedFeature> HORSEWEED = createPlacedFeature("horseweed", BYGOverworldVegetationFeatures.HORSEWEED, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> PRAIRIE_GRASS = createPlacedFeature("prairie_grass", BYGOverworldVegetationFeatures.PRAIRIE_GRASS, CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> IRIS = createPlacedFeature("iris", BYGOverworldVegetationFeatures.IRIS, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> TULIPS = createPlacedFeature("tulips", BYGOverworldVegetationFeatures.TULIPS, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> WHITE_PUFFBALL = createPlacedFeature("white_puffball", BYGOverworldVegetationFeatures.WHITE_PUFFBALL, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> SAGES = createPlacedFeature("sages", BYGOverworldVegetationFeatures.SAGES, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> HYDRANGEAS = createPlacedFeature("hydrangeas", BYGOverworldVegetationFeatures.HYDRANGEAS, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> DESERT_VEGETATION = createPlacedFeature("desert_vegetation", BYGOverworldVegetationFeatures.DESERT_VEGETATION, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> LUSH_DESERT_VEGETATION = createPlacedFeature("lush_desert_vegetation", BYGOverworldVegetationFeatures.DESERT_VEGETATION, worldSurfaceSquaredWithCount(10));
    public static final Holder<PlacedFeature> PATCH_BEACH_GRASS_NOISE = createPlacedFeature("patch_beach_grass_noise", BYGOverworldVegetationFeatures.BEACH_GRASS, NoiseThresholdCountPlacement.of(-0.45D, 7, 0), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> WINTER_SUCCULENT = createPlacedFeature("winter_succulent", BYGOverworldVegetationFeatures.WINTER_SUCCULENT, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> DAFFODIL_YELLOW = createPlacedFeature("yellow_daffodil", BYGOverworldVegetationFeatures.DAFFODIL_YELLOW, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> JUNGLE_FLOWERS = createPlacedFeature("jungle_flowers", BYGOverworldVegetationFeatures.JUNGLE_FLOWERS, worldSurfaceSquaredWithCount(2));
    public static final Holder<PlacedFeature> LARGE_PUMPKINS = createPlacedFeature("large_pumpkins", BYGOverworldVegetationFeatures.LARGE_PUMPKINS, clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));
    public static final Holder<PlacedFeature> SWAMP_WATER_VEGETATION = createPlacedFeature("swamp_water_vegetation", BYGOverworldVegetationFeatures.SWAMP_WATER_VEGETATION, worldSurfaceSquaredWithCount(25));

    public static final Holder<PlacedFeature> MUSHROOMS = createPlacedFeature("mushrooms", BYGOverworldVegetationFeatures.MUSHROOMS, VegetationPlacementsAccess.byg_invokeGetMushroomPlacement(512, null));
    public static final Holder<PlacedFeature> ARAUCARIA_TREES = createPlacedFeature("araucaria_trees", BYGOverworldTreeFeatures.ARAUCARIA_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
    public static final Holder<PlacedFeature> ASPEN_SHRUBS = createPlacedFeature("aspen_shrubs", BYGOverworldTreeFeatures.ASPEN_SHRUBS, clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 2)));
    public static final Holder<PlacedFeature> ASPEN_TREES = createPlacedFeature("aspen_trees", BYGOverworldTreeFeatures.ASPEN_TREES, clearingTreePlacement(PlacementUtils.countExtra(6, 0.25F, 3)));
    public static final Holder<PlacedFeature> ASPEN_TREES_SPARSE = createPlacedFeature("aspen_trees_sparse", BYGOverworldTreeFeatures.ASPEN_TREES, clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
    public static final Holder<PlacedFeature> BAOBAB_TREES = createPlacedFeature("baobab_trees", BYGOverworldTreeFeatures.BAOBAB_TREES, clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
    public static final Holder<PlacedFeature> NIGHTSHADE_TREES = createPlacedFeature("nightshade_tree", BYGEndVegetationFeatures.NIGHTSHADE_TREES, clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 1)));
    public static final Holder<PlacedFeature> NIGHTSHADE_SHRUBS = createPlacedFeature("nightshade_shrubs", BYGEndVegetationFeatures.NIGHTSHADE_SHRUBS, clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 1)));
    public static final Holder<PlacedFeature> BOREAL_TREES = createPlacedFeature("boreal_trees", BYGOverworldTreeFeatures.BOREAL_TREES, clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 2)));
    public static final Holder<PlacedFeature> BAYOU_TREES = createPlacedFeature("bayou_trees", BYGOverworldTreeFeatures.BAYOU_TREES, clearingTreePlacementBaseOceanFloor(PlacementUtils.countExtra(4, 0.2F, 2)));
    public static final Holder<PlacedFeature> BLACK_FOREST_TREES = createPlacedFeature("black_forest_trees", BYGOverworldTreeFeatures.BLACK_FOREST_TREES, clearingTreePlacement(PlacementUtils.countExtra(8, 0.2F, 2)));
    public static final Holder<PlacedFeature> CANADIAN_SHIELD_TREES = createPlacedFeature("canadian_shield_trees", BYGOverworldTreeFeatures.CANADIAN_SHIELD_TREES, clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 2)));
    public static final Holder<PlacedFeature> CHERRY_TREES = createPlacedFeature("cherry_trees", BYGOverworldTreeFeatures.CHERRY_TREES, clearingTreePlacement(PlacementUtils.countExtra(6, 0.25F, 2)));
    public static final Holder<PlacedFeature> CIKA_TREES = createPlacedFeature("cika_trees", BYGOverworldTreeFeatures.CIKA_TREES, clearingTreePlacement(PlacementUtils.countExtra(2, 0.25F, 2)));
    public static final Holder<PlacedFeature> CONIFER_TREES = createPlacedFeature("conifer_trees", BYGOverworldTreeFeatures.CONIFER_TREES, clearingTreePlacement(PlacementUtils.countExtra(7, 0.25F, 3)));
    public static final Holder<PlacedFeature> CYPRESS_TREES = createPlacedFeature("cypress_trees", BYGOverworldTreeFeatures.CYPRESS_TREES, clearingTreePlacementBaseOceanFloor(PlacementUtils.countExtra(4, 0.25F, 1)));
    public static final Holder<PlacedFeature> DACITE_RIDGE_TREES = createPlacedFeature("dacite_ridge_trees", BYGOverworldTreeFeatures.DACITE_RIDGE_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
    public static final Holder<PlacedFeature> DECIDUOUS_TREES = createPlacedFeature("deciduous_trees", BYGOverworldTreeFeatures.DECIDUOUS_TREES, clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 2)));
    public static final Holder<PlacedFeature> EBONY_TREES = createPlacedFeature("ebony_trees", BYGOverworldTreeFeatures.EBONY_TREES, clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 4)));
    public static final Holder<PlacedFeature> ENCHANTED_TREES = createPlacedFeature("enchanted_trees", BYGOverworldTreeFeatures.ENCHANTED_TREES, clearingTreePlacement(PlacementUtils.countExtra(5, 0.2F, 2)));
    public static final Holder<PlacedFeature> TEMPERATE_GROVE_TREES = createPlacedFeature("temperate_grove_trees", BYGOverworldTreeFeatures.TEMPERATE_GROVE_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
    public static final Holder<PlacedFeature> JACARANDA_TREES = createPlacedFeature("jacaranda_trees", BYGOverworldTreeFeatures.JACARANDA_TREES, clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 2)));
    public static final Holder<PlacedFeature> JACARANDA_BUSHES = createPlacedFeature("jacaranda_bushes", BYGOverworldVegetationFeatures.JACARANDA_BUSHES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final Holder<PlacedFeature> JOSHUA_TREES = createPlacedFeature("joshua_tree", BYGOverworldTreeFeatures.JOSHUA_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 2)));
    public static final Holder<PlacedFeature> MANGROVE_TREES = createPlacedFeature("mangrove_trees", BYGOverworldTreeFeatures.MANGROVE_TREES, clearingTreePlacementBaseOceanFloor(PlacementUtils.countExtra(2, 0.25F, 1)));
    public static final Holder<PlacedFeature> MAPLE_TREES = createPlacedFeature("maple_trees", BYGOverworldTreeFeatures.MAPLE_TREES, clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 2)));
    public static final Holder<PlacedFeature> NORTHERN_FOREST_TREES = createPlacedFeature("northern_forest_trees", BYGOverworldTreeFeatures.NORTHERN_FOREST_TREES, clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 3)));
    public static final Holder<PlacedFeature> ORCHARD_TREES = createPlacedFeature("orchard_trees", BYGOverworldTreeFeatures.ORCHARD_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final Holder<PlacedFeature> HOLLY_TREES = createPlacedFeature("holly_trees", BYGOverworldTreeFeatures.HOLLY_TREES, clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 4)));
    public static final Holder<PlacedFeature> HAZEL_TREES = createPlacedFeature("hazel_trees", BYGOverworldTreeFeatures.HAZEL_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
    public static final Holder<PlacedFeature> IMPARIUS_MUSHROOMS = createPlacedFeature("imparis_mushrooms", BYGEndVegetationFeatures.LARGE_IMPARIUS_MUSHROOMS, treePlacement(PlacementUtils.countExtra(0, 0.25F, 2)));
    public static final Holder<PlacedFeature> SHULKREN_TREES = createPlacedFeature("shulkren_trees", BYGEndVegetationFeatures.SHULKREN_TREES, treePlacement(PlacementUtils.countExtra(1, 0.2F, 2)));
    public static final Holder<PlacedFeature> SPARSE_ETHER_TREES = createPlacedFeature("sparse_ether_trees", BYGEndVegetationFeatures.ETHER_TREES, new ImmutableList.Builder<PlacementModifier>().addAll(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))).add(RarityFilter.onAverageOnceEvery(2)).add(DENSE_NOISE).build());
    public static final Holder<PlacedFeature> DEAD_ETHER_TREES = createPlacedFeature("dead_ether_trees", BYGEndVegetationFeatures.DEAD_ETHER_TREES, CountPlacement.of(7), HeightRangePlacement.uniform(VerticalAnchor.absolute(200), VerticalAnchor.absolute(256)), PlacementUtils.HEIGHTMAP, InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(2), BiomeFilter.biome());
    public static final Holder<PlacedFeature> HANGING_THERIUM_LANTERNS = createPlacedFeature("hanging_therium_lanterns", BYGEndFeatures.HANGING_THERIUM_LANTERNS, CountPlacement.of(7), HeightRangePlacement.uniform(VerticalAnchor.absolute(200), VerticalAnchor.absolute(256)), RarityFilter.onAverageOnceEvery(4));
    public static final Holder<PlacedFeature> ETHER_FOLIAGE = createPlacedFeature("ether_foliage", BYGEndVegetationFeatures.ETHER_FOLIAGE, new ImmutableList.Builder<PlacementModifier>().addAll(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))).add(RarityFilter.onAverageOnceEvery(2)).add(DENSE_NOISE).build());
    public static final Holder<PlacedFeature> ETHER_BUSHES = createPlacedFeature("ether_bushes", BYGEndVegetationFeatures.ETHER_BUSHES, treePlacement(PlacementUtils.countExtra(0, 0.2F, 1)));
    public static final Holder<PlacedFeature> FUNGAL_IMPARIUS = createPlacedFeature("fungal_imparis_mushrooms", BYGEndVegetationFeatures.FUNGAL_IMPARIUS, treePlacement(PlacementUtils.countExtra(0, 0.25F, 2)));
    public static final Holder<PlacedFeature> SPARSE_OAK_TREES = createPlacedFeature("sparse_oak_trees", BYGOverworldTreeFeatures.OAK_TREES, clearingTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final Holder<PlacedFeature> OAK_TREES = createPlacedFeature("oak_trees", BYGOverworldTreeFeatures.OAK_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final Holder<PlacedFeature> PALO_VERDE_TREES = createPlacedFeature("palo_verde_trees", BYGOverworldTreeFeatures.PALO_VERDE_TREES, clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 1)));
    public static final Holder<PlacedFeature> BULBIS_TREES = createPlacedFeature("bulbis_trees", BYGEndVegetationFeatures.BULBIS_TREES, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
    public static final Holder<PlacedFeature> PURPLE_BULBIS_TREES = createPlacedFeature("purple_bulbis_trees", BYGEndVegetationFeatures.PURPLE_BULBIS_TREES, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
    public static final Holder<PlacedFeature> SPARSE_PURPLE_BULBIS_TREES = createPlacedFeature("sparse_purple_bulbis_trees", BYGEndVegetationFeatures.PURPLE_BULBIS_TREES, treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    public static final Holder<PlacedFeature> PALM_TREES = createPlacedFeature("palm_trees", BYGOverworldTreeFeatures.PALM_TREES, Util.make(new ArrayList<>(clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 1), BYGBlocks.PALM_SAPLING)), (list) -> {
        list.add(new NearWaterPlacementFilter(4));
    }));
    public static final Holder<PlacedFeature> RED_OAK_TREES = createPlacedFeature("red_oak_trees", BYGOverworldTreeFeatures.RED_OAK_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final Holder<PlacedFeature> ORANGE_OAK_TREES = createPlacedFeature("orange_oak_trees", BYGOverworldTreeFeatures.ORANGE_OAK_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final Holder<PlacedFeature> BROWN_OAK_TREES = createPlacedFeature("brown_oak_trees", BYGOverworldTreeFeatures.BROWN_OAK_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final Holder<PlacedFeature> AUTUMNAL_OAK_TREES = createPlacedFeature("autumnal_oak_trees", BYGOverworldTreeFeatures.AUTUMNAL_OAK_TREES, clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 1)));
    public static final Holder<PlacedFeature> AUTUMNAL_SPRUCE_TREES = createPlacedFeature("autumnal_spruce_trees", BYGOverworldTreeFeatures.AUTUMNAL_SPRUCE_TREES, clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 1)));
    public static final Holder<PlacedFeature> PRAIRIE_SHRUBS = createPlacedFeature("prairie_shrubs", BYGOverworldTreeFeatures.PRAIRIE_SHRUBS, clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 2)));
    public static final Holder<PlacedFeature> GUIANA_SHIELD_TREES = createPlacedFeature("guiana_shield_trees", BYGOverworldTreeFeatures.GUIANA_SHIELD_TREES, clearingTreePlacement(PlacementUtils.countExtra(15, 0.25F, 1)));
    public static final Holder<PlacedFeature> RAINFOREST_TREES = createPlacedFeature("rainforest_trees", BYGOverworldTreeFeatures.RAINFOREST_TREES, clearingTreePlacement(PlacementUtils.countExtra(15, 0.25F, 1)));
    public static final Holder<PlacedFeature> REDWOOD_TREES = createPlacedFeature("redwood_trees", BYGOverworldTreeFeatures.REDWOOD_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
    public static final Holder<PlacedFeature> FRAGMENT_FOREST_TREES = createPlacedFeature("fragment_forest_trees", BYGOverworldTreeFeatures.FRAGMENT_FOREST_TREES, clearingTreePlacement(PlacementUtils.countExtra(2, 0.25F, 2)));
    public static final Holder<PlacedFeature> SKYRIS_TREES = createPlacedFeature("skyris_trees", BYGOverworldTreeFeatures.SKYRIS_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
    public static final Holder<PlacedFeature> RED_SPRUCE_TREES_SPARSE = createPlacedFeature("sparse_red_spruce_trees", BYGOverworldTreeFeatures.RED_SPRUCE_TREES, clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
    public static final Holder<PlacedFeature> BLUE_SPRUCE_TREES = createPlacedFeature("blue_spruce_trees", BYGOverworldTreeFeatures.BLUE_SPRUCE_TREES, clearingTreePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
    public static final Holder<PlacedFeature> SPRUCE_TREES_SPARSE = createPlacedFeature("sparse_spruce_trees", BYGOverworldTreeFeatures.SPRUCE_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
    public static final Holder<PlacedFeature> BROWN_ZELKOVA_TREES = createPlacedFeature("brown_zelkova_trees", BYGOverworldTreeFeatures.BROWN_ZELKOVA_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));
    public static final Holder<PlacedFeature> ZELKOVA_TREES = createPlacedFeature("zelkova_trees", BYGOverworldTreeFeatures.ZELKOVA_TREES, clearingTreePlacement(PlacementUtils.countExtra(5, 0.2F, 2)));
    public static final Holder<PlacedFeature> RAINBOW_EUCALYPTUS_TREES = createPlacedFeature("rainbow_eucalyptus_trees", BYGOverworldTreeFeatures.RAINBOW_EUCALYPTUS_TREES, PlacementUtils.countExtra(6, 0.2F, 1), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter.biome());
    public static final Holder<PlacedFeature> TEMPERATE_RAINFOREST_TREES = createPlacedFeature("temperate_rainforest_trees", BYGOverworldTreeFeatures.TEMPERATE_RAINFOREST_TREES, clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));
    public static final Holder<PlacedFeature> MEADOW_TREES = createPlacedFeature("meadow_trees", BYGOverworldTreeFeatures.MEADOW_TREES, clearingTreePlacement(PlacementUtils.countExtra(2, 0.25F, 3)));
    public static final Holder<PlacedFeature> MEADOW_TREES_SPARSE = createPlacedFeature("sparse_meadow_trees", BYGOverworldTreeFeatures.MEADOW_TREES, clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1)));
    public static final Holder<PlacedFeature> LARGE_BOULDERS = createPlacedFeature("large_boulders", BYGOverworldFeatures.LARGE_BOULDER, oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(12), BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(BlockTags.DIRT, BlockPos.ZERO.relative(Direction.DOWN)))));
    public static final Holder<PlacedFeature> LARGE_GRANITE_BOULDERS = createPlacedFeature("large_granite_boulders", BYGOverworldFeatures.LARGE_GRANITE_BOULDER, oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(12), BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(BlockTags.DIRT, BlockPos.ZERO.relative(Direction.DOWN)))));
    public static final Holder<PlacedFeature> LARGE_WINDSWEPT_BOULDERS = createPlacedFeature("large_windswept_boulders", BYGOverworldFeatures.LARGE_WINDSWEPT_BOULDER, oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(20), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlock(BYGBlocks.WINDSWEPT_SAND, new BlockPos(0, -1, 0))), RandomOffsetPlacement.vertical(BiasedToBottomInt.of(-4, -3))));
    public static final Holder<PlacedFeature> ROSE_FIELD_FLOWERS = createPlacedFeature("rose_field_flowers", BYGOverworldVegetationFeatures.ROSE_FIELD_FLOWERS, worldSurfaceSquaredWithCount(20));
    public static final Holder<PlacedFeature> FROST_MAGMA_LAKE = createPlacedFeature("frost_magma_lake", BYGOverworldFeatures.FROST_MAGMA_LAKE, worldSurfaceSquaredWithCount(3));
    public static final Holder<PlacedFeature> TINY_LILY_PAD = createPlacedFeature("tiny_lily_pad", BYGOverworldVegetationFeatures.TINY_LILY_PAD, CountPlacement.of(15), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter.biome());
    public static final Holder<PlacedFeature> LILY_PAD = createPlacedFeature("lily_pad", VegetationFeatures.PATCH_WATERLILY, CountPlacement.of(15), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_GRASS_CRAG = createPlacedFeature("patch_grass_crag", VegetationFeatures.PATCH_GRASS_JUNGLE, CountPlacement.of(25), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter.biome());

    public static final Holder<PlacedFeature> SPARSE_HUGE_MUSHROOMS = createPlacedFeature("sparse_huge_mushrooms", BYGOverworldVegetationFeatures.HUGE_MUSHROOMS, clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 2)));
    public static final Holder<PlacedFeature> HUGE_MUSHROOMS = createPlacedFeature("huge_mushrooms", BYGOverworldVegetationFeatures.HUGE_MUSHROOMS, clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2)));

    public static final Holder<PlacedFeature> MEADOW_SHRUBS = createPlacedFeature("meadow_shrubs", BYGOverworldTreeFeatures.MEADOW_SHRUBS, clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 2)));
    public static final Holder<PlacedFeature> FIRECRACKER_SHRUBS = createPlacedFeature("firecracker_shrubs", BYGOverworldTreeFeatures.FIRECRACKER_SHRUBS, clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 2)));

    public static final Holder<PlacedFeature> SPARSE_RED_OAK_TREES = createPlacedFeature("sparse_red_oak_trees", BYGOverworldTreeFeatures.RED_OAK_TREES, clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 1)));

    public static final Holder<PlacedFeature> SPARSE_JACARANDA_TREES = createPlacedFeature("sparse_jacaranda_trees", BYGOverworldTreeFeatures.JACARANDA_TREES, clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 2)));
    public static final Holder<PlacedFeature> SPARSE_ARAUCARIA_TREES = createPlacedFeature("sparse_araucaria_trees", BYGOverworldTreeFeatures.ARAUCARIA_TREES, clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 3)));

    public static final Holder<PlacedFeature> DISK_MUD = createPlacedFeature("disk_mud", BYGOverworldFeatures.DISK_MUD, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());

    public static final Holder<PlacedFeature> MOSSY_STONE_BOULDER = createPlacedFeature("mossy_stone_boulder", BYGOverworldFeatures.MOSSY_STONE_BOULDER, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> BEEHIVES = createPlacedFeature("beehives", BYGOverworldFeatures.BEEHIVES, CountPlacement.of(2), InSquarePlacement.spread(), BiomeFilter.biome());
    public static final Holder<PlacedFeature> ROCKY_STONE_BOULDER = createPlacedFeature("rocky_stone_boulder", BYGOverworldFeatures.ROCKY_STONE_BOULDER, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> BLACKSTONE_BOULDER = createPlacedFeature("blackstone_boulder", BYGOverworldFeatures.BLACKSTONE_BOULDER, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> ORANGE_TERRACOTTA_BOULDER = createPlacedFeature("orange_terracotta_boulder", BYGOverworldFeatures.ORANGE_TERRACOTTA_BOULDER, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> BLACK_ICE_SNOW = createPlacedFeature("black_ice_snow", BYGOverworldFeatures.BLACK_ICE, ChunkCoveringPlacement.INSTANCE, PlacementUtils.HEIGHTMAP_WORLD_SURFACE, RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlock(Blocks.WATER, BlockPos.ZERO)), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlock(Blocks.AIR, new BlockPos(0, 1, 0))));
    public static final Holder<PlacedFeature> STONE_FOREST_COLUMN = createPlacedFeature("stone_forest_column", BYGOverworldFeatures.STONE_FOREST_COLUMN, oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(2)));
    public static final Holder<PlacedFeature> IVIS_FIELDS_SPIKE = createPlacedFeature("ivis_fields_spike", BYGEndFeatures.IVIS_FIELDS_SPIKE, oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(9), BlockPredicateFilter.forPredicate(BlockPredicate.solid(new BlockPos(0, -1, 0)))));
    public static final Holder<PlacedFeature> IVIS_FIELDS_COLUMN = createPlacedFeature("ivis_fields_column", BYGEndFeatures.IVIS_FIELDS_COLUMN, oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(16), BlockPredicateFilter.forPredicate(BlockPredicate.solid(new BlockPos(0, -1, 0)))));
    public static final Holder<PlacedFeature> LARGE_WINDSWEPT_LAKE = createPlacedFeature("large_windswept_lake", BYGOverworldFeatures.LARGE_WINDSWEPT_LAKE, Util.make(new ArrayList<>(worldSurfaceSquaredWithCount(1)), list -> list.addAll(List.of(RarityFilter.onAverageOnceEvery(36), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.anyOf(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0)))))))));
    public static final Holder<PlacedFeature> END_LAKE = createPlacedFeature("end_lake", BYGEndFeatures.END_LAKE, Util.make(new ArrayList<>(worldSurfaceSquaredWithCount(1)), list -> list.addAll(List.of(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.solid(BlockPos.ZERO.relative(Direction.DOWN))), BiomeFilter.biome()))));

    public static final Holder<PlacedFeature> LUSH_STACKS_SPIKES = createPlacedFeature("lush_stacks_spikes", BYGOverworldFeatures.LUSH_STACKS_SPIKES, new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(1)).add(LUSH_STACKS_SPIKES_NOISE).build());
    public static final Holder<PlacedFeature> DEAD_SEA_SPIKES = createPlacedFeature("dead_sea_spikes", BYGOverworldFeatures.DEAD_SEA_SPIKES, new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(1)).add(LUSH_STACKS_SPIKES_NOISE).build());
    public static final Holder<PlacedFeature> CRYPTIC_SPIKE = createPlacedFeature("cryptic_spikes", BYGEndFeatures.CRYPTIC_SPIKE, new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(1)).add(RarityFilter.onAverageOnceEvery(3)).build());
    public static final Holder<PlacedFeature> RED_ROCK_SPIKES = createPlacedFeature("red_rock_spikes", BYGOverworldFeatures.RED_ROCK_SPIKE, new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(1)).add(RarityFilter.onAverageOnceEvery(24)).build());
    public static final Holder<PlacedFeature> WINDSWEPT_SPIKES = createPlacedFeature("windswept_spikes", BYGOverworldFeatures.WINDSWEPT_SPIKES, NoiseThresholdCountPlacement.of(0.6, 0, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.anyOf(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0))))), BiomeFilter.biome());
    public static final Holder<PlacedFeature> CRYPTIC_REDSTONE = createPlacedFeature("cryptic_redstone", BYGEndFeatures.ORE_CRYPTIC_REDSTONE, new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(8)).add(RandomOffsetPlacement.vertical(BiasedToBottomInt.of(-15, -2))).build());
//    public static final Holder<PlacedFeature> BRIMSTONE_VENTS = createPlacedFeature("brimstone_vents", BYGNetherFeatures.BRIMSTONE_VENTS, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());


    public static final Holder<PlacedFeature> CRYPTIC_CAVE = createPlacedFeature("cryptic_caves", BYGEndFeatures.CRYPTIC_CAVES, new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(2)).add(RandomOffsetPlacement.vertical(BiasedToBottomInt.of(-15, -7))).build());
    public static final Holder<PlacedFeature> CRYPTIC_VENTS = createPlacedFeature("cryptic_vents", BYGEndFeatures.CRYPTIC_VENT_PATCHES, new ImmutableList.Builder<PlacementModifier>().add(RarityFilter.onAverageOnceEvery(2)).addAll(oceanFloorSquaredWithCount(3)).build());


    public static final Holder<PlacedFeature> QUARTZ_SPIKE = createPlacedFeature("quartz_spike", BYGNetherFeatures.QUARTZ_SPIKE, NoiseThresholdCountPlacement.of(0.6, 0, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.anyOf(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0))))), BiomeFilter.biome());

    public static final Holder<PlacedFeature> ISLANDS = createPlacedFeature("islands", BYGEndFeatures.ISLANDS, CountPlacement.of(1), RarityFilter.onAverageOnceEvery(6), HeightRangePlacement.uniform(VerticalAnchor.absolute(200), VerticalAnchor.absolute(230)), InSquarePlacement.spread(), BiomeFilter.biome());

    public static final Holder<PlacedFeature> ORE_GOLD_BRIMSTONE = createPlacedFeature("ore_gold_brimstone", BYGNetherFeatures.ORE_GOLD_BRIMSTONE, byg_invokeCommonOrePlacement(10, PlacementUtils.RANGE_10_10));
    public static final Holder<PlacedFeature> ORE_QUARTZ_BRIMSTONE = createPlacedFeature("ore_quartz_brimstone", BYGNetherFeatures.ORE_QUARTZ_BRIMSTONE, byg_invokeCommonOrePlacement(16, PlacementUtils.RANGE_10_10));
    public static final Holder<PlacedFeature> ORE_GOLD_BLUE_NETHERRACK = createPlacedFeature("ore_gold_blue_netherrack", BYGNetherFeatures.ORE_GOLD_BLUE_NETHERRACK, byg_invokeCommonOrePlacement(10, PlacementUtils.RANGE_10_10));
    public static final Holder<PlacedFeature> ORE_QUARTZ_BLUE_NETHERRACK = createPlacedFeature("ore_quartz_blue_netherrack", BYGNetherFeatures.ORE_QUARTZ_BLUE_NETHERRACK, byg_invokeCommonOrePlacement(16, PlacementUtils.RANGE_10_10));
    public static final Holder<PlacedFeature> ORE_ANTHRACITE = createPlacedFeature("ore_anthracite", BYGNetherFeatures.ORE_ANTHRACITE, byg_invokeCommonOrePlacement(20, PlacementUtils.RANGE_10_10));

    public static final Holder<PlacedFeature> BORIC_FIRE = createPlacedFeature("patch_boric_fire", BYGNetherFeatures.BORIC_FIRE_PATCH, CountOnEveryLayerPlacement.of(8), BiomeFilter.biome());
    public static final Holder<PlacedFeature> BRIMSTONE_VOLCANO = createPlacedFeature("brimstone_volcano", BYGNetherFeatures.BRIMSTONE_VOLCANO, CountOnEveryLayerPlacement.of(3), BiomeFilter.biome());
    public static final Holder<PlacedFeature> CRAG_GEN = createPlacedFeature("crag_gen", BYGOverworldFeatures.CRAG_GEN, CountOnEveryLayerPlacement.of(3), BiomeFilter.biome(), new AboveHeightmapFilter(Heightmap.Types.OCEAN_FLOOR_WG), CRAG_NOISE);
    public static final Holder<PlacedFeature> ARCH_FEATURE = createPlacedFeature("arch_feature", BYGOverworldFeatures.ARCH_FEATURE, InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(12), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
    public static final Holder<PlacedFeature> CRAG_DELTA = createPlacedFeature("crag_delta", BYGOverworldFeatures.CRAG_DELTA, oceanFloorSquaredWithCount(3));
    public static final Holder<PlacedFeature> VINES_1 = createPlacedFeature("vines", VegetationFeatures.VINES, CountPlacement.of(256), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)), BiomeFilter.biome());
    public static final Holder<PlacedFeature> VINES_2 = createPlacedFeature("vines_2", VegetationFeatures.VINES, CountPlacement.of(256), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)), BiomeFilter.biome());

    public static final Holder<PlacedFeature> BRIMSTONE_PILLARS = createPlacedFeature("brimstone_pillars", BYGNetherFeatures.BRIMSTONE_PILLARS, CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> MAGMA_PILLARS = createPlacedFeature("magma_pillars", BYGNetherFeatures.MAGMA_PILLARS, CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> FROST_MAGMA_PILLARS = createPlacedFeature("frost_magma_pillars", BYGNetherFeatures.FROST_MAGMA_PILLARS, CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> SOUL_SOIL_PILLARS = createPlacedFeature("soul_soil_pillars", BYGNetherFeatures.SOUL_SOIL_PILLARS, CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> SYTHIAN_FUNGUS_PILLARS = createPlacedFeature("sythian_fungus_pillars", BYGNetherFeatures.SYTHIAN_FUNGUS_PILLARS, CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> EMBUR_ROOTS = createPlacedFeature("embur_roots", BYGNetherVegetationFeatures.EMBUR_ROOTS, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> TALL_EMBUR_ROOTS = createPlacedFeature("tall_embur_roots", BYGNetherVegetationFeatures.TALL_EMBUR_ROOTS, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> EMBUR_WART = createPlacedFeature("embur_wart", BYGNetherVegetationFeatures.EMBUR_WART, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> EMBUR_SPROUT = createPlacedFeature("embur_sprout", BYGNetherVegetationFeatures.EMBUR_SPROUT, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SYTHIAN_ROOTS = createPlacedFeature("sythian_roots", BYGNetherVegetationFeatures.SYTHIAN_ROOTS, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SYTHIAN_SPROUT = createPlacedFeature("sythian_sprout", BYGNetherVegetationFeatures.SYTHIAN_SPROUT, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SYTHIAN_FUNGUS = createPlacedFeature("sythian_fungus", BYGNetherVegetationFeatures.SYTHIAN_FUNGUS, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WARPED_CACTI = createPlacedFeature("warped_cacti", BYGNetherVegetationFeatures.WARPED_CACTI, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WARPED_BUSH = createPlacedFeature("warped_bush", BYGNetherVegetationFeatures.WARPED_BUSH, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WARPED_CORAL = createPlacedFeature("warped_coral", BYGNetherVegetationFeatures.WARPED_CORAL, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WARPED_CORAL_FAN = createPlacedFeature("warped_coral_fan", BYGNetherVegetationFeatures.WARPED_CORAL_FAN, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> TALL_CRIMSON_ROOTS = createPlacedFeature("tall_crimson_roots", BYGNetherVegetationFeatures.TALL_CRIMSON_ROOTS, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> CRIMSON_BERRY_BUSH = createPlacedFeature("crimson_berry_bush", BYGNetherVegetationFeatures.CRIMSON_BERRY_BUSH, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> CHAINS = createPlacedFeature("chains", BYGNetherVegetationFeatures.CHAINS, HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome());
    public static final Holder<PlacedFeature> CRIMSON_GARDEN_VEGETATION = createPlacedFeature("crimson_garden_vegetation", BYGNetherVegetationFeatures.CRIMSON_GARDEN_VEGETATION, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> EMBUR_BOG_VEGETATION = createPlacedFeature("embur_bog_vegetation", BYGNetherVegetationFeatures.EMBUR_BOG_VEGETATION, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> GLOWSTONE_GARDEN_VEGETATION = createPlacedFeature("glowstone_garden_vegetation", BYGNetherVegetationFeatures.GLOWSTONE_GARDEN_VEGETATION, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SYTHIAN_VEGETATION = createPlacedFeature("sythian_vegetation", BYGNetherVegetationFeatures.SYTHIAN_VEGETATION, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> EMBUR_LILY = createPlacedFeature("embur_lily", BYGNetherVegetationFeatures.EMBUR_LILY, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> FUNGI = createPlacedFeature("fungi", BYGNetherVegetationFeatures.FUNGI, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> BLACKSTONE_BOULDERS_NETHER = createPlacedFeature("blackstone_boulders_nether", BYGOverworldFeatures.BLACKSTONE_BOULDER, CountOnEveryLayerPlacement.of(2), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WEEPING_VINES = createPlacedFeature("weeping_vines", BYGNetherVegetationFeatures.WEEPING_VINES, CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WEEPING_ROOTS = createPlacedFeature("weeping_roots", BYGNetherVegetationFeatures.WEEPING_ROOTS, CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WAILING_VINES = createPlacedFeature("wailing_vines", BYGNetherVegetationFeatures.WAILING_VINE, CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome());
    public static final Holder<PlacedFeature> HANGING_SYTHIAN_ROOTS = createPlacedFeature("hanging_sythian_roots", BYGNetherVegetationFeatures.HANGING_SYTHIAN_ROOTS, CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SUBZERO_CRYSTALS = createPlacedFeature("subzero_crystals", BYGNetherFeatures.SUBZERO_CRYSTAL, CountOnEveryLayerPlacement.of(35), BiomeFilter.biome());
    public static final Holder<PlacedFeature> HANGING_BONE_FEATURE = createPlacedFeature("hanging_bone_feature", BYGNetherVegetationFeatures.HANGING_BONES, CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome());
    public static final Holder<PlacedFeature> HANGING_CHAINS = createPlacedFeature("hanging_chains", BYGNetherFeatures.HANGING_CHAINS, CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome());
    public static final Holder<PlacedFeature> HANGING_LANTERNS = createPlacedFeature("hanging_lanterns", BYGNetherFeatures.HANGING_LANTERNS, CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome());
    public static final Holder<PlacedFeature> HANGING_SOUL_SHROOM_SPORES = createPlacedFeature("hanging_soul_shroom_spores", BYGNetherVegetationFeatures.HANGING_SOUL_SHROOM_SPORES, CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome());
    public static final Holder<PlacedFeature> LAMENT_VINE_FEATURE = createPlacedFeature("lament_vine_feature", BYGNetherVegetationFeatures.LAMENT_VINE_FEATURE, CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome());
    public static final Holder<PlacedFeature> EMBUR_MUSHROOMS = createPlacedFeature("embur_mushrooms", BYGNetherVegetationFeatures.EMBUR_MUSHROOMS, CountOnEveryLayerPlacement.of(3), BiomeFilter.biome());
    public static final Holder<PlacedFeature> LAMENT_VEGETATION = createPlacedFeature("lament_vegetation", BYGNetherVegetationFeatures.LAMENT_VEGETATION, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SPARSE_WITHERING_OAK_TREES = createPlacedFeature("sparse_withering_oak_trees", BYGNetherVegetationFeatures.WITHERING_OAK_TREES, CountOnEveryLayerPlacement.of(4), RarityFilter.onAverageOnceEvery(3), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WITHERING_OAK_TREES = createPlacedFeature("withering_oak_trees", BYGNetherVegetationFeatures.WITHERING_OAK_TREES, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SOUL_SHROOM_TREES = createPlacedFeature("soul_shroom_trees", BYGNetherVegetationFeatures.SOUL_SHROOM_TREES, CountOnEveryLayerPlacement.of(8), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SYTHIAN_FUNGI_TREES = createPlacedFeature("sythian_fungi_trees", BYGNetherVegetationFeatures.SYTHIAN_FUNGI_TREES, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SYTHIAN_STALK = createPlacedFeature("sythian_stalk", BYGNetherVegetationFeatures.SYTHIAN_STALK, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> DEATH_CAP_TREES = createPlacedFeature("death_cap_trees", BYGNetherVegetationFeatures.DEATH_CAP_TREES, CountOnEveryLayerPlacement.of(6), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SUBZERO_ASHES = createPlacedFeature("subzero_ashes", BYGNetherFeatures.SUBZERO_ASHES, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> QUARTZ_CRYSTALS = createPlacedFeature("quartz_crystals", BYGNetherFeatures.QUARTZ_CRYSTAL, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> QUARTZ_COLUMNS = createPlacedFeature("quartz_columns", BYGNetherFeatures.QUARTZ_COLUMNS, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SCORCHED_PLANTS = createPlacedFeature("scorched_plants", BYGNetherVegetationFeatures.SCORCHED_PLANTS, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WARPED_CORAL_PLANT = createPlacedFeature("warped_coral_plant", BYGNetherVegetationFeatures.WARPED_CORAL_PLANT, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WARPED_DESERT_VEGETATION = createPlacedFeature("warped_desert_vegetation", BYGNetherVegetationFeatures.WARPED_DESERT_VEGETATION, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WAILING_VEGETATION = createPlacedFeature("wailing_vegetation", BYGNetherVegetationFeatures.WAILING_VEGETATION, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> MINI_MUSHROOMS = createPlacedFeature("mini_mushrooms", BYGNetherVegetationFeatures.MINI_MUSHROOMS, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> TWISTY_LAMENT_TREES = createPlacedFeature("twisty_lament_trees", BYGNetherVegetationFeatures.TWISTY_LAMENT_TREES, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WEEPING_LAMENT_TREES = createPlacedFeature("weeping_lament_trees", BYGNetherVegetationFeatures.WEEPING_LAMENT_TREES, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> WAILING_PILLARS = createPlacedFeature("wailing_pillar", BYGNetherFeatures.WAILING_PILLAR, CountOnEveryLayerPlacement.of(1), RarityFilter.onAverageOnceEvery(4), BiomeFilter.biome());
    public static final Holder<PlacedFeature> MAGMA_PATCH_FIRE = createPlacedFeature("magma_patch_fire", BYGNetherFeatures.MAGMA_PATCH_FIRE, CountPlacement.of(UniformInt.of(30, 45)), InSquarePlacement.spread(), PlacementUtils.RANGE_4_4, BiomeFilter.biome());
    public static final Holder<PlacedFeature> NYLIUM_SOUL_PATCH_FIRE = createPlacedFeature("nylium_soul_patch_fire", BYGNetherFeatures.NYLIUM_SOUL_PATCH_FIRE, CountPlacement.of(UniformInt.of(5, 10)), InSquarePlacement.spread(), PlacementUtils.RANGE_4_4, BiomeFilter.biome());

}
