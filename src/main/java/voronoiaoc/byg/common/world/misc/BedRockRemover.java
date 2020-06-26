package voronoiaoc.byg.common.world.misc;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class BedRockRemover extends WorldCarver<ProbabilityConfig> {
    static boolean yeet = true;

    public BedRockRemover(Codec<ProbabilityConfig> config, int idk) {
        super(config, idk);
    }

    @Override
    public boolean func_225555_a_(IChunk p_225555_1_, Function<BlockPos, Biome> p_225555_2_, Random p_225555_3_, int p_225555_4_, int p_225555_5_, int p_225555_6_, int p_225555_7_, int p_225555_8_, BitSet p_225555_9_, ProbabilityConfig p_225555_10_) {
        return carveRegion(p_225555_1_, p_225555_2_, p_225555_3_, p_225555_4_, p_225555_5_, p_225555_6_, p_225555_7_, p_225555_8_, p_225555_9_, p_225555_10_);
    }

    public boolean shouldCarve(Random rand, int chunkX, int chunkZ, ProbabilityConfig config) {
        return rand.nextFloat() <= config.probability;
    }

    //Carver
    public boolean carveRegion(IChunk chunk, Function<BlockPos, Biome> whatTheFUckISThIs, Random rand, int sealevel, int cX, int cZ, int chunkX, int chunkZ, BitSet carvingMask, ProbabilityConfig config) {
        for (int localX = 0; localX < 16; localX++) {
            for (int localZ = 0; localZ < 16; localZ++) {
                for (int y = 0; y <= 4; y++) {
                    BlockPos blockPos = new BlockPos(localX, y, localZ);
                    if (chunk.getBlockState(blockPos) == Blocks.WATER.getDefaultState() || chunk.getBlockState(blockPos) == Blocks.LAVA.getDefaultState()) {
                        chunk.setBlockState(blockPos, Blocks.AIR.getDefaultState(), false);
                    }
                }
            }
        }
        return false;
    }


    protected boolean func_222708_a(double p_222708_1_, double p_222708_3_, double p_222708_5_, int p_222708_7_) {
        return p_222708_3_ <= -0.7D || p_222708_1_ * p_222708_1_ + p_222708_3_ * p_222708_3_ + p_222708_5_ * p_222708_5_ >= 1.0D;
    }
}