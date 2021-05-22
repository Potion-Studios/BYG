package corgiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.config.NetherConfig;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.*;
import java.util.stream.Collectors;

public class BYGNetherBiomeSource extends BiomeProvider {
    public static final Codec<BYGNetherBiomeSource> BYGNETHERCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGNetherBiomeSource::new)));

    private static final List<String> NETHER_BIOME_IDS = Arrays.asList(NetherConfig.BLACKLIST_NETHER.get().trim().replace(" ", "").split(","));

    private final DatapackLayer biomeLayer;
    private final long seed;
    private final Registry<Biome> biomeRegistry;
    public static List<ResourceLocation> NETHER_BIOMES = new ArrayList<>();

    public BYGNetherBiomeSource(Registry<Biome> registry, long seed) {
        super(createNetherBiomeList(registry).stream().map(registry::get).collect(Collectors.toList()));
        this.seed = seed;
        biomeRegistry = registry;
        NETHER_BIOMES = createNetherBiomeList(registry);
        this.biomeLayer = BYGNetherLayerProvider.stackLayers(this.biomeRegistry, seed);
    }


    public static List<ResourceLocation> createNetherBiomeList(Registry<Biome> biomeRegistry) {
        List<ResourceLocation> NETHER_BIOMES = new ArrayList<>();

        for (Map.Entry<RegistryKey<Biome>, Biome> biomeEntry : biomeRegistry.entrySet()) {
            if (biomeEntry.getValue().getBiomeCategory() == Biome.Category.NETHER) {
                ResourceLocation locationKey = biomeEntry.getKey().location();

                if (NetherConfig.IS_BLACKLIST_NETHER.get()) {
                    //Avoid duping entries
                    if (!NETHER_BIOMES.contains(locationKey) && !NETHER_BIOME_IDS.contains(locationKey.toString())) {
                        NETHER_BIOMES.add(locationKey);
                    }
                } else {
                    for (String id : NETHER_BIOME_IDS) {
                        if (id.equals(locationKey.toString())) {
                            NETHER_BIOMES.add(locationKey);
                        }
                    }
                }
            }
        }
        NETHER_BIOMES.removeIf(Objects::isNull);
        NETHER_BIOMES.sort(Comparator.comparing(ResourceLocation::toString));
        return NETHER_BIOMES;
    }

    @Override
    protected Codec<? extends BiomeProvider> codec() {
        return BYGNETHERCODEC;
    }

    @Override
    public BiomeProvider withSeed(long seed) {
        return new BYGNetherBiomeSource(biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return biomeLayer.sampleNether(biomeRegistry, x, z);
    }

}
