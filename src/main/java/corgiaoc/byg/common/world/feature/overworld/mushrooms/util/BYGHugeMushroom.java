package corgiaoc.byg.common.world.feature.overworld.mushrooms.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import corgiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class BYGHugeMushroom {
    @Nullable
    protected abstract ConfiguredFeature<BYGMushroomFeatureConfig, ?> getHugeMushroomFeature(Random random);

    public boolean withSpawner(ISeedReader worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        ConfiguredFeature<BYGMushroomFeatureConfig, ?> abstractMushroomFeature = this.getHugeMushroomFeature(random);
        if (abstractMushroomFeature == null) {
            return false;
        } else {
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            abstractMushroomFeature.config.forcePlacement();
            if (abstractMushroomFeature.func_242765_a(worldIn, chunkGenerator, random, pos)) {
                return true;
            } else {
                worldIn.setBlockState(pos, blockUnder, 4);
                return false;
            }
        }
    }


    public static abstract class Massive extends BYGHugeMushroom {
        public static boolean canMassiveMushroomSpawnAt(BlockState blockUnder, IBlockReader worldIn, BlockPos pos, int xOffset, int zOffset) {
            Block block = blockUnder.getBlock();
            return block == worldIn.getBlockState(pos.add(xOffset, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset + 1, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset, 0, zOffset + 1)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset + 1, 0, zOffset + 1)).getBlock();
        }

        public boolean withSpawner(ISeedReader worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
            for (int i = 0; i >= -1; --i) {
                for (int j = 0; j >= -1; --j) {
                    if (canMassiveMushroomSpawnAt(blockUnder, worldIn, pos, i, j)) {
                        return this.massiveMushroom(worldIn, chunkGenerator, pos, blockUnder, random, i, j);
                    }
                }
            }

            return super.withSpawner(worldIn, chunkGenerator, pos, blockUnder, random);
        }

        @Nullable
        protected abstract ConfiguredFeature<BYGMushroomFeatureConfig, ?> getMassiveMushroomFeature(Random random);

        public boolean massiveMushroom(ISeedReader worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random, int xOffset, int zOffset) {
            ConfiguredFeature<BYGMushroomFeatureConfig, ?> abstractMushroomFeature = this.getMassiveMushroomFeature(random);
            if (abstractMushroomFeature == null) {
                return false;
            } else {
                BlockState blockstate = Blocks.AIR.getDefaultState();
                worldIn.setBlockState(pos.add(xOffset, 0, zOffset), blockstate, 4);
                worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset), blockstate, 4);
                worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 1), blockstate, 4);
                worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 1), blockstate, 4);
                abstractMushroomFeature.config.forcePlacement();
                if (abstractMushroomFeature.func_242765_a(worldIn, chunkGenerator, random, pos.add(xOffset, 0, zOffset))) {
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