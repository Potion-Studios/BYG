package corgiaoc.byg.common.properties.blocks.end;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Lantern;
import net.minecraft.world.level.block.state.BlockState;

public class CrypticLanternBlock extends Lantern {
    public CrypticLanternBlock(Properties builder) {
        super(builder);
    }

    public boolean isSignalSource(BlockState state) {
        return true;
    }

    public int getSignal(BlockState blockState, BlockGetter blockAccess, BlockPos pos, Direction side) {
        return 10;
    }
}
