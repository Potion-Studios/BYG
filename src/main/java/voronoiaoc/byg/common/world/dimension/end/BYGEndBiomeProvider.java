package voronoiaoc.byg.common.world.dimension.end;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BuiltInBiomes;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;

import java.util.ArrayList;
import java.util.List;

public class BYGEndBiomeProvider extends BiomeSource {
    public static final Codec<BYGEndBiomeProvider> BYGENDCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGEndBiomeProvider::new)));

    private final long seed;
    private final BiomeLayerSampler biomeLayer;

    public static final List<Biome> bygEndBiomeList = new ArrayList<>();

    private final Registry<Biome> biomeRegistry;

    public BYGEndBiomeProvider(Registry<Biome> registry, long seed) {
        super(bygEndBiomeList);
        this.seed = seed;
        ChunkRandom sharedseedrandom = new ChunkRandom(seed);
        sharedseedrandom.consume(17292);
        this.biomeLayer = BYGEndLayerProvider.stackLayers(seed);
        biomeRegistry = registry;
    }


    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return BYGENDCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGEndBiomeProvider(biomeRegistry, seed);
    }

    @Override
    public Biome getBiomeForNoiseGen(int x, int biomeY, int z) {
        int i = x >> 2;
        int j = z >> 2;
        if ((long) i * (long) i + (long) j * (long) j <= 4096L) {
            return biomeRegistry.get(BuiltInBiomes.THE_END);
        } else {
            //TODO: REIMPLEMENT BIOME LAYERS
            return biomeLayer.sample(biomeRegistry, x, z);
        }
    }
}