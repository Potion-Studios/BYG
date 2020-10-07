package corgiaoc.byg.core.world;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import corgiaoc.byg.common.world.feature.biomefeatures.BYGFeatureConfigs;
import corgiaoc.byg.common.world.feature.features.config.BYGBoulderFeatureConfig;
import corgiaoc.byg.common.world.feature.features.config.BYGGiantFlowerFeatureConfig;
import corgiaoc.byg.common.world.feature.features.config.BYGPumpkinFeatureConfig;
import corgiaoc.byg.common.world.feature.features.config.PointyRockFeatureConfig;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

public class BYGConfiguredFeatures {
    /***********************************************************Configured Features***********************************************************/

    public static ConfiguredFeature<?, ?> ALLIUM_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("allium_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ALLIUMBUSH_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_PINK_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("pink_allium_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINKALLIUMBUSH_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_TALL_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("tall_allium_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALL_ALLIUM_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_TALL_PINK_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("tall_pink_allium_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALL_PINK_ALLIUM_CONFIG));

    public static ConfiguredFeature<?, ?> AMARANTH = WorldGenRegistrationHelper.createConfiguredFeature("amaranth", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.AMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_MAGENTA = WorldGenRegistrationHelper.createConfiguredFeature("magenta_amaranth", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.MAGENTAAMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_ORANGE = WorldGenRegistrationHelper.createConfiguredFeature("orange_amaranth", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ORANGEAMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_PURPLE = WorldGenRegistrationHelper.createConfiguredFeature("purple_amaranth", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLEAMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_CYAN = WorldGenRegistrationHelper.createConfiguredFeature("cyan_amaranth", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CYANAMARANTH_CONFIG));

    public static ConfiguredFeature<?, ?> FERN_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("fern_grass", Feature.RANDOM_PATCH.withConfiguration(Features.Configs.TAIGA_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> SHORT_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("short_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SHORT_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> TALL_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("tall_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALL_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> SOUL_FIRE_ON_NYLIUM = WorldGenRegistrationHelper.createConfiguredFeature("soul_fire_on_nylium", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SOULFIREONNYLIUM));
    public static ConfiguredFeature<?, ?> BORIC_FIRE = WorldGenRegistrationHelper.createConfiguredFeature("boric_fire", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BORIC_FIRE));
    public static ConfiguredFeature<?, ?> MAGMA_FIRE = WorldGenRegistrationHelper.createConfiguredFeature("magma_fire", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.MAGMA_FIRE));
    public static ConfiguredFeature<?, ?> SUBZERO_ASH = WorldGenRegistrationHelper.createConfiguredFeature("subzero_ash", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SUBZERO_ASH));
    public static ConfiguredFeature<?, ?> SUBZERO_ASH_BLOCK = WorldGenRegistrationHelper.createConfiguredFeature("subzero_ash_block", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SUBZERO_ASH_BLOCK));
    public static ConfiguredFeature<?, ?> QUARTZ_CRYSTAL = WorldGenRegistrationHelper.createConfiguredFeature("quartz_crystal", BYGFeatures.QUARTZ_CRYSTAL.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    //Giant Flowers
    public static ConfiguredFeature<BYGGiantFlowerFeatureConfig, ?> GIANT_ANGELICA_FLOWER = WorldGenRegistrationHelper.createConfiguredFeature("giant_angelica", BYGFeatures.GIANT_ANGELICA_FLOWER.withConfiguration(new BYGGiantFlowerFeatureConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.WHITE_PETAL).setMaxHeight(18).setMinHeight(12).build()));
    public static ConfiguredFeature<BYGGiantFlowerFeatureConfig, ?> GIANT_DANDELION_FLOWER = WorldGenRegistrationHelper.createConfiguredFeature("giant_dandelion", BYGFeatures.GIANT_DANDELION_FLOWER.withConfiguration(new BYGGiantFlowerFeatureConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.RED_PETAL).setPetal2Block(BYGBlocks.YELLOW_PETAL).setMaxHeight(12).setMinHeight(6).build()));
    public static ConfiguredFeature<BYGGiantFlowerFeatureConfig, ?> GIANT_IRIS_FLOWER = WorldGenRegistrationHelper.createConfiguredFeature("giant_iris", BYGFeatures.GIANT_IRIS_FLOWER.withConfiguration(new BYGGiantFlowerFeatureConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.PURPLE_PETAL).setPetal2Block(BYGBlocks.YELLOW_PETAL).setMaxHeight(12).setMinHeight(6).build()));
    public static ConfiguredFeature<BYGGiantFlowerFeatureConfig, ?> GIANT_ROSE_FLOWER = WorldGenRegistrationHelper.createConfiguredFeature("giant_rose", BYGFeatures.GIANT_ROSE_FLOWER.withConfiguration(new BYGGiantFlowerFeatureConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.RED_PETAL).setMaxHeight(12).setMinHeight(6).build()));


    public static ConfiguredFeature<?, ?> MINI_CACTI = WorldGenRegistrationHelper.createConfiguredFeature("mini_cacti", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.MINI_CACTUS_CONFIG));
    public static ConfiguredFeature<?, ?> HORSE_WEED = WorldGenRegistrationHelper.createConfiguredFeature("horse_weed", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.HORSEWEED_CONFIG));
    public static ConfiguredFeature<?, ?> TINY_LILY_PAD = WorldGenRegistrationHelper.createConfiguredFeature("tiny_lily_pad", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TINY_LILYPAD_CONFIG));
    public static ConfiguredFeature<?, ?> WATER_SILK = WorldGenRegistrationHelper.createConfiguredFeature("water_silk", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WATER_SILK_CONFIG));
    public static ConfiguredFeature<?, ?> WINTER_SUCCULENT = WorldGenRegistrationHelper.createConfiguredFeature("winter_succulent", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_SUCCULENT_CONFIG));
    public static ConfiguredFeature<?, ?> BEACH_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("beach_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BEACH_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> BEACH_SHORT_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("short_beach_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SHORT_BEACH_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> WILTED_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("wilted_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WILTED_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> LEAF_PILE = WorldGenRegistrationHelper.createConfiguredFeature("leaf_pile", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.LEAF_PILE_CONFIG));
    public static ConfiguredFeature<?, ?> CLOVER_PATCH = WorldGenRegistrationHelper.createConfiguredFeature("clover_patch", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CLOVER_PATCH));
    public static ConfiguredFeature<?, ?> FLOWER_PATCH = WorldGenRegistrationHelper.createConfiguredFeature("flower_patch", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FLOWER_PATCH));
    public static ConfiguredFeature<?, ?> WEED_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("weed_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WEED_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> WINTER_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("winter_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> CALIFORNIA_POPPY = WorldGenRegistrationHelper.createConfiguredFeature("california_poppy", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CALIFORNIA_POPPY_CONFIG));
    public static ConfiguredFeature<?, ?> BLACK_PUFF = WorldGenRegistrationHelper.createConfiguredFeature("black_puff", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLACK_PUFF_CONFIG));
    public static ConfiguredFeature<?, ?> WEEPING_MILKCAP = WorldGenRegistrationHelper.createConfiguredFeature("weeping_milkcap", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WEEPING_MILKCAP_CONFIG));
    public static ConfiguredFeature<?, ?> WOOD_BLEWIT = WorldGenRegistrationHelper.createConfiguredFeature("wood_blewit", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WOOD_BLEWIT_CONFIG));
    public static ConfiguredFeature<?, ?> GREEN_MUSHROOM = WorldGenRegistrationHelper.createConfiguredFeature("green_mushroom", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GREEN_MUSHROOM_CONFIG));
    public static ConfiguredFeature<?, ?> BEGONIA = WorldGenRegistrationHelper.createConfiguredFeature("begonia", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BEGONIA_CONFIG));
    public static ConfiguredFeature<?, ?> BISTORT = WorldGenRegistrationHelper.createConfiguredFeature("bistort", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BISTORT_CONFIG));
    public static ConfiguredFeature<?, ?> GUZMANIA = WorldGenRegistrationHelper.createConfiguredFeature("guzmania", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GUZMANIA_CONFIG));
    public static ConfiguredFeature<?, ?> INCAN_LILY = WorldGenRegistrationHelper.createConfiguredFeature("incan_lily", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.INCAN_LILY_CONFIG));
    public static ConfiguredFeature<?, ?> LAZARUS_BELLFLOWER = WorldGenRegistrationHelper.createConfiguredFeature("lazarus_bellflower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.LAZARUS_BELLFLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> TORCH_GINGER = WorldGenRegistrationHelper.createConfiguredFeature("torch_ginger", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TORCH_GINGER_CONFIG));
    public static ConfiguredFeature<?, ?> RICHEA = WorldGenRegistrationHelper.createConfiguredFeature("richea", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RICHEA_CONFIG));
    public static ConfiguredFeature<?, ?> JAPANESE_ORCHID = WorldGenRegistrationHelper.createConfiguredFeature("japanese_orchid", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.JAPANESEORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> AZALEA = WorldGenRegistrationHelper.createConfiguredFeature("azalea", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.AZALEA_CONFIG));
    public static ConfiguredFeature<?, ?> PRAIRIE_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("prairie_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PRAIRIEGRASS_CONFIG));
    public static ConfiguredFeature<?, ?> PRAIRIE_TALL_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("tall_prairie_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALLPRAIRIEGRASS_CONFIG));
    public static ConfiguredFeature<?, ?> BLUE_GLOWSHROOM = WorldGenRegistrationHelper.createConfiguredFeature("blue_glowshroom", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLUE_GLOWSHROOM_CONFIG));
    public static ConfiguredFeature<?, ?> PURPLE_GLOWSHROOM = WorldGenRegistrationHelper.createConfiguredFeature("purple_glowshroom", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_GLOWSHROOM_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("rose_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ROSE_BUSH_CONFIG));


    public static ConfiguredFeature<?, ?> PRICKLY_PEAR_CACTI = WorldGenRegistrationHelper.createConfiguredFeature("prickly_pear_cacti", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PRICKLY_PEAR_CONFIG));
    public static ConfiguredFeature<?, ?> GOLDEN_SPINED_CACTI = WorldGenRegistrationHelper.createConfiguredFeature("golden_spined_cacti", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GOLDEN_SPINED_CONFIG));

    public static ConfiguredFeature<?, ?> PINK_CHERRY_FOLIAGE = WorldGenRegistrationHelper.createConfiguredFeature("pink_cherry_foliage", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_CHERRY_FOLIAGE));
    public static ConfiguredFeature<?, ?> WHITE_CHERRY_FOLIAGE = WorldGenRegistrationHelper.createConfiguredFeature("white_cherry_foliage", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WHITE_CHERRY_FOLIAGE));

    public static ConfiguredFeature<?, ?> WARPED_CACTI = WorldGenRegistrationHelper.createConfiguredFeature("warped_cacti", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WARPED_CACTUS_CONFIG));
    public static ConfiguredFeature<?, ?> WARPED_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("warped_bush", BYGFeatures.WARPED_BUSH.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> WARPED_CORAL = WorldGenRegistrationHelper.createConfiguredFeature("warped_coral", BYGFeatures.WARPED_CORAL.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> WARPED_CORAL_FAN = WorldGenRegistrationHelper.createConfiguredFeature("warped_coral_fan", BYGFeatures.WARPED_CORAL_FAN.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> CHAINS = WorldGenRegistrationHelper.createConfiguredFeature("chains", BYGFeatures.CHAINS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> SOUL_SOIL_PILLARS = WorldGenRegistrationHelper.createConfiguredFeature("soul_soil_pillars", BYGFeatures.SOUL_SOIL_PILLARS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> SCORCHED_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("scorched_bush", BYGFeatures.SCORCHED_BUSH.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> SCORCHED_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("scorched_grass", BYGFeatures.SCORCHED_GRASS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> WAILING_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("wailing_grass", BYGFeatures.WAILING_GRASS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> WAILING_VINES = WorldGenRegistrationHelper.createConfiguredFeature("wailing_vines", BYGFeatures.WAILING_VINES.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> LAMENT_SPROUTS = WorldGenRegistrationHelper.createConfiguredFeature("lament_sprouts", BYGFeatures.LAMENT_SPROUTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));


    public static ConfiguredFeature<?, ?> BLUE_BERRY_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("blue_berry_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLUEBERRY_BUSH_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE = WorldGenRegistrationHelper.createConfiguredFeature("rose", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> ANGELICA = WorldGenRegistrationHelper.createConfiguredFeature("angelica", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ANGELICA_CONFIG));
    public static ConfiguredFeature<?, ?> CROCUS = WorldGenRegistrationHelper.createConfiguredFeature("crocus", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CROCUS_CONFIG));
    public static ConfiguredFeature<?, ?> IRIS = WorldGenRegistrationHelper.createConfiguredFeature("iris", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.IRIS_CONFIG));
    public static ConfiguredFeature<?, ?> ANEMONE_WHITE = WorldGenRegistrationHelper.createConfiguredFeature("white_anemone", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WHITE_ANEMONE_CONFIG));
    public static ConfiguredFeature<?, ?> ANEMONE_PINK = WorldGenRegistrationHelper.createConfiguredFeature("pink_anemone", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_ANEMONE_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_WINTER = WorldGenRegistrationHelper.createConfiguredFeature("winter_rose", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> SNOWDROPS = WorldGenRegistrationHelper.createConfiguredFeature("snowdrops", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SNOWDROPS_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_PINK = WorldGenRegistrationHelper.createConfiguredFeature("pink_allium", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_ALLIUM_CONFIG));
    public static ConfiguredFeature<?, ?> DAISY_ORANGE = WorldGenRegistrationHelper.createConfiguredFeature("orange_daisy", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ORANGE_DAISY_CONFIG));
    public static ConfiguredFeature<?, ?> CORNFLOWER_RED = WorldGenRegistrationHelper.createConfiguredFeature("red_cornflower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RED_CORNFLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> SAGE_WHITE = WorldGenRegistrationHelper.createConfiguredFeature("white_sage", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WHITE_SAGE_CONFIG));
    public static ConfiguredFeature<?, ?> SAGE_PURPLE = WorldGenRegistrationHelper.createConfiguredFeature("purple_sage", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_SAGE_CONFIG));
    public static ConfiguredFeature<?, ?> DELPHINIUM = WorldGenRegistrationHelper.createConfiguredFeature("delphinium", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.DELPHINIUM_CONFIG));
    public static ConfiguredFeature<?, ?> FOXGLOVE = WorldGenRegistrationHelper.createConfiguredFeature("foxglove", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FOXGLOVE_CONFIG));
    public static ConfiguredFeature<?, ?> DAFFODIL_YELLOW = WorldGenRegistrationHelper.createConfiguredFeature("yellow_daffodil", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.YELLOW_DAFFODIL_CONFIG));
    public static ConfiguredFeature<?, ?> PUMPKIN_CONFIG = WorldGenRegistrationHelper.createConfiguredFeature("pumpkin", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PUMPKIN_CONFIG));
    public static ConfiguredFeature<?, ?> ALPINE_BELLFLOWER = WorldGenRegistrationHelper.createConfiguredFeature("alpine_bellflower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ALPINE_BELLFLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> WINTER_SCILLA = WorldGenRegistrationHelper.createConfiguredFeature("winter_scilla", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_SCILLA_CONFIG));
    public static ConfiguredFeature<?, ?> KOVAN_FLOWER = WorldGenRegistrationHelper.createConfiguredFeature("kovan_flower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.KOVAN_FLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> FIRECRACKER_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("firecracker_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FIRECRACKER_CONFIG));

    public static ConfiguredFeature<?, ?> NETHER_BRISTLE = WorldGenRegistrationHelper.createConfiguredFeature("nether_bristle", BYGFeatures.NETHER_BRISTLE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> TULIP_GREEN = WorldGenRegistrationHelper.createConfiguredFeature("green_tulip", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GREEN_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_CYAN = WorldGenRegistrationHelper.createConfiguredFeature("cyan_tulip", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CYAN_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_MAGENTA = WorldGenRegistrationHelper.createConfiguredFeature("magenta_tulip", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.MAGENTA_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_PURPLE = WorldGenRegistrationHelper.createConfiguredFeature("purple_tulip", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_YELLOW = WorldGenRegistrationHelper.createConfiguredFeature("yellow_tulip", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.YELLOW_TULIP_CONFIG));

    public static ConfiguredFeature<?, ?> REEDS = WorldGenRegistrationHelper.createConfiguredFeature("reeds", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.REEDS_CONFIG));
    public static ConfiguredFeature<?, ?> CATTAIL = WorldGenRegistrationHelper.createConfiguredFeature("cattail", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CATTAIL_CONFIG));

    public static ConfiguredFeature<?, ?> GLOWCANE_BLUE = WorldGenRegistrationHelper.createConfiguredFeature("blue_glowcane", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLUE_GLOWCANE_CONFIG));
    public static ConfiguredFeature<?, ?> GLOWCANE_PURPLE = WorldGenRegistrationHelper.createConfiguredFeature("purple_glowcane", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_GLOWCANE_CONFIG));
    public static ConfiguredFeature<?, ?> GLOWCANE_RED = WorldGenRegistrationHelper.createConfiguredFeature("red_glowcane", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RED_GLOWCANE_CONFIG));
    public static ConfiguredFeature<?, ?> GLOWCANE_PINK = WorldGenRegistrationHelper.createConfiguredFeature("pink_glowcane", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_GLOWCANE_CONFIG));

    public static ConfiguredFeature<?, ?> LOLI_POP = WorldGenRegistrationHelper.createConfiguredFeature("loli_pop", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.LOLLI_POP_CONFIG));
    public static ConfiguredFeature<?, ?> ORCHID_RED = WorldGenRegistrationHelper.createConfiguredFeature("red_orchid", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RED_ORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> ORCHID_PINK = WorldGenRegistrationHelper.createConfiguredFeature("pink_orchid", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_ORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> ORCHID_PURPLE = WorldGenRegistrationHelper.createConfiguredFeature("purple_orchid", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_ORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> LEATHER_FLOWER_PEACH = WorldGenRegistrationHelper.createConfiguredFeature("peach_leather_flower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PEACH_LEATHER_FLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> LEATHER_FLOWER_VIOLET = WorldGenRegistrationHelper.createConfiguredFeature("violet_leather_flower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.VIOLET_LEATHER_FLOWER_CONFIG));

    public static ConfiguredFeature<?, ?> DAFFODIL_PINK = WorldGenRegistrationHelper.createConfiguredFeature("pink_daffodil", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_DAFFODIL_CONFIG));
    public static ConfiguredFeature<?, ?> DAFFODIL = WorldGenRegistrationHelper.createConfiguredFeature("daffodil", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.DAFFODIL_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_BLACK = WorldGenRegistrationHelper.createConfiguredFeature("black_rose", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLACK_ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_CYAN = WorldGenRegistrationHelper.createConfiguredFeature("cyan_rose", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CYAN_ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_OSIRIA = WorldGenRegistrationHelper.createConfiguredFeature("osiria_rose", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.OSIRIA_CONFIG));
    public static ConfiguredFeature<?, ?> FAIRY_SLIPPER = WorldGenRegistrationHelper.createConfiguredFeature("fairy_slipper", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FAIRYSLIPPER_CONFIG));

    public static ConfiguredFeature<?, ?> IVIS_ROOTS = WorldGenRegistrationHelper.createConfiguredFeature("ivis_roots", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.IVIS_ROOTS));
    public static ConfiguredFeature<?, ?> IVIS_SPROUT = WorldGenRegistrationHelper.createConfiguredFeature("ivis_sprout", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.IVIS_SPROUT));

    public static ConfiguredFeature<?, ?> WEEPING_VINE_BLACKSTONE = WorldGenRegistrationHelper.createConfiguredFeature("weeping_vines_blackstone", BYGFeatures.WEEPING_VINE_BLACKSTONE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> WEEPING_ROOTS = WorldGenRegistrationHelper.createConfiguredFeature("weeping_roots", BYGFeatures.WEEPING_ROOTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> WEEPING_ROOTS_PLANT = WorldGenRegistrationHelper.createConfiguredFeature("weeping_roots_plant", BYGFeatures.WEEPING_ROOTS_PLANT.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> EMBUR_ROOTS = WorldGenRegistrationHelper.createConfiguredFeature("embur_roots", BYGFeatures.EMBUR_ROOTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> EMBUR_ROOTS_TALL = WorldGenRegistrationHelper.createConfiguredFeature("tall_embur_roots", BYGFeatures.TALL_EMBUR_ROOTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> EMBUR_GEL_VINES = WorldGenRegistrationHelper.createConfiguredFeature("embur_gel_vines", BYGFeatures.EMBUR_GEL_VINES.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> EMBUR_WART = WorldGenRegistrationHelper.createConfiguredFeature("embur_wart", BYGFeatures.EMBUR_WART.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> EMBUR_SPROUTS = WorldGenRegistrationHelper.createConfiguredFeature("embur_sprouts", BYGFeatures.EMBUR_SPROUTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> CRIMSON_ROOTS_TALL = WorldGenRegistrationHelper.createConfiguredFeature("tall_crimson_roots", BYGFeatures.TALL_CRIMSON_ROOTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> CRIMSON_BERRY_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("crimson_berry_bush", BYGFeatures.CRIMSON_BERRY_BUSH.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> SYTHIAN_ROOTS = WorldGenRegistrationHelper.createConfiguredFeature("sythian_root", BYGFeatures.SYTHIAN_ROOTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> SYTHIAN_SPROUT = WorldGenRegistrationHelper.createConfiguredFeature("sythian_sprout", BYGFeatures.SYTHIAN_SPROUT.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> SYTHIAN_FUNGUS = WorldGenRegistrationHelper.createConfiguredFeature("sythian_fungus", BYGFeatures.SYTHIAN_FUNGUS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> SOUL_SHROOM = WorldGenRegistrationHelper.createConfiguredFeature("soul_shroom", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SOUL_SHROOM_CONFIG));
    public static ConfiguredFeature<?, ?> DEATH_CAP = WorldGenRegistrationHelper.createConfiguredFeature("death_cap", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.DEATH_CAP_CONFIG));

    public static ConfiguredFeature<?, ?> DEAD_SEA_SPIKE = WorldGenRegistrationHelper.createConfiguredFeature("dead_sea_spike", BYGFeatures.POINTY_ROCK.withConfiguration(new PointyRockFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ROCKY_STONE.getDefaultState(), 5).addWeightedBlockstate(Blocks.STONE.getDefaultState(), 3).addWeightedBlockstate(Blocks.ANDESITE.getDefaultState(), 2)).setRockHeight(65).build()));
    public static ConfiguredFeature<?, ?> DEAD_SEA_SPIKE_TALL = WorldGenRegistrationHelper.createConfiguredFeature("dead_sea_tall_spike", BYGFeatures.POINTY_ROCK.withConfiguration(new PointyRockFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ROCKY_STONE.getDefaultState(), 5).addWeightedBlockstate(Blocks.STONE.getDefaultState(), 3).addWeightedBlockstate(Blocks.ANDESITE.getDefaultState(), 2)).setRockHeight(85).build()));

    public static ConfiguredFeature<?, ?> VALLE_DE_LUNA_POINTY_ROCK = WorldGenRegistrationHelper.createConfiguredFeature("valle_de_luna_pointy_rock", BYGFeatures.POINTY_ROCK.withConfiguration(new PointyRockFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SAND.getDefaultState(), 5).addWeightedBlockstate(BYGBlocks.WHITE_CUT_SANDSTONE.getDefaultState(), 5)).setRockHeight(88).build()).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(new AtSurfaceWithExtraConfig(28, 0.1F, 1))));
    public static ConfiguredFeature<?, ?> VALLE_DE_LUNA_POINTY_ROCK_LARGE = WorldGenRegistrationHelper.createConfiguredFeature("valle_de_luna_pointy_rock_large", BYGFeatures.POINTY_ROCK.withConfiguration(new PointyRockFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SAND.getDefaultState(), 5).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 5)).setRockHeight(100).build()).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(new AtSurfaceWithExtraConfig(4, 0.1F, 1))));


    public static ConfiguredFeature<?, ?> ORE_PERVADED_NETHERRACK = WorldGenRegistrationHelper.createConfiguredFeature("ore_pervaded_netherrack", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241884_c, BYGBlocks.PERVADED_NETHERRACK.getDefaultState(), 14)).withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).func_242728_a().func_242731_b(16));
    public static ConfiguredFeature<?, ?> ORE_ANTHRACITE = WorldGenRegistrationHelper.createConfiguredFeature("ore_anthracite", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241884_c, BYGBlocks.ANTHRACITE_ORE.getDefaultState(), 14)).withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).func_242728_a().func_242731_b(16));

    public static ConfiguredFeature<?, ?> ORE_AMETRINE = WorldGenRegistrationHelper.createConfiguredFeature("ore_ametrine", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BYGBlocks.AMETRINE_ORE.getDefaultState(), 4)).func_242733_d(56).func_242728_a().func_242731_b(10));
    public static ConfiguredFeature<?, ?> ORE_PENDORITE = WorldGenRegistrationHelper.createConfiguredFeature("ore_pendorite", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BYGBlocks.PENDORITE_ORE.getDefaultState(), 4)).func_242733_d(56).func_242728_a().func_242731_b(10));

    public static ConfiguredFeature<?, ?> ORE_ROCKY_STONE = WorldGenRegistrationHelper.createConfiguredFeature("ore_rocky_stone", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BYGBlocks.ROCKY_STONE.getDefaultState(), 20)).func_242733_d(63).func_242728_a().func_242731_b(10));
    public static ConfiguredFeature<?, ?> ORE_SCORIA_STONE = WorldGenRegistrationHelper.createConfiguredFeature("ore_scoria_stone", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BYGBlocks.SCORIA_STONE.getDefaultState(), 20)).func_242733_d(63).func_242728_a().func_242731_b(10));
    public static ConfiguredFeature<?, ?> ORE_SOAP_STONE = WorldGenRegistrationHelper.createConfiguredFeature("ore_soap_stone", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BYGBlocks.SOAPSTONE.getDefaultState(), 20)).func_242733_d(63).func_242728_a().func_242731_b(10));

    public static ConfiguredFeature<?, ?> MOSSY_STONE_BOULDER = WorldGenRegistrationHelper.createConfiguredFeature("mossy_stone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(BYGBlocks.MOSSY_STONE.getDefaultState())));
    public static ConfiguredFeature<?, ?> ROCKY_STONE_BOULDER = WorldGenRegistrationHelper.createConfiguredFeature("rocky_stone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(BYGBlocks.ROCKY_STONE.getDefaultState())));
    public static ConfiguredFeature<?, ?> BLACKSTONE_BOULDER = WorldGenRegistrationHelper.createConfiguredFeature("blackstone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.BLACKSTONE.getDefaultState())));
    public static ConfiguredFeature<?, ?> ORANGE_TERRACOTTA_BOULDER = WorldGenRegistrationHelper.createConfiguredFeature("orange_terracotta_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.ORANGE_TERRACOTTA.getDefaultState())));

    public static final ConfiguredFeature<BYGPumpkinFeatureConfig, ?> PUMPKIN1 = WorldGenRegistrationHelper.createConfiguredFeature("pumpkin1", BYGFeatures.LARGE_PUMPKIN1.withConfiguration(new BYGPumpkinFeatureConfig.Builder().setPumpkinBlock(Blocks.PUMPKIN).setStemBlock(Blocks.OAK_LOG).build()));
    public static final ConfiguredFeature<BYGPumpkinFeatureConfig, ?> PUMPKIN2 = WorldGenRegistrationHelper.createConfiguredFeature("pumpkin2", BYGFeatures.LARGE_PUMPKIN2.withConfiguration(new BYGPumpkinFeatureConfig.Builder().setPumpkinBlock(Blocks.PUMPKIN).setStemBlock(Blocks.OAK_LOG).build()));


    /***********************************************************Configured & Decorated Features***********************************************************/

    public static ConfiguredFeature<?, ?> FROST_MAGMA_LAKE = WorldGenRegistrationHelper.createConfiguredFeature("frost_magma_lake", BYGFeatures.FROSTED_LAKE.withConfiguration(new BlockStateFeatureConfig(BYGBlocks.FROST_MAGMA.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
    public static ConfiguredFeature<?, ?> WARPED_CORAL_PLANT = WorldGenRegistrationHelper.createConfiguredFeature("warped_coral_plant", BYGFeatures.HUGE_WARPED_CORAL_PLANT.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.2F, 1))));
    public static ConfiguredFeature<?, ?> SYTHIAN_STALK = WorldGenRegistrationHelper.createConfiguredFeature("sythian_stalk", BYGFeatures.SYTHIAN_STALK.withConfiguration(new ProbabilityConfig(0.9F)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));
    public static ConfiguredFeature<?, ?> EMBUR_LILY = WorldGenRegistrationHelper.createConfiguredFeature("embur_lily", BYGFeatures.EMBUR_LILY.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.5F, 2))));
    public static ConfiguredFeature<?, ?> CRAG_LAKE = WorldGenRegistrationHelper.createConfiguredFeature("crag_lake", BYGFeatures.LAKE_WIDE_SHALLOW.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(BYGDecorators.ANY_WATER_OR_SOLID_SURFACE.configure(new FeatureSpreadConfig(4))));
    public static ConfiguredFeature<?, ?> EMBUR_LAKE = WorldGenRegistrationHelper.createConfiguredFeature("embur_lake", BYGFeatures.EMBURLAKE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(32, 0, 4)).func_242728_a()).func_242731_b(15));
    public static ConfiguredFeature<?, ?> OBBY_SPIKE = WorldGenRegistrationHelper.createConfiguredFeature("obsidian_spire", BYGFeatures.OBBYSPIKES.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(BYGDecorators.OBBY_SPIKE.configure(new AtSurfaceWithExtraConfig(2000, 0, 0))));
    public static ConfiguredFeature<?, ?> STACKED_BOULDERS = WorldGenRegistrationHelper.createConfiguredFeature("stacked_boulders", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BYGBoulderFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.STONE.getDefaultState(), 3).addWeightedBlockstate(Blocks.DIORITE.getDefaultState(), 2)).setMinStackHeight(10).setMaxHeight(15).setMinRadius(8).setMaxRadius(28).build()).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(new AtSurfaceWithExtraConfig(0, 0.15F, 1))));
    public static ConfiguredFeature<?, ?> GRASSLAND_BOULDER = WorldGenRegistrationHelper.createConfiguredFeature("grassland_boulder", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BYGBoulderFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ROCKY_STONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.MOSSY_STONE.getDefaultState(), 2)).setMinStackHeight(1).setMaxHeight(1).setMinRadius(8).setMaxRadius(12).build()).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
    public static ConfiguredFeature<?, ?> GRANITE_BOULDER = WorldGenRegistrationHelper.createConfiguredFeature("granite_boulder", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BYGBoulderFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.GRANITE.getDefaultState(), 3).addWeightedBlockstate(Blocks.POLISHED_GRANITE.getDefaultState(), 2)).setMinStackHeight(1).setMaxHeight(1).setMinRadius(5).setMaxRadius(9).build()).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));

    public static ConfiguredFeature<?, ?> RED_ROCK_BOULDER = WorldGenRegistrationHelper.createConfiguredFeature("red_rock_boulder", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BYGBoulderFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.RED_ROCK.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.RED_ROCK.getDefaultState(), 9).addWeightedBlockstate(Blocks.RED_CONCRETE.getDefaultState(), 1)).setMinStackHeight(7).setMaxHeight(12).setMinRadius(8).setMaxRadius(12).build()));
    public static ConfiguredFeature<?, ?> WHITE_SANDSTONE_BOULDER = WorldGenRegistrationHelper.createConfiguredFeature("white_sandstone_boulder", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BYGBoulderFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SANDSTONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 2).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.WHITE_SAND.getDefaultState(), 5)).setMinStackHeight(3).setMaxHeight(12).setMinRadius(13).setMaxRadius(20).setRadiusDivisor(1.1).flattenTopBoulder().build()).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(new AtSurfaceWithExtraConfig(0, 0.04F, 1))));
