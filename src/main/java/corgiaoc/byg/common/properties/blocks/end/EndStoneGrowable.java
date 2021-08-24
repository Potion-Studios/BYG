package corgiaoc.byg.common.properties.blocks.end;

import corgiaoc.byg.common.properties.blocks.BYGNylium;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class EndStoneGrowable extends Block implements BonemealableBlock {

    // Add this just in case the block we're replacing is an instance of iGrowable already.
    @Nullable
    BonemealableBlock growableBlock;

    public EndStoneGrowable(Block block) {
        super(Properties.copy(block));
        growableBlock = block instanceof BonemealableBlock ? (BonemealableBlock) block : null;
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter reader, BlockPos pos, BlockState state, boolean isClient) {
        for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
            BlockState state1 = reader.getBlockState(blockpos);
            if (BYGNylium.BYG_END_SURFACE_BLOCKS.contains(state1.getBlock())) {
                return true;
            }
        }

        return growableBlock != null && growableBlock.isValidBonemealTarget(reader, pos, state, isClient);
    }

    @Override
    public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
        for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
            BlockState state2 = world.getBlockState(blockpos);
            if (BYGNylium.BYG_END_SURFACE_BLOCKS.contains(state2.getBlock())) {
                if (world.getBlockState(pos).getBlock() != state2.getBlock()) {
                    world.setBlock(pos, state2.getBlock().defaultBlockState(), 2);
                }
            }
        }

        if (growableBlock != null) {
            growableBlock.performBonemeal(world, random, pos, state);
        }
    }
}
