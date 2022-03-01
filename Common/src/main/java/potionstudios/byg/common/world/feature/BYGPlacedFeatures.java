package potionstudios.byg.common.world.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
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
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;
import static net.minecraft.data.worldgen.placement.VegetationPlacements.worldSurfaceSquaredWithCount;
import static potionstudios.byg.mixin.access.OrePlacementsAccess.invokeCommonOrePlacement;

public class BYGPlacedFeatures {

    public static final NoiseThresholdCountPlacement CLEARING_NOISE = NoiseThresholdCountPlacement.of(0.545, 1, 0);
    public static final NoiseThresholdCountPlacement CRAG_NOISE = NoiseThresholdCountPlacement.of(0, 1, 0);

    public static final NoiseThresholdCountPlacement DENSE_NOISE = NoiseThresholdCountPlacement.of(-0.545, 1, 2);


    public static final PlacedFeature ALLIUM_FIELD_FLOWERS = createPlacedFeature("allium_field_flowers", BYGOverworldVegetationFeatures.ALLIUM_FIELD_FLOWERS.placed(worldSurfaceSquaredWithCount(20)));
    public static final PlacedFeature PINK_ALLIUMS = createPlacedFeature("pink_alliums", BYGOverworldVegetationFeatures.ALLIUM_PINK.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature AMARANTH_FIELD_FLOWERS = createPlacedFeature("amaranth_field_flowers", BYGOverworldVegetationFeatures.AMARANTH_FIELD_FLOWERS.placed(worldSurfaceSquaredWithCount(20)));
    public static final PlacedFeature DUNE_TERRAIN = createPlacedFeature("dune_terrain", BYGOverworldVegetationFeatures.DUNE_TERRAIN.placed());

    public static final PlacedFeature SHRUB = createPlacedFeature("shrub", BYGOverworldVegetationFeatures.SHRUB.placed(worldSurfaceSquaredWithCount(1)));

    public static final PlacedFeature FIRECRACKER_BUSH = createPlacedFeature("firecracker_bush", BYGOverworldVegetationFeatures.FIRECRACKER_BUSH.placed(worldSurfaceSquaredWithCount(3)));
    public static final PlacedFeature BLUE_BERRY_BUSH = createPlacedFeature("blue_berry_bush", BYGOverworldVegetationFeatures.BLUE_BERRY_BUSH.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature BLUE_BERRY_BUSH_LUSH = createPlacedFeature("blue_berry_bush_lush", BYGOverworldVegetationFeatures.BLUE_BERRY_BUSH.placed(worldSurfaceSquaredWithCount(5)));

    public static final PlacedFeature CATTAIL = createPlacedFeature("cattails", BYGOverworldVegetationFeatures.CATTAIL.placed(oceanFloorSquaredWithCountAndMaxDepth(25, OptionalInt.of(2))));
    public static final PlacedFeature LEATHER_FLOWERS = createPlacedFeature("leather_flowers", BYGOverworldVegetationFeatures.LEATHER_FLOWERS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature LEAF_PILES = createPlacedFeature("leaf_piles", BYGOverworldVegetationFeatures.LEAF_PILE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature LOLLIPOP_FLOWERS = createPlacedFeature("lollipop_flowers", BYGOverworldVegetationFeatures.LOLLIPOP_FLOWER.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature CLOVER_FLOWERS = createPlacedFeature("clover_flower_patch", BYGOverworldVegetationFeatures.CLOVER_PATCH.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature CRYPTIC_BRAMBLE = createPlacedFeature("cryptic_bramble", BYGEndVegetationFeatures.CRYPTIC_BRAMBLE_PATCH.placed(new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(2)).build()));
    public static final PlacedFeature CROCUS = createPlacedFeature("crocus", BYGOverworldVegetationFeatures.CROCUS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature ANEMONES = createPlacedFeature("anemones", BYGOverworldVegetationFeatures.ANEMONES.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature MEADOW_GRASS = createPlacedFeature("meadow_grass", VegetationFeatures.PATCH_GRASS.placed(worldSurfaceSquaredWithCount(8)));
    public static final PlacedFeature ALPINE_BELLFLOWER = createPlacedFeature("alpine_bellflower", BYGOverworldVegetationFeatures.ALPINE_BELLFLOWER.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature ROSES = createPlacedFeature("rose", BYGOverworldVegetationFeatures.ROSE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature BLACK_ROSE = createPlacedFeature("black_rose", BYGOverworldVegetationFeatures.BLACK_ROSE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature BULBIS_ODDITIES = createPlacedFeature("bulbis_oddities", BYGEndVegetationFeatures.BULBIS_ODDITIES.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature BULBIS_SPROUTS = createPlacedFeature("bulbis_sprouts", BYGEndVegetationFeatures.BULBIS_SPROUTS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature THEREAL_BELLFLOWER = createPlacedFeature("thereal_bellflower", BYGEndVegetationFeatures.THEREAL_BELLFLOWER.placed(worldSurfaceSquaredWithCount(6)));
    public static final PlacedFeature IVIS_PLANTS = createPlacedFeature("ivis_plants", BYGEndVegetationFeatures.IVIS_PLANTS.placed(worldSurfaceSquaredWithCount(5)));
    public static final PlacedFeature ETHER_PLANTS = createPlacedFeature("ether_plants", BYGEndVegetationFeatures.ETHER_PLANTS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature ETHER_BULBS = createPlacedFeature("ether_bulbs", BYGEndVegetationFeatures.ETHER_BULB.placed(CountPlacement.of(UniformInt.of(15, 25)), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
    public static final PlacedFeature ENDER_LILY = createPlacedFeature("ender_lily", BYGEndVegetationFeatures.ENDER_LILY.placed(worldSurfaceSquaredWithCount(6)));
    public static final PlacedFeature NIGHTSHADE_PLANTS = createPlacedFeature("nightshade_plants", BYGEndVegetationFeatures.NIGHTSHADE_PLANTS.placed(worldSurfaceSquaredWithCount(7)));
    public static final PlacedFeature IMPARIUS_PLANTS = createPlacedFeature("imparius_plants", BYGEndVegetationFeatures.IMPARIUS_PLANTS.placed(worldSurfaceSquaredWithCount(12)));
    public static final PlacedFeature SPARSE_BULBIS_ANOMALIES = createPlacedFeature("sparse_anomalies", BYGEndVegetationFeatures.BULBIS_ANOMALIES.placed(new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(1)).add(RarityFilter.onAverageOnceEvery(4)).build()));
    public static final PlacedFeature BULBIS_ANOMALIES = createPlacedFeature("bulbis_anomalies", BYGEndVegetationFeatures.BULBIS_ANOMALIES.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature SHULKREN_PLANTS = createPlacedFeature("shulkren_plants", BYGEndVegetationFeatures.SHULKREN_PLANTS.placed(worldSurfaceSquaredWithCount(5)));
    public static final PlacedFeature SHULKREN_HANGING_VINES = createPlacedFeature("shulkren_hanging_vines", BYGEndVegetationFeatures.HANGING_SHULKREN_VINE.placed(CountPlacement.of(6), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
    public static final PlacedFeature THERIUM_DEPOSIT = createPlacedFeature("therium_deposit", BYGEndFeatures.THERIUM_CRYSTAL_DEPOSIT_LARGE.placed(new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(1)).add(RarityFilter.onAverageOnceEvery(65)).add(BiomeFilter.biome()).build()));
    public static final PlacedFeature CYAN_ROSE = createPlacedFeature("cyan_rose", BYGOverworldVegetationFeatures.CYAN_ROSE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature CRYPTIC_FIRE = createPlacedFeature("cryptic_fire", BYGEndFeatures.CRYPTIC_FIRE_PATCH.placed(new ImmutableList.Builder<PlacementModifier>().addAll(worldSurfaceSquaredWithCount(2)).build()));
    public static final PlacedFeature KOVAN_FLOWERS = createPlacedFeature("kovan_flowers", BYGOverworldVegetationFeatures.KOVAN_FLOWER.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature DAISY_ORANGE = createPlacedFeature("orange_daisy", BYGOverworldVegetationFeatures.DAISY_ORANGE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature JAPANESE_ORCHID = createPlacedFeature("japanese_orchid", BYGOverworldVegetationFeatures.JAPANESE_ORCHID.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature FOXGLOVES = createPlacedFeature("foxgloves", BYGOverworldVegetationFeatures.FOXGLOVE.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature FAIRY_SLIPPER = createPlacedFeature("fairy_slipper", BYGOverworldVegetationFeatures.FAIRY_SLIPPER.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature CHERRY_FOLIAGE = createPlacedFeature("cherry_foliage", BYGOverworldVegetationFeatures.CHERRY_FOLIAGE.placed(worldSurfaceSquaredWithCount(6)));
    public static final PlacedFeature WINTER_ROSES = createPlacedFeature("winter_roses", BYGOverworldVegetationFeatures.ROSE_WINTER.placed(worldSurfaceSquaredWithCount(6)));
    public static final PlacedFeature HORSEWEED = createPlacedFeature("horseweed", BYGOverworldVegetationFeatures.HORSEWEED.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature PRAIRIE_GRASS = createPlacedFeature("prairie_grass", BYGOverworldVegetationFeatures.PRAIRIE_GRASS.placed(CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    public static final PlacedFeature IRIS = createPlacedFeature("iris", BYGOverworldVegetationFeatures.IRIS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature TULIPS = createPlacedFeature("tulips", BYGOverworldVegetationFeatures.TULIPS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature WHITE_PUFFBALL = createPlacedFeature("white_puffball", BYGOverworldVegetationFeatures.WHITE_PUFFBALL.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature SAGES = createPlacedFeature("sages", BYGOverworldVegetationFeatures.SAGES.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature HYDRANGEAS = createPlacedFeature("hydrangeas", BYGOverworldVegetationFeatures.HYDRANGEAS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature DESERT_VEGETATION = createPlacedFeature("desert_vegetation", BYGOverworldVegetationFeatures.DESERT_VEGETATION.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature LUSH_DESERT_VEGETATION = createPlacedFeature("lush_desert_vegetation", BYGOverworldVegetationFeatures.DESERT_VEGETATION.placed(worldSurfaceSquaredWithCount(10)));
    public static final PlacedFeature PATCH_BEACH_GRASS_NOISE = createPlacedFeature("patch_beach_grass_noise", BYGOverworldVegetationFeatures.BEACH_GRASS.placed(NoiseThresholdCountPlacement.of(-0.45D, 7, 0), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    public static final PlacedFeature WINTER_SUCCULENT = createPlacedFeature("winter_succulent", BYGOverworldVegetationFeatures.WINTER_SUCCULENT.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature DAFFODIL_YELLOW = createPlacedFeature("yellow_daffodil", BYGOverworldVegetationFeatures.DAFFODIL_YELLOW.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature JUNGLE_FLOWERS = createPlacedFeature("jungle_flowers", BYGOverworldVegetationFeatures.JUNGLE_FLOWERS.placed(worldSurfaceSquaredWithCount(2)));
    public static final PlacedFeature LARGE_PUMPKINS = createPlacedFeature("large_pumpkins", BYGOverworldVegetationFeatures.LARGE_PUMPKINS.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 1))));
    public static final PlacedFeature SWAMP_WATER_VEGETATION = createPlacedFeature("swamp_water_vegetation", BYGOverworldVegetationFeatures.SWAMP_WATER_VEGETATION.placed(worldSurfaceSquaredWithCount(25)));

    public static final PlacedFeature MUSHROOMS = createPlacedFeature("mushrooms", BYGOverworldVegetationFeatures.MUSHROOMS.placed(VegetationPlacementsAccess.invokeGetMushroomPlacement(512, null)));
    public static final PlacedFeature ARAUCARIA_TREES = createPlacedFeature("araucaria_trees", BYGOverworldTreeFeatures.ARAUCARIA_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature ASPEN_SHRUBS = createPlacedFeature("aspen_shrubs", BYGOverworldTreeFeatures.ASPEN_SHRUBS.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));
    public static final PlacedFeature ASPEN_TREES = createPlacedFeature("aspen_trees", BYGOverworldTreeFeatures.ASPEN_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(6, 0.25F, 3))));
    public static final PlacedFeature ASPEN_TREES_SPARSE = createPlacedFeature("aspen_trees_sparse", BYGOverworldTreeFeatures.ASPEN_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1))));
    public static final PlacedFeature BAOBAB_TREES = createPlacedFeature("baobab_trees", BYGOverworldTreeFeatures.BAOBAB_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1))));
    public static final PlacedFeature NIGHTSHADE_TREES = createPlacedFeature("nightshade_tree", BYGEndVegetationFeatures.NIGHTSHADE_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 1))));
    public static final PlacedFeature NIGHTSHADE_SHRUBS = createPlacedFeature("nightshade_shrubs", BYGEndVegetationFeatures.NIGHTSHADE_SHRUBS.placed(clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 1))));
    public static final PlacedFeature BOREAL_TREES = createPlacedFeature("boreal_trees", BYGOverworldTreeFeatures.BOREAL_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 2))));
    public static final PlacedFeature BAYOU_TREES = createPlacedFeature("bayou_trees", BYGOverworldTreeFeatures.BAYOU_TREES.placed(clearingTreePlacementBaseOceanFloor(PlacementUtils.countExtra(4, 0.2F, 2))));
    public static final PlacedFeature BLACK_FOREST_TREES = createPlacedFeature("black_forest_trees", BYGOverworldTreeFeatures.BLACK_FOREST_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(8, 0.2F, 2))));
    public static final PlacedFeature CANADIAN_SHIELD_TREES = createPlacedFeature("canadian_shield_trees", BYGOverworldTreeFeatures.CANADIAN_SHIELD_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 2))));
    public static final PlacedFeature CHERRY_TREES = createPlacedFeature("cherry_trees", BYGOverworldTreeFeatures.CHERRY_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(6, 0.25F, 2))));
    public static final PlacedFeature CIKA_TREES = createPlacedFeature("cika_trees", BYGOverworldTreeFeatures.CIKA_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(2, 0.25F, 2))));
    public static final PlacedFeature CONIFER_TREES = createPlacedFeature("conifer_trees", BYGOverworldTreeFeatures.CONIFER_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(7, 0.25F, 3))));
    public static final PlacedFeature CYPRESS_TREES = createPlacedFeature("cypress_trees", BYGOverworldTreeFeatures.CYPRESS_TREES.placed(clearingTreePlacementBaseOceanFloor(PlacementUtils.countExtra(4, 0.25F, 1))));
    public static final PlacedFeature DACITE_RIDGE_TREES = createPlacedFeature("dacite_ridge_trees", BYGOverworldTreeFeatures.DACITE_RIDGE_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature DECIDUOUS_TREES = createPlacedFeature("deciduous_trees", BYGOverworldTreeFeatures.DECIDUOUS_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 2))));
    public static final PlacedFeature EBONY_TREES = createPlacedFeature("ebony_trees", BYGOverworldTreeFeatures.EBONY_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 4))));
    public static final PlacedFeature ENCHANTED_TREES = createPlacedFeature("enchanted_trees", BYGOverworldTreeFeatures.ENCHANTED_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(5, 0.2F, 2))));
    public static final PlacedFeature TEMPERATE_GROVE_TREES = createPlacedFeature("temperate_grove_trees", BYGOverworldTreeFeatures.TEMPERATE_GROVE_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature JACARANDA_TREES = createPlacedFeature("jacaranda_trees", BYGOverworldTreeFeatures.JACARANDA_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 2))));
    public static final PlacedFeature JACARANDA_BUSHES = createPlacedFeature("jacaranda_bushes", BYGOverworldVegetationFeatures.JACARANDA_BUSHES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature JOSHUA_TREES = createPlacedFeature("joshua_tree", BYGOverworldTreeFeatures.JOSHUA_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 2))));
    public static final PlacedFeature MANGROVE_TREES = createPlacedFeature("mangrove_trees", BYGOverworldTreeFeatures.MANGROVE_TREES.placed(clearingTreePlacementBaseOceanFloor(PlacementUtils.countExtra(6, 0.25F, 2))));
    public static final PlacedFeature MAPLE_TREES = createPlacedFeature("maple_trees", BYGOverworldTreeFeatures.MAPLE_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 2))));
    public static final PlacedFeature NORTHERN_FOREST_TREES = createPlacedFeature("northern_forest_trees", BYGOverworldTreeFeatures.NORTHERN_FOREST_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(3, 0.25F, 3))));
    public static final PlacedFeature ORCHARD_TREES = createPlacedFeature("orchard_trees", BYGOverworldTreeFeatures.ORCHARD_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature HOLLY_TREES = createPlacedFeature("holly_trees", BYGOverworldTreeFeatures.HOLLY_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(4, 0.25F, 4))));
    public static final PlacedFeature HAZEL_TREES = createPlacedFeature("hazel_trees", BYGOverworldTreeFeatures.HAZEL_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature IMPARIUS_MUSHROOMS = createPlacedFeature("imparis_mushrooms", BYGEndVegetationFeatures.LARGE_IMPARIUS_MUSHROOMS.placed(treePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));
    public static final PlacedFeature SHULKREN_TREES = createPlacedFeature("shulkren_trees", BYGEndVegetationFeatures.SHULKREN_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.2F, 2))));
    public static final PlacedFeature SPARSE_ETHER_TREES = createPlacedFeature("sparse_ether_trees", BYGEndVegetationFeatures.ETHER_TREES.placed(new ImmutableList.Builder<PlacementModifier>().addAll(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))).add(RarityFilter.onAverageOnceEvery(2)).add(DENSE_NOISE).build()));
    public static final PlacedFeature DEAD_ETHER_TREES = createPlacedFeature("dead_ether_trees", BYGEndVegetationFeatures.DEAD_ETHER_TREES.placed(CountPlacement.of(7), HeightRangePlacement.uniform(VerticalAnchor.absolute(200), VerticalAnchor.absolute(256)), PlacementUtils.HEIGHTMAP, InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(2), BiomeFilter.biome()));
    public static final PlacedFeature HANGING_THERIUM_LANTERNS = createPlacedFeature("hanging_therium_lanterns", BYGEndFeatures.HANGING_THERIUM_LANTERNS.placed(CountPlacement.of(7), HeightRangePlacement.uniform(VerticalAnchor.absolute(200), VerticalAnchor.absolute(256)), RarityFilter.onAverageOnceEvery(4)));
    public static final PlacedFeature ETHER_FOLIAGE = createPlacedFeature("ether_foliage", BYGEndVegetationFeatures.ETHER_FOLIAGE.placed(new ImmutableList.Builder<PlacementModifier>().addAll(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))).add(RarityFilter.onAverageOnceEvery(2)).add(DENSE_NOISE).build()));
    public static final PlacedFeature ETHER_BUSHES = createPlacedFeature("ether_bushes", BYGEndVegetationFeatures.ETHER_BUSHES.placed(treePlacement(PlacementUtils.countExtra(0, 0.2F, 1))));
    public static final PlacedFeature FUNGAL_IMPARIUS = createPlacedFeature("fungal_imparis_mushrooms", BYGEndVegetationFeatures.FUNGAL_IMPARIUS.placed(treePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));
    public static final PlacedFeature SPARSE_OAK_TREES = createPlacedFeature("sparse_oak_trees", BYGOverworldTreeFeatures.OAK_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.1F, 1))));
    public static final PlacedFeature OAK_TREES = createPlacedFeature("oak_trees", BYGOverworldTreeFeatures.OAK_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature PALO_VERDE_TREES = createPlacedFeature("palo_verde_trees", BYGOverworldTreeFeatures.PALO_VERDE_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 1))));
    public static final PlacedFeature BULBIS_TREES = createPlacedFeature("bulbis_trees", BYGEndVegetationFeatures.BULBIS_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
    public static final PlacedFeature PURPLE_BULBIS_TREES = createPlacedFeature("purple_bulbis_trees", BYGEndVegetationFeatures.PURPLE_BULBIS_TREES.placed(treePlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
    public static final PlacedFeature SPARSE_PURPLE_BULBIS_TREES = createPlacedFeature("sparse_purple_bulbis_trees", BYGEndVegetationFeatures.PURPLE_BULBIS_TREES.placed(treePlacement(PlacementUtils.countExtra(0, 0.1F, 1))));
    public static final PlacedFeature PALM_TREES = createPlacedFeature("palm_trees", BYGOverworldTreeFeatures.PALM_TREES.placed(Util.make(new ArrayList<>(clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 1), BYGBlocks.PALM_SAPLING)), (list) -> {
        list.add(new NearWaterPlacementFilter(4));
    })));
    public static final PlacedFeature RED_OAK_TREES = createPlacedFeature("red_oak_trees", BYGOverworldTreeFeatures.RED_OAK_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature ORANGE_OAK_TREES = createPlacedFeature("orange_oak_trees", BYGOverworldTreeFeatures.ORANGE_OAK_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature BROWN_OAK_TREES = createPlacedFeature("brown_oak_trees", BYGOverworldTreeFeatures.BROWN_OAK_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature AUTUMNAL_OAK_TREES = createPlacedFeature("autumnal_oak_trees", BYGOverworldTreeFeatures.AUTUMNAL_OAK_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 1))));
    public static final PlacedFeature AUTUMNAL_SPRUCE_TREES = createPlacedFeature("autumnal_spruce_trees", BYGOverworldTreeFeatures.AUTUMNAL_SPRUCE_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(4, 0.2F, 1))));
    public static final PlacedFeature PRAIRIE_SHRUBS = createPlacedFeature("prairie_shrubs", BYGOverworldTreeFeatures.PRAIRIE_SHRUBS.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));
    public static final PlacedFeature GUIANA_SHIELD_TREES = createPlacedFeature("guiana_shield_trees", BYGOverworldTreeFeatures.GUIANA_SHIELD_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(15, 0.25F, 1))));
    public static final PlacedFeature RAINFOREST_TREES = createPlacedFeature("rainforest_trees", BYGOverworldTreeFeatures.RAINFOREST_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(15, 0.25F, 1))));
    public static final PlacedFeature REDWOOD_TREES = createPlacedFeature("redwood_trees", BYGOverworldTreeFeatures.REDWOOD_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature FRAGMENT_FOREST_TREES = createPlacedFeature("fragment_forest_trees", BYGOverworldTreeFeatures.FRAGMENT_FOREST_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(2, 0.25F, 2))));
    public static final PlacedFeature SKYRIS_TREES = createPlacedFeature("skyris_trees", BYGOverworldTreeFeatures.SKYRIS_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature RED_SPRUCE_TREES_SPARSE = createPlacedFeature("sparse_red_spruce_trees", BYGOverworldTreeFeatures.RED_SPRUCE_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1))));
    public static final PlacedFeature BLUE_SPRUCE_TREES = createPlacedFeature("blue_spruce_trees", BYGOverworldTreeFeatures.BLUE_SPRUCE_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(2, 0.1F, 1))));
    public static final PlacedFeature SPRUCE_TREES_SPARSE = createPlacedFeature("sparse_spruce_trees", BYGOverworldTreeFeatures.SPRUCE_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.2F, 1))));
    public static final PlacedFeature BROWN_ZELKOVA_TREES = createPlacedFeature("brown_zelkova_trees", BYGOverworldTreeFeatures.BROWN_ZELKOVA_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));
    public static final PlacedFeature ZELKOVA_TREES = createPlacedFeature("zelkova_trees", BYGOverworldTreeFeatures.ZELKOVA_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(5, 0.2F, 2))));
    public static final PlacedFeature RAINBOW_EUCALYPTUS_TREES = createPlacedFeature("rainbow_eucalyptus_trees", BYGOverworldTreeFeatures.RAINBOW_EUCALYPTUS_TREES.placed(PlacementUtils.countExtra(6, 0.2F, 1), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter.biome()));
    public static final PlacedFeature TEMPERATE_RAINFOREST_TREES = createPlacedFeature("temperate_rainforest_trees", BYGOverworldTreeFeatures.TEMPERATE_RAINFOREST_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 1))));
    public static final PlacedFeature MEADOW_TREES = createPlacedFeature("meadow_trees", BYGOverworldTreeFeatures.MEADOW_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(2, 0.25F, 3))));
    public static final PlacedFeature MEADOW_TREES_SPARSE = createPlacedFeature("sparse_meadow_trees", BYGOverworldTreeFeatures.MEADOW_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 1))));
    public static final PlacedFeature LARGE_BOULDERS = createPlacedFeature("large_boulders", BYGOverworldFeatures.LARGE_BOULDER.placed(oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(8))));
    public static final PlacedFeature LARGE_GRANITE_BOULDERS = createPlacedFeature("large_granite_boulders", BYGOverworldFeatures.LARGE_GRANITE_BOULDER.placed(oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(8))));
    public static final PlacedFeature LARGE_WINDSWEPT_BOULDERS = createPlacedFeature("large_windswept_boulders", BYGOverworldFeatures.LARGE_WINDSWEPT_BOULDER.placed(oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(20), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlock(BYGBlocks.WINDSWEPT_SAND, new BlockPos(0, -1, 0))), RandomOffsetPlacement.vertical(BiasedToBottomInt.of(-4, -3)))));
    public static final PlacedFeature ROSE_FIELD_FLOWERS = createPlacedFeature("rose_field_flowers", BYGOverworldVegetationFeatures.ROSE_FIELD_FLOWERS.placed(worldSurfaceSquaredWithCount(20)));
    public static final PlacedFeature FROST_MAGMA_LAKE = createPlacedFeature("frost_magma_lake", BYGOverworldFeatures.FROST_MAGMA_LAKE.placed(worldSurfaceSquaredWithCount(3)));
    public static final PlacedFeature TINY_LILY_PAD = createPlacedFeature("tiny_lily_pad", BYGOverworldVegetationFeatures.TINY_LILY_PAD.placed(CountPlacement.of(15), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter.biome()));
    public static final PlacedFeature LILY_PAD = createPlacedFeature("lily_pad", VegetationFeatures.PATCH_WATERLILY.placed(CountPlacement.of(15), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter.biome()));
    public static final PlacedFeature PATCH_GRASS_CRAG = PlacementUtils.register("patch_grass_crag", VegetationFeatures.PATCH_GRASS_JUNGLE.placed(CountPlacement.of(25), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter.biome()));

    public static final PlacedFeature SPARSE_HUGE_MUSHROOMS = createPlacedFeature("sparse_huge_mushrooms", BYGOverworldVegetationFeatures.HUGE_MUSHROOMS.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 2))));
    public static final PlacedFeature HUGE_MUSHROOMS = createPlacedFeature("huge_mushrooms", BYGOverworldVegetationFeatures.HUGE_MUSHROOMS.placed(clearingTreePlacement(PlacementUtils.countExtra(1, 0.25F, 2))));

    public static final PlacedFeature MEADOW_SHRUBS = createPlacedFeature("meadow_shrubs", BYGOverworldTreeFeatures.MEADOW_SHRUBS.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));
    public static final PlacedFeature FIRECRACKER_SHRUBS = createPlacedFeature("firecracker_shrubs", BYGOverworldTreeFeatures.FIRECRACKER_SHRUBS.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.25F, 2))));

    public static final PlacedFeature SPARSE_RED_OAK_TREES = createPlacedFeature("sparse_red_oak_trees", BYGOverworldTreeFeatures.RED_OAK_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 1))));

    public static final PlacedFeature SPARSE_JACARANDA_TREES = createPlacedFeature("sparse_jacaranda_trees", BYGOverworldTreeFeatures.JACARANDA_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 2))));
    public static final PlacedFeature SPARSE_ARAUCARIA_TREES = createPlacedFeature("sparse_araucaria_trees", BYGOverworldTreeFeatures.ARAUCARIA_TREES.placed(clearingTreePlacement(PlacementUtils.countExtra(0, 0.2F, 3))));

    public static final PlacedFeature DISK_MUD = createPlacedFeature("disk_mud", BYGOverworldFeatures.DISK_MUD.placed(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome()));

    public static final PlacedFeature MOSSY_STONE_BOULDER = createPlacedFeature("mossy_stone_boulder", BYGOverworldFeatures.MOSSY_STONE_BOULDER.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final PlacedFeature BEEHIVES = createPlacedFeature("beehives", BYGOverworldFeatures.BEEHIVES.placed(CountPlacement.of(2), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature ROCKY_STONE_BOULDER = createPlacedFeature("rocky_stone_boulder", BYGOverworldFeatures.ROCKY_STONE_BOULDER.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final PlacedFeature BLACKSTONE_BOULDER = createPlacedFeature("blackstone_boulder", BYGOverworldFeatures.BLACKSTONE_BOULDER.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final PlacedFeature ORANGE_TERRACOTTA_BOULDER = createPlacedFeature("orange_terracotta_boulder", BYGOverworldFeatures.ORANGE_TERRACOTTA_BOULDER.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final PlacedFeature BLACK_ICE_SNOW = createPlacedFeature("black_ice_snow", BYGOverworldFeatures.BLACK_ICE.placed(ChunkCoveringPlacement.INSTANCE, PlacementUtils.HEIGHTMAP_WORLD_SURFACE, RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlock(Blocks.WATER, BlockPos.ZERO)), BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlock(Blocks.AIR, new BlockPos(0, 1, 0)))));
    public static final PlacedFeature STONE_FOREST_COLUMN = createPlacedFeature("stone_forest_column", BYGOverworldFeatures.STONE_FOREST_COLUMN.placed(oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(2))));
    public static final PlacedFeature IVIS_FIELDS_SPIKE = createPlacedFeature("ivis_fields_spike", BYGEndFeatures.IVIS_FIELDS_SPIKE.placed(oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(9), BlockPredicateFilter.forPredicate(BlockPredicate.solid(new BlockPos(0, -1, 0))))));
    public static final PlacedFeature IVIS_FIELDS_COLUMN = createPlacedFeature("ivis_fields_column", BYGEndFeatures.IVIS_FIELDS_COLUMN.placed(oceanFloorSquaredWithCount(1, RarityFilter.onAverageOnceEvery(16), BlockPredicateFilter.forPredicate(BlockPredicate.solid(new BlockPos(0, -1, 0))))));
    public static final PlacedFeature LARGE_WINDSWEPT_LAKE = createPlacedFeature("large_windswept_lake", BYGOverworldFeatures.LARGE_WINDSWEPT_LAKE.placed(Util.make(new ArrayList<>(worldSurfaceSquaredWithCount(1)), list -> list.addAll(List.of(RarityFilter.onAverageOnceEvery(36), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.anyOf(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0))))))))));
    public static final PlacedFeature END_LAKE = createPlacedFeature("end_lake", BYGEndFeatures.END_LAKE.placed(Util.make(new ArrayList<>(worldSurfaceSquaredWithCount(1)), list -> list.addAll(List.of(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.solid(BlockPos.ZERO.relative(Direction.DOWN))), BiomeFilter.biome())))));

    public static final PlacedFeature DEAD_SEA_SPIKES = createPlacedFeature("dead_sea_spikes", BYGOverworldFeatures.DEAD_SEA_SPIKES.placed(oceanFloorSquaredWithCount(3)));
    public static final PlacedFeature CRYPTIC_SPIKE = createPlacedFeature("cryptic_spikes", BYGEndFeatures.CRYPTIC_SPIKE.placed(new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(1)).add(RarityFilter.onAverageOnceEvery(3)).build()));
    public static final PlacedFeature WINDSWEPT_SPIKES = createPlacedFeature("windswept_spikes", BYGOverworldFeatures.WINDSWEPT_SPIKES.placed(NoiseThresholdCountPlacement.of(0.6, 0, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.anyOf(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0))))), BiomeFilter.biome()));
    public static final PlacedFeature CRYPTIC_REDSTONE = createPlacedFeature("cryptic_redstone", BYGEndFeatures.ORE_CRYPTIC_REDSTONE.placed(new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(8)).add(RandomOffsetPlacement.vertical(BiasedToBottomInt.of(-15, -2))).build()));
