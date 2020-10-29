package corgiaoc.byg.config.json.subbiomedata;

import net.minecraft.world.biome.Biome;

public class SubBiomeData {

    private final Biome biome;
    private final Biome edgeBiome;
    private final Biome beachBiome;
    private final Biome riverBiome;

    public SubBiomeData(Biome biome, Biome edgeBiome, Biome beachBiome, Biome river) {
        this.biome = biome;
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
}
