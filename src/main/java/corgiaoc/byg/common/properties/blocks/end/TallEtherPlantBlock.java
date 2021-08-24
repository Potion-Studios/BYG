package corgiaoc.byg.common.properties.blocks.end;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TallEtherPlantBlock extends DoublePlantBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public TallEtherPlantBlock(Properties builder) {
        super(builder);

    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(BYGBlocks.ETHER_PHYLIUM) || state.is(BYGBlocks.ETHER_SOIL) || super.mayPlaceOn(state, worldIn, pos);
    }
}

