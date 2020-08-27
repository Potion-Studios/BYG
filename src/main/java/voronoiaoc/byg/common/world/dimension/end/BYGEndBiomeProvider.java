package voronoiaoc.byg.common.world.dimension.end;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.newbiome.layer.Layer;

public class BYGEndBiomeProvider extends BiomeSource {
    public static final Codec<BYGEndBiomeProvider> BYGENDCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGEndBiomeProvider::new)));

    private final long seed;
    private final Layer biomeLayer;

    public static final List<Biome> bygEndBiomeList = new ArrayList<>();

    private final Registry<Biome> biomeRegistry;

    public BYGEndBiomeProvider(Registry<Biome> registry, long seed) {
        super(bygEndBiomeList);
        this.seed = seed;
        WorldgenRandom sharedseedrandom = new WorldgenRandom(seed);
        sharedseedrandom.consumeCount(17292);
        this.biomeLayer = BYGEndLayerProvider.stackLayers(seed);
        biomeRegistry = registry;
    }


    @Override
    protected Codec<? extends BiomeSource> codec() {
        return BYGENDCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGEndBiomeProvider(biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int biomeY, int z) {
        int i = x >> 2;
        int j = z >> 2;
        if ((long) i * (long) i + (long) j * (long) j <= 4096L) {
            return biomeRegistry.get(Biomes.THE_END);
        } else {
            //TODO: REIMPLEMENT BIOME LAYERS
            return biomeLayer.get(biomeRegistry, x, z);
        }
    }
}