package corgiaoc.byg.common.properties.blocks;

import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BYGRiverPlantBlock extends DoublePlantBlock implements IWaterLoggable {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BYGRiverPlantBlock(AbstractBlock.Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER && state.getValue(WATERLOGGED)) {
            return false;
        }
        if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
            BlockPos groundPos = pos.below();
            Block ground = world.getBlockState(groundPos).getBlock();

            if (world.getFluidState(pos).getType() == Fluids.WATER)
                return canGrow(ground);

            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (world.getFluidState(groundPos.relative(direction)).getType() == Fluids.WATER) {
                    return canGrow(ground);
                }
            }

            return false;
        } else {
            BlockState blockstate = world.getBlockState(pos.below());
            if (state.getBlock() != this)
                return false;
            return blockstate.getBlock() == this && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public boolean canGrow(Block ground) {
        return ground == Blocks.DIRT || ground instanceof GrassBlock || ground instanceof SandBlock
                || ground == Blocks.GRAVEL || ground == Blocks.CLAY;
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!canSurvive(state, world, pos)) {
            if (state.getValue(WATERLOGGED)) {
                world.setBlockAndUpdate(pos, Blocks.WATER.defaultBlockState());
            } else {
                world.destroyBlock(pos, false);
            }
        }
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            BlockState stateUpper = world.getBlockState(pos.above());
            if (stateUpper.getBlock() instanceof BYGRiverPlantBlock) {
                if (!canSurvive(stateUpper, world, pos.above())) {
                    world.destroyBlock(pos.above(), false);
                }
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world,
                                          BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            world.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState FluidState = context.getLevel().getFluidState(context.getClickedPos());

        BlockState state = super.getStateForPlacement(context);
        if (state != null) {
            return state.setValue(WATERLOGGED, Boolean.valueOf(FluidState.getType() == Fluids.WATER));
        } else {
            return null;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HALF, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockItemUseContext useContext) {
        return false;
    }
}

