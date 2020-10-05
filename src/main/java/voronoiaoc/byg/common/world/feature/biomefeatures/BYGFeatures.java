package voronoiaoc.byg.common.world.feature.biomefeatures;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import voronoiaoc.byg.core.byglists.BYGConfiguredFeatures;
import voronoiaoc.byg.core.byglists.BYGConfiguredTreeFeatures;

public class BYGFeatures {
    public static void addAlliumFieldFlowers(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ALLIUM_FLOWER);
    }

    public static void addBasaltFeatures(BiomeGenerationSettings.Builder gen) {
//        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.BASALT_BLOBS);
//        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.BASALT_BLOBS2);
//        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.BASALT_SPRING);
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.LARGE_BASALT_COLUMN);
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.SMALL_BASALT_COLUMN);
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.BASALT_DELTA);
    }

    public static void addAmaranthFieldFlowers(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_AMARANTH_FLOWER);
    }

    public static void addRoseFieldFlowers(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ROSE_FIELD_FLOWER);
    }

    public static void addGlowcane(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWCANE);
    }

    public static void addFernGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BYG_FERN_GRASS);
    }

    public static void addGrasslandBoulders(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.GRASSLAND_BOULDER);
    }

    public static void addGraniteBoulder(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.GRANITE_BOULDER);
    }

    public static void addBYGDesertPlants(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DESERT_PLANTS);
    }

    public static void addFirecracker(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_FIRECRACKER);
    }

    public static void addPrairieGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PRAIRIE_GRASS);
    }

    public static void addPumpkinPatch(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PUMPKIN);
    }

    public static void addBlueberries(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLUEBERRIES);
    }

    public static void addLushBlueberries(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LUSH_BLUEBERRIES);
    }

    public static void addBeachGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BEACH_GRASS);
    }

    public static void addLargeLake(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.CRAG_LAKE);
    }

    public static void addCrimsonGardensVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_FUNGUS);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CRIMSON_GARDEN_VEGETATION);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WEEPING_VINE_BLACKSTONE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLACKSTONE_BOULDERS);

    }

    public static void addEmburBogVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_EMBUR_MUSHROOM);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_BOG_PLANT);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.EMBUR_LILY);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_SPROUTS);

    }

    public static void addEmburBogVines(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_GEL_VINES);
    }

    public static void addAzalea(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_AZALEA);
    }

    public static void addSunFlowers(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SUNFLOWER);
    }

    public static void addDelphinium(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DELPHINIUM);
    }

    public static void addJapaneseOrchid(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_JAPANESE_ORCHID);
    }

    public static void addWiltedGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WILTED_GRASS);
    }

    public static void addWeedGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WEED_GRASS);
    }

    public static void addWinterGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WINTER_GRASS);
    }

    public static void addLeafPile(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LEAF_PILE);
    }

    public static void addCloverFlowerPatch(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CLOVER_FLOWER_PATCH);
    }

    public static void addCherryFoliage(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CHERRY_FOLIAGE);
    }

    public static void addBYGSwampVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SWAMP_PLANTS);
    }

    public static void addBYGLilyPad(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LILY_PADS);

    }

    public static void addHorseweed(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_HORSEWEED);
    }

    public static void addWinterSucculent(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WINTER_SUCCULENT);
    }

    public static void addShortGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SHORT_GRASS);
    }

    public static void addIris(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_IRIS);
    }

    public static void addTulips(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_TULIP);
    }

    public static void addCaliforniaPoppy(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CALIFORNIA_POPPY);
    }

    public static void addCrocus(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CROCUS);
    }

    public static void addAlpineBellflower(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BELLFLOWER);
    }

    public static void addWinterScilla(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SCILLA);
    }

    public static void addYellowDaffodil(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_YELLOW_DAFFODIL);
    }

    public static void addDaffodil(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DAFFODILS);
    }

    public static void addPinkDaffodil(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DAFFODILS);
    }

    public static void addLolliPop(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LOLIPOP);
    }

    public static void addRose(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ROSE);
    }

    public static void addBlackRose(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLACK_ROSE);
    }

    public static void addOsiria(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_OSIRIA_ROSE);
    }

    public static void addWinterRose(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WINTER_ROSE);
    }

    public static void addSnowdrops(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SNOWDROPS);
    }

    public static void addMudDisks(BiomeGenerationSettings.Builder biomeIn) {
//        biomeIn.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.configure(new DiskFeatureConfig(BYGBlockList.MUD_BLOCK.getDefaultState(), 4, 1, Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState()))).decorate(Decorator.COUNT_TOP_SOLID.configure(new CountDecoratorConfig(1))));
    }

    public static void addBYGMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MUSHROOM);
    }

    public static void addMGCoral(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_CORAL_MANGROVE);
    }

    public static void addGlowshrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWSHROOM);
    }

    public static void addAnemones(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ANEMONE);
    }

    public static void addFoxgloves(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_FOXGLOVE);
    }

    public static void addCattails(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CATTAILS);

    }

    public static void addReeds(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_REEDS);

    }

    public static void addFairyslipper(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.FAIRY_SLIPPER);
    }

    public static void addCyanRose(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CYAN_ROSE);
    }

    public static void addRedorchid(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORCHID);
    }

    public static void addPurpleOrchid(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORCHID);
    }

    public static void addPinkOrchid(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORCHID);
    }

    public static void addPeachleatherflower(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LEATHER_FLOWER);
    }

    public static void addVioletleatherflower(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LEATHER_FLOWER);
    }

    public static void addKovanFlower(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_KOVAN);
    }

    public static void addGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BYG_GRASS);
    }

    public static void addMarshGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_TALL_GRASS_2);
    }

    public static void addTallGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_TALL_GRASS);
    }


    public static void addSages(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SAGE);
    }

    public static void addOrangeDaisy(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORANGE_DAISY);
    }

    public static void addPinkAllium(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PINK_ALLIUM);
    }

    public static void addRedCornflower(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RED_CORNFLOWER);
    }

    public static void addBYGTropicFlowers(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_JUNGLE_FLOWERS);
    }

    public static void addMiniCactus(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DESERT_PLANTS);
    }

    public static void addBYGBambooJungleVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.BAMBOO);
    }

    public static void addRockyStoneBoulder(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BOULDERS);
    }

    public static void addGiantLunaRocks(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WHITE_SANDSTONE_BOULDER);
