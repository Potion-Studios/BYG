package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class BYGTree {
    @Nullable
    protected abstract ConfiguredFeature<BYGTreeFeatureConfig, ?> getTreeFeature(Random random);

    public boolean tree(ISeedReader worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        ConfiguredFeature<BYGTreeFeatureConfig, ?> configuredTreeFeature = this.getTreeFeature(random);
        if (configuredTreeFeature == null) {
            return false;
        } else {
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            configuredTreeFeature.config.forcePlacement();
            if (configuredTreeFeature.func_242765_a(worldIn, chunkGenerator, random, pos)) {
                return true;
            } else {
                worldIn.setBlockState(pos, blockUnder, 4);
                return false;
            }
        }
    }
}