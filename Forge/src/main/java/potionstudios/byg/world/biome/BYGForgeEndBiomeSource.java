package potionstudios.byg.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.biome.BiomeSource;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.end.EndBiomesConfig;
import terrablender.worldgen.noise.Area;

import static potionstudios.byg.world.biome.LayerUtil.createLayers;

public class BYGForgeEndBiomeSource extends BYGEndBiomeSource {
    public static final Codec<BYGForgeEndBiomeSource> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getBiomeRegistry();
        }), Codec.LONG.fieldOf("seed").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getSeed();
        }), LayersBiomeData.CODEC.fieldOf("islandLayersBiomeData").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getIslandLayersBiomeData();
        }), LayersBiomeData.CODEC.fieldOf("voidLayersBiomeData").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getVoidLayersBiomeData();
        }), LayersBiomeData.CODEC.fieldOf("skyLayersBiomeData").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getSkyLayersBiomeData();
        })).apply(builder, builder.stable(BYGForgeEndBiomeSource::new));
    });

    public BYGForgeEndBiomeSource(Registry<Biome> biomeRegistry, long seed, LayersBiomeData islandLayersBiomeData, LayersBiomeData voidLayersBiomeData, LayersBiomeData skyLayersBiomeData) {
        super(biomeRegistry, seed, islandLayersBiomeData, voidLayersBiomeData, skyLayersBiomeData);
    }

    @Override
    public BiomeResolver getIslandBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData islandLayersBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, islandLayersBiomeData.biomeWeights(), islandLayersBiomeData.biomeSize(), EndBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    @Override
    public BiomeResolver getVoidBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData voidLayersBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, voidLayersBiomeData.biomeWeights(), voidLayersBiomeData.biomeSize(), EndBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    @Override
    public BiomeResolver getSkyBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData skyLayersBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, skyLayersBiomeData.biomeWeights(), skyLayersBiomeData.biomeSize(), EndBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }
    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    public BiomeSource withSeed(long l) {
        return new BYGForgeEndBiomeSource(getBiomeRegistry(), l, getIslandLayersBiomeData(), getVoidLayersBiomeData(), getSkyLayersBiomeData());
    }
}