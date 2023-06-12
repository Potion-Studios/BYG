package potionstudios.byg.common.world.biome.end;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.DensityFunction;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.LayerUtil;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.common.world.biome.LazyLoadSeed;
import potionstudios.byg.util.BYGUtil;
import terrablender.worldgen.noise.Area;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import static potionstudios.byg.util.BYGUtil.createBiomesFromBiomeData;

public class BYGEndBiomeSource extends BiomeSource implements LazyLoadSeed {

    public static final Codec<BYGEndBiomeSource> CODEC = Codec.unit(BYGEndBiomeSource::new);

    public static final ResourceLocation LOCATION = BYG.createLocation("end");

    private Registry<Biome> biomeRegistry;

    private BiomeResolver islandBiomeResolver;
    private BiomeResolver voidBiomeResolver;
    private BiomeResolver skyBiomeResolver;
    private final int skyLayersStartY;

    public BYGEndBiomeSource() {
        super(new ArrayList<>());

        EndBiomesConfig config = EndBiomesConfig.getConfig();

        this.skyLayersStartY = QuartPos.fromBlock(config.skyLayerStartY());
    }


    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        int quartX = QuartPos.toBlock(x);
        int quartY = QuartPos.toBlock(y);
        int quartZ = QuartPos.toBlock(z);

        int chunkX = x >> 2;
        int chunkZ = z >> 2;
        if ((long) chunkX * (long) chunkX + (long) chunkZ * (long) chunkZ <= 4096L) {
            return this.biomeRegistry.getHolderOrThrow(Biomes.THE_END);
        } else {
            if (y > this.skyLayersStartY) {
                return this.skyBiomeResolver.getNoiseBiome(x, y, z, sampler);
            } else {

                double heightValue = sampler.erosion().compute(new DensityFunction.SinglePointContext(quartX, quartY, quartZ));
                if (heightValue > 40.0) {
                    return this.islandBiomeResolver.getNoiseBiome(x, y, z, sampler);
                } else if (heightValue >= 0.0) {
                    return this.islandBiomeResolver.getNoiseBiome(x, y, z, sampler);
                } else {
                    return heightValue < -20.0 ? this.voidBiomeResolver.getNoiseBiome(x, y, z, sampler) : this.islandBiomeResolver.getNoiseBiome(x, y, z, sampler);
                }
            }
        }
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    public void lazyLoad(long seed, Registry<Biome> biomeRegistry) {
        this.biomeRegistry = biomeRegistry;
        this.possibleBiomes().addAll(getPossibleBiomes(biomeRegistry));

        EndBiomesConfig config = EndBiomesConfig.getConfig();
        Set<ResourceKey<Biome>> possibleBiomes = possibleBiomes().stream().map(Holder::unwrapKey).map(Optional::orElseThrow).collect(Collectors.toSet());
        BiPredicate<Collection<ResourceKey<Biome>>, ResourceKey<Biome>> filter = (existing, added) -> !existing.contains(added) && possibleBiomes.contains(added);
        this.islandBiomeResolver = getIslandBiomeResolver(biomeRegistry, seed, config.islandLayers().filter(filter));
        this.voidBiomeResolver = getVoidBiomeResolver(biomeRegistry, seed, config.voidLayers().filter(filter));
        this.skyBiomeResolver = getSkyBiomeResolver(biomeRegistry, seed, config.skyLayers().filter(filter));
    }

    @NotNull
    private static List<Holder<Biome>> getPossibleBiomes(Registry<Biome> biomeRegistry) {
        EndBiomesConfig config = EndBiomesConfig.getConfig(false, false, biomeRegistry);

        Set<String> missingBiomes = new TreeSet<>();
        BiPredicate<Collection<ResourceKey<Biome>>, ResourceKey<Biome>> filter = (existing, added) -> {
            boolean biomeRegistryHas = biomeRegistry.containsKey(added);

            if (!biomeRegistryHas) {
                missingBiomes.add(added.location().toString());
            }

            return !existing.contains(added) && biomeRegistryHas;
        };

        LayersBiomeData usedIslandLayer = config.islandLayers().filter(filter);
        LayersBiomeData usedVoidLayer = config.voidLayers().filter(filter);
        LayersBiomeData usedSkyLayer = config.skyLayers().filter(filter);

        String ignored = BYGUtil.dumpCollection(missingBiomes);
        if (!ignored.isEmpty()) {
            BYG.logWarning(String.format("Config \"%s\" warned:\nThe following biome entries were ignored due to not being in this world's biome registry:\n%s", EndBiomesConfig.CONFIG_PATH.get(), ignored.toString()));
        }

        List<Holder<Biome>> biomesFromBiomeData = createBiomesFromBiomeData(biomeRegistry, usedIslandLayer, usedVoidLayer, usedSkyLayer);
        biomesFromBiomeData.add(biomeRegistry.getHolderOrThrow(Biomes.THE_END));
        return biomesFromBiomeData;
    }


    public static BiomeResolver getIslandBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData islandLayersBiomeData) {
        Area layers = LayerUtil.createLayers(biomeRegistry, seed, islandLayersBiomeData.biomeWeights(), islandLayersBiomeData.biomeSize(), EndBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    public static BiomeResolver getVoidBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData voidLayersBiomeData) {
        Area layers = LayerUtil.createLayers(biomeRegistry, seed, voidLayersBiomeData.biomeWeights(), voidLayersBiomeData.biomeSize(), EndBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    public static BiomeResolver getSkyBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData skyLayersBiomeData) {
        Area layers = LayerUtil.createLayers(biomeRegistry, seed, skyLayersBiomeData.biomeWeights(), skyLayersBiomeData.biomeSize(), EndBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }
}