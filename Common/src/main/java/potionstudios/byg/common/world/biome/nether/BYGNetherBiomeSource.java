package potionstudios.byg.common.world.biome.nether;

import net.minecraft.Util;
import net.minecraft.core.QuartPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.common.world.math.noise.fastnoise.lite.FastNoiseLite;
import potionstudios.byg.mixin.access.WeightedListAccess;

import java.util.ArrayList;
import java.util.List;

public abstract class BYGNetherBiomeSource extends BiomeSource {
    public static final ResourceLocation LOCATION = BYG.createLocation("nether");

    private final FastNoiseLite layerRoughnessNoise;
    private final Registry<Biome> biomeRegistry;
    private final LayersBiomeData upperLayerBiomeData;
    private final LayersBiomeData middleLayerBiomeData;
    private final LayersBiomeData bottomLayerBiomeData;
    private final BiomeResolver upperBiomeResolver;
    private final BiomeResolver middleBiomeResolver;
    private final BiomeResolver bottomResolver;
    private final int bottomTopY;
    private final long seed;

    protected BYGNetherBiomeSource(Registry<Biome> biomeRegistry, long seed, LayersBiomeData upperLayerBiomeData, LayersBiomeData middleLayerBiomeData, LayersBiomeData bottomLayerBiomeData) {
        super(Util.make(() -> {
            NetherBiomesConfig config = NetherBiomesConfig.getConfig(true);
            LayersBiomeData usedUpperLayer = config.useUpdatingConfig() ? config.upperLayer() : upperLayerBiomeData;
            LayersBiomeData usedMiddleLayer = config.useUpdatingConfig() ? config.middleLayer() : middleLayerBiomeData;
            LayersBiomeData usedBottomLayer = config.useUpdatingConfig() ? config.bottomLayer() : bottomLayerBiomeData;
            return createBiomesFromBiomeData(biomeRegistry, usedUpperLayer, usedMiddleLayer, usedBottomLayer);
        }));
        this.biomeRegistry = biomeRegistry;
        this.seed = seed;


        this.layerRoughnessNoise = new FastNoiseLite((int) seed);
        this.layerRoughnessNoise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        this.layerRoughnessNoise.SetFrequency(0.05F);
        this.upperLayerBiomeData = upperLayerBiomeData;
        this.middleLayerBiomeData = middleLayerBiomeData;
        this.bottomLayerBiomeData = bottomLayerBiomeData;
        NetherBiomesConfig config = NetherBiomesConfig.getConfig(true);

        LayersBiomeData usedUpperLayer = config.useUpdatingConfig() ? config.upperLayer() : upperLayerBiomeData;
        LayersBiomeData usedMiddleLayer = config.useUpdatingConfig() ? config.middleLayer() : middleLayerBiomeData;
        LayersBiomeData usedBottomLayer = config.useUpdatingConfig() ? config.bottomLayer() : bottomLayerBiomeData;

        this.upperBiomeResolver = getUpperBiomeResolver(biomeRegistry, seed, usedUpperLayer);
        this.middleBiomeResolver = getMiddleBiomeResolver(biomeRegistry, seed, usedMiddleLayer);
        this.bottomResolver = getLowerBiomeResolver(biomeRegistry, seed, usedBottomLayer);
        this.bottomTopY = QuartPos.fromBlock(40);
    }

    public abstract BiomeResolver getUpperBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData upperLayerBiomeData);

    public abstract BiomeResolver getMiddleBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData middleLayerBiomeData);

    public abstract BiomeResolver getLowerBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData lowerLayerBiomeData);


    @Override
    public Biome getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        float noise = Math.abs(this.layerRoughnessNoise.GetNoise(x, z)) * 9;

        if (y < bottomTopY + noise) {
            return this.bottomResolver.getNoiseBiome(x, y, z, sampler);
        } else if (y > bottomTopY + bottomTopY + noise) {
            return this.upperBiomeResolver.getNoiseBiome(x, y, z, sampler);
        } else {
            return this.middleBiomeResolver.getNoiseBiome(x, y, z, sampler);
        }
    }

    public Registry<Biome> getBiomeRegistry() {
        return biomeRegistry;
    }

    public LayersBiomeData getUpperLayerBiomeData() {
        return upperLayerBiomeData;
    }

    public LayersBiomeData getMiddleLayerBiomeData() {
        return middleLayerBiomeData;
    }

    public LayersBiomeData getBottomLayerBiomeData() {
        return bottomLayerBiomeData;
    }

    public long getSeed() {
        return seed;
    }

    @SuppressWarnings("unchecked")
    public static List<Biome> createBiomesFromBiomeData(Registry<Biome> biomeRegistry, LayersBiomeData... layersBiomeDatas) {
        List<Biome> biomes = new ArrayList<>();
        for (LayersBiomeData layersBiomeData : layersBiomeDatas) {
            ((WeightedListAccess<WeightedEntry.Wrapper<ResourceKey<Biome>>>) layersBiomeData.biomeWeights()).getItems().stream().map(WeightedEntry.Wrapper::getData).map(biomeRegistry::get).forEach(biomes::add);
        }
        return biomes;
    }
}