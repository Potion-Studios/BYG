package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class LeafFoliageBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

    protected LeafFoliageBlock(DyeColor colorIn, AbstractBlock.Settings properties) {
        super(properties);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos blockPos) {
        return state.getMaterial() == Material.SOIL || state.getBlock() == BYGBlocks.ETHER_PHYLIUM;
    }
}
