package potionstudios.byg.common.world.feature.features.nether;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createSolidDownAndAirAllAroundFilter;

public class BYGNetherFeatures {

    public static final RuleTest BRIMSTONE = new BlockMatchTest(BYGBlocks.BRIMSTONE);

    public static final ConfiguredFeature<?, ?> BRIMSTONE_VOLCANO = createConfiguredFeature("brimstone_volcano", BYGFeatures.VOLCANO.configured(new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.BRIMSTONE))));

    public static final ConfiguredFeature<?, ?> ORE_ANTHRACITE = createConfiguredFeature("ore_anthracite", Feature.ORE.configured(new OreConfiguration(BRIMSTONE, BYGBlocks.ANTHRACITE_ORE.defaultBlockState(), 10)));
    public static final ConfiguredFeature<?, ?> ORE_GOLD_BRIMSTONE = createConfiguredFeature("ore_gold_brimstone", Feature.ORE.configured(new OreConfiguration(BRIMSTONE, BYGBlocks.BRIMSTONE_NETHER_GOLD_ORE.defaultBlockState(), 10)));
    public static final ConfiguredFeature<?, ?> ORE_QUARTZ_BRIMSTONE = createConfiguredFeature("ore_quartz_brimstone", Feature.ORE.configured(new OreConfiguration(BRIMSTONE, BYGBlocks.BRIMSTONE_NETHER_QUARTZ_ORE.defaultBlockState(), 10)));
    public static final ConfiguredFeature<?, ?> BRIMSTONE_PILLARS = createConfiguredFeature("brimstone_pillars", BYGFeatures.PILLARS.configured(new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.BRIMSTONE))));
    public static final ConfiguredFeature<?, ?> BORIC_FIRE_PATCH = createConfiguredFeature("boric_fire_patch", Feature.RANDOM_PATCH.configured(
        new RandomPatchConfiguration(24, 4, 7,
            () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.BORIC_FIRE)
            )).placed(createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlock(BYGBlocks.BRIMSTONE, BlockPos.ZERO.relative(Direction.DOWN)))))
    ));
}
