package potionstudios.byg.registration;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.apache.commons.compress.utils.Lists;

import java.util.ServiceLoader;
import java.util.function.Supplier;

/**
 * This class is loaded by {@link java.util.ServiceLoader Service Loaders}, and it provides
 * the methods used for BYG registration.
 */
public interface BygRegistrationProvider {

    /**
     * The singleton instance of the {@link BygRegistrationProvider}. This is different on each loader.
     */
    BygRegistrationProvider INSTANCE = Util.make(() -> {
        final var loader = ServiceLoader.load(BygRegistrationProvider.class);
        final var providers = Lists.newArrayList(loader.iterator());
        if (providers.isEmpty()) {
            throw new RuntimeException("No BygRegistrationProvider was found on the classpath!");
        } else if (providers.size() > 1) {
            throw new RuntimeException("More than one BygRegistrationProvider was found on the classpath!");
        }
        return providers.get(0);
    });

    /**
     * Registers an object.
     *
     * @param key      the {@link ResourceKey} of the registry
     * @param name     the name of the object
     * @param supplier a supplier of the object to register
     * @param <T>      the type of the object
     * @return a wrapper containing the lazy registered object. <strong>Calling {@link Supplier#get() get} too early
     * on the wrapper might result in crashes!</strong>
     */
    <T> BygRegistryObject<T> register(ResourceKey<? extends Registry<T>> key, String name, Supplier<? extends T> supplier);

    /**
     * Registers an object. The result will be unsafely cast to the type {@code Z}.
     *
     * @param key      the {@link ResourceKey} of the registry
     * @param name     the name of the object
     * @param supplier a supplier of the object to register
     * @param <T>      the type of the object
     * @param <Z>      the type of the result to cast to
     * @return wrapper containing the lazy registered object. <strong>Calling {@link Supplier#get() get} too early
     * on the wrapper might result in crashes!</strong>
     */
    @SuppressWarnings("unchecked")
    default <T, Z> BygRegistryObject<Z> registerUnsafeResult(ResourceKey<? extends Registry<T>> key, String name, Supplier<? extends T> supplier) {
        return (BygRegistryObject<Z>) register(key, name, supplier);
    }
}
