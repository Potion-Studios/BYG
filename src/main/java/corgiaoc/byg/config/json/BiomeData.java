package corgiaoc.byg.config.json;

import net.minecraft.util.WeightedList;
import net.minecraft.world.biome.Biome;

public class BiomeData {

    private final Biome biome;
    private final int replacementChance;
    private final WeightedList<Biome> biomeWeightedList;
    private final Biome edgeBiome;
    private final Biome beachBiome;
    private final Biome riverBiome;
    private final int biomeWeight;


    public BiomeData(Biome biome, int replacementChance, int biomeWeight, WeightedList<Biome> biomeWeightedList, Biome edgeBiome, Biome beachBiome, Biome river) {
        this.biome = biome;
        this.replacementChance = replacementChance;
        this.biomeWeight = biomeWeight;
        this.biomeWeightedList = biomeWeightedList;
        this.edgeBiome = edgeBiome;
        this.beachBiome = beachBiome;
        this.riverBiome = river;
    }

    public Biome getBiome() {
        return biome;
    }

    public int getReplacementChance() {
        return replacementChance;
    }

    public WeightedList<Biome> getBiomeWeightedList() {
        return biomeWeightedList;
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

    public int getBiomeWeight() {
        return biomeWeight;
    }


}
