package corgiaoc.byg.common.world.dimension.nether;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.common.world.dimension.end.SimpleLayerProvider;
import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.mixin.access.WeightedListAccess;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class BYGNetherBiomeSource extends BiomeProvider {
    public static final Codec<BYGNetherBiomeSource> BYGNETHERCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGNetherBiomeSource::new)));

    private final DatapackLayer biomeLayer;
    private final long seed;
    private final Registry<Biome> biomeRegistry;
    public static List<ResourceLocation> NETHER_BIOMES = new ArrayList<>();

    public BYGNetherBiomeSource(Registry<Biome> registry, long seed) {
        super(new ArrayList<>());
        this.seed = seed;
        biomeRegistry = registry;
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        WeightedList<ResourceLocation> biomes = new WeightedList<>();
        Map<ResourceLocation, WeightedList<ResourceLocation>> hills = new HashMap<>();
        Map<ResourceLocation, ResourceLocation> edges = new HashMap<>();
        Set<ResourceLocation> allBiomes = new HashSet<>();
        BiomeDataHolders.WeightedBiomeDataHolder endWeightedBiomeDataHolder = BYG.getNetherData(gson, BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-nether-biomes.json"));
        endWeightedBiomeDataHolder.getBiomeData().forEach(((biome, endBiomeData) -> {
            biomes.add(biome, endBiomeData.getWeight());
            hills.put(biome, endBiomeData.getSubBiomes());
            edges.put(biome, endBiomeData.getEdgeBiome());
            allBiomes.addAll(((WeightedListAccess<ResourceLocation>) endBiomeData.getSubBiomes()).getEntries().stream().map(WeightedList.Entry::getData).collect(Collectors.toList()));
        }));
        this.possibleBiomes.addAll(allBiomes.stream().map(registry::get).collect(Collectors.toList()));
        this.biomeLayer = SimpleLayerProvider.stackLayers(this.biomeRegistry, seed, BYG.worldConfig().netherBiomeSize, biomes, hills, edges);
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
