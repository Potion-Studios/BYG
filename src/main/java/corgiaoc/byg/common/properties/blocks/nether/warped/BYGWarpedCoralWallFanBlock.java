package corgiaoc.byg.common.properties.blocks.nether.warped;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DeadCoralWallFanBlock;
import net.minecraft.util.math.Direction;

public class BYGWarpedCoralWallFanBlock extends DeadCoralWallFanBlock {
    protected BYGWarpedCoralWallFanBlock(AbstractBlock.Settings block) {
        super(block);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    protected boolean isValidGround(BlockState state) {
        Block block = state.getBlock();
        return block == BYGBlocks.NYLIUM_SOUL_SAND || block == BYGBlocks.NYLIUM_SOUL_SOIL;
    }
}
