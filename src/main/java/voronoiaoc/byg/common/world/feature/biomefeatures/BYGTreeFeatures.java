package voronoiaoc.byg.common.world.feature.biomefeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import voronoiaoc.byg.core.byglists.BYGConfiguredFeatures;


public class BYGTreeFeatures {
    public static void addAncientTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ANCIENT_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.4F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ANCIENT_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.4F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ANCIENT_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.4F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(DefaultBiomeFeatures.DARK_OAK_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.5F, 5))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ANCIENT_TREE);
    }

    public static void addBlueTaigaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLUE_TAIGA_TREE);
    }

    public static void addBlackForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLACK_FOREST_TREE);
    }

    public static void addSparseBlackForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_BLACK_FOREST_TREE);
    }

    public static void addBorealTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BOREAL_TREE);
    }

    public static void addBorealSparseTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_BOREAL_TREE);
    }

    public static void addConiferousTrees(Biome biome) {
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(25, 0.1F, 1))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(25, 0.1F, 1))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(25, 0.1F, 1))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE4.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(25, 0.1F, 1))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE5.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(25, 0.1F, 1))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE6.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(25, 0.1F, 1))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE7.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(25, 0.1F, 1))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE8.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(25, 0.1F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CONIFER_TREE);
    }

    public static void addConiferousSparseTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE6.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CONIFER_SPARSE_TREE);

    }

    public static void addCypressTrees(Biome biome) {
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CYPRESS_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(0, 0.3F, 1))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CYPRESS_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(2, 0.3F, 2))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CYPRESS_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(2, 0.3F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CYPRESS_TREE);
    }

    public static void addDeciduousTrees(Biome biome) {
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.DECIDUOUS_TREE.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(18, 0.3F, -8))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(4, 0.2F, -3))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_TREE);
    }

    public static void addDeciduousSparseTrees(Biome biome) {
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.DECIDUOUS_TREE.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 2))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.08F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_SPARSE_TREE);
    }
    //TODO: Reconfigure
    public static void addRedwoodSparseTrees(Biome biome) {
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.REDWOOD_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.2F, 1))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.REDWOOD_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.REDWOOD_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.2F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_REDWOOD_SPARSE_TREE);
    }

    public static void addMapleTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MAPLE_TREE);
    }

    public static void addMapleSparseTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_MAPLE_TREE);
    }


    public static void addGiantBlueTaigaTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.BLUE_GIANT_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.BLUEMEGAPINETREE_CONFIG).withChance(0.1F)),
//                Feature.TREE.configure(BYGFeatureConfigs.BLUEMEGASPRUCETREE_CONFIG))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(10, 0.3F, 5))));
//
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.BLUE_SMALL_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.3F),
//                Feature.TREE.configure(BYGFeatureConfigs.BLUEPINETREE_CONFIG).withChance(0.3F),
//                Feature.TREE.configure(BYGFeatureConfigs.BLUESPRUCETREE_CONFIG).withChance(0.3F),
//                BYGFeatureList.BLUE_TALL_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F)),
//                BYGFeatureList.BLUE_SPRUCE_TREE.configure(FeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(20, 0.3F, 1))));
//
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                Feature.TREE.configure(ConfiguredFeatures.MEGA_SPRUCE.config).withChance(0.35F),
//                Feature.TREE.configure(ConfiguredFeatures.MEGA_PINE.config).withChance(0.35F),
//                Feature.TREE.configure(ConfiguredFeatures.PINE.config).withChance(0.33333334F)),
//                Feature.TREE.configure(ConfiguredFeatures.SPRUCE.config))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(20, 0.1F, 2))));
    }

    public static void addGiantSeasonalTaigaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GIANT_SEASONAL_TAIGA_TREE);
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_TAIGA_TREE);
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GIANT_SEASONAL_TAIGA_MISC_TREE);
    }

    public static void addRedOakForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RED_OAK_FOREST_TREE);
    }

    public static void addSparseRedOakForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RED_OAK_FOREST_SPARSE_TREE);
    }

    public static void addSeasonalBirchForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_BIRCH_FOREST_TREE);

    }

    public static void addSeasonalDeciduousTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.DECIDUOUS_SEASONAL_SHRUBS.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(4, 0.3F, -3))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_DECIDUOUS_TREE);
    }

    public static void addSparseSeasonalDeciduousTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_DECIDUOUS_SPARSE_TREE);
    }

    public static void addSeasonalForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_FOREST_TREE);
    }

    public static void addSeasonalTaigaTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.RED_SMALL_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//                BYGFeatureList.RED_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.2F),
