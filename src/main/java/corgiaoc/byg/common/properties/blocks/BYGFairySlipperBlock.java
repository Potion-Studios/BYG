package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class BYGFairySlipperBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public BYGFairySlipperBlock(Settings properties) {
        super(properties);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView reader, BlockPos pos, ShapeContext context) {
        Vec3d Vector3d = state.getModelOffset(reader, pos);
        return SHAPE.offset(Vector3d.x, Vector3d.y, Vector3d.z);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return state.getBlock().isIn(BlockTags.LOGS) || state.getBlock().isIn(FabricTags.DIRT);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos posDown = pos.down();
        return this.canPlantOnTop(worldIn.getBlockState(posDown), worldIn, posDown);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

}