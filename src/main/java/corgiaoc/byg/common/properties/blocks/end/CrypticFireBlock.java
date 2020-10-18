package corgiaoc.byg.common.properties.blocks.end;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class CrypticFireBlock extends AbstractFireBlock {

    protected CrypticFireBlock(Properties properties) {
        super(properties, 3.5F);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return this.isValidPosition(stateIn, worldIn, currentPos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return shouldLightCrypticFire(worldIn.getBlockState(pos.down()).getBlock());
    }

    public static boolean shouldLightCrypticFire(Block block) {
        return block == Blocks.END_STONE || block == BYGBlocks.CRYPTIC_MAGMA_BLOCK;
    }

    protected boolean canBurn(BlockState state) {
        return true;
    }
}
