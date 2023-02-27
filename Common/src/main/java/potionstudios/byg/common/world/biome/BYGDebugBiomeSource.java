package potionstudios.byg.common.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class BYGDebugBiomeSource extends BiomeSource {

    private static final int WIDTH = Integer.parseInt(System.getProperty("byg.debug.biomes.width", "50"));


    public static final Codec<BYGDebugBiomeSource> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                            RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter(bygEndBiomeSource -> null),
                            TagKey.codec(Registry.BIOME_REGISTRY).fieldOf("filter").forGetter(bygDebugBiomeSource -> bygDebugBiomeSource.biomeTagKey)
                    )
                    .apply(builder, builder.stable(BYGDebugBiomeSource::new)));


    @Nullable
    private List<Holder<Biome>> possibleBiomesSorted;
    private final TagKey<Biome> biomeTagKey;


    public BYGDebugBiomeSource(Registry<Biome> biomeRegistry, TagKey<Biome> biomeTagKey) {
        super(StreamSupport.stream(biomeRegistry.asHolderIdMap().spliterator(), false));
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


}