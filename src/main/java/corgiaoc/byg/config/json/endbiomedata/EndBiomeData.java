package corgiaoc.byg.config.json.endbiomedata;

import net.minecraft.util.Identifier;
import net.minecraft.util.collection.WeightedList;

public class EndBiomeData {

    private final Identifier biome;
    private final WeightedList<Identifier> biomeWeightedList;
    private final Identifier edgeBiome;
    private final boolean isVoid;
    private final int biomeWeight;


    public EndBiomeData(Identifier biome, int biomeWeight, WeightedList<Identifier> biomeWeightedList, Identifier edgeBiome) {
        this(biome, biomeWeight, biomeWeightedList, edgeBiome, false);
    }

    public EndBiomeData(Identifier biome, int biomeWeight, WeightedList<Identifier> biomeWeightedList, Identifier edgeBiome, boolean isVoid) {
        this.biome = biome;
        this.biomeWeight = biomeWeight;
        this.biomeWeightedList = biomeWeightedList;
        this.edgeBiome = edgeBiome;
        this.isVoid = isVoid;
    }

    public Identifier getBiome() {
        return biome;
    }

    public WeightedList<Identifier> getBiomeWeightedList() {
        return biomeWeightedList;
    }

    public Identifier getEdgeBiome() {
        return edgeBiome;
    }

    public int getBiomeWeight() {
        return biomeWeight;
    }

    public boolean isVoid() {
        return isVoid;
    }
}
