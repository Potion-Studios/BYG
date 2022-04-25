package potionstudios.byg.mixin.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.common.block.AbstractBarrelCactusBlock;
import potionstudios.byg.common.block.CarvedBarrelCactusBlock;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;


@Mixin(PointedDripstoneBlock.class)
public class MixinPointedDripstoneBlock {

    private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);;

    @Inject(method = "findFillableCauldronBelowStalactiteTip", at = @At("HEAD"), cancellable = true)
    private static void addBYGCauldron(Level world, BlockPos pos, Fluid fluid, CallbackInfoReturnable<BlockPos> cir){
        Predicate<BlockState> predicate = (p_154162_) -> p_154162_.getBlock() instanceof CarvedBarrelCactusBlock && ((CarvedBarrelCactusBlock)p_154162_.getBlock()).canReceiveStalactiteDrip(fluid);
        BiPredicate<BlockPos, BlockState> $$4 = ($$1x, $$2x) -> canDripThrough(world, $$1x, $$2x);
        cir.setReturnValue(findBlockVertical(world, pos, Direction.DOWN.getAxisDirection(), $$4, predicate, 11).orElse(null));

    }

    private static boolean canDripThrough(BlockGetter $$0, BlockPos $$1, BlockState $$2) {
        if ($$2.isAir()) {
            return true;
        } else if ($$2.isSolidRender($$0, $$1)) {
            return false;
        } else if (!$$2.getFluidState().isEmpty()) {
            return false;
        } else {
            VoxelShape $$3 = $$2.getCollisionShape($$0, $$1);
            return !Shapes.joinIsNotEmpty(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, $$3, BooleanOp.AND);
        }
    }

    private static Optional<BlockPos> findBlockVertical(LevelAccessor p_202007_, BlockPos p_202008_, Direction.AxisDirection p_202009_, BiPredicate<BlockPos, BlockState> p_202010_, Predicate<BlockState> p_202011_, int p_202012_) {
        Direction direction = Direction.get(p_202009_, Direction.Axis.Y);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = p_202008_.mutable();

        for(int i = 1; i < p_202012_; ++i) {
            blockpos$mutableblockpos.move(direction);
            BlockState blockstate = p_202007_.getBlockState(blockpos$mutableblockpos);
            if (p_202011_.test(blockstate)) {
                return Optional.of(blockpos$mutableblockpos.immutable());
            }

            if (p_202007_.isOutsideBuildHeight(blockpos$mutableblockpos.getY()) || !p_202010_.test(blockpos$mutableblockpos, blockstate)) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }
}
