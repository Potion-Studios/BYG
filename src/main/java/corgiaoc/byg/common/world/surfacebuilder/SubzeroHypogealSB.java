package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class SubzeroHypogealSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public static final BlockState SAND = Blocks.SAND.defaultBlockState();

    public SubzeroHypogealSB(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;

        if (noise > 1.5) {
            for (int yPos = 256; yPos >= seaLevel; --yPos) {
                block.set(xPos, yPos, zPos);
                BlockState currentBlockToReplace = chunkIn.getBlockState(block);
                BlockState airCheck = chunkIn.getBlockState(block.below());

                if (currentBlockToReplace == Blocks.NETHERRACK.defaultBlockState() && airCheck == Blocks.AIR.defaultBlockState())
                    chunkIn.setBlockState(block, BYGBlocks.FROST_MAGMA.defaultBlockState(), false);
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState airCheck2 = chunkIn.getBlockState(block.relative(direction));


                    if (currentBlockToReplace == Blocks.NETHERRACK.defaultBlockState() && airCheck2 == Blocks.AIR.defaultBlockState())
                        chunkIn.setBlockState(block, BYGBlocks.FROST_MAGMA.defaultBlockState(), false);
                }
            }
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.FROST_MAGMA);
        } else {
            for (int yPos = 256; yPos >= seaLevel; --yPos) {
                block.set(xPos, yPos, zPos);
                BlockState currentBlockToReplace = chunkIn.getBlockState(block);
                BlockState airCheck = chunkIn.getBlockState(block.below());

                if (currentBlockToReplace == Blocks.NETHERRACK.defaultBlockState() && airCheck == Blocks.AIR.defaultBlockState())
                    chunkIn.setBlockState(block, BYGBlocks.SUBZERO_ASH_BLOCK.defaultBlockState(), false);
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState airCheck2 = chunkIn.getBlockState(block.relative(direction));


                    if (currentBlockToReplace == Blocks.NETHERRACK.defaultBlockState() && airCheck2 == Blocks.AIR.defaultBlockState())
                        chunkIn.setBlockState(block, BYGBlocks.SUBZERO_ASH_BLOCK.defaultBlockState(), false);
                }
            }
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.SUBZERO_ASH);
        }

    }
}