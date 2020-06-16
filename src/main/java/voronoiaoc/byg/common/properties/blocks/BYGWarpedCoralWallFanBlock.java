package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DeadCoralWallFanBlock;
import net.minecraft.util.Direction;
import voronoiaoc.byg.core.byglists.BYGBlockList;

public class BYGWarpedCoralWallFanBlock extends DeadCoralWallFanBlock {
    protected BYGWarpedCoralWallFanBlock(Block.Properties block) {
        super(block);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    protected boolean isValidGround(BlockState state) {
        Block block = state.getBlock();
        return block == BYGBlockList.NYLIUM_SOUL_SAND || block == BYGBlockList.NYLIUM_SOUL_SOIL;
    }
}
