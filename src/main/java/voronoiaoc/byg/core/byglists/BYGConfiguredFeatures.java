package voronoiaoc.byg.core.byglists;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.placement.ChanceDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatureConfigs;
import voronoiaoc.byg.common.world.feature.placements.AnyWaterOrSolidSurfaceSurface;
import voronoiaoc.byg.common.world.feature.placements.AtOceanFloorWithExtra;
import voronoiaoc.byg.common.world.feature.placements.ObsidianSpikePlacer;
import voronoiaoc.byg.common.world.feature.placements.UnderGroundPlacement;

public class BYGConfiguredFeatures {
    /***********************************************************Configured Features***********************************************************/

    public static ConfiguredFeature<?, ?> ALLIUM_BUSH = newConfiguredFeature("allium_bush", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.ALLIUMBUSH_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_PINK_BUSH = newConfiguredFeature("pink_allium_bush", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PINKALLIUMBUSH_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_TALL_BUSH = newConfiguredFeature("tall_allium_bush", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.TALL_ALLIUM_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_TALL_PINK_BUSH = newConfiguredFeature("tall_pink_allium_bush", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.TALL_PINK_ALLIUM_CONFIG));

    public static ConfiguredFeature<?, ?> AMARANTH = newConfiguredFeature("amaranth", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.AMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_MAGENTA = newConfiguredFeature("magenta_amaranth", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.MAGENTAAMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_ORANGE = newConfiguredFeature("orange_amaranth", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.ORANGEAMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_PURPLE = newConfiguredFeature("purple_amaranth", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PURPLEAMARANTH_CONFIG));
    public static ConfiguredFeature<?, ?> AMARANTH_CYAN = newConfiguredFeature("cyan_amaranth", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.CYANAMARANTH_CONFIG));

    public static ConfiguredFeature<?, ?> FERN_GRASS = newConfiguredFeature("fern_grass", Feature.RANDOM_PATCH.configured(Features.Configs.TAIGA_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> SHORT_GRASS = newConfiguredFeature("short_grass", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.SHORT_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> TALL_GRASS = newConfiguredFeature("tall_grass", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.TALL_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> SOUL_FIRE_ON_NYLIUM = newConfiguredFeature("soul_fire_on_nylium", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.SOULFIREONNYLIUM));

    public static ConfiguredFeature<?, ?> MINI_CACTI = newConfiguredFeature("mini_cacti", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.MINI_CACTUS_CONFIG));
    public static ConfiguredFeature<?, ?> HORSE_WEED = newConfiguredFeature("horse_weed", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.HORSEWEED_CONFIG));
    public static ConfiguredFeature<?, ?> TINY_LILY_PAD = newConfiguredFeature("tiny_lily_pad", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.TINY_LILYPAD_CONFIG));
    public static ConfiguredFeature<?, ?> WATER_SILK = newConfiguredFeature("water_silk", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WATER_SILK_CONFIG));
    public static ConfiguredFeature<?, ?> WINTER_SUCCULENT = newConfiguredFeature("winter_succulent", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WINTER_SUCCULENT_CONFIG));
    public static ConfiguredFeature<?, ?> BEACH_GRASS = newConfiguredFeature("beach_grass", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.BEACH_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> BEACH_SHORT_GRASS = newConfiguredFeature("short_beach_grass", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.SHORT_BEACH_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> WILTED_GRASS = newConfiguredFeature("wilted_grass", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WILTED_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> LEAF_PILE = newConfiguredFeature("leaf_pile", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.LEAF_PILE_CONFIG));
    public static ConfiguredFeature<?, ?> CLOVER_PATCH = newConfiguredFeature("clover_patch", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.CLOVER_PATCH));
    public static ConfiguredFeature<?, ?> FLOWER_PATCH = newConfiguredFeature("flower_patch", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.FLOWER_PATCH));
    public static ConfiguredFeature<?, ?> WEED_GRASS = newConfiguredFeature("weed_grass", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WEED_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> WINTER_GRASS = newConfiguredFeature("winter_grass", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WINTER_GRASS_CONFIG));
    public static ConfiguredFeature<?, ?> CALIFORNIA_POPPY = newConfiguredFeature("california_poppy", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.CALIFORNIA_POPPY_CONFIG));
    public static ConfiguredFeature<?, ?> BLACK_PUFF = newConfiguredFeature("black_puff", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.BLACK_PUFF_CONFIG));
    public static ConfiguredFeature<?, ?> WEEPING_MILKCAP = newConfiguredFeature("weeping_milkcap", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WEEPING_MILKCAP_CONFIG));
    public static ConfiguredFeature<?, ?> WOOD_BLEWIT = newConfiguredFeature("wood_blewit", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WOOD_BLEWIT_CONFIG));
    public static ConfiguredFeature<?, ?> GREEN_MUSHROOM = newConfiguredFeature("green_mushroom", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.GREEN_MUSHROOM_CONFIG));
    public static ConfiguredFeature<?, ?> BEGONIA = newConfiguredFeature("begonia", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.BEGONIA_CONFIG));
    public static ConfiguredFeature<?, ?> BISTORT = newConfiguredFeature("bistort", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.BISTORT_CONFIG));
    public static ConfiguredFeature<?, ?> GUZMANIA = newConfiguredFeature("guzmania", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.GUZMANIA_CONFIG));
    public static ConfiguredFeature<?, ?> INCAN_LILY = newConfiguredFeature("incan_lily", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.INCAN_LILY_CONFIG));
    public static ConfiguredFeature<?, ?> LAZARUS_BELLFLOWER = newConfiguredFeature("lazarus_bellflower", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.LAZARUS_BELLFLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> TORCH_GINGER = newConfiguredFeature("torch_ginger", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.TORCH_GINGER_CONFIG));
    public static ConfiguredFeature<?, ?> RICHEA = newConfiguredFeature("richea", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.RICHEA_CONFIG));
    public static ConfiguredFeature<?, ?> JAPANESE_ORCHID = newConfiguredFeature("japanese_orchid", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.JAPANESEORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> AZALEA = newConfiguredFeature("azalea", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.AZALEA_CONFIG));
    public static ConfiguredFeature<?, ?> PRAIRIE_GRASS = newConfiguredFeature("prairie_grass", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PRAIRIEGRASS_CONFIG));
    public static ConfiguredFeature<?, ?> PRAIRIE_TALL_GRASS = newConfiguredFeature("tall_prairie_grass", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.TALLPRAIRIEGRASS_CONFIG));
    public static ConfiguredFeature<?, ?> BLUE_GLOWSHROOM = newConfiguredFeature("blue_glowshroom", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.BLUE_GLOWSHROOM_CONFIG));
    public static ConfiguredFeature<?, ?> PURPLE_GLOWSHROOM = newConfiguredFeature("purple_glowshroom", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PURPLE_GLOWSHROOM_CONFIG));

    public static ConfiguredFeature<?, ?> PRICKLY_PEAR_CACTI = newConfiguredFeature("prickly_pear_cacti", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PRICKLY_PEAR_CONFIG));
    public static ConfiguredFeature<?, ?> GOLDEN_SPINED_CACTI = newConfiguredFeature("golden_spined_cacti", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.GOLDEN_SPINED_CONFIG));

    public static ConfiguredFeature<?, ?> PINK_CHERRY_FOLIAGE = newConfiguredFeature("pink_cherry_foliage", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PINK_CHERRY_FOLIAGE));
    public static ConfiguredFeature<?, ?> WHITE_CHERRY_FOLIAGE = newConfiguredFeature("white_cherry_foliage", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WHITE_CHERRY_FOLIAGE));

    public static ConfiguredFeature<?, ?> WARPED_CACTI = newConfiguredFeature("warped_cacti", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WARPED_CACTUS_CONFIG));
    public static ConfiguredFeature<?, ?> WARPED_BUSH = newConfiguredFeature("warped_bush", BYGFeatureList.WARPED_BUSH.configured(FeatureConfiguration.NONE));
    public static ConfiguredFeature<?, ?> WARPED_CORAL = newConfiguredFeature("warped_coral", BYGFeatureList.WARPED_CORAL.configured(FeatureConfiguration.NONE));
    public static ConfiguredFeature<?, ?> WARPED_CORAL_FAN = newConfiguredFeature("warped_coral_fan", BYGFeatureList.WARPED_CORAL_FAN.configured(FeatureConfiguration.NONE));

    public static ConfiguredFeature<?, ?> BLUE_BERRY_BUSH = newConfiguredFeature("blue_berry_bush", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.BLUEBERRY_BUSH_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE = newConfiguredFeature("rose", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> ANGELICA = newConfiguredFeature("angelica", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.ANGELICA_CONFIG));
    public static ConfiguredFeature<?, ?> CROCUS = newConfiguredFeature("crocus", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.CROCUS_CONFIG));
    public static ConfiguredFeature<?, ?> IRIS = newConfiguredFeature("iris", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.IRIS_CONFIG));
    public static ConfiguredFeature<?, ?> ANEMONE_WHITE = newConfiguredFeature("white_anemone", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WHITE_ANEMONE_CONFIG));
    public static ConfiguredFeature<?, ?> ANEMONE_PINK = newConfiguredFeature("pink_anemone", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PINK_ANEMONE_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_WINTER = newConfiguredFeature("winter_rose", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WINTER_ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> SNOWDROPS = newConfiguredFeature("snowdrops", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.SNOWDROPS_CONFIG));
    public static ConfiguredFeature<?, ?> ALLIUM_PINK = newConfiguredFeature("pink_allium", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PINK_ALLIUM_CONFIG));
    public static ConfiguredFeature<?, ?> DAISY_ORANGE = newConfiguredFeature("orange_daisy", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.ORANGE_DAISY_CONFIG));
    public static ConfiguredFeature<?, ?> CORNFLOWER_RED = newConfiguredFeature("red_cornflower", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.RED_CORNFLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> SAGE_WHITE = newConfiguredFeature("white_sage", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WHITE_SAGE_CONFIG));
    public static ConfiguredFeature<?, ?> SAGE_PURPLE = newConfiguredFeature("purple_sage", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PURPLE_SAGE_CONFIG));
    public static ConfiguredFeature<?, ?> DELPHINIUM = newConfiguredFeature("delphinium", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.DELPHINIUM_CONFIG));
    public static ConfiguredFeature<?, ?> FOXGLOVE = newConfiguredFeature("foxglove", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.FOXGLOVE_CONFIG));
    public static ConfiguredFeature<?, ?> DAFFODIL_YELLOW = newConfiguredFeature("yellow_daffodil", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.YELLOW_DAFFODIL_CONFIG));
    public static ConfiguredFeature<?, ?> PUMPKIN_CONFIG = newConfiguredFeature("pumpkin", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PUMPKIN_CONFIG));
    public static ConfiguredFeature<?, ?> ALPINE_BELLFLOWER = newConfiguredFeature("alpine_bellflower", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.ALPINE_BELLFLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> WINTER_SCILLA = newConfiguredFeature("winter_scilla", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.WINTER_SCILLA_CONFIG));
    public static ConfiguredFeature<?, ?> KOVAN_FLOWER = newConfiguredFeature("kovan_flower", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.KOVAN_FLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> FIRECRACKER_BUSH = newConfiguredFeature("firecracker_bush", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.FIRECRACKER_CONFIG));

    public static ConfiguredFeature<?, ?> NETHER_BRISTLE = newConfiguredFeature("nether_bristle", BYGFeatureList.NETHER_BRISTLE.configured(FeatureConfiguration.NONE));

    public static ConfiguredFeature<?, ?> TULIP_GREEN = newConfiguredFeature("green_tulip", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.GREEN_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_CYAN = newConfiguredFeature("cyan_tulip", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.CYAN_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_MAGENTA = newConfiguredFeature("magenta_tulip", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.MAGENTA_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_PURPLE = newConfiguredFeature("purple_tulip", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PURPLE_TULIP_CONFIG));
    public static ConfiguredFeature<?, ?> TULIP_YELLOW = newConfiguredFeature("yellow_tulip", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.YELLOW_TULIP_CONFIG));

    public static ConfiguredFeature<?, ?> REEDS = newConfiguredFeature("reeds", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.REEDS_CONFIG));
    public static ConfiguredFeature<?, ?> CATTAIL = newConfiguredFeature("cattail", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.CATTAIL_CONFIG));

    public static ConfiguredFeature<?, ?> GLOWCANE_BLUE = newConfiguredFeature("blue_glowcane", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.BLUE_GLOWCANE_CONFIG));
    public static ConfiguredFeature<?, ?> GLOWCANE_PURPLE = newConfiguredFeature("purple_glowcane", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PURPLE_GLOWCANE_CONFIG));
    public static ConfiguredFeature<?, ?> GLOWCANE_RED = newConfiguredFeature("red_glowcane", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.RED_GLOWCANE_CONFIG));
    public static ConfiguredFeature<?, ?> GLOWCANE_PINK = newConfiguredFeature("pink_glowcane", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PINK_GLOWCANE_CONFIG));

    public static ConfiguredFeature<?, ?> LOLI_POP = newConfiguredFeature("loli_pop", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.LOLLI_POP_CONFIG));
    public static ConfiguredFeature<?, ?> ORCHID_RED = newConfiguredFeature("red_orchid", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.RED_ORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> ORCHID_PINK = newConfiguredFeature("pink_orchid", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PINK_ORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> ORCHID_PURPLE = newConfiguredFeature("purple_orchid", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PURPLE_ORCHID_CONFIG));
    public static ConfiguredFeature<?, ?> LEATHER_FLOWER_PEACH = newConfiguredFeature("peach_leather_flower", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PEACH_LEATHER_FLOWER_CONFIG));
    public static ConfiguredFeature<?, ?> LEATHER_FLOWER_VIOLET = newConfiguredFeature("violet_leather_flower", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.VIOLET_LEATHER_FLOWER_CONFIG));

    public static ConfiguredFeature<?, ?> DAFFODIL_PINK = newConfiguredFeature("pink_daffodil", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.PINK_DAFFODIL_CONFIG));
    public static ConfiguredFeature<?, ?> DAFFODIL = newConfiguredFeature("daffodil", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.DAFFODIL_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_BLACK = newConfiguredFeature("black_rose", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.BLACK_ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_CYAN = newConfiguredFeature("cyan_rose", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.CYAN_ROSE_CONFIG));
    public static ConfiguredFeature<?, ?> ROSE_OSIRIA = newConfiguredFeature("osiria_rose", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.OSIRIA_CONFIG));
    public static ConfiguredFeature<?, ?> FAIRY_SLIPPER = newConfiguredFeature("fairy_slipper", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.FAIRYSLIPPER_CONFIG));

    public static ConfiguredFeature<?, ?> IVIS_ROOTS = newConfiguredFeature("ivis_roots", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.IVIS_ROOTS));
    public static ConfiguredFeature<?, ?> IVIS_SPROUT = newConfiguredFeature("ivis_sprout", Feature.RANDOM_PATCH.configured(BYGFeatureConfigs.IVIS_SPROUT));

    public static ConfiguredFeature<?, ?> WEEPING_ROOTS = newConfiguredFeature("weeping_roots", BYGFeatureList.WEEPING_ROOTS.configured(NoneFeatureConfiguration.NONE));
    public static ConfiguredFeature<?, ?> WEEPING_ROOTS_PLANT = newConfiguredFeature("weeping_roots_plant", BYGFeatureList.WEEPING_ROOTS_PLANT.configured(NoneFeatureConfiguration.NONE));

    public static ConfiguredFeature<?, ?> EMBUR_ROOTS = newConfiguredFeature("embur_roots", BYGFeatureList.EMBUR_ROOTS.configured(NoneFeatureConfiguration.NONE));
    public static ConfiguredFeature<?, ?> EMBUR_ROOTS_TALL = newConfiguredFeature("tall_embur_roots", BYGFeatureList.TALL_EMBUR_ROOTS.configured(NoneFeatureConfiguration.NONE));
    public static ConfiguredFeature<?, ?> EMBUR_GEL_VINES = newConfiguredFeature("embur_gel_vines", BYGFeatureList.EMBUR_GEL_VINES.configured(NoneFeatureConfiguration.NONE));
    public static ConfiguredFeature<?, ?> EMBUR_WART = newConfiguredFeature("embur_wart", BYGFeatureList.EMBUR_WART.configured(NoneFeatureConfiguration.NONE));

    public static ConfiguredFeature<?, ?> SYTHIAN_ROOTS = newConfiguredFeature("sythian_root", BYGFeatureList.SYTHIAN_ROOTS.configured(FeatureConfiguration.NONE));
    public static ConfiguredFeature<?, ?> SYTHIAN_SPROUT = newConfiguredFeature("sythian_sprout", BYGFeatureList.SYTHIAN_SPROUT.configured(FeatureConfiguration.NONE));


    public static ConfiguredFeature<?, ?> DEAD_SEA_SPIKE = newConfiguredFeature("dead_sea_spike", BYGFeatureList.DEADSEASPIKES.configured(DecoratedFeatureConfiguration.NONE));
    public static ConfiguredFeature<?, ?> DEAD_SEA_SPIKE_TALL = newConfiguredFeature("dead_sea_tall_spike", BYGFeatureList.TALLDEADSEASPIKES.configured(DecoratedFeatureConfiguration.NONE));

    public static ConfiguredFeature<?, ?> ORE_AMETRINE = newConfiguredFeature("ore_ametrine", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, BYGBlockList.AMETRINE_ORE.defaultBlockState(), 4)).range(56).squared().count(10));
    public static ConfiguredFeature<?, ?> ORE_PENDORITE = newConfiguredFeature("ore_pendorite", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, BYGBlockList.PENDORITE_ORE.defaultBlockState(), 4)).range(56).squared().count(10));

    public static ConfiguredFeature<?, ?> ORE_ROCKY_STONE = newConfiguredFeature("ore_rocky_stone", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, BYGBlockList.ROCKY_STONE.defaultBlockState(), 20)).range(63).squared().count(10));
    public static ConfiguredFeature<?, ?> ORE_SCORIA_STONE = newConfiguredFeature("ore_scoria_stone", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, BYGBlockList.SCORIA_STONE.defaultBlockState(), 20)).range(63).squared().count(10));
    public static ConfiguredFeature<?, ?> ORE_SOAP_STONE = newConfiguredFeature("ore_soap_stone", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, BYGBlockList.SOAPSTONE.defaultBlockState(), 20)).range(63).squared().count(10));


    /***********************************************************Configured & Decorated Features***********************************************************/

    public static ConfiguredFeature<?, ?> FROST_MAGMA_LAKE = newConfiguredFeature("frost_magma_lake", BYGFeatureList.LAKE_FROST.configured(new BlockStateConfiguration(BYGBlockList.FROST_MAGMA.defaultBlockState())).decorated(FeatureDecorator.WATER_LAKE.configured(new ChanceDecoratorConfiguration(4))));
    public static ConfiguredFeature<?, ?> WARPED_CORAL_PLANT = newConfiguredFeature("warped_coral_plant", BYGFeatureList.HUGE_WARPED_CORAL_PLANT.configured(FeatureConfiguration.NONE).decorated(UnderGroundPlacement.UGPLACER.configured(new FrequencyWithExtraChanceDecoratorConfiguration(2, 0.2F, 1))));
    public static ConfiguredFeature<?, ?> SYTHIAN_STALK = newConfiguredFeature("sythian_stalk", BYGFeatureList.SYTHIAN_STALK.configured(new ProbabilityFeatureConfiguration(0.9F)).decorated(UnderGroundPlacement.UGPLACER.configured(new FrequencyWithExtraChanceDecoratorConfiguration(10, 0.5F, 8))));
    public static ConfiguredFeature<?, ?> EMBUR_LILY = newConfiguredFeature("embur_lily", BYGFeatureList.EMBUR_LILY.configured(NoneFeatureConfiguration.NONE).decorated(UnderGroundPlacement.UGPLACER.configured(new FrequencyWithExtraChanceDecoratorConfiguration(2, 0.5F, 2))));
    public static ConfiguredFeature<?, ?> CRAG_LAKE = newConfiguredFeature("crag_lake", BYGFeatureList.LAKE_WIDE_SHALLOW.configured(FeatureConfiguration.NONE).decorated(AnyWaterOrSolidSurfaceSurface.WATER_OR_SOLID_SURFACE.configured(new CountConfiguration(4))));
    public static ConfiguredFeature<?, ?> EMBUR_LAKE = newConfiguredFeature("embur_lake", BYGFeatureList.EMBURLAKE.configured(NoneFeatureConfiguration.NONE).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(32, 0, 4)).squared()).count(15));
    public static ConfiguredFeature<?, ?> OBBY_SPIKE = newConfiguredFeature("obsidian_spire", BYGFeatureList.OBBYSPIKES.configured(FeatureConfiguration.NONE).decorated(ObsidianSpikePlacer.OBBY_SPIKE.configured(new FrequencyWithExtraChanceDecoratorConfiguration(2000, 0, 0))));

    /***********************************************************Random Selectors***********************************************************/

    public static final ConfiguredFeature<?, ?> RANDOM_ALLIUM_FLOWER = newConfiguredFeature("rs_allium_flower", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            ALLIUM_TALL_BUSH.weighted(0.25F),
            ALLIUM_TALL_PINK_BUSH.weighted(0.25F),
            ALLIUM_BUSH.weighted(0.25F)),
            ALLIUM_PINK_BUSH)).decorated(Features.Decorators.FIRE).count(60));

    public static final ConfiguredFeature<?, ?> RANDOM_AMARANTH_FLOWER = newConfiguredFeature("rs_amaranth_flower", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            AMARANTH.weighted(0.2F),
            AMARANTH_CYAN.weighted(0.2F),
            AMARANTH_MAGENTA.weighted(0.2F),
            AMARANTH_ORANGE.weighted(0.2F)),
            AMARANTH_PURPLE)).decorated(Features.Decorators.FIRE).count(60));

    public static final ConfiguredFeature<?, ?> RANDOM_CALIFORNIA_POPPY = newConfiguredFeature("rs_california_poppy", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            CALIFORNIA_POPPY.weighted(0.50F)),
            CALIFORNIA_POPPY)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WINTER_SUCCULENT = newConfiguredFeature("rs_winter_succulent", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            WINTER_SUCCULENT.weighted(0.50F)),
            WINTER_SUCCULENT)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_HORSEWEED = newConfiguredFeature("rs_horseweed", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            HORSE_WEED.weighted(0.50F)),
            HORSE_WEED)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_DESERT_PLANTS = newConfiguredFeature("rs_desert_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            MINI_CACTI.weighted(0.3F),
            PRICKLY_PEAR_CACTI.weighted(0.3F),
            GOLDEN_SPINED_CACTI.weighted(0.3F)),
            FIRECRACKER_BUSH)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(6));

