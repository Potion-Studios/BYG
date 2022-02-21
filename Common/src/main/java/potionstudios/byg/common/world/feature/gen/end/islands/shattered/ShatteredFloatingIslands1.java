package potionstudios.byg.common.world.feature.gen.end.islands.shattered;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import potionstudios.byg.common.world.feature.config.FloatingIslandConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;

import java.util.Random;

public class ShatteredFloatingIslands1 extends Feature<FloatingIslandConfig> {

    FastNoise perlin = null;


    public ShatteredFloatingIslands1(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<FloatingIslandConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());

        double radius = rand.nextInt(config.getMaxPossibleRadius()) + config.getMinRadius();

        if (world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        int modifiedRadiusOnY = (int) (radius + 11);

        for (double x = -radius; x <= radius; x++) {
            for (double y = -radius; y <= modifiedRadiusOnY; y++) {
                for (double z = -radius; z <= radius; z++) {
                    double noise = perlin.GetNoise((float) x, (float) y, (float) z) * 12;

                    double scaledNoise = (noise / 11) * ((y * 3) / ((x * x) + (z * z)));
                    if (scaledNoise >= 0.5) {
                        if (y >= 1) {
                            world.setBlock(pos.offset(x, y - modifiedRadiusOnY, z), config.getBlockProvider().getState(rand, pos), 2);
                            if (y == modifiedRadiusOnY) {
                                //Top block
                                world.setBlock(pos.offset(x, y - modifiedRadiusOnY, z), config.getTopBlockProvider().getState(rand, pos), 2);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }


    public void setSeed(long seed) {
        if (perlin == null) {
            perlin = new FastNoise((int) seed);
            perlin.SetNoiseType(FastNoise.NoiseType.Perlin);
            perlin.SetFrequency(0.2F);
        }
    }
}