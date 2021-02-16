package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;

public class BYGDefaultBiomeFeatures {
    public static void addAlliumFieldFlowers(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ALLIUM_FLOWER);
    }

    public static void addBasaltFeatures(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.LARGE_BASALT_COLUMN);
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.SMALL_BASALT_COLUMN);
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.BASALT_DELTA);
    }

    public static void addBeeHive(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.BEEHIVES);
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
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.FIRECRACKER_BUSHES);
    }

    public static void addPrairieGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PRAIRIE_GRASS);
    }

    public static void addPumpkinPatch(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.PUMPKINS);
    }

    public static void addBlueberries(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.BLUE_BERRY_BUSHES);
    }

    public static void addLushBlueberries(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.LUSH_BLUE_BERRY_BUSHES);
    }

    public static void addBeachGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BEACH_GRASS);
    }

    public static void addLargeLake(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.WIDE_WATER_LAKE);
    }

    public static void addEndLake(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.END_LAKE);
    }

    public static void addBulbisLake(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.BULBIS_WATER_LAKE);
    }

    public static void addCrimsonGardensVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_FUNGUS);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CRIMSON_GARDEN_VEGETATION);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WEEPING_VINES);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.BLACKSTONE_BOULDERS);

    }

    public static void addEmburBogVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_MUSHROOM);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_BOG_PLANT);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.EMBUR_LILY);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.EMBUR_SPROUTS);

    }

    public static void addEmburBogVines(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.EMBUR_GEL_VINES);
    }

    public static void addAzalea(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.AZALEAS);
    }

    public static void addSunFlowers(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SUNFLOWERS);
    }

    public static void addDelphinium(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.DELPHINIUMS);
    }

    public static void addJapaneseOrchid(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.JAPANESE_ORCHIDS);
    }

    public static void addWiltedGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WILTED_GRASS);
    }

    public static void addWeedGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WEED_GRASS);
    }

    public static void addWinterGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WINTER_GRASS);
    }

    public static void addLeafPile(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.LEAF_PILES);
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
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HORSEWEEDS);
    }

    public static void addWinterSucculent(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WINTER_SUCCLULENTS);
    }

    public static void addShortGrass(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SHORT_GRASSES);
    }

    public static void addIris(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.IRISES);
    }

    public static void addTulips(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_TULIP);
    }

    public static void addCaliforniaPoppy(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.CALIFORNIA_POPPIES);
    }

    public static void addCrocus(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.CROCUSES);
    }

    public static void addAlpineBellflower(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.ALPINE_BELLFLOWERS);
    }

    public static void addWinterScilla(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WINTER_SCILLAS);
    }

    public static void addYellowDaffodil(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.YELLOW_DAFFODILS);
    }

    public static void addDaffodil(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DAFFODILS);
    }

    public static void addPinkDaffodil(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DAFFODILS);
    }

    public static void addLolliPop(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.LOLIPOP_FLOWERS);
    }

    public static void addRose(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.ROSES);
    }

    public static void addBlackRose(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.BLACK_ROSES);
    }

    public static void addOsiria(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.OSIRIA_ROSES);
    }

    public static void addWinterRose(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WINTER_ROSES);
    }

    public static void addSnowdrops(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SNOWDROPS);
    }

    public static void addMudDisks(BiomeGenerationSettings.Builder biomeIn) {
//        biomeIn.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.configure(new DiskFeatureConfig(BYGBlocks.MUD_BLOCK.getDefaultState(), 4, 1, Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState()))).decorate(Decorator.COUNT_TOP_SOLID.configure(new CountDecoratorConfig(1))));
    }

    public static void addBYGMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MUSHROOM);
    }

    public static void addMGCoral(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CORAL_MANGROVE);
    }

    public static void addGlowshrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWSHROOM);
    }

    public static void addAnemones(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ANEMONE);
    }

    public static void addFoxgloves(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.FOXGLOVES);
    }

    public static void addCattails(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.CATTAILS);

    }

    public static void addReeds(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.REEDS);

    }

    public static void addFairyslipper(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.FAIRY_SLIPPER);
    }

    public static void addCyanRose(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.CYAN_ROSES);
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
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.KOVAN_FLOWERS);
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
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.ORANGE_DAISIES);
    }

    public static void addPinkAllium(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.PINK_ALLIUMS);
    }

    public static void addRedCornflower(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RED_CORNFLOWERS);
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
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.ROCKY_STONE_BOULDERS);
    }

    public static void addGiantLunaRocks(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WHITE_SANDSTONE_BOULDER);
