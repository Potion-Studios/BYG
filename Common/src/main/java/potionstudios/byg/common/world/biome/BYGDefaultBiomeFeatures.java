package potionstudios.byg.common.world.biome;

import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import potionstudios.byg.common.world.feature.BYGPlacedFeatures;

public class BYGDefaultBiomeFeatures {
    public static void addAlliumFieldFlowers(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ALLIUM_FIELD_FLOWERS);
    }

    public static void addBasaltFeatures(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.LARGE_BASALT_COLUMN);
        //gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.SMALL_BASALT_COLUMN);
        //gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.BASALT_DELTA);
    }

    public static void addBeeHive(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BEEHIVES);
    }

    public static void addDeadSeaSpires(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.DEAD_SEA_SPIKES);
    }

    public static void addAmaranthFieldFlowers(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.AMARANTH_FIELD_FLOWERS);
    }

    public static void addRoseFieldFlowers(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ROSE_FIELD_FLOWERS);
    }

    public static void addLargeBoulders(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.LARGE_BOULDERS);
    }

    public static void addGraniteLargeBoulder(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.LARGE_GRANITE_BOULDERS);
    }

    public static void addWindsweptBoulders(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.LARGE_WINDSWEPT_BOULDERS);
    }

    public static void addBYGDesertVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.DESERT_VEGETATION);
    }

    public static void addLushBYGDesertVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.LUSH_DESERT_VEGETATION);
    }


    public static void addFirecracker(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.FIRECRACKER_BUSH);
    }

    public static void addPrairieGrass(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.PRAIRIE_GRASS);
    }

    public static void addPumpkinPatch(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.PUMPKINS);
    }

    public static void addBlueberries(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BLUE_BERRY_BUSH);
    }

    public static void addLushBlueberries(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BLUE_BERRY_BUSH_LUSH);
    }

    public static void addBeachGrass(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BEACH_GRASS);
    }

    public static void addCragGen(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.CRAG_DELTA);
        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.CRAG_GEN);
    }

    public static void addOvergrownVines(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.VINES_1);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.VINES_2);
    }


    public static void addEndLake(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.END_LAKE);
    }

    public static void addOverworldLake(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.OVERWORLD_LAKE);
    }

    public static void addLargeWindsweptLake(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.LAKES, BYGPlacedFeatures.LARGE_WINDSWEPT_LAKE);
    }

    public static void addBulbisLake(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.BULBIS_WATER_LAKE);
    }

    public static void addCrimsonGardensVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CRIMSON_GARDEN_VEGETATION);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.FUNGI);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.WEEPING_VINES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BLACKSTONE_BOULDERS_NETHER);

    }

    public static void addEmburBogVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.EMBUR_MUSHROOMS);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.EMBUR_BOG_VEGETATION);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.EMBUR_LILY);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.EMBUR_SPROUT);
    }

    public static void addBlueNetherOres(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.ORE_GOLD_BLUE_NETHERRACK);
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.ORE_QUARTZ_BLUE_NETHERRACK);
    }

    public static void addVanillaSunFlowers(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUNFLOWER);
    }

    public static void addDelphinium(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.DELPHINIUMS);
    }

    public static void addJapaneseOrchid(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.JAPANESE_ORCHID);
    }

    public static void addWiltedGrass(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WILTED_GRASS);
    }

    public static void addLeafPile(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.LEAF_PILES);
    }

    public static void addCloverFlowerPatch(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CLOVER_FLOWERS);
    }

    public static void addCherryFoliage(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CHERRY_FOLIAGE);
    }

    public static void addBYGSwampVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SWAMP_WATER_VEGETATION);
    }


    public static void addLilyPads(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.TINY_LILY_PAD);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.LILY_PAD);

    }

    public static void addHorseweed(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.HORSEWEED);
    }

    public static void addWinterSucculent(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.WINTER_SUCCULENT);
    }

    public static void addShortGrass(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SHORT_GRASSES);
    }

    public static void addIris(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.IRIS);
    }

    public static void addTulips(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.TULIPS);
    }

    public static void addCaliforniaPoppy(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.CALIFORNIA_POPPIES);
    }

    public static void addCrocus(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CROCUS);
    }

    public static void addAlpineBellflower(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ALPINE_BELLFLOWER);
    }

    public static void addWinterScilla(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WINTER_SCILLAS);
    }

    public static void addYellowDaffodil(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.DAFFODIL_YELLOW);
    }

    public static void addDaffodil(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DAFFODILS);
    }

    public static void addPinkDaffodil(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DAFFODILS);
    }

    public static void addLolliPop(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.LOLLIPOP_FLOWERS);
    }

    public static void addRose(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ROSES);
    }

    public static void addBlackRose(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BLACK_ROSE);
    }

    public static void addOsiria(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.OSIRIA_ROSES);
    }

    public static void addWinterRose(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.WINTER_ROSES);
    }

    public static void addMeadowGrass(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_TALL_GRASS_2);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.MEADOW_GRASS);
    }


    public static void addSnowdrops(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SNOWDROPS);
    }

    public static void addMudDisks(BiomeGenerationSettings.Builder biomeIn) {
        biomeIn.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BYGPlacedFeatures.DISK_MUD);
    }

    public static void addBYGMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.MUSHROOMS);
    }

    public static void addWhitePuffball(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.WHITE_PUFFBALL);
    }

    public static void addMGCoral(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CORAL_MANGROVE);
    }

    public static void addAnemones(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ANEMONES);
    }

    public static void addFoxgloves(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.FOXGLOVES);
    }

    public static void addCattails(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CATTAIL);
    }

    public static void addReeds(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.REEDS);

    }

    public static void addFairyslipper(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.FAIRY_SLIPPER);
    }

    public static void addCyanRose(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CYAN_ROSE);
    }

    public static void addLeatherFlowers(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.LEATHER_FLOWERS);
    }

    public static void addKovanFlower(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.KOVAN_FLOWERS);
    }

    public static void addShrub(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SHRUB);
    }

    public static void addMarshGrass(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_TALL_GRASS_2);
    }

    public static void addTallGrass(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_TALL_GRASS);
    }


    public static void addSages(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SAGES);
    }

    public static void addHydrangeas(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.HYDRANGEAS);
    }

    public static void addOrangeDaisy(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.DAISY_ORANGE);
    }

    public static void addPinkAllium(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.PINK_ALLIUMS);
    }

    public static void addJacarandaBushes(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.JACARANDA_BUSHES);
    }

    public static void addBYGTropicFlowers(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.JUNGLE_FLOWERS);
    }

    public static void addRockyStoneBoulder(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.ROCKY_STONE_BOULDER);
    }

    public static void addGiantLunaRocks(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WHITE_SANDSTONE_BOULDER);
