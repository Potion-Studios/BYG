package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;

public class BYGDefaultBiomeFeatures {
    public static void addAlliumFieldFlowers(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ALLIUM_FLOWER);
    }

    public static void addBasaltFeatures(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.RAW_GENERATION, BYGConfiguredFeatures.LARGE_BASALT_COLUMN);
        gen.feature(GenerationStep.Feature.RAW_GENERATION, BYGConfiguredFeatures.SMALL_BASALT_COLUMN);
        gen.feature(GenerationStep.Feature.RAW_GENERATION, BYGConfiguredFeatures.BASALT_DELTA);
    }

    public static void addBeeHive(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.BEEHIVES);
    }


    public static void addAmaranthFieldFlowers(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_AMARANTH_FLOWER);
    }

    public static void addRoseFieldFlowers(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ROSE_FIELD_FLOWER);
    }

    public static void addGlowcane(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWCANE);
    }

    public static void addFernGrass(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BYG_FERN_GRASS);
    }

    public static void addGrasslandBoulders(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.RAW_GENERATION, BYGConfiguredFeatures.GRASSLAND_BOULDER);
    }

    public static void addGraniteBoulder(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.RAW_GENERATION, BYGConfiguredFeatures.GRANITE_BOULDER);
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
        gen.feature(GenerationStep.Feature.RAW_GENERATION, BYGConfiguredFeatures.WIDE_WATER_LAKE);
    }

    public static void addCrimsonGardensVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_FUNGUS);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CRIMSON_GARDEN_VEGETATION);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.WEEPING_VINES);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLACKSTONE_BOULDERS);

    }

    public static void addEmburBogVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_MUSHROOM);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_BOG_PLANT);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.EMBUR_LILY);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_SPROUTS);

    }

    public static void addEmburBogVines(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_GEL_VINES);
    }

    public static void addAzalea(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_AZALEA);
    }

    public static void addSunFlowers(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SUNFLOWER);
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
//        biomeIn.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.configure(new DiskFeatureConfig(BYGBlocks.MUD_BLOCK.getDefaultState(), 4, 1, Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState()))).decorate(Decorator.COUNT_TOP_SOLID.configure(new CountDecoratorConfig(1))));
    }

    public static void addBYGMushrooms(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MUSHROOM);
    }

    public static void addMGCoral(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CORAL_MANGROVE);
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
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BOULDERS);
    }

    public static void addGiantLunaRocks(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.WHITE_SANDSTONE_BOULDER);
//        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.VALLE_DE_LUNA_POINTY_ROCK);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.VALLE_DE_LUNA_POINTY_ROCK_LARGE);
    }

    public static void addTerracottaBoulder(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_TERRACOTTA_BOULDERS);
    }

    public static void addMossyStoneBoulder(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BOULDERS);
    }

    public static void addFrostMagmaLakes(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, BYGConfiguredFeatures.FROST_MAGMA_LAKE);
    }

    public static void addWarpedVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SOUL_SHROOM_SPORES);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.WARPED_CORAL_PLANT);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WARPED_DESERT_VEGETATION);
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.SOUL_SOIL_PILLARS);
    }

    public static void addSoulFireWarped(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_SOUL_FIRE_PATCH_WARPED);
    }

    public static void addFrostMagmaPillars(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.FROST_MAGMA_PILLARS);
    }

    public static void addMagmaPillars(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.MAGMA_PILLARS);
    }

    public static void addBrimstonePillars(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.BRIMSTONE_PILLARS);
    }

    public static void addBoricFire(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_BORIC_FIRE_PATCH);
    }

    public static void addCrypticFire(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_CRYPTIC_FIRE_PATCH);
    }

    public static void addMagmaFire(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_MAGMA_FIRE_PATCH);
    }

    public static void addSubzeroAsh(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_SUBZERO_ASH_PATCH);
    }

    public static void addScorchedPlants(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SCORCHED_PLANT);
    }

    public static void addWailingVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WAILING_VEGETATION);
//        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_WAILING_VINES);
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.CHAINS);
    }

    public static void addWeepigMireVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LAMENT_VEGETATION);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.LAMENT_VINE_FEATURE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.EMBUR_LILY);
    }

    public static void addSythianVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SYTHIAN_FUNGUS);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.SYTHIAN_STALK);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SYTHIAN_PLANT);
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.SYTHIAN_FUNGUS_PILLARS);
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.MOSSY_NETHERRACK_PILLARS);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SYTHIAN_ROOTS);
    }

    public static void addQuartzDesertVegetations(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_QUARTZ_CRYSTAL_PATCH);
        gen.feature(GenerationStep.Feature.SURFACE_STRUCTURES, BYGConfiguredFeatures.QUARTZ_COLUMNS);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_BONE_FEATURE);
    }


    public static void addGlowstoneGardenVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWSTONE_GARDEN_VEGETATION);
