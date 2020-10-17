package corgiaoc.byg.common.world.feature.overworld.trees.util;

import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class BYGHugeTree extends BYGTree {

    public boolean spawnTree(ISeedReader worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, BlockState saplingState, Random random) {
        return this.bigTree(worldIn, chunkGenerator, pos, blockUnder, saplingState, random);
    }

    @Nullable
    protected abstract ConfiguredFeature<BYGTreeConfig, ?> getBigTreeFeature(Random random);

    public boolean bigTree(ISeedReader worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, BlockState saplingState, Random random) {
        ConfiguredFeature<BYGTreeConfig, ?> configuredTreeFeature = this.getBigTreeFeature(random);
        if (configuredTreeFeature == null) {
            return false;
        } else {
            if (configuredTreeFeature.feature instanceof BYGAbstractTreeFeature) {
                configuredTreeFeature.config.forcePlacement();
                SaplingData saplingData = ((BYGAbstractTreeFeature<BYGTreeConfig>) configuredTreeFeature.feature).saplingData();
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
            Set<BlockPos> saplingPosList = new HashSet<>();
            boolean areAllPositionsPresent = false;
            int searchRange = saplingData.getSearchRange();
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            //Gather Saplings
            for (int xOffset = -searchRange; xOffset <= searchRange; xOffset++) {
                for (int ZOffset = -searchRange; ZOffset <= searchRange; ZOffset++) {
                    mutable.setPos(boneMealPos).move(xOffset, 0, ZOffset);
                    if (world.getBlockState(mutable).getBlock().equals(saplingState.getBlock()))
                        saplingPosList.add(mutable.toImmutable());
                }
            }

            for (BlockPos saplingPos : saplingPosList) {
                for (BlockPos modifiedPos : saplingData.getTrunkOffsetCoordinates()) {
                    if (world.getBlockState(saplingPos.add(modifiedPos)).getBlock().equals(saplingState.getBlock())) {
                        areAllPositionsPresent = true;
                        System.out.println(saplingPos.add(modifiedPos).toString() + "/" + saplingPos.toString());
                    }
                    else {
                        areAllPositionsPresent = false;
                        break;
                    }
                }
                if (areAllPositionsPresent) {
                    centerPos = saplingPos;
                    break;
                }
            }
        }
        return centerPos;
    }
}