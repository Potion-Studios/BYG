package corgiaoc.byg.common.world.feature.nether.quartzdesert;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.BasaltColumnsFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import javax.annotation.Nullable;
import java.util.Random;

public class RawQuartzColumnFeature extends Feature<BasaltColumnsFeatureConfig> {
    private static final ImmutableList<Block> field_236245_a_ = ImmutableList.of(Blocks.LAVA, Blocks.BEDROCK, Blocks.MAGMA_BLOCK, Blocks.SOUL_SAND, Blocks.NETHER_BRICKS, Blocks.NETHER_BRICK_FENCE, Blocks.NETHER_BRICK_STAIRS, Blocks.NETHER_WART, Blocks.CHEST, Blocks.SPAWNER);

    public RawQuartzColumnFeature(
            Codec<BasaltColumnsFeatureConfig> p_i231925_1_) {
        super(p_i231925_1_);
    }

    public boolean generate(StructureWorldAccess p_241855_1_, ChunkGenerator p_241855_2_, Random p_241855_3_, BlockPos p_241855_4_, BasaltColumnsFeatureConfig p_241855_5_) {
        int i = p_241855_2_.getSeaLevel();
        if (!func_242762_a(p_241855_1_, i, p_241855_4_.mutableCopy())) {
            return false;
        } else {
            int j = p_241855_5_.getHeight().getValue(p_241855_3_);
            boolean flag = p_241855_3_.nextFloat() < 0.9F;
            int k = Math.min(j, flag ? 5 : 8);
            int l = flag ? 50 : 15;
            boolean flag1 = false;

            for (BlockPos blockpos : BlockPos.iterateRandomly(p_241855_3_, l, p_241855_4_.getX() - k, p_241855_4_.getY(), p_241855_4_.getZ() - k, p_241855_4_.getX() + k, p_241855_4_.getY(), p_241855_4_.getZ() + k)) {
                int i1 = j - blockpos.getManhattanDistance(p_241855_4_);
                if (i1 >= 0) {
                    flag1 |= this.func_236248_a_(p_241855_1_, i, blockpos, i1, p_241855_5_.getReach().getValue(p_241855_3_));
                }
            }

            return flag1;
        }
    }

    private boolean func_236248_a_(WorldAccess p_236248_1_, int p_236248_2_, BlockPos p_236248_3_, int p_236248_4_, int p_236248_5_) {
        boolean flag = false;

        for (BlockPos blockpos : BlockPos.iterate(p_236248_3_.getX() - p_236248_5_, p_236248_3_.getY(), p_236248_3_.getZ() - p_236248_5_, p_236248_3_.getX() + p_236248_5_, p_236248_3_.getY(), p_236248_3_.getZ() + p_236248_5_)) {
            int i = blockpos.getManhattanDistance(p_236248_3_);
            BlockPos blockpos1 = func_236247_a_(p_236248_1_, p_236248_2_, blockpos) ? func_236246_a_(p_236248_1_, p_236248_2_, blockpos.mutableCopy(), i) : func_236249_a_(p_236248_1_, blockpos.mutableCopy(), i);
            if (blockpos1 != null) {
                int j = p_236248_4_ - i / 2;

                for (BlockPos.Mutable blockpos$mutable = blockpos1.mutableCopy(); j >= 0; --j) {
                    if (func_236247_a_(p_236248_1_, p_236248_2_, blockpos$mutable)) {
                        this.setBlockState(p_236248_1_, blockpos$mutable, BYGBlocks.RAW_QUARTZ_BLOCK.getDefaultState());
                        blockpos$mutable.move(Direction.UP);
                        flag = true;
                    } else {
                        if (!p_236248_1_.getBlockState(blockpos$mutable).isOf(BYGBlocks.RAW_QUARTZ_BLOCK)) {
                            break;
                        }

                        blockpos$mutable.move(Direction.UP);
                    }
                }
            }
        }

        return flag;
    }

    @Nullable
    private static BlockPos func_236246_a_(WorldAccess p_236246_0_, int p_236246_1_, BlockPos.Mutable p_236246_2_, int p_236246_3_) {
        while (p_236246_2_.getY() > 1 && p_236246_3_ > 0) {
            --p_236246_3_;
            if (func_242762_a(p_236246_0_, p_236246_1_, p_236246_2_)) {
                return p_236246_2_;
            }

            p_236246_2_.move(Direction.DOWN);
        }

        return null;
    }

    private static boolean func_242762_a(WorldAccess p_242762_0_, int p_242762_1_, BlockPos.Mutable p_242762_2_) {
        if (!func_236247_a_(p_242762_0_, p_242762_1_, p_242762_2_)) {
            return false;
        } else {
            BlockState blockstate = p_242762_0_.getBlockState(p_242762_2_.move(Direction.DOWN));
            p_242762_2_.move(Direction.UP);
            return !blockstate.isAir() && !field_236245_a_.contains(blockstate.getBlock());
        }
    }

    @Nullable
    private static BlockPos func_236249_a_(WorldAccess p_236249_0_, BlockPos.Mutable p_236249_1_, int p_236249_2_) {
        while (p_236249_1_.getY() < p_236249_0_.getHeight() && p_236249_2_ > 0) {
            --p_236249_2_;
            BlockState blockstate = p_236249_0_.getBlockState(p_236249_1_);
            if (field_236245_a_.contains(blockstate.getBlock())) {
                return null;
            }

            if (blockstate.isAir()) {
                return p_236249_1_;
            }

            p_236249_1_.move(Direction.UP);
        }

        return null;
    }

    private static boolean func_236247_a_(WorldAccess p_236247_0_, int p_236247_1_, BlockPos p_236247_2_) {
        BlockState blockstate = p_236247_0_.getBlockState(p_236247_2_);
        return blockstate.isAir() || blockstate.isOf(Blocks.LAVA) && p_236247_2_.getY() <= p_236247_1_;
    }
}
