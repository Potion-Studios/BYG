package voronoiaoc.byg.common.properties.blocks.plants;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
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

public class BYGRiverPlantBlock extends TallPlantBlock implements Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public BYGRiverPlantBlock(Settings propeties) {
        super(propeties);
        this.setDefaultState(this.stateManager.getDefaultState().with(HALF, DoubleBlockHalf.LOWER).with(WATERLOGGED, false));
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
        return ground == Blocks.DIRT || ground instanceof GrassBlock || ground instanceof SandBlock || ground == Blocks.GRAVEL || ground == Blocks.CLAY;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
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
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        DoubleBlockHalf doubleblockhalf = state.get(HALF);
        BlockPos blockpos = doubleblockhalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
        BlockState blockstate = world.getBlockState(blockpos);
        if (blockstate.getBlock() == this && blockstate.get(HALF) != doubleblockhalf) {
            if (blockstate.get(HALF) == DoubleBlockHalf.LOWER) {
                if (blockstate.get(WATERLOGGED)) {
                    world.setBlockState(blockpos, Blocks.WATER.getDefaultState());
                } else {
                    world.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
                }
            }

            world.syncWorldEvent(player, 2001, blockpos, Block.getRawIdFromState(blockstate));
            if (!world.isClient() && !player.isCreative()) {
                dropStacks(state, world, pos, null, player, player.getMainHandStack());
                dropStacks(blockstate, world, blockpos, null, player, player.getMainHandStack());
            }
        }
        world.syncWorldEvent(player, 2001, pos, Block.getRawIdFromState(state));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (state.get(WATERLOGGED)) {
            world.getBlockTickScheduler().schedule(pos, Blocks.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }


    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState ifluidstate = ctx.getWorld().getFluidState(ctx.getBlockPos());

        BlockState state = super.getPlacementState(ctx);
        if (state != null) {
            return state.with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
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
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return false;
    }
}

