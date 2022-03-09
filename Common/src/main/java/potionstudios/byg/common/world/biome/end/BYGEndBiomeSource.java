package potionstudios.byg.common.world.biome.end;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.LayersBiomeData;

import java.util.List;

import static net.minecraft.world.level.biome.TheEndBiomeSource.getHeightValue;
import static potionstudios.byg.util.BYGUtil.createBiomesFromBiomeData;

public abstract class BYGEndBiomeSource extends BiomeSource {
    public static final ResourceLocation LOCATION = BYG.createLocation("end");

    private final SimplexNoise islandNoise;
    private final Registry<Biome> biomeRegistry;
    private final LayersBiomeData islandLayersBiomeData;
    private final LayersBiomeData voidLayersBiomeData;
    private final LayersBiomeData skyLayersBiomeData;
    private final BiomeResolver islandBiomeResolver;
    private final BiomeResolver voidBiomeResolver;
    private final BiomeResolver skyBiomeResolver;
    private final int skyLayersStartY;
    private final long seed;

    protected BYGEndBiomeSource(Registry<Biome> biomeRegistry, long seed, LayersBiomeData islandLayersBiomeData, LayersBiomeData voidLayersBiomeData, LayersBiomeData skyLayersBiomeData) {
        super(Util.make(() -> {
            EndBiomesConfig config = EndBiomesConfig.getConfig(true, biomeRegistry);
            LayersBiomeData usedIslandLayer = config.useUpdatingConfig() ? config.islandLayers() : islandLayersBiomeData;
            LayersBiomeData usedVoidLayer = config.useUpdatingConfig() ? config.voidLayers() : voidLayersBiomeData;
            LayersBiomeData usedSkyLayer = config.useUpdatingConfig() ? config.skyLayers() : skyLayersBiomeData;
            List<Holder<Biome>> biomesFromBiomeData = createBiomesFromBiomeData(biomeRegistry, usedIslandLayer, usedVoidLayer, usedSkyLayer);
            biomesFromBiomeData.add(biomeRegistry.getHolderOrThrow(Biomes.THE_END));
            return biomesFromBiomeData;
        }));
        this.biomeRegistry = biomeRegistry;
        this.seed = seed;


        WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(seed));
        worldgenrandom.consumeCount(17292);
        this.islandNoise = new SimplexNoise(worldgenrandom);
        this.islandLayersBiomeData = islandLayersBiomeData;
        this.voidLayersBiomeData = voidLayersBiomeData;
        this.skyLayersBiomeData = skyLayersBiomeData;
        EndBiomesConfig config = EndBiomesConfig.getConfig(true);

        LayersBiomeData usedIslandLayer = config.useUpdatingConfig() ? config.islandLayers() : islandLayersBiomeData;
        LayersBiomeData usedVoidLayer = config.useUpdatingConfig() ? config.voidLayers() : voidLayersBiomeData;
        LayersBiomeData usedSkyLayer = config.useUpdatingConfig() ? config.skyLayers() : skyLayersBiomeData;

        this.islandBiomeResolver = getIslandBiomeResolver(biomeRegistry, seed, usedIslandLayer);
        this.voidBiomeResolver = getVoidBiomeResolver(biomeRegistry, seed, usedVoidLayer);
        this.skyBiomeResolver = getSkyBiomeResolver(biomeRegistry, seed, usedSkyLayer);
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

    public Registry<Biome> getBiomeRegistry() {
        return biomeRegistry;
    }

    public LayersBiomeData getIslandLayersBiomeData() {
        return islandLayersBiomeData;
    }

    public LayersBiomeData getVoidLayersBiomeData() {
        return voidLayersBiomeData;
    }

    public LayersBiomeData getSkyLayersBiomeData() {
        return skyLayersBiomeData;
    }

    public long getSeed() {
        return seed;
    }
}