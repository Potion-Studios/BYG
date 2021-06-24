package corgiaoc.byg.common.world.dimension.end;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.config.json.BYGJsonConfigHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.dynamic.RegistryLookupCodec;
import net.minecraft.util.math.noise.SimplexNoiseSampler;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.TheEndBiomeSource;
import net.minecraft.world.gen.ChunkRandom;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BYGEndBiomeProvider extends BiomeSource {
    public static final Codec<BYGEndBiomeProvider> BYGENDCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGEndBiomeProvider::new)));

    private final long seed;
    private final DatapackLayer mainIslandLayer;
    private final DatapackLayer smallIslandLayer;
    private final Registry<Biome> biomeRegistry;
    private final SimplexNoiseSampler generator;

    public static WeightedList<Identifier> END_BIOMES = new WeightedList<>();
    public static WeightedList<Identifier> VOID_BIOMES = new WeightedList<>();

    public BYGEndBiomeProvider(Registry<Biome> registry, long seed) {
        super(handleJsonAndFillBiomeList(registry));
        this.seed = seed;
        ChunkRandom sharedseedrandom = new ChunkRandom(seed);
        sharedseedrandom.next(17292);
        biomeRegistry = registry;
        this.mainIslandLayer = EndLayerProviders.stackLayers(this.biomeRegistry, seed);
        this.smallIslandLayer = EndLayerProviders.stackVoidLayers(this.biomeRegistry, seed);
        this.generator = new SimplexNoiseSampler(sharedseedrandom);
    }

    private static List<Biome> handleJsonAndFillBiomeList(Registry<Biome> registry) {
        BYG.EARLY_BIOME_REGISTRY_ACCESS = registry;
        BYGJsonConfigHandler.handleEndBiomeJsonConfigs(BYG.CONFIG_PATH, registry);
        return Stream.concat(END_BIOMES.entries.stream(), VOID_BIOMES.entries.stream()).map(WeightedList.Entry::getElement).map(registry::get).collect(Collectors.toList());
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
    public Biome getBiomeForNoiseGen(int x, int y, int z) {
        int xBitOffset = x >> 2;
        int zBitOffset = z >> 2;
        if ((long) xBitOffset * (long) xBitOffset + (long) zBitOffset * (long) zBitOffset <= 4096L) {
            return biomeRegistry.getOrThrow(BiomeKeys.THE_END);
        } else {
            float sampledNoise = TheEndBiomeSource.getNoiseAt(this.generator, xBitOffset * 2 + 1, zBitOffset * 2 + 1);
            if (sampledNoise >= -20.0F) {
                return mainIslandLayer.sampleEnd(biomeRegistry, x, z);
            } else {
                return this.smallIslandLayer.sampleEndVoid(biomeRegistry, x, z);
            }
        }
    }
}