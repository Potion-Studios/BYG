package corgiaoc.byg.common.properties.blocks.nether.warped;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class BYGWarpedBushBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected BYGWarpedBushBlock(AbstractBlock.Settings builder) {
        super(builder);

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        Vec3d lvt_5_1_ = state.getModelOffset(worldIn, pos);
        return SHAPE.offset(lvt_5_1_.x, lvt_5_1_.y, lvt_5_1_.z);
    }


    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == BYGBlocks.NYLIUM_SOUL_SAND || block == BYGBlocks.NYLIUM_SOUL_SOIL;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.canPlantOnTop(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
}

