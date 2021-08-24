package corgiaoc.byg.common.properties.blocks.nether.embur;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class BlueNetherrackBlock extends Block implements BonemealableBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected BlueNetherrackBlock(Properties builder) {
        super(builder);

    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean isValidBonemealTarget(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
        if (worldIn.getBlockState(pos.above()).propagatesSkylightDown(worldIn, pos)) {
            for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
                if (worldIn.getBlockState(blockpos).is(BlockTags.NYLIUM)) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean isBonemealSuccess(Level worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
        boolean flag = false;
        boolean flag1 = false;

        for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
            BlockState blockstate = worldIn.getBlockState(blockpos);
            if (blockstate.is(BYGBlocks.EMBUR_NYLIUM)) {
                flag1 = true;
            }

            if (flag1 && flag) {
                break;
            }
        }

        if (flag1 && flag) {
            worldIn.setBlock(pos, rand.nextBoolean() ? BYGBlocks.EMBUR_NYLIUM.defaultBlockState() : BYGBlocks.EMBUR_NYLIUM.defaultBlockState(), 3);
        } else if (flag1) {
            worldIn.setBlock(pos, BYGBlocks.EMBUR_NYLIUM.defaultBlockState(), 3);
        } else if (flag) {
            worldIn.setBlock(pos, BYGBlocks.EMBUR_NYLIUM.defaultBlockState(), 3);
        }

    }
}

