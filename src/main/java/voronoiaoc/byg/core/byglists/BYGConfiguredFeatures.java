package voronoiaoc.byg.core.byglists;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatureConfigs;

public class BYGConfiguredFeatures {

    public static ConfiguredFeature<?, ?> ALLIUM_BUSH = newConfiguredFeature("allium_bush", Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.ALLIUMBUSH_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_PINK_BUSH = newConfiguredFeature("pink_allium_bush", Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.PINKALLIUMBUSH_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_TALL_BUSH = newConfiguredFeature("tall_allium_bush", Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.TALL_ALLIUM_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_TALL_PINK_BUSH = newConfiguredFeature("tall_pink_allium_bush", Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.TALL_PINK_ALLIUM_CONFIG));


    public static final ConfiguredFeature<?, ?> RANDOM_ALLIUM_FLOWER = newConfiguredFeature("rs_allium_flower", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                ALLIUM_TALL_BUSH.withChance(0.25F),
                ALLIUM_TALL_PINK_BUSH.withChance(0.25F),
                ALLIUM_BUSH.withChance(0.25F)),
                ALLIUM_PINK_BUSH)).decorate(ConfiguredFeatures.Decorators.field_26166).repeat(50));


    public static ConfiguredFeature<?, ?> newConfiguredFeature(String registryName, ConfiguredFeature<?, ?> configuredFeature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(BYG.MODID, registryName), configuredFeature);
        return configuredFeature;
    }
}
