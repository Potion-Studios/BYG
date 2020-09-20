package voronoiaoc.byg.core.byglists;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatureConfigs;
import voronoiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.placements.AtOceanFloorWithExtra;
import voronoiaoc.byg.common.world.feature.placements.UnderGroundPlacement;

public class BYGConfiguredTreeFeatures {
    /***********************************************************Configured Features********************************************************/
//    public static final ConfiguredFeature<?, ?> ACACIA_TREE1 = newConfiguredFeature("acacia_tree1", BYGFeatureList.ACACIA_TREE1.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ANCIENT_TREE1 = newConfiguredFeature("ancient_tree1", BYGFeatureList.ANCIENT_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(25).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ANCIENT_TREE2 = newConfiguredFeature("ancient_tree2", BYGFeatureList.ANCIENT_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(25).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ANCIENT_TREE3 = newConfiguredFeature("ancient_tree3", BYGFeatureList.ANCIENT_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(25).setMinHeight(15).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ASPEN_SHRUB1 = newConfiguredFeature("aspen_shrub1", BYGFeatureList.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.ASPEN_LOG).setLeavesBlock(BYGBlockList.ASPEN_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ASPEN_SHRUB2 = newConfiguredFeature("aspen_shrub2", BYGFeatureList.SHRUB2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.ASPEN_LOG).setLeavesBlock(BYGBlockList.ASPEN_LEAVES).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ASPEN_TREE1 = newConfiguredFeature("aspen_tree1", BYGFeatureList.ASPEN_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.ASPEN_LOG).setLeavesBlock(BYGBlockList.ASPEN_LEAVES).setMaxHeight(10).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ASPEN_TREE2 = newConfiguredFeature("aspen_tree2", BYGFeatureList.ASPEN_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.ASPEN_LOG).setLeavesBlock(BYGBlockList.ASPEN_LEAVES).setMaxHeight(16).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ASPEN_TREE3 = newConfiguredFeature("aspen_tree3", BYGFeatureList.ASPEN_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.ASPEN_LOG).setLeavesBlock(BYGBlockList.ASPEN_LEAVES).setMaxHeight(16).setMinHeight(9).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BAOBAB_TREE1 = newConfiguredFeature("baobab_tree1", BYGFeatureList.BAOBAB_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.BAOBAB_LOG).setLeavesBlock(BYGBlockList.BAOBAB_LEAVES).setMaxHeight(28).setMinHeight(20).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BIRCH_BROWN_TREE1 = newConfiguredFeature("brown_birch_tree1", BYGFeatureList.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlockList.BROWN_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BIRCH_ORANGE_TREE1 = newConfiguredFeature("orange_birch_tree1", BYGFeatureList.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlockList.ORANGE_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BIRCH_RED_TREE1 = newConfiguredFeature("red_birch_tree1", BYGFeatureList.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlockList.RED_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BIRCH_YELLOW_TREE1 = newConfiguredFeature("yellow_birch_tree1", BYGFeatureList.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlockList.YELLOW_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(8).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BLUFF_TREE1 = newConfiguredFeature("bluff_tree1", BYGFeatureList.BLUFF_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(21).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BLUFF_TREE2 = newConfiguredFeature("bluff_tree2", BYGFeatureList.BLUFF_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BLUFF_TREE3 = newConfiguredFeature("bluff_tree3", BYGFeatureList.BLUFF_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BOREAL_TREE1 = newConfiguredFeature("boreal_tree1", BYGFeatureList.BOREAL_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> BOREAL_TREE2 = newConfiguredFeature("boreal_tree2", BYGFeatureList.BOREAL_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(15).setMinHeight(11).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CHERRY_PINK_TREE1 = newConfiguredFeature("pink_cherry_tree1", BYGFeatureList.CHERRY_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.CHERRY_LOG).setLeavesBlock(BYGBlockList.PINK_CHERRY_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CHERRY_PINK_TREE2 = newConfiguredFeature("pink_cherry_tree2", BYGFeatureList.CHERRY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.CHERRY_LOG).setLeavesBlock(BYGBlockList.PINK_CHERRY_LEAVES).setMaxHeight(13).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CHERRY_WHITE_TREE1 = newConfiguredFeature("white_cherry_tree1", BYGFeatureList.CHERRY_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.CHERRY_LOG).setLeavesBlock(BYGBlockList.WHITE_CHERRY_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CHERRY_WHITE_TREE2 = newConfiguredFeature("white_cherry_tree2", BYGFeatureList.CHERRY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.CHERRY_LOG).setLeavesBlock(BYGBlockList.WHITE_CHERRY_LEAVES).setMaxHeight(13).setMinHeight(8).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CIKA_TREE1 = newConfiguredFeature("cika_tree1", BYGFeatureList.CIKA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.CIKA_LOG).setLeavesBlock(BYGBlockList.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CIKA_TREE2 = newConfiguredFeature("cika_tree2", BYGFeatureList.CIKA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.CIKA_LOG).setLeavesBlock(BYGBlockList.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CIKA_TREE3 = newConfiguredFeature("cika_tree3", BYGFeatureList.CIKA_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.CIKA_LOG).setLeavesBlock(BYGBlockList.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE1 = newConfiguredFeature("conifer_tree1", BYGFeatureList.CONIFER_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.FIR_LOG).setLeavesBlock(BYGBlockList.FIR_LEAVES).setMaxHeight(25).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE2 = newConfiguredFeature("conifer_tree2", BYGFeatureList.CONIFER_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.FIR_LOG).setLeavesBlock(BYGBlockList.FIR_LEAVES).setMaxHeight(30).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE3 = newConfiguredFeature("conifer_tree3", BYGFeatureList.CONIFER_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.FIR_LOG).setLeavesBlock(BYGBlockList.FIR_LEAVES).setMaxHeight(35).setMinHeight(26).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE4 = newConfiguredFeature("conifer_tree4", BYGFeatureList.CONIFER_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.FIR_LOG).setLeavesBlock(BYGBlockList.FIR_LEAVES).setMaxHeight(35).setMinHeight(25).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE5 = newConfiguredFeature("conifer_tree5", BYGFeatureList.CONIFER_TREE5.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.FIR_LOG).setLeavesBlock(BYGBlockList.FIR_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE6 = newConfiguredFeature("conifer_tree6", BYGFeatureList.CONIFER_TREE6.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.FIR_LOG).setLeavesBlock(BYGBlockList.FIR_LEAVES).setMaxHeight(17).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE7 = newConfiguredFeature("conifer_tree7", BYGFeatureList.CONIFER_TREE7.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.FIR_LOG).setLeavesBlock(BYGBlockList.FIR_LEAVES).setMaxHeight(28).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CONIFER_TREE8 = newConfiguredFeature("conifer_tree8", BYGFeatureList.CONIFER_TREE8.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.FIR_LOG).setLeavesBlock(BYGBlockList.FIR_LEAVES).setMaxHeight(28).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CYPRESS_TREE1 = newConfiguredFeature("cypress_tree1", BYGFeatureList.CYPRESS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.CYPRESS_LOG).setLeavesBlock(BYGBlockList.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CYPRESS_TREE2 = newConfiguredFeature("cypress_tree2", BYGFeatureList.CYPRESS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.CYPRESS_LOG).setLeavesBlock(BYGBlockList.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> CYPRESS_TREE3 = newConfiguredFeature("cypress_tree3", BYGFeatureList.CYPRESS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.CYPRESS_LOG).setLeavesBlock(BYGBlockList.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DEAD_HAZEL_TREE1 = newConfiguredFeature("dead_hazel_tree1", BYGFeatureList.DEAD_HAZEL_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(15).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DEAD_HAZEL_TREE2 = newConfiguredFeature("dead_hazel_tree2", BYGFeatureList.DEAD_HAZEL_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DEAD_HAZEL_TREE3 = newConfiguredFeature("dead_hazel_tree3", BYGFeatureList.DEAD_HAZEL_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(16).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DEAD_HAZEL_TREE4 = newConfiguredFeature("dead_hazel_tree4", BYGFeatureList.DEAD_HAZEL_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(7).setMinHeight(5).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_SEASONAL_SHRUB = newConfiguredFeature("seasonal_deciduous_shrub", BYGFeatureList.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlockList.RED_OAK_LEAVES).setMinHeight(2).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_TREE1 = newConfiguredFeature("deciduous_tree1", BYGFeatureList.DECIDUOUS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(19).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_TREE2 = newConfiguredFeature("deciduous_tree2", BYGFeatureList.DECIDUOUS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(22).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_TREE3 = newConfiguredFeature("deciduous_tree3", BYGFeatureList.DECIDUOUS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(21).setMinHeight(16).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_TREE4 = newConfiguredFeature("deciduous_tree4", BYGFeatureList.DECIDUOUS_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_RED_TREE1 = newConfiguredFeature("deciduous_red_tree1", BYGFeatureList.DECIDUOUS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlockList.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_RED_TREE2 = newConfiguredFeature("deciduous_red_tree2", BYGFeatureList.DECIDUOUS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlockList.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_RED_TREE3 = newConfiguredFeature("deciduous_red_tree3", BYGFeatureList.DECIDUOUS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlockList.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_RED_TREE4 = newConfiguredFeature("deciduous_red_tree4", BYGFeatureList.DECIDUOUS_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlockList.RED_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_ORANGE_TREE1 = newConfiguredFeature("deciduous_orange_tree1", BYGFeatureList.DECIDUOUS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlockList.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_ORANGE_TREE2 = newConfiguredFeature("deciduous_orange_tree2", BYGFeatureList.DECIDUOUS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlockList.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_ORANGE_TREE3 = newConfiguredFeature("deciduous_orange_tree3", BYGFeatureList.DECIDUOUS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlockList.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_ORANGE_TREE4 = newConfiguredFeature("deciduous_orange_tree4", BYGFeatureList.DECIDUOUS_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlockList.ORANGE_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_BROWN_TREE1 = newConfiguredFeature("deciduous_brown_tree1", BYGFeatureList.DECIDUOUS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlockList.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_BROWN_TREE2 = newConfiguredFeature("deciduous_brown_tree2", BYGFeatureList.DECIDUOUS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlockList.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_BROWN_TREE3 = newConfiguredFeature("deciduous_brown_tree3", BYGFeatureList.DECIDUOUS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlockList.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> DECIDUOUS_BROWN_TREE4 = newConfiguredFeature("deciduous_brown_tree4", BYGFeatureList.DECIDUOUS_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlockList.BROWN_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> EBONY_BUSH1 = newConfiguredFeature("ebony_bush1", BYGFeatureList.EBONY_BUSH1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.EBONY_LOG).setLeavesBlock(BYGBlockList.EBONY_LEAVES).setMaxHeight(28).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> EBONY_TREE1 = newConfiguredFeature("ebony_tree1", BYGFeatureList.EBONY_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.EBONY_LOG).setLeavesBlock(BYGBlockList.EBONY_LEAVES).setMaxHeight(13).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> EBONY_TREE2 = newConfiguredFeature("ebony_tree2", BYGFeatureList.EBONY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.EBONY_LOG).setLeavesBlock(BYGBlockList.EBONY_LEAVES).setMaxHeight(17).setMinHeight(11).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_BLUE_TREE1 = newConfiguredFeature("blue_enchanted_tree1", BYGFeatureList.ENCHANTED_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlockList.BLUE_ENCHANTED_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_BLUE_TREE2 = newConfiguredFeature("blue_enchanted_tree2", BYGFeatureList.ENCHANTED_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlockList.BLUE_ENCHANTED_LEAVES).setMaxHeight(26).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_BLUE_TREE3 = newConfiguredFeature("blue_enchanted_tree3", BYGFeatureList.ENCHANTED_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlockList.BLUE_ENCHANTED_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_GREEN_TREE1 = newConfiguredFeature("green_enchanted_tree1", BYGFeatureList.ENCHANTED_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(ENCHANTED_BLUE_TREE1.config).setTrunkBlock(BYGBlockList.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlockList.GREEN_ENCHANTED_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_GREEN_TREE2 = newConfiguredFeature("green_enchanted_tree2", BYGFeatureList.ENCHANTED_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(ENCHANTED_BLUE_TREE2.config).setTrunkBlock(BYGBlockList.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlockList.GREEN_ENCHANTED_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_GREEN_TREE3 = newConfiguredFeature("green_enchanted_tree3", BYGFeatureList.ENCHANTED_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(ENCHANTED_BLUE_TREE3.config).setTrunkBlock(BYGBlockList.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlockList.GREEN_ENCHANTED_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_BLUE_GROVE_TREE1 = newConfiguredFeature("blue_enchanted_grove_tree1", BYGFeatureList.ENCHANTED_GROVE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlockList.BLUE_ENCHANTED_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ENCHANTED_GREEN_GROVE_TREE1 = newConfiguredFeature("green_enchanted_grove_tree1", BYGFeatureList.ENCHANTED_GROVE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(ENCHANTED_BLUE_TREE1.config).setTrunkBlock(BYGBlockList.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlockList.GREEN_ENCHANTED_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> HOLLY_TREE1 = newConfiguredFeature("holly_tree1", BYGFeatureList.HOLLY_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(23).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> HOLLY_TREE2 = newConfiguredFeature("holly_tree2", BYGFeatureList.HOLLY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(15).setMinHeight(10).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> HOLLY_TREE3 = newConfiguredFeature("holly_tree3", BYGFeatureList.HOLLY_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(25).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> HOLLY_TREE4 = newConfiguredFeature("holly_tree4", BYGFeatureList.HOLLY_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(14).setMinHeight(9).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> JACARANDA_TREE1 = newConfiguredFeature("jacaranda_tree1", BYGFeatureList.JACARANDA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.JACARANDA_LOG).setLeavesBlock(BYGBlockList.JACARANDA_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> JACARANDA_TREE2 = newConfiguredFeature("jacaranda_tree2", BYGFeatureList.JACARANDA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.JACARANDA_LOG).setLeavesBlock(BYGBlockList.JACARANDA_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> INDIGO_JACARANDA_TREE1 = newConfiguredFeature("indigo_jacaranda_tree1", BYGFeatureList.JACARANDA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(JACARANDA_TREE1.config).setLeavesBlock(BYGBlockList.INDIGO_JACARANDA_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> INDIGO_JACARANDA_TREE2 = newConfiguredFeature("indigo_jacaranda_tree2", BYGFeatureList.JACARANDA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(JACARANDA_TREE2.config).setLeavesBlock(BYGBlockList.INDIGO_JACARANDA_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> JOSHUA_TREE1 = newConfiguredFeature("joshua_tree1", BYGFeatureList.JOSHUA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlockList.JOSHUA_LEAVES).setMaxHeight(6).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> JOSHUA_TREE2 = newConfiguredFeature("joshua_tree2", BYGFeatureList.JOSHUA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlockList.JOSHUA_LEAVES).setMaxHeight(6).setMinHeight(3).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MANGROVE_TREE1 = newConfiguredFeature("mangrove_tree1", BYGFeatureList.MANGROVE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MANGROVE_LOG).setLeavesBlock(BYGBlockList.MANGROVE_LEAVES).setMaxHeight(15).setMinHeight(10).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MANGROVE_TREE2 = newConfiguredFeature("mangrove_tree2", BYGFeatureList.MANGROVE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MANGROVE_LOG).setLeavesBlock(BYGBlockList.MANGROVE_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MANGROVE_TREE3 = newConfiguredFeature("mangrove_tree3", BYGFeatureList.MANGROVE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MANGROVE_LOG).setLeavesBlock(BYGBlockList.MANGROVE_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MANGROVE_TREE4 = newConfiguredFeature("mangrove_tree4", BYGFeatureList.MANGROVE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MANGROVE_LOG).setLeavesBlock(BYGBlockList.MANGROVE_LEAVES).setMaxHeight(10).setMinHeight(5).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MANGROVE_TREE5 = newConfiguredFeature("mangrove_tree5", BYGFeatureList.MANGROVE_TREE5.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MANGROVE_LOG).setLeavesBlock(BYGBlockList.MANGROVE_LEAVES).setMaxHeight(11).setMinHeight(6).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAPLE_RED_TREE1 = newConfiguredFeature("red_maple_tree1", BYGFeatureList.MAPLE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MAPLE_LOG).setLeavesBlock(BYGBlockList.RED_MAPLE_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAPLE_RED_TREE2 = newConfiguredFeature("red_maple_tree2", BYGFeatureList.MAPLE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MAPLE_LOG).setLeavesBlock(BYGBlockList.RED_MAPLE_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAPLE_SILVER_TREE1 = newConfiguredFeature("silver_maple_tree1", BYGFeatureList.MAPLE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(MAPLE_RED_TREE1.config).setLeavesBlock(BYGBlockList.SILVER_MAPLE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAPLE_SILVER_TREE2 = newConfiguredFeature("silver_maple_tree2", BYGFeatureList.MAPLE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(MAPLE_RED_TREE2.config).setLeavesBlock(BYGBlockList.SILVER_MAPLE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAPLE_TREE1 = newConfiguredFeature("maple_tree1", BYGFeatureList.MAPLE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MAPLE_LOG).setLeavesBlock(BYGBlockList.MAPLE_LEAVES).setMaxHeight(10).setMinHeight(5).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MEADOW_TREE1 = newConfiguredFeature("meadow_tree1", BYGFeatureList.MEADOW_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MEADOW_TREE2 = newConfiguredFeature("meadow_tree2", BYGFeatureList.MEADOW_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MEADOW_TREE3 = newConfiguredFeature("meadow_tree3", BYGFeatureList.MEADOW_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ORCHARD_TREE1 = newConfiguredFeature("orchard_tree1", BYGFeatureList.ORCHARD_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.ORCHARD_LEAVES.getDefaultState(), 10).addWeightedBlockstate(BYGBlockList.FLOWERING_ORCHARD_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.RIPE_ORCHARD_LEAVES.getDefaultState(), 1)).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ORCHARD_TREE2 = newConfiguredFeature("orchard_tree2", BYGFeatureList.ORCHARD_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.ORCHARD_LEAVES.getDefaultState(), 10).addWeightedBlockstate(BYGBlockList.FLOWERING_ORCHARD_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.RIPE_ORCHARD_LEAVES.getDefaultState(), 1)).setMaxHeight(26).setMinHeight(21).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ORCHARD_TREE3 = newConfiguredFeature("orchard_tree3", BYGFeatureList.ORCHARD_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.ORCHARD_LEAVES.getDefaultState(), 10).addWeightedBlockstate(BYGBlockList.FLOWERING_ORCHARD_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.RIPE_ORCHARD_LEAVES.getDefaultState(), 1)).setMaxHeight(9).setMinHeight(14).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALM_TREE1 = newConfiguredFeature("palm_tree1", BYGFeatureList.PALM_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.PALM_LOG).setLeavesBlock(BYGBlockList.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALM_TREE2 = newConfiguredFeature("palm_tree2", BYGFeatureList.PALM_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.PALM_LOG).setLeavesBlock(BYGBlockList.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALM_TREE3 = newConfiguredFeature("palm_tree3", BYGFeatureList.PALM_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.PALM_LOG).setLeavesBlock(BYGBlockList.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALM_TREE4 = newConfiguredFeature("palm_tree4", BYGFeatureList.PALM_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.PALM_LOG).setLeavesBlock(BYGBlockList.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PINE_LARGE_TREE1 = newConfiguredFeature("large_pine_tree1", BYGFeatureList.PINE_LARGE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.PINE_LOG).setLeavesBlock(BYGBlockList.PINE_LEAVES).setMaxHeight(28).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PINE_LARGE_TREE2 = newConfiguredFeature("large_pine_tree2", BYGFeatureList.PINE_LARGE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.PINE_LOG).setLeavesBlock(BYGBlockList.PINE_LEAVES).setMaxHeight(31).setMinHeight(26).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PINE_TREE1 = newConfiguredFeature("pine_tree1", BYGFeatureList.PINE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.PINE_LOG).setLeavesBlock(BYGBlockList.PINE_LEAVES).setMaxHeight(20).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PINE_TREE2 = newConfiguredFeature("pine_tree2", BYGFeatureList.PINE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.PINE_LOG).setLeavesBlock(BYGBlockList.PINE_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALO_VERDE_TREE1 = newConfiguredFeature("palo_verde_tree1", BYGFeatureList.PALO_VERDE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.PALO_VERDE_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.PALO_VERDE_LEAVES.getDefaultState(), 6).addWeightedBlockstate(BYGBlockList.FLOWERING_PALO_VERDE_LEAVES.getDefaultState(), 1)).setMaxHeight(1).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> PALO_VERDE_TREE2 = newConfiguredFeature("palo_verde_tree2", BYGFeatureList.PALO_VERDE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.PALO_VERDE_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.PALO_VERDE_LEAVES.getDefaultState(), 6).addWeightedBlockstate(BYGBlockList.FLOWERING_PALO_VERDE_LEAVES.getDefaultState(), 1)).setMaxHeight(2).setMinHeight(1).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> RAINBOW_TREE1 = newConfiguredFeature("rainbow_eucalyptus_tree1", BYGFeatureList.RAINBOW_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.RAINBOW_EUCALYPTUS_LOG).setLeavesBlock(BYGBlockList.RAINBOW_EUCALYPTUS_LEAVES).setMaxHeight(32).setMinHeight(27).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> RAINBOW_LARGE_TREE1 = newConfiguredFeature("large_rainbow_eucalyptus_tree1", BYGFeatureList.RAINBOW_LARGE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.RAINBOW_EUCALYPTUS_LOG).setLeavesBlock(BYGBlockList.RAINBOW_EUCALYPTUS_LEAVES).setMaxHeight(19).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> REDWOOD_TREE1 = newConfiguredFeature("redwood_tree1", BYGFeatureList.REDWOOD_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.REDWOOD_LOG).setLeavesBlock(BYGBlockList.REDWOOD_LEAVES).setMaxHeight(37).setMinHeight(36).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> REDWOOD_TREE2 = newConfiguredFeature("redwood_tree2", BYGFeatureList.REDWOOD_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.REDWOOD_LOG).setLeavesBlock(BYGBlockList.REDWOOD_LEAVES).setMaxHeight(34).setMinHeight(31).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> REDWOOD_TREE3 = newConfiguredFeature("redwood_tree3", BYGFeatureList.REDWOOD_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.REDWOOD_LOG).setLeavesBlock(BYGBlockList.REDWOOD_LEAVES).setMaxHeight(25).setMinHeight(18).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> OAK_BROWN_TREE1 = newConfiguredFeature("brown_oak_tree1", BYGFeatureList.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlockList.BROWN_OAK_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> OAK_ORANGE_TREE = newConfiguredFeature("orange_oak_tree1", BYGFeatureList.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlockList.ORANGE_OAK_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> OAK_RED_TREE = newConfiguredFeature("red_oak_tree1", BYGFeatureList.BASIC_TREE.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlockList.RED_OAK_LEAVES).setMaxHeight(11).setMinHeight(8).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SHRUB = newConfiguredFeature("shrub", BYGFeatureList.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SHRUB_MEADOW = newConfiguredFeature("meadow_shrub1", BYGFeatureList.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SHRUB_MEADOW2 = newConfiguredFeature("meadow_shrub2", BYGFeatureList.SHRUB2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SHRUB_PRAIRIE1 = newConfiguredFeature("prairie_shrub1", BYGFeatureList.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SHRUB_PRAIRIE2 = newConfiguredFeature("prairie_shrub2", BYGFeatureList.SHRUB2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(2).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SKYRIS_TREE1 = newConfiguredFeature("skyris_tree1", BYGFeatureList.SKYRIS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(9).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SKYRIS_TREE2 = newConfiguredFeature("skyris_tree2", BYGFeatureList.SKYRIS_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(6).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SKYRIS_TREE3 = newConfiguredFeature("skyris_tree3", BYGFeatureList.SKYRIS_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(8).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SKYRIS_TREE4 = newConfiguredFeature("skyris_tree4", BYGFeatureList.SKYRIS_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(8).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SKYRIS_TREE5 = newConfiguredFeature("skyris_tree5", BYGFeatureList.SKYRIS_TREE5.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlockList.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(8).setMinHeight(6).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE1 = newConfiguredFeature("spruce_tree1", BYGFeatureList.SPRUCE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE2 = newConfiguredFeature("spruce_tree2", BYGFeatureList.SPRUCE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE3 = newConfiguredFeature("spruce_tree3", BYGFeatureList.SPRUCE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(16).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE4 = newConfiguredFeature("spruce_tree4", BYGFeatureList.SPRUCE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(12).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE_MEDIUM1 = newConfiguredFeature("spruce_tree_medium1", BYGFeatureList.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(24).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE_MEDIUM2 = newConfiguredFeature("spruce_tree_medium2", BYGFeatureList.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(25).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE_MEDIUM3 = newConfiguredFeature("spruce_tree_medium3", BYGFeatureList.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(26).setMinHeight(21).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE_MEDIUM4 = newConfiguredFeature("spruce_tree_medium4", BYGFeatureList.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(25).setMinHeight(19).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_TREE_LARGE1 = newConfiguredFeature("spruce_tree_large1", BYGFeatureList.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(55).setMinHeight(40).build()));

