package potionstudios.byg.common.world.feature.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import potionstudios.byg.BYG;

import java.util.List;

import static potionstudios.byg.mixin.access.VegetationFeaturesAccess.invokeGrassPatch;

public class BYGFeaturesUtil {

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
        return (CF) createPatchConfiguredFeature(id, block.defaultBlockState(), spread);
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createPatchConfiguredFeature(String id, BlockState state, int spread) {
        return (CF) createConfiguredFeature(id, Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(state))), List.of(), spread)));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createPatchConfiguredFeature(Block block, int spread) {
        return (CF) Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(block))), List.of(), spread));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createSimpleBlockConfiguredFeature(String id, Block block) {
        return createSimpleBlockConfiguredFeature(id, block.defaultBlockState());
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createSimpleBlockConfiguredFeature(String id, BlockState state) {
        return (CF) createConfiguredFeature(id, Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(state))));
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