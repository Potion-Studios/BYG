package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class RiverThingy extends Feature<NoFeatureConfig> {
    public RiverThingy(Codec<NoFeatureConfig> config) {
        super(config);
    }

    FastNoise fastNoise = null;
    FastNoise fastNoise2 = null;
    FastNoise fastNoise3 = null;

    public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        setSeed(worldIn.getSeed());
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int multiplier = 15;

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.set(pos.getX() + x, 0, pos.getZ() + z);

                double noise = (fastNoise.GetNoise(mutable.getX(), mutable.getZ()));
                double noise2 = Math.abs(fastNoise2.GetNoise(mutable.getX(), mutable.getZ()) + 1) * 3;
                double noise3 = Math.abs(fastNoise3.GetNoise(mutable.getX(), mutable.getZ()) + 1) * 4;
                if (noise > 0.85) {
//                    int maximumHeight = (int) (worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ()) - noise2) - 25;
                    int maximumHeight = (int) (noise3 * 2) + worldIn.getSeaLevel();
                    int minimumHeight = (int) (0 + 10 + noise2 * 3);
                    mutable.move(Direction.UP, maximumHeight);
                    for (int y = maximumHeight; y >= minimumHeight; y--) {
                        worldIn.setBlock(mutable, Blocks.AIR.defaultBlockState(), 2);
                        mutable.move(Direction.DOWN);
                    }
                }

            }
        }

        return true;
    }


    public void setSeed(long seed) {
        if (fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetFractalType(FastNoise.FractalType.RigidMulti);
            fastNoise.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            fastNoise.SetGradientPerturbAmp(1);
            fastNoise.SetFractalOctaves(1);
            fastNoise.SetFractalGain(0.3f);
            fastNoise.SetFrequency(0.00375F);
        }

        if (fastNoise2 == null) {
            fastNoise2 = new FastNoise((int) seed);
            fastNoise2.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            fastNoise2.SetGradientPerturbAmp(1);
            fastNoise2.SetFractalOctaves(1);
            fastNoise2.SetFractalGain(0.3f);
            fastNoise2.SetFrequency(0.0575F);
        }

        if (fastNoise3 == null) {
            fastNoise3 = new FastNoise((int) seed);
            fastNoise3.SetNoiseType(FastNoise.NoiseType.Perlin);
            fastNoise3.SetGradientPerturbAmp(1);
            fastNoise3.SetFractalOctaves(1);
            fastNoise3.SetFractalGain(0.3f);
            fastNoise3.SetFrequency(0.07675F);
        }
    }
}