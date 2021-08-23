package corgiaoc.byg.common.properties.blocks.nether.subzerohypogeal;

import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class SubzeroAshBlock extends Block {
    public static final IntegerProperty LAYERS = BlockStateProperties.LAYERS;
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{VoxelShapes.empty(), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    protected SubzeroAshBlock(AbstractBlock.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LAYERS, Integer.valueOf(1)));
    }

    public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        switch (type) {
            case LAND:
                return state.getValue(LAYERS) < 5;
            case WATER:
                return false;
            case AIR:
                return false;
            default:
                return false;
        }
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.getValue(LAYERS)];
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.getValue(LAYERS) - 1];
    }

    public VoxelShape getBlockSupportShape(BlockState state, IBlockReader reader, BlockPos pos) {
        return SHAPES[state.getValue(LAYERS)];
    }

    public VoxelShape getVisualShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.getValue(LAYERS)];
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState blockstate = worldIn.getBlockState(pos.below());
        if (!blockstate.is(Blocks.ICE) && !blockstate.is(Blocks.PACKED_ICE) && !blockstate.is(Blocks.BARRIER)) {
            if (!blockstate.is(Blocks.HONEY_BLOCK) && !blockstate.is(Blocks.SOUL_SAND)) {
                return Block.isFaceFull(blockstate.getCollisionShape(worldIn, pos.below()), Direction.UP) || blockstate.getBlock() == this && blockstate.getValue(LAYERS) == 8;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public boolean canBeReplaced(BlockState state, BlockItemUseContext useContext) {
        int i = state.getValue(LAYERS);
        if (useContext.getItemInHand().getItem() == this.asItem() && i < 8) {
            if (useContext.replacingClickedOnBlock()) {
                return useContext.getClickedFace() == Direction.UP;
            } else {
                return true;
            }
        } else {
            return i == 1;
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.is(this)) {
            int i = blockstate.getValue(LAYERS);
            return blockstate.setValue(LAYERS, Integer.valueOf(Math.min(8, i + 1)));
        } else {
            return super.getStateForPlacement(context);
        }
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }
}
