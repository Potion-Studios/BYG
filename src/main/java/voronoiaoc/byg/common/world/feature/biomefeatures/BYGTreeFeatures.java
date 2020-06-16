package voronoiaoc.byg.common.world.feature.biomefeatures;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.TopSolidHeightmapNoiseBiasedDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import voronoiaoc.byg.core.byglists.BYGFeatureList;

import static net.minecraft.world.gen.feature.DefaultBiomeFeatures.*;


public class BYGTreeFeatures {
//    public static final BYGTreeFeatureConfig SWAMP_TREE_CONFIG = (new BYGTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlockList.JACARANDA_LOG.getDefaultState()), new SimpleBlockStateProvider(BYGBlockList.JACARANDA_LEAVES.getDefaultState()), new BYGMappedBlobFoilagePlacer(3, 0))).baseHeight(5).heightRandA(3).foliageHeight(3).maxWaterDepth(1).decorators(ImmutableList.of(new LeaveVineTreeDecorator())).////setSapling((net.minecraftforge.common.IPlantable) Blocks.OAK_SAPLING).build();

    public static void addJacarandaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.JACARANDA_TREE2.configure(FeatureConfig.DEFAULT).withChance(0.3F),
                BYGFeatureList.INDIGOJACARANDA_TREE2.configure(FeatureConfig.DEFAULT).withChance(0.3F),
                BYGFeatureList.INDIGOJACARANDA_TREE.configure(FeatureConfig.DEFAULT).withChance(0.3F)),
                BYGFeatureList.JACARANDA_TREE.configure(FeatureConfig.DEFAULT))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(45, 0.1F, -15))));
    }

    public static void addBlueTaigaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.SMALLBLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.BLUEPINETREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.BLUESPRUCETREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(PINE_TREE_CONFIG).withChance(0.5F),
//                Feature.TREE.configure(SPRUCE_TREE_CONFIG).withChance(0.5F),
                BYGFeatureList.TALLBLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F)),
                BYGFeatureList.BLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(20, 0.1F, -8))));

    }

    public static void addBorealTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.BOREAL_TREE.configure(FeatureConfig.DEFAULT).withChance(0.5F)),
                BYGFeatureList.BOREAL_TREE2.configure(FeatureConfig.DEFAULT))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(55, 0.5F, -20))));
    }

    public static void addConiferousTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.WIDECONIFEROUS_TREE.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(35, 0.1F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.TALLCONIFEROUS_TREE.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(15, 0.1F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SMALLCONIFEROUS_TREE.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(25, 0.1F, 1))));

    }

//    public static void addCypressTreeVegetation(Biome biome) {
//        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.HUGECYPRESS_TREE.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.1F, 1))));
//    }

    public static void addDeciduousTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.DECIDUOUS_TREE.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(18, 0.3F, -8))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(4, 0.1F, -1))));
    }

    public static void addBYGJungleTreeForest(Biome biomeIn) {
        biomeIn.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(Feature.TREE.configure(FANCY_TREE_CONFIG).withChance(0.4F), Feature.TREE.configure(JUNGLE_GROUND_BUSH_CONFIG).withChance(0.15F), Feature.TREE.configure(MEGA_JUNGLE_TREE_CONFIG).withChance(0.0F)), Feature.TREE.configure(JUNGLE_TREE_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(30, 0.1F, -5))));
    }

    public static void addGiantBlueTaigaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.BLUEGIANTSPUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F)),
                BYGFeatureList.BLUEGIANTSPUCE_TREE.configure(FeatureConfig.DEFAULT)))
//                Feature.TREE.configure(BYGFeatureConfigs.BLUEMEGAPINETREE_CONFIG).withChance(0.1F)),
//                Feature.TREE.configure(BYGFeatureConfigs.BLUEMEGASPRUCETREE_CONFIG)))
                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(10, 0.3F, 5))));

        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.SMALLBLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.3F),
//                Feature.TREE.configure(BYGFeatureConfigs.BLUEPINETREE_CONFIG).withChance(0.3F),
//                Feature.TREE.configure(BYGFeatureConfigs.BLUESPRUCETREE_CONFIG).withChance(0.3F),
                BYGFeatureList.TALLBLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F)),
                BYGFeatureList.BLUESPRUCE_TREE.configure(FeatureConfig.DEFAULT))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(20, 0.3F, 1))));

