package voronoiaoc.byg.common.world.feature.biomefeatures;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import voronoiaoc.byg.common.world.feature.placements.AnyWaterOrSolidSurfaceSurface;
import voronoiaoc.byg.common.world.feature.placements.AtOceanFloorWithExtra;
import voronoiaoc.byg.common.world.feature.placements.UnderGroundPlacement;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGFeatureList;

public class BYGFeatures {
    public static void addAlliumFieldFlowers(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
                Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ALLIUMBUSH_CONFIG).withChance(0.6F)),
                Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINKALLIUMBUSH_CONFIG))).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(
                new FrequencyConfig(200))));

        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
                Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALL_ALLIUM_CONFIG).withChance(0.6F)),
                Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALL_PINK_ALLIUM_CONFIG))).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(
                new FrequencyConfig(25))));

    }

    public static void addFernGrass(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SHORT_GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.TAIGA_GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));

    }

    public static void addAmaranthFieldFlowers(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
                Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.AMARANTH_CONFIG).withChance(0.3F),
                Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CYANAMARANTH_CONFIG).withChance(0.3F),
                Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.MAGENTAAMARANTH_CONFIG).withChance(0.3F),
                Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ORANGEAMARANTH_CONFIG).withChance(0.3F)),
                Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLEAMARANTH_CONFIG))).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(
                new FrequencyConfig(200))));
    }

    public static void addEmburBogVegetation(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.EMBURMUSHROOM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(2, 0.5F, 3))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.EMBURMUSHROOM2.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(2, 0.5F, 3))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.EMBUR_ROOTS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(15, 0.5F, 12))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.TALL_EMBUR_ROOTS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(15, 0.5F, 12))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.EMBUR_GEL_VINES.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(20, 0.8F, 6))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.EMBUR_WART.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(3, 0.5F, 2))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.EMBUR_LILY.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(2, 0.5F, 2))));

    }

    public static void addBYGGlowcane(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLUE_GLOWCANE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RED_GLOWCANE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_GLOWCANE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_GLOWCANE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));

    }

    public static void addBYGDesertPlants(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PRICKLY_PEAR_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GOLDEN_SPINED_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FIRECRACKER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));

    }

    public static void addFirecracker(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FIRECRACKER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));

    }

    public static void addPrairieGrass(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALLPRAIRIEGRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(25))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PRAIRIEGRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(200))));
    }

    public static void addPumpkinPatch(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PUMPKIN_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(8))));

    }

    public static void addBlueberries(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLUEBERRY_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
    }

    public static void addLushBlueberries(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLUEBERRY_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
    }

    public static void addBeachGrass(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BEACH_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SHORT_BEACH_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
    }

    public static void addLargeLake(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.RAW_GENERATION, BYGFeatureList.LAKE_WIDE_SHALLOW.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(AnyWaterOrSolidSurfaceSurface.WWATERORSOLIDSURFACE.configure(new FrequencyConfig(4))));
    }

    public static void addLargeLavaLake(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.RAW_GENERATION, BYGFeatureList.LAKE_LAVA_WIDE_SHALLOW.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(AnyWaterOrSolidSurfaceSurface.WWATERORSOLIDSURFACE.configure(new FrequencyConfig(3))));
    }

    public static void addVolcanicCarvers(Biome biome) {
        biome.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(BYGFeatureList.VOLCANIC_CARVER, new ProbabilityConfig(0.02F)));

    }

    public static void addAzalea(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.AZALEA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addDelphinium(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.DELPHINIUM_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addJapaneseOrchid(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.JAPANESEORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(3))));
    }

    public static void addWiltedGrass(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WILTED_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
    }

    public static void addWeedGrass(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WEED_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
    }

    public static void addWinterGrass(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
    }

    public static void addLeafPile(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.LEAF_PILE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
    }

    public static void addCloverFlowerPatch(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CLOVER_PATCH).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FLOWER_PATCH).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
    }

    public static void addCherryFoliage(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_CHERRY_FOLIAGE).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(3))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WHITE_CHERRY_FOLIAGE).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(3))));
    }

    public static void addBYGSwampVegetation(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TINY_LILYPAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WATER_SILK_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.LILY_PAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));

    }

    public static void addBYGLilyPad(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TINY_LILYPAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(0))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.LILY_PAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));

    }

    public static void addHorseweed(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.HORSEWEED_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
    }

    public static void addWinterSucculent(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_SUCCULENT_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
    }

    public static void addShortGrass(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SHORT_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
    }

    public static void addIris(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.IRIS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addTulips(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GREEN_TULIP_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.MAGENTA_TULIP_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CYAN_TULIP_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_TULIP_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.YELLOW_TULIP_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));


    }

    public static void addCaliforniaPoppy(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CALIFORNIA_POPPY_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addCrocus(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CROCUS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addAlpineBellflower(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ALPINE_BELLFLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addWinterScilla(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_SCILLA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addYellowDaffodil(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.YELLOW_DAFFODIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addDaffodil(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.DAFFODIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addPinkDaffodil(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_DAFFODIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addLolliPop(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.LOLLI_POP_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addRose(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ROSE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addBlackRose(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLACK_ROSE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addOsiria(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.OSIRIA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addWinterRose(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_ROSE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addSnowdrops(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SNOWDROPS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addMudDisks(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(BYGBlockList.MUD_BLOCK.getDefaultState(), 4, 1, Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState()))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
    }

    public static void addBYGMushrooms(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WEEPING_MILKCAP_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(3, 0.125F))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLACK_PUFF_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(3, 0.125F))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WOOD_BLEWIT_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(3, 0.125F))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GREEN_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(3, 0.125F))));
    }

    public static void addGlowshrooms(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLUE_GLOWSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(3, 0.125F))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_GLOWSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(3, 0.125F))));
    }

    public static void addAnemones(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_ANEMONE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WHITE_ANEMONE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addFoxgloves(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FOXGLOVE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addCattails(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CATTAIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));

    }

    public static void addReeds(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.REEDS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));

    }

    public static void addFairyslipper(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FAIRYSLIPPER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addCyanRose(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CYAN_ROSE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addRedorchid(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RED_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addPurpleOrchid(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addPinkOrchid(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addPeachleatherflower(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PEACH_LEATHER_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addVioletleatherflower(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.VIOLET_LEATHER_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addKovanFlower(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.KOVAN_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addGrass(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SHORT_GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));
    }

    public static void addMarshGrass(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SHORT_GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.TALL_GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));

    }

    public static void addTallGrass(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALL_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));

    }


    public static void addSages(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WHITE_SAGE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_SAGE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addOrangeDaisy(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ORANGE_DAISY_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addPinkAllium(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_ALLIUM_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addRedCornflower(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RED_CORNFLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addBYGTropicFlowers(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BEGONIA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BISTORT_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GUZMANIA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.INCAN_LILY_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.LAZARUS_BELLFLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TORCH_GINGER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RICHEA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addMiniCactus(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.MINI_CACTUS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
    }

    public static void addQuagmireFeatures(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.QUAGMIREDEADBUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(100))));
//        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.DEAD_TREE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.4F, -1))));

    }

    public static void addBYGBambooJungleVegetation(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BAMBOO.withConfiguration(new ProbabilityConfig(0.1F)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(160, 80.0D, 0.3D, Heightmap.Type.WORLD_SURFACE_WG))));
    }

    public static void addRockyStoneBoulder(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(BYGBlockList.ROCKY_STONE.getDefaultState(), 0)).withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(2))));
    }

    public static void addTerracottaBoulder(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(Blocks.ORANGE_TERRACOTTA.getDefaultState(), 0)).withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(3))));
    }

    public static void addMossyStoneBoulder(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(BYGBlockList.MOSSY_STONE.getDefaultState(), 0)).withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(2))));
    }

    public static void addFrostMagmaLakes(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BYGFeatureList.LAKE_FROST.withConfiguration(new BlockStateFeatureConfig(BYGBlockList.FROST_MAGMA.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));

    }


