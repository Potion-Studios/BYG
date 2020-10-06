package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import corgiaoc.byg.common.world.worldtype.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import corgiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;

public class SubterraneanCave extends SurfaceBuilder<SurfaceBuilderConfig> {
    public SubterraneanCave(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    protected long seed;
    protected ChunkFastSimplexStyleNoise simplex;
    protected ChunkFastSimplexStyleNoise simplex2;

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        int randomer = random.nextInt(25);
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        double rawSimplexNoiseSample = this.octavedSimplex(x, z, 1, 0.01F, 4, 0.7f);
        double simplexNoiseSample = rawSimplexNoiseSample * 55;
        double simplexNoiseSample2 = rawSimplexNoiseSample * 2;
        if (randomer == 0) {
            for (int yPos = 256; yPos >= simplexNoiseSample + 15; --yPos) {
                block.setPos(xPos, yPos, zPos);
                if (yPos > 5 && chunkIn.getBlockState(block).getBlock() == Blocks.STONE) {
                    chunkIn.setBlockState(block, Blocks.GLASS.getDefaultState(), false);
                }
            }
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.TERRACOTTA_CF);
        } else {
//            BYG.LOGGER.info(biomeIn.getRegistryName().toString());

            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.COARSE);
        }
    }

    public void setSeed(long seed) {
        if (this.seed != seed || this.simplex == null) {
            SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
            this.simplex = new ChunkFastSimplexStyleNoise(sharedseedrandom);
        }
        if (this.seed != seed || this.simplex2 == null) {
            SharedSeedRandom sharedseedrandom = new SharedSeedRandom(1999L + seed);
            this.simplex2 = new ChunkFastSimplexStyleNoise(sharedseedrandom);
        }

        this.seed = seed;
    }

    public double octavedSimplex(int x, int y, float amp, float scale, int octaves, float change) {
        double height = 0;
        for (int i = 0; i < octaves; i++) {
            height += amp * simplex.sample2D(x * scale, y * scale);
            scale /= change;
            amp *= change;
        }
        return height;
    }
}