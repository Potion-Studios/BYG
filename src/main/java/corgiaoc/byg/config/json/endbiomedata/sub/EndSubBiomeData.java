package corgiaoc.byg.config.json.endbiomedata.sub;

import net.minecraft.util.Identifier;

public class EndSubBiomeData {

    private final Identifier biome;
    private final Identifier edgeBiome;
    private final boolean isVoid;

    public EndSubBiomeData(Identifier biome, Identifier edgeBiome) {
        this(biome, edgeBiome, false);
    }

    public EndSubBiomeData(Identifier biome, Identifier edgeBiome, boolean isVoid) {
        this.biome = biome;
        this.edgeBiome = edgeBiome;
        this.isVoid = isVoid;
    }

    public Identifier getBiome() {
        return biome;
    }

    public Identifier getEdgeBiome() {
        return edgeBiome;
    }

    public boolean isVoid() {
        return isVoid;
    }
}
