package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class CanyonEdgeSB extends SurfaceBuilder<TernarySurfaceConfig> {
    public CanyonEdgeSB(Codec<TernarySurfaceConfig> config) {
        super(config);
    }

    @Override
    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int i, long seed, TernarySurfaceConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        for (int yPos = startHeight + 100; yPos >= seaLevel - 3; --yPos) {
            mutable.set(xPos, yPos, zPos);
            if (yPos >= seaLevel - 1)
                chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
        }

        for (int y = seaLevel - 1; y >= seaLevel - 20; y--) {
            mutable.set(xPos, y, zPos);
            if (chunkIn.getBlockState(mutable).isAir()) {
                chunkIn.setBlockState(mutable, Blocks.WATER.getDefaultState(), false);
                chunkIn.getFluidTickScheduler().schedule(mutable, Fluids.WATER, 0);
            }
        }
        SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, i, seed, new TernarySurfaceConfig(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState()));
    }
}