package corgiaoc.byg.common.properties.blocks.nether.warped;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class BYGWarpedCoralPlantBlock extends CoralParentBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D);

    protected BYGWarpedCoralPlantBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView reader, BlockPos blockPos, ShapeContext context) {
        return SHAPE;
    }

    protected boolean isValidGround(BlockState state) {
        return state.getBlock() == BYGBlocks.NYLIUM_SOUL_SAND || state.getBlock() == BYGBlocks.NYLIUM_SOUL_SOIL;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos posDown = pos.down();
        return this.isValidGround(worldIn.getBlockState(posDown));
    }
}
