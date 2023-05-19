package potionstudios.byg.common.world.feature.features.nether;

import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.*;
import potionstudios.byg.common.world.feature.features.BYGFeaturesUtil;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;

import java.util.ArrayList;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createSimpleBlockConfiguredFeatureWithBlock;
import static potionstudios.byg.common.world.feature.features.BYGGlobalFeatureFeatures.createConfiguredFeature;
import static potionstudios.byg.common.world.feature.features.overworld.BYGOverworldVegetationFeatures.*;


public class BYGNetherVegetationFeatures {

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> EMBUR_ROOTS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("embur_roots", BYGBlocks.EMBUR_ROOTS, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TALL_EMBUR_ROOTS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("tall_embur_roots", BYGBlocks.TALL_EMBUR_ROOTS, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> EMBUR_WART = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("embur_wart", BYGWoodTypes.EMBUR.growerItem(), 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> EMBUR_SPROUT = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("embur_sprout", BYGBlocks.EMBUR_SPROUTS, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SYTHIAN_ROOTS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("sythian_roots", BYGBlocks.SYTHIAN_ROOTS, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SYTHIAN_SPROUT = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("sythian_sprout", BYGBlocks.SYTHIAN_SPROUT, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SYTHIAN_FUNGUS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("sythian_fungus", BYGWoodTypes.SYTHIAN.growerItem(), 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WARPED_CACTI = createConfiguredFeature("warped_cacti", () -> Feature.RANDOM_PATCH, () -> FeatureUtils.simpleRandomPatchConfiguration(15, BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BYGFeaturesUtil.createConfiguredFeature(Feature.BLOCK_COLUMN, BlockColumnConfiguration.simple(UniformInt.of(1, 3), BlockStateProvider.simple(BYGBlocks.WARPED_CACTUS.get()))), BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.wouldSurvive(BYGBlocks.WARPED_CACTUS.defaultBlockState(), BlockPos.ZERO))))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WARPED_BUSH = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("warped_bush", BYGBlocks.WARPED_BUSH, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WARPED_CORAL = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("warped_coral", BYGBlocks.WARPED_CORAL, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WARPED_CORAL_FAN = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("warped_coral_fan", BYGBlocks.WARPED_CORAL_FAN, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TALL_CRIMSON_ROOTS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("tall_crimson_roots", BYGBlocks.TALL_CRIMSON_ROOTS, 15);
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> CRIMSON_BERRY_BUSH = createSimpleBlockConfiguredFeatureWithBlock("crimson_berry_bush", BYGBlocks.CRIMSON_BERRY_BUSH);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> EMBUR_LILY = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("embur_lily", BYGBlocks.EMBUR_LILY, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SOUL_SHROOM = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("soul_shroom", BYGBlocks.SOUL_SHROOM, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DEATH_CAP = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("death_cap", BYGBlocks.DEATH_CAP, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NETHER_BRISTLE = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("nether_bristle", BYGBlocks.NETHER_BRISTLE, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SCORCHED_BUSH = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("scorched_bush", BYGBlocks.SCORCHED_BUSH, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SCORCHED_GRASS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("scorched_grass", BYGBlocks.SCORCHED_GRASS, 15);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WAILING_GRASS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("wailing_grass", BYGBlocks.WAILING_GRASS, 15);
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> WAILING_VINE = createConfiguredFeature("wailing_vine", BYGFeatures.WAILING_VINES, () -> FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> LAMENT_SPROUTS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("lament_sprouts", BYGBlocks.LAMENT_SPROUTS, 15);

    public static final Holder<ConfiguredFeature<HangingColumnWithBaseConfig, ?>> WEEPING_ROOTS = createConfiguredFeature("weeping_roots", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.GLOWSTONE).setBlock(BYGBlocks.WEEPING_ROOTS_PLANT.get()).setEndBlock(BYGBlocks.WEEPING_ROOTS.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setPlacementFilter( BlockPredicate.matchesBlocks(Blocks.NETHERRACK, Blocks.GLOWSTONE, Blocks.BLACKSTONE)).build());
    public static final Holder<ConfiguredFeature<HangingColumnWithBaseConfig, ?>> WEEPING_VINES = createConfiguredFeature("weeping_vines", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.GLOWSTONE).setBlock(Blocks.WEEPING_VINES_PLANT).setEndBlock(Blocks.WEEPING_VINES.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setPlacementFilter( BlockPredicate.matchesBlocks(Blocks.NETHERRACK, Blocks.GLOWSTONE, Blocks.BLACKSTONE)).build());


    public static final Holder<ConfiguredFeature<ChainConfig, ?>> CHAINS = createConfiguredFeature("chains", BYGFeatures.CHAIN, () -> new ChainConfig.Builder().setMinLength(6).setMaxLength(10).setXAxisBlock(Blocks.POLISHED_BLACKSTONE_BRICKS).setZAxisBlock(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).setWhitelist(ImmutableList.of(BYGBlocks.SCORIA_STONE.get())).build());
    public static final Holder<ConfiguredFeature<HangingColumnWithBaseConfig, ?>> HANGING_SOUL_SHROOM_SPORES = createConfiguredFeature("hanging_soul_shroom_spores", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SOUL_SHROOM_BLOCK.get()).setBlock(BYGBlocks.SOUL_SHROOM_SPORE.get()).setEndBlock(BYGBlocks.SOUL_SHROOM_SPORE_END.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setPlacementFilter( BlockPredicate.matchesBlocks(Blocks.SOUL_SOIL, Blocks.SOUL_SAND, BYGBlocks.WARPED_SOUL_SAND.get(), BYGBlocks.WARPED_SOUL_SAND.get())).build());
    public static final Holder<ConfiguredFeature<HangingColumnWithBaseConfig, ?>> HANGING_SYTHIAN_ROOTS = createConfiguredFeature("hanging_sythian_roots", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGWoodTypes.SYTHIAN.leaves().get()).setBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT.defaultBlockState()).setEndBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setPlacementFilter( BlockPredicate.matchesBlocks(Blocks.NETHERRACK, BYGWoodTypes.SYTHIAN.leaves().get())).build());
    public static final Holder<ConfiguredFeature<HangingColumnWithBaseConfig, ?>> HANGING_BONES = createConfiguredFeature("hanging_bones", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.BONE_BLOCK).setBlock(BYGBlocks.HANGING_BONE.get()).setMinLength(1).setMaxLength(8).setPlacementFilter( BlockPredicate.matchesBlocks(BYGBlocks.QUARTZITE_SAND.get(), Blocks.BONE_BLOCK)).build());
    public static final Holder<ConfiguredFeature<HangingColumnWithBaseConfig, ?>> LAMENT_VINE_FEATURE = createConfiguredFeature("lament_vine", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.NETHERRACK).setBlock(BYGBlocks.LAMENT_VINE_PLANT.get()).setEndBlock(BYGBlocks.LAMENT_VINE.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setPlacementFilter( BlockPredicate.matchesBlocks(Blocks.NETHERRACK)).build());
    public static final Holder<ConfiguredFeature<ProbabilityFeatureConfiguration, ?>> SYTHIAN_STALK = createConfiguredFeature("sythian_stalk", BYGFeatures.SYTHIAN_STALK, () -> new ProbabilityFeatureConfiguration(0.9F));
    public static final Holder<ConfiguredFeature<WhitelistedSimpleBlockProviderConfig, ?>> WARPED_CORAL_PLANT = createConfiguredFeature("warped_coral_plant", BYGFeatures.HUGE_WARPED_CORAL_PLANT, () -> new WhitelistedSimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.WARPED_CORAL_BLOCK.defaultBlockState()), ImmutableList.of(BYGBlocks.WARPED_SOUL_SOIL.defaultBlockState(), BYGBlocks.WARPED_SOUL_SAND.defaultBlockState())));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> LAMENT_VEGETATION = createConfiguredFeature("lament_vegetation", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SCORCHED_BUSH), 0.2F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SCORCHED_GRASS), 0.2F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(LAMENT_SPROUTS)));

    //Nether Mushrooms
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> EMBUR_MUSHROOM = createConfiguredFeature("embur_mushroom1",
            BYGFeatures.EMBUR_MUSHROOM,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.EMBUR.log().get())
                    .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> EMBUR_MUSHROOM2 = createConfiguredFeature("embur_mushroom2",
            BYGFeatures.EMBUR_MUSHROOM2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.EMBUR.log().get())
                    .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> EMBUR_MUSHROOM3 = createConfiguredFeature("embur_mushroom3",
            BYGFeatures.EMBUR_MUSHROOM3,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.EMBUR.log().get())
                    .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> EMBUR_MUSHROOM4 = createConfiguredFeature("embur_mushroom4",
            BYGFeatures.EMBUR_MUSHROOM4,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.EMBUR.log().get())
                    .setMushroomBlock(BYGBlocks.EMBUR_GEL_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> CRIMSON_FUNGUS1 = createConfiguredFeature("crimson_fungus1",
            BYGFeatures.CRIMSON_FUNGUS_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.CRIMSON_STEM)
                    .setMushroomBlock(Blocks.NETHER_WART_BLOCK)
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> CRIMSON_FUNGUS2 = createConfiguredFeature("crimson_fungus2",
            BYGFeatures.CRIMSON_FUNGUS_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.CRIMSON_STEM)
                    .setMushroomBlock(Blocks.NETHER_WART_BLOCK)
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> WARPED_FUNGUS1 = createConfiguredFeature("warped_fungus1",
            BYGFeatures.WARPED_FUNGUS_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.WARPED_STEM)
                    .setMushroomBlock(Blocks.WARPED_WART_BLOCK)
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> WARPED_FUNGUS2 = createConfiguredFeature("warped_fungus2",
            BYGFeatures.WARPED_FUNGUS_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.WARPED_STEM)
                    .setMushroomBlock(Blocks.WARPED_WART_BLOCK)
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> SYTHIAN_FUNGUS_TREE1 = createConfiguredFeature("sythian_fungus_tree1",
            BYGFeatures.SYTHIAN_FUNGUS_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.SYTHIAN.log().get())
                    .setMushroomBlock(BYGWoodTypes.SYTHIAN.leaves().get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> SYTHIAN_FUNGUS_TREE2 = createConfiguredFeature("sythian_fungus_tree2",
            BYGFeatures.SYTHIAN_FUNGUS_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.SYTHIAN.log().get())
                    .setMushroomBlock(BYGWoodTypes.SYTHIAN.leaves().get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> SYTHIAN_FUNGUS_TREE3 = createConfiguredFeature("sythian_fungus_tree3",
            BYGFeatures.SYTHIAN_FUNGUS_TREE3,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.SYTHIAN.log().get())
                    .setMushroomBlock(BYGWoodTypes.SYTHIAN.leaves().get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> SYTHIAN_FUNGUS_TREE4 = createConfiguredFeature("sythian_fungus_tree4",
            BYGFeatures.SYTHIAN_FUNGUS_TREE4,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.SYTHIAN.log().get())
                    .setMushroomBlock(BYGWoodTypes.SYTHIAN.leaves().get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> SOUL_SHROOM_TREE1 = createConfiguredFeature("soul_shroom_tree1",
            BYGFeatures.SOUL_SHROOM_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> SOUL_SHROOM_TREE2 = createConfiguredFeature("soul_shroom_tree2",
            BYGFeatures.SOUL_SHROOM_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> SOUL_SHROOM_TREE3 = createConfiguredFeature("soul_shroom_tree3",
            BYGFeatures.SOUL_SHROOM_TREE3,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> DEATH_CAP_TREE1 = createConfiguredFeature("death_cap_tree1",
            BYGFeatures.DEATH_CAP_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.MUSHROOM_STEM)
                    .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> DEATH_CAP_TREE2 = createConfiguredFeature("death_cap_tree2",
            BYGFeatures.DEATH_CAP_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.MUSHROOM_STEM)
                    .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> DEATH_CAP_TREE3 = createConfiguredFeature("death_cap_tree3",
            BYGFeatures.DEATH_CAP_TREE3,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.MUSHROOM_STEM)
                    .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    //Nether Trees
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> LAMENT_TWISTY_TREE1 = createConfiguredFeature("lament_twisty_tree1",
            BYGFeatures.LAMENT_TWISTY_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.LAMENT)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> LAMENT_TWISTY_TREE2 = createConfiguredFeature("lament_twisty_tree2",
            BYGFeatures.LAMENT_TWISTY_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.LAMENT)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> LAMENT_TWISTY_TREE3 = createConfiguredFeature("lament_twisty_tree3",
            BYGFeatures.LAMENT_TWISTY_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.LAMENT)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> LAMENT_WEEPING_TREE1 = createConfiguredFeature("lament_weeping_tree1",
            BYGFeatures.LAMENT_WEEPING_TREE1,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.LAMENT)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .setWhitelist(ImmutableList.of(Blocks.LAVA))
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> LAMENT_WEEPING_TREE2 = createConfiguredFeature("lament_weeping_tree2",
            BYGFeatures.LAMENT_WEEPING_TREE2,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.LAMENT)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .setWhitelist(ImmutableList.of(Blocks.LAVA))
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> LAMENT_WEEPING_TREE3 = createConfiguredFeature("lament_weeping_tree3",
            BYGFeatures.LAMENT_WEEPING_TREE3,
            () -> new BYGTreeConfig.Builder()
                    .fromWoodType(BYGWoodTypes.LAMENT)
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .setWhitelist(ImmutableList.of(Blocks.LAVA))
                    .build()
    );

    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> WITHERING_OAK_TREE1 = createConfiguredFeature("withering_oak_tree1",
            BYGFeatures.WITHERING_OAK_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.WITHERING_OAK_LOG.get())
                    .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES.get())
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> WITHERING_OAK_TREE2 = createConfiguredFeature("withering_oak_tree2",
            BYGFeatures.WITHERING_OAK_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.WITHERING_OAK_LOG.get())
                    .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES.get())
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> WITHERING_OAK_TREE3 = createConfiguredFeature("withering_oak_tree3",
            BYGFeatures.WITHERING_OAK_TREE3,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.WITHERING_OAK_LOG.get())
                    .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES.get())
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> WITHERING_OAK_TREE4 = createConfiguredFeature("withering_oak_tree4",
            BYGFeatures.WITHERING_OAK_TREE4,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.WITHERING_OAK_LOG.get())
                    .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES.get())
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );
    public static final Holder<ConfiguredFeature<BYGMushroomConfig, ?>> WITHERING_OAK_TREE5 = createConfiguredFeature("withering_oak_tree5",
            BYGFeatures.WITHERING_OAK_TREE5,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.WITHERING_OAK_LOG.get())
                    .setMushroomBlock(BYGBlocks.WITHERING_OAK_LEAVES.get())
                    .setMaxHeight(30)
                    .setMinHeight(22)
                    .build()
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> FUNGI = createConfiguredFeature("fungi", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WARPED_FUNGUS1), 0.15F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WARPED_FUNGUS2), 0.15F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CRIMSON_FUNGUS1), 0.4F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CRIMSON_FUNGUS2)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CRIMSON_GARDEN_VEGETATION = createConfiguredFeature("crimson_garden_vegetation", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(EMBUR_ROOTS), 0.45F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(TALL_CRIMSON_ROOTS), 0.8F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(CRIMSON_BERRY_BUSH)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> EMBUR_MUSHROOMS = createConfiguredFeature("embur_mushrooms", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(EMBUR_MUSHROOM4), 0.25F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(EMBUR_MUSHROOM3), 0.25F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(EMBUR_MUSHROOM2), 0.25F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(EMBUR_MUSHROOM)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SOUL_SHROOM_TREES = createConfiguredFeature("soul_shroom_trees", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SOUL_SHROOM_TREE3), 0.35F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SOUL_SHROOM_TREE2), 0.35F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SOUL_SHROOM_TREE1)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> DEATH_CAP_TREES = createConfiguredFeature("death_cap_trees", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(DEATH_CAP_TREE3), 0.35F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(DEATH_CAP_TREE2), 0.35F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(DEATH_CAP_TREE1)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SYTHIAN_FUNGI_TREES = createConfiguredFeature("sythian_fungi_trees", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SYTHIAN_FUNGUS_TREE1), 0.25F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SYTHIAN_FUNGUS_TREE2), 0.25F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SYTHIAN_FUNGUS_TREE3), 0.25F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SYTHIAN_FUNGUS_TREE4)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> EMBUR_BOG_VEGETATION = createConfiguredFeature("embur_bog_vegetation", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(TALL_EMBUR_ROOTS), 0.333F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(EMBUR_ROOTS), 0.333F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(EMBUR_WART)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> GLOWSTONE_GARDEN_VEGETATION = createConfiguredFeature("glowstone_garden_vegetation", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SOUL_SHROOM), 0.33F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(DEATH_CAP), 0.33F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(NETHER_BRISTLE)));


    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SCORCHED_PLANTS = createConfiguredFeature("scorched_plants", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SCORCHED_GRASS), 0.5F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SCORCHED_BUSH)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> WITHERING_OAK_TREES = createConfiguredFeature("withering_oak_trees", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WITHERING_OAK_TREE5), 0.2F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WITHERING_OAK_TREE4), 0.2F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WITHERING_OAK_TREE3), 0.2F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WITHERING_OAK_TREE2), 0.2F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WITHERING_OAK_TREE1)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> WAILING_VEGETATION = createConfiguredFeature("wailing_vegetation", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SCORCHED_BUSH), 0.333F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SCORCHED_GRASS), 0.333F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WAILING_GRASS)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SYTHIAN_VEGETATION = createConfiguredFeature("sythian_vegetation", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SYTHIAN_SPROUT), 0.333F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SYTHIAN_ROOTS), 0.333F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SYTHIAN_FUNGUS)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MINI_MUSHROOMS = createConfiguredFeature("mini_mushrooms", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(GREEN_MUSHROOM_MINI), 0.16F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(RED_MUSHROOM_MINI), 0.16F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(BROWN_MUSHROOM_MINI), 0.16F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WEEPING_MILKCAP_MINI), 0.16F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WOOD_BLEWIT_MINI)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> WARPED_DESERT_VEGETATION = createConfiguredFeature("warped_desert_vegetation", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(Util.make(new ArrayList<>(), list -> {
        list.add(new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WARPED_BUSH), 0.25F));
        list.add(new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WARPED_CORAL), 0.25F));
        if (BYGConstants.ENABLE_CACTI) {
            list.add(new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WARPED_CACTI), 0.25F));
        }
    }), BYGPlacedFeaturesUtil.createPlacedFeatureDirect(WARPED_CORAL_FAN)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TWISTY_LAMENT_TREES = createConfiguredFeature("twisty_lament_trees", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(LAMENT_TWISTY_TREE3), 0.35F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(LAMENT_TWISTY_TREE2), 0.35F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(LAMENT_TWISTY_TREE1)));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> WEEPING_LAMENT_TREES = createConfiguredFeature("weeping_lament_trees", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(LAMENT_WEEPING_TREE3), 0.35F),
            new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(LAMENT_WEEPING_TREE2), 0.35F)),
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(LAMENT_WEEPING_TREE1)));

    public static void loadClass() {
    }
}