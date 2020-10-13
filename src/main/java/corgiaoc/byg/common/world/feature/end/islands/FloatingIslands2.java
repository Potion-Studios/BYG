package corgiaoc.byg.common.world.feature.end.islands;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import org.spongepowered.noise.module.source.Perlin;

import java.util.Random;

public class FloatingIslands2 extends Feature<NoFeatureConfig> {

    Perlin perlin = null;

    public FloatingIslands2(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        setSeed(world.getSeed());

        if (world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        double diameter = 11;
        double size = diameter / 3;
        double radius = diameter / 2;
        int randInt = rand.nextInt(2);

        for (double x = -radius - 2; x <= radius + 8; x++) {

            for (double y = -diameter - 2; y <= diameter + 8; y++) {

                for (double z = -radius - 2; z <= radius + 8; z++) {
                    double squareNoise1 = perlin.getValue(x, y, z) * 12 - 6;
                    double distanceSqt1 = x * x + y * y + z * z + squareNoise1 * squareNoise1;
                    if (distanceSqt1 <= radius * diameter) {
                        if (y >= 1) {
                            world.setBlockState(pos.add(x, y, z), Blocks.END_STONE.getDefaultState(), 2);
                            if (y >= 2) {
                                world.setBlockState(pos.add(x, y, z), Blocks.END_STONE.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }
        }

        for (double x = -diameter - 2; x <= diameter + 2; x++) {
            for (double y = -diameter - 2; y <= diameter + 11; y++) {
                for (double z = -diameter - 2; z <= diameter + 2; z++) {
                    double noise = perlin.getValue(x, y, z) * 12;
                    double scaledNoise = (noise / 11) * ((y * 3) / ((x * x) + (z * z)));
                    if (scaledNoise >= 0.5) {
                        if (y >= 1) {
                            world.setBlockState(pos.add(x, y - 22, z), Blocks.END_STONE.getDefaultState(), 2);
                            if (y >= 20) {
                                world.setBlockState(pos.add(x, y - 22, z), Blocks.END_STONE.getDefaultState(), 2);
                                if (y >= 22) {
                                    world.setBlockState(pos.add(x, y - 22, z), Blocks.END_STONE.getDefaultState(), 2);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (double z = -radius; z <= radius - 7; z++) {
            double x = 0;
            double y = 23;
            double noise = perlin.getValue(x, y, z) * 12;
            double scaledNoise = noise + x + y + z;
            if (scaledNoise >= 0.5) {
                if (y == 23) {
                    world.setBlockState(pos.add(x, y - 22, z), Blocks.LAVA.getDefaultState(), 2);
                }
            }
        }

        return false;
    }


    public void setSeed(long seed) {
        if (perlin == null) {
            perlin = new Perlin();
            perlin.setSeed((int) seed);
            perlin.setFrequency(0.2);
        }
    }
}
