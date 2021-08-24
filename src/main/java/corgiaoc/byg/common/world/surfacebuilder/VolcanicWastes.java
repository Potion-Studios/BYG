package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import java.util.Random;

public class VolcanicWastes extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public VolcanicWastes(Codec<SurfaceBuilderBaseConfiguration> config) {
        super(config);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        if (noise > 0.3)
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.BLACK_SAND);
        else if (noise < -0.3)
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
        else
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, random.nextInt(4) == 0 ?  new SurfaceBuilderBaseConfiguration(Blocks.MAGMA_BLOCK.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState(), BYGBlocks.MAGMATIC_STONE.defaultBlockState()) : new SurfaceBuilderBaseConfiguration(BYGBlocks.MAGMATIC_STONE.defaultBlockState(), Blocks.OBSIDIAN.defaultBlockState(), Blocks.OBSIDIAN.defaultBlockState()));

    }
}