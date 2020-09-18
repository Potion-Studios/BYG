package voronoiaoc.byg.common.world.feature.biomefeatures;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import voronoiaoc.byg.core.byglists.BYGConfiguredFeatures;
import voronoiaoc.byg.core.byglists.BYGConfiguredTreeFeatures;

public class BYGTreeFeatures {
    public static void addAncientTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ANCIENT_TREE);
    }

    public static void addBlueTaigaTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_BLUE_TREE);
    }

    public static void addBlackForestTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BLACK_FOREST_TREE);
    }

    public static void addSparseBlackForestTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BLACK_FOREST_SPARSE_TREE);
    }

    public static void addBorealTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BOREAL_TREE);
    }

    public static void addBorealSparseTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BOREAL_SPARSE_TREE);
    }

    public static void addConiferousTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CONIFER_TREE);
    }

    public static void addConiferousSparseTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CONIFER_SPARSE_TREE);
    }

    public static void addCypressTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CYPRESS_TREE);
    }

    public static void addDeciduousTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DECIDUOUS_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SHRUBLAND);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SHRUB);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_ASPEN_TREE);
    }

    public static void addDeciduousSparseTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DECIDUOUS_SPARSE_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SHRUBLAND);
    }

    //TODO: Reconfigure
    public static void addRedwoodSparseTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_REDWOOD_SPARSE_TREE);
    }

    public static void addMapleTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MAPLE_TREE);
    }

    public static void addMapleSparseTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MAPLE_SPARSE_TREE);
    }

    public static void addGiantBlueTaigaTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_BLUE_TREE_GIANT);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_BLUE_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_TREE);
    }

    public static void addGiantSeasonalTaigaTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_RED_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_YELLOW_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_ORANGE_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_SEASONAL_TREE_GIANT);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_TAIGA_MISC_TREE);
    }

    public static void addRedOakForestTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RED_OAK_FOREST_TREE);
    }

    public static void addJacarandaTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_JACARANDA_TREE);
    }

    public static void addSparseJacarandaTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_JACARANDA_SPARSE_TREE);
    }

    public static void addSparseRedOakForestTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RED_OAK_FOREST_SPARSE_TREE);
    }

    public static void addSeasonalBirchForestTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_BIRCH_FOREST_TREE);
    }

    public static void addSeasonalDeciduousTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DECIDUOUS_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DECIDUOUS_RED_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DECIDUOUS_ORANGE_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DECIDUOUS_BROWN_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_SHRUB);
    }

    public static void addSparseSeasonalDeciduousTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_DECIDUOUS_SPARSE_TREE);
    }

    public static void addSeasonalForestTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_FOREST_TREE);
    }

    public static void addSeasonalTaigaTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_RED_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_YELLOW_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_ORANGE_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_TAIGA_MISC_TREE);
    }

    public static void addShrubs(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SHRUBLAND);
    }

    public static void addRainForestTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RAINFOREST_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.VINES);
    }

    public static void addStoneForestTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_STONEFOREST_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.VINES);
    }

    public static void addFungalRainForestTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RAINFOREST_FUNGAL_TREE);
    }

    public static void addSparseRainforestTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_RAINFOREST_SPARSE_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.VINES);
    }

    public static void addRainbowTrees(BiomeGenerationSettings.Builder biome) {
        //biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.5F, -4))));
    }

    public static void addCragRainbowTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CRAG_GARDEN_TREE);
    }

    public static void addCikaTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CIKA_TREE);
    }

    public static void addIslandRainbowTrees(BiomeGenerationSettings.Builder biome) {
        //biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 10))));
        //biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BAMBOO.configure(new ProbabilityConfig(0.05F)).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(64))));
        //biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(4, 0.1F, -1))));
        //biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(LILY_PAD_CONFIG).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
    }

    public static void addPrairieTree(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_PRAIRIE_TREE);
    }

    public static void addSpruceTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_TREE);
    }

    public static void addSmallSpruceTrees(BiomeGenerationSettings.Builder biome) {
        //biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE.configure(SPRUCE_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.3F, 1))));
    }

    public static void addBluffTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BLUFF_TREE);
    }

    public static void addDoverMTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SEASONAL_TAIGA_MISC_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DOVER_TREE);
    }

    public static void addNorthernForestTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_NORTHERN_FOREST_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPRUCE_TREE);
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DOVER_TREE);
    }

    public static void addSkyrisTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SKYRIS_TREE);
    }

    public static void addBaobabTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BAOBAB_TREE);
    }

    public static void addSavannaCanopyTrees(BiomeGenerationSettings.Builder biome) {
    }

    public static void addRedwoodTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_REDWOOD_TREE);
    }

    public static void addMeadowShrubs(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MEADOW_SHRUB);
    }

    public static void addMeadowTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MEADOW_TREE);
    }

    public static void addGroveTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GROVE_TREE);
    }

    public static void addEnchantedGroveTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ENCHANTED_GROVE_TREE);
    }

    public static void addEnchantedTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ENCHANTED_TREE);
    }

    public static void addLargePumpkins(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PUMPKIN_PATCH);
    }

    //TODO: Configured Pumpkin Random Selector
    public static void addWitchPumpkins(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PUMPKIN_PATCH);
    }

    public static void addMarshTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MARSH_TREE);
    }

    public static void addBayouVegetation(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_BAYOU_TREE);
    }

    public static void addGlowshroomBayouVegetation(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GLOWSHROOM_BAYOU_TREE);
    }

    public static void addAspenTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ASPEN_TREE);
    }

    public static void addSparseClearingAspenTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_ASPEN_TREE);
    }

    public static void addSparseAspenTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_ASPEN_TREE);
    }

    public static void addZelkovaTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ZELKOVA_TREE);
    }

    public static void addSparseZelkovaTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_ZELKOVA_TREE);
    }

    public static void addPaloVerdeTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_PALO_VERDE_TREE);
    }

    public static void addJoshuaTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_JOSHUA_TREE);
    }

    //TODO: Random Selector Mojave Shrubs
    public static void addBushes(BiomeGenerationSettings.Builder biome) {
        //biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.8F, 2))));
        //biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.SHRUB_PRAIRIE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.8F, 2))));
    }

    public static void addRedRockCanyonVegetation(BiomeGenerationSettings.Builder biome) {
        //biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.3F, 1))));
        //biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.3F, 1))));
        //biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.CACTUS.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(8))));
    }

    public static void addPalmTree(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_PALM_TREE);
    }

    public static void addCherryTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CHERRY_TREE);
    }

    public static void addSparseCherryTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_CHERRY_TREE);
    }

    public static void addDeadHazelTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_WITCH_HAZEL_TREE);
    }

    public static void addSparseDeadHazelTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_WITCH_HAZEL_TREE);
    }

    public static void addEbonyTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_EBONY_TREE);
    }

    public static void addHollyTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_HOLLY_TREE);
    }

    public static void addSparseHollyTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SPARSE_HOLLY_TREE);
    }

    public static void addMangroveTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MANGROVE_TREE);
    }

    public static void addSparseMangroveMarshes(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MANGROVE_SPARSE_TREE);
    }

    public static void addOrchardTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_ORCHARD_TREE);
    }

    public static void addHugeMushrooms(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MUSHROOM);
    }

    public static void addHugeGlowshrooms(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GLOWSHROOM);
    }

    public static void addWoodlandTrees(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_WOODLAND_TREE);
    }

    public static void addDummyTree(BiomeGenerationSettings.Builder biome) {
        biome.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_WOODLAND_TREE);
    }
}
