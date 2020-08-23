package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class CrimsonGardenSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public CrimsonGardenSB(Codec<SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        for (int yPos = 256; yPos >= seaLevel; --yPos) {
            block.setPos(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            BlockState checkAirForSB = chunkIn.getBlockState(block.up());
            if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && !(checkAirForSB.getBlock() == Blocks.AIR))
                chunkIn.setBlockState(block, Blocks.BLACKSTONE.getDefaultState(), false);
            if (currentBlockToReplace.getBlock() == Blocks.NETHERRACK && checkAirForSB.getBlock() == Blocks.AIR)
                chunkIn.setBlockState(block, BYGBlockList.OVERGROWN_CRIMSON_BLACKSTONE.getDefaultState(), false);
        }
    }
}