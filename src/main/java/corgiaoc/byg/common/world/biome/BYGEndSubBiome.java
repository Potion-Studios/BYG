package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.BYG;
import corgiaoc.byg.config.json.biomedata.BiomeData;
import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.mixin.access.BiomeAccess;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;

import java.util.*;

@SuppressWarnings("deprecation")
public class BYGEndSubBiome {
    public static final List<BYGEndSubBiome> BYG_END_SUB_BIOMES = new ArrayList<>();
    private final Biome biome;

    public static List<BiomeData> biomeData = new ArrayList<>();
    public static List<BiomeData> voidSubBiomeData = new ArrayList<>();

    public BYGEndSubBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        biome = BiomeAccess.create(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        BYG_END_SUB_BIOMES.add(this);
    }

    public BYGEndSubBiome(Biome.Builder builder) {
        this.biome = builder.build();
        BYG_END_SUB_BIOMES.add(this);
    }

    public BYGEndSubBiome(Biome biome) {
        this.biome = biome;
        BYG_END_SUB_BIOMES.add(this);
    }

    public Biome getBiome() {
        return this.biome;
    }

    @Nullable
    public Biome getEdge() {
        return null;
    }

    public String[] getBiomeDictionary() {
        return new String[]{"END"};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(this.biome)));
    }

    public static BiomeDataHolders.EndSubBiomeDataHolder extractDefaultHolder(Registry<Biome> biomeRegistry) {
        Map<ResourceLocation, BiomeData> biomeData = new HashMap<>();
        Map<ResourceLocation, BiomeData> voidBiomeData = new HashMap<>();
        for (BYGEndSubBiome bygBiome : BYG_END_SUB_BIOMES) {
            List<String> dictionary = Arrays.asList(bygBiome.getBiomeDictionary());

            boolean isVoid = new HashSet<>(dictionary).contains("VOID");
            BiomeData endBiomeData = new BiomeData(dictionary, bygBiome.getEdge() != null ? biomeRegistry.getKey(bygBiome.getEdge()) : new ResourceLocation(""));

            ResourceLocation key = biomeRegistry.getKey(bygBiome.getBiome());
            if (key != null) {
                if (!isVoid) {
                    biomeData.put(key, endBiomeData);
                } else {
                    voidBiomeData.put(key, endBiomeData);
                }
            } else {
                BYG.LOGGER.warn(bygBiome.getClass().getSimpleName() + " is not registered...");
            }
        }

        return new BiomeDataHolders.EndSubBiomeDataHolder(biomeData, voidBiomeData);
    }
}
