package potionstudios.byg.common.world.feature.features.end;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.*;
import potionstudios.byg.common.world.feature.features.overworld.BYGOverworldFeatures;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;
import potionstudios.byg.common.world.feature.stateproviders.BetweenNoiseThresholdProvider;

import java.util.List;
import java.util.function.Supplier;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;

public class BYGEndFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> IMPARIUS_GROVE_DELTA = createConfiguredFeature("imparius_grove_delta", () -> Feature.DELTA_FEATURE, () -> new DeltaFeatureConfiguration(Blocks.WATER.defaultBlockState(), BYGBlocks.IMPARIUS_PHYLIUM.defaultBlockState(), UniformInt.of(7, 15), ConstantInt.of(1)));

    public static final Supplier<BlockPredicate> CRYPTIC_STONE_UNDER = () -> BlockPredicate.matchesBlocks(BlockPos.ZERO.relative(Direction.DOWN), BYGBlocks.CRYPTIC_STONE.get());

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTIC_FIRE_PATCH = createConfiguredFeature("cryptic_fire_patch", () -> Feature.RANDOM_PATCH, () ->
            new RandomPatchConfiguration(24, 4, 7,
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_FIRE.get()))),
                            createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER.get()))
            ));

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTIC_FIRE = createConfiguredFeature("cryptic_fire",
            () -> Feature.SIMPLE_BLOCK,
            () -> new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_FIRE.get()))
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTIC_VENT_PATCH = createConfiguredFeature("cryptic_vent_patch", () -> Feature.RANDOM_PATCH, () ->
            new RandomPatchConfiguration(24, 4, 7,
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_VENT.get()))), createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER.get()))
            ));

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTIC_VENT = createConfiguredFeature("cryptic_vent",
            () -> Feature.SIMPLE_BLOCK,
            () -> new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_VENT.get()))
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_CRYPTIC_VENT_PATCH = createConfiguredFeature("tall_cryptic_vent_patch",
            () -> Feature.RANDOM_PATCH,
            () -> new RandomPatchConfiguration(24, 4, 7,
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.TALL_CRYPTIC_VENT.get()))), createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER.get()))
            ));

    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_CRYPTIC_VENT = createConfiguredFeature("tall_cryptic_vent",
            () -> Feature.SIMPLE_BLOCK,
            () -> new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.TALL_CRYPTIC_VENT.get()))
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CRYPTIC_REDSTONE = createConfiguredFeature("cryptic_redstone",
            () -> Feature.ORE,
            () -> new OreConfiguration(
                    List.of(
                            OreConfiguration.target(new BlockMatchTest(BYGBlocks.CRYPTIC_STONE.get()), BYGBlocks.CRYPTIC_REDSTONE_ORE.defaultBlockState())
                    ), 8)
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTIC_VENT_PATCHES = createConfiguredFeature("cryptic_vents_patch", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CRYPTIC_VENT_PATCH)), 0.50F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TALL_CRYPTIC_VENT_PATCH)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTIC_VENTS = createConfiguredFeature("cryptic_vents", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CRYPTIC_VENT)), 0.50F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TALL_CRYPTIC_VENT)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTIC_CAVES = createConfiguredFeature("cryptic_caves", BYGFeatures.NOISY_CAVE_SPHERE,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new NoisySphereConfig.Builder()
                        .withRadiusSettings(
                                new NoisySphereConfig.RadiusSettings(UniformInt.of(16, 24), UniformInt.of(10, 16), 0, UniformInt.of(16, 24))
                        ).withBlockProvider(SimpleStateProvider.simple(Blocks.CAVE_AIR))
                        .withFluidState(Fluids.LAVA.defaultFluidState())
                        .withTopBlockProvider(SimpleStateProvider.simple(Blocks.CAVE_AIR))
                        .withSpawningFeatures(
                                List.of(
                                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CRYPTIC_FIRE), List.of(RarityFilter.onAverageOnceEvery(5), createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER.get()))),
                                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CRYPTIC_VENTS), List.of(RarityFilter.onAverageOnceEvery(10), createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER.get()))),
                                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BYGEndVegetationFeatures.CRYPTIC_BRAMBLE), List.of(RarityFilter.onAverageOnceEvery(12), createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER.get())))
                                )
                        ).build();
            }
    );

    public static final BetweenNoiseThresholdProvider BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS = new BetweenNoiseThresholdProvider(2222,
            new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1,
            BetweenNoiseThresholdProvider.createThresholds(0.0125F, -1, 1),
            SimpleStateProvider.simple(Blocks.CRYING_OBSIDIAN), SimpleStateProvider.simple(Blocks.OBSIDIAN), false);

    public static final ResourceKey<ConfiguredFeature<?, ?>> IVIS_FIELDS_SPIKE = createConfiguredFeature("ivis_fields_spike", BYGFeatures.NOISE_SPIKE,
            () -> new NoisySphereConfig.Builder()
                    .copy(BYGOverworldFeatures.STONE_FOREST_COLUMN_CONFIG).withStackHeight(ConstantInt.of(1))
                    .withBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
                    .withTopBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
                    .withBelowSurfaceDepth(ConstantInt.of(1))
                    .withCheckSquareDistance(true)
                    .withPointed(true)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> IVIS_FIELDS_COLUMN = createConfiguredFeature("ivis_fields_column", BYGFeatures.NOISE_SPHERE,
            () -> new NoisySphereConfig.Builder()
                    .copy(BYGOverworldFeatures.STONE_FOREST_COLUMN_CONFIG.get())
                    .withBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
                    .withTopBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
                    .build()
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTIC_SPIKE = createConfiguredFeature("cryptic_spike",
            BYGFeatures.SPIKE,
            () -> new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.CRYPTIC_STONE.defaultBlockState(), 5)
                    .add(BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState(), 5))
            )
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> THERIUM_CRYSTAL_DEPOSIT = createConfiguredFeature("therium_crystal_deposit",
            BYGFeatures.NOISE_SPIKE,
            () -> new NoisySphereConfig.Builder()
                    .withTopBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.THERIUM_CRYSTAL_BLOCK.defaultBlockState(), 8)
                            .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 2))
                    ).withBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.THERIUM_CRYSTAL_BLOCK.defaultBlockState(), 6)
                            .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 4))
                    )
                    .withStackHeight(ConstantInt.of(1)).withRadiusSettings(new NoisySphereConfig.RadiusSettings(BiasedToBottomInt.of(8, 15), BiasedToBottomInt.of(5, 10), 0, BiasedToBottomInt.of(8, 15)))
                    .withNoiseFrequency(0.5F).withVerifiesHeight(false).withBelowSurfaceDepth(ConstantInt.of(Integer.MIN_VALUE)).withRadiusMatcher(RadiusMatcher.XZ).withPointed(true)
                    .withSpawningFeatures(List.of(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(
                                    createPatchConfiguredFeatureWithState(BYGBlocks.THERIUM_CRYSTAL_BLOCK.get(), 15),
                                    CountPlacement.of(UniformInt.of(10, 25)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                                    BlockPredicateFilter.forPredicate(BlockPredicate.anyOf(BlockPredicate.matchesBlocks(new BlockPos(0, -1, 0), BYGBlocks.THERIUM_CRYSTAL_BLOCK.get()))))
                            )
                    )
                    .build()
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> THERIUM_CRYSTAL_DEPOSIT_LARGE = createConfiguredFeature("therium_crystal_deposit_large",
            BYGFeatures.NOISE_SPIKE,
            () -> new NoisySphereConfig.Builder()
                    .withTopBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.THERIUM_CRYSTAL_BLOCK.defaultBlockState(), 2)
                            .add(BYGBlocks.BUDDING_THERIUM_CRYSTAL.defaultBlockState(), 3)
                            .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 5))
                    ).withBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.THERIUM_CRYSTAL_BLOCK.defaultBlockState(), 3)
                            .add(BYGBlocks.BUDDING_THERIUM_CRYSTAL.defaultBlockState(), 2)
                            .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 5))
                    )
                    .withStackHeight(ConstantInt.of(1)).withRadiusSettings(new NoisySphereConfig.RadiusSettings(BiasedToBottomInt.of(13, 20), BiasedToBottomInt.of(20, 27), 0, BiasedToBottomInt.of(13, 20)))
                    .withNoiseFrequency(0.2F).withRadiusMatcher(RadiusMatcher.NONE).withPointed(true)
                    .withSpawningFeatures(List.of(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(
                                    createPatchConfiguredFeatureWithState(BYGBlocks.THERIUM_CRYSTAL_CLUSTER.get(), 10),
                                    CountPlacement.of(UniformInt.of(10, 25)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                                    BlockPredicateFilter.forPredicate(BlockPredicate.anyOf(BlockPredicate.matchesBlocks(new BlockPos(0, -1, 0), BYGBlocks.BUDDING_THERIUM_CRYSTAL.get()))))
                            )
                    )
                    .build()
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> END_LAKE = createConfiguredFeature("large_end_lake", BYGFeatures.LARGE_LAKE,
            () -> new LargeLakeFeatureConfig(9, 14, 4, 9, SimpleStateProvider.simple(Blocks.END_STONE), SimpleStateProvider.simple(Blocks.END_STONE),
                    HolderSet.direct(),
                    HolderSet.direct(),
                    List.of()
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> HANGING_THERIUM_LANTERNS = createConfiguredFeature("hanging_therium_lanterns", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.ETHER_STONE.get()).setBlock(Blocks.CHAIN.defaultBlockState()).setEndBlock(BYGBlocks.THERIUM_LANTERN.defaultBlockState().setValue(LanternBlock.HANGING, true)).setMinLength(1).setMaxLength(8).setPlacementFilter(BlockPredicate.matchesBlocks(BYGBlocks.ETHER_STONE.get())).build());

    public static final ResourceKey<ConfiguredFeature<?, ?>> SHATTERED_FLOATING_ISLAND1 = createConfiguredFeature("shattered_floating_island1", BYGFeatures.SHATTERED_FLOATING_ISLAND1, () -> new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK.get()).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build());
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHATTERED_FLOATING_ISLAND2 = createConfiguredFeature("shattered_floating_island2", BYGFeatures.SHATTERED_FLOATING_ISLAND2, () -> new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK.get()).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build());
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHATTERED_FLOATING_ISLAND3 = createConfiguredFeature("shattered_floating_island3", BYGFeatures.SHATTERED_FLOATING_ISLAND3, () -> new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK.get()).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build());
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHATTERED_FLOATING_ISLAND4 = createConfiguredFeature("shattered_floating_island4", BYGFeatures.SHATTERED_FLOATING_ISLAND4, () -> new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK.get()).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(13).setMaxRadius(17).build());

    public static final ResourceKey<ConfiguredFeature<?, ?>> GROWABLE_SCULK = createConfiguredFeature("growabble_sculk",
            () -> Feature.RANDOM_PATCH,
            () -> new RandomPatchConfiguration(64, 16, 4, BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(
                            Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                                    .add(BYGBlocks.VERMILION_SCULK_GROWTH.defaultBlockState(), 5)
                                    .add(BYGBlocks.VERMILION_SCULK_TENDRILS.defaultBlockState(), 5)
                                    .build()
                            )))
                    , PlacementUtils.HEIGHTMAP)
            ));

    public static final Supplier<Holder<PlacedFeature>> ISLAND_AMETRINE_CLUSTERS = () -> BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(
            Feature.RANDOM_PATCH,
            new RandomPatchConfiguration(64, 16, 4, BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(
                            Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.AMETRINE_CLUSTER.get()))),
                    PlacementUtils.HEIGHTMAP, BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(BlockPos.ZERO.relative(Direction.DOWN), BYGBlocks.BUDDING_AMETRINE_ORE.get()))))), PlacementUtils.HEIGHTMAP);

    public static final Supplier<Holder<PlacedFeature>> ISLAND_SCULK_PLANTS = () -> BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(
            Feature.RANDOM_PATCH,
            new RandomPatchConfiguration(64, 16, 4, BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(
                            Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                                    .add(BYGBlocks.VERMILION_SCULK_GROWTH.defaultBlockState(), 5)
                                    .add(BYGBlocks.VERMILION_SCULK_TENDRILS.defaultBlockState(), 5)
                                    .build()
                            )))
                    , PlacementUtils.HEIGHTMAP)
            )), PlacementUtils.HEIGHTMAP);

    public static final Supplier<WeightedStateProvider> ISLAND_SURFACE_PROVIDER = () -> new WeightedStateProvider(
            new SimpleWeightedRandomList.Builder<BlockState>()
                    .add(BYGBlocks.VERMILION_SCULK.defaultBlockState(), 25)
                    .add(BYGBlocks.BUDDING_AMETRINE_ORE.defaultBlockState(), 1)
                    .add(BYGBlocks.AMETRINE_ORE.defaultBlockState(), 4)
                    .build()
    );
    public static final Supplier<WeightedStateProvider> ISLAND_BLOCK_PROVIDER = () -> new WeightedStateProvider(
            new SimpleWeightedRandomList.Builder<BlockState>()
                    .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 25)
                    .add(BYGBlocks.BUDDING_AMETRINE_ORE.defaultBlockState(), 1)
                    .add(BYGBlocks.AMETRINE_ORE.defaultBlockState(), 4)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOATING_ISLAND1 = createConfiguredFeature("floating_island1",
            BYGFeatures.FLOATING_ISLAND1,
            () -> new FloatingIslandConfig.Builder()
                    .setTopBlock(ISLAND_SURFACE_PROVIDER.get())
                    .setBlock(ISLAND_BLOCK_PROVIDER.get())
                    .setMinRadius(11)
                    .setMaxRadius(13)
                    .addFeatures(ISLAND_AMETRINE_CLUSTERS.get(), ISLAND_SCULK_PLANTS.get())
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOATING_ISLAND2 = createConfiguredFeature("floating_island2",
            BYGFeatures.FLOATING_ISLAND2,
            () -> new FloatingIslandConfig.Builder()
                    .setTopBlock(ISLAND_SURFACE_PROVIDER.get())
                    .setBlock(ISLAND_BLOCK_PROVIDER.get())
                    .setMinRadius(11)
                    .setMaxRadius(13)
                    .addFeatures(ISLAND_AMETRINE_CLUSTERS.get(), ISLAND_SCULK_PLANTS.get())
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOATING_ISLAND3 = createConfiguredFeature("floating_island3",
            BYGFeatures.FLOATING_ISLAND3,
            () -> new FloatingIslandConfig.Builder()
                    .setTopBlock(ISLAND_SURFACE_PROVIDER.get())
                    .setBlock(ISLAND_BLOCK_PROVIDER.get())
                    .setMinRadius(11)
                    .setMaxRadius(13)
                    .addFeatures(ISLAND_AMETRINE_CLUSTERS.get(), ISLAND_SCULK_PLANTS.get())
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOATING_ISLAND4 = createConfiguredFeature("floating_island4",
            BYGFeatures.FLOATING_ISLAND4,
            () -> new FloatingIslandConfig.Builder()
                    .setTopBlock(ISLAND_SURFACE_PROVIDER.get())
                    .setBlock(ISLAND_BLOCK_PROVIDER.get())
                    .setMinRadius(13)
                    .setMaxRadius(17)
                    .addFeatures(ISLAND_AMETRINE_CLUSTERS.get(), ISLAND_SCULK_PLANTS.get())
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOATING_ISLAND5 = createConfiguredFeature("floating_island5",
            BYGFeatures.FLOATING_ISLAND5,
            () -> new FloatingIslandConfig.Builder()
                    .setTopBlock(ISLAND_SURFACE_PROVIDER.get())
                    .setBlock(ISLAND_BLOCK_PROVIDER.get())
                    .setMinRadius(13)
                    .setMaxRadius(17)
                    .addFeatures(ISLAND_AMETRINE_CLUSTERS.get(), ISLAND_SCULK_PLANTS.get())
                    .build()
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> ISLANDS = createConfiguredFeature("floating_islands", () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(
                        ImmutableList.of(new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FLOATING_ISLAND1)), 0.1F),
                                new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FLOATING_ISLAND2)), 0.25F),
                                new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FLOATING_ISLAND3)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FLOATING_ISLAND5)));
            }
    );

    public static void loadClass() {
    }
}