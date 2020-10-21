package corgiaoc.byg.config.json.subbiomedata;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class SubBiomeData {

    private final Biome biome;
    private final Biome edgeBiome;
    private final Biome beachBiome;
    private final Biome riverBiome;
    private final BiomeDictionary.Type[] dictionaryType;

    public SubBiomeData(Biome biome, BiomeDictionary.Type[] dictionary, Biome edgeBiome, Biome beachBiome, Biome river) {
        this.biome = biome;
        this.dictionaryType = dictionary;
        this.edgeBiome = edgeBiome;
        this.beachBiome = beachBiome;
        this.riverBiome = river;
    }

    public Biome getBiome() {
        return biome;
    }

    public Biome getEdgeBiome() {
        return edgeBiome;
    }

    public Biome getBeachBiome() {
        return beachBiome;
    }

    public Biome getRiverBiome() {
        return riverBiome;
    }

    public BiomeDictionary.Type[] getDictionaryTypes() {
        return dictionaryType;
    }
}
