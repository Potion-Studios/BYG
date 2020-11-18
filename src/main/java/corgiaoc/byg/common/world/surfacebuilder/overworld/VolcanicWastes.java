package corgiaoc.byg.common.world.surfacebuilder.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class VolcanicWastes extends SurfaceBuilder<TernarySurfaceConfig> {
    public VolcanicWastes(Codec<TernarySurfaceConfig> config) {
        super(config);
    }

    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig config) {
        if (noise > 0.3)
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.BLACK_SAND);
        else if (noise < -0.3)
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
        else
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, random.nextInt(4) == 0 ? new TernarySurfaceConfig(Blocks.MAGMA_BLOCK.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState(), BYGBlocks.MAGMATIC_STONE.getDefaultState()) : new TernarySurfaceConfig(BYGBlocks.MAGMATIC_STONE.getDefaultState(), Blocks.OBSIDIAN.getDefaultState(), Blocks.OBSIDIAN.getDefaultState()));

    }
}