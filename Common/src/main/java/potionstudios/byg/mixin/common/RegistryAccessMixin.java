/*
 * Part of the Cyanide mod.
 * Licensed under MIT. See the project LICENSE.txt for details.
 */

package potionstudios.byg.mixin.common;

import net.minecraft.core.RegistryAccess;
import net.minecraft.server.WorldStem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.util.BYGUtil;

@Mixin(WorldStem.class)
public abstract class RegistryAccessMixin {

    @Inject(method = "registryAccess", at = @At("RETURN"))
    private void captureCurrentRegistryAccess(CallbackInfoReturnable<RegistryAccess.Frozen> cir) {
        BYGUtil.captureRegistryAccess(cir.getReturnValue());
    }
}