package corgiaoc.byg.common.properties.blocks.nether.warped;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BaseCoralWallFanBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BYGWarpedCoralWallFanBlock extends BaseCoralWallFanBlock {
    protected BYGWarpedCoralWallFanBlock(Properties block) {
        super(block);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    protected boolean isValidGround(BlockState state) {
        Block block = state.getBlock();
        return block == BYGBlocks.NYLIUM_SOUL_SAND || block == BYGBlocks.NYLIUM_SOUL_SOIL;
    }
}
