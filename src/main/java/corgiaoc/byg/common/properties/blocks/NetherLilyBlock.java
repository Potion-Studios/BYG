package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class NetherLilyBlock extends LilyPadBlock {

    protected NetherLilyBlock(Settings properties) {
        super(properties);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView reader, BlockPos p_200014_3_) {
        FluidState fluidState = reader.getFluidState(p_200014_3_);
        return fluidState.getFluid() == Fluids.LAVA || fluidState.getFluid() == Fluids.WATER;
    }
}
