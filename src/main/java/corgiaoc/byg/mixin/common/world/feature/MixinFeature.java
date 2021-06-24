package corgiaoc.byg.mixin.common.world.feature;

import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Feature.class)
public class MixinFeature {
    @Inject(at = @At("RETURN"), method = "isSoil(Lnet/minecraft/block/BlockState;)Z", cancellable = true)
    private static void isSoil(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.isIn(FabricTags.DIRT))
            cir.setReturnValue(true);
    }
}