package potionstudios.byg.common.block.end;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CrypticLanternBlock extends LanternBlock {
    public CrypticLanternBlock(Properties builder) {
        super(builder);
    }

    public boolean isSignalSource(@NotNull BlockState state) {
        return true;
    }

    public int getSignal(@NotNull BlockState blockState, @NotNull BlockGetter blockAccess, @NotNull BlockPos pos, @NotNull Direction side) {
        return 10;
    }
}
