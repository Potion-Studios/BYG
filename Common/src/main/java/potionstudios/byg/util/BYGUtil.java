package potionstudios.byg.util;


import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BYGUtil {

    public static final ResourceKey<Biome> EMPTY = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(""));

    public static final Codec<ResourceKey<Biome>> BIOME_KEY = ResourceLocation.CODEC.xmap(resourceLocation -> ResourceKey.create(Registry.BIOME_REGISTRY, resourceLocation), ResourceKey::location);


    /*
     * Part of the Cyanide mod.
     * Licensed under MIT. See the project LICENSE.txt for details.
     */
    public static final ThreadLocal<RegistryAccess> CAPTURED_REGISTRY_ACCESS = ThreadLocal.withInitial(() -> null);

    public static void captureRegistryAccess(RegistryAccess registryAccess) {
        CAPTURED_REGISTRY_ACCESS.set(registryAccess);
    }
}
