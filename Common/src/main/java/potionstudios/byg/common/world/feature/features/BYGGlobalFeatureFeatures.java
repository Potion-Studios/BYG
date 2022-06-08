package potionstudios.byg.common.world.feature.features;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import potionstudios.byg.common.block.BYGBlocks;

import static net.minecraft.data.worldgen.features.OreFeatures.NATURAL_STONE;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.CONFIGURED_FEATURES;

import java.util.function.Supplier;

public class BYGGlobalFeatureFeatures {

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SOAPSTONE = createConfiguredFeature("ore_soapstone", () -> Feature.ORE, () -> new OreConfiguration(NATURAL_STONE, BYGBlocks.SOAPSTONE.defaultBlockState(), 64));

    public static void loadClass() {
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeature(String id, Supplier<? extends F> feature, Supplier<? extends FC> config) {
        return CONFIGURED_FEATURES.<ConfiguredFeature<FC, ?>>register(id, () -> new ConfiguredFeature<>(feature.get(), config.get())).asHolder();
    }
}