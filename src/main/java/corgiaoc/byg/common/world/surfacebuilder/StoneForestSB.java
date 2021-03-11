package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.util.noise.fastnoise.FNVector3f;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class StoneForestSB extends SurfaceBuilder<SurfaceBuilderConfig> {

    public StoneForestSB(Codec<SurfaceBuilderConfig> codec) {
        super(codec);
    }

    public static FastNoise noiseGen = null;
    public static FastNoise noiseGen3D = null;

    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        initNoise(random.nextLong());
        int xPos = x & 15;
        int zPos = z & 15;
        BlockPos.Mutable mutable = new BlockPos.Mutable(xPos, 0, zPos);

        FNVector3f fnVector3f = new FNVector3f(x, 0, z);

        noiseGen.GradientPerturb(fnVector3f);

        float sampleNoise = noiseGen.GetNoise(fnVector3f.x, fnVector3f.z);

        int groundLevel = chunkIn.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, x, z);

        if (sampleNoise < 0.43) {
            int topHeight = startHeight + 55;
            mutable.move(Direction.UP, topHeight);
            for (int yPos = topHeight; yPos >= groundLevel; --yPos) {
                if (yPos == topHeight)
                    chunkIn.setBlockState(mutable, config.getTopMaterial(), false);
                else
                    chunkIn.setBlockState(mutable, config.getUnderMaterial(), false);

                mutable.move(Direction.DOWN);
            }
        } else if (sampleNoise < 0.48) {
            int topHeight = startHeight + 44;
            mutable.move(Direction.UP, topHeight);
            for (int yPos = topHeight; yPos >= groundLevel; --yPos) {
                if (yPos == topHeight)
                    chunkIn.setBlockState(mutable, config.getTopMaterial(), false);
                else {
                    double noise3D = noiseGen3D.GetNoise(x, yPos, z);
                    if (noise3D < 0.4)
                        chunkIn.setBlockState(mutable, config.getUnderMaterial(), false);
                }
                mutable.move(Direction.DOWN);
            }
        } else
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(config.getTopMaterial(), config.getUnderMaterial(), config.getUnderwaterMaterial()));
    }

    @Override
    public void initNoise(long seed) {
        if (noiseGen == null) {
            noiseGen = new FastNoise((int) seed);
            noiseGen.SetFractalType(FastNoise.FractalType.RigidMulti);
            noiseGen.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            noiseGen.SetGradientPerturbAmp(5);
            noiseGen.SetFractalOctaves(1);
            noiseGen.SetFractalGain(0.3f);
            noiseGen.SetFrequency(0.02f);
        }

        if (noiseGen3D == null) {
            noiseGen3D = new FastNoise((int) seed);
            noiseGen3D.SetNoiseType(FastNoise.NoiseType.Simplex);
            noiseGen3D.SetFractalGain(0.006f);
            noiseGen3D.SetFrequency(0.7f);
        }
    }
}