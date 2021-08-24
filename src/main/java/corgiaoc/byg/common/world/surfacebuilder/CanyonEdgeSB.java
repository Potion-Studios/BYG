package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.material.Fluids;

import java.util.Random;

public class CanyonEdgeSB extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public CanyonEdgeSB(Codec<SurfaceBuilderBaseConfiguration> config) {
        super(config);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        int xPos = x & 15;
        int zPos = z & 15;
        for (int yPos = startHeight + 100; yPos >= seaLevel - 3; --yPos) {
            mutable.set(xPos, yPos, zPos);
            if (yPos >= seaLevel - 1)
                chunkIn.setBlockState(mutable, Blocks.AIR.defaultBlockState(), false);
        }

        for (int y = seaLevel - 1; y >= seaLevel - 20; y--) {
            mutable.set(xPos, y, zPos);
            if (chunkIn.getBlockState(mutable).isAir()) {
                chunkIn.setBlockState(mutable, Blocks.WATER.defaultBlockState(), false);
                chunkIn.getLiquidTicks().scheduleTick(mutable, Fluids.WATER, 0);
            }
        }
        SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderBaseConfiguration(Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState()));
    }
}