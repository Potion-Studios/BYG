package corgiaoc.byg.core.world;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import corgiaoc.byg.common.properties.blocks.BlueBerryBush;
import corgiaoc.byg.common.properties.blocks.end.TheriumCrystalBlock;
import corgiaoc.byg.common.properties.blocks.nether.crimson.CrimsonBerryBushBlock;
import corgiaoc.byg.common.world.decorator.config.AtOrBelowSeaLevelCountExtraConfig;
import corgiaoc.byg.common.world.feature.blockplacer.DoubleBlockPlacer;
import corgiaoc.byg.common.world.feature.config.*;
import corgiaoc.byg.config.BYGWorldConfig;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.LanternBlock;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

import static corgiaoc.byg.core.world.util.WorldGenRegistrationHelper.createConfiguredFeature;

public class BYGConfiguredFeatures {

    /***********************************************************Configured Features***********************************************************/

    public static final ConfiguredFeature<?, ?> ALLIUM_BUSH = createConfiguredFeature("allium_bush", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.ALLIUM_FLOWER_BUSH.getDefaultState()), new SimpleBlockPlacer())).tries(100).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ALLIUM_PINK_BUSH = createConfiguredFeature("pink_allium_bush", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH.getDefaultState()), new SimpleBlockPlacer())).tries(100).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ALLIUM_TALL_BUSH = createConfiguredFeature("tall_allium_bush", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.TALL_ALLIUM.getDefaultState()), new DoublePlantBlockPlacer())).tries(100).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ALLIUM_TALL_PINK_BUSH = createConfiguredFeature("tall_pink_allium_bush", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.TALL_PINK_ALLIUM.getDefaultState()), new DoublePlantBlockPlacer())).tries(100).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> AMARANTH = createConfiguredFeature("amaranth", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.AMARANTH.getDefaultState()), new SimpleBlockPlacer())).tries(100).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> AMARANTH_MAGENTA = createConfiguredFeature("magenta_amaranth", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.MAGENTA_AMARANTH.getDefaultState()), new SimpleBlockPlacer())).tries(100).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> AMARANTH_ORANGE = createConfiguredFeature("orange_amaranth", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.ORANGE_AMARANTH.getDefaultState()), new SimpleBlockPlacer())).tries(100).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> AMARANTH_PURPLE = createConfiguredFeature("purple_amaranth", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PURPLE_AMARANTH.getDefaultState()), new SimpleBlockPlacer())).tries(100).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> AMARANTH_CYAN = createConfiguredFeature("cyan_amaranth", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.CYAN_AMARANTH.getDefaultState()), new SimpleBlockPlacer())).tries(100).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> SHORT_GRASS = createConfiguredFeature("short_grass_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.SHORT_GRASS.getDefaultState()), new SimpleBlockPlacer())).tries(24).build()));
    public static final ConfiguredFeature<?, ?> NYLIUM_SOUL_FIRE_PATCH = createConfiguredFeature("nylium_soul_fire_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.SOUL_FIRE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(Blocks.SOUL_SOIL, BYGBlocks.NYLIUM_SOUL_SOIL, BYGBlocks.BRIMSTONE, BYGBlocks.FROST_MAGMA)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> BORIC_FIRE_PATCH = createConfiguredFeature("boric_fire_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BORIC_FIRE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.BRIMSTONE, BYGBlocks.BRIMSTONE, BYGBlocks.BRIMSTONE, BYGBlocks.FROST_MAGMA)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> MAGMA_FIRE_PATCH = createConfiguredFeature("magma_fire_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.FIRE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MAGMATIC_STONE, Blocks.MAGMA_BLOCK, BYGBlocks.QUARTZITE_SAND)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> SUBZERO_ASH = createConfiguredFeature("subzero_ash", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.SUBZERO_ASH.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.SUBZERO_ASH_BLOCK, BYGBlocks.FROST_MAGMA)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> SUBZERO_ASH_BLOCK = createConfiguredFeature("subzero_ash_block", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.SUBZERO_ASH_BLOCK.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.SUBZERO_ASH_BLOCK, BYGBlocks.FROST_MAGMA)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> QUARTZ_CRYSTAL = createConfiguredFeature("quartz_crystal", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.QUARTZ_CRYSTAL.getDefaultState(), ImmutableList.of(BYGBlocks.QUARTZITE_SAND.getDefaultState(), BYGBlocks.RAW_QUARTZ_BLOCK.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), BYGBlocks.QUARTZITE_SAND.getDefaultState(), BYGBlocks.RAW_QUARTZ_BLOCK.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> CRYPTIC_FIRE_PATCH = createConfiguredFeature("cryptic_fire_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.CRYPTIC_FIRE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.CRYPTIC_STONE, BYGBlocks.CRYPTIC_MAGMA_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> CRYPTIC_VENT = createConfiguredFeature("cryptic_vent", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.CRYPTIC_VENT.getDefaultState()), new SimpleBlockPlacer())).tries(24).whitelist(ImmutableSet.of(BYGBlocks.CRYPTIC_STONE, BYGBlocks.CRYPTIC_MAGMA_BLOCK)).build()));
    public static final ConfiguredFeature<?, ?> TALL_CRYPTIC_VENT = createConfiguredFeature("tall_cryptic_vent", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.TALL_CRYPTIC_VENT.getDefaultState()), new DoubleBlockPlacer())).tries(24).whitelist(ImmutableSet.of(BYGBlocks.CRYPTIC_STONE, BYGBlocks.CRYPTIC_MAGMA_BLOCK)).build()));

    public static final ConfiguredFeature<?, ?> BEEHIVES = createConfiguredFeature("beehives", BYGFeatures.BEEHIVE.withConfiguration(new NoFeatureConfig()).range(256).square().func_242731_b(10));
    public static final ConfiguredFeature<?, ?> ETHER_BULBS = createConfiguredFeature("ether_bulbs", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.ETHER_BULB.getDefaultState(), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(BYGBlocks.ETHER_LEAVES.getDefaultState()))).range(256).square().func_242731_b(55));

    //Giant Flowers
    public static final ConfiguredFeature<GiantFlowerConfig, ?> GIANT_ANGELICA_FLOWER = createConfiguredFeature("giant_angelica", BYGFeatures.GIANT_ANGELICA_FLOWER.withConfiguration(new GiantFlowerConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.WHITE_PETAL).setMaxHeight(18).setMinHeight(12).build()));
    public static final ConfiguredFeature<GiantFlowerConfig, ?> GIANT_DANDELION_FLOWER = createConfiguredFeature("giant_dandelion", BYGFeatures.GIANT_DANDELION_FLOWER.withConfiguration(new GiantFlowerConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.RED_PETAL).setPetal2Block(BYGBlocks.YELLOW_PETAL).setMaxHeight(12).setMinHeight(6).build()));
    public static final ConfiguredFeature<GiantFlowerConfig, ?> GIANT_IRIS_FLOWER = createConfiguredFeature("giant_iris", BYGFeatures.GIANT_IRIS_FLOWER.withConfiguration(new GiantFlowerConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.PURPLE_PETAL).setPetal2Block(BYGBlocks.YELLOW_PETAL).setMaxHeight(12).setMinHeight(6).build()));
    public static final ConfiguredFeature<GiantFlowerConfig, ?> GIANT_ROSE_FLOWER = createConfiguredFeature("giant_rose", BYGFeatures.GIANT_ROSE_FLOWER.withConfiguration(new GiantFlowerConfig.Builder().setStemBlock(BYGBlocks.PLANT_STEM).setPetalBlock(BYGBlocks.RED_PETAL).setMaxHeight(12).setMinHeight(6).build()));


    public static final ConfiguredFeature<?, ?> MINI_CACTI = createConfiguredFeature("mini_cacti", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.MINI_CACTUS.getDefaultState()), new SimpleBlockPlacer())).tries(4).build()));
    public static final ConfiguredFeature<?, ?> HORSEWEED = createConfiguredFeature("horse_weed", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.HORSEWEED.getDefaultState()), new SimpleBlockPlacer())).tries(4).build()));
    public static final ConfiguredFeature<?, ?> TINY_LILY_PAD = createConfiguredFeature("tiny_lily_pad", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.TINY_LILYPADS.getDefaultState()), new SimpleBlockPlacer())).tries(10).build()));
    public static final ConfiguredFeature<?, ?> WATER_SILK = createConfiguredFeature("water_silk", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WATER_SILK.getDefaultState()), new SimpleBlockPlacer())).tries(128).build()));
    public static final ConfiguredFeature<?, ?> WINTER_SUCCULENT = createConfiguredFeature("winter_succulent", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WINTER_SUCCULENT.getDefaultState()), new SimpleBlockPlacer())).tries(10).build()));
    public static final ConfiguredFeature<?, ?> BEACH_GRASS = createConfiguredFeature("beach_grass_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BEACH_GRASS.getDefaultState()), new SimpleBlockPlacer())).tries(20).build()));
    public static final ConfiguredFeature<?, ?> BEACH_SHORT_GRASS_PATCH = createConfiguredFeature("short_beach_grass_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.SHORT_BEACH_GRASS.getDefaultState()), new SimpleBlockPlacer())).tries(20).build()));
    public static final ConfiguredFeature<?, ?> WILTED_GRASS_PATCH = createConfiguredFeature("wilted_grass_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WILTED_GRASS.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));
    public static final ConfiguredFeature<?, ?> LEAF_PILE = createConfiguredFeature("leaf_pile", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.LEAF_PILE.getDefaultState()), new SimpleBlockPlacer())).tries(14).build()));
    public static final ConfiguredFeature<?, ?> CLOVER_PATCH = createConfiguredFeature("clover_patch", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.CLOVER_PATCH.getDefaultState()), new SimpleBlockPlacer())).tries(14).build()));
    public static final ConfiguredFeature<?, ?> FLOWER_PATCH = createConfiguredFeature("flower_patch", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.FLOWER_PATCH.getDefaultState()), new SimpleBlockPlacer())).tries(14).build()));
    public static final ConfiguredFeature<?, ?> WEED_GRASS_PATCH = createConfiguredFeature("weed_grass_patch", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WEED_GRASS.getDefaultState()), new SimpleBlockPlacer())).tries(32).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> WINTER_GRASS_PATCH = createConfiguredFeature("winter_grass_patch", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WINTER_GRASS.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));
    public static final ConfiguredFeature<?, ?> CALIFORNIA_POPPY = createConfiguredFeature("california_poppy", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.CALIFORNIA_POPPY.getDefaultState()), new SimpleBlockPlacer())).tries(10).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> BLACK_PUFF = createConfiguredFeature("black_puff", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BLACK_PUFF.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> WEEPING_MILKCAP = createConfiguredFeature("weeping_milkcap", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WEEPING_MILKCAP.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> WOOD_BLEWIT = createConfiguredFeature("wood_blewit", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WOOD_BLEWIT.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> GREEN_MUSHROOM = createConfiguredFeature("green_mushroom", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.GREEN_MUSHROOM.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> BEGONIA = createConfiguredFeature("begonia", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BEGONIA.getDefaultState()), new SimpleBlockPlacer())).tries(10).build()));
    public static final ConfiguredFeature<?, ?> BISTORT = createConfiguredFeature("bistort", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BISTORT.getDefaultState()), new SimpleBlockPlacer())).tries(10).build()));
    public static final ConfiguredFeature<?, ?> GUZMANIA = createConfiguredFeature("guzmania", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.GUZMANIA.getDefaultState()), new SimpleBlockPlacer())).tries(10).build()));
    public static final ConfiguredFeature<?, ?> INCAN_LILY = createConfiguredFeature("incan_lily", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.INCAN_LILY.getDefaultState()), new SimpleBlockPlacer())).tries(10).build()));
    public static final ConfiguredFeature<?, ?> LAZARUS_BELLFLOWER = createConfiguredFeature("lazarus_bellflower", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.LAZARUS_BELLFLOWER.getDefaultState()), new SimpleBlockPlacer())).tries(10).build()));
    public static final ConfiguredFeature<?, ?> TORCH_GINGER = createConfiguredFeature("torch_ginger", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.TORCH_GINGER.getDefaultState()), new SimpleBlockPlacer())).tries(10).build()));
    public static final ConfiguredFeature<?, ?> RICHEA = createConfiguredFeature("richea", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.RICHEA.getDefaultState()), new SimpleBlockPlacer())).tries(10).build()));
    public static final ConfiguredFeature<?, ?> JAPANESE_ORCHID = createConfiguredFeature("japanese_orchid", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.JAPANESE_ORCHID.getDefaultState()), new DoublePlantBlockPlacer())).tries(10).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> AZALEA = createConfiguredFeature("azalea", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.AZALEA.getDefaultState()), new DoublePlantBlockPlacer())).tries(48).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> PRAIRIE_GRASS_PATCH = createConfiguredFeature("prairie_grass_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PRAIRIE_GRASS.getDefaultState()), new SimpleBlockPlacer())).tries(100).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> PRAIRIE_TALL_GRASS_PATCH = createConfiguredFeature("tall_prairie_grass_patch", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.TALL_PRAIRIE_GRASS.getDefaultState()), new DoublePlantBlockPlacer())).tries(100).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> BLUE_GLOWSHROOM = createConfiguredFeature("blue_glowshroom", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BLUE_GLOWSHROOM.getDefaultState()), new SimpleBlockPlacer())).tries(18).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> PURPLE_GLOWSHROOM = createConfiguredFeature("purple_glowshroom", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PURPLE_GLOWSHROOM.getDefaultState()), new SimpleBlockPlacer())).tries(18).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ROSE_BUSH = createConfiguredFeature("rose_bush", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.ROSE_BUSH.getDefaultState()), new DoublePlantBlockPlacer())).tries(48).func_227317_b_().build()));


    public static final ConfiguredFeature<?, ?> PRICKLY_PEAR_CACTI = createConfiguredFeature("prickly_pear_cacti", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PRICKLY_PEAR_CACTUS.getDefaultState()), new SimpleBlockPlacer())).tries(5).build()));
    public static final ConfiguredFeature<?, ?> GOLDEN_SPINED_CACTI = createConfiguredFeature("golden_spined_cacti", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.GOLDEN_SPINED_CACTUS.getDefaultState()), new SimpleBlockPlacer())).tries(5).build()));

    public static final ConfiguredFeature<?, ?> PINK_CHERRY_FOLIAGE = createConfiguredFeature("pink_cherry_foliage", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PINK_CHERRY_FOLIAGE.getDefaultState()), new SimpleBlockPlacer())).tries(24).build()));
    public static final ConfiguredFeature<?, ?> WHITE_CHERRY_FOLIAGE = createConfiguredFeature("white_cherry_foliage", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WHITE_CHERRY_FOLIAGE.getDefaultState()), new SimpleBlockPlacer())).tries(24).build()));

    public static final ConfiguredFeature<?, ?> WARPED_CACTI = createConfiguredFeature("warped_cacti", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WARPED_CACTUS.getDefaultState()), new ColumnBlockPlacer(1, 3))).tries(10).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> WARPED_BUSH = createConfiguredFeature("warped_bush", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.WARPED_BUSH.getDefaultState(), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> WARPED_CORAL = createConfiguredFeature("warped_coral", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.WARPED_CORAL.getDefaultState(), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> WARPED_CORAL_FAN = createConfiguredFeature("warped_coral_fan", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.WARPED_CORAL_FAN.getDefaultState(), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState()))));

    public static final ConfiguredFeature<?, ?> CHAINS = createConfiguredFeature("chains", BYGFeatures.CHAIN.withConfiguration(new ChainConfig.Builder().setMinLength(6).setMaxLength(10).setXAxisBlock(BYGBlocks.SOAPSTONE).setZAxisBlock(BYGBlocks.SOAPSTONE).setWhitelist(ImmutableList.of(Blocks.NETHERRACK)).build()).range(128).square().func_242731_b(4));

    public static final ConfiguredFeature<?, ?> SCORCHED_BUSH = createConfiguredFeature("scorched_bush", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.SCORCHED_BUSH.getDefaultState(), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.CRYPTIC_STONE.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlocks.OVERGROWN_NETHERRACK.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlocks.OVERGROWN_NETHERRACK.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState(), BYGBlocks.CRYPTIC_STONE.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> SCORCHED_GRASS = createConfiguredFeature("scorched_grass", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.SCORCHED_GRASS.getDefaultState(), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.CRYPTIC_STONE.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlocks.OVERGROWN_NETHERRACK.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlocks.OVERGROWN_NETHERRACK.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState(), BYGBlocks.CRYPTIC_STONE.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> WAILING_GRASS = createConfiguredFeature("wailing_grass", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.WAILING_GRASS.getDefaultState(), ImmutableList.of(BYGBlocks.OVERGROWN_NETHERRACK.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), BYGBlocks.OVERGROWN_NETHERRACK.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> WAILING_VINE = createConfiguredFeature("wailing_vine", BYGFeatures.WAILING_VINES.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG));

    public static final ConfiguredFeature<?, ?> LAMENT_SPROUTS = createConfiguredFeature("lament_sprouts", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.LAMENT_SPROUTS.getDefaultState(), ImmutableList.of(BYGBlocks.OVERGROWN_NETHERRACK.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState()))));

    public static final ConfiguredFeature<?, ?> BLUE_BERRY_BUSH = createConfiguredFeature("blue_berry_bush", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BLUEBERRY_BUSH.getDefaultState().with(BlueBerryBush.AGE, 3)), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ROSE = createConfiguredFeature("rose", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.ROSE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ANGELICA = createConfiguredFeature("angelica", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.ANGELICA.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> CROCUS = createConfiguredFeature("crocus", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.CROCUS.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> IRIS = createConfiguredFeature("iris", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.IRIS.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ANEMONE_WHITE = createConfiguredFeature("white_anemone", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WHITE_ANEMONE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ANEMONE_PINK = createConfiguredFeature("pink_anemone", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PINK_ANEMONE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ROSE_WINTER = createConfiguredFeature("winter_rose", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WINTER_ROSE.getDefaultState()), new SimpleBlockPlacer())).tries(48).whitelist(ImmutableSet.of(Blocks.SNOW_BLOCK, Blocks.GRASS_BLOCK, Blocks.SNOW)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> SNOWDROP = createConfiguredFeature("snowdrop", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.SNOWDROPS.getDefaultState()), new SimpleBlockPlacer())).tries(48).whitelist(ImmutableSet.of(Blocks.SNOW_BLOCK, Blocks.GRASS_BLOCK, Blocks.SNOW)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ALLIUM_PINK = createConfiguredFeature("pink_allium", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PINK_ALLIUM.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> DAISY_ORANGE = createConfiguredFeature("orange_daisy", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.ORANGE_DAISY.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> CORNFLOWER_RED = createConfiguredFeature("red_cornflower", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.RED_CORNFLOWER.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> SAGE_WHITE = createConfiguredFeature("white_sage", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WHITE_SAGE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> SAGE_PURPLE = createConfiguredFeature("purple_sage", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PURPLE_SAGE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> DELPHINIUM = createConfiguredFeature("delphinium", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.DELPHINIUM.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> FOXGLOVE = createConfiguredFeature("foxglove", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.FOXGLOVE.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> DAFFODIL_YELLOW = createConfiguredFeature("yellow_daffodil", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.YELLOW_DAFFODIL.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> PUMPKIN = createConfiguredFeature("pumpkin", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.PUMPKIN.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ALPINE_BELLFLOWER = createConfiguredFeature("alpine_bellflower", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.ALPINE_BELLFLOWER.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.PODZOL, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> WINTER_SCILLA = createConfiguredFeature("winter_scilla", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.WINTER_SCILLA.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.PODZOL, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> KOVAN_FLOWER = createConfiguredFeature("kovan_flower", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.KOVAN_FLOWER.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.PODZOL, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> FIRECRACKER_BUSH = createConfiguredFeature("firecracker_bush", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.FIRECRACKER_FLOWER_BUSH.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.PODZOL, Blocks.GRASS_BLOCK)).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> NETHER_BRISTLE = createConfiguredFeature("nether_bristle", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.NETHER_BRISTLE.getDefaultState()), new DoublePlantBlockPlacer())).whitelist(ImmutableSet.of(BYGBlocks.OVERGROWN_NETHERRACK)).tries(1).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> TULIP_GREEN = createConfiguredFeature("green_tulip", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.GREEN_TULIP.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.PODZOL, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> TULIP_CYAN = createConfiguredFeature("cyan_tulip", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.CYAN_TULIP.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.PODZOL, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> TULIP_MAGENTA = createConfiguredFeature("magenta_tulip", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.MAGENTA_TULIP.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.PODZOL, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> TULIP_PURPLE = createConfiguredFeature("purple_tulip", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PURPLE_TULIP.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.PODZOL, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> TULIP_YELLOW = createConfiguredFeature("yellow_tulip", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.YELLOW_TULIP.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.PODZOL, Blocks.GRASS_BLOCK)).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> REED = createConfiguredFeature("reed", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.REEDS.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().requiresWater().build()));
    public static final ConfiguredFeature<?, ?> CATTAIL = createConfiguredFeature("cattail", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.CATTAIL.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().requiresWater().build()));

    public static final ConfiguredFeature<?, ?> GLOWCANE_BLUE = createConfiguredFeature("blue_glowcane", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BLUE_GLOWCANE.getDefaultState()), new ColumnBlockPlacer(2, 3))).tries(32).xSpread(4).ySpread(0).zSpread(4).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> GLOWCANE_PURPLE = createConfiguredFeature("purple_glowcane", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PURPLE_GLOWCANE.getDefaultState()), new ColumnBlockPlacer(2, 3))).tries(32).xSpread(4).ySpread(0).zSpread(4).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> GLOWCANE_RED = createConfiguredFeature("red_glowcane", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.RED_GLOWCANE.getDefaultState()), new ColumnBlockPlacer(2, 3))).tries(32).xSpread(4).ySpread(0).zSpread(4).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> GLOWCANE_PINK = createConfiguredFeature("pink_glowcane", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PINK_GLOWCANE.getDefaultState()), new ColumnBlockPlacer(2, 3))).tries(32).xSpread(4).ySpread(0).zSpread(4).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> LOLIPOP_FLOWER = createConfiguredFeature("lolipop_flower", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.LOLIPOP_FLOWER.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ORCHID_RED = createConfiguredFeature("red_orchid", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.RED_ORCHID.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ORCHID_PINK = createConfiguredFeature("pink_orchid", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PINK_ORCHID.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ORCHID_PURPLE = createConfiguredFeature("purple_orchid", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PURPLE_ORCHID.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> LEATHER_FLOWER_PEACH = createConfiguredFeature("peach_leather_flower", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PEACH_LEATHER_FLOWER.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> LEATHER_FLOWER_VIOLET = createConfiguredFeature("violet_leather_flower", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.VIOLET_LEATHER_FLOWER.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> DAFFODIL_PINK = createConfiguredFeature("pink_daffodil", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PINK_DAFFODIL.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> DAFFODIL = createConfiguredFeature("daffodil", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.DAFFODIL.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ROSE_BLACK = createConfiguredFeature("black_rose", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BLACK_ROSE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ROSE_CYAN = createConfiguredFeature("cyan_rose", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.CYAN_ROSE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ROSE_OSIRIA = createConfiguredFeature("osiria_rose", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.ORSIRIA_ROSE.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> FAIRY_SLIPPER = createConfiguredFeature("fairy_slipper", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.FAIRY_SLIPPER.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.OVERGROWN_STONE, Blocks.GRASS_BLOCK)).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> IVIS_ROOTS = createConfiguredFeature("ivis_roots", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.IVIS_ROOTS.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));
    public static final ConfiguredFeature<?, ?> IVIS_SPROUT = createConfiguredFeature("ivis_sprout", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.IVIS_SPROUT.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));

    public static final ConfiguredFeature<?, ?> BULBIS_SPROUTS = createConfiguredFeature("bulbis_sprouts", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BULBIS_SPROUTS.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));
    public static final ConfiguredFeature<?, ?> CRYPTIC_BRAMBLE = createConfiguredFeature("cryptic_bramble", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.CRYPTIC_BRAMBLE.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));

    public static final ConfiguredFeature<?, ?> BULBIS_ODDITY = createConfiguredFeature("bulbis_oddity", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BULBIS_ODDITY.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));
    public static final ConfiguredFeature<?, ?> PURPLE_BULBIS_ODDITY = createConfiguredFeature("purple_bulbis_oddity", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PURPLE_BULBIS_ODDITY.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));

    public static final ConfiguredFeature<?, ?> BULBIS_ANOMALY = createConfiguredFeature("bulbis_anomaly", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.BULBIS_ANOMALY.getDefaultState()), new DoublePlantBlockPlacer())).tries(48).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> PURPLE_BULBIS_ANOMALY = createConfiguredFeature("purple_bulbis_anomaly", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.PURPLE_BULBIS_ANOMALY.getDefaultState()), new DoublePlantBlockPlacer())).tries(48).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> TALL_ETHER_GRASS = createConfiguredFeature("tall_ether_grass", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.TALL_ETHER_GRASS.getDefaultState()), new DoublePlantBlockPlacer())).tries(32).build()));
    public static final ConfiguredFeature<?, ?> ETHER_GRASS = createConfiguredFeature("ether_grass", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.ETHER_GRASS.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));
    public static final ConfiguredFeature<?, ?> ETHER_BUSH = createConfiguredFeature("ether_bush", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.ETHER_BUSH.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));
    public static final ConfiguredFeature<?, ?> THEREAL_BELLFLOWER = createConfiguredFeature("thereal_bellflower", Feature.FLOWER.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.THEREAL_BELLFLOWER.getDefaultState()), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.ETHER_PHYLIUM, BYGBlocks.NIGHTSHADE_PHYLIUM, BYGBlocks.IVIS_PHYLIUM, Blocks.GRASS_BLOCK)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ETHER_FOLIAGE = createConfiguredFeature("ether_foliage", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.ETHER_FOLIAGE.getDefaultState()), new SimpleBlockPlacer())).tries(24).build()));

    public static final ConfiguredFeature<?, ?> NIGHTSHADE_SPROUTS = createConfiguredFeature("nightshade_sprouts", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.NIGHTSHADE_SPROUTS.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));
    public static final ConfiguredFeature<?, ?> NIGHTSHADE_ROOTS = createConfiguredFeature("nightshade_roots", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.NIGHTSHADE_ROOTS.getDefaultState()), new DoublePlantBlockPlacer())).tries(32).build()));
    public static final ConfiguredFeature<?, ?> NIGHTSHADE_BERRY_BUSH = createConfiguredFeature("nightshade_berry_bush", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.NIGHTSHADE_BERRY_BUSH.getDefaultState().with(BlueBerryBush.AGE, Integer.valueOf(3))), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(BYGBlocks.NIGHTSHADE_PHYLIUM, BYGBlocks.ETHER_PHYLIUM, BYGBlocks.IVIS_PHYLIUM)).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> ODDITY_CACTUS = createConfiguredFeature("oddity_cactus", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.ODDITY_CACTUS.getDefaultState()), new ColumnBlockPlacer(1, 4))).tries(10).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> ODDITY_BUSH = createConfiguredFeature("oddity_bush", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.ODDITY_BUSH.getDefaultState(), ImmutableList.of(BYGBlocks.WHITE_SAND.getDefaultState(), BYGBlocks.BLACK_SAND.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.END_STONE.getDefaultState(), BYGBlocks.WHITE_SANDSTONE.getDefaultState(), BYGBlocks.BLACK_SANDSTONE.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> VERMILION_SCULK_GROWTH = createConfiguredFeature("vermilion_sculk_growth", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.VERMILION_SCULK_GROWTH.getDefaultState(), ImmutableList.of(BYGBlocks.VERMILION_SCULK.getDefaultState(), BYGBlocks.ETHER_STONE.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), BYGBlocks.VERMILION_SCULK.getDefaultState(), BYGBlocks.ETHER_STONE.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> THERIUM_CRYSTAL = createConfiguredFeature("therium_crystal", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.THERIUM_CRYSTAL.getDefaultState().with(TheriumCrystalBlock.AGE, 1), ImmutableList.of(BYGBlocks.THERIUM_BLOCK.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), BYGBlocks.THERIUM_BLOCK.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> VERMILION_SCULK_TENDRILS = createConfiguredFeature("vermilion_sculk_tendrils", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.VERMILION_SCULK_TENDRILS.getDefaultState(), ImmutableList.of(BYGBlocks.VERMILION_SCULK.getDefaultState(), BYGBlocks.ETHER_STONE.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), BYGBlocks.VERMILION_SCULK.getDefaultState(), BYGBlocks.ETHER_STONE.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> SHULKREN_MOSS = createConfiguredFeature("shulkren_moss_blanket", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.SHULKREN_MOSS_BLANKET.getDefaultState(), ImmutableList.of(BYGBlocks.SHULKREN_PHYLIUM.getDefaultState(), BYGBlocks.ETHER_PHYLIUM.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), BYGBlocks.SHULKREN_PHYLIUM.getDefaultState(), BYGBlocks.ETHER_PHYLIUM.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> SHULKREN_FUNGUS = createConfiguredFeature("shulkren_fungus", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.SHULKREN_FUNGUS.getDefaultState()), new SimpleBlockPlacer())).tries(32).build()));


    public static final ConfiguredFeature<?, ?> EMBUR_ROOTS = createConfiguredFeature("embur_roots", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.EMBUR_ROOTS.getDefaultState(), ImmutableList.of(BYGBlocks.EMBUR_NYLIUM.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), BYGBlocks.EMBUR_NYLIUM.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> EMBUR_ROOTS_TALL = createConfiguredFeature("tall_embur_roots", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.TALL_EMBUR_ROOTS.getDefaultState()), new DoublePlantBlockPlacer())).tries(1).whitelist(ImmutableSet.of(BYGBlocks.EMBUR_NYLIUM)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> EMBUR_GEL_VINE = createConfiguredFeature("embur_gel_vine", BYGFeatures.HANGING_COLUMN.withConfiguration(new HangingColumnConfig.Builder().setBlock(BYGBlocks.EMBUR_GEL_VINES).setMinLength(3).setMaxLength(3).setWhitelist(ImmutableList.of(BYGBlocks.EMBUR_GEL_BLOCK)).build()));
    public static final ConfiguredFeature<?, ?> EMBUR_WART = createConfiguredFeature("embur_wart", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.EMBUR_WART.getDefaultState(), ImmutableList.of(BYGBlocks.EMBUR_NYLIUM.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), BYGBlocks.EMBUR_NYLIUM.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> EMBUR_SPROUT = createConfiguredFeature("embur_sprout", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.EMBUR_SPROUTS.getDefaultState(), ImmutableList.of(BYGBlocks.EMBUR_NYLIUM.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), BYGBlocks.EMBUR_NYLIUM.getDefaultState()))));

    public static final ConfiguredFeature<?, ?> CRIMSON_ROOTS_TALL = createConfiguredFeature("tall_crimson_roots", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.TALL_EMBUR_ROOTS.getDefaultState()), new DoublePlantBlockPlacer())).tries(1).whitelist(ImmutableSet.of(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE)).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> CRIMSON_BERRY_BUSH = createConfiguredFeature("crimson_berry_bush", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.CRIMSON_BERRY_BUSH.getDefaultState().with(CrimsonBerryBushBlock.AGE, 3), ImmutableList.of(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE.getDefaultState(), Blocks.BLACKSTONE.getDefaultState()))));

    public static final ConfiguredFeature<?, ?> SYTHIAN_ROOTS = createConfiguredFeature("sythian_root", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.SYTHIAN_ROOTS.getDefaultState(), ImmutableList.of(BYGBlocks.SYTHIAN_NYLIUM.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), BYGBlocks.SYTHIAN_NYLIUM.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> SYTHIAN_SPROUT = createConfiguredFeature("sythian_sprout", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.SYTHIAN_SPROUT.getDefaultState(), ImmutableList.of(BYGBlocks.SYTHIAN_NYLIUM.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), BYGBlocks.SYTHIAN_NYLIUM.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> SYTHIAN_FUNGUS = createConfiguredFeature("sythian_fungus", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.SYTHIAN_FUNGUS.getDefaultState(), ImmutableList.of(BYGBlocks.SYTHIAN_NYLIUM.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), BYGBlocks.SYTHIAN_NYLIUM.getDefaultState()))));
    public static final ConfiguredFeature<?, ?> SOUL_SHROOM = createConfiguredFeature("soul_shroom", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.SOUL_SHROOM.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).func_227317_b_().build()));
    public static final ConfiguredFeature<?, ?> DEATH_CAP = createConfiguredFeature("death_cap", Feature.RANDOM_PATCH.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BYGBlocks.DEATH_CAP.getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).func_227317_b_().build()));

    public static final ConfiguredFeature<?, ?> DEAD_SEA_SPIKE = createConfiguredFeature("dead_sea_spike", BYGFeatures.POINTY_ROCK.withConfiguration(new PointyRockConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ROCKY_STONE.getDefaultState(), 5).addWeightedBlockstate(Blocks.STONE.getDefaultState(), 3).addWeightedBlockstate(Blocks.ANDESITE.getDefaultState(), 2)).setSeed(65).build()));
    public static final ConfiguredFeature<?, ?> DEAD_SEA_SPIKE_TALL = createConfiguredFeature("dead_sea_tall_spike", BYGFeatures.POINTY_ROCK.withConfiguration(new PointyRockConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ROCKY_STONE.getDefaultState(), 5).addWeightedBlockstate(Blocks.STONE.getDefaultState(), 3).addWeightedBlockstate(Blocks.ANDESITE.getDefaultState(), 2)).setSeed(85).build()));
    public static final ConfiguredFeature<?, ?> IVIS_SPIKES = createConfiguredFeature("ivis_spikes1", BYGFeatures.TALL_POINTED_ROCK.withConfiguration(new PointyRockConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.OBSIDIAN.getDefaultState(), 24).addWeightedBlockstate(Blocks.CRYING_OBSIDIAN.getDefaultState(), 1)).setSeed(120).setHeightMultiplier(0.4).build()));
    public static final ConfiguredFeature<?, ?> IVIS_SPIKES2 = createConfiguredFeature("ivis_spikes2", BYGFeatures.TALL_POINTED_ROCK.withConfiguration(new PointyRockConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.OBSIDIAN.getDefaultState(), 24).addWeightedBlockstate(Blocks.CRYING_OBSIDIAN.getDefaultState(), 1)).setSeed(15676).setHeightMultiplier(0.8).build()));

    public static final ConfiguredFeature<?, ?> BLACK_SANDSTONE_SPIKE = createConfiguredFeature("black_sandstone_spike", BYGFeatures.TALL_POINTED_ROCK.withConfiguration(new PointyRockConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.BLACK_SANDSTONE.getDefaultState(), 24).addWeightedBlockstate(BYGBlocks.BLACK_SMOOTH_SANDSTONE.getDefaultState(), 1)).setSeed(120).setHeightMultiplier(0.3).build()));
    public static final ConfiguredFeature<?, ?> BLACK_SANDSTONE_SPIKE2 = createConfiguredFeature("black_sandstone_spike2", BYGFeatures.TALL_POINTED_ROCK.withConfiguration(new PointyRockConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.BLACK_SANDSTONE.getDefaultState(), 24).addWeightedBlockstate(BYGBlocks.BLACK_SMOOTH_SANDSTONE.getDefaultState(), 1)).setSeed(15676).setHeightMultiplier(0.4).build()));
    public static final ConfiguredFeature<?, ?> WHITE_SANDSTONE_BOULDER2 = createConfiguredFeature("white_sandstone_boulder2", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BoulderConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SANDSTONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 2)).setMinStackHeight(1).setMaxHeight(1).setMinRadius(4).setMaxRadius(8).build()).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> PURPUR_SPIKES = createConfiguredFeature("purpur_spikes1", BYGFeatures.TALL_POINTED_ROCK.withConfiguration(new PointyRockConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.PURPUR_STONE.getDefaultState(), 24).addWeightedBlockstate(BYGBlocks.PURPUR_STONE.getDefaultState(), 1)).setSeed(120).setHeightMultiplier(0.5).build()));
    public static final ConfiguredFeature<?, ?> PURPUR_SPIKES2 = createConfiguredFeature("purpur_spikes2", BYGFeatures.TALL_POINTED_ROCK.withConfiguration(new PointyRockConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.PURPUR_STONE.getDefaultState(), 24).addWeightedBlockstate(BYGBlocks.PURPUR_STONE.getDefaultState(), 1)).setSeed(15676).setHeightMultiplier(0.4).build()));


    public static final ConfiguredFeature<?, ?> VALLE_DE_LUNA_POINTY_ROCK = createConfiguredFeature("valle_de_luna_pointy_rock", BYGFeatures.POINTY_ROCK.withConfiguration(new PointyRockConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SAND.getDefaultState(), 5).addWeightedBlockstate(BYGBlocks.WHITE_CUT_SANDSTONE.getDefaultState(), 5)).setSeed(88).build()).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(28, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> VALLE_DE_LUNA_POINTY_ROCK_LARGE = createConfiguredFeature("valle_de_luna_pointy_rock_large", BYGFeatures.POINTY_ROCK.withConfiguration(new PointyRockConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SAND.getDefaultState(), 5).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 5)).setSeed(100).build()).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(4, 0.1F, 1))));


    public static final ConfiguredFeature<?, ?> ORE_PERVADED_NETHERRACK = createConfiguredFeature("ore_pervaded_netherrack", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, BYGBlocks.PERVADED_NETHERRACK.getDefaultState(), 14)).withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).square().func_242731_b(14));
    public static final ConfiguredFeature<?, ?> ORE_ANTHRACITE = createConfiguredFeature("ore_anthracite", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, BYGBlocks.ANTHRACITE_ORE.getDefaultState(), 14)).withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).square().func_242731_b(12));
    public static final ConfiguredFeature<?, ?> ORE_LIGNITE = createConfiguredFeature("ore_lignite", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, BYGBlocks.LIGNITE_ORE.getDefaultState(), 14)).withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).square().func_242731_b(16));
    public static final ConfiguredFeature<?, ?> ORE_CRYPTIC_REDSTONE = createConfiguredFeature("ore_cryptic_redstone", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, BYGBlocks.CRYPTIC_REDSTONE_ORE.getDefaultState(), 14)).withPlacement(Features.Placements.NETHER_SPRING_ORE_PLACEMENT).square().func_242731_b(12));

    public static final ConfiguredFeature<?, ?> MOSSY_STONE_BOULDER = createConfiguredFeature("mossy_stone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(BYGBlocks.MOSSY_STONE.getDefaultState())));
    public static final ConfiguredFeature<?, ?> ROCKY_STONE_BOULDER = createConfiguredFeature("rocky_stone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(BYGBlocks.ROCKY_STONE.getDefaultState())));
    public static final ConfiguredFeature<?, ?> BLACKSTONE_BOULDER = createConfiguredFeature("blackstone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.BLACKSTONE.getDefaultState())));
    public static final ConfiguredFeature<?, ?> ORANGE_TERRACOTTA_BOULDER = createConfiguredFeature("orange_terracotta_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.ORANGE_TERRACOTTA.getDefaultState())));

    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND1 = createConfiguredFeature("shattered_floating_island1", BYGFeatures.SHATTERED_FLOATING_ISLAND1.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ETHER_STONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.LIGNITE_ORE.getDefaultState(), 2)).setMinRadius(11).setMaxRadius(13).build()));
    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND2 = createConfiguredFeature("shattered_floating_island2", BYGFeatures.SHATTERED_FLOATING_ISLAND2.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ETHER_STONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.LIGNITE_ORE.getDefaultState(), 2)).setMinRadius(11).setMaxRadius(13).build()));
    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND3 = createConfiguredFeature("shattered_floating_island3", BYGFeatures.SHATTERED_FLOATING_ISLAND3.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ETHER_STONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.LIGNITE_ORE.getDefaultState(), 2)).setMinRadius(11).setMaxRadius(13).build()));
    public static final ConfiguredFeature<?, ?> SHATTERED_FLOATING_ISLAND4 = createConfiguredFeature("shattered_floating_island4", BYGFeatures.SHATTERED_FLOATING_ISLAND4.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ETHER_STONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.LIGNITE_ORE.getDefaultState(), 2)).setMinRadius(13).setMaxRadius(17).build()));

    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND1 = createConfiguredFeature("floating_island1", BYGFeatures.FLOATING_ISLAND1.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ETHER_STONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.LIGNITE_ORE.getDefaultState(), 2)).setMinRadius(11).setMaxRadius(13).build()));
    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND2 = createConfiguredFeature("floating_island2", BYGFeatures.FLOATING_ISLAND2.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ETHER_STONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.LIGNITE_ORE.getDefaultState(), 2)).setMinRadius(11).setMaxRadius(13).build()));
    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND3 = createConfiguredFeature("floating_island3", BYGFeatures.FLOATING_ISLAND3.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ETHER_STONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.LIGNITE_ORE.getDefaultState(), 2)).setMinRadius(11).setMaxRadius(13).build()));
    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND4 = createConfiguredFeature("floating_island4", BYGFeatures.FLOATING_ISLAND4.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ETHER_STONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.LIGNITE_ORE.getDefaultState(), 2)).setMinRadius(13).setMaxRadius(17).build()));
    public static final ConfiguredFeature<?, ?> FLOATING_ISLAND5 = createConfiguredFeature("floating_island5", BYGFeatures.FLOATING_ISLAND5.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.VERMILION_SCULK).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ETHER_STONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.LIGNITE_ORE.getDefaultState(), 2)).setMinRadius(13).setMaxRadius(17).build()));

    public static final ConfiguredFeature<?, ?> FLOATING_DESERT_ISLAND1 = createConfiguredFeature("floating_desert_island1", BYGFeatures.FLOATING_ISLAND1.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.WHITE_SAND).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SANDSTONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 2)).setMinRadius(12).setMaxRadius(19).build()));
    public static final ConfiguredFeature<?, ?> FLOATING_DESERT_ISLAND2 = createConfiguredFeature("floating_desert_island2", BYGFeatures.FLOATING_ISLAND2.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.WHITE_SAND).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SANDSTONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 2)).setMinRadius(12).setMaxRadius(20).build()));
    public static final ConfiguredFeature<?, ?> FLOATING_DESERT_ISLAND3 = createConfiguredFeature("floating_desert_island3", BYGFeatures.FLOATING_ISLAND3.withConfiguration(new FloatingIslandConfig.Builder().setTopBlock(BYGBlocks.WHITE_SAND).setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SANDSTONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 2)).setMinRadius(12).setMaxRadius(21).build()));


    public static final ConfiguredFeature<PumpkinConfig, ?> PUMPKIN1 = createConfiguredFeature("pumpkin1", BYGFeatures.LARGE_PUMPKIN1.withConfiguration(new PumpkinConfig.Builder().setPumpkinBlock(Blocks.PUMPKIN).build()));
    public static final ConfiguredFeature<PumpkinConfig, ?> PUMPKIN2 = createConfiguredFeature("pumpkin2", BYGFeatures.LARGE_PUMPKIN2.withConfiguration(new PumpkinConfig.Builder().setPumpkinBlock(Blocks.PUMPKIN).setStemBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).build()));


    /***********************************************************Configured & Decorated Features***********************************************************/

    public static final ConfiguredFeature<?, ?> FROST_MAGMA_LAKE = createConfiguredFeature("frost_magma_lake", BYGFeatures.FROSTED_LAKE.withConfiguration(new BlockStateFeatureConfig(BYGBlocks.FROST_MAGMA.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
    public static final ConfiguredFeature<?, ?> WARPED_CORAL_PLANT = createConfiguredFeature("warped_coral_plant", BYGFeatures.HUGE_WARPED_CORAL_PLANT.withConfiguration(new WhitelistedSimpleBlockProviderConfig(new SimpleBlockStateProvider(BYGBlocks.WARPED_CORAL_BLOCK.getDefaultState()), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState(), BYGBlocks.NYLIUM_SOUL_SAND.getDefaultState()))).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.2F, 1))));
    public static final ConfiguredFeature<?, ?> SYTHIAN_STALK = createConfiguredFeature("sythian_stalk", BYGFeatures.SYTHIAN_STALK.withConfiguration(new ProbabilityConfig(0.9F)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.5F, 8))));
    public static final ConfiguredFeature<?, ?> EMBUR_LILY = createConfiguredFeature("embur_lily", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.EMBUR_LILY.getDefaultState(), ImmutableList.of(Blocks.LAVA.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.LAVA.getDefaultState()))).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.5F, 2))));
    public static final ConfiguredFeature<?, ?> WIDE_WATER_LAKE = createConfiguredFeature("wide_water_lake", BYGFeatures.WIDE_LAKE.withConfiguration(new SimpleBlockProviderConfig(new SimpleBlockStateProvider(Blocks.WATER.getDefaultState()))).withPlacement(BYGDecorators.ANY_WATER_OR_SOLID_SURFACE.configure(new FeatureSpreadConfig(4))));
    public static final ConfiguredFeature<?, ?> END_LAKE = createConfiguredFeature("end_lake", BYGFeatures.END_LAKE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
    public static final ConfiguredFeature<?, ?> BULBIS_WATER_LAKE = createConfiguredFeature("bulbis_water_lake", BYGFeatures.WIDE_LAKE.withConfiguration(new SimpleBlockProviderConfig(new SimpleBlockStateProvider(Blocks.WATER.getDefaultState()))).withPlacement(BYGDecorators.ANY_WATER_OR_SOLID_SURFACE.configure(new FeatureSpreadConfig(1))));
    public static final ConfiguredFeature<?, ?> STACKED_BOULDERS = createConfiguredFeature("stacked_boulders", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BoulderConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.STONE.getDefaultState(), 3).addWeightedBlockstate(Blocks.DIORITE.getDefaultState(), 2)).setMinStackHeight(10).setMaxHeight(15).setMinRadius(8).setMaxRadius(28).build()).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.15F, 1))));
    public static final ConfiguredFeature<?, ?> GRASSLAND_BOULDER = createConfiguredFeature("grassland_boulder", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BoulderConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ROCKY_STONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.MOSSY_STONE.getDefaultState(), 2)).setMinStackHeight(1).setMaxHeight(1).setMinRadius(8).setMaxRadius(12).build()).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> GRANITE_BOULDER = createConfiguredFeature("granite_boulder", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BoulderConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.GRANITE.getDefaultState(), 3).addWeightedBlockstate(Blocks.POLISHED_GRANITE.getDefaultState(), 2)).setMinStackHeight(1).setMaxHeight(1).setMinRadius(5).setMaxRadius(9).build()).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> ARCH = createConfiguredFeature("arch", BYGFeatures.ARCH.withConfiguration(new SimpleBlockProviderConfig(new SimpleBlockStateProvider(Blocks.DIAMOND_BLOCK.getDefaultState()))).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.015F, 1))));
    public static final ConfiguredFeature<?, ?> ARCH2 = createConfiguredFeature("arch2", BYGFeatures.ARCH.withConfiguration(new SimpleBlockProviderConfig(new SimpleBlockStateProvider(Blocks.EMERALD_BLOCK.getDefaultState()))).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.015F, 1))));
    public static final ConfiguredFeature<?, ?> CRYPTIC_CAVES = createConfiguredFeature("cryptic_caves", BYGFeatures.NOISY_CAVE_SPHERE.withConfiguration((new NoisySphereConfig.Builder().setMinXRadius(20).setMaxXRadius(30).setMinYRadius(10).setMaxYRadius(16).setMinZRadius(14).setMaxZRadius(20).setBlock(Blocks.CAVE_AIR).build())).range(55).square().func_242731_b(2));
    public static final ConfiguredFeature<?, ?> IRON_SURFACE_DEPOSIT = createConfiguredFeature("iron_surface_deposit", BYGFeatures.MINERAL_DEPOSIT.withConfiguration((new NoisySphereConfig.Builder().setMinXRadius(6).setMaxXRadius(14).setMinYRadius(4).setMaxYRadius(9).setMinZRadius(4).setMaxZRadius(7).setBlock(Blocks.IRON_BLOCK).build())).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 2))));
    public static final ConfiguredFeature<?, ?> ETHER_STONE_BOULDER = createConfiguredFeature("ether_stone_boulder", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BoulderConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ETHER_STONE.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.LIGNITE_ORE.getDefaultState(), 2)).setMinStackHeight(1).setMaxHeight(1).setMinRadius(8).setMaxRadius(12).build()).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> ENDER_LILY = createConfiguredFeature("ender_lily", Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(BYGBlocks.ENDER_LILY.getDefaultState(), ImmutableList.of(BYGBlocks.BULBIS_PHYCELIUM.getDefaultState()), ImmutableList.of(Blocks.AIR.getDefaultState()), ImmutableList.of(Blocks.WATER.getDefaultState()))).withPlacement(BYGDecorators.ANY_WATER_OR_SOLID_SURFACE.configure(new FeatureSpreadConfig(4))));
    public static final ConfiguredFeature<?, ?> CRYPTIC_SPIKE = createConfiguredFeature("cryptic_spike", BYGFeatures.SPIKE.withConfiguration(new SimpleBlockProviderConfig(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.CRYPTIC_STONE.getDefaultState(), 5).addWeightedBlockstate(BYGBlocks.CRYPTIC_MAGMA_BLOCK.getDefaultState(), 5))).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.18F, 1))));
    public static final ConfiguredFeature<?, ?> BLACK_ICE_SNOW = createConfiguredFeature("black_ice_snow", BYGFeatures.ICE_SNOW.withConfiguration(new Simple2BlockProviderConfig(new SimpleBlockStateProvider(BYGBlocks.BLACK_ICE.getDefaultState()), new SimpleBlockStateProvider(Blocks.SNOW.getDefaultState()))).withPlacement(Placement.NOPE.configure(new NoPlacementConfig())));
    public static final ConfiguredFeature<?, ?> BULBIS_GARDENS_CAVES = createConfiguredFeature("bulbis_gardens_caves", BYGFeatures.NOISY_CAVE_SPHERE_WATER.withConfiguration((new NoisySphereConfig.Builder().setMinXRadius(20).setMaxXRadius(30).setMinYRadius(10).setMaxYRadius(16).setMinZRadius(14).setMaxZRadius(20).setBlock(Blocks.CAVE_AIR).build())).range(55).square().func_242731_b(2));

    public static final ConfiguredFeature<?, ?> THERIUM_CRYSTAL_DEPOSIT = createConfiguredFeature("therium_crystal_deposit", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BoulderConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.THERIUM_BLOCK.getDefaultState(), 20).addWeightedBlockstate(BYGBlocks.ETHER_STONE.getDefaultState(), 2)).setMinStackHeight(0).setMaxHeight(0).setMinRadius(4).setMaxRadius(5).build()).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.015F, 1))));

    public static final ConfiguredFeature<?, ?> RED_ROCK_BOULDER = createConfiguredFeature("red_rock_boulder", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BoulderConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.RED_ROCK.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.RED_ROCK.getDefaultState(), 9).addWeightedBlockstate(Blocks.RED_CONCRETE.getDefaultState(), 1)).setMinStackHeight(7).setMaxHeight(12).setMinRadius(8).setMaxRadius(12).build()));
    public static final ConfiguredFeature<?, ?> WHITE_SANDSTONE_BOULDER = createConfiguredFeature("white_sandstone_boulder", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BoulderConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.WHITE_SANDSTONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 2).addWeightedBlockstate(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.WHITE_SAND.getDefaultState(), 5)).setMinStackHeight(3).setMaxHeight(12).setMinRadius(13).setMaxRadius(20).setRadiusDivisor(1.1).flattenTopBoulder().build()).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.04F, 1))));
    public static final ConfiguredFeature<?, ?> TERRACOTTA_BOULDER = createConfiguredFeature("terracotta_boulder", BYGFeatures.STACKABLE_BOULDERS.withConfiguration(new BoulderConfig.Builder().setBlock(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.TERRACOTTA.getDefaultState(), 3).addWeightedBlockstate(Blocks.TERRACOTTA.getDefaultState(), 3).addWeightedBlockstate(Blocks.RED_TERRACOTTA.getDefaultState(), 7)).setMinStackHeight(7).setMaxHeight(12).setMinRadius(8).setMaxRadius(12).build()));


    public static final ConfiguredFeature<?, ?> RIVER = createConfiguredFeature("river_aheehee", BYGFeatures.HUH.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(new NoPlacementConfig())));
    public static final ConfiguredFeature<?, ?> VOLCANO = createConfiguredFeature("volcano", BYGFeatures.VOLCANO.withConfiguration(new SimpleBlockProviderConfig(new WeightedBlockStateProvider().addWeightedBlockstate(Blocks.BLACKSTONE.getDefaultState(), 4).addWeightedBlockstate(Blocks.BLACK_CONCRETE.getDefaultState(), 3).addWeightedBlockstate(Blocks.STONE.getDefaultState(), 2).addWeightedBlockstate(BYGBlocks.MAGMATIC_STONE.getDefaultState(), 1))).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.025F, 1))));
    public static final ConfiguredFeature<?, ?> PURPUR_PEAK = createConfiguredFeature("purpur_peak", BYGFeatures.PURPUR_PEAK.withConfiguration(new SimpleBlockProviderConfig(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.PURPUR_STONE.getDefaultState(), 10))).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.25F, 1))));
    public static final ConfiguredFeature<?, ?> BASALT_DELTA = createConfiguredFeature("delta", Feature.DELTA_FEATURE.withConfiguration(new BasaltDeltasFeature(Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), FeatureSpread.func_242253_a(3, 4), FeatureSpread.func_242253_a(0, 2))).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(2))));
    public static final ConfiguredFeature<?, ?> SMALL_BASALT_COLUMN = createConfiguredFeature("small_basalt_columns", Feature.BASALT_COLUMNS.withConfiguration(new ColumnConfig(FeatureSpread.func_242252_a(1), FeatureSpread.func_242253_a(1, 1))).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1))));
    public static final ConfiguredFeature<?, ?> LARGE_BASALT_COLUMN = createConfiguredFeature("large_basalt_columns", Feature.BASALT_COLUMNS.withConfiguration(new ColumnConfig(FeatureSpread.func_242253_a(2, 1), FeatureSpread.func_242253_a(1, 1))).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1))));

    /***********************************************************Configured Placement***********************************************************/

    public static final ConfiguredFeature<?, ?> BULBIS_SPROUT_PLANT = createConfiguredFeature("bulbis_sprout_plant", BULBIS_SPROUTS.withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(5));

    public static final ConfiguredFeature<?, ?> CALIFORNIA_POPPIES = createConfiguredFeature("california_poppies", CALIFORNIA_POPPY.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> WINTER_SUCCLULENTS = createConfiguredFeature("winter_succulents", WINTER_SUCCULENT.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> HORSEWEEDS = createConfiguredFeature("horseweeds", HORSEWEED.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> BLACKSTONE_BOULDERS = createConfiguredFeature("blackstone_boulders", BLACKSTONE_BOULDER.withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.3F, 3))));
    public static final ConfiguredFeature<?, ?> ROCKY_STONE_BOULDERS = createConfiguredFeature("rocky_stone_boulders", ROCKY_STONE_BOULDER.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(2));
    public static final ConfiguredFeature<?, ?> MOSSY_STONE_BOULDERS = createConfiguredFeature("mossy_stone_boulders", MOSSY_STONE_BOULDER.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(2));
    public static final ConfiguredFeature<?, ?> ORANGE_TERRACOTTA_BOULDERS = createConfiguredFeature("orange_terracotta_boulders", ORANGE_TERRACOTTA_BOULDER.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(2));
    public static final ConfiguredFeature<?, ?> FIRECRACKER_BUSHES = createConfiguredFeature("firecracker_bushes", FIRECRACKER_BUSH.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> PUMPKINS = createConfiguredFeature("pumpkins", PUMPKIN.withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(8));
    public static final ConfiguredFeature<?, ?> BLUE_BERRY_BUSHES = createConfiguredFeature("blue_berry_bushes", BLUE_BERRY_BUSH.withPlacement(Features.Placements.PATCH_PLACEMENT));
    public static final ConfiguredFeature<?, ?> LUSH_BLUE_BERRY_BUSHES = createConfiguredFeature("lush_blue_berry_bushes", BLUE_BERRY_BUSH.withPlacement(Features.Placements.PATCH_PLACEMENT).chance(12));
    public static final ConfiguredFeature<?, ?> SHORT_GRASSES = createConfiguredFeature("short_grass", SHORT_GRASS.withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(10));
    public static final ConfiguredFeature<?, ?> EMBUR_SPROUTS = createConfiguredFeature("embur_sprouts", EMBUR_SPROUT.withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(30))));
    public static final ConfiguredFeature<?, ?> NYLIUM_SOUL_FIRE = createConfiguredFeature("nylium_soul_fire", NYLIUM_SOUL_FIRE_PATCH.withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1))));
    public static final ConfiguredFeature<?, ?> CRYPTIC_FIRE = createConfiguredFeature("cryptic_fire", CRYPTIC_FIRE_PATCH.withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> MAGMA_FIRE = createConfiguredFeature("magma_fire", MAGMA_FIRE_PATCH.withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1))));
    public static final ConfiguredFeature<?, ?> BORIC_FIRE = createConfiguredFeature("boric_fire", BORIC_FIRE_PATCH.withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1))));
    public static final ConfiguredFeature<?, ?> QUARTZ_CRYSTALS = createConfiguredFeature("quartz_crystals", QUARTZ_CRYSTAL.withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(50))));
    public static final ConfiguredFeature<?, ?> EMBUR_GEL_VINES = createConfiguredFeature("embur_gel_vines", EMBUR_GEL_VINE.range(128).square().func_242731_b(100));
    public static final ConfiguredFeature<?, ?> CRYPTIC_BRAMBLES = createConfiguredFeature("cryptic_brambles", CRYPTIC_BRAMBLE.withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(1));


    /***********************************************************Configured Random Selector Features***********************************************************/

    public static final ConfiguredFeature<?, ?> RANDOM_ALLIUM_FLOWER = createConfiguredFeature("allium_flowers", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ALLIUM_TALL_BUSH.withChance(0.25F),
            ALLIUM_TALL_PINK_BUSH.withChance(0.25F),
            ALLIUM_BUSH.withChance(0.25F)),
            ALLIUM_PINK_BUSH)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_AMARANTH_FLOWER = createConfiguredFeature("amaranth_flowers", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            AMARANTH.withChance(0.2F),
            AMARANTH_CYAN.withChance(0.2F),
            AMARANTH_MAGENTA.withChance(0.2F),
            AMARANTH_ORANGE.withChance(0.2F)),
            AMARANTH_PURPLE)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_ROSE_FIELD_FLOWER = createConfiguredFeature("rose_field_flower", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ROSE_OSIRIA.withChance(0.25F),
            ROSE.withChance(0.25F)),
            ROSE_BUSH)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_DESERT_PLANTS = createConfiguredFeature("desert_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MINI_CACTI.withChance(0.3F),
            PRICKLY_PEAR_CACTI.withChance(0.3F),
            GOLDEN_SPINED_CACTI.withChance(0.3F)),
            FIRECRACKER_BUSH)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_LUNA_BOULDERS = createConfiguredFeature("luna_boulders", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RED_ROCK_BOULDER.withChance(0.5F)),
            TERRACOTTA_BOULDER)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.3F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_PRAIRIE_GRASS = createConfiguredFeature("prairie_grasses", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PRAIRIE_GRASS_PATCH.withChance(0.92F)),
            PRAIRIE_TALL_GRASS_PATCH)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_BEACH_GRASS = createConfiguredFeature("beach_grasses", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BEACH_GRASS.withChance(0.50F)),
            BEACH_SHORT_GRASS_PATCH)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWCANE = createConfiguredFeature("glowcane", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            GLOWCANE_BLUE.withChance(0.25F),
            GLOWCANE_PINK.withChance(0.25F),
            GLOWCANE_PURPLE.withChance(0.25F)),
            GLOWCANE_RED)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(60));

    public static final ConfiguredFeature<?, ?> RANDOM_BYG_GRASS = createConfiguredFeature("grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHORT_GRASS.withChance(0.50F)),
            Features.PATCH_GRASS_NORMAL)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(10));

    public static final ConfiguredFeature<?, ?> RANDOM_BYG_FERN_GRASS = createConfiguredFeature("fern_grass", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHORT_GRASS.withChance(0.50F)),
            Features.PATCH_TAIGA_GRASS)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(10));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSHROOM = createConfiguredFeature("glowshrooms", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_GLOWSHROOM.withChance(0.50F)),
            PURPLE_GLOWSHROOM)).withPlacement(Features.Placements.PATCH_PLACEMENT).chance(4));

    public static final ConfiguredFeature<?, ?> RANDOM_MUSHROOM = createConfiguredFeature("mushrooms", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLACK_PUFF.withChance(0.50F),
            WOOD_BLEWIT.withChance(0.50F),
            WEEPING_MILKCAP.withChance(0.50F)),
            GREEN_MUSHROOM)).withPlacement(Features.Placements.PATCH_PLACEMENT).chance(4));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSTONE_GARDEN_VEGETATION = createConfiguredFeature("glowstone_garden_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SOUL_SHROOM.withChance(0.2F),
            DEATH_CAP.withChance(0.2F)),
            NETHER_BRISTLE)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(4)).func_242731_b(1)));

    public static final ConfiguredFeature<?, ?> RANDOM_CRIMSON_GARDEN_VEGETATION = createConfiguredFeature("crimson_garden_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_ROOTS_TALL.withChance(0.45F),
            CRIMSON_ROOTS_TALL.withChance(0.8F)),
            CRIMSON_BERRY_BUSH)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(25))));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_BOG_PLANT = createConfiguredFeature("embur_bog_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_ROOTS_TALL.withChance(0.45F),
            EMBUR_ROOTS.withChance(0.5F)),
            EMBUR_WART)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> RANDOM_SUBZERO_ASH_PATCH = createConfiguredFeature("subzero_ashes", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SUBZERO_ASH.withChance(0.6F)),
            SUBZERO_ASH_BLOCK)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(3))));

    public static final ConfiguredFeature<?, ?> WEEPING_ROOTS = createConfiguredFeature("weeping_roots", BYGFeatures.HANGING_FEATURE.withConfiguration(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.GLOWSTONE).setBlock(BYGBlocks.WEEPING_ROOTS_PLANT).setEndBlock(BYGBlocks.WEEPING_ROOTS.getDefaultState().with(AbstractTopPlantBlock.AGE, 23)).setWhitelist(ImmutableList.of(Blocks.NETHERRACK, Blocks.GLOWSTONE, Blocks.BLACKSTONE)).build()).range(128).square().func_242731_b(80));
    public static final ConfiguredFeature<?, ?> WEEPING_VINES = createConfiguredFeature("weeping_vines", BYGFeatures.HANGING_FEATURE.withConfiguration(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.GLOWSTONE).setBlock(Blocks.WEEPING_VINES_PLANT).setEndBlock(Blocks.WEEPING_VINES.getDefaultState().with(AbstractTopPlantBlock.AGE, 23)).setWhitelist(ImmutableList.of(Blocks.NETHERRACK, Blocks.GLOWSTONE, Blocks.BLACKSTONE)).build()).range(128).square().func_242731_b(80));
    public static final ConfiguredFeature<?, ?> SOUL_SOIL_PILLARS = createConfiguredFeature("soul_soil_pillars", BYGFeatures.PILLARS.withConfiguration(new SimpleBlockProviderConfig(new SimpleBlockStateProvider(BYGBlocks.NYLIUM_SOUL_SOIL.getDefaultState()))).range(128).square().func_242731_b(50));
    public static final ConfiguredFeature<?, ?> FROST_MAGMA_PILLARS = createConfiguredFeature("frost_magma_pillars", BYGFeatures.PILLARS.withConfiguration((new SimpleBlockProviderConfig(new SimpleBlockStateProvider(BYGBlocks.FROST_MAGMA.getDefaultState())))).range(128).square().func_242731_b(50));
    public static final ConfiguredFeature<?, ?> MAGMA_PILLARS = createConfiguredFeature("magma_pillars", BYGFeatures.PILLARS.withConfiguration((new SimpleBlockProviderConfig(new SimpleBlockStateProvider(BYGBlocks.MAGMATIC_STONE.getDefaultState())))).range(128).square().func_242731_b(65));
    public static final ConfiguredFeature<?, ?> BRIMSTONE_PILLARS = createConfiguredFeature("brimstone_pillars", BYGFeatures.PILLARS.withConfiguration((new SimpleBlockProviderConfig(new SimpleBlockStateProvider(BYGBlocks.BRIMSTONE.getDefaultState())))).range(128).square().func_242731_b(80));
    public static final ConfiguredFeature<?, ?> QUARTZ_COLUMNS = createConfiguredFeature("quartz_columns", BYGFeatures.QUARTZ_COLUMNS.withConfiguration(new ColumnConfig(FeatureSpread.func_242252_a(1), FeatureSpread.func_242253_a(1, 3))).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(4))));

    public static final ConfiguredFeature<?, ?> RANDOM_SYTHIAN_PLANT = createConfiguredFeature("sythian_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SYTHIAN_SPROUT.withChance(0.5F),
            SYTHIAN_ROOTS.withChance(0.46F)),
            SYTHIAN_FUNGUS)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> HANGING_SOUL_SHROOM_SPORES = createConfiguredFeature("hanging_soul_shroom_spores", BYGFeatures.HANGING_FEATURE.withConfiguration(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setBlock(BYGBlocks.SOUL_SHROOM_SPORE).setEndBlock(BYGBlocks.SOUL_SHROOM_SPORE_END.getDefaultState().with(AbstractTopPlantBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.SOUL_SOIL, Blocks.SOUL_SAND, BYGBlocks.NYLIUM_SOUL_SAND, BYGBlocks.NYLIUM_SOUL_SAND)).build()).range(128).square().func_242731_b(45));
    public static final ConfiguredFeature<?, ?> HANGING_SYTHIAN_ROOTS = createConfiguredFeature("hanging_sythian_roots", BYGFeatures.HANGING_FEATURE.withConfiguration(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT.getDefaultState()).setEndBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS.getDefaultState().with(AbstractTopPlantBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.NETHERRACK, BYGBlocks.SYTHIAN_WART_BLOCK)).build()).range(128).square().func_242731_b(80));
    public static final ConfiguredFeature<?, ?> MOSSY_NETHERRACK_PILLARS = createConfiguredFeature("mossy_netherrack_pillars", BYGFeatures.PILLARS.withConfiguration(new SimpleBlockProviderConfig(new SimpleBlockStateProvider(BYGBlocks.MOSSY_NETHERRACK.getDefaultState()))).range(128).square().func_242731_b(50));
    public static final ConfiguredFeature<?, ?> SYTHIAN_FUNGUS_PILLARS = createConfiguredFeature("sythian_fungus_pillars", BYGFeatures.PILLARS.withConfiguration(new SimpleBlockProviderConfig(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.SYTHIAN_HYPHAE.getDefaultState(), 9).addWeightedBlockstate(BYGBlocks.SYTHIAN_HYPHAE.getDefaultState(), 1))).range(128).square().func_242731_b(50));
    public static final ConfiguredFeature<?, ?> HANGING_BONE_FEATURE = createConfiguredFeature("hanging_bone", BYGFeatures.HANGING_FEATURE.withConfiguration(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.BONE_BLOCK).setBlock(BYGBlocks.HANGING_BONE).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(BYGBlocks.QUARTZITE_SAND, Blocks.BONE_BLOCK)).build()).range(128).square().func_242731_b(70));
    public static final ConfiguredFeature<?, ?> LAMENT_VINE_FEATURE = createConfiguredFeature("lament_vine", BYGFeatures.HANGING_FEATURE.withConfiguration(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.NETHERRACK).setBlock(BYGBlocks.LAMENT_VINE_PLANT).setEndBlock(BYGBlocks.LAMENT_VINE.getDefaultState().with(AbstractTopPlantBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.NETHERRACK)).build()).range(128).square().func_242731_b(70));


    public static final ConfiguredFeature<?, ?> HANGING_THERIUM_LANTERNS = createConfiguredFeature("hanging_therium_lanterns", BYGFeatures.HANGING_FEATURE.withConfiguration(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.ETHER_STONE).setBlock(Blocks.CHAIN.getDefaultState()).setEndBlock(BYGBlocks.THERIUM_LANTERN.getDefaultState().with(LanternBlock.HANGING, true)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(BYGBlocks.ETHER_STONE)).build()).range(256).square().func_242731_b(80));
    public static final ConfiguredFeature<?, ?> HANGING_SHULKREN_VINE = createConfiguredFeature("hanging_shulkren_vine", BYGFeatures.HANGING_FEATURE.withConfiguration(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.END_STONE).setBlock(BYGBlocks.SHULKREN_VINE_PLANT.getDefaultState()).setEndBlock(BYGBlocks.SHULKREN_VINE.getDefaultState().with(AbstractTopPlantBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.END_STONE, BYGBlocks.SHULKREN_PHYLIUM)).build()).range(256).square().func_242731_b(80));

    public static final ConfiguredFeature<?, ?> RANDOM_JUNGLE_FLOWERS = createConfiguredFeature("jungle_flowers", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BISTORT.withChance(0.50F),
            GUZMANIA.withChance(0.50F),
            BEGONIA.withChance(0.50F),
            LAZARUS_BELLFLOWER.withChance(0.50F),
            RICHEA.withChance(0.50F),
            TORCH_GINGER.withChance(0.50F)),
            INCAN_LILY)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(5));


    public static final ConfiguredFeature<?, ?> AZALEAS = createConfiguredFeature("azaleas", AZALEA.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> SUNFLOWERS = createConfiguredFeature("sunflowers",  Features.PATCH_SUNFLOWER.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> JAPANESE_ORCHIDS = createConfiguredFeature("japanese_orchids",  Features.PATCH_SUNFLOWER.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> DELPHINIUMS = createConfiguredFeature("delphiniums",  DELPHINIUM.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> WILTED_GRASS = createConfiguredFeature("wilted_grass",  WILTED_GRASS_PATCH.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> WEED_GRASS = createConfiguredFeature("weed_grass",  WEED_GRASS_PATCH.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> WINTER_GRASS = createConfiguredFeature("winter_grass",  WINTER_GRASS_PATCH.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> LEAF_PILES = createConfiguredFeature("leaf_piles",  LEAF_PILE.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> WAILING_VINES = createConfiguredFeature("wailing_vines",  WAILING_VINE.range(128).square().func_242731_b(100));
    public static final ConfiguredFeature<?, ?> ROSES = createConfiguredFeature("roses",  ROSE.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> ANGELICAS = createConfiguredFeature("angelicas",  ANGELICA.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> CROCUSES = createConfiguredFeature("crocuses",  CROCUS.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> IRISES = createConfiguredFeature("irises",  IRIS.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> WINTER_ROSES = createConfiguredFeature("winter_roses",  ROSE_WINTER.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> SNOWDROPS = createConfiguredFeature("snowdrops",  SNOWDROP.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> PINK_ALLIUMS = createConfiguredFeature("pink_alliums",  ALLIUM_PINK.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> ORANGE_DAISIES = createConfiguredFeature("orange_daises",  DAISY_ORANGE.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> RED_CORNFLOWERS = createConfiguredFeature("red_cornflowers",  CORNFLOWER_RED.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> FOXGLOVES = createConfiguredFeature("foxgloves",  FOXGLOVE.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> YELLOW_DAFFODILS = createConfiguredFeature("yellow_daffodils",  DAFFODIL_YELLOW.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> ALPINE_BELLFLOWERS = createConfiguredFeature("alpine_bellflowers",  ALPINE_BELLFLOWER.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> WINTER_SCILLAS = createConfiguredFeature("winter_scillas",  WINTER_SCILLA.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> KOVAN_FLOWERS = createConfiguredFeature("kovan_flowers",  KOVAN_FLOWER.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> REEDS = createConfiguredFeature("reeds",  REED.withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> CATTAILS = createConfiguredFeature("cattails",  CATTAIL.withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(20));
    public static final ConfiguredFeature<?, ?> LOLIPOP_FLOWERS = createConfiguredFeature("lolipop_flowers",  LOLIPOP_FLOWER.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> BLACK_ROSES = createConfiguredFeature("black_roses",  ROSE_BLACK.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> CYAN_ROSES = createConfiguredFeature("cyan_roses",  ROSE_CYAN.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> OSIRIA_ROSES = createConfiguredFeature("osiria_roses",  ROSE_OSIRIA.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> FAIRY_SLIPPERS = createConfiguredFeature("fairy_slippers",  FAIRY_SLIPPER.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> NIGHTSHADE_BERRY_BUSHES = createConfiguredFeature("nightshade_berry_bushes",  NIGHTSHADE_BERRY_BUSH.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(1));
    public static final ConfiguredFeature<?, ?> THEREAL_BELLFLOWERS = createConfiguredFeature("thereal_bellflowers",  THEREAL_BELLFLOWER.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));
    public static final ConfiguredFeature<?, ?> ETHER_FOLIAGES = createConfiguredFeature("ether_foliages",  ETHER_FOLIAGE.withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(5));
    public static final ConfiguredFeature<?, ?> VERMILION_SCULK_GROWTHS = createConfiguredFeature("vermilion_sculk_growths",  VERMILION_SCULK_GROWTH.withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(45))));
    public static final ConfiguredFeature<?, ?> VERMILION_SCULK_TENDRIL = createConfiguredFeature("vermilion_sculk_tendril",  VERMILION_SCULK_TENDRILS.withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(80))));
    public static final ConfiguredFeature<?, ?> THERIUM_CRYSTALS = createConfiguredFeature("therium_crystals",  THERIUM_CRYSTAL.withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(65))));
    public static final ConfiguredFeature<?, ?> SHULKREN_MOSSES = createConfiguredFeature("shulkren_mosses",  SHULKREN_MOSS.withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(45))));
    public static final ConfiguredFeature<?, ?> SHULKREN_FUNGI = createConfiguredFeature("shulkren_fungi",  SHULKREN_FUNGUS.withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SWAMP_PLANTS = createConfiguredFeature("swamp_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            TINY_LILY_PAD.withChance(0.50F)),
            WATER_SILK)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(3));

    public static final ConfiguredFeature<?, ?> RANDOM_LILY_PADS = createConfiguredFeature("lily_pads", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            TINY_LILY_PAD.withChance(0.50F)),
            Features.PATCH_WATERLILLY)).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(3));

    public static final ConfiguredFeature<?, ?> RANDOM_CLOVER_FLOWER_PATCH = createConfiguredFeature("clover_flower_patch", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CLOVER_PATCH.withChance(0.5F)),
            FLOWER_PATCH)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_CHERRY_FOLIAGE = createConfiguredFeature("cherry_foliage", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WHITE_CHERRY_FOLIAGE.withChance(0.5F)),
            PINK_CHERRY_FOLIAGE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(20));

    public static final ConfiguredFeature<?, ?> RANDOM_WARPED_DESERT_VEGETATION = createConfiguredFeature("warped_desert_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WARPED_BUSH.withChance(0.25F),
            WARPED_CORAL.withChance(0.25F),
            WARPED_CORAL_FAN.withChance(0.25F)),
            WARPED_CACTI)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(16))));

    public static final ConfiguredFeature<?, ?> RANDOM_SCORCHED_PLANT = createConfiguredFeature("scorched_plant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SCORCHED_GRASS.withChance(0.6F)),
            SCORCHED_BUSH)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> RANDOM_LAMENT_VEGETATION = createConfiguredFeature("lament_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SCORCHED_BUSH.withChance(0.2F),
            SCORCHED_GRASS.withChance(0.2F)),
            LAMENT_SPROUTS)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> RANDOM_WAILING_VEGETATION = createConfiguredFeature("wailing_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SCORCHED_BUSH.withChance(0.2F),
            SCORCHED_GRASS.withChance(0.2F)),
            WAILING_GRASS)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(50))));

    public static final ConfiguredFeature<?, ?> RANDOM_ANEMONE = createConfiguredFeature("anemones", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ANEMONE_PINK.withChance(0.5F)),
            ANEMONE_WHITE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_SAGE = createConfiguredFeature("sages", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SAGE_PURPLE.withChance(0.5F)),
            SAGE_WHITE)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_TULIP = createConfiguredFeature("tulips", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            TULIP_MAGENTA.withChance(0.5F),
            TULIP_YELLOW.withChance(0.5F),
            TULIP_PURPLE.withChance(0.5F),
            TULIP_CYAN.withChance(0.5F)),
            TULIP_GREEN)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(4));

    public static final ConfiguredFeature<?, ?> RANDOM_ORCHID = createConfiguredFeature("orchids", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ORCHID_PINK.withChance(0.5F),
            ORCHID_PURPLE.withChance(0.5F)),
            ORCHID_RED)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_LEATHER_FLOWER = createConfiguredFeature("leather_flowers", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            LEATHER_FLOWER_PEACH.withChance(0.5F)),
            LEATHER_FLOWER_VIOLET)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_DAFFODILS = createConfiguredFeature("daffodils", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DAFFODIL.withChance(0.5F)),
            DAFFODIL_PINK)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.PATCH_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_IVIS_PLANTS = createConfiguredFeature("ivis_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            IVIS_ROOTS.withChance(0.5F)),
            IVIS_SPROUT)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(5));

    public static final ConfiguredFeature<?, ?> RANDOM_BULBIS_ODDITY = createConfiguredFeature("bulbis_oddities", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BULBIS_ODDITY.withChance(0.5F)),
            PURPLE_BULBIS_ODDITY)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(1));

    public static final ConfiguredFeature<?, ?> RANDOM_BULBIS_ANOMALY = createConfiguredFeature("bulbis_anomalies", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BULBIS_ANOMALY.withChance(0.5F)),
            PURPLE_BULBIS_ANOMALY)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(1));

    public static final ConfiguredFeature<?, ?> RANDOM_ETHER_PLANT = createConfiguredFeature("ether_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            TALL_ETHER_GRASS.withChance(0.35F),
            ETHER_BUSH.withChance(0.2F)),
            ETHER_GRASS)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(8));

    public static final ConfiguredFeature<?, ?> RANDOM_NIGHTSHADE_PLANT = createConfiguredFeature("nightshade_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            NIGHTSHADE_ROOTS.withChance(0.35F)),
            NIGHTSHADE_SPROUTS)).withPlacement(Features.Placements.FIRE_PLACEMENT).func_242731_b(5));

    public static final ConfiguredFeature<?, ?> RANDOM_ODDITY_PLANT = createConfiguredFeature("oddity_plants", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ODDITY_CACTUS.withChance(0.5F)),
            ODDITY_BUSH)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(16))));

    public static final ConfiguredFeature<?, ?> RANDOM_CRYPTIC_VENT = createConfiguredFeature("rs_cryptic_vent", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CRYPTIC_VENT.withChance(0.50F)),
            TALL_CRYPTIC_VENT)).withPlacement(Features.Placements.VEGETATION_PLACEMENT).func_242731_b(2));

    public static final ConfiguredFeature<?, ?> RANDOM_DEAD_SEA_SPIKE = createConfiguredFeature("dead_sea_spikes", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEAD_SEA_SPIKE.withChance(0.75F)),
            DEAD_SEA_SPIKE_TALL)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(28, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_PUMPKIN_PATCH = createConfiguredFeature("large_pumpkin", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PUMPKIN.withChance(0.45F),
            PUMPKIN1.withChance(0.4F)),
            PUMPKIN2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.3F, 1))));


    /***********************************************************Configured Tree Features********************************************************/

    public static final ConfiguredFeature<?, ?> DUMMY_TREE = createConfiguredFeature("dummy_trees", BYGFeatures.DUMMY_TREE.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10000, 0.4F, 8))));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ARAUCARIA_TREE1 = createConfiguredFeature("araucaria_tree1", BYGFeatures.ARAUCARIA_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.ARAUCARIA_LEAVES).setMaxHeight(24).setMinHeight(16).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ARAUCARIA_TREE2 = createConfiguredFeature("araucaria_tree2", BYGFeatures.ARAUCARIA_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.ARAUCARIA_LEAVES).setMaxHeight(24).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ANCIENT_TREE1 = createConfiguredFeature("ancient_tree1", BYGFeatures.ANCIENT_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).setMaxHeight(25).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ANCIENT_TREE2 = createConfiguredFeature("ancient_tree2", BYGFeatures.ANCIENT_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(25).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ANCIENT_TREE3 = createConfiguredFeature("ancient_tree3", BYGFeatures.ANCIENT_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES).setMaxHeight(25).setMinHeight(15).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ASPEN_SHRUB1 = createConfiguredFeature("aspen_shrub1", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ASPEN_SHRUB2 = createConfiguredFeature("aspen_shrub2", BYGFeatures.SHRUB2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ASPEN_TREE1 = createConfiguredFeature("aspen_tree1", BYGFeatures.ASPEN_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMaxHeight(10).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ASPEN_TREE2 = createConfiguredFeature("aspen_tree2", BYGFeatures.ASPEN_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMaxHeight(16).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ASPEN_TREE3 = createConfiguredFeature("aspen_tree3", BYGFeatures.ASPEN_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ASPEN_LOG).setLeavesBlock(BYGBlocks.ASPEN_LEAVES).setMaxHeight(16).setMinHeight(9).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> BAOBAB_TREE1 = createConfiguredFeature("baobab_tree1", BYGFeatures.BAOBAB_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BAOBAB_LOG).setLeavesBlock(BYGBlocks.BAOBAB_LEAVES).setMaxHeight(28).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BAOBAB_TREE2 = createConfiguredFeature("baobab_tree2", BYGFeatures.BAOBAB_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BAOBAB_LOG).setLeavesBlock(BYGBlocks.BAOBAB_LEAVES).setMaxHeight(28).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BAOBAB_TREE3 = createConfiguredFeature("baobab_tree3", BYGFeatures.BAOBAB_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BAOBAB_LOG).setLeavesBlock(BYGBlocks.BAOBAB_LEAVES).setMaxHeight(28).setMinHeight(20).build()));

    //Birch
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_TREE1 = createConfiguredFeature("birch_tree1", BYGFeatures.BIRCH_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_TREE2 = createConfiguredFeature("birch_tree2", BYGFeatures.BIRCH_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).setMaxHeight(13).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_TREE3 = createConfiguredFeature("birch_tree3", BYGFeatures.BIRCH_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).setMaxHeight(28).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_TREE4 = createConfiguredFeature("birch_tree4", BYGFeatures.BIRCH_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).setMaxHeight(11).setMinHeight(8).build()));


    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_BROWN_TREE1 = createConfiguredFeature("brown_birch_tree1", BYGFeatures.BIRCH_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE1.config).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_BROWN_TREE2 = createConfiguredFeature("brown_birch_tree2", BYGFeatures.BIRCH_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE2.config).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_BROWN_TREE3 = createConfiguredFeature("brown_birch_tree3", BYGFeatures.BIRCH_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE3.config).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_BROWN_TREE4 = createConfiguredFeature("brown_birch_tree4", BYGFeatures.BIRCH_TREE4.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE4.config).setLeavesBlock(BYGBlocks.BROWN_BIRCH_LEAVES).build()));


    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_ORANGE_TREE1 = createConfiguredFeature("orange_birch_tree1", BYGFeatures.BIRCH_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE1.config).setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_ORANGE_TREE2 = createConfiguredFeature("orange_birch_tree2", BYGFeatures.BIRCH_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE2.config).setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_ORANGE_TREE3 = createConfiguredFeature("orange_birch_tree3", BYGFeatures.BIRCH_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE3.config).setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_ORANGE_TREE4 = createConfiguredFeature("orange_birch_tree4", BYGFeatures.BIRCH_TREE4.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE4.config).setLeavesBlock(BYGBlocks.ORANGE_BIRCH_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_RED_TREE1 = createConfiguredFeature("red_birch_tree1", BYGFeatures.BIRCH_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE1.config).setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_RED_TREE2 = createConfiguredFeature("red_birch_tree2", BYGFeatures.BIRCH_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE2.config).setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_RED_TREE3 = createConfiguredFeature("red_birch_tree3", BYGFeatures.BIRCH_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE3.config).setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_RED_TREE4 = createConfiguredFeature("red_birch_tree4", BYGFeatures.BIRCH_TREE4.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE4.config).setLeavesBlock(BYGBlocks.RED_BIRCH_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_YELLOW_TREE1 = createConfiguredFeature("yellow_birch_tree1", BYGFeatures.BIRCH_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE1.config).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_YELLOW_TREE2 = createConfiguredFeature("yellow_birch_tree2", BYGFeatures.BIRCH_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE2.config).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_YELLOW_TREE3 = createConfiguredFeature("yellow_birch_tree3", BYGFeatures.BIRCH_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE3.config).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_YELLOW_TREE4 = createConfiguredFeature("yellow_birch_tree4", BYGFeatures.BIRCH_TREE4.withConfiguration(new BYGTreeConfig.Builder().copy(BIRCH_TREE4.config).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> BLUFF_TREE1 = createConfiguredFeature("bluff_tree1", BYGFeatures.BLUFF_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(21).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BLUFF_TREE2 = createConfiguredFeature("bluff_tree2", BYGFeatures.BLUFF_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(11).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BLUFF_TREE3 = createConfiguredFeature("bluff_tree3", BYGFeatures.BLUFF_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_BOREAL_TREE1 = createConfiguredFeature("birch_boreal_tree1", BYGFeatures.BOREAL_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(BYGBlocks.YELLOW_BIRCH_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BIRCH_YELLOW_BOREAL_TREE1 = createConfiguredFeature("birch_yellow_boreal_tree1", BYGFeatures.BOREAL_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.BIRCH_LOG).setLeavesBlock(Blocks.BIRCH_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BOREAL_TREE2 = createConfiguredFeature("boreal_tree2", BYGFeatures.BOREAL_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(15).setMinHeight(11).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> CHERRY_PINK_TREE1 = createConfiguredFeature("pink_cherry_tree1", BYGFeatures.CHERRY_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.PINK_CHERRY_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CHERRY_PINK_TREE2 = createConfiguredFeature("pink_cherry_tree2", BYGFeatures.CHERRY_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.PINK_CHERRY_LEAVES).setMaxHeight(13).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CHERRY_WHITE_TREE1 = createConfiguredFeature("white_cherry_tree1", BYGFeatures.CHERRY_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.WHITE_CHERRY_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CHERRY_WHITE_TREE2 = createConfiguredFeature("white_cherry_tree2", BYGFeatures.CHERRY_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CHERRY_LOG).setLeavesBlock(BYGBlocks.WHITE_CHERRY_LEAVES).setMaxHeight(13).setMinHeight(8).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> CIKA_TREE1 = createConfiguredFeature("cika_tree1", BYGFeatures.CIKA_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CIKA_LOG).setLeavesBlock(BYGBlocks.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CIKA_TREE2 = createConfiguredFeature("cika_tree2", BYGFeatures.CIKA_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CIKA_LOG).setLeavesBlock(BYGBlocks.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CIKA_TREE3 = createConfiguredFeature("cika_tree3", BYGFeatures.CIKA_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CIKA_LOG).setLeavesBlock(BYGBlocks.CIKA_LEAVES).setMaxHeight(21).setMinHeight(14).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE1 = createConfiguredFeature("conifer_tree1", BYGFeatures.CONIFER_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(25).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE2 = createConfiguredFeature("conifer_tree2", BYGFeatures.CONIFER_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(30).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE3 = createConfiguredFeature("conifer_tree3", BYGFeatures.CONIFER_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(35).setMinHeight(26).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE4 = createConfiguredFeature("conifer_tree4", BYGFeatures.CONIFER_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(35).setMinHeight(25).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE5 = createConfiguredFeature("conifer_tree5", BYGFeatures.CONIFER_TREE5.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(21).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE6 = createConfiguredFeature("conifer_tree6", BYGFeatures.CONIFER_TREE6.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(17).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE7 = createConfiguredFeature("conifer_tree7", BYGFeatures.CONIFER_TREE7.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(28).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CONIFER_TREE8 = createConfiguredFeature("conifer_tree8", BYGFeatures.CONIFER_TREE8.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.FIR_LOG).setLeavesBlock(BYGBlocks.FIR_LEAVES).setMaxHeight(28).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> CYPRESS_TREE1 = createConfiguredFeature("cypress_tree1", BYGFeatures.CYPRESS_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CYPRESS_LOG).setLeavesBlock(BYGBlocks.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CYPRESS_TREE2 = createConfiguredFeature("cypress_tree2", BYGFeatures.CYPRESS_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CYPRESS_LOG).setLeavesBlock(BYGBlocks.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> CYPRESS_TREE3 = createConfiguredFeature("cypress_tree3", BYGFeatures.CYPRESS_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.CYPRESS_LOG).setLeavesBlock(BYGBlocks.CYPRESS_LEAVES).setMaxHeight(30).setMinHeight(20).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> DEAD_HAZEL_TREE1 = createConfiguredFeature("dead_hazel_tree1", BYGFeatures.DEAD_HAZEL_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(15).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DEAD_HAZEL_TREE2 = createConfiguredFeature("dead_hazel_tree2", BYGFeatures.DEAD_HAZEL_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DEAD_HAZEL_TREE3 = createConfiguredFeature("dead_hazel_tree3", BYGFeatures.DEAD_HAZEL_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(16).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DEAD_HAZEL_TREE4 = createConfiguredFeature("dead_hazel_tree4", BYGFeatures.DEAD_HAZEL_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITCH_HAZEL_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.WITCH_HAZEL_LEAVES.getDefaultState(), 4)).setMaxHeight(7).setMinHeight(5).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_SEASONAL_SHRUB = createConfiguredFeature("seasonal_deciduous_shrub", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMinHeight(2).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_TREE1 = createConfiguredFeature("deciduous_tree1", BYGFeatures.DECIDUOUS_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(19).setMinHeight(14).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_TREE2 = createConfiguredFeature("deciduous_tree2", BYGFeatures.DECIDUOUS_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(22).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_TREE3 = createConfiguredFeature("deciduous_tree3", BYGFeatures.DECIDUOUS_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(21).setMinHeight(16).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_TREE4 = createConfiguredFeature("deciduous_tree4", BYGFeatures.DECIDUOUS_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_RED_TREE1 = createConfiguredFeature("deciduous_red_tree1", BYGFeatures.DECIDUOUS_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_RED_TREE2 = createConfiguredFeature("deciduous_red_tree2", BYGFeatures.DECIDUOUS_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_RED_TREE3 = createConfiguredFeature("deciduous_red_tree3", BYGFeatures.DECIDUOUS_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_RED_TREE4 = createConfiguredFeature("deciduous_red_tree4", BYGFeatures.DECIDUOUS_TREE4.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_ORANGE_TREE1 = createConfiguredFeature("deciduous_orange_tree1", BYGFeatures.DECIDUOUS_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_ORANGE_TREE2 = createConfiguredFeature("deciduous_orange_tree2", BYGFeatures.DECIDUOUS_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_ORANGE_TREE3 = createConfiguredFeature("deciduous_orange_tree3", BYGFeatures.DECIDUOUS_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_ORANGE_TREE4 = createConfiguredFeature("deciduous_orange_tree4", BYGFeatures.DECIDUOUS_TREE4.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_BROWN_TREE1 = createConfiguredFeature("deciduous_brown_tree1", BYGFeatures.DECIDUOUS_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE1.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_BROWN_TREE2 = createConfiguredFeature("deciduous_brown_tree2", BYGFeatures.DECIDUOUS_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE2.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_BROWN_TREE3 = createConfiguredFeature("deciduous_brown_tree3", BYGFeatures.DECIDUOUS_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE3.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> DECIDUOUS_BROWN_TREE4 = createConfiguredFeature("deciduous_brown_tree4", BYGFeatures.DECIDUOUS_TREE4.withConfiguration(new BYGTreeConfig.Builder().copy(DECIDUOUS_TREE4.config).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> EBONY_BUSH1 = createConfiguredFeature("ebony_bush1", BYGFeatures.EBONY_BUSH1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(28).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> EBONY_TREE1 = createConfiguredFeature("ebony_tree1", BYGFeatures.EBONY_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(13).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> EBONY_TREE2 = createConfiguredFeature("ebony_tree2", BYGFeatures.EBONY_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.EBONY_LOG).setLeavesBlock(BYGBlocks.EBONY_LEAVES).setMaxHeight(17).setMinHeight(11).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_BLUE_TREE1 = createConfiguredFeature("blue_enchanted_tree1", BYGFeatures.ENCHANTED_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_BLUE_TREE2 = createConfiguredFeature("blue_enchanted_tree2", BYGFeatures.ENCHANTED_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(26).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_BLUE_TREE3 = createConfiguredFeature("blue_enchanted_tree3", BYGFeatures.ENCHANTED_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_GREEN_TREE1 = createConfiguredFeature("green_enchanted_tree1", BYGFeatures.ENCHANTED_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(ENCHANTED_BLUE_TREE1.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_GREEN_TREE2 = createConfiguredFeature("green_enchanted_tree2", BYGFeatures.ENCHANTED_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(ENCHANTED_BLUE_TREE2.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_GREEN_TREE3 = createConfiguredFeature("green_enchanted_tree3", BYGFeatures.ENCHANTED_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(ENCHANTED_BLUE_TREE3.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_BLUE_GROVE_TREE1 = createConfiguredFeature("blue_enchanted_grove_tree1", BYGFeatures.ENCHANTED_GROVE_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.BLUE_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.BLUE_ENCHANTED_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ENCHANTED_GREEN_GROVE_TREE1 = createConfiguredFeature("green_enchanted_grove_tree1", BYGFeatures.ENCHANTED_GROVE_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(ENCHANTED_BLUE_TREE1.config).setTrunkBlock(BYGBlocks.GREEN_ENCHANTED_LOG).setLeavesBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> HOLLY_TREE1 = createConfiguredFeature("holly_tree1", BYGFeatures.HOLLY_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(23).setMinHeight(17).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> HOLLY_TREE2 = createConfiguredFeature("holly_tree2", BYGFeatures.HOLLY_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(15).setMinHeight(10).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> HOLLY_TREE3 = createConfiguredFeature("holly_tree3", BYGFeatures.HOLLY_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(25).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> HOLLY_TREE4 = createConfiguredFeature("holly_tree4", BYGFeatures.HOLLY_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.HOLLY_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.HOLLY_BERRY_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.HOLLY_LEAVES.getDefaultState(), 10)).setMaxHeight(14).setMinHeight(9).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> JACARANDA_TREE1 = createConfiguredFeature("jacaranda_tree1", BYGFeatures.JACARANDA_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.JACARANDA_LOG).setLeavesBlock(BYGBlocks.JACARANDA_LEAVES).setMaxHeight(15).setMinHeight(9).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> JACARANDA_TREE2 = createConfiguredFeature("jacaranda_tree2", BYGFeatures.JACARANDA_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.JACARANDA_LOG).setLeavesBlock(BYGBlocks.JACARANDA_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> INDIGO_JACARANDA_TREE1 = createConfiguredFeature("indigo_jacaranda_tree1", BYGFeatures.JACARANDA_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(JACARANDA_TREE1.config).setLeavesBlock(BYGBlocks.INDIGO_JACARANDA_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> INDIGO_JACARANDA_TREE2 = createConfiguredFeature("indigo_jacaranda_tree2", BYGFeatures.JACARANDA_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(JACARANDA_TREE2.config).setLeavesBlock(BYGBlocks.INDIGO_JACARANDA_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> JOSHUA_TREE1 = createConfiguredFeature("joshua_tree1", BYGFeatures.JOSHUA_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.RIPE_JOSHUA_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.JOSHUA_LEAVES.getDefaultState(), 10)).setMaxHeight(6).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> JOSHUA_TREE2 = createConfiguredFeature("joshua_tree2", BYGFeatures.JOSHUA_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.RIPE_JOSHUA_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.JOSHUA_LEAVES.getDefaultState(), 10)).setMaxHeight(6).setMinHeight(3).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> MANGROVE_TREE1 = createConfiguredFeature("mangrove_tree1", BYGFeatures.MANGROVE_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(15).setMinHeight(10).setWhitelist(ImmutableList.of(BYGBlocks.MOSSY_STONE)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MANGROVE_TREE2 = createConfiguredFeature("mangrove_tree2", BYGFeatures.MANGROVE_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(17).setMinHeight(11).setWhitelist(ImmutableList.of(BYGBlocks.MOSSY_STONE)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MANGROVE_TREE3 = createConfiguredFeature("mangrove_tree3", BYGFeatures.MANGROVE_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(16).setMinHeight(12).setWhitelist(ImmutableList.of(BYGBlocks.MOSSY_STONE)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MANGROVE_TREE4 = createConfiguredFeature("mangrove_tree4", BYGFeatures.MANGROVE_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(15).setMinHeight(10).setWhitelist(ImmutableList.of(BYGBlocks.MOSSY_STONE)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MANGROVE_TREE5 = createConfiguredFeature("mangrove_tree5", BYGFeatures.MANGROVE_TREE5.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MANGROVE_LOG).setLeavesBlock(BYGBlocks.MANGROVE_LEAVES).setMaxHeight(17).setMinHeight(11).setWhitelist(ImmutableList.of(BYGBlocks.MOSSY_STONE)).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> MAPLE_RED_TREE1 = createConfiguredFeature("red_maple_tree1", BYGFeatures.MAPLE_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.RED_MAPLE_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAPLE_RED_TREE2 = createConfiguredFeature("red_maple_tree2", BYGFeatures.MAPLE_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.RED_MAPLE_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAPLE_SILVER_TREE1 = createConfiguredFeature("silver_maple_tree1", BYGFeatures.MAPLE_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(MAPLE_RED_TREE1.config).setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAPLE_SILVER_TREE2 = createConfiguredFeature("silver_maple_tree2", BYGFeatures.MAPLE_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(MAPLE_RED_TREE2.config).setLeavesBlock(BYGBlocks.SILVER_MAPLE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAPLE_TREE1 = createConfiguredFeature("maple_tree1", BYGFeatures.MAPLE_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAPLE_LOG).setLeavesBlock(BYGBlocks.MAPLE_LEAVES).setMaxHeight(10).setMinHeight(5).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> MEADOW_TREE1 = createConfiguredFeature("meadow_tree1", BYGFeatures.MEADOW_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MEADOW_TREE2 = createConfiguredFeature("meadow_tree2", BYGFeatures.MEADOW_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MEADOW_TREE3 = createConfiguredFeature("meadow_tree3", BYGFeatures.MEADOW_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.DARK_OAK_LEAVES).setMaxHeight(9).setMinHeight(4).build()));

    //Oak
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE1 = createConfiguredFeature("oak_tree1", BYGFeatures.OAK_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE2 = createConfiguredFeature("oak_tree2", BYGFeatures.OAK_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE3 = createConfiguredFeature("oak_tree3", BYGFeatures.OAK_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE_LARGE1 = createConfiguredFeature("large_oak_tree1", BYGFeatures.OAK_TREE_LARGE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE_LARGE2 = createConfiguredFeature("large_oak_tree2", BYGFeatures.OAK_TREE_LARGE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> OAK_TREE_LARGE3 = createConfiguredFeature("large_oak_tree3", BYGFeatures.OAK_TREE_LARGE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(18).setMinHeight(13).setDiskBlock(Blocks.PODZOL).setDiskRadius(3).build()));

    //Red Oak
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE1 = createConfiguredFeature("red_oak_tree1", BYGFeatures.OAK_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE2 = createConfiguredFeature("red_oak_tree2", BYGFeatures.OAK_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE3 = createConfiguredFeature("red_oak_tree3", BYGFeatures.OAK_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE_LARGE1 = createConfiguredFeature("large_red_oak_tree1", BYGFeatures.OAK_TREE_LARGE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE_LARGE2 = createConfiguredFeature("large_red_oak_tree2", BYGFeatures.OAK_TREE_LARGE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RED_OAK_TREE_LARGE3 = createConfiguredFeature("large_red_oak_tree3", BYGFeatures.OAK_TREE_LARGE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.RED_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).setDiskBlock(Blocks.PODZOL).setDiskRadius(3).build()));

    //Brown Oak
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE1 = createConfiguredFeature("brown_oak_tree1", BYGFeatures.OAK_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE2 = createConfiguredFeature("brown_oak_tree2", BYGFeatures.OAK_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE3 = createConfiguredFeature("brown_oak_tree3", BYGFeatures.OAK_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE_LARGE1 = createConfiguredFeature("large_brown_oak_tree1", BYGFeatures.OAK_TREE_LARGE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE_LARGE2 = createConfiguredFeature("large_brown_oak_tree2", BYGFeatures.OAK_TREE_LARGE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> BROWN_OAK_TREE_LARGE3 = createConfiguredFeature("large_brown_oak_tree3", BYGFeatures.OAK_TREE_LARGE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.BROWN_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).setDiskBlock(Blocks.PODZOL).setDiskRadius(3).build()));

    //Orange Oak
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE1 = createConfiguredFeature("orange_oak_tree1", BYGFeatures.OAK_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE2 = createConfiguredFeature("orange_oak_tree2", BYGFeatures.OAK_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE3 = createConfiguredFeature("orange_oak_tree3", BYGFeatures.OAK_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE_LARGE1 = createConfiguredFeature("large_orange_oak_tree1", BYGFeatures.OAK_TREE_LARGE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE_LARGE2 = createConfiguredFeature("large_orange_oak_tree2", BYGFeatures.OAK_TREE_LARGE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORANGE_OAK_TREE_LARGE3 = createConfiguredFeature("large_orange_oak_tree3", BYGFeatures.OAK_TREE_LARGE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(BYGBlocks.ORANGE_OAK_LEAVES).setMaxHeight(18).setMinHeight(13).setDiskBlock(Blocks.PODZOL).setDiskRadius(3).build()));

    //Orchard
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORCHARD_TREE1 = createConfiguredFeature("orchard_tree1", BYGFeatures.ORCHARD_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ORCHARD_LEAVES.getDefaultState(), 10).addWeightedBlockstate(BYGBlocks.FLOWERING_ORCHARD_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.RIPE_ORCHARD_LEAVES.getDefaultState(), 1)).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORCHARD_TREE2 = createConfiguredFeature("orchard_tree2", BYGFeatures.ORCHARD_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ORCHARD_LEAVES.getDefaultState(), 10).addWeightedBlockstate(BYGBlocks.FLOWERING_ORCHARD_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.RIPE_ORCHARD_LEAVES.getDefaultState(), 1)).setMaxHeight(26).setMinHeight(21).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ORCHARD_TREE3 = createConfiguredFeature("orchard_tree3", BYGFeatures.ORCHARD_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.ORCHARD_LEAVES.getDefaultState(), 10).addWeightedBlockstate(BYGBlocks.FLOWERING_ORCHARD_LEAVES.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.RIPE_ORCHARD_LEAVES.getDefaultState(), 1)).setMaxHeight(12).setMinHeight(9).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> PALM_TREE1 = createConfiguredFeature("palm_tree1", BYGFeatures.PALM_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PALM_TREE2 = createConfiguredFeature("palm_tree2", BYGFeatures.PALM_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PALM_TREE3 = createConfiguredFeature("palm_tree3", BYGFeatures.PALM_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PALM_TREE4 = createConfiguredFeature("palm_tree4", BYGFeatures.PALM_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALM_LOG).setLeavesBlock(BYGBlocks.PALM_LEAVES).setMaxHeight(5).setMinHeight(3).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> PINE_LARGE_TREE1 = createConfiguredFeature("large_pine_tree1", BYGFeatures.PINE_LARGE_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(28).setMinHeight(23).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PINE_LARGE_TREE2 = createConfiguredFeature("large_pine_tree2", BYGFeatures.PINE_LARGE_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(31).setMinHeight(26).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PINE_TREE1 = createConfiguredFeature("pine_tree1", BYGFeatures.PINE_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(20).setMinHeight(15).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PINE_TREE2 = createConfiguredFeature("pine_tree2", BYGFeatures.PINE_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PINE_LOG).setLeavesBlock(BYGBlocks.PINE_LEAVES).setMaxHeight(21).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> PALO_VERDE_TREE1 = createConfiguredFeature("palo_verde_tree1", BYGFeatures.PALO_VERDE_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALO_VERDE_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.PALO_VERDE_LEAVES.getDefaultState(), 6).addWeightedBlockstate(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES.getDefaultState(), 1)).setMaxHeight(1).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> PALO_VERDE_TREE2 = createConfiguredFeature("palo_verde_tree2", BYGFeatures.PALO_VERDE_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.PALO_VERDE_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.PALO_VERDE_LEAVES.getDefaultState(), 6).addWeightedBlockstate(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES.getDefaultState(), 1)).setMaxHeight(2).setMinHeight(1).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> RAINBOW_TREE1 = createConfiguredFeature("rainbow_eucalyptus_tree1", BYGFeatures.RAINBOW_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LOG).setLeavesBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES).setMaxHeight(32).setMinHeight(27).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> RAINBOW_LARGE_TREE1 = createConfiguredFeature("large_rainbow_eucalyptus_tree1", BYGFeatures.RAINBOW_LARGE_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LOG).setLeavesBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES).setMaxHeight(19).setMinHeight(16).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> REDWOOD_TREE1 = createConfiguredFeature("redwood_tree1", BYGFeatures.REDWOOD_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.REDWOOD_LOG).setLeavesBlock(BYGBlocks.REDWOOD_LEAVES).setMaxHeight(37).setMinHeight(36).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> REDWOOD_TREE2 = createConfiguredFeature("redwood_tree2", BYGFeatures.REDWOOD_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.REDWOOD_LOG).setLeavesBlock(BYGBlocks.REDWOOD_LEAVES).setMaxHeight(34).setMinHeight(31).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> REDWOOD_TREE3 = createConfiguredFeature("redwood_tree3", BYGFeatures.REDWOOD_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.REDWOOD_LOG).setLeavesBlock(BYGBlocks.REDWOOD_LEAVES).setMaxHeight(25).setMinHeight(18).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SHRUB = createConfiguredFeature("shrub", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SHRUB_MEADOW = createConfiguredFeature("meadow_shrub1", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SHRUB_MEADOW2 = createConfiguredFeature("meadow_shrub2", BYGFeatures.SHRUB2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.DARK_OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(1).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SHRUB_PRAIRIE1 = createConfiguredFeature("prairie_shrub1", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(1).setMaxHeight(2).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SHRUB_PRAIRIE2 = createConfiguredFeature("prairie_shrub2", BYGFeatures.SHRUB2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMinHeight(1).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SKYRIS_TREE1 = createConfiguredFeature("skyris_tree1", BYGFeatures.SKYRIS_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(9).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SKYRIS_TREE2 = createConfiguredFeature("skyris_tree2", BYGFeatures.SKYRIS_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(6).setMinHeight(3).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SKYRIS_TREE3 = createConfiguredFeature("skyris_tree3", BYGFeatures.SKYRIS_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(8).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SKYRIS_TREE4 = createConfiguredFeature("skyris_tree4", BYGFeatures.SKYRIS_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(8).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SKYRIS_TREE5 = createConfiguredFeature("skyris_tree5", BYGFeatures.SKYRIS_TREE5.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.SKYRIS_LOG).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState(), 1).addWeightedBlockstate(BYGBlocks.SKYRIS_LEAVES.getDefaultState(), 8)).setMaxHeight(8).setMinHeight(6).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE1 = createConfiguredFeature("spruce_tree1", BYGFeatures.SPRUCE_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE2 = createConfiguredFeature("spruce_tree2", BYGFeatures.SPRUCE_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE3 = createConfiguredFeature("spruce_tree3", BYGFeatures.SPRUCE_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(16).setMinHeight(12).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE4 = createConfiguredFeature("spruce_tree4", BYGFeatures.SPRUCE_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(17).setMinHeight(12).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE_MEDIUM1 = createConfiguredFeature("spruce_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(24).setMinHeight(19).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE_MEDIUM2 = createConfiguredFeature("spruce_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(25).setMinHeight(20).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE_MEDIUM3 = createConfiguredFeature("spruce_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(26).setMinHeight(21).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE_MEDIUM4 = createConfiguredFeature("spruce_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(25).setMinHeight(19).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_TREE_LARGE1 = createConfiguredFeature("spruce_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.SPRUCE_LOG).setLeavesBlock(Blocks.SPRUCE_LEAVES).setMaxHeight(55).setMinHeight(40).build()));

    //Yellow Spruce
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE1 = createConfiguredFeature("spruce_yellow_tree1", BYGFeatures.SPRUCE_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE2 = createConfiguredFeature("spruce_yellow_tree2", BYGFeatures.SPRUCE_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE3 = createConfiguredFeature("spruce_yellow_tree3", BYGFeatures.SPRUCE_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE4 = createConfiguredFeature("spruce_yellow_tree4", BYGFeatures.SPRUCE_TREE4.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM1 = createConfiguredFeature("spruce_yellow_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM2 = createConfiguredFeature("spruce_yellow_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM3 = createConfiguredFeature("spruce_yellow_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE_MEDIUM4 = createConfiguredFeature("spruce_yellow_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_YELLOW_TREE_LARGE1 = createConfiguredFeature("spruce_yellow_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES).build()));

    //Orange Spruce
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE1 = createConfiguredFeature("spruce_orange_tree1", BYGFeatures.SPRUCE_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE2 = createConfiguredFeature("spruce_orange_tree2", BYGFeatures.SPRUCE_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE3 = createConfiguredFeature("spruce_orange_tree3", BYGFeatures.SPRUCE_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE4 = createConfiguredFeature("spruce_orange_tree4", BYGFeatures.SPRUCE_TREE4.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM1 = createConfiguredFeature("spruce_orange_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM2 = createConfiguredFeature("spruce_orange_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM3 = createConfiguredFeature("spruce_orange_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE_MEDIUM4 = createConfiguredFeature("spruce_orange_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_ORANGE_TREE_LARGE1 = createConfiguredFeature("spruce_orange_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES).build()));

    //Red Spruce
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE1 = createConfiguredFeature("spruce_red_tree1", BYGFeatures.SPRUCE_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE2 = createConfiguredFeature("spruce_red_tree2", BYGFeatures.SPRUCE_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE3 = createConfiguredFeature("spruce_red_tree3", BYGFeatures.SPRUCE_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE4 = createConfiguredFeature("spruce_red_tree4", BYGFeatures.SPRUCE_TREE4.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE_MEDIUM1 = createConfiguredFeature("spruce_red_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE_MEDIUM2 = createConfiguredFeature("spruce_red_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE_MEDIUM3 = createConfiguredFeature("spruce_red_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE_MEDIUM4 = createConfiguredFeature("spruce_red_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_RED_TREE_LARGE1 = createConfiguredFeature("spruce_red_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.RED_SPRUCE_LEAVES).build()));

    //Blue Spruce
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE1 = createConfiguredFeature("spruce_blue_tree1", BYGFeatures.SPRUCE_TREE1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE1.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE2 = createConfiguredFeature("spruce_blue_tree2", BYGFeatures.SPRUCE_TREE2.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE2.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE3 = createConfiguredFeature("spruce_blue_tree3", BYGFeatures.SPRUCE_TREE3.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE3.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE4 = createConfiguredFeature("spruce_blue_tree4", BYGFeatures.SPRUCE_TREE4.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE4.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE_MEDIUM1 = createConfiguredFeature("spruce_blue_tree_medium1", BYGFeatures.SPRUCE_TREE_MEDIUM1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM1.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE_MEDIUM2 = createConfiguredFeature("spruce_blue_tree_medium2", BYGFeatures.SPRUCE_TREE_MEDIUM2.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM2.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE_MEDIUM3 = createConfiguredFeature("spruce_blue_tree_medium3", BYGFeatures.SPRUCE_TREE_MEDIUM3.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM3.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE_MEDIUM4 = createConfiguredFeature("spruce_blue_tree_medium4", BYGFeatures.SPRUCE_TREE_MEDIUM4.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_MEDIUM4.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> SPRUCE_BLUE_TREE_LARGE1 = createConfiguredFeature("spruce_blue_tree_large1", BYGFeatures.SPRUCE_TREE_LARGE1.withConfiguration(new BYGTreeConfig.Builder().copy(SPRUCE_TREE_LARGE1.config).setLeavesBlock(BYGBlocks.BLUE_SPRUCE_LEAVES).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> TROPICAL_SHRUB1 = createConfiguredFeature("tropical_shrub1", BYGFeatures.SHRUB1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMinHeight(2).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> MAHOGANY_TREE1 = createConfiguredFeature("mahogany_tree1", BYGFeatures.MAHOGANY_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAHOGANY_TREE2 = createConfiguredFeature("mahogany_tree2", BYGFeatures.MAHOGANY_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(14).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAHOGANY_TREE3 = createConfiguredFeature("mahogany_tree3", BYGFeatures.MAHOGANY_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(18).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAHOGANY_TREE4 = createConfiguredFeature("mahogany_tree4", BYGFeatures.MAHOGANY_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(24).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> MAHOGANY_TREE5 = createConfiguredFeature("mahogany_tree5", BYGFeatures.MAHOGANY_TREE5.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.MAHOGANY_LOG).setLeavesBlock(BYGBlocks.MAHOGANY_LEAVES).setMaxHeight(31).setMinHeight(25).build()));


    public static final ConfiguredFeature<BYGTreeConfig, ?> WOODLANDS_TREE1 = createConfiguredFeature("woodlands_tree1", BYGFeatures.WOODLANDS_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(Blocks.OAK_LOG).setLeavesBlock(Blocks.OAK_LEAVES).setMaxHeight(5).setMinHeight(25).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_DEAD_TREE1 = createConfiguredFeature("dead_willow_tree1", BYGFeatures.WILLOW_DEAD_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_M_TREE1 = createConfiguredFeature("mutated_willow_tree1", BYGFeatures.WILLOW_M_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(11).setMinHeight(6).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_M_TREE2 = createConfiguredFeature("mutated_willow_tree2", BYGFeatures.WILLOW_M_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_TREE1 = createConfiguredFeature("willow_tree1", BYGFeatures.WILLOW_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(14).setMinHeight(8).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_TREE2 = createConfiguredFeature("willow_tree2", BYGFeatures.WILLOW_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_TREE3 = createConfiguredFeature("willow_tree3", BYGFeatures.WILLOW_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(12).setMinHeight(7).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WILLOW_TREE4 = createConfiguredFeature("willow_tree4", BYGFeatures.WILLOW_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WILLOW_LOG).setLeavesBlock(BYGBlocks.WILLOW_LEAVES).setMaxHeight(21).setMinHeight(13).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_TREE1 = createConfiguredFeature("zelkova_tree1", BYGFeatures.ZELKOVA_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES).setMaxHeight(20).setMinHeight(13).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_TREE2 = createConfiguredFeature("zelkova_tree2", BYGFeatures.ZELKOVA_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES).setMaxHeight(28).setMinHeight(18).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_TREE3 = createConfiguredFeature("zelkova_tree3", BYGFeatures.ZELKOVA_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.ZELKOVA_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_BROWN_TREE1 = createConfiguredFeature("zelkova_brown_tree1", BYGFeatures.ZELKOVA_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES).setMaxHeight(21).setMinHeight(11).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_BROWN_TREE2 = createConfiguredFeature("zelkova_brown_tree2", BYGFeatures.ZELKOVA_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES).setMaxHeight(20).setMinHeight(10).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ZELKOVA_BROWN_TREE3 = createConfiguredFeature("zelkova_brown_tree3", BYGFeatures.ZELKOVA_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ZELKOVA_LOG).setLeavesBlock(BYGBlocks.BROWN_ZELKOVA_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    //Mushrooms
    public static final ConfiguredFeature<BYGMushroomConfig, ?> GREEN_MUSHROOM_HUGE = createConfiguredFeature("huge_green_mushroom", BYGFeatures.GREEN_MUSHROOM_HUGE.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WOOD_BLEWIT_HUGE = createConfiguredFeature("huge_wood_blewit", BYGFeatures.WOOD_BLEWIT_HUGE.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WEEPING_MILKCAP_HUGE = createConfiguredFeature("huge_weeping_milkcap", BYGFeatures.WEEPING_MILKCAP_HUGE.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BLACK_PUFF_HUGE = createConfiguredFeature("huge_black_puff", BYGFeatures.BLACK_PUFF_HUGE.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.PUFF_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BLUE_GLOWSHROOM_HUGE = createConfiguredFeature("huge_blue_glowshroom", BYGFeatures.BLUE_GLOWSHROOM_HUGE.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.YELLOW_GLOWSHROOM_STEM).setMushroomBlock(BYGBlocks.BLUE_GLOWSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_GLOWSHROOM_HUGE = createConfiguredFeature("huge_purple_glowshroom", BYGFeatures.PURPLE_GLOWSHROOM_HUGE.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.RED_GLOWSHROOM_STEM).setMushroomBlock(BYGBlocks.PURPLE_GLOWSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    //Mini Mushrooms
    public static final ConfiguredFeature<?, ?> GREEN_MUSHROOM_MINI = createConfiguredFeature("mini_green_mushroom", BYGFeatures.MINI_GREEN_MUSHROOM.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.GREEN_MUSHROOM_BLOCK).setMinHeight(3).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> WOOD_BLEWIT_MINI = createConfiguredFeature("mini_wood_blewit", BYGFeatures.MINI_WOOD_BLEWIT.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.BLEWIT_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> WEEPING_MILKCAP_MINI = createConfiguredFeature("mini_weeping_milkcap", BYGFeatures.MINI_WEEPING_MILKCAP.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.MILKCAP_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> BLACK_PUFF_MINI = createConfiguredFeature("mini_black_puff", BYGFeatures.MINI_BLACK_PUFF.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BROWN_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.PUFF_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> RED_MUSHROOM_MINI = createConfiguredFeature("mini_red_mushroom", BYGFeatures.MINI_RED_MUSHROOM.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(Blocks.RED_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));
    public static final ConfiguredFeature<?, ?> BROWN_MUSHROOM_MINI = createConfiguredFeature("mini_brown_mushroom", BYGFeatures.MINI_BROWN_MUSHROOM.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(Blocks.BROWN_MUSHROOM_BLOCK).setMinHeight(2).setMaxHeight(3).build()));


    //Nether Mushrooms
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM = createConfiguredFeature("embur_mushroom1", BYGFeatures.EMBUR_MUSHROOM.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM2 = createConfiguredFeature("embur_mushroom2", BYGFeatures.EMBUR_MUSHROOM2.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.EMBUR_PEDU).setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> CRIMSON_FUNGUS1 = createConfiguredFeature("crimson_fungus1", BYGFeatures.CRIMSON_FUNGUS_TREE1.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(Blocks.CRIMSON_STEM).setMushroomBlock(Blocks.NETHER_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> CRIMSON_FUNGUS2 = createConfiguredFeature("crimson_fungus2", BYGFeatures.CRIMSON_FUNGUS_TREE2.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(Blocks.CRIMSON_STEM).setMushroomBlock(Blocks.NETHER_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> WARPED_FUNGUS1 = createConfiguredFeature("warped_fungus1", BYGFeatures.WARPED_FUNGUS_TREE1.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(Blocks.WARPED_STEM).setMushroomBlock(Blocks.WARPED_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WARPED_FUNGUS2 = createConfiguredFeature("warped_fungus2", BYGFeatures.WARPED_FUNGUS_TREE2.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(Blocks.WARPED_STEM).setMushroomBlock(Blocks.WARPED_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE1 = createConfiguredFeature("sythian_fungus_tree1", BYGFeatures.SYTHIAN_FUNGUS_TREE1.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE2 = createConfiguredFeature("sythian_fungus_tree2", BYGFeatures.SYTHIAN_FUNGUS_TREE2.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE3 = createConfiguredFeature("sythian_fungus_tree3", BYGFeatures.SYTHIAN_FUNGUS_TREE3.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE4 = createConfiguredFeature("sythian_fungus_tree4", BYGFeatures.SYTHIAN_FUNGUS_TREE4.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SYTHIAN_STEM).setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE1 = createConfiguredFeature("soul_shroom_tree1", BYGFeatures.SOUL_SHROOM_TREE1.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE2 = createConfiguredFeature("soul_shroom_tree2", BYGFeatures.SOUL_SHROOM_TREE2.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE3 = createConfiguredFeature("soul_shroom_tree3", BYGFeatures.SOUL_SHROOM_TREE3.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.SOUL_SHROOM_STEM).setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE1 = createConfiguredFeature("death_cap_tree1", BYGFeatures.DEATH_CAP_TREE1.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE2 = createConfiguredFeature("death_cap_tree2", BYGFeatures.DEATH_CAP_TREE2.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE3 = createConfiguredFeature("death_cap_tree3", BYGFeatures.DEATH_CAP_TREE3.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(Blocks.MUSHROOM_STEM).setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    //Nether Trees
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE1 = createConfiguredFeature("lament_twisty_tree1", BYGFeatures.LAMENT_TWISTY_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE2 = createConfiguredFeature("lament_twisty_tree2", BYGFeatures.LAMENT_TWISTY_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE3 = createConfiguredFeature("lament_twisty_tree3", BYGFeatures.LAMENT_TWISTY_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE1 = createConfiguredFeature("lament_weeping_tree1", BYGFeatures.LAMENT_WEEPING_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).setWhitelist(ImmutableList.of(Blocks.LAVA)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE2 = createConfiguredFeature("lament_weeping_tree2", BYGFeatures.LAMENT_WEEPING_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).setWhitelist(ImmutableList.of(Blocks.LAVA)).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE3 = createConfiguredFeature("lament_weeping_tree3", BYGFeatures.LAMENT_WEEPING_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.LAMENT_LOG).setLeavesBlock(BYGBlocks.LAMENT_LEAVES).setMaxHeight(30).setMinHeight(22).setWhitelist(ImmutableList.of(Blocks.LAVA)).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> WITHERING_OAK_TREE1 = createConfiguredFeature("withering_oak_tree1", BYGFeatures.WITHERING_OAK_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITHERING_OAK_LOG).setLeavesBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WITHERING_OAK_TREE2 = createConfiguredFeature("withering_oak_tree2", BYGFeatures.WITHERING_OAK_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITHERING_OAK_LOG).setLeavesBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WITHERING_OAK_TREE3 = createConfiguredFeature("withering_oak_tree3", BYGFeatures.WITHERING_OAK_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITHERING_OAK_LOG).setLeavesBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> WITHERING_OAK_TREE4 = createConfiguredFeature("withering_oak_tree4", BYGFeatures.WITHERING_OAK_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.WITHERING_OAK_LOG).setLeavesBlock(BYGBlocks.WITHERING_OAK_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    //End Mushrooms
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_BUSH1 = createConfiguredFeature("bulbis_bush1", BYGFeatures.BULBIS_BUSH1.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE1 = createConfiguredFeature("bulbis_tree1", BYGFeatures.BULBIS_TREE1.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE2 = createConfiguredFeature("bulbis_tree2", BYGFeatures.BULBIS_TREE2.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE3 = createConfiguredFeature("bulbis_tree3", BYGFeatures.BULBIS_TREE3.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE4 = createConfiguredFeature("bulbis_tree4", BYGFeatures.BULBIS_TREE4.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE5 = createConfiguredFeature("bulbis_tree5", BYGFeatures.BULBIS_TREE5.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE6 = createConfiguredFeature("bulbis_tree6", BYGFeatures.BULBIS_TREE6.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> BULBIS_TREE7 = createConfiguredFeature("bulbis_tree7", BYGFeatures.BULBIS_TREE7.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_BUSH1 = createConfiguredFeature("purple_bulbis_bush1", BYGFeatures.BULBIS_BUSH1.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE1 = createConfiguredFeature("purple_bulbis_tree1", BYGFeatures.BULBIS_TREE1.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE2 = createConfiguredFeature("purple_bulbis_tree2", BYGFeatures.BULBIS_TREE2.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE3 = createConfiguredFeature("purple_bulbis_tree3", BYGFeatures.BULBIS_TREE3.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE4 = createConfiguredFeature("purple_bulbis_tree4", BYGFeatures.BULBIS_TREE4.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE5 = createConfiguredFeature("purple_bulbis_tree5", BYGFeatures.BULBIS_TREE5.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE6 = createConfiguredFeature("purple_bulbis_tree6", BYGFeatures.BULBIS_TREE6.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> PURPLE_BULBIS_TREE7 = createConfiguredFeature("purple_bulbis_tree7", BYGFeatures.BULBIS_TREE7.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.BULBIS_WOOD).setMushroomBlock(BYGBlocks.PURPLE_BULBIS_SHELL).setMinHeight(6).setMaxHeight(12).build()));

    //End Trees
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_BUSH1 = createConfiguredFeature("ether_bush1", BYGFeatures.ETHER_BUSH1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_BUSH2 = createConfiguredFeature("ether_bush2", BYGFeatures.ETHER_BUSH2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE1 = createConfiguredFeature("ether_tree1", BYGFeatures.ETHER_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE2 = createConfiguredFeature("ether_tree2", BYGFeatures.ETHER_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE3 = createConfiguredFeature("ether_tree3", BYGFeatures.ETHER_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE4 = createConfiguredFeature("ether_tree4", BYGFeatures.ETHER_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE5 = createConfiguredFeature("ether_tree5", BYGFeatures.ETHER_TREE5.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_LOG).setLeavesBlock(BYGBlocks.ETHER_LEAVES).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD1 = createConfiguredFeature("ether_tree_dead1", BYGFeatures.DEAD_ETHER_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_WOOD).setLeavesBlock(Blocks.AIR).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD2 = createConfiguredFeature("ether_tree_dead2", BYGFeatures.DEAD_ETHER_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_WOOD).setLeavesBlock(Blocks.AIR).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> ETHER_TREE_DEAD3 = createConfiguredFeature("ether_tree_dead3", BYGFeatures.DEAD_ETHER_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(BYGBlocks.ETHER_WOOD).setLeavesBlock(Blocks.AIR).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_BUSH1 = createConfiguredFeature("nightshade_bush1", BYGFeatures.NIGHTSHADE_BUSH1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LOG.getDefaultState(), 9).addWeightedBlockstate(BYGBlocks.IMBUED_NIGHTSHADE_LOG.getDefaultState(), 1)).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LEAVES.getDefaultState(), 8)).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_BUSH2 = createConfiguredFeature("nightshade_bush2", BYGFeatures.NIGHTSHADE_BUSH2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LOG.getDefaultState(), 9).addWeightedBlockstate(BYGBlocks.IMBUED_NIGHTSHADE_LOG.getDefaultState(), 1)).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LEAVES.getDefaultState(), 8)).setMaxHeight(30).setMinHeight(22).build()));

    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE1 = createConfiguredFeature("nightshade_tree1", BYGFeatures.NIGHTSHADE_TREE1.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LOG.getDefaultState(), 9).addWeightedBlockstate(BYGBlocks.IMBUED_NIGHTSHADE_LOG.getDefaultState(), 1)).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LEAVES.getDefaultState(), 8)).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE2 = createConfiguredFeature("nightshade_tree2", BYGFeatures.NIGHTSHADE_TREE2.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LOG.getDefaultState(), 9).addWeightedBlockstate(BYGBlocks.IMBUED_NIGHTSHADE_LOG.getDefaultState(), 1)).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LEAVES.getDefaultState(), 8)).setMaxHeight(30).setMinHeight(22).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE3 = createConfiguredFeature("nightshade_tree3", BYGFeatures.NIGHTSHADE_TREE3.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LOG.getDefaultState(), 9).addWeightedBlockstate(BYGBlocks.IMBUED_NIGHTSHADE_LOG.getDefaultState(), 1)).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LEAVES.getDefaultState(), 8)).setMaxHeight(30).setMinHeight(33).build()));
    public static final ConfiguredFeature<BYGTreeConfig, ?> NIGHTSHADE_TREE4 = createConfiguredFeature("nightshade_tree4", BYGFeatures.NIGHTSHADE_TREE4.withConfiguration(new BYGTreeConfig.Builder().setTrunkBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LOG.getDefaultState(), 9).addWeightedBlockstate(BYGBlocks.IMBUED_NIGHTSHADE_LOG.getDefaultState(), 1)).setLeavesBlock(new WeightedBlockStateProvider().addWeightedBlockstate(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES.getDefaultState(), 3).addWeightedBlockstate(BYGBlocks.NIGHTSHADE_LEAVES.getDefaultState(), 8)).setMaxHeight(30).setMinHeight(44).build()));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SHULKREN_TREE1 = createConfiguredFeature("shulkren_tree1", BYGFeatures.SHULKREN_TREE1.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SHULKREN_TREE2 = createConfiguredFeature("shulkren_tree2", BYGFeatures.SHULKREN_TREE2.withConfiguration(new BYGMushroomConfig.Builder().setStemBlock(BYGBlocks.WHITE_MUSHROOM_STEM).setMushroomBlock(BYGBlocks.SHULKREN_WART_BLOCK).setMinHeight(6).setMaxHeight(12).build()));

    /***********************************************************Configured Placement***********************************************************/

    public static final ConfiguredFeature<?, ?> SHRUBLAND_SHRUB = createConfiguredFeature("shrubland_shrub", SHRUB.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));


    /***********************************************************Random Selectors***********************************************************/

    public static final ConfiguredFeature<?, ?> RANDOM_ANCIENT_TREE = createConfiguredFeature("ancient_forest_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.DARK_OAK.withChance(0.3F),
            ANCIENT_TREE1.withChance(0.20F),
            ANCIENT_TREE2.withChance(0.20F)),
            ANCIENT_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(16, 0.4F, 8))));

    public static final ConfiguredFeature<?, ?> RANDOM_BAYOU_TREE = createConfiguredFeature("bayou_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WILLOW_DEAD_TREE1.withChance(0.1F),
            WILLOW_TREE1.withChance(0.25F),
            WILLOW_TREE2.withChance(0.25F),
            WILLOW_TREE3.withChance(0.25F)),
            WILLOW_TREE4)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(8, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_BAYOU_TREE = createConfiguredFeature("sparse_bayou_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WILLOW_TREE1.withChance(0.25F),
            WILLOW_TREE2.withChance(0.25F),
            WILLOW_TREE3.withChance(0.25F)),
            WILLOW_TREE4)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CORAL_MANGROVE = createConfiguredFeature("mg_coral", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Feature.CORAL_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.25F),
            Feature.CORAL_MUSHROOM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withChance(0.25F)),
            Feature.CORAL_CLAW.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG))).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(25, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLUFF_TREE = createConfiguredFeature("bluff_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_TREE1.withChance(0.05F),
            PINE_TREE2.withChance(0.05F),
            BLUFF_TREE1.withChance(0.3F),
            BLUFF_TREE2.withChance(0.3F),
            BLUFF_TREE3.withChance(0.25F)),
            CONIFER_TREE6)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(12, 0.3F, -4))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_TREE = createConfiguredFeature("boreal_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BIRCH_YELLOW_BOREAL_TREE1.withChance(0.3F),
            BIRCH_BOREAL_TREE1.withChance(0.3F)),
            BOREAL_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(18, 0.5F, -2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BOREAL_SPARSE_TREE = createConfiguredFeature("sparse_boreal_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BIRCH_YELLOW_BOREAL_TREE1.withChance(0.3F),
            BIRCH_BOREAL_TREE1.withChance(0.3F)),
            BOREAL_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_FOREST_TREE = createConfiguredFeature("black_forest_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE3.withChance(0.05F),
            ASPEN_TREE2.withChance(0.05F),
            CONIFER_TREE6.withChance(0.05F),
            CONIFER_TREE7.withChance(0.05F),
            PINE_LARGE_TREE1.withChance(0.5F),
            PINE_LARGE_TREE2.withChance(0.5F),
            PINE_TREE1.withChance(0.5F)),
            PINE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(30, 0.4F, -5))));

    public static final ConfiguredFeature<?, ?> RANDOM_BLACK_FOREST_SPARSE_TREE = createConfiguredFeature("sparse_black_forest_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_LARGE_TREE1.withChance(0.45F),
            PINE_LARGE_TREE2.withChance(0.45F),
            PINE_TREE1.withChance(0.4F)),
            PINE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CIKA_TREE = createConfiguredFeature("cika_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CIKA_TREE2.withChance(0.2F),
            CIKA_TREE3.withChance(0.1F)),
            CIKA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_CONIFER_TREE = createConfiguredFeature("conifer_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CONIFER_TREE1.withChance(0.06F),
            CONIFER_TREE2.withChance(0.5F),
            CONIFER_TREE3.withChance(0.04F),
            CONIFER_TREE4.withChance(0.2F),
            CONIFER_TREE5.withChance(0.2F),
            CONIFER_TREE6.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F)),
            CONIFER_TREE8)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(18, 0.4F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_CONIFER_SPARSE_TREE = createConfiguredFeature("sparse_conifer_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CONIFER_TREE1.withChance(0.06F),
            CONIFER_TREE2.withChance(0.5F),
            CONIFER_TREE3.withChance(0.04F),
            CONIFER_TREE4.withChance(0.2F),
            CONIFER_TREE5.withChance(0.2F),
            CONIFER_TREE6.withChance(0.2F),
            CONIFER_TREE7.withChance(0.1F)),
            CONIFER_TREE8)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CRAG_GARDEN_TREE = createConfiguredFeature("crag_garden_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_TREE1.withChance(0.2F),
            RAINBOW_TREE1.withChance(0.2F),
            Features.BAMBOO.withChance(0.05F),
            RAINBOW_LARGE_TREE1.withChance(0.1F)),
            MAHOGANY_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(30, 0.4F, 8))));

    public static final ConfiguredFeature<?, ?> RANDOM_CYPRESS_TREE = createConfiguredFeature("cypress_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CYPRESS_TREE1.withChance(0.5F),
            CYPRESS_TREE2.withChance(0.4F)),
            CYPRESS_TREE3)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(5, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_TREE = createConfiguredFeature("deciduous_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_TREE1.withChance(0.25F),
            DECIDUOUS_TREE2.withChance(0.25F),
            DECIDUOUS_TREE3.withChance(0.25F)),
            DECIDUOUS_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_RED_TREE = createConfiguredFeature("deciduous_red_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_RED_TREE1.withChance(0.25F),
            DECIDUOUS_RED_TREE2.withChance(0.25F),
            DECIDUOUS_RED_TREE3.withChance(0.25F)),
            DECIDUOUS_RED_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_ORANGE_TREE = createConfiguredFeature("deciduous_orange_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_ORANGE_TREE1.withChance(0.25F),
            DECIDUOUS_ORANGE_TREE2.withChance(0.25F),
            DECIDUOUS_ORANGE_TREE3.withChance(0.25F)),
            DECIDUOUS_ORANGE_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_BROWN_TREE = createConfiguredFeature("deciduous_brown_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_BROWN_TREE1.withChance(0.25F),
            DECIDUOUS_BROWN_TREE2.withChance(0.25F),
            DECIDUOUS_BROWN_TREE3.withChance(0.25F)),
            DECIDUOUS_BROWN_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_DECIDUOUS_SPARSE_TREE = createConfiguredFeature("sparse_deciduous_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_TREE1.withChance(0.25F),
            DECIDUOUS_TREE2.withChance(0.25F),
            DECIDUOUS_TREE3.withChance(0.25F)),
            DECIDUOUS_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_DOVER_TREE = createConfiguredFeature("dover_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_LARGE_TREE1.withChance(0.25F),
            PINE_LARGE_TREE2.withChance(0.25F)),
            SPRUCE_TREE_LARGE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_EUCALYPTUS_TREE = createConfiguredFeature("eucalyptus_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_TREE1.withChance(0.1F)),
            RAINBOW_LARGE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(8, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_TREE = createConfiguredFeature("jacaranda_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            JACARANDA_TREE2.withChance(0.3F),
            INDIGO_JACARANDA_TREE2.withChance(0.3F),
            INDIGO_JACARANDA_TREE1.withChance(0.3F)),
            JACARANDA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(25, 0.1F, -5))));

    public static final ConfiguredFeature<?, ?> RANDOM_JACARANDA_SPARSE_TREE = createConfiguredFeature("sparse_jacaranda_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            INDIGO_JACARANDA_TREE1.withChance(0.3F)),
            JACARANDA_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MAPLE_TREE = createConfiguredFeature("maple_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MAPLE_RED_TREE1.withChance(0.4F),
            MAPLE_RED_TREE2.withChance(0.03F),
            MAPLE_SILVER_TREE1.withChance(0.2F),
            MAPLE_SILVER_TREE2.withChance(0.1F)),
            MAPLE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(5, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MAPLE_SPARSE_TREE = createConfiguredFeature("sparse_maple_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MAPLE_TREE1.withChance(0.06F),
            MAPLE_RED_TREE1.withChance(0.5F),
            MAPLE_TREE1.withChance(0.04F),
            MAPLE_SILVER_TREE1.withChance(0.2F),
            MAPLE_SILVER_TREE2.withChance(0.1F)),
            MAPLE_RED_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_NORTHERN_FOREST_TREE = createConfiguredFeature("northern_forest_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_TREE1.withChance(0.5F)),
            PINE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(4, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PRAIRIE_TREE = createConfiguredFeature("prairie_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE1.withChance(0.4F),
            SHRUB_PRAIRIE2.withChance(0.4F),
            Features.FANCY_OAK_BEES_002.withChance(0.1F)),
            Features.FANCY_OAK)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_REDWOOD_TREE = createConfiguredFeature("redwood_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            REDWOOD_TREE1.withChance(0.55F),
            REDWOOD_TREE2.withChance(0.1F)),
            REDWOOD_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(3, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_REDWOOD_SPARSE_TREE = createConfiguredFeature("sparse_redwood_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            REDWOOD_TREE1.withChance(0.55F),
            REDWOOD_TREE2.withChance(0.1F)),
            REDWOOD_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_SHRUB = createConfiguredFeature("seasonal_shrubs", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB.withChance(0.4F)),
            DECIDUOUS_SEASONAL_SHRUB)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(5, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_DECIDUOUS_SPARSE_TREE = createConfiguredFeature("sparse_seasonal_deciduous_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DECIDUOUS_RED_TREE1.withChance(0.2F),
            DECIDUOUS_ORANGE_TREE1.withChance(0.2F),
            DECIDUOUS_SEASONAL_SHRUB.withChance(0.2F),
            DECIDUOUS_BROWN_TREE1.withChance(0.2F)),
            DECIDUOUS_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_TAIGA_MISC_TREE = createConfiguredFeature("seasonal_taiga_misc_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PINE_TREE1.withChance(0.25F),
            PINE_TREE2.withChance(0.25F),
            ASPEN_TREE2.withChance(0.25F)),
            ASPEN_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_SEASONAL_TREE_GIANT = createConfiguredFeature("spruce_seasonal_giant_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_RED_TREE_LARGE1.withChance(0.25F),
            SPRUCE_ORANGE_TREE_LARGE1.withChance(0.25F),
            SPRUCE_YELLOW_TREE_LARGE1.withChance(0.25F)),
            SPRUCE_TREE_LARGE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_TREE = createConfiguredFeature("spruce_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_TREE1.withChance(0.06F),
            SPRUCE_TREE2.withChance(0.5F),
            SPRUCE_TREE3.withChance(0.04F),
            SPRUCE_TREE4.withChance(0.2F),
            SPRUCE_TREE_MEDIUM1.withChance(0.2F),
            SPRUCE_TREE_MEDIUM2.withChance(0.2F),
            SPRUCE_TREE_MEDIUM3.withChance(0.2F),
            SPRUCE_TREE_MEDIUM4.withChance(0.1F)),
            SPRUCE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(3, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_YELLOW_TREE = createConfiguredFeature("spruce_yellow_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_YELLOW_TREE1.withChance(0.06F),
            SPRUCE_YELLOW_TREE2.withChance(0.5F),
            SPRUCE_YELLOW_TREE3.withChance(0.04F),
            SPRUCE_YELLOW_TREE4.withChance(0.2F),
            SPRUCE_YELLOW_TREE_MEDIUM1.withChance(0.2F),
            SPRUCE_YELLOW_TREE_MEDIUM2.withChance(0.2F),
            SPRUCE_YELLOW_TREE_MEDIUM3.withChance(0.2F),
            SPRUCE_YELLOW_TREE_MEDIUM4.withChance(0.1F)),
            SPRUCE_YELLOW_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(3, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_ORANGE_TREE = createConfiguredFeature("spruce_orange_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_ORANGE_TREE1.withChance(0.06F),
            SPRUCE_ORANGE_TREE2.withChance(0.5F),
            SPRUCE_ORANGE_TREE3.withChance(0.04F),
            SPRUCE_ORANGE_TREE4.withChance(0.2F),
            SPRUCE_ORANGE_TREE_MEDIUM1.withChance(0.2F),
            SPRUCE_ORANGE_TREE_MEDIUM2.withChance(0.2F),
            SPRUCE_ORANGE_TREE_MEDIUM3.withChance(0.2F),
            SPRUCE_ORANGE_TREE_MEDIUM4.withChance(0.1F)),
            SPRUCE_ORANGE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(3, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_RED_TREE = createConfiguredFeature("spruce_red_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_RED_TREE1.withChance(0.06F),
            SPRUCE_RED_TREE2.withChance(0.5F),
            SPRUCE_RED_TREE3.withChance(0.04F),
            SPRUCE_RED_TREE4.withChance(0.2F),
            SPRUCE_RED_TREE_MEDIUM1.withChance(0.2F),
            SPRUCE_RED_TREE_MEDIUM2.withChance(0.2F),
            SPRUCE_RED_TREE_MEDIUM3.withChance(0.2F),
            SPRUCE_RED_TREE_MEDIUM4.withChance(0.1F)),
            SPRUCE_RED_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(3, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_BLUE_TREE = createConfiguredFeature("spruce_blue_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_BLUE_TREE1.withChance(0.06F),
            SPRUCE_BLUE_TREE2.withChance(0.5F),
            SPRUCE_BLUE_TREE3.withChance(0.04F),
            SPRUCE_BLUE_TREE4.withChance(0.2F),
            SPRUCE_BLUE_TREE_MEDIUM1.withChance(0.2F),
            SPRUCE_BLUE_TREE_MEDIUM2.withChance(0.2F),
            SPRUCE_BLUE_TREE_MEDIUM3.withChance(0.2F),
            SPRUCE_BLUE_TREE_MEDIUM4.withChance(0.1F)),
            SPRUCE_BLUE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(3, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPRUCE_BLUE_TREE_GIANT = createConfiguredFeature("spruce_blue_tree_giant", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SPRUCE_BLUE_TREE_LARGE1.withChance(0.5F)),
            SPRUCE_TREE_LARGE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_FUNGAL_TREE = createConfiguredFeature("fungal_rainforest_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            MAHOGANY_TREE5.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            MAHOGANY_TREE2.withChance(0.2F),
            MAHOGANY_TREE3.withChance(0.2F),
            MAHOGANY_TREE4.withChance(0.15F)),
            MAHOGANY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(20, 0.3F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_SPARSE_TREE = createConfiguredFeature("sparse_rainforest_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            MAHOGANY_TREE5.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            MAHOGANY_TREE2.withChance(0.2F),
            MAHOGANY_TREE3.withChance(0.2F),
            MAHOGANY_TREE4.withChance(0.15F)),
            MAHOGANY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_RAINFOREST_TREE = createConfiguredFeature("rainforest_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RAINBOW_LARGE_TREE1.withChance(0.1F),
            RAINBOW_TREE1.withChance(0.1F),
            MAHOGANY_TREE5.withChance(0.1F),
            TROPICAL_SHRUB1.withChance(0.1F),
            MAHOGANY_TREE2.withChance(0.2F),
            MAHOGANY_TREE3.withChance(0.2F),
            MAHOGANY_TREE4.withChance(0.15F)),
            MAHOGANY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(20, 0.3F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_STONE_FOREST_TREE = createConfiguredFeature("stone_forest_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EBONY_TREE1.withChance(0.1F),
            EBONY_TREE2.withChance(0.1F),
            Features.JUNGLE_BUSH.withChance(0.1F),
            DECIDUOUS_TREE1.withChance(0.1F)),
            DECIDUOUS_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(20, 0.3F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_SKYRIS_TREE = createConfiguredFeature("skyris_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SKYRIS_TREE1.withChance(0.15F),
            SKYRIS_TREE5.withChance(0.25F),
            SKYRIS_TREE2.withChance(0.15F),
            SKYRIS_TREE3.withChance(0.25F)),
            SKYRIS_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(8, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BAOBAB_TREE = createConfiguredFeature("baobab_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            Features.ACACIA.withChance(0.15F),
            BAOBAB_TREE1.withChance(0.35F),
            BAOBAB_TREE2.withChance(0.35F)),
            BAOBAB_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.6F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_ARAUCARIA_TREE = createConfiguredFeature("araucaria_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ARAUCARIA_TREE2.withChance(0.5F)),
            ARAUCARIA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ARAUCARIA_TREE = createConfiguredFeature("sparse_araucaria_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ARAUCARIA_TREE2.withChance(0.5F)),
            ARAUCARIA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_BROWN_ZELKOVA_TREE = createConfiguredFeature("brown_zelkova_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ZELKOVA_BROWN_TREE3.withChance(0.35F),
            ZELKOVA_BROWN_TREE2.withChance(0.35F)),
            ZELKOVA_BROWN_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MEADOW_SHRUB = createConfiguredFeature("meadow_shrubs", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_MEADOW.withChance(0.1F)),
            SHRUB_PRAIRIE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MEADOW_TREE = createConfiguredFeature("meadow_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MEADOW_TREE1.withChance(0.2F),
            MEADOW_TREE2.withChance(0.1F)),
            MEADOW_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(3, 0.5F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_GROVE_TREE = createConfiguredFeature("grove_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BIRCH_YELLOW_BOREAL_TREE1.withChance(0.5F)),
            BIRCH_BOREAL_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ENCHANTED_GROVE_TREE = createConfiguredFeature("enchanted_grove_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ENCHANTED_BLUE_GROVE_TREE1.withChance(0.5F)),
            ENCHANTED_GREEN_GROVE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(2, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_GIANT_FLOWER = createConfiguredFeature("giant_flowers", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            GIANT_ANGELICA_FLOWER.withChance(0.2F),
            GIANT_DANDELION_FLOWER.withChance(0.2F),
            GIANT_IRIS_FLOWER.withChance(0.5F)),
            GIANT_ROSE_FLOWER)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MARSH_TREE = createConfiguredFeature("marsh_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE2.withChance(0.2F),
            SHRUB_PRAIRIE1.withChance(0.1F)),
            Features.SWAMP_TREE)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(3, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ENCHANTED_TREE = createConfiguredFeature("enchanted_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ENCHANTED_BLUE_TREE2.withChance(0.2F),
            ENCHANTED_BLUE_TREE3.withChance(0.2F),
            ENCHANTED_GREEN_TREE1.withChance(0.2F),
            ENCHANTED_GREEN_TREE2.withChance(0.2F),
            ENCHANTED_GREEN_TREE3.withChance(0.1F)),
            ENCHANTED_BLUE_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(10, 0.4F, -2))));

    public static final ConfiguredFeature<?, ?> RANDOM_GLOWSHROOM_BAYOU_TREE = createConfiguredFeature("glowshroom_bayou_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WILLOW_DEAD_TREE1.withChance(0.2F),
            WILLOW_M_TREE1.withChance(0.2F),
            WILLOW_M_TREE2.withChance(0.2F),
            WILLOW_TREE3.withChance(0.2F),
            WILLOW_TREE4.withChance(0.2F),
            WILLOW_TREE2.withChance(0.1F)),
            WILLOW_TREE1)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(8, 0.4F, 3))));

    public static final ConfiguredFeature<?, ?> RANDOM_ASPEN_TREE = createConfiguredFeature("aspen_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE2.withChance(0.50F),
            ASPEN_TREE3.withChance(0.25F)),
            ASPEN_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(15, 0.5F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_ASPEN_SHRUB = createConfiguredFeature("aspen_shrubs", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_SHRUB1.withChance(0.1F)),
            ASPEN_SHRUB2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ASPEN_TREE = createConfiguredFeature("sparse_aspen_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ASPEN_TREE2.withChance(0.2F),
            ASPEN_TREE3.withChance(0.1F)),
            ASPEN_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ZELKOVA_TREE = createConfiguredFeature("zelkova_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ZELKOVA_TREE2.withChance(0.2F),
            ZELKOVA_TREE3.withChance(0.1F)),
            ZELKOVA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(15, 0.4F, -2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ZELKOVA_TREE = createConfiguredFeature("sparse_zelkova_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ZELKOVA_TREE2.withChance(0.2F),
            ZELKOVA_TREE3.withChance(0.1F)),
            ZELKOVA_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PALO_VERDE_TREE = createConfiguredFeature("palo_verde_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PALO_VERDE_TREE1.withChance(0.5F)),
            PALO_VERDE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_JOSHUA_TREE = createConfiguredFeature("joshua_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            JOSHUA_TREE1.withChance(0.5F)),
            JOSHUA_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SHRUB = createConfiguredFeature("prairie_shrubs", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHRUB_PRAIRIE1.withChance(0.1F)),
            SHRUB_PRAIRIE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PALM_TREE = createConfiguredFeature("sparse_palm_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PALM_TREE4.withChance(0.05F),
            PALM_TREE3.withChance(0.35F),
            PALM_TREE2.withChance(0.35F)),
            PALM_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_DENSE_PALM_TREE = createConfiguredFeature("palm_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PALM_TREE4.withChance(0.05F),
            PALM_TREE3.withChance(0.35F),
            PALM_TREE2.withChance(0.35F)),
            PALM_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(7, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_CHERRY_TREE = createConfiguredFeature("cherry_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CHERRY_PINK_TREE1.withChance(0.2F),
            CHERRY_PINK_TREE2.withChance(0.2F),
            CHERRY_WHITE_TREE1.withChance(0.1F)),
            CHERRY_WHITE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(14, 0.4F, -1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_CHERRY_TREE = createConfiguredFeature("sparse_cherry_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            CHERRY_PINK_TREE1.withChance(0.2F),
            CHERRY_PINK_TREE2.withChance(0.2F),
            CHERRY_WHITE_TREE1.withChance(0.1F)),
            CHERRY_WHITE_TREE2)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.1F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_WITCH_HAZEL_TREE = createConfiguredFeature("witch_hazel_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEAD_HAZEL_TREE1.withChance(0.2F),
            DEAD_HAZEL_TREE2.withChance(0.2F),
            DEAD_HAZEL_TREE3.withChance(0.1F)),
            DEAD_HAZEL_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(14, 0.3F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_WITCH_HAZEL_TREE = createConfiguredFeature("sparse_witch_hazel_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEAD_HAZEL_TREE1.withChance(0.2F),
            DEAD_HAZEL_TREE2.withChance(0.2F),
            DEAD_HAZEL_TREE3.withChance(0.1F)),
            DEAD_HAZEL_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_EBONY_TREE = createConfiguredFeature("ebony_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EBONY_TREE1.withChance(0.2F),
            EBONY_TREE2.withChance(0.2F),
            EBONY_BUSH1.withChance(0.1F)),
            EBONY_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(10, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_HOLLY_TREE = createConfiguredFeature("holly_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            HOLLY_TREE1.withChance(0.2F),
            HOLLY_TREE2.withChance(0.2F),
            HOLLY_TREE3.withChance(0.1F)),
            HOLLY_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(25, 0.4F, 5))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_HOLLY_TREE = createConfiguredFeature("sparse_holly_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            HOLLY_TREE1.withChance(0.2F),
            HOLLY_TREE2.withChance(0.2F),
            HOLLY_TREE3.withChance(0.1F)),
            HOLLY_TREE4)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.4F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MANGROVE_TREE = createConfiguredFeature("mangrove_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MANGROVE_TREE1.withChance(0.2F),
            MANGROVE_TREE2.withChance(0.2F),
            MANGROVE_TREE3.withChance(0.2F),
            MANGROVE_TREE4.withChance(0.1F)),
            MANGROVE_TREE5)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(15, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MANGROVE_SPARSE_TREE = createConfiguredFeature("sparse_mangrove_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            MANGROVE_TREE1.withChance(0.2F),
            MANGROVE_TREE2.withChance(0.2F),
            MANGROVE_TREE3.withChance(0.2F),
            MANGROVE_TREE4.withChance(0.1F)),
            MANGROVE_TREE5)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ORCHARD_TREE = createConfiguredFeature("orchard_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ORCHARD_TREE1.withChance(0.3F),
            ORCHARD_TREE2.withChance(0.3F)),
            ORCHARD_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_WOODLAND_TREE = createConfiguredFeature("woodland_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WOODLANDS_TREE1.withChance(0.1F)),
            WOODLANDS_TREE1)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.35F, 2))));


    public static final ConfiguredFeature<?, ?> RANDOM_OAK_TREE = createConfiguredFeature("oak_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            OAK_TREE1.withChance(0.3F),
            OAK_TREE2.withChance(0.2F),
            OAK_TREE3.withChance(0.2F),
            OAK_TREE_LARGE1.withChance(0.1F),
            OAK_TREE_LARGE2.withChance(0.1F)),
            OAK_TREE_LARGE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_RED_OAK_TREE = createConfiguredFeature("red_oak_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RED_OAK_TREE1.withChance(0.3F),
            RED_OAK_TREE2.withChance(0.2F),
            RED_OAK_TREE3.withChance(0.2F),
            RED_OAK_TREE_LARGE1.withChance(0.1F),
            RED_OAK_TREE_LARGE2.withChance(0.1F)),
            RED_OAK_TREE_LARGE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_RED_OAK_TREE = createConfiguredFeature("sparse_red_oak_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            RED_OAK_TREE1.withChance(0.3F),
            RED_OAK_TREE2.withChance(0.2F),
            RED_OAK_TREE3.withChance(0.2F),
            RED_OAK_TREE_LARGE1.withChance(0.1F),
            RED_OAK_TREE_LARGE2.withChance(0.1F)),
            RED_OAK_TREE_LARGE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.3F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_BROWN_OAK_TREE = createConfiguredFeature("brown_oak_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BROWN_OAK_TREE1.withChance(0.3F),
            BROWN_OAK_TREE2.withChance(0.2F),
            BROWN_OAK_TREE3.withChance(0.2F),
            BROWN_OAK_TREE_LARGE1.withChance(0.1F),
            BROWN_OAK_TREE_LARGE2.withChance(0.1F)),
            BROWN_OAK_TREE_LARGE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_ORANGE_OAK_TREE = createConfiguredFeature("orange_oak_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ORANGE_OAK_TREE1.withChance(0.3F),
            ORANGE_OAK_TREE2.withChance(0.2F),
            ORANGE_OAK_TREE3.withChance(0.2F),
            ORANGE_OAK_TREE_LARGE1.withChance(0.1F),
            ORANGE_OAK_TREE_LARGE2.withChance(0.1F)),
            ORANGE_OAK_TREE_LARGE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.4F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SEASONAL_BIRCH_FOREST_TREE = createConfiguredFeature("seasonal_birch_forest_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BIRCH_BROWN_TREE1.withChance(0.06F),
            BIRCH_BROWN_TREE2.withChance(0.06F),
            BIRCH_BROWN_TREE3.withChance(0.06F),
            BIRCH_ORANGE_TREE1.withChance(0.06F),
            BIRCH_ORANGE_TREE2.withChance(0.06F),
            BIRCH_ORANGE_TREE3.withChance(0.06F),
            BIRCH_RED_TREE1.withChance(0.06F),
            BIRCH_RED_TREE2.withChance(0.06F),
            BIRCH_RED_TREE3.withChance(0.06F),
            BIRCH_YELLOW_TREE1.withChance(0.06F),
            BIRCH_YELLOW_TREE2.withChance(0.1F)),
            BIRCH_YELLOW_TREE3)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(8, 0.3F, -2))));

    public static final ConfiguredFeature<?, ?> RANDOM_HUGE_GLOWSHROOM = createConfiguredFeature("huge_glowshroom", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BLUE_GLOWSHROOM_HUGE.withChance(0.1F)),
            PURPLE_GLOWSHROOM_HUGE)).withPlacement(Placement.DARK_OAK_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

    public static final ConfiguredFeature<?, ?> RANDOM_SOUL_SHROOM_TREES = createConfiguredFeature("soul_shroom_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SOUL_SHROOM_TREE3.withChance(0.35F),
            SOUL_SHROOM_TREE2.withChance(0.35F)),
            SOUL_SHROOM_TREE1)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(8, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_DEATH_CAP_TREES = createConfiguredFeature("death_cap_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            DEATH_CAP_TREE3.withChance(0.35F),
            DEATH_CAP_TREE2.withChance(0.35F)),
            DEATH_CAP_TREE1)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(8, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_MINI_MUSHROOMS = createConfiguredFeature("mini_mushrooms", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            GREEN_MUSHROOM_MINI.withChance(0.16F),
            RED_MUSHROOM_MINI.withChance(0.16F),
            BROWN_MUSHROOM_MINI.withChance(0.16F),
            WOOD_BLEWIT_MINI.withChance(0.16F),
            WEEPING_MILKCAP_MINI.withChance(0.16F)),
            BLACK_PUFF_MINI)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(7, 0.5F, 4))));

    public static final ConfiguredFeature<?, ?> RANDOM_HUGE_MUSHROOM = createConfiguredFeature("huge_mushrooms", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            GREEN_MUSHROOM_HUGE.withChance(0.4F),
            WOOD_BLEWIT_HUGE.withChance(0.4F),
            WEEPING_MILKCAP_HUGE.withChance(0.4F)),
            BLACK_PUFF_HUGE)).withPlacement(Placement.DARK_OAK_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

    public static final ConfiguredFeature<?, ?> RANDOM_EMBUR_MUSHROOM = createConfiguredFeature("embur_mushrooms", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            EMBUR_MUSHROOM.withChance(0.5F)),
            EMBUR_MUSHROOM2)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(2, 0.5F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_FUNGUS = createConfiguredFeature("fungi", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WARPED_FUNGUS1.withChance(0.15F),
            WARPED_FUNGUS2.withChance(0.15F),
            CRIMSON_FUNGUS1.withChance(0.4F)),
            CRIMSON_FUNGUS2)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(4, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SYTHIAN_FUNGUS = createConfiguredFeature("sythian_fungi_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SYTHIAN_FUNGUS_TREE1.withChance(0.25F),
            SYTHIAN_FUNGUS_TREE2.withChance(0.25F),
            SYTHIAN_FUNGUS_TREE3.withChance(0.25F)),
            SYTHIAN_FUNGUS_TREE4)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(12, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_WITHERING_OAK_TREE = createConfiguredFeature("withering_oak_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WITHERING_OAK_TREE4.withChance(0.25F),
            WITHERING_OAK_TREE3.withChance(0.25F),
            WITHERING_OAK_TREE2.withChance(0.25F)),
            WITHERING_OAK_TREE1)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(12, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_WITHERING_OAK_TREE = createConfiguredFeature("sparse_withering_oak_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            WITHERING_OAK_TREE3.withChance(0.25F)),
            WITHERING_OAK_TREE1)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_TWISTY_LAMENT_TREE = createConfiguredFeature("twisty_lament_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            LAMENT_TWISTY_TREE3.withChance(0.35F),
            LAMENT_TWISTY_TREE2.withChance(0.35F)),
            LAMENT_TWISTY_TREE1)).withPlacement(BYGDecorators.UNDERGROUND_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(12, 0.5F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_WEEPING_LAMENT_TREE = createConfiguredFeature("weeping_lament_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            LAMENT_WEEPING_TREE3.withChance(0.35F),
            LAMENT_WEEPING_TREE2.withChance(0.35F)),
            LAMENT_WEEPING_TREE1)).withPlacement(BYGDecorators.AT_OR_BELOW_SEA_LEVEL.configure(
            new AtOrBelowSeaLevelCountExtraConfig(8, 0.5F, 2, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_BULBIS_TREE = createConfiguredFeature("bulbis_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BULBIS_BUSH1.withChance(0.1F),
            BULBIS_TREE1.withChance(0.15F),
            BULBIS_TREE2.withChance(0.15F),
            BULBIS_TREE3.withChance(0.1F),
            BULBIS_TREE4.withChance(0.15F),
            BULBIS_TREE5.withChance(0.15F),
            BULBIS_TREE6.withChance(0.1F)),
            BULBIS_TREE7)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.1F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_BULBIS_TREE = createConfiguredFeature("sparse_bulbis_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            BULBIS_BUSH1.withChance(0.1F),
            BULBIS_TREE1.withChance(0.15F),
            BULBIS_TREE2.withChance(0.15F),
            BULBIS_TREE3.withChance(0.1F),
            BULBIS_TREE4.withChance(0.15F),
            BULBIS_TREE5.withChance(0.15F),
            BULBIS_TREE6.withChance(0.1F)),
            BULBIS_TREE7)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_PURPLE_BULBIS_TREE = createConfiguredFeature("purple_bulbis_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PURPLE_BULBIS_BUSH1.withChance(0.1F),
            PURPLE_BULBIS_TREE1.withChance(0.15F),
            PURPLE_BULBIS_TREE2.withChance(0.15F),
            PURPLE_BULBIS_TREE3.withChance(0.1F),
            PURPLE_BULBIS_TREE4.withChance(0.15F),
            PURPLE_BULBIS_TREE5.withChance(0.15F),
            PURPLE_BULBIS_TREE6.withChance(0.1F)),
            PURPLE_BULBIS_TREE7)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.3F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_PURPLE_BULBIS_TREE = createConfiguredFeature("sparse_purple_bulbis_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            PURPLE_BULBIS_BUSH1.withChance(0.1F),
            PURPLE_BULBIS_TREE1.withChance(0.15F),
            PURPLE_BULBIS_TREE2.withChance(0.15F),
            PURPLE_BULBIS_TREE3.withChance(0.1F),
            PURPLE_BULBIS_TREE4.withChance(0.15F),
            PURPLE_BULBIS_TREE5.withChance(0.15F),
            PURPLE_BULBIS_TREE6.withChance(0.1F)),
            PURPLE_BULBIS_TREE7)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_NIGHTSHADE_TREE = createConfiguredFeature("nightshade_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            NIGHTSHADE_TREE1.withChance(0.15F),
            NIGHTSHADE_TREE2.withChance(0.3F),
            NIGHTSHADE_TREE3.withChance(0.3F)),
            NIGHTSHADE_TREE4)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(4, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_NIGHTSHADE_BUSH = createConfiguredFeature("nightshade_bushes", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            NIGHTSHADE_BUSH1.withChance(0.7F)),
            NIGHTSHADE_BUSH2)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(4, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ETHER_TREE = createConfiguredFeature("ether_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ETHER_TREE1.withChance(0.15F),
            ETHER_TREE2.withChance(0.15F),
            ETHER_TREE3.withChance(0.15F),
            ETHER_TREE5.withChance(0.15F)),
            ETHER_TREE4)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(4, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SPARSE_ETHER_TREE = createConfiguredFeature("sparse_ether_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ETHER_TREE1.withChance(0.4F),
            ETHER_TREE2.withChance(0.4F),
            ETHER_TREE3.withChance(0.05F),
            ETHER_TREE5.withChance(0.05F)),
            ETHER_TREE4)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(0, 0.35F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_ETHER_BUSH = createConfiguredFeature("ether_bushes", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ETHER_BUSH1.withChance(0.7F)),
            ETHER_BUSH2)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(4, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_SHULKREN_TREE = createConfiguredFeature("shulkren_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHULKREN_TREE1.withChance(0.7F)),
            SHULKREN_TREE2)).withPlacement(BYGDecorators.OCEAN_FLOOR_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(4, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_DEAD_ETHER_TREE = createConfiguredFeature("dead_ether_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            ETHER_TREE_DEAD1.withChance(0.35F),
            ETHER_TREE_DEAD2.withChance(0.35F)),
            ETHER_TREE_DEAD3)).withPlacement(BYGDecorators.MOTION_BLOCKING_NO_LEAVES_COUNT_EXTRA.configure(
            new AtSurfaceWithExtraConfig(1, 0.3F, 2))));

    public static final ConfiguredFeature<?, ?> RANDOM_DESERT_END_ISLAND = createConfiguredFeature("floating_desert_end_islands", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            FLOATING_DESERT_ISLAND1.withChance(0.35F),
            FLOATING_DESERT_ISLAND2.withChance(0.35F)),
            FLOATING_DESERT_ISLAND3)).withPlacement(BYGDecorators.ISLAND.configure(
            new AtSurfaceWithExtraConfig(0, 0.2F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_ISLAND = createConfiguredFeature("floating_islands", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            FLOATING_ISLAND1.withChance(0.25F),
            FLOATING_ISLAND2.withChance(0.25F),
            FLOATING_ISLAND3.withChance(0.25F)),
            FLOATING_ISLAND5)).withPlacement(BYGDecorators.ISLAND.configure(
            new AtSurfaceWithExtraConfig(0, 0.13F, 1))));

    public static final ConfiguredFeature<?, ?> RANDOM_SHATTERED_ISLAND = createConfiguredFeature("shattered_floating_islands", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
            SHATTERED_FLOATING_ISLAND1.withChance(0.25F),
            SHATTERED_FLOATING_ISLAND2.withChance(0.25F),
            SHATTERED_FLOATING_ISLAND2.withChance(0.25F)),
            SHATTERED_FLOATING_ISLAND4)).withPlacement(BYGDecorators.ISLAND.configure(
            new AtSurfaceWithExtraConfig(0, 0.13F, 1))));

    //Initialize these later so our blocks don't throw NPEs initializing other configured features in this class.
    public static class SpreadableBlockConfigs {
        public static final BlockStateProvidingFeatureConfig EMBUR_ROOTS = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(BYGBlocks.EMBUR_ROOTS.getDefaultState(), 50).addWeightedBlockstate(BYGBlocks.EMBUR_SPROUTS.getDefaultState(), 35).addWeightedBlockstate(BYGBlocks.EMBUR_WART.getDefaultState(), 11));
        public static final BlockStateProvidingFeatureConfig MEADOW_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(BYGBlocks.CLOVER_PATCH.getDefaultState(), 15).addWeightedBlockstate(Blocks.GRASS.getDefaultState(), 30).addWeightedBlockstate(Blocks.PINK_TULIP.getDefaultState(), 15).addWeightedBlockstate(BYGBlocks.MAGENTA_TULIP.getDefaultState(), 15).addWeightedBlockstate(BYGBlocks.CYAN_TULIP.getDefaultState(), 15).addWeightedBlockstate(BYGBlocks.WHITE_ANEMONE.getDefaultState(), 15).addWeightedBlockstate(BYGBlocks.ROSE.getDefaultState(), 10));
        public static final BlockStateProvidingFeatureConfig SYTHIAN_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(BYGBlocks.SYTHIAN_ROOTS.getDefaultState(), 50).addWeightedBlockstate(BYGBlocks.SYTHIAN_SPROUT.getDefaultState(), 50).addWeightedBlockstate(BYGBlocks.SYTHIAN_FUNGUS.getDefaultState(), 11));
        public static final BlockStateProvidingFeatureConfig IVIS_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(BYGBlocks.IVIS_ROOTS.getDefaultState(), 50).addWeightedBlockstate(BYGBlocks.IVIS_SPROUT.getDefaultState(), 50));
        public static final BlockStateProvidingFeatureConfig OVERGROWN_BLACKSTONE_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(Blocks.CRIMSON_ROOTS.getDefaultState(), 80).addWeightedBlockstate(Blocks.CRIMSON_FUNGUS.getDefaultState(), 15).addWeightedBlockstate(BYGBlocks.CRIMSON_BERRY_BUSH.getDefaultState(), 5));
        public static final BlockStateProvidingFeatureConfig OVERGROWN_NETHERRACK_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(Blocks.NETHER_SPROUTS.getDefaultState(), 90).addWeightedBlockstate(BYGBlocks.SOUL_SHROOM.getDefaultState(), 5).addWeightedBlockstate(BYGBlocks.DEATH_CAP.getDefaultState(), 5));
        public static final BlockStateProvidingFeatureConfig MYCELIUM_NETHERRACK_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(BYGBlocks.SOUL_SHROOM.getDefaultState(), 50).addWeightedBlockstate(BYGBlocks.DEATH_CAP.getDefaultState(), 50));
        public static final BlockStateProvidingFeatureConfig ETHER_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(BYGBlocks.ETHER_GRASS.getDefaultState(), 50).addWeightedBlockstate(BYGBlocks.ETHER_BUSH.getDefaultState(), 45).addWeightedBlockstate(BYGBlocks.THEREAL_BELLFLOWER.getDefaultState(), 5));
        public static final BlockStateProvidingFeatureConfig NIGHTSHADE_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(BYGBlocks.NIGHTSHADE_SPROUTS.getDefaultState(), 50).addWeightedBlockstate(BYGBlocks.NIGHTSHADE_SPROUTS.getDefaultState(), 50));
        public static final BlockStateProvidingFeatureConfig VERMILION_SCULK_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(BYGBlocks.VERMILION_SCULK_GROWTH.getDefaultState(), 50).addWeightedBlockstate(BYGBlocks.VERMILION_SCULK_GROWTH.getDefaultState(), 45).addWeightedBlockstate(BYGBlocks.VERMILION_SCULK_GROWTH.getDefaultState(), 5));
        public static final BlockStateProvidingFeatureConfig BULBIS_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(BYGBlocks.BULBIS_SPROUTS.getDefaultState(), 50).addWeightedBlockstate(BYGBlocks.BULBIS_SPROUTS.getDefaultState(), 45).addWeightedBlockstate(BYGBlocks.BULBIS_SPROUTS.getDefaultState(), 5));
    }

    //Initialize these later to ensure config values were read.
    public static class OreConfigs {
        public static final ConfiguredFeature<?, ?> ORE_AMETRINE = createConfiguredFeature("ore_ametrine", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BYGBlocks.AMETRINE_ORE.getDefaultState(), BYGWorldConfig.AMETRINE_GEN_SIZE.get())).range(BYGWorldConfig.AMETRINE_GEN_Y.get()).square().func_242731_b(BYGWorldConfig.AMETRINE_GEN_PER_CHUNK.get()));
        public static final ConfiguredFeature<?, ?> ORE_PENDORITE = createConfiguredFeature("ore_pendorite", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BYGBlocks.PENDORITE_ORE.getDefaultState(), BYGWorldConfig.PENDORITE_GEN_SIZE.get())).range(BYGWorldConfig.PENDORITE_GEN_Y.get()).square().func_242731_b(BYGWorldConfig.PENDORITE_GEN_PER_CHUNK.get()));

        public static final ConfiguredFeature<?, ?> ORE_ROCKY_STONE = createConfiguredFeature("ore_rocky_stone", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BYGBlocks.ROCKY_STONE.getDefaultState(), BYGWorldConfig.ROCKY_STONE_GEN_SIZE.get())).range(BYGWorldConfig.ROCKY_STONE_GEN_Y.get()).square().func_242731_b(BYGWorldConfig.ROCKY_STONE_GEN_PER_CHUNK.get()));
        public static final ConfiguredFeature<?, ?> ORE_SCORIA_STONE = createConfiguredFeature("ore_scoria_stone", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BYGBlocks.SCORIA_STONE.getDefaultState(), BYGWorldConfig.SCORIA_STONE_GEN_SIZE.get())).range(BYGWorldConfig.SCORIA_STONE_GEN_Y.get()).square().func_242731_b(BYGWorldConfig.SCORIA_STONE_GEN_PER_CHUNK.get()));
        public static final ConfiguredFeature<?, ?> ORE_SOAP_STONE = createConfiguredFeature("ore_soap_stone", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BYGBlocks.SOAPSTONE.getDefaultState(), BYGWorldConfig.SOAP_STONE_GEN_SIZE.get())).range(BYGWorldConfig.SOAP_STONE_GEN_Y.get()).square().func_242731_b(BYGWorldConfig.SOAP_STONE_GEN_PER_CHUNK.get()));

    }
}