//        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                Feature.TREE.configure(MEGA_SPRUCE_TREE_CONFIG).withChance(0.35F),
//                Feature.TREE.configure(MEGA_PINE_TREE_CONFIG).withChance(0.35F),
//                Feature.TREE.configure(PINE_TREE_CONFIG).withChance(0.33333334F)),
//                Feature.TREE.configure(SPRUCE_TREE_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
//                new CountExtraChanceDecoratorConfig(20, 0.1F, 2))));
    }

    public static void addGiantSeasonalTaigaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.GIANTORANGESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.15F),
//                Feature.TREE.configure(BYGFeatureConfigs.ORANGEMEGAPINETREE_CONFIG).withChance(0.15F),
//                Feature.TREE.configure(BYGFeatureConfigs.ORANGEMEGASPRUCETREE_CONFIG).withChance(0.15F),
                BYGFeatureList.GIANTYELLOWSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.35F)),
//                Feature.TREE.configure(BYGFeatureConfigs.YELLOWMEGAPINETREE_CONFIG).withChance(0.15F),
//                Feature.TREE.configure(BYGFeatureConfigs.YELLOWMEGASPRUCETREE_CONFIG).withChance(0.15F),
                BYGFeatureList.GIANTREDSPRUCE_TREE.configure(FeatureConfig.DEFAULT)))
//                Feature.TREE.configure(BYGFeatureConfigs.REDMEGAPINETREE_CONFIG).withChance(0.15F)),
//                Feature.TREE.configure(BYGFeatureConfigs.REDMEGASPRUCETREE_CONFIG)))
                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(10, 0.3F, 5))));

        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.SMALLREDSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.666F),
                BYGFeatureList.REDSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.666F),
                BYGFeatureList.TALLREDSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1f),
//                Feature.TREE.configure(BYGFeatureConfigs.REDPINETREE_CONFIG).withChance(0.3F),
//                Feature.TREE.configure(BYGFeatureConfigs.REDSPRUCETREE_CONFIG).withChance(0.3F),
                BYGFeatureList.SMALLORANGESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
                BYGFeatureList.ORANGESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F)),
                BYGFeatureList.TALLORANGESPRUCE_TREE.configure(FeatureConfig.DEFAULT)))
//                Feature.TREE.configure(BYGFeatureConfigs.ORANGEPINETREE_CONFIG).withChance(0.3F),
//                Feature.TREE.configure(BYGFeatureConfigs.ORANGESPRUCETREE_CONFIG).withChance(0.3F),
//                BYGFeatureList.SMALLYELLOWSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.666F),
//                BYGFeatureList.YELLOWSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//                BYGFeatureList.YELLOWSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.YELLOWPINETREE_CONFIG).withChance(0.3F)),
//                Feature.TREE.configure(BYGFeatureConfigs.YELLOWSPRUCETREE_CONFIG)))
                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(10, 0.1F, 3))));

//        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                Feature.TREE.configure(MEGA_SPRUCE_TREE_CONFIG).withChance(0.35F),
//                Feature.TREE.configure(MEGA_PINE_TREE_CONFIG).withChance(0.35F),
//                Feature.TREE.configure(PINE_TREE_CONFIG).withChance(0.33333334F)),
//                Feature.TREE.configure(SPRUCE_TREE_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
//                new CountExtraChanceDecoratorConfig(3, 0.1F, 2))));

    }

//    public static void addJacarandaTrees(Biome biome) {
//        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.JACARANDA_TREE.configure(FeatureConfig.DEFAULT).withChance(0.7F),
//                Feature.TREE.configure(BYGFeatureConfigs.TALLJACARANDATREE_CONFIG).withChance(0.1F)),
//                Feature.TREE.configure(BYGFeatureConfigs.JACARANDATREE_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
//                new CountExtraChanceDecoratorConfig(55, 0.5F, -20))));
//    }

    public static void addRedOakForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                Feature.TREE.configure(BIRCH_TREE_CONFIG).withChance(0.06F),
                Feature.TREE.configure(FANCY_TREE_CONFIG).withChance(0.1F)),
                BYGFeatureList.REDOAK_TREE.configure(FeatureConfig.DEFAULT))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(20, 0.4F, -8))));
    }

    public static void addSeasonalBirchForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.BROWNBIRCH_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.TALLBROWNBIRCHTREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.BROWNBIRCHTREE_CONFIG).withChance(0.1F),
                BYGFeatureList.ORANGEBIRCH_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.TALLORANGEBIRCHTREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.ORANGEBIRCHTREE_CONFIG).withChance(0.1F),
                BYGFeatureList.REDBIRCH_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F)),
