package potionstudios.byg.mixin.access;

import com.mojang.serialization.Lifecycle;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Registry.class)
public interface RegistryAccess {

    @Invoker("registerSimple")
    static <T> Registry<T> byg_invokeRegisterSimple(ResourceKey<? extends Registry<T>> resourceKey, Lifecycle lifecycle, Registry.RegistryBootstrap<T> bootstrap) {
        throw new Error("Mixin did not apply!");
    }
}