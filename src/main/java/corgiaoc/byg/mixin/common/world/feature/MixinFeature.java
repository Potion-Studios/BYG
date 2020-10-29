package corgiaoc.byg.mixin.common.world.feature;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Feature.class)
public class MixinFeature {
    @Inject(at = @At("RETURN"), method = "isSoil(Lnet/minecraft/block/Block;)Z", cancellable = true)
    private static void isSoil(Block block, CallbackInfoReturnable<Boolean> cir) {
        if (block == BYGBlocks.GLOWCELIUM || block == BYGBlocks.PEAT ||
                block == BYGBlocks.MEADOW_GRASSBLOCK || block == BYGBlocks.OVERGROWN_DACITE || block == BYGBlocks.OVERGROWN_STONE ||
                block == BYGBlocks.PODZOL_DACITE || block == BYGBlocks.OVERGROWN_NETHERRACK || block == BYGBlocks.SYTHIAN_NYLIUM ||
                block == BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE || block == BYGBlocks.ETHER_PHYLIUM || block == BYGBlocks.ETHER_SOIL || block == BYGBlocks.NIGHTSHADE_PHYLIUM) {
            cir.setReturnValue(true);
        }
    }
}