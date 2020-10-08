package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.PointyRockFeatureConfig;
import corgiaoc.byg.util.noise.fastnoise.FNVector3f;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class TallPointedRocks extends Feature<PointyRockFeatureConfig> {

    public TallPointedRocks(Codec<PointyRockFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, PointyRockFeatureConfig config) {
        ChunkPos chunk = world.getChunk(pos).getPos();
        int xStart = chunk.getXStart();
        int zStart = chunk.getZStart();
        for(int xMove = 0; xMove < 16; ++xMove) {
            for (int zMove = 0; zMove < 16; ++zMove) {
                int x = xStart + xMove;
                int z = zStart + zMove;
                buildPointedRock(world.getSeed(), rand, world.getChunk(pos), x, z, config);
            }
        }
        return true;
    }

    private FastNoise noiseGen = null;

    public void buildPointedRock(long seed, Random random, IChunk chunkIn, int x, int z, PointyRockFeatureConfig config) {
        setSeed(seed + config.getSeed());
        int xPos = x & 15;
        int zPos = z & 15;
        BlockPos.Mutable mutable = new BlockPos.Mutable(xPos, 0, zPos);

        FNVector3f fnVector3f = new FNVector3f(x, 0, z);

        noiseGen.GradientPerturb(fnVector3f);

        float sampleNoise = noiseGen.GetNoise(fnVector3f.x, fnVector3f.z);

        int groundLevel = chunkIn.getTopBlockY(Heightmap.Type.OCEAN_FLOOR_WG, x, z);

        if (!chunkIn.getBlockState(mutable.up(groundLevel)).isAir()) {
            if (sampleNoise < 0.43) {
                int valueToReverse = (int) (Math.abs((int) (sampleNoise * 645D) * 1.8));
                int topHeight = (int) ((valueToReverse - Math.abs(((-sampleNoise * 645D) * 1.8 - valueToReverse))) + (63) * 9.5D);

                //Some magic to stop spires going over the world limit. Point should always occur under world limit(<256).
                topHeight = (int) (redistribute(topHeight, groundLevel) * config.getHeightMultiplier());

                if (topHeight > groundLevel) {
                    mutable.move(Direction.UP, topHeight);
                    for (int yPos = topHeight; yPos >= groundLevel; --yPos) {
                        if (chunkIn.getBlockState(mutable).isAir() && mutable.getY() <= chunkIn.getHeight()) {
                            chunkIn.setBlockState(mutable, config.getBlockProvider().getBlockState(random, mutable), false);
                        }
                        mutable.move(Direction.DOWN);
                    }
                }
            }
        }
    }

    public void setSeed(long seed) {
        if (noiseGen == null) {
            noiseGen = new FastNoise((int) seed);
            noiseGen.SetFractalType(FastNoise.FractalType.RigidMulti);
            noiseGen.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            noiseGen.SetGradientPerturbAmp(5);
            noiseGen.SetFractalOctaves(1);
            noiseGen.SetFractalGain(0.3f);
            noiseGen.SetFrequency(0.02f);
        }
    }

    private static int redistribute(float height, float groundLevel) {
        float halfG = groundLevel * 0.5f;
        height = (height - 125 - halfG) / 80;
        float sigmoid = height / (1 + Math.abs(height));
        return (int) ((170 - groundLevel) * sigmoid + halfG + 125);
    }
}