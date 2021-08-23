package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.config.json.endbiomedata.EndBiomeData;
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

    public static List<EndBiomeData> endBiomeData = new ArrayList<>();
    public static List<EndBiomeData> voidBiomeData = new ArrayList<>();

    public static Map<ResourceLocation, WeightedList<ResourceLocation>> BIOME_TO_HILLS = new HashMap<>();
    public static Map<ResourceLocation, ResourceLocation> BIOME_TO_EDGE = new HashMap<>();

    public BYGEndBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
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

    @Nullable
    public WeightedList<ResourceLocation> getHills() {
        return null;
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
}
