package voronoiaoc.byg.mixin;

import net.minecraft.Bootstrap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import voronoiaoc.byg.BYG;

@Mixin(Bootstrap.class)
public class MixinBootstrap {

    @Inject(at = @At("TAIL"), method = "initialize()V")
    private static void addBiomeIDsServerSide(CallbackInfo ci) {
        BYG.bootStrap();
    }
}
