package potionstudios.byg;

import com.google.auto.service.AutoService;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import potionstudios.byg.registration.BygRegistrationProvider;
import potionstudios.byg.registration.BygRegistryObject;

import java.util.function.Supplier;

@AutoService(BygRegistrationProvider.class)
public class FabricRegistrationProvider implements BygRegistrationProvider {

    @Override
    @SuppressWarnings("unchecked")
    public <T> BygRegistryObject<T> register(ResourceKey<? extends Registry<T>> key, String name, Supplier<? extends T> supplier) {
        final var rl = BYG.createLocation(name);
        final var registry = (Registry<T>) Registry.REGISTRY.get(key.location());
        if (registry == null) {
            throw new RuntimeException("Registry with name " + key.location() + " was not found!");
        }
        final var obj = Registry.register(registry, rl, supplier.get());
        return new BygRegistryObject<T>() {
            @Override
            public ResourceKey<? extends Registry<T>> getResourceKey() {
                return key;
            }

            @Override
            public ResourceLocation getName() {
                return rl;
            }

            @Override
            public T get() {
                return obj;
            }
        };
    }
}
