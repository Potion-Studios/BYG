package potionstudios.byg;

import com.google.auto.service.AutoService;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import potionstudios.byg.registration.BygRegistrationProvider;
import potionstudios.byg.registration.BygRegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@AutoService(BygRegistrationProvider.class)
public class ForgeRegistrationProvider implements BygRegistrationProvider {

    static final Map<ResourceKey<?>, DeferredRegister<?>> registerMap = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <T> BygRegistryObject<T> register(ResourceKey<? extends Registry<T>> key, String name, Supplier<? extends T> supplier) {
        final var register = (DeferredRegister<T>) registerMap.computeIfAbsent(key, k -> DeferredRegister.create(key, BYG.MOD_ID));
        final var obj = register.<T>register(name, supplier);
        return new BygRegistryObject<T>() {
            @Override
            public ResourceKey<? extends Registry<T>> getResourceKey() {
                return key;
            }

            @Override
            public ResourceLocation getName() {
                return obj.getId();
            }

            @Override
            public T get() {
                return obj.get();
            }
        };
    }
}