//                Feature.TREE.configure(BYGFeatureConfigs.TALLREDBIRCHTREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.REDBIRCHTREE_CONFIG).withChance(0.1F),
                BYGFeatureList.YELLOWBIRCH_TREE.configure(FeatureConfig.DEFAULT)))
//                Feature.TREE.configure(BYGFeatureConfigs.TALLYELLOWBIRCHTREE_CONFIG).withChance(0.1F)),
//                Feature.TREE.configure(BYGFeatureConfigs.YELLOWBIRCHTREE_CONFIG)))
                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(20, 0.4F, -8))));
    }

    public static void addSeasonalDeciduousTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SEASONAL_SHRUBS.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(4, 0.4F, -1))));

        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.REDDECIDUOUS_TREE.configure(FeatureConfig.DEFAULT).withChance(0.15F),
                BYGFeatureList.ORANGEDECIDUOUS_TREE.configure(FeatureConfig.DEFAULT).withChance(0.15F),
                BYGFeatureList.DECIDUOUS_TREE.configure(FeatureConfig.DEFAULT).withChance(0.15F),
                BYGFeatureList.BROWNDECIDUOUS_TREE.configure(FeatureConfig.DEFAULT).withChance(0.15F)),
                BYGFeatureList.YELLOWDECIDUOUS_TREE.configure(FeatureConfig.DEFAULT))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(20, 0.5F, -15))));
    }

    public static void addSeasonalForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.BROWNOAK_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.BROWNOAKTREE_CONFIG).withChance(0.1F),
                BYGFeatureList.REDOAK_TREE.configure(FeatureConfig.DEFAULT).withChance(0.2F),
                BYGFeatureList.YELLOWBIRCH_TREE.configure(FeatureConfig.DEFAULT).withChance(0.2F)),
//                Feature.TREE.configure(BYGFeatureConfigs.REDOAKTREE_CONFIG).withChance(0.2F),
//                Feature.TREE.configure(FANCY_TREE_CONFIG).withChance(0.01F),
                BYGFeatureList.ORANGEOAK_TREE.configure(FeatureConfig.DEFAULT)))
//                Feature.TREE.configure(BYGFeatureConfigs.ORANGEOAKTREE_CONFIG)))
                .createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(20, 0.4F, -8))));
    }

    public static void addSeasonalTaigaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.SMALLREDSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
                BYGFeatureList.REDSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.2F),
                BYGFeatureList.TALLREDSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.05f),
//                Feature.TREE.configure(BYGFeatureConfigs.REDPINETREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.REDSPRUCETREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(PINE_TREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(SPRUCE_TREE_CONFIG).withChance(0.1F),
                BYGFeatureList.SMALLORANGESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
                BYGFeatureList.ORANGESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.2F),
                BYGFeatureList.TALLORANGESPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.05F),
//                Feature.TREE.configure(BYGFeatureConfigs.ORANGEPINETREE_CONFIG).withChance(0.1F),
//                Feature.TREE.configure(BYGFeatureConfigs.ORANGESPRUCETREE_CONFIG).withChance(0.1F),
                BYGFeatureList.SMALLYELLOWSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
                BYGFeatureList.YELLOWSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F),
                BYGFeatureList.TALLYELLOWSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.2F),
                BYGFeatureList.YELLOWSPRUCE_TREE.configure(FeatureConfig.DEFAULT).withChance(0.1F)),
                BYGFeatureList.YELLOWSPRUCE_TREE.configure(FeatureConfig.DEFAULT))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(15, 0.1F, 3))));
    }

    public static void addShrubs(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.1F, 1))));
    }

    public static void addTropJungleTrees(Biome biome) {
//        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(BYGFeatureConfigs.MEGATROPJUNGLETREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.0F, 0))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.TROPICALRAINFOREST_TREE.configure(FeatureConfig.DEFAULT).withChance(0.5F),
                BYGFeatureList.RAINBOW_TREE1.configure(FeatureConfig.DEFAULT).withChance(0.15F)
//                Feature.TREE.configure(BYGFeatureConfigs.TROPGROUNDBUSH_CONFIG).withChance(0.15F)),
        ), BYGFeatureList.SHORTTROPICALRAINFOREST_TREE.configure(FeatureConfig.DEFAULT))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(
                new CountExtraChanceDecoratorConfig(65, 0.1F, 10))));

        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.VINES.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_HEIGHT_64.configure(new CountDecoratorConfig(50))));
    }

    public static void addRainbowTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.5F, -4))));

    }

    public static void addCragRainbowTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(55, 0.5F, 8))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.BAMBOO.configure(new ProbabilityConfig(0.2F)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidHeightmapNoiseBiasedDecoratorConfig(160, 80.0D, 0.3D, Heightmap.Type.WORLD_SURFACE_WG))));
