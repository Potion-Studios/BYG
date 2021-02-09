package corgiaoc.byg.common.properties.blocks.end;

import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class CrypticLanternBlock extends LanternBlock {
    public CrypticLanternBlock(Settings builder) {
        super(builder);
    }

    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    public int getWeakRedstonePower(BlockState blockState, BlockView blockAccess, BlockPos pos, Direction side) {
        return 10;
    }
}