//    public static void addNetherFortress(Biome biome) {
//        biome.addStructure(Feature.NETHER_BRIDGE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
//        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.NETHER_BRIDGE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
//    }

    public static void addWarpedVegetation(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WARPED_CACTUS_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(2, 0.4F, -1))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.WARPED_BUSH.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(400, 0, 0, 256))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.WARPED_CORAL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(600, 0, 0, 256))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.WARPED_CORALFAN.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(600, 0, 0, 256))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.WARPED_CORALPLANT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(300, 0, 0, 256))));
    }

    public static void addSythianVegetation(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.SYTHIAN_STALK.withConfiguration(new ProbabilityConfig(0.9F)).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.SYTHIAN_ROOTS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.SYTHIAN_SPROUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));
    }

    public static void addGlowstoneGardenVegetation(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.WEED_GRASS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.WEEPING_MILKCAP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.WOOD_BLEWIT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.BLACK_PUFF.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.GREEN_MUSHROOM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.NETHER_BRISTLE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(2, 0.4F, 1))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.WEEPING_ROOTS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.LIGHT_GEM_CHANCE.configure(new FrequencyConfig(150))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.WEEPING_ROOTS_PLANT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.LIGHT_GEM_CHANCE.configure(new FrequencyConfig(200))));

    }

