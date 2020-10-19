package corgiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.ArrayList;
import java.util.List;

public class BYGNetherBiomeProvider extends BiomeProvider {
    public static final Codec<BYGNetherBiomeProvider> BYGNETHERCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGNetherBiomeProvider::new)));

    private final DatapackLayer biomeLayer;
    private final long seed;
    private final Registry<Biome> biomeRegistry;
    public static List<Biome> NETHER_BIOMES = new ArrayList<>();

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
        return biomeLayer.sampleNether(biomeRegistry, x, z);
    }

}
