package voronoiaoc.byg.core.byglists;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatureConfigs;

public class ConfiguredFeaturesList {
   public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_TREE = registerConfiguredFeature("rs_jacaranda_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
           BYGFeatureList.JACARANDA_TREE2.configure(FeatureConfig.DEFAULT).withChance(0.3F),
           BYGFeatureList.INDIGOJACARANDA_TREE2.configure(FeatureConfig.DEFAULT).withChance(0.3F),
           BYGFeatureList.INDIGOJACARANDA_TREE.configure(FeatureConfig.DEFAULT).withChance(0.3F)),
           BYGFeatureList.JACARANDA_TREE.configure(FeatureConfig.DEFAULT))).method_30374(Decorator.COUNT_EXTRA.configure(
           new CountExtraChanceDecoratorConfig(45, 0.1F, -15))));

   public static final ConfiguredFeature<?, ?> RANDOM_BLUE_TAIGA_TREE = registerConfiguredFeature("rs_blue_taiga_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
           BYGFeatureList.SMALLBLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
           Feature.TREE.configure(BYGFeatureConfigs.BLUEPINETREE_CONFIG).withChance(0.1F),
           Feature.TREE.configure(BYGFeatureConfigs.BLUESPRUCETREE_CONFIG).withChance(0.1F),
           Feature.TREE.configure(ConfiguredFeatures.PINE.config).withChance(0.5F),
           Feature.TREE.configure(ConfiguredFeatures.SPRUCE.config).withChance(0.5F),
           BYGFeatureList.TALLBLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F)),
           BYGFeatureList.BLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT))).method_30374(Decorator.COUNT_EXTRA.configure(
           new CountExtraChanceDecoratorConfig(20, 0.1F, -8))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_TREE = registerConfiguredFeature("rs_boreal_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BYGFeatureList.BOREAL_TREE.configure(FeatureConfig.DEFAULT).withChance(0.5F)),
            BYGFeatureList.BOREAL_TREE2.configure(FeatureConfig.DEFAULT))).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(55, 0.5F, -20))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_BOERAL_TREE = registerConfiguredFeature("rs_sparse_boreal_tree", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BYGFeatureList.BOREAL_TREE.configure(FeatureConfig.DEFAULT).withChance(0.5F)),
            BYGFeatureList.BOREAL_TREE2.configure(FeatureConfig.DEFAULT))).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> CONIFER_TREE1 = registerConfiguredFeature("conifer_tree1", BYGFeatureList.CONIFER_TREE1.configure(DecoratedFeatureConfig.DEFAULT).method_30374(Decorator.COUNT_EXTRA.configure(new CountExtraChanceDecoratorConfig(25, 0.1F, 1))));


    public static ConfiguredFeature<?, ?> registerConfiguredFeature(String registryName, ConfiguredFeature<?, ?> configuredFeature) {
       Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(BYG.MODID, registryName), configuredFeature);
       return configuredFeature;
   }
}
