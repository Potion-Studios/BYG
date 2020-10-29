package corgiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import net.fabricmc.loader.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;

import java.util.*;
import java.util.stream.Collectors;

public class BYGNetherBiomeProvider extends BiomeSource {
    public static final Codec<BYGNetherBiomeProvider> BYGNETHERCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGNetherBiomeProvider::new)));

    private static final List<String> NETHER_BIOME_IDS = Arrays.asList(BYG.DIMENSIONS_CONFIG.NetherDimension.BlackListNether.trim().replace(" ", "").split(","));

    private final DatapackLayer biomeLayer;
    private final long seed;
    private final Registry<Biome> biomeRegistry;
    public static List<Identifier> NETHER_BIOMES = new ArrayList<>();

    public BYGNetherBiomeProvider(Registry<Biome> registry, long seed) {
        super(createNetherBiomeList(registry).stream().map(registry::get).collect(Collectors.toList()));
        this.seed = seed;
        biomeRegistry = registry;
        NETHER_BIOMES = createNetherBiomeList(registry);
        this.biomeLayer = BYGNetherLayerProvider.stackLayers(this.biomeRegistry, seed);
    }


    public static List<Identifier> createNetherBiomeList(Registry<Biome> biomeRegistry) {
        List<Identifier> NETHER_BIOMES = new ArrayList<>();

        for (Map.Entry<RegistryKey<Biome>, Biome> biomeEntry : biomeRegistry.getEntries()) {
            if (biomeEntry.getValue().getCategory() == Biome.Category.NETHER) {
                Identifier locationKey = biomeEntry.getKey().getValue();

                if (BYG.DIMENSIONS_CONFIG.NetherDimension.IsBlackListNether) {
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
                //if a datapack is using the same namespace as another mod, this is bad....like really bad.
                if (!FabricLoader.INSTANCE.getAllMods().stream().map(ModContainer::getMetadata).map(ModMetadata::getId).collect(Collectors.toSet()).contains(locationKey.getNamespace()) && !NETHER_BIOMES.contains(locationKey)) {
                    NETHER_BIOMES.add(locationKey);
                }
            }
        }
        NETHER_BIOMES.removeIf(Objects::isNull);
        return NETHER_BIOMES;
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return BYGNETHERCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGNetherBiomeProvider(biomeRegistry, seed);
    }

    @Override
    public Biome getBiomeForNoiseGen(int x, int y, int z) {
        return biomeLayer.sampleNether(biomeRegistry, x, z);
    }

}
