package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import java.util.Random;

public class WarpedDesertSB extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public static final BlockState SAND = Blocks.SAND.defaultBlockState();

    public WarpedDesertSB(Codec<SurfaceBuilderBaseConfiguration> config) {
        super(config);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos();
        int xPos = x & 15;
        int zPos = z & 15;

        if (noise > 1.5) {
            for (int yPos = 256; yPos >= seaLevel; --yPos) {
                block.set(xPos, yPos, zPos);
                BlockState currentBlockToReplace = chunkIn.getBlockState(block);
                BlockState airCheck = chunkIn.getBlockState(block.below());

                if (currentBlockToReplace == Blocks.NETHERRACK.defaultBlockState() && airCheck == Blocks.AIR.defaultBlockState())
                    chunkIn.setBlockState(block, BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), false);
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState airCheck2 = chunkIn.getBlockState(block.relative(direction));


                    if (currentBlockToReplace == Blocks.NETHERRACK.defaultBlockState() && airCheck2 == Blocks.AIR.defaultBlockState())
                        chunkIn.setBlockState(block, BYGBlocks.NYLIUM_SOUL_SAND.defaultBlockState(), false);
                }
            }
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.WARPEDDESERT);
        } else {
            for (int yPos = 256; yPos >= seaLevel; --yPos) {
                block.set(xPos, yPos, zPos);
                BlockState currentBlockToReplace = chunkIn.getBlockState(block);
                BlockState airCheck = chunkIn.getBlockState(block.below());

                if (currentBlockToReplace == Blocks.NETHERRACK.defaultBlockState() && airCheck == Blocks.AIR.defaultBlockState())
                    chunkIn.setBlockState(block, BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), false);
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState airCheck2 = chunkIn.getBlockState(block.relative(direction));


                    if (currentBlockToReplace == Blocks.NETHERRACK.defaultBlockState() && airCheck2 == Blocks.AIR.defaultBlockState())
                        chunkIn.setBlockState(block, BYGBlocks.NYLIUM_SOUL_SOIL.defaultBlockState(), false);
                }
            }
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.WARPEDDESERT_SOIL);
        }

    }
}