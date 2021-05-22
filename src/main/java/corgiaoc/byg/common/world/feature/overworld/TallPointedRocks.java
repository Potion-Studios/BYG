package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.PointyRockConfig;
import corgiaoc.byg.util.noise.fastnoise.FNVector3f;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;

import java.util.Random;

public class TallPointedRocks extends ChunkCoordinatesFeature<PointyRockConfig> {

    public TallPointedRocks(Codec<PointyRockConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ISeedReader world, Random random, IChunk chunkIn, int x, int z, PointyRockConfig config) {
        config.setUpNoise(world.getSeed());
        int xPos = x & 15;
        int zPos = z & 15;
        BlockPos.Mutable mutable = new BlockPos.Mutable(xPos, 0, zPos);

        FNVector3f fnVector3f = new FNVector3f(x, 0, z);

        config.getNoiseGen().GradientPerturb(fnVector3f);

        float sampleNoise = config.getNoiseGen().GetNoise(fnVector3f.x, fnVector3f.z);

        int groundLevel = chunkIn.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, x, z);

        if (!chunkIn.getBlockState(mutable.above(groundLevel)).isAir()) {
            if (sampleNoise < 0.43) {
                int valueToReverse = (int) (Math.abs((int) (sampleNoise * 645D) * 1.8));
                int topHeight = (int) ((valueToReverse - Math.abs(((-sampleNoise * 645D) * 1.8 - valueToReverse))) + (63) * 9.5D);

                //Some magic to stop spires going over the world limit. Point should always occur under world limit(<256).
                topHeight = (int) (redistribute(topHeight, groundLevel) * config.getHeightMultiplier());

                if (topHeight > groundLevel) {
                    mutable.move(Direction.UP, topHeight);
                    for (int yPos = topHeight; yPos >= groundLevel; --yPos) {
                        if (chunkIn.getBlockState(mutable).isAir() && mutable.getY() <= chunkIn.getMaxBuildHeight()) {
                            chunkIn.setBlockState(mutable, config.getBlockProvider().getState(random, mutable), false);
                        }
                        mutable.move(Direction.DOWN);
                    }
                }
            }
        }
        return true;
    }

    private static int redistribute(float height, float groundLevel) {
        float halfG = groundLevel * 0.5f;
        height = (height - 125 - halfG) / 80;
        float sigmoid = height / (1 + Math.abs(height));
        return (int) ((170 - groundLevel) * sigmoid + halfG + 125);
    }
}