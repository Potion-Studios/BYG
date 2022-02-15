package potionstudios.byg.common.world.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BlueBerryBush;
import potionstudios.byg.common.world.feature.config.*;

import java.util.List;

import static potionstudios.byg.mixin.access.VegetationFeaturesAccess.invokeGrassPatch;

public class BYGConfiguredFeatures {

    /***********************************************************Configured Features***********************************************************/

    public static final ConfiguredFeature<?, ?> ALLIUM_BUSH = createFlowerConfiguredFeature("allium_bush", BYGBlocks.ALLIUM_FLOWER_BUSH);
    public static final ConfiguredFeature<?, ?> ALLIUM_PINK_BUSH = createFlowerConfiguredFeature("pink_allium_bush", BYGBlocks.PINK_ALLIUM_FLOWER_BUSH);
    public static final ConfiguredFeature<?, ?> ALLIUM_TALL_BUSH = createConfiguredFeature("tall_allium_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.TALL_ALLIUM))), List.of(), 15)));
    public static final ConfiguredFeature<?, ?> ALLIUM_TALL_PINK_BUSH = createConfiguredFeature("tall_pink_allium_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.TALL_PINK_ALLIUM))), List.of(), 15)));

    public static final ConfiguredFeature<?, ?> AMARANTH = createFlowerConfiguredFeature("amaranth", BYGBlocks.AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_MAGENTA = createFlowerConfiguredFeature("magenta_amaranth", BYGBlocks.MAGENTA_AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_ORANGE = createFlowerConfiguredFeature("orange_amaranth", BYGBlocks.ORANGE_AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_PURPLE = createFlowerConfiguredFeature("purple_amaranth", BYGBlocks.PURPLE_AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_CYAN = createFlowerConfiguredFeature("cyan_amaranth", BYGBlocks.CYAN_AMARANTH);

    public static final ConfiguredFeature<?, ?> FIRECRACKER_BUSH = createFlowerConfiguredFeature("firecracker_bush", BYGBlocks.FIRECRACKER_FLOWER_BUSH);
    public static final ConfiguredFeature<?, ?> SHRUB = createFlowerConfiguredFeature("shrub", BYGBlocks.SHRUB);

    public static final ConfiguredFeature<?, ?> CLOVER_PATCH = createFlowerConfiguredFeature("clover_patch", BYGBlocks.CLOVER_PATCH);
    public static final ConfiguredFeature<?, ?> FLOWER_PATCH = createFlowerConfiguredFeature("flower_patch", BYGBlocks.FLOWER_PATCH);
    public static final ConfiguredFeature<?, ?> CALIFORNIA_POPPY = createFlowerConfiguredFeature("california_poppy", BYGBlocks.CALIFORNIA_POPPY);
    public static final ConfiguredFeature<?, ?> WHITE_PUFFBALL = createFlowerConfiguredFeature("white_puffball", BYGBlocks.WHITE_PUFFBALL);
    public static final ConfiguredFeature<?, ?> WEEPING_MILKCAP = createFlowerConfiguredFeature("weeping_milkcap", BYGBlocks.WEEPING_MILKCAP);
    public static final ConfiguredFeature<?, ?> WOOD_BLEWIT = createFlowerConfiguredFeature("wood_blewit", BYGBlocks.WOOD_BLEWIT);
    public static final ConfiguredFeature<?, ?> GREEN_MUSHROOM = createFlowerConfiguredFeature("green_mushroom", BYGBlocks.GREEN_MUSHROOM);
    public static final ConfiguredFeature<?, ?> BEGONIA = createFlowerConfiguredFeature("begonia", BYGBlocks.BEGONIA);
    public static final ConfiguredFeature<?, ?> BISTORT = createFlowerConfiguredFeature("bistort", BYGBlocks.BISTORT);
    public static final ConfiguredFeature<?, ?> GUZMANIA = createFlowerConfiguredFeature("guzmania", BYGBlocks.GUZMANIA);
    public static final ConfiguredFeature<?, ?> INCAN_LILY = createFlowerConfiguredFeature("incan_lily", BYGBlocks.INCAN_LILY);
    public static final ConfiguredFeature<?, ?> LAZARUS_BELLFLOWER = createFlowerConfiguredFeature("lazarus_bellflower", BYGBlocks.LAZARUS_BELLFLOWER);
    public static final ConfiguredFeature<?, ?> TORCH_GINGER = createFlowerConfiguredFeature("torch_ginger", BYGBlocks.TORCH_GINGER);


    public static final ConfiguredFeature<?, ?> AMARANTH_FIELD_FLOWERS = createConfiguredFeature("amaranth_field_flowers", Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(AMARANTH.placed(), 0.2F), new WeightedPlacedFeature(AMARANTH_MAGENTA.placed(), 0.2F), new WeightedPlacedFeature(AMARANTH_ORANGE.placed(), 0.2F), new WeightedPlacedFeature(AMARANTH_PURPLE.placed(), 0.2F)), AMARANTH_CYAN.placed())));

    //    public static final ConfiguredFeature<?, ?> SHRUB = createConfiguredFeature("shrub_patch", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.SHRUB.defaultBlockState()), new SimpleBlockPlacer())).tries(24).build()));
//
//
    public static final ConfiguredFeature<?, ?> PATCH_GRASS_EXTRA = createConfiguredFeature("patch_grass_extra", Feature.RANDOM_PATCH.configured(invokeGrassPatch(SimpleStateProvider.simple(Blocks.GRASS.defaultBlockState()), 100)));
    public static final ConfiguredFeature<?, ?> BYG_GRASS_EXTRA = createConfiguredFeature("short_grass_and_grass_extra", Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PATCH_GRASS_EXTRA.placed(), 0.5F)), PATCH_GRASS_EXTRA.placed())));

    public static final ConfiguredFeature<?, ?> ALLIUM_FIELD_FLOWERS = createConfiguredFeature("allium_field_flowers", Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(ALLIUM_TALL_BUSH.placed(), 0.25F), new WeightedPlacedFeature(ALLIUM_TALL_PINK_BUSH.placed(), 0.25F), new WeightedPlacedFeature(ALLIUM_BUSH.placed(), 0.25F)), ALLIUM_PINK_BUSH.placed())));

    //    public static final ConfiguredFeature<?, ?> NYLIUM_SOUL_FIRE_PATCH = createConfiguredFeature("nylium_soul_fire_patch", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(Blocks.SOUL_FIRE.defaultBlockState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(Blocks.SOUL_SOIL, BYGBlocks.NYLIUM_SOUL_SOIL, BYGBlocks.BRIMSTONE, BYGBlocks.FROST_MAGMA)).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> BORIC_FIRE_PATCH = createConfiguredFeature("boric_fire_patch", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.BORIC_FIRE.defaultBlockState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.BRIMSTONE, BYGBlocks.BRIMSTONE, BYGBlocks.BRIMSTONE, BYGBlocks.FROST_MAGMA)).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> MAGMA_FIRE_PATCH = createConfiguredFeature("magma_fire_patch", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(Blocks.FIRE.defaultBlockState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MAGMATIC_STONE, Blocks.MAGMA_BLOCK, BYGBlocks.QUARTZITE_SAND)).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> SUBZERO_ASH = createConfiguredFeature("subzero_ash", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.SUBZERO_ASH.defaultBlockState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.SUBZERO_ASH_BLOCK, BYGBlocks.FROST_MAGMA)).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> SUBZERO_ASH_BLOCK = createConfiguredFeature("subzero_ash_block", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.SUBZERO_ASH_BLOCK.defaultBlockState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.SUBZERO_ASH_BLOCK, BYGBlocks.FROST_MAGMA)).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> QUARTZ_CRYSTAL = createConfiguredFeature("quartz_crystal", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.QUARTZ_CRYSTAL.defaultBlockState()), ImmutableList.of(BYGBlocks.QUARTZITE_SAND.defaultBlockState(), BYGBlocks.RAW_QUARTZ_BLOCK.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), BYGBlocks.QUARTZITE_SAND.defaultBlockState(), BYGBlocks.RAW_QUARTZ_BLOCK.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> CRYPTIC_FIRE_PATCH = createConfiguredFeature("cryptic_fire_patch", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_FIRE.defaultBlockState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.CRYPTIC_STONE, BYGBlocks.CRYPTIC_MAGMA_BLOCK)).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> CRYPTIC_VENT = createConfiguredFeature("cryptic_vent", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_VENT.defaultBlockState()), new SimpleBlockPlacer())).tries(24).whitelist(ImmutableSet.of(BYGBlocks.CRYPTIC_STONE, BYGBlocks.CRYPTIC_MAGMA_BLOCK)).build()));
//    public static final ConfiguredFeature<?, ?> TALL_CRYPTIC_VENT = createConfiguredFeature("tall_cryptic_vent", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.TALL_CRYPTIC_VENT.defaultBlockState()), new DoubleBlockPlacer())).tries(24).whitelist(ImmutableSet.of(BYGBlocks.CRYPTIC_STONE, BYGBlocks.CRYPTIC_MAGMA_BLOCK)).build()));
//
    public static final ConfiguredFeature<?, ?> BEEHIVES = createConfiguredFeature("beehives", BYGFeatures.BEEHIVE.configured(new NoneFeatureConfiguration()));
    //    public static final ConfiguredFeature<?, ?> ETHER_BULBS = createConfiguredFeature("ether_bulbs", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.ETHER_BULB.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(BYGBlocks.ETHER_LEAVES.defaultBlockState()))).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.aboveBottom(0), VerticalAnchor.belowTop(0)))).squared().count(55));
//
//    //Giant Flowers
//    public static final ConfiguredFeature<GiantFlowerConfig, ?> GIANT_ANGELICA_FLOWER = createConfiguredFeature("giant_angelica", BYGFeatures.GIANT_ANGELICA_FLOWER.configured(new GiantFlowerConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.WHITE_PETAL).setMaxHeight(18).setMinHeight(12).build()));
//    public static final ConfiguredFeature<GiantFlowerConfig, ?> GIANT_DANDELION_FLOWER = createConfiguredFeature("giant_dandelion", BYGFeatures.GIANT_DANDELION_FLOWER.configured(new GiantFlowerConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.RED_PETAL).setPetal2Block(BYGBlocks.YELLOW_PETAL).setMaxHeight(12).setMinHeight(6).build()));
//    public static final ConfiguredFeature<GiantFlowerConfig, ?> GIANT_IRIS_FLOWER = createConfiguredFeature("giant_iris", BYGFeatures.GIANT_IRIS_FLOWER.configured(new GiantFlowerConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.PURPLE_PETAL).setPetal2Block(BYGBlocks.YELLOW_PETAL).setMaxHeight(12).setMinHeight(6).build()));
//    public static final ConfiguredFeature<GiantFlowerConfig, ?> GIANT_ROSE_FLOWER = createConfiguredFeature("giant_rose", BYGFeatures.GIANT_ROSE_FLOWER.configured(new GiantFlowerConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.RED_PETAL).setMaxHeight(12).setMinHeight(6).build()));
//
//
    public static final ConfiguredFeature<?, ?> MINI_CACTI = createConfiguredFeature("mini_cacti", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.MINI_CACTUS))), List.of(), 4)));
    public static final ConfiguredFeature<?, ?> HORSEWEED = createConfiguredFeature("horseweed", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.HORSEWEED))), List.of(), 10)));
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> TINY_LILY_PAD = createConfiguredFeature("tiny_lily_pad", Feature.RANDOM_PATCH.configured(new RandomPatchConfiguration(10, 7, 3, () -> {
        return Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.TINY_LILYPADS))).onlyWhenEmpty();
    })));
    public static final ConfiguredFeature<?, ?> WATER_SILK = createConfiguredFeature("water_silk", Feature.RANDOM_PATCH.configured(new RandomPatchConfiguration(10, 7, 3, () -> {
        return Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WATER_SILK))).onlyWhenEmpty();
    })));
    public static final ConfiguredFeature<?, ?> WINTER_SUCCULENT = createConfiguredFeature("winter_succulent", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WINTER_SUCCULENT))), List.of(), 10)));
    public static final ConfiguredFeature<?, ?> BEACH_GRASS = createConfiguredFeature("beach_grass_patch", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.BEACH_GRASS))), List.of(), 32)));
    //    public static final ConfiguredFeature<?, ?> BEACH_SHORT_GRASS_PATCH = createConfiguredFeature("short_beach_grass_patch", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.SHORT_BEACH_GRASS.defaultBlockState()), new SimpleBlockPlacer())).tries(20).build()));
//    public static final ConfiguredFeature<?, ?> WILTED_GRASS_PATCH = createConfiguredFeature("wilted_grass_patch", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.WILTED_GRASS.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
    public static final ConfiguredFeature<?, ?> LEAF_PILE = createConfiguredFeature("leaf_pile", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.LEAF_PILE))), List.of(), 15)));
    public static final ConfiguredFeature<?, ?> RICHEA = createFlowerConfiguredFeature("richea", BYGBlocks.RICHEA);
    public static final ConfiguredFeature<?, ?> PRAIRIE_GRASS_PATCH = createConfiguredFeature("prairie_grass_patch", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.PRAIRIE_GRASS))), List.of(), 100)));
    public static final ConfiguredFeature<?, ?> TALL_PRAIRIE_GRASS_PATCH = createConfiguredFeature("tall_prairie_grass_patch", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.TALL_PRAIRIE_GRASS))), List.of(), 100)));
    public static final ConfiguredFeature<?, ?> ROSE_BUSH = createConfiguredFeature("rose_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.ROSE_BUSH))), List.of(), 64)));
    //    public static final ConfiguredFeature<?, ?> DELPHINIUM = createConfiguredFeature("delphinium", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.DELPHINIUM.defaultBlockState()), new DoublePlantPlacer())).tries(64).noProjection().build()));
    public static final ConfiguredFeature<?, ?> JAPANESE_ORCHID = createFlowerConfiguredFeature("japanese_orchid", BYGBlocks.JAPANESE_ORCHID);
    public static final ConfiguredFeature<?, ?> FOXGLOVE = createFlowerConfiguredFeature("foxglove", BYGBlocks.FOXGLOVE);
    public static final ConfiguredFeature<?, ?> FLOWERING_INDIGO_JACARANDA_BUSH = createConfiguredFeature("flowering_indigo_jacaranda_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH))), List.of(), 32)));
    public static final ConfiguredFeature<?, ?> INDIGO_JACARANDA_BUSH = createConfiguredFeature("indigo_jacaranda_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.INDIGO_JACARANDA_BUSH))), List.of(), 32)));
    public static final ConfiguredFeature<?, ?> FLOWERING_JACARANDA_BUSH = createConfiguredFeature("flowering_jacaranda_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.FLOWERING_JACARANDA_BUSH))), List.of(), 32)));
    public static final ConfiguredFeature<?, ?> JACARANDA_BUSH = createConfiguredFeature("jacaranda_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.JACARANDA_BUSH))), List.of(), 32)));
    //
//
    public static final ConfiguredFeature<?, ?> PRICKLY_PEAR_CACTI = createConfiguredFeature("prickly_pear_cacti", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.PRICKLY_PEAR_CACTUS))), List.of(), 5)));
    public static final ConfiguredFeature<?, ?> GOLDEN_SPINED_CACTI = createConfiguredFeature("golden_spined_cacti", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.GOLDEN_SPINED_CACTUS))), List.of(), 5)));
    //
    public static final ConfiguredFeature<?, ?> PINK_CHERRY_FOLIAGE = createConfiguredFeature("pink_cherry_foliage", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.PINK_CHERRY_FOLIAGE))), List.of(), 15)));
    public static final ConfiguredFeature<?, ?> WHITE_CHERRY_FOLIAGE = createConfiguredFeature("white_cherry_foliage", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WHITE_CHERRY_FOLIAGE))), List.of(), 15)));
    //
//    public static final ConfiguredFeature<?, ?> WARPED_CACTI = createConfiguredFeature("warped_cacti", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.WARPED_CACTUS.defaultBlockState()), new ColumnPlacer(UniformInt.of(1, 3)))).tries(10).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> WARPED_BUSH = createConfiguredFeature("warped_bush", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.WARPED_BUSH.defaultBlockState()), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> WARPED_CORAL = createConfiguredFeature("warped_coral", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.WARPED_CORAL.defaultBlockState()), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> WARPED_CORAL_FAN = createConfiguredFeature("warped_coral_fan", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.WARPED_CORAL_FAN.defaultBlockState()), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState()))));
//
//    public static final ConfiguredFeature<?, ?> CHAINS = createConfiguredFeature("chains", BYGFeatures.CHAIN.configured(new ChainConfig.Builder().setMinLength(6).setMaxLength(10).setXAxisBlock(Blocks.POLISHED_BLACKSTONE_BRICKS).setZAxisBlock(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).setWhitelist(ImmutableList.of(BYGBlocks.SCORIA_STONE)).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.aboveBottom(0), VerticalAnchor.belowTop(0)))).squared().count(4));
//
//    public static final ConfiguredFeature<?, ?> SCORCHED_BUSH = createConfiguredFeature("scorched_bush", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.SCORCHED_BUSH.defaultBlockState()), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.CRYPTIC_STONE.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState(), Blocks.MAGMA_BLOCK.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState(), Blocks.MAGMA_BLOCK.defaultBlockState(), BYGBlocks.CRYPTIC_STONE.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> SCORCHED_GRASS = createConfiguredFeature("scorched_grass", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.SCORCHED_GRASS.defaultBlockState()), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.CRYPTIC_STONE.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState(), Blocks.MAGMA_BLOCK.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState(), Blocks.MAGMA_BLOCK.defaultBlockState(), BYGBlocks.CRYPTIC_STONE.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> WAILING_GRASS = createConfiguredFeature("wailing_grass", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.WAILING_GRASS.defaultBlockState()), ImmutableList.of(BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState(), Blocks.SOUL_SAND.defaultBlockState(), Blocks.SOUL_SOIL.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> WAILING_VINE = createConfiguredFeature("wailing_vine", BYGFeatures.WAILING_VINES.configured(DecoratedFeatureConfiguration.NONE));
//
//    public static final ConfiguredFeature<?, ?> LAMENT_SPROUTS = createConfiguredFeature("lament_sprouts", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.LAMENT_SPROUTS.defaultBlockState()), ImmutableList.of(BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState()))));
//
//
    public static final ConfiguredFeature<?, ?> BLUE_BERRY_BUSH = createConfiguredFeature("blue_berry_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.BLUEBERRY_BUSH.defaultBlockState().setValue(BlueBerryBush.AGE, 3)))), List.of(), 15)));
    public static final ConfiguredFeature<?, ?> ROSE = createFlowerConfiguredFeature("rose", BYGBlocks.ROSE);
    //    public static final ConfiguredFeature<?, ?> ANGELICA = createConfiguredFeature("angelica", Feature.FLOWER.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.ANGELICA.defaultBlockState()), new SimpleBlockPlacer())).tries(64).noProjection().build()));
    public static final ConfiguredFeature<?, ?> CROCUS = createFlowerConfiguredFeature("crocus", BYGBlocks.CROCUS);
    public static final ConfiguredFeature<?, ?> IRIS = createFlowerConfiguredFeature("iris", BYGBlocks.IRIS);
    public static final ConfiguredFeature<?, ?> ANEMONE_WHITE = createFlowerConfiguredFeature("white_anemone", BYGBlocks.WHITE_ANEMONE);
    public static final ConfiguredFeature<?, ?> ANEMONE_PINK = createFlowerConfiguredFeature("pink_anemone", BYGBlocks.PINK_ANEMONE);
    public static final ConfiguredFeature<?, ?> ROSE_WINTER = createFlowerConfiguredFeature("winter_rose", BYGBlocks.WINTER_ROSE);
    //    public static final ConfiguredFeature<?, ?> SNOWDROP = createConfiguredFeature("snowdrop", Feature.FLOWER.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.SNOWDROPS.defaultBlockState()), new SimpleBlockPlacer())).tries(48).whitelist(ImmutableSet.of(Blocks.SNOW_BLOCK, Blocks.GRASS_BLOCK, Blocks.SNOW)).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> ALLIUM_PINK = createConfiguredFeature("pink_allium", Feature.FLOWER.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.PINK_ALLIUM.defaultBlockState()), new SimpleBlockPlacer())).tries(64).noProjection().build()));
    public static final ConfiguredFeature<?, ?> ALLIUM_PINK = createFlowerConfiguredFeature("allium_pink", BYGBlocks.PINK_ALLIUM);

    public static final ConfiguredFeature<?, ?> DAISY_ORANGE = createFlowerConfiguredFeature("orange_daisy", BYGBlocks.ORANGE_DAISY);
    public static final ConfiguredFeature<?, ?> HYDRANGEA_BUSH = createFlowerConfiguredFeature("hydrangea_bush", BYGBlocks.HYDRANGEA_BUSH);
    public static final ConfiguredFeature<?, ?> HYDRANGEA_HEDGE = createFlowerConfiguredFeature("hydrangea_hedge", BYGBlocks.HYDRANGEA_HEDGE);

    public static final ConfiguredFeature<?, ?> SAGE_WHITE = createFlowerConfiguredFeature("white_sage", BYGBlocks.WHITE_SAGE);
    public static final ConfiguredFeature<?, ?> SAGE_PURPLE = createFlowerConfiguredFeature("purple_sage", BYGBlocks.PURPLE_SAGE);
    public static final ConfiguredFeature<?, ?> DAFFODIL_YELLOW = createFlowerConfiguredFeature("yellow_daffodil", BYGBlocks.YELLOW_DAFFODIL);
    //    public static final ConfiguredFeature<?, ?> PUMPKIN = createConfiguredFeature("pumpkin", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(Blocks.PUMPKIN.defaultBlockState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.LUSH_GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).noProjection().build()));
    public static final ConfiguredFeature<?, ?> ALPINE_BELLFLOWER = createFlowerConfiguredFeature("alpine_bellflower", BYGBlocks.ALPINE_BELLFLOWER);
    //    public static final ConfiguredFeature<?, ?> WINTER_SCILLA = createConfiguredFeature("winter_scilla", Feature.FLOWER.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.WINTER_SCILLA.defaultBlockState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.LUSH_GRASS_BLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.PODZOL, Blocks.GRASS_BLOCK)).noProjection().build()));
    public static final ConfiguredFeature<?, ?> KOVAN_FLOWER = createFlowerConfiguredFeature("kovan_flower", BYGBlocks.KOVAN_FLOWER);
    //
//    public static final ConfiguredFeature<?, ?> NETHER_BRISTLE = createConfiguredFeature("nether_bristle", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.NETHER_BRISTLE.defaultBlockState()), new DoublePlantPlacer())).whitelist(ImmutableSet.of(BYGBlocks.OVERGROWN_NETHERRACK)).tries(1).noProjection().build()));
//
    public static final ConfiguredFeature<?, ?> TULIP_GREEN = createFlowerConfiguredFeature("green_tulip", BYGBlocks.GREEN_TULIP);
    public static final ConfiguredFeature<?, ?> TULIP_CYAN = createFlowerConfiguredFeature("cyan_tulip", BYGBlocks.CYAN_TULIP);
    public static final ConfiguredFeature<?, ?> TULIP_MAGENTA = createFlowerConfiguredFeature("magenta_tulip", BYGBlocks.MAGENTA_TULIP);
    public static final ConfiguredFeature<?, ?> TULIP_PURPLE = createFlowerConfiguredFeature("purple_tulip", BYGBlocks.PURPLE_TULIP);
    public static final ConfiguredFeature<?, ?> TULIP_YELLOW = createFlowerConfiguredFeature("yellow_tulip", BYGBlocks.YELLOW_TULIP);
    //
//    public static final ConfiguredFeature<?, ?> REED = createConfiguredFeature("reed", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.REEDS.defaultBlockState()), new DoublePlantPlacer())).tries(64).noProjection().needWater().build()));
    public static final ConfiguredFeature<?, ?> CATTAIL = createConfiguredFeature("cattail", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.CATTAIL))), List.of(), 15)));
    //
    public static final ConfiguredFeature<?, ?> LOLLIPOP_FLOWER = createFlowerConfiguredFeature("lollipop_flower", BYGBlocks.LOLLIPOP_FLOWER);
    public static final ConfiguredFeature<?, ?> LEATHER_FLOWER_PEACH = createFlowerConfiguredFeature("peach_leather_flower", BYGBlocks.PEACH_LEATHER_FLOWER);
    public static final ConfiguredFeature<?, ?> LEATHER_FLOWER_VIOLET = createFlowerConfiguredFeature("violet_leather_flower", BYGBlocks.VIOLET_LEATHER_FLOWER);
    //
