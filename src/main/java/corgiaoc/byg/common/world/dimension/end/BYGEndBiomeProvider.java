package corgiaoc.byg.common.world.dimension.end;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.config.json.BYGJsonConfigHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.EndBiomeProvider;
import net.minecraft.world.gen.SimplexNoiseGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BYGEndBiomeProvider extends BiomeProvider {
    public static final Codec<BYGEndBiomeProvider> BYGENDCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGEndBiomeProvider::new)));

    private final long seed;
    private final DatapackLayer mainIslandLayer;
    private final DatapackLayer smallIslandLayer;
    private final Registry<Biome> biomeRegistry;
    private final SimplexNoiseGenerator generator;

    public static WeightedList<ResourceLocation> END_BIOMES = new WeightedList<>();
    public static WeightedList<ResourceLocation> VOID_BIOMES = new WeightedList<>();

    public BYGEndBiomeProvider(Registry<Biome> registry, long seed) {
        super(handleJsonAndFillBiomeList(registry));
        this.seed = seed;
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
        sharedseedrandom.skip(17292);
        biomeRegistry = registry;
        this.mainIslandLayer = EndLayerProviders.stackLayers(this.biomeRegistry, seed);
        this.smallIslandLayer = EndLayerProviders.stackVoidLayers(this.biomeRegistry, seed);
        this.generator = new SimplexNoiseGenerator(sharedseedrandom);
    }

    private static List<Biome> handleJsonAndFillBiomeList(Registry<Biome> registry) {
        BYG.EARLY_BIOME_REGISTRY_ACCESS = registry;
        BYGJsonConfigHandler.handleEndBiomeJsonConfigs(BYG.CONFIG_PATH, registry);
        return Stream.concat(END_BIOMES.field_220658_a.stream(), VOID_BIOMES.field_220658_a.stream()).map(WeightedList.Entry::func_220647_b).map(registry::getOrDefault).collect(Collectors.toList());
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
                return mainIslandLayer.sampleEnd(biomeRegistry, x, z);
            } else {
                return f < -20.0F ? this.smallIslandLayer.sampleEndVoid(biomeRegistry, x, z) : biomeRegistry.getOrThrow(Biomes.END_BARRENS);
            }
        }
    }
}