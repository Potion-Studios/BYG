package voronoiaoc.byg.common.world.feature.biomefeatures;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import voronoiaoc.byg.core.byglists.BYGConfiguredTreeFeatures;

public class BYGTreeFeatures {
    public static void addAncientTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ANCIENT_TREE);
    }

    public static void addBlueTaigaTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GIANT_BLUE_TAIGA_TREE);
    }

    public static void addBlackForestTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BLACK_FOREST_TREE);
    }

    public static void addSparseBlackForestTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BLACK_FOREST_SPARSE_TREE);
    }

    public static void addBorealTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BOREAL_TREE);
    }

    public static void addBorealSparseTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BOREAL_SPARSE_TREE);
    }

    public static void addConiferousTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CONIFER_TREE);
    }

    public static void addConiferousSparseTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CONIFER_SPARSE_TREE);
    }

    public static void addCypressTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CYPRESS_TREE);
    }

    public static void addDeciduousTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DECIDUOUS_TREE);
    }

    public static void addDeciduousSparseTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DECIDUOUS_SPARSE_TREE);
    }
    //TODO: Reconfigure
    public static void addRedwoodSparseTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_REDWOOD_SPARSE_TREE);
    }

    public static void addMapleTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MAPLE_TREE);
    }

    public static void addMapleSparseTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MAPLE_SPARSE_TREE);
    }

    public static void addGiantBlueTaigaTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BLUE_TAIGA_TREE);
    }

    public static void addGiantSeasonalTaigaTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_GIANT_TAIGA_TREE);
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_TAIGA_TREE);
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_GIANT_TAIGA_MISC_TREE);
    }

    public static void addRedOakForestTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RED_OAK_FOREST_TREE);
    }

    public static void addSparseRedOakForestTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RED_OAK_FOREST_SPARSE_TREE);
    }

    public static void addSeasonalBirchForestTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_BIRCH_FOREST_TREE);
    }

    public static void addSeasonalDeciduousTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_DECIDUOUS_TREE);
    }

    public static void addSparseSeasonalDeciduousTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_DECIDUOUS_SPARSE_TREE);
    }

    public static void addSeasonalForestTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_FOREST_TREE);
    }

    public static void addSeasonalTaigaTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_GIANT_TAIGA_TREE);
    }

    public static void addShrubs(GenerationSettings.class_5495 biome) {
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.1F, 1))));
    }

    public static void addRainForestTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RAINFOREST_TREE);
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.VINES);
    }

    public static void addFungalRainForestTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RAINFOREST_FUNGAL_TREE);
    }

    public static void addSparseRainforestTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RAINFOREST_SPARSE_TREE);
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.VINES);
    }

    public static void addRainbowTrees(GenerationSettings.class_5495 biome) {
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.5F, -4))));
    }

    public static void addCragRainbowTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CRAG_GARDEN_TREE);
    }

    public static void addCikaTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CIKA_TREE);
    }

    public static void addIslandRainbowTrees(GenerationSettings.class_5495 biome) {
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.5F, 10))));
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, Feature.BAMBOO.configure(new ProbabilityConfig(0.05F)).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(64))));
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(4, 0.1F, -1))));
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(LILY_PAD_CONFIG).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
    }

    public static void addPrairieTree(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_PRAIRIE_TREE);
    }

    public static void addSpruceTrees(GenerationSettings.class_5495 biome) {
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(PINE_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.3F, -5))));
    }

    public static void addSmallSpruceTrees(GenerationSettings.class_5495 biome) {
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(SPRUCE_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.3F, 1))));
    }

    public static void addBluffTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BLUFF_TREE);
    }

    public static void addDoverMTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DOVER_TREE);
    }

    public static void addNorthernForestTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_NORTHERN_FOREST_TREE);
    }

    public static void addSkyrisTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SKYRIS_TREE);
    }

    public static void addBaobabTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BAOBAB_TREE);
    }

    public static void addSavannaCanopyTrees(GenerationSettings.class_5495 biome) {}

    public static void addRedwoodTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_REDWOOD_TREE);
    }

    public static void addMeadowShrubs(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MEADOW_SHRUB);
    }

    public static void addMeadowTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MEADOW_TREE);
    }

    public static void addGroveTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GROVE_TREE);
    }

    public static void addEnchantedGroveTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ENCHANTED_GROVE_TREE);
    }

    public static void addEnchantedTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ENCHANTED_TREE);
    }

    //TODO: Configured Pumpkin Random Selector
    public static void addLargePumpkins(GenerationSettings.class_5495 biome) {
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.5F, -2))));
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
    }

    //TODO: Configured Pumpkin Random Selector
    public static void addWitchPumpkins(GenerationSettings.class_5495 biome) {
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.5F, -2))));
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.8F, 2))));
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PUMPKIN_PATCH3.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.5F, 1))));
    }

    public static void addMarshTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MARSH_TREE);
    }

    public static void addBayouVegetation(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BAYOU_TREE);
    }

    public static void addGlowshroomBayouVegetation(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GLOWSHROOM_BAYOU_TREE);
    }

    public static void addAspenTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ASPEN_TREE);
    }

    public static void addSparseClearingAspenTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_ASPEN_TREE);
    }

    public static void addSparseAspenTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_ASPEN_TREE);
    }

    public static void addZelkovaTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ZELKOVA_TREE);
    }

    public static void addSparseZelkovaTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_ZELKOVA_TREE);
    }

    public static void addPaloVerdeTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_PALO_VERDE_TREE);
    }

    public static void addJoshuaTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_JOSHUA_TREE);
    }

    //TODO: Random Selector Mojave Shrubs
    public static void addBushes(GenerationSettings.class_5495 biome) {
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.8F, 2))));
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.8F, 2))));
    }

    public static void addRedRockCanyonVegetation(GenerationSettings.class_5495 biome) {
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, 1))));
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.CACTUS.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(8))));
    }

    public static void addPalmTree(GenerationSettings.class_5495 biome) {
        //biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PALM_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.4F, 1))));
    }

    public static void addCherryTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CHERRY_TREE);
    }

    public static void addSparseCherryTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_CHERRY_TREE);
    }

    public static void addDeadHazelTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_WITCH_HAZEL_TREE);
    }

    public static void addSparseDeadHazelTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_WITCH_HAZEL_TREE);
    }

    public static void addEbonyTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_EBONY_TREE);
    }

    public static void addHollyTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_HOLLY_TREE);
    }

    public static void addSparseHollyTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_HOLLY_TREE);
    }

    public static void addMangroveTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MANGROVE_TREE);
    }

    public static void addSparseMangroveMarshes(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MANGROVE_SPARSE_TREE);
    }

    public static void addOrchardTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ORCHARD_TREE);
    }

    public static void addHugeMushrooms(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MUSHROOM);
    }

    public static void addHugeGlowshrooms(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GLOWSHROOM);
    }

    public static void addWoodlandTrees(GenerationSettings.class_5495 biome) {
        biome.method_30992(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_WOODLAND_TREE);
    }
}
