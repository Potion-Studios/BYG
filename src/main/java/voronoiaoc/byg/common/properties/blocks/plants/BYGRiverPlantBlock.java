package voronoiaoc.byg.common.properties.blocks.plants;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class BYGRiverPlantBlock extends DoublePlantBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BYGRiverPlantBlock(Properties propeties) {
        super(propeties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
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
        return ground == Blocks.DIRT || ground instanceof GrassBlock || ground instanceof SandBlock || ground == Blocks.GRAVEL || ground == Blocks.CLAY;
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
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
    public void attack(BlockState state, Level world, BlockPos pos, Player player) {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        BlockPos blockpos = doubleblockhalf != DoubleBlockHalf.LOWER ? pos.above() : pos.below();
        BlockState blockstate = world.getBlockState(blockpos);
        if (blockstate.getBlock() == this && blockstate.getValue(HALF) != doubleblockhalf) {
            if (blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                if (blockstate.getValue(WATERLOGGED)) {
                    world.setBlockAndUpdate(blockpos, Blocks.WATER.defaultBlockState());
                } else {
                    world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                }
            }

            world.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
            if (!world.isClientSide() && !player.isCreative()) {
                dropResources(state, world, pos, null, player, player.getMainHandItem());
                dropResources(blockstate, world, blockpos, null, player, player.getMainHandItem());
            }
        }
        world.levelEvent(player, 2001, pos, Block.getId(state));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor world, BlockPos pos, BlockPos posFrom) {
        if (state.getValue(WATERLOGGED)) {
            world.getBlockTicks().scheduleTick(pos, Blocks.WATER, Fluids.WATER.getTickDelay(world));
        }

        return super.updateShape(state, direction, newState, world, pos, posFrom);
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState ifluidstate = ctx.getLevel().getFluidState(ctx.getClickedPos());

        BlockState state = super.getStateForPlacement(ctx);
        if (state != null) {
            return state.setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));
        } else {
            return null;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALF, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }
}

