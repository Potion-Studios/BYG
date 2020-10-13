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

public class FloatingIslands3 extends Feature<NoFeatureConfig> {

    Perlin perlin = null;

    public FloatingIslands3(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        setSeed(world.getSeed());

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        if (world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;


        double diameter = 11;
        double size = diameter / 3;
        double radius = diameter / 2;
        int randInt = rand.nextInt(2);

        for (double x = -diameter - 2; x <= diameter + 2; x++) {

            for (double y = -diameter - 2; y <= diameter + 2; y++) {

                for (double z = -diameter - 2; z <= diameter + 2; z++) {
                    double squareNoise1 = perlin.getValue(x, y, z) * 12 - 6;
                    double distanceSqt1 = x * x + y * y + z * z + squareNoise1 * squareNoise1;
                    if (distanceSqt1 <= diameter * diameter) {
                        mutable.setPos(pos).move((int)x, (int)y, (int)z);

                        if (y <= 1) {
                            world.setBlockState(mutable, Blocks.END_STONE.getDefaultState(), 2);
                            if (y <= 0) {
                                world.setBlockState(mutable, Blocks.END_STONE.getDefaultState(), 2);
                                if (y <= -2) {
                                    world.setBlockState(mutable, Blocks.END_STONE.getDefaultState(), 2);
                                }
                            }
                        }
                    }
                }
            }
        }

        // code for the bottom of the island!!!
        for (double x = -size; x <= 0; x++) {
            for (double y = -size; y <= 0; y++) {
                for (double z = -size; z <= 0; z++) {
                    for (double w = -diameter - 2; w <= diameter + 2; w++) {
                        for (double v = -diameter - 2; v <= diameter + 2; v++) {
                            for (double u = -diameter - 2; u <= diameter + 2; u++) {
                                double squareNoise2 = perlin.getValue(x, y, z) * 12 - 6;
                                double distanceSqt2 = x * x + y * y + z * z + squareNoise2 * squareNoise2;
                                if (distanceSqt2 <= diameter * (size + 2)) {
                                    if (y <= 1 && y >= -1) {
                                        if (x <= 1 && x >= -2) {
                                            if (z <= 1 && z >= -2) {
                                                mutable.setPos(pos).move((int)x + 1, (int)y - 9, (int)z + 1);
                                                world.setBlockState(mutable, Blocks.END_STONE.getDefaultState(), 2);
                                            }
                                        }
                                    }
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
            perlin = new Perlin();
            perlin.setSeed((int) seed);
            perlin.setFrequency(0.2);
        }
    }
}
