package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class BYGHugeMushroom {
    @Nullable
    protected abstract BYGAbstractTreeFeature<DefaultFeatureConfig> getHugeMushroomFeature(Random random);

    public boolean spawn(ServerWorld worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        BYGAbstractTreeFeature<DefaultFeatureConfig> abstracttreefeature = this.getHugeMushroomFeature(random);
        if (abstracttreefeature == null) {
            return false;
        } else {
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            if (abstracttreefeature.generate(worldIn, chunkGenerator, random, pos, DefaultFeatureConfig.DEFAULT)) {
                return true;
            } else {
                worldIn.setBlockState(pos, blockUnder, 4);
                return false;
            }
        }
    }


    public static abstract class Massive extends BYGHugeMushroom {
        public static boolean canMassiveMushroomSpawnAt(BlockState blockUnder, BlockView worldIn, BlockPos pos, int xOffset, int zOffset) {
            Block block = blockUnder.getBlock();
            return block == worldIn.getBlockState(pos.add(xOffset, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset + 1, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset, 0, zOffset + 1)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset + 1, 0, zOffset + 1)).getBlock();
        }

        public boolean spawn(ServerWorld worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
            for (int i = 0; i >= -1; --i) {
                for (int j = 0; j >= -1; --j) {
                    if (canMassiveMushroomSpawnAt(blockUnder, worldIn, pos, i, j)) {
                        return this.spawnMassiveMushroom(worldIn, chunkGenerator, pos, blockUnder, random, i, j);
                    }
                }
            }

            return super.spawn(worldIn, chunkGenerator, pos, blockUnder, random);
        }

        @Nullable
        protected abstract BYGAbstractTreeFeature<DefaultFeatureConfig> getMassiveMushroomFeature(Random random);

        public boolean spawnMassiveMushroom(ServerWorld worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random, int xOffset, int zOffset) {
            BYGAbstractTreeFeature<DefaultFeatureConfig> abstracttreefeature = this.getMassiveMushroomFeature(random);
            if (abstracttreefeature == null) {
                return false;
            } else {
                BlockState blockstate = Blocks.AIR.getDefaultState();
                worldIn.setBlockState(pos.add(xOffset, 0, zOffset), blockstate, 4);
                worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset), blockstate, 4);
                worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 1), blockstate, 4);
                worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 1), blockstate, 4);
                if (abstracttreefeature.generate(worldIn, chunkGenerator, random, pos.add(xOffset, 0, zOffset), DefaultFeatureConfig.DEFAULT)) {
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
}