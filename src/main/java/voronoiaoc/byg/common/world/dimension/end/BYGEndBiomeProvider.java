package voronoiaoc.byg.common.world.dimension.end;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.TheEndBiomeSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import net.minecraft.world.level.newbiome.layer.Layer;

import java.util.ArrayList;
import java.util.List;

public class BYGEndBiomeProvider extends BiomeSource {
    public static final Codec<BYGEndBiomeProvider> BYG_END_CODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGEndBiomeProvider::new)));

    private final long seed;
    private final Layer biomeLayer;

    public static final List<Biome> bygEndBiomeList = new ArrayList<>();
    private final SimplexNoise islandNoise;
    private final Registry<Biome> biomeRegistry;

    public BYGEndBiomeProvider(Registry<Biome> registry, long seed) {
        super(bygEndBiomeList);
        this.seed = seed;
        WorldgenRandom sharedseedrandom = new WorldgenRandom(seed);
        sharedseedrandom.consumeCount(17292);
        this.biomeLayer = BYGEndLayerProvider.stackLayers(seed);
        biomeRegistry = registry;
        this.islandNoise = new SimplexNoise(sharedseedrandom);
    }


    @Override
    protected Codec<? extends BiomeSource> codec() {
        return BYG_END_CODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGEndBiomeProvider(biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        int xBitOffset = x >> 2;
        int zBitOffset = z >> 2;
        if ((long) xBitOffset * (long) xBitOffset + (long) zBitOffset * (long) zBitOffset <= 4096L) {
            return biomeRegistry.get(Biomes.THE_END);
        } else {
            float f = TheEndBiomeSource.getHeightValue(this.islandNoise, xBitOffset * 2 + 1, zBitOffset * 2 + 1);
            if (f >= 0.0F) {
                return biomeLayer.get(biomeRegistry, x, z);
            } else {
                return f < -20.0F ? biomeRegistry.getOrThrow(Biomes.SMALL_END_ISLANDS) : biomeRegistry.getOrThrow(Biomes.END_BARRENS);
            }
        }
    }
}