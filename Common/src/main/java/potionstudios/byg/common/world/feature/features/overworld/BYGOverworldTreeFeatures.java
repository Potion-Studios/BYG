package potionstudios.byg.common.world.feature.features.overworld;

import com.google.common.collect.ImmutableList;
import corgitaco.corgilib.world.level.feature.CorgiLibFeatures;
import corgitaco.corgilib.world.level.feature.gen.configurations.TreeFromStructureNBTConfig;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangrovePropaguleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.features.BYGFeaturesUtil;
import potionstudios.byg.common.world.feature.gen.overworld.trees.decorators.AttachedToLogsDecorator;
import potionstudios.byg.common.world.feature.gen.overworld.trees.decorators.BYGLeavesVineDecorator;
import potionstudios.byg.common.world.feature.gen.overworld.trees.decorators.BYGTrunkVineDecorator;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;

import java.util.List;
import java.util.function.Supplier;

import static potionstudios.byg.common.block.BYGWoodTypes.*;

public class BYGOverworldTreeFeatures {
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ARAUCARIA_TREE1 = createConfiguredFeature("araucaria_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/araucaria/araucaria_tree_trunk1"),
                    BYG.createLocation("features/trees/araucaria/araucaria_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(PINE.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ARAUCARIA_LEAVES.defaultBlockState(), 1).build()),
                    PINE.log(),
                    BYGBlocks.ARAUCARIA_LEAVES,
                    BYGBlockTags.GROUND_ARAUCARIA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ARAUCARIA_TREE2 = createConfiguredFeature("araucaria_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/araucaria/araucaria_tree_trunk1"),
                    BYG.createLocation("features/trees/araucaria/araucaria_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(PINE.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ARAUCARIA_LEAVES.defaultBlockState(), 1).build()),
                    PINE.log(),
                    BYGBlocks.ARAUCARIA_LEAVES,
                    BYGBlockTags.GROUND_ARAUCARIA_SAPLING, 5, ImmutableList.of()
            )
    );


    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ANCIENT_TREE1 = createConfiguredFeature("ancient_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/ancient/ancient_tree_trunk1"),
                    BYG.createLocation("features/trees/ancient/ancient_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.DARK_OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.DARK_OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.DARK_OAK_LOG,
                    Blocks.DARK_OAK_LEAVES,
                    BYGBlockTags.GROUND_EBONY_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ANCIENT_TREE2 = createConfiguredFeature("ancient_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/ancient/ancient_tree_trunk2"),
                    BYG.createLocation("features/trees/ancient/ancient_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(EBONY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(EBONY.leaves().defaultBlockState(), 1).build()),
                    EBONY.log(),
                    EBONY.leaves(),
                    BYGBlockTags.GROUND_EBONY_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ANCIENT_TREE3 = createConfiguredFeature("ancient_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/ancient/ancient_tree_trunk3"),
                    BYG.createLocation("features/trees/ancient/ancient_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(MAPLE.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SILVER_MAPLE_LEAVES.defaultBlockState(), 1).build()),
                    MAPLE.log(),
                    BYGBlocks.SILVER_MAPLE_LEAVES,
                    BYGBlockTags.GROUND_EBONY_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ASPEN_SHRUB1 = createConfiguredFeature("aspen_shrub1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen-shrub/aspen_shrub_trunk1"),
                    BYG.createLocation("features/trees/aspen-shrub/aspen_shrub_canopy1"),
                    BiasedToBottomInt.of(0, 0),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 1, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ASPEN_SHRUB2 = createConfiguredFeature("aspen_shrub2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen-shrub/aspen_shrub_trunk1"),
                    BYG.createLocation("features/trees/aspen-shrub/aspen_shrub_canopy2"),
                    BiasedToBottomInt.of(0, 0),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 1, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ASPEN_TREE1 = createConfiguredFeature("aspen_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen/aspen_trunk1"),
                    BYG.createLocation("features/trees/aspen/aspen_canopy1"),
                    BiasedToBottomInt.of(4, 7),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 4, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ASPEN_TREE2 = createConfiguredFeature("aspen_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen/aspen_trunk2"),
                    BYG.createLocation("features/trees/aspen/aspen_canopy2"),
                    BiasedToBottomInt.of(4, 7),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 8, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ASPEN_TREE3 = createConfiguredFeature("aspen_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen/aspen_trunk3"),
                    BYG.createLocation("features/trees/aspen/aspen_canopy3"),
                    BiasedToBottomInt.of(4, 7),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 4, ImmutableList.of()
            )
    );

    //TODO: Fruit

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BAOBAB_TREE1 = createConfiguredFeature("baobab_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/baobab/baobab_tree_trunk1"),
                    BYG.createLocation("features/trees/baobab/baobab_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(PINE.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BAOBAB.leaves().defaultBlockState(), 1).build()),
                    BAOBAB.log(),
                    BAOBAB.leaves(),
                    BYGBlockTags.GROUND_BAOBAB_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BAOBAB_TREE2 = createConfiguredFeature("baobab_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/baobab/baobab_tree_trunk2"),
                    BYG.createLocation("features/trees/baobab/baobab_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(PINE.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BAOBAB.leaves().defaultBlockState(), 1).build()),
                    BAOBAB.log(),
                    BAOBAB.leaves(),
                    BYGBlockTags.GROUND_BAOBAB_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BAOBAB_TREE3 = createConfiguredFeature("baobab_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/baobab/baobab_tree_trunk3"),
                    BYG.createLocation("features/trees/baobab/baobab_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(PINE.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BAOBAB.leaves().defaultBlockState(), 1).build()),
                    BAOBAB.log(),
                    BAOBAB.leaves(),
                    BYGBlockTags.GROUND_BAOBAB_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_TREE1 = createConfiguredFeature("birch_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_TREE2 = createConfiguredFeature("birch_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_TREE3 = createConfiguredFeature("birch_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_TREE4 = createConfiguredFeature("birch_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BROWN_BIRCH_TREE1 = createConfiguredFeature("brown_birch_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BROWN_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BROWN_BIRCH_TREE2 = createConfiguredFeature("brown_birch_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BROWN_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BROWN_BIRCH_TREE3 = createConfiguredFeature("brown_birch_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BROWN_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BROWN_BIRCH_TREE4 = createConfiguredFeature("brown_birch_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BROWN_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );


    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_ORANGE_TREE1 = createConfiguredFeature("orange_birch_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_ORANGE_TREE2 = createConfiguredFeature("orange_birch_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_ORANGE_TREE3 = createConfiguredFeature("orange_birch_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_ORANGE_TREE4 = createConfiguredFeature("orange_birch_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );


    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_RED_TREE1 = createConfiguredFeature("red_birch_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_RED_TREE2 = createConfiguredFeature("red_birch_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_RED_TREE3 = createConfiguredFeature("red_birch_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_RED_TREE4 = createConfiguredFeature("red_birch_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );


    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_YELLOW_TREE1 = createConfiguredFeature("yellow_birch_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_YELLOW_TREE2 = createConfiguredFeature("yellow_birch_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_YELLOW_TREE3 = createConfiguredFeature("yellow_birch_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_YELLOW_TREE4 = createConfiguredFeature("yellow_birch_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BLUFF_TREE1 = createConfiguredFeature("bluff_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bluff/bluff_trunk2"),
                    BYG.createLocation("features/trees/bluff/bluff_canopy1"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BYGBlockTags.GROUND_BLUE_SPRUCE_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BLUFF_TREE2 = createConfiguredFeature("bluff_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bluff/bluff_trunk2"),
                    BYG.createLocation("features/trees/bluff/bluff_canopy2"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BYGBlockTags.GROUND_BLUE_SPRUCE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_BOREAL_TREE1 = createConfiguredFeature("birch_boreal_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_yellow_boreal_trunk"),
                    BYG.createLocation("features/trees/birch/birch_yellow_boreal_canopy"),
                    BiasedToBottomInt.of(3, 5),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    Blocks.BIRCH_LEAVES,
                    BYGBlockTags.GROUND_YELLOW_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BIRCH_YELLOW_BOREAL_TREE1 = createConfiguredFeature("birch_yellow_boreal_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_boreal_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_boreal_canopy1"),
                    BiasedToBottomInt.of(3, 5),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_BIRCH_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.YELLOW_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_YELLOW_BIRCH_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CHERRY_PINK_TREE1 = createConfiguredFeature("pink_cherry_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cherry/cherry_tree_trunk1"),
                    BYG.createLocation("features/trees/cherry/cherry_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(CHERRY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PINK_CHERRY_LEAVES.defaultBlockState(), 1).build()),
                    CHERRY.log().get(),
                    BYGBlocks.PINK_CHERRY_LEAVES.get(),
                    BYGBlockTags.GROUND_PINK_CHERRY_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CHERRY_PINK_TREE2 = createConfiguredFeature("pink_cherry_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cherry/cherry_tree_trunk2"),
                    BYG.createLocation("features/trees/cherry/cherry_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(CHERRY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PINK_CHERRY_LEAVES.defaultBlockState(), 1).build()),
                    CHERRY.log().get(),
                    BYGBlocks.PINK_CHERRY_LEAVES.get(),
                    BYGBlockTags.GROUND_WHITE_CHERRY_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CHERRY_WHITE_TREE1 = createConfiguredFeature("white_cherry_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cherry/cherry_tree_trunk1"),
                    BYG.createLocation("features/trees/cherry/cherry_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(CHERRY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.WHITE_CHERRY_LEAVES.defaultBlockState(), 1).build()),
                    CHERRY.log().get(),
                    BYGBlocks.PINK_CHERRY_LEAVES.get(),
                    BYGBlockTags.GROUND_WHITE_CHERRY_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CHERRY_WHITE_TREE2 = createConfiguredFeature("white_cherry_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cherry/cherry_tree_trunk2"),
                    BYG.createLocation("features/trees/cherry/cherry_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(CHERRY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.WHITE_CHERRY_LEAVES.defaultBlockState(), 1).build()),
                    CHERRY.log().get(),
                    BYGBlocks.PINK_CHERRY_LEAVES.get(),
                    BYGBlockTags.GROUND_PINK_CHERRY_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CIKA_TREE1 = createConfiguredFeature("cika_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cika/cika_trunk1"),
                    BYG.createLocation("features/trees/cika/cika_canopy1"),
                    BiasedToBottomInt.of(14, 21),
                    BlockStateProvider.simple(CIKA.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CIKA.leaves().defaultBlockState(), 1).build()),
                    CIKA.log().get(),
                    CIKA.leaves().get(),
                    BYGBlockTags.GROUND_CIKA_SAPLING, 14, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CIKA_TREE2 = createConfiguredFeature("cika_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cika/cika_trunk2"),
                    BYG.createLocation("features/trees/cika/cika_canopy2"),
                    BiasedToBottomInt.of(5, 12),
                    BlockStateProvider.simple(CIKA.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CIKA.leaves().defaultBlockState(), 1).build()),
                    CIKA.log().get(),
                    CIKA.leaves().get(),
                    BYGBlockTags.GROUND_CIKA_SAPLING, 12, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CIKA_TREE3 = createConfiguredFeature("cika_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cika/cika_trunk3"),
                    BYG.createLocation("features/trees/cika/cika_canopy3"),
                    BiasedToBottomInt.of(7, 18),
                    BlockStateProvider.simple(CIKA.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CIKA.leaves().defaultBlockState(), 1).build()),
                    CIKA.log().get(),
                    CIKA.leaves().get(),
                    BYGBlockTags.GROUND_CIKA_SAPLING, 14, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CONIFER_TREE1 = createConfiguredFeature("conifer_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy1"),
                    BiasedToBottomInt.of(19,25),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CONIFER_TREE2 = createConfiguredFeature("conifer_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy2"),
                    BiasedToBottomInt.of(23, 30),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CONIFER_TREE3 = createConfiguredFeature("conifer_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy3"),
                    BiasedToBottomInt.of(26,35),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CONIFER_TREE4 = createConfiguredFeature("conifer_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy4"),
                    BiasedToBottomInt.of(25, 35),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CONIFER_TREE5 = createConfiguredFeature("conifer_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy5"),
                    BiasedToBottomInt.of(7,11),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CONIFER_TREE6 = createConfiguredFeature("conifer_tree6",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy6"),
                    BiasedToBottomInt.of(10,15),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CONIFER_TREE7 = createConfiguredFeature("conifer_tree7",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy7"),
                    BiasedToBottomInt.of(11,18),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CONIFER_TREE8 = createConfiguredFeature("conifer_tree8",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk8"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy8"),
                    BiasedToBottomInt.of(12,18),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CYPRESS_TREE1 = createConfiguredFeature("cypress_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cypress/cypress_trunk1"),
                    BYG.createLocation("features/trees/cypress/cypress_canopy1"),
                    BiasedToBottomInt.of(14, 16),
                    BlockStateProvider.simple(CYPRESS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CYPRESS.leaves().defaultBlockState(), 1).build()),
                    CYPRESS.log().get(),
                    CYPRESS.leaves().get(),
                    BYGBlockTags.GROUND_CYPRESS_SAPLING, 14, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CYPRESS_TREE2 = createConfiguredFeature("cypress_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cypress/cypress_trunk2"),
                    BYG.createLocation("features/trees/cypress/cypress_canopy2"),
                    BiasedToBottomInt.of(10, 13),
                    BlockStateProvider.simple(CYPRESS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CYPRESS.leaves().defaultBlockState(), 1).build()),
                    CYPRESS.log().get(),
                    CYPRESS.leaves().get(),
                    BYGBlockTags.GROUND_CYPRESS_SAPLING, 14, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> CYPRESS_TREE3 = createConfiguredFeature("cypress_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cypress/cypress_trunk3"),
                    BYG.createLocation("features/trees/cypress/cypress_canopy3"),
                    BiasedToBottomInt.of(10, 13),
                    BlockStateProvider.simple(CYPRESS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CYPRESS.leaves().defaultBlockState(), 1).build()),
                    CYPRESS.log().get(),
                    CYPRESS.leaves().get(),
                    BYGBlockTags.GROUND_CYPRESS_SAPLING, 14, ImmutableList.of()
            )
    );

    public static final Supplier<AttachedToLogsDecorator> WITCH_HAZEL_BLOSSOM = () -> new AttachedToLogsDecorator(0.1F, 15, 15, SimpleStateProvider.simple(BYGBlocks.WITCH_HAZEL_BLOSSOM.defaultBlockState()), 3, List.of(Direction.DOWN));
    public static final Supplier<AttachedToLogsDecorator> WITCH_HAZEL_BRANCH = () -> new AttachedToLogsDecorator(0.65F, 0, 1, SimpleStateProvider.simple(BYGBlocks.WITCH_HAZEL_BRANCH.defaultBlockState()), 2, List.of(Direction.WEST, Direction.NORTH, Direction.SOUTH, Direction.EAST));
    public static final Supplier<AttachedToLogsDecorator> MOSS_CARPET = () -> new AttachedToLogsDecorator(0.9F, 0, 0, SimpleStateProvider.simple(Blocks.MOSS_CARPET.defaultBlockState()), 1, List.of(Direction.UP));


    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> WITCH_HAZEL1 = createConfiguredFeature("witch_hazel1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/witch-hazel/witch-hazel_trunk_1"),
                    BYG.createLocation("features/trees/witch-hazel/witch-hazel_canopy_1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WITCH_HAZEL.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1).add(WITCH_HAZEL.leaves().defaultBlockState(), 4).build()),
                    WITCH_HAZEL.log(),
                    WITCH_HAZEL.leaves(),
                    BYGBlockTags.GROUND_WITCH_HAZEL_SAPLING, 5, ImmutableList.of(WITCH_HAZEL_BLOSSOM.get(), WITCH_HAZEL_BRANCH.get())
            )
    );



    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> WITCH_HAZEL2 = createConfiguredFeature("witch_hazel2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/witch-hazel/witch-hazel_trunk_2"),
                    BYG.createLocation("features/trees/witch-hazel/witch-hazel_canopy_2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WITCH_HAZEL.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1).add(WITCH_HAZEL.leaves().defaultBlockState(), 4).build()),
                    WITCH_HAZEL.log(),
                    WITCH_HAZEL.leaves(),
                    BYGBlockTags.GROUND_WITCH_HAZEL_SAPLING, 5, ImmutableList.of(WITCH_HAZEL_BLOSSOM.get(), WITCH_HAZEL_BRANCH.get())
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> WITCH_HAZEL3 = createConfiguredFeature("witch_hazel3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/witch-hazel/witch-hazel_trunk_3"),
                    BYG.createLocation("features/trees/witch-hazel/witch-hazel_canopy_3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WITCH_HAZEL.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1).add(WITCH_HAZEL.leaves().defaultBlockState(), 4).build()),
                    WITCH_HAZEL.log(),
                    WITCH_HAZEL.leaves(),
                    BYGBlockTags.GROUND_WITCH_HAZEL_SAPLING, 5, ImmutableList.of(WITCH_HAZEL_BLOSSOM.get(), WITCH_HAZEL_BRANCH.get())
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> WITCH_HAZEL4 = createConfiguredFeature("witch_hazel4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/witch-hazel/witch-hazel_trunk_4"),
                    BYG.createLocation("features/trees/witch-hazel/witch-hazel_canopy_4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WITCH_HAZEL.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1).add(WITCH_HAZEL.leaves().defaultBlockState(), 4).build()),
                    WITCH_HAZEL.log(),
                    WITCH_HAZEL.leaves(),
                    BYGBlockTags.GROUND_WITCH_HAZEL_SAPLING, 5, ImmutableList.of(WITCH_HAZEL_BLOSSOM.get(), WITCH_HAZEL_BRANCH.get())
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> WITCH_HAZEL5 = createConfiguredFeature("witch_hazel5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/witch-hazel/witch-hazel_trunk_5"),
                    BYG.createLocation("features/trees/witch-hazel/witch-hazel_canopy_5"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WITCH_HAZEL.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.defaultBlockState(), 1).add(WITCH_HAZEL.leaves().defaultBlockState(), 4).build()),
                    WITCH_HAZEL.log(),
                    WITCH_HAZEL.leaves(),
                    BYGBlockTags.GROUND_WITCH_HAZEL_SAPLING, 5, ImmutableList.of(WITCH_HAZEL_BLOSSOM.get(), WITCH_HAZEL_BRANCH.get())
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> FIRECRACKER_SHRUB = createConfiguredFeature("firecracker_shrub",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/firecracker-shrub/firecracker_canopy1"),
                    BiasedToBottomInt.of(0, 0),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FIRECRACKER_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.FIRECRACKER_LEAVES.get(),
                    BYGBlockTags.GROUND_FIRECRACKER_FLOWER_BUSH, 1, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> FIRECRACKER_SHRUB2 = createConfiguredFeature("firecracker_shrub2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/firecracker-shrub/firecracker_canopy2"),
                    BiasedToBottomInt.of(0, 0),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FIRECRACKER_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.FIRECRACKER_LEAVES.get(),
                    BYGBlockTags.GROUND_FIRECRACKER_FLOWER_BUSH, 1, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_TREE1 = createConfiguredFeature("deciduous_tree1",
            BYGFeatures.DECIDUOUS_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(19)
                    .setMinHeight(14)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_TREE2 = createConfiguredFeature("deciduous_tree2",
            BYGFeatures.DECIDUOUS_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(22)
                    .setMinHeight(17)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_TREE3 = createConfiguredFeature("deciduous_tree3",
            BYGFeatures.DECIDUOUS_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(21)
                    .setMinHeight(16)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_TREE4 = createConfiguredFeature("deciduous_tree4",
            BYGFeatures.DECIDUOUS_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(21)
                    .setMinHeight(16)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_RED_TREE1 = createConfiguredFeature("deciduous_red_tree1",
            BYGFeatures.DECIDUOUS_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE1.value().config())
                    .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_RED_TREE2 = createConfiguredFeature("deciduous_red_tree2",
            BYGFeatures.DECIDUOUS_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE2.value().config())
                    .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_RED_TREE3 = createConfiguredFeature("deciduous_red_tree3",
            BYGFeatures.DECIDUOUS_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE3.value().config())
                    .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_RED_TREE4 = createConfiguredFeature("deciduous_red_tree4",
            BYGFeatures.DECIDUOUS_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE4.value().config())
                    .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_ORANGE_TREE1 = createConfiguredFeature("deciduous_orange_tree1",
            BYGFeatures.DECIDUOUS_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE1.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_ORANGE_TREE2 = createConfiguredFeature("deciduous_orange_tree2",
            BYGFeatures.DECIDUOUS_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE2.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_ORANGE_TREE3 = createConfiguredFeature("deciduous_orange_tree3",
            BYGFeatures.DECIDUOUS_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE3.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_ORANGE_TREE4 = createConfiguredFeature("deciduous_orange_tree4",
            BYGFeatures.DECIDUOUS_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE4.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_BROWN_TREE1 = createConfiguredFeature("deciduous_brown_tree1",
            BYGFeatures.DECIDUOUS_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE1.value().config())
                    .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_BROWN_TREE2 = createConfiguredFeature("deciduous_brown_tree2",
            BYGFeatures.DECIDUOUS_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE2.value().config())
                    .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_BROWN_TREE3 = createConfiguredFeature("deciduous_brown_tree3",
            BYGFeatures.DECIDUOUS_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE3.value().config())
                    .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> DECIDUOUS_BROWN_TREE4 = createConfiguredFeature("deciduous_brown_tree4",
            BYGFeatures.DECIDUOUS_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .copy(DECIDUOUS_TREE4.value().config())
                    .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> EBONY_BUSH1 = createConfiguredFeature("ebony_bush1",
            BYGFeatures.EBONY_BUSH1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.EBONY)
                    .setMaxHeight(28)
                    .setMinHeight(23)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> EBONY_TREE1 = createConfiguredFeature("ebony_tree1",
            BYGFeatures.EBONY_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.EBONY)
                    .setMaxHeight(13)
                    .setMinHeight(6)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> EBONY_TREE2 = createConfiguredFeature("ebony_tree2",
            BYGFeatures.EBONY_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.EBONY)
                    .setMaxHeight(17)
                    .setMinHeight(11)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_BLUE_TREE1 = createConfiguredFeature("blue_enchanted_tree1",
            BYGFeatures.ENCHANTED_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(BLUE_ENCHANTED.log().get())
                    .setLeavesBlock(BLUE_ENCHANTED.leaves().get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_BLUE_TREE2 = createConfiguredFeature("blue_enchanted_tree2",
            BYGFeatures.ENCHANTED_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(BLUE_ENCHANTED.log().get())
                    .setLeavesBlock(BLUE_ENCHANTED.leaves().get())
                    .setMaxHeight(26)
                    .setMinHeight(19)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_BLUE_TREE3 = createConfiguredFeature("blue_enchanted_tree3",
            BYGFeatures.ENCHANTED_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(BLUE_ENCHANTED.log().get())
                    .setLeavesBlock(BLUE_ENCHANTED.leaves().get())
                    .setMaxHeight(15)
                    .setMinHeight(9)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_GREEN_TREE1 = createConfiguredFeature("green_enchanted_tree1",
            BYGFeatures.ENCHANTED_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(ENCHANTED_BLUE_TREE1.value().config())
                    .fromWoodType(BYGWoodTypes.GREEN_ENCHANTED)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_GREEN_TREE2 = createConfiguredFeature("green_enchanted_tree2",
            BYGFeatures.ENCHANTED_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .copy(ENCHANTED_BLUE_TREE2.value().config())
                    .fromWoodType(BYGWoodTypes.GREEN_ENCHANTED)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_GREEN_TREE3 = createConfiguredFeature("green_enchanted_tree3",
            BYGFeatures.ENCHANTED_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .copy(ENCHANTED_BLUE_TREE3.value().config())
                    .fromWoodType(BYGWoodTypes.GREEN_ENCHANTED)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_BLUE_GROVE_TREE1 = createConfiguredFeature("blue_enchanted_grove_tree1",
            BYGFeatures.ENCHANTED_GROVE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(BLUE_ENCHANTED.log().get())
                    .setLeavesBlock(BLUE_ENCHANTED.leaves().get())
                    .setMaxHeight(15)
                    .setMinHeight(9)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ENCHANTED_GREEN_GROVE_TREE1 = createConfiguredFeature("green_enchanted_grove_tree1",
            BYGFeatures.ENCHANTED_GROVE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(ENCHANTED_BLUE_TREE1.value().config())
                    .fromWoodType(BYGWoodTypes.GREEN_ENCHANTED)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> HOLLY_TREE1 = createConfiguredFeature("holly_tree1",
            BYGFeatures.HOLLY_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(HOLLY.log())
                    .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.HOLLY_BERRY_LEAVES.defaultBlockState(), 1)
                            .add(HOLLY.leaves().defaultBlockState(), 10)))
                    .setMaxHeight(23)
                    .setMinHeight(17)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> HOLLY_TREE2 = createConfiguredFeature("holly_tree2",
            BYGFeatures.HOLLY_TREE2,
            () -> new BYGTreeConfig.Builder().copy(HOLLY_TREE1.value().config())
                    .setMaxHeight(15)
                    .setMinHeight(10)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> HOLLY_TREE3 = createConfiguredFeature("holly_tree3",
            BYGFeatures.HOLLY_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .copy(HOLLY_TREE1.value().config())
                    .setMaxHeight(25)
                    .setMinHeight(18)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> HOLLY_TREE4 = createConfiguredFeature("holly_tree4",
            BYGFeatures.HOLLY_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .copy(HOLLY_TREE1.value().config())
                    .setMaxHeight(14)
                    .setMinHeight(9)
                    .build()
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BLUE_ENCHANTED_TREE1 = createConfiguredFeature("blue_echanted_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_1"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_1"),
                    BiasedToBottomInt.of(0, 1),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_BLUE_ENCHANTED_LOG.defaultBlockState(), 1).add(BLUE_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(BLUE_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.wood(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BLUE_ENCHANTED_TREE2 = createConfiguredFeature("blue_echanted_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_2"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_2"),
                    BiasedToBottomInt.of(0, 1),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_BLUE_ENCHANTED_LOG.defaultBlockState(), 1).add(BLUE_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(BLUE_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.wood(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BLUE_ENCHANTED_TREE3 = createConfiguredFeature("blue_echanted_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_3"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_3"),
                    BiasedToBottomInt.of(0, 2),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_BLUE_ENCHANTED_LOG.defaultBlockState(), 1).add(BLUE_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(BLUE_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.wood(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> BLUE_ENCHANTED_TREE4 = createConfiguredFeature("blue_echanted_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_4"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_4"),
                    BiasedToBottomInt.of(0, 0),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_BLUE_ENCHANTED_LOG.defaultBlockState(), 1).add(BLUE_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(BLUE_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.wood(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> GREEN_ENCHANTED_TREE1 = createConfiguredFeature("green_echanted_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_1"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_1"),
                    BiasedToBottomInt.of(0, 1),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_GREEN_ENCHANTED_LOG.defaultBlockState(), 1).add(GREEN_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(GREEN_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.wood(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_GREEN_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> GREEN_ENCHANTED_TREE2 = createConfiguredFeature("green_echanted_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_2"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_2"),
                    BiasedToBottomInt.of(0, 1),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_GREEN_ENCHANTED_LOG.defaultBlockState(), 1).add(GREEN_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(GREEN_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.wood(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_GREEN_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> GREEN_ENCHANTED_TREE3 = createConfiguredFeature("green_echanted_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_3"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_3"),
                    BiasedToBottomInt.of(0, 2),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_GREEN_ENCHANTED_LOG.defaultBlockState(), 1).add(GREEN_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(GREEN_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.wood(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_GREEN_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> GREEN_ENCHANTED_TREE4 = createConfiguredFeature("green_echanted_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_4"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_4"),
                    BiasedToBottomInt.of(0, 0),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_GREEN_ENCHANTED_LOG.defaultBlockState(), 1).add(GREEN_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(GREEN_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.wood(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_GREEN_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> JACARANDA_TREE1 = createConfiguredFeature("jacaranda_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/jacaranda/jacaranda_trunk_1"),
                    BYG.createLocation("features/trees/jacaranda/jacaranda_canopy_1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(JACARANDA.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FLOWERING_JACARANDA_LEAVES.defaultBlockState(), 1).add(JACARANDA.leaves().defaultBlockState(), 4).build()),
                    JACARANDA.log(),
                    JACARANDA.leaves(),
                    BYGBlockTags.GROUND_JACARANDA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> JACARANDA_TREE2 = createConfiguredFeature("jacaranda_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/jacaranda/jacaranda_trunk_2"),
                    BYG.createLocation("features/trees/jacaranda/jacaranda_canopy_2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(JACARANDA.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FLOWERING_JACARANDA_LEAVES.defaultBlockState(), 1).add(JACARANDA.leaves().defaultBlockState(), 4).build()),
                    JACARANDA.log(),
                    JACARANDA.leaves(),
                    BYGBlockTags.GROUND_JACARANDA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> JACARANDA_TREE3 = createConfiguredFeature("jacaranda_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/jacaranda/jacaranda_trunk_3"),
                    BYG.createLocation("features/trees/jacaranda/jacaranda_canopy_3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(JACARANDA.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FLOWERING_JACARANDA_LEAVES.defaultBlockState(), 1).add(JACARANDA.leaves().defaultBlockState(), 4).build()),
                    JACARANDA.log(),
                    JACARANDA.leaves(),
                    BYGBlockTags.GROUND_JACARANDA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> JACARANDA_TREE4 = createConfiguredFeature("jacaranda_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/jacaranda/jacaranda_trunk_4"),
                    BYG.createLocation("features/trees/jacaranda/jacaranda_canopy_4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(JACARANDA.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FLOWERING_JACARANDA_LEAVES.defaultBlockState(), 1).add(JACARANDA.leaves().defaultBlockState(), 4).build()),
                    JACARANDA.log(),
                    JACARANDA.leaves(),
                    BYGBlockTags.GROUND_JACARANDA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> INDIGO_JACARANDA_TREE1 = createConfiguredFeature("indigo_jacaranda_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/jacaranda/jacaranda_trunk_1"),
                    BYG.createLocation("features/trees/jacaranda/jacaranda_canopy_1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(JACARANDA.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FLOWERING_INDIGO_JACARANDA_LEAVES.defaultBlockState(), 1).add(BYGBlocks.INDIGO_JACARANDA_LEAVES.defaultBlockState(), 4).build()),
                    JACARANDA.log(),
                    JACARANDA.leaves(),
                    BYGBlockTags.GROUND_JACARANDA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> INDIGO_JACARANDA_TREE2 = createConfiguredFeature("indigo_jacaranda_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/jacaranda/jacaranda_trunk_2"),
                    BYG.createLocation("features/trees/jacaranda/jacaranda_canopy_2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(JACARANDA.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FLOWERING_INDIGO_JACARANDA_LEAVES.defaultBlockState(), 1).add(BYGBlocks.INDIGO_JACARANDA_LEAVES.defaultBlockState(), 4).build()),
                    JACARANDA.log(),
                    JACARANDA.leaves(),
                    BYGBlockTags.GROUND_JACARANDA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> INDIGO_JACARANDA_TREE3 = createConfiguredFeature("indigo_jacaranda_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/jacaranda/jacaranda_trunk_3"),
                    BYG.createLocation("features/trees/jacaranda/jacaranda_canopy_3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(JACARANDA.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FLOWERING_INDIGO_JACARANDA_LEAVES.defaultBlockState(), 1).add(BYGBlocks.INDIGO_JACARANDA_LEAVES.defaultBlockState(), 4).build()),
                    JACARANDA.log(),
                    JACARANDA.leaves(),
                    BYGBlockTags.GROUND_JACARANDA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> INDIGO_JACARANDA_TREE4 = createConfiguredFeature("indigo_jacaranda_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/jacaranda/jacaranda_trunk_4"),
                    BYG.createLocation("features/trees/jacaranda/jacaranda_canopy_4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(JACARANDA.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FLOWERING_INDIGO_JACARANDA_LEAVES.defaultBlockState(), 1).add(BYGBlocks.INDIGO_JACARANDA_LEAVES.defaultBlockState(), 4).build()),
                    JACARANDA.log(),
                    JACARANDA.leaves(),
                    BYGBlockTags.GROUND_JACARANDA_SAPLING, 5, ImmutableList.of()
            )
    );



    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> JOSHUA_TREE1 = createConfiguredFeature("joshua_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/joshua/joshua_trunk1"),
                    BYG.createLocation("features/trees/joshua/joshua_canopy1"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RIPE_JOSHUA_LEAVES.defaultBlockState(), 1).add(BYGBlocks.JOSHUA_LEAVES.defaultBlockState(),4).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.JOSHUA_LEAVES.get(),
                    BYGBlockTags.GROUND_JOSHUA_SAPLING, 4, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> JOSHUA_TREE2 = createConfiguredFeature("joshua_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/joshua/joshua_trunk2"),
                    BYG.createLocation("features/trees/joshua/joshua_canopy2"),
                    BiasedToBottomInt.of(5, 8),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RIPE_JOSHUA_LEAVES.defaultBlockState(), 1).add(BYGBlocks.JOSHUA_LEAVES.defaultBlockState(),4).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.JOSHUA_LEAVES.get(),
                    BYGBlockTags.GROUND_JOSHUA_SAPLING, 6, ImmutableList.of()
                    )
    );

    // TODO: BYG Propagule
    public static final Supplier<AttachedToLeavesDecorator> PROPAGULE_DECORATOR = () -> new AttachedToLeavesDecorator(0.14F, 1, 0, new RandomizedIntStateProvider(BlockStateProvider.simple(Blocks.MANGROVE_PROPAGULE.defaultBlockState().setValue(MangrovePropaguleBlock.HANGING, Boolean.TRUE)), MangrovePropaguleBlock.AGE, UniformInt.of(0, 4)), 2, List.of(Direction.DOWN));

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> MANGROVE_TREE1 = createConfiguredFeature("white_mangrove_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/white_mangrove_tree1_base"),
                    BYG.createLocation("features/trees/white_mangrove_tree1_canopy"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    BlockStateProvider.simple(WHITE_MANGROVE.leaves().get()),
                    WHITE_MANGROVE.log(),
                    WHITE_MANGROVE.leaves(),
                    BYGBlockTags.GROUND_MANGROVE_TREE, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> MANGROVE_TREE2 = createConfiguredFeature("white_mangrove_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/white_mangrove_tree2_base"),
                    BYG.createLocation("features/trees/white_mangrove_tree2_canopy"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    BlockStateProvider.simple(WHITE_MANGROVE.leaves().get()),
                    WHITE_MANGROVE.log(),
                    WHITE_MANGROVE.leaves(),
                    BlockTags.DIRT, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> MANGROVE_TREE3 = createConfiguredFeature("white_mangrove_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/white_mangrove_tree3_base"),
                    BYG.createLocation("features/trees/white_mangrove_tree3_canopy"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    BlockStateProvider.simple(WHITE_MANGROVE.leaves().get()),
                    WHITE_MANGROVE.log(),
                    WHITE_MANGROVE.leaves(),
                    BYGBlockTags.GROUND_MANGROVE_TREE, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> MANGROVE_TREE4 = createConfiguredFeature("white_mangrove_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/white_mangrove_tree4_base"),
                    BYG.createLocation("features/trees/white_mangrove_tree4_canopy"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    BlockStateProvider.simple(WHITE_MANGROVE.leaves().get()),
                    WHITE_MANGROVE.log(),
                    WHITE_MANGROVE.leaves(),
                    BYGBlockTags.GROUND_MANGROVE_TREE, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> MANGROVE_TREE5 = createConfiguredFeature("white_mangrove_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/white_mangrove_tree5_base"),
                    BYG.createLocation("features/trees/white_mangrove_tree5_canopy"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    BlockStateProvider.simple(WHITE_MANGROVE.leaves().get()),
                    WHITE_MANGROVE.log(),
                    WHITE_MANGROVE.leaves(),
                    BYGBlockTags.GROUND_MANGROVE_TREE, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> IRONWOOD_TREE = createConfiguredFeature("ironwood_tree",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/ironwood/ironwood_trunk_1"),
                    BYG.createLocation("features/trees/ironwood/ironwood_canopy_1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.AZALEA_LEAVES.defaultBlockState(), 4).add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    () -> Blocks.AZALEA_LEAVES,
                    BYGBlockTags.GROUND_MANGROVE_TREE, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator())
            )
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAPLE_RED_TREE1 = createConfiguredFeature("red_maple_tree1",
            BYGFeatures.MAPLE_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(MAPLE.log().get())
                    .setLeavesBlock(BYGBlocks.RED_MAPLE_LEAVES.get())
                    .setMaxHeight(9)
                    .setMinHeight(4)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAPLE_RED_TREE2 = createConfiguredFeature("red_maple_tree2",
            BYGFeatures.MAPLE_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(MAPLE.log().get())
                    .setLeavesBlock(BYGBlocks.RED_MAPLE_LEAVES.get())
                    .setMaxHeight(9)
                    .setMinHeight(4)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAPLE_SILVER_TREE1 = createConfiguredFeature("silver_maple_tree1",
            BYGFeatures.MAPLE_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .copy(MAPLE_RED_TREE1.value().config())
                    .setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAPLE_SILVER_TREE2 = createConfiguredFeature("silver_maple_tree2",
            BYGFeatures.MAPLE_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .copy(MAPLE_RED_TREE2.value().config())
                    .setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAPLE_TREE1 = createConfiguredFeature("maple_tree1",
            BYGFeatures.MAPLE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(MAPLE)
                    .setMaxHeight(10)
                    .setMinHeight(5)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MEADOW_TREE1 = createConfiguredFeature("meadow_tree1",
            BYGFeatures.MEADOW_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(9)
                    .setMinHeight(4)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MEADOW_TREE2 = createConfiguredFeature("meadow_tree2",
            BYGFeatures.MEADOW_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.DARK_OAK_LOG)
                    .setLeavesBlock(Blocks.DARK_OAK_LEAVES)
                    .setMaxHeight(9)
                    .setMinHeight(4)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MEADOW_TREE3 = createConfiguredFeature("meadow_tree3",
            BYGFeatures.MEADOW_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.DARK_OAK_LOG)
                    .setLeavesBlock(Blocks.DARK_OAK_LEAVES)
                    .setMaxHeight(9)
                    .setMinHeight(4)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE1 = createConfiguredFeature("oak_tree1",
            BYGFeatures.OAK_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE2 = createConfiguredFeature("oak_tree2",
            BYGFeatures.OAK_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE3 = createConfiguredFeature("oak_tree3",
            BYGFeatures.OAK_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE_LARGE1 = createConfiguredFeature("large_oak_tree1",
            BYGFeatures.OAK_TREE_LARGE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE_LARGE2 = createConfiguredFeature("large_oak_tree2",
            BYGFeatures.OAK_TREE_LARGE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> OAK_TREE_LARGE3 = createConfiguredFeature("large_oak_tree3",
            BYGFeatures.OAK_TREE_LARGE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE1 = createConfiguredFeature("red_oak_tree1",
            BYGFeatures.OAK_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE2 = createConfiguredFeature("red_oak_tree2",
            BYGFeatures.OAK_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE3 = createConfiguredFeature("red_oak_tree3",
            BYGFeatures.OAK_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE_LARGE1 = createConfiguredFeature("large_red_oak_tree1",
            BYGFeatures.OAK_TREE_LARGE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE_LARGE2 = createConfiguredFeature("large_red_oak_tree2",
            BYGFeatures.OAK_TREE_LARGE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RED_OAK_TREE_LARGE3 = createConfiguredFeature("large_red_oak_tree3",
            BYGFeatures.OAK_TREE_LARGE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.RED_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE1 = createConfiguredFeature("brown_oak_tree1", BYGFeatures.OAK_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE2 = createConfiguredFeature("brown_oak_tree2", BYGFeatures.OAK_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE3 = createConfiguredFeature("brown_oak_tree3", BYGFeatures.OAK_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE_LARGE1 = createConfiguredFeature("large_brown_oak_tree1",
            BYGFeatures.OAK_TREE_LARGE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE_LARGE2 = createConfiguredFeature("large_brown_oak_tree2",
            BYGFeatures.OAK_TREE_LARGE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> BROWN_OAK_TREE_LARGE3 = createConfiguredFeature("large_brown_oak_tree3",
            BYGFeatures.OAK_TREE_LARGE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE1 = createConfiguredFeature("orange_oak_tree1",
            BYGFeatures.OAK_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE2 = createConfiguredFeature("orange_oak_tree2",
            BYGFeatures.OAK_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE3 = createConfiguredFeature("orange_oak_tree3",
            BYGFeatures.OAK_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE_LARGE1 = createConfiguredFeature("large_orange_oak_tree1",
            BYGFeatures.OAK_TREE_LARGE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE_LARGE2 = createConfiguredFeature("large_orange_oak_tree2",
            BYGFeatures.OAK_TREE_LARGE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORANGE_OAK_TREE_LARGE3 = createConfiguredFeature("large_orange_oak_tree3",
            BYGFeatures.OAK_TREE_LARGE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES.get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ORCHARD_TREE1 = createConfiguredFeature("orchard_tree1",
            BYGFeatures.ORCHARD_TREE1,
            () -> new BYGTreeConfig.Builder()
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
            () -> new BYGTreeConfig.Builder()
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
            () -> new BYGTreeConfig.Builder()
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
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.PALM)
                    .setMaxHeight(5)
                    .setMinHeight(3)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PALM_TREE2 = createConfiguredFeature("palm_tree2",
            BYGFeatures.PALM_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.PALM)
                    .setMaxHeight(5)
                    .setMinHeight(3)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PALM_TREE3 = createConfiguredFeature("palm_tree3",
            BYGFeatures.PALM_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.PALM)
                    .setMaxHeight(5)
                    .setMinHeight(3)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PALM_TREE4 = createConfiguredFeature("palm_tree4",
            BYGFeatures.PALM_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.PALM)
                    .setMaxHeight(5)
                    .setMinHeight(3)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PINE_LARGE_TREE1 = createConfiguredFeature("large_pine_tree1", BYGFeatures.PINE_LARGE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.PINE)
                    .setMaxHeight(28)
                    .setMinHeight(23)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PINE_LARGE_TREE2 = createConfiguredFeature("large_pine_tree2", BYGFeatures.PINE_LARGE_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.PINE)
                    .setMaxHeight(31)
                    .setMinHeight(26)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PINE_TREE1 = createConfiguredFeature("pine_tree1", BYGFeatures.PINE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.PINE)
                    .setMaxHeight(20)
                    .setMinHeight(15)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PINE_TREE2 = createConfiguredFeature("pine_tree2", BYGFeatures.PINE_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.PINE)
                    .setMaxHeight(21)
                    .setMinHeight(16)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> PALO_VERDE_TREE1 = createConfiguredFeature("palo_verde_tree1",
            BYGFeatures.PALO_VERDE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(BYGBlocks.PALO_VERDE_LOG.get())
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
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(BYGBlocks.PALO_VERDE_LOG.get())
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
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.RAINBOW_EUCALYPTUS)
                    .setMaxHeight(32)
                    .setMinHeight(27)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> RAINBOW_LARGE_TREE1 = createConfiguredFeature("large_rainbow_eucalyptus_tree1",
            BYGFeatures.RAINBOW_LARGE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.RAINBOW_EUCALYPTUS)
                    .setMaxHeight(19)
                    .setMinHeight(16)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> REDWOOD_TREE1 = createConfiguredFeature("redwood_tree1",
            BYGFeatures.REDWOOD_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.REDWOOD)
                    .setMaxHeight(37)
                    .setMinHeight(36)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> REDWOOD_TREE2 = createConfiguredFeature("redwood_tree2",
            BYGFeatures.REDWOOD_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.REDWOOD)
                    .setMaxHeight(34)
                    .setMinHeight(31)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> REDWOOD_TREE3 = createConfiguredFeature("redwood_tree3",
            BYGFeatures.REDWOOD_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.REDWOOD)
                    .setMaxHeight(25)
                    .setMinHeight(18)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SHRUB_MEADOW = createConfiguredFeature("meadow_shrub1",
            BYGFeatures.SHRUB1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.DARK_OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMinHeight(1)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SHRUB_MEADOW2 = createConfiguredFeature("meadow_shrub2",
            BYGFeatures.SHRUB2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.DARK_OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMinHeight(1)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SHRUB_PRAIRIE1 = createConfiguredFeature("prairie_shrub1",
            BYGFeatures.SHRUB1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMinHeight(1)
                    .setMaxHeight(2)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SHRUB_PRAIRIE2 = createConfiguredFeature("prairie_shrub2",
            BYGFeatures.SHRUB2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMinHeight(1)
                    .build()
    );


    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> SKYRIS_TREE1 = createConfiguredFeature("skyris_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_1"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).add(SKYRIS.leaves().defaultBlockState(), 4).build()),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F))
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> SKYRIS_TREE2 = createConfiguredFeature("skyris_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_2"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).add(SKYRIS.leaves().defaultBlockState(), 4).build()),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F))
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> SKYRIS_TREE3 = createConfiguredFeature("skyris_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_3"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).add(SKYRIS.leaves().defaultBlockState(), 4).build()),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F))
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> SKYRIS_TREE4 = createConfiguredFeature("skyris_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_4"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).add(SKYRIS.leaves().defaultBlockState(), 4).build()),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F))
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> SKYRIS_TREE5 = createConfiguredFeature("skyris_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_5"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_5"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).add(SKYRIS.leaves().defaultBlockState(), 4).build()),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F))
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> SKYRIS_TREE6 = createConfiguredFeature("skyris_tree6",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_6"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_6"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).add(SKYRIS.leaves().defaultBlockState(), 4).build()),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F))
            )
    );


    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE1 = createConfiguredFeature("spruce_tree1",
            BYGFeatures.SPRUCE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.SPRUCE_LOG)
                    .setLeavesBlock(Blocks.SPRUCE_LEAVES)
                    .setMaxHeight(17)
                    .setMinHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE2 = createConfiguredFeature("spruce_tree2",
            BYGFeatures.SPRUCE_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.SPRUCE_LOG)
                    .setLeavesBlock(Blocks.SPRUCE_LEAVES)
                    .setMaxHeight(17)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE3 = createConfiguredFeature("spruce_tree3",
            BYGFeatures.SPRUCE_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.SPRUCE_LOG)
                    .setLeavesBlock(Blocks.SPRUCE_LEAVES)
                    .setMaxHeight(16)
                    .setMinHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE4 = createConfiguredFeature("spruce_tree4",
            BYGFeatures.SPRUCE_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.SPRUCE_LOG)
                    .setLeavesBlock(Blocks.SPRUCE_LEAVES)
                    .setMaxHeight(17)
                    .setMinHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE_MEDIUM1 = createConfiguredFeature("spruce_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.SPRUCE_LOG)
                    .setLeavesBlock(Blocks.SPRUCE_LEAVES)
                    .setMaxHeight(24)
                    .setMinHeight(19)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE_MEDIUM2 = createConfiguredFeature("spruce_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.SPRUCE_LOG)
                    .setLeavesBlock(Blocks.SPRUCE_LEAVES)
                    .setMaxHeight(25)
                    .setMinHeight(20)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE_MEDIUM3 = createConfiguredFeature("spruce_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.SPRUCE_LOG)
                    .setLeavesBlock(Blocks.SPRUCE_LEAVES)
                    .setMaxHeight(26)
                    .setMinHeight(21)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE_MEDIUM4 = createConfiguredFeature("spruce_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.SPRUCE_LOG)
                    .setLeavesBlock(Blocks.SPRUCE_LEAVES)
                    .setMaxHeight(25)
                    .setMinHeight(19)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_TREE_LARGE1 = createConfiguredFeature("spruce_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.SPRUCE_LOG)
                    .setLeavesBlock(Blocks.SPRUCE_LEAVES)
                    .setMaxHeight(55)
                    .setMinHeight(40)
                    .build()
    );

    //Yellow Spruce
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE1 = createConfiguredFeature("spruce_yellow_tree1",
            BYGFeatures.SPRUCE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE1.value().config())
                    .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE2 = createConfiguredFeature("spruce_yellow_tree2",
            BYGFeatures.SPRUCE_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE2.value().config())
                    .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE3 = createConfiguredFeature("spruce_yellow_tree3",
            BYGFeatures.SPRUCE_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE3.value().config())
                    .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE4 = createConfiguredFeature("spruce_yellow_tree4",
            BYGFeatures.SPRUCE_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE4.value().config())
                    .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE_MEDIUM1 = createConfiguredFeature("spruce_yellow_tree_medium1",
            BYGFeatures.SPRUCE_TREE_MEDIUM1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM1.value().config())
                    .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE_MEDIUM2 = createConfiguredFeature("spruce_yellow_tree_medium2",
            BYGFeatures.SPRUCE_TREE_MEDIUM2,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM2.value().config())
                    .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE_MEDIUM3 = createConfiguredFeature("spruce_yellow_tree_medium3",
            BYGFeatures.SPRUCE_TREE_MEDIUM3,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM3.value().config())
                    .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE_MEDIUM4 = createConfiguredFeature("spruce_yellow_tree_medium4",
            BYGFeatures.SPRUCE_TREE_MEDIUM4,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM4.value().config())
                    .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_YELLOW_TREE_LARGE1 = createConfiguredFeature("spruce_yellow_tree_large1",
            BYGFeatures.SPRUCE_TREE_LARGE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_LARGE1.value().config())
                    .setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES.get())
                    .build()
    );

    //Orange Spruce
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE1 = createConfiguredFeature("spruce_orange_tree1",
            BYGFeatures.SPRUCE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE1.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE2 = createConfiguredFeature("spruce_orange_tree2",
            BYGFeatures.SPRUCE_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE2.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE3 = createConfiguredFeature("spruce_orange_tree3",
            BYGFeatures.SPRUCE_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE3.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE4 = createConfiguredFeature("spruce_orange_tree4",
            BYGFeatures.SPRUCE_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE4.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE_MEDIUM1 = createConfiguredFeature("spruce_orange_tree_medium1",
            BYGFeatures.SPRUCE_TREE_MEDIUM1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM1.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE_MEDIUM2 = createConfiguredFeature("spruce_orange_tree_medium2",
            BYGFeatures.SPRUCE_TREE_MEDIUM2,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM2.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE_MEDIUM3 = createConfiguredFeature("spruce_orange_tree_medium3",
            BYGFeatures.SPRUCE_TREE_MEDIUM3,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM3.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE_MEDIUM4 = createConfiguredFeature("spruce_orange_tree_medium4",
            BYGFeatures.SPRUCE_TREE_MEDIUM4,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM4.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_ORANGE_TREE_LARGE1 = createConfiguredFeature("spruce_orange_tree_large1",
            BYGFeatures.SPRUCE_TREE_LARGE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_LARGE1.value().config())
                    .setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES.get())
                    .build()
    );

    //Red Spruce
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE1 = createConfiguredFeature("spruce_red_tree1",
            BYGFeatures.SPRUCE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE1.value().config())
                    .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE2 = createConfiguredFeature("spruce_red_tree2",
            BYGFeatures.SPRUCE_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE2.value().config())
                    .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE3 = createConfiguredFeature("spruce_red_tree3",
            BYGFeatures.SPRUCE_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE3.value().config())
                    .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE4 = createConfiguredFeature("spruce_red_tree4",
            BYGFeatures.SPRUCE_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE4.value().config())
                    .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE_MEDIUM1 = createConfiguredFeature("spruce_red_tree_medium1",
            BYGFeatures.SPRUCE_TREE_MEDIUM1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM1.value().config())
                    .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE_MEDIUM2 = createConfiguredFeature("spruce_red_tree_medium2",
            BYGFeatures.SPRUCE_TREE_MEDIUM2,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM2.value().config())
                    .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE_MEDIUM3 = createConfiguredFeature("spruce_red_tree_medium3",
            BYGFeatures.SPRUCE_TREE_MEDIUM3,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM3.value().config())
                    .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE_MEDIUM4 = createConfiguredFeature("spruce_red_tree_medium4",
            BYGFeatures.SPRUCE_TREE_MEDIUM4,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM4.value().config())
                    .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_RED_TREE_LARGE1 = createConfiguredFeature("spruce_red_tree_large1",
            BYGFeatures.SPRUCE_TREE_LARGE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_LARGE1.value().config())
                    .setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE1 = createConfiguredFeature("spruce_blue_tree1",
            BYGFeatures.SPRUCE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE1.value().config())
                    .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE2 = createConfiguredFeature("spruce_blue_tree2",
            BYGFeatures.SPRUCE_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE2.value().config())
                    .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE3 = createConfiguredFeature("spruce_blue_tree3",
            BYGFeatures.SPRUCE_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE3.value().config())
                    .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE4 = createConfiguredFeature("spruce_blue_tree4",
            BYGFeatures.SPRUCE_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE4.value().config())
                    .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE_MEDIUM1 = createConfiguredFeature("spruce_blue_tree_medium1",
            BYGFeatures.SPRUCE_TREE_MEDIUM1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM1.value().config())
                    .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE_MEDIUM2 = createConfiguredFeature("spruce_blue_tree_medium2",
            BYGFeatures.SPRUCE_TREE_MEDIUM2,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM2.value().config())
                    .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE_MEDIUM3 = createConfiguredFeature("spruce_blue_tree_medium3",
            BYGFeatures.SPRUCE_TREE_MEDIUM3,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM3.value().config())
                    .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES.get())
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE_MEDIUM4 = createConfiguredFeature("spruce_blue_tree_medium4",
            BYGFeatures.SPRUCE_TREE_MEDIUM4,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_MEDIUM4.value().config())
                    .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> SPRUCE_BLUE_TREE_LARGE1 = createConfiguredFeature("spruce_blue_tree_large1",
            BYGFeatures.SPRUCE_TREE_LARGE1,
            () -> new BYGTreeConfig.Builder()
                    .copy(SPRUCE_TREE_LARGE1.value().config())
                    .setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES.get())
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> TROPICAL_SHRUB1 = createConfiguredFeature("tropical_shrub1",
            BYGFeatures.SHRUB1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(MAHOGANY.log().get())
                    .setLeavesBlock(MAHOGANY.leaves().get())
                    .setMinHeight(2)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAHOGANY_TREE1 = createConfiguredFeature("mahogany_tree1",
            BYGFeatures.MAHOGANY_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(MAHOGANY.log().get())
                    .setLeavesBlock(MAHOGANY.leaves().get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAHOGANY_TREE2 = createConfiguredFeature("mahogany_tree2",
            BYGFeatures.MAHOGANY_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(MAHOGANY.log().get())
                    .setLeavesBlock(MAHOGANY.leaves().get())
                    .setMaxHeight(14)
                    .setMinHeight(8)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAHOGANY_TREE3 = createConfiguredFeature("mahogany_tree3",
            BYGFeatures.MAHOGANY_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(MAHOGANY.log().get())
                    .setLeavesBlock(MAHOGANY.leaves().get())
                    .setMaxHeight(18)
                    .setMinHeight(13)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAHOGANY_TREE4 = createConfiguredFeature("mahogany_tree4",
            BYGFeatures.MAHOGANY_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(MAHOGANY.log().get())
                    .setLeavesBlock(MAHOGANY.leaves().get())
                    .setMaxHeight(24)
                    .setMinHeight(18)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> MAHOGANY_TREE5 = createConfiguredFeature("mahogany_tree5",
            BYGFeatures.MAHOGANY_TREE5,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(MAHOGANY.log().get())
                    .setLeavesBlock(MAHOGANY.leaves().get())
                    .setMaxHeight(31)
                    .setMinHeight(25)
                    .build()
    );


    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> WOODLANDS_TREE1 = createConfiguredFeature("woodlands_tree1",
            BYGFeatures.WOODLANDS_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(Blocks.OAK_LOG)
                    .setLeavesBlock(Blocks.OAK_LEAVES)
                    .setMaxHeight(5)
                    .setMinHeight(25)
                    .build()

    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> WILLOW_DEAD_TREE1 = createConfiguredFeature("dead_willow_tree1",
            BYGFeatures.WILLOW_DEAD_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(WILLOW)
                    .setMaxHeight(12)
                    .setMinHeight(7)
                    .build()
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> WILLOW_TREE1 = createConfiguredFeature("willow_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/willow/willow_tree_trunk1"),
                    BYG.createLocation("features/trees/willow/willow_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WILLOW.log().get()),
                    BlockStateProvider.simple(WILLOW.leaves().get()),
                    WILLOW.log(),
                    WILLOW.leaves(),
                    BYGBlockTags.GROUND_WILLOW_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> WILLOW_TREE2 = createConfiguredFeature("willow_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/willow/willow_tree_trunk1"),
                    BYG.createLocation("features/trees/willow/willow_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WILLOW.log().get()),
                    BlockStateProvider.simple(WILLOW.leaves().get()),
                    WILLOW.log(),
                    WILLOW.leaves(),
                    BYGBlockTags.GROUND_WILLOW_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> WILLOW_TREE3 = createConfiguredFeature("willow_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/willow/willow_tree_trunk1"),
                    BYG.createLocation("features/trees/willow/willow_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WILLOW.log().get()),
                    BlockStateProvider.simple(WILLOW.leaves().get()),
                    WILLOW.log(),
                    WILLOW.leaves(),
                    BYGBlockTags.GROUND_WILLOW_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> WILLOW_TREE4 = createConfiguredFeature("willow_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/willow/willow_tree_trunk2"),
                    BYG.createLocation("features/trees/willow/willow_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WILLOW.log().get()),
                    BlockStateProvider.simple(WILLOW.leaves().get()),
                    WILLOW.log(),
                    WILLOW.leaves(),
                    BYGBlockTags.GROUND_WILLOW_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ZELKOVA_TREE1 = createConfiguredFeature("zelkova_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_trunk1"),
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(ZELKOVA.log().get()),
                    BlockStateProvider.simple(ZELKOVA.leaves().get()),
                    ZELKOVA.log(),
                    ZELKOVA.leaves(),
                    BYGBlockTags.GROUND_ZELKOVA_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ZELKOVA_TREE2 = createConfiguredFeature("zelkova_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_trunk1"),
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(ZELKOVA.log().get()),
                    BlockStateProvider.simple(ZELKOVA.leaves().get()),
                    ZELKOVA.log(),
                    ZELKOVA.leaves(),
                    BYGBlockTags.GROUND_ZELKOVA_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ZELKOVA_TREE3 = createConfiguredFeature("zelkova_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_trunk1"),
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(ZELKOVA.log().get()),
                    BlockStateProvider.simple(ZELKOVA.leaves().get()),
                    ZELKOVA.log(),
                    ZELKOVA.leaves(),
                    BYGBlockTags.GROUND_ZELKOVA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ZELKOVA_BROWN_TREE1 = createConfiguredFeature("brown_zelkova_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_trunk1"),
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(ZELKOVA.log().get()),
                    BlockStateProvider.simple(BYGBlocks.BROWN_ZELKOVA_LEAVES.get()),
                    ZELKOVA.log(),
                    ZELKOVA.leaves(),
                    BYGBlockTags.GROUND_ZELKOVA_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ZELKOVA_BROWN_TREE2 = createConfiguredFeature("brown_zelkova_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_trunk1"),
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(ZELKOVA.log().get()),
                    BlockStateProvider.simple(BYGBlocks.BROWN_ZELKOVA_LEAVES.get()),
                    ZELKOVA.log(),
                    ZELKOVA.leaves(),
                    BYGBlockTags.GROUND_ZELKOVA_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> ZELKOVA_BROWN_TREE3 = createConfiguredFeature("brown_zelkova_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_trunk1"),
                    BYG.createLocation("features/trees/zelkova/zelkova_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(ZELKOVA.log().get()),
                    BlockStateProvider.simple(BYGBlocks.BROWN_ZELKOVA_LEAVES.get()),
                    ZELKOVA.log(),
                    ZELKOVA.leaves(),
                    BYGBlockTags.GROUND_ZELKOVA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> FIRECRACKER_SHRUBS = createConfiguredFeature("firecracker_shrubs",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(FIRECRACKER_SHRUB), 0.20F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(FIRECRACKER_SHRUB2)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BAYOU_TREES = createConfiguredFeature("bayou_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WILLOW_DEAD_TREE1), 0.1F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WILLOW_TREE1), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WILLOW_TREE2), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WILLOW_TREE3), 0.25F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WILLOW_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CANADIAN_SHIELD_TREES = createConfiguredFeature("canadian_shield_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PINE_TREE1), 0.05F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PINE_TREE2), 0.05F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BLUFF_TREE1), 0.3F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BLUFF_TREE2), 0.3F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CONIFER_TREE6))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BOREAL_TREES = createConfiguredFeature("boreal_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_YELLOW_BOREAL_TREE1), 0.3F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_BOREAL_TREE1), 0.3F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BLUFF_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BLACK_FOREST_TREES = createConfiguredFeature("black_forest_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ASPEN_TREE3), 0.05F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ASPEN_TREE2), 0.05F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CONIFER_TREE6), 0.05F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CONIFER_TREE7), 0.05F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PINE_LARGE_TREE1), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PINE_LARGE_TREE2), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PINE_TREE1), 0.2F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PINE_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CIKA_TREES = createConfiguredFeature("cika_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CIKA_TREE2), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CIKA_TREE3), 0.1F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CIKA_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CONIFER_TREES = createConfiguredFeature("conifer_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CONIFER_TREE1), 0.06F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CONIFER_TREE2), 0.5F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CONIFER_TREE3), 0.04F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CONIFER_TREE4), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CONIFER_TREE5), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CONIFER_TREE6), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CONIFER_TREE7), 0.1F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CONIFER_TREE8))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CYPRESS_TREES = createConfiguredFeature("cypress_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CYPRESS_TREE1), 0.33F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CYPRESS_TREE2), 0.33F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CYPRESS_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> DECIDUOUS_TREES = createConfiguredFeature("deciduous_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(DECIDUOUS_TREE1), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(DECIDUOUS_TREE2), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(DECIDUOUS_TREE3), 0.25F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(DECIDUOUS_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> DACITE_RIDGE_TREES = createConfiguredFeature("dacite_ridge_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE_MEDIUM2), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE_MEDIUM1), 0.25F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE_LARGE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> JACARANDA_TREES = createConfiguredFeature("jacaranda_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(JACARANDA_TREE1), 0.125F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(JACARANDA_TREE2), 0.125F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(JACARANDA_TREE3), 0.125F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(JACARANDA_TREE4), 0.125F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(INDIGO_JACARANDA_TREE1), 0.125F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(INDIGO_JACARANDA_TREE2), 0.125F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(INDIGO_JACARANDA_TREE3), 0.125F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(INDIGO_JACARANDA_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MAPLE_TREES = createConfiguredFeature("maple_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAPLE_RED_TREE1), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAPLE_RED_TREE2), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAPLE_SILVER_TREE1), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAPLE_SILVER_TREE2), 0.2F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAPLE_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> NORTHERN_FOREST_TREES = createConfiguredFeature("northern_forest_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PINE_TREE1), 0.5F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PINE_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> REDWOOD_TREES = createConfiguredFeature("redwood_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(REDWOOD_TREE1), 0.55F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(REDWOOD_TREE2), 0.1F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(REDWOOD_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SPRUCE_TREES = createConfiguredFeature("spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE1), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE2), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE3), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE4), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE_MEDIUM1), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE_MEDIUM2), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE_MEDIUM3), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE_MEDIUM4), 0.111F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ORANGE_SPRUCE_TREES = createConfiguredFeature("orange_spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_ORANGE_TREE1), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_ORANGE_TREE2), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_ORANGE_TREE3), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_ORANGE_TREE4), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_ORANGE_TREE_MEDIUM1), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_ORANGE_TREE_MEDIUM2), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_ORANGE_TREE_MEDIUM3), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_ORANGE_TREE_MEDIUM4), 0.111F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_ORANGE_TREE_LARGE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> YELLOW_SPRUCE_TREES = createConfiguredFeature("yellow_spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_YELLOW_TREE1), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_YELLOW_TREE2), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_YELLOW_TREE3), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_YELLOW_TREE4), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_YELLOW_TREE_MEDIUM1), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_YELLOW_TREE_MEDIUM2), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_YELLOW_TREE_MEDIUM3), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_YELLOW_TREE_MEDIUM4), 0.111F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_YELLOW_TREE_LARGE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> RED_SPRUCE_TREES = createConfiguredFeature("red_spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_RED_TREE1), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_RED_TREE2), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_RED_TREE3), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_RED_TREE4), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_RED_TREE_MEDIUM1), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_RED_TREE_MEDIUM2), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_RED_TREE_MEDIUM3), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_RED_TREE_MEDIUM4), 0.111F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_RED_TREE1))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> AUTUMNAL_SPRUCE_TREES = createConfiguredFeature("autumnal_spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RED_SPRUCE_TREES), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ORANGE_SPRUCE_TREES), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(YELLOW_SPRUCE_TREES), 0.25F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_TREES))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BLUE_SPRUCE_TREES = createConfiguredFeature("blue_spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_BLUE_TREE1), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_BLUE_TREE2), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_BLUE_TREE3), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_BLUE_TREE4), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_BLUE_TREE_MEDIUM1), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_BLUE_TREE_MEDIUM2), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_BLUE_TREE_MEDIUM3), 0.111F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_BLUE_TREE_MEDIUM4), 0.111F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SPRUCE_BLUE_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MAHOGANY_TREES = createConfiguredFeature("mahogany_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAHOGANY_TREE1), 0.1F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAHOGANY_TREE2), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAHOGANY_TREE3), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAHOGANY_TREE4), 0.15F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAHOGANY_TREE5))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> RAINFOREST_TREES = createConfiguredFeature("rainforest_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(TROPICAL_SHRUB1), 0.35F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAHOGANY_TREES))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> GUIANA_SHIELD_TREES = createConfiguredFeature("guiana_shield_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RAINBOW_LARGE_TREE1), 0.1F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RAINBOW_TREE1), 0.1F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(TROPICAL_SHRUB1), 0.1F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MAHOGANY_TREES))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> RAINBOW_EUCALYPTUS_TREES = createConfiguredFeature("rainbow_eucalyptus_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RAINBOW_LARGE_TREE1), 0.333F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RAINBOW_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SKYRIS_TREES = createConfiguredFeature("skyris_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SKYRIS_TREE1), 0.1667F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SKYRIS_TREE2), 0.1667F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SKYRIS_TREE3), 0.1667F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SKYRIS_TREE4), 0.1667F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SKYRIS_TREE5), 0.1667F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SKYRIS_TREE6))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BAOBAB_TREES = createConfiguredFeature("baobab_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BAOBAB_TREE1), 0.35F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BAOBAB_TREE2), 0.35F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BAOBAB_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ARAUCARIA_TREES = createConfiguredFeature("araucaria_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ARAUCARIA_TREE1), 0.5F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ARAUCARIA_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ORANGE_BIRCH_TREES = createConfiguredFeature("orange_birch_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_ORANGE_TREE1), 0.33F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_ORANGE_TREE2), 0.33F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_ORANGE_TREE3), 0.33F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_ORANGE_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> YELLOW_BIRCH_TREES = createConfiguredFeature("yellow_birch_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_YELLOW_TREE1), 0.33F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_YELLOW_TREE2), 0.33F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_YELLOW_TREE3), 0.33F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_YELLOW_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BROWN_ZELKOVA_TREES = createConfiguredFeature("brown_zelkova_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ZELKOVA_BROWN_TREE1), 0.33F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ZELKOVA_BROWN_TREE2), 0.33F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ZELKOVA_BROWN_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MEADOW_SHRUBS = createConfiguredFeature("meadow_shrubs",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SHRUB_MEADOW), 0.5F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SHRUB_MEADOW2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MEADOW_TREES = createConfiguredFeature("meadow_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MEADOW_TREE1), 0.3F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MEADOW_TREE2), 0.3F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MEADOW_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TEMPERATE_GROVE_TREES = createConfiguredFeature("temperate_grove_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_YELLOW_BOREAL_TREE1), 0.5F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BIRCH_BOREAL_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ENCHANTED_TREES = createConfiguredFeature("enchanted_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BLUE_ENCHANTED_TREE4), 0.05F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BLUE_ENCHANTED_TREE3), 0.05F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BLUE_ENCHANTED_TREE2), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(GREEN_ENCHANTED_TREE4), 0.05F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(GREEN_ENCHANTED_TREE3), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(GREEN_ENCHANTED_TREE2), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(GREEN_ENCHANTED_TREE1), 0.1F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BLUE_ENCHANTED_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ASPEN_TREES = createConfiguredFeature("aspen_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ASPEN_TREE2), 0.50F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ASPEN_TREE3), 0.25F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ASPEN_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ASPEN_SHRUBS = createConfiguredFeature("aspen_shrubs",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ASPEN_SHRUB1), 0.5F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ASPEN_SHRUB2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ZELKOVA_TREES = createConfiguredFeature("zelkova_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ZELKOVA_TREE1), 0.33F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ZELKOVA_TREE2), 0.33F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ZELKOVA_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PALO_VERDE_TREES = createConfiguredFeature("palo_verde_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PALO_VERDE_TREE1), 0.5F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PALO_VERDE_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> JOSHUA_TREES = createConfiguredFeature("joshua_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(JOSHUA_TREE1), 0.5F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(JOSHUA_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PRAIRIE_SHRUBS = createConfiguredFeature("prairie_shrubs", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SHRUB_PRAIRIE1), 0.5F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SHRUB_PRAIRIE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PALM_TREES = createConfiguredFeature("palm_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PALM_TREE1), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PALM_TREE2), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PALM_TREE3), 0.25F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PALM_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CHERRY_TREES = createConfiguredFeature("cherry_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CHERRY_PINK_TREE1), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CHERRY_PINK_TREE2), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CHERRY_WHITE_TREE1), 0.25F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CHERRY_WHITE_TREE2))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> WITCH_HAZEL_TREES = createConfiguredFeature("witch_hazel_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WITCH_HAZEL1), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WITCH_HAZEL2), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WITCH_HAZEL3), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WITCH_HAZEL4), 0.2F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WITCH_HAZEL5))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> EBONY_TREES = createConfiguredFeature("ebony_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(EBONY_TREE1), 0.45F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(EBONY_TREE2), 0.45F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(EBONY_BUSH1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> FRAGMENT_FOREST_TREES = createConfiguredFeature("stone_forest_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(TreeFeatures.JUNGLE_BUSH), 0.1F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(EBONY_TREES), 0.45F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(DECIDUOUS_TREES))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> HOLLY_TREES = createConfiguredFeature("holly_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(HOLLY_TREE1), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(HOLLY_TREE2), 0.25F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(HOLLY_TREE3), 0.25F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(HOLLY_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MANGROVE_TREES = createConfiguredFeature("white_mangrove_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MANGROVE_TREE1), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MANGROVE_TREE2), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MANGROVE_TREE3), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MANGROVE_TREE4), 0.2F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(MANGROVE_TREE5))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ORCHARD_TREES = createConfiguredFeature("orchard_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ORCHARD_TREE1), 0.33F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ORCHARD_TREE2), 0.33F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ORCHARD_TREE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TEMPERATE_RAINFOREST_TREES = createConfiguredFeature("temperate_rainforest_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WOODLANDS_TREE1), 0.5F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WOODLANDS_TREE1))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> OAK_TREES = createConfiguredFeature("oak_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE1), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE2), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE3), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE_LARGE1), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE_LARGE2), 0.16F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE_LARGE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> OAK_TREES_SWAMP = createConfiguredFeature("oak_trees_swamp",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE1), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE2), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE3), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE_LARGE1), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE_LARGE2), 0.16F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREE_LARGE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ORANGE_OAK_TREES = createConfiguredFeature("orange_oak_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ORANGE_OAK_TREE1), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ORANGE_OAK_TREE2), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ORANGE_OAK_TREE3), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ORANGE_OAK_TREE_LARGE1), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ORANGE_OAK_TREE_LARGE2), 0.16F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ORANGE_OAK_TREE_LARGE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BROWN_OAK_TREES = createConfiguredFeature("brown_oak_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BROWN_OAK_TREE1), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BROWN_OAK_TREE2), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BROWN_OAK_TREE3), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BROWN_OAK_TREE_LARGE1), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BROWN_OAK_TREE_LARGE2), 0.16F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BROWN_OAK_TREE_LARGE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> RED_OAK_TREES = createConfiguredFeature("red_oak_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RED_OAK_TREE1), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RED_OAK_TREE2), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RED_OAK_TREE3), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RED_OAK_TREE_LARGE1), 0.16F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RED_OAK_TREE_LARGE2), 0.16F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RED_OAK_TREE_LARGE3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> AUTUMNAL_OAK_TREES = createConfiguredFeature("autumnal_oak_trees", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RED_OAK_TREES), 0.25F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BROWN_OAK_TREES), 0.25F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ORANGE_OAK_TREES), 0.25F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(OAK_TREES))
    );

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeatureStatic(String id, Feature<FC> feature, FC config) {
        return BYGFeaturesUtil.CONFIGURED_FEATURES.<ConfiguredFeature<FC, ?>>register(id, () -> new ConfiguredFeature<>(feature, config)).asHolder();
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeature(String id, Supplier<? extends F> feature, Supplier<? extends FC> config) {
        return BYGFeaturesUtil.CONFIGURED_FEATURES.<ConfiguredFeature<FC, ?>>register(id, () -> new ConfiguredFeature<>(feature.get(), config.get())).asHolder();
    }

    public static void loadClass() {}
}
