package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.config.json.biomedata.OverworldSubBiomeData;
import corgiaoc.byg.mixin.access.BiomeAccess;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;

import java.util.*;

@SuppressWarnings("deprecation")
public class BYGSubBiome {
    public static final List<BYGSubBiome> BYG_SUB_BIOMES = new ArrayList<>();
    private final Biome biome;

    public BYGSubBiome(Biome.ClimateSettings climate, Biome.BiomeCategory category, float depth, float scale, BiomeSpecialEffects effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnSettings mobSpawnInfo) {
        biome = BiomeAccess.create(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        BYG_SUB_BIOMES.add(this);
    }

    public BYGSubBiome(Biome.BiomeBuilder builder) {
        this.biome = builder.build();
        BYG_SUB_BIOMES.add(this);
    }

    public BYGSubBiome(Biome biome) {
        this.biome = biome;
        BYG_SUB_BIOMES.add(this);
    }

    @Nullable
    public Biome getBeach() {
        return BuiltinRegistries.BIOME.getOrThrow(Biomes.BEACH);
    }

    @Nullable
    public Biome getEdge() {
        return null;
    }

    public Biome getBiome() {
        return this.biome;
    }

    public Biome getRiver() {
        return BuiltinRegistries.BIOME.getOrThrow(Biomes.RIVER);
    }

    public String[] getBiomeDictionary() {
        return new String[]{"OVERWORLD"};
    }

    public ResourceKey<Biome> getKey() {
        return ResourceKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(BuiltinRegistries.BIOME.getKey(this.biome)));
    }

    public static BiomeDataHolders.OverworldSubBiomeDataHolder extractDefaultHolder() {
        Map<ResourceLocation, OverworldSubBiomeData> biomeData = new HashMap<>();
        for (BYGSubBiome bygBiome : BYG_SUB_BIOMES) {
            biomeData.put(BuiltinRegistries.BIOME.getKey(bygBiome.getBiome()), new OverworldSubBiomeData(Arrays.asList(bygBiome.getBiomeDictionary()), bygBiome.getEdge() != null ? BuiltinRegistries.BIOME.getKey(bygBiome.getEdge()) : new ResourceLocation(""), bygBiome.getBeach() != null ? BuiltinRegistries.BIOME.getKey(bygBiome.getBeach()) : new ResourceLocation(""), BuiltinRegistries.BIOME.getKey(bygBiome.getRiver())));
        }
        return new BiomeDataHolders.OverworldSubBiomeDataHolder(biomeData);
    }
}
