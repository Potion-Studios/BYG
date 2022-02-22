package potionstudios.byg.common.world.feature.features.overworld;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BlueBerryBush;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.config.PumpkinConfig;
import potionstudios.byg.common.world.feature.config.QuartzSpikeConfig;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;

public class BYGOverworldVegetationFeatures {
    public static final ConfiguredFeature<?, ?> ALLIUM_BUSH = createFlowerConfiguredFeature("allium_bush", BYGBlocks.ALLIUM_FLOWER_BUSH);
    public static final ConfiguredFeature<?, ?> ALLIUM_PINK_BUSH = createFlowerConfiguredFeature("pink_allium_bush", BYGBlocks.PINK_ALLIUM_FLOWER_BUSH);
    public static final ConfiguredFeature<?, ?> ALLIUM_TALL_BUSH = createPatchConfiguredFeature("tall_allium_bush", BYGBlocks.TALL_ALLIUM, 15);
    public static final ConfiguredFeature<?, ?> ALLIUM_TALL_PINK_BUSH = createPatchConfiguredFeature("tall_pink_allium_bush", BYGBlocks.TALL_PINK_ALLIUM, 15);
    public static final ConfiguredFeature<?, ?> DUNE_TERRAIN = createConfiguredFeature("dune_terrain", BYGFeatures.DUNE_TERRAIN.configured(FeatureConfiguration.NONE));
    public static final ConfiguredFeature<?, ?> AMARANTH = createFlowerConfiguredFeature("amaranth", BYGBlocks.AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_MAGENTA = createFlowerConfiguredFeature("magenta_amaranth", BYGBlocks.MAGENTA_AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_ORANGE = createFlowerConfiguredFeature("orange_amaranth", BYGBlocks.ORANGE_AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_PURPLE = createFlowerConfiguredFeature("purple_amaranth", BYGBlocks.PURPLE_AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_CYAN = createFlowerConfiguredFeature("cyan_amaranth", BYGBlocks.CYAN_AMARANTH);
    public static final ConfiguredFeature<?, ?> FIRECRACKER_BUSH = createFlowerConfiguredFeature("firecracker_bush", BYGBlocks.FIRECRACKER_FLOWER_BUSH);
    public static final ConfiguredFeature<?, ?> SHRUB = createFlowerConfiguredFeature("shrub", BYGBlocks.SHRUB);
    public static final ConfiguredFeature<?, ?> MINI_CACTI = createPatchConfiguredFeature("mini_cacti", BYGBlocks.MINI_CACTUS, 4);
    public static final ConfiguredFeature<?, ?> CLOVER_PATCH = createFlowerConfiguredFeature("clover_patch", BYGBlocks.CLOVER_PATCH);
    public static final ConfiguredFeature<?, ?> FLOWER_PATCH = createFlowerConfiguredFeature("flower_patch", BYGBlocks.FLOWER_PATCH);
    public static final ConfiguredFeature<?, ?> CALIFORNIA_POPPY = createFlowerConfiguredFeature("california_poppy", BYGBlocks.CALIFORNIA_POPPY);
    public static final ConfiguredFeature<?, ?> WHITE_PUFFBALL = createFlowerConfiguredFeature("white_puffball", BYGBlocks.WHITE_PUFFBALL);
    public static final ConfiguredFeature<?, ?> WEEPING_MILKCAP = createFlowerConfiguredFeature("weeping_milkcap", BYGBlocks.WEEPING_MILKCAP);
    public static final ConfiguredFeature<?, ?> WOOD_BLEWIT = createFlowerConfiguredFeature("wood_blewit", BYGBlocks.WOOD_BLEWIT);
    public static final ConfiguredFeature<?, ?> GREEN_MUSHROOM = createFlowerConfiguredFeature("green_mushroom", BYGBlocks.GREEN_MUSHROOM);
    public static final ConfiguredFeature<?, ?> BEGONIA = createFlowerConfiguredFeature("begonia", BYGBlocks.BEGONIA);
    public static final ConfiguredFeature<?, ?> BISTORT = createFlowerConfiguredFeature("bistort", BYGBlocks.BISTORT);
    public static final ConfiguredFeature<?, ?> GUZMANIA = createFlowerConfiguredFeature("guzmania", BYGBlocks.GUZMANIA);
    public static final ConfiguredFeature<?, ?> INCAN_LILY = createFlowerConfiguredFeature("incan_lily", BYGBlocks.INCAN_LILY);
    public static final ConfiguredFeature<?, ?> LAZARUS_BELLFLOWER = createFlowerConfiguredFeature("lazarus_bellflower", BYGBlocks.LAZARUS_BELLFLOWER);
    public static final ConfiguredFeature<?, ?> TORCH_GINGER = createFlowerConfiguredFeature("torch_ginger", BYGBlocks.TORCH_GINGER);
    public static final ConfiguredFeature<?, ?> WINTER_SUCCULENT = createPatchConfiguredFeature("winter_succulent", BYGBlocks.WINTER_SUCCULENT, 10);
    public static final ConfiguredFeature<?, ?> BEACH_GRASS = createPatchConfiguredFeature("beach_grass_patch", BYGBlocks.BEACH_GRASS, 32);
    public static final ConfiguredFeature<?, ?> LEAF_PILE = createPatchConfiguredFeature("leaf_pile", BYGBlocks.LEAF_PILE, 15);
    public static final ConfiguredFeature<?, ?> RICHEA = createFlowerConfiguredFeature("richea", BYGBlocks.RICHEA);
    public static final ConfiguredFeature<?, ?> PRAIRIE_GRASS_PATCH = createPatchConfiguredFeature("prairie_grass_patch", BYGBlocks.PRAIRIE_GRASS, 100);
    public static final ConfiguredFeature<?, ?> TALL_PRAIRIE_GRASS_PATCH = createPatchConfiguredFeature("tall_prairie_grass_patch", BYGBlocks.TALL_PRAIRIE_GRASS, 100);
    public static final ConfiguredFeature<?, ?> ROSE_BUSH = createPatchConfiguredFeature("rose_bush", Blocks.ROSE_BUSH, 64);
    public static final ConfiguredFeature<?, ?> JAPANESE_ORCHID = createFlowerConfiguredFeature("japanese_orchid", BYGBlocks.JAPANESE_ORCHID);
    public static final ConfiguredFeature<?, ?> FOXGLOVE = createFlowerConfiguredFeature("foxglove", BYGBlocks.FOXGLOVE);
    public static final ConfiguredFeature<?, ?> FLOWERING_INDIGO_JACARANDA_BUSH = createPatchConfiguredFeature("flowering_indigo_jacaranda_bush", BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH, 32);
    public static final ConfiguredFeature<?, ?> INDIGO_JACARANDA_BUSH = createPatchConfiguredFeature("indigo_jacaranda_bush", BYGBlocks.INDIGO_JACARANDA_BUSH, 32);
    public static final ConfiguredFeature<?, ?> FLOWERING_JACARANDA_BUSH = createPatchConfiguredFeature("flowering_jacaranda_bush", BYGBlocks.FLOWERING_JACARANDA_BUSH, 32);
    public static final ConfiguredFeature<?, ?> JACARANDA_BUSH = createPatchConfiguredFeature("jacaranda_bush", BYGBlocks.JACARANDA_BUSH, 32);
    public static final ConfiguredFeature<?, ?> PRICKLY_PEAR_CACTI = createPatchConfiguredFeature("prickly_pear_cacti", BYGBlocks.PRICKLY_PEAR_CACTUS, 5);
    public static final ConfiguredFeature<?, ?> GOLDEN_SPINED_CACTI = createPatchConfiguredFeature("golden_spined_cacti", BYGBlocks.GOLDEN_SPINED_CACTUS, 5);
    public static final ConfiguredFeature<?, ?> PINK_CHERRY_FOLIAGE = createPatchConfiguredFeature("pink_cherry_foliage", BYGBlocks.PINK_CHERRY_FOLIAGE, 15);
    public static final ConfiguredFeature<?, ?> WHITE_CHERRY_FOLIAGE = createPatchConfiguredFeature("white_cherry_foliage", BYGBlocks.WHITE_CHERRY_FOLIAGE, 15);
    public static final ConfiguredFeature<?, ?> BLUE_BERRY_BUSH = createPatchConfiguredFeature("blue_berry_bush", BYGBlocks.BLUEBERRY_BUSH.defaultBlockState().setValue(BlueBerryBush.AGE, 3), 15);
    public static final ConfiguredFeature<?, ?> ROSE = createFlowerConfiguredFeature("rose", BYGBlocks.ROSE);
    public static final ConfiguredFeature<?, ?> CROCUS = createFlowerConfiguredFeature("crocus", BYGBlocks.CROCUS);
    public static final ConfiguredFeature<?, ?> IRIS = createFlowerConfiguredFeature("iris", BYGBlocks.IRIS);
    public static final ConfiguredFeature<?, ?> ANEMONE_WHITE = createFlowerConfiguredFeature("white_anemone", BYGBlocks.WHITE_ANEMONE);
    public static final ConfiguredFeature<?, ?> ANEMONE_PINK = createFlowerConfiguredFeature("pink_anemone", BYGBlocks.PINK_ANEMONE);
    public static final ConfiguredFeature<?, ?> ROSE_WINTER = createFlowerConfiguredFeature("winter_rose", BYGBlocks.WINTER_ROSE);
    public static final ConfiguredFeature<?, ?> ALLIUM_PINK = createFlowerConfiguredFeature("allium_pink", BYGBlocks.PINK_ALLIUM);
    public static final ConfiguredFeature<?, ?> DAISY_ORANGE = createFlowerConfiguredFeature("orange_daisy", BYGBlocks.ORANGE_DAISY);
    public static final ConfiguredFeature<?, ?> HYDRANGEA_BUSH = createFlowerConfiguredFeature("hydrangea_bush", BYGBlocks.HYDRANGEA_BUSH);
    public static final ConfiguredFeature<?, ?> HYDRANGEA_HEDGE = createFlowerConfiguredFeature("hydrangea_hedge", BYGBlocks.HYDRANGEA_HEDGE);
    public static final ConfiguredFeature<?, ?> SAGE_WHITE = createFlowerConfiguredFeature("white_sage", BYGBlocks.WHITE_SAGE);
    public static final ConfiguredFeature<?, ?> SAGE_PURPLE = createFlowerConfiguredFeature("purple_sage", BYGBlocks.PURPLE_SAGE);
    public static final ConfiguredFeature<?, ?> DAFFODIL_YELLOW = createFlowerConfiguredFeature("yellow_daffodil", BYGBlocks.YELLOW_DAFFODIL);
    public static final ConfiguredFeature<?, ?> ALPINE_BELLFLOWER = createFlowerConfiguredFeature("alpine_bellflower", BYGBlocks.ALPINE_BELLFLOWER);
    public static final ConfiguredFeature<?, ?> KOVAN_FLOWER = createFlowerConfiguredFeature("kovan_flower", BYGBlocks.KOVAN_FLOWER);
    public static final ConfiguredFeature<?, ?> TULIP_GREEN = createFlowerConfiguredFeature("green_tulip", BYGBlocks.GREEN_TULIP);
    public static final ConfiguredFeature<?, ?> TULIP_CYAN = createFlowerConfiguredFeature("cyan_tulip", BYGBlocks.CYAN_TULIP);
    public static final ConfiguredFeature<?, ?> TULIP_MAGENTA = createFlowerConfiguredFeature("magenta_tulip", BYGBlocks.MAGENTA_TULIP);
    public static final ConfiguredFeature<?, ?> TULIP_PURPLE = createFlowerConfiguredFeature("purple_tulip", BYGBlocks.PURPLE_TULIP);
    public static final ConfiguredFeature<?, ?> TULIP_YELLOW = createFlowerConfiguredFeature("yellow_tulip", BYGBlocks.YELLOW_TULIP);
    public static final ConfiguredFeature<?, ?> CATTAIL = createPatchConfiguredFeature("cattail", BYGBlocks.CATTAIL, 32);
    public static final ConfiguredFeature<?, ?> LOLLIPOP_FLOWER = createFlowerConfiguredFeature("lollipop_flower", BYGBlocks.LOLLIPOP_FLOWER);
    public static final ConfiguredFeature<?, ?> LEATHER_FLOWER_PEACH = createFlowerConfiguredFeature("peach_leather_flower", BYGBlocks.PEACH_LEATHER_FLOWER);
    public static final ConfiguredFeature<?, ?> LEATHER_FLOWER_VIOLET = createFlowerConfiguredFeature("violet_leather_flower", BYGBlocks.VIOLET_LEATHER_FLOWER);
    public static final ConfiguredFeature<?, ?> BLACK_ROSE = createFlowerConfiguredFeature("black_rose", BYGBlocks.BLACK_ROSE);
    public static final ConfiguredFeature<?, ?> CYAN_ROSE = createFlowerConfiguredFeature("cyan_rose", BYGBlocks.CYAN_ROSE);
    public static final ConfiguredFeature<?, ?> ROSE_OSIRIA = createFlowerConfiguredFeature("osiria_rose", BYGBlocks.ORSIRIA_ROSE);
    public static final ConfiguredFeature<?, ?> FAIRY_SLIPPER = createFlowerConfiguredFeature("fairy_slipper", BYGBlocks.FAIRY_SLIPPER);
    public static final ConfiguredFeature<?, ?> HORSEWEED = createPatchConfiguredFeature("horseweed", BYGBlocks.HORSEWEED, 10);


    public static final ConfiguredFeature<?, ?> AMARANTH_FIELD_FLOWERS = createConfiguredFeature("amaranth_field_flowers",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(AMARANTH.placed(), 0.2F),
                new WeightedPlacedFeature(AMARANTH_MAGENTA.placed(), 0.2F),
                new WeightedPlacedFeature(AMARANTH_ORANGE.placed(), 0.2F),
                new WeightedPlacedFeature(AMARANTH_PURPLE.placed(), 0.2F)),
                AMARANTH_CYAN.placed())
        ));

    public static final ConfiguredFeature<RandomPatchConfiguration, ?> TINY_LILY_PAD = createConfiguredFeature("tiny_lily_pad",
        Feature.RANDOM_PATCH.configured(
            new RandomPatchConfiguration(10, 7, 3,
                () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.TINY_LILYPADS))).onlyWhenEmpty())
        ));

    public static final ConfiguredFeature<?, ?> WATER_SILK = createConfiguredFeature("water_silk",
        Feature.RANDOM_PATCH.configured(
            new RandomPatchConfiguration(10, 7, 3,
                () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WATER_SILK))).onlyWhenEmpty())
        ));

    public static final ConfiguredFeature<?, ?> ALLIUM_FIELD_FLOWERS = createConfiguredFeature("allium_field_flowers",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(ALLIUM_TALL_BUSH.placed(), 0.25F),
                new WeightedPlacedFeature(ALLIUM_TALL_PINK_BUSH.placed(), 0.25F),
                new WeightedPlacedFeature(ALLIUM_BUSH.placed(), 0.25F)),
                ALLIUM_PINK_BUSH.placed())
        ));


    public static final ConfiguredFeature<?, ?> ROSE_FIELD_FLOWERS = createConfiguredFeature("rose_field_flowers",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(ROSE_OSIRIA.placed(), 0.25F),
                new WeightedPlacedFeature(ROSE.placed(), 0.25F)),
                ROSE_BUSH.placed())
        ));

    public static final ConfiguredFeature<?, ?> DESERT_VEGETATION = createConfiguredFeature("desert_vegetation",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(MINI_CACTI.placed(), 0.3F),
                new WeightedPlacedFeature(PRICKLY_PEAR_CACTI.placed(), 0.3F),
                new WeightedPlacedFeature(FIRECRACKER_BUSH.placed(), 0.1F)),
                GOLDEN_SPINED_CACTI.placed())
        ));

    public static final ConfiguredFeature<?, ?> PRAIRIE_GRASS = createConfiguredFeature("prairie_grass",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(PRAIRIE_GRASS_PATCH.placed(), 0.75F)),
                TALL_PRAIRIE_GRASS_PATCH.placed())
        ));

    public static final ConfiguredFeature<?, ?> MUSHROOMS = createConfiguredFeature("mushrooms",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(WOOD_BLEWIT.placed(), 0.33F),
                new WeightedPlacedFeature(WEEPING_MILKCAP.placed(), 0.33F)),
                GREEN_MUSHROOM.placed())
        ));

    public static final ConfiguredFeature<?, ?> QUARTZ_SPIKE = createConfiguredFeature("quartz_spike",
        BYGFeatures.QUARTZ_SPIKES.configured(
            new QuartzSpikeConfig.Builder()
                .setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(Blocks.QUARTZ_BLOCK.defaultBlockState(), 3)
                    .add(Blocks.SMOOTH_QUARTZ.defaultBlockState(), 2)
                )).build()
        ));

    public static final ConfiguredFeature<?, ?> JUNGLE_FLOWERS = createConfiguredFeature("jungle_flowers",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(BISTORT.placed(), 0.142F),
                new WeightedPlacedFeature(GUZMANIA.placed(), 0.142F),
                new WeightedPlacedFeature(BEGONIA.placed(), 0.142F),
                new WeightedPlacedFeature(LAZARUS_BELLFLOWER.placed(), 0.142F),
                new WeightedPlacedFeature(RICHEA.placed(), 0.142F),
                new WeightedPlacedFeature(TORCH_GINGER.placed(), 0.142F)),
                INCAN_LILY.placed())
        ));

    public static final ConfiguredFeature<?, ?> JACARANDA_BUSHES = createConfiguredFeature("jacaranda_bushes",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(FLOWERING_INDIGO_JACARANDA_BUSH.placed(), 0.25F),
                new WeightedPlacedFeature(FLOWERING_JACARANDA_BUSH.placed(), 0.25F),
                new WeightedPlacedFeature(INDIGO_JACARANDA_BUSH.placed(), 0.25F)),
                JACARANDA_BUSH.placed())
        ));

    public static final ConfiguredFeature<?, ?> SWAMP_WATER_VEGETATION = createConfiguredFeature("swamp_water_vegetation",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(TINY_LILY_PAD.placed(), 0.50F)),
                WATER_SILK.placed())
        ));

    public static final ConfiguredFeature<?, ?> CHERRY_FOLIAGE = createConfiguredFeature("cherry_foliage",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(WHITE_CHERRY_FOLIAGE.placed(), 0.5F)),
                PINK_CHERRY_FOLIAGE.placed())
        ));

    public static final ConfiguredFeature<?, ?> ANEMONES = createConfiguredFeature("anemones",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(ANEMONE_PINK.placed(), 0.5F)),
                ANEMONE_WHITE.placed())
        ));

    public static final ConfiguredFeature<?, ?> SAGES = createConfiguredFeature("sages",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(SAGE_PURPLE.placed(), 0.5F)),
                SAGE_WHITE.placed())
        ));

    public static final ConfiguredFeature<?, ?> HYDRANGEAS = createConfiguredFeature("hydrangeas",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(HYDRANGEA_BUSH.placed(), 0.5F)),
                HYDRANGEA_HEDGE.placed())
        ));

    public static final ConfiguredFeature<?, ?> TULIPS = createConfiguredFeature("tulips",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(TULIP_MAGENTA.placed(), 0.2F),
                new WeightedPlacedFeature(TULIP_YELLOW.placed(), 0.2F),
                new WeightedPlacedFeature(TULIP_PURPLE.placed(), 0.2F),
                new WeightedPlacedFeature(TULIP_CYAN.placed(), 0.2F)),
                TULIP_GREEN.placed())
        ));


    public static final ConfiguredFeature<PumpkinConfig, ?> PUMPKIN1 = createConfiguredFeature("pumpkin1",
        BYGFeatures.LARGE_PUMPKIN1.configured(
            new PumpkinConfig.Builder()
                .setPumpkinBlock(Blocks.PUMPKIN)
                .build()
        ));
    public static final ConfiguredFeature<PumpkinConfig, ?> PUMPKIN2 = createConfiguredFeature("pumpkin2",
        BYGFeatures.LARGE_PUMPKIN2.configured(
            new PumpkinConfig.Builder()
                .setPumpkinBlock(Blocks.PUMPKIN).setStemBlock(Blocks.DARK_OAK_LOG)
                .setLeavesBlock(Blocks.DARK_OAK_LEAVES)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> LARGE_PUMPKINS = createConfiguredFeature("large_pumpkin",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(PUMPKIN1.placed(), 0.5F)),
                PUMPKIN2.placed())
        ));

    public static final ConfiguredFeature<?, ?> LEATHER_FLOWERS = createConfiguredFeature("leather_flowers",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(LEATHER_FLOWER_PEACH.placed(), 0.5F)),
                LEATHER_FLOWER_VIOLET.placed())
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> GREEN_MUSHROOM_HUGE = createConfiguredFeature("huge_green_mushroom",
        BYGFeatures.GREEN_MUSHROOM_HUGE.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> WOOD_BLEWIT_HUGE = createConfiguredFeature("huge_wood_blewit",
        BYGFeatures.WOOD_BLEWIT_HUGE.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> WEEPING_MILKCAP_HUGE = createConfiguredFeature("huge_weeping_milkcap",
        BYGFeatures.WEEPING_MILKCAP_HUGE.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> GREEN_MUSHROOM_MINI = createConfiguredFeature("mini_green_mushroom",
        BYGFeatures.MINI_GREEN_MUSHROOM.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK)
                .setMinHeight(3)
                .setMaxHeight(3)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> WOOD_BLEWIT_MINI = createConfiguredFeature("mini_wood_blewit",
        BYGFeatures.MINI_WOOD_BLEWIT.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK)
                .setMinHeight(2)
                .setMaxHeight(3)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> WEEPING_MILKCAP_MINI = createConfiguredFeature("mini_weeping_milkcap",
        BYGFeatures.MINI_WEEPING_MILKCAP.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK)
                .setMinHeight(2)
                .setMaxHeight(3)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> RED_MUSHROOM_MINI = createConfiguredFeature("mini_red_mushroom",
        BYGFeatures.MINI_RED_MUSHROOM.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.MUSHROOM_STEM)
                .setMushroomBlock(Blocks.RED_MUSHROOM_BLOCK)
                .setMinHeight(2)
                .setMaxHeight(3)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> BROWN_MUSHROOM_MINI = createConfiguredFeature("mini_brown_mushroom",
        BYGFeatures.MINI_BROWN_MUSHROOM.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.MUSHROOM_STEM)
                .setMushroomBlock(Blocks.BROWN_MUSHROOM_BLOCK)
                .setMinHeight(2)
                .setMaxHeight(3)
                .build()
        ));


    public static final ConfiguredFeature<?, ?> HUGE_MUSHROOMS = createConfiguredFeature("huge_mushrooms",
        Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(
                new WeightedPlacedFeature(GREEN_MUSHROOM_HUGE.placed(), 0.35F),
                new WeightedPlacedFeature(WOOD_BLEWIT_HUGE.placed(), 0.35F),
                new WeightedPlacedFeature(WEEPING_MILKCAP_HUGE.placed(), 0.35F)),
                GREEN_MUSHROOM_HUGE.placed())
        ));

}
