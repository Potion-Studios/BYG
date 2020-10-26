package corgiaoc.byg.common.world.biome;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class BYGNetherBiome {
    public static final List<BYGNetherBiome> BYG_NETHER_BIOMES = new ArrayList<>();
    private final Biome biome;

    public BYGNetherBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        biome = new Biome(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        BYG_NETHER_BIOMES.add(this);
    }

    public BYGNetherBiome(Biome.Builder builder) {
        this.biome = builder.build();
        BYG_NETHER_BIOMES.add(this);
    }

    public BYGNetherBiome(Biome biome) {
        this.biome = biome;
        BYG_NETHER_BIOMES.add(this);
    }

    public Biome getBiome() {
        return this.biome;
    }

    public BiomeDictionary.Type[] getBiomeDictionary() {
        return new BiomeDictionary.Type[]{BiomeDictionary.Type.NETHER};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, ForgeRegistries.BIOMES.getKey(this.biome));
    }
}
