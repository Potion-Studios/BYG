package potionstudios.byg.common.block.end.therium;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGBlocks;

public class BuddingTheriumCrystalBlock extends Block {
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingTheriumCrystalBlock(Properties builder) {
        super(builder);
    }

    public @NotNull PushReaction getPistonPushReaction(@NotNull BlockState state) {
        return PushReaction.DESTROY;
    }

    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel world, @NotNull BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.relative(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;
            if (canClusterGrowAtState(blockState)) {
                block = BYGBlocks.SMALL_THERIUM_CRYSTAL_BUD.get();
            } else if (blockState.is(BYGBlocks.SMALL_THERIUM_CRYSTAL_BUD.get()) && blockState.getValue(AmethystClusterBlock.FACING) == direction) {
                block = BYGBlocks.MEDIUM_THERIUM_CRYSTAL_BUD.get();
            } else if (blockState.is(BYGBlocks.MEDIUM_THERIUM_CRYSTAL_BUD.get()) && blockState.getValue(AmethystClusterBlock.FACING) == direction) {
                block = BYGBlocks.LARGE_THERIUM_CRYSTAL_BUD.get();
            } else if (blockState.is(BYGBlocks.LARGE_THERIUM_CRYSTAL_BUD.get()) && blockState.getValue(AmethystClusterBlock.FACING) == direction) {
                block = BYGBlocks.THERIUM_CRYSTAL_CLUSTER.get();
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
