package corgiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

import java.util.ArrayList;
import java.util.List;

public class BYGNetherBiomeProvider extends BiomeProvider {
    public static final Codec<BYGNetherBiomeProvider> BYGNETHERCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGNetherBiomeProvider::new)));


    private final Layer biomeLayer;
    private final long seed;
    private final Registry<Biome> biomeRegistry;
    public static final List<Biome> NETHER_BIOMES = new ArrayList<>();


    public BYGNetherBiomeProvider(Registry<Biome> registry, long seed) {
        super(NETHER_BIOMES);
        this.seed = seed;
        biomeRegistry = registry;
        this.biomeLayer = BYGNetherLayerProvider.stackLayers(this.biomeRegistry, seed);
    }

    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return BYGNETHERCODEC;
    }

    @Override
    public BiomeProvider getBiomeProvider(long seed) {
        return new BYGNetherBiomeProvider(biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return biomeLayer.func_242936_a(biomeRegistry, x, z);
    }

}
