package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class BYGBeachGrassBlock extends FernBlock implements Fertilizable {

    protected BYGBeachGrassBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.SAND || block == Blocks.RED_SAND || block == BYGBlocks.BLUE_SAND || block == BYGBlocks.PINK_SAND || block == BYGBlocks.PURPLE_SAND || block == BYGBlocks.BLACK_SAND || block == BYGBlocks.WHITE_SAND;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.canPlantOnTop(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
}
