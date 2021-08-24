package corgiaoc.byg.common.world.biome;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public class BiomeUtil {

    public static int calcSkyColor(float f) {
        float g = f / 3.0F;
        g = Mth.clamp(g, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
    }

    public static boolean isOcean(Biome biome) {
        return biome == BuiltinRegistries.BIOME.getOrThrow(Biomes.WARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(Biomes.LUKEWARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(Biomes.OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(Biomes.COLD_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(Biomes.FROZEN_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(Biomes.DEEP_WARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(Biomes.DEEP_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(Biomes.DEEP_COLD_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(Biomes.DEEP_FROZEN_OCEAN);
    }
}