package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;import java.util.Random;

public class DoverMountainSB extends SurfaceBuilder<TernarySurfaceConfig> {
    public DoverMountainSB(Codec<TernarySurfaceConfig> p_i51312_1_) {
        super(p_i51312_1_);
    }

    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        for (int yPos = startHeight - 3; yPos >= seaLevel; --yPos) {
            block.set(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            if (currentBlockToReplace == Blocks.STONE.getDefaultState()) {
                chunkIn.setBlockState(block, BYGBlocks.DACITE.getDefaultState(), false);
            }
        }
        if (noise > 1.75D) {
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.COARSEDIRTDOVERMOUNTAIN_CF);
        } else if (noise > -0.95D) {
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.PODZOLDOVERMOUNTAIN_CF);
        } else {
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.GRASSDOVERMOUNTAIN_CF);
        }

    }
}