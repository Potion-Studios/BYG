package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import corgiaoc.byg.util.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;

import java.util.Random;

public class VolcanoSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public VolcanoSB(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    protected long seed;
    protected ChunkFastSimplexStyleNoise simplex;
    protected ChunkFastSimplexStyleNoise simplex2;

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        double rawSimplexNoiseSample = this.octavedSimplex(x, z, 1, 0.001F, 2, 0.5f);
        double simplexNoiseSample = rawSimplexNoiseSample * 65;
        double ridgedNoiseSample = 1 - (2 * Math.abs(simplexNoiseSample));

        if (ridgedNoiseSample > -4) {
            for (int yPos = startHeight - 20; yPos >= 170; --yPos) {
                block.setPos(x, yPos, z);
                if (chunkIn.getBlockState(block).getBlock() != Blocks.AIR) {
                    if (yPos >= 175)
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    else if (ridgedNoiseSample > -2.0F && -ridgedNoiseSample < 3.0F) {
                        chunkIn.setBlockState(block, Blocks.LAVA.getDefaultState(), false);
                        chunkIn.getFluidsToBeTicked().scheduleTick(block, Fluids.LAVA, 0);
                    }
                }
            }
        }
        if (noise < 1)
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.BLACK_SAND);
        else
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
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

    public static SurfaceBuilderConfig randomSurfaceConfig(Random random) {
        int randomizer = random.nextInt(3);

        if (randomizer == 1) {
            return BYGSurfaceBuilders.Configs.ROCKY;
        } else
            return BYGSurfaceBuilders.Configs.STONE_BLACK_SAND;

    }
}