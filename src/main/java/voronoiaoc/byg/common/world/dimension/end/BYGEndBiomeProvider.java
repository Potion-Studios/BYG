package voronoiaoc.byg.common.world.dimension.end;

import com.mojang.serialization.Codec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;

import java.util.ArrayList;
import java.util.List;

public class BYGEndBiomeProvider extends BiomeSource {
    public static final Codec<BYGEndBiomeProvider> BYGENDCODEC = Codec.LONG.fieldOf("seed").xmap(BYGEndBiomeProvider::new, (endBP) -> endBP.seed).stable().codec();
    private final long seed;
    private final BiomeLayerSampler biomeLayer;

    public static final List<Biome> bygEndBiomeList = new ArrayList<>();

    public BYGEndBiomeProvider(long seed) {
        super(bygEndBiomeList);
        this.seed = seed;
        ChunkRandom sharedseedrandom = new ChunkRandom(seed);
        sharedseedrandom.consume(17292);
        this.biomeLayer = BYGEndLayerProvider.stackLayers(seed);
    }


    @Override
    protected Codec<? extends BiomeSource> method_28442() {
        return BYGENDCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGEndBiomeProvider(seed);
    }

    @Override
    public Biome getBiomeForNoiseGen(int x, int biomeY, int z) {
        int i = x >> 2;
        int j = z >> 2;
        if ((long) i * (long) i + (long) j * (long) j <= 4096L) {
            return Biomes.THE_END;
        } else {
            return biomeLayer.sample(x, z);
        }
    }
}