//    public static final ConfiguredFeature<?, ?> RANDOM_PUMPKINS = newConfiguredFeature("rs_pumpkins", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
//            MINI_CACTI.withChance(0.3F),
//            PRICKLY_PEAR_CACTI.withChance(0.3F),
//            GOLDEN_SPINED_CACTI.withChance(0.3F)),
//            FIRECRACKER_BUSH)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(6));

    public static final ConfiguredFeature<?, ?> RANDOM_FIRECRACKER = newConfiguredFeature("rs_firecracker", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            FIRECRACKER_BUSH.weighted(0.50F)),
            FIRECRACKER_BUSH)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_PRAIRIE_GRASS = newConfiguredFeature("rs_prairie", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            PRAIRIE_GRASS.weighted(0.92F)),
            PRAIRIE_TALL_GRASS)).decorated(Features.Decorators.HEIGHTMAP).count(60));

    public static final ConfiguredFeature<?, ?> RANDOM_PUMPKIN = newConfiguredFeature("rs_pumpkin", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            PUMPKIN_CONFIG.weighted(0.50F)),
            PUMPKIN_CONFIG)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(8));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUEBERRIES = newConfiguredFeature("rs_blueberries", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            BLUE_BERRY_BUSH.weighted(0.50F)),
            BLUE_BERRY_BUSH)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(1));

    public static final ConfiguredFeature<?, ?> RANDOM_LUSH_BLUEBERRIES = newConfiguredFeature("rs_lush_blueberries", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            BLUE_BERRY_BUSH.weighted(0.50F)),
            BLUE_BERRY_BUSH)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).chance(12));

    public static final ConfiguredFeature<?, ?> RANDOM_BEACH_GRASS = newConfiguredFeature("rs_beach_grass", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            BEACH_GRASS.weighted(0.50F)),
            BEACH_SHORT_GRASS)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWCANE = newConfiguredFeature("rs_glowcane", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            GLOWCANE_BLUE.weighted(0.25F),
            GLOWCANE_PINK.weighted(0.25F),
            GLOWCANE_PURPLE.weighted(0.25F)),
            GLOWCANE_RED)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(16));

    public static final ConfiguredFeature<?, ?> RANDOM_BYG_GRASS = newConfiguredFeature("rs_byg_grass", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            SHORT_GRASS.weighted(0.50F)),
            Features.PATCH_GRASS_NORMAL)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(10));

    public static final ConfiguredFeature<?, ?> RANDOM_SHORT_GRASS = newConfiguredFeature("rs_short_grass", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            SHORT_GRASS.weighted(0.50F)),
            SHORT_GRASS)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(10));

    public static final ConfiguredFeature<?, ?> RANDOM_BYG_FERN_GRASS = newConfiguredFeature("rs_byg_fern_grass", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            SHORT_GRASS.weighted(0.50F)),
            Features.PATCH_TAIGA_GRASS)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(10));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSHROOM = newConfiguredFeature("rs_glowshroom", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            BLUE_GLOWSHROOM.weighted(0.50F)),
            PURPLE_GLOWSHROOM)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(5));

    public static final ConfiguredFeature<?, ?> RANDOM_MUSHROOM = newConfiguredFeature("rs_mushroom", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            BLACK_PUFF.weighted(0.50F),
            WOOD_BLEWIT.weighted(0.50F),
            WEEPING_MILKCAP.weighted(0.50F)),
            GREEN_MUSHROOM)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(4));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSTONE_GARDEN_VEGETATION = newConfiguredFeature("rs_gg_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            BLACK_PUFF.weighted(0.1F),
            GREEN_MUSHROOM.weighted(0.1F),
            BLACK_PUFF.weighted(0.1F),
            WOOD_BLEWIT.weighted(0.1F),
            WEEPING_MILKCAP.weighted(0.1F)),
            NETHER_BRISTLE)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(15)).count(1)));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_BOG_PLANT = newConfiguredFeature("rs_embur_bog_plant", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            EMBUR_ROOTS.weighted(0.35F),
            EMBUR_ROOTS_TALL.weighted(0.35F),
            EMBUR_GEL_VINES.weighted(0.25F)),
            EMBUR_WART)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(15))));

    public static final ConfiguredFeature<?, ?> RANDOM_SYTHIAN_PLANT = newConfiguredFeature("rs_sythian_plant", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            SYTHIAN_ROOTS.weighted(0.5F)),
            SYTHIAN_SPROUT)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(20))));

    public static final ConfiguredFeature<?, ?> RANDOM_WEEPING_ROOTS = newConfiguredFeature("rs_weeping_roots", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            WEEPING_ROOTS.weighted(0.3F)),
            WEEPING_ROOTS_PLANT)).range(128).squared().count(80));

    public static final ConfiguredFeature<?, ?> RANDOM_JUNGLE_FLOWERS = newConfiguredFeature("rs_jungle_flowers", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            BISTORT.weighted(0.50F),
            GUZMANIA.weighted(0.50F),
            BEGONIA.weighted(0.50F),
            LAZARUS_BELLFLOWER.weighted(0.50F),
            RICHEA.weighted(0.50F),
            TORCH_GINGER.weighted(0.50F)),
            INCAN_LILY)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(5));

    public static final ConfiguredFeature<?, ?> RANDOM_SWAMP_PLANTS = newConfiguredFeature("rs_swamp_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            TINY_LILY_PAD.weighted(0.50F)),
            WATER_SILK)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(5));

    public static final ConfiguredFeature<?, ?> RANDOM_LILY_PADS = newConfiguredFeature("rs_lily_pads", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            TINY_LILY_PAD.weighted(0.50F)),
            Features.PATCH_WATERLILLY)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(5));

    public static final ConfiguredFeature<?, ?> RANDOM_AZALEA = newConfiguredFeature("rs_azalea", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            AZALEA.weighted(0.5F)),
            AZALEA)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_JAPANESE_ORCHID = newConfiguredFeature("rs_japanese_orchid", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            JAPANESE_ORCHID.weighted(0.5F)),
            JAPANESE_ORCHID)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(3));

    public static final ConfiguredFeature<?, ?> RANDOM_DELPHINIUM = newConfiguredFeature("rs_delphinium", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            DELPHINIUM.weighted(0.25F)),
            DELPHINIUM)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WILTED_GRASS = newConfiguredFeature("rs_wilted_grass", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            WILTED_GRASS.weighted(0.25F)),
            WILTED_GRASS)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(1));

    public static final ConfiguredFeature<?, ?> RANDOM_WEED_GRASS = newConfiguredFeature("rs_weed_grass", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            WEED_GRASS.weighted(0.25F)),
            WEED_GRASS)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(1));

    public static final ConfiguredFeature<?, ?> RANDOM_WINTER_GRASS = newConfiguredFeature("rs_winter_grass", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            WINTER_GRASS.weighted(0.25F)),
            WINTER_GRASS)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_LEAF_PILE = newConfiguredFeature("rs_leaf_pile", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            LEAF_PILE.weighted(0.25F)),
            LEAF_PILE)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CLOVER_FLOWER_PATCH = newConfiguredFeature("rs_clover_flower_patch", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            CLOVER_PATCH.weighted(0.5F)),
            FLOWER_PATCH)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CHERRY_FOLIAGE = newConfiguredFeature("rs_cherry_foliage", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            WHITE_CHERRY_FOLIAGE.weighted(0.5F)),
            PINK_CHERRY_FOLIAGE)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(20));

    public static final ConfiguredFeature<?, ?> RANDOM_WARPED_DESERT_VEGETATION = newConfiguredFeature("rs_warped_desert_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            WARPED_BUSH.weighted(0.25F),
            WARPED_CORAL.weighted(0.25F),
            WARPED_CORAL_FAN.weighted(0.25F)),
            WARPED_CACTI)).decorated(FeatureDecorator.COUNT_MULTILAYER.configured(new CountConfiguration(16))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUEBERRY_BUSH = newConfiguredFeature("rs_blueberry_bush", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            BLUE_BERRY_BUSH.weighted(0.5F)),
            BLUE_BERRY_BUSH)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ROSE = newConfiguredFeature("rs_rose", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            ROSE.weighted(0.5F)),
            ROSE)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ANGELICA = newConfiguredFeature("rs_angelica", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            ANGELICA.weighted(0.5F)),
            ANGELICA)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CROCUS = newConfiguredFeature("rs_crocus", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            CROCUS.weighted(0.5F)),
            CROCUS)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_IRIS = newConfiguredFeature("rs_iris", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            IRIS.weighted(0.5F)),
            IRIS)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ANEMONE = newConfiguredFeature("rs_anemone", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            ANEMONE_PINK.weighted(0.5F)),
            ANEMONE_WHITE)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_WINTER_ROSE = newConfiguredFeature("rs_winter_rose", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            ROSE_WINTER.weighted(0.5F)),
            ROSE_WINTER)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_SNOWDROPS = newConfiguredFeature("rs_snowdrops", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            SNOWDROPS.weighted(0.5F)),
            SNOWDROPS)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_PINK_ALLIUM = newConfiguredFeature("rs_pink_allium", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            ALLIUM_PINK.weighted(0.5F)),
            ALLIUM_PINK)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ORANGE_DAISY = newConfiguredFeature("rs_orange_daisy", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            DAISY_ORANGE.weighted(0.5F)),
            DAISY_ORANGE)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_RED_CORNFLOWER = newConfiguredFeature("rs_red_cornflower", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            CORNFLOWER_RED.weighted(0.5F)),
            CORNFLOWER_RED)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_SAGE = newConfiguredFeature("rs_sage", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            SAGE_PURPLE.weighted(0.5F)),
            SAGE_WHITE)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_FOXGLOVE = newConfiguredFeature("rs_foxglove", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            FOXGLOVE.weighted(0.5F)),
            FOXGLOVE)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_YELLOW_DAFFODIL = newConfiguredFeature("rs_yellow_daffodil", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            DAFFODIL_YELLOW.weighted(0.5F)),
            DAFFODIL_YELLOW)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_BELLFLOWER = newConfiguredFeature("rs_bellflower", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            ALPINE_BELLFLOWER.weighted(0.5F)),
            ALPINE_BELLFLOWER)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_SCILLA = newConfiguredFeature("rs_scilla", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            WINTER_SCILLA.weighted(0.5F)),
            WINTER_SCILLA)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_KOVAN = newConfiguredFeature("rs_kovan", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            KOVAN_FLOWER.weighted(0.5F)),
            KOVAN_FLOWER)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_TULIP = newConfiguredFeature("rs_tulip", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            TULIP_MAGENTA.weighted(0.5F),
            TULIP_YELLOW.weighted(0.5F),
            TULIP_PURPLE.weighted(0.5F),
            TULIP_CYAN.weighted(0.5F)),
            TULIP_GREEN)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(10));

    public static final ConfiguredFeature<?, ?> RANDOM_REEDS = newConfiguredFeature("rs_reeds", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            REEDS.weighted(0.5F)),
            REEDS)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(12));

    public static final ConfiguredFeature<?, ?> RANDOM_CATTAILS = newConfiguredFeature("rs_cattails", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            CATTAIL.weighted(0.5F)),
            CATTAIL)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(12));

    public static final ConfiguredFeature<?, ?> RANDOM_LOLIPOP = newConfiguredFeature("rs_lolipop", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            LOLI_POP.weighted(0.5F)),
            LOLI_POP)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_ORCHID = newConfiguredFeature("rs_orchid", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            ORCHID_PINK.weighted(0.5F),
            ORCHID_PURPLE.weighted(0.5F)),
            ORCHID_RED)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_LEATHER_FLOWER = newConfiguredFeature("rs_leather_flower", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            LEATHER_FLOWER_PEACH.weighted(0.5F)),
            LEATHER_FLOWER_VIOLET)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_DAFFODILS = newConfiguredFeature("rs_daffodils", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            DAFFODIL.weighted(0.5F)),
            DAFFODIL_PINK)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_ROSE = newConfiguredFeature("rs_black_rose", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            ROSE_BLACK.weighted(0.5F)),
            ROSE_BLACK)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CYAN_ROSE = newConfiguredFeature("rs_cyan_rose", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            ROSE_CYAN.weighted(0.5F)),
            ROSE_CYAN)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_OSIRIA_ROSE = newConfiguredFeature("rs_osiria_rose", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            ROSE_OSIRIA.weighted(0.5F)),
            ROSE_OSIRIA)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_FAIRYSLIPPER = newConfiguredFeature("rs_fairslipper", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            FAIRY_SLIPPER.weighted(0.5F)),
            FAIRY_SLIPPER)).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(2));

    public static final ConfiguredFeature<?, ?> RANDOM_IVIS_PLANTS = newConfiguredFeature("rs_ivis_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            IVIS_ROOTS.weighted(0.5F)),
            IVIS_SPROUT)).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(20));

    public static final ConfiguredFeature<?, ?> RANDOM_DEAD_SEA_SPIKE = newConfiguredFeature("rs_dead_sea_spike", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            DEAD_SEA_SPIKE.weighted(0.9F)),
            DEAD_SEA_SPIKE_TALL)).decorated(AtOceanFloorWithExtra.OCEANFLOOR.configured(new FrequencyWithExtraChanceDecoratorConfiguration(28, 0.1F, 1))));


    public static ConfiguredFeature<?, ?> newConfiguredFeature(String registryName, ConfiguredFeature<?, ?> configuredFeature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(BYG.MODID, registryName), configuredFeature);
        return configuredFeature;
    }
}
