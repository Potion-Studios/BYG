package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class QuartzDesertSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public QuartzDesertSB(Codec<SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
    }

    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        for (int yPos = 256; yPos >= seaLevel; --yPos) {
            block.set(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            BlockState checkAirForSB = chunkIn.getBlockState(block.above());
            if (currentBlockToReplace == Blocks.NETHERRACK.defaultBlockState() && !(checkAirForSB.getBlock() == Blocks.AIR))
                chunkIn.setBlockState(block, BYGBlocks.QUARTZITE_SAND.defaultBlockState(), false);
            if (currentBlockToReplace.getBlock() == Blocks.NETHERRACK && checkAirForSB.getBlock() == Blocks.AIR)
                chunkIn.setBlockState(block, BYGBlocks.QUARTZITE_SAND.defaultBlockState(), false);
        }
    }
}