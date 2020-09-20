package voronoiaoc.byg.core.byglists;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatureConfigs;
import voronoiaoc.byg.common.world.feature.config.BYGBoulderFeatureConfig;
import voronoiaoc.byg.common.world.feature.config.BYGGiantFlowerFeatureConfig;
import voronoiaoc.byg.common.world.feature.config.BYGPumpkinFeatureConfig;
import voronoiaoc.byg.common.world.feature.placements.AnyWaterOrSolidSurfaceSurface;
import voronoiaoc.byg.common.world.feature.placements.AtOceanFloorWithExtra;
import voronoiaoc.byg.common.world.feature.placements.ObsidianSpikePlacer;
import voronoiaoc.byg.common.world.feature.placements.UnderGroundPlacement;

public class BYGConfiguredFeatures {
    /***********************************************************Configured Features***********************************************************/

    public static ConfiguredFeature<?, ?> ALLIUM_BUSH = newConfiguredFeature("allium_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ALLIUMBUSH_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_PINK_BUSH = newConfiguredFeature("pink_allium_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINKALLIUMBUSH_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_TALL_BUSH = newConfiguredFeature("tall_allium_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALL_ALLIUM_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_TALL_PINK_BUSH = newConfiguredFeature("tall_pink_allium_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALL_PINK_ALLIUM_CONFIG));

