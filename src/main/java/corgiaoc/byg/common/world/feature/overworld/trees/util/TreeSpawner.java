package corgiaoc.byg.common.world.feature.overworld.trees.util;

import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.WeightedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class TreeSpawner {

    @Nullable
    protected abstract WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> getLargeTreeList();

    public boolean spawnTree(ISeedReader worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, BlockState saplingState, Random random) {
        WeightedList<ConfiguredFeature<BYGTreeConfig, ?>> treeFeatureList = getLargeTreeList();
        if (treeFeatureList == null) {
            return false;
        } else {
            ConfiguredFeature<BYGTreeConfig, ?> configuredTreeFeature = treeFeatureList.func_226318_b_(random);

            if (configuredTreeFeature.feature instanceof BYGAbstractTreeFeature) {
                configuredTreeFeature.config.forcePlacement();
                SaplingData saplingData = ((BYGAbstractTreeFeature<BYGTreeConfig>) configuredTreeFeature.feature).saplingData(BlockPos.ZERO);
                BlockPos centerPos = saplingSettings(saplingData, worldIn, pos, saplingState);

                if (centerPos != null)
                    return configuredTreeFeature.func_242765_a(worldIn, chunkGenerator, random, centerPos);
                else
                    return false;
            }
            else {
                return false;
            }
        }
    }

    @Nullable
    public BlockPos saplingSettings(@Nullable SaplingData saplingData, ISeedReader world, BlockPos boneMealPos, BlockState saplingState) {
        BlockPos centerPos = null;

        if (saplingData != null) {
            int searchRange = saplingData.getSearchRange();
            if (searchRange == 0) {
                return boneMealPos;
            } else {
                Set<BlockPos> saplingPosList = new HashSet<>();
                boolean areAllPositionsPresent = false;
                BlockPos.Mutable mutable = new BlockPos.Mutable();
                //Gather Saplings in range
                for (int xOffset = -searchRange; xOffset <= searchRange; xOffset++) {
                    for (int ZOffset = -searchRange; ZOffset <= searchRange; ZOffset++) {
                        mutable.setPos(boneMealPos).move(xOffset, 0, ZOffset);
                        if (world.getBlockState(mutable).getBlock().equals(saplingState.getBlock()))
                            saplingPosList.add(mutable.toImmutable());
                    }
                }

                //Iterate through all sapling positions and ensure all positions required for a tree to spawn are occupied.
                for (BlockPos saplingPos : saplingPosList) {
                    for (BlockPos modifiedPos : saplingData.getTrunkOffsetCoordinates()) {
                        if (world.getBlockState(saplingPos.add(modifiedPos)).getBlock().equals(saplingState.getBlock())) {
                            areAllPositionsPresent = true;
                        } else {
                            areAllPositionsPresent = false;
                            break;
                        }
                    }
                    //If all positions are present, return the center pos value.
                    if (areAllPositionsPresent) {
                        centerPos = saplingPos;
                        break;
                    }
                }
            }
        }
        return centerPos;
    }
}