//    public static void addEndCity(Biome biome) {
//        biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.END_CITY.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
//        biome.addStructure(Feature.END_CITY.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
//        biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.END_GATEWAY.withConfiguration(EndGatewayConfig.func_214702_a(EndDimension.SPAWN, true)).withPlacement(Placement.END_GATEWAY.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
//    }

    public static void addDeadSeaSpires(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.RAW_GENERATION, BYGFeatureList.TALLDEADSEASPIKES.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(AtOceanFloorWithExtra.OCEANFLOOR.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
        biome.addFeature(GenerationStage.Decoration.RAW_GENERATION, BYGFeatureList.DEADSEASPIKES.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(AtOceanFloorWithExtra.OCEANFLOOR.configure(new AtSurfaceWithExtraConfig(25, 0.1F, 1))));
    }

//    public static void addSkyrisFortress(Biome biome) {
//        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGFeatureList.SKYRISFORTRESS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
//        biome.addStructure(BYGFeatureList.SKYRISFORTRESS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
//    }

    public static void addHugeNetherMushrooms(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_BOOLEAN_SELECTOR.withConfiguration(new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_RED_MUSHROOM), Feature.HUGE_BROWN_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_BROWN_MUSHROOM))).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(2, 0.5F, 2))));
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.BLUE_GLOWSHROOM_HUGE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withChance(0.5F),
                BYGFeatureList.PURPLE_GLOWSHROOM_HUGE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withChance(0.5F),
                BYGFeatureList.GREEN_MUSHROOM_HUGE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withChance(0.5F),
                BYGFeatureList.WOOD_BLEWIT_HUGE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withChance(0.5F),
                BYGFeatureList.WEEPING_MILKCAP_HUGE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withChance(0.5F)),
                BYGFeatureList.BLACK_PUFF_HUGE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG))).withPlacement(UnderGroundPlacement.UGPLACER.configure(
                new AtSurfaceWithExtraConfig(5, 0.5F, 2))));

    }

    public static void addTropFungalMushrooms(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
                BYGFeatureList.GREEN_MUSHROOM_HUGE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withChance(0.2F),
                BYGFeatureList.WOOD_BLEWIT_HUGE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withChance(0.4F),
                BYGFeatureList.WEEPING_MILKCAP_HUGE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withChance(0.4F)),
                BYGFeatureList.BLACK_PUFF_HUGE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                new AtSurfaceWithExtraConfig(15, 0.5F, 5))));
    }

    public static void addIvisPlants(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.IVIS_ROOTS).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.IVIS_SPROUT).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
    }

    public static void addExtraCanyons(Biome biome) {
        biome.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.8F)));
    }

    public static void addGiantFlowerFeatures(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.GIANT_ANGELICA_FLOWER.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.3F, -1))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.GIANT_DANDELION_FLOWER.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.3F, -1))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.GIANT_IRIS_FLOWER.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.3F, -1))));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BYGFeatureList.GIANT_ROSE_FLOWER.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.3F, -1))));
    }
}
