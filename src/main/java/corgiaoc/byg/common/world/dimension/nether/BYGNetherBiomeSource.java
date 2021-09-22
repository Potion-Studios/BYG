package corgiaoc.byg.common.world.dimension.nether;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.common.world.dimension.end.SimpleLayerProvider;
import corgiaoc.byg.config.BYGBiomeWorldProperties;
import corgiaoc.byg.config.json.BYGConfigHandler;
import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.config.json.biomedata.WeightedBiomeData;
import corgiaoc.byg.mixin.access.WeightedRandomListAccess;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class BYGNetherBiomeSource extends BiomeSource {
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

        SimpleWeightedRandomList.Builder<ResourceKey<Biome>> biomes = SimpleWeightedRandomList.builder();
        Map<ResourceKey<Biome>, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>>> hills = new HashMap<>();
        Map<ResourceKey<Biome>, ResourceKey<Biome>> edges = new HashMap<>();
        Set<ResourceKey<Biome>> allBiomes = new HashSet<>();
        BiomeDataHolders.WeightedBiomeDataHolder netherData = BYGConfigHandler.processAndGet(gson, BYG.CONFIG_PATH.resolve("byg-nether-biomes.json"), BYGBiomeWorldProperties.NETHER_DEFAULTS, BiomeDataHolders.WeightedBiomeDataHolder.CODEC);
        Map<ResourceKey<Biome>, WeightedBiomeData> biomeData = netherData.getBiomeData();
        biomeData.remove(null);
        biomeData.remove(BYG.EMPTY);
        biomeData.forEach(((biome, endBiomeData) -> {
            biomes.add(biome, endBiomeData.getWeight());
            hills.put(biome, endBiomeData.getSubBiomes());
            ResourceKey<Biome> edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                edges.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.addAll(((WeightedRandomListAccess<WeightedEntry.Wrapper<ResourceKey<Biome>>>) endBiomeData.getSubBiomes()).getItems().stream().map(WeightedEntry.Wrapper::getData).collect(Collectors.toList()));
        }));

        edges.remove(BYG.EMPTY);
        hills.remove(BYG.EMPTY);
        allBiomes.remove(BYG.EMPTY);
        edges.remove(null);
        hills.remove(null);
        allBiomes.remove(null);
        this.possibleBiomes.addAll(allBiomes.stream().filter(resourceLocation -> resourceLocation != null && !resourceLocation.equals(BYG.EMPTY)).map(registry::get).collect(Collectors.toList()));
        this.biomeLayer = SimpleLayerProvider.stackLayers(this.biomeRegistry, seed, BYG.worldConfig().netherBiomeSize, biomes.build(), hills, edges);
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return BYGNETHERCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGNetherBiomeSource(biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return biomeLayer.sampleNether(biomeRegistry, x, z);
    }

}
