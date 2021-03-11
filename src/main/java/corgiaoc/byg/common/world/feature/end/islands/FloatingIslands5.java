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

public class FloatingIslands5 extends Feature<FloatingIslandConfig> {

    FastNoiseLite perlin = null;

    public FloatingIslands5(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());


        if (world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);

        double radius = 25; //default 25
        double radiusFifth = radius / 5;

        //the spikes on the island
        for (double x = -radiusFifth - 5; x <= radiusFifth + 5; x++) {
            for (double y = 1; y <= radiusFifth + 11; y++) {
                for (double z = -radiusFifth - 5; z <= radiusFifth + 5; z++) {
                    mutable.set(pos).move((int) x, (int) y + 6, (int) z);
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ()));
                    double scaledNoise = (noise) * ((Math.pow((y / 2), 2)) / ((Math.pow(x, 2)) + (Math.pow(z, 2))));
                    if (scaledNoise <= 0.5)
                        world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
                }
            }
        }

        //The island itself
        for (double x = -radius - 2; x <= radius + 2; x++) {
            for (double y = 1; y <= radius + 11; y++) {
                for (double z = -radius - 2; z <= radius + 2; z++) {
                    mutable.set(pos).move((int) x, (int) y - 22, (int) z);
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ()));
                    double scaledNoise = (noise) * ((Math.pow((y / 4), 2)) / ((Math.pow(x, 2)) + (Math.pow(z, 2))));
                    if (scaledNoise >= 0.5) {
                        if (y == 36) {
                            world.setBlock(mutable, config.getTopBlockProvider().getState(rand, mutable), 2);
                        } else
                            world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
                    }
                }
            }
        }

        //The crater on the island!
        for (double x = -radiusFifth - 2; x <= radiusFifth + 2; x++) {
            for (double y = 1; y <= radiusFifth + 11; y++) {
                for (double z = -radiusFifth - 2; z <= radiusFifth + 2; z++) {
                    mutable.set(pos).move((int) x, (int) y + 5, (int) z);
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ()));
                    double scaledNoise = (noise) * ((Math.pow((y / 2), 2)) / ((Math.pow(x, 2)) + (Math.pow(z, 2))));
                    if (scaledNoise >= 0.5) {
                        world.setBlock(mutable, Blocks.AIR.defaultBlockState(), 2);
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

