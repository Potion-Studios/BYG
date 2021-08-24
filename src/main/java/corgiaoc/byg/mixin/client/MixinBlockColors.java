package corgiaoc.byg.mixin.client;

import corgiaoc.byg.client.textures.ColorManager;
import net.minecraft.client.color.block.BlockColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockColors.class)
public class MixinBlockColors {

    @Inject(method = "createDefault", at = @At("RETURN"))
    private static void addBYGBlockColors(CallbackInfoReturnable<BlockColors> cir) {
        ColorManager.onBlockColorsInit(cir.getReturnValue());
    }
}
