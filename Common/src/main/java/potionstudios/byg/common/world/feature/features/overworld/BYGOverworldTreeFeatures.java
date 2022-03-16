package potionstudios.byg.common.world.feature.features.overworld;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.structure.TreeFromStructureNBTConfig;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;
import static potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil.createPlacedFeature;

public class BYGOverworldTreeFeatures {
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ARAUCARIA_TREE1 = createConfiguredFeature("araucaria_tree1",
        BYGFeatures.ARAUCARIA_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PINE_LOG)
            .setLeavesBlock(BYGBlocks.ARAUCARIA_LEAVES)
            .setMaxHeight(24)
            .setMinHeight(16)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ARAUCARIA_TREE2 = createConfiguredFeature("araucaria_tree2",
        BYGFeatures.ARAUCARIA_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PINE_LOG)
            .setLeavesBlock(BYGBlocks.ARAUCARIA_LEAVES)
            .setMaxHeight(24)
            .setMinHeight(16)
            .build()
    );


    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ANCIENT_TREE1 = createConfiguredFeature("ancient_tree1",
        BYGFeatures.ANCIENT_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.DARK_OAK_LOG)
            .setLeavesBlock(Blocks.DARK_OAK_LEAVES)
            .setMaxHeight(25)
            .setMinHeight(15)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ANCIENT_TREE2 = createConfiguredFeature("ancient_tree2",
        BYGFeatures.ANCIENT_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.EBONY_LOG).
            setLeavesBlock(BYGBlocks.EBONY_LEAVES)
            .setMaxHeight(25)
            .setMinHeight(15)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ANCIENT_TREE3 = createConfiguredFeature("ancient_tree3",
        BYGFeatures.ANCIENT_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.MAPLE_LOG)
            .setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES)
            .setMaxHeight(25)
            .setMinHeight(15)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ASPEN_SHRUB1 = createConfiguredFeature("aspen_shrub1",
        BYGFeatures.SHRUB1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ASPEN_LOG)
            .setLeavesBlock(BYGBlocks.ASPEN_LEAVES)
            .setMinHeight(2)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ASPEN_SHRUB2 = createConfiguredFeature("aspen_shrub2",
        BYGFeatures.SHRUB2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ASPEN_LOG)
            .setLeavesBlock(BYGBlocks.ASPEN_LEAVES)
            .setMinHeight(1)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ASPEN_TREE1 = createConfiguredFeature("aspen_tree1",
        BYGFeatures.ASPEN_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ASPEN_LOG)
            .setLeavesBlock(BYGBlocks.ASPEN_LEAVES)
            .setMaxHeight(10)
            .setMinHeight(7)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ASPEN_TREE2 = createConfiguredFeature("aspen_tree2",
        BYGFeatures.ASPEN_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ASPEN_LOG)
            .setLeavesBlock(BYGBlocks.ASPEN_LEAVES)
            .setMaxHeight(19).setMinHeight(14).build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ASPEN_TREE3 =
        createConfiguredFeature("aspen_tree3", BYGFeatures.ASPEN_TREE3,
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.ASPEN_LOG)
                .setLeavesBlock(BYGBlocks.ASPEN_LEAVES)
                .setMaxHeight(18)
                .setMinHeight(11)
                .build()
        );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BAOBAB_TREE1 = createConfiguredFeature("baobab_tree1",
        BYGFeatures.BAOBAB_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.BAOBAB_LOG)
            .setLeavesBlock(BYGBlocks.BAOBAB_LEAVES)
            .setMaxHeight(28)
            .setMinHeight(20)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BAOBAB_TREE2 = createConfiguredFeature("baobab_tree2",
        BYGFeatures.BAOBAB_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.BAOBAB_LOG)
            .setLeavesBlock(BYGBlocks.BAOBAB_LEAVES)
            .setMaxHeight(28)
            .setMinHeight(20)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BAOBAB_TREE3 = createConfiguredFeature("baobab_tree3",
        BYGFeatures.BAOBAB_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.BAOBAB_LOG)
            .setLeavesBlock(BYGBlocks.BAOBAB_LEAVES)
            .setMaxHeight(28)
            .setMinHeight(20)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_TREE1 = createConfiguredFeature("birch_tree1",
        BYGFeatures.BIRCH_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.BIRCH_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES)
            .setMaxHeight(11)
            .setMinHeight(7)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_TREE2 = createConfiguredFeature("birch_tree2",
        BYGFeatures.BIRCH_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.BIRCH_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES)
            .setMaxHeight(13)
            .setMinHeight(9)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_TREE3 = createConfiguredFeature("birch_tree3",
        BYGFeatures.BIRCH_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.BIRCH_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES)
            .setMaxHeight(28)
            .setMinHeight(23)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_TREE4 = createConfiguredFeature("birch_tree4",
        BYGFeatures.BIRCH_TREE4,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.BIRCH_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES)
            .setMaxHeight(11)
            .setMinHeight(8)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_BROWN_TREE1 = createConfiguredFeature("brown_birch_tree1",
        BYGFeatures.BIRCH_TREE1,
        new BYGTreeConfig.Builder().copy(BIRCH_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_BROWN_TREE2 = createConfiguredFeature("brown_birch_tree2",
        BYGFeatures.BIRCH_TREE2,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_BROWN_TREE3 = createConfiguredFeature("brown_birch_tree3",
        BYGFeatures.BIRCH_TREE3,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE3.value().config())
            .setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_BROWN_TREE4 = createConfiguredFeature("brown_birch_tree4",
        BYGFeatures.BIRCH_TREE4,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE4.value().config())
            .setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_ORANGE_TREE1 = createConfiguredFeature("orange_birch_tree1",
        BYGFeatures.BIRCH_TREE1,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_ORANGE_TREE2 = createConfiguredFeature("orange_birch_tree2",
        BYGFeatures.BIRCH_TREE2,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_ORANGE_TREE3 = createConfiguredFeature("orange_birch_tree3",
        BYGFeatures.BIRCH_TREE3,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE3.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_ORANGE_TREE4 = createConfiguredFeature("orange_birch_tree4",
        BYGFeatures.BIRCH_TREE4,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE4.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_RED_TREE1 = createConfiguredFeature("red_birch_tree1",
        BYGFeatures.BIRCH_TREE1,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_RED_TREE2 = createConfiguredFeature("red_birch_tree2",
        BYGFeatures.BIRCH_TREE2,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_RED_TREE3 = createConfiguredFeature("red_birch_tree3",
        BYGFeatures.BIRCH_TREE3,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE3.value().config())
            .setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_RED_TREE4 = createConfiguredFeature("red_birch_tree4",
        BYGFeatures.BIRCH_TREE4,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE4.value().config())
            .setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_YELLOW_TREE1 = createConfiguredFeature("yellow_birch_tree1",
        BYGFeatures.BIRCH_TREE1,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_YELLOW_TREE2 = createConfiguredFeature("yellow_birch_tree2",
        BYGFeatures.BIRCH_TREE2,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_YELLOW_TREE3 = createConfiguredFeature("yellow_birch_tree3",
        BYGFeatures.BIRCH_TREE3,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE3.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_YELLOW_TREE4 = createConfiguredFeature("yellow_birch_tree4",
        BYGFeatures.BIRCH_TREE4,
        new BYGTreeConfig.Builder()
            .copy(BIRCH_TREE4.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BLUFF_TREE1 = createConfiguredFeature("bluff_tree1",
        BYGFeatures.BLUFF_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(21).setMinHeight(17).build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BLUFF_TREE2 = createConfiguredFeature("bluff_tree2",
        BYGFeatures.BLUFF_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(11).setMinHeight(8).build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BLUFF_TREE3 = createConfiguredFeature("bluff_tree3",
        BYGFeatures.BLUFF_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(16)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_BOREAL_TREE1 = createConfiguredFeature("birch_boreal_tree1",
        BYGFeatures.BOREAL_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.BIRCH_LOG)
            .setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES)
            .setMaxHeight(15)
            .setMinHeight(9)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BOREAL_TREE2 = createConfiguredFeature("boreal_tree2",
        BYGFeatures.BOREAL_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(15)
            .setMinHeight(11)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BIRCH_YELLOW_BOREAL_TREE1 = createConfiguredFeature("birch_yellow_boreal_tree1",
        BYGFeatures.BOREAL_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.BIRCH_LOG)
            .setLeavesBlock(Blocks.BIRCH_LEAVES)
            .setMaxHeight(15)
            .setMinHeight(9)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CHERRY_PINK_TREE1 = createConfiguredFeature("pink_cherry_tree1",
        BYGFeatures.CHERRY_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.CHERRY_LOG)
            .setLeavesBlock(BYGBlocks.PINK_CHERRY_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(14)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CHERRY_PINK_TREE2 = createConfiguredFeature("pink_cherry_tree2",
        BYGFeatures.CHERRY_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.CHERRY_LOG)
            .setLeavesBlock(BYGBlocks.PINK_CHERRY_LEAVES)
            .setMaxHeight(13)
            .setMinHeight(8)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CHERRY_WHITE_TREE1 = createConfiguredFeature("white_cherry_tree1",
        BYGFeatures.CHERRY_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.CHERRY_LOG)
            .setLeavesBlock(BYGBlocks.WHITE_CHERRY_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(14)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CHERRY_WHITE_TREE2 = createConfiguredFeature("white_cherry_tree2",
        BYGFeatures.CHERRY_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.CHERRY_LOG)
            .setLeavesBlock(BYGBlocks.WHITE_CHERRY_LEAVES)
            .setMaxHeight(13)
            .setMinHeight(8)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CIKA_TREE1 = createConfiguredFeature("cika_tree1", BYGFeatures.CIKA_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.CIKA_LOG)
            .setLeavesBlock(BYGBlocks.CIKA_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(14)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CIKA_TREE2 = createConfiguredFeature("cika_tree2",
        BYGFeatures.CIKA_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.CIKA_LOG)
            .setLeavesBlock(BYGBlocks.CIKA_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(14)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CIKA_TREE3 = createConfiguredFeature("cika_tree3",
        BYGFeatures.CIKA_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.CIKA_LOG)
            .setLeavesBlock(BYGBlocks.CIKA_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(14)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CONIFER_TREE1 = createConfiguredFeature("conifer_tree1",
        BYGFeatures.CONIFER_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.FIR_LOG)
            .setLeavesBlock(BYGBlocks.FIR_LEAVES)
            .setMaxHeight(25)
            .setMinHeight(19)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CONIFER_TREE2 = createConfiguredFeature("conifer_tree2",
        BYGFeatures.CONIFER_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.FIR_LOG)
            .setLeavesBlock(BYGBlocks.FIR_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(23)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CONIFER_TREE3 = createConfiguredFeature("conifer_tree3",
        BYGFeatures.CONIFER_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.FIR_LOG)
            .setLeavesBlock(BYGBlocks.FIR_LEAVES)
            .setMaxHeight(35)
            .setMinHeight(26)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CONIFER_TREE4 = createConfiguredFeature("conifer_tree4",
        BYGFeatures.CONIFER_TREE4,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.FIR_LOG)
            .setLeavesBlock(BYGBlocks.FIR_LEAVES)
            .setMaxHeight(35)
            .setMinHeight(25)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CONIFER_TREE5 = createConfiguredFeature("conifer_tree5",
        BYGFeatures.CONIFER_TREE5,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.FIR_LOG)
            .setLeavesBlock(BYGBlocks.FIR_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(14)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CONIFER_TREE6 = createConfiguredFeature("conifer_tree6",
        BYGFeatures.CONIFER_TREE6,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.FIR_LOG)
            .setLeavesBlock(BYGBlocks.FIR_LEAVES)
            .setMaxHeight(17)
            .setMinHeight(11)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CONIFER_TREE7 = createConfiguredFeature("conifer_tree7",
        BYGFeatures.CONIFER_TREE7,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.FIR_LOG)
            .setLeavesBlock(BYGBlocks.FIR_LEAVES)
            .setMaxHeight(28)
            .setMinHeight(18)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CONIFER_TREE8 = createConfiguredFeature("conifer_tree8",
        BYGFeatures.CONIFER_TREE8,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.FIR_LOG)
            .setLeavesBlock(BYGBlocks.FIR_LEAVES)
            .setMaxHeight(28)
            .setMinHeight(16)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CYPRESS_TREE1 = createConfiguredFeature("cypress_tree1",
        BYGFeatures.CYPRESS_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.CYPRESS_LOG)
            .setLeavesBlock(BYGBlocks.CYPRESS_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(20)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CYPRESS_TREE2 = createConfiguredFeature("cypress_tree2",
        BYGFeatures.CYPRESS_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.CYPRESS_LOG)
            .setLeavesBlock(BYGBlocks.CYPRESS_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(20)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> CYPRESS_TREE3 = createConfiguredFeature("cypress_tree3",
        BYGFeatures.CYPRESS_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.CYPRESS_LOG)
            .setLeavesBlock(BYGBlocks.CYPRESS_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(20)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> HAZEL_TREE1 = createConfiguredFeature("hazel_tree1",
        BYGFeatures.HAZEL_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG)
            .setLeavesBlock(
                new WeightedStateProvider(
                    SimpleWeightedRandomList.<BlockState>builder()
                        .add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1)
                        .add(BYGBlocks.WITCH_HAZEL_LEAVES.defaultBlockState(), 4)
                        .build()
                ))
            .setMaxHeight(15)
            .setMinHeight(6)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> HAZEL_TREE2 = createConfiguredFeature("hazel_tree2",
        BYGFeatures.HAZEL_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1)
                .add(BYGBlocks.WITCH_HAZEL_LEAVES.defaultBlockState(), 4)
                .build()
            ))
            .setMaxHeight(12)
            .setMinHeight(7)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DEAD_HAZEL_TREE1 = createConfiguredFeature("dead_hazel_tree1",
        BYGFeatures.DEAD_HAZEL_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG)
            .setLeavesBlock(
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1)
                    .add(BYGBlocks.WITCH_HAZEL_LEAVES.defaultBlockState(), 4)
                    .build()
                ))
            .setMaxHeight(16)
            .setMinHeight(11)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DEAD_HAZEL_TREE2 = createConfiguredFeature("dead_hazel_tree2",
        BYGFeatures.DEAD_HAZEL_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1)
                .add(BYGBlocks.WITCH_HAZEL_LEAVES.defaultBlockState(), 4)
                .build()
            ))
            .setMaxHeight(7)
            .setMinHeight(5)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> FIRECRACKER_SHRUB = createConfiguredFeature("firecracker_shrub",
        BYGFeatures.SHRUB1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.FIRECRACKER_LEAVES)
            .setMinHeight(2)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> FIRECRACKER_SHRUB2 = createConfiguredFeature("firecracker_shrub2",
        BYGFeatures.SHRUB2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.FIRECRACKER_LEAVES)
            .setMinHeight(2)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_TREE1 = createConfiguredFeature("deciduous_tree1",
        BYGFeatures.DECIDUOUS_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(19)
            .setMinHeight(14)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_TREE2 = createConfiguredFeature("deciduous_tree2",
        BYGFeatures.DECIDUOUS_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(22)
            .setMinHeight(17)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_TREE3 = createConfiguredFeature("deciduous_tree3",
        BYGFeatures.DECIDUOUS_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(16)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_TREE4 = createConfiguredFeature("deciduous_tree4",
        BYGFeatures.DECIDUOUS_TREE4,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(16)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_RED_TREE1 = createConfiguredFeature("deciduous_red_tree1",
        BYGFeatures.DECIDUOUS_TREE1,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_RED_TREE2 = createConfiguredFeature("deciduous_red_tree2",
        BYGFeatures.DECIDUOUS_TREE2,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_RED_TREE3 = createConfiguredFeature("deciduous_red_tree3",
        BYGFeatures.DECIDUOUS_TREE3,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE3.value().config())
            .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_RED_TREE4 = createConfiguredFeature("deciduous_red_tree4",
        BYGFeatures.DECIDUOUS_TREE4,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE4.value().config())
            .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_ORANGE_TREE1 = createConfiguredFeature("deciduous_orange_tree1",
        BYGFeatures.DECIDUOUS_TREE1,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_ORANGE_TREE2 = createConfiguredFeature("deciduous_orange_tree2",
        BYGFeatures.DECIDUOUS_TREE2,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_ORANGE_TREE3 = createConfiguredFeature("deciduous_orange_tree3",
        BYGFeatures.DECIDUOUS_TREE3,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE3.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_ORANGE_TREE4 = createConfiguredFeature("deciduous_orange_tree4",
        BYGFeatures.DECIDUOUS_TREE4,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE4.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_BROWN_TREE1 = createConfiguredFeature("deciduous_brown_tree1",
        BYGFeatures.DECIDUOUS_TREE1,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_BROWN_TREE2 = createConfiguredFeature("deciduous_brown_tree2",
        BYGFeatures.DECIDUOUS_TREE2,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_BROWN_TREE3 = createConfiguredFeature("deciduous_brown_tree3",
        BYGFeatures.DECIDUOUS_TREE3,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE3.value().config())
            .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_BROWN_TREE4 = createConfiguredFeature("deciduous_brown_tree4",
        BYGFeatures.DECIDUOUS_TREE4,
        new BYGTreeConfig.Builder()
            .copy(DECIDUOUS_TREE4.value().config())
            .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> EBONY_BUSH1 = createConfiguredFeature("ebony_bush1",
        BYGFeatures.EBONY_BUSH1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.EBONY_LOG)
            .setLeavesBlock(BYGBlocks.EBONY_LEAVES)
            .setMaxHeight(28)
            .setMinHeight(23)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> EBONY_TREE1 = createConfiguredFeature("ebony_tree1",
        BYGFeatures.EBONY_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.EBONY_LOG)
            .setLeavesBlock(BYGBlocks.EBONY_LEAVES)
            .setMaxHeight(13)
            .setMinHeight(6)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> EBONY_TREE2 = createConfiguredFeature("ebony_tree2",
        BYGFeatures.EBONY_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.EBONY_LOG)
            .setLeavesBlock(BYGBlocks.EBONY_LEAVES)
            .setMaxHeight(17)
            .setMinHeight(11)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_BLUE_TREE1 = createConfiguredFeature("blue_enchanted_tree1",
        BYGFeatures.ENCHANTED_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG)
            .setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_BLUE_TREE2 = createConfiguredFeature("blue_enchanted_tree2",
        BYGFeatures.ENCHANTED_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG)
            .setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES)
            .setMaxHeight(26)
            .setMinHeight(19)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_BLUE_TREE3 = createConfiguredFeature("blue_enchanted_tree3",
        BYGFeatures.ENCHANTED_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG)
            .setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES)
            .setMaxHeight(15)
            .setMinHeight(9)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_GREEN_TREE1 = createConfiguredFeature("green_enchanted_tree1",
        BYGFeatures.ENCHANTED_TREE1,
        new BYGTreeConfig.Builder()
            .copy(ENCHANTED_BLUE_TREE1.value().config())
            .setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG)
            .setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_GREEN_TREE2 = createConfiguredFeature("green_enchanted_tree2",
        BYGFeatures.ENCHANTED_TREE2,
        new BYGTreeConfig.Builder()
            .copy(ENCHANTED_BLUE_TREE2.value().config())
            .setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG)
            .setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_GREEN_TREE3 = createConfiguredFeature("green_enchanted_tree3",
        BYGFeatures.ENCHANTED_TREE3,
        new BYGTreeConfig.Builder()
            .copy(ENCHANTED_BLUE_TREE3.value().config())
            .setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG)
            .setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_BLUE_GROVE_TREE1 = createConfiguredFeature("blue_enchanted_grove_tree1",
        BYGFeatures.ENCHANTED_GROVE_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG)
            .setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES)
            .setMaxHeight(15)
            .setMinHeight(9)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_GREEN_GROVE_TREE1 = createConfiguredFeature("green_enchanted_grove_tree1",
        BYGFeatures.ENCHANTED_GROVE_TREE1,
        new BYGTreeConfig.Builder()
            .copy(ENCHANTED_BLUE_TREE1.value().config())
            .setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG)
            .setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> HOLLY_TREE1 = createConfiguredFeature("holly_tree1",
        BYGFeatures.HOLLY_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.HOLLY_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.HOLLY_BERRY_LEAVES.defaultBlockState(), 1)
                .add(BYGBlocks.HOLLY_LEAVES.defaultBlockState(), 10)))
            .setMaxHeight(23)
            .setMinHeight(17)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> HOLLY_TREE2 = createConfiguredFeature("holly_tree2",
        BYGFeatures.HOLLY_TREE2,
        new BYGTreeConfig.Builder().copy(HOLLY_TREE1.value().config())
            .setMaxHeight(15)
            .setMinHeight(10)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> HOLLY_TREE3 = createConfiguredFeature("holly_tree3",
        BYGFeatures.HOLLY_TREE3,
        new BYGTreeConfig.Builder()
            .copy(HOLLY_TREE1.value().config())
            .setMaxHeight(25)
            .setMinHeight(18)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> HOLLY_TREE4 = createConfiguredFeature("holly_tree4",
        BYGFeatures.HOLLY_TREE4,
        new BYGTreeConfig.Builder()
            .copy(HOLLY_TREE1.value().config())
            .setMaxHeight(14)
            .setMinHeight(9)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> JACARANDA_TREE1 = createConfiguredFeature("jacaranda_tree1",
        BYGFeatures.JACARANDA_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.JACARANDA_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.FLOWERING_JACARANDA_LEAVES.defaultBlockState(), 10)
                .add(BYGBlocks.JACARANDA_LEAVES.defaultBlockState(), 40)
            ))
            .setMaxHeight(15)
            .setMinHeight(9)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> JACARANDA_TREE2 = createConfiguredFeature("jacaranda_tree2",
        BYGFeatures.JACARANDA_TREE2,
        new BYGTreeConfig.Builder()
            .copy(JACARANDA_TREE1.value().config())
            .setMaxHeight(12)
            .setMinHeight(7)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> INDIGO_JACARANDA_TREE1 = createConfiguredFeature("indigo_jacaranda_tree1",
        BYGFeatures.JACARANDA_TREE1,
        new BYGTreeConfig.Builder().copy(JACARANDA_TREE1.value().config())
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.FLOWERING_INDIGO_JACARANDA_LEAVES.defaultBlockState(), 10)
                .add(BYGBlocks.INDIGO_JACARANDA_LEAVES.defaultBlockState(), 40)
            ))
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> INDIGO_JACARANDA_TREE2 = createConfiguredFeature("indigo_jacaranda_tree2",
        BYGFeatures.JACARANDA_TREE2,
        new BYGTreeConfig.Builder()
            .copy(JACARANDA_TREE2.value().config())
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.FLOWERING_INDIGO_JACARANDA_LEAVES.defaultBlockState(), 10)
                .add(BYGBlocks.INDIGO_JACARANDA_LEAVES.defaultBlockState(), 40)
            ))
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> JOSHUA_TREE1 = createConfiguredFeature("joshua_tree1",
        BYGFeatures.JOSHUA_TREE1,
        new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.RIPE_JOSHUA_LEAVES.defaultBlockState(), 1)
                .add(BYGBlocks.JOSHUA_LEAVES.defaultBlockState(), 10)
            ))
            .setMaxHeight(6)
            .setMinHeight(3)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> JOSHUA_TREE2 = createConfiguredFeature("joshua_tree2",
        BYGFeatures.JOSHUA_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.RIPE_JOSHUA_LEAVES.defaultBlockState(), 1)
                    .add(BYGBlocks.JOSHUA_LEAVES.defaultBlockState(), 10)
                ))
            .setMaxHeight(6)
            .setMinHeight(3)
            .build()
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> MANGROVE_TREE1 = createConfiguredFeature("mangrove_tree1",
        BYGFeatures.BYG_TREE_FROM_NBT,
        new TreeFromStructureNBTConfig(
            BYG.createLocation("features/trees/mangrove_tree1_base"),
            BYG.createLocation("features/trees/mangrove_tree1_canopy"),
            UniformInt.of(5, 15),
            BlockStateProvider.simple(BYGBlocks.MANGROVE_LOG),
            BlockStateProvider.simple(BYGBlocks.MANGROVE_LEAVES),
            BYGBlocks.MANGROVE_LOG,
            BYGBlocks.MANGROVE_LEAVES
        )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> MANGROVE_TREE2 = createConfiguredFeature("mangrove_tree2",
        BYGFeatures.BYG_TREE_FROM_NBT,
        new TreeFromStructureNBTConfig(
            BYG.createLocation("features/trees/mangrove_tree2_base"),
            BYG.createLocation("features/trees/mangrove_tree2_canopy"),
            UniformInt.of(5, 15),
            BlockStateProvider.simple(BYGBlocks.MANGROVE_LOG),
            BlockStateProvider.simple(BYGBlocks.MANGROVE_LEAVES),
            BYGBlocks.MANGROVE_LOG,
            BYGBlocks.MANGROVE_LEAVES
        )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> MANGROVE_TREE3 = createConfiguredFeature("mangrove_tree3",
        BYGFeatures.BYG_TREE_FROM_NBT,
        new TreeFromStructureNBTConfig(
            BYG.createLocation("features/trees/mangrove_tree3_base"),
            BYG.createLocation("features/trees/mangrove_tree3_canopy"),
            UniformInt.of(5, 15),
            BlockStateProvider.simple(BYGBlocks.MANGROVE_LOG),
            BlockStateProvider.simple(BYGBlocks.MANGROVE_LEAVES),
            BYGBlocks.MANGROVE_LOG,
            BYGBlocks.MANGROVE_LEAVES
        )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> MANGROVE_TREE4 = createConfiguredFeature("mangrove_tree4",
        BYGFeatures.BYG_TREE_FROM_NBT,
        new TreeFromStructureNBTConfig(
            BYG.createLocation("features/trees/mangrove_tree4_base"),
            BYG.createLocation("features/trees/mangrove_tree4_canopy"),
            UniformInt.of(5, 15),
            BlockStateProvider.simple(BYGBlocks.MANGROVE_LOG),
            BlockStateProvider.simple(BYGBlocks.MANGROVE_LEAVES),
            BYGBlocks.MANGROVE_LOG,
            BYGBlocks.MANGROVE_LEAVES
        )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> MANGROVE_TREE5 = createConfiguredFeature("mangrove_tree5",
        BYGFeatures.BYG_TREE_FROM_NBT,
        new TreeFromStructureNBTConfig(
            BYG.createLocation("features/trees/mangrove_tree5_base"),
            BYG.createLocation("features/trees/mangrove_tree5_canopy"),
            UniformInt.of(5, 15),
            BlockStateProvider.simple(BYGBlocks.MANGROVE_LOG),
            BlockStateProvider.simple(BYGBlocks.MANGROVE_LEAVES),
            BYGBlocks.MANGROVE_LOG,
            BYGBlocks.MANGROVE_LEAVES
        )
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAPLE_RED_TREE1 = createConfiguredFeature("red_maple_tree1",
        BYGFeatures.MAPLE_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.MAPLE_LOG)
            .setLeavesBlock(BYGBlocks.RED_MAPLE_LEAVES)
            .setMaxHeight(9)
            .setMinHeight(4)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAPLE_RED_TREE2 = createConfiguredFeature("red_maple_tree2",
        BYGFeatures.MAPLE_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.MAPLE_LOG)
            .setLeavesBlock(BYGBlocks.RED_MAPLE_LEAVES)
            .setMaxHeight(9)
            .setMinHeight(4)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAPLE_SILVER_TREE1 = createConfiguredFeature("silver_maple_tree1",
        BYGFeatures.MAPLE_TREE2,
        new BYGTreeConfig.Builder()
            .copy(MAPLE_RED_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAPLE_SILVER_TREE2 = createConfiguredFeature("silver_maple_tree2",
        BYGFeatures.MAPLE_TREE3,
        new BYGTreeConfig.Builder()
            .copy(MAPLE_RED_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAPLE_TREE1 = createConfiguredFeature("maple_tree1",
        BYGFeatures.MAPLE_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.MAPLE_LOG)
            .setLeavesBlock(BYGBlocks.MAPLE_LEAVES)
            .setMaxHeight(10)
            .setMinHeight(5)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MEADOW_TREE1 = createConfiguredFeature("meadow_tree1",
        BYGFeatures.MEADOW_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(9)
            .setMinHeight(4)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MEADOW_TREE2 = createConfiguredFeature("meadow_tree2",
        BYGFeatures.MEADOW_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.DARK_OAK_LOG)
            .setLeavesBlock(Blocks.DARK_OAK_LEAVES)
            .setMaxHeight(9)
            .setMinHeight(4)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MEADOW_TREE3 = createConfiguredFeature("meadow_tree3",
        BYGFeatures.MEADOW_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.DARK_OAK_LOG)
            .setLeavesBlock(Blocks.DARK_OAK_LEAVES)
            .setMaxHeight(9)
            .setMinHeight(4)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE1 = createConfiguredFeature("oak_tree1",
        BYGFeatures.OAK_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE2 = createConfiguredFeature("oak_tree2",
        BYGFeatures.OAK_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE3 = createConfiguredFeature("oak_tree3",
        BYGFeatures.OAK_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE_LARGE1 = createConfiguredFeature("large_oak_tree1",
        BYGFeatures.OAK_TREE_LARGE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE_LARGE2 = createConfiguredFeature("large_oak_tree2",
        BYGFeatures.OAK_TREE_LARGE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE_LARGE3 = createConfiguredFeature("large_oak_tree3",
        BYGFeatures.OAK_TREE_LARGE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .setDiskBlock(Blocks.PODZOL)
            .setDiskRadius(3)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE1 = createConfiguredFeature("red_oak_tree1",
        BYGFeatures.OAK_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE2 = createConfiguredFeature("red_oak_tree2",
        BYGFeatures.OAK_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE3 = createConfiguredFeature("red_oak_tree3",
        BYGFeatures.OAK_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE_LARGE1 = createConfiguredFeature("large_red_oak_tree1",
        BYGFeatures.OAK_TREE_LARGE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE_LARGE2 = createConfiguredFeature("large_red_oak_tree2",
        BYGFeatures.OAK_TREE_LARGE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE_LARGE3 = createConfiguredFeature("large_red_oak_tree3",
        BYGFeatures.OAK_TREE_LARGE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE1 = createConfiguredFeature("brown_oak_tree1", BYGFeatures.OAK_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE2 = createConfiguredFeature("brown_oak_tree2", BYGFeatures.OAK_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE3 = createConfiguredFeature("brown_oak_tree3", BYGFeatures.OAK_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE_LARGE1 = createConfiguredFeature("large_brown_oak_tree1",
        BYGFeatures.OAK_TREE_LARGE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE_LARGE2 = createConfiguredFeature("large_brown_oak_tree2",
        BYGFeatures.OAK_TREE_LARGE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE_LARGE3 = createConfiguredFeature("large_brown_oak_tree3",
        BYGFeatures.OAK_TREE_LARGE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE1 = createConfiguredFeature("orange_oak_tree1",
        BYGFeatures.OAK_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE2 = createConfiguredFeature("orange_oak_tree2",
        BYGFeatures.OAK_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE3 = createConfiguredFeature("orange_oak_tree3",
        BYGFeatures.OAK_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE_LARGE1 = createConfiguredFeature("large_orange_oak_tree1",
        BYGFeatures.OAK_TREE_LARGE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE_LARGE2 = createConfiguredFeature("large_orange_oak_tree2",
        BYGFeatures.OAK_TREE_LARGE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE_LARGE3 = createConfiguredFeature("large_orange_oak_tree3",
        BYGFeatures.OAK_TREE_LARGE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORCHARD_TREE1 = createConfiguredFeature("orchard_tree1",
        BYGFeatures.ORCHARD_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.ORCHARD_LEAVES.defaultBlockState(), 10)
                    .add(BYGBlocks.FLOWERING_ORCHARD_LEAVES.defaultBlockState(), 1)
                    .add(BYGBlocks.RIPE_ORCHARD_LEAVES.defaultBlockState(), 1))
            )
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORCHARD_TREE2 = createConfiguredFeature("orchard_tree2",
        BYGFeatures.ORCHARD_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.ORCHARD_LEAVES.defaultBlockState(), 10)
                    .add(BYGBlocks.FLOWERING_ORCHARD_LEAVES.defaultBlockState(), 1)
                    .add(BYGBlocks.RIPE_ORCHARD_LEAVES.defaultBlockState(), 1))
            )
            .setMaxHeight(26)
            .setMinHeight(21)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORCHARD_TREE3 = createConfiguredFeature("orchard_tree3",
        BYGFeatures.ORCHARD_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.ORCHARD_LEAVES.defaultBlockState(), 10)
                    .add(BYGBlocks.FLOWERING_ORCHARD_LEAVES.defaultBlockState(), 1)
                    .add(BYGBlocks.RIPE_ORCHARD_LEAVES.defaultBlockState(), 1))
            )
            .setMaxHeight(12)
            .setMinHeight(9)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PALM_TREE1 = createConfiguredFeature("palm_tree1",
        BYGFeatures.PALM_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PALM_LOG)
            .setLeavesBlock(BYGBlocks.PALM_LEAVES)
            .setMaxHeight(5)
            .setMinHeight(3)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PALM_TREE2 = createConfiguredFeature("palm_tree2",
        BYGFeatures.PALM_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PALM_LOG)
            .setLeavesBlock(BYGBlocks.PALM_LEAVES)
            .setMaxHeight(5)
            .setMinHeight(3)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PALM_TREE3 = createConfiguredFeature("palm_tree3",
        BYGFeatures.PALM_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PALM_LOG)
            .setLeavesBlock(BYGBlocks.PALM_LEAVES)
            .setMaxHeight(5)
            .setMinHeight(3)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PALM_TREE4 = createConfiguredFeature("palm_tree4",
        BYGFeatures.PALM_TREE4,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PALM_LOG)
            .setLeavesBlock(BYGBlocks.PALM_LEAVES)
            .setMaxHeight(5)
            .setMinHeight(3)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PINE_LARGE_TREE1 = createConfiguredFeature("large_pine_tree1", BYGFeatures.PINE_LARGE_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PINE_LOG)
            .setLeavesBlock(BYGBlocks.PINE_LEAVES)
            .setMaxHeight(28)
            .setMinHeight(23)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PINE_LARGE_TREE2 = createConfiguredFeature("large_pine_tree2", BYGFeatures.PINE_LARGE_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PINE_LOG)
            .setLeavesBlock(BYGBlocks.PINE_LEAVES)
            .setMaxHeight(31)
            .setMinHeight(26)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PINE_TREE1 = createConfiguredFeature("pine_tree1", BYGFeatures.PINE_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PINE_LOG)
            .setLeavesBlock(BYGBlocks.PINE_LEAVES)
            .setMaxHeight(20)
            .setMinHeight(15)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PINE_TREE2 = createConfiguredFeature("pine_tree2", BYGFeatures.PINE_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PINE_LOG)
            .setLeavesBlock(BYGBlocks.PINE_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(16)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PALO_VERDE_TREE1 = createConfiguredFeature("palo_verde_tree1",
        BYGFeatures.PALO_VERDE_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PALO_VERDE_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.PALO_VERDE_LEAVES.defaultBlockState(), 6)
                .add(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES.defaultBlockState(), 1))
            )
            .setMaxHeight(1)
            .setMinHeight(1)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PALO_VERDE_TREE2 = createConfiguredFeature("palo_verde_tree2",
        BYGFeatures.PALO_VERDE_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.PALO_VERDE_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.PALO_VERDE_LEAVES.defaultBlockState(), 6)
                .add(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES.defaultBlockState(), 1))
            )
            .setMaxHeight(2)
            .setMinHeight(1)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RAINBOW_TREE1 = createConfiguredFeature("rainbow_eucalyptus_tree1",
        BYGFeatures.RAINBOW_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LOG)
            .setLeavesBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES)
            .setMaxHeight(32)
            .setMinHeight(27)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RAINBOW_LARGE_TREE1 = createConfiguredFeature("large_rainbow_eucalyptus_tree1",
        BYGFeatures.RAINBOW_LARGE_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LOG)
            .setLeavesBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES)
            .setMaxHeight(19)
            .setMinHeight(16)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> REDWOOD_TREE1 = createConfiguredFeature("redwood_tree1",
        BYGFeatures.REDWOOD_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.REDWOOD_LOG)
            .setLeavesBlock(BYGBlocks.REDWOOD_LEAVES)
            .setMaxHeight(37)
            .setMinHeight(36)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> REDWOOD_TREE2 = createConfiguredFeature("redwood_tree2",
        BYGFeatures.REDWOOD_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.REDWOOD_LOG)
            .setLeavesBlock(BYGBlocks.REDWOOD_LEAVES)
            .setMaxHeight(34)
            .setMinHeight(31)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> REDWOOD_TREE3 = createConfiguredFeature("redwood_tree3",
        BYGFeatures.REDWOOD_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.REDWOOD_LOG)
            .setLeavesBlock(BYGBlocks.REDWOOD_LEAVES)
            .setMaxHeight(25)
            .setMinHeight(18)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SHRUB_MEADOW = createConfiguredFeature("meadow_shrub1",
        BYGFeatures.SHRUB1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.DARK_OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMinHeight(1)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SHRUB_MEADOW2 = createConfiguredFeature("meadow_shrub2",
        BYGFeatures.SHRUB2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.DARK_OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMinHeight(1)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SHRUB_PRAIRIE1 = createConfiguredFeature("prairie_shrub1",
        BYGFeatures.SHRUB1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMinHeight(1)
            .setMaxHeight(2)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SHRUB_PRAIRIE2 = createConfiguredFeature("prairie_shrub2",
        BYGFeatures.SHRUB2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMinHeight(1)
            .build()
    );


    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SKYRIS_TREE1 = createConfiguredFeature("skyris_tree1",
        BYGFeatures.SKYRIS_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.SKYRIS_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1)
                .add(BYGBlocks.SKYRIS_LEAVES.defaultBlockState(), 8))
            )
            .setMaxHeight(9)
            .setMinHeight(6)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SKYRIS_TREE2 = createConfiguredFeature("skyris_tree2",
        BYGFeatures.SKYRIS_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.SKYRIS_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1)
                .add(BYGBlocks.SKYRIS_LEAVES.defaultBlockState(), 8))
            )
            .setMaxHeight(6)
            .setMinHeight(3)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SKYRIS_TREE3 = createConfiguredFeature("skyris_tree3",
        BYGFeatures.SKYRIS_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.SKYRIS_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1)
                .add(BYGBlocks.SKYRIS_LEAVES.defaultBlockState(), 8))
            )
            .setMaxHeight(8)
            .setMinHeight(6)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SKYRIS_TREE4 = createConfiguredFeature("skyris_tree4",
        BYGFeatures.SKYRIS_TREE4,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.SKYRIS_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1)
                .add(BYGBlocks.SKYRIS_LEAVES.defaultBlockState(), 8))
            )
            .setMaxHeight(8)
            .setMinHeight(6)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SKYRIS_TREE5 = createConfiguredFeature("skyris_tree5",
        BYGFeatures.SKYRIS_TREE5,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.SKYRIS_LOG)
            .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1)
                .add(BYGBlocks.SKYRIS_LEAVES.defaultBlockState(), 8))
            )
            .setMaxHeight(8)
            .setMinHeight(6)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE1 = createConfiguredFeature("spruce_tree1",
        BYGFeatures.SPRUCE_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(17)
            .setMinHeight(12)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE2 = createConfiguredFeature("spruce_tree2",
        BYGFeatures.SPRUCE_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(17)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE3 = createConfiguredFeature("spruce_tree3",
        BYGFeatures.SPRUCE_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(16)
            .setMinHeight(12)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE4 = createConfiguredFeature("spruce_tree4",
        BYGFeatures.SPRUCE_TREE4,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(17)
            .setMinHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE_MEDIUM1 = createConfiguredFeature("spruce_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(24)
            .setMinHeight(19)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE_MEDIUM2 = createConfiguredFeature("spruce_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(25)
            .setMinHeight(20)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE_MEDIUM3 = createConfiguredFeature("spruce_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(26)
            .setMinHeight(21)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE_MEDIUM4 = createConfiguredFeature("spruce_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(25)
            .setMinHeight(19)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE_LARGE1 = createConfiguredFeature("spruce_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.SPRUCE_LOG)
            .setLeavesBlock(Blocks.SPRUCE_LEAVES)
            .setMaxHeight(55)
            .setMinHeight(40)
            .build()
    );

    //Yellow Spruce
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE1 = createConfiguredFeature("spruce_yellow_tree1",
        BYGFeatures.SPRUCE_TREE1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE2 = createConfiguredFeature("spruce_yellow_tree2",
        BYGFeatures.SPRUCE_TREE2,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE3 = createConfiguredFeature("spruce_yellow_tree3",
        BYGFeatures.SPRUCE_TREE3,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE3.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE4 = createConfiguredFeature("spruce_yellow_tree4",
        BYGFeatures.SPRUCE_TREE4,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE4.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE_MEDIUM1 = createConfiguredFeature("spruce_yellow_tree_medium1",
        BYGFeatures.SPRUCE_TREE_MEDIUM1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM1.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE_MEDIUM2 = createConfiguredFeature("spruce_yellow_tree_medium2",
        BYGFeatures.SPRUCE_TREE_MEDIUM2,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM2.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE_MEDIUM3 = createConfiguredFeature("spruce_yellow_tree_medium3",
        BYGFeatures.SPRUCE_TREE_MEDIUM3,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM3.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE_MEDIUM4 = createConfiguredFeature("spruce_yellow_tree_medium4",
        BYGFeatures.SPRUCE_TREE_MEDIUM4,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM4.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE_LARGE1 = createConfiguredFeature("spruce_yellow_tree_large1",
        BYGFeatures.SPRUCE_TREE_LARGE1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_LARGE1.value().config())
            .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES)
            .build()
    );

    //Orange Spruce
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE1 = createConfiguredFeature("spruce_orange_tree1",
        BYGFeatures.SPRUCE_TREE1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE2 = createConfiguredFeature("spruce_orange_tree2",
        BYGFeatures.SPRUCE_TREE2,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE3 = createConfiguredFeature("spruce_orange_tree3",
        BYGFeatures.SPRUCE_TREE3,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE3.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE4 = createConfiguredFeature("spruce_orange_tree4",
        BYGFeatures.SPRUCE_TREE4,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE4.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE_MEDIUM1 = createConfiguredFeature("spruce_orange_tree_medium1",
        BYGFeatures.SPRUCE_TREE_MEDIUM1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM1.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE_MEDIUM2 = createConfiguredFeature("spruce_orange_tree_medium2",
        BYGFeatures.SPRUCE_TREE_MEDIUM2,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM2.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE_MEDIUM3 = createConfiguredFeature("spruce_orange_tree_medium3",
        BYGFeatures.SPRUCE_TREE_MEDIUM3,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM3.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE_MEDIUM4 = createConfiguredFeature("spruce_orange_tree_medium4",
        BYGFeatures.SPRUCE_TREE_MEDIUM4,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM4.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE_LARGE1 = createConfiguredFeature("spruce_orange_tree_large1",
        BYGFeatures.SPRUCE_TREE_LARGE1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_LARGE1.value().config())
            .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES)
            .build()
    );

    //Red Spruce
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE1 = createConfiguredFeature("spruce_red_tree1",
        BYGFeatures.SPRUCE_TREE1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE2 = createConfiguredFeature("spruce_red_tree2",
        BYGFeatures.SPRUCE_TREE2,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE3 = createConfiguredFeature("spruce_red_tree3",
        BYGFeatures.SPRUCE_TREE3,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE3.value().config())
            .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE4 = createConfiguredFeature("spruce_red_tree4",
        BYGFeatures.SPRUCE_TREE4,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE4.value().config())
            .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE_MEDIUM1 = createConfiguredFeature("spruce_red_tree_medium1",
        BYGFeatures.SPRUCE_TREE_MEDIUM1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM1.value().config())
            .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE_MEDIUM2 = createConfiguredFeature("spruce_red_tree_medium2",
        BYGFeatures.SPRUCE_TREE_MEDIUM2,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM2.value().config())
            .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE_MEDIUM3 = createConfiguredFeature("spruce_red_tree_medium3",
        BYGFeatures.SPRUCE_TREE_MEDIUM3,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM3.value().config())
            .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE_MEDIUM4 = createConfiguredFeature("spruce_red_tree_medium4",
        BYGFeatures.SPRUCE_TREE_MEDIUM4,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM4.value().config())
            .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE_LARGE1 = createConfiguredFeature("spruce_red_tree_large1",
        BYGFeatures.SPRUCE_TREE_LARGE1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_LARGE1.value().config())
            .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE1 = createConfiguredFeature("spruce_blue_tree1",
        BYGFeatures.SPRUCE_TREE1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE1.value().config())
            .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE2 = createConfiguredFeature("spruce_blue_tree2",
        BYGFeatures.SPRUCE_TREE2,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE2.value().config())
            .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE3 = createConfiguredFeature("spruce_blue_tree3",
        BYGFeatures.SPRUCE_TREE3,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE3.value().config())
            .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE4 = createConfiguredFeature("spruce_blue_tree4",
        BYGFeatures.SPRUCE_TREE4,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE4.value().config())
            .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE_MEDIUM1 = createConfiguredFeature("spruce_blue_tree_medium1",
        BYGFeatures.SPRUCE_TREE_MEDIUM1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM1.value().config())
            .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE_MEDIUM2 = createConfiguredFeature("spruce_blue_tree_medium2",
        BYGFeatures.SPRUCE_TREE_MEDIUM2,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM2.value().config())
            .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE_MEDIUM3 = createConfiguredFeature("spruce_blue_tree_medium3",
        BYGFeatures.SPRUCE_TREE_MEDIUM3,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM3.value().config())
            .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE_MEDIUM4 = createConfiguredFeature("spruce_blue_tree_medium4",
        BYGFeatures.SPRUCE_TREE_MEDIUM4,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_MEDIUM4.value().config())
            .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE_LARGE1 = createConfiguredFeature("spruce_blue_tree_large1",
        BYGFeatures.SPRUCE_TREE_LARGE1,
        new BYGTreeConfig.Builder()
            .copy(SPRUCE_TREE_LARGE1.value().config())
            .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> TROPICAL_SHRUB1 = createConfiguredFeature("tropical_shrub1",
        BYGFeatures.SHRUB1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.MAHOGANY_LOG)
            .setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES)
            .setMinHeight(2)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAHOGANY_TREE1 = createConfiguredFeature("mahogany_tree1",
        BYGFeatures.MAHOGANY_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.MAHOGANY_LOG)
            .setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAHOGANY_TREE2 = createConfiguredFeature("mahogany_tree2",
        BYGFeatures.MAHOGANY_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.MAHOGANY_LOG)
            .setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES)
            .setMaxHeight(14)
            .setMinHeight(8)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAHOGANY_TREE3 = createConfiguredFeature("mahogany_tree3",
        BYGFeatures.MAHOGANY_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.MAHOGANY_LOG)
            .setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES)
            .setMaxHeight(18)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAHOGANY_TREE4 = createConfiguredFeature("mahogany_tree4",
        BYGFeatures.MAHOGANY_TREE4,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.MAHOGANY_LOG)
            .setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES)
            .setMaxHeight(24)
            .setMinHeight(18)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAHOGANY_TREE5 = createConfiguredFeature("mahogany_tree5",
        BYGFeatures.MAHOGANY_TREE5,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.MAHOGANY_LOG)
            .setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES)
            .setMaxHeight(31)
            .setMinHeight(25)
            .build()
    );


    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> WOODLANDS_TREE1 = createConfiguredFeature("woodlands_tree1",
        BYGFeatures.WOODLANDS_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(Blocks.OAK_LOG)
            .setLeavesBlock(Blocks.OAK_LEAVES)
            .setMaxHeight(5)
            .setMinHeight(25)
            .build()

    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> WILLOW_DEAD_TREE1 = createConfiguredFeature("dead_willow_tree1",
        BYGFeatures.WILLOW_DEAD_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.WILLOW_LOG)
            .setLeavesBlock(BYGBlocks.WILLOW_LEAVES)
            .setMaxHeight(12)
            .setMinHeight(7)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> WILLOW_TREE1 = createConfiguredFeature("willow_tree1",
        BYGFeatures.WILLOW_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.WILLOW_LOG)
            .setLeavesBlock(BYGBlocks.WILLOW_LEAVES)
            .setMaxHeight(14)
            .setMinHeight(8)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> WILLOW_TREE2 = createConfiguredFeature("willow_tree2",
        BYGFeatures.WILLOW_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.WILLOW_LOG)
            .setLeavesBlock(BYGBlocks.WILLOW_LEAVES)
            .setMaxHeight(12)
            .setMinHeight(7)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> WILLOW_TREE3 = createConfiguredFeature("willow_tree3",
        BYGFeatures.WILLOW_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.WILLOW_LOG)
            .setLeavesBlock(BYGBlocks.WILLOW_LEAVES)
            .setMaxHeight(12)
            .setMinHeight(7)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> WILLOW_TREE4 = createConfiguredFeature("willow_tree4",
        BYGFeatures.WILLOW_TREE4,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.WILLOW_LOG)
            .setLeavesBlock(BYGBlocks.WILLOW_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(13)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ZELKOVA_TREE1 = createConfiguredFeature("zelkova_tree1",
        BYGFeatures.ZELKOVA_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ZELKOVA_LOG)
            .setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES)
            .setMaxHeight(20)
            .setMinHeight(13)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ZELKOVA_TREE2 = createConfiguredFeature("zelkova_tree2",
        BYGFeatures.ZELKOVA_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ZELKOVA_LOG)
            .setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES)
            .setMaxHeight(28)
            .setMinHeight(18)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ZELKOVA_TREE3 = createConfiguredFeature("zelkova_tree3",
        BYGFeatures.ZELKOVA_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ZELKOVA_LOG)
            .setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ZELKOVA_BROWN_TREE1 = createConfiguredFeature("zelkova_brown_tree1",
        BYGFeatures.ZELKOVA_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ZELKOVA_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES)
            .setMaxHeight(21)
            .setMinHeight(11)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ZELKOVA_BROWN_TREE2 = createConfiguredFeature("zelkova_brown_tree2",
        BYGFeatures.ZELKOVA_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ZELKOVA_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES)
            .setMaxHeight(20)
            .setMinHeight(10)
            .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ZELKOVA_BROWN_TREE3 = createConfiguredFeature("zelkova_brown_tree3",
        BYGFeatures.ZELKOVA_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ZELKOVA_LOG)
            .setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> FIRECRACKER_SHRUBS = createConfiguredFeature("firecracker_shrubs",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(FIRECRACKER_SHRUB), 0.20F)),
            createPlacedFeature(FIRECRACKER_SHRUB2)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BAYOU_TREES = createConfiguredFeature("bayou_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(WILLOW_DEAD_TREE1), 0.1F),
            new WeightedPlacedFeature(createPlacedFeature(WILLOW_TREE1), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(WILLOW_TREE2), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(WILLOW_TREE3), 0.25F)),
            createPlacedFeature(WILLOW_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CANADIAN_SHIELD_TREES = createConfiguredFeature("canadian_shield_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(PINE_TREE1), 0.05F),
            new WeightedPlacedFeature(createPlacedFeature(PINE_TREE2), 0.05F),
            new WeightedPlacedFeature(createPlacedFeature(BLUFF_TREE1), 0.3F),
            new WeightedPlacedFeature(createPlacedFeature(BLUFF_TREE2), 0.3F),
            new WeightedPlacedFeature(createPlacedFeature(BLUFF_TREE3), 0.25F)),
            createPlacedFeature(CONIFER_TREE6))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BOREAL_TREES = createConfiguredFeature("boreal_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(BIRCH_YELLOW_BOREAL_TREE1), 0.3F),
            new WeightedPlacedFeature(createPlacedFeature(BIRCH_BOREAL_TREE1), 0.3F)),
            createPlacedFeature(BOREAL_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BLACK_FOREST_TREES = createConfiguredFeature("black_forest_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ASPEN_TREE3), 0.05F),
            new WeightedPlacedFeature(createPlacedFeature(ASPEN_TREE2), 0.05F),
            new WeightedPlacedFeature(createPlacedFeature(CONIFER_TREE6), 0.05F),
            new WeightedPlacedFeature(createPlacedFeature(CONIFER_TREE7), 0.05F),
            new WeightedPlacedFeature(createPlacedFeature(PINE_LARGE_TREE1), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(PINE_LARGE_TREE2), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(PINE_TREE1), 0.2F)),
            createPlacedFeature(PINE_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CIKA_TREES = createConfiguredFeature("cika_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(CIKA_TREE2), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(CIKA_TREE3), 0.1F)),
            createPlacedFeature(CIKA_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CONIFER_TREES = createConfiguredFeature("conifer_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(CONIFER_TREE1), 0.06F),
            new WeightedPlacedFeature(createPlacedFeature(CONIFER_TREE2), 0.5F),
            new WeightedPlacedFeature(createPlacedFeature(CONIFER_TREE3), 0.04F),
            new WeightedPlacedFeature(createPlacedFeature(CONIFER_TREE4), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(CONIFER_TREE5), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(CONIFER_TREE6), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(CONIFER_TREE7), 0.1F)),
            createPlacedFeature(CONIFER_TREE8))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CYPRESS_TREES = createConfiguredFeature("cypress_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(CYPRESS_TREE1), 0.33F),
            new WeightedPlacedFeature(createPlacedFeature(CYPRESS_TREE2), 0.33F)),
            createPlacedFeature(CYPRESS_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> DECIDUOUS_TREES = createConfiguredFeature("deciduous_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(DECIDUOUS_TREE1), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(DECIDUOUS_TREE2), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(DECIDUOUS_TREE3), 0.25F)),
            createPlacedFeature(DECIDUOUS_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> DACITE_RIDGE_TREES = createConfiguredFeature("dacite_ridge_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_TREE_MEDIUM2), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_TREE_MEDIUM1), 0.25F)),
            createPlacedFeature(SPRUCE_TREE_LARGE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> JACARANDA_TREES = createConfiguredFeature("jacaranda_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(JACARANDA_TREE2), 0.3F),
            new WeightedPlacedFeature(createPlacedFeature(INDIGO_JACARANDA_TREE2), 0.3F),
            new WeightedPlacedFeature(createPlacedFeature(INDIGO_JACARANDA_TREE1), 0.3F)),
            createPlacedFeature(JACARANDA_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MAPLE_TREES = createConfiguredFeature("maple_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(MAPLE_RED_TREE1), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(MAPLE_RED_TREE2), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(MAPLE_SILVER_TREE1), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(MAPLE_SILVER_TREE2), 0.2F)),
            createPlacedFeature(MAPLE_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> NORTHERN_FOREST_TREES = createConfiguredFeature("northern_forest_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(PINE_TREE1), 0.5F)),
            createPlacedFeature(PINE_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> REDWOOD_TREES = createConfiguredFeature("redwood_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(REDWOOD_TREE1), 0.55F),
            new WeightedPlacedFeature(createPlacedFeature(REDWOOD_TREE2), 0.1F)),
            createPlacedFeature(REDWOOD_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SPRUCE_TREES = createConfiguredFeature("spruce_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_TREE1), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_TREE2), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_TREE3), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_TREE4), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_TREE_MEDIUM1), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_TREE_MEDIUM2), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_TREE_MEDIUM3), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_TREE_MEDIUM4), 0.111F)),
            createPlacedFeature(SPRUCE_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ORANGE_SPRUCE_TREES = createConfiguredFeature("orange_spruce_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_ORANGE_TREE1), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_ORANGE_TREE2), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_ORANGE_TREE3), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_ORANGE_TREE4), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_ORANGE_TREE_MEDIUM1), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_ORANGE_TREE_MEDIUM2), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_ORANGE_TREE_MEDIUM3), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_ORANGE_TREE_MEDIUM4), 0.111F)),
            createPlacedFeature(SPRUCE_ORANGE_TREE_LARGE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> YELLOW_SPRUCE_TREES = createConfiguredFeature("yellow_spruce_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_YELLOW_TREE1), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_YELLOW_TREE2), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_YELLOW_TREE3), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_YELLOW_TREE4), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_YELLOW_TREE_MEDIUM1), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_YELLOW_TREE_MEDIUM2), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_YELLOW_TREE_MEDIUM3), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_YELLOW_TREE_MEDIUM4), 0.111F)),
            createPlacedFeature(SPRUCE_YELLOW_TREE_LARGE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> RED_SPRUCE_TREES = createConfiguredFeature("red_spruce_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_RED_TREE1), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_RED_TREE2), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_RED_TREE3), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_RED_TREE4), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_RED_TREE_MEDIUM1), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_RED_TREE_MEDIUM2), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_RED_TREE_MEDIUM3), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_RED_TREE_MEDIUM4), 0.111F)),
            createPlacedFeature(SPRUCE_RED_TREE1))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> AUTUMNAL_SPRUCE_TREES = createConfiguredFeature("autumnal_spruce_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(RED_SPRUCE_TREES), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(ORANGE_SPRUCE_TREES), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(YELLOW_SPRUCE_TREES), 0.25F)),
            createPlacedFeature(SPRUCE_TREES))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BLUE_SPRUCE_TREES = createConfiguredFeature("blue_spruce_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_BLUE_TREE1), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_BLUE_TREE2), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_BLUE_TREE3), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_BLUE_TREE4), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_BLUE_TREE_MEDIUM1), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_BLUE_TREE_MEDIUM2), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_BLUE_TREE_MEDIUM3), 0.111F),
            new WeightedPlacedFeature(createPlacedFeature(SPRUCE_BLUE_TREE_MEDIUM4), 0.111F)),
            createPlacedFeature(SPRUCE_BLUE_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MAHOGANY_TREES = createConfiguredFeature("mahogany_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(MAHOGANY_TREE1), 0.1F),
            new WeightedPlacedFeature(createPlacedFeature(MAHOGANY_TREE2), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(MAHOGANY_TREE3), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(MAHOGANY_TREE4), 0.15F)),
            createPlacedFeature(MAHOGANY_TREE5))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> RAINFOREST_TREES = createConfiguredFeature("rainforest_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(TROPICAL_SHRUB1), 0.35F)),
            createPlacedFeature(MAHOGANY_TREES))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> GUIANA_SHIELD_TREES = createConfiguredFeature("guiana_shield_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(RAINBOW_LARGE_TREE1), 0.1F),
            new WeightedPlacedFeature(createPlacedFeature(RAINBOW_TREE1), 0.1F),
            new WeightedPlacedFeature(createPlacedFeature(TROPICAL_SHRUB1), 0.1F)),
            createPlacedFeature(MAHOGANY_TREES))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> RAINBOW_EUCALYPTUS_TREES = createConfiguredFeature("rainbow_eucalyptus_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(RAINBOW_LARGE_TREE1), 0.333F)),
            createPlacedFeature(RAINBOW_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SKYRIS_TREES = createConfiguredFeature("skyris_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(SKYRIS_TREE1), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(SKYRIS_TREE2), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(SKYRIS_TREE3), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(SKYRIS_TREE4), 0.2F)),
            createPlacedFeature(SKYRIS_TREE5))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BAOBAB_TREES = createConfiguredFeature("baobab_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(BAOBAB_TREE1), 0.35F),
            new WeightedPlacedFeature(createPlacedFeature(BAOBAB_TREE2), 0.35F)),
            createPlacedFeature(BAOBAB_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ARAUCARIA_TREES = createConfiguredFeature("araucaria_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ARAUCARIA_TREE1), 0.5F)),
            createPlacedFeature(ARAUCARIA_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BROWN_ZELKOVA_TREES = createConfiguredFeature("brown_zelkova_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ZELKOVA_BROWN_TREE1), 0.33F),
            new WeightedPlacedFeature(createPlacedFeature(ZELKOVA_BROWN_TREE2), 0.33F)),
            createPlacedFeature(ZELKOVA_BROWN_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MEADOW_SHRUBS = createConfiguredFeature("meadow_shrubs",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(SHRUB_MEADOW), 0.5F)),
            createPlacedFeature(SHRUB_MEADOW2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MEADOW_TREES = createConfiguredFeature("meadow_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(MEADOW_TREE1), 0.3F),
            new WeightedPlacedFeature(createPlacedFeature(MEADOW_TREE2), 0.3F)),
            createPlacedFeature(MEADOW_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TEMPERATE_GROVE_TREES = createConfiguredFeature("temperate_grove_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(BIRCH_YELLOW_BOREAL_TREE1), 0.5F)),
            createPlacedFeature(BIRCH_BOREAL_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ENCHANTED_TREES = createConfiguredFeature("enchanted_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ENCHANTED_BLUE_TREE2), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(ENCHANTED_BLUE_TREE3), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(ENCHANTED_GREEN_TREE1), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(ENCHANTED_GREEN_TREE2), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(ENCHANTED_GREEN_TREE3), 0.1F)),
            createPlacedFeature(ENCHANTED_BLUE_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ASPEN_TREES = createConfiguredFeature("aspen_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ASPEN_TREE2), 0.50F),
            new WeightedPlacedFeature(createPlacedFeature(ASPEN_TREE3), 0.25F)),
            createPlacedFeature(ASPEN_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ASPEN_SHRUBS = createConfiguredFeature("aspen_shrubs",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ASPEN_SHRUB1), 0.5F)),
            createPlacedFeature(ASPEN_SHRUB2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ZELKOVA_TREES = createConfiguredFeature("zelkova_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ZELKOVA_TREE1), 0.33F),
            new WeightedPlacedFeature(createPlacedFeature(ZELKOVA_TREE2), 0.33F)),
            createPlacedFeature(ZELKOVA_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PALO_VERDE_TREES = createConfiguredFeature("palo_verde_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(PALO_VERDE_TREE1), 0.5F)),
            createPlacedFeature(PALO_VERDE_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> JOSHUA_TREES = createConfiguredFeature("joshua_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(JOSHUA_TREE1), 0.5F)),
            createPlacedFeature(JOSHUA_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PRAIRIE_SHRUBS = createConfiguredFeature("prairie_shrubs", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(SHRUB_PRAIRIE1), 0.5F)),
        createPlacedFeature(SHRUB_PRAIRIE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PALM_TREES = createConfiguredFeature("palm_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(PALM_TREE1), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(PALM_TREE2), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(PALM_TREE3), 0.25F)),
            createPlacedFeature(PALM_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CHERRY_TREES = createConfiguredFeature("cherry_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(CHERRY_PINK_TREE1), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(CHERRY_PINK_TREE2), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(CHERRY_WHITE_TREE1), 0.25F)),
            createPlacedFeature(CHERRY_WHITE_TREE2))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> HAZEL_TREES = createConfiguredFeature("hazel_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(HAZEL_TREE1), 0.3F),
            new WeightedPlacedFeature(createPlacedFeature(HAZEL_TREE2), 0.3F),
            new WeightedPlacedFeature(createPlacedFeature(DEAD_HAZEL_TREE1), 0.2F)),
            createPlacedFeature(DEAD_HAZEL_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> EBONY_TREES = createConfiguredFeature("ebony_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(EBONY_TREE1), 0.45F),
            new WeightedPlacedFeature(createPlacedFeature(EBONY_TREE2), 0.45F)),
            createPlacedFeature(EBONY_BUSH1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> FRAGMENT_FOREST_TREES = createConfiguredFeature("stone_forest_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(TreeFeatures.JUNGLE_BUSH), 0.1F),
            new WeightedPlacedFeature(createPlacedFeature(EBONY_TREES), 0.45F)),
            createPlacedFeature(DECIDUOUS_TREES))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> HOLLY_TREES = createConfiguredFeature("holly_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(HOLLY_TREE1), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(HOLLY_TREE2), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(HOLLY_TREE3), 0.25F)),
            createPlacedFeature(HOLLY_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MANGROVE_TREES = createConfiguredFeature("mangrove_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(MANGROVE_TREE1), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(MANGROVE_TREE2), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(MANGROVE_TREE3), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(MANGROVE_TREE4), 0.2F)),
            createPlacedFeature(MANGROVE_TREE5))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ORCHARD_TREES = createConfiguredFeature("orchard_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ORCHARD_TREE1), 0.33F),
            new WeightedPlacedFeature(createPlacedFeature(ORCHARD_TREE2), 0.33F)),
            createPlacedFeature(ORCHARD_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TEMPERATE_RAINFOREST_TREES = createConfiguredFeature("temperate_rainforest_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(WOODLANDS_TREE1), 0.5F)),
            createPlacedFeature(WOODLANDS_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> OAK_TREES = createConfiguredFeature("oak_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(OAK_TREE1), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(OAK_TREE2), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(OAK_TREE3), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(OAK_TREE_LARGE1), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(OAK_TREE_LARGE2), 0.16F)),
            createPlacedFeature(OAK_TREE_LARGE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ORANGE_OAK_TREES = createConfiguredFeature("orange_oak_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ORANGE_OAK_TREE1), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(ORANGE_OAK_TREE2), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(ORANGE_OAK_TREE3), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(ORANGE_OAK_TREE_LARGE1), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(ORANGE_OAK_TREE_LARGE2), 0.16F)),
            createPlacedFeature(ORANGE_OAK_TREE_LARGE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BROWN_OAK_TREES = createConfiguredFeature("brown_oak_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(BROWN_OAK_TREE1), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(BROWN_OAK_TREE2), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(BROWN_OAK_TREE3), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(BROWN_OAK_TREE_LARGE1), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(BROWN_OAK_TREE_LARGE2), 0.16F)),
            createPlacedFeature(BROWN_OAK_TREE_LARGE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> RED_OAK_TREES = createConfiguredFeature("red_oak_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(RED_OAK_TREE1), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(RED_OAK_TREE2), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(RED_OAK_TREE3), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(RED_OAK_TREE_LARGE1), 0.16F),
            new WeightedPlacedFeature(createPlacedFeature(RED_OAK_TREE_LARGE2), 0.16F)),
            createPlacedFeature(RED_OAK_TREE_LARGE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> AUTUMNAL_OAK_TREES = createConfiguredFeature("autumnal_oak_trees", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(RED_OAK_TREES), 0.25F),
        new WeightedPlacedFeature(createPlacedFeature(BROWN_OAK_TREES), 0.25F),
        new WeightedPlacedFeature(createPlacedFeature(ORANGE_OAK_TREES), 0.25F)),
        createPlacedFeature(OAK_TREES))
    );
}
