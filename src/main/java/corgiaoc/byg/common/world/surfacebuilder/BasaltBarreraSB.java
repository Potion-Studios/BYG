package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class BasaltBarreraSB extends SurfaceBuilder<SurfaceBuilderConfig> {

    public static FastNoise noiseGen = null;
    public static FastNoise simplexGen = null;

    public BasaltBarreraSB(Codec<SurfaceBuilderConfig> codec) {
        super(codec);
    }

    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        initNoise(seed);
        int xPos = x & 15;
        int zPos = z & 15;
        int topHeight;
        BlockPos.Mutable mutable = new BlockPos.Mutable(xPos, 0, zPos);

        float sampleNoise = noiseGen.GetNoise(x, z);
        float simplexNoise = simplexGen.GetNoise(x, z);

        int groundLevel = chunkIn.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, x, z);

        if (simplexNoise > 0) {
            topHeight = Math.abs((int) (sampleNoise * 2) * 2) + groundLevel;
        } else {
            topHeight = Math.abs((int) (sampleNoise * 2)) + groundLevel;
        }


        mutable.move(Direction.UP, topHeight);

        for (int y = Math.abs(topHeight); y >= groundLevel - 2; y--) {
            chunkIn.setBlockState(mutable, Blocks.BASALT.defaultBlockState(), false);
            mutable.move(Direction.DOWN);
        }
    }

    @Override
    public void initNoise(long seed) {
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