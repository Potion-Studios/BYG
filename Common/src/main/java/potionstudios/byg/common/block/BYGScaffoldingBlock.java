package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.ScaffoldingBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

import java.util.Random;

public class BYGScaffoldingBlock extends ScaffoldingBlock implements SimpleWaterloggedBlock {

    protected BYGScaffoldingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return useContext.getItemInHand().getItem() == this.asItem();
    }

    public static int calculateDISTANCE(BlockGetter blockReader, BlockPos pos) {
        BlockPos.MutableBlockPos blockpos$mutable = (new BlockPos.MutableBlockPos().set(pos)).move(Direction.DOWN);
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
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Level world = context.getLevel();
        int i = calculateDISTANCE(world, blockpos);
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(world.getFluidState(blockpos).getType() == Fluids.WATER)).setValue(DISTANCE, Integer.valueOf(i)).setValue(BOTTOM, Boolean.valueOf(this.shouldBeBOTTOM(world, blockpos, i)));
    }

    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        int i = calculateDISTANCE(worldIn, pos);
        BlockState blockstate = state.setValue(DISTANCE, Integer.valueOf(i)).setValue(BOTTOM, Boolean.valueOf(this.shouldBeBOTTOM(worldIn, pos, i)));
        if (blockstate.getValue(DISTANCE) == 7) {
            if (state.getValue(DISTANCE) == 7) {
                worldIn.addFreshEntity(FallingBlockEntity.fall(worldIn, pos, blockstate.setValue(WATERLOGGED, false)));
            } else {
                worldIn.destroyBlock(pos, true);
            }
        } else if (state != blockstate) {
            worldIn.setBlock(pos, blockstate, 3);
        }

    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        return calculateDISTANCE(worldIn, pos) < 7;
    }

    private boolean shouldBeBOTTOM(BlockGetter blockReader, BlockPos pos, int DISTANCE) {
        return DISTANCE > 0 && blockReader.getBlockState(pos.below()).getBlock() != this;
    }

    @Override
    public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!worldIn.isClientSide) {
            worldIn.scheduleTick(pos, this, 1);
        }

    }
}
