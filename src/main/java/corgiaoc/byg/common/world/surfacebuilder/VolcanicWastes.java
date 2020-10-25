package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class VolcanicWastes extends SurfaceBuilder<SurfaceBuilderConfig> {
    public VolcanicWastes(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (noise > 0.3)
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.BLACK_SAND);
        else if (noise < -0.3)
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
        else
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, random.nextInt(4) == 0 ?  new SurfaceBuilderConfig(Blocks.MAGMA_BLOCK.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState()) : new SurfaceBuilderConfig(BYGBlocks.MAGMATIC_STONE.getDefaultState(), Blocks.OBSIDIAN.getDefaultState(), Blocks.OBSIDIAN.getDefaultState()));

    }
}