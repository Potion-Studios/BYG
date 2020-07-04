package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import voronoiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;

public class GlowShroomBayouSB extends SurfaceBuilder<TernarySurfaceConfig> {
    public GlowShroomBayouSB(Codec<TernarySurfaceConfig> configIn) {
        super(configIn);
    }

    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig config) {
        double d0 = Biome.FOLIAGE_NOISE.sample((double) x * 0.25D, (double) z * 0.25D, false);
        if (d0 > 0.0D) {
            int i = x & 15;
            int j = z & 15;
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

            for (int k = startHeight; k >= 0; --k) {
                blockpos$mutable.set(i, k, j);
                if (!chunkIn.getBlockState(blockpos$mutable).isAir()) {
                    if (k == 62 && chunkIn.getBlockState(blockpos$mutable).getBlock() != defaultFluid.getBlock()) {
                        chunkIn.setBlockState(blockpos$mutable, defaultFluid, false);
                    }
                    break;
                }
            }
        }

        if (noise > 1.75D) {
            SurfaceBuilder.DEFAULT.generate
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.GLOWCELIUM_CF);
        } else if (noise > -0.95D) {
            SurfaceBuilder.DEFAULT.generate
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.GRASS_CONFIG);
        } else {
            SurfaceBuilder.DEFAULT.generate
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.GLOWCELIUM_CF);
        }

    }
}