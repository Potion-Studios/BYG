package potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;

import javax.annotation.Nullable;

public abstract class BYGHugeMushroom {
    @Nullable
    protected abstract ConfiguredFeature<BYGMushroomConfig, ?> getHugeMushroomFeature(RandomSource random);

    public boolean withSpawner(WorldGenLevel worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, RandomSource random) {
        ConfiguredFeature<BYGMushroomConfig, ?> abstractMushroomFeature = this.getHugeMushroomFeature(random);
        if (abstractMushroomFeature == null) {
            return false;
        } else {
            worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 4);
            abstractMushroomFeature.config().forcePlacement();
            if (abstractMushroomFeature.place(worldIn, chunkGenerator, random, pos)) {
                return true;
            } else {
                worldIn.setBlock(pos, blockUnder, 4);
                return false;
            }
        }
    }


}