package voronoiaoc.byg.common.world.feature.biomefeatures;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import voronoiaoc.byg.core.byglists.BYGConfiguredFeatures;
import voronoiaoc.byg.core.byglists.BYGConfiguredTreeFeatures;

public class BYGFeatures {
    public static void addAlliumFieldFlowers(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ALLIUM_FLOWER);
    }

    public static void addAmaranthFieldFlowers(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_AMARANTH_FLOWER);
    }

    public static void addGlowcane(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWCANE);
    }

    public static void addFernGrass(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BYG_FERN_GRASS);
    }

    public static void addBYGDesertPlants(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DESERT_PLANTS);
    }

    public static void addFirecracker(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_FIRECRACKER);
    }

    public static void addPrairieGrass(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PRAIRIE_GRASS);
    }

    public static void addPumpkinPatch(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PUMPKIN);
    }

    public static void addBlueberries(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLUEBERRIES);
    }

    public static void addLushBlueberries(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LUSH_BLUEBERRIES);
    }

    public static void addBeachGrass(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BEACH_GRASS);
    }

    public static void addLargeLake(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.RAW_GENERATION, BYGConfiguredFeatures.CRAG_LAKE);
    }

    public static void addEmburBogVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_EMBUR_MUSHROOM);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_BOG_PLANT);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.EMBUR_LILY);
    }

    public static void addAzalea(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_AZALEA);
    }

    public static void addDelphinium(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DELPHINIUM);
    }

    public static void addJapaneseOrchid(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_JAPANESE_ORCHID);
    }

    public static void addWiltedGrass(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WILTED_GRASS);
    }

    public static void addWeedGrass(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WEED_GRASS);
    }

    public static void addWinterGrass(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WINTER_GRASS);
    }

    public static void addLeafPile(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LEAF_PILE);
    }

    public static void addCloverFlowerPatch(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CLOVER_FLOWER_PATCH);
    }

    public static void addCherryFoliage(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CHERRY_FOLIAGE);
    }

    public static void addBYGSwampVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SWAMP_PLANTS);
    }

    public static void addBYGLilyPad(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LILY_PADS);

    }

    public static void addHorseweed(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_HORSEWEED);
    }

    public static void addWinterSucculent(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WINTER_SUCCULENT);
    }

    public static void addShortGrass(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SHORT_GRASS);
    }

    public static void addIris(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_IRIS);
    }

    public static void addTulips(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_TULIP);
    }

    public static void addCaliforniaPoppy(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CALIFORNIA_POPPY);
    }

    public static void addCrocus(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CROCUS);
    }

    public static void addAlpineBellflower(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BELLFLOWER);
    }

    public static void addWinterScilla(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SCILLA);
    }

    public static void addYellowDaffodil(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_YELLOW_DAFFODIL);
    }

    public static void addDaffodil(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DAFFODILS);
    }

    public static void addPinkDaffodil(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DAFFODILS);
    }

    public static void addLolliPop(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LOLIPOP);
    }

    public static void addRose(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ROSE);
    }

    public static void addBlackRose(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLACK_ROSE);
    }

    public static void addOsiria(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_OSIRIA_ROSE);
    }

    public static void addWinterRose(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WINTER_ROSE);
    }

    public static void addSnowdrops(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SNOWDROPS);
    }

    public static void addMudDisks(GenerationSettings.Builder biomeIn) {
//        biomeIn.feature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.DISK.configure(new DiskFeatureConfig(BYGBlockList.MUD_BLOCK.getDefaultState(), 4, 1, Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState()))).decorate(Decorator.COUNT_TOP_SOLID.configure(new CountDecoratorConfig(1))));
    }

    public static void addBYGMushrooms(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MUSHROOM);
    }

    public static void addGlowshrooms(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWSHROOM);
    }

    public static void addAnemones(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ANEMONE);
    }

    public static void addFoxgloves(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_FOXGLOVE);
    }

    public static void addCattails(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CATTAILS);

    }

    public static void addReeds(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_REEDS);

    }

    public static void addFairyslipper(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.FAIRY_SLIPPER);
    }

    public static void addCyanRose(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CYAN_ROSE);
    }

    public static void addRedorchid(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORCHID);
    }

    public static void addPurpleOrchid(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORCHID);
    }

    public static void addPinkOrchid(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORCHID);
    }

    public static void addPeachleatherflower(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LEATHER_FLOWER);
    }

    public static void addVioletleatherflower(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LEATHER_FLOWER);
    }

    public static void addKovanFlower(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_KOVAN);
    }

    public static void addGrass(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BYG_GRASS);
    }

    public static void addMarshGrass(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_TALL_GRASS_2);
    }

    public static void addTallGrass(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_TALL_GRASS);
    }


    public static void addSages(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SAGE);
    }

    public static void addOrangeDaisy(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORANGE_DAISY);
    }

    public static void addPinkAllium(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PINK_ALLIUM);
    }

    public static void addRedCornflower(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RED_CORNFLOWER);
    }

    public static void addBYGTropicFlowers(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_JUNGLE_FLOWERS);
    }

    public static void addMiniCactus(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DESERT_PLANTS);
    }

    public static void addBYGBambooJungleVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.BAMBOO);
    }

    public static void addRockyStoneBoulder(GenerationSettings.Builder gen) {
        //gen.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(new ForestRockFeatureConfig(BYGBlockList.ROCKY_STONE.getDefaultState(), 0)).decorate(Decorator.FOREST_ROCK.configure(new CountDecoratorConfig(2))));
    }

    public static void addTerracottaBoulder(GenerationSettings.Builder gen) {
        //gen.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(new ForestRockFeatureConfig(Blocks.ORANGE_TERRACOTTA.getDefaultState(), 0)).decorate(Decorator.FOREST_ROCK.configure(new CountDecoratorConfig(3))));
    }

    public static void addMossyStoneBoulder(GenerationSettings.Builder gen) {
        //gen.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(new ForestRockFeatureConfig(BYGBlockList.MOSSY_STONE.getDefaultState(), 0)).decorate(Decorator.FOREST_ROCK.configure(new CountDecoratorConfig(2))));
    }

    public static void addFrostMagmaLakes(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, BYGConfiguredFeatures.FROST_MAGMA_LAKE);
    }

    public static void addWarpedVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.WARPED_CORAL_PLANT);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WARPED_DESERT_VEGETATION);
    }

    public static void addSythianVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.SYTHIAN_STALK);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SYTHIAN_PLANT);
    }

    public static void addGlowstoneGardenVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWSTONE_GARDEN_VEGETATION);
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_WEEPING_ROOTS);
    }

    public static void addDeadSeaSpires(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.RAW_GENERATION, BYGConfiguredFeatures.RANDOM_DEAD_SEA_SPIKE);
    }

    public static void addHugeNetherMushrooms(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredTreeFeatures.RANDOM_GLOWSTONE_GARDENS_MUSHROOM);
    }

    public static void addTropFungalMushrooms(GenerationSettings.Builder gen) {
        //gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//                BYGFeatureList.GREEN_MUSHROOM_HUGE.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.2F),
//                BYGFeatureList.WOOD_BLEWIT_HUGE.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.4F),
//                BYGFeatureList.WEEPING_MILKCAP_HUGE.configure(DecoratedFeatureConfig.DEFAULT).withChance(0.4F)),
//                BYGFeatureList.BLACK_PUFF_HUGE.configure(DecoratedFeatureConfig.DEFAULT))).decorate(Decorator.COUNT_EXTRA.configure(
//                new CountExtraDecoratorConfig(15, 0.5F, 5))));
    }

    public static void addIvisPlants(GenerationSettings.Builder gen) {
        //gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.IVIS_ROOTS).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));
        //gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.IVIS_SPROUT).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));
    }

    public static void addExtraCanyons(GenerationSettings.Builder gen) {
//        gen.addCarver(GenerationStep.Carver.AIR, gen.configureCarver(Carver.CANYON, new ProbabilityConfig(0.8F)));
    }

    public static void addGiantFlowerFeatures(GenerationSettings.Builder gen) {
        //gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.GIANT_ANGELICA_FLOWER.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, -1))));
        //gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.GIANT_DANDELION_FLOWER.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, -1))));
        //gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.GIANT_IRIS_FLOWER.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, -1))));
        //gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGFeatureList.GIANT_ROSE_FLOWER.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.3F, -1))));
    }
}
