package voronoiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.List;

public class BYGNetherBiomeProvider extends BiomeSource {
    public static final Codec<BYGNetherBiomeProvider> BYGNETHERCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGNetherBiomeProvider::new)));


    private final BiomeLayerSampler biomeLayer;
    private final long seed;
    private final Registry<Biome> biomeRegistry;


    public BYGNetherBiomeProvider(Registry<Biome> registry, long seed) {
        super(biomeList);
        this.seed = seed;
        this.biomeLayer = BYGNetherLayerProvider.stackLayers(seed);
        biomeRegistry = registry;
    }

    @Override
    public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
        //TODO: REIMPLEMENT BIOME LAYERS
        return biomeLayer.sample(biomeRegistry, biomeX, biomeZ);
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return BYGNETHERCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGNetherBiomeProvider(biomeRegistry, seed);
    }

    public static List<Biome> biomeList = new ArrayList<>();

    public static void addNetherBiomesForProvider() {
        biomeList.add(BYGBiomeList.SYTHIANTORRIDS);
    }
}
