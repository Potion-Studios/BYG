package potionstudios.byg.common.world.feature.features.overworld;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.*;
import potionstudios.byg.common.world.feature.features.BYGFeaturesUtil;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;
import potionstudios.byg.common.world.feature.stateproviders.BetweenNoiseThresholdProvider;
import potionstudios.byg.util.lazy.LazySupplier;

import java.util.List;
import java.util.function.Supplier;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;

public class BYGOverworldFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> BASALT_DELTA = createConfiguredFeature("delta", () -> Feature.DELTA_FEATURE, () -> new DeltaFeatureConfiguration(Blocks.WATER.defaultBlockState(), Blocks.WATER.defaultBlockState(), UniformInt.of(3, 4), UniformInt.of(0, 2)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_BASALT_COLUMN = createConfiguredFeature("small_basalt_columns", () -> Feature.BASALT_COLUMNS, () -> new ColumnFeatureConfiguration(UniformInt.of(0, 1), UniformInt.of(1, 1)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_BASALT_COLUMN = createConfiguredFeature("large_basalt_columns", () -> Feature.BASALT_COLUMNS, () -> new ColumnFeatureConfiguration(UniformInt.of(1, 2), UniformInt.of(1, 1)));

    public static final ResourceKey<ConfiguredFeature<?, ?>> BEEHIVES = createConfiguredFeature("beehives", BYGFeatures.BEEHIVE, NoneFeatureConfiguration::new);
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOSSY_STONE_BOULDER = createConfiguredFeature("mossy_stone_boulder", () -> Feature.FOREST_ROCK, () -> new BlockStateConfiguration(BYGBlocks.MOSSY_STONE.defaultBlockState()));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCKY_STONE_BOULDER = createConfiguredFeature("rocky_stone_boulder", () -> Feature.FOREST_ROCK, () -> new BlockStateConfiguration(BYGBlocks.ROCKY_STONE.defaultBlockState()));
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKSTONE_BOULDER = createConfiguredFeature("blackstone_boulder", () -> Feature.FOREST_ROCK, () -> new BlockStateConfiguration(Blocks.BLACKSTONE.defaultBlockState()));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_TERRACOTTA_BOULDER = createConfiguredFeature("orange_terracotta_boulder", () -> Feature.FOREST_ROCK, () -> new BlockStateConfiguration(Blocks.ORANGE_TERRACOTTA.defaultBlockState()));
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACK_ICE = createConfiguredFeature("black_ice_snow", () -> Feature.SIMPLE_BLOCK, () -> new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.BLACK_ICE.get())));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRAG_GEN = createConfiguredFeature("crag_gen",
            BYGFeatures.CRAG_FEATURE, () -> new SimpleBlockProviderConfig(
                    new BetweenNoiseThresholdProvider(123, new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1,
                            BetweenNoiseThresholdProvider.createThresholds(0.0125F, -0.5F, 0.5F),
                            SimpleStateProvider.simple(Blocks.TUFF), SimpleStateProvider.simple(Blocks.DEEPSLATE), false)
            ));

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRAG_DELTA = createConfiguredFeature("crag_delta", () -> Feature.DELTA_FEATURE, () -> new DeltaFeatureConfiguration(Blocks.WATER.defaultBlockState(), BYGBlocks.OVERGROWN_STONE.defaultBlockState(), UniformInt.of(7, 15), UniformInt.of(1, 3)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SWAMP_MOSS_DELTA = createConfiguredFeature("swamp_moss_delta", () -> Feature.DELTA_FEATURE, () -> new DeltaFeatureConfiguration(Blocks.WATER.defaultBlockState(), Blocks.MOSS_BLOCK.defaultBlockState(), UniformInt.of(10, 15), UniformInt.of(1, 3)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SWAMP_GRASS_BLOCK_DELTA = createConfiguredFeature("swamp_grass_block_delta", () -> Feature.DELTA_FEATURE, () -> new DeltaFeatureConfiguration(Blocks.WATER.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), UniformInt.of(10, 15), UniformInt.of(1, 3)));


    public static final ResourceKey<ConfiguredFeature<?, ?>> WIDE_WATER_LAKE = createConfiguredFeature("wide_water_lake",
            BYGFeatures.WIDE_LAKE, () -> new SimpleBlockProviderConfig(SimpleStateProvider.simple(Blocks.WATER.defaultBlockState()))
    );


    private static final Supplier<WeightedStateProvider> LUSH_SPIKE_PROVIDER = () -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(Blocks.STONE.defaultBlockState(), 6)
            .add(Blocks.MOSSY_COBBLESTONE.defaultBlockState(), 3)
            .add(Blocks.ANDESITE.defaultBlockState(), 1)
            .add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 1)
    );

    private static final Supplier<WeightedStateProvider> SPIKE_PROVIDER = () -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(Blocks.STONE.defaultBlockState(), 6)
            .add(Blocks.ANDESITE.defaultBlockState(), 1)
            .add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 1)
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> LUSH_STACKS_SPIKE = createConfiguredFeature("lush_stacks_spike",
            BYGFeatures.POINTY_ROCK,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new PointyRockConfig.Builder()
                        .setBlock(LUSH_SPIKE_PROVIDER.get())
                        .setSeed(65)
                        .setPostFeatures(HolderSet.direct(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CaveFeatures.MOSS_PATCH))))
                        .build();
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> LUSH_STACKS_SPIKE_TALL = createConfiguredFeature("lush_stacks_tall_spike",
            BYGFeatures.POINTY_ROCK,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new PointyRockConfig.Builder()
                        .setBlock(LUSH_SPIKE_PROVIDER.get())
                        .setSeed(65)
                        .setPostFeatures(HolderSet.direct(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CaveFeatures.MOSS_PATCH))))
                        .build();
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SEA_SPIKE = createConfiguredFeature("dead_sea_spike",
            BYGFeatures.POINTY_ROCK,
            () -> new PointyRockConfig.Builder()
                    .setBlock(SPIKE_PROVIDER.get())
                    .setSeed(65)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SEA_SPIKE_TALL = createConfiguredFeature("dead_sea_tall_spike",
            BYGFeatures.TALL_POINTED_ROCK,
            () -> new PointyRockConfig.Builder()
                    .setBlock(SPIKE_PROVIDER.get())
                    .setSeed(85)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> WINDSWEPT_SPIKE = createConfiguredFeature("windswept_spike",
            BYGFeatures.POINTY_ROCK,
            () -> new PointyRockConfig.Builder()
                    .setBlock(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), 3)
                                    .add(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE.defaultBlockState(), 2))
                    )
                    .setSeed(65)
                    .build()
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> WINDSWEPT_SPIKE_TALL = createConfiguredFeature("windswept_tall_spike",
            BYGFeatures.POINTY_ROCK,
            () -> new PointyRockConfig.Builder()
                    .setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), 3)
                            .add(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE.defaultBlockState(), 2))
                    )
                    .setSeed(85)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_WINDSWEPT_LAKE = createConfiguredFeature("large_windswept_lake", BYGFeatures.LARGE_LAKE,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
                return   new LargeLakeFeatureConfig(15, 22, 4, 10, SimpleStateProvider.simple(BYGBlocks.WINDSWEPT_SAND.get()), SimpleStateProvider.simple(BYGBlocks.WINDSWEPT_SAND.get()),
                        HolderSet.direct(
                                BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BYGOverworldVegetationFeatures.TINY_LILY_PAD), RarityFilter.onAverageOnceEvery(95), BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(new BlockPos(0, -1, 0), Fluids.WATER))),
                                LargeLakeFeatureConfig.createDripLeavesPlacedFeature(lookup, 80, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
                        ),
                        HolderSet.direct(
                                LargeLakeFeatureConfig.createDripLeavesPlacedFeature(lookup, 8, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR),
                                BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BYGOverworldTreeFeatures.PALM_TREES), RarityFilter.onAverageOnceEvery(30), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BYGWoodTypes.PALM.growerItem().defaultBlockState(), BlockPos.ZERO)))
                        ),
                        List.of());
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_BOULDER = createConfiguredFeature("large_boulder",
            BYGFeatures.BOULDER,
            () -> new NoisySphereConfig.Builder()
                    .withRadiusSettings(
                            new NoisySphereConfig.RadiusSettings(UniformInt.of(16, 24), UniformInt.of(10, 16), 0, UniformInt.of(16, 24))
                    ).withBlockProvider(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(Blocks.STONE.defaultBlockState(), 4)
                                    .add(Blocks.ANDESITE.defaultBlockState(), 1)
                            )
                    )
                    .withTopBlockProvider(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(Blocks.STONE.defaultBlockState(), 4)
                                    .add(Blocks.ANDESITE.defaultBlockState(), 1)
                            )
                    )
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_HOWLING_PEAKS_BOULDER = createConfiguredFeature("large_howling_peaks_boulder",
            BYGFeatures.BOULDER,
            () -> new NoisySphereConfig.Builder()
                    .withRadiusSettings(
                            new NoisySphereConfig.RadiusSettings(UniformInt.of(9, 14), UniformInt.of(9, 14), 0, UniformInt.of(9, 14))
                    ).withBlockProvider(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 4)
                                    .add(Blocks.STONE.defaultBlockState(), 1)
                            )
                    )
                    .withTopBlockProvider(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(Blocks.MOSS_BLOCK.defaultBlockState(), 4)
                                    .add(BYGBlocks.MOSSY_STONE.defaultBlockState(), 1)
                            )
                    )
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_WINDSWEPT_BOULDER = createConfiguredFeature("large_windswept_boulder",
            BYGFeatures.BOULDER,
            () -> new NoisySphereConfig.Builder()
                    .withRadiusSettings(
                            new NoisySphereConfig.RadiusSettings(UniformInt.of(9, 14), UniformInt.of(9, 14), 0, UniformInt.of(9, 14))
                    ).withBlockProvider(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), 4)
                                    .add(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE.defaultBlockState(), 2)
                                    .add(BYGBlocks.WINDSWEPT_SAND.defaultBlockState(), 1)
                            )
                    )
                    .withTopBlockProvider(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), 4)
                                    .add(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE.defaultBlockState(), 2)
                                    .add(BYGBlocks.WINDSWEPT_SAND.defaultBlockState(), 1)
                            )
                    )
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_GRANITE_BOULDER = createConfiguredFeature("large_granite_boulder",
            BYGFeatures.BOULDER,
            () -> new NoisySphereConfig.Builder()
                    .withRadiusSettings(
                            new NoisySphereConfig.RadiusSettings(UniformInt.of(16, 24), UniformInt.of(10, 16), 0, UniformInt.of(16, 24))
                    ).withBlockProvider(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(Blocks.GRANITE.defaultBlockState(), 4)
                                    .add(Blocks.POLISHED_GRANITE.defaultBlockState(), 1)
                            )
                    )
                    .withTopBlockProvider(
                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(Blocks.GRANITE.defaultBlockState(), 4)
                                    .add(Blocks.POLISHED_GRANITE.defaultBlockState(), 1)
                            )
                    )
                    .build()
    );

    public static final LazySupplier<NoisySphereConfig> STONE_FOREST_COLUMN_CONFIG = new LazySupplier<>(() ->
            new NoisySphereConfig.Builder()
                    .withStackHeight(UniformInt.of(3, 7))
                    .withRadiusSettings(new NoisySphereConfig.RadiusSettings(UniformInt.of(8, 20), UniformInt.of(80, 100), 17, UniformInt.of(6, 18)))
                    .withRadiusDivisorPerStack(2)
                    .withNoise2DChance(0.25)
                    .withBlockProvider(SimpleStateProvider.simple(Blocks.STONE.defaultBlockState()))
                    .withTopBlockProvider(SimpleStateProvider.simple(BYGBlocks.OVERGROWN_STONE.get()))
                    .withNoiseFrequency(0.09F)
                    .withRadiusMatcher(RadiusMatcher.NONE)
                    .withCheckSquareDistance(false)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> STONE_FOREST_COLUMN = BYGFeaturesUtil.createConfiguredFeature("stone_forest_column",
            BYGFeatures.NOISE_SPHERE,
            STONE_FOREST_COLUMN_CONFIG
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> LUSH_STACKS_SPIKES = createConfiguredFeature("lush_stacks_spikes",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(LUSH_STACKS_SPIKE)), 0.75F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(LUSH_STACKS_SPIKE_TALL)));
            }
            ));

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SEA_SPIKES = createConfiguredFeature("dead_sea_spikes",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(DEAD_SEA_SPIKE)), 0.75F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(DEAD_SEA_SPIKE_TALL)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> WINDSWEPT_SPIKES = createConfiguredFeature("windswept_spikes",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WINDSWEPT_SPIKE)), 0.75F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WINDSWEPT_SPIKE_TALL)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_MUD = createConfiguredFeature("disk_mud",
            () -> Feature.DISK,
            () -> new DiskConfiguration(new RuleBasedBlockStateProvider(BlockStateProvider.simple(Blocks.MUD), List.of(new RuleBasedBlockStateProvider.Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR), BlockStateProvider.simple(Blocks.MUD)))), BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.CLAY), UniformInt.of(2, 6), 2)
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ARCH_FEATURE = createConfiguredFeature("red_rock_arches",
            BYGFeatures.ARCH,
            () -> new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.RED_ROCK.get()))
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_ROCK_SPIKE = createConfiguredFeature("red_rock_spike",
            BYGFeatures.SPIKE,
            () -> new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.RED_ROCK.defaultBlockState(), 4)
                    .add(Blocks.TERRACOTTA.defaultBlockState(), 1))
            )
    );

    public static void loadClass() {
    }
}