package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.config.json.subbiomedata.SubBiomeData;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class BYGSubBiome {
    public static final List<BYGSubBiome> BYG_SUB_BIOMES = new ArrayList<>();
    private final Biome biome;

    public static List<SubBiomeData> subBiomeData = new ArrayList<>();


    public BYGSubBiome(Biome.Weather climate, Biome.Category category, float depth, float scale, BiomeEffects effects, GenerationSettings biomeGenerationSettings, SpawnSettings mobSpawnInfo) {
        biome = new Biome(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        BYG_SUB_BIOMES.add(this);
    }

    public BYGSubBiome(Biome.Builder builder) {
        this.biome = builder.build();
        BYG_SUB_BIOMES.add(this);
    }

    public BYGSubBiome(Biome biome) {
        this.biome = biome;
        BYG_SUB_BIOMES.add(this);
    }

    public Biome getBeach() {
        return BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.BEACH);
    }

    @Nullable
    public Biome getEdge() {
        return null;
    }

    public Biome getBiome() {
        return this.biome;
    }

    public Biome getRiver() {
        return BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.RIVER);
    }

    public Object getBiomeDictionary() {
        return null; //new BiomeDictionary.Type[]{BiomeDictionary.Type.OVERWORLD};
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.of(Registry.BIOME_KEY, Objects.requireNonNull(BuiltinRegistries.BIOME.getId(this.biome)));
    }
}
