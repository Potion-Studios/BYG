package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.config.json.biomedata.OverworldPrimaryBiomeData;
import corgiaoc.byg.mixin.access.BiomeAccess;
import corgiaoc.byg.mixin.access.WeightedListAccess;
import corgiaoc.byg.mixin.access.WeightedListEntryAccess;
import corgiaoc.byg.util.MLClimate;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;

import java.util.*;

@SuppressWarnings("deprecation")
public class BYGBiome {
    public static final List<BYGBiome> BYG_BIOMES = new ArrayList<>();
    private final Biome biome;

    public static final Map<ResourceLocation, WeightedList<ResourceLocation>> BIOME_TO_HILLS_LIST = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> BIOME_TO_BEACH_LIST = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> BIOME_TO_EDGE_LIST = new HashMap<>();
    public static final Map<ResourceLocation, ResourceLocation> BIOME_TO_RIVER_LIST = new HashMap<>();

    public BYGBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        biome = BiomeAccess.create(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        BYG_BIOMES.add(this);
    }

    public BYGBiome(Biome.Builder builder) {
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
        return WorldGenRegistries.BIOME.getOrThrow(Biomes.RIVER);
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
        return WorldGenRegistries.BIOME.getOrThrow(Biomes.BEACH);
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
            for (WeightedList.Entry<Biome> entry : ((WeightedListAccess<Biome>) bygBiome.getHills()).getEntries()) {
                weightedListByLocation.add(WorldGenRegistries.BIOME.getKey(entry.getData()), ((WeightedListEntryAccess) entry).getWeight());
            }

            biomeData.put(WorldGenRegistries.BIOME.getKey(bygBiome.getBiome()), new OverworldPrimaryBiomeData(bygBiome.getClimate(), bygBiome.getWeight(), Arrays.asList(bygBiome.getBiomeDictionary()), weightedListByLocation, bygBiome.getEdge() != null ? WorldGenRegistries.BIOME.getKey(bygBiome.getEdge()) : new ResourceLocation(""), WorldGenRegistries.BIOME.getKey(bygBiome.getBeach()), WorldGenRegistries.BIOME.getKey(bygBiome.getRiver())));
        }
        return new BiomeDataHolders.OverworldPrimaryBiomeDataHolder(biomeData);
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(this.biome)));
    }
}
