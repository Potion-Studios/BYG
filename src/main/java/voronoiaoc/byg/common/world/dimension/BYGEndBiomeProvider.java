package voronoiaoc.byg.common.world.dimension;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

public class BYGEndBiomeProvider extends BiomeProvider {
    public static final Codec<BYGEndBiomeProvider> BYGENDCODEC = Codec.LONG.fieldOf("seed").xmap(BYGEndBiomeProvider::new, (p_235316_0_) -> p_235316_0_.seed).stable().codec();
    private static final List<Biome> END_BIOMES = ImmutableList.of(Biomes.THE_END, Biomes.END_HIGHLANDS, Biomes.END_MIDLANDS, Biomes.SMALL_END_ISLANDS, Biomes.END_BARRENS);
    private final long seed;
    private final Layer biomeLayer;

    public static final List<Biome> bygEndBiomeList = new ArrayList<>(END_BIOMES);

    public BYGEndBiomeProvider(long seed) {
        super(bygEndBiomeList);
        this.seed = seed;
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
        sharedseedrandom.skip(17292);
        this.biomeLayer = BYGEndLayerProvider.stackLayers(seed);
    }

    protected Codec<? extends BiomeProvider> func_230319_a_() {
        return BYGENDCODEC;
    }

    @OnlyIn(Dist.CLIENT)
    public BiomeProvider func_230320_a_(long seed) {
        return new BYGEndBiomeProvider(seed);
    }

    public Biome getNoiseBiome(int x, int y, int z) {
        int i = x >> 2;
        int j = z >> 2;
        if ((long) i * (long) i + (long) j * (long) j <= 4096L) {
            return Biomes.THE_END;
        } else {
            return biomeLayer.func_215738_a(x, z);
        }
    }
}
