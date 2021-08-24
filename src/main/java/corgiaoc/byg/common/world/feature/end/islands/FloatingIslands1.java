package corgiaoc.byg.common.world.feature.end.islands;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.FloatingIslandConfig;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.Random;

public class FloatingIslands1 extends Feature<FloatingIslandConfig> {

    FastNoiseLite perlin = null;


    public FloatingIslands1(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());

        double radius = 15; /*rand.nextInt(config.getMaxPossibleRadius()) + config.getMinRadius() - 5;*/

        if (world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        for (double x = -radius; x <= radius; x++) {
            for (double y = 1; y <= radius; y++) {
                for (double z = -radius; z <= radius; z++) {
                    mutable.set(pos).move((int) x, (int) (y - radius), (int) z);
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ()));
                    double scaledNoise = (noise) * ((y * 3) / ((x * x) + (z * z)));
                    if (scaledNoise >= 0.5) {
                        if (y == radius)
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