package potionstudios.byg.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.biome.BiomeSource;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import terrablender.worldgen.noise.Area;

import static potionstudios.byg.world.biome.LayerUtil.createLayers;

public class BYGFabricNetherBiomeSource extends BYGNetherBiomeSource {

    public static final Codec<BYGFabricNetherBiomeSource> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getBiomeRegistry();
        }), Codec.LONG.fieldOf("seed").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getSeed();
        }), LayersBiomeData.CODEC.fieldOf("upperLayerBiomeData").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getUpperLayerBiomeData();
        }), LayersBiomeData.CODEC.fieldOf("middleLayerBiomeData").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getMiddleLayerBiomeData();
        }), LayersBiomeData.CODEC.fieldOf("lowerLayerBiomeData").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getBottomLayerBiomeData();
        })).apply(builder, builder.stable(BYGFabricNetherBiomeSource::new));
    });

    public BYGFabricNetherBiomeSource(Registry<Biome> biomeRegistry, long seed, LayersBiomeData upperLayerBiomeData, LayersBiomeData middleLayerBiomeData, LayersBiomeData bottomLayerBiomeData) {
        super(biomeRegistry, seed, upperLayerBiomeData, middleLayerBiomeData, bottomLayerBiomeData);
    }

    @Override
    public BiomeResolver getUpperBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData upperLayerBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, upperLayerBiomeData.biomeWeights(), upperLayerBiomeData.biomeSize());
        return (x, y, z, sampler) -> biomeRegistry.byIdOrThrow(layers.get(x, z));
    }

    @Override
    public BiomeResolver getMiddleBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData middleLayerBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, middleLayerBiomeData.biomeWeights(), middleLayerBiomeData.biomeSize());
        return (x, y, z, sampler) -> biomeRegistry.byIdOrThrow(layers.get(x, z));
    }

    @Override
    public BiomeResolver getLowerBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData lowerLayerBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, lowerLayerBiomeData.biomeWeights(), lowerLayerBiomeData.biomeSize());
        return (x, y, z, sampler) -> biomeRegistry.byIdOrThrow(layers.get(x, z));
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    public BiomeSource withSeed(long l) {
        return new BYGFabricEndBiomeSource(getBiomeRegistry(), l, getUpperLayerBiomeData(), getMiddleLayerBiomeData(), getBottomLayerBiomeData());
    }
}
