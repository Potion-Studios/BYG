package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ScaffoldingBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Random;

public class BYGScaffoldingBlock extends ScaffoldingBlock implements Waterloggable {

    protected BYGScaffoldingBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext useContext) {
        return useContext.getStack().getItem() == this.asItem();
    }

    public static int calculateDISTANCE(BlockView blockReader, BlockPos pos) {
        BlockPos.Mutable blockpos$mutable = (new BlockPos.Mutable().set(pos)).move(Direction.DOWN);
        BlockState blockstate = blockReader.getBlockState(blockpos$mutable);
        int i = 7;
        if (blockstate.getBlock() == BYGBlocks.SYTHIAN_SCAFFOLDING) {
            i = blockstate.get(DISTANCE);
        } else if (blockstate.isSideSolidFullSquare(blockReader, blockpos$mutable, Direction.UP)) {
            return 0;
        }

        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockState blockstate1 = blockReader.getBlockState(blockpos$mutable.set(pos).move(direction));
            if (blockstate1.getBlock() == BYGBlocks.SYTHIAN_SCAFFOLDING) {
                i = Math.min(i, blockstate1.get(DISTANCE) + 1);
                if (i == 1) {
                    break;
                }
            }
        }

        return i;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        World world = context.getWorld();
        int i = calculateDISTANCE(world, blockpos);
        return this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(world.getFluidState(blockpos).getFluid() == Fluids.WATER)).with(DISTANCE, Integer.valueOf(i)).with(BOTTOM, Boolean.valueOf(this.shouldBeBOTTOM(world, blockpos, i)));
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        int i = calculateDISTANCE(worldIn, pos);
        BlockState blockstate = state.with(DISTANCE, Integer.valueOf(i)).with(BOTTOM, Boolean.valueOf(this.shouldBeBOTTOM(worldIn, pos, i)));
        if (blockstate.get(DISTANCE) == 7) {
            if (state.get(DISTANCE) == 7) {
                worldIn.spawnEntity(new FallingBlockEntity(worldIn, (double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D, blockstate.with(WATERLOGGED, false)));
            } else {
                worldIn.breakBlock(pos, true);
            }
        } else if (state != blockstate) {
            worldIn.setBlockState(pos, blockstate, 3);
        }

    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        return calculateDISTANCE(worldIn, pos) < 7;
    }

    private boolean shouldBeBOTTOM(BlockView blockReader, BlockPos pos, int DISTANCE) {
        return DISTANCE > 0 && blockReader.getBlockState(pos.down()).getBlock() != this;
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!worldIn.isClient) {
            worldIn.getBlockTickScheduler().schedule(pos, this, 1);
        }

    }
}