//        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.VALLE_DE_LUNA_POINTY_ROCK);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.VALLE_DE_LUNA_POINTY_ROCK_LARGE);
    }

    public static void addTerracottaBoulder(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.ORANGE_TERRACOTTA_BOULDER);
    }

    public static void addMossyStoneBoulder(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.MOSSY_STONE_BOULDER);
    }

    public static void addFrostMagmaLakes(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, BYGPlacedFeatures.FROST_MAGMA_LAKE);
    }

    public static void addWarpedVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.HANGING_SOUL_SHROOM_SPORES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.WARPED_CORAL_PLANT);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.WARPED_DESERT_VEGETATION);
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.SOUL_SOIL_PILLARS);
    }

    public static void addSoulFireWarped(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.NYLIUM_SOUL_PATCH_FIRE);
    }

    public static void addFrostMagmaPillars(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.FROST_MAGMA_PILLARS);
    }

    public static void addMagmaPillars(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.MAGMA_PILLARS);
    }

    public static void addBrimstoneOres(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.ORE_ANTHRACITE);
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.ORE_QUARTZ_BRIMSTONE);
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.ORE_GOLD_BRIMSTONE);
    }

    public static void addBrimstonePillars(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.BRIMSTONE_PILLARS);
    }

    public static void addBrimstoneVents(BiomeGenerationSettings.Builder gen) {
//        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.BRIMSTONE_VOLCANO);
    }

    public static void addBoricFire(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.BORIC_FIRE);
    }

    public static void addCrypticFire(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.CRYPTIC_FIRE);
    }

    public static void addCrypticVents(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CRYPTIC_VENTS);
    }

    public static void addCrypticBramble(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CRYPTIC_BRAMBLE);
    }

    public static void addMagmaFire(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.MAGMA_PATCH_FIRE);
    }

    public static void addSubzeroAsh(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.SUBZERO_ASHES);
    }

    public static void addScorchedPlants(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SCORCHED_PLANTS);
    }

    public static void addWailingVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.WAILING_VEGETATION);
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.WAILING_VINES);
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.CHAINS);
    }

    public static void addWeepigMireVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.LAMENT_VEGETATION);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.LAMENT_VINE_FEATURE);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.EMBUR_LILY);
    }

    public static void addSythianVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SYTHIAN_FUNGI_TREES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SYTHIAN_STALK);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SYTHIAN_VEGETATION);
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.SYTHIAN_FUNGUS_PILLARS);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.HANGING_SYTHIAN_ROOTS);
    }

    public static void addQuartzDesertVegetations(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.QUARTZ_CRYSTALS);
        gen.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, BYGPlacedFeatures.QUARTZ_COLUMNS);
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.QUARTZ_SPIKE);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.HANGING_BONE_FEATURE);
    }


    public static void addGlowstoneGardenVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.GLOWSTONE_GARDEN_VEGETATION);
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.WEEPING_VINES);
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.WEEPING_ROOTS);
    }

    public static void addlushStacksSpires(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.LUSH_STACKS_SPIKES);
    }

    public static void addHugeNetherMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.SOUL_SHROOM_TREES);
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.DEATH_CAP_TREES);
    }

    public static void addMiniNetherMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGPlacedFeatures.MINI_MUSHROOMS);
    }

    public static void addIvisPlants(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.IVIS_PLANTS);
    }

    public static void addBulbisOddity(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BULBIS_ODDITIES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BULBIS_SPROUTS);
    }

    public static void addBulbisAnomaly(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BULBIS_ANOMALIES);
    }

    public static void addSparseBulbisAnomaly(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPARSE_BULBIS_ANOMALIES);
    }

    public static void addEnderLily(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ENDER_LILY);
    }

    public static void addEtherPlants(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ETHER_PLANTS);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.THEREAL_BELLFLOWER);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ETHER_BULBS);
    }

    public static void addTheriumDeposit(BiomeGenerationSettings.Builder gen) {
//        gen.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGPlacedFeatures.THERIUM_DEPOSIT);
    }

    public static void addEtherFoliage(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ETHER_FOLIAGE);
    }

    public static void addNightshadePlants(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.NIGHTSHADE_PLANTS);
    }

    public static void addShulkrenPlants(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SHULKREN_PLANTS);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SHULKREN_HANGING_VINES);
    }

    public static void addImpariusPlants(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.IMPARIUS_PLANTS);
    }

    public static void addShatteredDesertPlants(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ODDITY_PLANT);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.END_STONE_BOULDER);
