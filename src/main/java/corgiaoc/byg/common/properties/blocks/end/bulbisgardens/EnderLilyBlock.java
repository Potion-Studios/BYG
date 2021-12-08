package corgiaoc.byg.common.properties.blocks.end.bulbisgardens;

import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class EnderLilyBlock extends LilyPadBlock {

    protected EnderLilyBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader reader, BlockPos pos) {
        FluidState fluidState = reader.getFluidState(pos);
        return fluidState.getType() == Fluids.WATER;
    }
}
