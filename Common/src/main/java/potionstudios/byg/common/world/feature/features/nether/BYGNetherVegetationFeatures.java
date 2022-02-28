package potionstudios.byg.common.world.feature.features.nether;

import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.*;

import java.util.ArrayList;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;
import static potionstudios.byg.common.world.feature.features.overworld.BYGOverworldVegetationFeatures.*;

public class BYGNetherVegetationFeatures {

    public static final ConfiguredFeature<?, ?> EMBUR_ROOTS = createPatchConfiguredFeature("embur_roots", BYGBlocks.EMBUR_ROOTS, 15);
    public static final ConfiguredFeature<?, ?> TALL_EMBUR_ROOTS = createPatchConfiguredFeature("tall_embur_roots", BYGBlocks.TALL_EMBUR_ROOTS, 15);
    public static final ConfiguredFeature<?, ?> EMBUR_WART = createPatchConfiguredFeature("embur_wart", BYGBlocks.EMBUR_WART, 15);
    public static final ConfiguredFeature<?, ?> EMBUR_SPROUT = createPatchConfiguredFeature("embur_sprout", BYGBlocks.EMBUR_SPROUTS, 15);
    public static final ConfiguredFeature<?, ?> SYTHIAN_ROOTS = createPatchConfiguredFeature("sythian_roots", BYGBlocks.SYTHIAN_ROOTS, 15);
    public static final ConfiguredFeature<?, ?> SYTHIAN_SPROUT = createPatchConfiguredFeature("sythian_sprout", BYGBlocks.SYTHIAN_SPROUT, 15);
    public static final ConfiguredFeature<?, ?> SYTHIAN_FUNGUS = createPatchConfiguredFeature("sythian_fungus", BYGBlocks.SYTHIAN_FUNGUS, 15);
    public static final ConfiguredFeature<?, ?> WARPED_CACTI = createPatchConfiguredFeature("warped_cacti", BYGBlocks.WARPED_CACTUS, 15);
    public static final ConfiguredFeature<?, ?> WARPED_BUSH = createPatchConfiguredFeature("warped_bush", BYGBlocks.WARPED_BUSH, 15);
    public static final ConfiguredFeature<?, ?> WARPED_CORAL = createPatchConfiguredFeature("warped_coral", BYGBlocks.WARPED_CORAL, 15);
    public static final ConfiguredFeature<?, ?> WARPED_CORAL_FAN = createPatchConfiguredFeature("warped_coral_fan", BYGBlocks.WARPED_CORAL_FAN, 15);
    public static final ConfiguredFeature<?, ?> TALL_CRIMSON_ROOTS = createPatchConfiguredFeature("tall_crimson_roots", BYGBlocks.TALL_CRIMSON_ROOTS, 15);
    public static final ConfiguredFeature<?, ?> CRIMSON_BERRY_BUSH = createSimpleBlockConfiguredFeature("crimson_berry_bush", BYGBlocks.CRIMSON_BERRY_BUSH);
    public static final ConfiguredFeature<?, ?> EMBUR_LILY = createPatchConfiguredFeature("embur_lily", BYGBlocks.EMBUR_LILY, 15);
    public static final ConfiguredFeature<?, ?> SOUL_SHROOM = createPatchConfiguredFeature("soul_shroom", BYGBlocks.SOUL_SHROOM, 15);
    public static final ConfiguredFeature<?, ?> DEATH_CAP = createPatchConfiguredFeature("death_cap", BYGBlocks.DEATH_CAP, 15);
    public static final ConfiguredFeature<?, ?> NETHER_BRISTLE = createPatchConfiguredFeature("nether_bristle", BYGBlocks.NETHER_BRISTLE, 15);
    public static final ConfiguredFeature<?, ?> SCORCHED_BUSH = createPatchConfiguredFeature("scorched_bush", BYGBlocks.SCORCHED_BUSH, 15);
    public static final ConfiguredFeature<?, ?> SCORCHED_GRASS = createPatchConfiguredFeature("scorched_grass", BYGBlocks.SCORCHED_GRASS, 15);
    public static final ConfiguredFeature<?, ?> WAILING_GRASS = createPatchConfiguredFeature("wailing_grass", BYGBlocks.WAILING_GRASS, 15);
    public static final ConfiguredFeature<?, ?> WAILING_VINE = createConfiguredFeature("wailing_vine", BYGFeatures.WAILING_VINES.configured(FeatureConfiguration.NONE));
    public static final ConfiguredFeature<?, ?> LAMENT_SPROUTS = createPatchConfiguredFeature("lament_sprouts", BYGBlocks.LAMENT_SPROUTS, 15);

