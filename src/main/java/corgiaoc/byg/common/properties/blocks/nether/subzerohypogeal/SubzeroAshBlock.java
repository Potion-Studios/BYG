package corgiaoc.byg.common.properties.blocks.nether.subzerohypogeal;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import edu.umd.cs.findbugs.annotations.Nullable;

public class SubzeroAshBlock extends Block {
    public static final IntProperty LAYERS = Properties.LAYERS;
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{VoxelShapes.empty(), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    protected SubzeroAshBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(LAYERS, Integer.valueOf(1)));
    }

    public boolean canPathfindThrough(BlockState state, BlockView worldIn, BlockPos pos, NavigationType type) {
        switch (type) {
            case LAND:
                return state.get(LAYERS) < 5;
            case WATER:
                return false;
            case AIR:
                return false;
            default:
                return false;
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPES[state.get(LAYERS)];
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPES[state.get(LAYERS) - 1];
    }

    public VoxelShape getSidesShape(BlockState state, BlockView reader, BlockPos pos) {
        return SHAPES[state.get(LAYERS)];
    }

    public VoxelShape getVisualShape(BlockState state, BlockView reader, BlockPos pos, ShapeContext context) {
        return SHAPES[state.get(LAYERS)];
    }

    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockState blockstate = worldIn.getBlockState(pos.down());
        if (!blockstate.isOf(Blocks.ICE) && !blockstate.isOf(Blocks.PACKED_ICE) && !blockstate.isOf(Blocks.BARRIER)) {
            if (!blockstate.isOf(Blocks.HONEY_BLOCK) && !blockstate.isOf(Blocks.SOUL_SAND)) {
                return Block.isFaceFullSquare(blockstate.getCollisionShape(worldIn, pos.down()), Direction.UP) || blockstate.getBlock() == this && blockstate.get(LAYERS) == 8;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.canPlaceAt(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public boolean canReplace(BlockState state, ItemPlacementContext useContext) {
        int i = state.get(LAYERS);
        if (useContext.getStack().getItem() == this.asItem() && i < 8) {
            if (useContext.canReplaceExisting()) {
                return useContext.getSide() == Direction.UP;
            } else {
                return true;
            }
        } else {
            return i == 1;
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getBlockPos());
        if (blockstate.isOf(this)) {
            int i = blockstate.get(LAYERS);
            return blockstate.with(LAYERS, Integer.valueOf(Math.min(8, i + 1)));
        } else {
            return super.getPlacementState(context);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }
}
