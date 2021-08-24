package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractBlock;
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

    protected BYGScaffoldingBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockItemUseContext useContext) {
        return useContext.getItemInHand().getItem() == this.asItem();
    }

    public static int calculateDISTANCE(IBlockReader blockReader, BlockPos pos) {
        BlockPos.Mutable blockpos$mutable = (new BlockPos.Mutable().set(pos)).move(Direction.DOWN);
        BlockState blockstate = blockReader.getBlockState(blockpos$mutable);
        int i = 7;
        if (blockstate.getBlock() == BYGBlocks.SYTHIAN_SCAFFOLDING) {
            i = blockstate.getValue(DISTANCE);
        } else if (blockstate.isFaceSturdy(blockReader, blockpos$mutable, Direction.UP)) {
            return 0;
        }

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate1 = blockReader.getBlockState(blockpos$mutable.set(pos).move(direction));
            if (blockstate1.getBlock() == BYGBlocks.SYTHIAN_SCAFFOLDING) {
                i = Math.min(i, blockstate1.getValue(DISTANCE) + 1);
                if (i == 1) {
                    break;
                }
            }
        }

        return i;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getClickedPos();
        World world = context.getLevel();
        int i = calculateDISTANCE(world, blockpos);
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(world.getFluidState(blockpos).getType() == Fluids.WATER)).setValue(DISTANCE, Integer.valueOf(i)).setValue(BOTTOM, Boolean.valueOf(this.shouldBeBOTTOM(world, blockpos, i)));
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        int i = calculateDISTANCE(worldIn, pos);
        BlockState blockstate = state.setValue(DISTANCE, Integer.valueOf(i)).setValue(BOTTOM, Boolean.valueOf(this.shouldBeBOTTOM(worldIn, pos, i)));
        if (blockstate.getValue(DISTANCE) == 7) {
            if (state.getValue(DISTANCE) == 7) {
                worldIn.addFreshEntity(new FallingBlockEntity(worldIn, (double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D, blockstate.setValue(WATERLOGGED, false)));
            } else {
                worldIn.destroyBlock(pos, true);
            }
        } else if (state != blockstate) {
            worldIn.setBlock(pos, blockstate, 3);
        }

    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return calculateDISTANCE(worldIn, pos) < 7;
    }

    private boolean shouldBeBOTTOM(IBlockReader blockReader, BlockPos pos, int DISTANCE) {
        return DISTANCE > 0 && blockReader.getBlockState(pos.below()).getBlock() != this;
    }

    @Override
    public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!worldIn.isClientSide) {
            worldIn.getBlockTicks().scheduleTick(pos, this, 1);
        }

    }
}
