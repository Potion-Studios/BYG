package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import java.util.Random;

public class WindsweptSB extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public static final BlockState WINDSWEPT_SANDSTONE = BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState();

    public WindsweptSB(Codec<SurfaceBuilderBaseConfiguration> p_i51312_1_) {
        super(p_i51312_1_);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int minSurfaceLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        if (noise > 1.75D) {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, minSurfaceLevel, seed, BYGSurfaceBuilders.Configs.WINDSWEPT_SAND);
        } else if (noise > -0.95D) {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, minSurfaceLevel, seed, BYGSurfaceBuilders.Configs.WINDSWEPT_SAND);
        } else {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, minSurfaceLevel, seed, BYGSurfaceBuilders.Configs.WINDSWEPT_SAND);
        }

        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos();
        int xPos = x & 15;
        int zPos = z & 15;
        for (int yPos = startHeight - 3; yPos >= seaLevel; --yPos) {
            block.set(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            if (currentBlockToReplace == Blocks.STONE.defaultBlockState()) {
                chunkIn.setBlockState(block, WINDSWEPT_SANDSTONE , true);
            }
        }
    }
}