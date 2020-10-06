package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import corgiaoc.byg.core.byglists.BYGBlockList;

public class BYGBeachGrassBlock extends TallGrassBlock implements IGrowable {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    protected BYGBeachGrassBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.SAND || block == Blocks.RED_SAND || block == BYGBlockList.BLUE_SAND || block == BYGBlockList.PINK_SAND || block == BYGBlockList.PURPLE_SAND || block == BYGBlockList.BLACK_SAND || block == BYGBlockList.WHITE_SAND;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
}
