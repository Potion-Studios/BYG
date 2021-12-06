package potionstudios.byg.util;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BiomeKeyUtil {

    public static final ResourceKey<Biome> EMPTY = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(""));

    public static final Codec<ResourceKey<Biome>> BIOME_KEY = ResourceLocation.CODEC.xmap(resourceLocation -> ResourceKey.create(Registry.BIOME_REGISTRY, resourceLocation), ResourceKey::location);
}
