package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.config.json.biomedata.WeightedBiomeData;
import corgiaoc.byg.mixin.access.BiomeAccess;
import corgiaoc.byg.mixin.access.WeightedListAccess;
import corgiaoc.byg.mixin.access.WeightedListEntryAccess;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;

import java.util.*;

@SuppressWarnings("deprecation")
public class BYGNetherBiome {
    public static final List<BYGNetherBiome> BYG_NETHER_BIOMES = new ArrayList<>();
    private final Biome biome;

    public BYGNetherBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        biome = BiomeAccess.create(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
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

    public WeightedList<Biome> getHills() {
        return new WeightedList<>();
    }

    @Nullable
    public Biome getEdge() {
        return null;
    }

    public int getWeight() {
        return 5;
    }

    public String[] getBiomeDictionary() {
        return new String[]{"NETHER"};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(this.biome)));
    }

    public static BiomeDataHolders.WeightedBiomeDataHolder extractDefaultHolder(Registry<Biome> biomeRegistry) {
        Map<ResourceLocation, WeightedBiomeData> biomeData = new HashMap<>();
        for (BYGNetherBiome bygBiome : BYG_NETHER_BIOMES) {
            List<String> dictionary = Arrays.asList(bygBiome.getBiomeDictionary());
            WeightedList<ResourceLocation> weightedListByLocation = new WeightedList<>();
            for (WeightedList.Entry<ResourceLocation> entry : ((WeightedListAccess<ResourceLocation>) bygBiome.getHills()).getEntries()) {
                weightedListByLocation.add(entry.getData(), ((WeightedListEntryAccess) entry).getWeight());
            }
            WeightedBiomeData weightedBiomeData = new WeightedBiomeData(bygBiome.getWeight(), dictionary, bygBiome.getEdge() != null ? biomeRegistry.getKey(bygBiome.getEdge()) : new ResourceLocation(""), weightedListByLocation);

            ResourceLocation key = biomeRegistry.getKey(bygBiome.getBiome());
            if (key != null) {
                biomeData.put(key, weightedBiomeData);
            }
        }
        for (Biome biome : biomeRegistry) {
            ResourceLocation biomeKey = biomeRegistry.getKey(biome);
            if (biome.getBiomeCategory() == Biome.Category.NETHER) {
                if (!biomeData.containsKey(biomeKey)) {
                    assert biomeKey != null;
                    biomeData.put(biomeKey, new WeightedBiomeData(5, Collections.singletonList("NETHER"), new ResourceLocation(""), new WeightedList<>()));
                }
            }
        }

        return new BiomeDataHolders.WeightedBiomeDataHolder(biomeData);

    }
}
