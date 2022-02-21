package potionstudios.byg.common.world.feature.gen.end.islands.shattered;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import potionstudios.byg.common.world.feature.config.FloatingIslandConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;

import java.util.Random;

public class ShatteredFloatingIslands4 extends Feature<FloatingIslandConfig> {

    FastNoise perlin = null;

    public ShatteredFloatingIslands4(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<FloatingIslandConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());


        if (world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);

        double radius = 13;
        double size = radius / 3;
        double radiusHalved = radius / 2;

        for (double x = -radius; x <= radius; x++) {
            for (double y = -radius; y <= 1; y++) {
                for (double z = -radius; z <= radius; z++) {
                    double squareNoise1 = perlin.GetNoise((float) x, (float) y, (float) z) * 12 - 6;
                    double distanceSqt1 = x * x + y * y + z * z + squareNoise1 * squareNoise1;
                    if (distanceSqt1 <= radius * radius) {
                        if (y <= 1) {
                            world.setBlock(mutable.offset(x, y, z), config.getTopBlockProvider().getState(rand, mutable), 2);
                            if (y <= 0) {
                                world.setBlock(mutable.offset(x, y, z), config.getBlockProvider().getState(rand, mutable), 2);
                                if (y <= -2) {
                                    world.setBlock(mutable.offset(x, y, z), config.getBlockProvider().getState(rand, mutable), 2);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (double x = -radiusHalved; x <= radiusHalved; x++) {
            for (double y = -size; y <= size; y++) {
                for (double z = -radiusHalved; z <= radiusHalved; z++) {
                    double distanceSqt1 = x * x + y * y + z * z;
                    if (distanceSqt1 <= radiusHalved * radiusHalved) {
                        if (y <= 2) {
                            world.setBlock(mutable.offset(x, y, z), Blocks.AIR.defaultBlockState(), 2);
                        }
                    }
                }
            }
        }

        return true;
    }


    public void setSeed(long seed) {
        if (perlin == null) {
            perlin = new FastNoise((int) seed);
            perlin.SetNoiseType(FastNoise.NoiseType.Perlin);
            perlin.SetFrequency(0.2F);
        }
    }
}
