package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class GlowShroomBayouSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public GlowShroomBayouSB(Codec<SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
    }

    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        double d0 = Biome.BIOME_INFO_NOISE.getValue((double) x * 0.25D, (double) z * 0.25D, false);
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
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.GLOWCELIUM_CF);
        } else if (noise > -0.95D) {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_GRASS);
        } else {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSurfaceBuilders.Configs.GLOWCELIUM_CF);
        }

    }
}