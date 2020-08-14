package voronoiaoc.byg.common.world.dimension.end;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

import java.util.ArrayList;
import java.util.List;

public class BYGEndBiomeProvider extends BiomeProvider {
    public static final Codec<BYGEndBiomeProvider> BYGENDCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.func_244331_a(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGEndBiomeProvider::new)));

    private final long seed;
    private final Layer biomeLayer;

    public static final List<Biome> bygEndBiomeList = new ArrayList<>();

    private final Registry<Biome> biomeRegistry;

    public BYGEndBiomeProvider(Registry<Biome> registry, long seed) {
        super(bygEndBiomeList);
        this.seed = seed;
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
        sharedseedrandom.setSeed(17292);
        this.biomeLayer = BYGEndLayerProvider.stackLayers(seed);
        biomeRegistry = registry;
    }

    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return BYGENDCODEC;
    }

    @Override
    public BiomeProvider getBiomeProvider(long seed) {
        return new BYGEndBiomeProvider(biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        int i = x >> 2;
        int j = z >> 2;
        if ((long) i * (long) i + (long) j * (long) j <= 4096L) {
            return biomeRegistry.func_243576_d(Biomes.THE_END);
        } else {
            //TODO: REIMPLEMENT BIOME LAYERS
            return biomeLayer.func_242936_a(biomeRegistry, x, z);
        }
    }
}