//        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(BYGFeatureConfigs.TROPGROUNDBUSH_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.5F, 8))));

    }

    public static void addIslandRainbowTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.5F, 10))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.BAMBOO.configure(new ProbabilityConfig(0.05F)).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(64))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SHRUB.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(4, 0.1F, -1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(LILY_PAD_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));

    }

    public static void addSparseTree(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(Feature.TREE.configure(FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withChance(0.33333334F)), Feature.TREE.configure(OAK_TREE_WITH_MORE_BEEHIVES_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.05F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PRAIRIE_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(3, 0.8F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PRAIRIE_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(3, 0.8F, 2))));

    }

    public static void addSpruceTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(PINE_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.2F, 5))));

    }

    public static void addBluffTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BLUFF_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.3F, -4))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BLUFF_TREE2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.3F, -4))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BLUFF_TREE3.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.3F, -4))));

    }

    public static void addDoverMTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(BYGFeatureConfigs.DOVERMEGASPRUCETREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(3, 0.1F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(PINE_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.2F, 5))));

    }

    public static void addSkyrisTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SKYRIS_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.5F, 4))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SKYRIS_TREE2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.5F, 4))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.SKYRIS_TREE3.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.5F, 4))));

    }

    public static void addBaobabTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BAOBAB_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.8F, -1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(Feature.TREE.configure(ACACIA_TREE_CONFIG).withChance(0.8F)), Feature.TREE.configure(ACACIA_TREE_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.1F, 1))));
    }

    public static void addSavannaCanopyTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(Feature.TREE.configure(BYGFeatureConfigs.ACACIA_TREE_CONFIG).withChance(0.5F), Feature.TREE.configure(BYGFeatureConfigs.ACACIA_TREE_CONFIG).withChance(0.4F)), Feature.TREE.configure(ACACIA_TREE_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(25, 0.2F, 10))));
    }

    public static void addRedwoodTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.REDWOOD_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.1F, 1))));
    }

    public static void addMeadowTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MEADOW_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(3, 0.8F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.MEADOW_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(3, 0.8F, 2))));

    }

    public static void addMarshTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PRAIRIE_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.8F, 8))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PRAIRIE_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.8F, 8))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(SWAMP_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.1F, 1))));

    }

    public static void addBayouVegetation(Biome biome) {
        //  biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BAYOU_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraChanceDecoratorConfig(9, 0.8F, -1))));
//        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BAYOU_TREE2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraChanceDecoratorConfig(3, 0.8F, -1))));
        // biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.BAYOU_TREE3.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraChanceDecoratorConfig(4, 0.8F, -1))));
    }

    public static void addAspenTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.5F, -1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.5F, -1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE3.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.5F, -1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(6, 0.8F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(6, 0.8F, 2))));

    }

    public static void addSparseAspenTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.5F, -2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.5F, -2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_TREE3.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(5, 0.5F, -2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(6, 0.8F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ASPEN_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(6, 0.8F, 2))));

    }

    public static void addZelkovaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ZELKOVA_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.8F, -5))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ZELKOVA_TREE2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.8F, -5))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.ZELKOVA_TREE3.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.8F, -5))));

    }

    public static void addPaloVerdeTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PALO_VERDE_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.3F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PALO_VERDE_TREE2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.3F, 1))));
    }

    public static void addJoshuaTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.3F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.3F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PRAIRIE_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(3, 0.8F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PRAIRIE_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(3, 0.8F, 2))));
    }

    public static void addBushes(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PRAIRIE_SHRUB1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.8F, 2))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.PRAIRIE_SHRUB2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.8F, 2))));
    }

    public static void addRedRockCanyonVegetation(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE1.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.3F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.JOSHUA_TREE2.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(1, 0.3F, 1))));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.HEIGHTCHECKEDCACTUS.configure(DecoratedFeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(8))));

    }
}
