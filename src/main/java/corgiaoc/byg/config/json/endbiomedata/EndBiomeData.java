package corgiaoc.byg.config.json.endbiomedata;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;

public class EndBiomeData {

    private final ResourceLocation biome;
    private final WeightedList<ResourceLocation> biomeWeightedList;
    private final ResourceLocation edgeBiome;
    private final int biomeWeight;
    private final String[] dictionaryType;


    public EndBiomeData(ResourceLocation biome, int biomeWeight, String[] dictionary, WeightedList<ResourceLocation> biomeWeightedList, ResourceLocation edgeBiome) {
        this.biome = biome;
        this.biomeWeight = biomeWeight;
        this.dictionaryType = dictionary;
        this.biomeWeightedList = biomeWeightedList;
        this.edgeBiome = edgeBiome;
    }

    public ResourceLocation getBiome() {
        return biome;
    }

    public WeightedList<ResourceLocation> getBiomeWeightedList() {
        return biomeWeightedList;
    }

    public ResourceLocation getEdgeBiome() {
        return edgeBiome;
    }

    public int getBiomeWeight() {
        return biomeWeight;
    }

    public String[] getDictionaryTypes() {
        return dictionaryType;
    }
}
