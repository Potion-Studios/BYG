package voronoiaoc.byg.common.world.feature.features.overworld.trees.util;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import java.util.Random;

public abstract class BYGHugeTree extends BYGTree {
    public static boolean canBigTreeSpawnAt(BlockState blockUnder, BlockGetter worldIn, BlockPos pos, int xOffset, int zOffset) {
        Block block = blockUnder.getBlock();
        return block == worldIn.getBlockState(pos.offset(xOffset, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.offset(xOffset + 1, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.offset(xOffset, 0, zOffset + 1)).getBlock() && block == worldIn.getBlockState(pos.offset(xOffset + 1, 0, zOffset + 1)).getBlock();
    }

    public boolean spawn(ServerLevel worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
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
    protected abstract BYGAbstractTreeFeature<NoneFeatureConfiguration> getBigTreeFeature(Random random);

    public boolean spawnBigTree(ServerLevel worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random, int xOffset, int zOffset) {
        BYGAbstractTreeFeature<NoneFeatureConfiguration> abstracttreefeature = this.getBigTreeFeature(random);
        if (abstracttreefeature == null) {
            return false;
        } else {
            BlockState blockstate = Blocks.AIR.defaultBlockState();
            worldIn.setBlock(pos.offset(xOffset, 0, zOffset), blockstate, 4);
            worldIn.setBlock(pos.offset(xOffset + 1, 0, zOffset), blockstate, 4);
            worldIn.setBlock(pos.offset(xOffset, 0, zOffset + 1), blockstate, 4);
            worldIn.setBlock(pos.offset(xOffset + 1, 0, zOffset + 1), blockstate, 4);
            if (abstracttreefeature.placeTree(worldIn, chunkGenerator, random, pos.offset(xOffset, 0, zOffset), NoneFeatureConfiguration.NONE, true)) {
                return true;
            } else {
                worldIn.setBlock(pos.offset(xOffset, 0, zOffset), blockUnder, 4);
                worldIn.setBlock(pos.offset(xOffset + 1, 0, zOffset), blockUnder, 4);
                worldIn.setBlock(pos.offset(xOffset, 0, zOffset + 1), blockUnder, 4);
                worldIn.setBlock(pos.offset(xOffset + 1, 0, zOffset + 1), blockUnder, 4);
                return false;
            }
        }
    }

}