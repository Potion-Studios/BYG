package potionstudios.byg.common.world.feature.features.overworld;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.placement.PlacementUtils;
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
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.*;
import potionstudios.byg.common.world.feature.stateproviders.BetweenNoiseThresholdProvider;

import java.util.List;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;

public class BYGOverworldFeatures {

    public static final ConfiguredFeature<?, ?> BEEHIVES = createConfiguredFeature("beehives", BYGFeatures.BEEHIVE.configured(new NoneFeatureConfiguration()));
    public static final ConfiguredFeature<?, ?> MOSSY_STONE_BOULDER = createConfiguredFeature("mossy_stone_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(BYGBlocks.MOSSY_STONE.defaultBlockState())));
    public static final ConfiguredFeature<?, ?> ROCKY_STONE_BOULDER = createConfiguredFeature("rocky_stone_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(BYGBlocks.ROCKY_STONE.defaultBlockState())));
    public static final ConfiguredFeature<?, ?> BLACKSTONE_BOULDER = createConfiguredFeature("blackstone_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.BLACKSTONE.defaultBlockState())));
    public static final ConfiguredFeature<?, ?> ORANGE_TERRACOTTA_BOULDER = createConfiguredFeature("orange_terracotta_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.ORANGE_TERRACOTTA.defaultBlockState())));
    public static final ConfiguredFeature<?, ?> BLACK_ICE = createConfiguredFeature("black_ice_snow", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.BLACK_ICE))));
    public static final ConfiguredFeature<?, ?> CRAG_GEN = createConfiguredFeature("crag_gen",
        BYGFeatures.CRAG_FEATURE.configured(new SimpleBlockProviderConfig(
            new BetweenNoiseThresholdProvider(123, new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1,
                BetweenNoiseThresholdProvider.createThresholds(0.0125F, -0.5F, 0.5F),
                SimpleStateProvider.simple(Blocks.TUFF), SimpleStateProvider.simple(Blocks.DEEPSLATE), false)
        )));

    public static final ConfiguredFeature<?, ?> CRAG_DELTA = createConfiguredFeature("crag_delta", Feature.DELTA_FEATURE.configured(new DeltaFeatureConfiguration(Blocks.WATER.defaultBlockState(), BYGBlocks.OVERGROWN_STONE.defaultBlockState(), UniformInt.of(7, 15), ConstantInt.of(0))));


    public static final ConfiguredFeature<?, ?> WIDE_WATER_LAKE = createConfiguredFeature("wide_water_lake",
        BYGFeatures.WIDE_LAKE.configured(new SimpleBlockProviderConfig(SimpleStateProvider.simple(Blocks.WATER.defaultBlockState())))
    );
    public static final ConfiguredFeature<?, ?> FROST_MAGMA_LAKE = createConfiguredFeature("wide_frost_magma_lake",
        BYGFeatures.WIDE_LAKE.configured(new SimpleBlockProviderConfig(SimpleStateProvider.simple(BYGBlocks.FROST_MAGMA.defaultBlockState())))
    );


    public static final ConfiguredFeature<?, ?> DEAD_SEA_SPIKE = createConfiguredFeature("dead_sea_spike",
        BYGFeatures.POINTY_ROCK.configured(
            new PointyRockConfig.Builder()
                .setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 5)
                    .add(Blocks.STONE.defaultBlockState(), 3)
                    .add(Blocks.ANDESITE.defaultBlockState(), 2))
                )
                .setSeed(65)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> DEAD_SEA_SPIKE_TALL = createConfiguredFeature("dead_sea_tall_spike",
        BYGFeatures.POINTY_ROCK.configured(
            new PointyRockConfig.Builder()
                .setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 5)
                    .add(Blocks.STONE.defaultBlockState(), 3)
                    .add(Blocks.ANDESITE.defaultBlockState(), 2))
                )
                .setSeed(85)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> WINDSWEPT_SPIKE = createConfiguredFeature("windswept_spike",
        BYGFeatures.POINTY_ROCK.configured(
            new PointyRockConfig.Builder()
                .setBlock(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), 3)
                        .add(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE.defaultBlockState(), 2))
                )
                .setSeed(65)
                .build()
        ));
    public static final ConfiguredFeature<?, ?> WINDSWEPT_SPIKE_TALL = createConfiguredFeature("windswept_tall_spike",
        BYGFeatures.POINTY_ROCK.configured(
            new PointyRockConfig.Builder()
                .setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), 3)
                    .add(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE.defaultBlockState(), 2))
                )
                .setSeed(85)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> LARGE_WINDSWEPT_LAKE = createConfiguredFeature("large_windswept_lake", BYGFeatures.LARGE_LAKE.configured(
        new LargeLakeFeatureConfig(15, 22, 4, 10, SimpleStateProvider.simple(BYGBlocks.WINDSWEPT_SAND), SimpleStateProvider.simple(BYGBlocks.WINDSWEPT_SAND),
            List.of(
                () -> BYGOverworldVegetationFeatures.TINY_LILY_PAD.placed(RarityFilter.onAverageOnceEvery(95), BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0)))),
                () -> LargeLakeFeatureConfig.createDripLeavesPlacedFeature(80, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
            ),
            List.of(
                () -> LargeLakeFeatureConfig.createDripLeavesPlacedFeature(8, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR),
                () -> BYGOverworldTreeFeatures.PALM_TREES.placed(RarityFilter.onAverageOnceEvery(30), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BYGBlocks.PALM_SAPLING.defaultBlockState(), BlockPos.ZERO)))
            ),
            List.of())
    ));

    public static final ConfiguredFeature<NoisySphereConfig, ?> LARGE_BOULDER = createConfiguredFeature("large_boulder",
        BYGFeatures.NOISE_SPHERE.configured(
            new NoisySphereConfig.Builder()
                .withBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 3)
                    .add(BYGBlocks.MOSSY_STONE.defaultBlockState(), 2))
                )
                .withStackHeight(ConstantInt.of(1))
                .withRadiusSettings(new NoisySphereConfig.RadiusSettings(BiasedToBottomInt.of(16, 30), BiasedToBottomInt.of(16, 30), 0, BiasedToBottomInt.of(16, 30)))
                .build()
        ));

    public static final ConfiguredFeature<NoisySphereConfig, ?> LARGE_GRANITE_BOULDER = createConfiguredFeature("large_granite_boulder",
        BYGFeatures.NOISE_SPHERE.configured(new NoisySphereConfig.Builder().copy(LARGE_BOULDER.config)
            .withBlockProvider(
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(Blocks.GRANITE.defaultBlockState(), 3)
                    .add(Blocks.POLISHED_GRANITE.defaultBlockState(), 2))
            )
            .build()
        ));

    public static final ConfiguredFeature<NoisySphereConfig, ?> LARGE_WINDSWEPT_BOULDER = createConfiguredFeature("large_windswept_boulders",
        BYGFeatures.NOISE_SPHERE.configured(
            new NoisySphereConfig.Builder()
                .withBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 158)
                    .add(Blocks.TUFF.defaultBlockState(), 41)
                    .add(Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 1))
                )
                .withTopBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 158)
                    .add(Blocks.TUFF.defaultBlockState(), 41)
                    .add(Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 1))
                )
                .withRadiusSettings(new NoisySphereConfig.RadiusSettings(BiasedToBottomInt.of(16, 35), UniformInt.of(20, 25), 0, BiasedToBottomInt.of(16, 35)))
                .withNoiseFrequency(0.2F)
                .withSpawningFeatures(List.of(
                    () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WINDSWEPT_SAND)))
                        .placed(
                            CountPlacement.of(UniformInt.of(10, 25)),
                            InSquarePlacement.spread(),
                            PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                            BlockPredicateFilter.forPredicate(BlockPredicate.anyOf(
                                BlockPredicate.matchesBlock(Blocks.TUFF, new BlockPos(0, -1, 0)),
                                BlockPredicate.matchesBlock(Blocks.DEEPSLATE_EMERALD_ORE, new BlockPos(0, -1, 0)),
                                BlockPredicate.matchesBlock(BYGBlocks.ROCKY_STONE, new BlockPos(0, -1, 0)))
                            )
                        )
                ))
                .build()
        ));

    public static final ConfiguredFeature<NoisySphereConfig, ?> STONE_FOREST_COLUMN = createConfiguredFeature("stone_forest_column",
        BYGFeatures.NOISE_SPHERE.configured(
            new NoisySphereConfig.Builder()
                .withStackHeight(UniformInt.of(3, 7))
                .withRadiusSettings(new NoisySphereConfig.RadiusSettings(UniformInt.of(8, 20), UniformInt.of(80, 100), 17, UniformInt.of(6, 18)))
                .withRadiusDivisorPerStack(2)
                .withNoise2DChance(0.25)
                .withBlockProvider(SimpleStateProvider.simple(Blocks.STONE.defaultBlockState()))
                .withTopBlockProvider(SimpleStateProvider.simple(BYGBlocks.OVERGROWN_STONE))
                .withNoiseFrequency(0.09F)
                .withRadiusMatcher(RadiusMatcher.NONE)
                .withCheckSquareDistance(false)
                .build()
        ));


    public static final ConfiguredFeature<?, ?> DEAD_SEA_SPIKES = createConfiguredFeature("dead_sea_spikes",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(DEAD_SEA_SPIKE.placed(), 0.75F)),
                DEAD_SEA_SPIKE_TALL.placed())
        ));

    public static final ConfiguredFeature<?, ?> WINDSWEPT_SPIKES = createConfiguredFeature("windswept_spikes",
        Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(WINDSWEPT_SPIKE.placed(), 0.75F)),
            WINDSWEPT_SPIKE_TALL.placed())));

    public static final ConfiguredFeature<DiskConfiguration, ?> DISK_MUD = createConfiguredFeature("disk_mud",
        Feature.DISK.configured(
            new DiskConfiguration(BYGBlocks.MUD_BLOCK.defaultBlockState(), UniformInt.of(2, 3), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.CLAY.defaultBlockState()))
        ));
}