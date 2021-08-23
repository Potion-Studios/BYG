package corgiaoc.byg.common.world.dimension.end;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.config.json.BYGJsonConfigHandler;
import corgiaoc.byg.mixin.access.WeightedListAccess;
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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BYGEndBiomeSource extends BiomeProvider {
    public static final Codec<BYGEndBiomeSource> BYGENDCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGEndBiomeSource::new)));

    private final long seed;
    private final DatapackLayer mainIslandLayer;
    private final DatapackLayer smallIslandLayer;
    private final Registry<Biome> biomeRegistry;
    private final SimplexNoiseGenerator generator;

    public static WeightedList<ResourceLocation> END_BIOMES = new WeightedList<>();
    public static WeightedList<ResourceLocation> VOID_BIOMES = new WeightedList<>();

    public BYGEndBiomeSource(Registry<Biome> registry, long seed) {
        super(handleJsonAndFillBiomeList(registry));
        this.seed = seed;
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
        sharedseedrandom.consumeCount(17292);
        biomeRegistry = registry;
        this.mainIslandLayer = EndLayerProviders.stackLayers(this.biomeRegistry, seed);
        this.smallIslandLayer = EndLayerProviders.stackVoidLayers(this.biomeRegistry, seed);
        this.generator = new SimplexNoiseGenerator(sharedseedrandom);
    }

    private static List<Biome> handleJsonAndFillBiomeList(Registry<Biome> registry) {
        BYGJsonConfigHandler.handleEndBiomeJsonConfigs(BYG.CONFIG_PATH, registry);
        return Stream.concat(((WeightedListAccess<ResourceLocation>) END_BIOMES).getEntries().stream(), ((WeightedListAccess<ResourceLocation>) VOID_BIOMES).getEntries().stream()).map(WeightedList.Entry::getData).map(registry::get).collect(Collectors.toList());
    }

    @Override
    protected Codec<? extends BiomeProvider> codec() {
        return BYGENDCODEC;
    }

    @Override
    public BiomeProvider withSeed(long seed) {
        return new BYGEndBiomeSource(biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        int xBitOffset = x >> 2;
        int zBitOffset = z >> 2;
        if ((long) xBitOffset * (long) xBitOffset + (long) zBitOffset * (long) zBitOffset <= 4096L) {
            return biomeRegistry.getOrThrow(Biomes.THE_END);
        } else {
            float sampledNoise = EndBiomeProvider.getHeightValue(this.generator, xBitOffset * 2 + 1, zBitOffset * 2 + 1);
            if (sampledNoise >= -20.0F) {
                return mainIslandLayer.sampleEnd(biomeRegistry, x, z);
            } else {
                return this.smallIslandLayer.sampleEndVoid(biomeRegistry, x, z);
            }
        }
    }
}