//    public static final ConfiguredFeature<?, ?> DAFFODIL_PINK = createConfiguredFeature("pink_daffodil", Feature.FLOWER.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.PINK_DAFFODIL.defaultBlockState()), new SimpleBlockPlacer())).tries(64).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> DAFFODIL = createConfiguredFeature("daffodil", Feature.FLOWER.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.DAFFODIL.defaultBlockState()), new SimpleBlockPlacer())).tries(64).noProjection().build()));
    public static final ConfiguredFeature<?, ?> BLACK_ROSE = createFlowerConfiguredFeature("black_rose", BYGBlocks.BLACK_ROSE);
    public static final ConfiguredFeature<?, ?> CYAN_ROSE = createFlowerConfiguredFeature("cyan_rose", BYGBlocks.CYAN_ROSE);
    public static final ConfiguredFeature<?, ?> ROSE_OSIRIA = createFlowerConfiguredFeature("osiria_rose", BYGBlocks.ORSIRIA_ROSE);
    public static final ConfiguredFeature<?, ?> FAIRY_SLIPPER = createFlowerConfiguredFeature("fairy_slipper", BYGBlocks.FAIRY_SLIPPER);
    //
//    public static final ConfiguredFeature<?, ?> IVIS_ROOTS = createConfiguredFeature("ivis_roots", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.IVIS_ROOTS.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//    public static final ConfiguredFeature<?, ?> IVIS_SPROUT = createConfiguredFeature("ivis_sprout", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.IVIS_SPROUT.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//
//    public static final ConfiguredFeature<?, ?> BULBIS_SPROUTS = createConfiguredFeature("bulbis_sprouts", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.BULBIS_SPROUTS.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//    public static final ConfiguredFeature<?, ?> CRYPTIC_BRAMBLE = createConfiguredFeature("cryptic_bramble", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_BRAMBLE.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//
//    public static final ConfiguredFeature<?, ?> BULBIS_ODDITY = createConfiguredFeature("bulbis_oddity", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.BULBIS_ODDITY.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//    public static final ConfiguredFeature<?, ?> PURPLE_BULBIS_ODDITY = createConfiguredFeature("purple_bulbis_oddity", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.PURPLE_BULBIS_ODDITY.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//
//    public static final ConfiguredFeature<?, ?> BULBIS_ANOMALY = createConfiguredFeature("bulbis_anomaly", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.BULBIS_ANOMALY.defaultBlockState()), new DoublePlantPlacer())).tries(48).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> PURPLE_BULBIS_ANOMALY = createConfiguredFeature("purple_bulbis_anomaly", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.PURPLE_BULBIS_ANOMALY.defaultBlockState()), new DoublePlantPlacer())).tries(48).noProjection().build()));
//
//    public static final ConfiguredFeature<?, ?> TALL_ETHER_GRASS = createConfiguredFeature("tall_ether_grass", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.TALL_ETHER_GRASS.defaultBlockState()), new DoublePlantPlacer())).tries(32).build()));
//    public static final ConfiguredFeature<?, ?> ETHER_GRASS = createConfiguredFeature("ether_grass", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.ETHER_GRASS.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//    public static final ConfiguredFeature<?, ?> ETHER_BUSH = createConfiguredFeature("ether_bush", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.ETHER_BUSH.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//    public static final ConfiguredFeature<?, ?> THEREAL_BELLFLOWER = createConfiguredFeature("thereal_bellflower", Feature.FLOWER.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.THEREAL_BELLFLOWER.defaultBlockState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.ETHER_PHYLIUM, BYGBlocks.NIGHTSHADE_PHYLIUM, BYGBlocks.IVIS_PHYLIUM, Blocks.GRASS_BLOCK)).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> ETHER_FOLIAGE = createConfiguredFeature("ether_foliage", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.ETHER_FOLIAGE.defaultBlockState()), new SimpleBlockPlacer())).tries(24).build()));
//
//    public static final ConfiguredFeature<?, ?> NIGHTSHADE_SPROUTS = createConfiguredFeature("nightshade_sprouts", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.NIGHTSHADE_SPROUTS.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//    public static final ConfiguredFeature<?, ?> NIGHTSHADE_ROOTS = createConfiguredFeature("nightshade_roots", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.NIGHTSHADE_ROOTS.defaultBlockState()), new DoublePlantPlacer())).tries(32).build()));
//    public static final ConfiguredFeature<?, ?> NIGHTSHADE_BERRY_BUSH = createConfiguredFeature("nightshade_berry_bush", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.NIGHTSHADE_BERRY_BUSH.defaultBlockState().setValue(BlueBerryBush.AGE, Integer.valueOf(3))), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.NIGHTSHADE_PHYLIUM, BYGBlocks.ETHER_PHYLIUM, BYGBlocks.IVIS_PHYLIUM)).noProjection().build()));
//
//    public static final ConfiguredFeature<?, ?> ODDITY_CACTUS = createConfiguredFeature("oddity_cactus", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.ODDITY_CACTUS.defaultBlockState()), new ColumnPlacer(UniformInt.of(1, 4)))).tries(10).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> ODDITY_BUSH = createConfiguredFeature("oddity_bush", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.ODDITY_BUSH.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//    public static final ConfiguredFeature<?, ?> VERMILION_SCULK_GROWTH = createConfiguredFeature("vermilion_sculk_growth", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.VERMILION_SCULK_GROWTH.defaultBlockState()), ImmutableList.of(BYGBlocks.VERMILION_SCULK.defaultBlockState(), BYGBlocks.ETHER_STONE.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), BYGBlocks.VERMILION_SCULK.defaultBlockState(), BYGBlocks.ETHER_STONE.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> THERIUM_CRYSTAL = createConfiguredFeature("therium_crystal", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.THERIUM_CRYSTAL.defaultBlockState().setValue(TheriumCrystalBlock.AGE, 1)), ImmutableList.of(BYGBlocks.THERIUM_BLOCK.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), BYGBlocks.THERIUM_BLOCK.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> VERMILION_SCULK_TENDRILS = createConfiguredFeature("vermilion_sculk_tendrils", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.VERMILION_SCULK_TENDRILS.defaultBlockState()), ImmutableList.of(BYGBlocks.VERMILION_SCULK.defaultBlockState(), BYGBlocks.ETHER_STONE.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), BYGBlocks.VERMILION_SCULK.defaultBlockState(), BYGBlocks.ETHER_STONE.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> SHULKREN_MOSS = createConfiguredFeature("shulkren_moss_blanket", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.SHULKREN_MOSS_BLANKET.defaultBlockState()), ImmutableList.of(BYGBlocks.SHULKREN_PHYLIUM.defaultBlockState(), BYGBlocks.ETHER_PHYLIUM.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), BYGBlocks.SHULKREN_PHYLIUM.defaultBlockState(), BYGBlocks.ETHER_PHYLIUM.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> SHULKREN_FUNGUS = createConfiguredFeature("shulkren_fungus", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.SHULKREN_FUNGUS.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//
//    public static final ConfiguredFeature<?, ?> IMPARIUS_MUSHROOM = createConfiguredFeature("imparius_mushroom", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.IMPARIUS_MUSHROOM.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//    public static final ConfiguredFeature<?, ?> FUNGAL_IMPARIUS = createConfiguredFeature("fungal_imparius", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.FUNGAL_IMPARIUS.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//    public static final ConfiguredFeature<?, ?> IMPARIUS_BUSH = createConfiguredFeature("imparius_bush", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.IMPARIUS_BUSH.defaultBlockState()), new SimpleBlockPlacer())).tries(32).build()));
//
//    public static final ConfiguredFeature<?, ?> EMBUR_ROOTS = createConfiguredFeature("embur_roots", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.EMBUR_ROOTS.defaultBlockState()), ImmutableList.of(BYGBlocks.EMBUR_NYLIUM.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), BYGBlocks.EMBUR_NYLIUM.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> EMBUR_ROOTS_TALL = createConfiguredFeature("tall_embur_roots", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.TALL_EMBUR_ROOTS.defaultBlockState()), new DoublePlantPlacer())).tries(1).whitelist(ImmutableSet.of(BYGBlocks.EMBUR_NYLIUM)).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> EMBUR_WART = createConfiguredFeature("embur_wart", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.EMBUR_WART.defaultBlockState()), ImmutableList.of(BYGBlocks.EMBUR_NYLIUM.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), BYGBlocks.EMBUR_NYLIUM.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> EMBUR_SPROUT = createConfiguredFeature("embur_sprout", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.EMBUR_SPROUTS.defaultBlockState()), ImmutableList.of(BYGBlocks.EMBUR_NYLIUM.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), BYGBlocks.EMBUR_NYLIUM.defaultBlockState()))));
//
//    public static final ConfiguredFeature<?, ?> CRIMSON_ROOTS_TALL = createConfiguredFeature("tall_crimson_roots", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.TALL_EMBUR_ROOTS.defaultBlockState()), new DoublePlantPlacer())).tries(1).whitelist(ImmutableSet.of(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE)).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> CRIMSON_BERRY_BUSH = createConfiguredFeature("crimson_berry_bush", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRIMSON_BERRY_BUSH.defaultBlockState().setValue(CrimsonBerryBushBlock.AGE, 3)), ImmutableList.of(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE.defaultBlockState(), Blocks.BLACKSTONE.defaultBlockState()))));
//
//    public static final ConfiguredFeature<?, ?> SYTHIAN_ROOTS = createConfiguredFeature("sythian_root", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.SYTHIAN_ROOTS.defaultBlockState()), ImmutableList.of(BYGBlocks.SYTHIAN_NYLIUM.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), BYGBlocks.SYTHIAN_NYLIUM.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> SYTHIAN_SPROUT = createConfiguredFeature("sythian_sprout", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.SYTHIAN_SPROUT.defaultBlockState()), ImmutableList.of(BYGBlocks.SYTHIAN_NYLIUM.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), BYGBlocks.SYTHIAN_NYLIUM.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> SYTHIAN_FUNGUS = createConfiguredFeature("sythian_fungus", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.SYTHIAN_FUNGUS.defaultBlockState()), ImmutableList.of(BYGBlocks.SYTHIAN_NYLIUM.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState(), BYGBlocks.SYTHIAN_NYLIUM.defaultBlockState()))));
//    public static final ConfiguredFeature<?, ?> SOUL_SHROOM = createConfiguredFeature("soul_shroom", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.SOUL_SHROOM.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(64).noProjection().build()));
//    public static final ConfiguredFeature<?, ?> DEATH_CAP = createConfiguredFeature("death_cap", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.DEATH_CAP.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(64).noProjection().build()));
//
    public static final ConfiguredFeature<?, ?> DEAD_SEA_SPIKE = createConfiguredFeature("dead_sea_spike", BYGFeatures.POINTY_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 5).add(Blocks.STONE.defaultBlockState(), 3).add(Blocks.ANDESITE.defaultBlockState(), 2).build())).setSeed(65).build()));
    public static final ConfiguredFeature<?, ?> DEAD_SEA_SPIKE_TALL = createConfiguredFeature("dead_sea_tall_spike", BYGFeatures.POINTY_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 5).add(Blocks.STONE.defaultBlockState(), 3).add(Blocks.ANDESITE.defaultBlockState(), 2).build())).setSeed(85).build()));

    public static final ConfiguredFeature<?, ?> WINDSWEPT_SPIKE = createConfiguredFeature("windswept_spike", BYGFeatures.POINTY_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), 3).add(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE.defaultBlockState(), 2).build())).setSeed(65).build()));
    public static final ConfiguredFeature<?, ?> WINDSWEPT_SPIKE_TALL = createConfiguredFeature("windswept_tall_spike", BYGFeatures.POINTY_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), 3).add(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE.defaultBlockState(), 2).build())).setSeed(85).build()));


    //    public static final ConfiguredFeature<?, ?> IVIS_SPIKES = createConfiguredFeature("ivis_spikes1", BYGFeatures.TALL_POINTED_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OBSIDIAN.defaultBlockState(), 24).add(Blocks.CRYING_OBSIDIAN.defaultBlockState(), 1))).setSeed(120).setHeightMultiplier(0.4).build()));
//    public static final ConfiguredFeature<?, ?> IVIS_SPIKES2 = createConfiguredFeature("ivis_spikes2", BYGFeatures.TALL_POINTED_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OBSIDIAN.defaultBlockState(), 24).add(Blocks.CRYING_OBSIDIAN.defaultBlockState(), 1))).setSeed(15676).setHeightMultiplier(0.8).build()));
//
//    public static final ConfiguredFeature<?, ?> END_STONE_BRICK_SPIKE = createConfiguredFeature("end_stone_brick_spike1", BYGFeatures.TALL_POINTED_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.END_STONE_BRICKS.defaultBlockState(), 24).add(Blocks.END_STONE.defaultBlockState(), 1))).setSeed(120).setHeightMultiplier(0.3).build()));
//    public static final ConfiguredFeature<?, ?> END_STONE_BRICK_SPIKE2 = createConfiguredFeature("end_stone_brick_spike2", BYGFeatures.TALL_POINTED_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.END_STONE_BRICKS.defaultBlockState(), 24).add(Blocks.END_STONE.defaultBlockState(), 1))).setSeed(15676).setHeightMultiplier(0.4).build()));
//    public static final ConfiguredFeature<?, ?> END_STONE_BOULDER = createConfiguredFeature("end_stone_boulder", BYGFeatures.STACKABLE_BOULDERS.configured(new BoulderConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.END_STONE.defaultBlockState(), 3).add(Blocks.END_STONE_BRICKS.defaultBlockState(), 2))).setMinStackHeight(1).setMaxHeight(1).setMinRadius(4).setMaxRadius(8).build()).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.1F, 1))));
//
//    public static final ConfiguredFeature<?, ?> PURPUR_SPIKES = createConfiguredFeature("purpur_spikes1", BYGFeatures.TALL_POINTED_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.PURPUR_STONE.defaultBlockState(), 24).add(BYGBlocks.PURPUR_STONE.defaultBlockState(), 1))).setSeed(120).setHeightMultiplier(0.5).build()));
//    public static final ConfiguredFeature<?, ?> PURPUR_SPIKES2 = createConfiguredFeature("purpur_spikes2", BYGFeatures.TALL_POINTED_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.PURPUR_STONE.defaultBlockState(), 24).add(BYGBlocks.PURPUR_STONE.defaultBlockState(), 1))).setSeed(15676).setHeightMultiplier(0.4).build()));
//
//
//    public static final ConfiguredFeature<?, ?> VALLE_DE_LUNA_POINTY_ROCK = createConfiguredFeature("valle_de_luna_pointy_rock", BYGFeatures.POINTY_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.WHITE_SAND.defaultBlockState(), 5).add(BYGBlocks.WHITE_CUT_SANDSTONE.defaultBlockState(), 5))).setSeed(88).build()).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(28, 0.1F, 1))));
//    public static final ConfiguredFeature<?, ?> VALLE_DE_LUNA_POINTY_ROCK_LARGE = createConfiguredFeature("valle_de_luna_pointy_rock_large", BYGFeatures.POINTY_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.WHITE_SAND.defaultBlockState(), 5).add(BYGBlocks.WHITE_SMOOTH_SANDSTONE.defaultBlockState(), 5))).setSeed(100).build()).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(4, 0.1F, 1))));
//
//
//    public static final ConfiguredFeature<?, ?> ORE_PERVADED_NETHERRACK = createConfiguredFeature("ore_pervaded_netherrack", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, BYGBlocks.PERVADED_NETHERRACK.defaultBlockState(), 14)).range(Features.Decorators.RANGE_10_10).squared().count(14));
//    public static final ConfiguredFeature<?, ?> ORE_ANTHRACITE = createConfiguredFeature("ore_anthracite", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, BYGBlocks.ANTHRACITE_ORE.defaultBlockState(), 14)).range(Features.Decorators.RANGE_10_10).squared().count(12));
//    public static final ConfiguredFeature<?, ?> ORE_LIGNITE = createConfiguredFeature("ore_lignite", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, BYGBlocks.LIGNITE_ORE.defaultBlockState(), 14)).range(Features.Decorators.RANGE_10_10).squared().count(16));
//    public static final ConfiguredFeature<?, ?> ORE_CRYPTIC_REDSTONE = createConfiguredFeature("ore_cryptic_redstone", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, BYGBlocks.CRYPTIC_REDSTONE_ORE.defaultBlockState(), 14)).range(Features.Decorators.RANGE_10_10).squared().count(12));
//
//    public static final ConfiguredFeature<?, ?> ORE_BLUE_NETHER_GOLD = createConfiguredFeature("ore_blue_nether_gold", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, BYGBlocks.BLUE_NETHER_GOLD_ORE.defaultBlockState(), 10)).range(Features.Decorators.RANGE_10_10).squared().count(10));
//    public static final ConfiguredFeature<?, ?> ORE_BLUE_NETHER_QUARTZ = createConfiguredFeature("ore_blue_nether_quartz", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, BYGBlocks.BLUE_NETHER_QUARTZ_ORE.defaultBlockState(), 14)).range(Features.Decorators.RANGE_10_10).squared().count(16));
//
//    public static final ConfiguredFeature<?, ?> ORE_BRIMSTONE_NETHER_GOLD = createConfiguredFeature("ore_brimstone_nether_gold", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, BYGBlocks.BRIMSTONE_NETHER_GOLD_ORE.defaultBlockState(), 10)).range(Features.Decorators.RANGE_10_10).squared().count(10));
//    public static final ConfiguredFeature<?, ?> ORE_BRIMSTONE_NETHER_QUARTZ = createConfiguredFeature("ore_brimstone_nether_quartz", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, BYGBlocks.BRIMSTONE_NETHER_QUARTZ_ORE.defaultBlockState(), 14)).range(Features.Decorators.RANGE_10_10).squared().count(16));
//
//
    public static final ConfiguredFeature<?, ?> MOSSY_STONE_BOULDER = createConfiguredFeature("mossy_stone_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(BYGBlocks.MOSSY_STONE.defaultBlockState())));
    public static final ConfiguredFeature<?, ?> ROCKY_STONE_BOULDER = createConfiguredFeature("rocky_stone_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(BYGBlocks.ROCKY_STONE.defaultBlockState())));
    public static final ConfiguredFeature<?, ?> BLACKSTONE_BOULDER = createConfiguredFeature("blackstone_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.BLACKSTONE.defaultBlockState())));
    public static final ConfiguredFeature<?, ?> ORANGE_TERRACOTTA_BOULDER = createConfiguredFeature("orange_terracotta_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.ORANGE_TERRACOTTA.defaultBlockState())));
    //
//    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND1 = createConfiguredFeature("shattered_floating_island1", BYGFeatures.SHATTERED_FLOATING_ISLAND1.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build()));
//    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND2 = createConfiguredFeature("shattered_floating_island2", BYGFeatures.SHATTERED_FLOATING_ISLAND2.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build()));
//    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND3 = createConfiguredFeature("shattered_floating_island3", BYGFeatures.SHATTERED_FLOATING_ISLAND3.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build()));
//    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND4 = createConfiguredFeature("shattered_floating_island4", BYGFeatures.SHATTERED_FLOATING_ISLAND4.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(13).setMaxRadius(17).build()));
//
//    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND1 = createConfiguredFeature("floating_island1", BYGFeatures.FLOATING_ISLAND1.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 20).add(BYGBlocks.LIGNITE_ORE.defaultBlockState(), 2))).setMinRadius(11).setMaxRadius(13).build()));
//    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND2 = createConfiguredFeature("floating_island2", BYGFeatures.FLOATING_ISLAND2.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 20).add(BYGBlocks.LIGNITE_ORE.defaultBlockState(), 2))).setMinRadius(11).setMaxRadius(13).build()));
//    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND3 = createConfiguredFeature("floating_island3", BYGFeatures.FLOATING_ISLAND3.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 20).add(BYGBlocks.LIGNITE_ORE.defaultBlockState(), 2))).setMinRadius(11).setMaxRadius(13).build()));
//    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND4 = createConfiguredFeature("floating_island4", BYGFeatures.FLOATING_ISLAND4.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 20).add(BYGBlocks.LIGNITE_ORE.defaultBlockState(), 2))).setMinRadius(13).setMaxRadius(17).build()));
//    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND5 = createConfiguredFeature("floating_island5", BYGFeatures.FLOATING_ISLAND5.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 20).add(BYGBlocks.LIGNITE_ORE.defaultBlockState(), 2))).setMinRadius(13).setMaxRadius(17).build()));
//
//    public static final ConfiguredFeature<?, ?> FLOATING_DESERT_ISLAND1 = createConfiguredFeature("floating_desert_island1", BYGFeatures.FLOATING_ISLAND1.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.END_SAND).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.END_STONE_BRICKS.defaultBlockState(), 20).add(Blocks.END_STONE.defaultBlockState(), 2))).setMinRadius(12).setMaxRadius(19).build()));
//    public static final ConfiguredFeature<?, ?> FLOATING_DESERT_ISLAND2 = createConfiguredFeature("floating_desert_island2", BYGFeatures.FLOATING_ISLAND2.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.END_SAND).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.END_STONE_BRICKS.defaultBlockState(), 20).add(Blocks.END_STONE.defaultBlockState(), 2))).setMinRadius(12).setMaxRadius(20).build()));
//    public static final ConfiguredFeature<?, ?> FLOATING_DESERT_ISLAND3 = createConfiguredFeature("floating_desert_island3", BYGFeatures.FLOATING_ISLAND3.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.END_SAND).setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.END_STONE_BRICKS.defaultBlockState(), 20).add(Blocks.END_STONE.defaultBlockState(), 2))).setMinRadius(12).setMaxRadius(21).build()));
//
    public static final ConfiguredFeature<PumpkinConfig, ?> PUMPKIN1 = createConfiguredFeature("pumpkin1", BYGFeatures.LARGE_PUMPKIN1.configured(new PumpkinConfig.Builder().setPumpkinBlock(Blocks.PUMPKIN).build()));
    public static final ConfiguredFeature<PumpkinConfig, ?> PUMPKIN2 = createConfiguredFeature("pumpkin2", BYGFeatures.LARGE_PUMPKIN2.configured(new PumpkinConfig.Builder().setPumpkinBlock(Blocks.PUMPKIN).setStemBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).build()));
    //
//
//    /***********************************************************Configured & Decorated Features***********************************************************/
//
//    public static final ConfiguredFeature<?, ?> FROST_MAGMA_LAKE = createConfiguredFeature("frost_magma_lake", BYGFeatures.FROSTED_LAKE.configured(new BlockStateConfiguration(BYGBlocks.FROST_MAGMA.defaultBlockState())).range(Features.Decorators.FULL_RANGE).squared().rarity(4));
//    public static final ConfiguredFeature<?, ?> WARPED_CORAL_PLANT = createConfiguredFeature("warped_coral_plant", BYGFeatures.HUGE_WARPED_CORAL_PLANT.configured(new WhitelistedSimpleBlockProviderConfig(SimpleStateProvider.simple(BYGBlocks.WARPED_CORAL_BLOCK.defaultBlockState()), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState()))).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(2, 0.2F, 1))));
//    public static final ConfiguredFeature<?, ?> SYTHIAN_STALK = createConfiguredFeature("sythian_stalk", BYGFeatures.SYTHIAN_STALK.configured(new ProbabilityFeatureConfiguration(0.9F)).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(10, 0.5F, 8))));
//    public static final ConfiguredFeature<?, ?> EMBUR_LILY = createConfiguredFeature("embur_lily", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.EMBUR_LILY.defaultBlockState()), ImmutableList.of(Blocks.LAVA.defaultBlockState()), ImmutableList.of(Blocks.AIR.defaultBlockState()), ImmutableList.of(Blocks.LAVA.defaultBlockState()))).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(2, 0.5F, 2))));
    public static final ConfiguredFeature<?, ?> WIDE_WATER_LAKE = createConfiguredFeature("wide_water_lake", BYGFeatures.WIDE_LAKE.configured(new SimpleBlockProviderConfig(SimpleStateProvider.simple(Blocks.WATER.defaultBlockState()))));
    public static final ConfiguredFeature<?, ?> FROST_MAGMA_LAKE = createConfiguredFeature("wide_frost_magma_lake", BYGFeatures.WIDE_LAKE.configured(new SimpleBlockProviderConfig(SimpleStateProvider.simple(BYGBlocks.FROST_MAGMA.defaultBlockState()))));
    //    public static final ConfiguredFeature<?, ?> END_LAKE = createConfiguredFeature("end_lake", BYGFeatures.END_LAKE.configured(FeatureConfiguration.NONE).range(Features.Decorators.FULL_RANGE).squared().rarity(4));
//    public static final ConfiguredFeature<?, ?> BULBIS_WATER_LAKE = createConfiguredFeature("bulbis_water_lake", BYGFeatures.WIDE_LAKE.configured(new SimpleBlockProviderConfig(SimpleStateProvider.simple(Blocks.WATER.defaultBlockState()))).decorated(BYGDecorators.ANY_WATER_OR_SOLID_SURFACE.configured(new CountConfiguration(1))));


    public static final ConfiguredFeature<?, ?> LARGE_WINDSWEPT_LAKE = createConfiguredFeature("large_windswept_lake", BYGFeatures.LARGE_LAKE.configured(
            new LargeLakeFeatureConfig(15, 22, 4, 10, SimpleStateProvider.simple(BYGBlocks.WINDSWEPT_SAND), SimpleStateProvider.simple(BYGBlocks.WINDSWEPT_SAND),
                    List.of(() -> BYGConfiguredFeatures.TINY_LILY_PAD.placed(RarityFilter.onAverageOnceEvery(95), BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0)))), () -> LargeLakeFeatureConfig.createDripLeavesPlacedFeature(80, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)),
                    List.of(() -> LargeLakeFeatureConfig.createDripLeavesPlacedFeature(8, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR), () -> BYGConfiguredFeatures.PALM_TREES.placed(RarityFilter.onAverageOnceEvery(30), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BYGBlocks.PALM_SAPLING.defaultBlockState(), BlockPos.ZERO)))), List.of())));
    //
