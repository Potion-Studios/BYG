package corgiaoc.byg.common.properties.blocks.nether;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class BoricFireBlock extends AbstractFireBlock {

    protected BoricFireBlock(AbstractBlock.Settings properties) {
        super(properties, 3.5F);
    }

    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        return this.canPlaceAt(stateIn, worldIn, currentPos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        return shouldLightBoricFire(worldIn.getBlockState(pos.down()).getBlock());
    }

    public static boolean shouldLightBoricFire(Block block) {
        return block == BYGBlocks.BRIMSTONE;
    }

    protected boolean isFlammable(BlockState state) {
        return true;
    }
}
