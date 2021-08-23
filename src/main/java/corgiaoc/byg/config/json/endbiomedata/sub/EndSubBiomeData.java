package corgiaoc.byg.config.json.endbiomedata.sub;

import net.minecraft.util.ResourceLocation;

public class EndSubBiomeData {

    private final ResourceLocation biome;
    private final ResourceLocation edgeBiome;
    private final String[] dictionaryType;


    public EndSubBiomeData(ResourceLocation biome, String[] dictionary, ResourceLocation edgeBiome) {
        this.biome = biome;
        this.dictionaryType = dictionary;
        this.edgeBiome = edgeBiome;
    }

    public ResourceLocation getBiome() {
        return biome;
    }

    public ResourceLocation getEdgeBiome() {
        return edgeBiome;
    }

    public String[] getDictionaryTypes() {
        return dictionaryType;
    }
}
