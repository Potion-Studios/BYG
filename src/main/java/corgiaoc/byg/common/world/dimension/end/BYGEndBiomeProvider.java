package corgiaoc.byg.common.world.dimension.end;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import net.fabricmc.loader.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.SimplexNoiseSampler;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.TheEndBiomeSource;
import net.minecraft.world.gen.ChunkRandom;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BYGEndBiomeProvider extends BiomeSource {
    public static final Codec<BYGEndBiomeProvider> BYGENDCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGEndBiomeProvider::new)));

    private final long seed;
    private final DatapackLayer mainIslandLayer;
    private final DatapackLayer smallIslandLayer;
    public static List<Identifier> END_BIOMES = new ArrayList<>();
    public static List<Identifier> VOID_END_BIOMES = new ArrayList<>();
    private final Registry<Biome> biomeRegistry;
    private final SimplexNoiseSampler generator;

    private static final List<String> END_BIOME_IDS = Arrays.asList(BYG.DIMENSIONS_CONFIG.EndDimension.Islands.BlackListEnd.trim().replace(" ", "").split(","));
    private static final List<String> END_VOID_BIOME_IDS = Arrays.asList(BYG.DIMENSIONS_CONFIG.EndDimension.Void.VoidBiomes.trim().replace(" ", "").split(","));

    public BYGEndBiomeProvider(Registry<Biome> registry, long seed) {
        super(Stream.concat(createEndBiomeList(registry).stream(), createVoidEndBiomeList(registry).stream()).map(registry::get).collect(Collectors.toList()));
        this.seed = seed;
        ChunkRandom sharedseedrandom = new ChunkRandom(seed);
        sharedseedrandom.consume(17292);
        biomeRegistry = registry;
        END_BIOMES = createEndBiomeList(this.biomeRegistry);
        VOID_END_BIOMES = createVoidEndBiomeList(this.biomeRegistry);
        this.mainIslandLayer = EndLayerProviders.stackLayers(this.biomeRegistry, seed);
        this.smallIslandLayer = EndLayerProviders.stackVoidLayers(this.biomeRegistry, seed);
        this.generator = new SimplexNoiseSampler(sharedseedrandom);
    }

    public static List<Identifier> createEndBiomeList(Registry<Biome> biomeRegistry) {
        List<Identifier> END_BIOMES = new ArrayList<>();

        for (Map.Entry<RegistryKey<Biome>, Biome> biomeEntry : biomeRegistry.getEntries()) {
            if (biomeEntry.getValue().getCategory() == Biome.Category.THEEND) {
                Identifier locationKey = biomeEntry.getKey().getValue();

                if (BYG.DIMENSIONS_CONFIG.EndDimension.Islands.IsBlackListEnd) {
                    //Avoid duping entries
                    if (!END_BIOMES.contains(locationKey) && !END_BIOME_IDS.contains(locationKey.toString())) {
                        END_BIOMES.add(locationKey);
                    }
                } else {
                    for (String id : END_BIOME_IDS) {
                        if (id.equals(locationKey.toString())) {
                            END_BIOMES.add(locationKey);
                        }
                    }
                }
                //if a datapack is using the same namespace as another mod, this is bad....like really bad.
                if (!FabricLoader.INSTANCE.getAllMods().stream().map(ModContainer::getMetadata).map(ModMetadata::getId).collect(Collectors.toSet()).contains(locationKey.getNamespace()) && !END_BIOMES.contains(locationKey)) {
                    END_BIOMES.add(locationKey);
                }
            }
        }
        END_BIOMES.removeIf(Objects::isNull);
        return END_BIOMES;
    }

    public static List<Identifier> createVoidEndBiomeList(Registry<Biome> biomeRegistry) {
        List<Identifier> END_VOID_BIOMES = new ArrayList<>();

        for (Map.Entry<RegistryKey<Biome>, Biome> biomeEntry : biomeRegistry.getEntries()) {
            if (biomeEntry.getValue().getCategory() == Biome.Category.THEEND) {
                Identifier locationKey = biomeEntry.getKey().getValue();
                for (String id : END_VOID_BIOME_IDS) {
                    if (id.equals(locationKey.toString()) && !END_VOID_BIOMES.contains(locationKey)) {
                        END_VOID_BIOMES.add(locationKey);
                    }
                }
            }
        }
        END_VOID_BIOMES.removeIf(Objects::isNull);
        return END_VOID_BIOMES;
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
            float f = TheEndBiomeSource.getNoiseAt(this.generator, xBitOffset * 2 + 1, zBitOffset * 2 + 1);
            if (f >= 0.0F) {
                return mainIslandLayer.sampleEnd(biomeRegistry, x, z);
            } else {
                return f < -20.0F ? this.smallIslandLayer.sampleEndVoid(biomeRegistry, x, z) : biomeRegistry.getOrThrow(BiomeKeys.END_BARRENS);
            }
        }
    }
}