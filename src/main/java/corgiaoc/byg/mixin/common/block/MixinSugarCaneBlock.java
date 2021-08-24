package corgiaoc.byg.mixin.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SugarCaneBlock.class)
public class MixinSugarCaneBlock {



    @Inject(method = "canSurvive", at = @At(value = "INVOKE", shift = At.Shift.BEFORE, target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z", ordinal = 0), cancellable = true)
    private void addBYGBlocks(BlockState state, LevelReader worldIn, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockState blockStateDown = worldIn.getBlockState(pos.below());
        if(blockStateDown.getBlock().is(BlockTags.SAND)) {
            BlockPos blockpos = pos.below();

            for(Direction direction : Direction.Plane.HORIZONTAL) {
                BlockState blockstate1 = worldIn.getBlockState(blockpos.relative(direction));
                FluidState fluidstate = worldIn.getFluidState(blockpos.relative(direction));
                if (fluidstate.is(FluidTags.WATER) || blockstate1.is(Blocks.FROSTED_ICE)) {
                    cir.setReturnValue(true);
                }
            }
        }
    }
}