    public static ConfiguredFeature<?, ?> AMARANTH = newConfiguredFeature("amaranth", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.AMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_MAGENTA = newConfiguredFeature("magenta_amaranth", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.MAGENTAAMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_ORANGE = newConfiguredFeature("orange_amaranth", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ORANGEAMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_PURPLE = newConfiguredFeature("purple_amaranth", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLEAMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_CYAN = newConfiguredFeature("cyan_amaranth", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CYANAMARANTH_CONFIG));

    public static ConfiguredFeature<?, ?> FERN_GRASS = newConfiguredFeature("fern_grass", Feature.RANDOM_PATCH.withConfiguration(Features.Configs.TAIGA_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> SHORT_GRASS = newConfiguredFeature("short_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SHORT_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> TALL_GRASS = newConfiguredFeature("tall_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALL_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> SOUL_FIRE_ON_NYLIUM = newConfiguredFeature("soul_fire_on_nylium", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SOULFIREONNYLIUM));

    //Giant Flowers
    public static ConfiguredFeature<BYGGiantFlowerFeatureConfig, ?> GIANT_ANGELICA_FLOWER = newConfiguredFeature("giant_angelica", BYGFeatureList.GIANT_ANGELICA_FLOWER.withConfiguration(new BYGGiantFlowerFeatureConfig.Builder().setStemBlock(BYGBlockList.PLANT_STEM).setPetalBlock(BYGBlockList.WHITE_PETAL).setMaxHeight(18).setMinHeight(12).build()));
    public static ConfiguredFeature<BYGGiantFlowerFeatureConfig, ?> GIANT_DANDELION_FLOWER = newConfiguredFeature("giant_dandelion", BYGFeatureList.GIANT_DANDELION_FLOWER.withConfiguration(new BYGGiantFlowerFeatureConfig.Builder().setStemBlock(BYGBlockList.PLANT_STEM).setPetalBlock(BYGBlockList.RED_PETAL).setPetal2Block(BYGBlockList.YELLOW_PETAL).setMaxHeight(12).setMinHeight(6).build()));
    public static ConfiguredFeature<BYGGiantFlowerFeatureConfig, ?> GIANT_IRIS_FLOWER = newConfiguredFeature("giant_iris", BYGFeatureList.GIANT_IRIS_FLOWER.withConfiguration(new BYGGiantFlowerFeatureConfig.Builder().setStemBlock(BYGBlockList.PLANT_STEM).setPetalBlock(BYGBlockList.PURPLE_PETAL).setPetal2Block(BYGBlockList.YELLOW_PETAL).setMaxHeight(12).setMinHeight(6).build()));
    public static ConfiguredFeature<BYGGiantFlowerFeatureConfig, ?> GIANT_ROSE_FLOWER = newConfiguredFeature("giant_rose", BYGFeatureList.GIANT_ROSE_FLOWER.withConfiguration(new BYGGiantFlowerFeatureConfig.Builder().setStemBlock(BYGBlockList.PLANT_STEM).setPetalBlock(BYGBlockList.RED_PETAL).setMaxHeight(12).setMinHeight(6).build()));


    public static ConfiguredFeature<?, ?> MINI_CACTI = newConfiguredFeature("mini_cacti", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.MINI_CACTUS_CONFIG));
    public static ConfiguredFeature<?, ?> HORSE_WEED = newConfiguredFeature("horse_weed", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.HORSEWEED_CONFIG));
    public static ConfiguredFeature<?, ?> TINY_LILY_PAD = newConfiguredFeature("tiny_lily_pad", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TINY_LILYPAD_CONFIG));
    public static ConfiguredFeature<?, ?> WATER_SILK = newConfiguredFeature("water_silk", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WATER_SILK_CONFIG));
    public static ConfiguredFeature<?, ?> WINTER_SUCCULENT = newConfiguredFeature("winter_succulent", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_SUCCULENT_CONFIG));
    public static ConfiguredFeature<?, ?> BEACH_GRASS = newConfiguredFeature("beach_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BEACH_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> BEACH_SHORT_GRASS = newConfiguredFeature("short_beach_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SHORT_BEACH_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> WILTED_GRASS = newConfiguredFeature("wilted_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WILTED_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> LEAF_PILE = newConfiguredFeature("leaf_pile", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.LEAF_PILE_CONFIG));
    public static ConfiguredFeature<?, ?> CLOVER_PATCH = newConfiguredFeature("clover_patch", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CLOVER_PATCH));
    public static ConfiguredFeature<?, ?> FLOWER_PATCH = newConfiguredFeature("flower_patch", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FLOWER_PATCH));
    public static ConfiguredFeature<?, ?> WEED_GRASS = newConfiguredFeature("weed_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WEED_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> WINTER_GRASS = newConfiguredFeature("winter_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> CALIFORNIA_POPPY = newConfiguredFeature("california_poppy", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CALIFORNIA_POPPY_CONFIG));
    public static ConfiguredFeature<?, ?> BLACK_PUFF = newConfiguredFeature("black_puff", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLACK_PUFF_CONFIG));
    public static ConfiguredFeature<?, ?> WEEPING_MILKCAP = newConfiguredFeature("weeping_milkcap", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WEEPING_MILKCAP_CONFIG));
    public static ConfiguredFeature<?, ?> WOOD_BLEWIT = newConfiguredFeature("wood_blewit", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WOOD_BLEWIT_CONFIG));
    public static ConfiguredFeature<?, ?> GREEN_MUSHROOM = newConfiguredFeature("green_mushroom", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GREEN_MUSHROOM_CONFIG));
    public static ConfiguredFeature<?, ?> BEGONIA = newConfiguredFeature("begonia", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BEGONIA_CONFIG));
    public static ConfiguredFeature<?, ?> BISTORT = newConfiguredFeature("bistort", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BISTORT_CONFIG));
    public static ConfiguredFeature<?, ?> GUZMANIA = newConfiguredFeature("guzmania", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GUZMANIA_CONFIG));
    public static ConfiguredFeature<?, ?> INCAN_LILY = newConfiguredFeature("incan_lily", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.INCAN_LILY_CONFIG));
    public static ConfiguredFeature<?, ?> LAZARUS_BELLFLOWER = newConfiguredFeature("lazarus_bellflower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.LAZARUS_BELLFLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> TORCH_GINGER = newConfiguredFeature("torch_ginger", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TORCH_GINGER_CONFIG));
    public static ConfiguredFeature<?, ?> RICHEA = newConfiguredFeature("richea", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RICHEA_CONFIG));
    public static ConfiguredFeature<?, ?> JAPANESE_ORCHID = newConfiguredFeature("japanese_orchid", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.JAPANESEORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> AZALEA = newConfiguredFeature("azalea", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.AZALEA_CONFIG));
    public static ConfiguredFeature<?, ?> PRAIRIE_GRASS = newConfiguredFeature("prairie_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PRAIRIEGRASS_CONFIG));
    public static ConfiguredFeature<?, ?> PRAIRIE_TALL_GRASS = newConfiguredFeature("tall_prairie_grass", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.TALLPRAIRIEGRASS_CONFIG));
    public static ConfiguredFeature<?, ?> BLUE_GLOWSHROOM = newConfiguredFeature("blue_glowshroom", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLUE_GLOWSHROOM_CONFIG));
    public static ConfiguredFeature<?, ?> PURPLE_GLOWSHROOM = newConfiguredFeature("purple_glowshroom", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_GLOWSHROOM_CONFIG));

    public static ConfiguredFeature<?, ?> PRICKLY_PEAR_CACTI = newConfiguredFeature("prickly_pear_cacti", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PRICKLY_PEAR_CONFIG));
    public static ConfiguredFeature<?, ?> GOLDEN_SPINED_CACTI = newConfiguredFeature("golden_spined_cacti", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GOLDEN_SPINED_CONFIG));

    public static ConfiguredFeature<?, ?> PINK_CHERRY_FOLIAGE = newConfiguredFeature("pink_cherry_foliage", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_CHERRY_FOLIAGE));
    public static ConfiguredFeature<?, ?> WHITE_CHERRY_FOLIAGE = newConfiguredFeature("white_cherry_foliage", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WHITE_CHERRY_FOLIAGE));

    public static ConfiguredFeature<?, ?> WARPED_CACTI = newConfiguredFeature("warped_cacti", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WARPED_CACTUS_CONFIG));
    public static ConfiguredFeature<?, ?> WARPED_BUSH = newConfiguredFeature("warped_bush", BYGFeatureList.WARPED_BUSH.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> WARPED_CORAL = newConfiguredFeature("warped_coral", BYGFeatureList.WARPED_CORAL.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> WARPED_CORAL_FAN = newConfiguredFeature("warped_coral_fan", BYGFeatureList.WARPED_CORAL_FAN.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> CHAINS = newConfiguredFeature("chains", BYGFeatureList.CHAINS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> SOUL_SOIL_PILLARS = newConfiguredFeature("soul_soil_pillars", BYGFeatureList.SOUL_SOIL_PILLARS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> SCORCHED_BUSH = newConfiguredFeature("scorched_bush", BYGFeatureList.SCORCHED_BUSH.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> SCORCHED_GRASS = newConfiguredFeature("scorched_grass", BYGFeatureList.SCORCHED_GRASS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> WAILING_GRASS = newConfiguredFeature("wailing_grass", BYGFeatureList.WAILING_GRASS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> WAILING_VINES = newConfiguredFeature("wailing_vines", BYGFeatureList.WAILING_VINES.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> BLUE_BERRY_BUSH = newConfiguredFeature("blue_berry_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLUEBERRY_BUSH_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE = newConfiguredFeature("rose", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> ANGELICA = newConfiguredFeature("angelica", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ANGELICA_CONFIG));
    public static ConfiguredFeature<?, ?> CROCUS = newConfiguredFeature("crocus", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CROCUS_CONFIG));
    public static ConfiguredFeature<?, ?> IRIS = newConfiguredFeature("iris", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.IRIS_CONFIG));
    public static ConfiguredFeature<?, ?> ANEMONE_WHITE = newConfiguredFeature("white_anemone", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WHITE_ANEMONE_CONFIG));
    public static ConfiguredFeature<?, ?> ANEMONE_PINK = newConfiguredFeature("pink_anemone", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_ANEMONE_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_WINTER = newConfiguredFeature("winter_rose", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> SNOWDROPS = newConfiguredFeature("snowdrops", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SNOWDROPS_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_PINK = newConfiguredFeature("pink_allium", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_ALLIUM_CONFIG));
    public static ConfiguredFeature<?, ?> DAISY_ORANGE = newConfiguredFeature("orange_daisy", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ORANGE_DAISY_CONFIG));
    public static ConfiguredFeature<?, ?> CORNFLOWER_RED = newConfiguredFeature("red_cornflower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RED_CORNFLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> SAGE_WHITE = newConfiguredFeature("white_sage", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WHITE_SAGE_CONFIG));
    public static ConfiguredFeature<?, ?> SAGE_PURPLE = newConfiguredFeature("purple_sage", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_SAGE_CONFIG));
    public static ConfiguredFeature<?, ?> DELPHINIUM = newConfiguredFeature("delphinium", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.DELPHINIUM_CONFIG));
    public static ConfiguredFeature<?, ?> FOXGLOVE = newConfiguredFeature("foxglove", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FOXGLOVE_CONFIG));
    public static ConfiguredFeature<?, ?> DAFFODIL_YELLOW = newConfiguredFeature("yellow_daffodil", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.YELLOW_DAFFODIL_CONFIG));
    public static ConfiguredFeature<?, ?> PUMPKIN_CONFIG = newConfiguredFeature("pumpkin", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PUMPKIN_CONFIG));
    public static ConfiguredFeature<?, ?> ALPINE_BELLFLOWER = newConfiguredFeature("alpine_bellflower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.ALPINE_BELLFLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> WINTER_SCILLA = newConfiguredFeature("winter_scilla", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.WINTER_SCILLA_CONFIG));
    public static ConfiguredFeature<?, ?> KOVAN_FLOWER = newConfiguredFeature("kovan_flower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.KOVAN_FLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> FIRECRACKER_BUSH = newConfiguredFeature("firecracker_bush", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FIRECRACKER_CONFIG));

    public static ConfiguredFeature<?, ?> NETHER_BRISTLE = newConfiguredFeature("nether_bristle", BYGFeatureList.NETHER_BRISTLE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> TULIP_GREEN = newConfiguredFeature("green_tulip", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.GREEN_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_CYAN = newConfiguredFeature("cyan_tulip", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CYAN_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_MAGENTA = newConfiguredFeature("magenta_tulip", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.MAGENTA_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_PURPLE = newConfiguredFeature("purple_tulip", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_YELLOW = newConfiguredFeature("yellow_tulip", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.YELLOW_TULIP_CONFIG));

    public static ConfiguredFeature<?, ?> REEDS = newConfiguredFeature("reeds", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.REEDS_CONFIG));
    public static ConfiguredFeature<?, ?> CATTAIL = newConfiguredFeature("cattail", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CATTAIL_CONFIG));

    public static ConfiguredFeature<?, ?> GLOWCANE_BLUE = newConfiguredFeature("blue_glowcane", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLUE_GLOWCANE_CONFIG));
    public static ConfiguredFeature<?, ?> GLOWCANE_PURPLE = newConfiguredFeature("purple_glowcane", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_GLOWCANE_CONFIG));
    public static ConfiguredFeature<?, ?> GLOWCANE_RED = newConfiguredFeature("red_glowcane", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RED_GLOWCANE_CONFIG));
    public static ConfiguredFeature<?, ?> GLOWCANE_PINK = newConfiguredFeature("pink_glowcane", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_GLOWCANE_CONFIG));

    public static ConfiguredFeature<?, ?> LOLI_POP = newConfiguredFeature("loli_pop", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.LOLLI_POP_CONFIG));
    public static ConfiguredFeature<?, ?> ORCHID_RED = newConfiguredFeature("red_orchid", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.RED_ORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> ORCHID_PINK = newConfiguredFeature("pink_orchid", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_ORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> ORCHID_PURPLE = newConfiguredFeature("purple_orchid", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PURPLE_ORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> LEATHER_FLOWER_PEACH = newConfiguredFeature("peach_leather_flower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PEACH_LEATHER_FLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> LEATHER_FLOWER_VIOLET = newConfiguredFeature("violet_leather_flower", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.VIOLET_LEATHER_FLOWER_CONFIG));

    public static ConfiguredFeature<?, ?> DAFFODIL_PINK = newConfiguredFeature("pink_daffodil", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.PINK_DAFFODIL_CONFIG));
    public static ConfiguredFeature<?, ?> DAFFODIL = newConfiguredFeature("daffodil", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.DAFFODIL_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_BLACK = newConfiguredFeature("black_rose", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.BLACK_ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_CYAN = newConfiguredFeature("cyan_rose", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.CYAN_ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_OSIRIA = newConfiguredFeature("osiria_rose", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.OSIRIA_CONFIG));
    public static ConfiguredFeature<?, ?> FAIRY_SLIPPER = newConfiguredFeature("fairy_slipper", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.FAIRYSLIPPER_CONFIG));

    public static ConfiguredFeature<?, ?> IVIS_ROOTS = newConfiguredFeature("ivis_roots", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.IVIS_ROOTS));
    public static ConfiguredFeature<?, ?> IVIS_SPROUT = newConfiguredFeature("ivis_sprout", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.IVIS_SPROUT));

    public static ConfiguredFeature<?, ?> WEEPING_VINE_BLACKSTONE = newConfiguredFeature("weeping_vines_blackstone", BYGFeatureList.WEEPING_VINE_BLACKSTONE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> WEEPING_ROOTS = newConfiguredFeature("weeping_roots", BYGFeatureList.WEEPING_ROOTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> WEEPING_ROOTS_PLANT = newConfiguredFeature("weeping_roots_plant", BYGFeatureList.WEEPING_ROOTS_PLANT.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> EMBUR_ROOTS = newConfiguredFeature("embur_roots", BYGFeatureList.EMBUR_ROOTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> EMBUR_ROOTS_TALL = newConfiguredFeature("tall_embur_roots", BYGFeatureList.TALL_EMBUR_ROOTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> EMBUR_GEL_VINES = newConfiguredFeature("embur_gel_vines", BYGFeatureList.EMBUR_GEL_VINES.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> EMBUR_WART = newConfiguredFeature("embur_wart", BYGFeatureList.EMBUR_WART.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> EMBUR_SPROUTS = newConfiguredFeature("embur_sprouts", BYGFeatureList.EMBUR_SPROUTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> CRIMSON_ROOTS_TALL = newConfiguredFeature("tall_crimson_roots", BYGFeatureList.TALL_CRIMSON_ROOTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> CRIMSON_BERRY_BUSH = newConfiguredFeature("crimson_berry_bush", BYGFeatureList.CRIMSON_BERRY_BUSH.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> SYTHIAN_ROOTS = newConfiguredFeature("sythian_root", BYGFeatureList.SYTHIAN_ROOTS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> SYTHIAN_SPROUT = newConfiguredFeature("sythian_sprout", BYGFeatureList.SYTHIAN_SPROUT.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> SYTHIAN_FUNGUS = newConfiguredFeature("sythian_fungus", BYGFeatureList.SYTHIAN_FUNGUS.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> SOUL_SHROOM = newConfiguredFeature("soul_shroom", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.SOUL_SHROOM_CONFIG));
    public static ConfiguredFeature<?, ?> DEATH_CAP = newConfiguredFeature("death_cap", Feature.RANDOM_PATCH.withConfiguration(BYGFeatureConfigs.DEATH_CAP_CONFIG));

    public static ConfiguredFeature<?, ?> DEAD_SEA_SPIKE = newConfiguredFeature("dead_sea_spike", BYGFeatureList.DEADSEASPIKES.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));
    public static ConfiguredFeature<?, ?> DEAD_SEA_SPIKE_TALL = newConfiguredFeature("dead_sea_tall_spike", BYGFeatureList.TALLDEADSEASPIKES.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static ConfiguredFeature<?, ?> ORE_PERVADED_NETHERRACK = newConfiguredFeature("ore_pervaded_netherrack", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241883_b, BYGBlockList.PERVADED_NETHERRACK.getDefaultState(), 14)).withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).func_242728_a().func_242731_b(16));

    public static ConfiguredFeature<?, ?> ORE_AMETRINE = newConfiguredFeature("ore_ametrine", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BYGBlockList.AMETRINE_ORE.getDefaultState(), 4)).func_242733_d(56).func_242728_a().func_242731_b(10));
    public static ConfiguredFeature<?, ?> ORE_PENDORITE = newConfiguredFeature("ore_pendorite", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BYGBlockList.PENDORITE_ORE.getDefaultState(), 4)).func_242733_d(56).func_242728_a().func_242731_b(10));

    public static ConfiguredFeature<?, ?> ORE_ROCKY_STONE = newConfiguredFeature("ore_rocky_stone", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BYGBlockList.ROCKY_STONE.getDefaultState(), 20)).func_242733_d(63).func_242728_a().func_242731_b(10));
    public static ConfiguredFeature<?, ?> ORE_SCORIA_STONE = newConfiguredFeature("ore_scoria_stone", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BYGBlockList.SCORIA_STONE.getDefaultState(), 20)).func_242733_d(63).func_242728_a().func_242731_b(10));
    public static ConfiguredFeature<?, ?> ORE_SOAP_STONE = newConfiguredFeature("ore_soap_stone", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, BYGBlockList.SOAPSTONE.getDefaultState(), 20)).func_242733_d(63).func_242728_a().func_242731_b(10));

    public static ConfiguredFeature<?, ?> MOSSY_STONE_BOULDER = newConfiguredFeature("mossy_stone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(BYGBlockList.MOSSY_STONE.getDefaultState())));
    public static ConfiguredFeature<?, ?> ROCKY_STONE_BOULDER = newConfiguredFeature("rocky_stone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(BYGBlockList.ROCKY_STONE.getDefaultState())));
    public static ConfiguredFeature<?, ?> BLACKSTONE_BOULDER = newConfiguredFeature("blackstone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.BLACKSTONE.getDefaultState())));
    public static ConfiguredFeature<?, ?> ORANGE_TERRACOTTA_BOULDER = newConfiguredFeature("orange_terracotta_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.ORANGE_TERRACOTTA.getDefaultState())));

    public static final ConfiguredFeature<BYGPumpkinFeatureConfig, ?> PUMPKIN1 = newConfiguredFeature("pumpkin1", BYGFeatureList.LARGE_PUMPKIN1.withConfiguration(new BYGPumpkinFeatureConfig.Builder().setPumpkinBlock(Blocks.PUMPKIN).setStemBlock(Blocks.OAK_LOG).build()));
    public static final ConfiguredFeature<BYGPumpkinFeatureConfig, ?> PUMPKIN2 = newConfiguredFeature("pumpkin2", BYGFeatureList.LARGE_PUMPKIN2.withConfiguration(new BYGPumpkinFeatureConfig.Builder().setPumpkinBlock(Blocks.PUMPKIN).setStemBlock(Blocks.OAK_LOG).build()));


    /***********************************************************Configured & Decorated Features***********************************************************/

    public static ConfiguredFeature<?, ?> FROST_MAGMA_LAKE = newConfiguredFeature("frost_magma_lake", BYGFeatureList.LAKE_FROST.withConfiguration(new BlockStateFeatureConfig(BYGBlockList.FROST_MAGMA.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
    public static ConfiguredFeature<?, ?> WARPED_CORAL_PLANT = newConfiguredFeature("warped_coral_plant", BYGFeatureList.HUGE_WARPED_CORAL_PLANT.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(2, 0.2F, 1))));
    public static ConfiguredFeature<?, ?> SYTHIAN_STALK = newConfiguredFeature("sythian_stalk", BYGFeatureList.SYTHIAN_STALK.withConfiguration(new ProbabilityConfig(0.9F)).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));
    public static ConfiguredFeature<?, ?> EMBUR_LILY = newConfiguredFeature("embur_lily", BYGFeatureList.EMBUR_LILY.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(UnderGroundPlacement.UGPLACER.configure(new AtSurfaceWithExtraConfig(2, 0.5F, 2))));
    public static ConfiguredFeature<?, ?> CRAG_LAKE = newConfiguredFeature("crag_lake", BYGFeatureList.LAKE_WIDE_SHALLOW.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(AnyWaterOrSolidSurfaceSurface.WATER_OR_SOLID_SURFACE.configure(new FeatureSpreadConfig(4))));
    public static ConfiguredFeature<?, ?> EMBUR_LAKE = newConfiguredFeature("embur_lake", BYGFeatureList.EMBURLAKE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(32, 0, 4)).func_242728_a()).func_242731_b(15));
    public static ConfiguredFeature<?, ?> OBBY_SPIKE = newConfiguredFeature("obsidian_spire", BYGFeatureList.OBBYSPIKES.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(ObsidianSpikePlacer.OBBY_SPIKE.configure(new AtSurfaceWithExtraConfig(2000, 0, 0))));
    public static ConfiguredFeature<?, ?> STACKED_BOULDERS = newConfiguredFeature("stacked_boulders", BYGFeatureList.STACKABLE_BOULDERS.withConfiguration(new BYGBoulderFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.STONE.getDefaultState(), 3).addWeightedBlockstate(Blocks.DIORITE.getDefaultState(), 2)).setMinStackHeight(10).setMaxHeight(15).setMinRadius(8).setMaxRadius(28).build()).withPlacement(AtOceanFloorWithExtra.OCEANFLOOR.configure(new AtSurfaceWithExtraConfig(0, 0.15F, 1))));
    public static ConfiguredFeature<?, ?> GRASSLAND_BOULDER = newConfiguredFeature("grassland_boulder", BYGFeatureList.STACKABLE_BOULDERS.withConfiguration(new BYGBoulderFeatureConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlockList.ROCKY_STONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlockList.MOSSY_STONE.getDefaultState(), 2)).setMinStackHeight(1).setMaxHeight(1).setMinRadius(8).setMaxRadius(12).build()).withPlacement(AtOceanFloorWithExtra.OCEANFLOOR.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
    public static ConfiguredFeature<?, ?> RIVER = newConfiguredFeature("river_aheehee", BYGFeatureList.HUH.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(new NoPlacementConfig())));
    public static ConfiguredFeature<?, ?> VOLCANO = newConfiguredFeature("volcano", BYGFeatureList.VOLCANO.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(new NoPlacementConfig())));
    public static ConfiguredFeature<?, ?> VOLCANO2 = newConfiguredFeature("volcano2", BYGFeatureList.VOLCANO2.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(new NoPlacementConfig())));
    public static final ConfiguredFeature<?, ?> BASALT_SPRING = newConfiguredFeature("blackhead_spring", Feature.SPRING_FEATURE.withConfiguration(new LiquidsConfig(Blocks.WATER.getDefaultState().getFluidState(), true, 4, 1, ImmutableSet.of(Blocks.BLACKSTONE))).withPlacement(Features.Placements.SPRING_PLACEMENT).func_242728_a().func_242731_b(16));
    public static final ConfiguredFeature<?, ?> BASALT_DELTA = newConfiguredFeature("delta", Feature.DELTA_FEATURE.withConfiguration(new BasaltDeltasFeature(Blocks.WATER.getDefaultState(), BYGBlockList.BLACK_SAND.getDefaultState(), FeatureSpread.func_242253_a(3, 4), FeatureSpread.func_242253_a(0, 2))).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(40))));
    public static final ConfiguredFeature<?, ?> SMALL_BASALT_COLUMN = newConfiguredFeature("small_basalt_columns", Feature.BASALT_COLUMNS.withConfiguration(new ColumnConfig(FeatureSpread.func_242252_a(1), FeatureSpread.func_242253_a(1, 3))).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(4))));
    public static final ConfiguredFeature<?, ?> LARGE_BASALT_COLUMN = newConfiguredFeature("large_basalt_columns", Feature.BASALT_COLUMNS.withConfiguration(new ColumnConfig(FeatureSpread.func_242253_a(2, 1), FeatureSpread.func_242253_a(5, 5))).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(2))));
    public static final ConfiguredFeature<?, ?> BASALT_BLOBS = newConfiguredFeature("basalt_blobs", Feature.NETHERRACK_REPLACE_BLOBS.withConfiguration(new BlobReplacementConfig(BYGBlockList.BLACK_SAND.getDefaultState(), Blocks.BASALT.getDefaultState(), FeatureSpread.func_242253_a(3, 4))).func_242733_d(128).func_242728_a().func_242731_b(75));
    public static final ConfiguredFeature<?, ?> BASALT_BLOBS2 = newConfiguredFeature("blackstone_blobs2", Feature.NETHERRACK_REPLACE_BLOBS.withConfiguration(new BlobReplacementConfig(BYGBlockList.BLACK_SAND.getDefaultState(), Blocks.BASALT.getDefaultState(), FeatureSpread.func_242253_a(3, 4))).func_242733_d(128).func_242728_a().func_242731_b(25));


    /***********************************************************Random Selectors***********************************************************/

    public static final ConfiguredFeature<?, ?> RANDOM_ALLIUM_FLOWER = newConfiguredFeature("rs_allium_flower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ALLIUM_TALL_BUSH.withChance(0.25F),
            ALLIUM_TALL_PINK_BUSH.withChance(0.25F),
            ALLIUM_BUSH.withChance(0.25F)),
            ALLIUM_PINK_BUSH)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_AMARANTH_FLOWER = newConfiguredFeature("rs_amaranth_flower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            AMARANTH.withChance(0.2F),
            AMARANTH_CYAN.withChance(0.2F),
            AMARANTH_MAGENTA.withChance(0.2F),
            AMARANTH_ORANGE.withChance(0.2F)),
            AMARANTH_PURPLE)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_CALIFORNIA_POPPY = newConfiguredFeature("rs_california_poppy", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CALIFORNIA_POPPY.withChance(0.50F)),
            CALIFORNIA_POPPY)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WINTER_SUCCULENT = newConfiguredFeature("rs_winter_succulent", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WINTER_SUCCULENT.withChance(0.50F)),
            WINTER_SUCCULENT)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_HORSEWEED = newConfiguredFeature("rs_horseweed", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            HORSE_WEED.withChance(0.50F)),
            HORSE_WEED)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_DESERT_PLANTS = newConfiguredFeature("rs_desert_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MINI_CACTI.withChance(0.3F),
            PRICKLY_PEAR_CACTI.withChance(0.3F),
            GOLDEN_SPINED_CACTI.withChance(0.3F)),
            FIRECRACKER_BUSH)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACKSTONE_BOULDERS = newConfiguredFeature("rs_blackstone_boulders", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLACKSTONE_BOULDER.withChance(0.5F)),
            BLACKSTONE_BOULDER)).withPlacement(UnderGroundPlacement.UGPLACER.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOULDERS = newConfiguredFeature("rs_boulders", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MOSSY_STONE_BOULDER.withChance(0.5F)),
            ROCKY_STONE_BOULDER)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(2));

    public static final ConfiguredFeature<?, ?> RANDOM_TERRACOTTA_BOULDERS = newConfiguredFeature("rs_terracotta_boulders", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ORANGE_TERRACOTTA_BOULDER.withChance(0.5F)),
            ORANGE_TERRACOTTA_BOULDER)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(2));

    public static final ConfiguredFeature<?, ?> RANDOM_FIRECRACKER = newConfiguredFeature("rs_firecracker", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            FIRECRACKER_BUSH.withChance(0.50F)),
            FIRECRACKER_BUSH)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_PRAIRIE_GRASS = newConfiguredFeature("rs_prairie", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PRAIRIE_GRASS.withChance(0.92F)),
            PRAIRIE_TALL_GRASS)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_PUMPKIN = newConfiguredFeature("rs_pumpkin", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PUMPKIN_CONFIG.withChance(0.50F)),
            PUMPKIN_CONFIG)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(8));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUEBERRIES = newConfiguredFeature("rs_blueberries", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_BERRY_BUSH.withChance(0.50F)),
            BLUE_BERRY_BUSH)).withPlacement(Features.Placements.PATCH_PLACEMENT));

    public static final ConfiguredFeature<?, ?> RANDOM_LUSH_BLUEBERRIES = newConfiguredFeature("rs_lush_blueberries", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_BERRY_BUSH.withChance(0.50F)),
            BLUE_BERRY_BUSH)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242729_a(12));

    public static final ConfiguredFeature<?, ?> RANDOM_BEACH_GRASS = newConfiguredFeature("rs_beach_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BEACH_GRASS.withChance(0.50F)),
            BEACH_SHORT_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWCANE = newConfiguredFeature("rs_glowcane", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            GLOWCANE_BLUE.withChance(0.25F),
            GLOWCANE_PINK.withChance(0.25F),
            GLOWCANE_PURPLE.withChance(0.25F)),
            GLOWCANE_RED)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(16));

    public static final ConfiguredFeature<?, ?> RANDOM_BYG_GRASS = newConfiguredFeature("rs_byg_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHORT_GRASS.withChance(0.50F)),
            Features.PATCH_GRASS_NORMAL)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(10));

    public static final ConfiguredFeature<?, ?> RANDOM_SHORT_GRASS = newConfiguredFeature("rs_short_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHORT_GRASS.withChance(0.50F)),
            SHORT_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(10));

    public static final ConfiguredFeature<?, ?> RANDOM_BYG_FERN_GRASS = newConfiguredFeature("rs_byg_fern_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHORT_GRASS.withChance(0.50F)),
            Features.PATCH_TAIGA_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(10));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSHROOM = newConfiguredFeature("rs_glowshroom", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_GLOWSHROOM.withChance(0.50F)),
            PURPLE_GLOWSHROOM)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242729_a(4));

    public static final ConfiguredFeature<?, ?> RANDOM_MUSHROOM = newConfiguredFeature("rs_mushroom", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLACK_PUFF.withChance(0.50F),
            WOOD_BLEWIT.withChance(0.50F),
            WEEPING_MILKCAP.withChance(0.50F)),
            GREEN_MUSHROOM)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242729_a(4));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSTONE_GARDEN_VEGETATION = newConfiguredFeature("rs_gg_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SOUL_SHROOM.withChance(0.2F),
            DEATH_CAP.withChance(0.2F)),
            NETHER_BRISTLE)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(4)).func_242731_b(1)));

    public static final ConfiguredFeature<?, ?> RANDOM_CRIMSON_GARDEN_VEGETATION = newConfiguredFeature("rs_cg_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_ROOTS_TALL.withChance(0.45F),
            CRIMSON_ROOTS_TALL.withChance(0.8F)),
            CRIMSON_BERRY_BUSH)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(25))));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_BOG_PLANT = newConfiguredFeature("rs_embur_bog_plant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_ROOTS_TALL.withChance(0.45F),
            EMBUR_ROOTS.withChance(0.5F)),
            EMBUR_WART)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_SPROUTS = newConfiguredFeature("rs_embur_sprouts", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_SPROUTS.withChance(0.5F)),
            EMBUR_SPROUTS)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(30))));

    public static final ConfiguredFeature<?, ?> RANDOM_SOUL_FIRE_PATCH_WARPED = newConfiguredFeature("patch_soul_fire_warped", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SOUL_FIRE_ON_NYLIUM.withChance(0.5F)),
            SOUL_FIRE_ON_NYLIUM)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(1))));

    public static final ConfiguredFeature<?, ?> RANDOM_WEEPING_VINE_BLACKSTONE = newConfiguredFeature("weeping_vines_blackstone", BYGFeatureList.WEEPING_VINE_BLACKSTONE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(80));

    public static final ConfiguredFeature<?, ?> RANDOM_WEEPING_ROOTS_FEATURE = newConfiguredFeature("weeping_roots_feature", BYGFeatureList.WEEPING_ROOTS_FEATURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(80));
    public static final ConfiguredFeature<?, ?> RANDOM_SOUL_SOIL_PILLARS = newConfiguredFeature("soul_soil_pillars", BYGFeatureList.SOUL_SOIL_PILLARS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(50));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_GEL_VINES = newConfiguredFeature("rs_embur_gel_vines", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_GEL_VINES.withChance(0.3F)),
            EMBUR_GEL_VINES)).func_242733_d(128).func_242728_a().func_242731_b(100));

    public static final ConfiguredFeature<?, ?> RANDOM_SYTHIAN_PLANT = newConfiguredFeature("rs_sythian_plant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SYTHIAN_SPROUT.withChance(0.5F),
            SYTHIAN_ROOTS.withChance(0.46F)),
            SYTHIAN_FUNGUS)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> HANGING_SOUL_SHROOM_SPORES = newConfiguredFeature("hanging_soul_shroom_spores_feature", BYGFeatureList.SOUL_SHROOM_SPORES_HANGING.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(60));
    public static final ConfiguredFeature<?, ?> HANGING_SYTHIAN_ROOTS = newConfiguredFeature("hanging_sythian_roots_feature", BYGFeatureList.SYTHIAN_HANGING_ROOTS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(80));
    public static final ConfiguredFeature<?, ?> MOSSY_NETHERRACK_PILLARS_FEATURE = newConfiguredFeature("mossy_netherrack_pillars", BYGFeatureList.MOSSY_NETHERRACK_PILLARS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(50));
    public static final ConfiguredFeature<?, ?> SYTHIAN_FUNGUS_PILLARS_FEATURE = newConfiguredFeature("sythian_fungus_pillars", BYGFeatureList.SYTHIAN_FUNGUS_PILLARS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_242733_d(128).func_242728_a().func_242731_b(50));


    public static final ConfiguredFeature<?, ?> RANDOM_WEEPING_ROOTS = newConfiguredFeature("rs_weeping_roots", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WEEPING_ROOTS.withChance(0.3F)),
            WEEPING_ROOTS_PLANT)).func_242733_d(128).func_242728_a().func_242731_b(80));

    public static final ConfiguredFeature<?, ?> RANDOM_JUNGLE_FLOWERS = newConfiguredFeature("rs_jungle_flowers", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BISTORT.withChance(0.50F),
            GUZMANIA.withChance(0.50F),
            BEGONIA.withChance(0.50F),
            LAZARUS_BELLFLOWER.withChance(0.50F),
            RICHEA.withChance(0.50F),
            TORCH_GINGER.withChance(0.50F)),
            INCAN_LILY)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(5));

    public static final ConfiguredFeature<?, ?> RANDOM_SWAMP_PLANTS = newConfiguredFeature("rs_swamp_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            TINY_LILY_PAD.withChance(0.50F)),
            WATER_SILK)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(3));

    public static final ConfiguredFeature<?, ?> RANDOM_LILY_PADS = newConfiguredFeature("rs_lily_pads", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            TINY_LILY_PAD.withChance(0.50F)),
            Features.PATCH_WATERLILLY)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(3));

    public static final ConfiguredFeature<?, ?> RANDOM_AZALEA = newConfiguredFeature("rs_azalea", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            AZALEA.withChance(0.5F)),
            AZALEA)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_JAPANESE_ORCHID = newConfiguredFeature("rs_japanese_orchid", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            JAPANESE_ORCHID.withChance(0.5F)),
            JAPANESE_ORCHID)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_DELPHINIUM = newConfiguredFeature("rs_delphinium", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DELPHINIUM.withChance(0.25F)),
            DELPHINIUM)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WILTED_GRASS = newConfiguredFeature("rs_wilted_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WILTED_GRASS.withChance(0.25F)),
            WILTED_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WEED_GRASS = newConfiguredFeature("rs_weed_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WEED_GRASS.withChance(0.25F)),
            WEED_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WINTER_GRASS = newConfiguredFeature("rs_winter_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WINTER_GRASS.withChance(0.25F)),
            WINTER_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_LEAF_PILE = newConfiguredFeature("rs_leaf_pile", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            LEAF_PILE.withChance(0.25F)),
            LEAF_PILE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CLOVER_FLOWER_PATCH = newConfiguredFeature("rs_clover_flower_patch", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CLOVER_PATCH.withChance(0.5F)),
            FLOWER_PATCH)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CHERRY_FOLIAGE = newConfiguredFeature("rs_cherry_foliage", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WHITE_CHERRY_FOLIAGE.withChance(0.5F)),
            PINK_CHERRY_FOLIAGE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(20));

    public static final ConfiguredFeature<?, ?> RANDOM_WARPED_DESERT_VEGETATION = newConfiguredFeature("rs_warped_desert_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WARPED_BUSH.withChance(0.25F),
            WARPED_CORAL.withChance(0.25F),
            WARPED_CORAL_FAN.withChance(0.25F)),
            WARPED_CACTI)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(16))));

    public static final ConfiguredFeature<?, ?> RANDOM_WAILING_VEGETATION = newConfiguredFeature("rs_wailing_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SCORCHED_BUSH.withChance(0.2F),
            SCORCHED_GRASS.withChance(0.2F)),
            WAILING_GRASS)).withPlacement(Placement.field_242897_C.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> RANDOM_WAILING_VINES = newConfiguredFeature("rs_wailing_vines", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WAILING_VINES.withChance(0.5F)),
            WAILING_VINES)).func_242733_d(128).func_242728_a().func_242731_b(100));

    public static final ConfiguredFeature<?, ?> RANDOM_CHAINS = newConfiguredFeature("rs_chains", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CHAINS.withChance(0.5F)),
            CHAINS)).func_242733_d(128).func_242728_a().func_242731_b(5));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUEBERRY_BUSH = newConfiguredFeature("rs_blueberry_bush", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_BERRY_BUSH.withChance(0.5F)),
            BLUE_BERRY_BUSH)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ROSE = newConfiguredFeature("rs_rose", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE.withChance(0.5F)),
            ROSE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ANGELICA = newConfiguredFeature("rs_angelica", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ANGELICA.withChance(0.5F)),
            ANGELICA)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CROCUS = newConfiguredFeature("rs_crocus", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CROCUS.withChance(0.5F)),
            CROCUS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_IRIS = newConfiguredFeature("rs_iris", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            IRIS.withChance(0.5F)),
            IRIS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ANEMONE = newConfiguredFeature("rs_anemone", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ANEMONE_PINK.withChance(0.5F)),
            ANEMONE_WHITE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WINTER_ROSE = newConfiguredFeature("rs_winter_rose", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE_WINTER.withChance(0.5F)),
            ROSE_WINTER)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_SNOWDROPS = newConfiguredFeature("rs_snowdrops", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SNOWDROPS.withChance(0.5F)),
            SNOWDROPS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_PINK_ALLIUM = newConfiguredFeature("rs_pink_allium", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ALLIUM_PINK.withChance(0.5F)),
            ALLIUM_PINK)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ORANGE_DAISY = newConfiguredFeature("rs_orange_daisy", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DAISY_ORANGE.withChance(0.5F)),
            DAISY_ORANGE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_RED_CORNFLOWER = newConfiguredFeature("rs_red_cornflower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CORNFLOWER_RED.withChance(0.5F)),
            CORNFLOWER_RED)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_SAGE = newConfiguredFeature("rs_sage", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SAGE_PURPLE.withChance(0.5F)),
            SAGE_WHITE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_FOXGLOVE = newConfiguredFeature("rs_foxglove", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            FOXGLOVE.withChance(0.5F)),
            FOXGLOVE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_YELLOW_DAFFODIL = newConfiguredFeature("rs_yellow_daffodil", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DAFFODIL_YELLOW.withChance(0.5F)),
            DAFFODIL_YELLOW)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_BELLFLOWER = newConfiguredFeature("rs_bellflower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ALPINE_BELLFLOWER.withChance(0.5F)),
            ALPINE_BELLFLOWER)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_SCILLA = newConfiguredFeature("rs_scilla", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WINTER_SCILLA.withChance(0.5F)),
            WINTER_SCILLA)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_KOVAN = newConfiguredFeature("rs_kovan", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            KOVAN_FLOWER.withChance(0.5F)),
            KOVAN_FLOWER)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_TULIP = newConfiguredFeature("rs_tulip", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            TULIP_MAGENTA.withChance(0.5F),
            TULIP_YELLOW.withChance(0.5F),
            TULIP_PURPLE.withChance(0.5F),
            TULIP_CYAN.withChance(0.5F)),
            TULIP_GREEN)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(5));

    public static final ConfiguredFeature<?, ?> RANDOM_REEDS = newConfiguredFeature("rs_reeds", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            REEDS.withChance(0.5F)),
            REEDS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(8));

    public static final ConfiguredFeature<?, ?> RANDOM_CATTAILS = newConfiguredFeature("rs_cattails", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CATTAIL.withChance(0.5F)),
            CATTAIL)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(8));

    public static final ConfiguredFeature<?, ?> RANDOM_LOLIPOP = newConfiguredFeature("rs_lolipop", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            LOLI_POP.withChance(0.5F)),
            LOLI_POP)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ORCHID = newConfiguredFeature("rs_orchid", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ORCHID_PINK.withChance(0.5F),
            ORCHID_PURPLE.withChance(0.5F)),
            ORCHID_RED)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_LEATHER_FLOWER = newConfiguredFeature("rs_leather_flower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            LEATHER_FLOWER_PEACH.withChance(0.5F)),
            LEATHER_FLOWER_VIOLET)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_DAFFODILS = newConfiguredFeature("rs_daffodils", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DAFFODIL.withChance(0.5F)),
            DAFFODIL_PINK)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_ROSE = newConfiguredFeature("rs_black_rose", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE_BLACK.withChance(0.5F)),
            ROSE_BLACK)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CYAN_ROSE = newConfiguredFeature("rs_cyan_rose", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE_CYAN.withChance(0.5F)),
            ROSE_CYAN)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_OSIRIA_ROSE = newConfiguredFeature("rs_osiria_rose", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE_OSIRIA.withChance(0.5F)),
            ROSE_OSIRIA)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_FAIRYSLIPPER = newConfiguredFeature("rs_fairslipper", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            FAIRY_SLIPPER.withChance(0.5F)),
            FAIRY_SLIPPER)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_IVIS_PLANTS = newConfiguredFeature("rs_ivis_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            IVIS_ROOTS.withChance(0.5F)),
            IVIS_SPROUT)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(20));

    public static final ConfiguredFeature<?, ?> RANDOM_DEAD_SEA_SPIKE = newConfiguredFeature("rs_dead_sea_spike", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEAD_SEA_SPIKE.withChance(0.9F)),
            DEAD_SEA_SPIKE_TALL)).withPlacement(AtOceanFloorWithExtra.OCEANFLOOR.configure(new AtSurfaceWithExtraConfig(28, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_PUMPKIN_PATCH = newConfiguredFeature("rs_pumpkin_patch", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PUMPKIN1.withChance(0.45F),
            PUMPKIN2.withChance(0.45F)),
            PUMPKIN2)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Placement.field_242902_f.configure(
            new AtSurfaceWithExtraConfig(2, 0.3F, 1))));


    private static <FC extends IFeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, F> newConfiguredFeature(String registryName, ConfiguredFeature<FC, F> configuredFeature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(BYG.MOD_ID, registryName), configuredFeature);
        return configuredFeature;
    }
}