//        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.VALLE_DE_LUNA_POINTY_ROCK);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.VALLE_DE_LUNA_POINTY_ROCK_LARGE);
    }

    public static void addTerracottaBoulder(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.ORANGE_TERRACOTTA_BOULDERS);
    }

    public static void addMossyStoneBoulder(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.MOSSY_STONE_BOULDER);
    }

    public static void addFrostMagmaLakes(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BYGConfiguredFeatures.FROST_MAGMA_LAKE);
    }

    public static void addWarpedVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SOUL_SHROOM_SPORES);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WARPED_CORAL_PLANT);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WARPED_DESERT_VEGETATION);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.SOUL_SOIL_PILLARS);
    }

    public static void addSoulFireWarped(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.NYLIUM_SOUL_FIRE);
    }

    public static void addFrostMagmaPillars(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.FROST_MAGMA_PILLARS);
    }

    public static void addMagmaPillars(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.MAGMA_PILLARS);
    }

    public static void addBrimstonePillars(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.BRIMSTONE_PILLARS);
    }

    public static void addBoricFire(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.BORIC_FIRE);
    }

    public static void addCrypticFire(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.CRYPTIC_FIRE);
    }

    public static void addCrypticVents(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CRYPTIC_VENT);
    }

    public static void addCrypticBramble(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.CRYPTIC_BRAMBLES);
    }

    public static void addMagmaFire(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.MAGMA_FIRE);
    }

    public static void addSubzeroAsh(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_SUBZERO_ASH_PATCH);
    }

    public static void addScorchedPlants(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SCORCHED_PLANT);
    }

    public static void addWailingVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WAILING_VEGETATION);
//        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_WAILING_VINES);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.CHAINS);
    }

    public static void addWeepigMireVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_LAMENT_VEGETATION);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.LAMENT_VINE_FEATURE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.EMBUR_LILY);
    }

    public static void addSythianVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SYTHIAN_FUNGUS);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SYTHIAN_STALK);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SYTHIAN_PLANT);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.SYTHIAN_FUNGUS_PILLARS);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.MOSSY_NETHERRACK_PILLARS);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SYTHIAN_ROOTS);
    }

    public static void addQuartzDesertVegetations(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.QUARTZ_CRYSTALS);
        gen.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, BYGConfiguredFeatures.QUARTZ_COLUMNS);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_BONE_FEATURE);
    }


    public static void addGlowstoneGardenVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWSTONE_GARDEN_VEGETATION);
//        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_WEEPING_ROOTS);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.WEEPING_ROOTS);
    }

    public static void addDeadSeaSpires(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.RANDOM_DEAD_SEA_SPIKE);
    }

    public static void addHugeNetherMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_SOUL_SHROOM_TREES);
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_DEATH_CAP_TREES);
    }

    public static void addMiniNetherMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_MINI_MUSHROOMS);
    }

    public static void addTropFungalMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_HUGE_MUSHROOM);
    }

    public static void addIvisPlants(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_IVIS_PLANTS);
    }

    public static void addBulbisOddity(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BULBIS_ODDITY);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.BULBIS_SPROUT_PLANT);
    }

    public static void addBulbisAnomaly(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BULBIS_ANOMALY);
    }

    public static void addEnderLily(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.ENDER_LILY);
    }

    public static void addEtherPlants(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ETHER_PLANT);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.THEREAL_BELLFLOWERS);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.ETHER_BULBS);
        gen.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.ETHER_STONE_BOULDER);
    }

    public static void addTheriumDeposit(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.THERIUM_CRYSTAL_DEPOSIT);
        gen.withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, BYGConfiguredFeatures.THERIUM_CRYSTALS);
    }

    public static void addEtherFoliage(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.ETHER_FOLIAGES);
    }

    public static void addNightshadePlants(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_NIGHTSHADE_PLANT);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.NIGHTSHADE_BERRY_BUSHES);
    }

    public static void addShulkrenPlants(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SHULKREN_FUNGI);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SHULKREN_MOSS);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SHULKREN_VINE);
    }

    public static void addShatteredDesertPlants(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ODDITY_PLANT);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WHITE_SANDSTONE_BOULDER2);
