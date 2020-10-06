package corgiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import corgiaoc.byg.core.byglists.BYGBlockList;
import corgiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;

public class SubzeroHypogealSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public static final BlockState SAND = Blocks.SAND.getDefaultState();

    public SubzeroHypogealSB(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;

        if (noise > 1.5) {
            for (int yPos = 256; yPos >= seaLevel; --yPos) {
                block.setPos(xPos, yPos, zPos);
                BlockState currentBlockToReplace = chunkIn.getBlockState(block);
                BlockState airCheck = chunkIn.getBlockState(block.down());

                if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && airCheck == Blocks.AIR.getDefaultState())
                    chunkIn.setBlockState(block, BYGBlockList.FROST_MAGMA.getDefaultState(), false);
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState airCheck2 = chunkIn.getBlockState(block.offset(direction));


                    if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && airCheck2 == Blocks.AIR.getDefaultState())
                        chunkIn.setBlockState(block, BYGBlockList.FROST_MAGMA.getDefaultState(), false);
                }
            }
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.FROST_MAGMA);
        } else {
            for (int yPos = 256; yPos >= seaLevel; --yPos) {
                block.setPos(xPos, yPos, zPos);
                BlockState currentBlockToReplace = chunkIn.getBlockState(block);
                BlockState airCheck = chunkIn.getBlockState(block.down());

                if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && airCheck == Blocks.AIR.getDefaultState())
                    chunkIn.setBlockState(block, BYGBlockList.SUBZERO_ASH_BLOCK.getDefaultState(), false);
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState airCheck2 = chunkIn.getBlockState(block.offset(direction));


                    if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && airCheck2 == Blocks.AIR.getDefaultState())
                        chunkIn.setBlockState(block, BYGBlockList.SUBZERO_ASH_BLOCK.getDefaultState(), false);
                }
            }
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.SUBZERO_ASH);
        }

    }
}