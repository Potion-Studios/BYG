package corgiaoc.byg.common.world.biome;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class BiomeUtil {

    public static int calcSkyColor(float f) {
        float g = f / 3.0F;
        g = MathHelper.clamp(g, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
    }

    public static boolean isOcean(Biome biome) {
        return biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.WARM_OCEAN) || biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.LUKEWARM_OCEAN) || biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.OCEAN) || biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.COLD_OCEAN) || biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.FROZEN_OCEAN) || biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.DEEP_WARM_OCEAN) || biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN) || biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.DEEP_OCEAN) || biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.DEEP_COLD_OCEAN) || biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.DEEP_FROZEN_OCEAN);
    }
}