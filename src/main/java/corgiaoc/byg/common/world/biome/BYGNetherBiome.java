package corgiaoc.byg.common.world.biome;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.BiomeDictionary;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class BYGNetherBiome {
    public static final List<BYGNetherBiome> BYG_NETHER_BIOMES = new ArrayList<>();
    private final Biome biome;

    public static final Int2ObjectMap<WeightedList<Biome>> BIOME_TO_HILLS = new Int2ObjectArrayMap<>();
    public static final Int2ObjectMap<Biome> BIOME_TO_EDGE = new Int2ObjectArrayMap<>();


    public BYGNetherBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        biome = new Biome(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
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

    @Nullable
    public WeightedList<Biome> getHills() {
        return null;
    }

    @Nullable
    public Biome getEdge() {
        return null;
    }

    public BiomeDictionary.Type[] getBiomeDictionary() {
        return new BiomeDictionary.Type[]{BiomeDictionary.Type.NETHER};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(this.biome)));
}
}
