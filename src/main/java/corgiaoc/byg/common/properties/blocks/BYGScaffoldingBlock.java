package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.ScaffoldingBlock;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BYGScaffoldingBlock extends ScaffoldingBlock implements IWaterLoggable {

    protected BYGScaffoldingBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        return useContext.getItem().getItem() == this.asItem();
    }

    public static int calculateDISTANCE(IBlockReader blockReader, BlockPos pos) {
        BlockPos.Mutable blockpos$mutable = (new BlockPos.Mutable().setPos(pos)).move(Direction.DOWN);
        BlockState blockstate = blockReader.getBlockState(blockpos$mutable);
        int i = 7;
        if (blockstate.getBlock() == BYGBlocks.SYTHIAN_SCAFFOLDING) {
            i = blockstate.get(DISTANCE);
        } else if (blockstate.isSolidSide(blockReader, blockpos$mutable, Direction.UP)) {
            return 0;
        }

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate1 = blockReader.getBlockState(blockpos$mutable.setPos(pos).move(direction));
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
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        World world = context.getWorld();
        int i = calculateDISTANCE(world, blockpos);
        return this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(world.getFluidState(blockpos).getFluid() == Fluids.WATER)).with(DISTANCE, Integer.valueOf(i)).with(BOTTOM, Boolean.valueOf(this.shouldBeBOTTOM(world, blockpos, i)));
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        int i = calculateDISTANCE(worldIn, pos);
        BlockState blockstate = state.with(DISTANCE, Integer.valueOf(i)).with(BOTTOM, Boolean.valueOf(this.shouldBeBOTTOM(worldIn, pos, i)));
        if (blockstate.get(DISTANCE) == 7) {
            if (state.get(DISTANCE) == 7) {
                worldIn.addEntity(new FallingBlockEntity(worldIn, (double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D, blockstate.with(WATERLOGGED, false)));
            } else {
                worldIn.destroyBlock(pos, true);
            }
        } else if (state != blockstate) {
            worldIn.setBlockState(pos, blockstate, 3);
        }

    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return calculateDISTANCE(worldIn, pos) < 7;
    }

    private boolean shouldBeBOTTOM(IBlockReader blockReader, BlockPos pos, int DISTANCE) {
        return DISTANCE > 0 && blockReader.getBlockState(pos.down()).getBlock() != this;
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!worldIn.isRemote) {
            worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1);
        }

    }
}
