package corgiaoc.byg.common.world.dimension.end;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.core.world.BYGBiomes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.EndBiomeProvider;
import net.minecraft.world.gen.SimplexNoiseGenerator;
import net.minecraft.world.gen.layer.Layer;

import java.util.ArrayList;
import java.util.List;

public class BYGEndBiomeProvider extends BiomeProvider {
    public static final Codec<BYGEndBiomeProvider> BYGENDCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGEndBiomeProvider::new)));

    private final long seed;
    private final Layer biomeLayer;
    public static final List<Biome> END_BIOMES = new ArrayList<>();
    private final Registry<Biome> biomeRegistry;
    private final SimplexNoiseGenerator generator;

    public BYGEndBiomeProvider(Registry<Biome> registry, long seed) {
        super(END_BIOMES);
        this.seed = seed;
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
        sharedseedrandom.skip(17292);
        biomeRegistry = registry;
        this.biomeLayer = BYGEndLayerProvider.stackLayers(this.biomeRegistry, seed);

        this.generator = new SimplexNoiseGenerator(sharedseedrandom);
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
        int xBitOffset = x >> 2;
        int zBitOffset = z >> 2;
        if ((long) xBitOffset * (long) xBitOffset + (long) zBitOffset * (long) zBitOffset <= 4096L) {
            return biomeRegistry.getOrThrow(Biomes.THE_END);
        } else {
            float f = EndBiomeProvider.getRandomNoise(this.generator, xBitOffset * 2 + 1, zBitOffset * 2 + 1);
            if (f >= 0.0F) {
                return biomeLayer.func_242936_a(biomeRegistry, x, z);
            } else {
                return f < -20.0F ? biomeRegistry.getOrThrow(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(BYGBiomes.VISCAL_ISLES))) : biomeRegistry.getOrThrow(Biomes.END_BARRENS);
            }
        }
    }
}