    public static final ConfiguredFeature<?, ?> WEEPING_ROOTS = createConfiguredFeature("weeping_roots", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.GLOWSTONE).setBlock(BYGBlocks.WEEPING_ROOTS_PLANT).setEndBlock(BYGBlocks.WEEPING_ROOTS.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setWhitelist(ImmutableList.of(Blocks.NETHERRACK, Blocks.GLOWSTONE, Blocks.BLACKSTONE)).build()));
    public static final ConfiguredFeature<?, ?> WEEPING_VINES = createConfiguredFeature("weeping_vines", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.GLOWSTONE).setBlock(Blocks.WEEPING_VINES_PLANT).setEndBlock(Blocks.WEEPING_VINES.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setWhitelist(ImmutableList.of(Blocks.NETHERRACK, Blocks.GLOWSTONE, Blocks.BLACKSTONE)).build()));


    public static final ConfiguredFeature<?, ?> CHAINS = createConfiguredFeature("chains", BYGFeatures.CHAIN.configured(new ChainConfig.Builder().setMinLength(6).setMaxLength(10).setXAxisBlock(Blocks.POLISHED_BLACKSTONE_BRICKS).setZAxisBlock(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).setWhitelist(ImmutableList.of(BYGBlocks.SCORIA_STONE)).build()));
    public static final ConfiguredFeature<?, ?> HANGING_SOUL_SHROOM_SPORES = createConfiguredFeature("hanging_soul_shroom_spores", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SOUL_SHROOM_BLOCK).setBlock(BYGBlocks.SOUL_SHROOM_SPORE).setEndBlock(BYGBlocks.SOUL_SHROOM_SPORE_END.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.SOUL_SOIL, Blocks.SOUL_SAND, BYGBlocks.NYLIUM_SOUL_SAND, BYGBlocks.NYLIUM_SOUL_SAND)).build()));
    public static final ConfiguredFeature<?, ?> HANGING_SYTHIAN_ROOTS = createConfiguredFeature("hanging_sythian_roots", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SYTHIAN_WART_BLOCK).setBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT.defaultBlockState()).setEndBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.NETHERRACK, BYGBlocks.SYTHIAN_WART_BLOCK)).build()));
    public static final ConfiguredFeature<?, ?> HANGING_BONES = createConfiguredFeature("hanging_bones", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.BONE_BLOCK).setBlock(BYGBlocks.HANGING_BONE).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(BYGBlocks.QUARTZITE_SAND, Blocks.BONE_BLOCK)).build()));
    public static final ConfiguredFeature<?, ?> LAMENT_VINE_FEATURE = createConfiguredFeature("lament_vine", BYGFeatures.HANGING_FEATURE.configured(new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.NETHERRACK).setBlock(BYGBlocks.LAMENT_VINE_PLANT).setEndBlock(BYGBlocks.LAMENT_VINE.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setWhitelist(ImmutableList.of(Blocks.NETHERRACK)).build()));
    public static final ConfiguredFeature<?, ?> SYTHIAN_STALK = createConfiguredFeature("sythian_stalk", BYGFeatures.SYTHIAN_STALK.configured(new ProbabilityFeatureConfiguration(0.9F)));
    public static final ConfiguredFeature<?, ?> WARPED_CORAL_PLANT = createConfiguredFeature("warped_coral_plant", BYGFeatures.HUGE_WARPED_CORAL_PLANT.configured(new WhitelistedSimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.WARPED_CORAL_BLOCK.defaultBlockState()), ImmutableList.of(BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState()))));
    public static final ConfiguredFeature<?, ?> LAMENT_VEGETATION = createConfiguredFeature("lament_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(SCORCHED_BUSH.placed(), 0.2F),
        new WeightedPlacedFeature(SCORCHED_GRASS.placed(), 0.2F)),
        LAMENT_SPROUTS.placed())));

    //Nether Mushrooms
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM = createConfiguredFeature("embur_mushroom1",
        BYGFeatures.EMBUR_MUSHROOM.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.EMBUR_PEDU)
                .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM2 = createConfiguredFeature("embur_mushroom2",
        BYGFeatures.EMBUR_MUSHROOM2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.EMBUR_PEDU)
                .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM3 = createConfiguredFeature("embur_mushroom3",
        BYGFeatures.EMBUR_MUSHROOM3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.EMBUR_PEDU)
                .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> EMBUR_MUSHROOM4 = createConfiguredFeature("embur_mushroom4",
        BYGFeatures.EMBUR_MUSHROOM4.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.EMBUR_PEDU)
                .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> CRIMSON_FUNGUS1 = createConfiguredFeature("crimson_fungus1",
        BYGFeatures.CRIMSON_FUNGUS_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.CRIMSON_STEM)
                .setMushroomBlock(Blocks.NETHER_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> CRIMSON_FUNGUS2 = createConfiguredFeature("crimson_fungus2",
        BYGFeatures.CRIMSON_FUNGUS_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.CRIMSON_STEM)
                .setMushroomBlock(Blocks.NETHER_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> WARPED_FUNGUS1 = createConfiguredFeature("warped_fungus1",
        BYGFeatures.WARPED_FUNGUS_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.WARPED_STEM)
                .setMushroomBlock(Blocks.WARPED_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WARPED_FUNGUS2 = createConfiguredFeature("warped_fungus2",
        BYGFeatures.WARPED_FUNGUS_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.WARPED_STEM)
                .setMushroomBlock(Blocks.WARPED_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE1 = createConfiguredFeature("sythian_fungus_tree1",
        BYGFeatures.SYTHIAN_FUNGUS_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SYTHIAN_STEM)
                .setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE2 = createConfiguredFeature("sythian_fungus_tree2",
        BYGFeatures.SYTHIAN_FUNGUS_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SYTHIAN_STEM)
                .setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE3 = createConfiguredFeature("sythian_fungus_tree3",
        BYGFeatures.SYTHIAN_FUNGUS_TREE3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SYTHIAN_STEM)
                .setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SYTHIAN_FUNGUS_TREE4 = createConfiguredFeature("sythian_fungus_tree4",
        BYGFeatures.SYTHIAN_FUNGUS_TREE4.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SYTHIAN_STEM)
                .setMushroomBlock(BYGBlocks.SYTHIAN_WART_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE1 = createConfiguredFeature("soul_shroom_tree1",
        BYGFeatures.SOUL_SHROOM_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM)
                .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE2 = createConfiguredFeature("soul_shroom_tree2",
        BYGFeatures.SOUL_SHROOM_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM)
                .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> SOUL_SHROOM_TREE3 = createConfiguredFeature("soul_shroom_tree3",
        BYGFeatures.SOUL_SHROOM_TREE3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM)
                .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE1 = createConfiguredFeature("death_cap_tree1",
        BYGFeatures.DEATH_CAP_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE2 = createConfiguredFeature("death_cap_tree2",
        BYGFeatures.DEATH_CAP_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> DEATH_CAP_TREE3 = createConfiguredFeature("death_cap_tree3",
        BYGFeatures.DEATH_CAP_TREE3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(Blocks.MUSHROOM_STEM)
                .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK)
                .setMinHeight(6)
                .setMaxHeight(12)
                .build()
        ));

    //Nether Trees
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE1 = createConfiguredFeature("lament_twisty_tree1",
        BYGFeatures.LAMENT_TWISTY_TREE1.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE2 = createConfiguredFeature("lament_twisty_tree2",
        BYGFeatures.LAMENT_TWISTY_TREE2.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_TWISTY_TREE3 = createConfiguredFeature("lament_twisty_tree3",
        BYGFeatures.LAMENT_TWISTY_TREE3.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE1 = createConfiguredFeature("lament_weeping_tree1",
        BYGFeatures.LAMENT_WEEPING_TREE1.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .setWhitelist(ImmutableList.of(Blocks.LAVA))
                .build()
        ));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE2 = createConfiguredFeature("lament_weeping_tree2",
        BYGFeatures.LAMENT_WEEPING_TREE2.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .setWhitelist(ImmutableList.of(Blocks.LAVA))
                .build()
        ));
    public static final ConfiguredFeature<BYGTreeConfig, ?> LAMENT_WEEPING_TREE3 = createConfiguredFeature("lament_weeping_tree3",
        BYGFeatures.LAMENT_WEEPING_TREE3.configured(
            new BYGTreeConfig.Builder()
                .setTrunkBlock(BYGBlocks.LAMENT_LOG)
                .setLeavesBlock(BYGBlocks.LAMENT_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .setWhitelist(ImmutableList.of(Blocks.LAVA))
                .build()
        ));

    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE1 = createConfiguredFeature("withering_oak_tree1",
        BYGFeatures.WITHERING_OAK_TREE1.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WITHERING_OAK_LOG)
                .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE2 = createConfiguredFeature("withering_oak_tree2",
        BYGFeatures.WITHERING_OAK_TREE2.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WITHERING_OAK_LOG)
                .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE3 = createConfiguredFeature("withering_oak_tree3",
        BYGFeatures.WITHERING_OAK_TREE3.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WITHERING_OAK_LOG)
                .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE4 = createConfiguredFeature("withering_oak_tree4",
        BYGFeatures.WITHERING_OAK_TREE4.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WITHERING_OAK_LOG)
                .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));
    public static final ConfiguredFeature<BYGMushroomConfig, ?> WITHERING_OAK_TREE5 = createConfiguredFeature("withering_oak_tree5",
        BYGFeatures.WITHERING_OAK_TREE5.configured(
            new BYGMushroomConfig.Builder()
                .setStemBlock(BYGBlocks.WITHERING_OAK_LOG)
                .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES)
                .setMaxHeight(30)
                .setMinHeight(22)
                .build()
        ));

    public static final ConfiguredFeature<?, ?> FUNGI = createConfiguredFeature("fungi", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(WARPED_FUNGUS1.placed(), 0.15F),
        new WeightedPlacedFeature(WARPED_FUNGUS2.placed(), 0.15F),
        new WeightedPlacedFeature(CRIMSON_FUNGUS1.placed(), 0.4F)),
        CRIMSON_FUNGUS2.placed())));

    public static final ConfiguredFeature<?, ?> CRIMSON_GARDEN_VEGETATION = createConfiguredFeature("crimson_garden_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(EMBUR_ROOTS.placed(), 0.45F),
        new WeightedPlacedFeature(TALL_CRIMSON_ROOTS.placed(), 0.8F)),
        CRIMSON_BERRY_BUSH.placed())));

    public static final ConfiguredFeature<?, ?> EMBUR_MUSHROOMS = createConfiguredFeature("embur_mushrooms", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(EMBUR_MUSHROOM4.placed(), 0.25F),
        new WeightedPlacedFeature(EMBUR_MUSHROOM3.placed(), 0.25F),
        new WeightedPlacedFeature(EMBUR_MUSHROOM2.placed(), 0.25F)),
        EMBUR_MUSHROOM.placed())));

    public static final ConfiguredFeature<?, ?> SOUL_SHROOM_TREES = createConfiguredFeature("soul_shroom_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(SOUL_SHROOM_TREE3.placed(), 0.35F),
        new WeightedPlacedFeature(SOUL_SHROOM_TREE2.placed(), 0.35F)),
        SOUL_SHROOM_TREE1.placed())));

    public static final ConfiguredFeature<?, ?> DEATH_CAP_TREES = createConfiguredFeature("death_cap_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(DEATH_CAP_TREE3.placed(), 0.35F),
        new WeightedPlacedFeature(DEATH_CAP_TREE2.placed(), 0.35F)),
        DEATH_CAP_TREE1.placed())));

    public static final ConfiguredFeature<?, ?> SYTHIAN_FUNGI_TREES = createConfiguredFeature("sythian_fungi_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(SYTHIAN_FUNGUS_TREE1.placed(), 0.25F),
        new WeightedPlacedFeature(SYTHIAN_FUNGUS_TREE2.placed(), 0.25F),
        new WeightedPlacedFeature(SYTHIAN_FUNGUS_TREE3.placed(), 0.25F)),
        SYTHIAN_FUNGUS_TREE4.placed())));

    public static final ConfiguredFeature<?, ?> EMBUR_BOG_VEGETATION = createConfiguredFeature("embur_bog_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(TALL_EMBUR_ROOTS.placed(), 0.333F),
        new WeightedPlacedFeature(EMBUR_ROOTS.placed(), 0.333F)),
        EMBUR_WART.placed())));

    public static final ConfiguredFeature<?, ?> GLOWSTONE_GARDEN_VEGETATION = createConfiguredFeature("glowstone_garden_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(SOUL_SHROOM.placed(), 0.33F),
        new WeightedPlacedFeature(DEATH_CAP.placed(), 0.33F)),
        NETHER_BRISTLE.placed())));


    public static final ConfiguredFeature<?, ?> SCORCHED_PLANTS = createConfiguredFeature("scorched_plants", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(SCORCHED_GRASS.placed(), 0.5F)),
        SCORCHED_BUSH.placed())));

    public static final ConfiguredFeature<?, ?> WITHERING_OAK_TREES = createConfiguredFeature("withering_oak_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(WITHERING_OAK_TREE5.placed(), 0.2F),
        new WeightedPlacedFeature(WITHERING_OAK_TREE4.placed(), 0.2F),
        new WeightedPlacedFeature(WITHERING_OAK_TREE3.placed(), 0.2F),
        new WeightedPlacedFeature(WITHERING_OAK_TREE2.placed(), 0.2F)),
        WITHERING_OAK_TREE1.placed())));

    public static final ConfiguredFeature<?, ?> WAILING_VEGETATION = createConfiguredFeature("wailing_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(SCORCHED_BUSH.placed(), 0.333F),
        new WeightedPlacedFeature(SCORCHED_GRASS.placed(), 0.333F)),
        WAILING_GRASS.placed())));

    public static final ConfiguredFeature<?, ?> SYTHIAN_VEGETATION = createConfiguredFeature("sythian_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(SYTHIAN_SPROUT.placed(), 0.333F),
        new WeightedPlacedFeature(SYTHIAN_ROOTS.placed(), 0.333F)),
        SYTHIAN_FUNGUS.placed())));

    public static final ConfiguredFeature<?, ?> MINI_MUSHROOMS = createConfiguredFeature("mini_mushrooms", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(GREEN_MUSHROOM_MINI.placed(), 0.16F),
        new WeightedPlacedFeature(RED_MUSHROOM_MINI.placed(), 0.16F),
        new WeightedPlacedFeature(BROWN_MUSHROOM_MINI.placed(), 0.16F),
        new WeightedPlacedFeature(WEEPING_MILKCAP_MINI.placed(), 0.16F)),
        WOOD_BLEWIT_MINI.placed())));

    public static final ConfiguredFeature<?, ?> WARPED_DESERT_VEGETATION = createConfiguredFeature("warped_desert_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(Util.make(new ArrayList<>(), list -> {
        list.add(new WeightedPlacedFeature(WARPED_BUSH.placed(), 0.25F));
        list.add(new WeightedPlacedFeature(WARPED_CORAL.placed(), 0.25F));
        if (BYG.ENABLE_CACTI) {
            list.add(new WeightedPlacedFeature(WARPED_CACTI.placed(), 0.25F));
        }
    }), WARPED_CORAL_FAN.placed())));

    public static final ConfiguredFeature<?, ?> TWISTY_LAMENT_TREES = createConfiguredFeature("twisty_lament_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(LAMENT_TWISTY_TREE3.placed(), 0.35F),
        new WeightedPlacedFeature(LAMENT_TWISTY_TREE2.placed(), 0.35F)),
        LAMENT_TWISTY_TREE1.placed())));

    public static final ConfiguredFeature<?, ?> WEEPING_LAMENT_TREES = createConfiguredFeature("weeping_lament_trees", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(LAMENT_WEEPING_TREE3.placed(), 0.35F),
        new WeightedPlacedFeature(LAMENT_WEEPING_TREE2.placed(), 0.35F)),
        LAMENT_WEEPING_TREE1.placed())));
}