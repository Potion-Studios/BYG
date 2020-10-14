package corgiaoc.byg.common.world.feature.end.islands;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.FloatingIslandConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.noise.module.source.Perlin;

import java.util.Random;

public class FloatingIslands1 extends Feature<FloatingIslandConfig> {

    Perlin perlin = null;

    public FloatingIslands1(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());

        double radius = rand.nextInt(config.getMaxPossibleRadius()) + config.getMinRadius();

        if (world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        int modifiedRadiusOnY = (int) (radius + 11);

        for (double x = -radius; x <= radius; x++) {
            for (double y = -radius; y <= modifiedRadiusOnY; y++) {
                for (double z = -radius; z <= radius; z++) {
                    double noise = perlin.getValue(x, y, z) * 12;
                    double scaledNoise = (noise / 11) * ((y * 3) / ((x * x) + (z * z)));
                    if (scaledNoise >= 0.5) {
                        if (y >= 1) {
                            world.setBlockState(pos.add(x, y - modifiedRadiusOnY, z), config.getBlockProvider().getBlockState(rand, pos), 2);
                            if (y == modifiedRadiusOnY) {
                                //Top block
                                world.setBlockState(pos.add(x, y - modifiedRadiusOnY, z), config.getTopBlockProvider().getBlockState(rand, pos), 2);
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