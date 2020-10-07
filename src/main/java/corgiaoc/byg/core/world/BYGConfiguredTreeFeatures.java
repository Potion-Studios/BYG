package corgiaoc.byg.core.world;

import com.google.common.collect.ImmutableList;
import corgiaoc.byg.common.world.feature.biomefeatures.BYGFeatureConfigs;
import corgiaoc.byg.common.world.feature.features.config.BYGMushroomFeatureConfig;
import corgiaoc.byg.common.world.feature.features.config.BYGTreeFeatureConfig;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public class BYGConfiguredTreeFeatures {
    /***********************************************************Configured Features********************************************************/
    public static final ConfiguredFeature<?, ?> DUMMY_TREE = WorldGenRegistrationHelper.createConfiguredFeature("dummy_tree", BYGFeatures.DUMMY_TREE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(new AtSurfaceWithExtraConfig(16, 0.4F, 8))));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ARAUCARIA_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("araucaria_tree1", BYGFeatures.ARAUCARIA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.ARAUCARIA_LEAVES).setMaxHeight(30).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ARAUCARIA_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("araucaria_tree2", BYGFeatures.ARAUCARIA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.ARAUCARIA_LEAVES).setMaxHeight(28).setMinHeight(18).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ANCIENT_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("ancient_tree1", BYGFeatures.ANCIENT_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).setMaxHeight(25).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ANCIENT_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("ancient_tree2", BYGFeatures.ANCIENT_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(25).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ANCIENT_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("ancient_tree3", BYGFeatures.ANCIENT_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES).setMaxHeight(25).setMinHeight(15).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ASPEN_SHRUB1 = WorldGenRegistrationHelper.createConfiguredFeature("aspen_shrub1", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ASPEN_SHRUB2 = WorldGenRegistrationHelper.createConfiguredFeature("aspen_shrub2", BYGFeatures.SHRUB2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ASPEN_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("aspen_tree1", BYGFeatures.ASPEN_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMaxHeight(10).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ASPEN_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("aspen_tree2", BYGFeatures.ASPEN_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMaxHeight(16).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ASPEN_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("aspen_tree3", BYGFeatures.ASPEN_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMaxHeight(16).setMinHeight(9).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BAOBAB_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("baobab_tree1", BYGFeatures.BAOBAB_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.BAOBAB_LOG).setLeavesBlock(BYGBlocks.BAOBAB_LEAVES).setMaxHeight(28).setMinHeight(20).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BIRCH_BROWN_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("brown_birch_tree1", BYGFeatures.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BIRCH_ORANGE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("orange_birch_tree1", BYGFeatures.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BIRCH_RED_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("red_birch_tree1", BYGFeatures.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BIRCH_YELLOW_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("yellow_birch_tree1", BYGFeatures.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(8).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BLUFF_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("bluff_tree1", BYGFeatures.BLUFF_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(21).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BLUFF_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("bluff_tree2", BYGFeatures.BLUFF_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BLUFF_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("bluff_tree3", BYGFeatures.BLUFF_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BIRCH_BOREAL_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("birch_boreal_tree1", BYGFeatures.BOREAL_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BIRCH_YELLOW_BOREAL_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("birch_yellow_boreal_tree1", BYGFeatures.BOREAL_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(Blocks.BIRCH_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BOREAL_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("boreal_tree2", BYGFeatures.BOREAL_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(15).setMinHeight(11).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CHERRY_PINK_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("pink_cherry_tree1", BYGFeatures.CHERRY_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.PINK_CHERRY_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CHERRY_PINK_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("pink_cherry_tree2", BYGFeatures.CHERRY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.PINK_CHERRY_LEAVES).setMaxHeight(13).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CHERRY_WHITE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("white_cherry_tree1", BYGFeatures.CHERRY_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.WHITE_CHERRY_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CHERRY_WHITE_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("white_cherry_tree2", BYGFeatures.CHERRY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.WHITE_CHERRY_LEAVES).setMaxHeight(13).setMinHeight(8).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CIKA_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("cika_tree1", BYGFeatures.CIKA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.CIKA_LOG).setLeavesBlock(BYGBlocks.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CIKA_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("cika_tree2", BYGFeatures.CIKA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.CIKA_LOG).setLeavesBlock(BYGBlocks.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CIKA_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("cika_tree3", BYGFeatures.CIKA_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.CIKA_LOG).setLeavesBlock(BYGBlocks.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("conifer_tree1", BYGFeatures.CONIFER_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(25).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("conifer_tree2", BYGFeatures.CONIFER_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(30).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("conifer_tree3", BYGFeatures.CONIFER_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(35).setMinHeight(26).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("conifer_tree4", BYGFeatures.CONIFER_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(35).setMinHeight(25).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE5 = WorldGenRegistrationHelper.createConfiguredFeature("conifer_tree5", BYGFeatures.CONIFER_TREE5.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE6 = WorldGenRegistrationHelper.createConfiguredFeature("conifer_tree6", BYGFeatures.CONIFER_TREE6.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(17).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE7 = WorldGenRegistrationHelper.createConfiguredFeature("conifer_tree7", BYGFeatures.CONIFER_TREE7.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(28).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE8 = WorldGenRegistrationHelper.createConfiguredFeature("conifer_tree8", BYGFeatures.CONIFER_TREE8.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(28).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CYPRESS_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("cypress_tree1", BYGFeatures.CYPRESS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.CYPRESS_LOG).setLeavesBlock(BYGBlocks.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CYPRESS_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("cypress_tree2", BYGFeatures.CYPRESS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.CYPRESS_LOG).setLeavesBlock(BYGBlocks.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CYPRESS_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("cypress_tree3", BYGFeatures.CYPRESS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.CYPRESS_LOG).setLeavesBlock(BYGBlocks.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DEAD_HAZEL_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("dead_hazel_tree1", BYGFeatures.DEAD_HAZEL_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(15).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DEAD_HAZEL_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("dead_hazel_tree2", BYGFeatures.DEAD_HAZEL_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DEAD_HAZEL_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("dead_hazel_tree3", BYGFeatures.DEAD_HAZEL_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(16).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DEAD_HAZEL_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("dead_hazel_tree4", BYGFeatures.DEAD_HAZEL_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(7).setMinHeight(5).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_SEASONAL_SHRUB = WorldGenRegistrationHelper.createConfiguredFeature("seasonal_deciduous_shrub", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMinHeight(2).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_tree1", BYGFeatures.DECIDUOUS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(19).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_tree2", BYGFeatures.DECIDUOUS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(22).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_tree3", BYGFeatures.DECIDUOUS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(21).setMinHeight(16).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_tree4", BYGFeatures.DECIDUOUS_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_RED_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_red_tree1", BYGFeatures.DECIDUOUS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_RED_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_red_tree2", BYGFeatures.DECIDUOUS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_RED_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_red_tree3", BYGFeatures.DECIDUOUS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_RED_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_red_tree4", BYGFeatures.DECIDUOUS_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_ORANGE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_orange_tree1", BYGFeatures.DECIDUOUS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_ORANGE_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_orange_tree2", BYGFeatures.DECIDUOUS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_ORANGE_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_orange_tree3", BYGFeatures.DECIDUOUS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_ORANGE_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_orange_tree4", BYGFeatures.DECIDUOUS_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_BROWN_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_brown_tree1", BYGFeatures.DECIDUOUS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_BROWN_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_brown_tree2", BYGFeatures.DECIDUOUS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_BROWN_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_brown_tree3", BYGFeatures.DECIDUOUS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_BROWN_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("deciduous_brown_tree4", BYGFeatures.DECIDUOUS_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> EBONY_BUSH1 = WorldGenRegistrationHelper.createConfiguredFeature("ebony_bush1", BYGFeatures.EBONY_BUSH1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(28).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> EBONY_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("ebony_tree1", BYGFeatures.EBONY_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(13).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> EBONY_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("ebony_tree2", BYGFeatures.EBONY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(17).setMinHeight(11).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_BLUE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("blue_enchanted_tree1", BYGFeatures.ENCHANTED_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_BLUE_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("blue_enchanted_tree2", BYGFeatures.ENCHANTED_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(26).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_BLUE_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("blue_enchanted_tree3", BYGFeatures.ENCHANTED_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_GREEN_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("green_enchanted_tree1", BYGFeatures.ENCHANTED_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(ENCHANTED_BLUE_TREE1.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_GREEN_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("green_enchanted_tree2", BYGFeatures.ENCHANTED_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(ENCHANTED_BLUE_TREE2.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_GREEN_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("green_enchanted_tree3", BYGFeatures.ENCHANTED_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(ENCHANTED_BLUE_TREE3.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_BLUE_GROVE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("blue_enchanted_grove_tree1", BYGFeatures.ENCHANTED_GROVE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_GREEN_GROVE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("green_enchanted_grove_tree1", BYGFeatures.ENCHANTED_GROVE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(ENCHANTED_BLUE_TREE1.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> HOLLY_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("holly_tree1", BYGFeatures.HOLLY_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(23).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> HOLLY_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("holly_tree2", BYGFeatures.HOLLY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(15).setMinHeight(10).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> HOLLY_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("holly_tree3", BYGFeatures.HOLLY_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(25).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> HOLLY_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("holly_tree4", BYGFeatures.HOLLY_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(14).setMinHeight(9).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> JACARANDA_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("jacaranda_tree1", BYGFeatures.JACARANDA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.JACARANDA_LOG).setLeavesBlock(BYGBlocks.JACARANDA_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> JACARANDA_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("jacaranda_tree2", BYGFeatures.JACARANDA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.JACARANDA_LOG).setLeavesBlock(BYGBlocks.JACARANDA_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> INDIGO_JACARANDA_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("indigo_jacaranda_tree1", BYGFeatures.JACARANDA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(JACARANDA_TREE1.config).setLeavesBlock(BYGBlocks.INDIGO_JACARANDA_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> INDIGO_JACARANDA_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("indigo_jacaranda_tree2", BYGFeatures.JACARANDA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(JACARANDA_TREE2.config).setLeavesBlock(BYGBlocks.INDIGO_JACARANDA_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> JOSHUA_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("joshua_tree1", BYGFeatures.JOSHUA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.RIPE_JOSHUA_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.JOSHUA_LEAVES.getDefaultState(), 10)).setMaxHeight(6).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> JOSHUA_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("joshua_tree2", BYGFeatures.JOSHUA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.RIPE_JOSHUA_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.JOSHUA_LEAVES.getDefaultState(), 10)).setMaxHeight(6).setMinHeight(3).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MANGROVE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("mangrove_tree1", BYGFeatures.MANGROVE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(15).setMinHeight(10).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MANGROVE_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("mangrove_tree2", BYGFeatures.MANGROVE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(17).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MANGROVE_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("mangrove_tree3", BYGFeatures.MANGROVE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(16).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MANGROVE_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("mangrove_tree4", BYGFeatures.MANGROVE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(15).setMinHeight(10).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MANGROVE_TREE5 = WorldGenRegistrationHelper.createConfiguredFeature("mangrove_tree5", BYGFeatures.MANGROVE_TREE5.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(17).setMinHeight(11).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAPLE_RED_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("red_maple_tree1", BYGFeatures.MAPLE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.RED_MAPLE_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAPLE_RED_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("red_maple_tree2", BYGFeatures.MAPLE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.RED_MAPLE_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAPLE_SILVER_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("silver_maple_tree1", BYGFeatures.MAPLE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(MAPLE_RED_TREE1.config).setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAPLE_SILVER_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("silver_maple_tree2", BYGFeatures.MAPLE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(MAPLE_RED_TREE2.config).setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAPLE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("maple_tree1", BYGFeatures.MAPLE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.MAPLE_LEAVES).setMaxHeight(10).setMinHeight(5).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MEADOW_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("meadow_tree1", BYGFeatures.MEADOW_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MEADOW_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("meadow_tree2", BYGFeatures.MEADOW_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MEADOW_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("meadow_tree3", BYGFeatures.MEADOW_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ORCHARD_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("orchard_tree1", BYGFeatures.ORCHARD_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ORCHARD_LEAVES.getDefaultState(), 10).addWeightedBlockstate(BYGBlocks.FLOWERING_ORCHARD_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.RIPE_ORCHARD_LEAVES.getDefaultState(), 1)).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ORCHARD_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("orchard_tree2", BYGFeatures.ORCHARD_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ORCHARD_LEAVES.getDefaultState(), 10).addWeightedBlockstate(BYGBlocks.FLOWERING_ORCHARD_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.RIPE_ORCHARD_LEAVES.getDefaultState(), 1)).setMaxHeight(26).setMinHeight(21).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ORCHARD_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("orchard_tree3", BYGFeatures.ORCHARD_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ORCHARD_LEAVES.getDefaultState(), 10).addWeightedBlockstate(BYGBlocks.FLOWERING_ORCHARD_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.RIPE_ORCHARD_LEAVES.getDefaultState(), 1)).setMaxHeight(9).setMinHeight(14).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALM_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("palm_tree1", BYGFeatures.PALM_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALM_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("palm_tree2", BYGFeatures.PALM_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALM_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("palm_tree3", BYGFeatures.PALM_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALM_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("palm_tree4", BYGFeatures.PALM_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PINE_LARGE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("large_pine_tree1", BYGFeatures.PINE_LARGE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(28).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PINE_LARGE_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("large_pine_tree2", BYGFeatures.PINE_LARGE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(31).setMinHeight(26).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PINE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("pine_tree1", BYGFeatures.PINE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(20).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PINE_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("pine_tree2", BYGFeatures.PINE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALO_VERDE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("palo_verde_tree1", BYGFeatures.PALO_VERDE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PALO_VERDE_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.PALO_VERDE_LEAVES.getDefaultState(), 6).addWeightedBlockstate(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES.getDefaultState(), 1)).setMaxHeight(1).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALO_VERDE_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("palo_verde_tree2", BYGFeatures.PALO_VERDE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.PALO_VERDE_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.PALO_VERDE_LEAVES.getDefaultState(), 6).addWeightedBlockstate(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES.getDefaultState(), 1)).setMaxHeight(2).setMinHeight(1).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> RAINBOW_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("rainbow_eucalyptus_tree1", BYGFeatures.RAINBOW_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LOG).setLeavesBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES).setMaxHeight(32).setMinHeight(27).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> RAINBOW_LARGE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("large_rainbow_eucalyptus_tree1", BYGFeatures.RAINBOW_LARGE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LOG).setLeavesBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES).setMaxHeight(19).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> REDWOOD_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("redwood_tree1", BYGFeatures.REDWOOD_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.REDWOOD_LOG).setLeavesBlock(BYGBlocks.REDWOOD_LEAVES).setMaxHeight(37).setMinHeight(36).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> REDWOOD_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("redwood_tree2", BYGFeatures.REDWOOD_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.REDWOOD_LOG).setLeavesBlock(BYGBlocks.REDWOOD_LEAVES).setMaxHeight(34).setMinHeight(31).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> REDWOOD_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("redwood_tree3", BYGFeatures.REDWOOD_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.REDWOOD_LOG).setLeavesBlock(BYGBlocks.REDWOOD_LEAVES).setMaxHeight(25).setMinHeight(18).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> OAK_BROWN_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("brown_oak_tree1", BYGFeatures.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> OAK_ORANGE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("orange_oak_tree1", BYGFeatures.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> OAK_RED_TREE = WorldGenRegistrationHelper.createConfiguredFeature("red_oak_tree1", BYGFeatures.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(11).setMinHeight(8).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SHRUB = WorldGenRegistrationHelper.createConfiguredFeature("shrub", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SHRUB_MEADOW = WorldGenRegistrationHelper.createConfiguredFeature("meadow_shrub1", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SHRUB_MEADOW2 = WorldGenRegistrationHelper.createConfiguredFeature("meadow_shrub2", BYGFeatures.SHRUB2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SHRUB_PRAIRIE1 = WorldGenRegistrationHelper.createConfiguredFeature("prairie_shrub1", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SHRUB_PRAIRIE2 = WorldGenRegistrationHelper.createConfiguredFeature("prairie_shrub2", BYGFeatures.SHRUB2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(2).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SKYRIS_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("skyris_tree1", BYGFeatures.SKYRIS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(9).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SKYRIS_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("skyris_tree2", BYGFeatures.SKYRIS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(6).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SKYRIS_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("skyris_tree3", BYGFeatures.SKYRIS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(8).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SKYRIS_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("skyris_tree4", BYGFeatures.SKYRIS_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(8).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SKYRIS_TREE5 = WorldGenRegistrationHelper.createConfiguredFeature("skyris_tree5", BYGFeatures.SKYRIS_TREE5.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(8).setMinHeight(6).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_tree1", BYGFeatures.SPRUCE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_tree2", BYGFeatures.SPRUCE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_tree3", BYGFeatures.SPRUCE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(16).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_tree4", BYGFeatures.SPRUCE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(12).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE_MEDIUM1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(24).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE_MEDIUM2 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(25).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE_MEDIUM3 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(26).setMinHeight(21).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE_MEDIUM4 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(25).setMinHeight(19).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE_LARGE1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(55).setMinHeight(40).build()));

    //Yellow Spruce
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_yellow_tree1", BYGFeatures.SPRUCE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_yellow_tree2", BYGFeatures.SPRUCE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_yellow_tree3", BYGFeatures.SPRUCE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_yellow_tree4", BYGFeatures.SPRUCE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_yellow_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM2 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_yellow_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM3 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_yellow_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM4 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_yellow_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE_LARGE1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_yellow_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));

    //Orange Spruce
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_orange_tree1", BYGFeatures.SPRUCE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_orange_tree2", BYGFeatures.SPRUCE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_orange_tree3", BYGFeatures.SPRUCE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_orange_tree4", BYGFeatures.SPRUCE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_orange_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM2 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_orange_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM3 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_orange_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM4 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_orange_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE_LARGE1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_orange_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));

    //Red Spruce
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_red_tree1", BYGFeatures.SPRUCE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_red_tree2", BYGFeatures.SPRUCE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_red_tree3", BYGFeatures.SPRUCE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_red_tree4", BYGFeatures.SPRUCE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE_MEDIUM1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_red_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE_MEDIUM2 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_red_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE_MEDIUM3 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_red_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE_MEDIUM4 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_red_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE_LARGE1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_red_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));

    //Blue Spruce
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_blue_tree1", BYGFeatures.SPRUCE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_blue_tree2", BYGFeatures.SPRUCE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_blue_tree3", BYGFeatures.SPRUCE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_blue_tree4", BYGFeatures.SPRUCE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE_MEDIUM1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_blue_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE_MEDIUM2 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_blue_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE_MEDIUM3 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_blue_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE_MEDIUM4 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_blue_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE_LARGE1 = WorldGenRegistrationHelper.createConfiguredFeature("spruce_blue_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> TROPICAL_SHRUB1 = WorldGenRegistrationHelper.createConfiguredFeature("tropical_shrub1", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMinHeight(2).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAHOGANY_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("mahogany_tree1", BYGFeatures.MAHOGANY_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAHOGANY_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("mahogany_tree2", BYGFeatures.MAHOGANY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(14).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAHOGANY_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("mahogany_tree3", BYGFeatures.MAHOGANY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAHOGANY_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("mahogany_tree4", BYGFeatures.MAHOGANY_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(24).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAHOGANY_TREE5 = WorldGenRegistrationHelper.createConfiguredFeature("mahogany_tree5", BYGFeatures.MAHOGANY_TREE5.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(31).setMinHeight(25).build()));


    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WOODLANDS_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("woodlands_tree1", BYGFeatures.WOODLANDS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(5).setMinHeight(25).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_DEAD_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("dead_willow_tree1", BYGFeatures.WILLOW_DEAD_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_M_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("mutated_willow_tree1", BYGFeatures.WILLOW_M_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(11).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_M_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("mutated_willow_tree2", BYGFeatures.WILLOW_M_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("willow_tree1", BYGFeatures.WILLOW_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(14).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("willow_tree2", BYGFeatures.WILLOW_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("willow_tree3", BYGFeatures.WILLOW_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("willow_tree4", BYGFeatures.WILLOW_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(21).setMinHeight(13).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ZELKOVA_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("zelkova_tree1", BYGFeatures.ZELKOVA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES).setMaxHeight(20).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ZELKOVA_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("zelkova_tree2", BYGFeatures.ZELKOVA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES).setMaxHeight(28).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ZELKOVA_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("zelkova_tree3", BYGFeatures.ZELKOVA_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ZELKOVA_BROWN_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("zelkova_brown_tree1", BYGFeatures.ZELKOVA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES).setMaxHeight(21).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ZELKOVA_BROWN_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("zelkova_brown_tree2", BYGFeatures.ZELKOVA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES).setMaxHeight(20).setMinHeight(10).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ZELKOVA_BROWN_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("zelkova_brown_tree3", BYGFeatures.ZELKOVA_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES).setMaxHeight(30).setMinHeight(22).build()));


    //Vanilla Tree Features
    public static final ConfiguredFeature<?, ?> MC_TROPICAL_GROUND_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("mc_tropical_ground_bush", Feature.TREE.withConfiguration(BYGFeatureConfigs.TROPGROUNDBUSH_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_MEGA_TROPICAL_GROUND_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_mega_tropical_jungle_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.MEGATROPJUNGLETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_PINE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_blue_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.BLUEPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_SPRUCE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_blue_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.BLUESPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_PINE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_red_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_SPRUCE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_red_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDSPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_PINE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_yellow_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.YELLOWPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_SPRUCE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_yellow_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.YELLOWSPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_PINE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_orange_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGEPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_SPRUCE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_orange_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGESPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_MEGA_SPRUCE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_blue_mega_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.BLUEMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_MEGA_PINE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_blue_mega_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.BLUEMEGAPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_MEGA_SPRUCE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_red_mega_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_MEGA_PINE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_red_mega_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDMEGAPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_MEGA_SPRUCE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_yellow_mega_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.YELLOWMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_MEGA_PINE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_yellow_mega_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.YELLOWMEGAPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_MEGA_SPRUCE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_orange_mega_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGEMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_MEGA_PINE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_orange_mega_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGEMEGAPINETREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_BIRCH_RED_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_red_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_RED_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_tall_red_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.TALLREDBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_BROWN_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_brown_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.BROWNBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_BROWN_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_tall_brown_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.TALLBROWNBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_ORANGE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_orange_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGEBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_ORANGE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_tall_orange_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.TALLORANGEBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_YELLOW_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_yellow_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.YELLOWBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_YELLOW_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_tall_yellow_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.TALLYELLOWBIRCHTREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_BROWN_OAK_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_brown_oak_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.BROWNOAKTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_OAK_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_orange_oak_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGEOAKTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_OAK_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_red_oak_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDOAKTREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_DOVER_MEGA_SPRUCE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("mc_dover_mega_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.DOVERMEGASPRUCETREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_FANCY_RED_OAK_WITH_MORE_BEEHIVES = WorldGenRegistrationHelper.createConfiguredFeature("mc_fancy_red_oak_with_more_beehives_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.FANCY_RED_OAK_WITH_MORE_BEEHIVES_CONFIG));

    //Mushrooms
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> GREEN_MUSHROOM_HUGE = WorldGenRegistrationHelper.createConfiguredFeature("huge_green_mushroom", BYGFeatures.GREEN_MUSHROOM_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> WOOD_BLEWIT_HUGE = WorldGenRegistrationHelper.createConfiguredFeature("huge_wood_blewit", BYGFeatures.WOOD_BLEWIT_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> WEEPING_MILKCAP_HUGE = WorldGenRegistrationHelper.createConfiguredFeature("huge_weeping_milkcap", BYGFeatures.WEEPING_MILKCAP_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> BLACK_PUFF_HUGE = WorldGenRegistrationHelper.createConfiguredFeature("huge_black_puff", BYGFeatures.BLACK_PUFF_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> BLUE_GLOWSHROOM_HUGE = WorldGenRegistrationHelper.createConfiguredFeature("huge_blue_glowshroom", BYGFeatures.BLUE_GLOWSHROOM_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.YELLOW_GLOWSHROOM_STEM).setMushroomBlock(BYGBlocks.BLUE_GLOWSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> PURPLE_GLOWSHROOM_HUGE = WorldGenRegistrationHelper.createConfiguredFeature("huge_purple_glowshroom", BYGFeatures.PURPLE_GLOWSHROOM_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.RED_GLOWSHROOM_STEM).setMushroomBlock(BYGBlocks.PURPLE_GLOWSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    //Mini Mushrooms
    public static final ConfiguredFeature<?, ?> GREEN_MUSHROOM_MINI = WorldGenRegistrationHelper.createConfiguredFeature("mini_green_mushroom", BYGFeatures.MINI_GREEN_MUSHROOM.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK).setMinHeight(3).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> WOOD_BLEWIT_MINI = WorldGenRegistrationHelper.createConfiguredFeature("mini_wood_blewit", BYGFeatures.MINI_WOOD_BLEWIT.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> WEEPING_MILKCAP_MINI = WorldGenRegistrationHelper.createConfiguredFeature("mini_weeping_milkcap", BYGFeatures.MINI_WEEPING_MILKCAP.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> BLACK_PUFF_MINI = WorldGenRegistrationHelper.createConfiguredFeature("mini_black_puff", BYGFeatures.MINI_BLACK_PUFF.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.PUFF_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> RED_MUSHROOM_MINI = WorldGenRegistrationHelper.createConfiguredFeature("mini_red_mushroom", BYGFeatures.MINI_RED_MUSHROOM.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(Blocks.RED_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> BROWN_MUSHROOM_MINI = WorldGenRegistrationHelper.createConfiguredFeature("mini_brown_mushroom", BYGFeatures.MINI_BROWN_MUSHROOM.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(Blocks.BROWN_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));


    //Nether Mushrooms
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> EMBUR_MUSHROOM = WorldGenRegistrationHelper.createConfiguredFeature("embur_mushroom1", BYGFeatures.EMBUR_MUSHROOM.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> EMBUR_MUSHROOM2 = WorldGenRegistrationHelper.createConfiguredFeature("embur_mushroom2", BYGFeatures.EMBUR_MUSHROOM2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> CRIMSON_FUNGUS1 = WorldGenRegistrationHelper.createConfiguredFeature("crimson_fungus1", BYGFeatures.CRIMSON_FUNGUS_TREE1.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(Blocks.CRIMSON_STEM).setMushroomBlock(Blocks.NETHER_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> CRIMSON_FUNGUS2 = WorldGenRegistrationHelper.createConfiguredFeature("crimson_fungus2", BYGFeatures.CRIMSON_FUNGUS_TREE2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(Blocks.CRIMSON_STEM).setMushroomBlock(Blocks.NETHER_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> WARPED_FUNGUS1 = WorldGenRegistrationHelper.createConfiguredFeature("warped_fungus1", BYGFeatures.WARPED_FUNGUS_TREE1.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(Blocks.WARPED_STEM).setMushroomBlock(Blocks.WARPED_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> WARPED_FUNGUS2 = WorldGenRegistrationHelper.createConfiguredFeature("warped_fungus2", BYGFeatures.WARPED_FUNGUS_TREE2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(Blocks.WARPED_STEM).setMushroomBlock(Blocks.WARPED_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SYTHIAN_FUNGUS_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("sythian_fungus_tree1", BYGFeatures.SYTHIAN_FUNGUS_TREE1.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SYTHIAN_FUNGUS_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("sythian_fungus_tree2", BYGFeatures.SYTHIAN_FUNGUS_TREE2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SYTHIAN_FUNGUS_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("sythian_fungus_tree3", BYGFeatures.SYTHIAN_FUNGUS_TREE3.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SYTHIAN_FUNGUS_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("sythian_fungus_tree4", BYGFeatures.SYTHIAN_FUNGUS_TREE4.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SOUL_SHROOM_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("soul_shroom_tree1", BYGFeatures.SOUL_SHROOM_TREE1.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SOUL_SHROOM_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("soul_shroom_tree2", BYGFeatures.SOUL_SHROOM_TREE2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SOUL_SHROOM_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("soul_shroom_tree3", BYGFeatures.SOUL_SHROOM_TREE3.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> DEATH_CAP_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("death_cap_tree1", BYGFeatures.DEATH_CAP_TREE1.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> DEATH_CAP_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("death_cap_tree2", BYGFeatures.DEATH_CAP_TREE2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> DEATH_CAP_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("death_cap_tree3", BYGFeatures.DEATH_CAP_TREE3.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    //Nether Trees
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> LAMENT_TWISTY_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("lament_twisty_tree1", BYGFeatures.LAMENT_TWISTY_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> LAMENT_TWISTY_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("lament_twisty_tree2", BYGFeatures.LAMENT_TWISTY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> LAMENT_TWISTY_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("lament_twisty_tree3", BYGFeatures.LAMENT_TWISTY_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> LAMENT_WEEPING_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("lament_weeping_tree1", BYGFeatures.LAMENT_WEEPING_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> LAMENT_WEEPING_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("lament_weeping_tree2", BYGFeatures.LAMENT_WEEPING_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> LAMENT_WEEPING_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("lament_weeping_tree3", BYGFeatures.LAMENT_WEEPING_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WITHERING_OAK_TREE1 = WorldGenRegistrationHelper.createConfiguredFeature("withering_oak_tree1", BYGFeatures.WITHERING_OAK_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WITHERING_OAK_LOG).setLeavesBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WITHERING_OAK_TREE2 = WorldGenRegistrationHelper.createConfiguredFeature("withering_oak_tree2", BYGFeatures.WITHERING_OAK_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WITHERING_OAK_LOG).setLeavesBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WITHERING_OAK_TREE3 = WorldGenRegistrationHelper.createConfiguredFeature("withering_oak_tree3", BYGFeatures.WITHERING_OAK_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WITHERING_OAK_LOG).setLeavesBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WITHERING_OAK_TREE4 = WorldGenRegistrationHelper.createConfiguredFeature("withering_oak_tree4", BYGFeatures.WITHERING_OAK_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlocks.WITHERING_OAK_LOG).setLeavesBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));


    /***********************************************************Random Selectors***********************************************************/

    public static final ConfiguredFeature<?, ?> RANDOM_ANCIENT_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_ancient_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.DARK_OAK.withChance(0.3F),
            ANCIENT_TREE1.withChance(0.20F),
            ANCIENT_TREE2.withChance(0.20F)),
            ANCIENT_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(16, 0.4F, 8))));

    public static final ConfiguredFeature<?, ?> RANDOM_BAYOU_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_bayou_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WILLOW_DEAD_TREE1.withChance(0.1F),
            WILLOW_TREE1.withChance(0.25F),
            WILLOW_TREE2.withChance(0.25F),
            WILLOW_TREE3.withChance(0.25F)),
            WILLOW_TREE4)).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(
            new AtSurfaceWithExtraConfig(8, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CORAL_MANGROVE = WorldGenRegistrationHelper.createConfiguredFeature("rs_mg_coral", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Feature.CORAL_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.25F),
            Feature.CORAL_MUSHROOM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.25F)),
            Feature.CORAL_CLAW.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG))).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(
            new AtSurfaceWithExtraConfig(25, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUFF_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_bluff_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_TREE1.withChance(0.05F),
            PINE_TREE2.withChance(0.05F),
            BLUFF_TREE1.withChance(0.3F),
            BLUFF_TREE2.withChance(0.3F),
            BLUFF_TREE3.withChance(0.25F)),
            CONIFER_TREE6)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(12, 0.3F, -4))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_boreal", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BIRCH_YELLOW_BOREAL_TREE1.withChance(0.3F),
            BIRCH_BOREAL_TREE1.withChance(0.3F)),
            BOREAL_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(20, 0.5F, -4))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_SPARSE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_boreal", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BIRCH_YELLOW_BOREAL_TREE1.withChance(0.3F),
            BIRCH_BOREAL_TREE1.withChance(0.3F)),
            BOREAL_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_FOREST_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_black_forest", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE3.withChance(0.05F),
            ASPEN_TREE2.withChance(0.05F),
            CONIFER_TREE6.withChance(0.05F),
            CONIFER_TREE7.withChance(0.05F),
            PINE_LARGE_TREE1.withChance(0.5F),
            PINE_LARGE_TREE2.withChance(0.5F),
            PINE_TREE1.withChance(0.5F)),
            PINE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(30, 0.4F, -5))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_FOREST_SPARSE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_black_forest", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_LARGE_TREE1.withChance(0.45F),
            PINE_LARGE_TREE2.withChance(0.45F),
            PINE_TREE1.withChance(0.4F)),
            PINE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CIKA_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_cika_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CIKA_TREE2.withChance(0.2F),
            CIKA_TREE3.withChance(0.1F)),
            CIKA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_CONIFER_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_conifer_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CONIFER_TREE1.withChance(0.06F),
            CONIFER_TREE2.withChance(0.5F),
            CONIFER_TREE3.withChance(0.04F),
            CONIFER_TREE4.withChance(0.2F),
            CONIFER_TREE5.withChance(0.2F),
            CONIFER_TREE6.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F)),
            CONIFER_TREE8)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(30, 0.4F, 10))));

    public static final ConfiguredFeature<?, ?> RANDOM_CONIFER_SPARSE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_conifer_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CONIFER_TREE1.withChance(0.06F),
            CONIFER_TREE2.withChance(0.5F),
            CONIFER_TREE3.withChance(0.04F),
            CONIFER_TREE4.withChance(0.2F),
            CONIFER_TREE5.withChance(0.2F),
            CONIFER_TREE6.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F)),
            CONIFER_TREE8)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CRAG_GARDEN_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_crag_garden_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_TREE1.withChance(0.2F),
            RAINBOW_TREE1.withChance(0.2F),
            Features.BAMBOO.withChance(0.05F),
            RAINBOW_LARGE_TREE1.withChance(0.1F)),
            MAHOGANY_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(30, 0.4F, 8))));

    public static final ConfiguredFeature<?, ?> RANDOM_CYPRESS_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_cypress_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CYPRESS_TREE1.withChance(0.5F),
            CYPRESS_TREE2.withChance(0.4F)),
            CYPRESS_TREE3)).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(
            new AtSurfaceWithExtraConfig(5, 0.4F, 1))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_deciduous_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_TREE1.withChance(0.25F),
            DECIDUOUS_TREE2.withChance(0.25F),
            DECIDUOUS_TREE3.withChance(0.25F)),
            DECIDUOUS_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 3))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_RED_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_deciduous_red_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_RED_TREE1.withChance(0.25F),
            DECIDUOUS_RED_TREE2.withChance(0.25F),
            DECIDUOUS_RED_TREE3.withChance(0.25F)),
            DECIDUOUS_RED_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_ORANGE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_deciduous_orange_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_ORANGE_TREE1.withChance(0.25F),
            DECIDUOUS_ORANGE_TREE2.withChance(0.25F),
            DECIDUOUS_ORANGE_TREE3.withChance(0.25F)),
            DECIDUOUS_ORANGE_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_BROWN_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_deciduous_brown_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_BROWN_TREE1.withChance(0.25F),
            DECIDUOUS_BROWN_TREE2.withChance(0.25F),
            DECIDUOUS_BROWN_TREE3.withChance(0.25F)),
            DECIDUOUS_BROWN_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_SPARSE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_deciduous_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_TREE1.withChance(0.25F),
            DECIDUOUS_TREE2.withChance(0.25F),
            DECIDUOUS_TREE3.withChance(0.25F)),
            DECIDUOUS_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_DOVER_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_dover_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_LARGE_TREE1.withChance(0.25F),
            PINE_LARGE_TREE2.withChance(0.25F)),
            SPRUCE_TREE_LARGE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_EUCALYPTUS_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_eucalyptus_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_TREE1.withChance(0.1F)),
            RAINBOW_LARGE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(8, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_jacaranda", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            JACARANDA_TREE2.withChance(0.3F),
            INDIGO_JACARANDA_TREE2.withChance(0.3F),
            INDIGO_JACARANDA_TREE1.withChance(0.3F)),
            JACARANDA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(25, 0.1F, -5))));

    public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_SPARSE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_jacaranda", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            INDIGO_JACARANDA_TREE1.withChance(0.3F)),
            JACARANDA_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MAPLE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_maple", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MAPLE_RED_TREE1.withChance(0.4F),
            MAPLE_RED_TREE2.withChance(0.03F),
            MAPLE_SILVER_TREE1.withChance(0.2F),
            MAPLE_SILVER_TREE2.withChance(0.1F)),
            MAPLE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(5, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MAPLE_SPARSE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_maple", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MAPLE_TREE1.withChance(0.06F),
            MAPLE_RED_TREE1.withChance(0.5F),
            MAPLE_TREE1.withChance(0.04F),
            MAPLE_SILVER_TREE1.withChance(0.2F),
            MAPLE_SILVER_TREE2.withChance(0.1F)),
            MAPLE_RED_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_NORTHERN_FOREST_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_northern_forest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_TREE1.withChance(0.5F)),
            PINE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PRAIRIE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_prairie_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE1.withChance(0.4F),
            SHRUB_PRAIRIE2.withChance(0.4F),
            Features.FANCY_OAK_BEES_002.withChance(0.1F)),
            Features.FANCY_OAK)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_REDWOOD_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_redwood_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            REDWOOD_TREE1.withChance(0.55F),
            REDWOOD_TREE2.withChance(0.1F)),
            REDWOOD_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(5, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_REDWOOD_SPARSE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_redwood_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            REDWOOD_TREE1.withChance(0.55F),
            REDWOOD_TREE2.withChance(0.1F)),
            REDWOOD_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_SHRUB = WorldGenRegistrationHelper.createConfiguredFeature("rs_seasonal_shrub", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB.withChance(0.4F)),
            DECIDUOUS_SEASONAL_SHRUB)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(5, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_DECIDUOUS_SPARSE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_seasonal_deciduous_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_RED_TREE1.withChance(0.2F),
            DECIDUOUS_ORANGE_TREE1.withChance(0.2F),
            DECIDUOUS_SEASONAL_SHRUB.withChance(0.2F),
            DECIDUOUS_BROWN_TREE1.withChance(0.2F)),
            DECIDUOUS_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_TAIGA_MISC_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_seasonal_taiga_misc_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_TREE1.withChance(0.25F),
            PINE_TREE2.withChance(0.25F),
            ASPEN_TREE2.withChance(0.25F)),
            ASPEN_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_SEASONAL_TREE_GIANT = WorldGenRegistrationHelper.createConfiguredFeature("rs_spruce_seasonal_tree_giant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_RED_TREE_LARGE1.withChance(0.25F),
            SPRUCE_ORANGE_TREE_LARGE1.withChance(0.25F),
            SPRUCE_YELLOW_TREE_LARGE1.withChance(0.25F)),
            SPRUCE_TREE_LARGE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_spruce_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_TREE1.withChance(0.06F),
            SPRUCE_TREE2.withChance(0.5F),
            SPRUCE_TREE3.withChance(0.04F),
            SPRUCE_TREE4.withChance(0.2F),
            SPRUCE_TREE_MEDIUM1.withChance(0.2F),
            SPRUCE_TREE_MEDIUM2.withChance(0.2F),
            SPRUCE_TREE_MEDIUM3.withChance(0.2F),
            SPRUCE_TREE_MEDIUM4.withChance(0.1F)),
            SPRUCE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_YELLOW_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_spruce_yellow_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_YELLOW_TREE1.withChance(0.06F),
            SPRUCE_YELLOW_TREE2.withChance(0.5F),
            SPRUCE_YELLOW_TREE3.withChance(0.04F),
            SPRUCE_YELLOW_TREE4.withChance(0.2F),
            SPRUCE_YELLOW_TREE_MEDIUM1.withChance(0.2F),
            SPRUCE_YELLOW_TREE_MEDIUM2.withChance(0.2F),
            SPRUCE_YELLOW_TREE_MEDIUM3.withChance(0.2F),
            SPRUCE_YELLOW_TREE_MEDIUM4.withChance(0.1F)),
            SPRUCE_YELLOW_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_ORANGE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_spruce_orange_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_ORANGE_TREE1.withChance(0.06F),
            SPRUCE_ORANGE_TREE2.withChance(0.5F),
            SPRUCE_ORANGE_TREE3.withChance(0.04F),
            SPRUCE_ORANGE_TREE4.withChance(0.2F),
            SPRUCE_ORANGE_TREE_MEDIUM1.withChance(0.2F),
            SPRUCE_ORANGE_TREE_MEDIUM2.withChance(0.2F),
            SPRUCE_ORANGE_TREE_MEDIUM3.withChance(0.2F),
            SPRUCE_ORANGE_TREE_MEDIUM4.withChance(0.1F)),
            SPRUCE_ORANGE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_RED_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_spruce_red_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_RED_TREE1.withChance(0.06F),
            SPRUCE_RED_TREE2.withChance(0.5F),
            SPRUCE_RED_TREE3.withChance(0.04F),
            SPRUCE_RED_TREE4.withChance(0.2F),
            SPRUCE_RED_TREE_MEDIUM1.withChance(0.2F),
            SPRUCE_RED_TREE_MEDIUM2.withChance(0.2F),
            SPRUCE_RED_TREE_MEDIUM3.withChance(0.2F),
            SPRUCE_RED_TREE_MEDIUM4.withChance(0.1F)),
            SPRUCE_RED_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_BLUE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_spruce_blue_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_BLUE_TREE1.withChance(0.06F),
            SPRUCE_BLUE_TREE2.withChance(0.5F),
            SPRUCE_BLUE_TREE3.withChance(0.04F),
            SPRUCE_BLUE_TREE4.withChance(0.2F),
            SPRUCE_BLUE_TREE_MEDIUM1.withChance(0.2F),
            SPRUCE_BLUE_TREE_MEDIUM2.withChance(0.2F),
            SPRUCE_BLUE_TREE_MEDIUM3.withChance(0.2F),
            SPRUCE_BLUE_TREE_MEDIUM4.withChance(0.1F)),
            SPRUCE_BLUE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_BLUE_TREE_GIANT = WorldGenRegistrationHelper.createConfiguredFeature("rs_spruce_blue_tree_giant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_BLUE_TREE_LARGE1.withChance(0.5F)),
            SPRUCE_TREE_LARGE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_FUNGAL_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_fungal_rainforest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            MAHOGANY_TREE5.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            MAHOGANY_TREE2.withChance(0.2F),
            MAHOGANY_TREE3.withChance(0.2F),
            MAHOGANY_TREE4.withChance(0.15F)),
            MAHOGANY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(35, 0.1F, 10))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_SPARSE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_rainforest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            MAHOGANY_TREE5.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            MAHOGANY_TREE2.withChance(0.2F),
            MAHOGANY_TREE3.withChance(0.2F),
            MAHOGANY_TREE4.withChance(0.15F)),
            MAHOGANY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_rainforest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            MAHOGANY_TREE5.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            MAHOGANY_TREE2.withChance(0.2F),
            MAHOGANY_TREE3.withChance(0.2F),
            MAHOGANY_TREE4.withChance(0.15F)),
            MAHOGANY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(45, 0.1F, 10))));

    public static final ConfiguredFeature<?, ?> RANDOM_STONE_FOREST_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_stone_forest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EBONY_TREE1.withChance(0.1F),
            EBONY_TREE2.withChance(0.1F),
            Features.JUNGLE_BUSH.withChance(0.1F),
            DECIDUOUS_TREE1.withChance(0.1F)),
            DECIDUOUS_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(30, 0.3F, 8))));

    public static final ConfiguredFeature<?, ?> RANDOM_SKYRIS_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_skyris_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SKYRIS_TREE1.withChance(0.15F),
            SKYRIS_TREE5.withChance(0.25F),
            SKYRIS_TREE2.withChance(0.15F),
            SKYRIS_TREE3.withChance(0.25F)),
            SKYRIS_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(8, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BAOBAB_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_baobab_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.ACACIA.withChance(0.1F)),
            BAOBAB_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.3F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_ARAUCARIA_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_araucaria_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ARAUCARIA_TREE2.withChance(0.5F)),
            ARAUCARIA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ARAUCARIA_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_araucaria_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ARAUCARIA_TREE2.withChance(0.5F)),
            ARAUCARIA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_BROWN_ZELKOVA_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_brown_zelkova_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ZELKOVA_BROWN_TREE3.withChance(0.35F),
            ZELKOVA_BROWN_TREE2.withChance(0.35F)),
            ZELKOVA_BROWN_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MEADOW_SHRUB = WorldGenRegistrationHelper.createConfiguredFeature("rs_meadow_shrub", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_MEADOW.withChance(0.1F)),
            SHRUB_PRAIRIE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MEADOW_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_meadow_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MEADOW_TREE1.withChance(0.2F),
            MEADOW_TREE2.withChance(0.1F)),
            MEADOW_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(3, 0.5F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_GROVE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_grove_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BIRCH_YELLOW_BOREAL_TREE1.withChance(0.5F)),
            BIRCH_BOREAL_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ENCHANTED_GROVE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_enchanted_grove_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ENCHANTED_BLUE_GROVE_TREE1.withChance(0.5F)),
            ENCHANTED_GREEN_GROVE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_MARSH_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_marsh_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE2.withChance(0.2F),
            SHRUB_PRAIRIE1.withChance(0.1F)),
            Features.SWAMP_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(3, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ENCHANTED_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_enchanted_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ENCHANTED_BLUE_TREE2.withChance(0.2F),
            ENCHANTED_BLUE_TREE3.withChance(0.2F),
            ENCHANTED_GREEN_TREE1.withChance(0.2F),
            ENCHANTED_GREEN_TREE2.withChance(0.2F),
            ENCHANTED_GREEN_TREE3.withChance(0.1F)),
            ENCHANTED_BLUE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(20, 0.4F, -2))));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSHROOM_BAYOU_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_glowshroom_bayou_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WILLOW_DEAD_TREE1.withChance(0.2F),
            WILLOW_M_TREE1.withChance(0.2F),
            WILLOW_M_TREE2.withChance(0.2F),
            WILLOW_TREE3.withChance(0.2F),
            WILLOW_TREE4.withChance(0.2F),
            WILLOW_TREE2.withChance(0.1F)),
            WILLOW_TREE1)).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(
            new AtSurfaceWithExtraConfig(8, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_ASPEN_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_aspen_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE2.withChance(0.50F),
            ASPEN_TREE3.withChance(0.25F)),
            ASPEN_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(20, 0.5F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_ASPEN_SHRUB = WorldGenRegistrationHelper.createConfiguredFeature("rs_aspen_shrub", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_SHRUB1.withChance(0.1F)),
            ASPEN_SHRUB2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ASPEN_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_aspen_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE2.withChance(0.2F),
            ASPEN_TREE3.withChance(0.1F)),
            ASPEN_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ZELKOVA_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_zelkova_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ZELKOVA_TREE2.withChance(0.2F),
            ZELKOVA_TREE3.withChance(0.1F)),
            ZELKOVA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(20, 0.4F, -2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ZELKOVA_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_zelkova_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ZELKOVA_TREE2.withChance(0.2F),
            ZELKOVA_TREE3.withChance(0.1F)),
            ZELKOVA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PALO_VERDE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_palo_verde_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PALO_VERDE_TREE1.withChance(0.5F)),
            PALO_VERDE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_JOSHUA_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_joshua_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            JOSHUA_TREE1.withChance(0.5F)),
            JOSHUA_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SHRUB = WorldGenRegistrationHelper.createConfiguredFeature("rs_shrub", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE1.withChance(0.1F)),
            SHRUB_PRAIRIE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SHRUBLAND = WorldGenRegistrationHelper.createConfiguredFeature("rs_shrubland", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB.withChance(0.1F)),
            SHRUB)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PALM_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_palm_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PALM_TREE4.withChance(0.05F),
            PALM_TREE3.withChance(0.35F),
            PALM_TREE2.withChance(0.35F)),
            PALM_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CHERRY_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_cherry_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CHERRY_PINK_TREE1.withChance(0.2F),
            CHERRY_PINK_TREE2.withChance(0.2F),
            CHERRY_WHITE_TREE1.withChance(0.1F)),
            CHERRY_WHITE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(14, 0.4F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_CHERRY_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_cherry_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CHERRY_PINK_TREE1.withChance(0.2F),
            CHERRY_PINK_TREE2.withChance(0.2F),
            CHERRY_WHITE_TREE1.withChance(0.1F)),
            CHERRY_WHITE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_WITCH_HAZEL_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_witch_hazel_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEAD_HAZEL_TREE1.withChance(0.2F),
            DEAD_HAZEL_TREE2.withChance(0.2F),
            DEAD_HAZEL_TREE3.withChance(0.1F)),
            DEAD_HAZEL_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(14, 0.3F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_WITCH_HAZEL_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_witch_hazel_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEAD_HAZEL_TREE1.withChance(0.2F),
            DEAD_HAZEL_TREE2.withChance(0.2F),
            DEAD_HAZEL_TREE3.withChance(0.1F)),
            DEAD_HAZEL_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_EBONY_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_ebony_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EBONY_TREE1.withChance(0.2F),
            EBONY_TREE2.withChance(0.2F),
            EBONY_BUSH1.withChance(0.1F)),
            EBONY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(10, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_HOLLY_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_holly_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            HOLLY_TREE1.withChance(0.2F),
            HOLLY_TREE2.withChance(0.2F),
            HOLLY_TREE3.withChance(0.1F)),
            HOLLY_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(25, 0.4F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_HOLLY_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_holly_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            HOLLY_TREE1.withChance(0.2F),
            HOLLY_TREE2.withChance(0.2F),
            HOLLY_TREE3.withChance(0.1F)),
            HOLLY_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MANGROVE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_mangrove_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MANGROVE_TREE1.withChance(0.2F),
            MANGROVE_TREE2.withChance(0.2F),
            MANGROVE_TREE3.withChance(0.2F),
            MANGROVE_TREE4.withChance(0.1F)),
            MANGROVE_TREE5)).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(
            new AtSurfaceWithExtraConfig(15, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MANGROVE_SPARSE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_mangrove_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MANGROVE_TREE1.withChance(0.2F),
            MANGROVE_TREE2.withChance(0.2F),
            MANGROVE_TREE3.withChance(0.2F),
            MANGROVE_TREE4.withChance(0.1F)),
            MANGROVE_TREE5)).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(
            new AtSurfaceWithExtraConfig(0, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PINE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_pine_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_TREE2.withChance(0.2F),
            PINE_TREE1.withChance(0.2F),
            PINE_LARGE_TREE1.withChance(0.1F)),
            PINE_LARGE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(20, 0.4F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_ORCHARD_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_orchard_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ORCHARD_TREE1.withChance(0.3F),
            ORCHARD_TREE2.withChance(0.3F)),
            ORCHARD_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_WOODLAND_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_woodland_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WOODLANDS_TREE1.withChance(0.1F)),
            WOODLANDS_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_RED_OAK_FOREST_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_red_oak_forest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.OAK.withChance(0.1F),
            Features.OAK_BEES_002.withChance(0.1F),
            Features.FANCY_OAK_BEES_0002.withChance(0.1F),
            MC_FANCY_RED_OAK_WITH_MORE_BEEHIVES.withChance(0.2F)),
            MC_RED_OAK_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(8, 0.3F, 5))));


    public static final ConfiguredFeature<?, ?> RANDOM_RED_OAK_FOREST_SPARSE_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_red_oak_forest_sparse_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.OAK.withChance(0.06F),
            MC_RED_OAK_TREE.withChance(0.1F)),
            MC_FANCY_RED_OAK_WITH_MORE_BEEHIVES)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_BIRCH_FOREST_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_seasonal_birch_forest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BIRCH_BROWN_TREE1.withChance(0.06F),
            MC_BIRCH_BROWN_TREE.withChance(0.06F),
            MC_BIRCH_TALL_BROWN_TREE.withChance(0.06F),
            BIRCH_ORANGE_TREE1.withChance(0.06F),
            MC_BIRCH_ORANGE_TREE.withChance(0.06F),
            MC_BIRCH_TALL_ORANGE_TREE.withChance(0.06F),
            BIRCH_RED_TREE1.withChance(0.06F),
            MC_BIRCH_RED_TREE.withChance(0.06F),
            MC_BIRCH_TALL_RED_TREE.withChance(0.06F),
            BIRCH_YELLOW_TREE1.withChance(0.06F),
            MC_BIRCH_YELLOW_TREE.withChance(0.1F)),
            MC_BIRCH_TALL_YELLOW_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(15, 0.4F, -2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_FOREST_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_seasonal_forest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            OAK_BROWN_TREE1.withChance(0.06F),
            OAK_ORANGE_TREE.withChance(0.06F),
            OAK_RED_TREE.withChance(0.06F),
            MC_BROWN_OAK_TREE.withChance(0.06F),
            MC_FANCY_RED_OAK_WITH_MORE_BEEHIVES.withChance(0.06F),
            Features.FANCY_OAK.withChance(0.06F),
            Features.OAK.withChance(0.06F),
            MC_BIRCH_YELLOW_TREE.withChance(0.1F)),
            MC_ORANGE_OAK_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(15, 0.4F, -2))));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSHROOM = WorldGenRegistrationHelper.createConfiguredFeature("rs_huge_glowshroom", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_GLOWSHROOM_HUGE.withChance(0.1F)),
            PURPLE_GLOWSHROOM_HUGE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(25, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SOUL_SHROOM_TREES = WorldGenRegistrationHelper.createConfiguredFeature("rs_soul_shroom_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SOUL_SHROOM_TREE3.withChance(0.35F),
            SOUL_SHROOM_TREE2.withChance(0.35F)),
            SOUL_SHROOM_TREE1)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(8, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_DEATH_CAP_TREES = WorldGenRegistrationHelper.createConfiguredFeature("rs_death_cap_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEATH_CAP_TREE3.withChance(0.35F),
            DEATH_CAP_TREE2.withChance(0.35F)),
            DEATH_CAP_TREE1)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(8, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MINI_MUSHROOMS = WorldGenRegistrationHelper.createConfiguredFeature("rs_mini_mushrooms", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            GREEN_MUSHROOM_MINI.withChance(0.16F),
            RED_MUSHROOM_MINI.withChance(0.16F),
            BROWN_MUSHROOM_MINI.withChance(0.16F),
            WOOD_BLEWIT_MINI.withChance(0.16F),
            WEEPING_MILKCAP_MINI.withChance(0.16F)),
            BLACK_PUFF_MINI)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(7, 0.5F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_MUSHROOM = WorldGenRegistrationHelper.createConfiguredFeature("rs_huge_mushroom", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            GREEN_MUSHROOM_HUGE.withChance(0.4F),
            WOOD_BLEWIT_HUGE.withChance(0.4F),
            WEEPING_MILKCAP_HUGE.withChance(0.4F)),
            BLACK_PUFF_HUGE)).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(10, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_MUSHROOM = WorldGenRegistrationHelper.createConfiguredFeature("rs_embur_mushroom", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_MUSHROOM.withChance(0.5F)),
            EMBUR_MUSHROOM2)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(2, 0.5F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_FUNGUS = WorldGenRegistrationHelper.createConfiguredFeature("rs_fungus", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WARPED_FUNGUS1.withChance(0.15F),
            WARPED_FUNGUS2.withChance(0.15F),
            CRIMSON_FUNGUS1.withChance(0.4F)),
            CRIMSON_FUNGUS2)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(4, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SYTHIAN_FUNGUS = WorldGenRegistrationHelper.createConfiguredFeature("rs_sythian_fungus", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SYTHIAN_FUNGUS_TREE1.withChance(0.25F),
            SYTHIAN_FUNGUS_TREE2.withChance(0.25F),
            SYTHIAN_FUNGUS_TREE3.withChance(0.25F)),
            SYTHIAN_FUNGUS_TREE4)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(12, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_WITHERING_OAK_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_withering_oak_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WITHERING_OAK_TREE4.withChance(0.25F),
            WITHERING_OAK_TREE3.withChance(0.25F),
            WITHERING_OAK_TREE2.withChance(0.25F)),
            WITHERING_OAK_TREE1)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(12, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_WITHERING_OAK_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sparse_withering_oak_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WITHERING_OAK_TREE3.withChance(0.25F)),
            WITHERING_OAK_TREE1)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_TWISTY_LAMENT_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_twisty_lament_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            LAMENT_TWISTY_TREE3.withChance(0.35F),
            LAMENT_TWISTY_TREE2.withChance(0.35F)),
            LAMENT_TWISTY_TREE1)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(12, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_WEEPING_LAMENT_TREE = WorldGenRegistrationHelper.createConfiguredFeature("rs_weeping_lament_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            LAMENT_WEEPING_TREE3.withChance(0.35F),
            LAMENT_WEEPING_TREE2.withChance(0.35F)),
            LAMENT_WEEPING_TREE1)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(8, 0.5F, 2))));
}
