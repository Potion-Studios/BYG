package potionstudios.byg.registration;

import com.google.common.collect.Lists;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Supplier;

/**
 * Utility class for multiloader registration.
 *
 * @param <T> the type of the objects that this class registers
 */
public interface RegistrationProvider<T> {

    /**
     * Gets a provider for specified {@code modId} and {@code resourceKey}. <br>
     * It is <i>recommended</i> to store the resulted provider in a {@code static final} field to
     * the {@link Factory#INSTANCE factory} creating multiple providers for the same resource key and mod id.
     *
     * @param resourceKey the {@link ResourceKey} of the registry of the provider
     * @param modId       the mod id that the provider will register objects for
     * @param <T>         the type of the provider
     * @return the provider
     */
    static <T> RegistrationProvider<T> get(ResourceKey<? extends Registry<T>> resourceKey, String modId) {
        return Factory.INSTANCE.create(resourceKey, modId);
    }

    /**
     * Gets a provider for specified {@code modId} and {@code registry}. <br>
     * It is <i>recommended</i> to store the resulted provider in a {@code static final} field to
     * the {@link Factory#INSTANCE factory} creating multiple providers for the same resource key and mod id.
     *
     * @param registry the {@link Registry} of the provider
     * @param modId    the mod id that the provider will register objects for
     * @param <T>      the type of the provider
     * @return the provider
     */
    static <T> RegistrationProvider<T> get(Registry<T> registry, String modId) {
        return Factory.INSTANCE.create(registry, modId);
    }

    /**
     * Registers an object.
     *
     * @param name     the name of the object
     * @param supplier a supplier of the object to register
     * @param <I>      the type of the object
     * @return a wrapper containing the lazy registered object. <strong>Calling {@link RegistryObject#get() get} too early
     * on the wrapper might result in crashes!</strong>
     */
    <I extends T> RegistryObject<I> register(String name, Supplier<? extends I> supplier);

    /**
     * Gets all the objects currently registered.
     *
     * @return an <strong>immutable</strong> view of all the objects currently registered
     */
    Collection<RegistryObject<T>> getEntries();

    /**
     * Gets the mod id that this provider registers objects for.
     *
     * @return the mod id
     */
    String getModId();

    /**
     * Factory class for {@link RegistrationProvider registration providers}. <br>
     * This class is loaded using {@link java.util.ServiceLoader Service Loaders}, and only one
     * should exist per mod loader.
     */
    interface Factory {

        /**
         * The singleton instance of the {@link Factory}. This is different on each loader.
         */
        Factory INSTANCE = Util.make(() -> {
            final var loader = ServiceLoader.load(Factory.class);
            final var providers = Lists.newArrayList(loader.iterator());
            if (providers.isEmpty()) {
                throw new RuntimeException("No BygRegistrationProvider Factory was found on the classpath!");
            } else if (providers.size() > 1) {
                throw new RuntimeException("More than one BygRegistrationProvider Factory was found on the classpath!");
            }
            return providers.get(0);
        });

        /**
         * Creates a {@link RegistrationProvider}.
         *
         * @param resourceKey the {@link ResourceKey} of the registry to create this provider for
         * @param modId       the mod id for which the provider will register objects
         * @param <T>         the type of the provider
         * @return the provider
         */
        <T> RegistrationProvider<T> create(ResourceKey<? extends Registry<T>> resourceKey, String modId);

        /**
         * Creates a {@link RegistrationProvider}.
         *
         * @param registry the {@link Registry} to create this provider for
         * @param modId    the mod id for which the provider will register objects
         * @param <T>      the type of the provider
         * @return the provider
         */
        default <T> RegistrationProvider<T> create(Registry<T> registry, String modId) {
            return create(registry.key(), modId);
        }
    }
}