//    public static ConfiguredFeature<?, ?> WHITE_SANDSTONE_BOULDER_W_FLAT_TOP = WorldGenRegistrationHelper.createConfiguredFeature("white_sandstone_boulder_w_flat_top", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BYGBoulderFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SANDSTONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.WHITE_SANDSTONE.getDefaultState(), 2).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.WHITE_SAND.getDefaultState(), 5)).setMinStackHeight(3).setMaxHeight(12).setMinRadius(13).setMaxRadius(20).setRadiusDivisor(1.1).flattenTopBoulder().build()).withPlacement(BYGDecorators.OCEANFLOOR.configure(new AtSurfaceWithExtraConfig(0, 0.01F, 1))));
//    public static ConfiguredFeature<?, ?> WHITE_SANDSTONE_BOULDER_XL = WorldGenRegistrationHelper.createConfiguredFeature("white_sandstone_boulder_xl", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BYGBoulderFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SANDSTONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.WHITE_SANDSTONE.getDefaultState(), 2).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.WHITE_SAND.getDefaultState(), 5)).setMinStackHeight(4).setMaxHeight(8).setMinRadius(25).setMaxRadius(28).setRadiusDivisor(1.1).build()).withPlacement(BYGDecorators.OCEANFLOOR.configure(new AtSurfaceWithExtraConfig(0, 0.005F, 1))));
    public static ConfiguredFeature<?, ?> TERRACOTTA_BOULDER = WorldGenRegistrationHelper.createConfiguredFeature("terracotta_boulder", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BYGBoulderFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.TERRACOTTA.getDefaultState(), 3).addWeightedBlockstate(Blocks.TERRACOTTA.getDefaultState(), 3).addWeightedBlockstate(Blocks.RED_TERRACOTTA.getDefaultState(), 7)).setMinStackHeight(7).setMaxHeight(12).setMinRadius(8).setMaxRadius(12).build()));


    public static ConfiguredFeature<?, ?> RIVER = WorldGenRegistrationHelper.createConfiguredFeature("river_aheehee", BYGFeatures.HUH.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(new NoPlacementConfig())));
    public static ConfiguredFeature<?, ?> VOLCANO = WorldGenRegistrationHelper.createConfiguredFeature("volcano", BYGFeatures.VOLCANO.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(new NoPlacementConfig())));
    public static final ConfiguredFeature<?, ?> BASALT_SPRING = WorldGenRegistrationHelper.createConfiguredFeature("blackhead_spring", Feature.SPRING_FEATURE.withConfiguration(new LiquidsConfig(Blocks.WATER.getDefaultState().getFluidState(), true, 4, 1, ImmutableSet.of(Blocks.BLACKSTONE))).withPlacement(Features.Placements.SPRING_PLACEMENT).func_242728_a().func_242731_b(16));
    public static final ConfiguredFeature<?, ?> BASALT_DELTA = WorldGenRegistrationHelper.createConfiguredFeature("delta", Feature.DELTA_FEATURE.withConfiguration(new BasaltDeltasFeature(Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), FeatureSpread.func_242253_a(3, 4), FeatureSpread.func_242253_a(0, 2))).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(2))));
    public static final ConfiguredFeature<?, ?> SMALL_BASALT_COLUMN = WorldGenRegistrationHelper.createConfiguredFeature("small_basalt_columns", Feature.BASALT_COLUMNS.withConfiguration(new ColumnConfig(FeatureSpread.func_242252_a(1), FeatureSpread.func_242253_a(1, 1))).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(1))));
    public static final ConfiguredFeature<?, ?> LARGE_BASALT_COLUMN = WorldGenRegistrationHelper.createConfiguredFeature("large_basalt_columns", Feature.BASALT_COLUMNS.withConfiguration(new ColumnConfig(FeatureSpread.func_242253_a(2, 1), FeatureSpread.func_242253_a(1, 1))).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(1))));
    public static final ConfiguredFeature<?, ?> BASALT_BLOBS = WorldGenRegistrationHelper.createConfiguredFeature("basalt_blobs", Feature.NETHERRACK_REPLACE_BLOBS.withConfiguration(new BlobReplacementConfig(BYGBlocks.BLACK_SAND.getDefaultState(), Blocks.BASALT.getDefaultState(), FeatureSpread.func_242253_a(1, 1))).func_242733_d(128).func_242728_a().func_242731_b(75));
    public static final ConfiguredFeature<?, ?> BASALT_BLOBS2 = WorldGenRegistrationHelper.createConfiguredFeature("blackstone_blobs2", Feature.NETHERRACK_REPLACE_BLOBS.withConfiguration(new BlobReplacementConfig(BYGBlocks.BLACK_SAND.getDefaultState(), Blocks.BASALT.getDefaultState(), FeatureSpread.func_242253_a(1, 1))).func_242733_d(128).func_242728_a().func_242731_b(25));


    /***********************************************************Random Selectors***********************************************************/

    public static final ConfiguredFeature<?, ?> RANDOM_ALLIUM_FLOWER = WorldGenRegistrationHelper.createConfiguredFeature("rs_allium_flower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ALLIUM_TALL_BUSH.withChance(0.25F),
            ALLIUM_TALL_PINK_BUSH.withChance(0.25F),
            ALLIUM_BUSH.withChance(0.25F)),
            ALLIUM_PINK_BUSH)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_AMARANTH_FLOWER = WorldGenRegistrationHelper.createConfiguredFeature("rs_amaranth_flower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            AMARANTH.withChance(0.2F),
            AMARANTH_CYAN.withChance(0.2F),
            AMARANTH_MAGENTA.withChance(0.2F),
            AMARANTH_ORANGE.withChance(0.2F)),
            AMARANTH_PURPLE)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_ROSE_FIELD_FLOWER = WorldGenRegistrationHelper.createConfiguredFeature("rs_rose_field_flower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE_OSIRIA.withChance(0.25F),
            ROSE.withChance(0.25F),
            ROSE_BUSH.withChance(0.25F)),
            ROSE_BUSH)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_CALIFORNIA_POPPY = WorldGenRegistrationHelper.createConfiguredFeature("rs_california_poppy", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CALIFORNIA_POPPY.withChance(0.50F)),
            CALIFORNIA_POPPY)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WINTER_SUCCULENT = WorldGenRegistrationHelper.createConfiguredFeature("rs_winter_succulent", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WINTER_SUCCULENT.withChance(0.50F)),
            WINTER_SUCCULENT)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_HORSEWEED = WorldGenRegistrationHelper.createConfiguredFeature("rs_horseweed", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            HORSE_WEED.withChance(0.50F)),
            HORSE_WEED)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_DESERT_PLANTS = WorldGenRegistrationHelper.createConfiguredFeature("rs_desert_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MINI_CACTI.withChance(0.3F),
            PRICKLY_PEAR_CACTI.withChance(0.3F),
            GOLDEN_SPINED_CACTI.withChance(0.3F)),
            FIRECRACKER_BUSH)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));


    public static final ConfiguredFeature<?, ?> RANDOM_LUNA_BOULDERS = WorldGenRegistrationHelper.createConfiguredFeature("rs_luna_boulders", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RED_ROCK_BOULDER.withChance(0.5F)),
            TERRACOTTA_BOULDER)).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(new AtSurfaceWithExtraConfig(0, 0.3F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACKSTONE_BOULDERS = WorldGenRegistrationHelper.createConfiguredFeature("rs_blackstone_boulders", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLACKSTONE_BOULDER.withChance(0.5F)),
            BLACKSTONE_BOULDER)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOULDERS = WorldGenRegistrationHelper.createConfiguredFeature("rs_boulders", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MOSSY_STONE_BOULDER.withChance(0.5F)),
            ROCKY_STONE_BOULDER)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(2));

    public static final ConfiguredFeature<?, ?> RANDOM_TERRACOTTA_BOULDERS = WorldGenRegistrationHelper.createConfiguredFeature("rs_terracotta_boulders", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ORANGE_TERRACOTTA_BOULDER.withChance(0.5F)),
            ORANGE_TERRACOTTA_BOULDER)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(2));

    public static final ConfiguredFeature<?, ?> RANDOM_FIRECRACKER = WorldGenRegistrationHelper.createConfiguredFeature("rs_firecracker", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            FIRECRACKER_BUSH.withChance(0.50F)),
            FIRECRACKER_BUSH)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_PRAIRIE_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("rs_prairie", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PRAIRIE_GRASS.withChance(0.92F)),
            PRAIRIE_TALL_GRASS)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_PUMPKIN = WorldGenRegistrationHelper.createConfiguredFeature("rs_pumpkin", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PUMPKIN_CONFIG.withChance(0.50F)),
            PUMPKIN_CONFIG)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(8));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUEBERRIES = WorldGenRegistrationHelper.createConfiguredFeature("rs_blueberries", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_BERRY_BUSH.withChance(0.50F)),
            BLUE_BERRY_BUSH)).withPlacement(Features.Placements.PATCH_PLACEMENT));

    public static final ConfiguredFeature<?, ?> RANDOM_LUSH_BLUEBERRIES = WorldGenRegistrationHelper.createConfiguredFeature("rs_lush_blueberries", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_BERRY_BUSH.withChance(0.50F)),
            BLUE_BERRY_BUSH)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242729_a(12));

    public static final ConfiguredFeature<?, ?> RANDOM_BEACH_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("rs_beach_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BEACH_GRASS.withChance(0.50F)),
            BEACH_SHORT_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWCANE = WorldGenRegistrationHelper.createConfiguredFeature("rs_glowcane", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            GLOWCANE_BLUE.withChance(0.25F),
            GLOWCANE_PINK.withChance(0.25F),
            GLOWCANE_PURPLE.withChance(0.25F)),
            GLOWCANE_RED)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(16));

    public static final ConfiguredFeature<?, ?> RANDOM_BYG_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("rs_byg_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHORT_GRASS.withChance(0.50F)),
            Features.PATCH_GRASS_NORMAL)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(10));

    public static final ConfiguredFeature<?, ?> RANDOM_SHORT_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("rs_short_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHORT_GRASS.withChance(0.50F)),
            SHORT_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(10));

    public static final ConfiguredFeature<?, ?> RANDOM_BYG_FERN_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("rs_byg_fern_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHORT_GRASS.withChance(0.50F)),
            Features.PATCH_TAIGA_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(10));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSHROOM = WorldGenRegistrationHelper.createConfiguredFeature("rs_glowshroom", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_GLOWSHROOM.withChance(0.50F)),
            PURPLE_GLOWSHROOM)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242729_a(4));

    public static final ConfiguredFeature<?, ?> RANDOM_MUSHROOM = WorldGenRegistrationHelper.createConfiguredFeature("rs_mushroom", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLACK_PUFF.withChance(0.50F),
            WOOD_BLEWIT.withChance(0.50F),
            WEEPING_MILKCAP.withChance(0.50F)),
            GREEN_MUSHROOM)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242729_a(4));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSTONE_GARDEN_VEGETATION = WorldGenRegistrationHelper.createConfiguredFeature("rs_gg_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SOUL_SHROOM.withChance(0.2F),
            DEATH_CAP.withChance(0.2F)),
            NETHER_BRISTLE)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(4)).func_242731_b(1)));

    public static final ConfiguredFeature<?, ?> RANDOM_CRIMSON_GARDEN_VEGETATION = WorldGenRegistrationHelper.createConfiguredFeature("rs_cg_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_ROOTS_TALL.withChance(0.45F),
            CRIMSON_ROOTS_TALL.withChance(0.8F)),
            CRIMSON_BERRY_BUSH)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(25))));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_BOG_PLANT = WorldGenRegistrationHelper.createConfiguredFeature("rs_embur_bog_plant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_ROOTS_TALL.withChance(0.45F),
            EMBUR_ROOTS.withChance(0.5F)),
            EMBUR_WART)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_SPROUTS = WorldGenRegistrationHelper.createConfiguredFeature("rs_embur_sprouts", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_SPROUTS.withChance(0.5F)),
            EMBUR_SPROUTS)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(30))));

    public static final ConfiguredFeature<?, ?> RANDOM_SOUL_FIRE_PATCH_WARPED = WorldGenRegistrationHelper.createConfiguredFeature("patch_soul_fire_warped", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SOUL_FIRE_ON_NYLIUM.withChance(0.5F)),
            SOUL_FIRE_ON_NYLIUM)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(1))));

    public static final ConfiguredFeature<?, ?> RANDOM_BORIC_FIRE_PATCH = WorldGenRegistrationHelper.createConfiguredFeature("patch_boric_fire", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BORIC_FIRE.withChance(0.5F)),
            BORIC_FIRE)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(1))));

    public static final ConfiguredFeature<?, ?> RANDOM_MAGMA_FIRE_PATCH = WorldGenRegistrationHelper.createConfiguredFeature("patch_magma_fire", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MAGMA_FIRE.withChance(0.5F)),
            MAGMA_FIRE)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SUBZERO_ASH_PATCH = WorldGenRegistrationHelper.createConfiguredFeature("patch_subzero_ash", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SUBZERO_ASH.withChance(0.6F)),
            SUBZERO_ASH_BLOCK)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(3))));

    public static final ConfiguredFeature<?, ?> RANDOM_QUARTZ_CRYSTAL_PATCH = WorldGenRegistrationHelper.createConfiguredFeature("rs_quartz_crystal", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            QUARTZ_CRYSTAL.withChance(0.6F)),
            QUARTZ_CRYSTAL)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> RANDOM_WEEPING_VINE_BLACKSTONE = WorldGenRegistrationHelper.createConfiguredFeature("weeping_vines_blackstone", BYGFeatures.WEEPING_VINE_BLACKSTONE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(80));

    public static final ConfiguredFeature<?, ?> RANDOM_WEEPING_ROOTS_FEATURE = WorldGenRegistrationHelper.createConfiguredFeature("weeping_roots_feature", BYGFeatures.WEEPING_ROOTS_FEATURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(80));
    public static final ConfiguredFeature<?, ?> RANDOM_SOUL_SOIL_PILLARS = WorldGenRegistrationHelper.createConfiguredFeature("soul_soil_pillars", BYGFeatures.SOUL_SOIL_PILLARS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(50));
    public static final ConfiguredFeature<?, ?> RANDOM_FROST_MAGMA_PILLARS = WorldGenRegistrationHelper.createConfiguredFeature("frost_magma_pillars", BYGFeatures.FROST_MAGMA_PILLARS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(50));
    public static final ConfiguredFeature<?, ?> RANDOM_MAGMA_PILLARS = WorldGenRegistrationHelper.createConfiguredFeature("magma_pillars", BYGFeatures.MAGMA_PILLARS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(65));
    public static final ConfiguredFeature<?, ?> RANDOM_BRIMSTONE_PILLARS = WorldGenRegistrationHelper.createConfiguredFeature("brimstone_pillars", BYGFeatures.BRIMSTONE_PILLARS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(80));
    public static final ConfiguredFeature<?, ?> QUARTZ_COLUMNS = WorldGenRegistrationHelper.createConfiguredFeature("quartz_columns", BYGFeatures.QUARTZ_COLUMNS.withConfiguration(new ColumnConfig(FeatureSpread.func_242252_a(1), FeatureSpread.func_242253_a(1, 3))).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(4))));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_GEL_VINES = WorldGenRegistrationHelper.createConfiguredFeature("rs_embur_gel_vines", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_GEL_VINES.withChance(0.3F)),
            EMBUR_GEL_VINES)).func_242733_d(128).func_242728_a().func_242731_b(100));

    public static final ConfiguredFeature<?, ?> RANDOM_SYTHIAN_PLANT = WorldGenRegistrationHelper.createConfiguredFeature("rs_sythian_plant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SYTHIAN_SPROUT.withChance(0.5F),
            SYTHIAN_ROOTS.withChance(0.46F)),
            SYTHIAN_FUNGUS)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> HANGING_SOUL_SHROOM_SPORES = WorldGenRegistrationHelper.createConfiguredFeature("hanging_soul_shroom_spores_feature", BYGFeatures.SOUL_SHROOM_SPORES_HANGING.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(45));
    public static final ConfiguredFeature<?, ?> HANGING_SYTHIAN_ROOTS = WorldGenRegistrationHelper.createConfiguredFeature("hanging_sythian_roots_feature", BYGFeatures.SYTHIAN_HANGING_ROOTS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(80));
    public static final ConfiguredFeature<?, ?> MOSSY_NETHERRACK_PILLARS_FEATURE = WorldGenRegistrationHelper.createConfiguredFeature("mossy_netherrack_pillars", BYGFeatures.MOSSY_NETHERRACK_PILLARS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(50));
    public static final ConfiguredFeature<?, ?> SYTHIAN_FUNGUS_PILLARS_FEATURE = WorldGenRegistrationHelper.createConfiguredFeature("sythian_fungus_pillars", BYGFeatures.SYTHIAN_FUNGUS_PILLARS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(50));
    public static final ConfiguredFeature<?, ?> HANGING_BONE_FEATURE = WorldGenRegistrationHelper.createConfiguredFeature("hanging_bone_feature", BYGFeatures.HANGING_BONE_FEATURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(70));
    public static final ConfiguredFeature<?, ?> LAMENT_VINE_FEATURE = WorldGenRegistrationHelper.createConfiguredFeature("lament_vine_feature", BYGFeatures.LAMENT_VINE_FEATURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(70));


    public static final ConfiguredFeature<?, ?> RANDOM_WEEPING_ROOTS = WorldGenRegistrationHelper.createConfiguredFeature("rs_weeping_roots", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WEEPING_ROOTS.withChance(0.3F)),
            WEEPING_ROOTS_PLANT)).func_242733_d(128).func_242728_a().func_242731_b(80));

    public static final ConfiguredFeature<?, ?> RANDOM_JUNGLE_FLOWERS = WorldGenRegistrationHelper.createConfiguredFeature("rs_jungle_flowers", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BISTORT.withChance(0.50F),
            GUZMANIA.withChance(0.50F),
            BEGONIA.withChance(0.50F),
            LAZARUS_BELLFLOWER.withChance(0.50F),
            RICHEA.withChance(0.50F),
            TORCH_GINGER.withChance(0.50F)),
            INCAN_LILY)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(5));

    public static final ConfiguredFeature<?, ?> RANDOM_SWAMP_PLANTS = WorldGenRegistrationHelper.createConfiguredFeature("rs_swamp_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            TINY_LILY_PAD.withChance(0.50F)),
            WATER_SILK)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(3));

    public static final ConfiguredFeature<?, ?> RANDOM_LILY_PADS = WorldGenRegistrationHelper.createConfiguredFeature("rs_lily_pads", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            TINY_LILY_PAD.withChance(0.50F)),
            Features.PATCH_WATERLILLY)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(3));

    public static final ConfiguredFeature<?, ?> RANDOM_AZALEA = WorldGenRegistrationHelper.createConfiguredFeature("rs_azalea", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            AZALEA.withChance(0.5F)),
            AZALEA)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_SUNFLOWER = WorldGenRegistrationHelper.createConfiguredFeature("rs_sunflower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.PATCH_SUNFLOWER.withChance(0.5F)),
            Features.PATCH_SUNFLOWER)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_JAPANESE_ORCHID = WorldGenRegistrationHelper.createConfiguredFeature("rs_japanese_orchid", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            JAPANESE_ORCHID.withChance(0.5F)),
            JAPANESE_ORCHID)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_DELPHINIUM = WorldGenRegistrationHelper.createConfiguredFeature("rs_delphinium", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DELPHINIUM.withChance(0.25F)),
            DELPHINIUM)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WILTED_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("rs_wilted_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WILTED_GRASS.withChance(0.25F)),
            WILTED_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WEED_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("rs_weed_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WEED_GRASS.withChance(0.25F)),
            WEED_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WINTER_GRASS = WorldGenRegistrationHelper.createConfiguredFeature("rs_winter_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WINTER_GRASS.withChance(0.25F)),
            WINTER_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_LEAF_PILE = WorldGenRegistrationHelper.createConfiguredFeature("rs_leaf_pile", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            LEAF_PILE.withChance(0.25F)),
            LEAF_PILE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CLOVER_FLOWER_PATCH = WorldGenRegistrationHelper.createConfiguredFeature("rs_clover_flower_patch", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CLOVER_PATCH.withChance(0.5F)),
            FLOWER_PATCH)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CHERRY_FOLIAGE = WorldGenRegistrationHelper.createConfiguredFeature("rs_cherry_foliage", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WHITE_CHERRY_FOLIAGE.withChance(0.5F)),
            PINK_CHERRY_FOLIAGE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(20));

    public static final ConfiguredFeature<?, ?> RANDOM_WARPED_DESERT_VEGETATION = WorldGenRegistrationHelper.createConfiguredFeature("rs_warped_desert_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WARPED_BUSH.withChance(0.25F),
            WARPED_CORAL.withChance(0.25F),
            WARPED_CORAL_FAN.withChance(0.25F)),
            WARPED_CACTI)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(16))));

    public static final ConfiguredFeature<?, ?> RANDOM_SCORCHED_PLANT = WorldGenRegistrationHelper.createConfiguredFeature("rs_scorched_plant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SCORCHED_GRASS.withChance(0.6F)),
            SCORCHED_BUSH)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> RANDOM_LAMENT_VEGETATION = WorldGenRegistrationHelper.createConfiguredFeature("rs_lament_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SCORCHED_BUSH.withChance(0.2F),
            SCORCHED_GRASS.withChance(0.2F)),
            LAMENT_SPROUTS)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> RANDOM_WAILING_VEGETATION = WorldGenRegistrationHelper.createConfiguredFeature("rs_wailing_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SCORCHED_BUSH.withChance(0.2F),
            SCORCHED_GRASS.withChance(0.2F)),
            WAILING_GRASS)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> RANDOM_WAILING_VINES = WorldGenRegistrationHelper.createConfiguredFeature("rs_wailing_vines", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WAILING_VINES.withChance(0.5F)),
            WAILING_VINES)).func_242733_d(128).func_242728_a().func_242731_b(100));

    public static final ConfiguredFeature<?, ?> RANDOM_CHAINS = WorldGenRegistrationHelper.createConfiguredFeature("rs_chains", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CHAINS.withChance(0.5F)),
            CHAINS)).func_242733_d(128).func_242728_a().func_242731_b(4));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUEBERRY_BUSH = WorldGenRegistrationHelper.createConfiguredFeature("rs_blueberry_bush", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_BERRY_BUSH.withChance(0.5F)),
            BLUE_BERRY_BUSH)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ROSE = WorldGenRegistrationHelper.createConfiguredFeature("rs_rose", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE.withChance(0.5F)),
            ROSE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ANGELICA = WorldGenRegistrationHelper.createConfiguredFeature("rs_angelica", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ANGELICA.withChance(0.5F)),
            ANGELICA)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CROCUS = WorldGenRegistrationHelper.createConfiguredFeature("rs_crocus", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CROCUS.withChance(0.5F)),
            CROCUS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_IRIS = WorldGenRegistrationHelper.createConfiguredFeature("rs_iris", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            IRIS.withChance(0.5F)),
            IRIS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ANEMONE = WorldGenRegistrationHelper.createConfiguredFeature("rs_anemone", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ANEMONE_PINK.withChance(0.5F)),
            ANEMONE_WHITE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WINTER_ROSE = WorldGenRegistrationHelper.createConfiguredFeature("rs_winter_rose", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE_WINTER.withChance(0.5F)),
            ROSE_WINTER)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_SNOWDROPS = WorldGenRegistrationHelper.createConfiguredFeature("rs_snowdrops", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SNOWDROPS.withChance(0.5F)),
            SNOWDROPS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_PINK_ALLIUM = WorldGenRegistrationHelper.createConfiguredFeature("rs_pink_allium", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ALLIUM_PINK.withChance(0.5F)),
            ALLIUM_PINK)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ORANGE_DAISY = WorldGenRegistrationHelper.createConfiguredFeature("rs_orange_daisy", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DAISY_ORANGE.withChance(0.5F)),
            DAISY_ORANGE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_RED_CORNFLOWER = WorldGenRegistrationHelper.createConfiguredFeature("rs_red_cornflower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CORNFLOWER_RED.withChance(0.5F)),
            CORNFLOWER_RED)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_SAGE = WorldGenRegistrationHelper.createConfiguredFeature("rs_sage", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SAGE_PURPLE.withChance(0.5F)),
            SAGE_WHITE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_FOXGLOVE = WorldGenRegistrationHelper.createConfiguredFeature("rs_foxglove", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            FOXGLOVE.withChance(0.5F)),
            FOXGLOVE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_YELLOW_DAFFODIL = WorldGenRegistrationHelper.createConfiguredFeature("rs_yellow_daffodil", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DAFFODIL_YELLOW.withChance(0.5F)),
            DAFFODIL_YELLOW)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_BELLFLOWER = WorldGenRegistrationHelper.createConfiguredFeature("rs_bellflower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ALPINE_BELLFLOWER.withChance(0.5F)),
            ALPINE_BELLFLOWER)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_SCILLA = WorldGenRegistrationHelper.createConfiguredFeature("rs_scilla", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WINTER_SCILLA.withChance(0.5F)),
            WINTER_SCILLA)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_KOVAN = WorldGenRegistrationHelper.createConfiguredFeature("rs_kovan", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            KOVAN_FLOWER.withChance(0.5F)),
            KOVAN_FLOWER)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_TULIP = WorldGenRegistrationHelper.createConfiguredFeature("rs_tulip", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            TULIP_MAGENTA.withChance(0.5F),
            TULIP_YELLOW.withChance(0.5F),
            TULIP_PURPLE.withChance(0.5F),
            TULIP_CYAN.withChance(0.5F)),
            TULIP_GREEN)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(5));

    public static final ConfiguredFeature<?, ?> RANDOM_REEDS = WorldGenRegistrationHelper.createConfiguredFeature("rs_reeds", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            REEDS.withChance(0.5F)),
            REEDS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(8));

    public static final ConfiguredFeature<?, ?> RANDOM_CATTAILS = WorldGenRegistrationHelper.createConfiguredFeature("rs_cattails", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CATTAIL.withChance(0.5F)),
            CATTAIL)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(8));

    public static final ConfiguredFeature<?, ?> RANDOM_LOLIPOP = WorldGenRegistrationHelper.createConfiguredFeature("rs_lolipop", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            LOLI_POP.withChance(0.5F)),
            LOLI_POP)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ORCHID = WorldGenRegistrationHelper.createConfiguredFeature("rs_orchid", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ORCHID_PINK.withChance(0.5F),
            ORCHID_PURPLE.withChance(0.5F)),
            ORCHID_RED)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_LEATHER_FLOWER = WorldGenRegistrationHelper.createConfiguredFeature("rs_leather_flower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            LEATHER_FLOWER_PEACH.withChance(0.5F)),
            LEATHER_FLOWER_VIOLET)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_DAFFODILS = WorldGenRegistrationHelper.createConfiguredFeature("rs_daffodils", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DAFFODIL.withChance(0.5F)),
            DAFFODIL_PINK)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_ROSE = WorldGenRegistrationHelper.createConfiguredFeature("rs_black_rose", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE_BLACK.withChance(0.5F)),
            ROSE_BLACK)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CYAN_ROSE = WorldGenRegistrationHelper.createConfiguredFeature("rs_cyan_rose", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE_CYAN.withChance(0.5F)),
            ROSE_CYAN)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_OSIRIA_ROSE = WorldGenRegistrationHelper.createConfiguredFeature("rs_osiria_rose", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE_OSIRIA.withChance(0.5F)),
            ROSE_OSIRIA)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_FAIRYSLIPPER = WorldGenRegistrationHelper.createConfiguredFeature("rs_fairslipper", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            FAIRY_SLIPPER.withChance(0.5F)),
            FAIRY_SLIPPER)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_IVIS_PLANTS = WorldGenRegistrationHelper.createConfiguredFeature("rs_ivis_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            IVIS_ROOTS.withChance(0.5F)),
            IVIS_SPROUT)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(20));

    public static final ConfiguredFeature<?, ?> RANDOM_DEAD_SEA_SPIKE = WorldGenRegistrationHelper.createConfiguredFeature("rs_dead_sea_spike", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEAD_SEA_SPIKE.withChance(0.9F)),
            DEAD_SEA_SPIKE_TALL)).withPlacement(BYGDecorators.OCEAN_FLOOR.configure(new AtSurfaceWithExtraConfig(28, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_PUMPKIN_PATCH = WorldGenRegistrationHelper.createConfiguredFeature("rs_pumpkin_patch", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PUMPKIN1.withChance(0.45F),
            PUMPKIN2.withChance(0.45F)),
            PUMPKIN2)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.3F, 1))));
}
