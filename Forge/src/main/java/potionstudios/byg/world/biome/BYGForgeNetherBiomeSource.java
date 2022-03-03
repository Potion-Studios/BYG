package potionstudios.byg.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;

public class BYGForgeNetherBiomeSource extends BYGNetherBiomeSource {

    public static final Codec<BYGForgeNetherBiomeSource> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((bygForgeNetherBiomeSource) -> {
            return bygForgeNetherBiomeSource.getBiomeRegistry();
        }), Codec.LONG.fieldOf("seed").stable().forGetter((bygForgeNetherBiomeSource) -> {
            return bygForgeNetherBiomeSource.getSeed();
        }), LayersBiomeData.CODEC.fieldOf("upperLayerBiomeData").stable().forGetter((bygForgeNetherBiomeSource) -> {
            return bygForgeNetherBiomeSource.getUpperLayerBiomeData();
        }), LayersBiomeData.CODEC.fieldOf("middleLayerBiomeData").stable().forGetter((bygForgeNetherBiomeSource) -> {
            return bygForgeNetherBiomeSource.getMiddleLayerBiomeData();
        }), LayersBiomeData.CODEC.fieldOf("lowerLayerBiomeData").stable().forGetter((bygForgeNetherBiomeSource) -> {
            return bygForgeNetherBiomeSource.getBottomLayerBiomeData();
        }), Codec.INT.fieldOf("layerSize").stable().forGetter((bygForgeNetherBiomeSource) -> {
            return bygForgeNetherBiomeSource.getBottomTopY();
        })).apply(builder, builder.stable(BYGForgeNetherBiomeSource::new));
    });

    public BYGForgeNetherBiomeSource(Registry<Biome> biomeRegistry, long seed, LayersBiomeData upperLayerBiomeData, LayersBiomeData middleLayerBiomeData, LayersBiomeData bottomLayerBiomeData, int layerSize) {
        super(biomeRegistry, seed, upperLayerBiomeData, middleLayerBiomeData, bottomLayerBiomeData, layerSize);
    }

    @Override
    public BiomeResolver getUpperBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData upperLayerBiomeData) {
//        Area layers = createLayers(biomeRegistry, seed, upperLayerBiomeData.biomeWeights(), upperLayerBiomeData.biomeSize());
        return (x, y, z, sampler) -> biomeRegistry.getHolderOrThrow(Biomes.NETHER_WASTES); //TODO: biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    @Override
    public BiomeResolver getMiddleBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData middleLayerBiomeData) {
//        Area layers = createLayers(biomeRegistry, seed, middleLayerBiomeData.biomeWeights(), middleLayerBiomeData.biomeSize());
        return (x, y, z, sampler) -> biomeRegistry.getHolderOrThrow(Biomes.NETHER_WASTES); //TODO: biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    @Override
    public BiomeResolver getLowerBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData lowerLayerBiomeData) {
//        Area layers = createLayers(biomeRegistry, seed, lowerLayerBiomeData.biomeWeights(), lowerLayerBiomeData.biomeSize());
        return (x, y, z, sampler) -> biomeRegistry.getHolderOrThrow(Biomes.NETHER_WASTES); //TODO: biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    public BiomeSource withSeed(long l) {
        return new BYGForgeNetherBiomeSource(getBiomeRegistry(), l, getUpperLayerBiomeData(), getMiddleLayerBiomeData(), getBottomLayerBiomeData(), getBottomTopY());
    }
}