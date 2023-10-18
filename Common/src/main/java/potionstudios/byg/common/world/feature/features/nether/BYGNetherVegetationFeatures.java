package potionstudios.byg.common.world.feature.features.nether;

import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.config.HangingColumnWithBaseConfig;
import potionstudios.byg.common.world.feature.config.WhitelistedSimpleBlockProviderConfig;
import potionstudios.byg.common.world.feature.features.BYGFeaturesUtil;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;

import java.util.ArrayList;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;
import static potionstudios.byg.common.world.feature.features.overworld.BYGOverworldVegetationFeatures.*;


public class BYGNetherVegetationFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SYTHIAN_ROOTS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("sythian_roots", BYGBlocks.SYTHIAN_ROOTS, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> SYTHIAN_SPROUT = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("sythian_sprout", BYGBlocks.SYTHIAN_SPROUT, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> SYTHIAN_FUNGUS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("sythian_fungus", BYGWoodTypes.SYTHIAN.growerItem(), 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_CACTI = createConfiguredFeature("warped_cacti", () -> Feature.RANDOM_PATCH, () -> FeatureUtils.simpleRandomPatchConfiguration(15, BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(Feature.BLOCK_COLUMN, BlockColumnConfiguration.simple(UniformInt.of(1, 3), BlockStateProvider.simple(BYGBlocks.WARPED_CACTUS.get()))), BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.wouldSurvive(BYGBlocks.WARPED_CACTUS.defaultBlockState(), BlockPos.ZERO))))));

    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_BUSH = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("warped_bush", BYGBlocks.WARPED_BUSH, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_CORAL = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("warped_coral", BYGBlocks.WARPED_CORAL, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_CORAL_FAN = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("warped_coral_fan", BYGBlocks.WARPED_CORAL_FAN, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_SHROOM = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("soul_shroom", BYGBlocks.SOUL_SHROOM, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEATH_CAP = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("death_cap", BYGBlocks.DEATH_CAP, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCORCHED_BUSH = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("scorched_bush", BYGBlocks.SCORCHED_BUSH, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCORCHED_GRASS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("scorched_grass", BYGBlocks.SCORCHED_GRASS, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> WAILING_GRASS = BYGFeaturesUtil.createPatchConfiguredFeatureWithBlock("wailing_grass", BYGBlocks.WAILING_GRASS, 15);
    public static final ResourceKey<ConfiguredFeature<?, ?>> WAILING_VINE = createConfiguredFeature("wailing_vine", BYGFeatures.WAILING_VINES, () -> FeatureConfiguration.NONE);
    public static final ResourceKey<ConfiguredFeature<?, ?>> HANGING_SOUL_SHROOM_SPORES = createConfiguredFeature("hanging_soul_shroom_spores", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SOUL_SHROOM_BLOCK.get()).setBlock(BYGBlocks.SOUL_SHROOM_SPORE.get()).setEndBlock(BYGBlocks.SOUL_SHROOM_SPORE_END.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setPlacementFilter(BlockPredicate.matchesBlocks(Blocks.SOUL_SOIL, Blocks.SOUL_SAND, BYGBlocks.WARPED_SOUL_SAND.get(), BYGBlocks.WARPED_SOUL_SAND.get())).build());
    public static final ResourceKey<ConfiguredFeature<?, ?>> HANGING_SYTHIAN_ROOTS = createConfiguredFeature("hanging_sythian_roots", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGWoodTypes.SYTHIAN.leaves().get()).setBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT.defaultBlockState()).setEndBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, 23)).setMinLength(1).setMaxLength(8).setPlacementFilter(BlockPredicate.matchesBlocks(Blocks.NETHERRACK, BYGWoodTypes.SYTHIAN.leaves().get())).build());
    public static final ResourceKey<ConfiguredFeature<?, ?>> HANGING_BONES = createConfiguredFeature("hanging_bones", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(Blocks.BONE_BLOCK).setBlock(BYGBlocks.HANGING_BONE.get()).setMinLength(1).setMaxLength(8).setPlacementFilter(BlockPredicate.matchesBlocks(BYGBlocks.QUARTZITE_SAND.get(), Blocks.BONE_BLOCK)).build());
    public static final ResourceKey<ConfiguredFeature<?, ?>> SYTHIAN_STALK = createConfiguredFeature("sythian_stalk", BYGFeatures.SYTHIAN_STALK, () -> new ProbabilityFeatureConfiguration(0.9F));
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_CORAL_PLANT = createConfiguredFeature("warped_coral_plant", BYGFeatures.HUGE_WARPED_CORAL_PLANT, () -> new WhitelistedSimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.WARPED_CORAL_BLOCK.defaultBlockState()), ImmutableList.of(BYGBlocks.WARPED_SOUL_SOIL.defaultBlockState(), BYGBlocks.WARPED_SOUL_SAND.defaultBlockState())));

    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_FUNGUS1 = createConfiguredFeature("warped_fungus1",
            BYGFeatures.WARPED_FUNGUS_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.WARPED_STEM)
                    .setMushroomBlock(Blocks.WARPED_WART_BLOCK)
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_FUNGUS2 = createConfiguredFeature("warped_fungus2",
            BYGFeatures.WARPED_FUNGUS_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.WARPED_STEM)
                    .setMushroomBlock(Blocks.WARPED_WART_BLOCK)
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SYTHIAN_FUNGUS_TREE1 = createConfiguredFeature("sythian_fungus_tree1",
            BYGFeatures.SYTHIAN_FUNGUS_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.SYTHIAN.log().get())
                    .setMushroomBlock(BYGWoodTypes.SYTHIAN.leaves().get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SYTHIAN_FUNGUS_TREE2 = createConfiguredFeature("sythian_fungus_tree2",
            BYGFeatures.SYTHIAN_FUNGUS_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.SYTHIAN.log().get())
                    .setMushroomBlock(BYGWoodTypes.SYTHIAN.leaves().get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SYTHIAN_FUNGUS_TREE3 = createConfiguredFeature("sythian_fungus_tree3",
            BYGFeatures.SYTHIAN_FUNGUS_TREE3,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.SYTHIAN.log().get())
                    .setMushroomBlock(BYGWoodTypes.SYTHIAN.leaves().get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SYTHIAN_FUNGUS_TREE4 = createConfiguredFeature("sythian_fungus_tree4",
            BYGFeatures.SYTHIAN_FUNGUS_TREE4,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGWoodTypes.SYTHIAN.log().get())
                    .setMushroomBlock(BYGWoodTypes.SYTHIAN.leaves().get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_SHROOM_TREE1 = createConfiguredFeature("soul_shroom_tree1",
            BYGFeatures.SOUL_SHROOM_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_SHROOM_TREE2 = createConfiguredFeature("soul_shroom_tree2",
            BYGFeatures.SOUL_SHROOM_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_SHROOM_TREE3 = createConfiguredFeature("soul_shroom_tree3",
            BYGFeatures.SOUL_SHROOM_TREE3,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(BYGBlocks.SOUL_SHROOM_STEM.get())
                    .setMushroomBlock(BYGBlocks.SOUL_SHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEATH_CAP_TREE1 = createConfiguredFeature("death_cap_tree1",
            BYGFeatures.DEATH_CAP_TREE1,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.MUSHROOM_STEM)
                    .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEATH_CAP_TREE2 = createConfiguredFeature("death_cap_tree2",
            BYGFeatures.DEATH_CAP_TREE2,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.MUSHROOM_STEM)
                    .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEATH_CAP_TREE3 = createConfiguredFeature("death_cap_tree3",
            BYGFeatures.DEATH_CAP_TREE3,
            () -> new BYGMushroomConfig.Builder()
                    .setStemBlock(Blocks.MUSHROOM_STEM)
                    .setMushroomBlock(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK.get())
                    .setMinHeight(6)
                    .setMaxHeight(12)
                    .build()
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_SHROOM_TREES = createConfiguredFeature("soul_shroom_trees", () -> Feature.RANDOM_SELECTOR, (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SOUL_SHROOM_TREE3)), 0.35F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SOUL_SHROOM_TREE2)), 0.35F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SOUL_SHROOM_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEATH_CAP_TREES = createConfiguredFeature("death_cap_trees", () -> Feature.RANDOM_SELECTOR, (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(DEATH_CAP_TREE3)), 0.35F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(DEATH_CAP_TREE2)), 0.35F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(DEATH_CAP_TREE1)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SYTHIAN_FUNGI_TREES = createConfiguredFeature("sythian_fungi_trees", () -> Feature.RANDOM_SELECTOR, (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SYTHIAN_FUNGUS_TREE1)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SYTHIAN_FUNGUS_TREE2)), 0.25F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SYTHIAN_FUNGUS_TREE3)), 0.25F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SYTHIAN_FUNGUS_TREE4)));
            }
    );


    public static final ResourceKey<ConfiguredFeature<?, ?>> SCORCHED_PLANTS = createConfiguredFeature("scorched_plants", () -> Feature.RANDOM_SELECTOR, (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SCORCHED_GRASS)), 0.5F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SCORCHED_BUSH)));
            }
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> WAILING_VEGETATION = createConfiguredFeature("wailing_vegetation", () -> Feature.RANDOM_SELECTOR, (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SCORCHED_BUSH)), 0.333F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SCORCHED_GRASS)), 0.333F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WAILING_GRASS)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> SYTHIAN_VEGETATION = createConfiguredFeature("sythian_vegetation", () -> Feature.RANDOM_SELECTOR, (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SYTHIAN_SPROUT)), 0.333F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SYTHIAN_ROOTS)), 0.333F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(SYTHIAN_FUNGUS)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MINI_MUSHROOMS = createConfiguredFeature("mini_mushrooms", () -> Feature.RANDOM_SELECTOR, (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(GREEN_MUSHROOM_MINI)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(RED_MUSHROOM_MINI)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(BROWN_MUSHROOM_MINI)), 0.16F),
                        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WEEPING_MILKCAP_MINI)), 0.16F)),
                        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WOOD_BLEWIT_MINI)));
            }
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_DESERT_VEGETATION = createConfiguredFeature("warped_desert_vegetation", () -> Feature.RANDOM_SELECTOR, (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);

                return new RandomFeatureConfiguration(Util.make(new ArrayList<>(), list -> {
                    list.add(new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WARPED_BUSH)), 0.25F));
                    list.add(new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WARPED_CORAL)), 0.25F));
                    if (BYGConstants.ENABLE_CACTI) {
                        list.add(new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WARPED_CACTI)), 0.25F));
                    }
                }), BYGPlacedFeaturesUtil.createPlacedFeatureDirect(lookup.getOrThrow(WARPED_CORAL_FAN)));
            }
    );

    public static void loadClass() {
    }
}