//                BYGFeatureList.RED_TALL_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.05f),
//                Feature.TREE.configure(BYGFeatureConfigs.REDPINETREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.REDSPRUCETREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(PINE_TREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(SPRUCE_TREE_CONFIG).withChance(0.1F),
//                BYGFeatureList.ORANGE_SMALL_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//                BYGFeatureList.ORANGE_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.2F),
//                BYGFeatureList.ORANGE_TALL_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.05F),
//                Feature.TREE.configure(BYGFeatureConfigs.ORANGEPINETREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.ORANGESPRUCETREE_CONFIG).withChance(0.1F),
//                BYGFeatureList.YELLOW_SMALL_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//                BYGFeatureList.YELLOW_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//                BYGFeatureList.YELLOW_TALL_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.2F),
//                BYGFeatureList.YELLOW_SPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F)),
//                BYGFeatureList.YELLOW_SPRUCE_TREE.configure(FeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(5, 0.3F, 3))));

        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.PINE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.5F)),
//                BYGFeatureList.PINE_TREE2.configure(DecoratedFeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(1, 0.3F, 2))));

        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BOREAL_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.6F, -2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.6F, -2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.6F, -2))));
    }

    public static void addShrubs(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.1F, 1))));
    }

    public static void addTropJungleTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(BYGFeatureConfigs.MEGATROPJUNGLETREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.0F, 0))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.TROPICAL_TREE1.configure(FeatureConfig.DEFAULT).withChance(0.5F),
//                BYGFeatureList.RAINBOW_TREE1.configure(FeatureConfig.DEFAULT).withChance(0.15F),
//                Feature.TREE.configure(BYGFeatureConfigs.TROPGROUNDBUSH_CONFIG).withChance(0.15F)),
//                BYGFeatureList.TROPICAL_SHORT_TREE1.configure(FeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(65, 0.1F, 10))));

        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.VINES.configure(FeatureConfig.DEFAULT).method_30371().method_30375(50));
    }

    public static void addFungalTropJungleTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(BYGFeatureConfigs.MEGATROPJUNGLETREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.0F, 0))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.TROPICAL_TREE1.configure(FeatureConfig.DEFAULT).withChance(0.5F),
//                BYGFeatureList.RAINBOW_TREE1.configure(FeatureConfig.DEFAULT).withChance(0.15F),
//                Feature.TREE.configure(BYGFeatureConfigs.TROPGROUNDBUSH_CONFIG).withChance(0.15F)),
//                BYGFeatureList.TROPICAL_SHORT_TREE1.configure(FeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(45, 0.1F, 10))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_FUNGAL_RAINFOREST_TREE);

    }

    public static void addSparseTropJungleTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(BYGFeatureConfigs.MEGATROPJUNGLETREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.0F, 0))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.TROPICAL_TREE1.configure(FeatureConfig.DEFAULT).withChance(0.5F),
//                BYGFeatureList.RAINBOW_TREE1.configure(FeatureConfig.DEFAULT).withChance(0.15F),
//                Feature.TREE.configure(BYGFeatureConfigs.TROPGROUNDBUSH_CONFIG).withChance(0.15F)),
//                BYGFeatureList.TROPICAL_SHORT_TREE1.configure(FeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(0, 0.1F, 2))));

        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.VINES.configure(FeatureConfig.DEFAULT).method_30371().method_30375(50));
    }

    public static void addRainbowTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.5F, -4))));
    }

    public static void addCragRainbowTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_LARGE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.5F, 8))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(40, 0.5F, 8))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.BAMBOO.configure(new ProbabilityConfig(0.2F)).decorate(Decorator.COUNT_NOISE_BIASED.configure(new TopSolidHeightmapNoiseBiasedDecoratorConfig(160, 80.0D, 0.3D))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(BYGFeatureConfigs.TROPGROUNDBUSH_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.5F, 8))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CRAG_GARDEN_TREE);
    }

    public static void addCikaTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CIKA_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.4F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CIKA_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.4F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CIKA_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.4F, 1))));
    biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CIKA_TREE);
    }

    public static void addIslandRainbowTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.5F, 10))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.BAMBOO.configure(new ProbabilityConfig(0.05F)).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(64))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(4, 0.1F, -1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(LILY_PAD_CONFIG).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
    }

    public static void addSparseTree(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(Feature.TREE.configure(FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withChance(0.33333334F)), Feature.TREE.configure(OAK_TREE_WITH_MORE_BEEHIVES_CONFIG))).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.05F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
    }

    public static void addSpruceTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(PINE_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.3F, -5))));

    }

    public static void addSmallSpruceTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(SPRUCE_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.3F, 1))));
    }



    public static void addBluffTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BLUFF_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(7, 0.3F, -5))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BLUFF_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(7, 0.3F, -5))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BLUFF_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(7, 0.3F, -5))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE6.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 2))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.PINE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.5F)),
