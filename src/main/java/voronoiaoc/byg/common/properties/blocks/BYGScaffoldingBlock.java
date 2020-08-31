package voronoiaoc.byg.common.properties.blocks;//package voronoiaoc.byg.common.properties.blocks;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ScaffoldingBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BYGScaffoldingBlock extends ScaffoldingBlock implements SimpleWaterloggedBlock {

    protected BYGScaffoldingBlock(Properties properties) {
        super(properties);
    }

    public static int getDistance(BlockGetter world, BlockPos pos) {
        BlockPos.MutableBlockPos mutable = pos.mutable().move(Direction.DOWN);
        BlockState blockState = world.getBlockState(mutable);
        int i = 7;
        if (blockState.is(Blocks.SCAFFOLDING)) {
            i = blockState.getValue(DISTANCE);
        } else if (blockState.isFaceSturdy(world, mutable, Direction.UP)) {
            return 0;
        }

        Iterator var5 = Direction.Plane.HORIZONTAL.iterator();

        while (var5.hasNext()) {
            Direction direction = (Direction) var5.next();
            BlockState blockState2 = world.getBlockState(mutable.setWithOffset(pos, direction));
            if (blockState2.is(Blocks.SCAFFOLDING)) {
                i = Math.min(i, blockState2.getValue(DISTANCE) + 1);
                if (i == 1) {
                    break;
                }
            }
        }

        return i;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockPos blockPos = ctx.getClickedPos();
        Level world = ctx.getLevel();
        int i = getDistance(world, blockPos);
        return this.defaultBlockState().setValue(WATERLOGGED, world.getFluidState(blockPos).getType() == Fluids.WATER).setValue(DISTANCE, i).setValue(BOTTOM, this.isBottom(world, blockPos, i));
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        int i = getDistance(world, pos);
        BlockState blockState = state.setValue(DISTANCE, i).setValue(BOTTOM, this.isBottom(world, pos, i));
        if (blockState.getValue(DISTANCE) == 7) {
            if (state.getValue(DISTANCE) == 7) {
                world.addFreshEntity(new FallingBlockEntity(world, (double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D, blockState.setValue(WATERLOGGED, false)));
            } else {
                world.destroyBlock(pos, true);
            }
        } else if (state != blockState) {
            world.setBlock(pos, blockState, 3);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return getDistance(world, pos) < 7;
    }

    private boolean isBottom(BlockGetter world, BlockPos pos, int distance) {
        return distance > 0 && !world.getBlockState(pos.below()).is(this);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return context.getItemInHand().getItem() == this.asItem();
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClientSide) {
            world.getBlockTicks().scheduleTick(pos, this, 1);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor world, BlockPos pos, BlockPos posFrom) {
        if (state.getValue(WATERLOGGED)) {
            world.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        if (!world.isClientSide()) {
            world.getBlockTicks().scheduleTick(pos, this, 1);
        }
        return state;
    }
}
