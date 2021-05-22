package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class BYGBeachGrassBlock extends TallGrassBlock implements IGrowable {

    protected BYGBeachGrassBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.SAND || block == Blocks.RED_SAND || block == BYGBlocks.BLUE_SAND || block == BYGBlocks.PINK_SAND || block == BYGBlocks.PURPLE_SAND || block == BYGBlocks.BLACK_SAND || block == BYGBlocks.WHITE_SAND;
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
}
