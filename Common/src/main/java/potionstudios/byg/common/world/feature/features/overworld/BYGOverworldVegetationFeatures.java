package potionstudios.byg.common.world.feature.features.overworld;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BlueBerryBush;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.config.PumpkinConfig;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;
import static potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil.createPlacedFeature;

public class BYGOverworldVegetationFeatures {
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ALLIUM_BUSH = createFlowerConfiguredFeature("allium_bush", BYGBlocks.ALLIUM_FLOWER_BUSH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ALLIUM_PINK_BUSH = createFlowerConfiguredFeature("pink_allium_bush", BYGBlocks.PINK_ALLIUM_FLOWER_BUSH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ALLIUM_TALL_BUSH = createPatchConfiguredFeature("tall_allium_bush", BYGBlocks.TALL_ALLIUM, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ALLIUM_TALL_PINK_BUSH = createPatchConfiguredFeature("tall_pink_allium_bush", BYGBlocks.TALL_PINK_ALLIUM, 15);
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> DUNE_TERRAIN = createConfiguredFeature("dune_terrain", BYGFeatures.DUNE_TERRAIN, FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> AMARANTH = createFlowerConfiguredFeature("amaranth", BYGBlocks.AMARANTH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> AMARANTH_MAGENTA = createFlowerConfiguredFeature("magenta_amaranth", BYGBlocks.MAGENTA_AMARANTH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> AMARANTH_ORANGE = createFlowerConfiguredFeature("orange_amaranth", BYGBlocks.ORANGE_AMARANTH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> AMARANTH_PURPLE = createFlowerConfiguredFeature("purple_amaranth", BYGBlocks.PURPLE_AMARANTH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> AMARANTH_CYAN = createFlowerConfiguredFeature("cyan_amaranth", BYGBlocks.CYAN_AMARANTH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FIRECRACKER_BUSH = createFlowerConfiguredFeature("firecracker_bush", BYGBlocks.FIRECRACKER_FLOWER_BUSH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SHRUB = createFlowerConfiguredFeature("shrub", BYGBlocks.SHRUB);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> MINI_CACTI = createPatchConfiguredFeature("mini_cacti", BYGBlocks.MINI_CACTUS, 4);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CLOVER_PATCH = createFlowerConfiguredFeature("clover_patch", BYGBlocks.CLOVER_PATCH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWER_PATCH = createFlowerConfiguredFeature("flower_patch", BYGBlocks.FLOWER_PATCH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CALIFORNIA_POPPY = createFlowerConfiguredFeature("california_poppy", BYGBlocks.CALIFORNIA_POPPY);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WHITE_PUFFBALL = createFlowerConfiguredFeature("white_puffball", BYGBlocks.WHITE_PUFFBALL);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WEEPING_MILKCAP = createFlowerConfiguredFeature("weeping_milkcap", BYGBlocks.WEEPING_MILKCAP);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WOOD_BLEWIT = createFlowerConfiguredFeature("wood_blewit", BYGBlocks.WOOD_BLEWIT);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> GREEN_MUSHROOM = createFlowerConfiguredFeature("green_mushroom", BYGBlocks.GREEN_MUSHROOM);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BEGONIA = createFlowerConfiguredFeature("begonia", BYGBlocks.BEGONIA);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BISTORT = createFlowerConfiguredFeature("bistort", BYGBlocks.BISTORT);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> GUZMANIA = createFlowerConfiguredFeature("guzmania", BYGBlocks.GUZMANIA);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> INCAN_LILY = createFlowerConfiguredFeature("incan_lily", BYGBlocks.INCAN_LILY);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> LAZARUS_BELLFLOWER = createFlowerConfiguredFeature("lazarus_bellflower", BYGBlocks.LAZARUS_BELLFLOWER);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TORCH_GINGER = createFlowerConfiguredFeature("torch_ginger", BYGBlocks.TORCH_GINGER);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WINTER_SUCCULENT = createPatchConfiguredFeature("winter_succulent", BYGBlocks.WINTER_SUCCULENT, 10);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BEACH_GRASS = createPatchConfiguredFeature("beach_grass_patch", BYGBlocks.BEACH_GRASS, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> LEAF_PILE = createPatchConfiguredFeature("leaf_pile", BYGBlocks.LEAF_PILE, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> RICHEA = createFlowerConfiguredFeature("richea", BYGBlocks.RICHEA);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PRAIRIE_GRASS_PATCH = createPatchConfiguredFeature("prairie_grass_patch", BYGBlocks.PRAIRIE_GRASS, 100);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TALL_PRAIRIE_GRASS_PATCH = createPatchConfiguredFeature("tall_prairie_grass_patch", BYGBlocks.TALL_PRAIRIE_GRASS, 100);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ROSE_BUSH = createPatchConfiguredFeature("rose_bush", Blocks.ROSE_BUSH, 64);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> JAPANESE_ORCHID = createFlowerConfiguredFeature("japanese_orchid", BYGBlocks.JAPANESE_ORCHID);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FOXGLOVE = createFlowerConfiguredFeature("foxglove", BYGBlocks.FOXGLOVE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWERING_INDIGO_JACARANDA_BUSH = createPatchConfiguredFeature("flowering_indigo_jacaranda_bush", BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> INDIGO_JACARANDA_BUSH = createPatchConfiguredFeature("indigo_jacaranda_bush", BYGBlocks.INDIGO_JACARANDA_BUSH, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWERING_JACARANDA_BUSH = createPatchConfiguredFeature("flowering_jacaranda_bush", BYGBlocks.FLOWERING_JACARANDA_BUSH, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> JACARANDA_BUSH = createPatchConfiguredFeature("jacaranda_bush", BYGBlocks.JACARANDA_BUSH, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PRICKLY_PEAR_CACTI = createPatchConfiguredFeature("prickly_pear_cacti", BYGBlocks.PRICKLY_PEAR_CACTUS, 5);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> GOLDEN_SPINED_CACTI = createPatchConfiguredFeature("golden_spined_cacti", BYGBlocks.GOLDEN_SPINED_CACTUS, 5);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PINK_CHERRY_FOLIAGE = createPatchConfiguredFeature("pink_cherry_foliage", BYGBlocks.PINK_CHERRY_FOLIAGE, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WHITE_CHERRY_FOLIAGE = createPatchConfiguredFeature("white_cherry_foliage", BYGBlocks.WHITE_CHERRY_FOLIAGE, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BLUE_BERRY_BUSH = createPatchConfiguredFeature("blue_berry_bush", BYGBlocks.BLUEBERRY_BUSH.defaultBlockState().setValue(BlueBerryBush.AGE, 3), 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ROSE = createFlowerConfiguredFeature("rose", BYGBlocks.ROSE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CROCUS = createFlowerConfiguredFeature("crocus", BYGBlocks.CROCUS);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> IRIS = createFlowerConfiguredFeature("iris", BYGBlocks.IRIS);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ANEMONE_WHITE = createFlowerConfiguredFeature("white_anemone", BYGBlocks.WHITE_ANEMONE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ANEMONE_PINK = createFlowerConfiguredFeature("pink_anemone", BYGBlocks.PINK_ANEMONE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ROSE_WINTER = createFlowerConfiguredFeature("winter_rose", BYGBlocks.WINTER_ROSE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ALLIUM_PINK = createFlowerConfiguredFeature("allium_pink", BYGBlocks.PINK_ALLIUM);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DAISY_ORANGE = createFlowerConfiguredFeature("orange_daisy", BYGBlocks.ORANGE_DAISY);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> HYDRANGEA_BUSH = createFlowerConfiguredFeature("hydrangea_bush", BYGBlocks.HYDRANGEA_BUSH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> HYDRANGEA_HEDGE = createFlowerConfiguredFeature("hydrangea_hedge", BYGBlocks.HYDRANGEA_HEDGE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SAGE_WHITE = createFlowerConfiguredFeature("white_sage", BYGBlocks.WHITE_SAGE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SAGE_PURPLE = createFlowerConfiguredFeature("purple_sage", BYGBlocks.PURPLE_SAGE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DAFFODIL_YELLOW = createFlowerConfiguredFeature("yellow_daffodil", BYGBlocks.YELLOW_DAFFODIL);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ALPINE_BELLFLOWER = createFlowerConfiguredFeature("alpine_bellflower", BYGBlocks.ALPINE_BELLFLOWER);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> KOVAN_FLOWER = createFlowerConfiguredFeature("kovan_flower", BYGBlocks.KOVAN_FLOWER);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TULIP_GREEN = createFlowerConfiguredFeature("green_tulip", BYGBlocks.GREEN_TULIP);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TULIP_CYAN = createFlowerConfiguredFeature("cyan_tulip", BYGBlocks.CYAN_TULIP);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TULIP_MAGENTA = createFlowerConfiguredFeature("magenta_tulip", BYGBlocks.MAGENTA_TULIP);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TULIP_PURPLE = createFlowerConfiguredFeature("purple_tulip", BYGBlocks.PURPLE_TULIP);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TULIP_YELLOW = createFlowerConfiguredFeature("yellow_tulip", BYGBlocks.YELLOW_TULIP);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CATTAIL = createPatchConfiguredFeature("cattail", BYGBlocks.CATTAIL, 32);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> LOLLIPOP_FLOWER = createFlowerConfiguredFeature("lollipop_flower", BYGBlocks.LOLLIPOP_FLOWER);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> LEATHER_FLOWER_PEACH = createFlowerConfiguredFeature("peach_leather_flower", BYGBlocks.PEACH_LEATHER_FLOWER);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> LEATHER_FLOWER_VIOLET = createFlowerConfiguredFeature("violet_leather_flower", BYGBlocks.VIOLET_LEATHER_FLOWER);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BLACK_ROSE = createFlowerConfiguredFeature("black_rose", BYGBlocks.BLACK_ROSE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CYAN_ROSE = createFlowerConfiguredFeature("cyan_rose", BYGBlocks.CYAN_ROSE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ROSE_OSIRIA = createFlowerConfiguredFeature("osiria_rose", BYGBlocks.ORSIRIA_ROSE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FAIRY_SLIPPER = createFlowerConfiguredFeature("fairy_slipper", BYGBlocks.FAIRY_SLIPPER);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> HORSEWEED = createPatchConfiguredFeature("horseweed", BYGBlocks.HORSEWEED, 10);


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> AMARANTH_FIELD_FLOWERS = createConfiguredFeature("amaranth_field_flowers",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(AMARANTH), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(AMARANTH_MAGENTA), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(AMARANTH_ORANGE), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(AMARANTH_PURPLE), 0.2F)),
            createPlacedFeature(AMARANTH_CYAN))
    );

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TINY_LILY_PAD = createConfiguredFeature("tiny_lily_pad",
        Feature.RANDOM_PATCH,
        new RandomPatchConfiguration(10, 7, 3,
            createPlacedFeature(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.TINY_LILYPADS))))
        ));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WATER_SILK = createConfiguredFeature("water_silk",
        Feature.RANDOM_PATCH,
        new RandomPatchConfiguration(10, 7, 3,
            createPlacedFeature(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WATER_SILK)))
            )));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ALLIUM_FIELD_FLOWERS = createConfiguredFeature("allium_field_flowers",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ALLIUM_TALL_BUSH), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(ALLIUM_TALL_PINK_BUSH), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(ALLIUM_BUSH), 0.25F)),
            createPlacedFeature(ALLIUM_PINK_BUSH))
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ROSE_FIELD_FLOWERS = createConfiguredFeature("rose_field_flowers",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ROSE_OSIRIA), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(ROSE), 0.25F)),
            createPlacedFeature(ROSE_BUSH))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> DESERT_VEGETATION = createConfiguredFeature("desert_vegetation",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(MINI_CACTI), 0.3F),
            new WeightedPlacedFeature(createPlacedFeature(PRICKLY_PEAR_CACTI), 0.3F),
            new WeightedPlacedFeature(createPlacedFeature(FIRECRACKER_BUSH), 0.1F)),
            createPlacedFeature(GOLDEN_SPINED_CACTI))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PRAIRIE_GRASS = createConfiguredFeature("prairie_grass",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(PRAIRIE_GRASS_PATCH), 0.75F)),
            createPlacedFeature(TALL_PRAIRIE_GRASS_PATCH))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MUSHROOMS = createConfiguredFeature("mushrooms",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(WOOD_BLEWIT), 0.33F),
            new WeightedPlacedFeature(createPlacedFeature(WEEPING_MILKCAP), 0.33F)),
            createPlacedFeature(GREEN_MUSHROOM))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> JUNGLE_FLOWERS = createConfiguredFeature("jungle_flowers",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(BISTORT), 0.142F),
            new WeightedPlacedFeature(createPlacedFeature(GUZMANIA), 0.142F),
            new WeightedPlacedFeature(createPlacedFeature(BEGONIA), 0.142F),
            new WeightedPlacedFeature(createPlacedFeature(LAZARUS_BELLFLOWER), 0.142F),
            new WeightedPlacedFeature(createPlacedFeature(RICHEA), 0.142F),
            new WeightedPlacedFeature(createPlacedFeature(TORCH_GINGER), 0.142F)),
            createPlacedFeature(INCAN_LILY))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> JACARANDA_BUSHES = createConfiguredFeature("jacaranda_bushes",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(FLOWERING_INDIGO_JACARANDA_BUSH), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(FLOWERING_JACARANDA_BUSH), 0.25F),
            new WeightedPlacedFeature(createPlacedFeature(INDIGO_JACARANDA_BUSH), 0.25F)),
            createPlacedFeature(JACARANDA_BUSH))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SWAMP_WATER_VEGETATION = createConfiguredFeature("swamp_water_vegetation",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(TINY_LILY_PAD), 0.50F)),
            createPlacedFeature(WATER_SILK))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CHERRY_FOLIAGE = createConfiguredFeature("cherry_foliage",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(WHITE_CHERRY_FOLIAGE), 0.5F)),
            createPlacedFeature(PINK_CHERRY_FOLIAGE))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ANEMONES = createConfiguredFeature("anemones",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(ANEMONE_PINK), 0.5F)),
            createPlacedFeature(ANEMONE_WHITE))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SAGES = createConfiguredFeature("sages",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(SAGE_PURPLE), 0.5F)),
            createPlacedFeature(SAGE_WHITE))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> HYDRANGEAS = createConfiguredFeature("hydrangeas",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(HYDRANGEA_BUSH), 0.5F)),
            createPlacedFeature(HYDRANGEA_HEDGE))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TULIPS = createConfiguredFeature("tulips",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(TULIP_MAGENTA), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(TULIP_YELLOW), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(TULIP_PURPLE), 0.2F),
            new WeightedPlacedFeature(createPlacedFeature(TULIP_CYAN), 0.2F)),
            createPlacedFeature(TULIP_GREEN))
    );


    public static final Holder<ConfiguredFeature<PumpkinConfig, ?>> PUMPKIN1 = createConfiguredFeature("pumpkin1",
        BYGFeatures.LARGE_PUMPKIN1,
        new PumpkinConfig.Builder()
            .setPumpkinBlock(Blocks.PUMPKIN)
            .build()
    );
    public static final Holder<ConfiguredFeature<PumpkinConfig, ?>> PUMPKIN2 = createConfiguredFeature("pumpkin2",
        BYGFeatures.LARGE_PUMPKIN2,
        new PumpkinConfig.Builder()
            .setPumpkinBlock(Blocks.PUMPKIN).setStemBlock(Blocks.DARK_OAK_LOG)
            .setLeavesBlock(Blocks.DARK_OAK_LEAVES)
            .build()
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> LARGE_PUMPKINS = createConfiguredFeature("large_pumpkin",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(PUMPKIN1), 0.5F)),
            createPlacedFeature(PUMPKIN2))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> LEATHER_FLOWERS = createConfiguredFeature("leather_flowers",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(LEATHER_FLOWER_PEACH), 0.5F)),
            createPlacedFeature(LEATHER_FLOWER_VIOLET))
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> GREEN_MUSHROOM_HUGE = createConfiguredFeature("huge_green_mushroom",
        BYGFeatures.GREEN_MUSHROOM_HUGE,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM)
            .setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> WOOD_BLEWIT_HUGE = createConfiguredFeature("huge_wood_blewit",
        BYGFeatures.WOOD_BLEWIT_HUGE,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM)
            .setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> WEEPING_MILKCAP_HUGE = createConfiguredFeature("huge_weeping_milkcap",
        BYGFeatures.WEEPING_MILKCAP_HUGE,
        new BYGMushroomConfig.Builder()
            .setStemBlock(Blocks.MUSHROOM_STEM)
            .setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK)
            .setMinHeight(6)
            .setMaxHeight(12)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> GREEN_MUSHROOM_MINI = createConfiguredFeature("mini_green_mushroom",
        BYGFeatures.MINI_GREEN_MUSHROOM,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM)
            .setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK)
            .setMinHeight(3)
            .setMaxHeight(3)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> WOOD_BLEWIT_MINI = createConfiguredFeature("mini_wood_blewit",
        BYGFeatures.MINI_WOOD_BLEWIT,
        new BYGMushroomConfig.Builder()
            .setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM)
            .setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK)
            .setMinHeight(2)
            .setMaxHeight(3)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> WEEPING_MILKCAP_MINI = createConfiguredFeature("mini_weeping_milkcap",
        BYGFeatures.MINI_WEEPING_MILKCAP,
        new BYGMushroomConfig.Builder()
            .setStemBlock(Blocks.MUSHROOM_STEM)
            .setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK)
            .setMinHeight(2)
            .setMaxHeight(3)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> RED_MUSHROOM_MINI = createConfiguredFeature("mini_red_mushroom",
        BYGFeatures.MINI_RED_MUSHROOM,
        new BYGMushroomConfig.Builder()
            .setStemBlock(Blocks.MUSHROOM_STEM)
            .setMushroomBlock(Blocks.RED_MUSHROOM_BLOCK)
            .setMinHeight(2)
            .setMaxHeight(3)
            .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> BROWN_MUSHROOM_MINI = createConfiguredFeature("mini_brown_mushroom",
        BYGFeatures.MINI_BROWN_MUSHROOM,
        new BYGMushroomConfig.Builder()
            .setStemBlock(Blocks.MUSHROOM_STEM)
            .setMushroomBlock(Blocks.BROWN_MUSHROOM_BLOCK)
            .setMinHeight(2)
            .setMaxHeight(3)
            .build()
    );


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> HUGE_MUSHROOMS = createConfiguredFeature("huge_mushrooms",
        Feature.RANDOM_SELECTOR,
        new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(createPlacedFeature(GREEN_MUSHROOM_HUGE), 0.35F),
            new WeightedPlacedFeature(createPlacedFeature(WOOD_BLEWIT_HUGE), 0.35F),
            new WeightedPlacedFeature(createPlacedFeature(WEEPING_MILKCAP_HUGE), 0.35F)),
            createPlacedFeature(GREEN_MUSHROOM_HUGE))
    );

}
