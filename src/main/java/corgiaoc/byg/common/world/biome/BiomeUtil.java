package corgiaoc.byg.common.world.biome;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class BiomeUtil {

    public static int calcSkyColor(float f) {
        float g = f / 3.0F;
        g = MathHelper.clamp(g, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
    }

    public static boolean isOcean(Biome biome) {
        return biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.WARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.LUKEWARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.COLD_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.FROZEN_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_WARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_LUKEWARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_COLD_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_FROZEN_OCEAN);
    }
}