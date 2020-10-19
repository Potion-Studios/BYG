package corgiaoc.byg.common.world.feature.end.islands;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.FloatingIslandConfig;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
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
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());


        if (world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(pos);

        double radius = 25; //default 25
        double radiusByFifths = radius / 5;

        //the spikes on the island
        for (double x = -radiusByFifths - 5; x <= radiusByFifths + 5; x++) {
            for (double y = -radiusByFifths - 5; y <= radiusByFifths + 11; y++) {
                for (double z = -radiusByFifths - 5; z <= radiusByFifths + 5; z++) {
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(x, y, z));
                    double scaledNoise = (noise) * ((Math.pow((y / 2), 2) ) / ((Math.pow(x, 2)) + (Math.pow(z, 2))));
                    if (scaledNoise <= 0.5) {
                        if (y >= 1) {
                            world.setBlockState(pos.add(x, y + 6, z), config.getTopBlockProvider().getBlockState(rand, mutable), 2);
                            if (y >= 21) {
                                world.setBlockState(pos.add(x, y + 6, z), config.getBlockProvider().getBlockState(rand, mutable), 2);
                                if (y >= 22) {
                                    world.setBlockState(pos.add(x, y + 6, z), config.getTopBlockProvider().getBlockState(rand, mutable), 2);
                                }
                            }
                        }
                    }
                }
            }
        }

        //The island itself
        for (double x = -radius - 2; x <= radius + 2; x++) {
            for (double y = -radius - 2; y <= radius + 11; y++) {
                for (double z = -radius - 2; z <= radius + 2; z++) {
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(x, y, z));
                    double scaledNoise = (noise) * ((Math.pow((y / 4), 2) ) / ((Math.pow(x, 2)) + (Math.pow(z, 2))));
                    if (scaledNoise >= 0.5) {
                        if (y >= 1) {
                            world.setBlockState(pos.add(x, y - 22, z), config.getBlockProvider().getBlockState(rand, mutable), 2);
                            if (y >= 33) {
                                world.setBlockState(pos.add(x, y - 22, z), config.getBlockProvider().getBlockState(rand, mutable), 2);
                                if (y >= 35) {
                                    world.setBlockState(pos.add(x, y - 22, z), config.getTopBlockProvider().getBlockState(rand, mutable), 2);
                                }
                            }
                        }
                    }
                }
            }
        }

        //The crater on the island!
        for (double x = -radiusByFifths - 2; x <= radiusByFifths + 2; x++) {
            for (double y = -radiusByFifths - 2; y <= radiusByFifths + 11; y++) {
                for (double z = -radiusByFifths - 2; z <= radiusByFifths + 2; z++) {
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(x, y, z));
                    double scaledNoise = (noise) * ((Math.pow((y / 2), 2) ) / ((Math.pow(x, 2)) + (Math.pow(z, 2))));
                    if (scaledNoise >= 0.5) {
                        if (y >= 1) {
                            world.setBlockState(pos.add(x, y + 5, z), Blocks.AIR.getDefaultState(), 2);
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

