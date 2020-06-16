package voronoiaoc.byg.common.world.worldtype;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

import java.util.Set;

public class BYGBiomeProvider extends BiomeProvider {
    private final Layer layer;

    public BYGBiomeProvider(Set<Biome> biomes, long seed) {
        super(biomes);
        this.layer = BYGBiomeLayers.stackLayerTransformers(seed);
    }

    @Override
    public Biome getNoiseBiome(int noiseX, int noiseY, int noiseZ) {
        return layer.func_215738_a(noiseX, noiseZ);
    }
}