//    public static final ConfiguredFeature<?, ?> STACKED_BOULDERS = createConfiguredFeature("stacked_boulders", BYGFeatures.STACKABLE_BOULDERS.configured(new BoulderConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.STONE.defaultBlockState(), 3).add(Blocks.DIORITE.defaultBlockState(), 2))).setMinStackHeight(10).setMaxHeight(15).setMinRadius(8).setMaxRadius(28).build()).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.15F, 1))));
    public static final ConfiguredFeature<?, ?> LARGE_BOULDER = createConfiguredFeature("large_boulder", BYGFeatures.NOISE_SPHERE.configured(new NoisySphereConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 3).add(BYGBlocks.MOSSY_STONE.defaultBlockState(), 2))).setMinStackHeight(1).setMaxStackHeight(1).setMinXRadius(8).setMaxXRadius(12).setRadiusMatcher(RadiusMatcher.XZ).build()));
    public static final ConfiguredFeature<?, ?> LARGE_GRANITE_BOULDER = createConfiguredFeature("large_granite_boulder", BYGFeatures.NOISE_SPHERE.configured(new NoisySphereConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.GRANITE.defaultBlockState(), 3).add(Blocks.POLISHED_GRANITE.defaultBlockState(), 2))).setMinStackHeight(1).setMaxStackHeight(1).setMinXRadius(5).setMaxXRadius(9).setRadiusMatcher(RadiusMatcher.XZ).build()));
    public static final ConfiguredFeature<?, ?> LARGE_WINDSWEPT_BOULDER = createConfiguredFeature("large_windswept_boulders", BYGFeatures.NOISE_SPHERE.configured(
            new NoisySphereConfig.Builder()
                    .setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 158).add(Blocks.TUFF.defaultBlockState(), 41).add(Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 1)))
                    .setTopBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 158).add(Blocks.TUFF.defaultBlockState(), 41).add(Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 1)))
                    .setMinStackHeight(1).setMaxStackHeight(1).setMinXRadius(16).setMaxXRadius(25).setMinYRadius(20).setMaxYRadius(25).setNoiseFrequency(0.15F).setRadiusMatcher(RadiusMatcher.XZ)
                    .addSpawningFeature(() -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WINDSWEPT_SAND))).placed
                            (CountPlacement.of(UniformInt.of(10, 25)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                                    BlockPredicateFilter.forPredicate(BlockPredicate.anyOf(BlockPredicate.matchesBlock(Blocks.TUFF, new BlockPos(0, -1, 0)),
                                            BlockPredicate.matchesBlock(Blocks.DEEPSLATE_EMERALD_ORE, new BlockPos(0, -1, 0)), BlockPredicate.matchesBlock(BYGBlocks.ROCKY_STONE, new BlockPos(0, -1, 0)))))).build()));
    //
//    public static final ConfiguredFeature<?, ?> ARCH = createConfiguredFeature("arch", BYGFeatures.ARCH.configured(new SimpleBlockProviderConfig(SimpleStateProvider.simple(Blocks.DIAMOND_BLOCK.defaultBlockState()))).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.1F, 1))));
//    public static final ConfiguredFeature<?, ?> WINDSWEPT_ARCH = createConfiguredFeature("windswept_arch", BYGFeatures.WINDSWEPT_ARCH.configured(new SimpleBlockProviderConfig(SimpleStateProvider.simple(Blocks.EMERALD_BLOCK.defaultBlockState()))).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.1F, 1))));
//    public static final ConfiguredFeature<?, ?> CRYPTIC_CAVES = createConfiguredFeature("cryptic_caves", BYGFeatures.NOISY_CAVE_SPHERE.configured((new NoisySphereConfig.Builder().setMinXRadius(20).setMaxXRadius(30).setMinYRadius(10).setMaxYRadius(16).setMinZRadius(14).setMaxZRadius(20).setBlock(Blocks.CAVE_AIR).build())).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(55)))).squared().count(2));
//    public static final ConfiguredFeature<?, ?> GLOWSHROOM_CAVES = createConfiguredFeature("glow_caves", BYGFeatures.NOISY_CAVE_SPHERE.configured((new NoisySphereConfig.Builder().setMinXRadius(20).setMaxXRadius(30).setMinYRadius(10).setMaxYRadius(16).setMinZRadius(14).setMaxZRadius(20).setBlock(Blocks.CAVE_AIR).setFluidStartY(12).build())).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.aboveBottom(25), VerticalAnchor.aboveBottom(40)))).count(1)));
    public static final ConfiguredFeature<?, ?> STONE_FOREST_COLUMN = createConfiguredFeature("stone_forest_column", BYGFeatures.NOISE_SPHERE.configured(new NoisySphereConfig.Builder().setMinXRadius(8).setMaxXRadius(20).setMinYRadius(80).setMaxYRadius(100).setMinZRadius(6).setMaxZRadius(18).setMinStackHeight(1).setMaxStackHeight(4).setRadiusDivisor(2).setNoise2DChance(0.25).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.STONE.defaultBlockState(), 5))).setTopBlock(BYGBlocks.OVERGROWN_STONE).setFluidStartY(12).setNoiseFrequency(0.09F).setPositiveYRadiusAddition(17).setRadiusMatcher(RadiusMatcher.NONE).setSquaredDistanceCheck(false).build()));
    //    public static final ConfiguredFeature<?, ?> IVIS_FIELDS_COLUMN = createConfiguredFeature("ivis_fields_column", BYGFeatures.COLUMN.configured((new NoisySphereConfig.Builder().setMinXRadius(4).setMaxXRadius(14).setMinYRadius(35).setMaxYRadius(45).setMinZRadius(4).setMaxZRadius(14).setMinStackHeight(1).setMaxStackHeight(2).setRadiusDivisor(2).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OBSIDIAN.defaultBlockState(), 9).add(Blocks.CRYING_OBSIDIAN.defaultBlockState(), 1))).setTopBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OBSIDIAN.defaultBlockState(), 9).add(Blocks.CRYING_OBSIDIAN.defaultBlockState(), 1))).setFluidStartY(12).build())).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.45F, 1))));
//    public static final ConfiguredFeature<?, ?> IRON_SURFACE_DEPOSIT = createConfiguredFeature("iron_surface_deposit", BYGFeatures.MINERAL_DEPOSIT.configured((new NoisySphereConfig.Builder().setMinXRadius(6).setMaxXRadius(14).setMinYRadius(4).setMaxYRadius(9).setMinZRadius(4).setMaxZRadius(7).setBlock(Blocks.IRON_ORE).build())).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.05F, 2))));
//    public static final ConfiguredFeature<?, ?> ETHER_STONE_BOULDER = createConfiguredFeature("ether_stone_boulder", BYGFeatures.STACKABLE_BOULDERS.configured(new BoulderConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 20).add(BYGBlocks.LIGNITE_ORE.defaultBlockState(), 2))).setMinStackHeight(1).setMaxHeight(1).setMinRadius(8).setMaxRadius(12).build()).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.1F, 1))));
//    public static final ConfiguredFeature<?, ?> ENDER_LILY = createConfiguredFeature("ender_lily", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(SimpleStateProvider.simple(BYGBlocks.ENDER_LILY.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(10).build()).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(4));
//
//    public static final ConfiguredFeature<?, ?> CRYPTIC_SPIKE = createConfiguredFeature("cryptic_spike", BYGFeatures.SPIKE.configured(new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.CRYPTIC_STONE.defaultBlockState(), 5).add(BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState(), 5)))).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.18F, 1))));
    public static final ConfiguredFeature<?, ?> BLACK_ICE = createConfiguredFeature("black_ice_snow", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.BLACK_ICE))));
    //    public static final ConfiguredFeature<?, ?> BULBIS_GARDENS_CAVES = createConfiguredFeature("bulbis_gardens_caves", BYGFeatures.NOISY_CAVE_SPHERE_WATER.configured((new NoisySphereConfig.Builder().setMinXRadius(20).setMaxXRadius(30).setMinYRadius(10).setMaxYRadius(16).setMinZRadius(14).setMaxZRadius(20).setBlock(Blocks.CAVE_AIR).build())).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(55)))).squared().count(2));
//    public static final ConfiguredFeature<?, ?> CANYON_RIVER = createConfiguredFeature("ahhhh", BYGFeatures.CANYON_RIVER.configured(new NoneFeatureConfiguration()).decorated(FeatureDecorator.NOPE.configured(new NoneDecoratorConfiguration())));
//
//    public static final ConfiguredFeature<?, ?> THERIUM_CRYSTAL_DEPOSIT = createConfiguredFeature("therium_crystal_deposit", BYGFeatures.STACKABLE_BOULDERS.configured(new BoulderConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.THERIUM_BLOCK.defaultBlockState(), 20).add(BYGBlocks.ETHER_STONE.defaultBlockState(), 2))).setMinStackHeight(0).setMaxHeight(0).setMinRadius(4).setMaxRadius(5).build()).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.015F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RED_ROCK_BOULDER = createConfiguredFeature("red_rock_boulder", BYGFeatures.STACKABLE_BOULDERS.configured(new BoulderConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.RED_ROCK.defaultBlockState(), 3).add(BYGBlocks.RED_ROCK.defaultBlockState(), 9).add(Blocks.RED_CONCRETE.defaultBlockState(), 1))).setMinStackHeight(7).setMaxHeight(12).setMinRadius(8).setMaxRadius(12).build()));
//    public static final ConfiguredFeature<?, ?> WHITE_SANDSTONE_BOULDER = createConfiguredFeature("white_sandstone_boulder", BYGFeatures.STACKABLE_BOULDERS.configured(new BoulderConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.WHITE_SANDSTONE.defaultBlockState(), 3).add(BYGBlocks.WHITE_SMOOTH_SANDSTONE.defaultBlockState(), 2).add(BYGBlocks.WHITE_SMOOTH_SANDSTONE.defaultBlockState(), 3).add(BYGBlocks.WHITE_SAND.defaultBlockState(), 5))).setMinStackHeight(3).setMaxHeight(12).setMinRadius(13).setMaxRadius(20).setRadiusDivisor(1.1).flattenTopBoulder().build()).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.04F, 1))));
//    public static final ConfiguredFeature<?, ?> TERRACOTTA_BOULDER = createConfiguredFeature("terracotta_boulder", BYGFeatures.STACKABLE_BOULDERS.configured(new BoulderConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.TERRACOTTA.defaultBlockState(), 3).add(Blocks.TERRACOTTA.defaultBlockState(), 3).add(Blocks.RED_TERRACOTTA.defaultBlockState(), 7))).setMinStackHeight(7).setMaxHeight(12).setMinRadius(8).setMaxRadius(12).build()));
//
//
//    public static final ConfiguredFeature<?, ?> RIVER = createConfiguredFeature("river_aheehee", BYGFeatures.HUH.configured(DecoratedFeatureConfiguration.NONE).decorated(FeatureDecorator.NOPE.configured(new NoneDecoratorConfiguration())));
//    public static final ConfiguredFeature<?, ?> VOLCANO = createConfiguredFeature("volcano", BYGFeatures.VOLCANO.configured(new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.BLACKSTONE.defaultBlockState(), 4).add(Blocks.BLACK_CONCRETE.defaultBlockState(), 3).add(Blocks.STONE.defaultBlockState(), 2).add(BYGBlocks.MAGMATIC_STONE.defaultBlockState(), 1)))).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.025F, 1))));
//    public static final ConfiguredFeature<?, ?> PURPUR_PEAK = createConfiguredFeature("purpur_peak", BYGFeatures.PURPUR_PEAK.configured(new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.PURPUR_STONE.defaultBlockState(), 10).build()))).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.25F, 1))));
//    public static final ConfiguredFeature<?, ?> BASALT_DELTA = createConfiguredFeature("delta", Feature.DELTA_FEATURE.configured(new DeltaFeatureConfiguration(Blocks.WATER.defaultBlockState(), Blocks.WATER.defaultBlockState(), UniformInt.of(3, 4), UniformInt.of(0, 2))).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(2))));
//    public static final ConfiguredFeature<?, ?> SMALL_BASALT_COLUMN = createConfiguredFeature("small_basalt_columns", Feature.BASALT_COLUMNS.configured(new ColumnFeatureConfiguration(UniformInt.of(0, 1), UniformInt.of(1, 1))).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(1))));
//    public static final ConfiguredFeature<?, ?> LARGE_BASALT_COLUMN = createConfiguredFeature("large_basalt_columns", Feature.BASALT_COLUMNS.configured(new ColumnFeatureConfiguration(UniformInt.of(1, 2), UniformInt.of(1, 1))).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(1))));
//
//    /***********************************************************Configured Placement***********************************************************/
//
//    public static final ConfiguredFeature<?, ?> BULBIS_SPROUT_PLANT = createConfiguredFeature("bulbis_sprout_plant", BULBIS_SPROUTS.decorated(Features.Decorators.FIRE).count(5));
//
//    public static final ConfiguredFeature<?, ?> CALIFORNIA_POPPIES = createConfiguredFeature("california_poppies", CALIFORNIA_POPPY.decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(2));
//    public static final ConfiguredFeature<?, ?> WINTER_SUCCLULENTS = createConfiguredFeature("winter_succulents", WINTER_SUCCULENT.decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(2));
//    public static final ConfiguredFeature<?, ?> BLACKSTONE_BOULDERS = createConfiguredFeature("blackstone_boulders", BLACKSTONE_BOULDER.decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.3F, 3))));
//    public static final ConfiguredFeature<?, ?> ROCKY_STONE_BOULDERS = createConfiguredFeature("rocky_stone_boulders", ROCKY_STONE_BOULDER.decorated(Features.Decorators.HEIGHTMAP_SQUARE).countRandom(2));
//    public static final ConfiguredFeature<?, ?> MOSSY_STONE_BOULDERS = createConfiguredFeature("mossy_stone_boulders", MOSSY_STONE_BOULDER.decorated(Features.Decorators.HEIGHTMAP_SQUARE).countRandom(2));
//    public static final ConfiguredFeature<?, ?> FIRECRACKER_BUSHES = createConfiguredFeature("firecracker_bushes", FIRECRACKER_BUSH.decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(2));
//    public static final ConfiguredFeature<?, ?> PUMPKINS = createConfiguredFeature("pumpkins", PUMPKIN.decorated(Features.Decorators.ADD_32).count(8));
//    public static final ConfiguredFeature<?, ?> SHORT_GRASSES = createConfiguredFeature("short_grass", SHORT_GRASS.decorated(Features.Decorators.ADD_32).count(10));
//    public static final ConfiguredFeature<?, ?> EMBUR_SPROUTS = createConfiguredFeature("embur_sprouts", EMBUR_SPROUT.decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(30))));
//    public static final ConfiguredFeature<?, ?> NYLIUM_SOUL_FIRE = createConfiguredFeature("nylium_soul_fire", NYLIUM_SOUL_FIRE_PATCH.decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(1))));
//    public static final ConfiguredFeature<?, ?> CRYPTIC_FIRE = createConfiguredFeature("cryptic_fire", CRYPTIC_FIRE_PATCH.decorated(Features.Decorators.FIRE).count(2));
//    public static final ConfiguredFeature<?, ?> MAGMA_FIRE = createConfiguredFeature("magma_fire", MAGMA_FIRE_PATCH.decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(1))));
//    public static final ConfiguredFeature<?, ?> BORIC_FIRE = createConfiguredFeature("boric_fire", BORIC_FIRE_PATCH.decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(1))));
//    public static final ConfiguredFeature<?, ?> QUARTZ_CRYSTALS = createConfiguredFeature("quartz_crystals", QUARTZ_CRYSTAL.decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(50))));
//    public static final ConfiguredFeature<?, ?> CRYPTIC_BRAMBLES = createConfiguredFeature("cryptic_brambles", CRYPTIC_BRAMBLE.decorated(Features.Decorators.FIRE).count(1));
//
//
//    /***********************************************************Configured Random Selector Features***********************************************************/
//
//    public static final ConfiguredFeature<?, ?> RANDOM_ALLIUM_FLOWER = createConfiguredFeature("allium_flowers", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            ALLIUM_TALL_BUSH.weighted(0.25F),
//            ALLIUM_TALL_PINK_BUSH.weighted(0.25F),
//            ALLIUM_BUSH.weighted(0.25F)),
//            ALLIUM_PINK_BUSH)).decorated(Features.Decorators.FIRE).count(60));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_AMARANTH_FLOWER = createConfiguredFeature("amaranth_flowers", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            AMARANTH.weighted(0.2F),
//            AMARANTH_CYAN.weighted(0.2F),
//            AMARANTH_MAGENTA.weighted(0.2F),
//            AMARANTH_ORANGE.weighted(0.2F)),
//            AMARANTH_PURPLE)).decorated(Features.Decorators.FIRE).count(60));
//
    public static final ConfiguredFeature<?, ?> ROSE_FIELD_FLOWERS = createConfiguredFeature("rose_field_flowers", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ROSE_OSIRIA.placed(), 0.25F),
            new WeightedPlacedFeature(ROSE.placed(), 0.25F)),
            ROSE_BUSH.placed())));
    //
    public static final ConfiguredFeature<?, ?> DESERT_VEGETATION = createConfiguredFeature("desert_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(MINI_CACTI.placed(), 0.3F),
            new WeightedPlacedFeature(PRICKLY_PEAR_CACTI.placed(), 0.3F),
            new WeightedPlacedFeature(FIRECRACKER_BUSH.placed(), 0.1F)),
            GOLDEN_SPINED_CACTI.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_LUNA_BOULDERS = createConfiguredFeature("luna_boulders", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            RED_ROCK_BOULDER.weighted(0.5F)),
