package corgiaoc.byg.common.world.dimension.end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.config.BYGBiomeWorldProperties;
import corgiaoc.byg.config.json.BYGConfigHandler;
import corgiaoc.byg.config.json.biomedata.BiomeData;
import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.config.json.biomedata.WeightedBiomeData;
import corgiaoc.byg.mixin.access.WeightedRandomListAccess;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.TheEndBiomeSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;

import java.util.*;
import java.util.stream.Collectors;

public class BYGEndBiomeSource extends BiomeSource {
    public static final Codec<BYGEndBiomeSource> BYGENDCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGEndBiomeSource::new)));

    private final long seed;
    private final DatapackLayer mainIslandLayer;
    private final DatapackLayer smallIslandLayer;
    private final Registry<Biome> biomeRegistry;
    private final SimplexNoise generator;

    @SuppressWarnings("unchecked")
    public BYGEndBiomeSource(Registry<Biome> registry, long seed) {
        super(new ArrayList<>());
        this.seed = seed;
        WorldgenRandom sharedseedrandom = new WorldgenRandom(seed);
        sharedseedrandom.consumeCount(17292);
        this.biomeRegistry = registry;
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        SimpleWeightedRandomList.Builder<ResourceKey<Biome>> endBiomes = SimpleWeightedRandomList.builder();
        Map<ResourceKey<Biome>, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>>> endHills = new HashMap<>();
        Map<ResourceKey<Biome>, ResourceKey<Biome>> biomeToEdge = new HashMap<>();
        Set<ResourceKey<Biome>> allBiomes = new HashSet<>();
        BiomeDataHolders.EndBiomeDataHolder endBiomeDataHolder = BYGConfigHandler.processAndGet(gson, BYG.CONFIG_PATH.resolve("byg-end-biomes.json"), BYGBiomeWorldProperties.END_DEFAULTS, BiomeDataHolders.EndBiomeDataHolder.CODEC);
        Map<ResourceKey<Biome>, WeightedBiomeData> endBiomeData1 = endBiomeDataHolder.getEndBiomeData();
        endBiomeData1.remove(null);
        endBiomeData1.remove(BYG.EMPTY);
        endBiomeData1.forEach(((biome, endBiomeData) -> {
            endBiomes.add(biome, endBiomeData.getWeight());
            endHills.put(biome, endBiomeData.getSubBiomes());
            ResourceKey<Biome> edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                biomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.addAll(((WeightedRandomListAccess<WeightedEntry.Wrapper<ResourceKey<Biome>>>) endBiomeData.getSubBiomes()).getItems().stream().map(WeightedEntry.Wrapper::getData).collect(Collectors.toList()));
        }));
        endHills.remove(BYG.EMPTY);
        biomeToEdge.remove(BYG.EMPTY);
        endHills.remove(null);
        biomeToEdge.remove(null);
        SimpleWeightedRandomList.Builder<ResourceKey<Biome>> voidBiomes = SimpleWeightedRandomList.builder();
        Map<ResourceKey<Biome>, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>>> voidHillsMap = new HashMap<>();
        Map<ResourceKey<Biome>, ResourceKey<Biome>> voidBiomeToEdge = new HashMap<>();

        Map<ResourceKey<Biome>, WeightedBiomeData> voidBiomeData = endBiomeDataHolder.getVoidBiomeData();
        voidBiomeData.remove(null);
        voidBiomeData.remove(BYG.EMPTY);
        voidBiomeData.forEach(((biome, endBiomeData) -> {
            voidBiomes.add(biome, endBiomeData.getWeight());
            voidHillsMap.put(biome, endBiomeData.getSubBiomes());
            ResourceKey<Biome> edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                voidBiomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.addAll(((WeightedRandomListAccess<WeightedEntry.Wrapper<ResourceKey<Biome>>>) endBiomeData.getSubBiomes()).getItems().stream().map(WeightedEntry.Wrapper::getData).collect(Collectors.toList()));
        }));

        BiomeDataHolders.EndSubBiomeDataHolder endSubBiomeDataHolder = new BiomeDataHolders.EndSubBiomeDataHolder(new HashMap<>(), new HashMap<>());

        Map<ResourceKey<Biome>, BiomeData> endSubBiomeData = endSubBiomeDataHolder.getEndSubBiomeData();
        endSubBiomeData.remove(null);
        endSubBiomeData.remove(BYG.EMPTY);
        endSubBiomeData.forEach(((biome, endBiomeData) -> {
            ResourceKey<Biome> edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                biomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.add(endBiomeData.getEdgeBiome());
        }));

        Map<ResourceKey<Biome>, BiomeData> voidSubBiomeData = endSubBiomeDataHolder.getVoidSubBiomeData();
        voidSubBiomeData.remove(null);
        voidBiomeData.remove(BYG.EMPTY);
        voidSubBiomeData.forEach(((biome, endBiomeData) -> {
            ResourceKey<Biome> edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                voidBiomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.add(endBiomeData.getEdgeBiome());
        }));
        voidHillsMap.remove(BYG.EMPTY);
        voidBiomeToEdge.remove(BYG.EMPTY);
        voidHillsMap.remove(null);
        voidBiomeToEdge.remove(null);
        this.possibleBiomes.addAll(allBiomes.stream().filter(resourceLocation -> resourceLocation != null && !resourceLocation.equals(BYG.EMPTY)).map(registry::get).collect(Collectors.toList()));
        this.mainIslandLayer = SimpleLayerProvider.stackLayers(this.biomeRegistry, seed, BYG.worldConfig().endBiomeSize, endBiomes.build(), endHills, biomeToEdge);
        this.smallIslandLayer = SimpleLayerProvider.stackLayers(this.biomeRegistry, seed, BYG.worldConfig().voidBiomeSize, voidBiomes.build(), voidHillsMap, voidBiomeToEdge);
        this.generator = new SimplexNoise(sharedseedrandom);
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return BYGENDCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGEndBiomeSource(biomeRegistry, seed);
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        int xBitOffset = x >> 2;
        int zBitOffset = z >> 2;
        if ((long) xBitOffset * (long) xBitOffset + (long) zBitOffset * (long) zBitOffset <= 4096L) {
            return biomeRegistry.getOrThrow(Biomes.THE_END);
        } else {
            float sampledNoise = TheEndBiomeSource.getHeightValue(this.generator, xBitOffset * 2 + 1, zBitOffset * 2 + 1);
            if (sampledNoise >= -20.0F) {
                return mainIslandLayer.sampleEnd(biomeRegistry, x, z);
            } else {
                return this.smallIslandLayer.sampleEndVoid(biomeRegistry, x, z);
            }
        }
    }
}