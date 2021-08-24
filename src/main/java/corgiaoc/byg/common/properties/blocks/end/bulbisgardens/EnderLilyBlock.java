package corgiaoc.byg.common.properties.blocks.end.bulbisgardens;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class EnderLilyBlock extends WaterlilyBlock {

    protected EnderLilyBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter reader, BlockPos pos) {
        FluidState fluidState = reader.getFluidState(pos);
        return fluidState.getType() == Fluids.WATER;
    }
}
