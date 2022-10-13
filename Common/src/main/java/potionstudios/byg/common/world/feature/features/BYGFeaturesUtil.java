package potionstudios.byg.common.world.feature.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
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
import potionstudios.byg.reg.RegistrationProvider;

import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

import static potionstudios.byg.mixin.access.VegetationFeaturesAccess.byg_invokeGrassPatch;

public class BYGFeaturesUtil {

    public static final RegistrationProvider<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = RegistrationProvider.get(BuiltinRegistries.CONFIGURED_FEATURE, BYG.MOD_ID);

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeature(String id, Supplier<? extends F> feature, Supplier<? extends FC> config) {
        return CONFIGURED_FEATURES.<ConfiguredFeature<FC, ?>>register(id, () -> new ConfiguredFeature<>(feature.get(), config.get())).asHolder();
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeature(F feature, Supplier<? extends FC> config) {
        return Holder.direct(new ConfiguredFeature<>(feature, config.get()));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeature(F feature, FC config) {
        return Holder.direct(new ConfiguredFeature<>(feature, config));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> createFlowerConfiguredFeature(String id, Supplier<Block> flowerBlock) {
        return createConfiguredFeature(id, () -> Feature.FLOWER, () -> byg_invokeGrassPatch(SimpleStateProvider.simple(flowerBlock.get().defaultBlockState()), 15));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> createPatchConfiguredFeatureWithBlock(String id, Supplier<? extends Block> block, int tries) {
        return createPatchConfiguredFeatureWithState(id, () -> block.get().defaultBlockState(), tries);
    }

    public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> createPatchConfiguredFeatureWithState(String id, Supplier<BlockState> state, int tries) {
        return createConfiguredFeature(id, () -> Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(state.get())), List.of(), tries));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> createPatchConfiguredFeatureWithState(Block block, int tries) {
        return Holder.direct(new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)), List.of(), tries)));
    }

    public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> createSimpleBlockConfiguredFeatureWithBlock(String id, Supplier<Block> block) {
        return createSimpleBlockConfiguredFeatureWithState(id, () -> block.get().defaultBlockState());
    }

    public static Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> createSimpleBlockConfiguredFeatureWithState(String id, Supplier<BlockState> state) {
        return createConfiguredFeature(id, () -> Feature.SIMPLE_BLOCK, () -> new SimpleBlockConfiguration(BlockStateProvider.simple(state.get())));
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
        return "global/" + stage.toString().toLowerCase(Locale.ROOT);
    }
}