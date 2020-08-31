package voronoiaoc.byg.common.world.carver;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import voronoiaoc.byg.common.noise.fastnoise.FastNoise;
import voronoiaoc.byg.common.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class VolcanicCarver extends WorldCarver<ProbabilityFeatureConfiguration> {

    protected ChunkFastSimplexStyleNoise simplex = new ChunkFastSimplexStyleNoise(1000);

    public VolcanicCarver(Codec<ProbabilityFeatureConfiguration> configIn, int maxHeightIn) {
        super(configIn, maxHeightIn);
    }

    @Override
    public boolean carve(ChunkAccess chunkIn, Function<BlockPos, Biome> posToBiome, Random random, int seaLevel, int chunkX, int chunkZ, int mainChunkX, int mainChunkZ, BitSet carvingMask, ProbabilityFeatureConfiguration carverConfig) {
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
                int topBlockY = chunkIn.getOrCreateHeightmapUnprimed(Heightmap.Types.WORLD_SURFACE_WG).getFirstAvailable(x, z);
                double rawSimplexNoiseSample = noiseGen.GetNoise(x, z) * 10;
                if (rawSimplexNoiseSample > 8.75) {
                    for (int y = topBlockY; y >= 63; y--) {
                        BlockPos.MutableBlockPos mutable1 = new BlockPos.MutableBlockPos(x, y, z);
                        chunkIn.setBlockState(mutable1, Blocks.AIR.defaultBlockState(), false);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean isStartChunk(Random rand, int chunkX, int chunkZ, ProbabilityFeatureConfiguration config) {
        return true;
    }

    @Override
    protected boolean skip(double scaledRelativeX, double scaledRelativeY, double scaledRelativeZ, int y) {
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
