package corgiaoc.byg.mixin.common.block;

import corgiaoc.byg.util.MLBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BushBlock.class)
public class PlantBlockMixin {
    @Inject(at = @At("RETURN"), method = "mayPlaceOn", cancellable = true)
    private void isBYGDirt(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if (blockState.is(MLBlockTags.DIRT)) {
            cir.setReturnValue(true);
        }
    }
}