    //Yellow Spruce
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE1 = newConfiguredFeature("spruce_yellow_tree1", BYGFeatureList.SPRUCE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlockList.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE2 = newConfiguredFeature("spruce_yellow_tree2", BYGFeatureList.SPRUCE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlockList.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE3 = newConfiguredFeature("spruce_yellow_tree3", BYGFeatureList.SPRUCE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlockList.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE4 = newConfiguredFeature("spruce_yellow_tree4", BYGFeatureList.SPRUCE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlockList.YELLOW_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM1 = newConfiguredFeature("spruce_yellow_tree_medium1", BYGFeatureList.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlockList.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM2 = newConfiguredFeature("spruce_yellow_tree_medium2", BYGFeatureList.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlockList.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM3 = newConfiguredFeature("spruce_yellow_tree_medium3", BYGFeatureList.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlockList.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM4 = newConfiguredFeature("spruce_yellow_tree_medium4", BYGFeatureList.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlockList.YELLOW_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_YELLOW_TREE_LARGE1 = newConfiguredFeature("spruce_yellow_tree_large1", BYGFeatureList.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlockList.YELLOW_SPRUCE_LEAVES).build()));

    //Orange Spruce
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE1 = newConfiguredFeature("spruce_orange_tree1", BYGFeatureList.SPRUCE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlockList.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE2 = newConfiguredFeature("spruce_orange_tree2", BYGFeatureList.SPRUCE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlockList.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE3 = newConfiguredFeature("spruce_orange_tree3", BYGFeatureList.SPRUCE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlockList.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE4 = newConfiguredFeature("spruce_orange_tree4", BYGFeatureList.SPRUCE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlockList.ORANGE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM1 = newConfiguredFeature("spruce_orange_tree_medium1", BYGFeatureList.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlockList.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM2 = newConfiguredFeature("spruce_orange_tree_medium2", BYGFeatureList.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlockList.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM3 = newConfiguredFeature("spruce_orange_tree_medium3", BYGFeatureList.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlockList.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM4 = newConfiguredFeature("spruce_orange_tree_medium4", BYGFeatureList.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlockList.ORANGE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_ORANGE_TREE_LARGE1 = newConfiguredFeature("spruce_orange_tree_large1", BYGFeatureList.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlockList.ORANGE_SPRUCE_LEAVES).build()));

    //Red Spruce
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE1 = newConfiguredFeature("spruce_red_tree1", BYGFeatureList.SPRUCE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlockList.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE2 = newConfiguredFeature("spruce_red_tree2", BYGFeatureList.SPRUCE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlockList.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE3 = newConfiguredFeature("spruce_red_tree3", BYGFeatureList.SPRUCE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlockList.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE4 = newConfiguredFeature("spruce_red_tree4", BYGFeatureList.SPRUCE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlockList.RED_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE_MEDIUM1 = newConfiguredFeature("spruce_red_tree_medium1", BYGFeatureList.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlockList.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE_MEDIUM2 = newConfiguredFeature("spruce_red_tree_medium2", BYGFeatureList.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlockList.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE_MEDIUM3 = newConfiguredFeature("spruce_red_tree_medium3", BYGFeatureList.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlockList.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE_MEDIUM4 = newConfiguredFeature("spruce_red_tree_medium4", BYGFeatureList.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlockList.RED_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_RED_TREE_LARGE1 = newConfiguredFeature("spruce_red_tree_large1", BYGFeatureList.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlockList.RED_SPRUCE_LEAVES).build()));

    //Blue Spruce
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE1 = newConfiguredFeature("spruce_blue_tree1", BYGFeatureList.SPRUCE_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlockList.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE2 = newConfiguredFeature("spruce_blue_tree2", BYGFeatureList.SPRUCE_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlockList.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE3 = newConfiguredFeature("spruce_blue_tree3", BYGFeatureList.SPRUCE_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlockList.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE4 = newConfiguredFeature("spruce_blue_tree4", BYGFeatureList.SPRUCE_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlockList.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE_MEDIUM1 = newConfiguredFeature("spruce_blue_tree_medium1", BYGFeatureList.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlockList.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE_MEDIUM2 = newConfiguredFeature("spruce_blue_tree_medium2", BYGFeatureList.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlockList.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE_MEDIUM3 = newConfiguredFeature("spruce_blue_tree_medium3", BYGFeatureList.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlockList.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE_MEDIUM4 = newConfiguredFeature("spruce_blue_tree_medium4", BYGFeatureList.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlockList.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> SPRUCE_BLUE_TREE_LARGE1 = newConfiguredFeature("spruce_blue_tree_large1", BYGFeatureList.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeFeatureConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlockList.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> TROPICAL_SHRUB1 = newConfiguredFeature("tropical_shrub1", BYGFeatureList.SHRUB1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MAHOGANY_LOG).setLeavesBlock(BYGBlockList.MAHOGANY_LEAVES).setMinHeight(2).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAHOGANY_TREE1 = newConfiguredFeature("mahogany_tree1", BYGFeatureList.MAHOGANY_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MAHOGANY_LOG).setLeavesBlock(BYGBlockList.MAHOGANY_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAHOGANY_TREE2 = newConfiguredFeature("mahogany_tree2", BYGFeatureList.MAHOGANY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MAHOGANY_LOG).setLeavesBlock(BYGBlockList.MAHOGANY_LEAVES).setMaxHeight(14).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAHOGANY_TREE3 = newConfiguredFeature("mahogany_tree3", BYGFeatureList.MAHOGANY_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MAHOGANY_LOG).setLeavesBlock(BYGBlockList.MAHOGANY_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAHOGANY_TREE4 = newConfiguredFeature("mahogany_tree4", BYGFeatureList.MAHOGANY_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MAHOGANY_LOG).setLeavesBlock(BYGBlockList.MAHOGANY_LEAVES).setMaxHeight(24).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> MAHOGANY_TREE5 = newConfiguredFeature("mahogany_tree5", BYGFeatureList.MAHOGANY_TREE5.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.MAHOGANY_LOG).setLeavesBlock(BYGBlockList.MAHOGANY_LEAVES).setMaxHeight(31).setMinHeight(25).build()));


    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WOODLANDS_TREE1 = newConfiguredFeature("woodlands_tree1", BYGFeatureList.WOODLANDS_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(5).setMinHeight(25).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_DEAD_TREE1 = newConfiguredFeature("dead_willow_tree1", BYGFeatureList.WILLOW_DEAD_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.WILLOW_LOG).setLeavesBlock(BYGBlockList.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_M_TREE1 = newConfiguredFeature("mutated_willow_tree1", BYGFeatureList.WILLOW_M_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.WILLOW_LOG).setLeavesBlock(BYGBlockList.WILLOW_LEAVES).setMaxHeight(11).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_M_TREE2 = newConfiguredFeature("mutated_willow_tree2", BYGFeatureList.WILLOW_M_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.WILLOW_LOG).setLeavesBlock(BYGBlockList.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_TREE1 = newConfiguredFeature("willow_tree1", BYGFeatureList.WILLOW_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.WILLOW_LOG).setLeavesBlock(BYGBlockList.WILLOW_LEAVES).setMaxHeight(14).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_TREE2 = newConfiguredFeature("willow_tree2", BYGFeatureList.WILLOW_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.WILLOW_LOG).setLeavesBlock(BYGBlockList.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_TREE3 = newConfiguredFeature("willow_tree3", BYGFeatureList.WILLOW_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.WILLOW_LOG).setLeavesBlock(BYGBlockList.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> WILLOW_TREE4 = newConfiguredFeature("willow_tree4", BYGFeatureList.WILLOW_TREE4.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.WILLOW_LOG).setLeavesBlock(BYGBlockList.WILLOW_LEAVES).setMaxHeight(21).setMinHeight(13).build()));

    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ZELKOVA_TREE1 = newConfiguredFeature("zelkova_tree1", BYGFeatureList.ZELKOVA_TREE1.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.ZELKOVA_LOG).setLeavesBlock(BYGBlockList.ZELKOVA_LEAVES).setMaxHeight(20).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ZELKOVA_TREE2 = newConfiguredFeature("zelkova_tree2", BYGFeatureList.ZELKOVA_TREE2.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.ZELKOVA_LOG).setLeavesBlock(BYGBlockList.ZELKOVA_LEAVES).setMaxHeight(28).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeFeatureConfig, ?> ZELKOVA_TREE3 = newConfiguredFeature("zelkova_tree3", BYGFeatureList.ZELKOVA_TREE3.withConfiguration(new BYGTreeFeatureConfig.Builder().setTrunkBlock(BYGBlockList.ZELKOVA_LOG).setLeavesBlock(BYGBlockList.ZELKOVA_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    //Vanilla Tree Features
    public static final ConfiguredFeature<?, ?> MC_TROPICAL_GROUND_BUSH = newConfiguredFeature("mc_tropical_ground_bush", Feature.TREE.withConfiguration(BYGFeatureConfigs.TROPGROUNDBUSH_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_MEGA_TROPICAL_GROUND_TREE = newConfiguredFeature("mc_mega_tropical_jungle_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.MEGATROPJUNGLETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_PINE_TREE = newConfiguredFeature("mc_blue_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.BLUEPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_SPRUCE_TREE = newConfiguredFeature("mc_blue_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.BLUESPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_PINE_TREE = newConfiguredFeature("mc_red_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_SPRUCE_TREE = newConfiguredFeature("mc_red_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDSPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_PINE_TREE = newConfiguredFeature("mc_yellow_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.YELLOWPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_SPRUCE_TREE = newConfiguredFeature("mc_yellow_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.YELLOWSPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_PINE_TREE = newConfiguredFeature("mc_orange_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGEPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_SPRUCE_TREE = newConfiguredFeature("mc_orange_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGESPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_MEGA_SPRUCE_TREE = newConfiguredFeature("mc_blue_mega_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.BLUEMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BLUE_MEGA_PINE_TREE = newConfiguredFeature("mc_blue_mega_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.BLUEMEGAPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_MEGA_SPRUCE_TREE = newConfiguredFeature("mc_red_mega_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_MEGA_PINE_TREE = newConfiguredFeature("mc_red_mega_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDMEGAPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_MEGA_SPRUCE_TREE = newConfiguredFeature("mc_yellow_mega_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.YELLOWMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_YELLOW_MEGA_PINE_TREE = newConfiguredFeature("mc_yellow_mega_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.YELLOWMEGAPINETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_MEGA_SPRUCE_TREE = newConfiguredFeature("mc_orange_mega_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGEMEGASPRUCETREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_MEGA_PINE_TREE = newConfiguredFeature("mc_orange_mega_pine_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGEMEGAPINETREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_BIRCH_RED_TREE = newConfiguredFeature("mc_red_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_RED_TREE = newConfiguredFeature("mc_tall_red_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.TALLREDBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_BROWN_TREE = newConfiguredFeature("mc_brown_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.BROWNBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_BROWN_TREE = newConfiguredFeature("mc_tall_brown_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.TALLBROWNBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_ORANGE_TREE = newConfiguredFeature("mc_orange_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGEBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_ORANGE_TREE = newConfiguredFeature("mc_tall_orange_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.TALLORANGEBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_YELLOW_TREE = newConfiguredFeature("mc_yellow_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.YELLOWBIRCHTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_BIRCH_TALL_YELLOW_TREE = newConfiguredFeature("mc_tall_yellow_birch", Feature.TREE.withConfiguration(BYGFeatureConfigs.TALLYELLOWBIRCHTREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_BROWN_OAK_TREE = newConfiguredFeature("mc_brown_oak_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.BROWNOAKTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_ORANGE_OAK_TREE = newConfiguredFeature("mc_orange_oak_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.ORANGEOAKTREE_CONFIG));
    public static final ConfiguredFeature<?, ?> MC_RED_OAK_TREE = newConfiguredFeature("mc_red_oak_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.REDOAKTREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_DOVER_MEGA_SPRUCE_TREE = newConfiguredFeature("mc_dover_mega_spruce_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.DOVERMEGASPRUCETREE_CONFIG));

    public static final ConfiguredFeature<?, ?> MC_FANCY_RED_OAK_WITH_MORE_BEEHIVES = newConfiguredFeature("mc_fancy_red_oak_with_more_beehives_tree", Feature.TREE.withConfiguration(BYGFeatureConfigs.FANCY_RED_OAK_WITH_MORE_BEEHIVES_CONFIG));

    //Mushrooms
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> GREEN_MUSHROOM_HUGE = newConfiguredFeature("huge_green_mushroom", BYGFeatureList.GREEN_MUSHROOM_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.GREEN_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> WOOD_BLEWIT_HUGE = newConfiguredFeature("huge_wood_blewit", BYGFeatureList.WOOD_BLEWIT_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> WEEPING_MILKCAP_HUGE = newConfiguredFeature("huge_weeping_milkcap", BYGFeatureList.WEEPING_MILKCAP_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> BLACK_PUFF_HUGE = newConfiguredFeature("huge_black_puff", BYGFeatureList.BLACK_PUFF_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> BLUE_GLOWSHROOM_HUGE = newConfiguredFeature("huge_blue_glowshroom", BYGFeatureList.BLUE_GLOWSHROOM_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> PURPLE_GLOWSHROOM_HUGE = newConfiguredFeature("huge_purple_glowshroom", BYGFeatureList.PURPLE_GLOWSHROOM_HUGE.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    //MiniMushrooms
    public static final ConfiguredFeature<?, ?> GREEN_MUSHROOM_MINI = newConfiguredFeature("mini_green_mushroom", BYGFeatureList.MINI_GREEN_MUSHROOM.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<?, ?> WOOD_BLEWIT_MINI = newConfiguredFeature("mini_wood_blewit", BYGFeatureList.MINI_WOOD_BLEWIT.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<?, ?> WEEPING_MILKCAP_MINI = newConfiguredFeature("mini_weeping_milkcap", BYGFeatureList.MINI_WEEPING_MILKCAP.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<?, ?> BLACK_PUFF_MINI = newConfiguredFeature("mini_black_puff", BYGFeatureList.MINI_BLACK_PUFF.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<?, ?> RED_MUSHROOM_MINI = newConfiguredFeature("mini_red_mushroom", BYGFeatureList.MINI_RED_MUSHROOM.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<?, ?> BROWN_MUSHROOM_MINI = newConfiguredFeature("mini_brown_mushroom", BYGFeatureList.MINI_BROWN_MUSHROOM.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));


    //Nether Mushrooms
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> EMBUR_MUSHROOM = newConfiguredFeature("embur_mushroom1", BYGFeatureList.EMBUR_MUSHROOM.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> EMBUR_MUSHROOM2 = newConfiguredFeature("embur_mushroom2", BYGFeatureList.EMBUR_MUSHROOM2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> CRIMSON_FUNGUS1 = newConfiguredFeature("crimson_fungus1", BYGFeatureList.CRIMSON_FUNGUS_TREE1.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> CRIMSON_FUNGUS2 = newConfiguredFeature("crimson_fungus2", BYGFeatureList.CRIMSON_FUNGUS_TREE2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> WARPED_FUNGUS1 = newConfiguredFeature("warped_fungus1", BYGFeatureList.WARPED_FUNGUS_TREE1.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> WARPED_FUNGUS2 = newConfiguredFeature("warped_fungus2", BYGFeatureList.WARPED_FUNGUS_TREE2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SYTHIAN_FUNGUS_TREE1 = newConfiguredFeature("sythian_fungus_tree1", BYGFeatureList.SYTHIAN_FUNGUS_TREE1.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SYTHIAN_FUNGUS_TREE2 = newConfiguredFeature("sythian_fungus_tree2", BYGFeatureList.SYTHIAN_FUNGUS_TREE2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SYTHIAN_FUNGUS_TREE3 = newConfiguredFeature("sythian_fungus_tree3", BYGFeatureList.SYTHIAN_FUNGUS_TREE3.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SYTHIAN_FUNGUS_TREE4 = newConfiguredFeature("sythian_fungus_tree4", BYGFeatureList.SYTHIAN_FUNGUS_TREE4.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SOUL_SHROOM_TREE1 = newConfiguredFeature("soul_shroom_tree1", BYGFeatureList.SOUL_SHROOM_TREE1.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SOUL_SHROOM_TREE2 = newConfiguredFeature("soul_shroom_tree2", BYGFeatureList.SOUL_SHROOM_TREE2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> SOUL_SHROOM_TREE3 = newConfiguredFeature("soul_shroom_tree3", BYGFeatureList.SOUL_SHROOM_TREE3.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> DEATH_CAP_TREE1 = newConfiguredFeature("death_cap_tree1", BYGFeatureList.DEATH_CAP_TREE1.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> DEATH_CAP_TREE2 = newConfiguredFeature("death_cap_tree2", BYGFeatureList.DEATH_CAP_TREE2.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomFeatureConfig, ?> DEATH_CAP_TREE3 = newConfiguredFeature("death_cap_tree3", BYGFeatureList.DEATH_CAP_TREE3.withConfiguration(new BYGMushroomFeatureConfig.Builder().setStemBlock(BYGBlockList.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlockList.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));


    /***********************************************************Random Selectors***********************************************************/

    public static final ConfiguredFeature<?, ?> RANDOM_ANCIENT_TREE = newConfiguredFeature("rs_ancient_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.DARK_OAK.withChance(0.3F),
            ANCIENT_TREE1.withChance(0.20F),
            ANCIENT_TREE2.withChance(0.20F)),
            ANCIENT_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(16, 0.4F, 8))));

    public static final ConfiguredFeature<?, ?> RANDOM_BAYOU_TREE = newConfiguredFeature("rs_bayou_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WILLOW_DEAD_TREE1.withChance(0.1F),
            WILLOW_TREE1.withChance(0.25F),
            WILLOW_TREE2.withChance(0.25F),
            WILLOW_TREE3.withChance(0.25F)),
            WILLOW_TREE4)).withPlacement(AtOceanFloorWithExtra.OCEANFLOOR.configure(
            new AtSurfaceWithExtraConfig(8, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CORAL_MANGROVE = newConfiguredFeature("rs_mg_coral", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Feature.CORAL_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.25F),
            Feature.CORAL_MUSHROOM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.25F)),
            Feature.CORAL_CLAW.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG))).withPlacement(AtOceanFloorWithExtra.OCEANFLOOR.configure(
            new AtSurfaceWithExtraConfig(25, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUFF_TREE = newConfiguredFeature("rs_bluff_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_TREE1.withChance(0.05F),
            PINE_TREE2.withChance(0.05F),
            BLUFF_TREE1.withChance(0.3F),
            BLUFF_TREE2.withChance(0.3F),
            BLUFF_TREE3.withChance(0.25F)),
            CONIFER_TREE6)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(12, 0.3F, -4))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_TREE = newConfiguredFeature("rs_boreal", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BOREAL_TREE1.withChance(0.5F)),
            BOREAL_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(20, 0.5F, -4))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_SPARSE_TREE = newConfiguredFeature("rs_sparse_boreal", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BOREAL_TREE1.withChance(0.5F)),
            BOREAL_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_FOREST_TREE = newConfiguredFeature("rs_black_forest", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE3.withChance(0.05F),
            ASPEN_TREE2.withChance(0.05F),
            CONIFER_TREE6.withChance(0.05F),
            CONIFER_TREE7.withChance(0.05F),
            PINE_LARGE_TREE1.withChance(0.5F),
            PINE_LARGE_TREE2.withChance(0.5F),
            PINE_TREE1.withChance(0.5F)),
            PINE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(30, 0.4F, -5))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_FOREST_SPARSE_TREE = newConfiguredFeature("rs_sparse_black_forest", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_LARGE_TREE1.withChance(0.45F),
            PINE_LARGE_TREE2.withChance(0.45F),
            PINE_TREE1.withChance(0.4F)),
            PINE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CIKA_TREE = newConfiguredFeature("rs_cika_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CIKA_TREE2.withChance(0.2F),
            CIKA_TREE3.withChance(0.1F)),
            CIKA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_CONIFER_TREE = newConfiguredFeature("rs_conifer_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CONIFER_TREE1.withChance(0.06F),
            CONIFER_TREE2.withChance(0.5F),
            CONIFER_TREE3.withChance(0.04F),
            CONIFER_TREE4.withChance(0.2F),
            CONIFER_TREE5.withChance(0.2F),
            CONIFER_TREE6.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F)),
            CONIFER_TREE8)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(30, 0.4F, 10))));

    public static final ConfiguredFeature<?, ?> RANDOM_CONIFER_SPARSE_TREE = newConfiguredFeature("rs_sparse_conifer_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CONIFER_TREE1.withChance(0.06F),
            CONIFER_TREE2.withChance(0.5F),
            CONIFER_TREE3.withChance(0.04F),
            CONIFER_TREE4.withChance(0.2F),
            CONIFER_TREE5.withChance(0.2F),
            CONIFER_TREE6.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F)),
            CONIFER_TREE8)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CRAG_GARDEN_TREE = newConfiguredFeature("rs_crag_garden_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_TREE1.withChance(0.2F),
            RAINBOW_TREE1.withChance(0.2F),
            Features.BAMBOO.withChance(0.05F),
            RAINBOW_LARGE_TREE1.withChance(0.1F)),
            MAHOGANY_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(30, 0.4F, 8))));

    public static final ConfiguredFeature<?, ?> RANDOM_CYPRESS_TREE = newConfiguredFeature("rs_cypress_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CYPRESS_TREE1.withChance(0.5F),
            CYPRESS_TREE2.withChance(0.4F)),
            CYPRESS_TREE3)).withPlacement(AtOceanFloorWithExtra.OCEANFLOOR.configure(
            new AtSurfaceWithExtraConfig(5, 0.4F, 1))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_TREE = newConfiguredFeature("rs_deciduous_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_TREE1.withChance(0.25F),
            DECIDUOUS_TREE2.withChance(0.25F),
            DECIDUOUS_TREE3.withChance(0.25F)),
            DECIDUOUS_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 3))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_RED_TREE = newConfiguredFeature("rs_deciduous_red_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_RED_TREE1.withChance(0.25F),
            DECIDUOUS_RED_TREE2.withChance(0.25F),
            DECIDUOUS_RED_TREE3.withChance(0.25F)),
            DECIDUOUS_RED_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_ORANGE_TREE = newConfiguredFeature("rs_deciduous_orange_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_ORANGE_TREE1.withChance(0.25F),
            DECIDUOUS_ORANGE_TREE2.withChance(0.25F),
            DECIDUOUS_ORANGE_TREE3.withChance(0.25F)),
            DECIDUOUS_ORANGE_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_BROWN_TREE = newConfiguredFeature("rs_deciduous_brown_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_BROWN_TREE1.withChance(0.25F),
            DECIDUOUS_BROWN_TREE2.withChance(0.25F),
            DECIDUOUS_BROWN_TREE3.withChance(0.25F)),
            DECIDUOUS_BROWN_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_SPARSE_TREE = newConfiguredFeature("rs_sparse_deciduous_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_TREE1.withChance(0.25F),
            DECIDUOUS_TREE2.withChance(0.25F),
            DECIDUOUS_TREE3.withChance(0.25F)),
            DECIDUOUS_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_DOVER_TREE = newConfiguredFeature("rs_dover_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_LARGE_TREE1.withChance(0.25F),
            PINE_LARGE_TREE2.withChance(0.25F)),
            SPRUCE_TREE_LARGE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_EUCALYPTUS_TREE = newConfiguredFeature("rs_eucalyptus_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_TREE1.withChance(0.1F)),
            RAINBOW_LARGE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(8, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_TREE = newConfiguredFeature("rs_jacaranda", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            JACARANDA_TREE2.withChance(0.3F),
            INDIGO_JACARANDA_TREE2.withChance(0.3F),
            INDIGO_JACARANDA_TREE1.withChance(0.3F)),
            JACARANDA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(25, 0.1F, -5))));

    public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_SPARSE_TREE = newConfiguredFeature("rs_sparse_jacaranda", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            INDIGO_JACARANDA_TREE1.withChance(0.3F)),
            JACARANDA_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MAPLE_TREE = newConfiguredFeature("rs_maple", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MAPLE_RED_TREE1.withChance(0.4F),
            MAPLE_RED_TREE2.withChance(0.03F),
            MAPLE_SILVER_TREE1.withChance(0.2F),
            MAPLE_SILVER_TREE2.withChance(0.1F)),
            MAPLE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(5, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MAPLE_SPARSE_TREE = newConfiguredFeature("rs_sparse_maple", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MAPLE_TREE1.withChance(0.06F),
            MAPLE_RED_TREE1.withChance(0.5F),
            MAPLE_TREE1.withChance(0.04F),
            MAPLE_SILVER_TREE1.withChance(0.2F),
            MAPLE_SILVER_TREE2.withChance(0.1F)),
            MAPLE_RED_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_NORTHERN_FOREST_TREE = newConfiguredFeature("rs_northern_forest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_TREE1.withChance(0.5F)),
            PINE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PRAIRIE_TREE = newConfiguredFeature("rs_prairie_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE1.withChance(0.4F),
            SHRUB_PRAIRIE2.withChance(0.4F),
            Features.FANCY_OAK_BEES_002.withChance(0.1F)),
            Features.FANCY_OAK)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_REDWOOD_TREE = newConfiguredFeature("rs_redwood_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            REDWOOD_TREE1.withChance(0.55F),
            REDWOOD_TREE2.withChance(0.1F)),
            REDWOOD_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(5, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_REDWOOD_SPARSE_TREE = newConfiguredFeature("rs_sparse_redwood_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            REDWOOD_TREE1.withChance(0.55F),
            REDWOOD_TREE2.withChance(0.1F)),
            REDWOOD_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_SHRUB = newConfiguredFeature("rs_seasonal_shrub", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB.withChance(0.4F)),
            DECIDUOUS_SEASONAL_SHRUB)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(5, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_DECIDUOUS_SPARSE_TREE = newConfiguredFeature("rs_sparse_seasonal_deciduous_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_RED_TREE1.withChance(0.2F),
            DECIDUOUS_ORANGE_TREE1.withChance(0.2F),
            DECIDUOUS_SEASONAL_SHRUB.withChance(0.2F),
            DECIDUOUS_BROWN_TREE1.withChance(0.2F)),
            DECIDUOUS_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_TAIGA_MISC_TREE = newConfiguredFeature("rs_seasonal_taiga_misc_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_TREE1.withChance(0.25F),
            PINE_TREE2.withChance(0.25F),
            ASPEN_TREE2.withChance(0.25F)),
            ASPEN_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_SEASONAL_TREE_GIANT = newConfiguredFeature("rs_spruce_seasonal_tree_giant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_RED_TREE_LARGE1.withChance(0.25F),
            SPRUCE_ORANGE_TREE_LARGE1.withChance(0.25F),
            SPRUCE_YELLOW_TREE_LARGE1.withChance(0.25F)),
            SPRUCE_TREE_LARGE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_TREE = newConfiguredFeature("rs_spruce_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
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

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_YELLOW_TREE = newConfiguredFeature("rs_spruce_yellow_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
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

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_ORANGE_TREE = newConfiguredFeature("rs_spruce_orange_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
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

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_RED_TREE = newConfiguredFeature("rs_spruce_red_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
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

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_BLUE_TREE = newConfiguredFeature("rs_spruce_blue_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
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

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_BLUE_TREE_GIANT = newConfiguredFeature("rs_spruce_blue_tree_giant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_BLUE_TREE_LARGE1.withChance(0.5F)),
            SPRUCE_TREE_LARGE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_FUNGAL_TREE = newConfiguredFeature("rs_fungal_rainforest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            MAHOGANY_TREE5.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            MAHOGANY_TREE2.withChance(0.2F),
            MAHOGANY_TREE3.withChance(0.2F),
            MAHOGANY_TREE4.withChance(0.15F)),
            MAHOGANY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(35, 0.1F, 10))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_SPARSE_TREE = newConfiguredFeature("rs_sparse_rainforest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            MAHOGANY_TREE5.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            MAHOGANY_TREE2.withChance(0.2F),
            MAHOGANY_TREE3.withChance(0.2F),
            MAHOGANY_TREE4.withChance(0.15F)),
            MAHOGANY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_TREE = newConfiguredFeature("rs_rainforest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            MAHOGANY_TREE5.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            MAHOGANY_TREE2.withChance(0.2F),
            MAHOGANY_TREE3.withChance(0.2F),
            MAHOGANY_TREE4.withChance(0.15F)),
            MAHOGANY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(45, 0.1F, 10))));

    public static final ConfiguredFeature<?, ?> RANDOM_STONEFOREST_TREE = newConfiguredFeature("rs_stoneforest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EBONY_TREE1.withChance(0.1F),
            EBONY_TREE2.withChance(0.1F),
            Features.JUNGLE_BUSH.withChance(0.1F),
            DECIDUOUS_TREE1.withChance(0.1F)),
            DECIDUOUS_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(30, 0.3F, 8))));

    public static final ConfiguredFeature<?, ?> RANDOM_SKYRIS_TREE = newConfiguredFeature("rs_skyris_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SKYRIS_TREE1.withChance(0.15F),
            SKYRIS_TREE5.withChance(0.25F),
            SKYRIS_TREE2.withChance(0.15F),
            SKYRIS_TREE3.withChance(0.25F)),
            SKYRIS_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(8, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BAOBAB_TREE = newConfiguredFeature("rs_baobab_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.ACACIA.withChance(0.1F)),
            BAOBAB_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.3F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_MEADOW_SHRUB = newConfiguredFeature("rs_meadow_shrub", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_MEADOW.withChance(0.1F)),
            SHRUB_PRAIRIE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MEADOW_TREE = newConfiguredFeature("rs_meadow_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MEADOW_TREE1.withChance(0.2F),
            MEADOW_TREE2.withChance(0.1F)),
            MEADOW_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(3, 0.5F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_GROVE_TREE = newConfiguredFeature("rs_grove_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BOREAL_TREE1.withChance(0.1F)),
            BOREAL_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ENCHANTED_GROVE_TREE = newConfiguredFeature("rs_enchanted_grove_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ENCHANTED_BLUE_GROVE_TREE1.withChance(0.5F)),
            ENCHANTED_GREEN_GROVE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_MARSH_TREE = newConfiguredFeature("rs_marsh_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE2.withChance(0.2F),
            SHRUB_PRAIRIE1.withChance(0.1F)),
            Features.SWAMP_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(3, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ENCHANTED_TREE = newConfiguredFeature("rs_enchanted_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ENCHANTED_BLUE_TREE2.withChance(0.2F),
            ENCHANTED_BLUE_TREE3.withChance(0.2F),
            ENCHANTED_GREEN_TREE1.withChance(0.2F),
            ENCHANTED_GREEN_TREE2.withChance(0.2F),
            ENCHANTED_GREEN_TREE3.withChance(0.1F)),
            ENCHANTED_BLUE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(20, 0.4F, -2))));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSHROOM_BAYOU_TREE = newConfiguredFeature("rs_glowshroom_bayou_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WILLOW_DEAD_TREE1.withChance(0.2F),
            WILLOW_M_TREE1.withChance(0.2F),
            WILLOW_M_TREE2.withChance(0.2F),
            WILLOW_TREE3.withChance(0.2F),
            WILLOW_TREE4.withChance(0.2F),
            WILLOW_TREE2.withChance(0.1F)),
            WILLOW_TREE1)).withPlacement(AtOceanFloorWithExtra.OCEANFLOOR.configure(
            new AtSurfaceWithExtraConfig(8, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_ASPEN_TREE = newConfiguredFeature("rs_aspen_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE2.withChance(0.50F),
            ASPEN_TREE3.withChance(0.25F)),
            ASPEN_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(20, 0.5F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_ASPEN_SHRUB = newConfiguredFeature("rs_aspen_shrub", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_SHRUB1.withChance(0.1F)),
            ASPEN_SHRUB2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ASPEN_TREE = newConfiguredFeature("rs_sparse_aspen_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE2.withChance(0.2F),
            ASPEN_TREE3.withChance(0.1F)),
            ASPEN_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ZELKOVA_TREE = newConfiguredFeature("rs_zelkova_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ZELKOVA_TREE2.withChance(0.2F),
            ZELKOVA_TREE3.withChance(0.1F)),
            ZELKOVA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(20, 0.4F, -2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ZELKOVA_TREE = newConfiguredFeature("rs_sparse_zelkova_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ZELKOVA_TREE2.withChance(0.2F),
            ZELKOVA_TREE3.withChance(0.1F)),
            ZELKOVA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PALO_VERDE_TREE = newConfiguredFeature("rs_palo_verde_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PALO_VERDE_TREE1.withChance(0.5F)),
            PALO_VERDE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_JOSHUA_TREE = newConfiguredFeature("rs_joshua_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            JOSHUA_TREE1.withChance(0.5F)),
            JOSHUA_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SHRUB = newConfiguredFeature("rs_shrub", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE1.withChance(0.1F)),
            SHRUB_PRAIRIE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SHRUBLAND = newConfiguredFeature("rs_shrubland", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB.withChance(0.1F)),
            SHRUB)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PALM_TREE = newConfiguredFeature("rs_palm_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PALM_TREE3.withChance(0.35F),
            PALM_TREE2.withChance(0.35F)),
            PALM_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CHERRY_TREE = newConfiguredFeature("rs_cherry_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CHERRY_PINK_TREE1.withChance(0.2F),
            CHERRY_PINK_TREE2.withChance(0.2F),
            CHERRY_WHITE_TREE1.withChance(0.1F)),
            CHERRY_WHITE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(14, 0.4F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_CHERRY_TREE = newConfiguredFeature("rs_sparse_cherry_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CHERRY_PINK_TREE1.withChance(0.2F),
            CHERRY_PINK_TREE2.withChance(0.2F),
            CHERRY_WHITE_TREE1.withChance(0.1F)),
            CHERRY_WHITE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_WITCH_HAZEL_TREE = newConfiguredFeature("rs_witch_hazel_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEAD_HAZEL_TREE1.withChance(0.2F),
            DEAD_HAZEL_TREE2.withChance(0.2F),
            DEAD_HAZEL_TREE3.withChance(0.1F)),
            DEAD_HAZEL_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(14, 0.3F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_WITCH_HAZEL_TREE = newConfiguredFeature("rs_sparse_witch_hazel_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEAD_HAZEL_TREE1.withChance(0.2F),
            DEAD_HAZEL_TREE2.withChance(0.2F),
            DEAD_HAZEL_TREE3.withChance(0.1F)),
            DEAD_HAZEL_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_EBONY_TREE = newConfiguredFeature("rs_ebony_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EBONY_TREE1.withChance(0.2F),
            EBONY_TREE2.withChance(0.2F),
            EBONY_BUSH1.withChance(0.1F)),
            EBONY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(10, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_HOLLY_TREE = newConfiguredFeature("rs_holly_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            HOLLY_TREE1.withChance(0.2F),
            HOLLY_TREE2.withChance(0.2F),
            HOLLY_TREE3.withChance(0.1F)),
            HOLLY_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(25, 0.4F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_HOLLY_TREE = newConfiguredFeature("rs_sparse_holly_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            HOLLY_TREE1.withChance(0.2F),
            HOLLY_TREE2.withChance(0.2F),
            HOLLY_TREE3.withChance(0.1F)),
            HOLLY_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MANGROVE_TREE = newConfiguredFeature("rs_mangrove_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MANGROVE_TREE1.withChance(0.2F),
            MANGROVE_TREE2.withChance(0.2F),
            MANGROVE_TREE3.withChance(0.2F),
            MANGROVE_TREE4.withChance(0.1F)),
            MANGROVE_TREE5)).withPlacement(AtOceanFloorWithExtra.OCEANFLOOR.configure(
            new AtSurfaceWithExtraConfig(15, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MANGROVE_SPARSE_TREE = newConfiguredFeature("rs_sparse_mangrove_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MANGROVE_TREE1.withChance(0.2F),
            MANGROVE_TREE2.withChance(0.2F),
            MANGROVE_TREE3.withChance(0.2F),
            MANGROVE_TREE4.withChance(0.1F)),
            MANGROVE_TREE5)).withPlacement(AtOceanFloorWithExtra.OCEANFLOOR.configure(
            new AtSurfaceWithExtraConfig(0, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PINE_TREE = newConfiguredFeature("rs_pine_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_TREE2.withChance(0.2F),
            PINE_TREE1.withChance(0.2F),
            PINE_LARGE_TREE1.withChance(0.1F)),
            PINE_LARGE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(20, 0.4F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_ORCHARD_TREE = newConfiguredFeature("rs_orchard_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ORCHARD_TREE1.withChance(0.3F),
            ORCHARD_TREE2.withChance(0.3F)),
            ORCHARD_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_WOODLAND_TREE = newConfiguredFeature("rs_woodland_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WOODLANDS_TREE1.withChance(0.1F)),
            WOODLANDS_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_RED_OAK_FOREST_TREE = newConfiguredFeature("rs_red_oak_forest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.OAK.withChance(0.1F),
            Features.OAK_BEES_002.withChance(0.1F),
            Features.FANCY_OAK_BEES_0002.withChance(0.1F),
            MC_FANCY_RED_OAK_WITH_MORE_BEEHIVES.withChance(0.2F)),
            MC_RED_OAK_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(8, 0.3F, 5))));


    public static final ConfiguredFeature<?, ?> RANDOM_RED_OAK_FOREST_SPARSE_TREE = newConfiguredFeature("rs_red_oak_forest_sparse_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.OAK.withChance(0.06F),
            MC_RED_OAK_TREE.withChance(0.1F)),
            MC_FANCY_RED_OAK_WITH_MORE_BEEHIVES)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_BIRCH_FOREST_TREE = newConfiguredFeature("rs_seasonal_birch_forest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
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

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_FOREST_TREE = newConfiguredFeature("rs_seasonal_forest_tree", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
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

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSHROOM = newConfiguredFeature("rs_huge_glowshroom", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_GLOWSHROOM_HUGE.withChance(0.1F)),
            PURPLE_GLOWSHROOM_HUGE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(25, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SOUL_SHROOM_TREES = newConfiguredFeature("rs_soul_shroom_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SOUL_SHROOM_TREE3.withChance(0.35F),
            SOUL_SHROOM_TREE2.withChance(0.35F)),
            SOUL_SHROOM_TREE1)).withPlacement(UnderGroundPlacement.UGPLACER.configure(
            new AtSurfaceWithExtraConfig(8, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_DEATH_CAP_TREES = newConfiguredFeature("rs_death_cap_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEATH_CAP_TREE3.withChance(0.35F),
            DEATH_CAP_TREE2.withChance(0.35F)),
            DEATH_CAP_TREE1)).withPlacement(UnderGroundPlacement.UGPLACER.configure(
            new AtSurfaceWithExtraConfig(8, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MINI_MUSHROOMS = newConfiguredFeature("rs_mini_mushrooms", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            GREEN_MUSHROOM_MINI.withChance(0.16F),
            RED_MUSHROOM_MINI.withChance(0.16F),
            BROWN_MUSHROOM_MINI.withChance(0.16F),
            WOOD_BLEWIT_MINI.withChance(0.16F),
            WEEPING_MILKCAP_MINI.withChance(0.16F)),
            BLACK_PUFF_MINI)).withPlacement(UnderGroundPlacement.UGPLACER.configure(
            new AtSurfaceWithExtraConfig(7, 0.5F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_MUSHROOM = newConfiguredFeature("rs_huge_mushroom", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            GREEN_MUSHROOM_HUGE.withChance(0.4F),
            WOOD_BLEWIT_HUGE.withChance(0.4F),
            WEEPING_MILKCAP_HUGE.withChance(0.4F)),
            BLACK_PUFF_HUGE)).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(10, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_MUSHROOM = newConfiguredFeature("rs_embur_mushroom", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_MUSHROOM.withChance(0.5F)),
            EMBUR_MUSHROOM2)).withPlacement(UnderGroundPlacement.UGPLACER.configure(
            new AtSurfaceWithExtraConfig(2, 0.5F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_FUNGUS = newConfiguredFeature("rs_fungus", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WARPED_FUNGUS1.withChance(0.15F),
            WARPED_FUNGUS2.withChance(0.15F),
            CRIMSON_FUNGUS1.withChance(0.4F)),
            CRIMSON_FUNGUS2)).withPlacement(UnderGroundPlacement.UGPLACER.configure(
            new AtSurfaceWithExtraConfig(4, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SYTHIAN_FUNGUS = newConfiguredFeature("rs_sythian_fungus", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SYTHIAN_FUNGUS_TREE1.withChance(0.25F),
            SYTHIAN_FUNGUS_TREE2.withChance(0.25F),
            SYTHIAN_FUNGUS_TREE3.withChance(0.25F)),
            SYTHIAN_FUNGUS_TREE4)).withPlacement(UnderGroundPlacement.UGPLACER.configure(
            new AtSurfaceWithExtraConfig(12, 0.5F, 2))));

    private static <FC extends IFeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, F> newConfiguredFeature(String registryName, ConfiguredFeature<FC, F> configuredFeature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(BYG.MOD_ID, registryName), configuredFeature);
        return configuredFeature;
    }
}
