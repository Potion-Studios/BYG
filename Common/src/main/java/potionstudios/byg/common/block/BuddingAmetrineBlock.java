package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;

import java.util.Random;

public class BuddingAmetrineBlock extends OreBlock {
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingAmetrineBlock(Properties builder) {
        super(builder, UniformInt.of(3, 9));
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
                block = BYGBlocks.AMETRINE_CLUSTER;
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
