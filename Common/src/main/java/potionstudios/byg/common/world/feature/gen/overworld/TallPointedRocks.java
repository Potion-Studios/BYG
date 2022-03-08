package potionstudios.byg.common.world.feature.gen.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;
import potionstudios.byg.common.world.feature.config.PointyRockConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.FNVector3f;

import java.util.Random;

public class TallPointedRocks extends ChunkCoordinatesFeature<PointyRockConfig> {

    public TallPointedRocks(Codec<PointyRockConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(WorldGenLevel world, Random random, ChunkAccess chunkIn, int x, int z, PointyRockConfig config) {
        config.setUpNoise(world.getSeed());
        int xPos = x & 15;
        int zPos = z & 15;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos(xPos, 0, zPos);

        FNVector3f fnVector3f = new FNVector3f(x, 0, z);

        config.getNoiseGen().GradientPerturb(fnVector3f);

        float sampleNoise = config.getNoiseGen().GetNoise(fnVector3f.x, fnVector3f.z);

        int groundLevel = chunkIn.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, x, z);

        BlockPos.MutableBlockPos center = new BlockPos.MutableBlockPos();

        if (!chunkIn.getBlockState(mutable.above(groundLevel)).isAir()) {
            if (sampleNoise < 0.43) {
                int valueToReverse = (int) (Math.abs((int) (sampleNoise * 645D) * 1.8));
                int topHeight = (int) ((valueToReverse - Math.abs(((-sampleNoise * 645D) * 1.8 - valueToReverse))) + (63) * 9.5D);

                //Some magic to stop spires going over the world limit. Point should always occur under world limit(<256).
                topHeight = (int) (redistribute(topHeight, groundLevel) * config.getHeightMultiplier());


                if (topHeight > groundLevel) {
                    mutable.move(Direction.UP, topHeight);
                    if (center.getY() < mutable.getY()) {
                        center.set(mutable);
                    }

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