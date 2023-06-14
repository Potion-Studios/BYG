package potionstudios.byg.common.world.biome.nether;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.LayerUtil;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.common.world.biome.LazyLoadSeed;
import potionstudios.byg.common.world.math.noise.fastnoise.lite.FastNoiseLite;
import potionstudios.byg.mixin.access.BiomeSourceAccess;
import potionstudios.byg.util.BYGUtil;
import terrablender.worldgen.noise.Area;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static potionstudios.byg.util.BYGUtil.createBiomesFromBiomeData;

public class BYGNetherBiomeSource extends BiomeSource implements LazyLoadSeed {
    public static final ResourceLocation LOCATION = BYG.createLocation("nether");

    public static final Codec<BYGNetherBiomeSource> CODEC = Codec.unit(BYGNetherBiomeSource::new);

    private FastNoiseLite lowerLayerRoughnessNoise;
    private FastNoiseLite upperLayerRoughnessNoise;
    private BiomeResolver upperBiomeResolver;
    private BiomeResolver middleBiomeResolver;
    private BiomeResolver bottomResolver;
    private final int bottomTopY;

    public BYGNetherBiomeSource() {
        super();

        NetherBiomesConfig config = NetherBiomesConfig.getConfig();

        int usedLayerSize = config.layerSize();
        this.bottomTopY = QuartPos.fromBlock(usedLayerSize);
    }

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

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return Stream.empty();
    }

    @Override
    public void lazyLoad(long seed, Registry<Biome> biomeRegistry) {
        ((BiomeSourceAccess) this).byg_setPossibleBiomes(Suppliers.memoize(() -> getPossibleBiomes(biomeRegistry).stream().collect(ObjectOpenHashSet.toSet())));
        NetherBiomesConfig config = NetherBiomesConfig.getConfig();
        Set<ResourceKey<Biome>> possibleBiomes = possibleBiomes().stream().map(Holder::unwrapKey).map(Optional::orElseThrow).collect(Collectors.toSet());
        BiPredicate<Collection<ResourceKey<Biome>>, ResourceKey<Biome>> filter = (existing, added) -> !existing.contains(added) && possibleBiomes.contains(added);

        this.lowerLayerRoughnessNoise = new FastNoiseLite((int) seed);
        this.lowerLayerRoughnessNoise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        this.lowerLayerRoughnessNoise.SetFrequency(0.005F);

        this.upperLayerRoughnessNoise = new FastNoiseLite((int) seed + 43594389);
        this.upperLayerRoughnessNoise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        this.upperLayerRoughnessNoise.SetFrequency(0.005F);

        this.upperBiomeResolver = getUpperBiomeResolver(biomeRegistry, seed, config.upperLayer().filter(filter));
        this.middleBiomeResolver = getMiddleBiomeResolver(biomeRegistry, seed, config.middleLayer().filter(filter));
        this.bottomResolver = getLowerBiomeResolver(biomeRegistry, seed, config.bottomLayer().filter(filter));
    }

    @NotNull
    private static List<Holder<Biome>> getPossibleBiomes(Registry<Biome> biomeRegistry) {
        NetherBiomesConfig config = NetherBiomesConfig.getConfig(false, false, biomeRegistry);

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
            BYG.logWarning(String.format("Config \"%s\" warned:\nThe following biome entries were ignored due to not being in this world's biome registry:\n%s", NetherBiomesConfig.CONFIG_PATH.get(), ignored));
        }
        return createBiomesFromBiomeData(biomeRegistry, upperLayer, middleLayer, bottomLayer);
    }

    public static BiomeResolver getUpperBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData upperLayerBiomeData) {
        Area layers = LayerUtil.createLayers(biomeRegistry, seed, upperLayerBiomeData.biomeWeights(), upperLayerBiomeData.biomeSize(), NetherBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    public static BiomeResolver getMiddleBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData middleLayerBiomeData) {
        Area layers = LayerUtil.createLayers(biomeRegistry, seed, middleLayerBiomeData.biomeWeights(), middleLayerBiomeData.biomeSize(), NetherBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    public static BiomeResolver getLowerBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData lowerLayerBiomeData) {
        Area layers = LayerUtil.createLayers(biomeRegistry, seed, lowerLayerBiomeData.biomeWeights(), lowerLayerBiomeData.biomeSize(), NetherBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }
}