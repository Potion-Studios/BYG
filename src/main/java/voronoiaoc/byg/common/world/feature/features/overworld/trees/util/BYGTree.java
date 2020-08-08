package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class BYGTree {
    @Nullable
    protected abstract BYGAbstractTreeFeature<DefaultFeatureConfig> getTreeFeature(Random random);

    public boolean spawn(ServerWorld worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        BYGAbstractTreeFeature<DefaultFeatureConfig> abstracttreefeature = this.getTreeFeature(random);
        if (abstracttreefeature == null) {
            return false;
        } else {
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            if (abstracttreefeature.placeTree(worldIn, chunkGenerator, random, pos, DefaultFeatureConfig.DEFAULT, true)) {
                return true;
            } else {
                worldIn.setBlockState(pos, blockUnder, 4);
                return false;
            }
        }

    }
}