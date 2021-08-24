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
public class BYGEndBiome {
    public static final List<BYGEndBiome> BYG_END_BIOMES = new ArrayList<>();
    private final Biome biome;

    public BYGEndBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        biome = BiomeAccess.create(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
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

    public WeightedList<ResourceLocation> getHills() {
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
        return new String[]{"END"};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(this.biome)));
    }

    public static BiomeDataHolders.EndBiomeDataHolder extractDefaultHolder(Registry<Biome> biomeRegistry) {
        Map<ResourceLocation, WeightedBiomeData> biomeData = new HashMap<>();
        Map<ResourceLocation, WeightedBiomeData> voidBiomeData = new HashMap<>();
        for (BYGEndBiome bygBiome : BYG_END_BIOMES) {
            List<String> dictionary = Arrays.asList(bygBiome.getBiomeDictionary());
            WeightedList<ResourceLocation> weightedListByLocation = new WeightedList<>();
            for (WeightedList.Entry<ResourceLocation> entry : ((WeightedListAccess<ResourceLocation>) bygBiome.getHills()).getEntries()) {
                weightedListByLocation.add(entry.getData(), ((WeightedListEntryAccess) entry).getWeight());
            }
            boolean isVoid = new HashSet<>(dictionary).contains("VOID");
            WeightedBiomeData weightedBiomeData = new WeightedBiomeData(bygBiome.getWeight(), dictionary, bygBiome.getEdge() != null ? biomeRegistry.getKey(bygBiome.getEdge()) : new ResourceLocation(""), weightedListByLocation);

            ResourceLocation key = biomeRegistry.getKey(bygBiome.getBiome());
            if (key != null) {
                if (!isVoid) {
                    biomeData.put(key, weightedBiomeData);
                } else {
                    voidBiomeData.put(key, weightedBiomeData);
                }
            }

            for (Biome biome : biomeRegistry) {
                ResourceLocation biomeKey = biomeRegistry.getKey(biome);
                if (biome.getBiomeCategory() == Biome.Category.THEEND) {
                    if (!biomeData.containsKey(biomeKey)) {
                        assert biomeKey != null;
                        if (!biomeKey.equals(new ResourceLocation("small_end_islands"))) {
                           biomeData.put(biomeKey, new WeightedBiomeData(5, Collections.singletonList("END"), new ResourceLocation(""), new WeightedList<>()));
                        } else {
                            voidBiomeData.put(biomeKey, new WeightedBiomeData(5, Collections.singletonList("VOID"), new ResourceLocation(""), new WeightedList<>()));
                        }
                    }
                }
            }
        }

        return new BiomeDataHolders.EndBiomeDataHolder(biomeData, voidBiomeData);
    }
}
