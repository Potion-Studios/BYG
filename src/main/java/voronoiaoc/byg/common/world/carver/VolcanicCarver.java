package voronoiaoc.byg.common.world.carver;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import voronoiaoc.byg.common.world.worldtype.noise.fastnoise.FastNoise;
import voronoiaoc.byg.common.world.worldtype.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class VolcanicCarver extends WorldCarver<ProbabilityConfig> {

    protected ChunkFastSimplexStyleNoise simplex = new ChunkFastSimplexStyleNoise(1000);

    public VolcanicCarver(Function<Dynamic<?>, ? extends ProbabilityConfig> configIn, int maxHeightIn) {
        super(configIn, maxHeightIn);
    }


    public boolean carveRegion(IChunk chunkIn, Function<BlockPos, Biome> getBiomeFunction, Random rand, int seaLevel, int chunkXOff, int chunkZOff, int chunkX, int chunkZ, BitSet carvingMask, ProbabilityConfig config) {
        int xPos = chunkX * 16;
        int zPos = chunkZ * 16;
        FastNoise noiseGen = new FastNoise();
        noiseGen.SetSeed(1000);
        noiseGen.SetFractalType(FastNoise.FractalType.RigidMulti);
        noiseGen.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
        noiseGen.SetFractalOctaves(1);
        noiseGen.SetFractalGain(0.3f);
        noiseGen.SetFrequency(0.003f);

        for (int x = xPos; x <= xPos + 15; x++) {
            for (int z = zPos; z <= zPos + 15; z++) {
                int topBlockY = chunkIn.getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, x, z);
                double rawSimplexNoiseSample = noiseGen.GetNoise(x, z) * 10;
                if (rawSimplexNoiseSample > 8.75) {
                    for (int y = topBlockY; y >= 63; y--) {
                        BlockPos.Mutable mutable1 = new BlockPos.Mutable(x, y, z);
                        chunkIn.setBlockState(mutable1, Blocks.AIR.getDefaultState(), false);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean shouldCarve(Random rand, int chunkX, int chunkZ, ProbabilityConfig config) {
        return true;
    }

    @Override
    protected boolean func_222708_a(double p_222708_1_, double p_222708_3_, double p_222708_5_, int p_222708_7_) {
        return false;
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
