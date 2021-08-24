package corgiaoc.byg.common.world.feature.overworld.trees.util;

import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public abstract class TreeSpawner {
    @Nullable
    protected abstract ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random);

    public boolean spawn(WorldGenLevel worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        ConfiguredFeature<BYGTreeConfig, ?> configuredTreeFeature = this.getTreeFeature(random);
        if (configuredTreeFeature == null) {
            return false;
        } else {
            worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 4);
            configuredTreeFeature.config.forcePlacement();
            if (configuredTreeFeature.place(worldIn, chunkGenerator, random, pos)) {
                return true;
            } else {
                worldIn.setBlock(pos, blockUnder, 4);
                return false;
            }
        }
    }
}