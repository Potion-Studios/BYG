package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.config.json.biomedata.OverworldPrimaryBiomeData;
import corgiaoc.byg.mixin.access.BiomeAccess;
import corgiaoc.byg.mixin.access.WeightedListAccess;
import corgiaoc.byg.mixin.access.WeightedListEntryAccess;
import corgiaoc.byg.util.MLClimate;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.*;

import java.util.*;

@SuppressWarnings("deprecation")
public class BYGBiome {
    public static final List<BYGBiome> BYG_BIOMES = new ArrayList<>();
    private final Biome biome;

    public static final Map<ResourceLocation, WeightedList<ResourceLocation>> BIOME_TO_HILLS_LIST = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> BIOME_TO_BEACH_LIST = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> BIOME_TO_EDGE_LIST = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> BIOME_TO_RIVER_LIST = new HashMap<>();

    public BYGBiome(Biome.ClimateSettings climate, Biome.BiomeCategory category, float depth, float scale, BiomeSpecialEffects effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnSettings mobSpawnInfo) {
        biome = BiomeAccess.create(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        BYG_BIOMES.add(this);
    }

    public BYGBiome(Biome.BiomeBuilder builder) {
        this.biome = builder.build();
        BYG_BIOMES.add(this);
    }

    public BYGBiome(Biome biome) {
        this.biome = biome;
        BYG_BIOMES.add(this);
    }

    public Biome getBiome() {
        return this.biome;
    }

    public Biome getRiver() {
        return BuiltinRegistries.BIOME.getOrThrow(Biomes.RIVER);
    }

    public WeightedList<Biome> getHills() {
        return new WeightedList<>();
    }

    @Nullable
    public Biome getEdge() {
        return null;
    }

    @Nullable
    public Biome getBeach() {
        return BuiltinRegistries.BIOME.getOrThrow(Biomes.BEACH);
    }


    public String[] getBiomeDictionary() {
        return new String[]{"OVERWORLD"};
    }

    public MLClimate getClimate() {
        return MLClimate.WARM;
    }

    public int getWeight() {
        return 5;
    }

    public static BiomeDataHolders.OverworldPrimaryBiomeDataHolder extractDefaultHolder() {
        Map<ResourceLocation, OverworldPrimaryBiomeData> biomeData = new HashMap<>();
        for (BYGBiome bygBiome : BYG_BIOMES) {
            WeightedList<ResourceLocation> weightedListByLocation = new WeightedList<>();
            for (WeightedList.WeightedEntry<Biome> entry : ((WeightedListAccess<Biome>) bygBiome.getHills()).getEntries()) {
                weightedListByLocation.add(BuiltinRegistries.BIOME.getKey(entry.getData()), ((WeightedListEntryAccess) entry).getWeight());
            }

            biomeData.put(BuiltinRegistries.BIOME.getKey(bygBiome.getBiome()), new OverworldPrimaryBiomeData(bygBiome.getClimate(), bygBiome.getWeight(), Arrays.asList(bygBiome.getBiomeDictionary()), weightedListByLocation, bygBiome.getEdge() != null ? BuiltinRegistries.BIOME.getKey(bygBiome.getEdge()) : new ResourceLocation(""), BuiltinRegistries.BIOME.getKey(bygBiome.getBeach()), BuiltinRegistries.BIOME.getKey(bygBiome.getRiver())));
        }
        return new BiomeDataHolders.OverworldPrimaryBiomeDataHolder(biomeData);
    }

    public ResourceKey<Biome> getKey() {
        return ResourceKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(BuiltinRegistries.BIOME.getKey(this.biome)));
    }
}
