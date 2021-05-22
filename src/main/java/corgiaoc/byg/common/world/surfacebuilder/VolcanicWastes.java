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

    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (noise > 0.3)
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.BLACK_SAND);
        else if (noise < -0.3)
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
        else
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, random.nextInt(4) == 0 ?  new SurfaceBuilderConfig(Blocks.MAGMA_BLOCK.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState()) : new SurfaceBuilderConfig(BYGBlocks.MAGMATIC_STONE.defaultBlockState(), Blocks.OBSIDIAN.defaultBlockState(), Blocks.OBSIDIAN.defaultBlockState()));

    }
}