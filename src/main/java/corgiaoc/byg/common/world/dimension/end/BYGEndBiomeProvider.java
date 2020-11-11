package corgiaoc.byg.common.world.dimension.end;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.config.BYGWorldConfig;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
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
    public static List<ResourceLocation> END_BIOMES = new ArrayList<>();
    public static List<ResourceLocation> VOID_END_BIOMES = new ArrayList<>();
    private final Registry<Biome> biomeRegistry;
    private final SimplexNoiseGenerator generator;

    private static final List<String> END_BIOME_IDS = Arrays.asList(BYGWorldConfig.BLACKLIST_END.get().trim().replace(" ", "").split(","));
    private static final List<String> END_VOID_BIOME_IDS = Arrays.asList(BYGWorldConfig.VOID_BIOMES.get().trim().replace(" ", "").split(","));

    public BYGEndBiomeProvider(Registry<Biome> registry, long seed) {
        super(Stream.concat(createEndBiomeList(registry).stream(), createVoidEndBiomeList(registry).stream()).map(registry::getOrDefault).collect(Collectors.toList()));
        this.seed = seed;
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
        sharedseedrandom.skip(17292);
        biomeRegistry = registry;
        END_BIOMES = createEndBiomeList(this.biomeRegistry);
        VOID_END_BIOMES = createVoidEndBiomeList(this.biomeRegistry);
        this.mainIslandLayer = EndLayerProviders.stackLayers(this.biomeRegistry, seed);
        this.smallIslandLayer = EndLayerProviders.stackVoidLayers(this.biomeRegistry, seed);
        this.generator = new SimplexNoiseGenerator(sharedseedrandom);
    }

    public static List<ResourceLocation> createEndBiomeList(Registry<Biome> biomeRegistry) {
        List<ResourceLocation> END_BIOMES = new ArrayList<>();

        for (Map.Entry<RegistryKey<Biome>, Biome> biomeEntry : biomeRegistry.getEntries()) {
            if (biomeEntry.getValue().getCategory() == Biome.Category.THEEND) {
                ResourceLocation locationKey = biomeEntry.getKey().getLocation();

                if (BYGWorldConfig.IS_BLACKLIST_END.get()) {
                    //Avoid duping entries
                    if (!END_BIOMES.contains(locationKey) && !END_BIOME_IDS.contains(locationKey.toString())) {
                        END_BIOMES.add(locationKey);
                    }
                }
                else {
                    for (String id : END_BIOME_IDS) {
                        if (id.equals(locationKey.toString())) {
                            END_BIOMES.add(locationKey);
                        }
                    }
                }
                if (!END_BIOMES.contains(locationKey) && !END_BIOME_IDS.contains(locationKey.toString())) {
                    END_BIOMES.add(locationKey);
                }
            }
        }
        END_BIOMES.removeIf(Objects::isNull);
        return END_BIOMES;
    }

    public static List<ResourceLocation> createVoidEndBiomeList(Registry<Biome> biomeRegistry) {
        List<ResourceLocation> END_VOID_BIOMES = new ArrayList<>();

        for (Map.Entry<RegistryKey<Biome>, Biome> biomeEntry : biomeRegistry.getEntries()) {
            if (biomeEntry.getValue().getCategory() == Biome.Category.THEEND) {
                ResourceLocation locationKey = biomeEntry.getKey().getLocation();
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