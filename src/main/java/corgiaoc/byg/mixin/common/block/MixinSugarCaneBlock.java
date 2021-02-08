package corgiaoc.byg.mixin.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SugarCaneBlock.class)
public class MixinSugarCaneBlock {



    @Inject(method = "isValidPosition", at = @At(value = "INVOKE", shift = At.Shift.BEFORE, target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/block/Block;)Z", ordinal = 0), cancellable = true)
    private void addBYGBlocks(BlockState state, IWorldReader worldIn, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockState blockStateDown = worldIn.getBlockState(pos.down());
        if(blockStateDown.getBlock().isIn(BlockTags.SAND)) {
            BlockPos blockpos = pos.down();

            for(Direction direction : Direction.Plane.HORIZONTAL) {
                BlockState blockstate1 = worldIn.getBlockState(blockpos.offset(direction));
                FluidState fluidstate = worldIn.getFluidState(blockpos.offset(direction));
                if (fluidstate.isTagged(FluidTags.WATER) || blockstate1.isIn(Blocks.FROSTED_ICE)) {
                    cir.setReturnValue(true);
                }
            }
        }
    }
}
