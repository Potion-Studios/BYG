package potionstudios.byg.common.world.feature.features.overworld;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BlueBerryBush;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.config.PumpkinConfig;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;

import java.util.List;
import java.util.function.Supplier;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock;
import static potionstudios.byg.mixin.access.VegetationFeaturesAccess.byg_invokeGrassPatch;

public class BYGOverworldVegetationFeatures {
    private static final BlockPredicateFilter SAND_FILTER = BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(BlockPos.ZERO.below(), BlockTags.SAND));
    private static final BlockPredicateFilter ON_WATER_FILTER = BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(BlockPos.ZERO.below(), Fluids.WATER));
    private static final BlockPredicateFilter IN_REPLACEABLE_FILTER = BlockPredicateFilter.forPredicate(BlockPredicate.replaceable());

    public static final ResourceKey<ConfiguredFeature<?, ?>> ALLIUM_BUSH = createFlowerConfiguredFeature("allium_bush", BYGBlocks.ALLIUM_FLOWER_BUSH::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALLIUM_PINK_BUSH = createFlowerConfiguredFeature("pink_allium_bush", BYGBlocks.PINK_ALLIUM_FLOWER_BUSH::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALLIUM_TALL_BUSH = createPatchConfiguredFeatureWithBlock("tall_allium_bush", BYGBlocks.TALL_ALLIUM::get, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALLIUM_TALL_PINK_BUSH = createPatchConfiguredFeatureWithBlock("tall_pink_allium_bush", BYGBlocks.TALL_PINK_ALLIUM::get, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALOE_VERA = createPatchConfiguredFeatureWithBlock("aloe_vera", BYGBlocks.ALOE_VERA::get, 6);

    public static final ResourceKey<ConfiguredFeature<?, ?>> DUNE_TERRAIN = createConfiguredFeature("dune_terrain", BYGFeatures.DUNE_TERRAIN, () -> FeatureConfiguration.NONE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMARANTH = createFlowerConfiguredFeature("amaranth", BYGBlocks.AMARANTH::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMARANTH_MAGENTA = createFlowerConfiguredFeature("magenta_amaranth", BYGBlocks.MAGENTA_AMARANTH::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMARANTH_ORANGE = createFlowerConfiguredFeature("orange_amaranth", BYGBlocks.ORANGE_AMARANTH::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMARANTH_PURPLE = createFlowerConfiguredFeature("purple_amaranth", BYGBlocks.PURPLE_AMARANTH::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMARANTH_CYAN = createFlowerConfiguredFeature("cyan_amaranth", BYGBlocks.CYAN_AMARANTH::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> FIRECRACKER_BUSH = createFlowerConfiguredFeature("firecracker_bush", BYGBlocks.FIRECRACKER_FLOWER_BUSH::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHRUB = createPatchConfiguredFeatureWithBlock("shrub", BYGBlocks.SHRUB::get, 4);
    public static final ResourceKey<ConfiguredFeature<?, ?>> MINI_CACTI = createPatchConfiguredFeatureWithBlock("mini_cacti", BYGBlocks.MINI_CACTUS::get, 4);
    public static final ResourceKey<ConfiguredFeature<?, ?>> BARREL_CACTI = createPatchConfiguredFeatureWithBlock("barrel_cacti", BYGBlocks.BARREL_CACTUS::get, 4);
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_BARREL_CACTI = createPatchConfiguredFeatureWithBlock("flowering_barrel_cacti", BYGBlocks.FLOWERING_BARREL_CACTUS::get, 4);
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOVER_PATCH = createFlowerConfiguredFeature("clover_patch", BYGBlocks.CLOVER_PATCH::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PATCH = createFlowerConfiguredFeature("flower_patch", BYGBlocks.FLOWER_PATCH::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALIFORNIA_POPPY = createFlowerConfiguredFeature("california_poppy", BYGBlocks.CALIFORNIA_POPPY::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_PUFFBALL = createFlowerConfiguredFeature("white_puffball", BYGBlocks.WHITE_PUFFBALL::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> WEEPING_MILKCAP = createFlowerConfiguredFeature("weeping_milkcap", BYGBlocks.WEEPING_MILKCAP::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> WOOD_BLEWIT = createFlowerConfiguredFeature("wood_blewit", BYGBlocks.WOOD_BLEWIT::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_MUSHROOM = createFlowerConfiguredFeature("green_mushroom", BYGBlocks.GREEN_MUSHROOM::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEGONIA = createFlowerConfiguredFeature("begonia", BYGBlocks.BEGONIA::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> BISTORT = createFlowerConfiguredFeature("bistort", BYGBlocks.BISTORT::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> GUZMANIA = createFlowerConfiguredFeature("guzmania", BYGBlocks.GUZMANIA::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> INCAN_LILY = createFlowerConfiguredFeature("incan_lily", BYGBlocks.INCAN_LILY::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAZARUS_BELLFLOWER = createFlowerConfiguredFeature("lazarus_bellflower", BYGBlocks.LAZARUS_BELLFLOWER::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> TORCH_GINGER = createFlowerConfiguredFeature("torch_ginger", BYGBlocks.TORCH_GINGER::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> WINTER_SUCCULENT = createPatchConfiguredFeatureWithBlock("winter_succulent", BYGBlocks.WINTER_SUCCULENT::get, 10);
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACH_GRASS = createPatchConfiguredFeatureWithBlock("beach_grass_patch", BYGBlocks.BEACH_GRASS::get, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_BEACH_GRASS_PATCH = createPatchConfiguredFeatureWithBlock("tall_beach_grass_patch", BYGBlocks.TALL_BEACH_GRASS::get, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAF_PILE = createPatchConfiguredFeatureWithBlock("leaf_pile", BYGBlocks.LEAF_PILE::get, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> RICHEA = createFlowerConfiguredFeature("richea", BYGBlocks.RICHEA::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> PRAIRIE_GRASS_PATCH = createPatchConfiguredFeatureWithBlock("prairie_grass_patch", BYGBlocks.PRAIRIE_GRASS::get, 100);
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_PRAIRIE_GRASS_PATCH = createPatchConfiguredFeatureWithBlock("tall_prairie_grass_patch", BYGBlocks.TALL_PRAIRIE_GRASS::get, 100);
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_ROSE_BUSH = createPatchConfiguredFeatureWithBlock("blue_rose_bush", BYGBlocks.BLUE_ROSE_BUSH::get, 5);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSE_BUSH = createPatchConfiguredFeatureWithBlock("rose_bush", () -> Blocks.ROSE_BUSH, 5);
    public static final ResourceKey<ConfiguredFeature<?, ?>> JAPANESE_ORCHID = createFlowerConfiguredFeature("japanese_orchid", BYGBlocks.JAPANESE_ORCHID::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOXGLOVE = createFlowerConfiguredFeature("foxglove", BYGBlocks.FOXGLOVE::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_INDIGO_JACARANDA_BUSH = createPatchConfiguredFeatureWithBlock("flowering_indigo_jacaranda_bush", BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH::get, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> INDIGO_JACARANDA_BUSH = createPatchConfiguredFeatureWithBlock("indigo_jacaranda_bush", BYGBlocks.INDIGO_JACARANDA_BUSH::get, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_JACARANDA_BUSH = createPatchConfiguredFeatureWithBlock("flowering_jacaranda_bush", BYGBlocks.FLOWERING_JACARANDA_BUSH::get, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA_BUSH = createPatchConfiguredFeatureWithBlock("jacaranda_bush", BYGBlocks.JACARANDA_BUSH::get, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> PRICKLY_PEAR_CACTI = createPatchConfiguredFeatureWithBlock("prickly_pear_cacti", BYGBlocks.PRICKLY_PEAR_CACTUS::get, 5);
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_SPINED_CACTI = createPatchConfiguredFeatureWithBlock("golden_spined_cacti", BYGBlocks.GOLDEN_SPINED_CACTUS::get, 5);
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_CHERRY_FOLIAGE = createPatchConfiguredFeatureWithBlock("pink_cherry_foliage", BYGBlocks.PINK_CHERRY_FOLIAGE::get, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_CHERRY_FOLIAGE = createPatchConfiguredFeatureWithBlock("white_cherry_foliage", BYGBlocks.WHITE_CHERRY_FOLIAGE::get, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLUEBERRY = createPatchConfiguredFeatureState("blue_berry_bush", () -> BYGBlocks.BLUEBERRY_BUSH.defaultBlockState().setValue(BlueBerryBush.AGE, 3), 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSE = createFlowerConfiguredFeature("rose", BYGBlocks.ROSE::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> CROCUS = createFlowerConfiguredFeature("crocus", BYGBlocks.CROCUS::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> IRIS = createFlowerConfiguredFeature("iris", BYGBlocks.IRIS::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANEMONE_WHITE = createFlowerConfiguredFeature("white_anemone", BYGBlocks.WHITE_ANEMONE::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANEMONE_PINK = createFlowerConfiguredFeature("pink_anemone", BYGBlocks.PINK_ANEMONE::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSE_WINTER = createFlowerConfiguredFeature("winter_rose", BYGBlocks.WINTER_ROSE::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALLIUM_PINK = createFlowerConfiguredFeature("allium_pink", BYGBlocks.PINK_ALLIUM::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> DAISY_ORANGE = createFlowerConfiguredFeature("orange_daisy", BYGBlocks.ORANGE_DAISY::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> HYDRANGEA_BUSH = createFlowerConfiguredFeature("hydrangea_bush", BYGBlocks.HYDRANGEA_BUSH::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> HYDRANGEA_HEDGE = createFlowerConfiguredFeature("hydrangea_hedge", BYGBlocks.HYDRANGEA_HEDGE::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAGE_WHITE = createFlowerConfiguredFeature("white_sage", BYGBlocks.WHITE_SAGE::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAGE_PURPLE = createFlowerConfiguredFeature("purple_sage", BYGBlocks.PURPLE_SAGE::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAGE_BLUE = createFlowerConfiguredFeature("blue_sage", BYGBlocks.BLUE_SAGE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> DAFFODIL_YELLOW = createFlowerConfiguredFeature("yellow_daffodil", BYGBlocks.YELLOW_DAFFODIL::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALPINE_BELLFLOWER = createFlowerConfiguredFeature("alpine_bellflower", BYGBlocks.ALPINE_BELLFLOWER::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> KOVAN_FLOWER = createFlowerConfiguredFeature("kovan_flower", BYGBlocks.KOVAN_FLOWER::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> TULIP_GREEN = createFlowerConfiguredFeature("green_tulip", BYGBlocks.GREEN_TULIP::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> TULIP_CYAN = createFlowerConfiguredFeature("cyan_tulip", BYGBlocks.CYAN_TULIP::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> TULIP_MAGENTA = createFlowerConfiguredFeature("magenta_tulip", BYGBlocks.MAGENTA_TULIP::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> TULIP_PURPLE = createFlowerConfiguredFeature("purple_tulip", BYGBlocks.PURPLE_TULIP::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> TULIP_YELLOW = createFlowerConfiguredFeature("yellow_tulip", BYGBlocks.YELLOW_TULIP::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> CATTAIL = createPatchConfiguredFeatureWithBlock("cattail", BYGBlocks.CATTAIL::get, 32);
    public static final ResourceKey<ConfiguredFeature<?, ?>> LOLLIPOP_FLOWER = createFlowerConfiguredFeature("lollipop_flower", BYGBlocks.LOLLIPOP_FLOWER::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEATHER_FLOWER_PEACH = createFlowerConfiguredFeature("peach_leather_flower", BYGBlocks.PEACH_LEATHER_FLOWER::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEATHER_FLOWER_VIOLET = createFlowerConfiguredFeature("violet_leather_flower", BYGBlocks.VIOLET_LEATHER_FLOWER::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACK_ROSE = createFlowerConfiguredFeature("black_rose", BYGBlocks.BLACK_ROSE::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYAN_ROSE = createFlowerConfiguredFeature("cyan_rose", BYGBlocks.CYAN_ROSE::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSE_OSIRIA = createFlowerConfiguredFeature("osiria_rose", BYGBlocks.ORSIRIA_ROSE::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> FAIRY_SLIPPER = createFlowerConfiguredFeature("fairy_slipper", BYGBlocks.FAIRY_SLIPPER::get);
    public static final ResourceKey<ConfiguredFeature<?, ?>> HORSEWEED = createPatchConfiguredFeatureWithBlock("horseweed", BYGBlocks.HORSEWEED::get, 10);

    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACH_GRASSES = createConfiguredFeature("beach_grasses",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TALL_BEACH_GRASS_PATCH), SAND_FILTER), 0.33F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BEACH_GRASS), SAND_FILTER)
                );
            }
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> AMARANTH_FIELD_FLOWERS = createConfiguredFeature("amaranth_field_flowers",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(AMARANTH)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(AMARANTH_MAGENTA)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(AMARANTH_ORANGE)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(AMARANTH_PURPLE)), 0.2F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(AMARANTH_CYAN)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> TINY_LILY_PAD = createConfiguredFeature("tiny_lily_pad",
            () -> Feature.RANDOM_PATCH,
            () -> new RandomPatchConfiguration(10, 7, 3,
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.TINY_LILYPADS.get()))), ON_WATER_FILTER, IN_REPLACEABLE_FILTER)
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_TINY_LILY_PAD = createConfiguredFeature("flowering_tiny_lily_pad",
            () -> Feature.RANDOM_PATCH,
            () -> new RandomPatchConfiguration(10, 7, 3,
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.FLOWERING_TINY_LILY_PADS.get()))), ON_WATER_FILTER, IN_REPLACEABLE_FILTER)
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_SILK = createConfiguredFeature("water_silk",
            () -> Feature.RANDOM_PATCH,
            () -> new RandomPatchConfiguration(10, 7, 3,
                    BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.WATER_SILK.get()))), ON_WATER_FILTER, IN_REPLACEABLE_FILTER)
            )
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ALLIUM_FIELD_FLOWERS = createConfiguredFeature("allium_field_flowers",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ALLIUM_TALL_BUSH)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ALLIUM_TALL_PINK_BUSH)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ALLIUM_BUSH)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ALLIUM_PINK_BUSH)));
            }
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSE_FIELD_FLOWERS = createConfiguredFeature("rose_field_flowers",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ROSE_OSIRIA)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BLUE_ROSE_BUSH)), 0.3F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ROSE)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ROSE_BUSH)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DESERT_VEGETATION = createConfiguredFeature("desert_vegetation",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MINI_CACTI)), 0.3F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PRICKLY_PEAR_CACTI)), 0.3F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ALOE_VERA)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FIRECRACKER_BUSH)), 0.1F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GOLDEN_SPINED_CACTI)));
            }
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> WINDSWEPT_DESERT_VEGETATION = createConfiguredFeature("windswept_desert_vegetation",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MINI_CACTI), SAND_FILTER), 0.15F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PRICKLY_PEAR_CACTI), SAND_FILTER), 0.15F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(VegetationFeatures.PATCH_CACTUS), SAND_FILTER), 0.15F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ALOE_VERA), SAND_FILTER), 0.3F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GOLDEN_SPINED_CACTI), SAND_FILTER));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DESERT_VEGETATION_ATACAMA = createConfiguredFeature("desert_vegetation_atacama",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(MINI_CACTI)), 0.15F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PRICKLY_PEAR_CACTI)), 0.15F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ALOE_VERA)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FLOWERING_BARREL_CACTI)), 0.15F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BARREL_CACTI)), 0.15F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GOLDEN_SPINED_CACTI)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PRAIRIE_GRASS = createConfiguredFeature("prairie_grass",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PRAIRIE_GRASS_PATCH)), 0.75F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TALL_PRAIRIE_GRASS_PATCH)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOMS = createConfiguredFeature("mushrooms",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WOOD_BLEWIT)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WEEPING_MILKCAP)), 0.33F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GREEN_MUSHROOM)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_FLOWERS = createConfiguredFeature("jungle_flowers",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BISTORT)), 0.142F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GUZMANIA)), 0.142F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BEGONIA)), 0.142F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(LAZARUS_BELLFLOWER)), 0.142F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RICHEA)), 0.142F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TORCH_GINGER)), 0.142F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(INCAN_LILY)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> JACARANDA_BUSHES = createConfiguredFeature("jacaranda_bushes",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FLOWERING_INDIGO_JACARANDA_BUSH)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FLOWERING_JACARANDA_BUSH)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(INDIGO_JACARANDA_BUSH)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(JACARANDA_BUSH)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SWAMP_WATER_VEGETATION = createConfiguredFeature("swamp_water_vegetation",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TINY_LILY_PAD), ON_WATER_FILTER), 0.50F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WATER_SILK), ON_WATER_FILTER));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_MANGROVE_SWAMP_WATER_VEGETATION = createConfiguredFeature("white_white_mangrove_swamp_water_vegetation",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TINY_LILY_PAD), ON_WATER_FILTER), 0.50F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FLOWERING_TINY_LILY_PAD), ON_WATER_FILTER));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_FOLIAGE = createConfiguredFeature("cherry_foliage",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WHITE_CHERRY_FOLIAGE)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PINK_CHERRY_FOLIAGE)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOVER_AND_FLOWERS = createConfiguredFeature("clovers_and_flowers",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(FLOWER_PATCH)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(CLOVER_PATCH)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ANEMONES = createConfiguredFeature("anemones",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ANEMONE_PINK)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(ANEMONE_WHITE)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SAGES = createConfiguredFeature("sages",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SAGE_BLUE)), 0.33F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SAGE_PURPLE)), 0.33F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SAGE_WHITE)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> HYDRANGEAS = createConfiguredFeature("hydrangeas",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(HYDRANGEA_BUSH)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(HYDRANGEA_HEDGE)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> TULIPS = createConfiguredFeature("tulips",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TULIP_MAGENTA)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TULIP_YELLOW)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TULIP_PURPLE)), 0.2F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TULIP_CYAN)), 0.2F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(TULIP_GREEN)));
            }
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> PUMPKIN1 = createConfiguredFeature("pumpkin1",
            BYGFeatures.LARGE_PUMPKIN1,
            () -> new PumpkinConfig.Builder()
                    .setPumpkinBlock(Blocks.PUMPKIN)
                    .build()
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> PUMPKIN2 = createConfiguredFeature("pumpkin2",
            BYGFeatures.LARGE_PUMPKIN2,
            () -> new PumpkinConfig.Builder()
                    .setPumpkinBlock(Blocks.PUMPKIN).setStemBlock(Blocks.DARK_OAK_LOG)
                    .setLeavesBlock(Blocks.DARK_OAK_LEAVES)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_PUMPKINS = createConfiguredFeature("large_pumpkin",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PUMPKIN1)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(PUMPKIN2)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> LEATHER_FLOWERS = createConfiguredFeature("leather_flowers",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(LEATHER_FLOWER_PEACH)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(LEATHER_FLOWER_VIOLET)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_MUSHROOM_HUGE = createConfiguredFeature("huge_green_mushroom",
            BYGFeatures.GREEN_MUSHROOM_HUGE,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> WOOD_BLEWIT_HUGE = createConfiguredFeature("huge_wood_blewit",
            BYGFeatures.WOOD_BLEWIT_HUGE,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> WEEPING_MILKCAP_HUGE = createConfiguredFeature("huge_weeping_milkcap",
            BYGFeatures.WEEPING_MILKCAP_HUGE,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.MUSHROOM_STEM)
                    .setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_MUSHROOM_MINI = createConfiguredFeature("mini_green_mushroom",
            BYGFeatures.MINI_GREEN_MUSHROOM,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK.get())
                    .setMinHeight(3)
                    .setMaxHeight(3)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> WOOD_BLEWIT_MINI = createConfiguredFeature("mini_wood_blewit",
            BYGFeatures.MINI_WOOD_BLEWIT,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK.get())
                    .setMinHeight(2)
                    .setMaxHeight(3)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> WEEPING_MILKCAP_MINI = createConfiguredFeature("mini_weeping_milkcap",
            BYGFeatures.MINI_WEEPING_MILKCAP,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.MUSHROOM_STEM)
                    .setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK.get())
                    .setMinHeight(2)
                    .setMaxHeight(3)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MUSHROOM_MINI = createConfiguredFeature("mini_red_mushroom",
            BYGFeatures.MINI_RED_MUSHROOM,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.MUSHROOM_STEM)
                    .setMushroomBlock(Blocks.RED_MUSHROOM_BLOCK)
                    .setMinHeight(2)
                    .setMaxHeight(3)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_MUSHROOM_MINI = createConfiguredFeature("mini_brown_mushroom",
            BYGFeatures.MINI_BROWN_MUSHROOM,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.MUSHROOM_STEM)
                    .setMushroomBlock(Blocks.BROWN_MUSHROOM_BLOCK)
                    .setMinHeight(2)
                    .setMaxHeight(3)
                    .build()
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_MUSHROOMS = createConfiguredFeature("huge_mushrooms",
            () -> Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);


                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GREEN_MUSHROOM_HUGE)), 0.35F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WOOD_BLEWIT_HUGE)), 0.35F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WEEPING_MILKCAP_HUGE)), 0.35F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GREEN_MUSHROOM_HUGE)));
            }
    );


    public static <FC extends FeatureConfiguration, F extends Feature<FC>> ResourceKey<ConfiguredFeature<?, ?>> createFlowerConfiguredFeature(String id, Supplier<? extends Block> flowerBlock) {
        return createConfiguredFeature(id, () -> Feature.FLOWER, () -> byg_invokeGrassPatch(SimpleStateProvider.simple(flowerBlock.get().defaultBlockState()), 15));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> createPatchConfiguredFeatureState(String id, Supplier<? extends BlockState> state, int tries) {
        return createConfiguredFeature(id, () -> Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(state.get())), List.of(), tries));
    }

    public static void loadClass() {
    }
}