//        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.VALLE_DE_LUNA_POINTY_ROCK);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.VALLE_DE_LUNA_POINTY_ROCK_LARGE);
    }

    public static void addTerracottaBoulder(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_TERRACOTTA_BOULDERS);
    }

    public static void addMossyStoneBoulder(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BOULDERS);
    }

    public static void addFrostMagmaLakes(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BYGConfiguredFeatures.FROST_MAGMA_LAKE);
    }

    public static void addWarpedVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SOUL_SHROOM_SPORES);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WARPED_CORAL_PLANT);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WARPED_DESERT_VEGETATION);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_SOUL_SOIL_PILLARS);
    }

    public static void addSoulFireWarped(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_SOUL_FIRE_PATCH_WARPED);
    }

    public static void addFrostMagmaPillars(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_FROST_MAGMA_PILLARS);
    }

    public static void addMagmaPillars(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_MAGMA_PILLARS);
    }

    public static void addBrimstonePillars(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_BRIMSTONE_PILLARS);
    }

    public static void addBoricFire(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_BORIC_FIRE_PATCH);
    }

    public static void addMagmaFire(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_MAGMA_FIRE_PATCH);
    }

    public static void addSubzeroAsh(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_SUBZERO_ASH_PATCH);
    }

    public static void addScorchedPlants(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SCORCHED_PLANT);
    }

    public static void addWailingVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WARPED_CORAL_PLANT);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WAILING_VEGETATION);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_WAILING_VINES);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_CHAINS);
    }

    public static void addSythianVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SYTHIAN_FUNGUS);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SYTHIAN_STALK);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SYTHIAN_PLANT);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.SYTHIAN_FUNGUS_PILLARS_FEATURE);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.MOSSY_NETHERRACK_PILLARS_FEATURE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SYTHIAN_ROOTS);
    }

    public static void addGlowstoneGardenVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWSTONE_GARDEN_VEGETATION);
//        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_WEEPING_ROOTS);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_WEEPING_ROOTS_FEATURE);
    }

    public static void addDeadSeaSpires(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.RANDOM_DEAD_SEA_SPIKE);
    }

    public static void addHugeNetherMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredTreeFeatures.RANDOM_SOUL_SHROOM_TREES);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredTreeFeatures.RANDOM_DEATH_CAP_TREES);
    }

    public static void addMiniNetherMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MINI_MUSHROOMS);
    }

    public static void addTropFungalMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_MUSHROOM);

    }

    public static void addIvisPlants(BiomeGenerationSettings.Builder gen) {
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.IVIS_ROOTS).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.IVIS_SPROUT).decorate(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));
    }

    public static void addExtraCanyons(BiomeGenerationSettings.Builder gen) {
//        gen.addCarver(GenerationStep.Carver.AIR, gen.configureCarver(Carver.CANYON, new ProbabilityConfig(0.8F)));
    }

    public static void addGiantFlowerFeatures(BiomeGenerationSettings.Builder gen) {
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.GIANT_ANGELICA_FLOWER.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.3F, -1))));
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.GIANT_DANDELION_FLOWER.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.3F, -1))));
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.GIANT_IRIS_FLOWER.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.3F, -1))));
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.GIANT_ROSE_FLOWER.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.3F, -1))));
    }
}