//        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WHITE_SANDSTONE_BOULDER);
    }

    public static void addHangingTheriumLanterns(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.HANGING_THERIUM_LANTERNS);
    }

    public static void addHangingChains(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.HANGING_CHAINS);
    }

    public static void addHangingLanterns(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.HANGING_LANTERNS);
    }

    public static void addGiantFlowerFeatures(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GIANT_FLOWER);
    }


    /*****Trees*****/
    public static void addAncientTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ANCIENT_TREE);
    }

    public static void addBlueSpruceTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BLUE_SPRUCE_TREES);
    }

    public static void addBlackForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BLACK_FOREST_TREES);
    }

    public static void addSparseBlackForestTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLACK_FOREST_SPARSE_TREE);
    }

    public static void addBorealTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BOREAL_TREES);
    }

    public static void addBorealSparseTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BOREAL_SPARSE_TREE);
    }

    public static void addConiferousTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CONIFER_TREES);
    }

    public static void addConiferousSparseTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CONIFER_SPARSE_TREE);
    }

    public static void addCypressTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CYPRESS_TREES);
    }

    public static void addDeciduousForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.DECIDUOUS_TREES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.PRAIRIE_SHRUBS);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ASPEN_TREES_SPARSE);
    }

    public static void addDeciduousSparseTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_SPARSE_TREE);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SHRUB);
    }

    //TODO: Reconfigure
    public static void addRedwoodSparseTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_REDWOOD_SPARSE_TREE);
    }

    public static void addMapleTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.MAPLE_TREES);
    }

    public static void addMapleSparseTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MAPLE_SPARSE_TREE);
    }

    public static void addGiantBlueTaigaTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_BLUE_TREE_GIANT);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_BLUE_TREE);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
    }

    public static void addGiantSeasonalTaigaTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_RED_TREE);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_YELLOW_TREE);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_ORANGE_TREE);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_SEASONAL_TREE_GIANT);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_TAIGA_MISC_TREE);
    }

    public static void addRedOakForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.OAK_TREES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.RED_OAK_TREES);
    }

    public static void addOakForestTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_OAK_TREE);
    }

    public static void addJacarandaTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.JACARANDA_TREES);
    }

    public static void addSparseJacarandaTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPARSE_JACARANDA_TREES);
    }

    public static void addSparseRedOakForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPARSE_RED_OAK_TREES);
    }

    public static void addSparseOakForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPARSE_OAK_TREES);
    }

    public static void addAutumnalForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.AUTUMNAL_OAK_TREES);
    }

    public static void addAutumnalTaigaTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.AUTUMNAL_SPRUCE_TREES);
    }

    public static void addFirecrackerShrubs(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.FIRECRACKER_SHRUBS);
    }

    public static void addGuianaShieldTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.GUIANA_SHIELD_TREES);
    }

    public static void addFragmentForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.FRAGMENT_FOREST_TREES);
    }

    public static void addRainForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.RAINFOREST_TREES);
    }

    public static void addSparseRainforestTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RAINFOREST_SPARSE_TREE);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.VINES);
    }

    public static void addRainbowTrees(BiomeGenerationSettings.Builder gen) {
        ////gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGDefaultBiomeFeatures.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.5F, -4))));
    }

    public static void adddCragVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.PATCH_GRASS_CRAG);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.RAINBOW_EUCALYPTUS_TREES);
    }

    public static void addCikaTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CIKA_TREES);
    }

    public static void addPrairieShrubs(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.PRAIRIE_SHRUBS);
    }

    public static void addScarceSpruceTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPRUCE_TREES_SPARSE);
    }

