package voronoiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.List;

public class BYGNetherBiomeProvider extends BiomeSource {
    public static final MapCodec<BYGNetherBiomeProvider> BYGMAPCODEC = RecordCodecBuilder.mapCodec((instance) ->
            instance.group(Codec.LONG.fieldOf("seed").forGetter((bygNether) ->
                    bygNether.seed)).apply(instance, BYGNetherBiomeProvider::new));

    public static final Codec<BYGNetherBiomeProvider> BYGNETHERCODEC = BYGMAPCODEC.codec();


    private final BiomeLayerSampler biomeLayer;
    private final long seed;

    public BYGNetherBiomeProvider(long seed) {
        super(biomeList);
        this.seed = seed;
        this.biomeLayer = BYGNetherLayerProvider.stackLayers(seed);
    }

    @Override
    public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
        //TODO: REIMPLEMENT BIOME LAYERS
        return BuiltinRegistries.BIOME.get(Biomes.NETHER_WASTES);
    }

    @Override
    protected Codec<? extends BiomeSource> method_28442() {
        return BYGNETHERCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGNetherBiomeProvider(seed);
    }

    public static List<Biome> biomeList = new ArrayList<>();


    static {
        biomeList.add(BYGBiomeList.SYTHIANTORRIDS);
    }
}
