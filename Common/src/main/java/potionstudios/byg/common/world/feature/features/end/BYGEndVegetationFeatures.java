package potionstudios.byg.common.world.feature.features.end;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createPatchConfiguredFeature;

public class BYGEndVegetationFeatures {

    public static final ConfiguredFeature<?, ?> IVIS_ROOTS = createPatchConfiguredFeature("ivis_roots", BYGBlocks.IVIS_ROOTS, 32);

    public static final ConfiguredFeature<?, ?> IVIS_SPROUT = createPatchConfiguredFeature("ivis_sprout", BYGBlocks.IVIS_SPROUT, 32);

    public static final ConfiguredFeature<?, ?> BULBIS_SPROUTS = createPatchConfiguredFeature("bulbis_sprouts", BYGBlocks.BULBIS_SPROUTS, 32);

    public static final ConfiguredFeature<?, ?> CRYPTIC_BRAMBLE_PATCH = createPatchConfiguredFeature("cryptic_bramble_patch", BYGBlocks.CRYPTIC_BRAMBLE, 32);

    public static final ConfiguredFeature<?, ?> CRYPTIC_BRAMBLE = createConfiguredFeature("cryptic_bramble",
        Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_BRAMBLE))
        ));

    public static final ConfiguredFeature<?, ?> BULBIS_ODDITY = createPatchConfiguredFeature("bulbis_oddity", BYGBlocks.BULBIS_ODDITY, 32);

    public static final ConfiguredFeature<?, ?> PURPLE_BULBIS_ODDITY = createPatchConfiguredFeature("purple_bulbis_oddity", BYGBlocks.PURPLE_BULBIS_ODDITY, 32);

    public static final ConfiguredFeature<?, ?> BULBIS_ANOMALY = createPatchConfiguredFeature("bulbis_anomaly", BYGBlocks.BULBIS_ANOMALY, 48);

    public static final ConfiguredFeature<?, ?> PURPLE_BULBIS_ANOMALY = createPatchConfiguredFeature("purple_bulbis_anomaly", BYGBlocks.PURPLE_BULBIS_ANOMALY, 48);
    public static final ConfiguredFeature<?, ?> NIGHTSHADE_SPROUTS = createPatchConfiguredFeature("nightshade_sprouts", BYGBlocks.NIGHTSHADE_SPROUTS, 32);
    public static final ConfiguredFeature<?, ?> NIGHTSHADE_ROOTS = createPatchConfiguredFeature("nightshade_roots", BYGBlocks.NIGHTSHADE_ROOTS, 32);
    public static final ConfiguredFeature<?, ?> NIGHTSHADE_BERRY_BUSH = createPatchConfiguredFeature("nightshade_berry_bush", BYGBlocks.NIGHTSHADE_BERRY_BUSH, 32);

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_BUSH1 = createConfiguredFeature("ether_bush1",
        BYGFeatures.ETHER_BUSH1.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.ETHER_LOG)
                .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_BUSH2 = createConfiguredFeature("ether_bush2",
        BYGFeatures.ETHER_BUSH2.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.ETHER_LOG)
                .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE1 = createConfiguredFeature("ether_tree1",
        BYGFeatures.ETHER_TREE1.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.ETHER_LOG)
                .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE2 = createConfiguredFeature("ether_tree2",
        BYGFeatures.ETHER_TREE2.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.ETHER_LOG)
                .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE3 = createConfiguredFeature("ether_tree3",
        BYGFeatures.ETHER_TREE3.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.ETHER_LOG)
                .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE4 = createConfiguredFeature("ether_tree4",
        BYGFeatures.ETHER_TREE4.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.ETHER_LOG)
                .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE5 = createConfiguredFeature("ether_tree5",
        BYGFeatures.ETHER_TREE5.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.ETHER_LOG)
                .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD1 = createConfiguredFeature("ether_tree_dead1",
        BYGFeatures.DEAD_ETHER_TREE1.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.ETHER_WOOD)
                .setLeavesBlock(Blocks.AIR)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD2 = createConfiguredFeature("ether_tree_dead2",
        BYGFeatures.DEAD_ETHER_TREE2.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.ETHER_WOOD)
                .setLeavesBlock(Blocks.AIR)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD3 = createConfiguredFeature("ether_tree_dead3",
        BYGFeatures.DEAD_ETHER_TREE3.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.ETHER_WOOD)
                .setLeavesBlock(Blocks.AIR)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_SHRUB1 = createConfiguredFeature("nightshade_shrub1",
        BYGFeatures.NIGHTSHADE_BUSH1.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9)
                    .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                )
                .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                    .add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))
                )
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_SHRUB2 = createConfiguredFeature("nightshade_shrub2",
        BYGFeatures.NIGHTSHADE_BUSH2.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9)
                    .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                )
                .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                    .add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))
                )
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE1 = createConfiguredFeature("nightshade_tree1",
        BYGFeatures.NIGHTSHADE_TREE1.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9)
                        .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                )
                .setLeavesBlock(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                        .add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))
                )
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE2 = createConfiguredFeature("nightshade_tree2",
        BYGFeatures.NIGHTSHADE_TREE2.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9)
                        .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                )
                .setLeavesBlock(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                        .add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))
                )
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE3 = createConfiguredFeature("nightshade_tree3",
        BYGFeatures.NIGHTSHADE_TREE3.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9)
                        .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                )
                .setLeavesBlock(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                        .add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))
                )
                .setMaxHeight(30)
                .setMinHeight(33)
                .build()
        ));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE4 = createConfiguredFeature("nightshade_tree4",
        BYGFeatures.NIGHTSHADE_TREE4.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9)
                        .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                )
                .setLeavesBlock(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                        .add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))
                )
                .setMaxHeight(30)
                .setMinHeight(44)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SHULKREN_TREE1 = createConfiguredFeature("shulkren_tree1",
        BYGFeatures.SHULKREN_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SHULKREN_TREE2 = createConfiguredFeature("shulkren_tree2",
        BYGFeatures.SHULKREN_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM1 = createConfiguredFeature("imparius_mushroom1",
        BYGFeatures.IMPARIUS_MUSHROOM1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.IMPARIUS_STEM)
                .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM2 = createConfiguredFeature("imparius_mushroom2",
        BYGFeatures.IMPARIUS_MUSHROOM2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.IMPARIUS_STEM)
                .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM3 = createConfiguredFeature("imparius_mushroom3",
        BYGFeatures.IMPARIUS_MUSHROOM3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.IMPARIUS_STEM)
                .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM4 = createConfiguredFeature("imparius_mushroom4",
        BYGFeatures.IMPARIUS_MUSHROOM4.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.IMPARIUS_STEM)
                .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM5 = createConfiguredFeature("imparius_mushroom5",
        BYGFeatures.IMPARIUS_MUSHROOM5.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.IMPARIUS_STEM)
                .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM6 = createConfiguredFeature("imparius_mushroom6",
        BYGFeatures.IMPARIUS_MUSHROOM6.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.IMPARIUS_STEM)
                .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS1 = createConfiguredFeature("fungal_imparius1",
        BYGFeatures.FUNGAL_IMPARIUS1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM)
                .setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS2 = createConfiguredFeature("fungal_imparius2",
        BYGFeatures.FUNGAL_IMPARIUS2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM)
                .setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS3 = createConfiguredFeature("fungal_imparius3",
        BYGFeatures.FUNGAL_IMPARIUS3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM)
                .setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS4 = createConfiguredFeature("fungal_imparius4",
        BYGFeatures.FUNGAL_IMPARIUS4.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM)
                .setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS5 = createConfiguredFeature("fungal_imparius5",
        BYGFeatures.FUNGAL_IMPARIUS5.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM)
                .setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_BUSH1 = createConfiguredFeature("bulbis_bush1",
        BYGFeatures.BULBIS_BUSH1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE1 = createConfiguredFeature("bulbis_tree1",
        BYGFeatures.BULBIS_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE2 = createConfiguredFeature("bulbis_tree2",
        BYGFeatures.BULBIS_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE3 = createConfiguredFeature("bulbis_tree3",
        BYGFeatures.BULBIS_TREE3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE4 = createConfiguredFeature("bulbis_tree4",
        BYGFeatures.BULBIS_TREE4.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE5 = createConfiguredFeature("bulbis_tree5",
        BYGFeatures.BULBIS_TREE5.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE6 = createConfiguredFeature("bulbis_tree6",
        BYGFeatures.BULBIS_TREE6.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE7 = createConfiguredFeature("bulbis_tree7",
        BYGFeatures.BULBIS_TREE7.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_BUSH1 = createConfiguredFeature("purple_bulbis_bush1",
        BYGFeatures.BULBIS_BUSH1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE1 = createConfiguredFeature("purple_bulbis_tree1",
        BYGFeatures.BULBIS_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE2 = createConfiguredFeature("purple_bulbis_tree2",
        BYGFeatures.BULBIS_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE3 = createConfiguredFeature("purple_bulbis_tree3",
        BYGFeatures.BULBIS_TREE3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE4 = createConfiguredFeature("purple_bulbis_tree4",
        BYGFeatures.BULBIS_TREE4.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE5 = createConfiguredFeature("purple_bulbis_tree5",
        BYGFeatures.BULBIS_TREE5.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE6 = createConfiguredFeature("purple_bulbis_tree6",
        BYGFeatures.BULBIS_TREE6.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE7 = createConfiguredFeature("purple_bulbis_tree7",
        BYGFeatures.BULBIS_TREE7.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BULBIS_WOOD)
                .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));


    public static final ConfiguredFeature<?, ?> BULBIS_TREES = createConfiguredFeature("bulbis_trees",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(BULBIS_BUSH1.placed(), 0.14285f),
                new WeightedPlacedFeature(BULBIS_TREE1.placed(), 0.14285f),
                new WeightedPlacedFeature(BULBIS_TREE2.placed(), 0.14285f),
                new WeightedPlacedFeature(BULBIS_TREE3.placed(), 0.14285f),
                new WeightedPlacedFeature(BULBIS_TREE4.placed(), 0.14285f),
                new WeightedPlacedFeature(BULBIS_TREE5.placed(), 0.14285f),
                new WeightedPlacedFeature(BULBIS_TREE6.placed(), 0.14285f)),
                BULBIS_TREE7.placed())
        ));

    public static final ConfiguredFeature<?, ?> PURPLE_BULBIS_TREES = createConfiguredFeature("purple_bulbis_trees",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(PURPLE_BULBIS_BUSH1.placed(), 0.14285f),
                new WeightedPlacedFeature(PURPLE_BULBIS_TREE1.placed(), 0.14285f),
                new WeightedPlacedFeature(PURPLE_BULBIS_TREE2.placed(), 0.14285f),
                new WeightedPlacedFeature(PURPLE_BULBIS_TREE3.placed(), 0.14285f),
                new WeightedPlacedFeature(PURPLE_BULBIS_TREE4.placed(), 0.14285f),
                new WeightedPlacedFeature(PURPLE_BULBIS_TREE5.placed(), 0.14285f),
                new WeightedPlacedFeature(PURPLE_BULBIS_TREE6.placed(), 0.14285f)),
                PURPLE_BULBIS_TREE7.placed())
        ));


    public static final ConfiguredFeature<?, ?> NIGHTSHADE_TREES = createConfiguredFeature("nightshade_trees",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(NIGHTSHADE_TREE1.placed(), 0.15F),
                new WeightedPlacedFeature(NIGHTSHADE_TREE2.placed(), 0.3F),
                new WeightedPlacedFeature(NIGHTSHADE_TREE3.placed(), 0.3F)),
                NIGHTSHADE_TREE4.placed())
        ));

    public static final ConfiguredFeature<?, ?> NIGHTSHADE_SHRUBS = createConfiguredFeature("nightshade_shrubs",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(NIGHTSHADE_SHRUB1.placed(), 0.5F)),
                NIGHTSHADE_SHRUB2.placed())
        ));

    public static final ConfiguredFeature<?, ?> IVIS_PLANTS = createConfiguredFeature("ivis_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(IVIS_ROOTS.placed(), 0.5F)),
        IVIS_SPROUT.placed())
    ));

    public static final ConfiguredFeature<?, ?> BULBIS_ODDITIES = createConfiguredFeature("bulbis_oddities", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(BULBIS_ODDITY.placed(), 0.5F)),
        PURPLE_BULBIS_ODDITY.placed())
    ));

    public static final ConfiguredFeature<?, ?> BULBIS_ANOMALIES = createConfiguredFeature("bulbis_anomalies", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(BULBIS_ANOMALY.placed(), 0.5F)),
        PURPLE_BULBIS_ANOMALY.placed())
    ));

    public static final ConfiguredFeature<?, ?> NIGHTSHADE_PLANTS = createConfiguredFeature("nightshade_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(NIGHTSHADE_BERRY_BUSH.placed(), 0.2F),
        new WeightedPlacedFeature(NIGHTSHADE_ROOTS.placed(), 0.4F)),
        NIGHTSHADE_SPROUTS.placed())
    ));
}
