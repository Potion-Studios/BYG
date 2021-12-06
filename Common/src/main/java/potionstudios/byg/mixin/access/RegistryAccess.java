package potionstudios.byg.mixin.access;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.Supplier;

@Mixin(Registry.class)
public interface RegistryAccess {

    @Invoker
    static <T> Registry<T> invokeRegisterSimple(ResourceKey<? extends Registry<T>> registryKey, Supplier<T> supplier) {
        throw new Error("Mixin did not apply!");
    }
}