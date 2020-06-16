package voronoiaoc.byg.common.world.dimension.nether.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

public class BYGNetherBiomeProvider extends BiomeProvider {
    public Layer biomeLayer;

    public BYGNetherBiomeProvider(long seed) {
        super(BYGNetherBiomeCatch.getBiomeSet());

        biomeLayer = BYGNetherLayerProvider.build(seed);
    }

    /**
     * @param genX (x >> 2)
     * @param genY (y >> 3)
     * @param genZ (z >> 2)
     * @return the biome for the specified position
     */

    @Override
    public Biome getNoiseBiome(int genX, int genY, int genZ) {
        return biomeLayer.func_215738_a(genX, genZ);
    }
}
