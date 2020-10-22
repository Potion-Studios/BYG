package corgiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BYGNetherBiomeProvider extends BiomeProvider {
    public static final Codec<BYGNetherBiomeProvider> BYGNETHERCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGNetherBiomeProvider::new)));

    private final DatapackLayer biomeLayer;
    private final long seed;
    private final Registry<Biome> biomeRegistry;
    public static List<ResourceLocation> NETHER_BIOMES = new ArrayList<>();

    public BYGNetherBiomeProvider(Registry<Biome> registry, long seed) {
        super(registry.getEntries().stream()
                .filter(registryKeyBiomeEntry ->{
                    BYG.LOGGER.info(registryKeyBiomeEntry.getKey().getLocation().toString());

                    NETHER_BIOMES.forEach(yuh -> BYG.LOGGER.info("NETHER BIOMES: " + yuh.toString()));
                    return NETHER_BIOMES.contains(registryKeyBiomeEntry.getKey().getLocation());
                })
                .map(Map.Entry::getValue).collect(Collectors.toList()));
        this.seed = seed;
        biomeRegistry = registry;
        this.biomeLayer = BYGNetherLayerProvider.stackLayers(this.biomeRegistry, seed);
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
