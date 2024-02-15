package potionstudios.byg.common.world.feature.features.overworld;

import com.google.common.collect.ImmutableList;
import corgitaco.corgilib.world.level.feature.CorgiLibFeatures;
import corgitaco.corgilib.world.level.feature.gen.configurations.TreeFromStructureNBTConfig;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangrovePropaguleBlock;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.*;
import potionstudios.byg.common.world.feature.gen.overworld.trees.decorators.AttachedToFruitLeavesDecorator;
import potionstudios.byg.common.world.feature.gen.overworld.trees.decorators.AttachedToLogsDecorator;
import potionstudios.byg.common.world.feature.gen.overworld.trees.decorators.BYGLeavesVineDecorator;
import potionstudios.byg.common.world.feature.gen.overworld.trees.decorators.BYGTrunkVineDecorator;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;

import java.util.List;
import java.util.function.Supplier;

import static potionstudios.byg.common.block.BYGWoodTypes.*;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;

public class BYGOverworldTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ARAUCARIA_TREE1 = createConfiguredFeature("araucaria_tree1",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> ARAUCARIA_TREE2 = createConfiguredFeature("araucaria_tree2",
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


    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_TREE1 = createConfiguredFeature("ancient_tree1",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_TREE2 = createConfiguredFeature("ancient_tree2",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_TREE3 = createConfiguredFeature("ancient_tree3",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_SHRUB1 = createConfiguredFeature("aspen_shrub1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen-shrub/aspen_shrub_trunk1"),
                    BYG.createLocation("features/trees/aspen-shrub/aspen_shrub_canopy1"),
                    ConstantInt.of(0),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 1, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_SHRUB2 = createConfiguredFeature("aspen_shrub2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen-shrub/aspen_shrub_trunk1"),
                    BYG.createLocation("features/trees/aspen-shrub/aspen_shrub_canopy2"),
                    ConstantInt.of(0),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 1, ImmutableList.of()
            )
    );

    public static final Supplier<AttachedToLogsDecorator> SHELF_FUNGI = () -> new AttachedToLogsDecorator(0.3F, 0, 1, SimpleStateProvider.simple(BYGBlocks.SHELF_FUNGI.defaultBlockState()), 2, List.of(Direction.WEST, Direction.NORTH, Direction.SOUTH, Direction.EAST));

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE1 = createConfiguredFeature("aspen_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen/aspen_trunk1"),
                    BYG.createLocation("features/trees/aspen/aspen_canopy1"),
                    BiasedToBottomInt.of(7, 12),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 4, ImmutableList.of(SHELF_FUNGI.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE2 = createConfiguredFeature("aspen_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen/aspen_trunk2"),
                    BYG.createLocation("features/trees/aspen/aspen_canopy2"),
                    BiasedToBottomInt.of(7, 12),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 8, ImmutableList.of(SHELF_FUNGI.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE3 = createConfiguredFeature("aspen_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen/aspen_trunk3"),
                    BYG.createLocation("features/trees/aspen/aspen_canopy3"),
                    BiasedToBottomInt.of(6, 10),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 4, ImmutableList.of(SHELF_FUNGI.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE4 = createConfiguredFeature("aspen_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen/aspen_trunk4"),
                    BYG.createLocation("features/trees/aspen/aspen_canopy4"),
                    BiasedToBottomInt.of(6, 10),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 4, ImmutableList.of(SHELF_FUNGI.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE5 = createConfiguredFeature("aspen_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen/aspen_trunk5"),
                    BYG.createLocation("features/trees/aspen/aspen_canopy5"),
                    BiasedToBottomInt.of(6, 12),
                    BlockStateProvider.simple(ASPEN.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ASPEN.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ASPEN_SAPLING, 4, ImmutableList.of(SHELF_FUNGI.get())
            )
    );

    public static final Supplier<AttachedToLeavesDecorator> BAOBAB_FRUIT = () -> new AttachedToFruitLeavesDecorator(0.2F, 2, 0, BYGBlocks.RIPE_BAOBAB_LEAVES.get(), new RandomizedIntStateProvider(BlockStateProvider.simple(BYGBlocks.BAOBAB_FRUIT_BLOCK.defaultBlockState()), FruitBlock.AGE, UniformInt.of(0, 3)), 2, List.of(Direction.DOWN));

    public static final ResourceKey<ConfiguredFeature<?, ?>> BAOBAB_TREE1 = createConfiguredFeature("baobab_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/baobab/baobab_tree_trunk1"),
                    BYG.createLocation("features/trees/baobab/baobab_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(BAOBAB.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(BAOBAB.leaves().defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_BAOBAB_LEAVES.defaultBlockState(), 2)
                            .add(BYGBlocks.RIPE_BAOBAB_LEAVES.defaultBlockState(), 1).build()
                    ),
                    BAOBAB.log(),
                    BAOBAB.leaves(),
                    BYGBlockTags.GROUND_BAOBAB_SAPLING, 5, ImmutableList.of(BAOBAB_FRUIT.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAOBAB_TREE2 = createConfiguredFeature("baobab_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/baobab/baobab_tree_trunk2"),
                    BYG.createLocation("features/trees/baobab/baobab_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(BAOBAB.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(BAOBAB.leaves().defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_BAOBAB_LEAVES.defaultBlockState(), 2)
                            .add(BYGBlocks.RIPE_BAOBAB_LEAVES.defaultBlockState(), 1).build()
                    ),
                    BAOBAB.log(),
                    BAOBAB.leaves(),
                    BYGBlockTags.GROUND_BAOBAB_SAPLING, 5, ImmutableList.of(BAOBAB_FRUIT.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAOBAB_TREE3 = createConfiguredFeature("baobab_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/baobab/baobab_tree_trunk3"),
                    BYG.createLocation("features/trees/baobab/baobab_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(BAOBAB.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(BAOBAB.leaves().defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_BAOBAB_LEAVES.defaultBlockState(), 2)
                            .add(BYGBlocks.RIPE_BAOBAB_LEAVES.defaultBlockState(), 1).build()
                    ),
                    BAOBAB.log(),
                    BAOBAB.leaves(),
                    BYGBlockTags.GROUND_BAOBAB_SAPLING, 5, ImmutableList.of(BAOBAB_FRUIT.get())
            )
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_TREE1 = createConfiguredFeature("birch_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of(SHELF_FUNGI.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_TREE2 = createConfiguredFeature("birch_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of(SHELF_FUNGI.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_TREE3 = createConfiguredFeature("birch_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of(SHELF_FUNGI.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_TREE4 = createConfiguredFeature("birch_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/birch/birch_tree_trunk1"),
                    BYG.createLocation("features/trees/birch/birch_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.BIRCH_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.BIRCH_LOG,
                    BYGBlocks.BROWN_BIRCH_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, 5, ImmutableList.of(SHELF_FUNGI.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_BIRCH_TREE1 = createConfiguredFeature("brown_birch_tree1",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_BIRCH_TREE2 = createConfiguredFeature("brown_birch_tree2",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_BIRCH_TREE3 = createConfiguredFeature("brown_birch_tree3",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_BIRCH_TREE4 = createConfiguredFeature("brown_birch_tree4",
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


    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_ORANGE_TREE1 = createConfiguredFeature("orange_birch_tree1",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_ORANGE_TREE2 = createConfiguredFeature("orange_birch_tree2",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_ORANGE_TREE3 = createConfiguredFeature("orange_birch_tree3",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_ORANGE_TREE4 = createConfiguredFeature("orange_birch_tree4",
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


    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_RED_TREE1 = createConfiguredFeature("red_birch_tree1",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_RED_TREE2 = createConfiguredFeature("red_birch_tree2",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_RED_TREE3 = createConfiguredFeature("red_birch_tree3",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_RED_TREE4 = createConfiguredFeature("red_birch_tree4",
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


    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_YELLOW_TREE1 = createConfiguredFeature("yellow_birch_tree1",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_YELLOW_TREE2 = createConfiguredFeature("yellow_birch_tree2",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_YELLOW_TREE3 = createConfiguredFeature("yellow_birch_tree3",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_YELLOW_TREE4 = createConfiguredFeature("yellow_birch_tree4",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUFF_TREE1 = createConfiguredFeature("bluff_tree1",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUFF_TREE2 = createConfiguredFeature("bluff_tree2",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_BOREAL_TREE1 = createConfiguredFeature("birch_boreal_tree1",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_YELLOW_BOREAL_TREE1 = createConfiguredFeature("birch_yellow_boreal_tree1",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_BUSH1 = createConfiguredFeature("oak_bush1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bush/trunk_bush1"),
                    BYG.createLocation("features/trees/bush/canopy_bush1"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    BlockStateProvider.simple(Blocks.OAK_LEAVES),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_ZELKOVA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_CHERRY_TREE1 = createConfiguredFeature("white_cherry_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/sakura_cherry/white_sakura_cherry_tree_trunk1"),
                    BYG.createLocation("features/trees/sakura_cherry/white_sakura_cherry_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SAKURA_CHERRY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.WHITE_CHERRY_LEAVES.defaultBlockState(), 1).build()),
                    SAKURA_CHERRY.log().get(),
                    BYGBlocks.WHITE_CHERRY_LEAVES.get(),
                    BYGBlockTags.GROUND_WHITE_CHERRY_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_CHERRY_TREE2 = createConfiguredFeature("white_cherry_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/sakura_cherry/white_sakura_cherry_tree_trunk2"),
                    BYG.createLocation("features/trees/sakura_cherry/white_sakura_cherry_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SAKURA_CHERRY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.WHITE_CHERRY_LEAVES.defaultBlockState(), 1).build()),
                    SAKURA_CHERRY.log().get(),
                    BYGBlocks.WHITE_CHERRY_LEAVES.get(),
                    BYGBlockTags.GROUND_WHITE_CHERRY_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CIKA_TREE1 = createConfiguredFeature("cika_tree1",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> CIKA_TREE2 = createConfiguredFeature("cika_tree2",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> CIKA_TREE3 = createConfiguredFeature("cika_tree3",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> CONIFER_TREE1 = createConfiguredFeature("conifer_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy1"),
                    BiasedToBottomInt.of(19, 25),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONIFER_TREE2 = createConfiguredFeature("conifer_tree2",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONIFER_TREE3 = createConfiguredFeature("conifer_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy3"),
                    BiasedToBottomInt.of(26, 35),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONIFER_TREE4 = createConfiguredFeature("conifer_tree4",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONIFER_TREE5 = createConfiguredFeature("conifer_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy5"),
                    BiasedToBottomInt.of(7, 11),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONIFER_TREE6 = createConfiguredFeature("conifer_tree6",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy6"),
                    BiasedToBottomInt.of(10, 15),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONIFER_TREE7 = createConfiguredFeature("conifer_tree7",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk1"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy7"),
                    BiasedToBottomInt.of(11, 18),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )

    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONIFER_TREE8 = createConfiguredFeature("conifer_tree8",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/conifer/conifer_trunk8"),
                    BYG.createLocation("features/trees/conifer/conifer_canopy8"),
                    BiasedToBottomInt.of(12, 18),
                    BlockStateProvider.simple(FIR.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(FIR.leaves().defaultBlockState(), 1).build()),
                    FIR.log().get(),
                    FIR.leaves().get(),
                    BYGBlockTags.GROUND_FIR_SAPLING, 14, ImmutableList.of()
            )
    );

    public static final Supplier<AttachedToLogsDecorator> WITCH_HAZEL_BLOSSOM = () -> new AttachedToLogsDecorator(0.1F, 15, 15, SimpleStateProvider.simple(BYGBlocks.WITCH_HAZEL_BLOSSOM.defaultBlockState()), 3, List.of(Direction.DOWN));
    public static final Supplier<AttachedToLogsDecorator> WITCH_HAZEL_BRANCH = () -> new AttachedToLogsDecorator(0.65F, 0, 1, SimpleStateProvider.simple(BYGBlocks.WITCH_HAZEL_BRANCH.defaultBlockState()), 2, List.of(Direction.WEST, Direction.NORTH, Direction.SOUTH, Direction.EAST));
    public static final Supplier<AttachedToLogsDecorator> MOSS_CARPET = () -> new AttachedToLogsDecorator(0.9F, 0, 0, SimpleStateProvider.simple(Blocks.MOSS_CARPET.defaultBlockState()), 1, List.of(Direction.UP));

    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_TREE1 = createConfiguredFeature("cypress_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cypress/cypress_trunk1"),
                    BYG.createLocation("features/trees/cypress/cypress_canopy1"),
                    BiasedToBottomInt.of(14, 16),
                    BlockStateProvider.simple(CYPRESS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CYPRESS.leaves().defaultBlockState(), 1).build()),
                    CYPRESS.log().get(),
                    CYPRESS.leaves().get(),
                    BYGBlockTags.GROUND_CYPRESS_SAPLING, 14, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_TREE2 = createConfiguredFeature("cypress_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cypress/cypress_trunk2"),
                    BYG.createLocation("features/trees/cypress/cypress_canopy2"),
                    BiasedToBottomInt.of(10, 13),
                    BlockStateProvider.simple(CYPRESS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CYPRESS.leaves().defaultBlockState(), 1).build()),
                    CYPRESS.log().get(),
                    CYPRESS.leaves().get(),
                    BYGBlockTags.GROUND_CYPRESS_SAPLING, 14, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_TREE3 = createConfiguredFeature("cypress_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/cypress/cypress_trunk3"),
                    BYG.createLocation("features/trees/cypress/cypress_canopy3"),
                    BiasedToBottomInt.of(10, 13),
                    BlockStateProvider.simple(CYPRESS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CYPRESS.leaves().defaultBlockState(), 1).build()),
                    CYPRESS.log().get(),
                    CYPRESS.leaves().get(),
                    BYGBlockTags.GROUND_CYPRESS_SAPLING, 14, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> WITCH_HAZEL1 = createConfiguredFeature("witch_hazel1",
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


    public static final ResourceKey<ConfiguredFeature<?, ?>> WITCH_HAZEL2 = createConfiguredFeature("witch_hazel2",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> WITCH_HAZEL3 = createConfiguredFeature("witch_hazel3",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> WITCH_HAZEL4 = createConfiguredFeature("witch_hazel4",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> WITCH_HAZEL5 = createConfiguredFeature("witch_hazel5",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> FIRECRACKER_SHRUB = createConfiguredFeature("firecracker_shrub",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/meadow/meadow_shrub_canopy1"),
                    ConstantInt.of(0),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    BlockStateProvider.simple(BYGBlocks.FIRECRACKER_LEAVES.get().defaultBlockState()),
                    Blocks.DARK_OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_ORANGE_OAK_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FIRECRACKER_SHRUB2 = createConfiguredFeature("firecracker_shrub2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/meadow/meadow_shrub_canopy1"),
                    ConstantInt.of(0),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    BlockStateProvider.simple(BYGBlocks.FIRECRACKER_LEAVES.get().defaultBlockState()),
                    Blocks.DARK_OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_ORANGE_OAK_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FIRECRACKER_BUSH1 = createConfiguredFeature("firecracker_bush1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bush/trunk_bush1"),
                    BYG.createLocation("features/trees/bush/canopy_bush1"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    BlockStateProvider.simple(BYGBlocks.FIRECRACKER_LEAVES.get().defaultBlockState()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_ZELKOVA_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DECIDUOUS_TREE1 = createConfiguredFeature("deciduous_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/deciduous/deciduous_trunk1"),
                    BYG.createLocation("features/trees/deciduous/deciduous_canopy1"),
                    BiasedToBottomInt.of(4, 7),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 1, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DECIDUOUS_TREE2 = createConfiguredFeature("deciduous_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/deciduous/deciduous_canopy2"),
                    BiasedToBottomInt.of(6, 8),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 1, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DECIDUOUS_TREE3 = createConfiguredFeature("deciduous_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/deciduous/deciduous_canopy3"),
                    BiasedToBottomInt.of(6, 8),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 1, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DECIDUOUS_TREE4 = createConfiguredFeature("deciduous_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/deciduous/deciduous_canopy3"),
                    BiasedToBottomInt.of(5, 8),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 8, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_BUSH1 = createConfiguredFeature("ebony_bush1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/ebony/ebony_bush_trunk"),
                    BYG.createLocation("features/trees/ebony/ebony_canopy2"),
                    ConstantInt.of(0)
                    ,
                    BlockStateProvider.simple(EBONY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(EBONY.leaves().defaultBlockState(), 1).build()),
                    EBONY.log(),
                    EBONY.leaves(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 6, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_TREE1 = createConfiguredFeature("ebony_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/ebony/ebony_trunk1"),
                    BYG.createLocation("features/trees/ebony/ebony_canopy1"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(EBONY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(EBONY.leaves().defaultBlockState(), 1).build()),
                    EBONY.log(),
                    EBONY.leaves(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 6, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_TREE2 = createConfiguredFeature("ebony_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/ebony/ebony_trunk2"),
                    BYG.createLocation("features/trees/ebony/ebony_canopy2"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(EBONY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(EBONY.leaves().defaultBlockState(), 1).build()),
                    EBONY.log(),
                    EBONY.leaves(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 6, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLLY_TREE1 = createConfiguredFeature("holly_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/holly/holly_canopy1"),
                    BiasedToBottomInt.of(10, 16),
                    BlockStateProvider.simple(HOLLY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(HOLLY.leaves().defaultBlockState(), 7).add(BYGBlocks.HOLLY_BERRY_LEAVES.defaultBlockState(), 1).build()),
                    HOLLY.log(),
                    HOLLY.leaves(),
                    BYGBlockTags.GROUND_HOLLY_SAPLING, 6, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLLY_TREE2 = createConfiguredFeature("holly_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/holly/holly_canopy2"),
                    BiasedToBottomInt.of(8, 14),
                    BlockStateProvider.simple(HOLLY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(HOLLY.leaves().defaultBlockState(), 7).add(BYGBlocks.HOLLY_BERRY_LEAVES.defaultBlockState(), 1).build()),
                    HOLLY.log(),
                    HOLLY.leaves(),
                    BYGBlockTags.GROUND_HOLLY_SAPLING, 6, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLLY_TREE3 = createConfiguredFeature("holly_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/holly/holly_trunk3"),
                    BYG.createLocation("features/trees/holly/holly_canopy3"),
                    BiasedToBottomInt.of(2, 12),
                    BlockStateProvider.simple(HOLLY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(HOLLY.leaves().defaultBlockState(), 7).add(BYGBlocks.HOLLY_BERRY_LEAVES.defaultBlockState(), 1).build()),
                    HOLLY.log(),
                    HOLLY.leaves(),
                    BYGBlockTags.GROUND_HOLLY_SAPLING, 6, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLLY_TREE4 = createConfiguredFeature("holly_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/holly/holly_canopy4"),
                    BiasedToBottomInt.of(10, 16),
                    BlockStateProvider.simple(HOLLY.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(HOLLY.leaves().defaultBlockState(), 7).add(BYGBlocks.HOLLY_BERRY_LEAVES.defaultBlockState(), 1).build()),
                    HOLLY.log(),
                    HOLLY.leaves(),
                    BYGBlockTags.GROUND_HOLLY_SAPLING, 6, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_ENCHANTED_TREE1 = createConfiguredFeature("blue_enchanted_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_1"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_1"),
                    BiasedToBottomInt.of(3, 8),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_BLUE_ENCHANTED_LOG.defaultBlockState(), 1).add(BLUE_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(BLUE_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.log(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_ENCHANTED_TREE2 = createConfiguredFeature("blue_enchanted_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_2"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_2"),
                    BiasedToBottomInt.of(3, 8),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_BLUE_ENCHANTED_LOG.defaultBlockState(), 1).add(BLUE_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(BLUE_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.log(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_ENCHANTED_TREE3 = createConfiguredFeature("blue_enchanted_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_3"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_3"),
                    BiasedToBottomInt.of(3, 8),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_BLUE_ENCHANTED_LOG.defaultBlockState(), 1).add(BLUE_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(BLUE_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.log(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_ENCHANTED_TREE4 = createConfiguredFeature("blue_enchanted_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_4"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_4"),
                    ConstantInt.of(0)
                    ,
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_BLUE_ENCHANTED_LOG.defaultBlockState(), 1).add(BLUE_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(BLUE_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.wood(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_ENCHANTED_TREE1 = createConfiguredFeature("green_enchanted_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_1"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_1"),
                    BiasedToBottomInt.of(3, 8),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_GREEN_ENCHANTED_LOG.defaultBlockState(), 1).add(GREEN_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(GREEN_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.log(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_GREEN_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_ENCHANTED_TREE2 = createConfiguredFeature("green_enchanted_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_2"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_2"),
                    BiasedToBottomInt.of(3, 8),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_GREEN_ENCHANTED_LOG.defaultBlockState(), 1).add(GREEN_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(GREEN_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.log(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_GREEN_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_ENCHANTED_TREE3 = createConfiguredFeature("green_enchanted_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_3"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_3"),
                    BiasedToBottomInt.of(3, 8),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_GREEN_ENCHANTED_LOG.defaultBlockState(), 1).add(GREEN_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(GREEN_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.log(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_GREEN_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_ENCHANTED_TREE4 = createConfiguredFeature("green_enchanted_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/enchanted/enchanted_trunk_4"),
                    BYG.createLocation("features/trees/enchanted/enchanted_canopy_4"),
                    ConstantInt.of(0)
                    ,
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMBUED_GREEN_ENCHANTED_LOG.defaultBlockState(), 1).add(GREEN_ENCHANTED.log().defaultBlockState(), 4).build()),
                    BlockStateProvider.simple(GREEN_ENCHANTED.leaves().defaultBlockState()),
                    BLUE_ENCHANTED.log(),
                    BLUE_ENCHANTED.leaves(),
                    BYGBlockTags.GROUND_GREEN_ENCHANTED_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA_TREE1 = createConfiguredFeature("jacaranda_tree1",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA_TREE2 = createConfiguredFeature("jacaranda_tree2",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA_TREE3 = createConfiguredFeature("jacaranda_tree3",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA_TREE4 = createConfiguredFeature("jacaranda_tree4",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> INDIGO_JACARANDA_TREE1 = createConfiguredFeature("indigo_jacaranda_tree1",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> INDIGO_JACARANDA_TREE2 = createConfiguredFeature("indigo_jacaranda_tree2",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> INDIGO_JACARANDA_TREE3 = createConfiguredFeature("indigo_jacaranda_tree3",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> INDIGO_JACARANDA_TREE4 = createConfiguredFeature("indigo_jacaranda_tree4",
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

    public static final Supplier<AttachedToLeavesDecorator> JOSHUA_FRUIT = () -> new AttachedToFruitLeavesDecorator(0.1F, 2, 0, BYGBlocks.RIPE_JOSHUA_LEAVES.get(), new RandomizedIntStateProvider(BlockStateProvider.simple(BYGBlocks.JOSHUA_FRUIT_BLOCK.defaultBlockState()), FruitBlock.AGE, UniformInt.of(0, 3)), 2, List.of(Direction.DOWN));

    public static final ResourceKey<ConfiguredFeature<?, ?>> JOSHUA_TREE1 = createConfiguredFeature("joshua_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/joshua/joshua_trunk1"),
                    BYG.createLocation("features/trees/joshua/joshua_canopy1"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(BYGBlocks.JOSHUA_LEAVES.defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_JOSHUA_LEAVES.defaultBlockState(), 2)
                            .add(BYGBlocks.RIPE_JOSHUA_LEAVES.defaultBlockState(), 1).build()
                    ),
                    Blocks.OAK_LOG,
                    BYGBlocks.JOSHUA_LEAVES.get(),
                    BYGBlockTags.GROUND_JOSHUA_SAPLING, 4, ImmutableList.of(JOSHUA_FRUIT.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> JOSHUA_TREE2 = createConfiguredFeature("joshua_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/joshua/joshua_trunk2"),
                    BYG.createLocation("features/trees/joshua/joshua_canopy2"),
                    BiasedToBottomInt.of(5, 8),
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(BYGBlocks.JOSHUA_LEAVES.defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_JOSHUA_LEAVES.defaultBlockState(), 2)
                            .add(BYGBlocks.RIPE_JOSHUA_LEAVES.defaultBlockState(), 1).build()
                    ),
                    Blocks.OAK_LOG,
                    BYGBlocks.JOSHUA_LEAVES.get(),
                    BYGBlockTags.GROUND_JOSHUA_SAPLING, 6, ImmutableList.of(JOSHUA_FRUIT.get())
            )
    );

    // TODO: BYG Propagule
    public static final Supplier<AttachedToLeavesDecorator> PROPAGULE_DECORATOR = () -> new AttachedToLeavesDecorator(0.14F, 1, 0, new RandomizedIntStateProvider(BlockStateProvider.simple(Blocks.MANGROVE_PROPAGULE.defaultBlockState().setValue(MangrovePropaguleBlock.HANGING, Boolean.TRUE)), MangrovePropaguleBlock.AGE, UniformInt.of(0, 4)), 2, List.of(Direction.DOWN));

    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_MANGROVE_TREE1 = createConfiguredFeature("white_mangrove_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/white_mangrove_tree1_base"),
                    BYG.createLocation("features/trees/white_mangrove_tree1_canopy"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    BlockStateProvider.simple(WHITE_MANGROVE.leaves().get()),
                    WHITE_MANGROVE.log(),
                    WHITE_MANGROVE.leaves(),
                    BYGBlockTags.GROUND_WHITE_MANGROVE_SAPLING, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_MANGROVE_TREE2 = createConfiguredFeature("white_mangrove_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/white_mangrove_tree2_base"),
                    BYG.createLocation("features/trees/white_mangrove_tree2_canopy"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    BlockStateProvider.simple(WHITE_MANGROVE.leaves().get()),
                    WHITE_MANGROVE.log(),
                    WHITE_MANGROVE.leaves(),
                    BYGBlockTags.GROUND_WHITE_MANGROVE_SAPLING, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_MANGROVE_TREE3 = createConfiguredFeature("white_mangrove_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/white_mangrove_tree3_base"),
                    BYG.createLocation("features/trees/white_mangrove_tree3_canopy"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    BlockStateProvider.simple(WHITE_MANGROVE.leaves().get()),
                    WHITE_MANGROVE.log(),
                    WHITE_MANGROVE.leaves(),
                    BYGBlockTags.GROUND_WHITE_MANGROVE_SAPLING, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_MANGROVE_TREE4 = createConfiguredFeature("white_mangrove_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/white_mangrove_tree4_base"),
                    BYG.createLocation("features/trees/white_mangrove_tree4_canopy"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    BlockStateProvider.simple(WHITE_MANGROVE.leaves().get()),
                    WHITE_MANGROVE.log(),
                    WHITE_MANGROVE.leaves(),
                    BYGBlockTags.GROUND_WHITE_MANGROVE_SAPLING, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_MANGROVE_TREE5 = createConfiguredFeature("white_mangrove_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/white_mangrove_tree5_base"),
                    BYG.createLocation("features/trees/white_mangrove_tree5_canopy"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    BlockStateProvider.simple(WHITE_MANGROVE.leaves().get()),
                    WHITE_MANGROVE.log(),
                    WHITE_MANGROVE.leaves(),
                    BYGBlockTags.GROUND_WHITE_MANGROVE_SAPLING, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> IRONWOOD_TREE = createConfiguredFeature("ironwood_tree",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/ironwood/ironwood_trunk_1"),
                    BYG.createLocation("features/trees/ironwood/ironwood_canopy_1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WHITE_MANGROVE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.AZALEA_LEAVES.defaultBlockState(), 4).add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    () -> Blocks.AZALEA_LEAVES,
                    BYGBlockTags.GROUND_WHITE_MANGROVE_SAPLING, 5, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_TREE1 = createConfiguredFeature("maple_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk1"),
                    BYG.createLocation("features/trees/maple/maple_canopy1"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(MAPLE.leaves().get().defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_TREE2 = createConfiguredFeature("maple_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk2"),
                    BYG.createLocation("features/trees/maple/maple_canopy2"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(MAPLE.leaves().get().defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_TREE3 = createConfiguredFeature("maple_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk3"),
                    BYG.createLocation("features/trees/maple/maple_canopy3"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(MAPLE.leaves().get().defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_TREE4 = createConfiguredFeature("maple_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk4"),
                    BYG.createLocation("features/trees/maple/maple_canopy4"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(MAPLE.leaves().get().defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_TREE5 = createConfiguredFeature("maple_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk4"),
                    BYG.createLocation("features/trees/maple/maple_canopy5"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(MAPLE.leaves().get().defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_TREE1 = createConfiguredFeature("red_maple_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk1"),
                    BYG.createLocation("features/trees/maple/maple_canopy1"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_MAPLE_LEAVES.defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_TREE2 = createConfiguredFeature("red_maple_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk2"),
                    BYG.createLocation("features/trees/maple/maple_canopy2"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_MAPLE_LEAVES.defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_TREE3 = createConfiguredFeature("red_maple_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk3"),
                    BYG.createLocation("features/trees/maple/maple_canopy3"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_MAPLE_LEAVES.defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_TREE4 = createConfiguredFeature("red_maple_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk4"),
                    BYG.createLocation("features/trees/maple/maple_canopy4"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_MAPLE_LEAVES.defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_TREE5 = createConfiguredFeature("red_maple_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk4"),
                    BYG.createLocation("features/trees/maple/maple_canopy5"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_MAPLE_LEAVES.defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_MAPLE_TREE1 = createConfiguredFeature("silver_maple_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk1"),
                    BYG.createLocation("features/trees/maple/maple_canopy1"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SILVER_MAPLE_LEAVES.defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_MAPLE_TREE2 = createConfiguredFeature("silver_maple_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk2"),
                    BYG.createLocation("features/trees/maple/maple_canopy2"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SILVER_MAPLE_LEAVES.defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_MAPLE_TREE3 = createConfiguredFeature("silver_maple_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk3"),
                    BYG.createLocation("features/trees/maple/maple_canopy3"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SILVER_MAPLE_LEAVES.defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_MAPLE_TREE4 = createConfiguredFeature("silver_maple_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk4"),
                    BYG.createLocation("features/trees/maple/maple_canopy4"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SILVER_MAPLE_LEAVES.defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_MAPLE_TREE5 = createConfiguredFeature("silver_maple_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/maple/maple_trunk4"),
                    BYG.createLocation("features/trees/maple/maple_canopy5"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(MAPLE.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.SILVER_MAPLE_LEAVES.defaultBlockState(), 1).build()),
                    MAPLE.log().get(),
                    MAPLE.leaves().get(),
                    BYGBlockTags.GROUND_MAPLE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MEADOW_TREE1 = createConfiguredFeature("meadow_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/meadow/meadow_canopy1"),
                    BiasedToBottomInt.of(6, 8),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEADOW_TREE2 = createConfiguredFeature("meadow_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/meadow/meadow_canopy2"),
                    BiasedToBottomInt.of(6, 8),
                    BlockStateProvider.simple(Blocks.DARK_OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.DARK_OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.DARK_OAK_LOG,
                    Blocks.DARK_OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEADOW_TREE3 = createConfiguredFeature("meadow_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/meadow/meadow_canopy3"),
                    BiasedToBottomInt.of(6, 8),
                    BlockStateProvider.simple(Blocks.DARK_OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.DARK_OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.DARK_OAK_LOG,
                    Blocks.DARK_OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_TREE1 = createConfiguredFeature("oak_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/oak_trunk1"),
                    BYG.createLocation("features/trees/oak/oak_canopy1"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_TREE2 = createConfiguredFeature("oak_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/oak_trunk2"),
                    BYG.createLocation("features/trees/oak/oak_canopy2"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_TREE3 = createConfiguredFeature("oak_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/oak/oak_canopy3"),
                    BiasedToBottomInt.of(5, 6),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_TREE_LARGE1 = createConfiguredFeature("large_oak_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk1"),
                    BYG.createLocation("features/trees/oak/large_oak_canopy1"),
                    BiasedToBottomInt.of(2, 4),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_TREE_LARGE2 = createConfiguredFeature("large_oak_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk2"),
                    BYG.createLocation("features/trees/oak/large_oak_canopy2"),
                    BiasedToBottomInt.of(1, 3),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_TREE_LARGE3 = createConfiguredFeature("large_oak_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk3"),
                    BYG.createLocation("features/trees/oak/large_oak_canopy3"),
                    BiasedToBottomInt.of(1, 3),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_OAK_TREE1 = createConfiguredFeature("red_oak_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/oak_trunk1"),
                    BYG.createLocation("features/trees/oak/red_oak_canopy1"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.RED_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_RED_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_OAK_TREE2 = createConfiguredFeature("red_oak_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/oak_trunk2"),
                    BYG.createLocation("features/trees/oak/red_oak_canopy2"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.RED_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_RED_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_OAK_TREE3 = createConfiguredFeature("red_oak_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/oak/red_oak_canopy3"),
                    BiasedToBottomInt.of(5, 6),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.RED_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_RED_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_OAK_TREE_LARGE1 = createConfiguredFeature("large_red_oak_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk1"),
                    BYG.createLocation("features/trees/oak/large_red_oak_canopy1"),
                    BiasedToBottomInt.of(2, 4),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.RED_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_OAK_TREE_LARGE2 = createConfiguredFeature("large_red_oak_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk2"),
                    BYG.createLocation("features/trees/oak/large_red_oak_canopy2"),
                    BiasedToBottomInt.of(1, 3),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.RED_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_OAK_TREE_LARGE3 = createConfiguredFeature("large_red_oak_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk3"),
                    BYG.createLocation("features/trees/oak/large_red_oak_canopy3"),
                    BiasedToBottomInt.of(1, 3),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.RED_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_OAK_TREE1 = createConfiguredFeature("brown_oak_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/oak_trunk1"),
                    BYG.createLocation("features/trees/oak/brown_oak_canopy1"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BROWN_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.BROWN_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_OAK_TREE2 = createConfiguredFeature("brown_oak_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/oak_trunk1"),
                    BYG.createLocation("features/trees/oak/brown_oak_canopy2"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BROWN_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.BROWN_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_OAK_TREE3 = createConfiguredFeature("brown_oak_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/oak/brown_oak_canopy3"),
                    BiasedToBottomInt.of(5, 6),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BROWN_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.BROWN_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_OAK_TREE_LARGE1 = createConfiguredFeature("large_brown_oak_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk1"),
                    BYG.createLocation("features/trees/oak/large_brown_oak_canopy1"),
                    BiasedToBottomInt.of(2, 4),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BROWN_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.BROWN_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_OAK_TREE_LARGE2 = createConfiguredFeature("large_brown_oak_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk2"),
                    BYG.createLocation("features/trees/oak/large_brown_oak_canopy2"),
                    BiasedToBottomInt.of(1, 3),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BROWN_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.BROWN_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_OAK_TREE_LARGE3 = createConfiguredFeature("large_brown_oak_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk3"),
                    BYG.createLocation("features/trees/oak/large_brown_oak_canopy3"),
                    BiasedToBottomInt.of(1, 3),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BROWN_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.BROWN_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_OAK_TREE1 = createConfiguredFeature("orange_oak_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/oak_trunk1"),
                    BYG.createLocation("features/trees/oak/orange_oak_canopy1"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.ORANGE_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_ORANGE_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_OAK_TREE2 = createConfiguredFeature("orange_oak_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/oak_trunk2"),
                    BYG.createLocation("features/trees/oak/orange_oak_canopy2"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.ORANGE_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_ORANGE_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_OAK_TREE3 = createConfiguredFeature("orange_oak_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/oak/orange_oak_canopy3"),
                    BiasedToBottomInt.of(5, 6),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.ORANGE_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_ORANGE_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_OAK_TREE_LARGE1 = createConfiguredFeature("large_orange_oak_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk1"),
                    BYG.createLocation("features/trees/oak/large_orange_oak_canopy1"),
                    BiasedToBottomInt.of(2, 4),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.ORANGE_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_OAK_TREE_LARGE2 = createConfiguredFeature("large_orange_oak_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk2"),
                    BYG.createLocation("features/trees/oak/large_orange_oak_canopy2"),
                    BiasedToBottomInt.of(1, 3),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.ORANGE_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_OAK_TREE_LARGE3 = createConfiguredFeature("large_orange_oak_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/oak/large_oak_trunk2"),
                    BYG.createLocation("features/trees/oak/large_orange_oak_canopy2"),
                    BiasedToBottomInt.of(1, 3),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_OAK_LEAVES.get().defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    BYGBlocks.ORANGE_OAK_LEAVES.get(),
                    BYGBlockTags.GROUND_BROWN_OAK_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORCHARD_TREE1 = createConfiguredFeature("orchard_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/orchard/orchard_trunk1"),
                    BYG.createLocation("features/trees/orchard/orchard_canopy1"),
                    BiasedToBottomInt.of(6, 11),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(BYGBlocks.ORCHARD_LEAVES.defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_ORCHARD_LEAVES.defaultBlockState(), 1)
                            .add(BYGBlocks.RIPE_ORCHARD_LEAVES.defaultBlockState(), 1).build()
                    ),
                    Blocks.OAK_LOG,
                    BYGBlocks.ORCHARD_LEAVES.get(),
                    BYGBlockTags.GROUND_ORCHARD_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORCHARD_TREE2 = createConfiguredFeature("orchard_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/orchard/orchard_trunk2"),
                    BYG.createLocation("features/trees/orchard/orchard_canopy2"),
                    BiasedToBottomInt.of(7, 12),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(BYGBlocks.ORCHARD_LEAVES.defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_ORCHARD_LEAVES.defaultBlockState(), 1)
                            .add(BYGBlocks.RIPE_ORCHARD_LEAVES.defaultBlockState(), 1).build()
                    ),
                    Blocks.OAK_LOG,
                    BYGBlocks.ORCHARD_LEAVES.get(),
                    BYGBlockTags.GROUND_ORCHARD_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORCHARD_TREE3 = createConfiguredFeature("orchard_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/orchard/orchard_canopy3"),
                    UniformInt.of(9, 12),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(BYGBlocks.ORCHARD_LEAVES.defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_ORCHARD_LEAVES.defaultBlockState(), 1)
                            .add(BYGBlocks.RIPE_ORCHARD_LEAVES.defaultBlockState(), 1).build()
                    ),
                    Blocks.OAK_LOG,
                    BYGBlocks.ORCHARD_LEAVES.get(),
                    BYGBlockTags.GROUND_ORCHARD_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_TREE1 = createConfiguredFeature("palm_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/palm/palm_trunk"),
                    BYG.createLocation("features/trees/palm/palm_canopy1"),
                    BiasedToBottomInt.of(1, 1),
                    BlockStateProvider.simple(PALM.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(PALM.leaves().defaultBlockState(), 1).build()),
                    PALM.log(),
                    PALM.leaves(),
                    BYGBlockTags.GROUND_PALM_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_TREE2 = createConfiguredFeature("palm_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/palm/palm_trunk"),
                    BYG.createLocation("features/trees/palm/palm_canopy2"),
                    BiasedToBottomInt.of(3, 4),
                    BlockStateProvider.simple(PALM.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(PALM.leaves().defaultBlockState(), 1).build()),
                    PALM.log(),
                    PALM.leaves(),
                    BYGBlockTags.GROUND_PALM_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_TREE3 = createConfiguredFeature("palm_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/palm/palm_trunk"),
                    BYG.createLocation("features/trees/palm/palm_canopy3"),
                    BiasedToBottomInt.of(1, 2),
                    BlockStateProvider.simple(PALM.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(PALM.leaves().defaultBlockState(), 1).build()),
                    PALM.log(),
                    PALM.leaves(),
                    BYGBlockTags.GROUND_PALM_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_TREE4 = createConfiguredFeature("palm_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/palm/palm_trunk4"),
                    BYG.createLocation("features/trees/palm/palm_canopy4"),
                    BiasedToBottomInt.of(3, 4),
                    BlockStateProvider.simple(PALM.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(PALM.leaves().defaultBlockState(), 1).build()),
                    PALM.log(),
                    PALM.leaves(),
                    BYGBlockTags.GROUND_PALM_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_LARGE_TREE1 = createConfiguredFeature("large_pine_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/pine/large_pine_trunk1"),
                    BYG.createLocation("features/trees/pine/large_pine_canopy2"),
                    BiasedToBottomInt.of(7, 9),
                    BlockStateProvider.simple(PINE.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(PINE.leaves().defaultBlockState(), 1).build()),
                    PINE.log(),
                    PINE.leaves(),
                    BYGBlockTags.GROUND_PINE_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_LARGE_TREE2 = createConfiguredFeature("large_pine_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/pine/large_pine_canopy1"),
                    BiasedToBottomInt.of(7, 9),
                    BlockStateProvider.simple(PINE.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(PINE.leaves().defaultBlockState(), 1).build()),
                    PINE.log(),
                    PINE.leaves(),
                    BYGBlockTags.GROUND_PINE_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_TREE1 = createConfiguredFeature("pine_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/pine/pine_canopy1"),
                    BiasedToBottomInt.of(9, 12),
                    BlockStateProvider.simple(PINE.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(PINE.leaves().defaultBlockState(), 1).build()),
                    PINE.log(),
                    PINE.leaves(),
                    BYGBlockTags.GROUND_PINE_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_TREE2 = createConfiguredFeature("pine_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/pine/pine_canopy2"),
                    BiasedToBottomInt.of(9, 12),
                    BlockStateProvider.simple(PINE.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(PINE.leaves().defaultBlockState(), 1).build()),
                    PINE.log(),
                    PINE.leaves(),
                    BYGBlockTags.GROUND_PINE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PALO_VERDE_TREE1 = createConfiguredFeature("palo_verde_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/palo-verde/palo_verde_tree_canopy1"),
                    BiasedToBottomInt.of(1, 4),
                    BlockStateProvider.simple(BYGBlocks.PALO_VERDE_LOG.get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PALO_VERDE_LEAVES.get().defaultBlockState(), 1).build()),
                    BYGBlocks.PALO_VERDE_LOG.get(),
                    BYGBlocks.PALO_VERDE_LEAVES.get(),
                    BYGBlockTags.GROUND_PALO_VERDE_SAPLING, 2, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALO_VERDE_TREE2 = createConfiguredFeature("palo_verde_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/palo-verde/palo_verde_tree_canopy2"),
                    BiasedToBottomInt.of(1, 4),
                    BlockStateProvider.simple(BYGBlocks.PALO_VERDE_LOG.get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PALO_VERDE_LEAVES.get().defaultBlockState(), 1).build()),
                    BYGBlocks.PALO_VERDE_LOG.get(),
                    BYGBlocks.PALO_VERDE_LEAVES.get(),
                    BYGBlockTags.GROUND_PALO_VERDE_SAPLING, 2, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RAINBOW_EUCALYPTUS_TREE1 = createConfiguredFeature("rainbow_eucalyptus_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/rainbow-eucalyptus/rainbow_eucalyptus_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(RAINBOW_EUCALYPTUS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(RAINBOW_EUCALYPTUS.leaves().defaultBlockState(), 1).build()),
                    RAINBOW_EUCALYPTUS.log(),
                    RAINBOW_EUCALYPTUS.leaves(),
                    BYGBlockTags.GROUND_RAINBOW_EUCALYPTUS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator((VineBlock) Blocks.VINE, 0.05F), new BYGTrunkVineDecorator((VineBlock) Blocks.VINE, 0.05F))
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> RAINBOW_EUCALYPTUS_LARGE_TREE1 = createConfiguredFeature("rainbow_eucalyptus_large_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/rainbow-eucalyptus/rainbow_eucalyptus_tree_large_trunk1"),
                    BYG.createLocation("features/trees/rainbow-eucalyptus/rainbow_eucalyptus_tree_large_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(RAINBOW_EUCALYPTUS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(RAINBOW_EUCALYPTUS.leaves().defaultBlockState(), 1).build()),
                    RAINBOW_EUCALYPTUS.log(),
                    RAINBOW_EUCALYPTUS.leaves(),
                    BYGBlockTags.GROUND_RAINBOW_EUCALYPTUS_SAPLING, 5, ImmutableList.of(new BYGTrunkVineDecorator((VineBlock) Blocks.VINE, 0.05F), new BYGLeavesVineDecorator((VineBlock) Blocks.VINE, 0.05F))
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_TREE1 = createConfiguredFeature("redwood_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/redwood/redwood_tree_trunk1"),
                    BYG.createLocation("features/trees/redwood/redwood_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(REDWOOD.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(REDWOOD.leaves().defaultBlockState(), 1).build()),
                    REDWOOD.log(),
                    REDWOOD.leaves(),
                    BYGBlockTags.GROUND_REDWOOD_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_TREE2 = createConfiguredFeature("redwood_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/redwood/redwood_tree_trunk2"),
                    BYG.createLocation("features/trees/redwood/redwood_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(REDWOOD.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(REDWOOD.leaves().defaultBlockState(), 1).build()),
                    REDWOOD.log(),
                    REDWOOD.leaves(),
                    BYGBlockTags.GROUND_REDWOOD_SAPLING, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_TREE3 = createConfiguredFeature("redwood_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/redwood/redwood_tree_trunk3"),
                    BYG.createLocation("features/trees/redwood/redwood_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(REDWOOD.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(REDWOOD.leaves().defaultBlockState(), 1).build()),
                    REDWOOD.log(),
                    REDWOOD.leaves(),
                    BYGBlockTags.GROUND_REDWOOD_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SHRUB_MEADOW = createConfiguredFeature("meadow_shrub1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/meadow/meadow_shrub_canopy1"),
                    ConstantInt.of(0)
                    ,
                    BlockStateProvider.simple(Blocks.DARK_OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.DARK_OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_ORANGE_OAK_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SHRUB_MEADOW2 = createConfiguredFeature("meadow_shrub2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/meadow/meadow_shrub_canopy2"),
                    ConstantInt.of(0)
                    ,
                    BlockStateProvider.simple(Blocks.DARK_OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.DARK_OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_ORANGE_OAK_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SHRUB_PRAIRIE1 = createConfiguredFeature("prairie_shrub1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/prairie/prairie_shrub_canopy1"),
                    ConstantInt.of(0)
                    ,
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_ORANGE_OAK_SAPLING, 0, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHRUB_PRAIRIE2 = createConfiguredFeature("prairie_shrub2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/prairie/prairie_shrub_canopy2"),
                    ConstantInt.of(0)
                    ,
                    BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.OAK_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BYGBlockTags.GROUND_ORANGE_OAK_SAPLING, 0, ImmutableList.of()
            )
    );

    public static final Supplier<AttachedToLeavesDecorator> GREEN_APPLE_FRUIT = () -> new AttachedToFruitLeavesDecorator(0.1F, 2, 0, BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.get(), new RandomizedIntStateProvider(BlockStateProvider.simple(BYGBlocks.GREEN_APPLE_FRUIT_BLOCK.defaultBlockState()), FruitBlock.AGE, UniformInt.of(0, 3)), 2, List.of(Direction.DOWN));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYRIS_TREE1 = createConfiguredFeature("skyris_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_1"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(SKYRIS.leaves().defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_SKYRIS_LEAVES.defaultBlockState(), 2)
                            .add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).build()
                    ),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F), GREEN_APPLE_FRUIT.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYRIS_TREE2 = createConfiguredFeature("skyris_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_2"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(SKYRIS.leaves().defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_SKYRIS_LEAVES.defaultBlockState(), 2)
                            .add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).build()
                    ),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F), GREEN_APPLE_FRUIT.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYRIS_TREE3 = createConfiguredFeature("skyris_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_3"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(SKYRIS.leaves().defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_SKYRIS_LEAVES.defaultBlockState(), 2)
                            .add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).build()
                    ),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F), GREEN_APPLE_FRUIT.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYRIS_TREE4 = createConfiguredFeature("skyris_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_4"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(SKYRIS.leaves().defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_SKYRIS_LEAVES.defaultBlockState(), 2)
                            .add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).build()
                    ),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F), GREEN_APPLE_FRUIT.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYRIS_TREE5 = createConfiguredFeature("skyris_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_5"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_5"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(SKYRIS.leaves().defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_SKYRIS_LEAVES.defaultBlockState(), 2)
                            .add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).build()
                    ),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F), GREEN_APPLE_FRUIT.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYRIS_TREE6 = createConfiguredFeature("skyris_tree6",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/skyris/skyris_trunk_6"),
                    BYG.createLocation("features/trees/skyris/skyris_canopy_6"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(SKYRIS.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(SKYRIS.leaves().defaultBlockState(), 10)
                            .add(BYGBlocks.FLOWERING_SKYRIS_LEAVES.defaultBlockState(), 2)
                            .add(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState(), 1).build()
                    ),
                    SKYRIS.log(),
                    SKYRIS.leaves(),
                    BYGBlockTags.GROUND_SKYRIS_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.1F), new BYGTrunkVineDecorator(BYGBlocks.SKYRIS_VINE.get(), 0.3F), GREEN_APPLE_FRUIT.get())
            )
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREE1 = createConfiguredFeature("spruce_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREE2 = createConfiguredFeature("spruce_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREE3 = createConfiguredFeature("spruce_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREE4 = createConfiguredFeature("spruce_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREE_MEDIUM1 = createConfiguredFeature("spruce_tree_medium1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREE_MEDIUM2 = createConfiguredFeature("spruce_tree_medium2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREE_MEDIUM3 = createConfiguredFeature("spruce_tree_medium3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREE_MEDIUM4 = createConfiguredFeature("spruce_tree_medium4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREE_LARGE1 = createConfiguredFeature("spruce_tree_large1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_large_trunk1"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_large_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    //Yellow Spruce
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_YELLOW_TREE1 = createConfiguredFeature("spruce_yellow_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_YELLOW_TREE2 = createConfiguredFeature("spruce_yellow_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_YELLOW_TREE3 = createConfiguredFeature("spruce_yellow_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_YELLOW_TREE4 = createConfiguredFeature("spruce_yellow_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_YELLOW_TREE_MEDIUM1 = createConfiguredFeature("spruce_yellow_tree_medium1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_YELLOW_TREE_MEDIUM2 = createConfiguredFeature("spruce_yellow_tree_medium2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_YELLOW_TREE_MEDIUM3 = createConfiguredFeature("spruce_yellow_tree_medium3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_YELLOW_TREE_MEDIUM4 = createConfiguredFeature("spruce_yellow_tree_medium4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_YELLOW_TREE_LARGE1 = createConfiguredFeature("spruce_yellow_tree_large1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_large_trunk1"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_large_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.YELLOW_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    //Orange Spruce
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_ORANGE_TREE1 = createConfiguredFeature("spruce_orange_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_ORANGE_TREE2 = createConfiguredFeature("spruce_orange_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_ORANGE_TREE3 = createConfiguredFeature("spruce_orange_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_ORANGE_TREE4 = createConfiguredFeature("spruce_orange_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_ORANGE_TREE_MEDIUM1 = createConfiguredFeature("spruce_orange_tree_medium1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_ORANGE_TREE_MEDIUM2 = createConfiguredFeature("spruce_orange_tree_medium2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_ORANGE_TREE_MEDIUM3 = createConfiguredFeature("spruce_orange_tree_medium3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_ORANGE_TREE_MEDIUM4 = createConfiguredFeature("spruce_orange_tree_medium4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_ORANGE_TREE_LARGE1 = createConfiguredFeature("spruce_orange_tree_large1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_large_trunk1"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_large_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ORANGE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    //Red Spruce
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_RED_TREE1 = createConfiguredFeature("spruce_red_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_RED_TREE2 = createConfiguredFeature("spruce_red_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_RED_TREE3 = createConfiguredFeature("spruce_red_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_RED_TREE4 = createConfiguredFeature("spruce_red_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_RED_TREE_MEDIUM1 = createConfiguredFeature("spruce_red_tree_medium1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_RED_TREE_MEDIUM2 = createConfiguredFeature("spruce_red_tree_medium2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_RED_TREE_MEDIUM3 = createConfiguredFeature("spruce_red_tree_medium3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_RED_TREE_MEDIUM4 = createConfiguredFeature("spruce_red_tree_medium4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_RED_TREE_LARGE1 = createConfiguredFeature("spruce_red_tree_large1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_large_trunk1"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_large_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.RED_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_BLUE_TREE1 = createConfiguredFeature("spruce_blue_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLUE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_BLUE_TREE2 = createConfiguredFeature("spruce_blue_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLUE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_BLUE_TREE3 = createConfiguredFeature("spruce_blue_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLUE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_BLUE_TREE4 = createConfiguredFeature("spruce_blue_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLUE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_BLUE_TREE_MEDIUM1 = createConfiguredFeature("spruce_blue_tree_medium1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLUE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_BLUE_TREE_MEDIUM2 = createConfiguredFeature("spruce_blue_tree_medium2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLUE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_BLUE_TREE_MEDIUM3 = createConfiguredFeature("spruce_blue_tree_medium3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLUE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_BLUE_TREE_MEDIUM4 = createConfiguredFeature("spruce_blue_tree_medium4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_trunk2"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_medium_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLUE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_BLUE_TREE_LARGE1 = createConfiguredFeature("spruce_blue_tree_large1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/spruce/spruce_tree_large_trunk1"),
                    BYG.createLocation("features/trees/spruce/spruce_tree_large_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BLUE_SPRUCE_LEAVES.defaultBlockState(), 1).build()),
                    Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> TROPICAL_SHRUB1 = createConfiguredFeature("tropical_shrub1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/mahogany/tropical_shrub_canopy1"),
                    ConstantInt.of(0)
                    ,
                    BlockStateProvider.simple(MAHOGANY.log().get()),
                    BlockStateProvider.simple(MAHOGANY.leaves().get()),
                    MAHOGANY.log(),
                    MAHOGANY.leaves(),
                    BYGBlockTags.GROUND_MAHOGANY_SAPLING, 0, ImmutableList.of(new BYGLeavesVineDecorator((VineBlock) Blocks.VINE, 0.5F), new BYGTrunkVineDecorator((VineBlock) Blocks.VINE, 1F))
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAHOGANY_TREE1 = createConfiguredFeature("mahogany_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/mahogany/mahogany_tree_trunk1"),
                    BYG.createLocation("features/trees/mahogany/mahogany_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(MAHOGANY.log().get()),
                    BlockStateProvider.simple(MAHOGANY.leaves().get()),
                    MAHOGANY.log(),
                    MAHOGANY.leaves(),
                    BYGBlockTags.GROUND_MAHOGANY_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator((VineBlock) Blocks.VINE, 0.5F), new BYGTrunkVineDecorator((VineBlock) Blocks.VINE, 1F), new CocoaDecorator(0.2F))
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAHOGANY_TREE2 = createConfiguredFeature("mahogany_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/mahogany/mahogany_tree_trunk1"),
                    BYG.createLocation("features/trees/mahogany/mahogany_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(MAHOGANY.log().get()),
                    BlockStateProvider.simple(MAHOGANY.leaves().get()),
                    MAHOGANY.log(),
                    MAHOGANY.leaves(),
                    BYGBlockTags.GROUND_MAHOGANY_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator((VineBlock) Blocks.VINE, 0.4F), new BYGTrunkVineDecorator((VineBlock) Blocks.VINE, 1F), new CocoaDecorator(0.2F))
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAHOGANY_TREE3 = createConfiguredFeature("mahogany_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/mahogany/mahogany_tree_trunk1"),
                    BYG.createLocation("features/trees/mahogany/mahogany_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(MAHOGANY.log().get()),
                    BlockStateProvider.simple(MAHOGANY.leaves().get()),
                    MAHOGANY.log(),
                    MAHOGANY.leaves(),
                    BYGBlockTags.GROUND_MAHOGANY_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator((VineBlock) Blocks.VINE, 0.4F), new BYGTrunkVineDecorator((VineBlock) Blocks.VINE, 1F), new CocoaDecorator(0.2F))
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAHOGANY_TREE4 = createConfiguredFeature("mahogany_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/mahogany/mahogany_tree_trunk4"),
                    BYG.createLocation("features/trees/mahogany/mahogany_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(MAHOGANY.log().get()),
                    BlockStateProvider.simple(MAHOGANY.leaves().get()),
                    MAHOGANY.log(),
                    MAHOGANY.leaves(),
                    BYGBlockTags.GROUND_MAHOGANY_SAPLING, 5, ImmutableList.of(new BYGLeavesVineDecorator((VineBlock) Blocks.VINE, 0.4F), new BYGTrunkVineDecorator((VineBlock) Blocks.VINE, 1F), new CocoaDecorator(0.2F))
            )
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> WOODLANDS_TREE1 = createConfiguredFeature("woodlands_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/woodlands/woodlands_tree_trunk1"),
                    BYG.createLocation("features/trees/woodlands/woodlands_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(Blocks.OAK_LOG),
                    BlockStateProvider.simple(Blocks.OAK_LEAVES),
                    Blocks.OAK_LOG,
                    Blocks.OAK_LEAVES,
                    BlockTags.DIRT, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_DEAD_TREE1 = createConfiguredFeature("dead_willow_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/willow/dead_willow_trunk"),
                    BYG.createLocation("features/trees/willow/dead_willow_canopy"),
                    BiasedToBottomInt.of(5, 7),
                    BlockStateProvider.simple(WILLOW.log().get()),
                    BlockStateProvider.simple(WILLOW.leaves().get()),
                    WILLOW.log(),
                    WILLOW.leaves(),
                    BYGBlockTags.GROUND_WILLOW_SAPLING, 10, ImmutableList.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_TREE1 = createConfiguredFeature("willow_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/willow/willow_tree_trunk1"),
                    BYG.createLocation("features/trees/willow/willow_tree_canopy1"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WILLOW.log().get()),
                    BlockStateProvider.simple(WILLOW.leaves().get()),
                    WILLOW.log(),
                    WILLOW.leaves(),
                    BYGBlockTags.GROUND_WILLOW_SAPLING, 10, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_TREE2 = createConfiguredFeature("willow_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/willow/willow_tree_trunk1"),
                    BYG.createLocation("features/trees/willow/willow_tree_canopy2"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WILLOW.log().get()),
                    BlockStateProvider.simple(WILLOW.leaves().get()),
                    WILLOW.log(),
                    WILLOW.leaves(),
                    BYGBlockTags.GROUND_WILLOW_SAPLING, 10, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_TREE3 = createConfiguredFeature("willow_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/willow/willow_tree_trunk1"),
                    BYG.createLocation("features/trees/willow/willow_tree_canopy3"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WILLOW.log().get()),
                    BlockStateProvider.simple(WILLOW.leaves().get()),
                    WILLOW.log(),
                    WILLOW.leaves(),
                    BYGBlockTags.GROUND_WILLOW_SAPLING, 10, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_TREE4 = createConfiguredFeature("willow_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/willow/willow_tree_trunk2"),
                    BYG.createLocation("features/trees/willow/willow_tree_canopy4"),
                    BiasedToBottomInt.of(5, 15),
                    BlockStateProvider.simple(WILLOW.log().get()),
                    BlockStateProvider.simple(WILLOW.leaves().get()),
                    WILLOW.log(),
                    WILLOW.leaves(),
                    BYGBlockTags.GROUND_WILLOW_SAPLING, 10, ImmutableList.of(new LeaveVineDecorator(1), new TrunkVineDecorator(), MOSS_CARPET.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ZELKOVA_TREE1 = createConfiguredFeature("zelkova_tree1",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZELKOVA_TREE2 = createConfiguredFeature("zelkova_tree2",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZELKOVA_TREE3 = createConfiguredFeature("zelkova_tree3",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> ZELKOVA_BROWN_TREE1 = createConfiguredFeature("brown_zelkova_tree1",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZELKOVA_BROWN_TREE2 = createConfiguredFeature("brown_zelkova_tree2",
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZELKOVA_BROWN_TREE3 = createConfiguredFeature("brown_zelkova_tree3",
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> FIRECRACKER_SHRUBS = createConfiguredFeature("firecracker_shrubs",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FIRECRACKER_BUSH1)), 0.5F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FIRECRACKER_SHRUB)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FIRECRACKER_SHRUB2)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BAYOU_TREES = createConfiguredFeature("bayou_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WILLOW_DEAD_TREE1)), 0.01F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WILLOW_TREE1)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WILLOW_TREE2)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WILLOW_TREE3)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WILLOW_TREE4)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CANADIAN_SHIELD_TREES = createConfiguredFeature("canadian_shield_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PINE_TREE1)), 0.05F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PINE_TREE2)), 0.05F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BLUFF_TREE1)), 0.3F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BLUFF_TREE2)), 0.3F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CONIFER_TREE6)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BOREAL_TREES = createConfiguredFeature("boreal_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_YELLOW_BOREAL_TREE1)), 0.3F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_BOREAL_TREE1)), 0.3F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BLUFF_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACK_FOREST_TREES = createConfiguredFeature("black_forest_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ASPEN_TREE3)), 0.05F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ASPEN_TREE2)), 0.05F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CONIFER_TREE6)), 0.05F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CONIFER_TREE7)), 0.05F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PINE_LARGE_TREE1)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PINE_LARGE_TREE2)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PINE_TREE1)), 0.2F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PINE_TREE2)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CIKA_TREES = createConfiguredFeature("cika_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CIKA_TREE2)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CIKA_TREE3)), 0.1F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CIKA_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CONIFER_TREES = createConfiguredFeature("conifer_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CONIFER_TREE1)), 0.06F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CONIFER_TREE2)), 0.5F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CONIFER_TREE3)), 0.04F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CONIFER_TREE4)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CONIFER_TREE5)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CONIFER_TREE6)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CONIFER_TREE7)), 0.1F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CONIFER_TREE8)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_TREES = createConfiguredFeature("cypress_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CYPRESS_TREE1)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CYPRESS_TREE2)), 0.33F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CYPRESS_TREE3)));
            }
    );

    //TODO: Add back deciduous trees
    public static final ResourceKey<ConfiguredFeature<?, ?>> DECIDUOUS_TREES = createConfiguredFeature("deciduous_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE1)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE2)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE3)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE_LARGE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DACITE_RIDGE_TREES = createConfiguredFeature("dacite_ridge_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE_MEDIUM2)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE_MEDIUM1)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE_LARGE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA_TREES = createConfiguredFeature("jacaranda_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(JACARANDA_TREE1)), 0.125F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(JACARANDA_TREE2)), 0.125F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(JACARANDA_TREE3)), 0.125F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(JACARANDA_TREE4)), 0.125F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(INDIGO_JACARANDA_TREE1)), 0.125F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(INDIGO_JACARANDA_TREE2)), 0.125F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(INDIGO_JACARANDA_TREE3)), 0.125F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(INDIGO_JACARANDA_TREE4)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_TREES = createConfiguredFeature("maple_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAPLE_TREE5)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAPLE_TREE4)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAPLE_TREE3)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAPLE_TREE2)), 0.2F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAPLE_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_TREES = createConfiguredFeature("red_maple_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_MAPLE_TREE5)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_MAPLE_TREE4)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_MAPLE_TREE3)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_MAPLE_TREE2)), 0.2F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_MAPLE_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_MAPLE_TREES = createConfiguredFeature("silver_maple_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SILVER_MAPLE_TREE5)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SILVER_MAPLE_TREE4)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SILVER_MAPLE_TREE3)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SILVER_MAPLE_TREE2)), 0.2F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SILVER_MAPLE_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_TAIGA_TREES = createConfiguredFeature("maple_taiga_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SILVER_MAPLE_TREES)), 0.1F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_MAPLE_TREES)), 0.35F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAPLE_TREES)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> NORTHERN_FOREST_TREES = createConfiguredFeature("northern_forest_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PINE_TREE1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PINE_TREE2)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_TREES = createConfiguredFeature("redwood_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(REDWOOD_TREE1)), 0.55F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(REDWOOD_TREE2)), 0.1F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(REDWOOD_TREE3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREES = createConfiguredFeature("spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE3)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE4)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE_MEDIUM1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE_MEDIUM2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE_MEDIUM3)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE_MEDIUM4)), 0.111F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_SPRUCE_TREES = createConfiguredFeature("orange_spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_ORANGE_TREE1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_ORANGE_TREE2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_ORANGE_TREE3)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_ORANGE_TREE4)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_ORANGE_TREE_MEDIUM1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_ORANGE_TREE_MEDIUM2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_ORANGE_TREE_MEDIUM3)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_ORANGE_TREE_MEDIUM4)), 0.111F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_ORANGE_TREE_LARGE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_SPRUCE_TREES = createConfiguredFeature("yellow_spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_YELLOW_TREE1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_YELLOW_TREE2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_YELLOW_TREE3)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_YELLOW_TREE4)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_YELLOW_TREE_MEDIUM1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_YELLOW_TREE_MEDIUM2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_YELLOW_TREE_MEDIUM3)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_YELLOW_TREE_MEDIUM4)), 0.111F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_YELLOW_TREE_LARGE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SPRUCE_TREES = createConfiguredFeature("red_spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE3)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE4)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE_MEDIUM1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE_MEDIUM2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE_MEDIUM3)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE_MEDIUM4)), 0.111F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE1)));
            }
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> AUTUMNAL_SPRUCE_TREES = createConfiguredFeature("autumnal_spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_SPRUCE_TREES)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ORANGE_SPRUCE_TREES)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(YELLOW_SPRUCE_TREES)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_TREES)));
            }
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_SPRUCE_TREES = createConfiguredFeature("blue_spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE3)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE4)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE_MEDIUM1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE_MEDIUM2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE_MEDIUM3)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE_MEDIUM4)), 0.111F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSE_FIELD_SPRUCE_TREES = createConfiguredFeature("rose_field_spruce_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE3)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_BLUE_TREE4)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE1)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE2)), 0.111F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE3)), 0.111F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SPRUCE_RED_TREE4)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAHOGANY_TREES = createConfiguredFeature("mahogany_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAHOGANY_TREE1)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAHOGANY_TREE2)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAHOGANY_TREE3)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAHOGANY_TREE4)));
            }
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> RAINFOREST_TREES = createConfiguredFeature("rainforest_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TROPICAL_SHRUB1)), 0.35F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAHOGANY_TREES)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> GUIANA_SHIELD_TREES = createConfiguredFeature("guiana_shield_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RAINBOW_EUCALYPTUS_LARGE_TREE1)), 0.1F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RAINBOW_EUCALYPTUS_TREE1)), 0.1F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TROPICAL_SHRUB1)), 0.1F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MAHOGANY_TREES)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RAINBOW_EUCALYPTUS_TREES = createConfiguredFeature("rainbow_eucalyptus_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RAINBOW_EUCALYPTUS_LARGE_TREE1)), 0.333F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RAINBOW_EUCALYPTUS_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SKYRIS_TREES = createConfiguredFeature("skyris_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SKYRIS_TREE1)), 0.1667F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SKYRIS_TREE2)), 0.1667F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SKYRIS_TREE3)), 0.1667F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SKYRIS_TREE4)), 0.1667F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SKYRIS_TREE5)), 0.1667F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SKYRIS_TREE6)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BAOBAB_TREES = createConfiguredFeature("baobab_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BAOBAB_TREE1)), 0.35F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BAOBAB_TREE2)), 0.35F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BAOBAB_TREE3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ARAUCARIA_TREES = createConfiguredFeature("araucaria_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ARAUCARIA_TREE1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ARAUCARIA_TREE2)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_TREES = createConfiguredFeature("birch_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_TREE1)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_TREE2)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_TREE3)), 0.33F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_TREE4)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_BIRCH_TREES = createConfiguredFeature("orange_birch_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_ORANGE_TREE1)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_ORANGE_TREE2)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_ORANGE_TREE3)), 0.33F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_ORANGE_TREE4)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_BIRCH_TREES = createConfiguredFeature("yellow_birch_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_YELLOW_TREE1)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_YELLOW_TREE2)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_YELLOW_TREE3)), 0.33F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_YELLOW_TREE4)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_ZELKOVA_TREES = createConfiguredFeature("brown_zelkova_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ZELKOVA_BROWN_TREE1)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ZELKOVA_BROWN_TREE2)), 0.33F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ZELKOVA_BROWN_TREE3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_BUSHES = createConfiguredFeature("oak_bushes",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_BUSH1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_BUSH1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MEADOW_SHRUBS = createConfiguredFeature("meadow_shrubs",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SHRUB_MEADOW)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SHRUB_MEADOW2)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MEADOW_TREES = createConfiguredFeature("meadow_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MEADOW_TREE1)), 0.3F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MEADOW_TREE2)), 0.3F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MEADOW_TREE3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> TEMPERATE_GROVE_TREES = createConfiguredFeature("temperate_grove_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_YELLOW_BOREAL_TREE1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BIRCH_BOREAL_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_TREES = createConfiguredFeature("enchanted_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BLUE_ENCHANTED_TREE4)), 0.05F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BLUE_ENCHANTED_TREE3)), 0.05F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BLUE_ENCHANTED_TREE2)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GREEN_ENCHANTED_TREE4)), 0.05F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GREEN_ENCHANTED_TREE3)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GREEN_ENCHANTED_TREE2)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GREEN_ENCHANTED_TREE1)), 0.1F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BLUE_ENCHANTED_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREES = createConfiguredFeature("aspen_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ASPEN_TREE5)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ASPEN_TREE4)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ASPEN_TREE3)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ASPEN_TREE2)), 0.2F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ASPEN_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_SHRUBS = createConfiguredFeature("aspen_shrubs",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ASPEN_SHRUB1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ASPEN_SHRUB2)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ZELKOVA_TREES = createConfiguredFeature("zelkova_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ZELKOVA_TREE1)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ZELKOVA_TREE2)), 0.33F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ZELKOVA_TREE3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PALO_VERDE_TREES = createConfiguredFeature("palo_verde_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PALO_VERDE_TREE1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PALO_VERDE_TREE2)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> JOSHUA_TREES = createConfiguredFeature("joshua_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(JOSHUA_TREE1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(JOSHUA_TREE2)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PRAIRIE_SHRUBS = createConfiguredFeature("prairie_shrubs", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SHRUB_PRAIRIE1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SHRUB_PRAIRIE2)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_TREES = createConfiguredFeature("palm_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PALM_TREE1)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PALM_TREE2)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PALM_TREE3)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PALM_TREE4)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_TREES = createConfiguredFeature("cherry_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SAKURA_CHERRY_TREE1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SAKURA_CHERRY_TREE2)));
            }
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> WITCH_HAZEL_TREES = createConfiguredFeature("witch_hazel_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WITCH_HAZEL1)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WITCH_HAZEL2)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WITCH_HAZEL3)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WITCH_HAZEL4)), 0.2F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WITCH_HAZEL5)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_TREES = createConfiguredFeature("ebony_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(EBONY_TREE1)), 0.45F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(EBONY_TREE2)), 0.45F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(EBONY_BUSH1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FRAGMENT_FOREST_TREES = createConfiguredFeature("stone_forest_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TreeFeatures.JUNGLE_BUSH)), 0.1F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(EBONY_TREES)), 0.45F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(DECIDUOUS_TREES)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLLY_TREES = createConfiguredFeature("holly_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(HOLLY_TREE1)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(HOLLY_TREE2)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(HOLLY_TREE3)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(HOLLY_TREE4)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGROVE_TREES = createConfiguredFeature("white_mangrove_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WHITE_MANGROVE_TREE1)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WHITE_MANGROVE_TREE2)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WHITE_MANGROVE_TREE3)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WHITE_MANGROVE_TREE4)), 0.2F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WHITE_MANGROVE_TREE5)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORCHARD_TREES = createConfiguredFeature("orchard_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ORCHARD_TREE1)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ORCHARD_TREE2)), 0.33F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ORCHARD_TREE3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> TEMPERATE_RAINFOREST_TREES = createConfiguredFeature("temperate_rainforest_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WOODLANDS_TREE1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WOODLANDS_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_TREES = createConfiguredFeature("oak_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE1)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE2)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE3)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE_LARGE1)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE_LARGE2)), 0.16F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE_LARGE3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_TREES_SWAMP = createConfiguredFeature("oak_trees_swamp",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE1)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE2)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE3)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE_LARGE1)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE_LARGE2)), 0.16F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREE_LARGE3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_OAK_TREES = createConfiguredFeature("orange_oak_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ORANGE_OAK_TREE1)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ORANGE_OAK_TREE2)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ORANGE_OAK_TREE3)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ORANGE_OAK_TREE_LARGE1)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ORANGE_OAK_TREE_LARGE2)), 0.16F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ORANGE_OAK_TREE_LARGE3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_OAK_TREES = createConfiguredFeature("brown_oak_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BROWN_OAK_TREE1)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BROWN_OAK_TREE2)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BROWN_OAK_TREE3)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BROWN_OAK_TREE_LARGE1)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BROWN_OAK_TREE_LARGE2)), 0.16F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BROWN_OAK_TREE_LARGE3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_OAK_TREES = createConfiguredFeature("red_oak_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_OAK_TREE1)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_OAK_TREE2)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_OAK_TREE3)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_OAK_TREE_LARGE1)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_OAK_TREE_LARGE2)), 0.16F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_OAK_TREE_LARGE3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> AUTUMNAL_OAK_TREES = createConfiguredFeature("autumnal_oak_trees", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_OAK_TREES)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BROWN_OAK_TREES)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ORANGE_OAK_TREES)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(OAK_TREES)));
            }
    );

    public static void loadClass() {
    }
}
