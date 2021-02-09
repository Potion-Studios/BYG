package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.config.json.endbiomedata.sub.EndSubBiomeData;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class BYGEndSubBiome {
    public static final List<BYGEndSubBiome> BYG_END_SUB_BIOMES = new ArrayList<>();
    public static List<EndSubBiomeData> endSubBiomeData = new ArrayList<>();
    public static List<EndSubBiomeData> voidSubBiomeData = new ArrayList<>();
    private final Biome biome;

    public BYGEndSubBiome(Biome.Weather climate, Biome.Category category, float depth, float scale, BiomeEffects effects, GenerationSettings biomeGenerationSettings, SpawnSettings mobSpawnInfo) {
        biome = new Biome(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
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

    public boolean isVoid() {
        return false;
    }

    public Object getBiomeDictionary() {
        return null; //new BiomeDictionary.Type[]{BiomeDictionary.Type.END};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.of(Registry.BIOME_KEY, Objects.requireNonNull(BuiltinRegistries.BIOME.getId(this.biome)));
    }
}
