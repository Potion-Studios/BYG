package corgiaoc.byg.common.world.biome;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.INoiseRandom;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class BYGBiome {
    public static final List<BYGBiome> BYG_BIOMES = new ArrayList<>();
    private final Biome biome;

    private static final Int2IntMap BIOME_SIMILARITY_MAP = new Int2IntOpenHashMap();



    public BYGBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
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
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(this.biome)));
    }

    public static void fillMutationMap() {
        for (Biome biome : WorldGenRegistries.BIOME) {
            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NONE)
                BIOME_SIMILARITY_MAP.put(WorldGenRegistries.BIOME.getId(biome), biome.getCategory().ordinal());
        }
    }

    public static boolean areBiomesSimilar(int layer2Value, int layer1Value) {
        if (layer2Value == layer1Value) {
            return true;
        } else {
            return BIOME_SIMILARITY_MAP.get(layer2Value) == BIOME_SIMILARITY_MAP.get(layer1Value);
        }
    }
}
