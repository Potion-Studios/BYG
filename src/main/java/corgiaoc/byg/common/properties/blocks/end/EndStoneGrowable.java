package corgiaoc.byg.common.properties.blocks.end;

import corgiaoc.byg.common.properties.blocks.BYGNylium;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class EndStoneGrowable extends Block implements IGrowable {

    // Add this just in case the block we're replacing is an instance of iGrowable already.
    @Nullable
    IGrowable growableBlock;

    public EndStoneGrowable(Block block) {
        super(AbstractBlock.Properties.copy(block));
        growableBlock = block instanceof IGrowable ? (IGrowable) block : null;
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader reader, BlockPos pos, BlockState state, boolean isClient) {
        for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
            BlockState state1 = reader.getBlockState(blockpos);
            if (BYGNylium.BYG_END_SURFACE_BLOCKS.contains(state1.getBlock())) {
                return true;
            }
        }

        return growableBlock != null && growableBlock.isValidBonemealTarget(reader, pos, state, isClient);
    }

    @Override
    public boolean isBonemealSuccess(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerWorld world, Random random, BlockPos pos, BlockState state) {
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
