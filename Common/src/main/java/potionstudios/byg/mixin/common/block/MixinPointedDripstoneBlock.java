package potionstudios.byg.mixin.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.CarvedBarrelCactusBlock;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Mixin(PointedDripstoneBlock.class)
public class MixinPointedDripstoneBlock {

    private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

    @Shadow
    private static boolean canDripThrough(BlockGetter block, BlockPos pos, BlockState state) {
        if (state.isAir()) {
            return true;
        } else if (state.isSolidRender(block, pos)) {
            return false;
        } else if (!state.getFluidState().isEmpty()) {
            return false;
        } else {
            VoxelShape shape = state.getCollisionShape(block, pos);
            return !Shapes.joinIsNotEmpty(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, shape, BooleanOp.AND);
        }
    }

    @Inject(method = "findFillableCauldronBelowStalactiteTip", at = @At(value = "HEAD"), cancellable = true)
    private static void addBYGCauldron(Level world, BlockPos pos, Fluid fluid, CallbackInfoReturnable<BlockPos> cir) {
        if (world.getBlockState(pos).is(BYGBlocks.CARVED_BARREL_CACTUS.get())) {
            Predicate<BlockState> predicate = (block) -> block.getBlock() instanceof CarvedBarrelCactusBlock && ((CarvedBarrelCactusBlock) block.getBlock()).canReceiveStalactiteDrip(fluid);
            BiPredicate<BlockPos, BlockState> posState = (blockPos, state) -> canDripThrough(world, blockPos, state);
            cir.setReturnValue(findBlockVertical(world, pos, Direction.DOWN.getAxisDirection(), posState, predicate, 11).orElse(null));
        }
    }

    @Shadow
    private static Optional<BlockPos> findBlockVertical(LevelAccessor level, BlockPos pos, Direction.AxisDirection direction, BiPredicate<BlockPos, BlockState> posState, Predicate<BlockState> state, int j) {
        throw new UnsupportedOperationException("Mixin did not apply");
    }
}
