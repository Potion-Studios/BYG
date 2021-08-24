package corgiaoc.byg.common.properties.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class CrystalClusterBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    protected final VoxelShape northAabb;
    protected final VoxelShape southAabb;
    protected final VoxelShape eastAabb;
    protected final VoxelShape westAabb;
    protected final VoxelShape upAabb;
    protected final VoxelShape downAabb;
    public CrystalClusterBlock(int i, int j, Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, true).setValue(WATERLOGGED, false).setValue(FACING, Direction.UP));
        this.upAabb = Block.box(j, 0.0D,  j, 16 - j,  i,  (16 - j));
        this.downAabb = Block.box( j,  (16 - i),  j,  (16 - j), 16.0D,  (16 - j));
        this.northAabb = Block.box( j,  j,  (16 - i),  (16 - j),  (16 - j), 16.0D);
        this.southAabb = Block.box( j,  j, 0.0D,  (16 - j),  (16 - j),  i);
        this.eastAabb = Block.box(0.0D,  j,  j,  i,  (16 - j),  (16 - j));
        this.westAabb = Block.box( (16 - i),  j,  j, 16.0D,  (16 - j),  (16 - j));
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        switch(direction) {
            case NORTH:
                return this.northAabb;
            case SOUTH:
                return this.southAabb;
            case EAST:
                return this.eastAabb;
            case WEST:
                return this.westAabb;
            case DOWN:
                return this.downAabb;
            case UP:
            default:
                return this.upAabb;
        }
    }

    public boolean canSurvive(BlockState state, BlockGetter world, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos blockPos = pos.relative(direction.getOpposite());
        return world.getBlockState(blockPos).isFaceSturdy(world, blockPos, direction);
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.getLiquidTicks().scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return direction == blockState.getValue(FACING).getOpposite() && !blockState.canSurvive(levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        LevelAccessor levelAccessor = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        return this.defaultBlockState().setValue(WATERLOGGED, levelAccessor.getFluidState(blockPos).getType() == Fluids.WATER).setValue(FACING, ctx.getClickedFace());
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{WATERLOGGED, LIT, FACING});
    }

    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.NORMAL;
    }

}
