package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;
import java.util.function.Function;

public class WarpedDesertSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public static final BlockState SAND = Blocks.SAND.getDefaultState();

    public WarpedDesertSB(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> config) {
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
                    chunkIn.setBlockState(block, BYGBlockList.NYLIUM_SOUL_SAND.getDefaultState(), false);
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState airCheck2 = chunkIn.getBlockState(block.offset(direction));


                    if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && airCheck2 == Blocks.AIR.getDefaultState())
                        chunkIn.setBlockState(block, BYGBlockList.NYLIUM_SOUL_SAND.getDefaultState(), false);
                }
            }
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.WARPEDDESERT);
        }
        else {
            for (int yPos = 256; yPos >= seaLevel; --yPos) {
                block.setPos(xPos, yPos, zPos);
                BlockState currentBlockToReplace = chunkIn.getBlockState(block);
                BlockState airCheck = chunkIn.getBlockState(block.down());

                if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && airCheck == Blocks.AIR.getDefaultState())
                    chunkIn.setBlockState(block, BYGBlockList.NYLIUM_SOUL_SOIL.getDefaultState(), false);
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState airCheck2 = chunkIn.getBlockState(block.offset(direction));


                    if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState() && airCheck2 == Blocks.AIR.getDefaultState())
                        chunkIn.setBlockState(block, BYGBlockList.NYLIUM_SOUL_SOIL.getDefaultState(), false);
                }
            }
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.WARPEDDESERT_SOIL);
        }

    }
}