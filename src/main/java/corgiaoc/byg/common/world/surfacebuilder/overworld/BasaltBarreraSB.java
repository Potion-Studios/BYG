package corgiaoc.byg.common.world.surfacebuilder.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class BasaltBarreraSB extends SurfaceBuilder<TernarySurfaceConfig> {

    public static FastNoise noiseGen = null;
    public static FastNoise simplexGen = null;

    public BasaltBarreraSB(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig config) {
        initSeed(seed);
        int xPos = x & 15;
        int zPos = z & 15;
        int topHeight;
        BlockPos.Mutable mutable = new BlockPos.Mutable(xPos, 0, zPos);

        float sampleNoise = noiseGen.GetNoise(x, z);
        float simplexNoise = simplexGen.GetNoise(x, z);

        int groundLevel = chunkIn.sampleHeightmap(Heightmap.Type.OCEAN_FLOOR_WG, x, z);

        if (simplexNoise > 0) {
            topHeight = Math.abs((int) (sampleNoise * 2) * 2) + groundLevel;
        } else {
            topHeight = Math.abs((int) (sampleNoise * 2)) + groundLevel;
        }


        mutable.move(Direction.UP, topHeight);

        for (int y = Math.abs(topHeight); y >= groundLevel - 2; y--) {
            chunkIn.setBlockState(mutable, Blocks.BASALT.getDefaultState(), false);
            mutable.move(Direction.DOWN);
        }
    }

    @Override
    public void initSeed(long seed) {
        if (noiseGen == null) {
            noiseGen = new FastNoise((int) seed);
            noiseGen.SetNoiseType(FastNoise.NoiseType.WhiteNoise);
            noiseGen.SetFractalOctaves(1);
            noiseGen.SetFrequency(0.002f);
        }

        if (simplexGen == null) {
            simplexGen = new FastNoise((int) seed);
            simplexGen.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            simplexGen.SetFractalOctaves(3);
            simplexGen.SetFrequency(0.009f);
        }
    }
}