package voronoiaoc.byg.core.byglists;

import com.google.common.collect.ImmutableList;
import net.minecraft.class_5458;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureConfig;

public class ConfiguredFeaturesList {
   public static final ConfiguredFeature<?, ?> RANDOM_JACARANDATREE = Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
           BYGFeatureList.JACARANDA_TREE2.configure(FeatureConfig.DEFAULT).withChance(0.3F),
           BYGFeatureList.INDIGOJACARANDA_TREE2.configure(FeatureConfig.DEFAULT).withChance(0.3F),
           BYGFeatureList.INDIGOJACARANDA_TREE.configure(FeatureConfig.DEFAULT).withChance(0.3F)),
           BYGFeatureList.JACARANDA_TREE.configure(FeatureConfig.DEFAULT))).method_30374(Decorator.COUNT_EXTRA.configure(
           new CountExtraChanceDecoratorConfig(45, 0.1F, -15)));



    public static class RegisterConfiguredFeatures {

        public static void registerConfiguredFeatures() {

        }






    public static void registerConfiguredFeature(ConfiguredFeature<?, ?> configuredFeature, String registryName) {
            Registry.register(class_5458.field_25929, registryName, configuredFeature);
        }
    }
}
