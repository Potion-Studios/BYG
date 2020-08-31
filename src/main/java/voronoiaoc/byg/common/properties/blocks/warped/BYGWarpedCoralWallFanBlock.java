package voronoiaoc.byg.common.properties.blocks.warped;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BaseCoralWallFanBlock;

public class BYGWarpedCoralWallFanBlock extends BaseCoralWallFanBlock {
    protected BYGWarpedCoralWallFanBlock(Properties block) {
        super(block);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }
}
