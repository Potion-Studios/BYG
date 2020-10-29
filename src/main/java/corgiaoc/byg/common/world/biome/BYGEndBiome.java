package corgiaoc.byg.common.world.biome;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class BYGEndBiome {
    public static final List<BYGEndBiome> BYG_END_BIOMES = new ArrayList<>();
    private final Biome biome;

    public BYGEndBiome(Biome.Weather climate, Biome.Category category, float depth, float scale, BiomeEffects effects, GenerationSettings biomeGenerationSettings, SpawnSettings mobSpawnInfo) {
        biome = new Biome(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        BYG_END_BIOMES.add(this);
    }

    public BYGEndBiome(Biome.Builder builder) {
        this.biome = builder.build();
        BYG_END_BIOMES.add(this);
    }

    public BYGEndBiome(Biome biome) {
        this.biome = biome;
        BYG_END_BIOMES.add(this);
    }

    public Biome getBiome() {
        return this.biome;
    }

    public Object getBiomeDictionary() {
        return null; //{BiomeDictionary.Type.END};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.of(Registry.BIOME_KEY, Objects.requireNonNull(BuiltinRegistries.BIOME.getId(this.biome)));
    }
}
