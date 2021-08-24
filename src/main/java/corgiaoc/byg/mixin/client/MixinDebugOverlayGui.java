package corgiaoc.byg.mixin.client;

import net.minecraft.client.gui.components.DebugScreenOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(DebugScreenOverlay.class)
public class MixinDebugOverlayGui {

    @Inject(method = "getSystemInformation", at = @At("RETURN"))
    private void modifyTagList(CallbackInfoReturnable<List<String>> cir) {
        cir.getReturnValue().removeIf(s -> s.contains("#byg:ground_"));
    }
}