//            TERRACOTTA_BOULDER)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.3F, 1))));
//
    public static final ConfiguredFeature<?, ?> PRAIRIE_GRASS = createConfiguredFeature("prairie_grass", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(PRAIRIE_GRASS_PATCH.placed(), 0.75F)),
            TALL_PRAIRIE_GRASS_PATCH.placed())));
    //
//
//    public static final ConfiguredFeature<?, ?> RANDOM_BYG_SHRUB = createConfiguredFeature("shrub", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SHRUB.weighted(0.50F)),
//            SHRUB)).decorated(Features.Decorators.ADD_32).count(1));
//
//
    public static final ConfiguredFeature<?, ?> MUSHROOMS = createConfiguredFeature("mushrooms", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(WOOD_BLEWIT.placed(), 0.33F), new WeightedPlacedFeature(WEEPING_MILKCAP.placed(), 0.33F)), GREEN_MUSHROOM.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSTONE_GARDEN_VEGETATION = createConfiguredFeature("glowstone_garden_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SOUL_SHROOM.weighted(0.2F),
//            DEATH_CAP.weighted(0.2F)),
//            NETHER_BRISTLE)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(4)).count(1)));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_CRIMSON_GARDEN_VEGETATION = createConfiguredFeature("crimson_garden_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            EMBUR_ROOTS_TALL.weighted(0.45F),
//            CRIMSON_ROOTS_TALL.weighted(0.8F)),
//            CRIMSON_BERRY_BUSH)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(25))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_BOG_PLANT = createConfiguredFeature("embur_bog_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            EMBUR_ROOTS_TALL.weighted(0.45F),
//            EMBUR_ROOTS.weighted(0.5F)),
//            EMBUR_WART)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(50))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SUBZERO_ASH_PATCH = createConfiguredFeature("subzero_ashes", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SUBZERO_ASH.weighted(0.6F)),
//            SUBZERO_ASH_BLOCK)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(3))));
//
//    public static final ConfiguredFeature<?, ?> WEEPING_ROOTS = createConfiguredFeature("weeping_roots", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.GLOWSTONE).setBlock(BYGBlocks.WEEPING_ROOTS_PLANT).setEndBlock(BYGBlocks.WEEPING_ROOTS.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setWhitelist(ImmutableList.of(Blocks.NETHERRACK, Blocks.GLOWSTONE, Blocks.BLACKSTONE)).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(80));
//    public static final ConfiguredFeature<?, ?> WEEPING_VINES = createConfiguredFeature("weeping_vines", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.GLOWSTONE).setBlock(Blocks.WEEPING_VINES_PLANT).setEndBlock(Blocks.WEEPING_VINES.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setWhitelist(ImmutableList.of(Blocks.NETHERRACK, Blocks.GLOWSTONE, Blocks.BLACKSTONE)).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(80));
//    public static final ConfiguredFeature<?, ?> SOUL_SOIL_PILLARS = createConfiguredFeature("soul_soil_pillars", BYGFeatures.PILLARS.configured(new SimpleBlockProviderConfig(SimpleStateProvider.simple(BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState()))).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(50));
//    public static final ConfiguredFeature<?, ?> FROST_MAGMA_PILLARS = createConfiguredFeature("frost_magma_pillars", BYGFeatures.PILLARS.configured((new SimpleBlockProviderConfig(SimpleStateProvider.simple(BYGBlocks.FROST_MAGMA.defaultBlockState())))).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(50));
//    public static final ConfiguredFeature<?, ?> MAGMA_PILLARS = createConfiguredFeature("magma_pillars", BYGFeatures.PILLARS.configured((new SimpleBlockProviderConfig(SimpleStateProvider.simple(BYGBlocks.MAGMATIC_STONE.defaultBlockState())))).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(65));
//    public static final ConfiguredFeature<?, ?> BRIMSTONE_PILLARS = createConfiguredFeature("brimstone_pillars", BYGFeatures.PILLARS.configured((new SimpleBlockProviderConfig(SimpleStateProvider.simple(BYGBlocks.BRIMSTONE.defaultBlockState())))).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(80));
//    public static final ConfiguredFeature<?, ?> BRIMSTONE_VENTS = createConfiguredFeature("brimstone_vent", BYGFeatures.BRIMSTONE_VENT_FEATURE.configured(new BrimstoneVentsConfig.Builder().setLavaBlock(Blocks.LAVA).setBlock(BYGBlocks.BRIMSTONE).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(64)))).squared().count(30));
//
//    public static final ConfiguredFeature<?, ?> QUARTZ_COLUMNS = createConfiguredFeature("quartz_columns", BYGFeatures.QUARTZ_COLUMNS.configured(new ColumnFeatureConfiguration(UniformInt.of(1, 1), UniformInt.of(1, 3))).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(4))));
//    public static final ConfiguredFeature<?, ?> QUARTZ_SPIKE = createConfiguredFeature("quartz_spike", BYGFeatures.QUARTZ_SPIKES.configured(new QuartzSpikeConfig.Builder().setBlock(BYGBlocks.QUARTZITE_SAND).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(40));
//
//    public static final ConfiguredFeature<?, ?> SUBZERO_CRYSTAL = createConfiguredFeature("subzero_crystal", BYGFeatures.SUBZERO_CRYSTAL.configured(new NoneFeatureConfiguration()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(60));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SYTHIAN_PLANT = createConfiguredFeature("sythian_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SYTHIAN_SPROUT.weighted(0.5F),
//            SYTHIAN_ROOTS.weighted(0.46F)),
//            SYTHIAN_FUNGUS)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(50))));
//
//    public static final ConfiguredFeature<?, ?> HANGING_SOUL_SHROOM_SPORES = createConfiguredFeature("hanging_soul_shroom_spores", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setBlock(BYGBlocks.SOUL_SHROOM_SPORE).setEndBlock(BYGBlocks.SOUL_SHROOM_SPORE_END.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.SOUL_SOIL, Blocks.SOUL_SAND, BYGBlocks.NYLIUM_SOUL_SAND, BYGBlocks.NYLIUM_SOUL_SAND)).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(45));
//    public static final ConfiguredFeature<?, ?> HANGING_SYTHIAN_ROOTS = createConfiguredFeature("hanging_sythian_roots", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT.defaultBlockState()).setEndBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.NETHERRACK, BYGBlocks.SYTHIAN_WART_BLOCK)).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(80));
//    public static final ConfiguredFeature<?, ?> MOSSY_NETHERRACK_PILLARS = createConfiguredFeature("mossy_netherrack_pillars", BYGFeatures.PILLARS.configured(new SimpleBlockProviderConfig(SimpleStateProvider.simple(BYGBlocks.MOSSY_NETHERRACK.defaultBlockState()))).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(50));
//    public static final ConfiguredFeature<?, ?> SYTHIAN_FUNGUS_PILLARS = createConfiguredFeature("sythian_fungus_pillars", BYGFeatures.PILLARS.configured(new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.SYTHIAN_HYPHAE.defaultBlockState(), 9).add(BYGBlocks.SYTHIAN_HYPHAE.defaultBlockState(), 1)))).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(50));
//    public static final ConfiguredFeature<?, ?> HANGING_BONE_FEATURE = createConfiguredFeature("hanging_bone", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.BONE_BLOCK).setBlock(BYGBlocks.HANGING_BONE).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(BYGBlocks.QUARTZITE_SAND, Blocks.BONE_BLOCK)).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(70));
//    public static final ConfiguredFeature<?, ?> LAMENT_VINE_FEATURE = createConfiguredFeature("lament_vine", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.NETHERRACK).setBlock(BYGBlocks.LAMENT_VINE_PLANT).setEndBlock(BYGBlocks.LAMENT_VINE.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.NETHERRACK)).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(70));
//
//    public static final ConfiguredFeature<?, ?> HANGING_CHAINS = createConfiguredFeature("hanging_chains", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SCORIA_STONE).setBlock(Blocks.CHAIN.defaultBlockState()).setEndBlock(Blocks.CHAIN.defaultBlockState()).setMinLength(8).setMaxLength(16).setWhitelist(ImmutableList.of(BYGBlocks.SCORIA_STONE)).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.aboveBottom(0), VerticalAnchor.belowTop(0)))).squared().count(80));
//    public static final ConfiguredFeature<?, ?> HANGING_LANTERNS = createConfiguredFeature("hanging_lanterns", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SCORIA_STONE).setBlock(Blocks.CAVE_AIR.defaultBlockState()).setEndBlock(BYGBlocks.WAILING_BELL_BLOSSOM.defaultBlockState()).setMinLength(1).setMaxLength(4).setWhitelist(ImmutableList.of(BYGBlocks.SCORIA_STONE)).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.aboveBottom(0), VerticalAnchor.belowTop(0)))).squared().count(80));
//
//    public static final ConfiguredFeature<?, ?> HANGING_THERIUM_LANTERNS = createConfiguredFeature("hanging_therium_lanterns", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.ETHER_STONE).setBlock(Blocks.CHAIN.defaultBlockState()).setEndBlock(BYGBlocks.THERIUM_LANTERN.defaultBlockState().setValue(LanternBlock.HANGING, true)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(BYGBlocks.ETHER_STONE)).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.aboveBottom(0), VerticalAnchor.belowTop(0)))).squared().count(80));
//    public static final ConfiguredFeature<?, ?> HANGING_SHULKREN_VINE = createConfiguredFeature("hanging_shulkren_vine", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.END_STONE).setBlock(BYGBlocks.SHULKREN_VINE_PLANT.defaultBlockState()).setEndBlock(BYGBlocks.SHULKREN_VINE.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.END_STONE, BYGBlocks.SHULKREN_PHYLIUM)).build()).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.aboveBottom(0), VerticalAnchor.belowTop(0)))).squared().count(80));
//
    public static final ConfiguredFeature<?, ?> JUNGLE_FLOWERS = createConfiguredFeature("jungle_flowers", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BISTORT.placed(), 0.142F),
            new WeightedPlacedFeature(GUZMANIA.placed(), 0.142F),
            new WeightedPlacedFeature(BEGONIA.placed(), 0.142F),
            new WeightedPlacedFeature(LAZARUS_BELLFLOWER.placed(), 0.142F),
            new WeightedPlacedFeature(RICHEA.placed(), 0.142F),
            new WeightedPlacedFeature(TORCH_GINGER.placed(), 0.142F)),
            INCAN_LILY.placed())));
    //
//
//
    public static final ConfiguredFeature<?, ?> JACARANDA_BUSHES = createConfiguredFeature("jacaranda_bushes", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(FLOWERING_INDIGO_JACARANDA_BUSH.placed(), 0.25F),
            new WeightedPlacedFeature(FLOWERING_JACARANDA_BUSH.placed(), 0.25F),
            new WeightedPlacedFeature(INDIGO_JACARANDA_BUSH.placed(), 0.25F)),
            JACARANDA_BUSH.placed())));
    //
    public static final ConfiguredFeature<?, ?> SWAMP_WATER_VEGETATION = createConfiguredFeature("swamp_water_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(TINY_LILY_PAD.placed(), 0.50F)),
            WATER_SILK.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_LILY_PADS = createConfiguredFeature("lily_pads", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            TINY_LILY_PAD.weighted(0.50F)),
//            Features.PATCH_WATERLILLY)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(3));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_CLOVER_FLOWER_PATCH = createConfiguredFeature("clover_flower_patch", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            CLOVER_PATCH.weighted(0.5F)),
//            FLOWER_PATCH)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(5));
//
    public static final ConfiguredFeature<?, ?> CHERRY_FOLIAGE = createConfiguredFeature("cherry_foliage", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(WHITE_CHERRY_FOLIAGE.placed(), 0.5F)),
            PINK_CHERRY_FOLIAGE.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_WARPED_DESERT_VEGETATION = createConfiguredFeature("warped_desert_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            WARPED_BUSH.weighted(0.25F),
//            WARPED_CORAL.weighted(0.25F),
//            WARPED_CORAL_FAN.weighted(0.25F)),
//            BYG.ENABLE_CACTI ? WARPED_CACTI : Feature.NO_OP.configured(NoneFeatureConfiguration.INSTANCE))).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(16))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SCORCHED_PLANT = createConfiguredFeature("scorched_plant", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SCORCHED_GRASS.weighted(0.6F)),
//            SCORCHED_BUSH)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(50))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_LAMENT_VEGETATION = createConfiguredFeature("lament_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SCORCHED_BUSH.weighted(0.2F),
//            SCORCHED_GRASS.weighted(0.2F)),
//            LAMENT_SPROUTS)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(50))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_WAILING_VEGETATION = createConfiguredFeature("wailing_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SCORCHED_BUSH.weighted(0.2F),
//            SCORCHED_GRASS.weighted(0.2F)),
//            WAILING_GRASS)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(50))));
//
    public static final ConfiguredFeature<?, ?> ANEMONES = createConfiguredFeature("anemones", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ANEMONE_PINK.placed(), 0.5F)), ANEMONE_WHITE.placed())));
    //
    public static final ConfiguredFeature<?, ?> SAGES = createConfiguredFeature("sages", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(SAGE_PURPLE.placed(), 0.5F)),
            SAGE_WHITE.placed())));
    //
    public static final ConfiguredFeature<?, ?> HYDRANGEAS = createConfiguredFeature("hydrangeas", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(HYDRANGEA_BUSH.placed(), 0.5F)),
            HYDRANGEA_HEDGE.placed())));

    public static final ConfiguredFeature<?, ?> TULIPS = createConfiguredFeature("tulips", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(TULIP_MAGENTA.placed(), 0.2F),
            new WeightedPlacedFeature(TULIP_YELLOW.placed(), 0.2F),
            new WeightedPlacedFeature(TULIP_PURPLE.placed(), 0.2F),
            new WeightedPlacedFeature(TULIP_CYAN.placed(), 0.2F)),
            TULIP_GREEN.placed())));
    //
    public static final ConfiguredFeature<?, ?> LEATHER_FLOWERS = createConfiguredFeature("leather_flowers", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(LEATHER_FLOWER_PEACH.placed(), 0.5F)), LEATHER_FLOWER_VIOLET.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_DAFFODILS = createConfiguredFeature("daffodils", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            DAFFODIL.weighted(0.5F)),
//            DAFFODIL_PINK)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(2));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_IVIS_PLANTS = createConfiguredFeature("ivis_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            IVIS_ROOTS.weighted(0.5F)),
//            IVIS_SPROUT)).decorated(Features.Decorators.FIRE).count(5));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_BULBIS_ODDITY = createConfiguredFeature("bulbis_oddities", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            BULBIS_ODDITY.weighted(0.5F)),
//            PURPLE_BULBIS_ODDITY)).decorated(Features.Decorators.FIRE).count(1));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_BULBIS_ANOMALY = createConfiguredFeature("bulbis_anomalies", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            BULBIS_ANOMALY.weighted(0.5F)),
//            PURPLE_BULBIS_ANOMALY)).decorated(Features.Decorators.FIRE).count(1));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_ETHER_PLANT = createConfiguredFeature("ether_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            TALL_ETHER_GRASS.weighted(0.35F),
//            ETHER_BUSH.weighted(0.2F)),
//            ETHER_GRASS)).decorated(Features.Decorators.FIRE).count(8));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_NIGHTSHADE_PLANT = createConfiguredFeature("nightshade_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            NIGHTSHADE_ROOTS.weighted(0.35F)),
//            NIGHTSHADE_SPROUTS)).decorated(Features.Decorators.FIRE).count(5));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_ODDITY_PLANT = createConfiguredFeature("oddity_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            (BYG.ENABLE_CACTI ? ODDITY_CACTUS : Feature.NO_OP.configured(NoneFeatureConfiguration.INSTANCE)).weighted(0.5F)),
//            ODDITY_BUSH)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(16))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_CRYPTIC_VENT = createConfiguredFeature("rs_cryptic_vent", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            CRYPTIC_VENT.weighted(0.50F)),
//            TALL_CRYPTIC_VENT)).decorated(Features.Decorators.ADD_32).count(2));
//
    public static final ConfiguredFeature<?, ?> DEAD_SEA_SPIKES = createConfiguredFeature("dead_sea_spikes", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(DEAD_SEA_SPIKE.placed(), 0.75F)),
            DEAD_SEA_SPIKE_TALL.placed())));

    public static final ConfiguredFeature<?, ?> WINDSWEPT_SPIKES = createConfiguredFeature("windswept_spikes", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(WINDSWEPT_SPIKE.placed(), 0.75F)),
            WINDSWEPT_SPIKE_TALL.placed())));
    //
    public static final ConfiguredFeature<?, ?> LARGE_PUMPKINS = createConfiguredFeature("large_pumpkin", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(PUMPKIN1.placed(), 0.5F)), PUMPKIN2.placed())));
    //
