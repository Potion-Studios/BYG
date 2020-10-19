package corgiaoc.byg.common.world.feature.end.islands;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.FloatingIslandConfig;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class FloatingIslands4 extends Feature<FloatingIslandConfig> {

    FastNoiseLite perlin = null;

    public FloatingIslands4(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());


        if (world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(pos);

        double radius = 8;
        double size = radius / 3;
        double radiusHalved = radius / 2;

        for (double x = -radius; x <= radius; x++) {
            for (double y = -radius; y <= -5; y++) {
                for (double z = -radius; z <= radius; z++) {
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(x, y, z)) * 12 - 6;
                    double distanceSqt1 = x * x + y * y + z * z + noise * noise;
                    if (distanceSqt1 <= radius * radius) {
                        if (y <= 1) {
                            world.setBlockState(mutable.add(x, y, z), config.getTopBlockProvider().getBlockState(rand, mutable), 2);
                            if (y <= 0) {
                                world.setBlockState(mutable.add(x, y, z), config.getBlockProvider().getBlockState(rand, mutable), 2);
                                if (y <= -2) {
                                    world.setBlockState(mutable.add(x, y, z), config.getBlockProvider().getBlockState(rand, mutable), 2);
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
                            world.setBlockState(mutable.add(x, y, z), Blocks.AIR.getDefaultState(), 2);
                        }
                    }
                }
            }
        }

        return true;
    }


    public void setSeed(long seed) {
        if (perlin == null) {
            perlin = FastNoiseLite.createSpongePerlin((int) seed);
            perlin.SetFrequency(0.2F);
        }
    }
}
