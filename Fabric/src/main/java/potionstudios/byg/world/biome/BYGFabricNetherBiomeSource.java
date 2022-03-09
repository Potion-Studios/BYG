package potionstudios.byg.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.biome.BiomeSource;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.common.world.biome.nether.NetherBiomesConfig;
import terrablender.worldgen.noise.Area;

import static potionstudios.byg.world.biome.LayerUtil.createLayers;

public class BYGFabricNetherBiomeSource extends BYGNetherBiomeSource {

    public static final Codec<BYGFabricNetherBiomeSource> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getBiomeRegistry();
        }), Codec.LONG.fieldOf("seed").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getSeed();
        }), LayersBiomeData.CODEC.fieldOf("upperLayerBiomeData").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getUpperLayerBiomeData();
        }), LayersBiomeData.CODEC.fieldOf("middleLayerBiomeData").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getMiddleLayerBiomeData();
        }), LayersBiomeData.CODEC.fieldOf("lowerLayerBiomeData").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getBottomLayerBiomeData();
        }), Codec.INT.fieldOf("layerSize").stable().forGetter((bygForgeNetherBiomeSource) -> {
            return bygForgeNetherBiomeSource.getBottomTopY();
        })).apply(builder, builder.stable(BYGFabricNetherBiomeSource::new));
    });

    public BYGFabricNetherBiomeSource(Registry<Biome> biomeRegistry, long seed, LayersBiomeData upperLayerBiomeData, LayersBiomeData middleLayerBiomeData, LayersBiomeData bottomLayerBiomeData, int layerSize) {
        super(biomeRegistry, seed, upperLayerBiomeData, middleLayerBiomeData, bottomLayerBiomeData, layerSize);
    }

    @Override
    public BiomeResolver getUpperBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData upperLayerBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, upperLayerBiomeData.biomeWeights(), upperLayerBiomeData.biomeSize(), NetherBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    @Override
    public BiomeResolver getMiddleBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData middleLayerBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, middleLayerBiomeData.biomeWeights(), middleLayerBiomeData.biomeSize(), NetherBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    @Override
    public BiomeResolver getLowerBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData lowerLayerBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, lowerLayerBiomeData.biomeWeights(), lowerLayerBiomeData.biomeSize(), NetherBiomesConfig.CONFIG_PATH.get());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    public BiomeSource withSeed(long l) {
        return new BYGFabricNetherBiomeSource(getBiomeRegistry(), l, getUpperLayerBiomeData(), getMiddleLayerBiomeData(), getBottomLayerBiomeData(), getBottomTopY());
    }
}
