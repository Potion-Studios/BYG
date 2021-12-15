/*
 * Part of the Cyanide mod.
 * Licensed under MIT. See the project LICENSE.txt for details.
 */

package potionstudios.byg.mixin.common;

import net.minecraft.core.RegistryAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.util.BYGUtil;

@Mixin(RegistryAccess.class)
public abstract class RegistryAccessMixin {

    @Inject(method = "builtin", at = @At("RETURN"))
    private static void captureCurrentRegistryAccess(CallbackInfoReturnable<RegistryAccess.RegistryHolder> cir) {
        BYGUtil.captureRegistryAccess(cir.getReturnValue());
    }
}