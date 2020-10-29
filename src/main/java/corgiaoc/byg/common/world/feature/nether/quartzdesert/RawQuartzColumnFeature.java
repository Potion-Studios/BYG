package corgiaoc.byg.common.world.feature.nether.quartzdesert;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ColumnConfig;
import net.minecraft.world.gen.feature.Feature;

import javax.annotation.Nullable;
import java.util.Random;

public class RawQuartzColumnFeature extends Feature<ColumnConfig> {
    private static final ImmutableList<Block> field_236245_a_ = ImmutableList.of(Blocks.LAVA, Blocks.BEDROCK, Blocks.MAGMA_BLOCK, Blocks.SOUL_SAND, Blocks.NETHER_BRICKS, Blocks.NETHER_BRICK_FENCE, Blocks.NETHER_BRICK_STAIRS, Blocks.NETHER_WART, Blocks.CHEST, Blocks.SPAWNER);

    public RawQuartzColumnFeature(
            Codec<ColumnConfig> codec) {
        super(codec);
    }

    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, ColumnConfig config) {
        int i = generator.getSeaLevel();
        if (!func_242762_a(reader, i, pos.toMutable())) {
            return false;
        } else {
            int j = config.func_242795_b().func_242259_a(rand);
            boolean flag = rand.nextFloat() < 0.9F;
            int k = Math.min(j, flag ? 5 : 8);
            int l = flag ? 50 : 15;
            boolean flag1 = false;

            for (BlockPos blockpos : BlockPos.getRandomPositions(rand, l, pos.getX() - k, pos.getY(), pos.getZ() - k, pos.getX() + k, pos.getY(), pos.getZ() + k)) {
                int i1 = j - blockpos.manhattanDistance(pos);
                if (i1 >= 0) {
                    flag1 |= this.func_236248_a_(reader, i, blockpos, i1, config.func_242794_am_().func_242259_a(rand));
                }
            }

            return flag1;
        }
    }

    private boolean func_236248_a_(IWorld p_236248_1_, int p_236248_2_, BlockPos p_236248_3_, int p_236248_4_, int p_236248_5_) {
        boolean flag = false;

        for (BlockPos blockpos : BlockPos.getAllInBoxMutable(p_236248_3_.getX() - p_236248_5_, p_236248_3_.getY(), p_236248_3_.getZ() - p_236248_5_, p_236248_3_.getX() + p_236248_5_, p_236248_3_.getY(), p_236248_3_.getZ() + p_236248_5_)) {
            int i = blockpos.manhattanDistance(p_236248_3_);
            BlockPos blockpos1 = func_236247_a_(p_236248_1_, p_236248_2_, blockpos) ? func_236246_a_(p_236248_1_, p_236248_2_, blockpos.toMutable(), i) : func_236249_a_(p_236248_1_, blockpos.toMutable(), i);
            if (blockpos1 != null) {
                int j = p_236248_4_ - i / 2;

                for (BlockPos.Mutable blockpos$mutable = blockpos1.toMutable(); j >= 0; --j) {
                    if (func_236247_a_(p_236248_1_, p_236248_2_, blockpos$mutable)) {
                        this.setBlockState(p_236248_1_, blockpos$mutable, BYGBlocks.RAW_QUARTZ_BLOCK.getDefaultState());
                        blockpos$mutable.move(Direction.UP);
                        flag = true;
                    } else {
                        if (!p_236248_1_.getBlockState(blockpos$mutable).isIn(BYGBlocks.RAW_QUARTZ_BLOCK)) {
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
    private static BlockPos func_236246_a_(IWorld p_236246_0_, int p_236246_1_, BlockPos.Mutable p_236246_2_, int p_236246_3_) {
        while (p_236246_2_.getY() > 1 && p_236246_3_ > 0) {
            --p_236246_3_;
            if (func_242762_a(p_236246_0_, p_236246_1_, p_236246_2_)) {
                return p_236246_2_;
            }

            p_236246_2_.move(Direction.DOWN);
        }

        return null;
    }

    private static boolean func_242762_a(IWorld p_242762_0_, int p_242762_1_, BlockPos.Mutable p_242762_2_) {
        if (!func_236247_a_(p_242762_0_, p_242762_1_, p_242762_2_)) {
            return false;
        } else {
            BlockState blockstate = p_242762_0_.getBlockState(p_242762_2_.move(Direction.DOWN));
            p_242762_2_.move(Direction.UP);
            return !blockstate.isAir() && !field_236245_a_.contains(blockstate.getBlock());
        }
    }

    @Nullable
    private static BlockPos func_236249_a_(IWorld p_236249_0_, BlockPos.Mutable p_236249_1_, int p_236249_2_) {
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

    private static boolean func_236247_a_(IWorld p_236247_0_, int p_236247_1_, BlockPos p_236247_2_) {
        BlockState blockstate = p_236247_0_.getBlockState(p_236247_2_);
        return blockstate.isAir() || blockstate.isIn(Blocks.LAVA) && p_236247_2_.getY() <= p_236247_1_;
    }
}
