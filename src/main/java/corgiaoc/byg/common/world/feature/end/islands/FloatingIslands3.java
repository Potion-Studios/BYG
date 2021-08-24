package corgiaoc.byg.common.world.feature.end.islands;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.FloatingIslandConfig;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class FloatingIslands3 extends Feature<FloatingIslandConfig> {

    FastNoiseLite perlin = null;

    public FloatingIslands3(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        double radius = rand.nextInt(config.getMaxPossibleRadius()) + config.getMinRadius() - 5;
        double thirdRadius = radius / 3;

        if (world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        for (double x = -radius - 5; x <= radius + 5; x++) {
            for (double y = -radius - 5; y <= radius + 5; y++) {
                for (double z = -radius - 5; z <= radius + 5; z++) {
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(x, y, z));
                    double distanceSqt1 = x * x + y * y + z * z + noise * noise;
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
        for (double x = -thirdRadius; x <= thirdRadius; x++) {
            for (double y = -thirdRadius; y <= thirdRadius; y++) {
                for (double z = -thirdRadius; z <= thirdRadius; z++) {
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(x, y, z));
                    double distanceSqt2 = x * x + y * y + z * z + noise * noise;
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
            perlin = FastNoiseLite.createSpongePerlin((int) seed);
            perlin.SetFrequency(0.2F);
        }
    }
}
