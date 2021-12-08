package corgiaoc.byg.common.world.feature.overworld.trees.util;

import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public abstract class TreeSpawner {
    @Nullable
    protected abstract ConfiguredFeature<BYGTreeConfig, ?> getTreeFeature(Random random);

    public boolean spawn(ISeedReader worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
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