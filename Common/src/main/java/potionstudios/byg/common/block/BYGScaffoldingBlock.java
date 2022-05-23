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
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BYGScaffoldingBlock extends ScaffoldingBlock implements SimpleWaterloggedBlock {

    protected BYGScaffoldingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canBeReplaced(BlockState state, @NotNull BlockPlaceContext useContext) {
        return useContext.getItemInHand().getItem() == this.asItem();
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext $$0) {
        BlockPos $$1 = $$0.getClickedPos();
        Level $$2 = $$0.getLevel();
        int $$3 = getBlockDistance($$2, $$1);
        return (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(WATERLOGGED, $$2.getFluidState($$1).getType() == Fluids.WATER)).setValue(DISTANCE, $$3)).setValue(BOTTOM, this.isBottom($$2, $$1, $$3));
    }

    @Override
    public void tick(@NotNull BlockState $$0, ServerLevel $$1, BlockPos $$2, Random $$3) {
        int $$4 = getBlockDistance($$1, $$2);
        BlockState $$5 = (BlockState)((BlockState)$$0.setValue(DISTANCE, $$4)).setValue(BOTTOM, this.isBottom($$1, $$2, $$4));
        if ((Integer)$$5.getValue(DISTANCE) == 7) {
            if ((Integer)$$0.getValue(DISTANCE) == 7) {
                FallingBlockEntity.fall($$1, $$2, $$5);
            } else {
                $$1.destroyBlock($$2, true);
            }
        } else if ($$0 != $$5) {
            $$1.setBlock($$2, $$5, 3);
        }

    }

    @Override
    public boolean canSurvive(BlockState $$0, LevelReader $$1, BlockPos $$2) {
        return getBlockDistance($$1, $$2) < 7;
    }

    @Override
    public void onPlace(BlockState $$0, Level $$1, BlockPos $$2, BlockState $$3, boolean $$4) {
        if (!$$1.isClientSide) {
            $$1.scheduleTick($$2, this, 1);
        }

    }

    public boolean isBottom(BlockGetter $$0, BlockPos $$1, int $$2) {
        return $$2 > 0 && !$$0.getBlockState($$1.below()).is(BYGBlockTags.SCAFFOLDING);
    }

    public static int getBlockDistance(@NotNull BlockGetter $$0, @NotNull BlockPos $$1) {
        BlockPos.MutableBlockPos $$2 = $$1.mutable().move(Direction.DOWN);
        BlockState $$3 = $$0.getBlockState($$2);
        int $$4 = 7;
        if ($$3.is(BYGBlockTags.SCAFFOLDING)) {
            $$4 = $$3.getValue(DISTANCE);
        } else if ($$3.isFaceSturdy($$0, $$2, Direction.UP)) {
            return 0;
        }

        for (Direction $$5 : Direction.Plane.HORIZONTAL) {
            BlockState $$6 = $$0.getBlockState($$2.setWithOffset($$1, $$5));
            if ($$6.is(BYGBlockTags.SCAFFOLDING)) {
                $$4 = Math.min($$4, $$6.getValue(DISTANCE) + 1);
                if ($$4 == 1) {
                    break;
                }
            }
        }

        return $$4;
    }
}
