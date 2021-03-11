package corgiaoc.byg.common.properties.blocks.nether;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class BoricFireBlock extends AbstractFireBlock {

    protected BoricFireBlock(AbstractBlock.Properties properties) {
        super(properties, 3.5F);
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return this.canSurvive(stateIn, worldIn, currentPos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
    }

    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return shouldLightBoricFire(worldIn.getBlockState(pos.below()).getBlock());
    }

    public static boolean shouldLightBoricFire(Block block) {
        return block == BYGBlocks.BRIMSTONE;
    }

    protected boolean canBurn(BlockState state) {
        return true;
    }
}
