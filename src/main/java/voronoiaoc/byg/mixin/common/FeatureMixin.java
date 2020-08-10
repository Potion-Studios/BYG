package voronoiaoc.byg.mixin.common;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.core.byglists.BYGBlockList;

@Mixin(Feature.class)
public class FeatureMixin {
    @Inject(at = @At("RETURN"), method = "isSoil(Lnet/minecraft/block/Block;)Z", cancellable = true)
    private static void isSoil(Block block, CallbackInfoReturnable<Boolean> cir) {
        if (block == BYGBlockList.GLOWCELIUM || block == BYGBlockList.PEAT ||
                block == BYGBlockList.MEADOW_GRASSBLOCK || block == BYGBlockList.OVERGROWN_DACITE || block == BYGBlockList.OVERGROWN_STONE ||
                block == BYGBlockList.PODZOL_DACITE || block == BYGBlockList.OVERGROWN_NETHERRACK || block == BYGBlockList.SYTHIAN_NYLIUM ||
                block == BYGBlockList.IVIS_PHYLIUM) {
            cir.setReturnValue(true);
        }
    }
}