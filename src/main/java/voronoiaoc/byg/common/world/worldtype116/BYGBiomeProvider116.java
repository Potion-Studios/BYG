package voronoiaoc.byg.common.world.worldtype116;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.gen.layer.Layer;

public class BYGBiomeProvider116 extends OverworldBiomeProvider {
    public Layer layer;


    public BYGBiomeProvider116(long seed) {
        super(seed, true, true);
        layer = BYGWorldLayerProvider.stackLayers(seed);
    }


    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return layer.func_215738_a(x, z);
    }
}
