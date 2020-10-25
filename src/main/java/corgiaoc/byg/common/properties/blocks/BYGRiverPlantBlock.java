package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
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

import javax.annotation.Nullable;

public class BYGRiverPlantBlock extends DoublePlantBlock implements IWaterLoggable {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BYGRiverPlantBlock(Block.Properties properties) {
        super(properties);
        this.setDefaultState(
                this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.LOWER).with(WATERLOGGED, false));
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        if (state.get(HALF) == DoubleBlockHalf.UPPER && state.get(WATERLOGGED)) {
            return false;
        }
        if (state.get(HALF) != DoubleBlockHalf.UPPER) {
            BlockPos groundPos = pos.down();
            Block ground = world.getBlockState(groundPos).getBlock();

            if (world.getFluidState(pos).getFluid() == Fluids.WATER)
                return canGrow(ground);

            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (world.getFluidState(groundPos.offset(direction)).getFluid() == Fluids.WATER) {
                    return canGrow(ground);
                }
            }

            return false;
        } else {
            BlockState blockstate = world.getBlockState(pos.down());
            if (state.getBlock() != this)
                return false;
            return blockstate.getBlock() == this && blockstate.get(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public boolean canGrow(Block ground) {
        return ground == Blocks.DIRT || ground instanceof GrassBlock || ground instanceof SandBlock
                || ground == Blocks.GRAVEL || ground == Blocks.CLAY;
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!isValidPosition(state, world, pos)) {
            if (state.get(WATERLOGGED)) {
                world.setBlockState(pos, Blocks.WATER.getDefaultState());
            } else {
                world.destroyBlock(pos, false);
            }
        }
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            BlockState stateUpper = world.getBlockState(pos.up());
            if (stateUpper.getBlock() instanceof BYGRiverPlantBlock) {
                if (!isValidPosition(stateUpper, world, pos.up())) {
                    world.destroyBlock(pos.up(), false);
                }
            }
        }
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world,
                                          BlockPos currentPos, BlockPos facingPos) {
        if (state.get(WATERLOGGED)) {
            world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState FluidState = context.getWorld().getFluidState(context.getPos());

        BlockState state = super.getStateForPlacement(context);
        if (state != null) {
            return state.with(WATERLOGGED, Boolean.valueOf(FluidState.getFluid() == Fluids.WATER));
        } else {
            return null;
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HALF, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        return false;
    }
}

