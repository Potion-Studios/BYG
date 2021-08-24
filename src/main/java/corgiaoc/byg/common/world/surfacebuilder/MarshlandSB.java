package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import java.util.Random;

public class MarshlandSB extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public MarshlandSB(Codec<SurfaceBuilderBaseConfiguration> p_i51304_1_) {
        super(p_i51304_1_);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        double d0 = Biome.BIOME_INFO_NOISE.getValue((double) x * 0.25D, (double) z * 0.25D, false);
        if (d0 > 0.0D) {
            int i = x & 15;
            int j = z & 15;
            BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

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

        SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
    }
}
