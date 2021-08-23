package corgiaoc.byg.mixin.client;

import corgiaoc.byg.client.textures.ColorManager;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemColors.class)
public class MixinItemColors {
    @Inject(method = "createDefault", at = @At("RETURN"))
    private static void addBYGItemColors(BlockColors blockColors, CallbackInfoReturnable<ItemColors> cir) {
        ColorManager.onItemColorsInit(blockColors, cir.getReturnValue());
    }
}
