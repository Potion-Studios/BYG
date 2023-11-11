package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.EndRodBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CrypticEndRodBlock extends EndRodBlock {
    protected CrypticEndRodBlock(Properties $$0) {
        super($$0);
    }

    public boolean isSignalSource(@NotNull BlockState state) {
        return true;
    }

    public int getSignal(@NotNull BlockState blockState, @NotNull BlockGetter blockAccess, @NotNull BlockPos pos, @NotNull Direction side) {
        return 10;
    }
}
