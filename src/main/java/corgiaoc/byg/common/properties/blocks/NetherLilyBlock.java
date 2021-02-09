package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class NetherLilyBlock extends LilyPadBlock {

    protected NetherLilyBlock(Settings properties) {
        super(properties);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView reader, BlockPos pos) {
        FluidState fluidState = reader.getFluidState(pos);
        return fluidState.getFluid() == Fluids.LAVA || fluidState.getFluid() == Fluids.WATER;
    }
}
