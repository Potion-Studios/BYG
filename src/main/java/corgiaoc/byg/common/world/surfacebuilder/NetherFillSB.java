package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.surfacebuilder.config.FillSurfaceBuilderConfig;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;

import java.util.Random;

public class NetherFillSB extends SurfaceBuilder<FillSurfaceBuilderConfig> {
    public NetherFillSB(Codec<FillSurfaceBuilderConfig> config) {
        super(config);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, FillSurfaceBuilderConfig config) {
        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos();
        int xPos = x & 15;
        int zPos = z & 15;
        for (int yPos = 256; yPos >= seaLevel; --yPos) {
            block.set(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            BlockState checkAirForSB = chunkIn.getBlockState(block.above());
            if (currentBlockToReplace == Blocks.NETHERRACK.defaultBlockState() && !(checkAirForSB.getBlock() == Blocks.AIR))
                chunkIn.setBlockState(block, BYGBlocks.BLUE_NETHERRACK.defaultBlockState(), false);
            if (currentBlockToReplace.getBlock() == Blocks.NETHERRACK && checkAirForSB.getBlock() == Blocks.AIR)
                chunkIn.setBlockState(block, BYGBlocks.EMBUR_NYLIUM.defaultBlockState(), false);
        }
    }
}