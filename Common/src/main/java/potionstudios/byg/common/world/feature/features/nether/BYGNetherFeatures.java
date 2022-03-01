package potionstudios.byg.common.world.feature.features.nether;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
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
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.config.HangingColumnWithBaseConfig;
import potionstudios.byg.common.world.feature.config.QuartzSpikeConfig;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;

import java.util.List;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;

public class BYGNetherFeatures {


    public static final ConfiguredFeature<?, ?> SUBZERO_ASH_BLOCK = createPatchConfiguredFeature("subzero_ash_block", BYGBlocks.SUBZERO_ASH_BLOCK, 15);
    public static final ConfiguredFeature<?, ?> SUBZERO_ASH = createPatchConfiguredFeature("subzero_ash", BYGBlocks.SUBZERO_ASH, 15);
    public static final ConfiguredFeature<?, ?> QUARTZ_CRYSTAL = createPatchConfiguredFeature("quartz_crystal", BYGBlocks.QUARTZ_CRYSTAL, 15);


    public static final RuleTest BRIMSTONE = new BlockMatchTest(BYGBlocks.BRIMSTONE);
    public static final RuleTest BLUE_NETHERRACK = new BlockMatchTest(BYGBlocks.BLUE_NETHERRACK);

    public static final ConfiguredFeature<?, ?> BRIMSTONE_VOLCANO = createConfiguredFeature("brimstone_volcano", BYGFeatures.VOLCANO.configured(new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.BRIMSTONE))));
    public static final ConfiguredFeature<?, ?> QUARTZ_COLUMNS = createConfiguredFeature("quartz_columns", BYGFeatures.QUARTZ_COLUMNS.configured(new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 3))));
    public static final ConfiguredFeature<?, ?> QUARTZ_SPIKE = createConfiguredFeature("quartz_spike", BYGFeatures.QUARTZ_SPIKES.configured(new QuartzSpikeConfig.Builder().setBlock(BYGBlocks.QUARTZITE_SAND).build()));
    public static final ConfiguredFeature<?, ?> ORE_ANTHRACITE = createConfiguredFeature("ore_anthracite", Feature.ORE.configured(new OreConfiguration(BRIMSTONE, BYGBlocks.ANTHRACITE_ORE.defaultBlockState(), 10)));
    public static final ConfiguredFeature<?, ?> ORE_GOLD_BRIMSTONE = createConfiguredFeature("ore_gold_brimstone", Feature.ORE.configured(new OreConfiguration(BRIMSTONE, BYGBlocks.BRIMSTONE_NETHER_GOLD_ORE.defaultBlockState(), 10)));
    public static final ConfiguredFeature<?, ?> ORE_QUARTZ_BRIMSTONE = createConfiguredFeature("ore_quartz_brimstone", Feature.ORE.configured(new OreConfiguration(BRIMSTONE, BYGBlocks.BRIMSTONE_NETHER_QUARTZ_ORE.defaultBlockState(), 10)));
    public static final ConfiguredFeature<?, ?> ORE_GOLD_BLUE_NETHERRACK = createConfiguredFeature("ore_gold_blue_netherrack", Feature.ORE.configured(new OreConfiguration(BLUE_NETHERRACK, BYGBlocks.BLUE_NETHER_GOLD_ORE.defaultBlockState(), 10)));
    public static final ConfiguredFeature<?, ?> ORE_QUARTZ_BLUE_NETHERRACK = createConfiguredFeature("ore_quartz_blue_netherrack", Feature.ORE.configured(new OreConfiguration(BLUE_NETHERRACK, BYGBlocks.BLUE_NETHER_GOLD_ORE.defaultBlockState(), 10)));
    public static final ConfiguredFeature<?, ?> BRIMSTONE_PILLARS = createConfiguredFeature("brimstone_pillars", BYGFeatures.PILLARS.configured(new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.BRIMSTONE))));
    public static final ConfiguredFeature<?, ?> BORIC_FIRE_PATCH = createConfiguredFeature("boric_fire_patch", Feature.RANDOM_PATCH.configured(
        new RandomPatchConfiguration(24, 4, 7,
            () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.BORIC_FIRE)
            )).placed(createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlock(BYGBlocks.BRIMSTONE, BlockPos.ZERO.relative(Direction.DOWN)))))
    ));

    public static final ConfiguredFeature<?, ?> SOUL_SOIL_PILLARS = createConfiguredFeature("soul_soil_pillars", BYGFeatures.PILLARS.configured(new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState()))));
    public static final ConfiguredFeature<?, ?> FROST_MAGMA_PILLARS = createConfiguredFeature("frost_magma_pillars", BYGFeatures.PILLARS.configured((new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.FROST_MAGMA.defaultBlockState())))));
    public static final ConfiguredFeature<?, ?> MAGMA_PILLARS = createConfiguredFeature("magma_pillars", BYGFeatures.PILLARS.configured((new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.MAGMATIC_STONE.defaultBlockState())))));
    public static final ConfiguredFeature<?, ?> MOSSY_NETHERRACK_PILLARS = createConfiguredFeature("mossy_netherrack_pillars", BYGFeatures.PILLARS.configured(new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.MOSSY_NETHERRACK.defaultBlockState()))));
    public static final ConfiguredFeature<?, ?> HANGING_LANTERNS = createConfiguredFeature("hanging_lanterns", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SCORIA_STONE).setBlock(Blocks.CAVE_AIR.defaultBlockState()).setEndBlock(BYGBlocks.WAILING_BELL_BLOSSOM.defaultBlockState()).setMinLength(1).setMaxLength(4).setWhitelist(ImmutableList.of(BYGBlocks.SCORIA_STONE)).build()));
    public static final ConfiguredFeature<?, ?> SYTHIAN_FUNGUS_PILLARS = createConfiguredFeature("sythian_fungus_pillars", BYGFeatures.PILLARS.configured(new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.SYTHIAN_HYPHAE.defaultBlockState(), 9).add(BYGBlocks.SYTHIAN_HYPHAE.defaultBlockState(), 1)))));
    public static final ConfiguredFeature<?, ?> HANGING_CHAINS = createConfiguredFeature("hanging_chains", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SCORIA_STONE).setBlock(Blocks.CHAIN.defaultBlockState()).setEndBlock(Blocks.CHAIN.defaultBlockState()).setMinLength(8).setMaxLength(16).setWhitelist(ImmutableList.of(BYGBlocks.SCORIA_STONE)).build()));
    public static final ConfiguredFeature<?, ?> SUBZERO_ASHES = createConfiguredFeature("subzero_ashes", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(SUBZERO_ASH.placed(), 0.6F)),
        SUBZERO_ASH_BLOCK.placed())));


    public static final ConfiguredFeature<?, ?> WAILING_PILLAR = createConfiguredFeature("wailing_pillar1", BYGFeatures.WAILING_PILLAR1.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.BASALT.defaultBlockState(), 8).add(Blocks.POLISHED_BASALT.defaultBlockState(), 2))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 4).add(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3).add(Blocks.BLACKSTONE.defaultBlockState(), 2).add(BYGBlocks.DUSTED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3))).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<?, ?> NYLIUM_SOUL_PATCH_FIRE = createConfiguredFeature("nylium_soul_patch_fire", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SOUL_FIRE))), List.of(BYGBlocks.NYLIUM_SOUL_SOIL, BYGBlocks.NYLIUM_SOUL_SAND))));
    public static final ConfiguredFeature<?, ?> MAGMA_PATCH_FIRE = createConfiguredFeature("magma_patch_fire", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.FIRE))), List.of(BYGBlocks.MAGMATIC_STONE))));
}
