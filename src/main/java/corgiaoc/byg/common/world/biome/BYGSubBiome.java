package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.config.json.biomedata.OverworldSubBiomeData;
import corgiaoc.byg.mixin.access.BiomeAccess;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;

import java.util.*;

@SuppressWarnings("deprecation")
public class BYGSubBiome {
    public static final List<BYGSubBiome> BYG_SUB_BIOMES = new ArrayList<>();
    private final Biome biome;

    public BYGSubBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        biome = BiomeAccess.create(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        BYG_SUB_BIOMES.add(this);
    }

    public BYGSubBiome(Biome.Builder builder) {
        this.biome = builder.build();
        BYG_SUB_BIOMES.add(this);
    }

    public BYGSubBiome(Biome biome) {
        this.biome = biome;
        BYG_SUB_BIOMES.add(this);
    }

    @Nullable
    public Biome getBeach() {
        return WorldGenRegistries.BIOME.getOrThrow(Biomes.BEACH);
    }

    @Nullable
    public Biome getEdge() {
        return null;
    }

    public Biome getBiome() {
        return this.biome;
    }

    public Biome getRiver() {
        return WorldGenRegistries.BIOME.getOrThrow(Biomes.RIVER);
    }

    public String[] getBiomeDictionary() {
        return new String[]{"OVERWORLD"};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(this.biome)));
    }

    public static BiomeDataHolders.OverworldSubBiomeDataHolder extractDefaultHolder() {
        Map<ResourceLocation, OverworldSubBiomeData> biomeData = new HashMap<>();
        for (BYGSubBiome bygBiome : BYG_SUB_BIOMES) {
            biomeData.put(WorldGenRegistries.BIOME.getKey(bygBiome.getBiome()), new OverworldSubBiomeData(Arrays.asList(bygBiome.getBiomeDictionary()), bygBiome.getEdge() != null ? WorldGenRegistries.BIOME.getKey(bygBiome.getEdge()) : new ResourceLocation(""), bygBiome.getBeach() != null ? WorldGenRegistries.BIOME.getKey(bygBiome.getBeach()) : new ResourceLocation(""), WorldGenRegistries.BIOME.getKey(bygBiome.getRiver())));
        }
        return new BiomeDataHolders.OverworldSubBiomeDataHolder(biomeData);
    }
}
