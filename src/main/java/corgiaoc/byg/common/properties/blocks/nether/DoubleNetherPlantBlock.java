package corgiaoc.byg.common.properties.blocks.nether;

import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class DoubleNetherPlantBlock extends TallPlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected DoubleNetherPlantBlock(Settings builder) {
        super(builder);

    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return state.isIn(BlockTags.NYLIUM) || state.isOf(Blocks.MYCELIUM) || state.isOf(Blocks.SOUL_SOIL) || state.isIn(FabricTags.END_STONES) || super.canPlantOnTop(state, worldIn, pos);
    }
}

