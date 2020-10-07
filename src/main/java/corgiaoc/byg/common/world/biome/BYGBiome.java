package corgiaoc.byg.common.world.biome;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class BYGBiome {
    public static List<BYGBiome> bygBiomes = new ArrayList<>();
    private final Biome biome;

    public BYGBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        biome = new Biome(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        bygBiomes.add(this);
    }

    public BYGBiome(Biome.Builder builder) {
        biome = builder.build();
        bygBiomes.add(this);
    }

    public Biome getBiome() {
        return this.biome;
    }

    public Biome getRiver() {
        return WorldGenRegistries.BIOME.getOrThrow(Biomes.RIVER);
    }

    @Nullable
    public Biome getHills(INoiseRandom random) {
        return null;
    }

    @Nullable
    public Biome getEdges(INoiseRandom rand, Biome north, Biome west, Biome south, Biome east) {
        return null;
    }


    public HashMap<Biome, Integer> getHills() {
        return new HashMap<>();
    }

    public HashMap<Biome, Integer> getEdges() {
        return new HashMap<>();
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(this.biome)));
    }
}
