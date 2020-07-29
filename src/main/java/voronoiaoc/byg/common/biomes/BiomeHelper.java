package voronoiaoc.byg.common.biomes;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

import java.util.Optional;

public class BiomeHelper extends Biome {
    public BiomeHelper(Biome.Weather weather, Category category, float f, float g, BiomeEffects biomeEffects, GenerationSettings generationSettings, SpawnSettings spawnSettings, Optional<String> optional) {
        super(weather, category, f, g, biomeEffects, generationSettings, spawnSettings, optional);
    }

    public static int calcSkyColor(float f) {
        float g = f / 3.0F;
        g = MathHelper.clamp(g, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
    }
}