//
//    /***********************************************************Configured Tree Features********************************************************/
//
//    public static final ConfiguredFeature<?, ?> DUMMY_TREE = createConfiguredFeature("dummy_trees", BYGFeatures.DUMMY_TREE.configured(DecoratedFeatureConfiguration.NONE).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(10000, 0.4F, 8))));
//
    public static final ConfiguredFeature<BYGTreeConfig, ?> ARAUCARIA_TREE1 = createConfiguredFeature("araucaria_tree1", BYGFeatures.ARAUCARIA_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.ARAUCARIA_LEAVES).setMaxHeight(24).setMinHeight(16).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ARAUCARIA_TREE2 = createConfiguredFeature("araucaria_tree2", BYGFeatures.ARAUCARIA_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.ARAUCARIA_LEAVES).setMaxHeight(24).setMinHeight(16).build()));
    //
    public static final ConfiguredFeature<BYGTreeConfig, ?> ANCIENT_TREE1 = createConfiguredFeature("ancient_tree1", BYGFeatures.ANCIENT_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).setMaxHeight(25).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ANCIENT_TREE2 = createConfiguredFeature("ancient_tree2", BYGFeatures.ANCIENT_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(25).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ANCIENT_TREE3 = createConfiguredFeature("ancient_tree3", BYGFeatures.ANCIENT_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES).setMaxHeight(25).setMinHeight(15).build()));
    //
    public static final ConfiguredFeature<BYGTreeConfig, ?> ASPEN_SHRUB1 = createConfiguredFeature("aspen_shrub1", BYGFeatures.SHRUB1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ASPEN_SHRUB2 = createConfiguredFeature("aspen_shrub2", BYGFeatures.SHRUB2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ASPEN_TREE1 = createConfiguredFeature("aspen_tree1", BYGFeatures.ASPEN_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMaxHeight(10).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ASPEN_TREE2 = createConfiguredFeature("aspen_tree2", BYGFeatures.ASPEN_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMaxHeight(19).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ASPEN_TREE3 = createConfiguredFeature("aspen_tree3", BYGFeatures.ASPEN_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMaxHeight(18).setMinHeight(11).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> BAOBAB_TREE1 = createConfiguredFeature("baobab_tree1", BYGFeatures.BAOBAB_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BAOBAB_LOG).setLeavesBlock(BYGBlocks.BAOBAB_LEAVES).setMaxHeight(28).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BAOBAB_TREE2 = createConfiguredFeature("baobab_tree2", BYGFeatures.BAOBAB_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BAOBAB_LOG).setLeavesBlock(BYGBlocks.BAOBAB_LEAVES).setMaxHeight(28).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BAOBAB_TREE3 = createConfiguredFeature("baobab_tree3", BYGFeatures.BAOBAB_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BAOBAB_LOG).setLeavesBlock(BYGBlocks.BAOBAB_LEAVES).setMaxHeight(28).setMinHeight(20).build()));

    //Birch
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_TREE1 = createConfiguredFeature("birch_tree1", BYGFeatures.BIRCH_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_TREE2 = createConfiguredFeature("birch_tree2", BYGFeatures.BIRCH_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).setMaxHeight(13).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_TREE3 = createConfiguredFeature("birch_tree3", BYGFeatures.BIRCH_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).setMaxHeight(28).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_TREE4 = createConfiguredFeature("birch_tree4", BYGFeatures.BIRCH_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(8).build()));


    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_BROWN_TREE1 = createConfiguredFeature("brown_birch_tree1", BYGFeatures.BIRCH_TREE1.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE1.config).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_BROWN_TREE2 = createConfiguredFeature("brown_birch_tree2", BYGFeatures.BIRCH_TREE2.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE2.config).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_BROWN_TREE3 = createConfiguredFeature("brown_birch_tree3", BYGFeatures.BIRCH_TREE3.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE3.config).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_BROWN_TREE4 = createConfiguredFeature("brown_birch_tree4", BYGFeatures.BIRCH_TREE4.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE4.config).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).build()));


    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_ORANGE_TREE1 = createConfiguredFeature("orange_birch_tree1", BYGFeatures.BIRCH_TREE1.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE1.config).setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_ORANGE_TREE2 = createConfiguredFeature("orange_birch_tree2", BYGFeatures.BIRCH_TREE2.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE2.config).setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_ORANGE_TREE3 = createConfiguredFeature("orange_birch_tree3", BYGFeatures.BIRCH_TREE3.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE3.config).setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_ORANGE_TREE4 = createConfiguredFeature("orange_birch_tree4", BYGFeatures.BIRCH_TREE4.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE4.config).setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_RED_TREE1 = createConfiguredFeature("red_birch_tree1", BYGFeatures.BIRCH_TREE1.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE1.config).setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_RED_TREE2 = createConfiguredFeature("red_birch_tree2", BYGFeatures.BIRCH_TREE2.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE2.config).setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_RED_TREE3 = createConfiguredFeature("red_birch_tree3", BYGFeatures.BIRCH_TREE3.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE3.config).setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_RED_TREE4 = createConfiguredFeature("red_birch_tree4", BYGFeatures.BIRCH_TREE4.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE4.config).setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_YELLOW_TREE1 = createConfiguredFeature("yellow_birch_tree1", BYGFeatures.BIRCH_TREE1.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE1.config).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_YELLOW_TREE2 = createConfiguredFeature("yellow_birch_tree2", BYGFeatures.BIRCH_TREE2.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE2.config).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_YELLOW_TREE3 = createConfiguredFeature("yellow_birch_tree3", BYGFeatures.BIRCH_TREE3.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE3.config).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_YELLOW_TREE4 = createConfiguredFeature("yellow_birch_tree4", BYGFeatures.BIRCH_TREE4.configured(new BYGTreeConfig.Builder().copy(BIRCH_TREE4.config).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> BLUFF_TREE1 = createConfiguredFeature("bluff_tree1", BYGFeatures.BLUFF_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(21).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BLUFF_TREE2 = createConfiguredFeature("bluff_tree2", BYGFeatures.BLUFF_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BLUFF_TREE3 = createConfiguredFeature("bluff_tree3", BYGFeatures.BLUFF_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_BOREAL_TREE1 = createConfiguredFeature("birch_boreal_tree1", BYGFeatures.BOREAL_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_YELLOW_BOREAL_TREE1 = createConfiguredFeature("birch_yellow_boreal_tree1", BYGFeatures.BOREAL_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(Blocks.BIRCH_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BOREAL_TREE2 = createConfiguredFeature("boreal_tree2", BYGFeatures.BOREAL_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(15).setMinHeight(11).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> CHERRY_PINK_TREE1 = createConfiguredFeature("pink_cherry_tree1", BYGFeatures.CHERRY_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.PINK_CHERRY_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CHERRY_PINK_TREE2 = createConfiguredFeature("pink_cherry_tree2", BYGFeatures.CHERRY_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.PINK_CHERRY_LEAVES).setMaxHeight(13).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CHERRY_WHITE_TREE1 = createConfiguredFeature("white_cherry_tree1", BYGFeatures.CHERRY_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.WHITE_CHERRY_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CHERRY_WHITE_TREE2 = createConfiguredFeature("white_cherry_tree2", BYGFeatures.CHERRY_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.WHITE_CHERRY_LEAVES).setMaxHeight(13).setMinHeight(8).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> CIKA_TREE1 = createConfiguredFeature("cika_tree1", BYGFeatures.CIKA_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CIKA_LOG).setLeavesBlock(BYGBlocks.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CIKA_TREE2 = createConfiguredFeature("cika_tree2", BYGFeatures.CIKA_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CIKA_LOG).setLeavesBlock(BYGBlocks.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CIKA_TREE3 = createConfiguredFeature("cika_tree3", BYGFeatures.CIKA_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CIKA_LOG).setLeavesBlock(BYGBlocks.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE1 = createConfiguredFeature("conifer_tree1", BYGFeatures.CONIFER_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(25).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE2 = createConfiguredFeature("conifer_tree2", BYGFeatures.CONIFER_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(30).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE3 = createConfiguredFeature("conifer_tree3", BYGFeatures.CONIFER_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(35).setMinHeight(26).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE4 = createConfiguredFeature("conifer_tree4", BYGFeatures.CONIFER_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(35).setMinHeight(25).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE5 = createConfiguredFeature("conifer_tree5", BYGFeatures.CONIFER_TREE5.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE6 = createConfiguredFeature("conifer_tree6", BYGFeatures.CONIFER_TREE6.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(17).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE7 = createConfiguredFeature("conifer_tree7", BYGFeatures.CONIFER_TREE7.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(28).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE8 = createConfiguredFeature("conifer_tree8", BYGFeatures.CONIFER_TREE8.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(28).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> CYPRESS_TREE1 = createConfiguredFeature("cypress_tree1", BYGFeatures.CYPRESS_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CYPRESS_LOG).setLeavesBlock(BYGBlocks.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CYPRESS_TREE2 = createConfiguredFeature("cypress_tree2", BYGFeatures.CYPRESS_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CYPRESS_LOG).setLeavesBlock(BYGBlocks.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CYPRESS_TREE3 = createConfiguredFeature("cypress_tree3", BYGFeatures.CYPRESS_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CYPRESS_LOG).setLeavesBlock(BYGBlocks.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> HAZEL_TREE1 = createConfiguredFeature("hazel_tree1", BYGFeatures.HAZEL_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1).add(BYGBlocks.WITCH_HAZEL_LEAVES.defaultBlockState(), 4).build())).setMaxHeight(15).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> HAZEL_TREE2 = createConfiguredFeature("hazel_tree2", BYGFeatures.HAZEL_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1).add(BYGBlocks.WITCH_HAZEL_LEAVES.defaultBlockState(), 4).build())).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DEAD_HAZEL_TREE1 = createConfiguredFeature("dead_hazel_tree1", BYGFeatures.DEAD_HAZEL_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1).add(BYGBlocks.WITCH_HAZEL_LEAVES.defaultBlockState(), 4).build())).setMaxHeight(16).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DEAD_HAZEL_TREE2 = createConfiguredFeature("dead_hazel_tree2", BYGFeatures.DEAD_HAZEL_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1).add(BYGBlocks.WITCH_HAZEL_LEAVES.defaultBlockState(), 4).build())).setMaxHeight(7).setMinHeight(5).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> FIRECRACKER_SHRUB = createConfiguredFeature("firecracker_shrub", BYGFeatures.SHRUB1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.FIRECRACKER_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> FIRECRACKER_SHRUB2 = createConfiguredFeature("firecracker_shrub2", BYGFeatures.SHRUB2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.FIRECRACKER_LEAVES).setMinHeight(2).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_TREE1 = createConfiguredFeature("deciduous_tree1", BYGFeatures.DECIDUOUS_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(19).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_TREE2 = createConfiguredFeature("deciduous_tree2", BYGFeatures.DECIDUOUS_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(22).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_TREE3 = createConfiguredFeature("deciduous_tree3", BYGFeatures.DECIDUOUS_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(21).setMinHeight(16).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_TREE4 = createConfiguredFeature("deciduous_tree4", BYGFeatures.DECIDUOUS_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_RED_TREE1 = createConfiguredFeature("deciduous_red_tree1", BYGFeatures.DECIDUOUS_TREE1.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_RED_TREE2 = createConfiguredFeature("deciduous_red_tree2", BYGFeatures.DECIDUOUS_TREE2.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_RED_TREE3 = createConfiguredFeature("deciduous_red_tree3", BYGFeatures.DECIDUOUS_TREE3.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_RED_TREE4 = createConfiguredFeature("deciduous_red_tree4", BYGFeatures.DECIDUOUS_TREE4.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_ORANGE_TREE1 = createConfiguredFeature("deciduous_orange_tree1", BYGFeatures.DECIDUOUS_TREE1.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_ORANGE_TREE2 = createConfiguredFeature("deciduous_orange_tree2", BYGFeatures.DECIDUOUS_TREE2.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_ORANGE_TREE3 = createConfiguredFeature("deciduous_orange_tree3", BYGFeatures.DECIDUOUS_TREE3.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_ORANGE_TREE4 = createConfiguredFeature("deciduous_orange_tree4", BYGFeatures.DECIDUOUS_TREE4.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_BROWN_TREE1 = createConfiguredFeature("deciduous_brown_tree1", BYGFeatures.DECIDUOUS_TREE1.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_BROWN_TREE2 = createConfiguredFeature("deciduous_brown_tree2", BYGFeatures.DECIDUOUS_TREE2.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_BROWN_TREE3 = createConfiguredFeature("deciduous_brown_tree3", BYGFeatures.DECIDUOUS_TREE3.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_BROWN_TREE4 = createConfiguredFeature("deciduous_brown_tree4", BYGFeatures.DECIDUOUS_TREE4.configured(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> EBONY_BUSH1 = createConfiguredFeature("ebony_bush1", BYGFeatures.EBONY_BUSH1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(28).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> EBONY_TREE1 = createConfiguredFeature("ebony_tree1", BYGFeatures.EBONY_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(13).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> EBONY_TREE2 = createConfiguredFeature("ebony_tree2", BYGFeatures.EBONY_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(17).setMinHeight(11).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_BLUE_TREE1 = createConfiguredFeature("blue_enchanted_tree1", BYGFeatures.ENCHANTED_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_BLUE_TREE2 = createConfiguredFeature("blue_enchanted_tree2", BYGFeatures.ENCHANTED_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(26).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_BLUE_TREE3 = createConfiguredFeature("blue_enchanted_tree3", BYGFeatures.ENCHANTED_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_GREEN_TREE1 = createConfiguredFeature("green_enchanted_tree1", BYGFeatures.ENCHANTED_TREE1.configured(new BYGTreeConfig.Builder().copy(ENCHANTED_BLUE_TREE1.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_GREEN_TREE2 = createConfiguredFeature("green_enchanted_tree2", BYGFeatures.ENCHANTED_TREE2.configured(new BYGTreeConfig.Builder().copy(ENCHANTED_BLUE_TREE2.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_GREEN_TREE3 = createConfiguredFeature("green_enchanted_tree3", BYGFeatures.ENCHANTED_TREE3.configured(new BYGTreeConfig.Builder().copy(ENCHANTED_BLUE_TREE3.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_BLUE_GROVE_TREE1 = createConfiguredFeature("blue_enchanted_grove_tree1", BYGFeatures.ENCHANTED_GROVE_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_GREEN_GROVE_TREE1 = createConfiguredFeature("green_enchanted_grove_tree1", BYGFeatures.ENCHANTED_GROVE_TREE1.configured(new BYGTreeConfig.Builder().copy(ENCHANTED_BLUE_TREE1.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> HOLLY_TREE1 = createConfiguredFeature("holly_tree1", BYGFeatures.HOLLY_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.HOLLY_BERRY_LEAVES.defaultBlockState(), 1).add(BYGBlocks.HOLLY_LEAVES.defaultBlockState(), 10))).setMaxHeight(23).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> HOLLY_TREE2 = createConfiguredFeature("holly_tree2", BYGFeatures.HOLLY_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.HOLLY_BERRY_LEAVES.defaultBlockState(), 1).add(BYGBlocks.HOLLY_LEAVES.defaultBlockState(), 10))).setMaxHeight(15).setMinHeight(10).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> HOLLY_TREE3 = createConfiguredFeature("holly_tree3", BYGFeatures.HOLLY_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.HOLLY_BERRY_LEAVES.defaultBlockState(), 1).add(BYGBlocks.HOLLY_LEAVES.defaultBlockState(), 10))).setMaxHeight(25).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> HOLLY_TREE4 = createConfiguredFeature("holly_tree4", BYGFeatures.HOLLY_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.HOLLY_BERRY_LEAVES.defaultBlockState(), 1).add(BYGBlocks.HOLLY_LEAVES.defaultBlockState(), 10))).setMaxHeight(14).setMinHeight(9).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> JACARANDA_TREE1 = createConfiguredFeature("jacaranda_tree1", BYGFeatures.JACARANDA_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.JACARANDA_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_JACARANDA_LEAVES.defaultBlockState(), 10).add(BYGBlocks.JACARANDA_LEAVES.defaultBlockState(), 40))).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> JACARANDA_TREE2 = createConfiguredFeature("jacaranda_tree2", BYGFeatures.JACARANDA_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.JACARANDA_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_JACARANDA_LEAVES.defaultBlockState(), 10).add(BYGBlocks.JACARANDA_LEAVES.defaultBlockState(), 40))).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> INDIGO_JACARANDA_TREE1 = createConfiguredFeature("indigo_jacaranda_tree1", BYGFeatures.JACARANDA_TREE1.configured(new BYGTreeConfig.Builder().copy(JACARANDA_TREE1.config).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_INDIGO_JACARANDA_LEAVES.defaultBlockState(), 10).add(BYGBlocks.INDIGO_JACARANDA_LEAVES.defaultBlockState(), 40))).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> INDIGO_JACARANDA_TREE2 = createConfiguredFeature("indigo_jacaranda_tree2", BYGFeatures.JACARANDA_TREE2.configured(new BYGTreeConfig.Builder().copy(JACARANDA_TREE2.config).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_INDIGO_JACARANDA_LEAVES.defaultBlockState(), 10).add(BYGBlocks.INDIGO_JACARANDA_LEAVES.defaultBlockState(), 40))).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> JOSHUA_TREE1 = createConfiguredFeature("joshua_tree1", BYGFeatures.JOSHUA_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.RIPE_JOSHUA_LEAVES.defaultBlockState(), 1).add(BYGBlocks.JOSHUA_LEAVES.defaultBlockState(), 10))).setMaxHeight(6).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> JOSHUA_TREE2 = createConfiguredFeature("joshua_tree2", BYGFeatures.JOSHUA_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.RIPE_JOSHUA_LEAVES.defaultBlockState(), 1).add(BYGBlocks.JOSHUA_LEAVES.defaultBlockState(), 10))).setMaxHeight(6).setMinHeight(3).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> MANGROVE_TREE1 = createConfiguredFeature("mangrove_tree1", BYGFeatures.MANGROVE_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(15).setMinHeight(10).setWhitelist(ImmutableList.of(BYGBlocks.MOSSY_STONE)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MANGROVE_TREE2 = createConfiguredFeature("mangrove_tree2", BYGFeatures.MANGROVE_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(17).setMinHeight(11).setWhitelist(ImmutableList.of(BYGBlocks.MOSSY_STONE)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MANGROVE_TREE3 = createConfiguredFeature("mangrove_tree3", BYGFeatures.MANGROVE_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(16).setMinHeight(12).setWhitelist(ImmutableList.of(BYGBlocks.MOSSY_STONE)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MANGROVE_TREE4 = createConfiguredFeature("mangrove_tree4", BYGFeatures.MANGROVE_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(15).setMinHeight(10).setWhitelist(ImmutableList.of(BYGBlocks.MOSSY_STONE)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MANGROVE_TREE5 = createConfiguredFeature("mangrove_tree5", BYGFeatures.MANGROVE_TREE5.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(17).setMinHeight(11).setWhitelist(ImmutableList.of(BYGBlocks.MOSSY_STONE)).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> MAPLE_RED_TREE1 = createConfiguredFeature("red_maple_tree1", BYGFeatures.MAPLE_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.RED_MAPLE_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAPLE_RED_TREE2 = createConfiguredFeature("red_maple_tree2", BYGFeatures.MAPLE_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.RED_MAPLE_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAPLE_SILVER_TREE1 = createConfiguredFeature("silver_maple_tree1", BYGFeatures.MAPLE_TREE2.configured(new BYGTreeConfig.Builder().copy(MAPLE_RED_TREE1.config).setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAPLE_SILVER_TREE2 = createConfiguredFeature("silver_maple_tree2", BYGFeatures.MAPLE_TREE3.configured(new BYGTreeConfig.Builder().copy(MAPLE_RED_TREE2.config).setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAPLE_TREE1 = createConfiguredFeature("maple_tree1", BYGFeatures.MAPLE_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.MAPLE_LEAVES).setMaxHeight(10).setMinHeight(5).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> MEADOW_TREE1 = createConfiguredFeature("meadow_tree1", BYGFeatures.MEADOW_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MEADOW_TREE2 = createConfiguredFeature("meadow_tree2", BYGFeatures.MEADOW_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MEADOW_TREE3 = createConfiguredFeature("meadow_tree3", BYGFeatures.MEADOW_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));

    //Oak
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE1 = createConfiguredFeature("oak_tree1", BYGFeatures.OAK_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE2 = createConfiguredFeature("oak_tree2", BYGFeatures.OAK_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE3 = createConfiguredFeature("oak_tree3", BYGFeatures.OAK_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE_LARGE1 = createConfiguredFeature("large_oak_tree1", BYGFeatures.OAK_TREE_LARGE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE_LARGE2 = createConfiguredFeature("large_oak_tree2", BYGFeatures.OAK_TREE_LARGE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE_LARGE3 = createConfiguredFeature("large_oak_tree3", BYGFeatures.OAK_TREE_LARGE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).setDiskBlock(Blocks.PODZOL).setDiskRadius(3).build()));

    //    //Red Oak
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE1 = createConfiguredFeature("red_oak_tree1", BYGFeatures.OAK_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE2 = createConfiguredFeature("red_oak_tree2", BYGFeatures.OAK_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE3 = createConfiguredFeature("red_oak_tree3", BYGFeatures.OAK_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE_LARGE1 = createConfiguredFeature("large_red_oak_tree1", BYGFeatures.OAK_TREE_LARGE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE_LARGE2 = createConfiguredFeature("large_red_oak_tree2", BYGFeatures.OAK_TREE_LARGE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE_LARGE3 = createConfiguredFeature("large_red_oak_tree3", BYGFeatures.OAK_TREE_LARGE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));

    //Brown Oak
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE1 = createConfiguredFeature("brown_oak_tree1", BYGFeatures.OAK_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE2 = createConfiguredFeature("brown_oak_tree2", BYGFeatures.OAK_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE3 = createConfiguredFeature("brown_oak_tree3", BYGFeatures.OAK_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE_LARGE1 = createConfiguredFeature("large_brown_oak_tree1", BYGFeatures.OAK_TREE_LARGE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE_LARGE2 = createConfiguredFeature("large_brown_oak_tree2", BYGFeatures.OAK_TREE_LARGE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE_LARGE3 = createConfiguredFeature("large_brown_oak_tree3", BYGFeatures.OAK_TREE_LARGE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));

    //Orange Oak
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE1 = createConfiguredFeature("orange_oak_tree1", BYGFeatures.OAK_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE2 = createConfiguredFeature("orange_oak_tree2", BYGFeatures.OAK_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE3 = createConfiguredFeature("orange_oak_tree3", BYGFeatures.OAK_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE_LARGE1 = createConfiguredFeature("large_orange_oak_tree1", BYGFeatures.OAK_TREE_LARGE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE_LARGE2 = createConfiguredFeature("large_orange_oak_tree2", BYGFeatures.OAK_TREE_LARGE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE_LARGE3 = createConfiguredFeature("large_orange_oak_tree3", BYGFeatures.OAK_TREE_LARGE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));

    //Orchard
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORCHARD_TREE1 = createConfiguredFeature("orchard_tree1", BYGFeatures.ORCHARD_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ORCHARD_LEAVES.defaultBlockState(), 10).add(BYGBlocks.FLOWERING_ORCHARD_LEAVES.defaultBlockState(), 1).add(BYGBlocks.RIPE_ORCHARD_LEAVES.defaultBlockState(), 1))).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORCHARD_TREE2 = createConfiguredFeature("orchard_tree2", BYGFeatures.ORCHARD_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ORCHARD_LEAVES.defaultBlockState(), 10).add(BYGBlocks.FLOWERING_ORCHARD_LEAVES.defaultBlockState(), 1).add(BYGBlocks.RIPE_ORCHARD_LEAVES.defaultBlockState(), 1))).setMaxHeight(26).setMinHeight(21).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORCHARD_TREE3 = createConfiguredFeature("orchard_tree3", BYGFeatures.ORCHARD_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ORCHARD_LEAVES.defaultBlockState(), 10).add(BYGBlocks.FLOWERING_ORCHARD_LEAVES.defaultBlockState(), 1).add(BYGBlocks.RIPE_ORCHARD_LEAVES.defaultBlockState(), 1))).setMaxHeight(12).setMinHeight(9).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> PALM_TREE1 = createConfiguredFeature("palm_tree1", BYGFeatures.PALM_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PALM_TREE2 = createConfiguredFeature("palm_tree2", BYGFeatures.PALM_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PALM_TREE3 = createConfiguredFeature("palm_tree3", BYGFeatures.PALM_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PALM_TREE4 = createConfiguredFeature("palm_tree4", BYGFeatures.PALM_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> PINE_LARGE_TREE1 = createConfiguredFeature("large_pine_tree1", BYGFeatures.PINE_LARGE_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(28).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PINE_LARGE_TREE2 = createConfiguredFeature("large_pine_tree2", BYGFeatures.PINE_LARGE_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(31).setMinHeight(26).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PINE_TREE1 = createConfiguredFeature("pine_tree1", BYGFeatures.PINE_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(20).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PINE_TREE2 = createConfiguredFeature("pine_tree2", BYGFeatures.PINE_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> PALO_VERDE_TREE1 = createConfiguredFeature("palo_verde_tree1", BYGFeatures.PALO_VERDE_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALO_VERDE_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.PALO_VERDE_LEAVES.defaultBlockState(), 6).add(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES.defaultBlockState(), 1))).setMaxHeight(1).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PALO_VERDE_TREE2 = createConfiguredFeature("palo_verde_tree2", BYGFeatures.PALO_VERDE_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALO_VERDE_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.PALO_VERDE_LEAVES.defaultBlockState(), 6).add(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES.defaultBlockState(), 1))).setMaxHeight(2).setMinHeight(1).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> RAINBOW_TREE1 = createConfiguredFeature("rainbow_eucalyptus_tree1", BYGFeatures.RAINBOW_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LOG).setLeavesBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES).setMaxHeight(32).setMinHeight(27).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RAINBOW_LARGE_TREE1 = createConfiguredFeature("large_rainbow_eucalyptus_tree1", BYGFeatures.RAINBOW_LARGE_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LOG).setLeavesBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES).setMaxHeight(19).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> REDWOOD_TREE1 = createConfiguredFeature("redwood_tree1", BYGFeatures.REDWOOD_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.REDWOOD_LOG).setLeavesBlock(BYGBlocks.REDWOOD_LEAVES).setMaxHeight(37).setMinHeight(36).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> REDWOOD_TREE2 = createConfiguredFeature("redwood_tree2", BYGFeatures.REDWOOD_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.REDWOOD_LOG).setLeavesBlock(BYGBlocks.REDWOOD_LEAVES).setMaxHeight(34).setMinHeight(31).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> REDWOOD_TREE3 = createConfiguredFeature("redwood_tree3", BYGFeatures.REDWOOD_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.REDWOOD_LOG).setLeavesBlock(BYGBlocks.REDWOOD_LEAVES).setMaxHeight(25).setMinHeight(18).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SHRUB_MEADOW = createConfiguredFeature("meadow_shrub1", BYGFeatures.SHRUB1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SHRUB_MEADOW2 = createConfiguredFeature("meadow_shrub2", BYGFeatures.SHRUB2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SHRUB_PRAIRIE1 = createConfiguredFeature("prairie_shrub1", BYGFeatures.SHRUB1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(1).setMaxHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SHRUB_PRAIRIE2 = createConfiguredFeature("prairie_shrub2", BYGFeatures.SHRUB2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(1).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SKYRIS_TREE1 = createConfiguredFeature("skyris_tree1", BYGFeatures.SKYRIS_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).add(BYGBlocks.SKYRIS_LEAVES.defaultBlockState(), 8))).setMaxHeight(9).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SKYRIS_TREE2 = createConfiguredFeature("skyris_tree2", BYGFeatures.SKYRIS_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).add(BYGBlocks.SKYRIS_LEAVES.defaultBlockState(), 8))).setMaxHeight(6).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SKYRIS_TREE3 = createConfiguredFeature("skyris_tree3", BYGFeatures.SKYRIS_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).add(BYGBlocks.SKYRIS_LEAVES.defaultBlockState(), 8))).setMaxHeight(8).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SKYRIS_TREE4 = createConfiguredFeature("skyris_tree4", BYGFeatures.SKYRIS_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).add(BYGBlocks.SKYRIS_LEAVES.defaultBlockState(), 8))).setMaxHeight(8).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SKYRIS_TREE5 = createConfiguredFeature("skyris_tree5", BYGFeatures.SKYRIS_TREE5.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).add(BYGBlocks.SKYRIS_LEAVES.defaultBlockState(), 8))).setMaxHeight(8).setMinHeight(6).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE1 = createConfiguredFeature("spruce_tree1", BYGFeatures.SPRUCE_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE2 = createConfiguredFeature("spruce_tree2", BYGFeatures.SPRUCE_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE3 = createConfiguredFeature("spruce_tree3", BYGFeatures.SPRUCE_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(16).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE4 = createConfiguredFeature("spruce_tree4", BYGFeatures.SPRUCE_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(12).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE_MEDIUM1 = createConfiguredFeature("spruce_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(24).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE_MEDIUM2 = createConfiguredFeature("spruce_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(25).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE_MEDIUM3 = createConfiguredFeature("spruce_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(26).setMinHeight(21).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE_MEDIUM4 = createConfiguredFeature("spruce_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(25).setMinHeight(19).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE_LARGE1 = createConfiguredFeature("spruce_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(55).setMinHeight(40).build()));

    //Yellow Spruce
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE1 = createConfiguredFeature("spruce_yellow_tree1", BYGFeatures.SPRUCE_TREE1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE2 = createConfiguredFeature("spruce_yellow_tree2", BYGFeatures.SPRUCE_TREE2.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE3 = createConfiguredFeature("spruce_yellow_tree3", BYGFeatures.SPRUCE_TREE3.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE4 = createConfiguredFeature("spruce_yellow_tree4", BYGFeatures.SPRUCE_TREE4.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM1 = createConfiguredFeature("spruce_yellow_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM2 = createConfiguredFeature("spruce_yellow_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM3 = createConfiguredFeature("spruce_yellow_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM4 = createConfiguredFeature("spruce_yellow_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE_LARGE1 = createConfiguredFeature("spruce_yellow_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));

    //Orange Spruce
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE1 = createConfiguredFeature("spruce_orange_tree1", BYGFeatures.SPRUCE_TREE1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE2 = createConfiguredFeature("spruce_orange_tree2", BYGFeatures.SPRUCE_TREE2.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE3 = createConfiguredFeature("spruce_orange_tree3", BYGFeatures.SPRUCE_TREE3.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE4 = createConfiguredFeature("spruce_orange_tree4", BYGFeatures.SPRUCE_TREE4.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM1 = createConfiguredFeature("spruce_orange_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM2 = createConfiguredFeature("spruce_orange_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM3 = createConfiguredFeature("spruce_orange_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM4 = createConfiguredFeature("spruce_orange_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE_LARGE1 = createConfiguredFeature("spruce_orange_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));

    //Red Spruce
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE1 = createConfiguredFeature("spruce_red_tree1", BYGFeatures.SPRUCE_TREE1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE2 = createConfiguredFeature("spruce_red_tree2", BYGFeatures.SPRUCE_TREE2.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE3 = createConfiguredFeature("spruce_red_tree3", BYGFeatures.SPRUCE_TREE3.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE4 = createConfiguredFeature("spruce_red_tree4", BYGFeatures.SPRUCE_TREE4.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE_MEDIUM1 = createConfiguredFeature("spruce_red_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE_MEDIUM2 = createConfiguredFeature("spruce_red_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE_MEDIUM3 = createConfiguredFeature("spruce_red_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE_MEDIUM4 = createConfiguredFeature("spruce_red_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE_LARGE1 = createConfiguredFeature("spruce_red_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));

    //Blue Spruce
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE1 = createConfiguredFeature("spruce_blue_tree1", BYGFeatures.SPRUCE_TREE1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE2 = createConfiguredFeature("spruce_blue_tree2", BYGFeatures.SPRUCE_TREE2.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE3 = createConfiguredFeature("spruce_blue_tree3", BYGFeatures.SPRUCE_TREE3.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE4 = createConfiguredFeature("spruce_blue_tree4", BYGFeatures.SPRUCE_TREE4.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE_MEDIUM1 = createConfiguredFeature("spruce_blue_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE_MEDIUM2 = createConfiguredFeature("spruce_blue_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE_MEDIUM3 = createConfiguredFeature("spruce_blue_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE_MEDIUM4 = createConfiguredFeature("spruce_blue_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE_LARGE1 = createConfiguredFeature("spruce_blue_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.configured(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> TROPICAL_SHRUB1 = createConfiguredFeature("tropical_shrub1", BYGFeatures.SHRUB1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMinHeight(2).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> MAHOGANY_TREE1 = createConfiguredFeature("mahogany_tree1", BYGFeatures.MAHOGANY_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAHOGANY_TREE2 = createConfiguredFeature("mahogany_tree2", BYGFeatures.MAHOGANY_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(14).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAHOGANY_TREE3 = createConfiguredFeature("mahogany_tree3", BYGFeatures.MAHOGANY_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAHOGANY_TREE4 = createConfiguredFeature("mahogany_tree4", BYGFeatures.MAHOGANY_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(24).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAHOGANY_TREE5 = createConfiguredFeature("mahogany_tree5", BYGFeatures.MAHOGANY_TREE5.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(31).setMinHeight(25).build()));


    public static final ConfiguredFeature<BYGTreeConfig, ?> WOODLANDS_TREE1 = createConfiguredFeature("woodlands_tree1", BYGFeatures.WOODLANDS_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(5).setMinHeight(25).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_DEAD_TREE1 = createConfiguredFeature("dead_willow_tree1", BYGFeatures.WILLOW_DEAD_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_TREE1 = createConfiguredFeature("willow_tree1", BYGFeatures.WILLOW_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(14).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_TREE2 = createConfiguredFeature("willow_tree2", BYGFeatures.WILLOW_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_TREE3 = createConfiguredFeature("willow_tree3", BYGFeatures.WILLOW_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_TREE4 = createConfiguredFeature("willow_tree4", BYGFeatures.WILLOW_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(21).setMinHeight(13).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_TREE1 = createConfiguredFeature("zelkova_tree1", BYGFeatures.ZELKOVA_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES).setMaxHeight(20).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_TREE2 = createConfiguredFeature("zelkova_tree2", BYGFeatures.ZELKOVA_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES).setMaxHeight(28).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_TREE3 = createConfiguredFeature("zelkova_tree3", BYGFeatures.ZELKOVA_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_BROWN_TREE1 = createConfiguredFeature("zelkova_brown_tree1", BYGFeatures.ZELKOVA_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES).setMaxHeight(21).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_BROWN_TREE2 = createConfiguredFeature("zelkova_brown_tree2", BYGFeatures.ZELKOVA_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES).setMaxHeight(20).setMinHeight(10).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_BROWN_TREE3 = createConfiguredFeature("zelkova_brown_tree3", BYGFeatures.ZELKOVA_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    //Mushrooms
    public static final ConfiguredFeature<BYGMushroomConfig, ?> GREEN_MUSHROOM_HUGE = createConfiguredFeature("huge_green_mushroom", BYGFeatures.GREEN_MUSHROOM_HUGE.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WOOD_BLEWIT_HUGE = createConfiguredFeature("huge_wood_blewit", BYGFeatures.WOOD_BLEWIT_HUGE.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WEEPING_MILKCAP_HUGE = createConfiguredFeature("huge_weeping_milkcap", BYGFeatures.WEEPING_MILKCAP_HUGE.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    //Mini Mushrooms
    public static final ConfiguredFeature<?, ?> GREEN_MUSHROOM_MINI = createConfiguredFeature("mini_green_mushroom", BYGFeatures.MINI_GREEN_MUSHROOM.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK).setMinHeight(3).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> WOOD_BLEWIT_MINI = createConfiguredFeature("mini_wood_blewit", BYGFeatures.MINI_WOOD_BLEWIT.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> WEEPING_MILKCAP_MINI = createConfiguredFeature("mini_weeping_milkcap", BYGFeatures.MINI_WEEPING_MILKCAP.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> RED_MUSHROOM_MINI = createConfiguredFeature("mini_red_mushroom", BYGFeatures.MINI_RED_MUSHROOM.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(Blocks.RED_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> BROWN_MUSHROOM_MINI = createConfiguredFeature("mini_brown_mushroom", BYGFeatures.MINI_BROWN_MUSHROOM.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(Blocks.BROWN_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));


    //Nether Mushrooms
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM = createConfiguredFeature("embur_mushroom1", BYGFeatures.EMBUR_MUSHROOM.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM2 = createConfiguredFeature("embur_mushroom2", BYGFeatures.EMBUR_MUSHROOM2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM3 = createConfiguredFeature("embur_mushroom3", BYGFeatures.EMBUR_MUSHROOM3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM4 = createConfiguredFeature("embur_mushroom4", BYGFeatures.EMBUR_MUSHROOM4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> CRIMSON_FUNGUS1 = createConfiguredFeature("crimson_fungus1", BYGFeatures.CRIMSON_FUNGUS_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.CRIMSON_STEM).setMushroomBlock(Blocks.NETHER_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> CRIMSON_FUNGUS2 = createConfiguredFeature("crimson_fungus2", BYGFeatures.CRIMSON_FUNGUS_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.CRIMSON_STEM).setMushroomBlock(Blocks.NETHER_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> WARPED_FUNGUS1 = createConfiguredFeature("warped_fungus1", BYGFeatures.WARPED_FUNGUS_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.WARPED_STEM).setMushroomBlock(Blocks.WARPED_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WARPED_FUNGUS2 = createConfiguredFeature("warped_fungus2", BYGFeatures.WARPED_FUNGUS_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.WARPED_STEM).setMushroomBlock(Blocks.WARPED_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE1 = createConfiguredFeature("sythian_fungus_tree1", BYGFeatures.SYTHIAN_FUNGUS_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE2 = createConfiguredFeature("sythian_fungus_tree2", BYGFeatures.SYTHIAN_FUNGUS_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE3 = createConfiguredFeature("sythian_fungus_tree3", BYGFeatures.SYTHIAN_FUNGUS_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE4 = createConfiguredFeature("sythian_fungus_tree4", BYGFeatures.SYTHIAN_FUNGUS_TREE4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE1 = createConfiguredFeature("soul_shroom_tree1", BYGFeatures.SOUL_SHROOM_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE2 = createConfiguredFeature("soul_shroom_tree2", BYGFeatures.SOUL_SHROOM_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE3 = createConfiguredFeature("soul_shroom_tree3", BYGFeatures.SOUL_SHROOM_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE1 = createConfiguredFeature("death_cap_tree1", BYGFeatures.DEATH_CAP_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE2 = createConfiguredFeature("death_cap_tree2", BYGFeatures.DEATH_CAP_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE3 = createConfiguredFeature("death_cap_tree3", BYGFeatures.DEATH_CAP_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    //Nether Trees
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE1 = createConfiguredFeature("lament_twisty_tree1", BYGFeatures.LAMENT_TWISTY_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE2 = createConfiguredFeature("lament_twisty_tree2", BYGFeatures.LAMENT_TWISTY_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE3 = createConfiguredFeature("lament_twisty_tree3", BYGFeatures.LAMENT_TWISTY_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE1 = createConfiguredFeature("lament_weeping_tree1", BYGFeatures.LAMENT_WEEPING_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).setWhitelist(ImmutableList.of(Blocks.LAVA)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE2 = createConfiguredFeature("lament_weeping_tree2", BYGFeatures.LAMENT_WEEPING_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).setWhitelist(ImmutableList.of(Blocks.LAVA)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE3 = createConfiguredFeature("lament_weeping_tree3", BYGFeatures.LAMENT_WEEPING_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).setWhitelist(ImmutableList.of(Blocks.LAVA)).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE1 = createConfiguredFeature("withering_oak_tree1", BYGFeatures.WITHERING_OAK_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WITHERING_OAK_LOG).setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE2 = createConfiguredFeature("withering_oak_tree2", BYGFeatures.WITHERING_OAK_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WITHERING_OAK_LOG).setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE3 = createConfiguredFeature("withering_oak_tree3", BYGFeatures.WITHERING_OAK_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WITHERING_OAK_LOG).setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE4 = createConfiguredFeature("withering_oak_tree4", BYGFeatures.WITHERING_OAK_TREE4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WITHERING_OAK_LOG).setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE5 = createConfiguredFeature("withering_oak_tree5", BYGFeatures.WITHERING_OAK_TREE5.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WITHERING_OAK_LOG).setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    //Nether Features
    public static final ConfiguredFeature<BYGTreeConfig, ?> WAILING_PILLAR1 = createConfiguredFeature("wailing_pillar1", BYGFeatures.WAILING_PILLAR1.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.BASALT.defaultBlockState(), 8).add(Blocks.POLISHED_BASALT.defaultBlockState(), 2))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 4).add(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3).add(Blocks.BLACKSTONE.defaultBlockState(), 2).add(BYGBlocks.DUSTED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3))).setMaxHeight(30).setMinHeight(22).build()));

    //End Mushrooms
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_BUSH1 = createConfiguredFeature("bulbis_bush1", BYGFeatures.BULBIS_BUSH1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE1 = createConfiguredFeature("bulbis_tree1", BYGFeatures.BULBIS_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE2 = createConfiguredFeature("bulbis_tree2", BYGFeatures.BULBIS_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE3 = createConfiguredFeature("bulbis_tree3", BYGFeatures.BULBIS_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE4 = createConfiguredFeature("bulbis_tree4", BYGFeatures.BULBIS_TREE4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE5 = createConfiguredFeature("bulbis_tree5", BYGFeatures.BULBIS_TREE5.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE6 = createConfiguredFeature("bulbis_tree6", BYGFeatures.BULBIS_TREE6.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE7 = createConfiguredFeature("bulbis_tree7", BYGFeatures.BULBIS_TREE7.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_BUSH1 = createConfiguredFeature("purple_bulbis_bush1", BYGFeatures.BULBIS_BUSH1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE1 = createConfiguredFeature("purple_bulbis_tree1", BYGFeatures.BULBIS_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE2 = createConfiguredFeature("purple_bulbis_tree2", BYGFeatures.BULBIS_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE3 = createConfiguredFeature("purple_bulbis_tree3", BYGFeatures.BULBIS_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE4 = createConfiguredFeature("purple_bulbis_tree4", BYGFeatures.BULBIS_TREE4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE5 = createConfiguredFeature("purple_bulbis_tree5", BYGFeatures.BULBIS_TREE5.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE6 = createConfiguredFeature("purple_bulbis_tree6", BYGFeatures.BULBIS_TREE6.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE7 = createConfiguredFeature("purple_bulbis_tree7", BYGFeatures.BULBIS_TREE7.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));

    //End Trees
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_BUSH1 = createConfiguredFeature("ether_bush1", BYGFeatures.ETHER_BUSH1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_BUSH2 = createConfiguredFeature("ether_bush2", BYGFeatures.ETHER_BUSH2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE1 = createConfiguredFeature("ether_tree1", BYGFeatures.ETHER_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE2 = createConfiguredFeature("ether_tree2", BYGFeatures.ETHER_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE3 = createConfiguredFeature("ether_tree3", BYGFeatures.ETHER_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE4 = createConfiguredFeature("ether_tree4", BYGFeatures.ETHER_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE5 = createConfiguredFeature("ether_tree5", BYGFeatures.ETHER_TREE5.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD1 = createConfiguredFeature("ether_tree_dead1", BYGFeatures.DEAD_ETHER_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_WOOD).setLeavesBlock(Blocks.AIR).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD2 = createConfiguredFeature("ether_tree_dead2", BYGFeatures.DEAD_ETHER_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_WOOD).setLeavesBlock(Blocks.AIR).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD3 = createConfiguredFeature("ether_tree_dead3", BYGFeatures.DEAD_ETHER_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_WOOD).setLeavesBlock(Blocks.AIR).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_BUSH1 = createConfiguredFeature("nightshade_bush1", BYGFeatures.NIGHTSHADE_BUSH1.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_BUSH2 = createConfiguredFeature("nightshade_bush2", BYGFeatures.NIGHTSHADE_BUSH2.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE1 = createConfiguredFeature("nightshade_tree1", BYGFeatures.NIGHTSHADE_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE2 = createConfiguredFeature("nightshade_tree2", BYGFeatures.NIGHTSHADE_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE3 = createConfiguredFeature("nightshade_tree3", BYGFeatures.NIGHTSHADE_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(33).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE4 = createConfiguredFeature("nightshade_tree4", BYGFeatures.NIGHTSHADE_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(44).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SHULKREN_TREE1 = createConfiguredFeature("shulkren_tree1", BYGFeatures.SHULKREN_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SHULKREN_TREE2 = createConfiguredFeature("shulkren_tree2", BYGFeatures.SHULKREN_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM1 = createConfiguredFeature("imparius_mushroom1", BYGFeatures.IMPARIUS_MUSHROOM1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM2 = createConfiguredFeature("imparius_mushroom2", BYGFeatures.IMPARIUS_MUSHROOM2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM3 = createConfiguredFeature("imparius_mushroom3", BYGFeatures.IMPARIUS_MUSHROOM3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM4 = createConfiguredFeature("imparius_mushroom4", BYGFeatures.IMPARIUS_MUSHROOM4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM5 = createConfiguredFeature("imparius_mushroom5", BYGFeatures.IMPARIUS_MUSHROOM5.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM6 = createConfiguredFeature("imparius_mushroom6", BYGFeatures.IMPARIUS_MUSHROOM6.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS1 = createConfiguredFeature("fungal_imparius1", BYGFeatures.FUNGAL_IMPARIUS1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM).setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS2 = createConfiguredFeature("fungal_imparius2", BYGFeatures.FUNGAL_IMPARIUS2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM).setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS3 = createConfiguredFeature("fungal_imparius3", BYGFeatures.FUNGAL_IMPARIUS3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM).setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS4 = createConfiguredFeature("fungal_imparius4", BYGFeatures.FUNGAL_IMPARIUS4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM).setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS5 = createConfiguredFeature("fungal_imparius5", BYGFeatures.FUNGAL_IMPARIUS5.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM).setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<DiskConfiguration, ?> DISK_MUD = createConfiguredFeature("disk_mud", Feature.DISK.configured(new DiskConfiguration(BYGBlocks.MUD_BLOCK.defaultBlockState(), UniformInt.of(2, 3), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.CLAY.defaultBlockState()))));


    //
//    /***********************************************************Configured Placement***********************************************************/
//
    public static final ConfiguredFeature<?, ?> FIRECRACKER_SHRUBS = createConfiguredFeature("firecracker_shrubs", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(FIRECRACKER_SHRUB.placed(), 0.20F)),
            FIRECRACKER_SHRUB2.placed())));
    //
//    /***********************************************************Random Selectors***********************************************************/
//
//    public static final ConfiguredFeature<?, ?> RANDOM_ANCIENT_TREE = createConfiguredFeature("ancient_forest_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            Features.DARK_OAK.weighted(0.3F),
//            ANCIENT_TREE1.weighted(0.20F),
//            ANCIENT_TREE2.weighted(0.20F)),
//            ANCIENT_TREE3)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(10, 0.2F, 5))));
//
    public static final ConfiguredFeature<?, ?> BAYOU_TREES = createConfiguredFeature("bayou_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(WILLOW_DEAD_TREE1.placed(), 0.1F),
            new WeightedPlacedFeature(WILLOW_TREE1.placed(), 0.25F),
            new WeightedPlacedFeature(WILLOW_TREE2.placed(), 0.25F),
            new WeightedPlacedFeature(WILLOW_TREE3.placed(), 0.25F)),
            WILLOW_TREE4.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_BAYOU_TREE = createConfiguredFeature("sparse_bayou_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            WILLOW_TREE1.weighted(0.25F),
//            WILLOW_TREE2.weighted(0.25F),
//            WILLOW_TREE3.weighted(0.25F)),
//            WILLOW_TREE4)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.15F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_CORAL_MANGROVE = createConfiguredFeature("mg_coral", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            Feature.CORAL_TREE.configured(FeatureConfiguration.NONE).weighted(0.25F),
//            Feature.CORAL_MUSHROOM.configured(FeatureConfiguration.NONE).weighted(0.25F)),
//            Feature.CORAL_CLAW.configured(FeatureConfiguration.NONE))).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(20, 0.3F, 2))));
//
    public static final ConfiguredFeature<?, ?> CANADIAN_SHIELD_TREES = createConfiguredFeature("canadian_shield_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(PINE_TREE1.placed(), 0.05F),
            new WeightedPlacedFeature(PINE_TREE2.placed(), 0.05F),
            new WeightedPlacedFeature(BLUFF_TREE1.placed(), 0.3F),
            new WeightedPlacedFeature(BLUFF_TREE2.placed(), 0.3F),
            new WeightedPlacedFeature(BLUFF_TREE3.placed(), 0.25F)),
            CONIFER_TREE6.placed())));
    //
    public static final ConfiguredFeature<?, ?> BOREAL_TREES = createConfiguredFeature("boreal_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BIRCH_YELLOW_BOREAL_TREE1.placed(), 0.3F),
            new WeightedPlacedFeature(BIRCH_BOREAL_TREE1.placed(), 0.3F)),
            BOREAL_TREE2.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_SPARSE_TREE = createConfiguredFeature("sparse_boreal_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            BIRCH_YELLOW_BOREAL_TREE1.weighted(0.3F),
//            BIRCH_BOREAL_TREE1.weighted(0.3F)),
//            BOREAL_TREE2)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.1F, 2))));
//
    public static final ConfiguredFeature<?, ?> BLACK_FOREST_TREES = createConfiguredFeature("black_forest_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ASPEN_TREE3.placed(), 0.05F),
            new WeightedPlacedFeature(ASPEN_TREE2.placed(), 0.05F),
            new WeightedPlacedFeature(CONIFER_TREE6.placed(), 0.05F),
            new WeightedPlacedFeature(CONIFER_TREE7.placed(), 0.05F),
            new WeightedPlacedFeature(PINE_LARGE_TREE1.placed(), 0.2F),
            new WeightedPlacedFeature(PINE_LARGE_TREE2.placed(), 0.2F),
            new WeightedPlacedFeature(PINE_TREE1.placed(), 0.2F)),
            PINE_TREE2.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_FOREST_SPARSE_TREE = createConfiguredFeature("sparse_black_forest_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            PINE_LARGE_TREE1.weighted(0.45F),
//            PINE_LARGE_TREE2.weighted(0.45F),
//            PINE_TREE1.weighted(0.4F)),
//            PINE_TREE2)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.15F, 2))));
//
    public static final ConfiguredFeature<?, ?> CIKA_TREES = createConfiguredFeature("cika_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(CIKA_TREE2.placed(), 0.2F),
            new WeightedPlacedFeature(CIKA_TREE3.placed(), 0.1F)),
            CIKA_TREE1.placed())));
    //
    public static final ConfiguredFeature<?, ?> CONIFER_TREES = createConfiguredFeature("conifer_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(CONIFER_TREE1.placed(), 0.06F),
            new WeightedPlacedFeature(CONIFER_TREE2.placed(), 0.5F),
            new WeightedPlacedFeature(CONIFER_TREE3.placed(), 0.04F),
            new WeightedPlacedFeature(CONIFER_TREE4.placed(), 0.2F),
            new WeightedPlacedFeature(CONIFER_TREE5.placed(), 0.2F),
            new WeightedPlacedFeature(CONIFER_TREE6.placed(), 0.2F),
            new WeightedPlacedFeature(CONIFER_TREE7.placed(), 0.1F)),
            CONIFER_TREE8.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_CONIFER_SPARSE_TREE = createConfiguredFeature("sparse_conifer_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            CONIFER_TREE1.weighted(0.06F),
//            CONIFER_TREE2.weighted(0.5F),
//            CONIFER_TREE3.weighted(0.04F),
//            CONIFER_TREE4.weighted(0.2F),
//            CONIFER_TREE5.weighted(0.2F),
//            CONIFER_TREE6.weighted(0.2F),
//            CONIFER_TREE7.weighted(0.1F)),
//            CONIFER_TREE8)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.2F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_CRAG_GARDEN_TREE = createConfiguredFeature("crag_garden_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            RAINBOW_TREE1.weighted(0.2F),
//            RAINBOW_TREE1.weighted(0.2F),
//            Features.BAMBOO.weighted(0.05F),
//            RAINBOW_LARGE_TREE1.weighted(0.1F)),
//            MAHOGANY_TREE2)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(10, 0.35F, 2))));
//
    public static final ConfiguredFeature<?, ?> CYPRESS_TREES = createConfiguredFeature("cypress_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(CYPRESS_TREE1.placed(), 0.33F),
            new WeightedPlacedFeature(CYPRESS_TREE2.placed(), 0.33F)),
            CYPRESS_TREE3.placed())));

    public static final ConfiguredFeature<?, ?> DECIDUOUS_TREES = createConfiguredFeature("deciduous_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(DECIDUOUS_TREE1.placed(), 0.25F),
            new WeightedPlacedFeature(DECIDUOUS_TREE2.placed(), 0.25F),
            new WeightedPlacedFeature(DECIDUOUS_TREE3.placed(), 0.25F)),
            DECIDUOUS_TREE4.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_RED_TREE = createConfiguredFeature("deciduous_red_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            DECIDUOUS_RED_TREE1.weighted(0.25F),
//            DECIDUOUS_RED_TREE2.weighted(0.25F),
//            DECIDUOUS_RED_TREE3.weighted(0.25F)),
//            DECIDUOUS_RED_TREE4)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.4F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_ORANGE_TREE = createConfiguredFeature("deciduous_orange_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            DECIDUOUS_ORANGE_TREE1.weighted(0.25F),
//            DECIDUOUS_ORANGE_TREE2.weighted(0.25F),
//            DECIDUOUS_ORANGE_TREE3.weighted(0.25F)),
//            DECIDUOUS_ORANGE_TREE4)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.4F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_BROWN_TREE = createConfiguredFeature("deciduous_brown_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            DECIDUOUS_BROWN_TREE1.weighted(0.25F),
//            DECIDUOUS_BROWN_TREE2.weighted(0.25F),
//            DECIDUOUS_BROWN_TREE3.weighted(0.25F)),
//            DECIDUOUS_BROWN_TREE4)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.4F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_SPARSE_TREE = createConfiguredFeature("sparse_deciduous_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            DECIDUOUS_TREE1.weighted(0.25F),
//            DECIDUOUS_TREE2.weighted(0.25F),
//            DECIDUOUS_TREE3.weighted(0.25F)),
//            DECIDUOUS_TREE4)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.4F, 2))));
//
    public static final ConfiguredFeature<?, ?> DACITE_RIDGE_TREES = createConfiguredFeature("dacite_ridge_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(SPRUCE_TREE_MEDIUM2.placed(), 0.25F),
            new WeightedPlacedFeature(SPRUCE_TREE_MEDIUM1.placed(), 0.25F)),
            SPRUCE_TREE_LARGE1.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_EUCALYPTUS_TREE = createConfiguredFeature("eucalyptus_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            RAINBOW_TREE1.weighted(0.1F)),
//            RAINBOW_LARGE_TREE1)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(8, 0.4F, 2))));
//
    public static final ConfiguredFeature<?, ?> JACARANDA_TREES = createConfiguredFeature("jacaranda_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(JACARANDA_TREE2.placed(), 0.3F),
            new WeightedPlacedFeature(INDIGO_JACARANDA_TREE2.placed(), 0.3F),
            new WeightedPlacedFeature(INDIGO_JACARANDA_TREE1.placed(), 0.3F)),
            JACARANDA_TREE1.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_SPARSE_TREE = createConfiguredFeature("sparse_jacaranda_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            INDIGO_JACARANDA_TREE1.weighted(0.3F)),
//            JACARANDA_TREE2)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.2F, 2))));
//
    public static final ConfiguredFeature<?, ?> MAPLE_TREES = createConfiguredFeature("maple_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(MAPLE_RED_TREE1.placed(), 0.2F),
            new WeightedPlacedFeature(MAPLE_RED_TREE2.placed(), 0.2F),
            new WeightedPlacedFeature(MAPLE_SILVER_TREE1.placed(), 0.2F),
            new WeightedPlacedFeature(MAPLE_SILVER_TREE2.placed(), 0.2F)),
            MAPLE_TREE1.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_MAPLE_SPARSE_TREE = createConfiguredFeature("sparse_maple_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            MAPLE_TREE1.weighted(0.06F),
//            MAPLE_RED_TREE1.weighted(0.5F),
//            MAPLE_TREE1.weighted(0.04F),
//            MAPLE_SILVER_TREE1.weighted(0.2F),
//            MAPLE_SILVER_TREE2.weighted(0.1F)),
//            MAPLE_RED_TREE1)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.4F, 2))));
//
    public static final ConfiguredFeature<?, ?> NORTHERN_FOREST_TREES = createConfiguredFeature("northern_forest_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(PINE_TREE1.placed(), 0.5F)),
            PINE_TREE2.placed())));

    //
    public static final ConfiguredFeature<?, ?> REDWOOD_TREES = createConfiguredFeature("redwood_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(REDWOOD_TREE1.placed(), 0.55F),
            new WeightedPlacedFeature(REDWOOD_TREE2.placed(), 0.1F)),
            REDWOOD_TREE3.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_REDWOOD_SPARSE_TREE = createConfiguredFeature("sparse_redwood_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            REDWOOD_TREE1.weighted(0.55F),
//            REDWOOD_TREE2.weighted(0.1F)),
//            REDWOOD_TREE3)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.2F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_TAIGA_MISC_TREE = createConfiguredFeature("seasonal_taiga_misc_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            PINE_TREE1.weighted(0.25F),
//            PINE_TREE2.weighted(0.25F),
//            ASPEN_TREE2.weighted(0.25F)),
//            ASPEN_TREE1)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_SEASONAL_TREE_GIANT = createConfiguredFeature("spruce_seasonal_giant_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SPRUCE_RED_TREE_LARGE1.weighted(0.25F),
//            SPRUCE_ORANGE_TREE_LARGE1.weighted(0.25F),
//            SPRUCE_YELLOW_TREE_LARGE1.weighted(0.25F)),
//            SPRUCE_TREE_LARGE1)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.15F, 1))));
//
    public static final ConfiguredFeature<?, ?> SPRUCE_TREES = createConfiguredFeature("spruce_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(SPRUCE_TREE1.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_TREE2.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_TREE3.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_TREE4.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_TREE_MEDIUM1.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_TREE_MEDIUM2.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_TREE_MEDIUM3.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_TREE_MEDIUM4.placed(), 0.111F)),
            SPRUCE_TREE1.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_YELLOW_TREE = createConfiguredFeature("spruce_yellow_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SPRUCE_YELLOW_TREE1.weighted(0.06F),
//            SPRUCE_YELLOW_TREE2.weighted(0.5F),
//            SPRUCE_YELLOW_TREE3.weighted(0.04F),
//            SPRUCE_YELLOW_TREE4.weighted(0.2F),
//            SPRUCE_YELLOW_TREE_MEDIUM1.weighted(0.2F),
//            SPRUCE_YELLOW_TREE_MEDIUM2.weighted(0.2F),
//            SPRUCE_YELLOW_TREE_MEDIUM3.weighted(0.2F),
//            SPRUCE_YELLOW_TREE_MEDIUM4.weighted(0.1F)),
//            SPRUCE_YELLOW_TREE1)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.15F, 1))));
//
    public static final ConfiguredFeature<?, ?> ORANGE_SPRUCE_TREES = createConfiguredFeature("orange_spruce_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(SPRUCE_ORANGE_TREE1.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_ORANGE_TREE2.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_ORANGE_TREE3.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_ORANGE_TREE4.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_ORANGE_TREE_MEDIUM1.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_ORANGE_TREE_MEDIUM2.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_ORANGE_TREE_MEDIUM3.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_ORANGE_TREE_MEDIUM4.placed(), 0.111F)),
            SPRUCE_ORANGE_TREE_LARGE1.placed())));

    public static final ConfiguredFeature<?, ?> YELLOW_SPRUCE_TREES = createConfiguredFeature("yellow_spruce_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(SPRUCE_YELLOW_TREE1.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_YELLOW_TREE2.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_YELLOW_TREE3.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_YELLOW_TREE4.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_YELLOW_TREE_MEDIUM1.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_YELLOW_TREE_MEDIUM2.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_YELLOW_TREE_MEDIUM3.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_YELLOW_TREE_MEDIUM4.placed(), 0.111F)),
            SPRUCE_YELLOW_TREE_LARGE1.placed())));

    public static final ConfiguredFeature<?, ?> RED_SPRUCE_TREES = createConfiguredFeature("red_spruce_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(SPRUCE_RED_TREE1.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_RED_TREE2.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_RED_TREE3.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_RED_TREE4.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_RED_TREE_MEDIUM1.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_RED_TREE_MEDIUM2.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_RED_TREE_MEDIUM3.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_RED_TREE_MEDIUM4.placed(), 0.111F)),
            SPRUCE_RED_TREE1.placed())));


    public static final ConfiguredFeature<?, ?> AUTUMNAL_SPRUCE_TREES = createConfiguredFeature("autumnal_spruce_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(RED_SPRUCE_TREES.placed(), 0.25F),
            new WeightedPlacedFeature(ORANGE_SPRUCE_TREES.placed(), 0.25F),
            new WeightedPlacedFeature(YELLOW_SPRUCE_TREES.placed(), 0.25F)),
            SPRUCE_TREES.placed())));


    public static final ConfiguredFeature<?, ?> BLUE_SPRUCE_TREES = createConfiguredFeature("blue_spruce_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(SPRUCE_BLUE_TREE1.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_BLUE_TREE2.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_BLUE_TREE3.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_BLUE_TREE4.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_BLUE_TREE_MEDIUM1.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_BLUE_TREE_MEDIUM2.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_BLUE_TREE_MEDIUM3.placed(), 0.111F),
            new WeightedPlacedFeature(SPRUCE_BLUE_TREE_MEDIUM4.placed(), 0.111F)),
            SPRUCE_BLUE_TREE1.placed())));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_BLUE_TREE_GIANT = createConfiguredFeature("spruce_blue_tree_giant", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SPRUCE_BLUE_TREE_LARGE1.weighted(0.5F)),
//            SPRUCE_TREE_LARGE1)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.15F, 1))));
//

    public static final ConfiguredFeature<?, ?> MAHOGANY_TREES = createConfiguredFeature("mahogany_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(MAHOGANY_TREE1.placed(), 0.1F),
            new WeightedPlacedFeature(MAHOGANY_TREE2.placed(), 0.2F),
            new WeightedPlacedFeature(MAHOGANY_TREE3.placed(), 0.2F),
            new WeightedPlacedFeature(MAHOGANY_TREE4.placed(), 0.15F)),
            MAHOGANY_TREE5.placed())));


    public static final ConfiguredFeature<?, ?> RAINFOREST_TREES = createConfiguredFeature("rainforest_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(TROPICAL_SHRUB1.placed(), 0.1F)),
            MAHOGANY_TREES.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_SPARSE_TREE = createConfiguredFeature("sparse_rainforest_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            RAINBOW_LARGE_TREE1.weighted(0.1F),
//            RAINBOW_TREE1.weighted(0.1F),
//            MAHOGANY_TREE5.weighted(0.1F),
//            TROPICAL_SHRUB1.weighted(0.1F),
//            MAHOGANY_TREE2.weighted(0.2F),
//            MAHOGANY_TREE3.weighted(0.2F),
//            MAHOGANY_TREE4.weighted(0.15F)),
//            MAHOGANY_TREE1)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.2F, 2))));
//
    public static final ConfiguredFeature<?, ?> GUIANA_SHIELD_TREES = createConfiguredFeature("guiana_shield_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(RAINBOW_LARGE_TREE1.placed(), 0.1F),
            new WeightedPlacedFeature(RAINBOW_TREE1.placed(), 0.1F),
            new WeightedPlacedFeature(TROPICAL_SHRUB1.placed(), 0.1F)),
            MAHOGANY_TREES.placed())));
    //
//
    public static final ConfiguredFeature<?, ?> SKYRIS_TREES = createConfiguredFeature("skyris_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(SKYRIS_TREE1.placed(), 0.2F),
            new WeightedPlacedFeature(SKYRIS_TREE2.placed(), 0.2F),
            new WeightedPlacedFeature(SKYRIS_TREE3.placed(), 0.2F),
            new WeightedPlacedFeature(SKYRIS_TREE4.placed(), 0.2F)),
            SKYRIS_TREE5.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_SKYRIS_TREE = createConfiguredFeature("sparse_skyris_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SKYRIS_TREE1.weighted(0.15F),
//            SKYRIS_TREE5.weighted(0.25F),
//            SKYRIS_TREE2.weighted(0.15F),
//            SKYRIS_TREE3.weighted(0.25F)),
//            SKYRIS_TREE4)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.3F, 2))));
//
    public static final ConfiguredFeature<?, ?> BAOBAB_TREES = createConfiguredFeature("baobab_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BAOBAB_TREE1.placed(), 0.35F),
            new WeightedPlacedFeature(BAOBAB_TREE2.placed(), 0.35F)),
            BAOBAB_TREE3.placed())));

    public static final ConfiguredFeature<?, ?> ARAUCARIA_TREES = createConfiguredFeature("araucaria_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ARAUCARIA_TREE1.placed(), 0.5F)), ARAUCARIA_TREE2.placed())));
    //
    public static final ConfiguredFeature<?, ?> BROWN_ZELKOVA_TREES = createConfiguredFeature("brown_zelkova_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ZELKOVA_BROWN_TREE1.placed(), 0.33F),
            new WeightedPlacedFeature(ZELKOVA_BROWN_TREE2.placed(), 0.33F)),
            ZELKOVA_BROWN_TREE3.placed())));
    //
    public static final ConfiguredFeature<?, ?> MEADOW_SHRUBS = createConfiguredFeature("meadow_shrubs", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(SHRUB_MEADOW.placed(), 0.5F)), SHRUB_MEADOW2.placed())));
    //
    public static final ConfiguredFeature<?, ?> MEADOW_TREES = createConfiguredFeature("meadow_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(MEADOW_TREE1.placed(), 0.3F),
            new WeightedPlacedFeature(MEADOW_TREE2.placed(), 0.3F)),
            MEADOW_TREE3.placed())));
    //
    public static final ConfiguredFeature<?, ?> TEMPERATE_GROVE_TREES = createConfiguredFeature("temperate_grove_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BIRCH_YELLOW_BOREAL_TREE1.placed(), 0.5F)),
            BIRCH_BOREAL_TREE1.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_ENCHANTED_GROVE_TREE = createConfiguredFeature("enchanted_grove_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            ENCHANTED_BLUE_GROVE_TREE1.weighted(0.5F)),
//            ENCHANTED_GREEN_GROVE_TREE1)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.25F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_GIANT_FLOWER = createConfiguredFeature("giant_flowers", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            GIANT_ANGELICA_FLOWER.weighted(0.2F),
//            GIANT_DANDELION_FLOWER.weighted(0.2F),
//            GIANT_IRIS_FLOWER.weighted(0.5F)),
//            GIANT_ROSE_FLOWER)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.15F, 1))));
//
    public static final ConfiguredFeature<?, ?> ENCHANTED_TREES = createConfiguredFeature("enchanted_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ENCHANTED_BLUE_TREE2.placed(), 0.2F),
            new WeightedPlacedFeature(ENCHANTED_BLUE_TREE3.placed(), 0.2F),
            new WeightedPlacedFeature(ENCHANTED_GREEN_TREE1.placed(), 0.2F),
            new WeightedPlacedFeature(ENCHANTED_GREEN_TREE2.placed(), 0.2F),
            new WeightedPlacedFeature(ENCHANTED_GREEN_TREE3.placed(), 0.1F)),
            ENCHANTED_BLUE_TREE1.placed())));

    public static final ConfiguredFeature<?, ?> ASPEN_TREES = createConfiguredFeature("aspen_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ASPEN_TREE2.placed(), 0.50F), new WeightedPlacedFeature(ASPEN_TREE3.placed(), 0.25F)), ASPEN_TREE1.placed())));
    //
    public static final ConfiguredFeature<?, ?> ASPEN_SHRUBS = createConfiguredFeature("aspen_shrubs", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ASPEN_SHRUB1.placed(), 0.5F)),
            ASPEN_SHRUB2.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ASPEN_TREE = createConfiguredFeature("sparse_aspen_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            ASPEN_TREE2.weighted(0.2F),
//            ASPEN_TREE3.weighted(0.1F)),
//            ASPEN_TREE1)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.4F, 2))));
//
    public static final ConfiguredFeature<?, ?> ZELKOVA_TREES = createConfiguredFeature("zelkova_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ZELKOVA_TREE1.placed(), 0.33F),
            new WeightedPlacedFeature(ZELKOVA_TREE2.placed(), 0.33F)),
            ZELKOVA_TREE3.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ZELKOVA_TREE = createConfiguredFeature("sparse_zelkova_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            ZELKOVA_TREE2.weighted(0.2F),
//            ZELKOVA_TREE3.weighted(0.1F)),
//            ZELKOVA_TREE1)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.4F, 2))));
//
    public static final ConfiguredFeature<?, ?> PALO_VERDE_TREES = createConfiguredFeature("palo_verde_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(PALO_VERDE_TREE1.placed(), 0.5F)),
            PALO_VERDE_TREE2.placed())));

    public static final ConfiguredFeature<?, ?> JOSHUA_TREES = createConfiguredFeature("joshua_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(JOSHUA_TREE1.placed(), 0.5F)),
            JOSHUA_TREE2.placed())));
    //
    public static final ConfiguredFeature<?, ?> PRAIRIE_SHRUBS = createConfiguredFeature("prairie_shrubs", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(SHRUB_PRAIRIE1.placed(), 0.5F)),
            SHRUB_PRAIRIE2.placed())));
    //
    public static final ConfiguredFeature<?, ?> PALM_TREES = createConfiguredFeature("palm_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(PALM_TREE1.placed(), 0.25F),
            new WeightedPlacedFeature(PALM_TREE2.placed(), 0.25F),
            new WeightedPlacedFeature(PALM_TREE3.placed(), 0.25F)),
            PALM_TREE4.placed())));

    //    public static final ConfiguredFeature<?, ?> RANDOM_DUNE_PALM_TREE = createConfiguredFeature("dune_palm_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            PALM_TREE4.weighted(0.05F),
//            PALM_TREE3.weighted(0.35F),
//            PALM_TREE2.weighted(0.35F)),
//            PALM_TREE1)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.15F, 2))));
//
    public static final ConfiguredFeature<?, ?> CHERRY_TREES = createConfiguredFeature("cherry_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(CHERRY_PINK_TREE1.placed(), 0.25F),
            new WeightedPlacedFeature(CHERRY_PINK_TREE2.placed(), 0.25F),
            new WeightedPlacedFeature(CHERRY_WHITE_TREE1.placed(), 0.25F)),
            CHERRY_WHITE_TREE2.placed())));

    //    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_CHERRY_TREE = createConfiguredFeature("sparse_cherry_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            CHERRY_PINK_TREE1.weighted(0.2F),
//            CHERRY_PINK_TREE2.weighted(0.2F),
//            CHERRY_WHITE_TREE1.weighted(0.1F)),
//            CHERRY_WHITE_TREE2)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.1F, 2))));
//
    public static final ConfiguredFeature<?, ?> HAZEL_TREES = createConfiguredFeature("hazel_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(HAZEL_TREE1.placed(), 0.3F),
            new WeightedPlacedFeature(HAZEL_TREE2.placed(), 0.3F),
            new WeightedPlacedFeature(DEAD_HAZEL_TREE1.placed(), 0.2F)),
            DEAD_HAZEL_TREE2.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_WITCH_HAZEL_TREE = createConfiguredFeature("sparse_witch_hazel_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            DEAD_HAZEL_TREE1.weighted(0.2F),
//            DEAD_HAZEL_TREE2.weighted(0.2F),
//            DEAD_HAZEL_TREE3.weighted(0.1F)),
//            DEAD_HAZEL_TREE4)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.3F, 2))));
//
    public static final ConfiguredFeature<?, ?> EBONY_TREES = createConfiguredFeature("ebony_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(EBONY_TREE1.placed(), 0.45F),
            new WeightedPlacedFeature(EBONY_TREE2.placed(), 0.45F)),
            EBONY_BUSH1.placed())));

    public static final ConfiguredFeature<?, ?> FRAGMENT_FOREST_TREES = createConfiguredFeature("stone_forest_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(TreeFeatures.JUNGLE_BUSH.placed(), 0.1F),
            new WeightedPlacedFeature(EBONY_TREES.placed(), 0.45F)),
            DECIDUOUS_TREES.placed())));
    //
    public static final ConfiguredFeature<?, ?> HOLLY_TREES = createConfiguredFeature("holly_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(HOLLY_TREE1.placed(), 0.2F),
            new WeightedPlacedFeature(HOLLY_TREE2.placed(), 0.2F),
            new WeightedPlacedFeature(HOLLY_TREE3.placed(), 0.1F)),
            HOLLY_TREE4.placed())));
    //
//    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_HOLLY_TREE = createConfiguredFeature("sparse_holly_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            HOLLY_TREE1.weighted(0.2F),
//            HOLLY_TREE2.weighted(0.2F),
//            HOLLY_TREE3.weighted(0.1F)),
//            HOLLY_TREE4)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.4F, 2))));
//
    public static final ConfiguredFeature<?, ?> MANGROVE_TREES = createConfiguredFeature("mangrove_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(MANGROVE_TREE1.placed(), 0.2F),
            new WeightedPlacedFeature(MANGROVE_TREE2.placed(), 0.2F),
            new WeightedPlacedFeature(MANGROVE_TREE3.placed(), 0.2F),
            new WeightedPlacedFeature(MANGROVE_TREE4.placed(), 0.2F)),
            MANGROVE_TREE5.placed())));

    //    public static final ConfiguredFeature<?, ?> RANDOM_MANGROVE_SPARSE_TREE = createConfiguredFeature("sparse_mangrove_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            MANGROVE_TREE1.weighted(0.2F),
//            MANGROVE_TREE2.weighted(0.2F),
//            MANGROVE_TREE3.weighted(0.2F),
//            MANGROVE_TREE4.weighted(0.1F)),
//            MANGROVE_TREE5)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.5F, 2))));
//
    public static final ConfiguredFeature<?, ?> ORCHARD_TREES = createConfiguredFeature("orchard_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ORCHARD_TREE1.placed(), 0.33F),
            new WeightedPlacedFeature(ORCHARD_TREE2.placed(), 0.33F)),
            ORCHARD_TREE3.placed())));
    //
    public static final ConfiguredFeature<?, ?> TEMPERATE_RAINFOREST_TREES = createConfiguredFeature("temperate_rainforest_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(WOODLANDS_TREE1.placed(), 0.5F)),
            WOODLANDS_TREE1.placed())));
//

    public static final ConfiguredFeature<?, ?> OAK_TREES = createConfiguredFeature("oak_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(OAK_TREE1.placed(), 0.16F),
            new WeightedPlacedFeature(OAK_TREE2.placed(), 0.16F),
            new WeightedPlacedFeature(OAK_TREE3.placed(), 0.16F),
            new WeightedPlacedFeature(OAK_TREE_LARGE1.placed(), 0.16F),
            new WeightedPlacedFeature(OAK_TREE_LARGE2.placed(), 0.16F)),
            OAK_TREE_LARGE3.placed())));

    public static final ConfiguredFeature<?, ?> ORANGE_OAK_TREES = createConfiguredFeature("orange_oak_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ORANGE_OAK_TREE1.placed(), 0.16F),
            new WeightedPlacedFeature(ORANGE_OAK_TREE2.placed(), 0.16F),
            new WeightedPlacedFeature(ORANGE_OAK_TREE3.placed(), 0.16F),
            new WeightedPlacedFeature(ORANGE_OAK_TREE_LARGE1.placed(), 0.16F),
            new WeightedPlacedFeature(ORANGE_OAK_TREE_LARGE2.placed(), 0.16F)),
            ORANGE_OAK_TREE_LARGE3.placed())));

    public static final ConfiguredFeature<?, ?> BROWN_OAK_TREES = createConfiguredFeature("brown_oak_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BROWN_OAK_TREE1.placed(), 0.16F),
            new WeightedPlacedFeature(BROWN_OAK_TREE2.placed(), 0.16F),
            new WeightedPlacedFeature(BROWN_OAK_TREE3.placed(), 0.16F),
            new WeightedPlacedFeature(BROWN_OAK_TREE_LARGE1.placed(), 0.16F),
            new WeightedPlacedFeature(BROWN_OAK_TREE_LARGE2.placed(), 0.16F)),
            BROWN_OAK_TREE_LARGE3.placed())));

    public static final ConfiguredFeature<?, ?> RED_OAK_TREES = createConfiguredFeature("red_oak_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(RED_OAK_TREE1.placed(), 0.16F),
            new WeightedPlacedFeature(RED_OAK_TREE2.placed(), 0.16F),
            new WeightedPlacedFeature(RED_OAK_TREE3.placed(), 0.16F),
            new WeightedPlacedFeature(RED_OAK_TREE_LARGE1.placed(), 0.16F),
            new WeightedPlacedFeature(RED_OAK_TREE_LARGE2.placed(), 0.16F)),
            RED_OAK_TREE_LARGE3.placed())));

    public static final ConfiguredFeature<?, ?> AUTUMNAL_OAK_TREES = createConfiguredFeature("autumnal_oak_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(RED_OAK_TREES.placed(), 0.25F),
            new WeightedPlacedFeature(BROWN_OAK_TREES.placed(), 0.25F),
            new WeightedPlacedFeature(ORANGE_OAK_TREES.placed(), 0.25F)),
            OAK_TREES.placed())));

    //    public static final ConfiguredFeature<?, ?> RANDOM_SOUL_SHROOM_TREES = createConfiguredFeature("soul_shroom_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SOUL_SHROOM_TREE3.weighted(0.35F),
//            SOUL_SHROOM_TREE2.weighted(0.35F)),
//            SOUL_SHROOM_TREE1)).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(8, 0.5F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_DEATH_CAP_TREES = createConfiguredFeature("death_cap_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            DEATH_CAP_TREE3.weighted(0.35F),
//            DEATH_CAP_TREE2.weighted(0.35F)),
//            DEATH_CAP_TREE1)).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(8, 0.5F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_MINI_MUSHROOMS = createConfiguredFeature("mini_mushrooms", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            GREEN_MUSHROOM_MINI.weighted(0.16F),
//            RED_MUSHROOM_MINI.weighted(0.16F),
//            BROWN_MUSHROOM_MINI.weighted(0.16F),
//            WOOD_BLEWIT_MINI.weighted(0.16F),
//            WEEPING_MILKCAP_MINI.weighted(0.16F)),
//            GREEN_MUSHROOM_MINI)).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.3F, 3))));
//
    public static final ConfiguredFeature<?, ?> HUGE_MUSHROOMS = createConfiguredFeature("huge_mushrooms", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(GREEN_MUSHROOM_HUGE.placed(), 0.25F),
            new WeightedPlacedFeature(WOOD_BLEWIT_HUGE.placed(), 0.25F),
            new WeightedPlacedFeature(WEEPING_MILKCAP_HUGE.placed(), 0.25F)),
            GREEN_MUSHROOM_HUGE.placed())));

    //
//    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_MUSHROOM = createConfiguredFeature("embur_mushrooms", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            EMBUR_MUSHROOM4.weighted(0.25F),
//            EMBUR_MUSHROOM3.weighted(0.25F),
//            EMBUR_MUSHROOM2.weighted(0.25F)),
//            EMBUR_MUSHROOM)).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.5F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_FUNGUS = createConfiguredFeature("fungi", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            WARPED_FUNGUS1.weighted(0.15F),
//            WARPED_FUNGUS2.weighted(0.15F),
//            CRIMSON_FUNGUS1.weighted(0.4F)),
//            CRIMSON_FUNGUS2)).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(4, 0.5F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SYTHIAN_FUNGUS = createConfiguredFeature("sythian_fungi_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SYTHIAN_FUNGUS_TREE1.weighted(0.25F),
//            SYTHIAN_FUNGUS_TREE2.weighted(0.25F),
//            SYTHIAN_FUNGUS_TREE3.weighted(0.25F)),
//            SYTHIAN_FUNGUS_TREE4)).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(12, 0.5F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_WITHERING_OAK_TREE = createConfiguredFeature("withering_oak_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            WITHERING_OAK_TREE5.weighted(0.25F),
//            WITHERING_OAK_TREE4.weighted(0.2F),
//            WITHERING_OAK_TREE3.weighted(0.25F),
//            WITHERING_OAK_TREE2.weighted(0.2F)),
//            WITHERING_OAK_TREE1)).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(7, 0.35F, 5))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_WITHERING_OAK_TREE = createConfiguredFeature("sparse_withering_oak_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            WITHERING_OAK_TREE4.weighted(0.25F)),
//            WITHERING_OAK_TREE1)).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.1F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_TWISTY_LAMENT_TREE = createConfiguredFeature("twisty_lament_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            LAMENT_TWISTY_TREE3.weighted(0.35F),
//            LAMENT_TWISTY_TREE2.weighted(0.35F)),
//            LAMENT_TWISTY_TREE1)).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(12, 0.5F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_WEEPING_LAMENT_TREE = createConfiguredFeature("weeping_lament_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            LAMENT_WEEPING_TREE3.weighted(0.35F),
//            LAMENT_WEEPING_TREE2.weighted(0.35F)),
//            LAMENT_WEEPING_TREE1)).decorated(BYGDecorators.AT_OR_BELOW_SEA_LEVEL.configured(
//            new AtOrBelowSeaLevelCountExtraConfig(8, 0.5F, 2, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_WAILING_PILLAR = createConfiguredFeature("wailing_pillars", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            WAILING_PILLAR1.weighted(0.5F)),
//            WAILING_PILLAR1)).decorated(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.4F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_BULBIS_TREE = createConfiguredFeature("bulbis_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            BULBIS_BUSH1.weighted(0.1F),
//            BULBIS_TREE1.weighted(0.15F),
//            BULBIS_TREE2.weighted(0.15F),
//            BULBIS_TREE3.weighted(0.1F),
//            BULBIS_TREE4.weighted(0.15F),
//            BULBIS_TREE5.weighted(0.15F),
//            BULBIS_TREE6.weighted(0.1F)),
//            BULBIS_TREE7)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_BULBIS_TREE = createConfiguredFeature("sparse_bulbis_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            BULBIS_BUSH1.weighted(0.1F),
//            BULBIS_TREE1.weighted(0.15F),
//            BULBIS_TREE2.weighted(0.15F),
//            BULBIS_TREE3.weighted(0.1F),
//            BULBIS_TREE4.weighted(0.15F),
//            BULBIS_TREE5.weighted(0.15F),
//            BULBIS_TREE6.weighted(0.1F)),
//            BULBIS_TREE7)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.2F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_PURPLE_BULBIS_TREE = createConfiguredFeature("purple_bulbis_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            PURPLE_BULBIS_BUSH1.weighted(0.1F),
//            PURPLE_BULBIS_TREE1.weighted(0.15F),
//            PURPLE_BULBIS_TREE2.weighted(0.15F),
//            PURPLE_BULBIS_TREE3.weighted(0.1F),
//            PURPLE_BULBIS_TREE4.weighted(0.15F),
//            PURPLE_BULBIS_TREE5.weighted(0.15F),
//            PURPLE_BULBIS_TREE6.weighted(0.1F)),
//            PURPLE_BULBIS_TREE7)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.3F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_PURPLE_BULBIS_TREE = createConfiguredFeature("sparse_purple_bulbis_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            PURPLE_BULBIS_BUSH1.weighted(0.1F),
//            PURPLE_BULBIS_TREE1.weighted(0.15F),
//            PURPLE_BULBIS_TREE2.weighted(0.15F),
//            PURPLE_BULBIS_TREE3.weighted(0.1F),
//            PURPLE_BULBIS_TREE4.weighted(0.15F),
//            PURPLE_BULBIS_TREE5.weighted(0.15F),
//            PURPLE_BULBIS_TREE6.weighted(0.1F)),
//            PURPLE_BULBIS_TREE7)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.2F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_NIGHTSHADE_TREE = createConfiguredFeature("nightshade_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            NIGHTSHADE_TREE1.weighted(0.15F),
//            NIGHTSHADE_TREE2.weighted(0.3F),
//            NIGHTSHADE_TREE3.weighted(0.3F)),
//            NIGHTSHADE_TREE4)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(4, 0.3F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_NIGHTSHADE_BUSH = createConfiguredFeature("nightshade_bushes", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            NIGHTSHADE_BUSH1.weighted(0.7F)),
//            NIGHTSHADE_BUSH2)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(4, 0.3F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_ETHER_TREE = createConfiguredFeature("ether_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            ETHER_TREE1.weighted(0.15F),
//            ETHER_TREE2.weighted(0.15F),
//            ETHER_TREE3.weighted(0.15F),
//            ETHER_TREE5.weighted(0.15F)),
//            ETHER_TREE4)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(4, 0.3F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ETHER_TREE = createConfiguredFeature("sparse_ether_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            ETHER_TREE1.weighted(0.4F),
//            ETHER_TREE2.weighted(0.4F),
//            ETHER_TREE3.weighted(0.05F),
//            ETHER_TREE5.weighted(0.05F)),
//            ETHER_TREE4)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.35F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_ETHER_BUSH = createConfiguredFeature("ether_bushes", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            ETHER_BUSH1.weighted(0.7F)),
//            ETHER_BUSH2)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(4, 0.3F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SHULKREN_TREE = createConfiguredFeature("shulkren_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SHULKREN_TREE1.weighted(0.7F)),
//            SHULKREN_TREE2)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(4, 0.3F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_IMPARIUS_MUSHROOM = createConfiguredFeature("imparius_mushrooms", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            IMPARIUS_MUSHROOM3.weighted(0.25F),
//            IMPARIUS_MUSHROOM4.weighted(0.25F),
//            IMPARIUS_MUSHROOM5.weighted(0.25F)),
//            IMPARIUS_MUSHROOM6)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.3F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_IMPARIUS_MUSHROOM_SHRUBS = createConfiguredFeature("imparius_mushroom_shrubs", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            IMPARIUS_MUSHROOM1.weighted(0.5F)),
//            IMPARIUS_MUSHROOM2)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_FUNGAL_IMPARIUS = createConfiguredFeature("fungal_impariuses", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            FUNGAL_IMPARIUS1.weighted(0.25F),
//            FUNGAL_IMPARIUS2.weighted(0.25F),
//            FUNGAL_IMPARIUS3.weighted(0.25F),
//            FUNGAL_IMPARIUS4.weighted(0.25F)),
//            FUNGAL_IMPARIUS5)).decorated(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.3F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_DEAD_ETHER_TREE = createConfiguredFeature("dead_ether_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            ETHER_TREE_DEAD1.weighted(0.35F),
//            ETHER_TREE_DEAD2.weighted(0.35F)),
//            ETHER_TREE_DEAD3)).decorated(BYGDecorators.MOTION_BLOCKING_NO_LEAVES_COUNT_EXTRA.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.3F, 2))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_DESERT_END_ISLAND = createConfiguredFeature("floating_desert_end_islands", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            FLOATING_DESERT_ISLAND1.weighted(0.35F),
//            FLOATING_DESERT_ISLAND2.weighted(0.35F)),
//            FLOATING_DESERT_ISLAND3)).decorated(BYGDecorators.ISLAND.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.2F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_ISLAND = createConfiguredFeature("floating_islands", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            FLOATING_ISLAND1.weighted(0.25F),
//            FLOATING_ISLAND2.weighted(0.25F),
//            FLOATING_ISLAND3.weighted(0.25F)),
//            FLOATING_ISLAND5)).decorated(BYGDecorators.ISLAND.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.13F, 1))));
//
//    public static final ConfiguredFeature<?, ?> RANDOM_SHATTERED_ISLAND = createConfiguredFeature("shattered_floating_islands", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
//            SHATTERED_FLOATING_ISLAND1.weighted(0.25F),
//            SHATTERED_FLOATING_ISLAND2.weighted(0.25F),
//            SHATTERED_FLOATING_ISLAND2.weighted(0.25F)),
//            SHATTERED_FLOATING_ISLAND4)).decorated(BYGDecorators.ISLAND.configured(
//            new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.13F, 1))));
//
//
    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        ResourceLocation bygID = BYG.createLocation(id);
        if (BuiltinRegistries.CONFIGURED_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Configured Feature ID: \"" + bygID.toString() + "\" already exists in the Configured Features registry!");

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, bygID, configuredFeature);
        if (configuredFeature == null) {
            String s = "";
        }
        return configuredFeature;
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createFlowerConfiguredFeature(String id, Block flowerBlock) {
        return (CF) createConfiguredFeature(id, Feature.FLOWER.configured(invokeGrassPatch(SimpleStateProvider.simple(flowerBlock.defaultBlockState()), 15)));
    }
//}
//
////Initialize these later so our blocks don't throw NPEs initializing other configured features in this class.
//    public static class SpreadableBlockConfigs {
//        public static final RandomPatchConfiguration EMBUR_ROOTS = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.EMBUR_ROOTS.defaultBlockState(), 50).add(BYGBlocks.EMBUR_SPROUTS.defaultBlockState(), 35).add(BYGBlocks.EMBUR_WART.defaultBlockState(), 11)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration LUSH_GRASS_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.CLOVER_PATCH.defaultBlockState(), 15).add(BYGBlocks.FLOWER_PATCH.defaultBlockState(), 15).add(Blocks.GRASS.defaultBlockState(), 55).add(BYGBlocks.SHRUB.defaultBlockState(), 25).add(Blocks.PINK_TULIP.defaultBlockState(), 15).add(BYGBlocks.MAGENTA_TULIP.defaultBlockState(), 15).add(BYGBlocks.CYAN_TULIP.defaultBlockState(), 15).add(BYGBlocks.WHITE_ANEMONE.defaultBlockState(), 15).add(BYGBlocks.ROSE.defaultBlockState(), 10).add(BYGBlocks.ALPINE_BELLFLOWER.defaultBlockState(), 20)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration SYTHIAN_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.SYTHIAN_ROOTS.defaultBlockState(), 50).add(BYGBlocks.SYTHIAN_SPROUT.defaultBlockState(), 50).add(BYGBlocks.SYTHIAN_FUNGUS.defaultBlockState(), 11)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration WAILING_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.WAILING_GRASS.defaultBlockState(), 50).add(BYGBlocks.WAILING_GRASS.defaultBlockState(), 50).add(BYGBlocks.WAILING_GRASS.defaultBlockState(), 11)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration IVIS_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.IVIS_ROOTS.defaultBlockState(), 50).add(BYGBlocks.IVIS_SPROUT.defaultBlockState(), 50)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration OVERGROWN_BLACKSTONE_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.CRIMSON_ROOTS.defaultBlockState(), 80).add(Blocks.CRIMSON_FUNGUS.defaultBlockState(), 15).add(BYGBlocks.CRIMSON_BERRY_BUSH.defaultBlockState(), 5)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration OVERGROWN_NETHERRACK_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.NETHER_SPROUTS.defaultBlockState(), 90).add(BYGBlocks.SOUL_SHROOM.defaultBlockState(), 5).add(BYGBlocks.DEATH_CAP.defaultBlockState(), 5)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration MYCELIUM_NETHERRACK_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.SOUL_SHROOM.defaultBlockState(), 50).add(BYGBlocks.DEATH_CAP.defaultBlockState(), 50)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration ETHER_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ETHER_GRASS.defaultBlockState(), 50).add(BYGBlocks.ETHER_BUSH.defaultBlockState(), 45).add(BYGBlocks.THEREAL_BELLFLOWER.defaultBlockState(), 5)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration NIGHTSHADE_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_SPROUTS.defaultBlockState(), 50).add(BYGBlocks.NIGHTSHADE_SPROUTS.defaultBlockState(), 50)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration VERMILION_SCULK_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.VERMILION_SCULK_TENDRILS.defaultBlockState(), 50).add(BYGBlocks.VERMILION_SCULK_TENDRILS.defaultBlockState(), 40).add(BYGBlocks.VERMILION_SCULK_GROWTH.defaultBlockState(), 10)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration BULBIS_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.BULBIS_SPROUTS.defaultBlockState(), 50).add(BYGBlocks.BULBIS_SPROUTS.defaultBlockState(), 45).add(BYGBlocks.BULBIS_SPROUTS.defaultBlockState(), 5)), new DoubleBlockPlacer()).build();
//        public static final RandomPatchConfiguration SHULKREN_CONFIG = new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.SHULKREN_MOSS_BLANKET.defaultBlockState(), 50).add(BYGBlocks.SHULKREN_MOSS_BLANKET.defaultBlockState(), 45).add(BYGBlocks.SHULKREN_FUNGUS.defaultBlockState(), 5)), new DoubleBlockPlacer()).build();
//    }
//
//    //Initialize these later to ensure config values were read.
//    public static class OreConfigs {
//        public static RuleTest ETHER_STONE = new BlockMatchTest(BYGBlocks.ETHER_STONE);
//
//        public static final ConfiguredFeature<?, ?> ORE_EMERALDITE = createConfiguredFeature("ore_emeraldite", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, BYGBlocks.EMERALDITE_ORE.defaultBlockState(), 4)).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(4)))).squared().count(22));
//        public static final ConfiguredFeature<?, ?> ORE_PENDORITE = createConfiguredFeature("ore_pendorite", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, BYGBlocks.PENDORITE_ORE.defaultBlockState(), 4)).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(4)))).squared().count(20));
//        public static final ConfiguredFeature<?, ?> ORE_AMETRINE = createConfiguredFeature("ore_ametrine", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.AMETRINE_ORE.defaultBlockState()), ImmutableList.of(BYGBlocks.ETHER_STONE.defaultBlockState()), ImmutableList.of(BYGBlocks.ETHER_STONE.defaultBlockState(), BYGBlocks.VERMILION_SCULK.defaultBlockState()), ImmutableList.of(BYGBlocks.ETHER_STONE.defaultBlockState(), BYGBlocks.VERMILION_SCULK.defaultBlockState(), Blocks.AIR.defaultBlockState()))).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(128));
//        public static final ConfiguredFeature<?, ?> ORE_AMETRINE_BUDDING = createConfiguredFeature("ore_ametrine_budding", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.AMETRINE_ORE.defaultBlockState()), ImmutableList.of(BYGBlocks.ETHER_STONE.defaultBlockState()), ImmutableList.of(BYGBlocks.ETHER_STONE.defaultBlockState(), BYGBlocks.VERMILION_SCULK.defaultBlockState()), ImmutableList.of(BYGBlocks.ETHER_STONE.defaultBlockState(), BYGBlocks.VERMILION_SCULK.defaultBlockState(), Blocks.AIR.defaultBlockState()))).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(128));
//
//        public static final ConfiguredFeature<?, ?> ORE_ROCKY_STONE = createConfiguredFeature("ore_rocky_stone", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, BYGBlocks.ROCKY_STONE.defaultBlockState(), 20)).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(60)))).squared().count(10));
//        public static final ConfiguredFeature<?, ?> ORE_SCORIA_STONE = createConfiguredFeature("ore_scoria_stone", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, BYGBlocks.SCORIA_STONE.defaultBlockState(), 20)).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(60)))).squared().count(10));
//        public static final ConfiguredFeature<?, ?> ORE_SOAP_STONE = createConfiguredFeature("ore_soap_stone", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, BYGBlocks.SOAPSTONE.defaultBlockState(), 20)).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(60)))).squared().count(10));
//    }
}
