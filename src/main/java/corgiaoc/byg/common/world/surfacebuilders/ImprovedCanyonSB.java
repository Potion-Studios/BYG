package corgiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import corgiaoc.byg.common.world.worldtype.noise.fastnoise.FastNoise;
import corgiaoc.byg.common.world.worldtype.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import corgiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;

public class ImprovedCanyonSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public ImprovedCanyonSB(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    protected long seed;
    protected ChunkFastSimplexStyleNoise simplex;

    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        FastNoise noiseGen = new FastNoise();
        noiseGen.SetSeed(1000);
//        noiseGen.SetFractalType(FastNoise.FractalType.RigidMulti);
        noiseGen.SetNoiseType(FastNoise.NoiseType.Cellular);
        noiseGen.SetFractalOctaves(4);
        noiseGen.SetFractalGain(0.3f);
        noiseGen.SetFrequency(0.02f);

        double simplex3D = this.octavedSimplex3D(x, z, seaLevel, 1F, 0.01F, 1, 0.7f);
        double simplexSample3D = simplex3D * 3;
        BlockPos.Mutable carverMutable = new BlockPos.Mutable(x, startHeight, z);
        for (int y = startHeight; y <= startHeight + simplexSample3D; y++) {
            double canyonShapingNoise = noiseGen.GetNoise(x, z) * 10;
            carverMutable.setPos(xPos, y, zPos);
            if (canyonShapingNoise > 8.0) {
                chunkIn.setBlockState(carverMutable, Blocks.STONE.getDefaultState(), false);
            }
        }
        if (noise < 1)
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
        else
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.COARSE);
    }

    @Override
    public void setSeed(long seed) {
        if (this.seed != seed || this.simplex == null) {
            SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
            this.simplex = new ChunkFastSimplexStyleNoise(sharedseedrandom);
        }
        this.seed = seed;
    }

    public double octavedSimplex3D(int x, int y, int z, float amp, float scale, int octaves, float change) {
        double height = 0;
        for (int i = 0; i < octaves; i++) {
            height += amp * simplex.noise3_PlaneFirst(x * scale, y * scale, z * scale);
            scale /= change;
            amp *= change;
        }
        return height;
    }

    public static SurfaceBuilderConfig randomSurfaceConfig(Random random) {
        int randomizer = random.nextInt(3);

        if (randomizer == 1) {
            return SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG;
        } else
            return BYGSBList.BYGSBConfigList.COARSE;

    }
}