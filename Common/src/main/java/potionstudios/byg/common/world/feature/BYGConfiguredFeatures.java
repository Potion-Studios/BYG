package potionstudios.byg.common.world.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BlueBerryBush;
import potionstudios.byg.common.world.feature.config.*;
import potionstudios.byg.common.world.feature.configured.BYGTreeFeatures;
import potionstudios.byg.common.world.feature.stateproviders.BetweenNoiseThresholdProvider;

import java.util.List;

import static potionstudios.byg.common.world.feature.configured.BYGTreeFeatures.*;
import static potionstudios.byg.mixin.access.VegetationFeaturesAccess.invokeGrassPatch;

public class BYGConfiguredFeatures {

    /***********************************************************Configured Features***********************************************************/

    public static final ConfiguredFeature<?, ?> ALLIUM_BUSH = createFlowerConfiguredFeature("allium_bush", BYGBlocks.ALLIUM_FLOWER_BUSH);
    public static final ConfiguredFeature<?, ?> ALLIUM_PINK_BUSH = createFlowerConfiguredFeature("pink_allium_bush", BYGBlocks.PINK_ALLIUM_FLOWER_BUSH);
    public static final ConfiguredFeature<?, ?> ALLIUM_TALL_BUSH = createConfiguredFeature("tall_allium_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.TALL_ALLIUM))), List.of(), 15)));
    public static final ConfiguredFeature<?, ?> ALLIUM_TALL_PINK_BUSH = createConfiguredFeature("tall_pink_allium_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.TALL_PINK_ALLIUM))), List.of(), 15)));

    public static final ConfiguredFeature<?, ?> DUNE_TERRAIN = createConfiguredFeature("dune_terrain", BYGFeatures.DUNE_TERRAIN.configured(FeatureConfiguration.NONE));

    public static final ConfiguredFeature<?, ?> AMARANTH = createFlowerConfiguredFeature("amaranth", BYGBlocks.AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_MAGENTA = createFlowerConfiguredFeature("magenta_amaranth", BYGBlocks.MAGENTA_AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_ORANGE = createFlowerConfiguredFeature("orange_amaranth", BYGBlocks.ORANGE_AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_PURPLE = createFlowerConfiguredFeature("purple_amaranth", BYGBlocks.PURPLE_AMARANTH);
    public static final ConfiguredFeature<?, ?> AMARANTH_CYAN = createFlowerConfiguredFeature("cyan_amaranth", BYGBlocks.CYAN_AMARANTH);

    public static final ConfiguredFeature<?, ?> FIRECRACKER_BUSH = createFlowerConfiguredFeature("firecracker_bush", BYGBlocks.FIRECRACKER_FLOWER_BUSH);
    public static final ConfiguredFeature<?, ?> SHRUB = createFlowerConfiguredFeature("shrub", BYGBlocks.SHRUB);

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


    public static final ConfiguredFeature<?, ?> AMARANTH_FIELD_FLOWERS = createConfiguredFeature("amaranth_field_flowers", Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(AMARANTH.placed(), 0.2F), new WeightedPlacedFeature(AMARANTH_MAGENTA.placed(), 0.2F), new WeightedPlacedFeature(AMARANTH_ORANGE.placed(), 0.2F), new WeightedPlacedFeature(AMARANTH_PURPLE.placed(), 0.2F)), AMARANTH_CYAN.placed())));

    public static final ConfiguredFeature<?, ?> PATCH_GRASS_EXTRA = createConfiguredFeature("patch_grass_extra", Feature.RANDOM_PATCH.configured(invokeGrassPatch(SimpleStateProvider.simple(Blocks.GRASS.defaultBlockState()), 100)));
    public static final ConfiguredFeature<?, ?> BYG_GRASS_EXTRA = createConfiguredFeature("short_grass_and_grass_extra", Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PATCH_GRASS_EXTRA.placed(), 0.5F)), PATCH_GRASS_EXTRA.placed())));

    public static final ConfiguredFeature<?, ?> ALLIUM_FIELD_FLOWERS = createConfiguredFeature("allium_field_flowers", Feature.RANDOM_SELECTOR.configured(
            new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(ALLIUM_TALL_BUSH.placed(), 0.25F), new WeightedPlacedFeature(ALLIUM_TALL_PINK_BUSH.placed(), 0.25F), new WeightedPlacedFeature(ALLIUM_BUSH.placed(), 0.25F)), ALLIUM_PINK_BUSH.placed())));

    public static final BlockPredicate CRYPTIC_STONE_UNDER = BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, BlockPos.ZERO.relative(Direction.DOWN));

    public static final ConfiguredFeature<?, ?> CRYPTIC_FIRE_PATCH = createConfiguredFeature("cryptic_fire_patch", Feature.RANDOM_PATCH.configured(
            new RandomPatchConfiguration(24, 4, 7, () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_FIRE))).placed(createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER)))));
    public static final ConfiguredFeature<?, ?> CRYPTIC_FIRE = createConfiguredFeature("cryptic_fire", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_FIRE))));

    public static final ConfiguredFeature<?, ?> CRYPTIC_VENT_PATCH = createConfiguredFeature("cryptic_vent_patch", Feature.RANDOM_PATCH.configured(
            new RandomPatchConfiguration(24, 4, 7, () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_VENT))).placed(createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER)))));
    public static final ConfiguredFeature<?, ?> CRYPTIC_VENT = createConfiguredFeature("cryptic_vent", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_VENT))));

    public static final ConfiguredFeature<?, ?> TALL_CRYPTIC_VENT_PATCH = createConfiguredFeature("tall_cryptic_vent_patch", Feature.RANDOM_PATCH.configured(
            new RandomPatchConfiguration(24, 4, 7, () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.TALL_CRYPTIC_VENT))).placed(createSolidDownAndAirAllAroundFilter(CRYPTIC_STONE_UNDER)))));
    public static final ConfiguredFeature<?, ?> TALL_CRYPTIC_VENT = createConfiguredFeature("tall_cryptic_vent", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.TALL_CRYPTIC_VENT))));


    public static final RuleTest CRYPTIC_STONE = new BlockMatchTest(BYGBlocks.CRYPTIC_STONE);

    public static final ConfiguredFeature<?, ?> ORE_CRYPTIC_REDSTONE = createConfiguredFeature("cryptic_redstone", Feature.ORE.configured(new OreConfiguration(List.of(OreConfiguration.target(CRYPTIC_STONE, BYGBlocks.CRYPTIC_REDSTONE_ORE.defaultBlockState())), 8)));


    public static final ConfiguredFeature<?, ?> BEEHIVES = createConfiguredFeature("beehives", BYGFeatures.BEEHIVE.configured(new NoneFeatureConfiguration()));
    public static final ConfiguredFeature<?, ?> MINI_CACTI = createConfiguredFeature("mini_cacti", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.MINI_CACTUS))), List.of(), 4)));
    public static final ConfiguredFeature<?, ?> HORSEWEED = createConfiguredFeature("horseweed", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.HORSEWEED))), List.of(), 10)));
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> TINY_LILY_PAD = createConfiguredFeature("tiny_lily_pad", Feature.RANDOM_PATCH.configured(new RandomPatchConfiguration(10, 7, 3, () -> {
        return Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.TINY_LILYPADS))).onlyWhenEmpty();
    })));
    public static final ConfiguredFeature<?, ?> WATER_SILK = createConfiguredFeature("water_silk", Feature.RANDOM_PATCH.configured(new RandomPatchConfiguration(10, 7, 3, () -> {
        return Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WATER_SILK))).onlyWhenEmpty();
    })));
    public static final ConfiguredFeature<?, ?> WINTER_SUCCULENT = createConfiguredFeature("winter_succulent", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WINTER_SUCCULENT))), List.of(), 10)));
    public static final ConfiguredFeature<?, ?> BEACH_GRASS = createConfiguredFeature("beach_grass_patch", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.BEACH_GRASS))), List.of(), 32)));
    public static final ConfiguredFeature<?, ?> LEAF_PILE = createConfiguredFeature("leaf_pile", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.LEAF_PILE))), List.of(), 15)));
    public static final ConfiguredFeature<?, ?> RICHEA = createFlowerConfiguredFeature("richea", BYGBlocks.RICHEA);
    public static final ConfiguredFeature<?, ?> PRAIRIE_GRASS_PATCH = createConfiguredFeature("prairie_grass_patch", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.PRAIRIE_GRASS))), List.of(), 100)));
    public static final ConfiguredFeature<?, ?> TALL_PRAIRIE_GRASS_PATCH = createConfiguredFeature("tall_prairie_grass_patch", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.TALL_PRAIRIE_GRASS))), List.of(), 100)));
    public static final ConfiguredFeature<?, ?> ROSE_BUSH = createConfiguredFeature("rose_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.ROSE_BUSH))), List.of(), 64)));
    public static final ConfiguredFeature<?, ?> JAPANESE_ORCHID = createFlowerConfiguredFeature("japanese_orchid", BYGBlocks.JAPANESE_ORCHID);
    public static final ConfiguredFeature<?, ?> FOXGLOVE = createFlowerConfiguredFeature("foxglove", BYGBlocks.FOXGLOVE);
    public static final ConfiguredFeature<?, ?> FLOWERING_INDIGO_JACARANDA_BUSH = createConfiguredFeature("flowering_indigo_jacaranda_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH))), List.of(), 32)));
    public static final ConfiguredFeature<?, ?> INDIGO_JACARANDA_BUSH = createConfiguredFeature("indigo_jacaranda_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.INDIGO_JACARANDA_BUSH))), List.of(), 32)));
    public static final ConfiguredFeature<?, ?> FLOWERING_JACARANDA_BUSH = createConfiguredFeature("flowering_jacaranda_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.FLOWERING_JACARANDA_BUSH))), List.of(), 32)));
    public static final ConfiguredFeature<?, ?> JACARANDA_BUSH = createConfiguredFeature("jacaranda_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.JACARANDA_BUSH))), List.of(), 32)));
    public static final ConfiguredFeature<?, ?> PRICKLY_PEAR_CACTI = createConfiguredFeature("prickly_pear_cacti", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.PRICKLY_PEAR_CACTUS))), List.of(), 5)));
    public static final ConfiguredFeature<?, ?> GOLDEN_SPINED_CACTI = createConfiguredFeature("golden_spined_cacti", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.GOLDEN_SPINED_CACTUS))), List.of(), 5)));
    //
    public static final ConfiguredFeature<?, ?> PINK_CHERRY_FOLIAGE = createConfiguredFeature("pink_cherry_foliage", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.PINK_CHERRY_FOLIAGE))), List.of(), 15)));
    public static final ConfiguredFeature<?, ?> WHITE_CHERRY_FOLIAGE = createConfiguredFeature("white_cherry_foliage", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WHITE_CHERRY_FOLIAGE))), List.of(), 15)));
    public static final ConfiguredFeature<?, ?> BLUE_BERRY_BUSH = createConfiguredFeature("blue_berry_bush", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.BLUEBERRY_BUSH.defaultBlockState().setValue(BlueBerryBush.AGE, 3)))), List.of(), 15)));
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
    public static final ConfiguredFeature<?, ?> CATTAIL = createConfiguredFeature("cattail", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.CATTAIL))), List.of(), 15)));
    public static final ConfiguredFeature<?, ?> LOLLIPOP_FLOWER = createFlowerConfiguredFeature("lollipop_flower", BYGBlocks.LOLLIPOP_FLOWER);
    public static final ConfiguredFeature<?, ?> LEATHER_FLOWER_PEACH = createFlowerConfiguredFeature("peach_leather_flower", BYGBlocks.PEACH_LEATHER_FLOWER);
    public static final ConfiguredFeature<?, ?> LEATHER_FLOWER_VIOLET = createFlowerConfiguredFeature("violet_leather_flower", BYGBlocks.VIOLET_LEATHER_FLOWER);

    public static final ConfiguredFeature<?, ?> BLACK_ROSE = createFlowerConfiguredFeature("black_rose", BYGBlocks.BLACK_ROSE);
    public static final ConfiguredFeature<?, ?> CYAN_ROSE = createFlowerConfiguredFeature("cyan_rose", BYGBlocks.CYAN_ROSE);
    public static final ConfiguredFeature<?, ?> ROSE_OSIRIA = createFlowerConfiguredFeature("osiria_rose", BYGBlocks.ORSIRIA_ROSE);
    public static final ConfiguredFeature<?, ?> FAIRY_SLIPPER = createFlowerConfiguredFeature("fairy_slipper", BYGBlocks.FAIRY_SLIPPER);
    //
    public static final ConfiguredFeature<?, ?> IVIS_ROOTS = createPatchConfiguredFeature("ivis_roots", BYGBlocks.IVIS_ROOTS, 32);
    public static final ConfiguredFeature<?, ?> IVIS_SPROUT = createPatchConfiguredFeature("ivis_sprout", BYGBlocks.IVIS_SPROUT, 32);
    //
    public static final ConfiguredFeature<?, ?> BULBIS_SPROUTS = createPatchConfiguredFeature("bulbis_sprouts", BYGBlocks.BULBIS_SPROUTS, 32);
    public static final ConfiguredFeature<?, ?> CRYPTIC_BRAMBLE_PATCH = createPatchConfiguredFeature("cryptic_bramble_patch", BYGBlocks.CRYPTIC_BRAMBLE, 32);
    public static final ConfiguredFeature<?, ?> CRYPTIC_BRAMBLE = createConfiguredFeature("cryptic_bramble", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.CRYPTIC_BRAMBLE))));
    //
    public static final ConfiguredFeature<?, ?> BULBIS_ODDITY = createPatchConfiguredFeature("bulbis_oddity", BYGBlocks.BULBIS_ODDITY, 32);
    public static final ConfiguredFeature<?, ?> PURPLE_BULBIS_ODDITY = createPatchConfiguredFeature("purple_bulbis_oddity", BYGBlocks.PURPLE_BULBIS_ODDITY, 32);
    //
    public static final ConfiguredFeature<?, ?> BULBIS_ANOMALY = createPatchConfiguredFeature("bulbis_anomaly", BYGBlocks.BULBIS_ANOMALY, 48);
    public static final ConfiguredFeature<?, ?> PURPLE_BULBIS_ANOMALY = createPatchConfiguredFeature("purple_bulbis_anomaly", BYGBlocks.PURPLE_BULBIS_ANOMALY, 48);
    public static final ConfiguredFeature<?, ?> DEAD_SEA_SPIKE = createConfiguredFeature("dead_sea_spike", BYGFeatures.POINTY_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 5).add(Blocks.STONE.defaultBlockState(), 3).add(Blocks.ANDESITE.defaultBlockState(), 2).build())).setSeed(65).build()));
    public static final ConfiguredFeature<?, ?> DEAD_SEA_SPIKE_TALL = createConfiguredFeature("dead_sea_tall_spike", BYGFeatures.POINTY_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 5).add(Blocks.STONE.defaultBlockState(), 3).add(Blocks.ANDESITE.defaultBlockState(), 2).build())).setSeed(85).build()));

    public static final ConfiguredFeature<?, ?> WINDSWEPT_SPIKE = createConfiguredFeature("windswept_spike", BYGFeatures.POINTY_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), 3).add(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE.defaultBlockState(), 2).build())).setSeed(65).build()));
    public static final ConfiguredFeature<?, ?> WINDSWEPT_SPIKE_TALL = createConfiguredFeature("windswept_tall_spike", BYGFeatures.POINTY_ROCK.configured(new PointyRockConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), 3).add(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE.defaultBlockState(), 2).build())).setSeed(85).build()));

    public static final ConfiguredFeature<?, ?> MOSSY_STONE_BOULDER = createConfiguredFeature("mossy_stone_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(BYGBlocks.MOSSY_STONE.defaultBlockState())));
    public static final ConfiguredFeature<?, ?> ROCKY_STONE_BOULDER = createConfiguredFeature("rocky_stone_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(BYGBlocks.ROCKY_STONE.defaultBlockState())));
    public static final ConfiguredFeature<?, ?> BLACKSTONE_BOULDER = createConfiguredFeature("blackstone_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.BLACKSTONE.defaultBlockState())));
    public static final ConfiguredFeature<?, ?> ORANGE_TERRACOTTA_BOULDER = createConfiguredFeature("orange_terracotta_boulder", Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.ORANGE_TERRACOTTA.defaultBlockState())));

    public static final ConfiguredFeature<PumpkinConfig, ?> PUMPKIN1 = createConfiguredFeature("pumpkin1", BYGFeatures.LARGE_PUMPKIN1.configured(new PumpkinConfig.Builder().setPumpkinBlock(Blocks.PUMPKIN).build()));
    public static final ConfiguredFeature<PumpkinConfig, ?> PUMPKIN2 = createConfiguredFeature("pumpkin2", BYGFeatures.LARGE_PUMPKIN2.configured(new PumpkinConfig.Builder().setPumpkinBlock(Blocks.PUMPKIN).setStemBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).build()));

    /***********************************************************Configured & Decorated Features***********************************************************/

    public static final ConfiguredFeature<?, ?> WIDE_WATER_LAKE = createConfiguredFeature("wide_water_lake", BYGFeatures.WIDE_LAKE.configured(new SimpleBlockProviderConfig(SimpleStateProvider.simple(Blocks.WATER.defaultBlockState()))));
    public static final ConfiguredFeature<?, ?> FROST_MAGMA_LAKE = createConfiguredFeature("wide_frost_magma_lake", BYGFeatures.WIDE_LAKE.configured(new SimpleBlockProviderConfig(SimpleStateProvider.simple(BYGBlocks.FROST_MAGMA.defaultBlockState()))));


    public static final ConfiguredFeature<?, ?> LARGE_WINDSWEPT_LAKE = createConfiguredFeature("large_windswept_lake", BYGFeatures.LARGE_LAKE.configured(
            new LargeLakeFeatureConfig(15, 22, 4, 10, SimpleStateProvider.simple(BYGBlocks.WINDSWEPT_SAND), SimpleStateProvider.simple(BYGBlocks.WINDSWEPT_SAND),
                    List.of(() -> BYGConfiguredFeatures.TINY_LILY_PAD.placed(RarityFilter.onAverageOnceEvery(95), BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0)))), () -> LargeLakeFeatureConfig.createDripLeavesPlacedFeature(80, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)),
                    List.of(() -> LargeLakeFeatureConfig.createDripLeavesPlacedFeature(8, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR), () -> BYGTreeFeatures.PALM_TREES.placed(RarityFilter.onAverageOnceEvery(30), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(BYGBlocks.PALM_SAPLING.defaultBlockState(), BlockPos.ZERO)))), List.of())));

    public static final ConfiguredFeature<NoisySphereConfig, ?> LARGE_BOULDER = createConfiguredFeature("large_boulder", BYGFeatures.NOISE_SPHERE.configured(new NoisySphereConfig.Builder().withBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 3).add(BYGBlocks.MOSSY_STONE.defaultBlockState(), 2))).withStackHeight(ConstantInt.of(1)).withRadiusSettings(new NoisySphereConfig.RadiusSettings(BiasedToBottomInt.of(16, 30), BiasedToBottomInt.of(16, 30), 0, BiasedToBottomInt.of(16, 30))).build()));
    public static final ConfiguredFeature<NoisySphereConfig, ?> LARGE_GRANITE_BOULDER = createConfiguredFeature("large_granite_boulder", BYGFeatures.NOISE_SPHERE.configured(new NoisySphereConfig.Builder().copy(LARGE_BOULDER.config).withBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.GRANITE.defaultBlockState(), 3).add(Blocks.POLISHED_GRANITE.defaultBlockState(), 2))).build()));
    public static final ConfiguredFeature<NoisySphereConfig, ?> LARGE_WINDSWEPT_BOULDER = createConfiguredFeature("large_windswept_boulders", BYGFeatures.NOISE_SPHERE.configured(
            new NoisySphereConfig.Builder()
                    .withBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 158).add(Blocks.TUFF.defaultBlockState(), 41).add(Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 1)))
                    .withTopBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.ROCKY_STONE.defaultBlockState(), 158).add(Blocks.TUFF.defaultBlockState(), 41).add(Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 1)))
                    .withRadiusSettings(new NoisySphereConfig.RadiusSettings(BiasedToBottomInt.of(16, 35), UniformInt.of(20, 25), 0, BiasedToBottomInt.of(16, 35))).withNoiseFrequency(0.2F)
                    .withSpawningFeatures(List.of(
                            () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WINDSWEPT_SAND))).placed
                                    (CountPlacement.of(UniformInt.of(10, 25)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                                            BlockPredicateFilter.forPredicate(BlockPredicate.anyOf(BlockPredicate.matchesBlock(Blocks.TUFF, new BlockPos(0, -1, 0)),
                                                    BlockPredicate.matchesBlock(Blocks.DEEPSLATE_EMERALD_ORE, new BlockPos(0, -1, 0)), BlockPredicate.matchesBlock(BYGBlocks.ROCKY_STONE, new BlockPos(0, -1, 0)))))
                    )).build()));
    //

    public static final ConfiguredFeature<?, ?> CRYPTIC_CAVES = createConfiguredFeature("cryptic_caves", BYGFeatures.NOISY_CAVE_SPHERE.configured(
            new NoisySphereConfig.Builder().withRadiusSettings(
                            new NoisySphereConfig.RadiusSettings(UniformInt.of(16, 24), UniformInt.of(10, 16), 0, UniformInt.of(16, 24))
                    ).withBlockProvider(SimpleStateProvider.simple(Blocks.CAVE_AIR)).withFluidState(Fluids.LAVA.defaultFluidState())
                    .withTopBlockProvider(SimpleStateProvider.simple(Blocks.CAVE_AIR)).withSpawningFeatures(
                            List.of(
                                    () -> BYGConfiguredFeatures.CRYPTIC_FIRE.placed(List.of(RarityFilter.onAverageOnceEvery(5), createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, new BlockPos(0, -1, 0))))),
                                    () -> BYGConfiguredFeatures.CRYPTIC_VENTS.placed(List.of(RarityFilter.onAverageOnceEvery(10), createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, new BlockPos(0, -1, 0))))),
                                    () -> BYGConfiguredFeatures.CRYPTIC_BRAMBLE.placed(List.of(RarityFilter.onAverageOnceEvery(12), createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlock(BYGBlocks.CRYPTIC_STONE, new BlockPos(0, -1, 0)))))
                            )
                    ).build()));

    public static final ConfiguredFeature<NoisySphereConfig, ?> STONE_FOREST_COLUMN = createConfiguredFeature("stone_forest_column", BYGFeatures.NOISE_SPHERE.configured(
            new NoisySphereConfig.Builder().withStackHeight(UniformInt.of(3, 7))
                    .withRadiusSettings(new NoisySphereConfig.RadiusSettings(UniformInt.of(8, 20), UniformInt.of(80, 100), 17, UniformInt.of(6, 18))
                    ).withRadiusDivisorPerStack(2).withNoise2DChance(0.25)
                    .withBlockProvider(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.STONE.defaultBlockState(), 5)))
                    .withTopBlockProvider(SimpleStateProvider.simple(BYGBlocks.OVERGROWN_STONE)).withNoiseFrequency(0.09F).withRadiusMatcher(RadiusMatcher.NONE)
                    .withCheckSquareDistance(false).build()));

    public static final ConfiguredFeature<NoisySphereConfig, ?> IVIS_FIELDS_SPIKE = createConfiguredFeature("ivis_fields_spike", BYGFeatures.NOISE_SPIKE.configured(new NoisySphereConfig.Builder()
            .copy(STONE_FOREST_COLUMN.config).withStackHeight(ConstantInt.of(1))
            .withBlockProvider(
                    new BetweenNoiseThresholdProvider(2222, new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1, BetweenNoiseThresholdProvider.createThresholds(0.0125F, -1, 1), SimpleStateProvider.simple(Blocks.CRYING_OBSIDIAN), SimpleStateProvider.simple(Blocks.OBSIDIAN), false)
            ).withTopBlockProvider(
                    new BetweenNoiseThresholdProvider(2222, new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1, BetweenNoiseThresholdProvider.createThresholds(0.0125F, -1, 1), SimpleStateProvider.simple(Blocks.CRYING_OBSIDIAN), SimpleStateProvider.simple(Blocks.OBSIDIAN), false)
            ).withBelowSurfaceDepth(ConstantInt.of(1)).withCheckSquareDistance(true).withPointed(true).build()));

    public static final ConfiguredFeature<NoisySphereConfig, ?> IVIS_FIELDS_COLUMN = createConfiguredFeature("ivis_fields_column", BYGFeatures.NOISE_SPHERE.configured(new NoisySphereConfig.Builder()
            .copy(STONE_FOREST_COLUMN.config)
            .withBlockProvider(
                    new BetweenNoiseThresholdProvider(2222, new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1, BetweenNoiseThresholdProvider.createThresholds(0.0125F, -1, 1), SimpleStateProvider.simple(Blocks.CRYING_OBSIDIAN), SimpleStateProvider.simple(Blocks.OBSIDIAN), false)
            ).withTopBlockProvider(
                    new BetweenNoiseThresholdProvider(2222, new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1, BetweenNoiseThresholdProvider.createThresholds(0.0125F, -1, 1), SimpleStateProvider.simple(Blocks.CRYING_OBSIDIAN), SimpleStateProvider.simple(Blocks.OBSIDIAN), false)
            ).build()));


    public static final ConfiguredFeature<?, ?> CRYPTIC_SPIKE = createConfiguredFeature("cryptic_spike", BYGFeatures.SPIKE.configured(new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.CRYPTIC_STONE.defaultBlockState(), 5).add(BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState(), 5)))));
    public static final ConfiguredFeature<?, ?> BLACK_ICE = createConfiguredFeature("black_ice_snow", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.BLACK_ICE))));

    public static final ConfiguredFeature<?, ?> THERIUM_CRYSTAL_DEPOSIT = createConfiguredFeature("therium_crystal_deposit",
            BYGFeatures.NOISE_SPIKE.configured(
                    new NoisySphereConfig.Builder()
                            .withTopBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGBlocks.THERIUM_BLOCK.defaultBlockState(), 2)
                                    .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 8))
                            ).withBlockProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                    .add(BYGBlocks.THERIUM_BLOCK.defaultBlockState(), 4)
                                    .add(BYGBlocks.ETHER_STONE.defaultBlockState(), 6))
                            )
                            .withStackHeight(ConstantInt.of(1)).withRadiusSettings(new NoisySphereConfig.RadiusSettings(BiasedToBottomInt.of(13, 20), BiasedToBottomInt.of(20, 27), 0, BiasedToBottomInt.of(13, 20)))
                            .withNoiseFrequency(0.2F).withRadiusMatcher(RadiusMatcher.NONE).withPointed(true)
                            .withSpawningFeatures(List.of(
                                    () -> createPatchConfiguredFeature(BYGBlocks.THERIUM_CRYSTAL, 15).placed(
                                            CountPlacement.of(UniformInt.of(10, 25)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                                            BlockPredicateFilter.forPredicate(BlockPredicate.anyOf(BlockPredicate.matchesBlock(BYGBlocks.THERIUM_BLOCK, new BlockPos(0, -1, 0)))))))
                            .build()));


    public static final ConfiguredFeature<?, ?> ROSE_FIELD_FLOWERS = createConfiguredFeature("rose_field_flowers", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ROSE_OSIRIA.placed(), 0.25F),
            new WeightedPlacedFeature(ROSE.placed(), 0.25F)),
            ROSE_BUSH.placed())));

    public static final ConfiguredFeature<?, ?> DESERT_VEGETATION = createConfiguredFeature("desert_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(MINI_CACTI.placed(), 0.3F),
            new WeightedPlacedFeature(PRICKLY_PEAR_CACTI.placed(), 0.3F),
            new WeightedPlacedFeature(FIRECRACKER_BUSH.placed(), 0.1F)),
            GOLDEN_SPINED_CACTI.placed())));

    public static final ConfiguredFeature<?, ?> PRAIRIE_GRASS = createConfiguredFeature("prairie_grass", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(PRAIRIE_GRASS_PATCH.placed(), 0.75F)),
            TALL_PRAIRIE_GRASS_PATCH.placed())));

    public static final ConfiguredFeature<?, ?> MUSHROOMS = createConfiguredFeature("mushrooms", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(WOOD_BLEWIT.placed(), 0.33F), new WeightedPlacedFeature(WEEPING_MILKCAP.placed(), 0.33F)), GREEN_MUSHROOM.placed())));

    public static final ConfiguredFeature<?, ?> QUARTZ_SPIKE = createConfiguredFeature("quartz_spike", BYGFeatures.QUARTZ_SPIKES.configured(new QuartzSpikeConfig.Builder().setBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.QUARTZ_BLOCK.defaultBlockState(), 3).add(Blocks.SMOOTH_QUARTZ.defaultBlockState(), 2))).build()));

    public static final ConfiguredFeature<?, ?> JUNGLE_FLOWERS = createConfiguredFeature("jungle_flowers", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BISTORT.placed(), 0.142F),
            new WeightedPlacedFeature(GUZMANIA.placed(), 0.142F),
            new WeightedPlacedFeature(BEGONIA.placed(), 0.142F),
            new WeightedPlacedFeature(LAZARUS_BELLFLOWER.placed(), 0.142F),
            new WeightedPlacedFeature(RICHEA.placed(), 0.142F),
            new WeightedPlacedFeature(TORCH_GINGER.placed(), 0.142F)),
            INCAN_LILY.placed())));

    public static final ConfiguredFeature<?, ?> JACARANDA_BUSHES = createConfiguredFeature("jacaranda_bushes", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(FLOWERING_INDIGO_JACARANDA_BUSH.placed(), 0.25F),
            new WeightedPlacedFeature(FLOWERING_JACARANDA_BUSH.placed(), 0.25F),
            new WeightedPlacedFeature(INDIGO_JACARANDA_BUSH.placed(), 0.25F)),
            JACARANDA_BUSH.placed())));

    public static final ConfiguredFeature<?, ?> SWAMP_WATER_VEGETATION = createConfiguredFeature("swamp_water_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(TINY_LILY_PAD.placed(), 0.50F)),
            WATER_SILK.placed())));

    public static final ConfiguredFeature<?, ?> CHERRY_FOLIAGE = createConfiguredFeature("cherry_foliage", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(WHITE_CHERRY_FOLIAGE.placed(), 0.5F)),
            PINK_CHERRY_FOLIAGE.placed())));

    public static final ConfiguredFeature<?, ?> ANEMONES = createConfiguredFeature("anemones", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(ANEMONE_PINK.placed(), 0.5F)), ANEMONE_WHITE.placed())));
    //
    public static final ConfiguredFeature<?, ?> SAGES = createConfiguredFeature("sages", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(SAGE_PURPLE.placed(), 0.5F)),
            SAGE_WHITE.placed())));
    //
    public static final ConfiguredFeature<?, ?> HYDRANGEAS = createConfiguredFeature("hydrangeas", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(HYDRANGEA_BUSH.placed(), 0.5F)),
            HYDRANGEA_HEDGE.placed())));

    public static final ConfiguredFeature<?, ?> TULIPS = createConfiguredFeature("tulips", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(TULIP_MAGENTA.placed(), 0.2F),
            new WeightedPlacedFeature(TULIP_YELLOW.placed(), 0.2F),
            new WeightedPlacedFeature(TULIP_PURPLE.placed(), 0.2F),
            new WeightedPlacedFeature(TULIP_CYAN.placed(), 0.2F)),
            TULIP_GREEN.placed())));

    public static final ConfiguredFeature<?, ?> LEATHER_FLOWERS = createConfiguredFeature("leather_flowers", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(LEATHER_FLOWER_PEACH.placed(), 0.5F)), LEATHER_FLOWER_VIOLET.placed())));

    public static final ConfiguredFeature<?, ?> IVIS_PLANTS = createConfiguredFeature("ivis_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(IVIS_ROOTS.placed(), 0.5F)),
            IVIS_SPROUT.placed())));

    public static final ConfiguredFeature<?, ?> BULBIS_ODDITIES = createConfiguredFeature("bulbis_oddities", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BULBIS_ODDITY.placed(), 0.5F)),
            PURPLE_BULBIS_ODDITY.placed())));

    public static final ConfiguredFeature<?, ?> BULBIS_ANOMALIES = createConfiguredFeature("bulbis_anomalies", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BULBIS_ANOMALY.placed(), 0.5F)),
            PURPLE_BULBIS_ANOMALY.placed())));

    public static final ConfiguredFeature<?, ?> CRYPTIC_VENT_PATCHES = createConfiguredFeature("cryptic_vents_patch", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(CRYPTIC_VENT_PATCH.placed(), 0.50F)),
            TALL_CRYPTIC_VENT_PATCH.placed())));

    public static final ConfiguredFeature<?, ?> CRYPTIC_VENTS = createConfiguredFeature("cryptic_vents", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(CRYPTIC_VENT.placed(), 0.50F)),
            TALL_CRYPTIC_VENT.placed())));

    public static final ConfiguredFeature<?, ?> DEAD_SEA_SPIKES = createConfiguredFeature("dead_sea_spikes", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(DEAD_SEA_SPIKE.placed(), 0.75F)),
            DEAD_SEA_SPIKE_TALL.placed())));

    public static final ConfiguredFeature<?, ?> WINDSWEPT_SPIKES = createConfiguredFeature("windswept_spikes",
            Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(WINDSWEPT_SPIKE.placed(), 0.75F)),
                    WINDSWEPT_SPIKE_TALL.placed())));

    public static final ConfiguredFeature<?, ?> LARGE_PUMPKINS = createConfiguredFeature("large_pumpkin",
            Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
                    new WeightedPlacedFeature(PUMPKIN1.placed(), 0.5F)),
                    PUMPKIN2.placed())));


    //Mushrooms
    public static final ConfiguredFeature<BYGMushroomConfig, ?> GREEN_MUSHROOM_HUGE = createConfiguredFeature("huge_green_mushroom", BYGFeatures.GREEN_MUSHROOM_HUGE.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WOOD_BLEWIT_HUGE = createConfiguredFeature("huge_wood_blewit", BYGFeatures.WOOD_BLEWIT_HUGE.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WEEPING_MILKCAP_HUGE = createConfiguredFeature("huge_weeping_milkcap", BYGFeatures.WEEPING_MILKCAP_HUGE.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    //Mini Mushrooms
    public static final ConfiguredFeature<?, ?> GREEN_MUSHROOM_MINI = createConfiguredFeature("mini_green_mushroom", BYGFeatures.MINI_GREEN_MUSHROOM.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK).setMinHeight(3).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> WOOD_BLEWIT_MINI = createConfiguredFeature("mini_wood_blewit", BYGFeatures.MINI_WOOD_BLEWIT.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> WEEPING_MILKCAP_MINI = createConfiguredFeature("mini_weeping_milkcap", BYGFeatures.MINI_WEEPING_MILKCAP.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> RED_MUSHROOM_MINI = createConfiguredFeature("mini_red_mushroom", BYGFeatures.MINI_RED_MUSHROOM.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(Blocks.RED_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> BROWN_MUSHROOM_MINI = createConfiguredFeature("mini_brown_mushroom", BYGFeatures.MINI_BROWN_MUSHROOM.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(Blocks.BROWN_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));


    //Nether Mushrooms
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM = createConfiguredFeature("embur_mushroom1", BYGFeatures.EMBUR_MUSHROOM.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM2 = createConfiguredFeature("embur_mushroom2", BYGFeatures.EMBUR_MUSHROOM2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM3 = createConfiguredFeature("embur_mushroom3", BYGFeatures.EMBUR_MUSHROOM3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM4 = createConfiguredFeature("embur_mushroom4", BYGFeatures.EMBUR_MUSHROOM4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> CRIMSON_FUNGUS1 = createConfiguredFeature("crimson_fungus1", BYGFeatures.CRIMSON_FUNGUS_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.CRIMSON_STEM).setMushroomBlock(Blocks.NETHER_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> CRIMSON_FUNGUS2 = createConfiguredFeature("crimson_fungus2", BYGFeatures.CRIMSON_FUNGUS_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.CRIMSON_STEM).setMushroomBlock(Blocks.NETHER_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> WARPED_FUNGUS1 = createConfiguredFeature("warped_fungus1", BYGFeatures.WARPED_FUNGUS_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.WARPED_STEM).setMushroomBlock(Blocks.WARPED_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WARPED_FUNGUS2 = createConfiguredFeature("warped_fungus2", BYGFeatures.WARPED_FUNGUS_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.WARPED_STEM).setMushroomBlock(Blocks.WARPED_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE1 = createConfiguredFeature("sythian_fungus_tree1", BYGFeatures.SYTHIAN_FUNGUS_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE2 = createConfiguredFeature("sythian_fungus_tree2", BYGFeatures.SYTHIAN_FUNGUS_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE3 = createConfiguredFeature("sythian_fungus_tree3", BYGFeatures.SYTHIAN_FUNGUS_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE4 = createConfiguredFeature("sythian_fungus_tree4", BYGFeatures.SYTHIAN_FUNGUS_TREE4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE1 = createConfiguredFeature("soul_shroom_tree1", BYGFeatures.SOUL_SHROOM_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE2 = createConfiguredFeature("soul_shroom_tree2", BYGFeatures.SOUL_SHROOM_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE3 = createConfiguredFeature("soul_shroom_tree3", BYGFeatures.SOUL_SHROOM_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE1 = createConfiguredFeature("death_cap_tree1", BYGFeatures.DEATH_CAP_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE2 = createConfiguredFeature("death_cap_tree2", BYGFeatures.DEATH_CAP_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE3 = createConfiguredFeature("death_cap_tree3", BYGFeatures.DEATH_CAP_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    //Nether Trees
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE1 = createConfiguredFeature("lament_twisty_tree1", BYGFeatures.LAMENT_TWISTY_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE2 = createConfiguredFeature("lament_twisty_tree2", BYGFeatures.LAMENT_TWISTY_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE3 = createConfiguredFeature("lament_twisty_tree3", BYGFeatures.LAMENT_TWISTY_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE1 = createConfiguredFeature("lament_weeping_tree1", BYGFeatures.LAMENT_WEEPING_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).setWhitelist(ImmutableList.of(Blocks.LAVA)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE2 = createConfiguredFeature("lament_weeping_tree2", BYGFeatures.LAMENT_WEEPING_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).setWhitelist(ImmutableList.of(Blocks.LAVA)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE3 = createConfiguredFeature("lament_weeping_tree3", BYGFeatures.LAMENT_WEEPING_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).setWhitelist(ImmutableList.of(Blocks.LAVA)).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE1 = createConfiguredFeature("withering_oak_tree1", BYGFeatures.WITHERING_OAK_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WITHERING_OAK_LOG).setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE2 = createConfiguredFeature("withering_oak_tree2", BYGFeatures.WITHERING_OAK_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WITHERING_OAK_LOG).setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE3 = createConfiguredFeature("withering_oak_tree3", BYGFeatures.WITHERING_OAK_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WITHERING_OAK_LOG).setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE4 = createConfiguredFeature("withering_oak_tree4", BYGFeatures.WITHERING_OAK_TREE4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WITHERING_OAK_LOG).setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE5 = createConfiguredFeature("withering_oak_tree5", BYGFeatures.WITHERING_OAK_TREE5.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WITHERING_OAK_LOG).setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    //Nether Features
    public static final ConfiguredFeature<BYGTreeConfig, ?> WAILING_PILLAR1 = createConfiguredFeature("wailing_pillar1", BYGFeatures.WAILING_PILLAR1.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.BASALT.defaultBlockState(), 8).add(Blocks.POLISHED_BASALT.defaultBlockState(), 2))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 4).add(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3).add(Blocks.BLACKSTONE.defaultBlockState(), 2).add(BYGBlocks.DUSTED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3))).setMaxHeight(30).setMinHeight(22).build()));

    //End Mushrooms
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_BUSH1 = createConfiguredFeature("bulbis_bush1", BYGFeatures.BULBIS_BUSH1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE1 = createConfiguredFeature("bulbis_tree1", BYGFeatures.BULBIS_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE2 = createConfiguredFeature("bulbis_tree2", BYGFeatures.BULBIS_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE3 = createConfiguredFeature("bulbis_tree3", BYGFeatures.BULBIS_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE4 = createConfiguredFeature("bulbis_tree4", BYGFeatures.BULBIS_TREE4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE5 = createConfiguredFeature("bulbis_tree5", BYGFeatures.BULBIS_TREE5.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE6 = createConfiguredFeature("bulbis_tree6", BYGFeatures.BULBIS_TREE6.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE7 = createConfiguredFeature("bulbis_tree7", BYGFeatures.BULBIS_TREE7.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_BUSH1 = createConfiguredFeature("purple_bulbis_bush1", BYGFeatures.BULBIS_BUSH1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE1 = createConfiguredFeature("purple_bulbis_tree1", BYGFeatures.BULBIS_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE2 = createConfiguredFeature("purple_bulbis_tree2", BYGFeatures.BULBIS_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE3 = createConfiguredFeature("purple_bulbis_tree3", BYGFeatures.BULBIS_TREE3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE4 = createConfiguredFeature("purple_bulbis_tree4", BYGFeatures.BULBIS_TREE4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE5 = createConfiguredFeature("purple_bulbis_tree5", BYGFeatures.BULBIS_TREE5.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE6 = createConfiguredFeature("purple_bulbis_tree6", BYGFeatures.BULBIS_TREE6.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE7 = createConfiguredFeature("purple_bulbis_tree7", BYGFeatures.BULBIS_TREE7.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));

    //End Trees
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_BUSH1 = createConfiguredFeature("ether_bush1", BYGFeatures.ETHER_BUSH1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_BUSH2 = createConfiguredFeature("ether_bush2", BYGFeatures.ETHER_BUSH2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE1 = createConfiguredFeature("ether_tree1", BYGFeatures.ETHER_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE2 = createConfiguredFeature("ether_tree2", BYGFeatures.ETHER_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE3 = createConfiguredFeature("ether_tree3", BYGFeatures.ETHER_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE4 = createConfiguredFeature("ether_tree4", BYGFeatures.ETHER_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE5 = createConfiguredFeature("ether_tree5", BYGFeatures.ETHER_TREE5.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD1 = createConfiguredFeature("ether_tree_dead1", BYGFeatures.DEAD_ETHER_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_WOOD).setLeavesBlock(Blocks.AIR).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD2 = createConfiguredFeature("ether_tree_dead2", BYGFeatures.DEAD_ETHER_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_WOOD).setLeavesBlock(Blocks.AIR).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD3 = createConfiguredFeature("ether_tree_dead3", BYGFeatures.DEAD_ETHER_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_WOOD).setLeavesBlock(Blocks.AIR).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_BUSH1 = createConfiguredFeature("nightshade_bush1", BYGFeatures.NIGHTSHADE_BUSH1.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_BUSH2 = createConfiguredFeature("nightshade_bush2", BYGFeatures.NIGHTSHADE_BUSH2.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE1 = createConfiguredFeature("nightshade_tree1", BYGFeatures.NIGHTSHADE_TREE1.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE2 = createConfiguredFeature("nightshade_tree2", BYGFeatures.NIGHTSHADE_TREE2.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE3 = createConfiguredFeature("nightshade_tree3", BYGFeatures.NIGHTSHADE_TREE3.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(33).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE4 = createConfiguredFeature("nightshade_tree4", BYGFeatures.NIGHTSHADE_TREE4.configured(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.NIGHTSHADE_LOG.defaultBlockState(), 9).add(BYGBlocks.IMBUED_NIGHTSHADE_LOG.defaultBlockState(), 1))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.defaultBlockState(), 3).add(BYGBlocks.NIGHTSHADE_LEAVES.defaultBlockState(), 8))).setMaxHeight(30).setMinHeight(44).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SHULKREN_TREE1 = createConfiguredFeature("shulkren_tree1", BYGFeatures.SHULKREN_TREE1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SHULKREN_TREE2 = createConfiguredFeature("shulkren_tree2", BYGFeatures.SHULKREN_TREE2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM1 = createConfiguredFeature("imparius_mushroom1", BYGFeatures.IMPARIUS_MUSHROOM1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM2 = createConfiguredFeature("imparius_mushroom2", BYGFeatures.IMPARIUS_MUSHROOM2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM3 = createConfiguredFeature("imparius_mushroom3", BYGFeatures.IMPARIUS_MUSHROOM3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM4 = createConfiguredFeature("imparius_mushroom4", BYGFeatures.IMPARIUS_MUSHROOM4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM5 = createConfiguredFeature("imparius_mushroom5", BYGFeatures.IMPARIUS_MUSHROOM5.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> IMPARIUS_MUSHROOM6 = createConfiguredFeature("imparius_mushroom6", BYGFeatures.IMPARIUS_MUSHROOM6.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.IMPARIUS_STEM).setMushroomBlock(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS1 = createConfiguredFeature("fungal_imparius1", BYGFeatures.FUNGAL_IMPARIUS1.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM).setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS2 = createConfiguredFeature("fungal_imparius2", BYGFeatures.FUNGAL_IMPARIUS2.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM).setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS3 = createConfiguredFeature("fungal_imparius3", BYGFeatures.FUNGAL_IMPARIUS3.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM).setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS4 = createConfiguredFeature("fungal_imparius4", BYGFeatures.FUNGAL_IMPARIUS4.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM).setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> FUNGAL_IMPARIUS5 = createConfiguredFeature("fungal_imparius5", BYGFeatures.FUNGAL_IMPARIUS5.configured(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.FUNGAL_IMPARIUS_STEM).setMushroomBlock(BYGBlocks.FUNGAL_IMPARIUS_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<DiskConfiguration, ?> DISK_MUD = createConfiguredFeature("disk_mud", Feature.DISK.configured(new DiskConfiguration(BYGBlocks.MUD_BLOCK.defaultBlockState(), UniformInt.of(2, 3), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.CLAY.defaultBlockState()))));


//    /***********************************************************Configured Placement***********************************************************/


    public static final ConfiguredFeature<?, ?> AUTUMNAL_OAK_TREES = createConfiguredFeature("autumnal_oak_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(RED_OAK_TREES.placed(), 0.25F),
            new WeightedPlacedFeature(BROWN_OAK_TREES.placed(), 0.25F),
            new WeightedPlacedFeature(ORANGE_OAK_TREES.placed(), 0.25F)),
            OAK_TREES.placed())));

    public static final ConfiguredFeature<?, ?> HUGE_MUSHROOMS = createConfiguredFeature("huge_mushrooms", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(GREEN_MUSHROOM_HUGE.placed(), 0.35F),
            new WeightedPlacedFeature(WOOD_BLEWIT_HUGE.placed(), 0.35F),
            new WeightedPlacedFeature(WEEPING_MILKCAP_HUGE.placed(), 0.35F)),
            GREEN_MUSHROOM_HUGE.placed())));

    public static final ConfiguredFeature<?, ?> BULBIS_TREES = createConfiguredFeature("bulbis_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BULBIS_BUSH1.placed(), 0.14285f),
            new WeightedPlacedFeature(BULBIS_TREE1.placed(), 0.14285f),
            new WeightedPlacedFeature(BULBIS_TREE2.placed(), 0.14285f),
            new WeightedPlacedFeature(BULBIS_TREE3.placed(), 0.14285f),
            new WeightedPlacedFeature(BULBIS_TREE4.placed(), 0.14285f),
            new WeightedPlacedFeature(BULBIS_TREE5.placed(), 0.14285f),
            new WeightedPlacedFeature(BULBIS_TREE6.placed(), 0.14285f)),
            BULBIS_TREE7.placed())));

    public static final ConfiguredFeature<?, ?> PURPLE_BULBIS_TREES = createConfiguredFeature("purple_bulbis_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(PURPLE_BULBIS_BUSH1.placed(), 0.14285f),
            new WeightedPlacedFeature(PURPLE_BULBIS_TREE1.placed(), 0.14285f),
            new WeightedPlacedFeature(PURPLE_BULBIS_TREE2.placed(), 0.14285f),
            new WeightedPlacedFeature(PURPLE_BULBIS_TREE3.placed(), 0.14285f),
            new WeightedPlacedFeature(PURPLE_BULBIS_TREE4.placed(), 0.14285f),
            new WeightedPlacedFeature(PURPLE_BULBIS_TREE5.placed(), 0.14285f),
            new WeightedPlacedFeature(PURPLE_BULBIS_TREE6.placed(), 0.14285f)),
            PURPLE_BULBIS_TREE7.placed())));

    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        ResourceLocation bygID = BYG.createLocation(id);
        if (BuiltinRegistries.CONFIGURED_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Configured Feature ID: \"" + bygID.toString() + "\" already exists in the Configured Features registry!");

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, bygID, configuredFeature);
        if (configuredFeature == null) {
            String s = "";
        }
        return configuredFeature;
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createFlowerConfiguredFeature(String id, Block flowerBlock) {
        return (CF) createConfiguredFeature(id, Feature.FLOWER.configured(invokeGrassPatch(SimpleStateProvider.simple(flowerBlock.defaultBlockState()), 15)));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createPatchConfiguredFeature(String id, Block block, int spread) {
        return (CF) createConfiguredFeature(id, Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(block))), List.of(), spread)));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createPatchConfiguredFeature(Block block, int spread) {
        return (CF) Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(block))), List.of(), spread));
    }

    public static BlockPredicateFilter createSolidDownAndAirAllAroundFilter(BlockPredicate... predicates) {
        return BlockPredicateFilter.forPredicate(BlockPredicate.allOf(new ImmutableList.Builder<BlockPredicate>().add(BlockPredicate.solid(BlockPos.ZERO.relative(Direction.DOWN)),
                        BlockPredicate.not(BlockPredicate.solid(BlockPos.ZERO.relative(Direction.WEST))),
                        BlockPredicate.not(BlockPredicate.solid(BlockPos.ZERO.relative(Direction.EAST))),
                        BlockPredicate.not(BlockPredicate.solid(BlockPos.ZERO.relative(Direction.NORTH))),
                        BlockPredicate.not(BlockPredicate.solid(BlockPos.ZERO.relative(Direction.SOUTH))),
                        BlockPredicate.not(BlockPredicate.solid(BlockPos.ZERO.relative(Direction.UP))))
                .add(BlockPredicate.matchesBlocks(List.of(Blocks.AIR, Blocks.CAVE_AIR)))
                .add(predicates).build()));
    }
}