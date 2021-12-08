package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.PushReaction;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BuddingAmetrineBlock extends BYGOreBlock {
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingAmetrineBlock(Properties builder) {
        super(builder);
    }

    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.relative(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;
            if (canClusterGrowAtState(blockState)) {
                block = BYGBlocks.AMETRINE_CLUSTER;
            }
            if (block != null) {
                BlockState blockState2 = block.defaultBlockState().setValue(CrystalClusterBlock.FACING, direction).setValue(CrystalClusterBlock.WATERLOGGED, blockState.getFluidState().getType() == Fluids.WATER);
                world.setBlockAndUpdate(blockPos, blockState2);
            }

        }
    }

    public static boolean canClusterGrowAtState(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8;
    }
}
