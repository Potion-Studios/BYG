package corgiaoc.byg.common.world.dimension.end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.mixin.access.WeightedRandomListAccess;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.resources.ResourceLocation;
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

        SimpleWeightedRandomList.Builder<ResourceLocation> endBiomes = SimpleWeightedRandomList.builder();
        Map<ResourceLocation, WeightedRandomList<WeightedEntry.Wrapper<ResourceLocation>>> endHills = new HashMap<>();
        Map<ResourceLocation, ResourceLocation> biomeToEdge = new HashMap<>();
        Set<ResourceLocation> allBiomes = new HashSet<>();
        BiomeDataHolders.EndBiomeDataHolder endBiomeDataHolder = new BiomeDataHolders.EndBiomeDataHolder(new HashMap<>(), new HashMap<>());
        endBiomeDataHolder.getEndBiomeData().forEach(((biome, endBiomeData) -> {
            endBiomes.add(biome, endBiomeData.getWeight());
            endHills.put(biome, endBiomeData.getSubBiomes());
            ResourceLocation edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                biomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.addAll(((WeightedRandomListAccess<WeightedEntry.Wrapper<ResourceLocation>>) endBiomeData.getSubBiomes()).getItems().stream().map(WeightedEntry.Wrapper::getData).collect(Collectors.toList()));
        }));
        endHills.remove(BYG.EMPTY);
        biomeToEdge.remove(BYG.EMPTY);

        SimpleWeightedRandomList.Builder<ResourceLocation> voidBiomes = SimpleWeightedRandomList.builder();
        Map<ResourceLocation, WeightedRandomList<WeightedEntry.Wrapper<ResourceLocation>>> voidHillsMap = new HashMap<>();
        Map<ResourceLocation, ResourceLocation> voidBiomeToEdge = new HashMap<>();

        endBiomeDataHolder.getVoidBiomeData().forEach(((biome, endBiomeData) -> {
            voidBiomes.add(biome, endBiomeData.getWeight());
            voidHillsMap.put(biome, endBiomeData.getSubBiomes());
            ResourceLocation edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                voidBiomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.addAll(((WeightedRandomListAccess<WeightedEntry.Wrapper<ResourceLocation>>) endBiomeData.getSubBiomes()).getItems().stream().map(WeightedEntry.Wrapper::getData).collect(Collectors.toList()));
        }));

        BiomeDataHolders.EndSubBiomeDataHolder endSubBiomeDataHolder = new BiomeDataHolders.EndSubBiomeDataHolder(new HashMap<>(), new HashMap<>());

        endSubBiomeDataHolder.getEndSubBiomeData().forEach(((biome, endBiomeData) -> {
            ResourceLocation edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                biomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.add(endBiomeData.getEdgeBiome());
        }));

        endSubBiomeDataHolder.getVoidSubBiomeData().forEach(((biome, endBiomeData) -> {
            ResourceLocation edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                voidBiomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.add(endBiomeData.getEdgeBiome());
        }));
        voidHillsMap.remove(BYG.EMPTY);
        voidBiomeToEdge.remove(BYG.EMPTY);
        this.possibleBiomes.addAll(allBiomes.stream().map(registry::get).collect(Collectors.toList()));
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