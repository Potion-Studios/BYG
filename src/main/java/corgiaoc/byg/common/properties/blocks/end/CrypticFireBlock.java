package corgiaoc.byg.common.properties.blocks.end;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CrypticFireBlock extends AbstractFireBlock {

    protected CrypticFireBlock(Settings properties) {
        super(properties, 3.5F);
    }

    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        return this.canPlaceAt(stateIn, worldIn, currentPos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        return shouldLightCrypticFire(worldIn.getBlockState(pos.down()).getBlock());
    }

    public static boolean shouldLightCrypticFire(Block block) {
        return block == BYGBlocks.CRYPTIC_STONE || block == BYGBlocks.CRYPTIC_MAGMA_BLOCK;
    }

    protected boolean isFlammable(BlockState state) {
        return true;
    }

    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    public int getWeakRedstonePower(BlockState blockState, BlockView blockAccess, BlockPos pos, Direction side) {
        return 10;
    }
}
