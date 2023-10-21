package potionstudios.byg.common.world.feature.features.end;

import com.google.common.collect.ImmutableList;
import corgitaco.corgilib.world.level.feature.CorgiLibFeatures;
import corgitaco.corgilib.world.level.feature.gen.configurations.TreeFromStructureNBTConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.block.BaobabFruitBlock;
import potionstudios.byg.common.block.end.impariusgrove.ImpariusVineBlock;
import potionstudios.byg.common.world.feature.gen.overworld.trees.decorators.AttachedToLogsDecorator;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static potionstudios.byg.common.block.BYGWoodTypes.*;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;

public class BYGEndVegetationFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> IVIS_ROOTS = createPatchConfiguredFeatureWithBlock("ivis_roots", BYGBlocks.IVIS_ROOTS, 32);

    public static final ResourceKey<ConfiguredFeature<?, ?>> IVIS_SPROUT = createPatchConfiguredFeatureWithBlock("ivis_sprout", BYGBlocks.IVIS_SPROUT, 32);

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_SPROUTS = createPatchConfiguredFeatureWithBlock("bulbis_sprouts", BYGBlocks.BULBIS_SPROUTS, 32);

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTIC_BRAMBLE_PATCH = createPatchConfiguredFeatureWithBlock("cryptic_bramble_patch", BYGBlocks.CRYPTIC_BRAMBLE, 32);

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTIC_BRAMBLE = createConfiguredFeature("cryptic_bramble",
            () -> Feature.SIMPLE_BLOCK, (configuredFeatureBootstapContext) -> new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_BRAMBLE.get()))
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_ODDITY = createPatchConfiguredFeatureWithBlock("bulbis_oddity", BULBIS.growerItem(), 32);

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BULBIS_ODDITY = createPatchConfiguredFeatureWithBlock("purple_bulbis_oddity", BYGBlocks.PURPLE_BULBIS_ODDITY, 32);

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_ANOMALY = createPatchConfiguredFeatureWithBlock("bulbis_anomaly", BYGBlocks.BULBIS_ANOMALY, 48);

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BULBIS_ANOMALY = createPatchConfiguredFeatureWithBlock("purple_bulbis_anomaly", BYGBlocks.PURPLE_BULBIS_ANOMALY, 48);
    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_SPROUTS = createPatchConfiguredFeatureWithBlock("nightshade_sprouts", BYGBlocks.NIGHTSHADE_SPROUTS, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_ROOTS = createPatchConfiguredFeatureWithBlock("nightshade_roots", BYGBlocks.NIGHTSHADE_ROOTS, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_BERRY_BUSH = createPatchConfiguredFeatureWithBlock("nightshade_berry_bush", BYGBlocks.NIGHTSHADE_BERRY_BUSH, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> IMPARIUS_MUSHROOM = createPatchConfiguredFeatureWithBlock("imparius_mushroom", BYGWoodTypes.IMPARIUS.growerItem(), 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> FUNGAL_IMPARIUS_PATCH = createPatchConfiguredFeatureWithBlock("fungal_imparius_patch", BYGBlocks.FUNGAL_IMPARIUS, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> IMPARIUS_BUSH = createPatchConfiguredFeatureWithBlock("imparius_bush", BYGBlocks.IMPARIUS_BUSH, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> THEREAL_BELLFLOWER = createFlowerConfiguredFeature("thereal_bellflower", BYGBlocks.THEREAL_BELLFLOWER);

    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_ETHER_GRASS = createPatchConfiguredFeatureWithBlock("tall_ether_grass", BYGBlocks.TALL_ETHER_GRASS, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_GRASS = createPatchConfiguredFeatureWithBlock("ether_grass", BYGBlocks.ETHER_GRASS, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_BUSH = createPatchConfiguredFeatureWithBlock("ether_bush", BYGBlocks.ETHER_BUSH, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_FOLIAGE = createPatchConfiguredFeatureWithBlock("ether_foliage", BYGBlocks.ETHER_FOLIAGE, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_BULB = createSimpleBlockConfiguredFeatureWithBlock("ether_bulb", BYGBlocks.ETHER_BULB);

    public static final ResourceKey<ConfiguredFeature<?, ?>> ENDER_LILY = createConfiguredFeature("ender_lily",
            () -> Feature.RANDOM_PATCH,
            () -> new RandomPatchConfiguration(32, 4, 8,
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.ENDER_LILY.get()))
                    ), BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(BlockPos.ZERO.relative(Direction.DOWN), Fluids.WATER))))
    );

    public static final Supplier<AttachedToLeavesDecorator> ETHER_BULBS = () -> new AttachedToLeavesDecorator(0.2F, 2, 0, new RandomizedIntStateProvider(BlockStateProvider.simple(BYGBlocks.ETHER_BULB.defaultBlockState()), BaobabFruitBlock.AGE, UniformInt.of(0, 3)), 1, List.of(Direction.DOWN));


    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_BUSH1 = createConfiguredFeature("ether_bush1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/aspen-shrub/aspen_shrub_trunk1"),
                    BYG.createLocation("features/trees/aspen-shrub/aspen_shrub_canopy1"),
                    ConstantInt.of(0),
                    BlockStateProvider.simple(ETHER.log().defaultBlockState()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ETHER.leaves().defaultBlockState(), 1).build()),
                    ASPEN.log(),
                    ASPEN.leaves(),
                    BYGBlockTags.GROUND_ETHER_SAPLING, 1, ImmutableList.of(ETHER_BULBS.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_TREE1 = createConfiguredFeature("ether_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/ether/ether_canopy1"),
                    BiasedToBottomInt.of(5, 10),
                    BlockStateProvider.simple(ETHER.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ETHER.leaves().defaultBlockState(), 1).build()),
                    ETHER.log().get(),
                    ETHER.leaves().get(),
                    BYGBlockTags.GROUND_ETHER_SAPLING, 5, ImmutableList.of(ETHER_BULBS.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_TREE2 = createConfiguredFeature("ether_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/ether/ether_canopy2"),
                    BiasedToBottomInt.of(5, 13),
                    BlockStateProvider.simple(ETHER.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ETHER.leaves().defaultBlockState(), 1).build()),
                    ETHER.log().get(),
                    ETHER.leaves().get(),
                    BYGBlockTags.GROUND_ETHER_SAPLING, 5, ImmutableList.of(ETHER_BULBS.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_TREE3 = createConfiguredFeature("ether_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/ether/ether_canopy3"),
                    BiasedToBottomInt.of(5, 13),
                    BlockStateProvider.simple(ETHER.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ETHER.leaves().defaultBlockState(), 1).build()),
                    ETHER.log().get(),
                    ETHER.leaves().get(),
                    BYGBlockTags.GROUND_ETHER_SAPLING, 5, ImmutableList.of(ETHER_BULBS.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_TREE4 = createConfiguredFeature("ether_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/ether/ether_trunk4"),
                    BYG.createLocation("features/trees/ether/ether_canopy4"),
                    BiasedToBottomInt.of(5, 13),
                    BlockStateProvider.simple(ETHER.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ETHER.leaves().defaultBlockState(), 1).build()),
                    ETHER.log().get(),
                    ETHER.leaves().get(),
                    BYGBlockTags.GROUND_ETHER_SAPLING, 5, ImmutableList.of(ETHER_BULBS.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_TREE5 = createConfiguredFeature("ether_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/ether/ether_trunk4"),
                    BYG.createLocation("features/trees/ether/ether_canopy4"),
                    BiasedToBottomInt.of(5, 13),
                    BlockStateProvider.simple(ETHER.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ETHER.leaves().defaultBlockState(), 1).build()),
                    ETHER.log().get(),
                    ETHER.leaves().get(),
                    BYGBlockTags.GROUND_ETHER_SAPLING, 5, ImmutableList.of(ETHER_BULBS.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_TREE_DEAD1 = createConfiguredFeature("ether_tree_dead1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/ether/ether_canopy1"),
                    BiasedToBottomInt.of(5, 10),
                    BlockStateProvider.simple(ETHER.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ETHER.leaves().defaultBlockState(), 1).build()),
                    ETHER.log().get(),
                    ETHER.leaves().get(),
                    BYGBlockTags.GROUND_ETHER_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_TREE_DEAD2 = createConfiguredFeature("ether_tree_dead2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/ether/ether_canopy2"),
                    BiasedToBottomInt.of(5, 10),
                    BlockStateProvider.simple(ETHER.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(ETHER.leaves().defaultBlockState(), 1).build()),
                    ETHER.log().get(),
                    ETHER.leaves().get(),
                    BYGBlockTags.GROUND_ETHER_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_TREE_DEAD3 = createConfiguredFeature("ether_tree_dead3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/ether/ether_canopy3"),
                    BiasedToBottomInt.of(5, 10),
                    BlockStateProvider.simple(ETHER.log().get()),
                    BlockStateProvider.simple(Blocks.AIR),
                    ETHER.log().get(),
                    ETHER.leaves().get(),
                    BYGBlockTags.GROUND_ETHER_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_SHRUB1 = createConfiguredFeature("nightshade_shrub1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/nightshade/nightshade_shrub_canopy1"),
                    BiasedToBottomInt.of(0, 1),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                            .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1)),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                            .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8).build()),
                    NIGHTSHADE.log().get(),
                    NIGHTSHADE.leaves().get(),
                    BYGBlockTags.GROUND_NIGHTSHADE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_SHRUB2 = createConfiguredFeature("nightshade_shrub2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/nightshade/nightshade_shrub_canopy2"),
                    BiasedToBottomInt.of(0, 1),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                            .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1)),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                            .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8).build()),
                    NIGHTSHADE.log().get(),
                    NIGHTSHADE.leaves().get(),
                    BYGBlockTags.GROUND_NIGHTSHADE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_TREE1 = createConfiguredFeature("nightshade_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/nightshade/nightshade_trunk1"),
                    BYG.createLocation("features/trees/nightshade/nightshade_canopy1"),
                    BiasedToBottomInt.of(3, 5),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                            .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1)),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                            .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8).build()),
                    NIGHTSHADE.log().get(),
                    NIGHTSHADE.leaves().get(),
                    BYGBlockTags.GROUND_NIGHTSHADE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_TREE2 = createConfiguredFeature("nightshade_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/nightshade/nightshade_canopy2"),
                    BiasedToBottomInt.of(2, 4),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                            .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1)),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                            .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8).build()),
                    NIGHTSHADE.log().get(),
                    NIGHTSHADE.leaves().get(),
                    BYGBlockTags.GROUND_NIGHTSHADE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_TREE3 = createConfiguredFeature("nightshade_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/nightshade/nightshade_trunk3"),
                    BYG.createLocation("features/trees/nightshade/nightshade_canopy3"),
                    BiasedToBottomInt.of(2, 4),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                            .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1)),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                            .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8).build()),
                    NIGHTSHADE.log().get(),
                    NIGHTSHADE.leaves().get(),
                    BYGBlockTags.GROUND_NIGHTSHADE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_TREE4 = createConfiguredFeature("nightshade_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/nightshade/nightshade_trunk4"),
                    BYG.createLocation("features/trees/nightshade/nightshade_canopy4"),
                    BiasedToBottomInt.of(2, 4),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                            .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1)),
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                            .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8).build()),
                    NIGHTSHADE.log().get(),
                    NIGHTSHADE.leaves().get(),
                    BYGBlockTags.GROUND_NIGHTSHADE_SAPLING, 5, ImmutableList.of()
            )
    );

    public static final Supplier<AttachedToLeavesDecorator> PURPLE_SHROOMLIGHT = () -> new AttachedToLeavesDecorator(0.13F, 2, 0, new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PURPLE_SHROOMLIGHT.defaultBlockState(), 1).build()), 2, List.of(Direction.DOWN, Direction.UP));




    public static final Supplier<AttachedToLogsDecorator> IMPARIUS_MUSHROOM_BRANCH = () -> new AttachedToLogsDecorator(0.43F, 0, 1, SimpleStateProvider.simple(BYGBlocks.IMPARIUS_MUSHROOM_BRANCH.defaultBlockState()), 2, List.of(Direction.WEST, Direction.NORTH, Direction.SOUTH, Direction.EAST));
    public static final Supplier<AttachedToLeavesDecorator> IMPARIUS_VINE_PLANT = () -> new AttachedToLeavesDecorator(0.15F, 2, 0, new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMPARIUS_VINE_PLANT.defaultBlockState(), 1).build()), 2, List.of(Direction.DOWN));
    public static final Supplier<AttachedToLeavesDecorator> IMPARIUS_VINE = () -> new AttachedToLeavesDecorator(0.15F, 2, 0, new RandomizedIntStateProvider(BlockStateProvider.simple(BYGBlocks.IMPARIUS_VINE.defaultBlockState()), ImpariusVineBlock.AGE, UniformInt.of(0, 3)), 2, List.of(Direction.DOWN));

    public static final ResourceKey<ConfiguredFeature<?, ?>> IMPARIUS_MUSHROOM1 = createConfiguredFeature("imparius_mushroom1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_trunk1"),
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_canopy1"),
                    BiasedToBottomInt.of(3, 4),
                    BlockStateProvider.simple(IMPARIUS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.defaultBlockState(), 1).build()),
                    IMPARIUS.log().get(),
                    BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get(),
                    BYGBlockTags.GROUND_IMPARIUS_MUSHROOM, 5, ImmutableList.of(IMPARIUS_MUSHROOM_BRANCH.get(), IMPARIUS_VINE_PLANT.get(), IMPARIUS_VINE.get())
            )
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> IMPARIUS_MUSHROOM2 = createConfiguredFeature("imparius_mushroom2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_trunk2"),
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_canopy2"),
                    BiasedToBottomInt.of(7, 11),
                    BlockStateProvider.simple(IMPARIUS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.defaultBlockState(), 1).build()),
                    IMPARIUS.log().get(),
                    BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get(),
                    BYGBlockTags.GROUND_IMPARIUS_MUSHROOM, 5, ImmutableList.of(IMPARIUS_MUSHROOM_BRANCH.get(), IMPARIUS_VINE_PLANT.get(), IMPARIUS_VINE.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> IMPARIUS_MUSHROOM3 = createConfiguredFeature("imparius_mushroom3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_trunk3"),
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_canopy3"),
                    BiasedToBottomInt.of(10, 15),
                    BlockStateProvider.simple(IMPARIUS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.defaultBlockState(), 1).build()),
                    IMPARIUS.log().get(),
                    BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get(),
                    BYGBlockTags.GROUND_IMPARIUS_MUSHROOM, 5, ImmutableList.of(IMPARIUS_MUSHROOM_BRANCH.get(), IMPARIUS_VINE_PLANT.get(), IMPARIUS_VINE.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> IMPARIUS_MUSHROOM4 = createConfiguredFeature("imparius_mushroom4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_trunk4"),
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_canopy4"),
                    BiasedToBottomInt.of(10, 15),
                    BlockStateProvider.simple(IMPARIUS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.defaultBlockState(), 1).build()),
                    IMPARIUS.log().get(),
                    BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get(),
                    BYGBlockTags.GROUND_IMPARIUS_MUSHROOM, 5, ImmutableList.of(IMPARIUS_MUSHROOM_BRANCH.get(), IMPARIUS_VINE_PLANT.get(), IMPARIUS_VINE.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> IMPARIUS_MUSHROOM5 = createConfiguredFeature("imparius_mushroom5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_trunk5"),
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_canopy5"),
                    BiasedToBottomInt.of(10, 15),
                    BlockStateProvider.simple(IMPARIUS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.defaultBlockState(), 1).build()),
                    IMPARIUS.log().get(),
                    BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get(),
                    BYGBlockTags.GROUND_IMPARIUS_MUSHROOM, 5, ImmutableList.of(IMPARIUS_MUSHROOM_BRANCH.get(), IMPARIUS_VINE_PLANT.get(), IMPARIUS_VINE.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> IMPARIUS_MUSHROOM6 = createConfiguredFeature("imparius_mushroom6",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_trunk6"),
                    BYG.createLocation("features/mushrooms/imparius/imparius_mushroom_canopy6"),
                    BiasedToBottomInt.of(10, 15),
                    BlockStateProvider.simple(IMPARIUS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.defaultBlockState(), 1).build()),
                    IMPARIUS.log().get(),
                    BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get(),
                    BYGBlockTags.GROUND_IMPARIUS_MUSHROOM, 5, ImmutableList.of(IMPARIUS_MUSHROOM_BRANCH.get(), IMPARIUS_VINE_PLANT.get(), IMPARIUS_VINE.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FUNGAL_IMPARIUS1 = createConfiguredFeature("fungal_imparius1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/fungi/imparius/imparius_trunk1"),
                    BYG.createLocation("features/fungi/imparius/imparius_canopy1"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(BYGBlocks.FUNGAL_IMPARIUS_STEM.get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FUNGAL_IMPARIUS_BLOCK.defaultBlockState(), 1).build()),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_STEM.get()),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_BLOCK.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_FUNGAL_IMPARIUS),
                    BlockPredicate.replaceable(),
                    5,
                    ImmutableList.of(),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_FILAMENT_BLOCK.get(), BYGBlocks.FUNGAL_IMPARIUS.get())
            )
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> FUNGAL_IMPARIUS2 = createConfiguredFeature("fungal_imparius2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/fungi/imparius/imparius_trunk2"),
                    BYG.createLocation("features/fungi/imparius/imparius_canopy2"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(BYGBlocks.FUNGAL_IMPARIUS_STEM.get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FUNGAL_IMPARIUS_BLOCK.defaultBlockState(), 1).build()),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_STEM.get()),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_BLOCK.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_FUNGAL_IMPARIUS),
                    BlockPredicate.replaceable(),
                    5,
                    ImmutableList.of(),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_FILAMENT_BLOCK.get(), BYGBlocks.FUNGAL_IMPARIUS.get())
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> FUNGAL_IMPARIUS3 = createConfiguredFeature("fungal_imparius3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/fungi/imparius/imparius_trunk3"),
                    BYG.createLocation("features/fungi/imparius/imparius_canopy3"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(BYGBlocks.FUNGAL_IMPARIUS_STEM.get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FUNGAL_IMPARIUS_BLOCK.defaultBlockState(), 1).build()),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_STEM.get()),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_BLOCK.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_FUNGAL_IMPARIUS),
                    BlockPredicate.replaceable(),
                    5,
                    ImmutableList.of(),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_FILAMENT_BLOCK.get(), BYGBlocks.FUNGAL_IMPARIUS.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FUNGAL_IMPARIUS4 = createConfiguredFeature("fungal_imparius4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/fungi/imparius/imparius_trunk4"),
                    BYG.createLocation("features/fungi/imparius/imparius_canopy4"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(BYGBlocks.FUNGAL_IMPARIUS_STEM.get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FUNGAL_IMPARIUS_BLOCK.defaultBlockState(), 1).build()),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_STEM.get()),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_BLOCK.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_FUNGAL_IMPARIUS),
                    BlockPredicate.replaceable(),
                    5,
                    ImmutableList.of(),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_FILAMENT_BLOCK.get(), BYGBlocks.FUNGAL_IMPARIUS.get())
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FUNGAL_IMPARIUS5 = createConfiguredFeature("fungal_imparius5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/fungi/imparius/imparius_trunk5"),
                    BYG.createLocation("features/fungi/imparius/imparius_canopy5"),
                    BiasedToBottomInt.of(4, 6),
                    BlockStateProvider.simple(BYGBlocks.FUNGAL_IMPARIUS_STEM.get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.FUNGAL_IMPARIUS_BLOCK.defaultBlockState(), 1).build()),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_STEM.get()),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_BLOCK.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_FUNGAL_IMPARIUS),
                    BlockPredicate.replaceable(),
                    5,
                    ImmutableList.of(),
                    Set.of(BYGBlocks.FUNGAL_IMPARIUS_FILAMENT_BLOCK.get(), BYGBlocks.FUNGAL_IMPARIUS.get())
            )
    );


    public static final Supplier<AttachedToLeavesDecorator> PURPLE_SHROOMLIGHT_DOWN = () -> new AttachedToLeavesDecorator(0.2F, 2, 0, new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PURPLE_SHROOMLIGHT.defaultBlockState(), 1).build()), 2, List.of(Direction.DOWN));

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_BUSH1 = createConfiguredFeature("bulbis_bush1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/bulbis/bulbis_bush_canopy1"),
                    BiasedToBottomInt.of(0, 2),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BULBIS_SHELL.get().defaultBlockState(), 8).add(BYGBlocks.PURPLE_SHROOMLIGHT.defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_TREE1 = createConfiguredFeature("bulbis_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk1"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy1"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_TREE2 = createConfiguredFeature("bulbis_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk2"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy2"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_TREE3 = createConfiguredFeature("bulbis_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk2"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy3"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_TREE4 = createConfiguredFeature("bulbis_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk4"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy4"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_TREE5 = createConfiguredFeature("bulbis_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk5"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy5"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_TREE6 = createConfiguredFeature("bulbis_tree6",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk6"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy6"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_TREE7 = createConfiguredFeature("bulbis_tree7",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk7"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy7"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BULBIS_BUSH1 = createConfiguredFeature("purple_bulbis_bush1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/generic_trunk"),
                    BYG.createLocation("features/trees/bulbis/bulbis_bush_canopy1"),
                    BiasedToBottomInt.of(0, 2),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PURPLE_BULBIS_SHELL.get().defaultBlockState(), 8).add(BYGBlocks.PURPLE_SHROOMLIGHT.defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_PURPLE_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BULBIS_TREE1 = createConfiguredFeature("purple_bulbis_tree1",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk1"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy1"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PURPLE_BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_PURPLE_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BULBIS_TREE2 = createConfiguredFeature("purple_bulbis_tree2",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk2"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy2"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PURPLE_BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_PURPLE_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BULBIS_TREE3 = createConfiguredFeature("purple_bulbis_tree3",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk2"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy3"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PURPLE_BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_PURPLE_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BULBIS_TREE4 = createConfiguredFeature("purple_bulbis_tree4",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk4"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy4"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PURPLE_BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_PURPLE_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BULBIS_TREE5 = createConfiguredFeature("purple_bulbis_tree5",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk5"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy5"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PURPLE_BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_PURPLE_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BULBIS_TREE6 = createConfiguredFeature("purple_bulbis_tree6",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk6"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy6"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PURPLE_BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_PURPLE_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BULBIS_TREE7 = createConfiguredFeature("purple_bulbis_tree7",
            CorgiLibFeatures.TREE_FROM_NBT,
            () -> new TreeFromStructureNBTConfig(
                    BYG.createLocation("features/trees/bulbis/bulbis_trunk7"),
                    BYG.createLocation("features/trees/bulbis/bulbis_canopy7"),
                    BiasedToBottomInt.of(8, 15),
                    BlockStateProvider.simple(BULBIS.log().get()),
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.PURPLE_BULBIS_SHELL.get().defaultBlockState(), 1).build()),
                    Set.of(BULBIS.log().get(), BULBIS.wood().get()),
                    Set.of(BYGBlocks.BULBIS_SHELL.get()),
                    BlockPredicate.matchesTag(BYGBlockTags.GROUND_PURPLE_BULBIS_ODDITY), BlockPredicate.replaceable(), 5, ImmutableList.of(PURPLE_SHROOMLIGHT_DOWN.get()), Set.of()
            )
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_TREES = createConfiguredFeature("bulbis_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BULBIS_BUSH1)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BULBIS_TREE1)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BULBIS_TREE2)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BULBIS_TREE3)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BULBIS_TREE4)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BULBIS_TREE5)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BULBIS_TREE6)), 0.14285f)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BULBIS_TREE7)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_BULBIS_TREES = createConfiguredFeature("purple_bulbis_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PURPLE_BULBIS_BUSH1)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PURPLE_BULBIS_TREE1)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PURPLE_BULBIS_TREE2)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PURPLE_BULBIS_TREE3)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PURPLE_BULBIS_TREE4)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PURPLE_BULBIS_TREE5)), 0.14285f),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PURPLE_BULBIS_TREE6)), 0.14285f)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PURPLE_BULBIS_TREE7)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MIXED_COLOR_BULBIS_TREES = createConfiguredFeature("mixed_color_bulbis_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PURPLE_BULBIS_TREES)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BULBIS_TREES)));
            }
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_TREES = createConfiguredFeature("nightshade_trees",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(NIGHTSHADE_TREE1)), 0.15F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(NIGHTSHADE_TREE2)), 0.3F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(NIGHTSHADE_TREE3)), 0.3F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(NIGHTSHADE_TREE4)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_SHRUBS = createConfiguredFeature("nightshade_shrubs",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(NIGHTSHADE_SHRUB1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(NIGHTSHADE_SHRUB2)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_IMPARIUS_MUSHROOMS = createConfiguredFeature("large_imparius_mushrooms",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(IMPARIUS_MUSHROOM1)), 0.166F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(IMPARIUS_MUSHROOM2)), 0.166F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(IMPARIUS_MUSHROOM3)), 0.166F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(IMPARIUS_MUSHROOM4)), 0.166F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(IMPARIUS_MUSHROOM5)), 0.166F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(IMPARIUS_MUSHROOM6)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FUNGAL_IMPARIUS = createConfiguredFeature("fungal_imparius",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(

                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FUNGAL_IMPARIUS1)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FUNGAL_IMPARIUS2)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FUNGAL_IMPARIUS3)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FUNGAL_IMPARIUS4)), 0.2F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FUNGAL_IMPARIUS5)));
            }
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> IVIS_PLANTS = createConfiguredFeature("ivis_plants", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(IVIS_ROOTS)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(IVIS_SPROUT)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_ODDITIES = createConfiguredFeature("bulbis_oddities", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BULBIS_ODDITY)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PURPLE_BULBIS_ODDITY)));

            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BULBIS_ANOMALIES = createConfiguredFeature("bulbis_anomalies", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BULBIS_ANOMALY)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PURPLE_BULBIS_ANOMALY)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> NIGHTSHADE_PLANTS = createConfiguredFeature("nightshade_plants", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(NIGHTSHADE_BERRY_BUSH)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(NIGHTSHADE_ROOTS)), 0.4F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(NIGHTSHADE_SPROUTS)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_PLANTS = createConfiguredFeature("ether_plants", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ETHER_BUSH)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ETHER_GRASS)), 0.4F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TALL_ETHER_GRASS)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ETHER_TREES = createConfiguredFeature("ether_trees", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ETHER_TREE1)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ETHER_TREE2)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ETHER_TREE3)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ETHER_TREE4)), 0.2F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ETHER_TREE5)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_ETHER_TREES = createConfiguredFeature("dead_ether_trees", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ETHER_TREE_DEAD1)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ETHER_TREE_DEAD2)), 0.33F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ETHER_TREE_DEAD3)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> IMPARIUS_PLANTS = createConfiguredFeature("imparius_plants", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(IMPARIUS_BUSH)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FUNGAL_IMPARIUS_PATCH)), 0.4F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(IMPARIUS_MUSHROOM)));
            }
    );

    public static void loadClass() {
    }
}
