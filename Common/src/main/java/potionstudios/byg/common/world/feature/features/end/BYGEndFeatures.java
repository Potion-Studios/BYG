package potionstudios.byg.common.world.feature.features.end;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.placement.PlacementUtils;
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
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
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
import potionstudios.byg.common.world.feature.stateproviders.BetweenNoiseThresholdProvider;

import java.util.List;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;
import static potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil.createPlacedFeature;

public class BYGEndFeatures {
    public static final BlockPredicate CRYPTIC_STONE_UNDER = BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, BlockPos.ZERO.relative(Direction.DOWN));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CRYPTIC_FIRE_PATCH = createConfiguredFeature("cryptic_fire_patch", Feature.RANDOM_PATCH,
        new RandomPatchConfiguration(24, 4, 7,
            createPlacedFeature(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_FIRE))),
                createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER))
        ));

    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> CRYPTIC_FIRE = createConfiguredFeature("cryptic_fire",
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_FIRE))
    );

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CRYPTIC_VENT_PATCH = createConfiguredFeature("cryptic_vent_patch", Feature.RANDOM_PATCH,
        new RandomPatchConfiguration(24, 4, 7,
            createPlacedFeature(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_VENT))), createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER))
        ));

    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> CRYPTIC_VENT = createConfiguredFeature("cryptic_vent",
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_VENT))
    );

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TALL_CRYPTIC_VENT_PATCH = createConfiguredFeature("tall_cryptic_vent_patch",
        Feature.RANDOM_PATCH,
        new RandomPatchConfiguration(24, 4, 7,
            createPlacedFeature(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.TALL_CRYPTIC_VENT))), createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER))
        ));

    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> TALL_CRYPTIC_VENT = createConfiguredFeature("tall_cryptic_vent",
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.TALL_CRYPTIC_VENT))
    );

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_CRYPTIC_REDSTONE = createConfiguredFeature("cryptic_redstone",
        Feature.ORE,
        new OreConfiguration(
            List.of(
                OreConfiguration.target(new BlockMatchTest(BYGBlocks.CRYPTIC_STONE), BYGBlocks.CRYPTIC_REDSTONE_ORE.defaultBlockState())
            ), 8)
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CRYPTIC_VENT_PATCHES = createConfiguredFeature("cryptic_vents_patch", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(CRYPTIC_VENT_PATCH), 0.50F)),
        createPlacedFeature(TALL_CRYPTIC_VENT_PATCH))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CRYPTIC_VENTS = createConfiguredFeature("cryptic_vents", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(CRYPTIC_VENT), 0.50F)),
        createPlacedFeature(TALL_CRYPTIC_VENT))
    );

    public static final Holder<ConfiguredFeature<NoisySphereConfig, ?>> CRYPTIC_CAVES = createConfiguredFeature("cryptic_caves", BYGFeatures.NOISY_CAVE_SPHERE,
        new NoisySphereConfig.Builder()
            .withRadiusSettings(
                new NoisySphereConfig.RadiusSettings(UniformInt.of(16, 24), UniformInt.of(10, 16), 0, UniformInt.of(16, 24))
            ).withBlockProvider(SimpleStateProvider.simple(Blocks.CAVE_AIR))
            .withFluidState(Fluids.LAVA.defaultFluidState())
            .withTopBlockProvider(SimpleStateProvider.simple(Blocks.CAVE_AIR))
            .withSpawningFeatures(
                List.of(
                    createPlacedFeature(CRYPTIC_FIRE, List.of(RarityFilter.onAverageOnceEvery(5), createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, new BlockPos(0, -1, 0))))),
                    createPlacedFeature(CRYPTIC_VENTS, List.of(RarityFilter.onAverageOnceEvery(10), createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, new BlockPos(0, -1, 0))))),
                    createPlacedFeature(BYGEndVegetationFeatures.CRYPTIC_BRAMBLE, List.of(RarityFilter.onAverageOnceEvery(12), createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, new BlockPos(0, -1, 0)))))
                )
            ).build()
    );

    public static final BetweenNoiseThresholdProvider BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS = new BetweenNoiseThresholdProvider(2222,
        new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1,
        BetweenNoiseThresholdProvider.createThresholds(0.0125F, -1, 1),
        SimpleStateProvider.simple(Blocks.CRYING_OBSIDIAN), SimpleStateProvider.simple(Blocks.OBSIDIAN), false);

    public static final Holder<ConfiguredFeature<NoisySphereConfig, ?>> IVIS_FIELDS_SPIKE = createConfiguredFeature("ivis_fields_spike", BYGFeatures.NOISE_SPIKE,
        new NoisySphereConfig.Builder()
            .copy(BYGOverworldFeatures.STONE_FOREST_COLUMN.value().config()).withStackHeight(ConstantInt.of(1))
            .withBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
            .withTopBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
            .withBelowSurfaceDepth(ConstantInt.of(1))
            .withCheckSquareDistance(true)
            .withPointed(true)
            .build()
    );

    public static final Holder<ConfiguredFeature<NoisySphereConfig, ?>> IVIS_FIELDS_COLUMN = createConfiguredFeature("ivis_fields_column", BYGFeatures.NOISE_SPHERE,
        new NoisySphereConfig.Builder()
            .copy(BYGOverworldFeatures.STONE_FOREST_COLUMN.value().config())
            .withBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
            .withTopBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
            .build()
    );


    public static final Holder<ConfiguredFeature<SimpleBlockProviderConfig, ?>> CRYPTIC_SPIKE = createConfiguredFeature("cryptic_spike",
        BYGFeatures.SPIKE,
        new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(BYGBlocks.CRYPTIC_STONE.defaultBlockState(), 5)
            .add(BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState(), 5))
        )
    );


    public static final Holder<ConfiguredFeature<NoisySphereConfig, ?>> THERIUM_CRYSTAL_DEPOSIT = createConfiguredFeature("therium_crystal_deposit",
        BYGFeatures.NOISE_SPIKE,
        new NoisySphereConfig.Builder()
            .withTopBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.THERIUM_BLOCK.defaultBlockState(), 8)
                .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 2))
            ).withBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.THERIUM_BLOCK.defaultBlockState(), 6)
                .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 4))
            )
            .withStackHeight(ConstantInt.of(1)).withRadiusSettings(new NoisySphereConfig.RadiusSettings(BiasedToBottomInt.of(8, 15), BiasedToBottomInt.of(5, 10), 0, BiasedToBottomInt.of(8, 15)))
            .withNoiseFrequency(0.5F).withVerifiesHeight(false).withBelowSurfaceDepth(ConstantInt.of(Integer.MIN_VALUE)).withRadiusMatcher(RadiusMatcher.XZ).withPointed(true)
            .withSpawningFeatures(List.of(createPlacedFeature(
                    createPatchConfiguredFeature(BYGBlocks.THERIUM_CRYSTAL, 15),
                    CountPlacement.of(UniformInt.of(10, 25)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                    BlockPredicateFilter.forPredicate(BlockPredicate.anyOf(BlockPredicate.matchesBlock(BYGBlocks.THERIUM_BLOCK, new BlockPos(0, -1, 0)))))
                )
            )
            .build()
    );


    public static final Holder<ConfiguredFeature<NoisySphereConfig, ?>> THERIUM_CRYSTAL_DEPOSIT_LARGE = createConfiguredFeature("therium_crystal_deposit_large",
        BYGFeatures.NOISE_SPIKE,
        new NoisySphereConfig.Builder()
            .withTopBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.THERIUM_BLOCK.defaultBlockState(), 2)
                .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 8))
            ).withBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.THERIUM_BLOCK.defaultBlockState(), 4)
                .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 6))
            )
            .withStackHeight(ConstantInt.of(1)).withRadiusSettings(new NoisySphereConfig.RadiusSettings(BiasedToBottomInt.of(13, 20), BiasedToBottomInt.of(20, 27), 0, BiasedToBottomInt.of(13, 20)))
            .withNoiseFrequency(0.2F).withRadiusMatcher(RadiusMatcher.NONE).withPointed(true)
            .withSpawningFeatures(List.of(createPlacedFeature(
                    createPatchConfiguredFeature(BYGBlocks.THERIUM_CRYSTAL, 15),
                    CountPlacement.of(UniformInt.of(10, 25)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                    BlockPredicateFilter.forPredicate(BlockPredicate.anyOf(BlockPredicate.matchesBlock(BYGBlocks.THERIUM_BLOCK, new BlockPos(0, -1, 0)))))
                )
            )
            .build()
    );


    public static final Holder<ConfiguredFeature<LargeLakeFeatureConfig, ?>> END_LAKE = createConfiguredFeature("large_end_lake", BYGFeatures.LARGE_LAKE,
        new LargeLakeFeatureConfig(15, 22, 7, 12, SimpleStateProvider.simple(Blocks.END_STONE), SimpleStateProvider.simple(Blocks.END_STONE),
            HolderSet.direct(),
            HolderSet.direct(),
            List.of()
        )
    );

    public static final Holder<ConfiguredFeature<HangingColumnWithBaseConfig, ?>> HANGING_THERIUM_LANTERNS = createConfiguredFeature("hanging_therium_lanterns", BYGFeatures.HANGING_FEATURE, new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.ETHER_STONE).setBlock(Blocks.CHAIN.defaultBlockState()).setEndBlock(BYGBlocks.THERIUM_LANTERN.defaultBlockState().setValue(LanternBlock.HANGING, true)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(BYGBlocks.ETHER_STONE)).build());

    public static final Holder<ConfiguredFeature<FloatingIslandConfig, ?>> SHATTERED_FLOATING_ISLAND1 = createConfiguredFeature("shattered_floating_island1", BYGFeatures.SHATTERED_FLOATING_ISLAND1, new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build());
    public static final Holder<ConfiguredFeature<FloatingIslandConfig, ?>> SHATTERED_FLOATING_ISLAND2 = createConfiguredFeature("shattered_floating_island2", BYGFeatures.SHATTERED_FLOATING_ISLAND2, new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build());
    public static final Holder<ConfiguredFeature<FloatingIslandConfig, ?>> SHATTERED_FLOATING_ISLAND3 = createConfiguredFeature("shattered_floating_island3", BYGFeatures.SHATTERED_FLOATING_ISLAND3, new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build());
    public static final Holder<ConfiguredFeature<FloatingIslandConfig, ?>> SHATTERED_FLOATING_ISLAND4 = createConfiguredFeature("shattered_floating_island4", BYGFeatures.SHATTERED_FLOATING_ISLAND4, new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(13).setMaxRadius(17).build());

    public static final Holder<PlacedFeature> ISLAND_AMETRINE_CLUSTERS = createPlacedFeature(createConfiguredFeature(
        Feature.RANDOM_PATCH,
        new RandomPatchConfiguration(64, 16, 4, createPlacedFeature(createConfiguredFeature(
                Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.AMETRINE_CLUSTER))),
            PlacementUtils.HEIGHTMAP, BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlock(BYGBlocks.BUDDING_AMETRINE_ORE, BlockPos.ZERO.relative(Direction.DOWN)))))), PlacementUtils.HEIGHTMAP);

    public static final Holder<PlacedFeature> ISLAND_SCULK_PLANTS = createPlacedFeature(createConfiguredFeature(Feature.RANDOM_PATCH,
        new RandomPatchConfiguration(64, 16, 4, createPlacedFeature(createConfiguredFeature(
                Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                    .add(BYGBlocks.VERMILION_SCULK_GROWTH.defaultBlockState(), 5)
                    .add(BYGBlocks.VERMILION_SCULK_TENDRILS.defaultBlockState(), 5)
                    .build()
                )))
            , PlacementUtils.HEIGHTMAP)
        )), PlacementUtils.HEIGHTMAP);

    public static final WeightedStateProvider ISLAND_SURFACE_PROVIDER = new WeightedStateProvider(
        new SimpleWeightedRandomList.Builder<BlockState>()
            .add(BYGBlocks.VERMILION_SCULK.defaultBlockState(), 25)
            .add(BYGBlocks.BUDDING_AMETRINE_ORE.defaultBlockState(), 1)
            .add(BYGBlocks.AMETRINE_ORE.defaultBlockState(), 4)
            .build()
    );
    public static final WeightedStateProvider ISLAND_BLOCK_PROVIDER = new WeightedStateProvider(
        new SimpleWeightedRandomList.Builder<BlockState>()
            .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 25)
            .add(BYGBlocks.BUDDING_AMETRINE_ORE.defaultBlockState(), 1)
            .add(BYGBlocks.AMETRINE_ORE.defaultBlockState(), 4)
            .build()
    );

    public static final Holder<ConfiguredFeature<FloatingIslandConfig, ?>> FLOATING_ISLAND1 = createConfiguredFeature("floating_island1",
        BYGFeatures.FLOATING_ISLAND1,
        new FloatingIslandConfig.Builder()
            .setTopBlock(ISLAND_SURFACE_PROVIDER)
            .setBlock(ISLAND_BLOCK_PROVIDER)
            .setMinRadius(11)
            .setMaxRadius(13)
            .addFeatures(ISLAND_AMETRINE_CLUSTERS, ISLAND_SCULK_PLANTS)
            .build()
    );

    public static final Holder<ConfiguredFeature<FloatingIslandConfig, ?>> FLOATING_ISLAND2 = createConfiguredFeature("floating_island2",
        BYGFeatures.FLOATING_ISLAND2,
        new FloatingIslandConfig.Builder()
            .setTopBlock(ISLAND_SURFACE_PROVIDER)
            .setBlock(ISLAND_BLOCK_PROVIDER)
            .setMinRadius(11)
            .setMaxRadius(13)
            .addFeatures(ISLAND_AMETRINE_CLUSTERS, ISLAND_SCULK_PLANTS)
            .build()
    );

    public static final Holder<ConfiguredFeature<FloatingIslandConfig, ?>> FLOATING_ISLAND3 = createConfiguredFeature("floating_island3",
        BYGFeatures.FLOATING_ISLAND3,
        new FloatingIslandConfig.Builder()
            .setTopBlock(ISLAND_SURFACE_PROVIDER)
            .setBlock(ISLAND_BLOCK_PROVIDER)
            .setMinRadius(11)
            .setMaxRadius(13)
            .addFeatures(ISLAND_AMETRINE_CLUSTERS, ISLAND_SCULK_PLANTS)
            .build()
    );

    public static final Holder<ConfiguredFeature<FloatingIslandConfig, ?>> FLOATING_ISLAND4 = createConfiguredFeature("floating_island4",
        BYGFeatures.FLOATING_ISLAND4,
        new FloatingIslandConfig.Builder()
            .setTopBlock(ISLAND_SURFACE_PROVIDER)
            .setBlock(ISLAND_BLOCK_PROVIDER)
            .setMinRadius(13)
            .setMaxRadius(17)
            .addFeatures(ISLAND_AMETRINE_CLUSTERS, ISLAND_SCULK_PLANTS)
            .build()
    );

    public static final Holder<ConfiguredFeature<FloatingIslandConfig, ?>> FLOATING_ISLAND5 = createConfiguredFeature("floating_island5",
        BYGFeatures.FLOATING_ISLAND5,
        new FloatingIslandConfig.Builder()
            .setTopBlock(ISLAND_SURFACE_PROVIDER)
            .setBlock(ISLAND_BLOCK_PROVIDER)
            .setMinRadius(13)
            .setMaxRadius(17)
            .addFeatures(ISLAND_AMETRINE_CLUSTERS, ISLAND_SCULK_PLANTS)
            .build()
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ISLANDS = createConfiguredFeature("floating_islands", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(createPlacedFeature(FLOATING_ISLAND1), 0.1F),
        new WeightedPlacedFeature(createPlacedFeature(FLOATING_ISLAND2), 0.25F),
        new WeightedPlacedFeature(createPlacedFeature(FLOATING_ISLAND3), 0.25F)),
        createPlacedFeature(FLOATING_ISLAND5)
    ));
}