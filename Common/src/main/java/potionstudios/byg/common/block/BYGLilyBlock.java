package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

public class BYGLilyBlock extends WaterlilyBlock {

    private final Fluid fluid;
    protected BYGLilyBlock(Properties properties, @NotNull Fluid fluid) {
        super(properties);
        this.fluid = fluid;
    }

    @Override
    protected boolean mayPlaceOn(@NotNull BlockState state, BlockGetter reader, @NotNull BlockPos pos) {
        return reader.getFluidState(pos).getType().isSame(fluid) && reader.getFluidState(pos.above()).getType().isSame(Fluids.EMPTY);
    }
}
