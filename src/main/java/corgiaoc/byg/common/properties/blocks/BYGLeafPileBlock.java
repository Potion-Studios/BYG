package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.Feature;

public class BYGLeafPileBlock extends PlantBlock {
    protected static final VoxelShape LEAF_PILE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);

    protected BYGLeafPileBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView p_220053_2_, BlockPos blockPos, ShapeContext ctx) {
        return LEAF_PILE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return Feature.isSoil(state.getBlock()) || state.isIn(FabricTags.END_STONES) || state.isIn(BlockTags.NYLIUM) || state.isIn(FabricTags.NETHERRACK) || super.canPlantOnTop(state, worldIn, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.canPlantOnTop(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
}
