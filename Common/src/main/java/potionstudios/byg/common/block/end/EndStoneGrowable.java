package potionstudios.byg.common.block.end;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGNylium;

public class EndStoneGrowable {



    public static boolean isValidBonemealTarget(BlockGetter reader, BlockPos pos) {
        for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
            BlockState state1 = reader.getBlockState(blockpos);
            if (BYGNylium.BYG_END_SURFACE_BLOCKS.contains(state1.getBlock())) {
                return true;
            }
        }
        return false;
    }

    public static void performBonemeal(ServerLevel world, BlockPos pos) {
        for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
            BlockState state2 = world.getBlockState(blockpos);
            if (BYGNylium.BYG_END_SURFACE_BLOCKS.contains(state2.getBlock())) {
                if (world.getBlockState(pos).getBlock() != state2.getBlock()) {
                    world.setBlock(pos, state2.getBlock().defaultBlockState(), 2);
                }
            }
        }
    }
}