package potionstudios.byg.common.world.feature.features.end;

import com.google.common.collect.ImmutableList;
import corgitaco.corgilib.world.level.feature.CorgiLibFeatures;
import corgitaco.corgilib.world.level.feature.gen.configurations.TreeFromStructureNBTConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
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
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.config.HangingColumnWithBaseConfig;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;

import java.util.Set;

import static potionstudios.byg.common.block.BYGWoodTypes.BULBIS;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;

public class BYGEndVegetationFeatures {

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> IVIS_ROOTS = createPatchConfiguredFeatureWithBlock("ivis_roots", BYGBlocks.IVIS_ROOTS, 32);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> IVIS_SPROUT = createPatchConfiguredFeatureWithBlock("ivis_sprout", BYGBlocks.IVIS_SPROUT, 32);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BULBIS_SPROUTS = createPatchConfiguredFeatureWithBlock("bulbis_sprouts", BYGBlocks.BULBIS_SPROUTS, 32);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CRYPTIC_BRAMBLE_PATCH = createPatchConfiguredFeatureWithBlock("cryptic_bramble_patch", BYGBlocks.CRYPTIC_BRAMBLE, 32);

    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> CRYPTIC_BRAMBLE = createConfiguredFeature("cryptic_bramble",
            () -> Feature.SIMPLE_BLOCK, () -> new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_BRAMBLE.get()))
    );

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BULBIS_ODDITY = createPatchConfiguredFeatureWithBlock("bulbis_oddity", BULBIS.growerItem(), 32);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PURPLE_BULBIS_ODDITY = createPatchConfiguredFeatureWithBlock("purple_bulbis_oddity", BYGBlocks.PURPLE_BULBIS_ODDITY, 32);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BULBIS_ANOMALY = createPatchConfiguredFeatureWithBlock("bulbis_anomaly", BYGBlocks.BULBIS_ANOMALY, 48);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PURPLE_BULBIS_ANOMALY = createPatchConfiguredFeatureWithBlock("purple_bulbis_anomaly", BYGBlocks.PURPLE_BULBIS_ANOMALY, 48);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NIGHTSHADE_SPROUTS = createPatchConfiguredFeatureWithBlock("nightshade_sprouts", BYGBlocks.NIGHTSHADE_SPROUTS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NIGHTSHADE_ROOTS = createPatchConfiguredFeatureWithBlock("nightshade_roots", BYGBlocks.NIGHTSHADE_ROOTS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NIGHTSHADE_BERRY_BUSH = createPatchConfiguredFeatureWithBlock("nightshade_berry_bush", BYGBlocks.NIGHTSHADE_BERRY_BUSH, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> IMPARIUS_MUSHROOM = createPatchConfiguredFeatureWithBlock("imparius_mushroom", BYGWoodTypes.IMPARIUS.growerItem(), 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FUNGAL_IMPARIUS_PATCH = createPatchConfiguredFeatureWithBlock("fungal_imparius_patch", BYGBlocks.FUNGAL_IMPARIUS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> IMPARIUS_BUSH = createPatchConfiguredFeatureWithBlock("imparius_bush", BYGBlocks.IMPARIUS_BUSH, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SHULKREN_FUNGUS = createPatchConfiguredFeatureWithBlock("shulkren_fungus", BYGBlocks.SHULKREN_FUNGUS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SHULKREN_MOSS = createPatchConfiguredFeatureWithBlock("shulkren_moss", BYGBlocks.SHULKREN_MOSS_BLANKET, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> THEREAL_BELLFLOWER = createFlowerConfiguredFeature("thereal_bellflower", BYGBlocks.THEREAL_BELLFLOWER);

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TALL_ETHER_GRASS = createPatchConfiguredFeatureWithBlock("tall_ether_grass", BYGBlocks.TALL_ETHER_GRASS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ETHER_GRASS = createPatchConfiguredFeatureWithBlock("ether_grass", BYGBlocks.ETHER_GRASS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ETHER_BUSH = createPatchConfiguredFeatureWithBlock("ether_bush", BYGBlocks.ETHER_BUSH, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ETHER_FOLIAGE = createPatchConfiguredFeatureWithBlock("ether_foliage", BYGBlocks.ETHER_FOLIAGE, 32);
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> ETHER_BULB = createSimpleBlockConfiguredFeatureWithBlock("ether_bulb", BYGBlocks.ETHER_BULB);

    public static final Holder<ConfiguredFeature<HangingColumnWithBaseConfig, ?>> HANGING_SHULKREN_VINE = createConfiguredFeature("hanging_shulkren_vine",
            BYGFeatures.HANGING_FEATURE,
            () -> new HangingColumnWithBaseConfig.Builder()
                    .setBaseBlock(Blocks.END_STONE)
                    .setBlock(BYGBlocks.SHULKREN_VINE_PLANT.defaultBlockState())
                    .setEndBlock(BYGBlocks.SHULKREN_VINE.defaultBlockState().setValue(BlockStateProperties.AGE_25, 23))
                    .setMinLength(1)
                    .setMaxLength(8)
                    .setWhitelist(ImmutableList.of(Blocks.END_STONE, BYGBlocks.SHULKREN_PHYLIUM.get()))
                    .build()
    );

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ENDER_LILY = createConfiguredFeature("ender_lily",
            () -> Feature.RANDOM_PATCH,
            () -> new RandomPatchConfiguration(32, 4, 8,
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.ENDER_LILY.get()))
                    ), BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(BlockPos.ZERO.relative(Direction.DOWN), Fluids.WATER))))
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_BUSH1 = createConfiguredFeature("ether_bush1",
            BYGFeatures.ETHER_BUSH1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.ETHER)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_BUSH2 = createConfiguredFeature("ether_bush2",
            BYGFeatures.ETHER_BUSH2,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.ETHER)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE1 = createConfiguredFeature("ether_tree1",
            BYGFeatures.ETHER_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.ETHER)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE2 = createConfiguredFeature("ether_tree2",
            BYGFeatures.ETHER_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.ETHER)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE3 = createConfiguredFeature("ether_tree3",
            BYGFeatures.ETHER_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.ETHER)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE4 = createConfiguredFeature("ether_tree4",
            BYGFeatures.ETHER_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.ETHER)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE5 = createConfiguredFeature("ether_tree5",
            BYGFeatures.ETHER_TREE5,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.ETHER)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE_DEAD1 = createConfiguredFeature("ether_tree_dead1",
            BYGFeatures.DEAD_ETHER_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(BYGWoodTypes.ETHER.wood().get())
                    .setLeavesBlock(Blocks.AIR)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE_DEAD2 = createConfiguredFeature("ether_tree_dead2",
            BYGFeatures.DEAD_ETHER_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(BYGWoodTypes.ETHER.wood().get())
                    .setLeavesBlock(Blocks.AIR)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> ETHER_TREE_DEAD3 = createConfiguredFeature("ether_tree_dead3",
            BYGFeatures.DEAD_ETHER_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(BYGWoodTypes.ETHER.wood().get())
                    .setLeavesBlock(Blocks.AIR)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_SHRUB1 = createConfiguredFeature("nightshade_shrub1",
            BYGFeatures.NIGHTSHADE_BUSH1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                            .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                    )
                    .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                            .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8))
                    )
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_SHRUB2 = createConfiguredFeature("nightshade_shrub2",
            BYGFeatures.NIGHTSHADE_BUSH2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                            .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                    )
                    .setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                            .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8))
                    )
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_TREE1 = createConfiguredFeature("nightshade_tree1",
            BYGFeatures.NIGHTSHADE_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                                    .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                    )
                    .setLeavesBlock(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                                    .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8))
                    )
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_TREE2 = createConfiguredFeature("nightshade_tree2",
            BYGFeatures.NIGHTSHADE_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                                    .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                    )
                    .setLeavesBlock(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                                    .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8))
                    )
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_TREE3 = createConfiguredFeature("nightshade_tree3",
            BYGFeatures.NIGHTSHADE_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                                    .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                    )
                    .setLeavesBlock(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                                    .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8))
                    )
                    .setMaxHeight(30)
                    .setMinHeight(33)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> NIGHTSHADE_TREE4 = createConfiguredFeature("nightshade_tree4",
            BYGFeatures.NIGHTSHADE_TREE4,
            () -> new BYGTreeConfig.Builder()
                    .setTrunkBlock(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGWoodTypes.NIGHTSHADE.log().defaultBlockState(), 9)
                                    .add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))
                    )
                    .setLeavesBlock(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3)
                                    .add(BYGWoodTypes.NIGHTSHADE.leaves().defaultBlockState(), 8))
                    )
                    .setMaxHeight(30)
                    .setMinHeight(44)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> SHULKREN_TREE1 = createConfiguredFeature("shulkren_tree1",
            BYGFeatures.SHULKREN_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> SHULKREN_TREE2 = createConfiguredFeature("shulkren_tree2",
            BYGFeatures.SHULKREN_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM1 = createConfiguredFeature("imparius_mushroom1",
            BYGFeatures.IMPARIUS_MUSHROOM1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.IMPARIUS.log().get())
                    .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM2 = createConfiguredFeature("imparius_mushroom2",
            BYGFeatures.IMPARIUS_MUSHROOM2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.IMPARIUS.log().get())
                    .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM3 = createConfiguredFeature("imparius_mushroom3",
            BYGFeatures.IMPARIUS_MUSHROOM3,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.IMPARIUS.log().get())
                    .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM4 = createConfiguredFeature("imparius_mushroom4",
            BYGFeatures.IMPARIUS_MUSHROOM4,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.IMPARIUS.log().get())
                    .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM5 = createConfiguredFeature("imparius_mushroom5",
            BYGFeatures.IMPARIUS_MUSHROOM5,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.IMPARIUS.log().get())
                    .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> IMPARIUS_MUSHROOM6 = createConfiguredFeature("imparius_mushroom6",
            BYGFeatures.IMPARIUS_MUSHROOM6,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.IMPARIUS.log().get())
                    .setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> FUNGAL_IMPARIUS1 = createConfiguredFeature("fungal_imparius1",
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


    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> FUNGAL_IMPARIUS2 = createConfiguredFeature("fungal_imparius2",
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
    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> FUNGAL_IMPARIUS3 = createConfiguredFeature("fungal_imparius3",
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

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> FUNGAL_IMPARIUS4 = createConfiguredFeature("fungal_imparius4",
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

    public static final Holder<ConfiguredFeature<TreeFromStructureNBTConfig, ?>> FUNGAL_IMPARIUS5 = createConfiguredFeature("fungal_imparius5",
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

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_BUSH1 = createConfiguredFeature("bulbis_bush1",
            BYGFeatures.BULBIS_BUSH1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE1 = createConfiguredFeature("bulbis_tree1",
            BYGFeatures.BULBIS_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE2 = createConfiguredFeature("bulbis_tree2",
            BYGFeatures.BULBIS_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE3 = createConfiguredFeature("bulbis_tree3",
            BYGFeatures.BULBIS_TREE3,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE4 = createConfiguredFeature("bulbis_tree4",
            BYGFeatures.BULBIS_TREE4,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE5 = createConfiguredFeature("bulbis_tree5",
            BYGFeatures.BULBIS_TREE5,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE6 = createConfiguredFeature("bulbis_tree6",
            BYGFeatures.BULBIS_TREE6,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BULBIS_TREE7 = createConfiguredFeature("bulbis_tree7",
            BYGFeatures.BULBIS_TREE7,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_BUSH1 = createConfiguredFeature("purple_bulbis_bush1",
            BYGFeatures.BULBIS_BUSH1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE1 = createConfiguredFeature("purple_bulbis_tree1",
            BYGFeatures.BULBIS_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE2 = createConfiguredFeature("purple_bulbis_tree2",
            BYGFeatures.BULBIS_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE3 = createConfiguredFeature("purple_bulbis_tree3",
            BYGFeatures.BULBIS_TREE3,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE4 = createConfiguredFeature("purple_bulbis_tree4",
            BYGFeatures.BULBIS_TREE4,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE5 = createConfiguredFeature("purple_bulbis_tree5",
            BYGFeatures.BULBIS_TREE5,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE6 = createConfiguredFeature("purple_bulbis_tree6",
            BYGFeatures.BULBIS_TREE6,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> PURPLE_BULBIS_TREE7 = createConfiguredFeature("purple_bulbis_tree7",
            BYGFeatures.BULBIS_TREE7,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BULBIS.wood())
                    .setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BULBIS_TREES = createConfiguredFeature("bulbis_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BULBIS_BUSH1), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BULBIS_TREE1), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BULBIS_TREE2), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BULBIS_TREE3), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BULBIS_TREE4), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BULBIS_TREE5), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BULBIS_TREE6), 0.14285f)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BULBIS_TREE7))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PURPLE_BULBIS_TREES = createConfiguredFeature("purple_bulbis_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PURPLE_BULBIS_BUSH1), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PURPLE_BULBIS_TREE1), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PURPLE_BULBIS_TREE2), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PURPLE_BULBIS_TREE3), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PURPLE_BULBIS_TREE4), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PURPLE_BULBIS_TREE5), 0.14285f),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PURPLE_BULBIS_TREE6), 0.14285f)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PURPLE_BULBIS_TREE7))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> NIGHTSHADE_TREES = createConfiguredFeature("nightshade_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(NIGHTSHADE_TREE1), 0.15F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(NIGHTSHADE_TREE2), 0.3F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(NIGHTSHADE_TREE3), 0.3F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(NIGHTSHADE_TREE4))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SHULKREN_TREES = createConfiguredFeature("shulkren_trees",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SHULKREN_TREE1), 0.5F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SHULKREN_TREE2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> NIGHTSHADE_SHRUBS = createConfiguredFeature("nightshade_shrubs",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(NIGHTSHADE_SHRUB1), 0.5F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(NIGHTSHADE_SHRUB2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> LARGE_IMPARIUS_MUSHROOMS = createConfiguredFeature("large_imparius_mushrooms",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(IMPARIUS_MUSHROOM1), 0.166F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(IMPARIUS_MUSHROOM2), 0.166F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(IMPARIUS_MUSHROOM3), 0.166F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(IMPARIUS_MUSHROOM4), 0.166F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(IMPARIUS_MUSHROOM5), 0.166F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(IMPARIUS_MUSHROOM6))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> FUNGAL_IMPARIUS = createConfiguredFeature("fungal_imparius",
            () -> Feature.RANDOM_SELECTOR,
            () -> new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(FUNGAL_IMPARIUS1), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(FUNGAL_IMPARIUS2), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(FUNGAL_IMPARIUS3), 0.2F),
                    new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(FUNGAL_IMPARIUS4), 0.2F)),
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(FUNGAL_IMPARIUS5))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> IVIS_PLANTS = createConfiguredFeature("ivis_plants", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(IVIS_ROOTS), 0.5F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(IVIS_SPROUT))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BULBIS_ODDITIES = createConfiguredFeature("bulbis_oddities", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BULBIS_ODDITY), 0.5F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PURPLE_BULBIS_ODDITY))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BULBIS_ANOMALIES = createConfiguredFeature("bulbis_anomalies", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BULBIS_ANOMALY), 0.5F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(PURPLE_BULBIS_ANOMALY))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SHULKREN_PLANTS = createConfiguredFeature("shulkren_plants", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SHULKREN_FUNGUS), 0.5F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SHULKREN_MOSS))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> NIGHTSHADE_PLANTS = createConfiguredFeature("nightshade_plants", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(NIGHTSHADE_BERRY_BUSH), 0.2F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(NIGHTSHADE_ROOTS), 0.4F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(NIGHTSHADE_SPROUTS))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ETHER_PLANTS = createConfiguredFeature("ether_plants", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_BUSH), 0.2F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_GRASS), 0.4F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(TALL_ETHER_GRASS))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ETHER_TREES = createConfiguredFeature("ether_trees", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_TREE1), 0.2F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_TREE2), 0.2F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_TREE3), 0.2F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_TREE4), 0.2F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_TREE5))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> DEAD_ETHER_TREES = createConfiguredFeature("dead_ether_trees", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_TREE_DEAD1), 0.33F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_TREE_DEAD2), 0.33F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_TREE_DEAD3))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ETHER_BUSHES = createConfiguredFeature("ether_bushes", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_BUSH1), 0.5F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(ETHER_BUSH2)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> IMPARIUS_PLANTS = createConfiguredFeature("imparius_plants", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(IMPARIUS_BUSH), 0.2F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(FUNGAL_IMPARIUS_PATCH), 0.4F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(IMPARIUS_MUSHROOM))
    );

    public static void loadClass() {
    }
}
