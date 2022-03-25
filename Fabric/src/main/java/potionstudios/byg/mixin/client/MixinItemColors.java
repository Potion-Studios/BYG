package potionstudios.byg.mixin.client;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.client.textures.ColorManager;

@Mixin(ItemColors.class)
public class MixinItemColors {

    @Inject(method = "createDefault", at = @At("RETURN"))
    private static void addBYGItemColors(BlockColors blockColors, CallbackInfoReturnable<ItemColors> cir) {
        ColorManager.onItemColorsInit(blockColors, cir.getReturnValue());
    }
}