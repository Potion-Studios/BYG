package corgiaoc.byg.common.properties.blocks.end;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class CrypticFireBlock extends AbstractFireBlock {

    protected CrypticFireBlock(Properties properties) {
        super(properties, 3.5F);
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return this.canSurvive(stateIn, worldIn, currentPos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
    }

    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return shouldLightCrypticFire(worldIn.getBlockState(pos.below()).getBlock());
    }

    public static boolean shouldLightCrypticFire(Block block) {
        return block == BYGBlocks.CRYPTIC_STONE || block == BYGBlocks.CRYPTIC_MAGMA_BLOCK;
    }

    protected boolean canBurn(BlockState state) {
        return true;
    }

    public boolean isSignalSource(BlockState state) {
        return true;
    }

    public int getSignal(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return 10;
    }
}
