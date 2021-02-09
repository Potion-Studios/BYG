package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.config.json.biomedata.BiomeData;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class BYGBiome {
    public static final List<BYGBiome> BYG_BIOMES = new ArrayList<>();
    private final Biome biome;

    public static List<BiomeData> biomeData = new ArrayList<>();

    public static final Int2ObjectMap<WeightedList<Biome>> BIOME_TO_HILLS_LIST = new Int2ObjectArrayMap<>();
    public static final Int2ObjectMap<Biome> BIOME_TO_BEACH_LIST = new Int2ObjectArrayMap<>();
    public static final Int2ObjectMap<Biome> BIOME_TO_EDGE_LIST = new Int2ObjectArrayMap<>();
    public static final Int2ObjectMap<Biome> BIOME_TO_RIVER_LIST = new Int2ObjectArrayMap<>();

    public BYGBiome(Biome.Weather climate, Biome.Category category, float depth, float scale, BiomeEffects effects, GenerationSettings biomeGenerationSettings, SpawnSettings mobSpawnInfo) {
        biome = new Biome(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
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
        return BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.RIVER);
    }

    @Nullable
    public WeightedList<Biome> getHills() {
        return null;
    }

    @Nullable
    public Biome getEdge() {
        return null;
    }

    @Nullable
    public Biome getBeach() {
        return BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.BEACH);
    }


    public Object getBiomeDictionary() {
        return null; //new BiomeDictionary.Type[]{BiomeDictionary.Type.OVERWORLD};
    }

    public OverworldClimate getBiomeType() {
        return OverworldClimate.TEMPERATE;
    }

    public int getWeight() {
        return 5;
    }


    public RegistryKey<Biome> getKey() {
        return RegistryKey.of(Registry.BIOME_KEY, Objects.requireNonNull(BuiltinRegistries.BIOME.getId(this.biome)));
    }
}
