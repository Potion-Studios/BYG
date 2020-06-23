package voronoiaoc.byg.common.properties.blocks;//package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Iterator;
import java.util.Random;

public class BYGScaffoldingBlock extends ScaffoldingBlock implements Waterloggable {

    protected BYGScaffoldingBlock(Settings properties) {
        super(properties);
    }
    public static int calculateDistance(BlockView world, BlockPos pos) {
        BlockPos.Mutable mutable = pos.mutableCopy().move(Direction.DOWN);
        BlockState blockState = world.getBlockState(mutable);
        int i = 7;
        if (blockState.isOf(Blocks.SCAFFOLDING)) {
            i = blockState.get(DISTANCE);
        } else if (blockState.isSideSolidFullSquare(world, mutable, Direction.UP)) {
            return 0;
        }

        Iterator var5 = Direction.Type.HORIZONTAL.iterator();

        while(var5.hasNext()) {
            Direction direction = (Direction)var5.next();
            BlockState blockState2 = world.getBlockState(mutable.set(pos, direction));
            if (blockState2.isOf(Blocks.SCAFFOLDING)) {
                i = Math.min(i, blockState2.get(DISTANCE) + 1);
                if (i == 1) {
                    break;
                }
            }
        }

        return i;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        World world = ctx.getWorld();
        int i = calculateDistance(world, blockPos);
        return this.getDefaultState().with(WATERLOGGED, world.getFluidState(blockPos).getFluid() == Fluids.WATER).with(DISTANCE, i).with(BOTTOM, this.shouldBeBottom(world, blockPos, i));
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = calculateDistance(world, pos);
        BlockState blockState = state.with(DISTANCE, i).with(BOTTOM, this.shouldBeBottom(world, pos, i));
        if (blockState.get(DISTANCE) == 7) {
            if (state.get(DISTANCE) == 7) {
                world.spawnEntity(new FallingBlockEntity(world, (double)pos.getX() + 0.5D, pos.getY(), (double)pos.getZ() + 0.5D, blockState.with(WATERLOGGED, false)));
            } else {
                world.breakBlock(pos, true);
            }
        } else if (state != blockState) {
            world.setBlockState(pos, blockState, 3);
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return calculateDistance(world, pos) < 7;
    }

    private boolean shouldBeBottom(BlockView world, BlockPos pos, int distance) {
        return distance > 0 && !world.getBlockState(pos.down()).isOf(this);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return context.getStack().getItem() == this.asItem();
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient) {
            world.getBlockTickScheduler().schedule(pos, this, 1);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (state.get(WATERLOGGED)) {
            world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        if (!world.isClient()) {
            world.getBlockTickScheduler().schedule(pos, this, 1);
        }
        return state;
    }
}
