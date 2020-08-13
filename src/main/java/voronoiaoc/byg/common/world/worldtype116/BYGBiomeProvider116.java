package voronoiaoc.byg.common.world.worldtype116;

import com.mojang.serialization.Codec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.gen.layer.Layer;

public class BYGBiomeProvider116 extends Biome implements BiomeToolsProvider {
    public Layer layer;
    private final long seed;


    public static final Codec<BYGBiomeProvider116> BYGBPCODEC = Codec.LONG.fieldOf("seed").xmap(BYGBiomeProvider116::new, (biomeProvider) -> biomeProvider.seed).stable().codec();


    public BYGBiomeProvider116(long seed) {
        super(OverworldBiomeProvider.field_226847_e_);
        this.seed = seed;
        layer = BYGWorldLayerProvider.stackLayers(seed);
    }


    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return layer.func_215738_a(x, z);
    }

    @Override
    protected Codec<? extends Biome implements BiomeToolsProvider> func_230319_a_() {
        return BYGBPCODEC;
    }

    @Override
    public BiomeProvider func_230320_a_(long seed) {
        return new BYGBiomeProvider116(seed);
    }
}
