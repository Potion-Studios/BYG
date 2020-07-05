package voronoiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

import java.util.ArrayList;
import java.util.List;

public class BYGNetherBiomeProvider extends BiomeProvider {
    public static final MapCodec<BYGNetherBiomeProvider> BYGMAPCODEC = RecordCodecBuilder.mapCodec((instance) ->
            instance.group(Codec.LONG.fieldOf("seed").forGetter((bygNether) ->
                    bygNether.seed)).apply(instance, BYGNetherBiomeProvider::new));

    public static final Codec<BYGNetherBiomeProvider> BYGNETHERCODEC = BYGMAPCODEC.codec();


    private final Layer biomeLayer;
    private final long seed;

    public BYGNetherBiomeProvider(long seed) {
        super(biomeList);
        this.seed = seed;
        this.biomeLayer = BYGNetherLayerProvider.stackLayers(seed);
    }

    public static List<Biome> biomeList = new ArrayList<>();


    @Override
    protected Codec<? extends BiomeProvider> func_230319_a_() {
        return BYGNETHERCODEC;
    }

    @Override
    public BiomeProvider func_230320_a_(long seed) {
        return new BYGNetherBiomeProvider(seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return biomeLayer.func_215738_a(x, z);
    }
}
