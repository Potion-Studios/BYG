package corgiaoc.byg.common.properties.blocks.end;

import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class EndPlantBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected EndPlantBlock(Settings builder) {
        super(builder);

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView reader, BlockPos map, ShapeContext ctx) {
        Vec3d Vector3d = state.getModelOffset(reader, map);
        return SHAPE.offset(Vector3d.x, Vector3d.y, Vector3d.z);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return state.isOf(BYGBlocks.IVIS_PHYLIUM) || state.isOf(BYGBlocks.ETHER_PHYLIUM) || state.getBlock() == BYGBlocks.SHULKREN_PHYLIUM || state.isOf(BYGBlocks.NIGHTSHADE_PHYLIUM) || state.isOf(BYGBlocks.BULBIS_PHYCELIUM) || state.isOf(BYGBlocks.VERMILION_SCULK) || state.isIn(FabricTags.SAND) || super.canPlantOnTop(state, worldIn, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.canPlantOnTop(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
}

