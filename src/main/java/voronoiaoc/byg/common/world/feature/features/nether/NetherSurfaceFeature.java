package voronoiaoc.byg.common.world.feature.features.nether;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.worldtype.noise.fastnoise.FastNoise;

import java.util.Random;

public class NetherSurfaceFeature extends Feature<NoFeatureConfig> {
    public NetherSurfaceFeature(Codec<NoFeatureConfig> config) {
        super(config);
    }

    FastNoise fastNoise = null;

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        setSeed(worldIn.getSeed());
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int multiplier = 15;

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.setPos(pos.getX() + x, 0, pos.getZ() + z);

                double noise = (fastNoise.GetNoise(mutable.getX(), mutable.getZ()) + 1D) * 3D;

                if (noise < 0) {
                    multiplier = 2;
                }
                int maximumHeight = (int) (noise * multiplier) + 128;
                mutable.move(Direction.UP, maximumHeight);
                for (int y = maximumHeight; y >= 128; y--) {
                    worldIn.setBlockState(mutable, Blocks.NETHERRACK.getDefaultState(), 2);

                    mutable.move(Direction.DOWN);
                }
            }
        }

        return true;
    }


    public void setSeed(long seed) {
        if (fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            fastNoise.SetFrequency(0.01F);
        }
    }
}