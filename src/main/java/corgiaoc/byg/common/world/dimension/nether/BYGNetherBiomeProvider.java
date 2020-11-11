package corgiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.config.BYGWorldConfig;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.*;
import java.util.stream.Collectors;

public class BYGNetherBiomeProvider extends BiomeProvider {
    public static final Codec<BYGNetherBiomeProvider> BYGNETHERCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGNetherBiomeProvider::new)));

    private static final List<String> NETHER_BIOME_IDS = Arrays.asList(BYGWorldConfig.BLACKLIST_NETHER.get().trim().replace(" ", "").split(","));

    private final DatapackLayer biomeLayer;
    private final long seed;
    private final Registry<Biome> biomeRegistry;
    public static List<ResourceLocation> NETHER_BIOMES = new ArrayList<>();

    public BYGNetherBiomeProvider(Registry<Biome> registry, long seed) {
        super(createNetherBiomeList(registry).stream().map(registry::getOrDefault).collect(Collectors.toList()));
        this.seed = seed;
        biomeRegistry = registry;
        NETHER_BIOMES = createNetherBiomeList(registry);
        this.biomeLayer = BYGNetherLayerProvider.stackLayers(this.biomeRegistry, seed);
    }


    public static List<ResourceLocation> createNetherBiomeList(Registry<Biome> biomeRegistry) {
        List<ResourceLocation> NETHER_BIOMES = new ArrayList<>();

        for (Map.Entry<RegistryKey<Biome>, Biome> biomeEntry : biomeRegistry.getEntries()) {
            if (biomeEntry.getValue().getCategory() == Biome.Category.NETHER) {
                ResourceLocation locationKey = biomeEntry.getKey().getLocation();

                if (BYGWorldConfig.IS_BLACKLIST_NETHER.get()) {
                    //Avoid duping entries
                    if (!NETHER_BIOMES.contains(locationKey) && !NETHER_BIOME_IDS.contains(locationKey.toString())) {
                        NETHER_BIOMES.add(locationKey);
                    }
                }
                else {
                    for (String id : NETHER_BIOME_IDS) {
                        if (id.equals(locationKey.toString())) {
                            NETHER_BIOMES.add(locationKey);
                        }
                    }
                }
            }
        }
        NETHER_BIOMES.removeIf(Objects::isNull);
        return NETHER_BIOMES;
    }

    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return BYGNETHERCODEC;
    }

    @Override
    public BiomeProvider getBiomeProvider(long seed) {
        return new BYGNetherBiomeProvider(biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return biomeLayer.sampleNether(biomeRegistry, x, z);
    }

}
