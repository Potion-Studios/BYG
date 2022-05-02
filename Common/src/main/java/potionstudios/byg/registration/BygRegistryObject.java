package potionstudios.byg.registration;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

/**
 * Represents a lazy wrapper for BYG registry object.
 *
 * @param <T> the type of the object
 */
public interface BygRegistryObject<T> extends Supplier<T> {

    /**
     * Gets the {@link ResourceKey} of the registry of the object wrapped.
     * @return the {@link ResourceKey} of the registry
     */
    ResourceKey<? extends Registry<T>> getResourceKey();

    /**
     * Gets the name of the object.
     * @return the name of the object
     */
    ResourceLocation getName();

    /**
     * Gets the object behind this wrapper. Calling this method too early
     * might result in crashes.
     * @return the object behind this wrapper
     */
    @Override
    T get();
}
