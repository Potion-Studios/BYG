package potionstudios.byg.mixin;

import net.minecraft.core.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.BYGFabric;

@Mixin(Registry.class)
public class MixinRegistry {

    @Inject(method = "freezeBuiltins", at = @At("RETURN"))
    private static void byg_afterRegistriesFreeze(CallbackInfo ci) {
        BYGFabric.afterRegistriesFreeze();
    }
}