//    public static final PlacedFeature BRIMSTONE_VENTS = createPlacedFeature("brimstone_vents", BYGNetherFeatures.BRIMSTONE_VENTS.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));


    public static final PlacedFeature CRYPTIC_CAVE = createPlacedFeature("cryptic_caves", BYGEndFeatures.CRYPTIC_CAVES.placed(new ImmutableList.Builder<PlacementModifier>().addAll(oceanFloorSquaredWithCount(2)).add(RandomOffsetPlacement.vertical(BiasedToBottomInt.of(-15, -7))).build()));
    public static final PlacedFeature CRYPTIC_VENTS = createPlacedFeature("cryptic_vents", BYGEndFeatures.CRYPTIC_VENT_PATCHES.placed(new ImmutableList.Builder<PlacementModifier>().add(RarityFilter.onAverageOnceEvery(2)).addAll(oceanFloorSquaredWithCount(3)).build()));


    public static final PlacedFeature QUARTZ_SPIKE = createPlacedFeature("quartz_spike", BYGNetherFeatures.QUARTZ_SPIKE.placed(NoiseThresholdCountPlacement.of(0.6, 0, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.not(BlockPredicate.anyOf(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0))))), BiomeFilter.biome()));

    public static final PlacedFeature ISLANDS = createPlacedFeature("islands", BYGEndFeatures.ISLANDS.placed(CountPlacement.of(1), RarityFilter.onAverageOnceEvery(6), HeightRangePlacement.uniform(VerticalAnchor.absolute(200), VerticalAnchor.absolute(230)), InSquarePlacement.spread(), BiomeFilter.biome()));

    public static final PlacedFeature ORE_GOLD_BRIMSTONE = PlacementUtils.register("ore_gold_brimstone", BYGNetherFeatures.ORE_GOLD_BRIMSTONE.placed(invokeCommonOrePlacement(10, PlacementUtils.RANGE_10_10)));
    public static final PlacedFeature ORE_QUARTZ_BRIMSTONE = PlacementUtils.register("ore_quartz_brimstone", BYGNetherFeatures.ORE_QUARTZ_BRIMSTONE.placed(invokeCommonOrePlacement(16, PlacementUtils.RANGE_10_10)));
    public static final PlacedFeature ORE_GOLD_BLUE_NETHERRACK = PlacementUtils.register("ore_gold_blue_netherrack", BYGNetherFeatures.ORE_GOLD_BLUE_NETHERRACK.placed(invokeCommonOrePlacement(10, PlacementUtils.RANGE_10_10)));
    public static final PlacedFeature ORE_QUARTZ_BLUE_NETHERRACK = PlacementUtils.register("ore_quartz_blue_netherrack", BYGNetherFeatures.ORE_QUARTZ_BLUE_NETHERRACK.placed(invokeCommonOrePlacement(16, PlacementUtils.RANGE_10_10)));
    public static final PlacedFeature ORE_ANTHRACITE = PlacementUtils.register("ore_anthracite", BYGNetherFeatures.ORE_ANTHRACITE.placed(invokeCommonOrePlacement(20, PlacementUtils.RANGE_10_10)));

    public static final PlacedFeature BORIC_FIRE = createPlacedFeature("patch_boric_fire", BYGNetherFeatures.BORIC_FIRE_PATCH.placed(CountOnEveryLayerPlacement.of(8), BiomeFilter.biome()));
    public static final PlacedFeature BRIMSTONE_VOLCANO = createPlacedFeature("brimstone_volcano", BYGNetherFeatures.BRIMSTONE_VOLCANO.placed(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));
    public static final PlacedFeature CRAG_GEN = createPlacedFeature("crag_gen", BYGOverworldFeatures.CRAG_GEN.placed(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome(), new AboveHeightmapFilter(Heightmap.Types.OCEAN_FLOOR_WG), CRAG_NOISE));
    public static final PlacedFeature CRAG_DELTA = createPlacedFeature("crag_delta", BYGOverworldFeatures.CRAG_DELTA.placed(oceanFloorSquaredWithCount(3)));
    public static final PlacedFeature VINES_1 = createPlacedFeature("vines", VegetationFeatures.VINES.placed(CountPlacement.of(256), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)), BiomeFilter.biome()));
    public static final PlacedFeature VINES_2 = createPlacedFeature("vines_2", VegetationFeatures.VINES.placed(CountPlacement.of(256), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)), BiomeFilter.biome()));

    public static final PlacedFeature BRIMSTONE_PILLARS = createPlacedFeature("brimstone_pillars", BYGNetherFeatures.BRIMSTONE_PILLARS.placed(CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()));
    public static final PlacedFeature MAGMA_PILLARS = createPlacedFeature("magma_pillars", BYGNetherFeatures.MAGMA_PILLARS.placed(CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()));
    public static final PlacedFeature FROST_MAGMA_PILLARS = createPlacedFeature("frost_magma_pillars", BYGNetherFeatures.FROST_MAGMA_PILLARS.placed(CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()));
    public static final PlacedFeature SOUL_SOIL_PILLARS = createPlacedFeature("soul_soil_pillars", BYGNetherFeatures.SOUL_SOIL_PILLARS.placed(CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()));
    public static final PlacedFeature SYTHIAN_FUNGUS_PILLARS = createPlacedFeature("sythian_fungus_pillars", BYGNetherFeatures.SYTHIAN_FUNGUS_PILLARS.placed(CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()));
    public static final PlacedFeature MOSSY_NETHERRACK_PILLARS = createPlacedFeature("mossy_netherrack_pillars", BYGNetherFeatures.MOSSY_NETHERRACK_PILLARS.placed(CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()));

    public static final PlacedFeature EMBUR_ROOTS = createPlacedFeature("embur_roots", BYGNetherVegetationFeatures.EMBUR_ROOTS.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature TALL_EMBUR_ROOTS = createPlacedFeature("tall_embur_roots", BYGNetherVegetationFeatures.TALL_EMBUR_ROOTS.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature EMBUR_WART = createPlacedFeature("embur_wart", BYGNetherVegetationFeatures.EMBUR_WART.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature EMBUR_SPROUT = createPlacedFeature("embur_sprout", BYGNetherVegetationFeatures.EMBUR_SPROUT.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature SYTHIAN_ROOTS = createPlacedFeature("sythian_roots", BYGNetherVegetationFeatures.SYTHIAN_ROOTS.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature SYTHIAN_SPROUT = createPlacedFeature("sythian_sprout", BYGNetherVegetationFeatures.SYTHIAN_SPROUT.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature SYTHIAN_FUNGUS = createPlacedFeature("sythian_fungus", BYGNetherVegetationFeatures.SYTHIAN_FUNGUS.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature WARPED_CACTI = createPlacedFeature("warped_cacti", BYGNetherVegetationFeatures.WARPED_CACTI.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature WARPED_BUSH = createPlacedFeature("warped_bush", BYGNetherVegetationFeatures.WARPED_BUSH.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature WARPED_CORAL = createPlacedFeature("warped_coral", BYGNetherVegetationFeatures.WARPED_CORAL.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature WARPED_CORAL_FAN = createPlacedFeature("warped_coral_fan", BYGNetherVegetationFeatures.WARPED_CORAL_FAN.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature TALL_CRIMSON_ROOTS = createPlacedFeature("tall_crimson_roots", BYGNetherVegetationFeatures.TALL_CRIMSON_ROOTS.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature CRIMSON_BERRY_BUSH = createPlacedFeature("crimson_berry_bush", BYGNetherVegetationFeatures.CRIMSON_BERRY_BUSH.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature CHAINS = createPlacedFeature("chains", BYGNetherVegetationFeatures.CHAINS.placed(HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature CRIMSON_GARDEN_VEGETATION = createPlacedFeature("crimson_garden_vegetation", BYGNetherVegetationFeatures.CRIMSON_GARDEN_VEGETATION.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature EMBUR_BOG_VEGETATION = createPlacedFeature("embur_bog_vegetation", BYGNetherVegetationFeatures.EMBUR_BOG_VEGETATION.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature GLOWSTONE_GARDEN_VEGETATION = createPlacedFeature("glowstone_garden_vegetation", BYGNetherVegetationFeatures.GLOWSTONE_GARDEN_VEGETATION.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature SYTHIAN_VEGETATION = createPlacedFeature("sythian_vegetation", BYGNetherVegetationFeatures.SYTHIAN_VEGETATION.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature EMBUR_LILY = createPlacedFeature("embur_lily", BYGNetherVegetationFeatures.EMBUR_LILY.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature FUNGI = createPlacedFeature("fungi", BYGNetherVegetationFeatures.FUNGI.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature BLACKSTONE_BOULDERS_NETHER = createPlacedFeature("blackstone_boulders_nether", BYGOverworldFeatures.BLACKSTONE_BOULDER.placed(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
    public static final PlacedFeature WEEPING_VINES = createPlacedFeature("weeping_vines", BYGNetherVegetationFeatures.WEEPING_VINES.placed(CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature WEEPING_ROOTS = createPlacedFeature("weeping_roots", BYGNetherVegetationFeatures.WEEPING_ROOTS.placed(CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature WAILING_VINES = createPlacedFeature("wailing_vines", BYGNetherVegetationFeatures.WAILING_VINE.placed(CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature HANGING_SYTHIAN_ROOTS = createPlacedFeature("hanging_sythian_roots", BYGNetherVegetationFeatures.HANGING_SYTHIAN_ROOTS.placed(CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature HANGING_BONE_FEATURE = createPlacedFeature("hanging_bone_feature", BYGNetherVegetationFeatures.HANGING_BONES.placed(CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature HANGING_CHAINS = createPlacedFeature("hanging_chains", BYGNetherFeatures.HANGING_CHAINS.placed(CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature HANGING_LANTERNS = createPlacedFeature("hanging_lanterns", BYGNetherFeatures.HANGING_LANTERNS.placed(CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature HANGING_SOUL_SHROOM_SPORES = createPlacedFeature("hanging_soul_shroom_spores", BYGNetherVegetationFeatures.HANGING_SOUL_SHROOM_SPORES.placed(CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature LAMENT_VINE_FEATURE = createPlacedFeature("lament_vine_feature", BYGNetherVegetationFeatures.LAMENT_VINE_FEATURE.placed(CountPlacement.of(10), HeightRangePlacement.uniform(VerticalAnchor.belowTop(6), VerticalAnchor.aboveBottom(6)), InSquarePlacement.spread(), BiomeFilter.biome()));
    public static final PlacedFeature EMBUR_MUSHROOMS = createPlacedFeature("embur_mushrooms", BYGNetherVegetationFeatures.EMBUR_MUSHROOMS.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature LAMENT_VEGETATION = createPlacedFeature("lament_vegetation", BYGNetherVegetationFeatures.LAMENT_VEGETATION.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature SPARSE_WITHERING_OAK_TREES = createPlacedFeature("sparse_withering_oak_trees", BYGNetherVegetationFeatures.WITHERING_OAK_TREES.placed(CountOnEveryLayerPlacement.of(4), RarityFilter.onAverageOnceEvery(3), BiomeFilter.biome()));
    public static final PlacedFeature WITHERING_OAK_TREES = createPlacedFeature("withering_oak_trees", BYGNetherVegetationFeatures.WITHERING_OAK_TREES.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature SOUL_SHROOM_TREES = createPlacedFeature("soul_shroom_trees", BYGNetherVegetationFeatures.SOUL_SHROOM_TREES.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature SYTHIAN_FUNGI_TREES = createPlacedFeature("sythian_fungi_trees", BYGNetherVegetationFeatures.SYTHIAN_FUNGI_TREES.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature SYTHIAN_STALK = createPlacedFeature("sythian_stalk", BYGNetherVegetationFeatures.SYTHIAN_STALK.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature DEATH_CAP_TREES = createPlacedFeature("death_cap_trees", BYGNetherVegetationFeatures.DEATH_CAP_TREES.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature SUBZERO_ASHES = createPlacedFeature("subzero_ashes", BYGNetherFeatures.SUBZERO_ASHES.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature QUARTZ_CRYSTALS = createPlacedFeature("quartz_crystals", BYGNetherFeatures.QUARTZ_CRYSTAL.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature QUARTZ_COLUMNS = createPlacedFeature("quartz_columns", BYGNetherFeatures.QUARTZ_COLUMNS.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature SCORCHED_PLANTS = createPlacedFeature("scorched_plants", BYGNetherVegetationFeatures.SCORCHED_PLANTS.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature WARPED_CORAL_PLANT = createPlacedFeature("warped_coral_plant", BYGNetherVegetationFeatures.WARPED_CORAL_PLANT.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature WARPED_DESERT_VEGETATION = createPlacedFeature("warped_desert_vegetation", BYGNetherVegetationFeatures.WARPED_DESERT_VEGETATION.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature WAILING_VEGETATION = createPlacedFeature("wailing_vegetation", BYGNetherVegetationFeatures.WAILING_VEGETATION.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature MINI_MUSHROOMS = createPlacedFeature("mini_mushrooms", BYGNetherVegetationFeatures.MINI_MUSHROOMS.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature TWISTY_LAMENT_TREES = createPlacedFeature("twisty_lament_trees", BYGNetherVegetationFeatures.TWISTY_LAMENT_TREES.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature WEEPING_LAMENT_TREES = createPlacedFeature("weeping_lament_trees", BYGNetherVegetationFeatures.WEEPING_LAMENT_TREES.placed(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));
    public static final PlacedFeature WAILING_PILLARS = createPlacedFeature("wailing_pillar", BYGNetherFeatures.WAILING_PILLAR.placed(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));
    public static final PlacedFeature MAGMA_PATCH_FIRE = createPlacedFeature("magma_patch_fire", BYGNetherFeatures.MAGMA_PATCH_FIRE.placed(CountPlacement.of(UniformInt.of(30, 45)), InSquarePlacement.spread(), PlacementUtils.RANGE_4_4, BiomeFilter.biome()));
    public static final PlacedFeature NYLIUM_SOUL_PATCH_FIRE = createPlacedFeature("nylium_soul_patch_fire", BYGNetherFeatures.NYLIUM_SOUL_PATCH_FIRE.placed(CountPlacement.of(UniformInt.of(5, 10)), InSquarePlacement.spread(), PlacementUtils.RANGE_4_4, BiomeFilter.biome()));


    private static List<PlacementModifier> clearingTreePlacementBaseOceanFloor(PlacementModifier $$0) {
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


    public static <PF extends PlacedFeature> PF createPlacedFeature(String id, PF placedFeature) {
        ResourceLocation bygID = BYG.createLocation(id);
        if (BuiltinRegistries.PLACED_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Placed Feature ID: \"" + bygID.toString() + "\" already exists in the Placed Features registry!");

        Registry.register(BuiltinRegistries.PLACED_FEATURE, bygID, placedFeature);
        return placedFeature;
    }
}
