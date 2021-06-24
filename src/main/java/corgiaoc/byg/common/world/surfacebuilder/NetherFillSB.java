package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.surfacebuilder.config.FillSurfaceBuilderConfig;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.Random;

public class NetherFillSB extends SurfaceBuilder<FillSurfaceBuilderConfig> {
    public NetherFillSB(Codec<FillSurfaceBuilderConfig> config) {
        super(config);
    }

    @Override
    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int i, long seed, FillSurfaceBuilderConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        for (int yPos = 256; yPos >= seaLevel; --yPos) {
            block.set(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            BlockState checkAirForSB = chunkIn.getBlockState(block.up());
            if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && !(checkAirForSB.getBlock() == Blocks.AIR))
                chunkIn.setBlockState(block, BYGBlocks.BLUE_NETHERRACK.getDefaultState(), false);
            if (currentBlockToReplace.getBlock() == Blocks.NETHERRACK && checkAirForSB.getBlock() == Blocks.AIR)
                chunkIn.setBlockState(block, BYGBlocks.EMBUR_NYLIUM.getDefaultState(), false);
        }
    }
}