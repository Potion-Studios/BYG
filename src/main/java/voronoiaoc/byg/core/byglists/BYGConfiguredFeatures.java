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

public class BYGConfiguredFeatures {
    /***********************************************************Configured Features********************************************************/
    public static final ConfiguredFeature<?, ?> ACACIA_TREE1 = registerConfiguredFeature("acacia_tree1", BYGFeatureList.ACACIA_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ANCIENT_TREE1 = registerConfiguredFeature("ancient_tree1", BYGFeatureList.ANCIENT_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ANCIENT_TREE2 = registerConfiguredFeature("ancient_tree2", BYGFeatureList.ANCIENT_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ANCIENT_TREE3 = registerConfiguredFeature("ancient_tree3", BYGFeatureList.ANCIENT_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> ASPEN_SHRUB1 = registerConfiguredFeature("aspen_shrub1", BYGFeatureList.ASPEN_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ASPEN_SHRUB2 = registerConfiguredFeature("aspen_shrub2", BYGFeatureList.ASPEN_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ASPEN_TREE1 = registerConfiguredFeature("aspen_tree1", BYGFeatureList.ASPEN_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ASPEN_TREE2 = registerConfiguredFeature("aspen_tree2", BYGFeatureList.ASPEN_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ASPEN_TREE3 = registerConfiguredFeature("aspen_tree3", BYGFeatureList.ASPEN_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> BAOBAB_TREE1 = registerConfiguredFeature("baobab_tree1", BYGFeatureList.BAOBAB_TREE1.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> BIRCH_BROWN_TREE1 = registerConfiguredFeature("brown_birch_tree1", BYGFeatureList.BIRCH_BROWN_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BIRCH_ORANGE_TREE1 = registerConfiguredFeature("orange_birch_tree1", BYGFeatureList.BIRCH_ORANGE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BIRCH_RED_TREE1 = registerConfiguredFeature("red_birch_tree1", BYGFeatureList.BIRCH_RED_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BIRCH_YELLOW_TREE1 = registerConfiguredFeature("yellow_birch_tree1", BYGFeatureList.BIRCH_YELLOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> BLUFF_TREE1 = registerConfiguredFeature("bluff_tree1", BYGFeatureList.BLUFF_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BLUFF_TREE2 = registerConfiguredFeature("bluff_tree2", BYGFeatureList.BLUFF_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BLUFF_TREE3 = registerConfiguredFeature("bluff_tree3", BYGFeatureList.BLUFF_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> BOREAL_TREE1 = registerConfiguredFeature("boreal_tree1", BYGFeatureList.BOREAL_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> BOREAL_TREE2 = registerConfiguredFeature("boreal_tree2", BYGFeatureList.BOREAL_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> CHERRY_PINK_TREE1 = registerConfiguredFeature("pink_cherry_tree1", BYGFeatureList.CHERRY_PINK_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CHERRY_PINK_TREE2 = registerConfiguredFeature("pink_cherry_tree2", BYGFeatureList.CHERRY_PINK_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CHERRY_WHITE_TREE1 = registerConfiguredFeature("white_cherry_tree1", BYGFeatureList.CHERRY_WHITE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CHERRY_WHITE_TREE2 = registerConfiguredFeature("white_cherry_tree2", BYGFeatureList.CHERRY_WHITE_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> CIKA_TREE1 = registerConfiguredFeature("cika_tree1", BYGFeatureList.CIKA_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CIKA_TREE2 = registerConfiguredFeature("cika_tree2", BYGFeatureList.CIKA_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CIKA_TREE3 = registerConfiguredFeature("cika_tree3", BYGFeatureList.CIKA_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> CONIFER_TREE1 = registerConfiguredFeature("conifer_tree1", BYGFeatureList.CONIFER_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE2 = registerConfiguredFeature("conifer_tree2", BYGFeatureList.CONIFER_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE3 = registerConfiguredFeature("conifer_tree3", BYGFeatureList.CONIFER_TREE3.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE4 = registerConfiguredFeature("conifer_tree4", BYGFeatureList.CONIFER_TREE4.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE5 = registerConfiguredFeature("conifer_tree5", BYGFeatureList.CONIFER_TREE5.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE6 = registerConfiguredFeature("conifer_tree6", BYGFeatureList.CONIFER_TREE6.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE7 = registerConfiguredFeature("conifer_tree7", BYGFeatureList.CONIFER_TREE7.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CONIFER_TREE8 = registerConfiguredFeature("conifer_tree8", BYGFeatureList.CONIFER_TREE8.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> CYPRESS_TREE1 = registerConfiguredFeature("cypress_tree1", BYGFeatureList.CYPRESS_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CYPRESS_TREE2 = registerConfiguredFeature("cypress_tree2", BYGFeatureList.CYPRESS_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> CYPRESS_TREE3 = registerConfiguredFeature("cypress_tree3", BYGFeatureList.CYPRESS_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> DEAD_HAZEL_TREE1 = registerConfiguredFeature("dead_hazel_tree1", BYGFeatureList.DEAD_HAZEL_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DEAD_HAZEL_TREE2 = registerConfiguredFeature("dead_hazel_tree2", BYGFeatureList.DEAD_HAZEL_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DEAD_HAZEL_TREE3 = registerConfiguredFeature("dead_hazel_tree3", BYGFeatureList.DEAD_HAZEL_TREE3.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DEAD_HAZEL_TREE4 = registerConfiguredFeature("dead_hazel_tree4", BYGFeatureList.DEAD_HAZEL_TREE4.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> DECIDUOUS_TREE1 = registerConfiguredFeature("deciduous_tree1", BYGFeatureList.DECIDUOUS_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DECIDUOUS_BROWN_TREE1 = registerConfiguredFeature("brown_deciduous_tree1", BYGFeatureList.DECIDUOUS_BROWN_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DECIDUOUS_ORANGE_TREE1 = registerConfiguredFeature("orange_deciduous_tree1", BYGFeatureList.DECIDUOUS_ORANGE_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DECIDUOUS_YELLOW_TREE1 = registerConfiguredFeature("yellow_deciduous_tree1", BYGFeatureList.DECIDUOUS_YELLOW_TREE.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> DECIDUOUS_RED_TREE1 = registerConfiguredFeature("orange_deciduous_tree1", BYGFeatureList.DECIDUOUS_RED_TREE.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> DECIDUOUS_SEASONAL_SHRUB = registerConfiguredFeature("seasonal_deciduous_shrub", BYGFeatureList.DECIDUOUS_SEASONAL_SHRUBS.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> EBONY_TREE1 = registerConfiguredFeature("ebony_tree1", BYGFeatureList.EBONY_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> EBONY_TREE2 = registerConfiguredFeature("ebony_tree2", BYGFeatureList.EBONY_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> ENCHANTED_BLUE_TREE1 = registerConfiguredFeature("blue_enchanted_tree1", BYGFeatureList.ENCHANTED_BLUE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_BLUE_TREE2 = registerConfiguredFeature("blue_enchanted_tree2", BYGFeatureList.ENCHANTED_BLUE_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_BLUE_TREE3 = registerConfiguredFeature("blue_enchanted_tree3", BYGFeatureList.ENCHANTED_BLUE_TREE3.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_GREEN_TREE1 = registerConfiguredFeature("green_enchanted_tree1", BYGFeatureList.ENCHANTED_GREEN_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_GREEN_TREE2 = registerConfiguredFeature("green_enchanted_tree2", BYGFeatureList.ENCHANTED_GREEN_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_GREEN_TREE3 = registerConfiguredFeature("green_enchanted_tree3", BYGFeatureList.ENCHANTED_GREEN_TREE3.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> ENCHANTED_BLUE_GROVE_TREE1 = registerConfiguredFeature("blue_enchanted_grove_tree1", BYGFeatureList.ENCHANTED_BLUE_GROVE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> ENCHANTED_GREEN_GROVE_TREE1 = registerConfiguredFeature("green_enchanted_grove_tree1", BYGFeatureList.ENCHANTED_GREEN_GROVE_TREE1.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> HOLLY_TREE1 = registerConfiguredFeature("holly_tree1", BYGFeatureList.HOLLY_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> HOLLY_TREE2 = registerConfiguredFeature("holly_tree2", BYGFeatureList.HOLLY_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> HOLLY_TREE3 = registerConfiguredFeature("holly_tree3", BYGFeatureList.HOLLY_TREE3.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> HOLLY_TREE4 = registerConfiguredFeature("holly_tree4", BYGFeatureList.HOLLY_TREE4.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> JACARANDA_TREE1 = registerConfiguredFeature("jacaranda_tree1", BYGFeatureList.JACARANDA_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> JACARANDA_TREE2 = registerConfiguredFeature("jacaranda_tree2", BYGFeatureList.JACARANDA_TREE2.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> INDIGO_JACARANDA_TREE1 = registerConfiguredFeature("indigo_jacaranda_tree1", BYGFeatureList.JACARANDA_INDIGO_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> INDIGO_JACARANDA_TREE2 = registerConfiguredFeature("indigo_jacaranda_tree2", BYGFeatureList.JACARANDA_INDIGO_TREE2.configure(DecoratedFeatureConfig.DEFAULT));

    public static final ConfiguredFeature<?, ?> JOSHUA_TREE1 = registerConfiguredFeature("joshua_tree1", BYGFeatureList.JOSHUA_TREE1.configure(DecoratedFeatureConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> JOSHUA_TREE2 = registerConfiguredFeature("joshua_tree2", BYGFeatureList.JOSHUA_TREE2.configure(DecoratedFeatureConfig.DEFAULT));


    /***********************************************************Random Selectors***********************************************************/
    public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_TREE = registerConfiguredFeature("rs_jacaranda", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BYGFeatureList.JACARANDA_TREE2.configure(FeatureConfig.DEFAULT).withChance(0.3F),
            BYGFeatureList.JACARANDA_INDIGO_TREE2.configure(FeatureConfig.DEFAULT).withChance(0.3F),
            BYGFeatureList.JACARANDA_INDIGO_TREE1.configure(FeatureConfig.DEFAULT).withChance(0.3F)),
            BYGFeatureList.JACARANDA_TREE1.configure(FeatureConfig.DEFAULT))).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(45, 0.1F, -15))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUE_TAIGA_TREE = registerConfiguredFeature("rs_blue_taiga", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
           BYGFeatureList.SMALLBLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
           Feature.TREE.configure(BYGFeatureConfigs.BLUEPINETREE_CONFIG).withChance(0.1F),
           Feature.TREE.configure(BYGFeatureConfigs.BLUESPRUCETREE_CONFIG).withChance(0.1F),
           Feature.TREE.configure(ConfiguredFeatures.PINE.config).withChance(0.5F),
           Feature.TREE.configure(ConfiguredFeatures.SPRUCE.config).withChance(0.5F),
           BYGFeatureList.TALLBLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F)),
           BYGFeatureList.BLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT))).method_30374(Decorator.COUNT_EXTRA.configure(
           new CountExtraChanceDecoratorConfig(20, 0.1F, -8))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_TREE = registerConfiguredFeature("rs_boreal", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BYGFeatureList.BOREAL_TREE1.configure(FeatureConfig.DEFAULT).withChance(0.5F)),
            BYGFeatureList.BOREAL_TREE2.configure(FeatureConfig.DEFAULT))).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(55, 0.5F, -20))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_BOERAL_TREE = registerConfiguredFeature("rs_sparse_boreal", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
            BYGFeatureList.BOREAL_TREE1.configure(FeatureConfig.DEFAULT).withChance(0.5F)),
            BYGFeatureList.BOREAL_TREE2.configure(FeatureConfig.DEFAULT))).method_30374(Decorator.COUNT_EXTRA.configure(
            new CountExtraChanceDecoratorConfig(0, 0.1F, 2))));

    public static ConfiguredFeature<?, ?> registerConfiguredFeature(String registryName, ConfiguredFeature<?, ?> configuredFeature) {
       Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(BYG.MODID, registryName), configuredFeature);
       return configuredFeature;
   }
}
