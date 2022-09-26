package potionstudios.byg.common.block.nether.sythian;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BambooBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.common.block.BYGBlocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SythianStalkBlock extends BambooBlock {

    public static final int MAX_HEIGHT = 16;

    public SythianStalkBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(LEAVES, BambooLeaves.NONE).setValue(STAGE, 0));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        if (!fluidState.isEmpty()) {
            return null;
        }

        BlockState stateDown = context.getLevel().getBlockState(context.getClickedPos().below());

        if (stateDown.is(BYGBlockTags.SYTHIAN_STALK_PLANTABLE_ON)) {
            if (stateDown.is(BYGBlocks.SYTHIAN_SAPLING.get())) {
                return this.defaultBlockState().setValue(AGE, 0);
            } else if (stateDown.is(this)) {
                int age = stateDown.getValue(AGE) > 0 ? 1 : 0;
                return this.defaultBlockState().setValue(AGE, age);
            }

            return BYGBlocks.SYTHIAN_SAPLING.get().defaultBlockState();
        }

        return null;
    }

    @Override
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (state.getValue(STAGE) == 0) {
            if (level.isEmptyBlock(pos.above())) {
                int i = this.getHeightBelowUpToMax(level, pos) + 1;

                if (i < 16) {
                    this.growBamboo(state, level, pos, random, i);
                }
            }
        }
    }

    @Nonnull
    @Override
    public BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos posFrom) {
        if (!state.canSurvive(level, pos)) {
            level.scheduleTick(pos, this, 1);
        }

        if (facing == Direction.UP && facingState.getBlock() == this && facingState.getValue(AGE) > state.getValue(AGE)) {
            level.setBlock(pos, state.cycle(AGE), 2);
        }

        return super.updateShape(state, facing, facingState, level, pos, posFrom);
    }

    @Override
    protected void growBamboo(@NotNull BlockState state, Level world, BlockPos pos, @NotNull RandomSource rand, int i) {
        BlockState stateDOWN = world.getBlockState(pos.below());
        BlockPos posDOWN2 = pos.below(2);
        BlockState blockStateDOWN2 = world.getBlockState(posDOWN2);
        BambooLeaves bambooLeavesNONE = BambooLeaves.NONE;
        if (i >= 1) {
            if (stateDOWN.getBlock() == this && stateDOWN.getValue(LEAVES) != BambooLeaves.NONE) {
                if (stateDOWN.getBlock() == this && stateDOWN.getValue(LEAVES) != BambooLeaves.NONE) {
                    bambooLeavesNONE = BambooLeaves.LARGE;
                    if (blockStateDOWN2.getBlock() == this) {
                        world.setBlock(pos.below(), stateDOWN.setValue(LEAVES, BambooLeaves.SMALL), 3);
                        world.setBlock(posDOWN2, blockStateDOWN2.setValue(LEAVES, BambooLeaves.NONE), 3);
                    }
                }
            } else {
                bambooLeavesNONE = BambooLeaves.SMALL;
            }
        }

        int j = state.getValue(AGE) != 1 && blockStateDOWN2.getBlock() != this ? 0 : 1;
        int k = (i < 11 || rand.nextFloat() >= 0.25F) && i != 15 ? 0 : 1;
        world.setBlock(pos.above(), this.defaultBlockState().setValue(AGE, j).setValue(LEAVES, bambooLeavesNONE).setValue(STAGE, k), 3);
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        return level.getBlockState(pos.below()).is(BYGBlockTags.SYTHIAN_STALK_PLANTABLE_ON);
    }

    @Override
    protected int getHeightAboveUpToMax(@NotNull BlockGetter level, @NotNull BlockPos pos) {
        int i = 0;

        while (i < MAX_HEIGHT && level.getBlockState(pos.above(i + 1)).is(this)) {
            i++;
        }

        return i;
    }

    @Override
    protected int getHeightBelowUpToMax(@NotNull BlockGetter level, @NotNull BlockPos pos) {
        int i = 0;

        while (i < MAX_HEIGHT && level.getBlockState(pos.below(i + 1)).is(this)) {
            i++;
        }

        return i;
    }
}
