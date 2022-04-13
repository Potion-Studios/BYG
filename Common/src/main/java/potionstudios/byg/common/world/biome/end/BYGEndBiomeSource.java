package potionstudios.byg.common.world.biome.end;

import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.mixin.access.BiomeSourceAccess;
import potionstudios.byg.util.BYGUtil;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import static net.minecraft.world.level.biome.TheEndBiomeSource.getHeightValue;
import static potionstudios.byg.util.BYGUtil.createBiomesFromBiomeData;

public abstract class BYGEndBiomeSource extends BiomeSource {
    public static final ResourceLocation LOCATION = BYG.createLocation("end");

    private final SimplexNoise islandNoise;
    private final Registry<Biome> biomeRegistry;
    private final BiomeResolver islandBiomeResolver;
    private final BiomeResolver voidBiomeResolver;
    private final BiomeResolver skyBiomeResolver;
    private final int skyLayersStartY;
    private final long seed;

    protected BYGEndBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        super(getPossibleBiomes(biomeRegistry));
        this.biomeRegistry = biomeRegistry;
        this.seed = seed;


        WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(seed));
        worldgenrandom.consumeCount(17292);
        this.islandNoise = new SimplexNoise(worldgenrandom);

        EndBiomesConfig config = EndBiomesConfig.getConfig();
        Set<ResourceKey<Biome>> possibleBiomes = ((BiomeSourceAccess) this).byg_getPossibleBiomes().stream().map(Holder::unwrapKey).map(Optional::orElseThrow).collect(Collectors.toSet());
        BiPredicate<Collection<ResourceKey<Biome>>, ResourceKey<Biome>> filter = (existing, added) -> !existing.contains(added) && possibleBiomes.contains(added);

        this.islandBiomeResolver = getIslandBiomeResolver(biomeRegistry, seed, config.islandLayers().filter(filter));
        this.voidBiomeResolver = getVoidBiomeResolver(biomeRegistry, seed, config.voidLayers().filter(filter));
        this.skyBiomeResolver = getSkyBiomeResolver(biomeRegistry, seed, config.skyLayers().filter(filter));
        this.skyLayersStartY = QuartPos.fromBlock(config.skyLayerStartY());
    }

    public abstract BiomeResolver getIslandBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData islandLayersBiomeData);

    public abstract BiomeResolver getVoidBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData voidLayersBiomeData);

    public abstract BiomeResolver getSkyBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData skyLayersBiomeData);


    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        int chunkX = x >> 2;
        int chunkZ = z >> 2;
        if ((long) chunkX * (long) chunkX + (long) chunkZ * (long) chunkZ <= 4096L) {
            return this.biomeRegistry.getHolderOrThrow(Biomes.THE_END);
        } else {
            if (y > this.skyLayersStartY) {
                return this.skyBiomeResolver.getNoiseBiome(x, y, z, sampler);
            } else {

                float heightValue = getHeightValue(this.islandNoise, chunkX * 2 + 1, chunkZ * 2 + 1);
                if (heightValue > 40.0F) {
                    return this.islandBiomeResolver.getNoiseBiome(x, y, z, sampler);
                } else if (heightValue >= 0.0F) {
                    return this.islandBiomeResolver.getNoiseBiome(x, y, z, sampler);
                } else {
                    return heightValue < -20.0F ? this.voidBiomeResolver.getNoiseBiome(x, y, z, sampler) : this.islandBiomeResolver.getNoiseBiome(x, y, z, sampler);
                }
            }
        }
    }

    protected Registry<Biome> getBiomeRegistry() {
        return biomeRegistry;
    }

    protected long getSeed() {
        return seed;
    }

    @NotNull
    private static List<Holder<Biome>> getPossibleBiomes(Registry<Biome> biomeRegistry) {
        EndBiomesConfig config = EndBiomesConfig.getConfig(true, biomeRegistry);

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
            BYG.LOGGER.warn(String.format("Config \"%s\" warned:\nThe following biome entries were ignored due to not being in this world's biome registry:\n%s", EndBiomesConfig.CONFIG_PATH.get(), ignored.toString()));
        }

        List<Holder<Biome>> biomesFromBiomeData = createBiomesFromBiomeData(biomeRegistry, usedIslandLayer, usedVoidLayer, usedSkyLayer);
        biomesFromBiomeData.add(biomeRegistry.getHolderOrThrow(Biomes.THE_END));
        return biomesFromBiomeData;
    }
}