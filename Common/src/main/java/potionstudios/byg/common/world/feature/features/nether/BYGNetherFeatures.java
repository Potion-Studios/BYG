package potionstudios.byg.common.world.feature.features.nether;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
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
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.config.QuartzSpikeConfig;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;

import java.util.List;
import java.util.function.Supplier;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;

public class BYGNetherFeatures {


    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_CRYSTAL = createPatchConfiguredFeatureWithBlock("quartz_crystal", BYGBlocks.QUARTZ_CRYSTAL, 15);


    public static final Supplier<RuleTest> BRIMSTONE = () -> new BlockMatchTest(BYGBlocks.BRIMSTONE.get());
    public static final ResourceKey<ConfiguredFeature<?, ?>> BRIMSTONE_VOLCANO = createConfiguredFeature("brimstone_volcano", BYGFeatures.VOLCANO, () -> new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.BRIMSTONE.get())));
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_COLUMNS = createConfiguredFeature("quartz_columns", BYGFeatures.QUARTZ_COLUMNS, () -> new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 3)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_SPIKE = createConfiguredFeature("quartz_spike", BYGFeatures.QUARTZ_SPIKES, () -> new QuartzSpikeConfig.Builder().setBlock(BYGBlocks.QUARTZITE_SAND.get()).build());

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ANTHRACITE = createConfiguredFeature("ore_anthracite", () -> Feature.ORE, () -> new OreConfiguration(BRIMSTONE.get(), BYGBlocks.ANTHRACITE_ORE.defaultBlockState(), 10));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GOLD_BRIMSTONE = createConfiguredFeature("ore_gold_brimstone", () -> Feature.ORE, () -> new OreConfiguration(BRIMSTONE.get(), BYGBlocks.BRIMSTONE_NETHER_GOLD_ORE.defaultBlockState(), 10));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_QUARTZ_BRIMSTONE = createConfiguredFeature("ore_quartz_brimstone", () -> Feature.ORE, () -> new OreConfiguration(BRIMSTONE.get(), BYGBlocks.BRIMSTONE_NETHER_QUARTZ_ORE.defaultBlockState(), 10));
    public static final ResourceKey<ConfiguredFeature<?, ?>> BRIMSTONE_PILLARS = createConfiguredFeature("brimstone_pillars", BYGFeatures.PILLARS, () -> new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.BRIMSTONE.get())));
    public static final ResourceKey<ConfiguredFeature<?, ?>> BORIC_FIRE_PATCH = createConfiguredFeature("boric_fire_patch", () -> Feature.RANDOM_PATCH, () ->
            new RandomPatchConfiguration(24, 4, 7,
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.BORIC_FIRE.get()))),
                            createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlocks(BlockPos.ZERO.relative(Direction.DOWN), BYGBlocks.BRIMSTONE.get()))))
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_SOIL_PILLARS = createConfiguredFeature("soul_soil_pillars", BYGFeatures.PILLARS, () -> new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.WARPED_SOUL_SOIL.defaultBlockState())));
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGMA_PILLARS = createConfiguredFeature("magma_pillars", BYGFeatures.PILLARS, () -> new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.MAGMATIC_STONE.defaultBlockState())));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SYTHIAN_FUNGUS_PILLARS = createConfiguredFeature("sythian_fungus_pillars", BYGFeatures.PILLARS, () -> new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGWoodTypes.SYTHIAN.wood().defaultBlockState(), 9).add(BYGWoodTypes.SYTHIAN.wood().defaultBlockState(), 1))));


    public static final ResourceKey<ConfiguredFeature<?, ?>> WAILING_PILLAR = createConfiguredFeature("wailing_pillar1", BYGFeatures.WAILING_PILLAR1, () -> new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.BASALT.defaultBlockState(), 8).add(Blocks.POLISHED_BASALT.defaultBlockState(), 2))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 4).add(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3).add(Blocks.BLACKSTONE.defaultBlockState(), 2).add(BYGBlocks.DUSTED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3))).setMaxHeight(30).setMinHeight(22).build());

    public static final ResourceKey<ConfiguredFeature<?, ?>> NYLIUM_SOUL_PATCH_FIRE = createConfiguredFeature("nylium_soul_patch_fire", () -> Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SOUL_FIRE)), List.of(BYGBlocks.WARPED_SOUL_SOIL.get(), BYGBlocks.WARPED_SOUL_SAND.get())));
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGMA_PATCH_FIRE = createConfiguredFeature("magma_patch_fire", () -> Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.FIRE)), List.of(BYGBlocks.MAGMATIC_STONE.get())));
    public static void loadClass() {
    }
}
