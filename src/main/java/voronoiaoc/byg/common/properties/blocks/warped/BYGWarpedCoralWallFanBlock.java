package voronoiaoc.byg.common.properties.blocks.warped;

import net.minecraft.block.DeadCoralWallFanBlock;
import net.minecraft.util.math.Direction;

public class BYGWarpedCoralWallFanBlock extends DeadCoralWallFanBlock {
    protected BYGWarpedCoralWallFanBlock(Settings block) {
        super(block);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
    }
}
