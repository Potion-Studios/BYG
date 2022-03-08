package potionstudios.byg.common.world.feature.features.end;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.config.HangingColumnWithBaseConfig;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;
import static potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil.createPlacedFeature;

public class BYGEndVegetationFeatures {

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> IVIS_ROOTS = createPatchConfiguredFeature("ivis_roots", BYGBlocks.IVIS_ROOTS, 32);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> IVIS_SPROUT = createPatchConfiguredFeature("ivis_sprout", BYGBlocks.IVIS_SPROUT, 32);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BULBIS_SPROUTS = createPatchConfiguredFeature("bulbis_sprouts", BYGBlocks.BULBIS_SPROUTS, 32);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CRYPTIC_BRAMBLE_PATCH = createPatchConfiguredFeature("cryptic_bramble_patch", BYGBlocks.CRYPTIC_BRAMBLE, 32);

    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> CRYPTIC_BRAMBLE = createConfiguredFeature("cryptic_bramble",
        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_BRAMBLE))
    );

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BULBIS_ODDITY = createPatchConfiguredFeature("bulbis_oddity", BYGBlocks.BULBIS_ODDITY, 32);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PURPLE_BULBIS_ODDITY = createPatchConfiguredFeature("purple_bulbis_oddity", BYGBlocks.PURPLE_BULBIS_ODDITY, 32);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BULBIS_ANOMALY = createPatchConfiguredFeature("bulbis_anomaly", BYGBlocks.BULBIS_ANOMALY, 48);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PURPLE_BULBIS_ANOMALY = createPatchConfiguredFeature("purple_bulbis_anomaly", BYGBlocks.PURPLE_BULBIS_ANOMALY, 48);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NIGHTSHADE_SPROUTS = createPatchConfiguredFeature("nightshade_sprouts", BYGBlocks.NIGHTSHADE_SPROUTS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NIGHTSHADE_ROOTS = createPatchConfiguredFeature("nightshade_roots", BYGBlocks.NIGHTSHADE_ROOTS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NIGHTSHADE_BERRY_BUSH = createPatchConfiguredFeature("nightshade_berry_bush", BYGBlocks.NIGHTSHADE_BERRY_BUSH, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> IMPARIUS_MUSHROOM = createPatchConfiguredFeature("imparius_mushroom", BYGBlocks.IMPARIUS_MUSHROOM, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FUNGAL_IMPARIUS_PATCH = createPatchConfiguredFeature("fungal_imparius_patch", BYGBlocks.FUNGAL_IMPARIUS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> IMPARIUS_BUSH = createPatchConfiguredFeature("imparius_bush", BYGBlocks.IMPARIUS_BUSH, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SHULKREN_FUNGUS = createPatchConfiguredFeature("shulkren_fungus", BYGBlocks.SHULKREN_FUNGUS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SHULKREN_MOSS = createPatchConfiguredFeature("shulkren_moss", BYGBlocks.SHULKREN_MOSS_BLANKET, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> THEREAL_BELLFLOWER = createFlowerConfiguredFeature("thereal_bellflower", BYGBlocks.THEREAL_BELLFLOWER);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TALL_ETHER_GRASS = createPatchConfiguredFeature("tall_ether_grass", BYGBlocks.TALL_ETHER_GRASS.defaultBlockState(), 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ETHER_GRASS = createPatchConfiguredFeature("ether_grass", BYGBlocks.ETHER_GRASS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ETHER_BUSH = createPatchConfiguredFeature("ether_bush", BYGBlocks.ETHER_BUSH, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ETHER_FOLIAGE = createPatchConfiguredFeature("ether_foliage", BYGBlocks.ETHER_FOLIAGE, 32);
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> ETHER_BULB = createSimpleBlockConfiguredFeature("ether_bulb", BYGBlocks.ETHER_BULB);

    public static final Holder<ConfiguredFeature<HangingColumnWithBaseConfig, ?>> HANGING_SHULKREN_VINE = createConfiguredFeature("hanging_shulkren_vine",
        BYGFeatures.HANGING_FEATURE,
        new HangingColumnWithBaseConfig.Builder()
            .setBaseBlock(Blocks.END_STONE)
            .setBlock(BYGBlocks.SHULKREN_VINE_PLANT.defaultBlockState())
            .setEndBlock(BYGBlocks.SHULKREN_VINE.defaultBlockState().setValue(BlockStateProperties.AGE_25, 23))
            .setMinLength(1)
            .setMaxLength(8)
            .setWhitelist(ImmutableList.of(Blocks.END_STONE, BYGBlocks.SHULKREN_PHYLIUM))
            .build()
    );

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ENDER_LILY = createConfiguredFeature("ender_lily",
        Feature.RANDOM_PATCH,
        new RandomPatchConfiguration(32, 4, 8,
            createPlacedFeature(createConfiguredFeature(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.ENDER_LILY))
            ), BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluid(Fluids.WATER, BlockPos.ZERO.relative(Direction.DOWN)))))
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_BUSH1 = createConfiguredFeature("ether_bush1",
        BYGFeatures.ETHER_BUSH1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ETHER_LOG)
            .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_BUSH2 = createConfiguredFeature("ether_bush2",
        BYGFeatures.ETHER_BUSH2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ETHER_LOG)
            .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE1 = createConfiguredFeature("ether_tree1",
        BYGFeatures.ETHER_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ETHER_LOG)
            .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE2 = createConfiguredFeature("ether_tree2",
        BYGFeatures.ETHER_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ETHER_LOG)
            .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE3 = createConfiguredFeature("ether_tree3",
        BYGFeatures.ETHER_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ETHER_LOG)
            .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE4 = createConfiguredFeature("ether_tree4",
        BYGFeatures.ETHER_TREE4,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ETHER_LOG)
            .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE5 = createConfiguredFeature("ether_tree5",
        BYGFeatures.ETHER_TREE5,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ETHER_LOG)
            .setLeavesBlock(BYGBlocks.ETHER_LEAVES)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE_DEAD1 = createConfiguredFeature("ether_tree_dead1",
        BYGFeatures.DEAD_ETHER_TREE1,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ETHER_WOOD)
            .setLeavesBlock(Blocks.AIR)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE_DEAD2 = createConfiguredFeature("ether_tree_dead2",
        BYGFeatures.DEAD_ETHER_TREE2,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ETHER_WOOD)
            .setLeavesBlock(Blocks.AIR)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE_DEAD3 = createConfiguredFeature("ether_tree_dead3",
        BYGFeatures.DEAD_ETHER_TREE3,
        new BYGTreeConfig.Builder()
            .setTrunkBlock(BYGBlocks.ETHER_WOOD)
            .setLeavesBlock(Blocks.AIR)
            .setMaxHeight(30)
            .setMinHeight(22)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_SHRUB1 = createConfiguredFeature("nightshade_shrub1",
        BYGFeatures.NIGHTSHADE_BUSH1,
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
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_SHRUB2 = createConfiguredFeature("nightshade_shrub2",
        BYGFeatures.NIGHTSHADE_BUSH2,
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
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_TREE1 = createConfiguredFeature("nightshade_tree1",
        BYGFeatures.NIGHTSHADE_TREE1,
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
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_TREE2 = createConfiguredFeature("nightshade_tree2",
        BYGFeatures.NIGHTSHADE_TREE2,
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
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_TREE3 = createConfiguredFeature("nightshade_tree3",
        BYGFeatures.NIGHTSHADE_TREE3,
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
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_TREE4 = createConfiguredFeature("nightshade_tree4",
        BYGFeatures.NIGHTSHADE_TREE4,
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
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> SHULKREN_TREE1 = createConfiguredFeature("shulkren_tree1",
        BYGFeatures.SHULKREN_TREE1,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM)
            .setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> SHULKREN_TREE2 = createConfiguredFeature("shulkren_tree2",
        BYGFeatures.SHULKREN_TREE2,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM)
            .setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM1 = createConfiguredFeature("imparius_mushroom1",
        BYGFeatures.IMPARIUS_MUSHROOM1,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.IMPARIUS_STEM)
            .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM2 = createConfiguredFeature("imparius_mushroom2",
        BYGFeatures.IMPARIUS_MUSHROOM2,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.IMPARIUS_STEM)
            .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM3 = createConfiguredFeature("imparius_mushroom3",
        BYGFeatures.IMPARIUS_MUSHROOM3,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.IMPARIUS_STEM)
            .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM4 = createConfiguredFeature("imparius_mushroom4",
        BYGFeatures.IMPARIUS_MUSHROOM4,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.IMPARIUS_STEM)
            .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM5 = createConfiguredFeature("imparius_mushroom5",
        BYGFeatures.IMPARIUS_MUSHROOM5,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.IMPARIUS_STEM)
            .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM6 = createConfiguredFeature("imparius_mushroom6",
        BYGFeatures.IMPARIUS_MUSHROOM6,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.IMPARIUS_STEM)
            .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> FUNGAL_IMPARIUS1 = createConfiguredFeature("fungal_imparius1",
        BYGFeatures.FUNGAL_IMPARIUS1,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM)
            .setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> FUNGAL_IMPARIUS2 = createConfiguredFeature("fungal_imparius2",
        BYGFeatures.FUNGAL_IMPARIUS2,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM)
            .setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> FUNGAL_IMPARIUS3 = createConfiguredFeature("fungal_imparius3",
        BYGFeatures.FUNGAL_IMPARIUS3,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM)
            .setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> FUNGAL_IMPARIUS4 = createConfiguredFeature("fungal_imparius4",
        BYGFeatures.FUNGAL_IMPARIUS4,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM)
            .setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> FUNGAL_IMPARIUS5 = createConfiguredFeature("fungal_imparius5",
        BYGFeatures.FUNGAL_IMPARIUS5,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM)
            .setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_BUSH1 = createConfiguredFeature("bulbis_bush1",
        BYGFeatures.BULBIS_BUSH1,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE1 = createConfiguredFeature("bulbis_tree1",
        BYGFeatures.BULBIS_TREE1,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE2 = createConfiguredFeature("bulbis_tree2",
        BYGFeatures.BULBIS_TREE2,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE3 = createConfiguredFeature("bulbis_tree3",
        BYGFeatures.BULBIS_TREE3,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE4 = createConfiguredFeature("bulbis_tree4",
        BYGFeatures.BULBIS_TREE4,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE5 = createConfiguredFeature("bulbis_tree5",
        BYGFeatures.BULBIS_TREE5,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE6 = createConfiguredFeature("bulbis_tree6",
        BYGFeatures.BULBIS_TREE6,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE7 = createConfiguredFeature("bulbis_tree7",
        BYGFeatures.BULBIS_TREE7,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_BUSH1 = createConfiguredFeature("purple_bulbis_bush1",
        BYGFeatures.BULBIS_BUSH1,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE1 = createConfiguredFeature("purple_bulbis_tree1",
        BYGFeatures.BULBIS_TREE1,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE2 = createConfiguredFeature("purple_bulbis_tree2",
        BYGFeatures.BULBIS_TREE2,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE3 = createConfiguredFeature("purple_bulbis_tree3",
        BYGFeatures.BULBIS_TREE3,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE4 = createConfiguredFeature("purple_bulbis_tree4",
        BYGFeatures.BULBIS_TREE4,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE5 = createConfiguredFeature("purple_bulbis_tree5",
        BYGFeatures.BULBIS_TREE5,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE6 = createConfiguredFeature("purple_bulbis_tree6",
        BYGFeatures.BULBIS_TREE6,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE7 = createConfiguredFeature("purple_bulbis_tree7",
        BYGFeatures.BULBIS_TREE7,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BULBIS_WOOD)
            .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BULBIS_TREES = createConfiguredFeature("bulbis_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(BULBIS_BUSH1), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(BULBIS_TREE1), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(BULBIS_TREE2), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(BULBIS_TREE3), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(BULBIS_TREE4), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(BULBIS_TREE5), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(BULBIS_TREE6), 0.14285f)),
            createPlacedFeature(BULBIS_TREE7))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PURPLE_BULBIS_TREES = createConfiguredFeature("purple_bulbis_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(PURPLE_BULBIS_BUSH1), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(PURPLE_BULBIS_TREE1), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(PURPLE_BULBIS_TREE2), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(PURPLE_BULBIS_TREE3), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(PURPLE_BULBIS_TREE4), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(PURPLE_BULBIS_TREE5), 0.14285f),
            new WeightedPlacedFeature(createPlacedFeature(PURPLE_BULBIS_TREE6), 0.14285f)),
            createPlacedFeature(PURPLE_BULBIS_TREE7))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> NIGHTSHADE_TREES = createConfiguredFeature("nightshade_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(NIGHTSHADE_TREE1), 0.15F),
            new WeightedPlacedFeature(createPlacedFeature(NIGHTSHADE_TREE2), 0.3F),
            new WeightedPlacedFeature(createPlacedFeature(NIGHTSHADE_TREE3), 0.3F)),
            createPlacedFeature(NIGHTSHADE_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SHULKREN_TREES = createConfiguredFeature("shulkren_trees",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(SHULKREN_TREE1), 0.5F)),
            createPlacedFeature(SHULKREN_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> NIGHTSHADE_SHRUBS = createConfiguredFeature("nightshade_shrubs",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(NIGHTSHADE_SHRUB1), 0.5F)),
            createPlacedFeature(NIGHTSHADE_SHRUB2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> LARGE_IMPARIUS_MUSHROOMS = createConfiguredFeature("large_imparius_mushrooms",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(IMPARIUS_MUSHROOM1), 0.166F),
            new WeightedPlacedFeature(createPlacedFeature(IMPARIUS_MUSHROOM2), 0.166F),
            new WeightedPlacedFeature(createPlacedFeature(IMPARIUS_MUSHROOM3), 0.166F),
            new WeightedPlacedFeature(createPlacedFeature(IMPARIUS_MUSHROOM4), 0.166F),
            new WeightedPlacedFeature(createPlacedFeature(IMPARIUS_MUSHROOM5), 0.166F)),
            createPlacedFeature(IMPARIUS_MUSHROOM6))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> FUNGAL_IMPARIUS = createConfiguredFeature("fungal_imparius",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(FUNGAL_IMPARIUS1), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(FUNGAL_IMPARIUS2), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(FUNGAL_IMPARIUS3), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(FUNGAL_IMPARIUS4), 0.2F)),
            createPlacedFeature(FUNGAL_IMPARIUS5))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> IVIS_PLANTS = createConfiguredFeature("ivis_plants", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(IVIS_ROOTS), 0.5F)),
        createPlacedFeature(IVIS_SPROUT))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BULBIS_ODDITIES = createConfiguredFeature("bulbis_oddities", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(BULBIS_ODDITY), 0.5F)),
        createPlacedFeature(PURPLE_BULBIS_ODDITY))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BULBIS_ANOMALIES = createConfiguredFeature("bulbis_anomalies", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(BULBIS_ANOMALY), 0.5F)),
        createPlacedFeature(PURPLE_BULBIS_ANOMALY))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SHULKREN_PLANTS = createConfiguredFeature("shulkren_plants", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(SHULKREN_FUNGUS), 0.5F)),
        createPlacedFeature(SHULKREN_MOSS))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> NIGHTSHADE_PLANTS = createConfiguredFeature("nightshade_plants", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(NIGHTSHADE_BERRY_BUSH), 0.2F),
        new WeightedPlacedFeature(createPlacedFeature(NIGHTSHADE_ROOTS), 0.4F)),
        createPlacedFeature(NIGHTSHADE_SPROUTS))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ETHER_PLANTS = createConfiguredFeature("ether_plants", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(ETHER_BUSH), 0.2F),
        new WeightedPlacedFeature(createPlacedFeature(ETHER_GRASS), 0.4F)),
        createPlacedFeature(TALL_ETHER_GRASS))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ETHER_TREES = createConfiguredFeature("ether_trees", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(ETHER_TREE1), 0.2F),
        new WeightedPlacedFeature(createPlacedFeature(ETHER_TREE2), 0.2F),
        new WeightedPlacedFeature(createPlacedFeature(ETHER_TREE3), 0.2F),
        new WeightedPlacedFeature(createPlacedFeature(ETHER_TREE4), 0.2F)),
        createPlacedFeature(ETHER_TREE5))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> DEAD_ETHER_TREES = createConfiguredFeature("dead_ether_trees", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(ETHER_TREE_DEAD1), 0.33F),
        new WeightedPlacedFeature(createPlacedFeature(ETHER_TREE_DEAD2), 0.33F)),
        createPlacedFeature(ETHER_TREE_DEAD3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ETHER_BUSHES = createConfiguredFeature("ether_bushes", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(ETHER_BUSH1), 0.5F)),
        createPlacedFeature(ETHER_BUSH2)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> IMPARIUS_PLANTS = createConfiguredFeature("imparius_plants", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(IMPARIUS_BUSH), 0.2F),
        new WeightedPlacedFeature(createPlacedFeature(FUNGAL_IMPARIUS_PATCH), 0.4F)),
        createPlacedFeature(IMPARIUS_MUSHROOM))
    );
}
