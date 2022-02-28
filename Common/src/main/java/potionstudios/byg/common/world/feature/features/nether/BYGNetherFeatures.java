package potionstudios.byg.common.world.feature.features.nether;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;

public class BYGNetherFeatures {


    public static final ConfiguredFeature<?, ?> SUBZERO_ASH_BLOCK = createPatchConfiguredFeature("subzero_ash_block", BYGBlocks.SUBZERO_ASH_BLOCK, 15);
    public static final ConfiguredFeature<?, ?> SUBZERO_ASH = createPatchConfiguredFeature("subzero_ash", BYGBlocks.SUBZERO_ASH, 15);


    public static final RuleTest BRIMSTONE = new BlockMatchTest(BYGBlocks.BRIMSTONE);
    public static final RuleTest BLUE_NETHERRACK = new BlockMatchTest(BYGBlocks.BLUE_NETHERRACK);

    public static final ConfiguredFeature<?, ?> BRIMSTONE_VOLCANO = createConfiguredFeature("brimstone_volcano", BYGFeatures.VOLCANO.configured(new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.BRIMSTONE))));

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

    public static final ConfiguredFeature<?, ?> SUBZERO_ASHES = createConfiguredFeature("subzero_ashes", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(SUBZERO_ASH.placed(), 0.6F)),
        SUBZERO_ASH_BLOCK.placed())));

}
