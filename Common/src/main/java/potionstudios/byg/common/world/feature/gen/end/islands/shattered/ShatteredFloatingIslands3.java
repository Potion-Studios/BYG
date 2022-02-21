package potionstudios.byg.common.world.feature.gen.end.islands.shattered;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Material;
import potionstudios.byg.common.world.feature.config.FloatingIslandConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;

import java.util.Random;

public class ShatteredFloatingIslands3 extends Feature<FloatingIslandConfig> {

    FastNoise perlin = null;

    public ShatteredFloatingIslands3(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<FloatingIslandConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        double radius = rand.nextInt(config.getMaxPossibleRadius()) + config.getMinRadius();
        double thirdRadius = radius / 3;

        if (world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        for (double x = -radius - 2; x <= radius + 2; x++) {
            for (double y = -radius - 2; y <= radius + 2; y++) {
                for (double z = -radius - 2; z <= radius + 2; z++) {
                    double squareNoise1 = perlin.GetNoise((float) x, (float) y, (float) z) * 12 - 6;
                    double distanceSqt1 = x * x + y * y + z * z + squareNoise1 * squareNoise1;
                    if (distanceSqt1 <= radius * radius) {
                        mutable.set(pos).move((int) x, (int) y, (int) z);
                        if (world.getBlockState(mutable).getMaterial() == Material.AIR) {
                            if (y <= 1)
                                world.setBlock(mutable, config.getTopBlockProvider().getState(rand, mutable), 2);
                            if (y <= 0)
                                world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
                        }
                    }
                }
            }
        }

        //Island Bottom
        for (double x = -thirdRadius; x <= 0; x++) {
            for (double y = -thirdRadius; y <= 0; y++) {
                for (double z = -thirdRadius; z <= 0; z++) {
                    double squareNoise2 = perlin.GetNoise((float) x, (float) y, (float) z) * 12 - 6;
                    double distanceSqt2 = x * x + y * y + z * z + squareNoise2 * squareNoise2;
                    if (distanceSqt2 <= radius * (thirdRadius + 2)) {
                        if (y <= 1 && y >= -1) {
                            if (x <= 1 && x >= -2) {
                                if (z <= 1 && z >= -2) {
                                    mutable.set(pos).move((int) x + 1, (int) y - 9, (int) z + 1);
                                    world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
                                }
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
