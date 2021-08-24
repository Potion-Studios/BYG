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

public class FloatingIslands2 extends Feature<FloatingIslandConfig> {

    FastNoiseLite perlin = null;

    public FloatingIslands2(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());

        double radius = 15; /*rand.nextInt(config.getMaxPossibleRadius()) + config.getMinRadius() - 5*/
        double halfRadius = radius / 2;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        if (world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        //top bit on the island
        for (double x = -halfRadius - 8; x <= halfRadius + 8; x++) {
            for (double y = -radius - 2; y <= radius; y++) {
                for (double z = -halfRadius - 8; z <= halfRadius + 8; z++) {
                    mutable.set(pos).move((int) x, (int) y, (int) z);
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ()));
                    double distanceSqt1 = x * x + y * y + z * z + noise * noise;
                    if (distanceSqt1 <= halfRadius * radius) {
                        if (world.getBlockState(mutable).getMaterial() == Material.AIR) {
                            if (y == radius)
                                world.setBlock(mutable, config.getTopBlockProvider().getState(rand, mutable), 2);
                            else
                                world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);

                        }
                    }
                }
            }
        }

        //the actual freaking island!!! (actually works now!!!)
        for (double x = -radius - 8; x <= radius + 8; x++) {
            for (double y = 1; y <= radius + 11; y++) {
                for (double z = -radius - 8; z <= radius + 8; z++) {
                    mutable.set(pos).move((int) x, (int) y - 22, (int) z);
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ()));
                    double scaledNoise = (noise) * ((y * 3) / ((x * x) + (z * z)));
                    if (scaledNoise >= 0.5) {
                        if (y == 26)
                            world.setBlock(mutable, config.getTopBlockProvider().getState(rand, mutable), 2);
                        else
                            world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
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
