package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BYGBeachGrassBlock extends TallGrassBlock implements BonemealableBlock {

    protected BYGBeachGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.SAND || block == Blocks.RED_SAND || block == BYGBlocks.BLUE_SAND || block == BYGBlocks.PINK_SAND || block == BYGBlocks.PURPLE_SAND || block == BYGBlocks.BLACK_SAND || block == BYGBlocks.WHITE_SAND;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
}
