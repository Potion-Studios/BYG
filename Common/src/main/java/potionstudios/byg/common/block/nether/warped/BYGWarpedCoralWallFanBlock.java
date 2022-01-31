package potionstudios.byg.common.block.nether.warped;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BaseCoralWallFanBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGBlocks;

public class BYGWarpedCoralWallFanBlock extends BaseCoralWallFanBlock {
    protected BYGWarpedCoralWallFanBlock(Properties block) {
        super(block);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

}
