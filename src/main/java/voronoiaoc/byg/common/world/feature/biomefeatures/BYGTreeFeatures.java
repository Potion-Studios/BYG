package voronoiaoc.byg.common.world.feature.biomefeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import voronoiaoc.byg.core.byglists.BYGConfiguredTreeFeatures;

public class BYGTreeFeatures {
    public static void addAncientTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ANCIENT_TREE);
    }

    public static void addBlueTaigaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GIANT_BLUE_TAIGA_TREE);
    }

    public static void addBlackForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BLACK_FOREST_TREE);
    }

    public static void addSparseBlackForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BLACK_FOREST_SPARSE_TREE);
    }

    public static void addBorealTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BOREAL_TREE);
    }

    public static void addBorealSparseTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BOREAL_SPARSE_TREE);
    }

    public static void addConiferousTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CONIFER_TREE);
    }

    public static void addConiferousSparseTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CONIFER_SPARSE_TREE);
    }

    public static void addCypressTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CYPRESS_TREE);
    }

    public static void addDeciduousTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DECIDUOUS_TREE);
    }

    public static void addDeciduousSparseTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DECIDUOUS_SPARSE_TREE);
    }
    //TODO: Reconfigure
    public static void addRedwoodSparseTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_REDWOOD_SPARSE_TREE);
    }

    public static void addMapleTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MAPLE_TREE);
    }

    public static void addMapleSparseTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MAPLE_SPARSE_TREE);
    }

    public static void addGiantBlueTaigaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BLUE_TAIGA_TREE);
    }

    public static void addGiantSeasonalTaigaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_GIANT_TAIGA_TREE);
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_TAIGA_TREE);
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_GIANT_TAIGA_MISC_TREE);
    }

    public static void addRedOakForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RED_OAK_FOREST_TREE);
    }

    public static void addSparseRedOakForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RED_OAK_FOREST_SPARSE_TREE);
    }

    public static void addSeasonalBirchForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_BIRCH_FOREST_TREE);
    }

    public static void addSeasonalDeciduousTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_DECIDUOUS_TREE);
    }

    public static void addSparseSeasonalDeciduousTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_DECIDUOUS_SPARSE_TREE);
    }

    public static void addSeasonalForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_FOREST_TREE);
    }

    public static void addSeasonalTaigaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_GIANT_TAIGA_TREE);
    }

    public static void addShrubs(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.1F, 1))));
    }

    public static void addRainForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RAINFOREST_TREE);
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.VINES);
    }

    public static void addFungalRainForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RAINFOREST_FUNGAL_TREE);
    }

    public static void addSparseRainforestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RAINFOREST_SPARSE_TREE);
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.VINES);
    }

    public static void addRainbowTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.5F, -4))));
    }

    public static void addCragRainbowTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CRAG_GARDEN_TREE);
    }

    public static void addCikaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CIKA_TREE);
    }

    public static void addIslandRainbowTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.5F, 10))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.BAMBOO.configure(new ProbabilityConfig(0.05F)).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(64))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(4, 0.1F, -1))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(LILY_PAD_CONFIG).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
    }

    public static void addPrairieTree(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_PRAIRIE_TREE);
    }

    public static void addSpruceTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(PINE_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.3F, -5))));
    }

    public static void addSmallSpruceTrees(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(SPRUCE_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.3F, 1))));
    }

    public static void addBluffTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BLUFF_TREE);
    }

    public static void addDoverMTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DOVER_TREE);
    }

    public static void addNorthernForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_NORTHERN_FOREST_TREE);
    }

    public static void addSkyrisTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SKYRIS_TREE);
    }

    public static void addBaobabTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BAOBAB_TREE);
    }

    public static void addSavannaCanopyTrees(Biome biome) {}

    public static void addRedwoodTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_REDWOOD_TREE);
    }

    public static void addMeadowShrubs(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MEADOW_SHRUB);
    }

    public static void addMeadowTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MEADOW_TREE);
    }

    public static void addGroveTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GROVE_TREE);
    }

    public static void addEnchantedGroveTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ENCHANTED_GROVE_TREE);
    }

    public static void addEnchantedTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ENCHANTED_TREE);
    }

    //TODO: Configured Pumpkin Random Selector
    public static void addLargePumpkins(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.5F, -2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
    }

    //TODO: Configured Pumpkin Random Selector
    public static void addWitchPumpkins(Biome biome) {
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.5F, -2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
        //biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.5F, 1))));
    }

    public static void addMarshTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MARSH_TREE);
    }

    public static void addBayouVegetation(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BAYOU_TREE);
    }

    public static void addGlowshroomBayouVegetation(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GLOWSHROOM_BAYOU_TREE);
    }

    public static void addAspenTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ASPEN_TREE);
    }

    public static void addSparseClearingAspenTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_ASPEN_TREE);
    }

    public static void addSparseAspenTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_ASPEN_TREE);
    }

    public static void addZelkovaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ZELKOVA_TREE);
    }

    public static void addSparseZelkovaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_ZELKOVA_TREE);
    }

    public static void addPaloVerdeTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_PALO_VERDE_TREE);
    }

    public static void addJoshuaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_JOSHUA_TREE);
    }

    //TODO: Random Selector Mojave Shrubs
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
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CHERRY_TREE);
    }

    public static void addSparseCherryTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_CHERRY_TREE);
    }

    public static void addDeadHazelTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_WITCH_HAZEL_TREE);
    }

    public static void addSparseDeadHazelTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_WITCH_HAZEL_TREE);
    }

    public static void addEbonyTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_EBONY_TREE);
    }

    public static void addHollyTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_HOLLY_TREE);
    }

    public static void addSparseHollyTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_HOLLY_TREE);
    }

    public static void addMangroveTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MANGROVE_TREE);
    }

    public static void addSparseMangroveMarshes(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MANGROVE_SPARSE_TREE);
    }

    public static void addOrchardTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ORCHARD_TREE);
    }

    public static void addHugeMushrooms(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MUSHROOM);
    }

    public static void addHugeGlowshrooms(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GLOWSHROOM);
    }

    public static void addWoodlandTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_WOODLAND_TREE);
    }
}
