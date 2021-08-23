package corgiaoc.byg.config.json.endbiomedata.sub;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.BiomeDictionary;

public class EndSubBiomeData {

    private final ResourceLocation biome;
    private final ResourceLocation edgeBiome;
    private final BiomeDictionary.Type[] dictionaryType;


    public EndSubBiomeData(ResourceLocation biome, BiomeDictionary.Type[] dictionary, ResourceLocation edgeBiome) {
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

    public BiomeDictionary.Type[] getDictionaryTypes() {
        return dictionaryType;
    }
}
