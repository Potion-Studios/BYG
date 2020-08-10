package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class BYGHugeTree extends BYGTree {
    public static boolean canBigTreeSpawnAt(BlockState blockUnder, BlockView worldIn, BlockPos pos, int xOffset, int zOffset) {
        Block block = blockUnder.getBlock();
        return block == worldIn.getBlockState(pos.add(xOffset, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset + 1, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset, 0, zOffset + 1)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset + 1, 0, zOffset + 1)).getBlock();
    }

    public boolean spawn(ServerWorld worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        for (int i = 0; i >= -1; --i) {
            for (int j = 0; j >= -1; --j) {
                if (canBigTreeSpawnAt(blockUnder, worldIn, pos, i, j)) {
                    return this.spawnBigTree(worldIn, chunkGenerator, pos, blockUnder, random, i, j);
                }
            }
        }

        return super.spawn(worldIn, chunkGenerator, pos, blockUnder, random);
    }

    @Nullable
    protected abstract BYGAbstractTreeFeature<DefaultFeatureConfig> getBigTreeFeature(Random random);

    public boolean spawnBigTree(ServerWorld worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random, int xOffset, int zOffset) {
        BYGAbstractTreeFeature<DefaultFeatureConfig> abstracttreefeature = this.getBigTreeFeature(random);
        if (abstracttreefeature == null) {
            return false;
        } else {
            BlockState blockstate = Blocks.AIR.getDefaultState();
            worldIn.setBlockState(pos.add(xOffset, 0, zOffset), blockstate, 4);
            worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset), blockstate, 4);
            worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 1), blockstate, 4);
            worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 1), blockstate, 4);
            if (abstracttreefeature.placeTree(worldIn, chunkGenerator, random, pos.add(xOffset, 0, zOffset), DefaultFeatureConfig.DEFAULT, true)) {
                return true;
            } else {
                worldIn.setBlockState(pos.add(xOffset, 0, zOffset), blockUnder, 4);
                worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset), blockUnder, 4);
                worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 1), blockUnder, 4);
                worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 1), blockUnder, 4);
                return false;
            }
        }
    }

}