//        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_WEEPING_ROOTS);
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.WEEPING_ROOTS);
    }

    public static void addDeadSeaSpires(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.RAW_GENERATION, BYGConfiguredFeatures.RANDOM_DEAD_SEA_SPIKE);
    }

    public static void addHugeNetherMushrooms(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_SOUL_SHROOM_TREES);
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_DEATH_CAP_TREES);
    }

    public static void addMiniNetherMushrooms(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_MINI_MUSHROOMS);
    }

    public static void addTropFungalMushrooms(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_HUGE_MUSHROOM);
    }

    public static void addIvisPlants(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_IVIS_PLANTS);
    }

    public static void addBulbisOddity(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BULBIS_ODDITY);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.EMBUR_LILY);
    }

    public static void addEnderLily(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.ENDER_LILY);
    }

    public static void addEtherPlants(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ETHER_PLANT);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_THEREAL_BELLFLOWER);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.ETHER_STONE_BOULDER);
    }

    public static void addNightshadePlants(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_NIGHTSHADE_PLANT);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_NIGHTSHADE_BERRIES);
    }

    public static void addShulkrenPlants(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SHULKREN_FUNGUS);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.SHULKREN_MOSS_PATCH);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SHULKREN_VINE);
    }

    public static void addShatteredDesertPlants(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ODDITY_PLANT);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.WHITE_SANDSTONE_BOULDER2);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.WHITE_SANDSTONE_BOULDER);
    }

    public static void addVermilionSculkGrowth(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.VERMILION_SCULK_GROWTH_PATCH);
    }

    public static void addTheriumCrystals(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.THERIUM_CRYSTALS);
    }

    public static void addHangingTheriumLanterns(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_THERIUM_LANTERNS);
    }

    public static void addGiantFlowerFeatures(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GIANT_FLOWER);
    }


    /*****Trees*****/
    public static void addAncientTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ANCIENT_TREE);
    }

    public static void addBlueTaigaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_BLUE_TREE);
    }

    public static void addBlackForestTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLACK_FOREST_TREE);
    }

    public static void addSparseBlackForestTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLACK_FOREST_SPARSE_TREE);
    }

    public static void addBorealTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BOREAL_TREE);
    }

    public static void addBorealSparseTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BOREAL_SPARSE_TREE);
    }

    public static void addConiferousTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CONIFER_TREE);
    }

    public static void addConiferousSparseTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CONIFER_SPARSE_TREE);
    }

    public static void addCypressTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CYPRESS_TREE);
    }

    public static void addDeciduousTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SHRUBLAND);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SHRUB);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ASPEN_TREE);
    }

    public static void addDeciduousSparseTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_SPARSE_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SHRUBLAND);
    }

    //TODO: Reconfigure
    public static void addRedwoodSparseTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_REDWOOD_SPARSE_TREE);
    }

    public static void addMapleTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MAPLE_TREE);
    }

    public static void addMapleSparseTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MAPLE_SPARSE_TREE);
    }

    public static void addGiantBlueTaigaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_BLUE_TREE_GIANT);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_BLUE_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
    }

    public static void addGiantSeasonalTaigaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_RED_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_YELLOW_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_ORANGE_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_SEASONAL_TREE_GIANT);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_TAIGA_MISC_TREE);
    }

    public static void addRedOakForestTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_OAK_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RED_OAK_TREE);
    }

    public static void addJacarandaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_JACARANDA_TREE);
    }

    public static void addSparseJacarandaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_JACARANDA_SPARSE_TREE);
    }

    public static void addSparseRedOakForestTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_RED_OAK_TREE);
    }

    public static void addSeasonalBirchForestTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_BIRCH_FOREST_TREE);
    }

    public static void addSeasonalDeciduousTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_RED_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_ORANGE_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_BROWN_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_SHRUB);
    }

    public static void addSparseSeasonalDeciduousTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_DECIDUOUS_SPARSE_TREE);
    }

    public static void addSeasonalForestTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_OAK_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RED_OAK_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORANGE_OAK_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BROWN_OAK_TREE);
    }

    public static void addSeasonalTaigaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_RED_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_YELLOW_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_ORANGE_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_TAIGA_MISC_TREE);
    }

    public static void addShrubs(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SHRUBLAND);
    }

    public static void addRainForestTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RAINFOREST_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.VINES);
    }

    public static void addStoneForestTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_STONE_FOREST_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.VINES);
    }

    public static void addFungalRainForestTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RAINFOREST_FUNGAL_TREE);
    }

    public static void addSparseRainforestTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RAINFOREST_SPARSE_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.VINES);
    }

    public static void addRainbowTrees(GenerationSettings.Builder gen) {
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGDefaultBiomeFeatures.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.5F, -4))));
    }

    public static void addCragRainbowTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CRAG_GARDEN_TREE);
    }

    public static void addCikaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CIKA_TREE);
    }

    public static void addPrairieTree(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PRAIRIE_TREE);
    }

    public static void addSpruceTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
    }

    public static void addRedSpruceTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_RED_TREE);
    }

    public static void addSmallSpruceTrees(GenerationSettings.Builder gen) {
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE.configure(SPRUCE_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.3F, 1))));
    }

    public static void addBluffTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLUFF_TREE);
    }

    public static void addDoverMTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_TAIGA_MISC_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DOVER_TREE);
    }

    public static void addNorthernForestTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_NORTHERN_FOREST_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DOVER_TREE);
    }

    public static void addSkyrisTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SKYRIS_TREE);
    }

    public static void addAraucariaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ARAUCARIA_TREE);
    }

    public static void addSparseAraucariaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ARAUCARIA_TREE);
    }

    public static void addBrownZelkovaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BROWN_ZELKOVA_TREE);
    }

    public static void addBaobabTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BAOBAB_TREE);
    }

    public static void addSavannaCanopyTrees(GenerationSettings.Builder gen) {
    }

    public static void addRedwoodTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_REDWOOD_TREE);
    }

    public static void addMeadowShrubs(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MEADOW_SHRUB);
    }

    public static void addMeadowTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MEADOW_TREE);
    }

    public static void addGroveTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GROVE_TREE);
    }

    public static void addEnchantedGroveTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ENCHANTED_GROVE_TREE);
    }

    public static void addEnchantedTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ENCHANTED_TREE);
    }

    public static void addLargePumpkins(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PUMPKIN_PATCH);
    }

    //TODO: Configured Pumpkin Random Selector
    public static void addWitchPumpkins(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PUMPKIN_PATCH);
    }

    public static void addMarshTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MARSH_TREE);
    }

    public static void addBayouVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BAYOU_TREE);
    }

    public static void addGlowshroomBayouVegetation(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWSHROOM_BAYOU_TREE);
    }

    public static void addAspenTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ASPEN_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ASPEN_SHRUB);

    }

    public static void addSparseClearingAspenTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ASPEN_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ASPEN_SHRUB);
    }

    public static void addSparseAspenTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ASPEN_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ASPEN_SHRUB);
    }

    public static void addZelkovaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ZELKOVA_TREE);
    }

    public static void addSparseZelkovaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ZELKOVA_TREE);
    }

    public static void addPaloVerdeTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PALO_VERDE_TREE);
    }

    public static void addJoshuaTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_JOSHUA_TREE);
    }

    //TODO: Random Selector Mojave Shrubs
    public static void addBushes(GenerationSettings.Builder gen) {
    }

    public static void addPalmTree(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PALM_TREE);
    }

    public static void addCherryTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CHERRY_TREE);
    }

    public static void addSparseCherryTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_CHERRY_TREE);
    }

    public static void addDeadHazelTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WITCH_HAZEL_TREE);
    }

    public static void addSparseDeadHazelTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_WITCH_HAZEL_TREE);
    }

    public static void addEbonyTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EBONY_TREE);
    }

    public static void addHollyTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_HOLLY_TREE);
    }

    public static void addSparseHollyTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_HOLLY_TREE);
    }

    public static void addMangroveTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MANGROVE_TREE);
    }

    public static void addSparseMangroveMarshes(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MANGROVE_SPARSE_TREE);
    }

    public static void addOrchardTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORCHARD_TREE);
    }

    public static void addHugeMushrooms(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_HUGE_MUSHROOM);
    }

    public static void addHugeGlowshrooms(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_HUGE_GLOWSHROOM);
    }

    public static void addWoodlandTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WOODLAND_TREE);
    }

    public static void addDummyTree(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.DUMMY_TREE);
    }

    public static void addLamentTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_TWISTY_LAMENT_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WEEPING_LAMENT_TREE);
    }

    public static void addWitheringOakTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WITHERING_OAK_TREE);
    }

    public static void addSparseWitheringOakTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_WITHERING_OAK_TREE);
    }

    public static void addBulbisTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BULBIS_TREE);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PURPLE_BULBIS_TREE);
    }

    public static void addSparsePurpleBulbisTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_PURPLE_BULBIS_TREE);
    }

    public static void addEtherTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ETHER_TREE);
    }

    public static void addShulkrenTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SHULKREN_TREE);
    }

    public static void addDeadEtherTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DEAD_ETHER_TREE);
    }

    public static void addNightShadeTrees(GenerationSettings.Builder gen) {
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_NIGHTSHADE_TREE);
    }
}
