package corgiaoc.byg.common.properties.blocks.end;

import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class CrypticLanternBlock extends LanternBlock {
    public CrypticLanternBlock(Properties builder) {
        super(builder);
    }

    public boolean isSignalSource(BlockState state) {
        return true;
    }

    public int getSignal(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return 10;
    }
}
