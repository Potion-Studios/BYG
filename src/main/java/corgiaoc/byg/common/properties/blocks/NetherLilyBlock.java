package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class NetherLilyBlock extends LilyPadBlock {

    protected NetherLilyBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader reader, BlockPos pos) {
        FluidState fluidState = reader.getFluidState(pos);
        return fluidState.getType() == Fluids.LAVA || fluidState.getType() == Fluids.WATER;
    }
}
