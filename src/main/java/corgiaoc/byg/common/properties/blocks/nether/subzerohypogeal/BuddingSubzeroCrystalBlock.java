package corgiaoc.byg.common.properties.blocks.nether.subzerohypogeal;

import corgiaoc.byg.common.properties.blocks.CrystalClusterBlock;
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

public class BuddingSubzeroCrystalBlock extends Block {
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingSubzeroCrystalBlock(Properties builder) {
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
                block = BYGBlocks.SMALL_SUBZERO_CRYSTAL_BUD;
            } else if (blockState.is(BYGBlocks.SMALL_SUBZERO_CRYSTAL_BUD) && blockState.getValue(CrystalClusterBlock.FACING) == direction) {
                block = BYGBlocks.MEDIUM_SUBZERO_CRYSTAL_BUD;
            } else if (blockState.is(BYGBlocks.MEDIUM_SUBZERO_CRYSTAL_BUD) && blockState.getValue(CrystalClusterBlock.FACING) == direction) {
                block = BYGBlocks.LARGE_SUBZERO_CRYSTAL_BUD;
            } else if (blockState.is(BYGBlocks.LARGE_SUBZERO_CRYSTAL_BUD) && blockState.getValue(CrystalClusterBlock.FACING) == direction) {
                block = BYGBlocks.SUBZERO_CRYSTAL_CLUSTER;
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
