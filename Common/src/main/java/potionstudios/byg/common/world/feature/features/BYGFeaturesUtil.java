package potionstudios.byg.common.world.feature.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import potionstudios.byg.BYG;

import java.util.List;

import static potionstudios.byg.mixin.access.VegetationFeaturesAccess.byg_invokeGrassPatch;

public class BYGFeaturesUtil {

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeature(String id, F feature, FC config) {
        ResourceLocation bygID = BYG.createLocation(id);
        if (BuiltinRegistries.CONFIGURED_FEATURE.keySet().contains(bygID)) {
            throw new IllegalStateException("Configured Feature ID: \"" + bygID.toString() + "\" already exists in the Configured Features registry!");
        }
        return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, BYG.createLocation(id).toString(), new ConfiguredFeature<>(feature, config));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeature(F feature, FC config) {
        return Holder.direct(new ConfiguredFeature<>(feature, config));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> createFlowerConfiguredFeature(String id, Block flowerBlock) {
        return createConfiguredFeature(id, Feature.FLOWER, byg_invokeGrassPatch(SimpleStateProvider.simple(flowerBlock.defaultBlockState()), 15));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> createPatchConfiguredFeature(String id, Block block, int tries) {
        return  createPatchConfiguredFeature(id, block.defaultBlockState(), tries);
    }

    public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> createPatchConfiguredFeature(String id, BlockState state, int tries) {
        return createConfiguredFeature(id, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(state)), List.of(), tries));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> createPatchConfiguredFeature(Block block, int tries) {
        return Holder.direct(new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)), List.of(), tries)));
    }

    public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> createSimpleBlockConfiguredFeature(String id, Block block) {
        return createSimpleBlockConfiguredFeature(id, block.defaultBlockState());
    }

    public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> createSimpleBlockConfiguredFeature(String id, BlockState state) {
        return createConfiguredFeature(id, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(state)));
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


    public static String globalGenStagePath(GenerationStep.Decoration stage) {
        return "global/" + stage.toString().toLowerCase();
    }
}