package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.config.json.endbiomedata.sub.EndSubBiomeData;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class BYGEndSubBiome {
    public static final List<BYGEndSubBiome> BYG_END_SUB_BIOMES = new ArrayList<>();
    private final Biome biome;

    public static List<EndSubBiomeData> endSubBiomeData = new ArrayList<>();
    public static List<EndSubBiomeData> voidSubBiomeData = new ArrayList<>();

    public BYGEndSubBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
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

    public String[] getBiomeDictionary() {
        return new String[]{"END"};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(this.biome)));
    }
}
