package corgiaoc.byg.common.world.feature.overworld.trees.util;

import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class BYGTree {
    @Nullable
    protected abstract ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random);

    public boolean spawnTree(ISeedReader worldIn, ChunkGenerator chunkGenerator, BlockPos bonemealPos, BlockState blockUnder, BlockState saplingState, Random random) {
        ConfiguredFeature <BYGTreeConfig, ?> configuredTreeFeature = this.getTreeFeature(random);
        if (configuredTreeFeature == null) {
            return false;
        } else {
            worldIn.setBlockState(bonemealPos, Blocks.AIR.getDefaultState(), 4);
            configuredTreeFeature.config.forcePlacement();
            if (configuredTreeFeature.func_242765_a(worldIn, chunkGenerator, random, bonemealPos)) {
                return true;
            } else {
                worldIn.setBlockState(bonemealPos, blockUnder, 4);
                return false;
            }
        }
    }
}