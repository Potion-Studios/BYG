package voronoiaoc.byg.common.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.INoiseRandom;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BYGBiomeBuilder extends Biome.Builder {
    public static List<BYGBiomeBuilder> biomeBuilders = new ArrayList<>();
    private final Biome biome;
    

    public BYGBiomeBuilder(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience ambiance, BiomeGenerationSettings generationSettings, MobSpawnInfo spawnInfo) {
        
        
        
        biome = new Biome(climate, category, depth, scale, ambiance, generationSettings, spawnInfo);

        biomeBuilders.add(this);
    }


    public Biome getBiome() {
        return biome;
    }

    @Nullable
    public Biome getHill(INoiseRandom rand) {
        return null;
    }

}
