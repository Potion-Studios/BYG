package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class BYGHugeMushroom {
    @Nullable
    protected abstract BYGAbstractTreeFeature<NoFeatureConfig> getHugeMushroomFeature(Random random);

    public boolean func_242575_a(ISeedReader worldIn, StructureManager structureManager, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        BYGAbstractTreeFeature<NoFeatureConfig> abstracttreefeature = this.getHugeMushroomFeature(random);
        if (abstracttreefeature == null) {
            return false;
        } else {
            BYG.LOGGER.info("NOTNULL");
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            if (abstracttreefeature.func_230362_a_(worldIn, structureManager, chunkGenerator, random, pos, IFeatureConfig.NO_FEATURE_CONFIG)) {
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

        public boolean func_242575_a(ISeedReader worldIn, StructureManager structureManager, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
            for (int i = 0; i >= -1; --i) {
                for (int j = 0; j >= -1; --j) {
                    if (canMassiveMushroomSpawnAt(blockUnder, worldIn, pos, i, j)) {
                        return this.func_242575_aMassiveMushroom(worldIn, structureManager, chunkGenerator, pos, blockUnder, random, i, j);
                    }
                }
            }

            return super.func_242575_a(worldIn, structureManager, chunkGenerator, pos, blockUnder, random);
        }

        @Nullable
        protected abstract BYGAbstractTreeFeature<NoFeatureConfig> getMassiveMushroomFeature(Random random);

        public boolean func_242575_aMassiveMushroom(ISeedReader worldIn, StructureManager structureManager, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random, int xOffset, int zOffset) {
            BYGAbstractTreeFeature<NoFeatureConfig> abstracttreefeature = this.getMassiveMushroomFeature(random);
            if (abstracttreefeature == null) {
                return false;
            } else {
                BlockState blockstate = Blocks.AIR.getDefaultState();
                worldIn.setBlockState(pos.add(xOffset, 0, zOffset), blockstate, 4);
                worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset), blockstate, 4);
                worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 1), blockstate, 4);
                worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 1), blockstate, 4);
                if (abstracttreefeature.func_230362_a_(worldIn, structureManager, chunkGenerator, random, pos.add(xOffset, 0, zOffset), IFeatureConfig.NO_FEATURE_CONFIG)) {
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