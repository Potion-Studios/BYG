package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import edu.umd.cs.findbugs.annotations.Nullable;

public class BYGRiverPlantBlock extends TallPlantBlock implements Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public BYGRiverPlantBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(
                this.stateManager.getDefaultState().with(HALF, DoubleBlockHalf.LOWER).with(WATERLOGGED, false));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (state.get(HALF) == DoubleBlockHalf.UPPER && state.get(WATERLOGGED)) {
            return false;
        }
        if (state.get(HALF) != DoubleBlockHalf.UPPER) {
            BlockPos groundPos = pos.down();
            Block ground = world.getBlockState(groundPos).getBlock();

            if (world.getFluidState(pos).getFluid() == Fluids.WATER)
                return canGrow(ground);

            for (Direction direction : Direction.Type.HORIZONTAL) {
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
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!canPlaceAt(state, world, pos)) {
            if (state.get(WATERLOGGED)) {
                world.setBlockState(pos, Blocks.WATER.getDefaultState());
            } else {
                world.breakBlock(pos, false);
            }
        }
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            BlockState stateUpper = world.getBlockState(pos.up());
            if (stateUpper.getBlock() instanceof BYGRiverPlantBlock) {
                if (!canPlaceAt(stateUpper, world, pos.up())) {
                    world.breakBlock(pos.up(), false);
                }
            }
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState facingState, WorldAccess world,
                                                BlockPos currentPos, BlockPos facingPos) {
        if (state.get(WATERLOGGED)) {
            world.getFluidTickScheduler().schedule(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState FluidState = context.getWorld().getFluidState(context.getBlockPos());

        BlockState state = super.getPlacementState(context);
        if (state != null) {
            return state.with(WATERLOGGED, Boolean.valueOf(FluidState.getFluid() == Fluids.WATER));
        } else {
            return null;
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HALF, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext useContext) {
        return false;
    }
}

