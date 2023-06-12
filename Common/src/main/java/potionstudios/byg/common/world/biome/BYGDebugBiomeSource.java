package potionstudios.byg.common.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryOps;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class BYGDebugBiomeSource extends BiomeSource implements LazyLoadSeed {

    private static final int WIDTH = Integer.parseInt(System.getProperty("byg.debug.biomes.width", "50"));


    public static final Codec<BYGDebugBiomeSource> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                            RegistryOps.retrieveGetter(Registries.BIOME),
                            TagKey.codec(Registries.BIOME).fieldOf("filter").forGetter(bygDebugBiomeSource -> bygDebugBiomeSource.biomeTagKey)
                    )
                    .apply(builder, builder.stable(BYGDebugBiomeSource::new)));


    @Nullable
    private List<Holder<Biome>> possibleBiomesSorted;
    private final TagKey<Biome> biomeTagKey;


    public BYGDebugBiomeSource(HolderGetter<Biome> biomeRegistry, TagKey<Biome> biomeTagKey) {
        super(biomeRegistry.getOrThrow(biomeTagKey).stream());
        this.biomeTagKey = biomeTagKey;
    }


    public BYGDebugBiomeSource(Stream<Holder<Biome>> holderStream, TagKey<Biome> biomeTagKey) {
        super(holderStream);
        this.possibleBiomesSorted = null;
        this.biomeTagKey = biomeTagKey;
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        if (this.possibleBiomesSorted == null) {
            this.possibleBiomesSorted = this.possibleBiomes().stream().filter(biomeHolder -> biomeHolder.is(biomeTagKey)).sorted(Comparator.comparing(biomeHolder -> biomeHolder.unwrapKey().orElseThrow().location())).toList();
        }

        return this.possibleBiomesSorted.get(Math.floorMod(z / WIDTH, this.possibleBiomesSorted.size()));
    }


    @Override
    public void lazyLoad(long seed, Registry<Biome> biomeRegistry) {

    }
}