package corgiaoc.byg.common.properties.blocks.nether.warped;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DeadCoralWallFanBlock;
import net.minecraft.util.Direction;

public class BYGWarpedCoralWallFanBlock extends DeadCoralWallFanBlock {
    protected BYGWarpedCoralWallFanBlock(Block.Properties block) {
        super(block);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    protected boolean isValidGround(BlockState state) {
        Block block = state.getBlock();
        return block == BYGBlocks.NYLIUM_SOUL_SAND || block == BYGBlocks.NYLIUM_SOUL_SOIL;
    }
}
