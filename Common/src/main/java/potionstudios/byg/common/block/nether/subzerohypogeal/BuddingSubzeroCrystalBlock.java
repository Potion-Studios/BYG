package potionstudios.byg.common.block.nether.subzerohypogeal;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import potionstudios.byg.common.block.BYGBlocks;

import java.util.Random;

public class BuddingSubzeroCrystalBlock extends Block {
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingSubzeroCrystalBlock(Properties builder) {
        super(builder);
    }

    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.relative(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;
            if (canClusterGrowAtState(blockState)) {
                block = BYGBlocks.SMALL_SUBZERO_CRYSTAL_BUD;
            } else if (blockState.is(BYGBlocks.SMALL_SUBZERO_CRYSTAL_BUD) && blockState.getValue(AmethystClusterBlock.FACING) == direction) {
                block = BYGBlocks.MEDIUM_SUBZERO_CRYSTAL_BUD;
            } else if (blockState.is(BYGBlocks.MEDIUM_SUBZERO_CRYSTAL_BUD) && blockState.getValue(AmethystClusterBlock.FACING) == direction) {
                block = BYGBlocks.LARGE_SUBZERO_CRYSTAL_BUD;
            } else if (blockState.is(BYGBlocks.LARGE_SUBZERO_CRYSTAL_BUD) && blockState.getValue(AmethystClusterBlock.FACING) == direction) {
                block = BYGBlocks.SUBZERO_CRYSTAL_CLUSTER;
            }
            if (block != null) {
                BlockState blockState2 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, blockState.getFluidState().getType() == Fluids.WATER);
                world.setBlockAndUpdate(blockPos, blockState2);
            }

        }
    }

    public static boolean canClusterGrowAtState(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8;
    }
}