//    public static void addRedSpruceTrees(BiomeGenerationSettings.Builder gen) {
//        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_RED_TREE);
//    }

    public static void addSpareRedSpruceTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.RED_SPRUCE_TREES_SPARSE);
    }

    public static void addSparseSpruceTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPRUCE_TREES_SPARSE);
    }

    public static void addCanadianShieldTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CANADIAN_SHIELD_TREES);
    }

    public static void addDaciteRidgeTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.DACITE_RIDGE_TREES);
    }

    public static void addNorthernForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.NORTHERN_FOREST_TREES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPRUCE_TREES_SPARSE);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.DACITE_RIDGE_TREES);
    }

    public static void addSkyrisTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SKYRIS_TREES);
    }

    public static void addSparseSkyrisTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_SKYRIS_TREE);
    }

    public static void addAraucariaTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ARAUCARIA_TREES);
    }

    public static void addSparseAraucariaTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPARSE_ARAUCARIA_TREES);
    }

    public static void addBrownZelkovaTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BROWN_ZELKOVA_TREES);
    }

    public static void addBaobabTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BAOBAB_TREES);
    }

    public static void addSavannaCanopyTrees(BiomeGenerationSettings.Builder gen) {
    }

    public static void addRedwoodTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.REDWOOD_TREES);
    }

    public static void addMeadowShrubs(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.MEADOW_SHRUBS);
    }

    public static void addMeadowTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.MEADOW_TREES);
    }

    public static void addSparseMeadowTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.MEADOW_TREES_SPARSE);
    }

    public static void addGroveTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.TEMPERATE_GROVE_TREES);
    }

    public static void addEnchantedGroveTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ENCHANTED_GROVE_TREE);
    }

    public static void addEnchantedTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ENCHANTED_TREES);
    }

    public static void addLargePumpkins(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.LARGE_PUMPKINS);
    }

    //TODO: Configured Pumpkin Random Selector
    public static void addWitchPumpkins(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PUMPKIN_PATCH);
    }

    public static void addBayouVegetation(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BAYOU_TREES);
    }

    public static void addSparseWillowTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_BAYOU_TREE);
    }

    public static void addAspenTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ASPEN_TREES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ASPEN_SHRUBS);

    }

    public static void addSparseClearingAspenTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ASPEN_TREE);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ASPEN_SHRUB);
    }

    public static void addSparseAspenTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ASPEN_TREES_SPARSE);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ASPEN_SHRUBS);
    }

    public static void addZelkovaTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ZELKOVA_TREES);
    }

    public static void addSparseZelkovaTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ZELKOVA_TREE);
    }

    public static void addPaloVerdeTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.PALO_VERDE_TREES);
    }

    public static void addJoshuaTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.JOSHUA_TREES);
    }

    //TODO: Random Selector Mojave Shrubs
    public static void addBushes(BiomeGenerationSettings.Builder gen) {
        ////gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGDefaultBiomeFeatures.SHRUB_PRAIRIE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.8F, 2))));
        ////gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGDefaultBiomeFeatures.SHRUB_PRAIRIE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.8F, 2))));
    }

    public static void addPalmTree(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.PALM_TREES);
    }

    public static void addCherryTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.CHERRY_TREES);
    }

    public static void addSparseCherryTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_CHERRY_TREE);
    }

    public static void addHazelTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.HAZEL_TREES);
    }

    public static void addSparseDeadHazelTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_WITCH_HAZEL_TREE);
    }

    public static void addEbonyTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.EBONY_TREES);
    }

    public static void addHollyTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.HOLLY_TREES);
    }


    public static void addSparseHollyTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_HOLLY_TREE);
    }

    public static void addMangroveTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.MANGROVE_TREES);
    }

    public static void addSparseMangroveMarshes(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MANGROVE_SPARSE_TREE);
    }

    public static void addOrchardTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ORCHARD_TREES);
    }

    public static void addSparseHugeMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPARSE_HUGE_MUSHROOMS);
    }

    public static void addHugeMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.HUGE_MUSHROOMS);
    }

    public static void addTemperateRainforestTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.TEMPERATE_RAINFOREST_TREES);
    }

    public static void addDummyTree(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.DUMMY_TREE);
    }

    public static void addLamentTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.TWISTY_LAMENT_TREES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.WEEPING_LAMENT_TREES);
    }

    public static void addWailingPillars(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.WAILING_PILLARS);
    }

    public static void addWitheringOakTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.WITHERING_OAK_TREES);
    }

    public static void addSparseWitheringOakTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPARSE_WITHERING_OAK_TREES);
    }

    public static void addBulbisTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.BULBIS_TREES);
    }

    public static void addPurpleBulbisTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.PURPLE_BULBIS_TREES);
    }

    public static void addSparseBulbisTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_BULBIS_TREE);
    }

    public static void addSparsePurpleBulbisTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPARSE_PURPLE_BULBIS_TREES);
    }

    public static void addEtherTrees(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ETHER_TREE);
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ETHER_BUSH);
    }

    public static void addEtherBushes(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ETHER_BUSH);
    }

    public static void addSparseEtherTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SPARSE_ETHER_TREES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.ETHER_BUSHES);
    }

    public static void addShulkrenTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.SHULKREN_TREES);
    }

    public static void addLargeImpariusMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.IMPARIUS_MUSHROOMS);
    }

    public static void addFungalImparius(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.FUNGAL_IMPARIUS);
    }

    public static void addImpariusMushroomShrubs(BiomeGenerationSettings.Builder gen) {
        //gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_IMPARIUS_MUSHROOM_SHRUBS);
    }

    public static void addDeadEtherTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.DEAD_ETHER_TREES);
    }

    public static void addNightShadeTrees(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.NIGHTSHADE_TREES);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BYGPlacedFeatures.NIGHTSHADE_SHRUBS);
    }
}
