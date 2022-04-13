package potionstudios.byg.common.world.biome.nether;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.common.world.math.noise.fastnoise.lite.FastNoiseLite;
import potionstudios.byg.util.BYGUtil;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiPredicate;

import static potionstudios.byg.util.BYGUtil.createBiomesFromBiomeData;

public abstract class BYGNetherBiomeSource extends BiomeSource {
    public static final ResourceLocation LOCATION = BYG.createLocation("nether");

    private final FastNoiseLite lowerLayerRoughnessNoise;
    private final FastNoiseLite upperLayerRoughnessNoise;
    private final Registry<Biome> biomeRegistry;
    private final LayersBiomeData upperLayerBiomeData;
    private final LayersBiomeData middleLayerBiomeData;
    private final LayersBiomeData bottomLayerBiomeData;
    private final BiomeResolver upperBiomeResolver;
    private final BiomeResolver middleBiomeResolver;
    private final BiomeResolver bottomResolver;
    private final int bottomTopY;
    private final long seed;

    protected BYGNetherBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        super(Util.make(() -> {
            NetherBiomesConfig config = NetherBiomesConfig.getConfig(true, biomeRegistry);

            Set<String> missingBiomes = new TreeSet<>();
            BiPredicate<Collection<ResourceKey<Biome>>, ResourceKey<Biome>> filter = (existing, added) -> {
                boolean biomeRegistryHas = biomeRegistry.containsKey(added);

                if (!biomeRegistryHas) {
                    missingBiomes.add(added.location().toString());
                }

                return !existing.contains(added) && biomeRegistryHas;
            };

            LayersBiomeData upperLayer = config.upperLayer().filter(filter);
            LayersBiomeData middleLayer = config.middleLayer().filter(filter);
            LayersBiomeData bottomLayer = config.bottomLayer().filter(filter);

            String ignored = BYGUtil.dumpCollection(missingBiomes);
            if (!ignored.isEmpty()) {
                BYG.LOGGER.warn(String.format("Config \"%s\" warned:\nThe following biome entries were ignored due to not being in this world's biome registry:\n%s", NetherBiomesConfig.CONFIG_PATH.get(), ignored.toString()));
            }
            return createBiomesFromBiomeData(biomeRegistry, upperLayer, middleLayer, bottomLayer);
        }));
        this.biomeRegistry = biomeRegistry;
        this.seed = seed;


        this.lowerLayerRoughnessNoise = new FastNoiseLite((int) seed);
        this.lowerLayerRoughnessNoise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        this.lowerLayerRoughnessNoise.SetFrequency(0.005F);

        this.upperLayerRoughnessNoise = new FastNoiseLite((int) seed + 43594389);
        this.upperLayerRoughnessNoise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        this.upperLayerRoughnessNoise.SetFrequency(0.005F);
        NetherBiomesConfig config = NetherBiomesConfig.getConfig();
        BiPredicate<Collection<ResourceKey<Biome>>, ResourceKey<Biome>> filter = (existing, added) -> !existing.contains(added) && biomeRegistry.containsKey(added);

        this.upperLayerBiomeData = config.upperLayer().filter(filter);
        this.middleLayerBiomeData = config.middleLayer().filter(filter);
        this.bottomLayerBiomeData = config.bottomLayer().filter(filter);

        int usedLayerSize = config.layerSize();

        this.upperBiomeResolver = getUpperBiomeResolver(biomeRegistry, seed, upperLayerBiomeData);
        this.middleBiomeResolver = getMiddleBiomeResolver(biomeRegistry, seed, middleLayerBiomeData);
        this.bottomResolver = getLowerBiomeResolver(biomeRegistry, seed, bottomLayerBiomeData);
        this.bottomTopY = QuartPos.fromBlock(usedLayerSize);
    }

    public abstract BiomeResolver getUpperBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData upperLayerBiomeData);

    public abstract BiomeResolver getMiddleBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData middleLayerBiomeData);

    public abstract BiomeResolver getLowerBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData lowerLayerBiomeData);


    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        if (y < bottomTopY + this.lowerLayerRoughnessNoise.GetNoise(x, z) * 5) {
            return this.bottomResolver.getNoiseBiome(x, y, z, sampler);
        } else if (y > bottomTopY + bottomTopY + this.upperLayerRoughnessNoise.GetNoise(x, z) * 5) {
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

    public int getBottomTopY() {
        return QuartPos.toBlock(bottomTopY);
    }
}