//                BYGFeatureList.PINE_TREE2.configure(DecoratedFeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(1, 0.3F, 2))));
    }

    public static void addDoverMTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(BYGFeatureConfigs.DOVERMEGASPRUCETREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.1F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(PINE_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.2F, -5))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PINE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 2))));

    }

    public static void addNorthernForestTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE8.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.3F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CONIFER_TREE6.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.3F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(BYGFeatureConfigs.DOVERMEGASPRUCETREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(15, 0.5F, 5))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(BYGFeatureConfigs.DOVERMEGASPRUCETREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(15, 0.5F, 5))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(PINE_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.3F, -5))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.PINE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.5F)),
//                BYGFeatureList.PINE_TREE2.configure(DecoratedFeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(6, 0.3F, 2))));
    }

    public static void addSkyrisTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SKYRIS_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.5F, 4))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SKYRIS_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.5F, 4))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SKYRIS_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.5F, 4))));

    }

    public static void addBaobabTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BAOBAB_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.8F, -1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(Feature.TREE.configure(ACACIA_TREE_CONFIG).withChance(0.8F)), Feature.TREE.configure(ACACIA_TREE_CONFIG))).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1F, 1))));
    }

    public static void addSavannaCanopyTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ACACIA_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.8F, -1))));
//        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ACACIA_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.8F, -1))));

    }

    public static void addRedwoodTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.REDWOOD_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.4F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.REDWOOD_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.4F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.REDWOOD_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.6F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.EBONY_BUSH1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.2F, 1))));
    }

    public static void addMeadowShrubs(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_MEADOW1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_MEADOW2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
    }

    public static void addMeadowTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MEADOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.5F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MEADOW_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.5F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MEADOW_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.5F, 2))));
    }

    public static void addGroveTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BOREAL_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 2))));

    }

    public static void addEnchantedGroveTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ENCHANTED_BLUE_GROVE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ENCHANTED_GREEN_GROVE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ENCHANTED_GROVE_TREE);

    }

    public static void addEnchantedTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.ENCHANTED_BLUE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.4F),
//                BYGFeatureList.ENCHANTED_BLUE_TREE2.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.4F),
//                BYGFeatureList.ENCHANTED_BLUE_TREE3.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.4F),
//                BYGFeatureList.ENCHANTED_GREEN_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.5F),
//                BYGFeatureList.ENCHANTED_GREEN_TREE2.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.5F)),
//                BYGFeatureList.ENCHANTED_GREEN_TREE3.configure(DecoratedFeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(25, 0.3F, 5))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ENCHANTED_TREE);


    }

    public static void addPumpkinPatches(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.5F, -2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
    }

    public static void addWitchPumpkinPatches(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.5F, -2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.5F, 1))));

    }

    public static void addMarshTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.8F, 8))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.8F, 8))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(SWAMP_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MARSH_TREE);

    }

    public static void addBayouVegetation(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.WILLOW_DEAD_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.1F),
//                BYGFeatureList.WILLOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.3F),
//                BYGFeatureList.WILLOW_TREE2.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.3F),
//                BYGFeatureList.WILLOW_TREE3.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.3F)),
//                BYGFeatureList.WILLOW_TREE4.configure(DecoratedFeatureConfig.DEFAULT))).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(
//                new CountExtraDecoratorConfig(8, 0.3F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BAYOU_TREE);

    }

    public static void addGlowshroomBayouVegetation(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.WILLOW_DEAD_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.1F),
