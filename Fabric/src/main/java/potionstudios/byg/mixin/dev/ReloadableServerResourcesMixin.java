package potionstudios.byg.mixin.dev;

import net.minecraft.core.RegistryAccess;
import net.minecraft.server.ReloadableServerResources;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.util.FabricModPlatform;

@Mixin(ReloadableServerResources.class)
public class ReloadableServerResourcesMixin {

    @Inject(at = @At("TAIL"), method = "updateRegistryTags(Lnet/minecraft/core/RegistryAccess;)V")
    private void byg$updateRegistryTags(RegistryAccess registryAccess, CallbackInfo ci) {
        FabricModPlatform.TAGS_UPDATED_EVENT.invoker().onTagsUpdated(registryAccess);
    }

}
