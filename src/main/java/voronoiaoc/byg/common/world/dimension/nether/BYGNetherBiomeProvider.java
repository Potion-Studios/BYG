package voronoiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.fabric.impl.biome.InternalBiomeData;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;

import java.util.ArrayList;
import java.util.List;

public class BYGNetherBiomeProvider extends BiomeSource {
    public static final MapCodec<BYGNetherBiomeProvider> BYGMAPCODEC = RecordCodecBuilder.mapCodec((instance) ->
            instance.group(Codec.LONG.fieldOf("seed").forGetter((bygNether) ->
                    bygNether.seed)).apply(instance, BYGNetherBiomeProvider::new));

    public static final Codec<BYGNetherBiomeProvider> BYGNETHERCODEC = BYGMAPCODEC.codec();


    private final BiomeLayerSampler biomeLayer;
    private final long seed;

    public BYGNetherBiomeProvider(long seed) {
        super(biomeList);
        this.seed = seed;
        this.biomeLayer = BYGNetherLayerProvider.stackLayers(seed);
    }

    @Override
    public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
        return biomeLayer.sample(biomeX, biomeZ);
    }

    @Override
    protected Codec<? extends BiomeSource> method_28442() {
        return BYGNETHERCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGNetherBiomeProvider(seed);
    }

    public static List<Biome> biomeList = new ArrayList<>(InternalBiomeData.getNetherBiomes());



    static {
        biomeList.add(Biomes.CRIMSON_FOREST);
        biomeList.add(Biomes.SOUL_SAND_VALLEY);
        biomeList.add(Biomes.WARPED_FOREST);
        biomeList.add(Biomes.NETHER_WASTES);
        biomeList.add(Biomes.BASALT_DELTAS);

    }
}
