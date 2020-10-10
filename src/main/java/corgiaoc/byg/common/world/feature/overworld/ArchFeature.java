package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGBoulderFeatureConfig;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class ArchFeature extends Feature<BYGBoulderFeatureConfig> {

    public ArchFeature(Codec<BYGBoulderFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected long seed;
    protected static FastNoise fastNoise;

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, BYGBoulderFeatureConfig config) {
        setSeed(world.getSeed());
        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(pos);
        int radius = 25;

        for (int archThicccness = 0; archThicccness <= 8; archThicccness++) {
            BlockPos.Mutable mutable2 = new BlockPos.Mutable();

            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    mutable2.setPos(mutable.getX() + x, mutable.getY(), mutable.getZ() + z);
                    int height = Math.abs(getArchHeight(x, z)) - 175;
                    mutable2.move(Direction.UP, height);

                    for (int yHeight = height; yHeight >= height - 3; yHeight--) {
                        world.setBlockState(mutable2, Blocks.DIAMOND_BLOCK.getDefaultState(), 2);
                        mutable2.move(Direction.DOWN);
                    }
                }
            }
            mutable.move(Direction.WEST);
        }
        return true;
    }

    public static int getArchHeight(int x, int z) {
        return (int) (-Math.pow(x, 2) + (Math.pow(z, 2) * 0.08));
    }


    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            this.seed = seed;
        }
    }
}