//                BYGFeatureList.WILLOW_M_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.4F),
//                BYGFeatureList.WILLOW_M_TREE2.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.2F),
//                BYGFeatureList.WILLOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.25F),
//                BYGFeatureList.WILLOW_TREE2.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.25F),
//                BYGFeatureList.WILLOW_TREE3.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.25F)),
//                BYGFeatureList.WILLOW_TREE4.configure(DecoratedFeatureConfig.DEFAULT))).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(
//                new CountExtraDecoratorConfig(8, 0.3F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWSHROOM_BAYOU_TREE);

    }

    public static void addAspenTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.5F, -1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.5F, -1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.5F, -1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(6, 0.8F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(6, 0.8F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ASPEN_TREE);

    }

    public static void addSparseClearingAspenTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));

    }

    public static void addSparseAspenTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.5F, -2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.5F, -2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.5F, -2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(6, 0.8F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(6, 0.8F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ASPEN_TREE);

    }

    public static void addZelkovaTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ZELKOVA_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.8F, -5))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ZELKOVA_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.8F, -5))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ZELKOVA_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.8F, -5))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ZELKOVA_TREE);

    }

    public static void addSparseZelkovaTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ZELKOVA_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ZELKOVA_TREE);

    }

    public static void addPaloVerdeTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PALO_VERDE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PALO_VERDE_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PALO_VERDE_TREE);

    }

    public static void addJoshuaTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_JOSHUA_TREE);

    }

    public static void addBushes(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.8F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.8F, 2))));
    }

    public static void addRedRockCanyonVegetation(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CACTUS.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(8))));

    }

    public static void addPalmTree(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PALM_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.4F, 1))));
    }

    public static void addCherryTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.CHERRY_WHITE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.35F),
//                BYGFeatureList.CHERRY_WHITE_TREE2.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.35F),
//                BYGFeatureList.CHERRY_PINK_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.4F)),
//                BYGFeatureList.CHERRY_PINK_TREE2.configure(DecoratedFeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(8, 0.3F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CHERRY_TREE);

    }

    public static void addSparseCherryTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.CHERRY_WHITE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.5F),
//                BYGFeatureList.CHERRY_WHITE_TREE2.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.5F),
//                BYGFeatureList.CHERRY_PINK_TREE1.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.5F)),
//                BYGFeatureList.CHERRY_PINK_TREE2.configure(DecoratedFeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(0, 0.1F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_CHERRY_TREE);

    }

    public static void addDeadHazelTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.DEAD_HAZEL_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(8, 0.3F, 5))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.DEAD_HAZEL_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(8, 0.3F, 5))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.DEAD_HAZEL_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 4))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.DEAD_HAZEL_TREE4.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 4))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WITCH_HAZEL_TREE);

    }

    public static void addSparseDeadHazelTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.DEAD_HAZEL_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.DEAD_HAZEL_TREE4.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_WITCH_HAZEL_TREE);

    }

    public static void addEbonyTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.EBONY_BUSH1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, -1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.EBONY_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(4, 0.3F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.EBONY_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(4, 0.3F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EBONY_TREE);

    }

    public static void addHollyTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.HOLLY_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.5F, 4))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.HOLLY_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.5F, 4))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.HOLLY_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.5F, 4))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.HOLLY_TREE4.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.5F, 4))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_HOLLY_TREE);

    }

    public static void addSparseHollyTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.HOLLY_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.HOLLY_TREE4.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_HOLLY_TREE);

    }

    public static void addMangroveTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MANGROVE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(3, 0.1F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MANGROVE_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(3, 0.1F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MANGROVE_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(3, 0.1F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MANGROVE_TREE4.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(3, 0.1F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MANGROVE_TREE5.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(3, 0.1F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MANGROVE_TREE);

    }

    public static void addSparseMangroveMarshes(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MANGROVE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(0, 0.3F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MANGROVE_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(0, 0.3F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MANGROVE_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(0, 0.3F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MANGROVE_TREE4.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(0, 0.3F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MANGROVE_TREE5.configure(DecoratedFeatureConfig.DEFAULT).decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(0, 0.3F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_MANGROVE_TREE);

    }

    public static void addOrchardTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ORCHARD_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ORCHARD_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ORCHARD_TREE3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
    biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORCHARD_TREE);
    }

    public static void addHugeMushrooms(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.GREEN_MUSHROOM_HUGE.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.4F),
//                BYGFeatureList.WOOD_BLEWIT_HUGE.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.4F),
//                BYGFeatureList.WEEPING_MILKCAP_HUGE.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.4F)),
//                BYGFeatureList.BLACK_PUFF_HUGE.configure(DecoratedFeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(2, 0.3F, 2))));

    }

    public static void addHugeGlowshrooms(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.BLUE_GLOWSHROOM_HUGE.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.2F)),
//                BYGFeatureList.PURPLE_GLOWSHROOM_HUGE.configure(DecoratedFeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(2, 0.3F, 2))));
//        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWSHROOM_BAYOU_TREE);

    }

    public static void addWoodlandTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.WOODLANDS_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 3))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WOODLAND_TREE);

    }
}