//        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.WHITE_SANDSTONE_BOULDER);
    }

    public static void addVermilionSculkGrowth(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.VERMILION_SCULK_GROWTHS);
    }

    public static void addVermilionSculkTendrils(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.VERMILION_SCULK_TENDRIL);
    }

    public static void addHangingTheriumLanterns(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_THERIUM_LANTERNS);
    }

    public static void addGiantFlowerFeatures(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GIANT_FLOWER);
    }


    /*****Trees*****/
    public static void addAncientTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ANCIENT_TREE);
    }

    public static void addBlueTaigaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_BLUE_TREE);
    }

    public static void addBlackForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLACK_FOREST_TREE);
    }

    public static void addSparseBlackForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLACK_FOREST_SPARSE_TREE);
    }

    public static void addBorealTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BOREAL_TREE);
    }

    public static void addBorealSparseTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BOREAL_SPARSE_TREE);
    }

    public static void addConiferousTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CONIFER_TREE);
    }

    public static void addConiferousSparseTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CONIFER_SPARSE_TREE);
    }

    public static void addCypressTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CYPRESS_TREE);
    }

    public static void addDeciduousTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SHRUBLAND_SHRUB);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SHRUB);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ASPEN_TREE);
    }

    public static void addDeciduousSparseTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_SPARSE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SHRUBLAND_SHRUB);
    }

    //TODO: Reconfigure
    public static void addRedwoodSparseTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_REDWOOD_SPARSE_TREE);
    }

    public static void addMapleTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MAPLE_TREE);
    }

    public static void addMapleSparseTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MAPLE_SPARSE_TREE);
    }

    public static void addGiantBlueTaigaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_BLUE_TREE_GIANT);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_BLUE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
    }

    public static void addGiantSeasonalTaigaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_RED_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_YELLOW_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_ORANGE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_SEASONAL_TREE_GIANT);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_TAIGA_MISC_TREE);
    }

    public static void addRedOakForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_OAK_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RED_OAK_TREE);
    }

    public static void addJacarandaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_JACARANDA_TREE);
    }

    public static void addSparseJacarandaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_JACARANDA_SPARSE_TREE);
    }

    public static void addSparseRedOakForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_RED_OAK_TREE);
    }

    public static void addSeasonalBirchForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_BIRCH_FOREST_TREE);
    }

    public static void addSeasonalDeciduousTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_RED_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_ORANGE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DECIDUOUS_BROWN_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_SHRUB);
    }

    public static void addSparseSeasonalDeciduousTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_DECIDUOUS_SPARSE_TREE);
    }

    public static void addSeasonalForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_OAK_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RED_OAK_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORANGE_OAK_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BROWN_OAK_TREE);
    }

    public static void addSeasonalTaigaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_RED_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_YELLOW_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_ORANGE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_TAIGA_MISC_TREE);
    }

    public static void addShrubs(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.SHRUBLAND_SHRUB);
    }

    public static void addRainForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RAINFOREST_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.VINES);
    }

    public static void addStoneForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_STONE_FOREST_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.VINES);
    }

    public static void addFungalRainForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RAINFOREST_FUNGAL_TREE);
    }

    public static void addSparseRainforestTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_RAINFOREST_SPARSE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.VINES);
    }

    public static void addRainbowTrees(BiomeGenerationSettings.Builder gen) {
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGDefaultBiomeFeatures.RAINBOW_TREE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.5F, -4))));
    }

    public static void addCragRainbowTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CRAG_GARDEN_TREE);
    }

    public static void addCikaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CIKA_TREE);
    }

    public static void addPrairieTree(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PRAIRIE_TREE);
    }

    public static void addSpruceTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
    }

    public static void addRedSpruceTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_RED_TREE);
    }

    public static void addSmallSpruceTrees(BiomeGenerationSettings.Builder gen) {
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE.configure(SPRUCE_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.3F, 1))));
    }

    public static void addBluffTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BLUFF_TREE);
    }

    public static void addDoverMTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SEASONAL_TAIGA_MISC_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DOVER_TREE);
    }

    public static void addNorthernForestTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_NORTHERN_FOREST_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPRUCE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DOVER_TREE);
    }

    public static void addSkyrisTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SKYRIS_TREE);
    }

    public static void addAraucariaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ARAUCARIA_TREE);
    }

    public static void addSparseAraucariaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ARAUCARIA_TREE);
    }

    public static void addBrownZelkovaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BROWN_ZELKOVA_TREE);
    }

    public static void addBaobabTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BAOBAB_TREE);
    }

    public static void addSavannaCanopyTrees(BiomeGenerationSettings.Builder gen) {
    }

    public static void addRedwoodTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_REDWOOD_TREE);
    }

    public static void addMeadowShrubs(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MEADOW_SHRUB);
    }

    public static void addMeadowTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MEADOW_TREE);
    }

    public static void addGroveTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GROVE_TREE);
    }

    public static void addEnchantedGroveTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ENCHANTED_GROVE_TREE);
    }

    public static void addEnchantedTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ENCHANTED_TREE);
    }

    public static void addLargePumpkins(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PUMPKIN_PATCH);
    }

    //TODO: Configured Pumpkin Random Selector
    public static void addWitchPumpkins(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PUMPKIN_PATCH);
    }

    public static void addMarshTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MARSH_TREE);
    }

    public static void addBayouVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BAYOU_TREE);
    }

    public static void addSparseWillowTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_BAYOU_TREE);
    }

    public static void addGlowshroomBayouVegetation(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_GLOWSHROOM_BAYOU_TREE);
    }

    public static void addAspenTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ASPEN_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ASPEN_SHRUB);

    }

    public static void addSparseClearingAspenTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ASPEN_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ASPEN_SHRUB);
    }

    public static void addSparseAspenTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ASPEN_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ASPEN_SHRUB);
    }

    public static void addZelkovaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ZELKOVA_TREE);
    }

    public static void addSparseZelkovaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ZELKOVA_TREE);
    }

    public static void addPaloVerdeTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PALO_VERDE_TREE);
    }

    public static void addJoshuaTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_JOSHUA_TREE);
    }

    //TODO: Random Selector Mojave Shrubs
    public static void addBushes(BiomeGenerationSettings.Builder gen) {
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGDefaultBiomeFeatures.SHRUB_PRAIRIE1.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.8F, 2))));
        //gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGDefaultBiomeFeatures.SHRUB_PRAIRIE2.configure(DecoratedFeatureConfig.DEFAULT).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.8F, 2))));
    }

    public static void addPalmTree(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PALM_TREE);
    }

    public static void addCherryTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_CHERRY_TREE);
    }

    public static void addSparseCherryTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_CHERRY_TREE);
    }

    public static void addDeadHazelTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WITCH_HAZEL_TREE);
    }

    public static void addSparseDeadHazelTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_WITCH_HAZEL_TREE);
    }

    public static void addEbonyTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_EBONY_TREE);
    }

    public static void addHollyTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_HOLLY_TREE);
    }

    public static void addSparseHollyTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_HOLLY_TREE);
    }

    public static void addMangroveTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MANGROVE_TREE);
    }

    public static void addSparseMangroveMarshes(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_MANGROVE_SPARSE_TREE);
    }

    public static void addOrchardTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ORCHARD_TREE);
    }

    public static void addHugeMushrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_HUGE_MUSHROOM);
    }

    public static void addHugeGlowshrooms(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_HUGE_GLOWSHROOM);
    }

    public static void addWoodlandTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WOODLAND_TREE);
    }

    public static void addDummyTree(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.DUMMY_TREE);
    }

    public static void addLamentTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_TWISTY_LAMENT_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WEEPING_LAMENT_TREE);
    }

    public static void addWitheringOakTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_WITHERING_OAK_TREE);
    }

    public static void addSparseWitheringOakTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_WITHERING_OAK_TREE);
    }

    public static void addBulbisTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_BULBIS_TREE);
    }

    public static void addPurpleBulbisTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PURPLE_BULBIS_TREE);
    }

    public static void addSparseBulbisTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_BULBIS_TREE);
    }

    public static void addSparsePurpleBulbisTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_PURPLE_BULBIS_TREE);
    }

    public static void addEtherTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ETHER_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ETHER_BUSH);
    }

    public static void addEtherBushes(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ETHER_BUSH);
    }

    public static void addSparseEtherTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SPARSE_ETHER_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_ETHER_BUSH);
    }

    public static void addShulkrenTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_SHULKREN_TREE);
    }

    public static void addDeadEtherTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_DEAD_ETHER_TREE);
    }

    public static void addNightShadeTrees(BiomeGenerationSettings.Builder gen) {
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_NIGHTSHADE_TREE);
        gen.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_NIGHTSHADE_BUSH);
    }
}
