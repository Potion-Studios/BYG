package potionstudios.byg.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.BYG;

@Mixin(value = ForgeRegistry.class, remap = false)
public class MixinForgeRegistry<V extends IForgeRegistryEntry<V>> {

    @Shadow @Final private ResourceLocation defaultKey;

    @Inject(method = "getKey(Lnet/minecraftforge/registries/IForgeRegistryEntry;)Lnet/minecraft/resources/ResourceLocation;", cancellable = true, at = @At("HEAD"), remap = false)
    private void useRegistryNameField(V value, CallbackInfoReturnable<ResourceLocation> cir) {
        if (cir.getReturnValue() == null || cir.getReturnValue().equals(this.defaultKey)) {
            final ResourceLocation registryName = value.getRegistryName();
            if (registryName != null && registryName.getNamespace().equals(BYG.MOD_ID)) {
                cir.setReturnValue(registryName);
            }
        }
    }
}
