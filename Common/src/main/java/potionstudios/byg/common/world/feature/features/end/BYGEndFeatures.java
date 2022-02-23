package potionstudios.byg.common.world.feature.features.end;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
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

public class BYGEndFeatures {
    public static final BlockPredicate CRYPTIC_STONE_UNDER = BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, BlockPos.ZERO.relative(Direction.DOWN));

    public static final ConfiguredFeature<?, ?> CRYPTIC_FIRE_PATCH = createConfiguredFeature("cryptic_fire_patch", Feature.RANDOM_PATCH.configured(
        new RandomPatchConfiguration(24, 4, 7,
            () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_FIRE)
            )).placed(createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER)))
    ));

    public static final ConfiguredFeature<?, ?> CRYPTIC_FIRE = createConfiguredFeature("cryptic_fire",
        Feature.SIMPLE_BLOCK.configured(
            new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_FIRE))
        ));

    public static final ConfiguredFeature<?, ?> CRYPTIC_VENT_PATCH = createConfiguredFeature("cryptic_vent_patch", Feature.RANDOM_PATCH.configured(
        new RandomPatchConfiguration(24, 4, 7,
            () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_VENT))).placed(createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER))
        )));

    public static final ConfiguredFeature<?, ?> CRYPTIC_VENT = createConfiguredFeature("cryptic_vent",
        Feature.SIMPLE_BLOCK.configured(
            new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_VENT))
        ));

    public static final ConfiguredFeature<?, ?> TALL_CRYPTIC_VENT_PATCH = createConfiguredFeature("tall_cryptic_vent_patch",
        Feature.RANDOM_PATCH.configured(
            new RandomPatchConfiguration(24, 4, 7,
                () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.TALL_CRYPTIC_VENT))).placed(createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER))
            )));

    public static final ConfiguredFeature<?, ?> TALL_CRYPTIC_VENT = createConfiguredFeature("tall_cryptic_vent",
        Feature.SIMPLE_BLOCK.configured(
            new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.TALL_CRYPTIC_VENT))
        ));

    public static final ConfiguredFeature<?, ?> ORE_CRYPTIC_REDSTONE = createConfiguredFeature("cryptic_redstone",
        Feature.ORE.configured(
            new OreConfiguration(
                List.of(
                    OreConfiguration.target(new BlockMatchTest(BYGBlocks.CRYPTIC_STONE), BYGBlocks.CRYPTIC_REDSTONE_ORE.defaultBlockState())
                ), 8)
        ));

    public static final ConfiguredFeature<?, ?> CRYPTIC_VENT_PATCHES = createConfiguredFeature("cryptic_vents_patch", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(CRYPTIC_VENT_PATCH.placed(), 0.50F)),
        TALL_CRYPTIC_VENT_PATCH.placed())
    ));

    public static final ConfiguredFeature<?, ?> CRYPTIC_VENTS = createConfiguredFeature("cryptic_vents", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(CRYPTIC_VENT.placed(), 0.50F)),
        TALL_CRYPTIC_VENT.placed())
    ));

    public static final ConfiguredFeature<?, ?> CRYPTIC_CAVES = createConfiguredFeature("cryptic_caves", BYGFeatures.NOISY_CAVE_SPHERE.configured(
        new NoisySphereConfig.Builder()
            .withRadiusSettings(
                new NoisySphereConfig.RadiusSettings(UniformInt.of(16, 24), UniformInt.of(10, 16), 0, UniformInt.of(16, 24))
            ).withBlockProvider(SimpleStateProvider.simple(Blocks.CAVE_AIR))
            .withFluidState(Fluids.LAVA.defaultFluidState())
            .withTopBlockProvider(SimpleStateProvider.simple(Blocks.CAVE_AIR))
            .withSpawningFeatures(
                List.of(
                    () -> CRYPTIC_FIRE.placed(List.of(RarityFilter.onAverageOnceEvery(5), createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, new BlockPos(0, -1, 0))))),
                    () -> CRYPTIC_VENTS.placed(List.of(RarityFilter.onAverageOnceEvery(10), createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, new BlockPos(0, -1, 0))))),
                    () -> BYGEndVegetationFeatures.CRYPTIC_BRAMBLE.placed(List.of(RarityFilter.onAverageOnceEvery(12), createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, new BlockPos(0, -1, 0)))))
                )
            ).build()
    ));

    public static final BetweenNoiseThresholdProvider BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS = new BetweenNoiseThresholdProvider(2222,
        new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1,
        BetweenNoiseThresholdProvider.createThresholds(0.0125F, -1, 1),
        SimpleStateProvider.simple(Blocks.CRYING_OBSIDIAN), SimpleStateProvider.simple(Blocks.OBSIDIAN), false);

    public static final ConfiguredFeature<NoisySphereConfig, ?> IVIS_FIELDS_SPIKE = createConfiguredFeature("ivis_fields_spike", BYGFeatures.NOISE_SPIKE.configured(new NoisySphereConfig.Builder()
        .copy(BYGOverworldFeatures.STONE_FOREST_COLUMN.config).withStackHeight(ConstantInt.of(1))
        .withBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
        .withTopBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
        .withBelowSurfaceDepth(ConstantInt.of(1))
        .withCheckSquareDistance(true)
        .withPointed(true)
        .build()
    ));

    public static final ConfiguredFeature<NoisySphereConfig, ?> IVIS_FIELDS_COLUMN = createConfiguredFeature("ivis_fields_column", BYGFeatures.NOISE_SPHERE.configured(new NoisySphereConfig.Builder()
        .copy(BYGOverworldFeatures.STONE_FOREST_COLUMN.config)
        .withBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
        .withTopBlockProvider(BETWEEN_NOISE_THRESHOLD_PROVIDER_IVIS)
        .build()
    ));


    public static final ConfiguredFeature<?, ?> CRYPTIC_SPIKE = createConfiguredFeature("cryptic_spike",
        BYGFeatures.SPIKE.configured(
            new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(BYGBlocks.CRYPTIC_STONE.defaultBlockState(), 5)
                .add(BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState(), 5))
            )
        ));


    public static final ConfiguredFeature<?, ?> THERIUM_CRYSTAL_DEPOSIT = createConfiguredFeature("therium_crystal_deposit",
        BYGFeatures.NOISE_SPIKE.configured(
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
                .withSpawningFeatures(List.of(
                    () -> createPatchConfiguredFeature(BYGBlocks.THERIUM_CRYSTAL, 15).placed(
                        CountPlacement.of(UniformInt.of(15, 30)), HeightRangePlacement.uniform(VerticalAnchor.absolute(200), VerticalAnchor.absolute(256)), InSquarePlacement.spread(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.anyOf(BlockPredicate.matchesBlock(BYGBlocks.THERIUM_BLOCK, new BlockPos(0, -1, 0)))))))
                .build()
        ));


    public static final ConfiguredFeature<?, ?> THERIUM_CRYSTAL_DEPOSIT_LARGE = createConfiguredFeature("therium_crystal_deposit_large",
        BYGFeatures.NOISE_SPIKE.configured(
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
                .withSpawningFeatures(List.of(
                    () -> createPatchConfiguredFeature(BYGBlocks.THERIUM_CRYSTAL, 15).placed(
                        CountPlacement.of(UniformInt.of(10, 25)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        BlockPredicateFilter.forPredicate(BlockPredicate.anyOf(BlockPredicate.matchesBlock(BYGBlocks.THERIUM_BLOCK, new BlockPos(0, -1, 0)))))))
                .build()
        ));


    public static final ConfiguredFeature<?, ?> END_LAKE = createConfiguredFeature("large_end_lake", BYGFeatures.LARGE_LAKE.configured(
        new LargeLakeFeatureConfig(15, 22, 7, 12, SimpleStateProvider.simple(Blocks.END_STONE), SimpleStateProvider.simple(Blocks.END_STONE),
            List.of(),
            List.of(),
            List.of()
        )
    ));

    public static final ConfiguredFeature<?, ?> HANGING_THERIUM_LANTERNS = createConfiguredFeature("hanging_therium_lanterns", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.ETHER_STONE).setBlock(Blocks.CHAIN.defaultBlockState()).setEndBlock(BYGBlocks.THERIUM_LANTERN.defaultBlockState().setValue(LanternBlock.HANGING, true)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(BYGBlocks.ETHER_STONE)).build()));

    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND1 = createConfiguredFeature("shattered_floating_island1", BYGFeatures.SHATTERED_FLOATING_ISLAND1.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build()));
    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND2 = createConfiguredFeature("shattered_floating_island2", BYGFeatures.SHATTERED_FLOATING_ISLAND2.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build()));
    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND3 = createConfiguredFeature("shattered_floating_island3", BYGFeatures.SHATTERED_FLOATING_ISLAND3.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(11).setMaxRadius(13).build()));
    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND4 = createConfiguredFeature("shattered_floating_island4", BYGFeatures.SHATTERED_FLOATING_ISLAND4.configured(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BYGBlocks.ETHER_STONE.defaultBlockState(), 45))).setMinRadius(13).setMaxRadius(17).build()));

    public static final PlacedFeature ISLAND_DEPOSIT = THERIUM_CRYSTAL_DEPOSIT.placed(RarityFilter.onAverageOnceEvery(5), PlacementUtils.HEIGHTMAP);

    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND1 = createConfiguredFeature("floating_island1",
        BYGFeatures.FLOATING_ISLAND1.configured(
            new FloatingIslandConfig.Builder()
                .setTopBlock(BYGBlocks.VERMILION_SCULK)
                .setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                    .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 20))
                )
                .setMinRadius(11)
                .setMaxRadius(13)
                .addFeatures(() -> ISLAND_DEPOSIT)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND2 = createConfiguredFeature("floating_island2",
        BYGFeatures.FLOATING_ISLAND2.configured(
            new FloatingIslandConfig.Builder()
                .setTopBlock(BYGBlocks.VERMILION_SCULK)
                .setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                    .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 20))
                )
                .setMinRadius(11)
                .setMaxRadius(13)
                .addFeatures(() -> ISLAND_DEPOSIT)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND3 = createConfiguredFeature("floating_island3",
        BYGFeatures.FLOATING_ISLAND3.configured(
            new FloatingIslandConfig.Builder()
                .setTopBlock(BYGBlocks.VERMILION_SCULK)
                .setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                    .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 20))
                )
                .setMinRadius(11)
                .setMaxRadius(13)
                .addFeatures(() -> ISLAND_DEPOSIT)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND4 = createConfiguredFeature("floating_island4",
        BYGFeatures.FLOATING_ISLAND4.configured(
            new FloatingIslandConfig.Builder()
                .setTopBlock(BYGBlocks.VERMILION_SCULK)
                .setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                    .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 20))
                )
                .setMinRadius(13)
                .setMaxRadius(17)
                .addFeatures(() -> ISLAND_DEPOSIT)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND5 = createConfiguredFeature("floating_island5",
        BYGFeatures.FLOATING_ISLAND5.configured(
            new FloatingIslandConfig.Builder()
                .setTopBlock(BYGBlocks.VERMILION_SCULK)
                .setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                    .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 20))
                )
                .setMinRadius(13)
                .setMaxRadius(17)
                .addFeatures(() -> ISLAND_DEPOSIT)
                .build()
        ));


    public static final ConfiguredFeature<?, ?> ISLANDS = createConfiguredFeature("floating_islands", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
         new WeightedPlacedFeature(FLOATING_ISLAND1.placed(), 0.25F),
         new WeightedPlacedFeature(FLOATING_ISLAND2.placed(), 0.25F),
         new WeightedPlacedFeature(FLOATING_ISLAND3.placed(), 0.25F)),
         FLOATING_ISLAND5.placed())
    ));
}