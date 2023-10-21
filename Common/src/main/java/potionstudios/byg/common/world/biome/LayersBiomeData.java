package potionstudios.byg.common.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgitaco.corgilib.serialization.codec.CodecUtil;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.util.BYGUtil;

import java.util.Collection;
import java.util.function.BiPredicate;

import static potionstudios.byg.common.world.biome.BYGBiomes.*;

public record LayersBiomeData(SimpleWeightedRandomList<ResourceKey<Biome>> biomeWeights, int biomeSize) {
    public static final Codec<LayersBiomeData> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
            SimpleWeightedRandomList.wrappedCodec(CodecUtil.BIOME_CODEC).fieldOf("biomeWeights").forGetter(layersBiomeData -> layersBiomeData.biomeWeights),
            Codec.INT.fieldOf("biomeSize").forGetter(layersBiomeData -> layersBiomeData.biomeSize)
        ).apply(builder, LayersBiomeData::new);
    });

    public LayersBiomeData filter(BiPredicate<Collection<ResourceKey<Biome>>, ResourceKey<Biome>> filter) {
        return new LayersBiomeData(BYGUtil.combineWeightedRandomLists(filter, biomeWeights), biomeSize);
    }

    public static final LayersBiomeData DEFAULT_END_ISLANDS = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.END_MIDLANDS, 2)
            .add(Biomes.END_BARRENS, 2)
            .add(Biomes.END_HIGHLANDS, 2)
            .add(IVIS_FIELDS, 1)
            .add(NIGHTSHADE_FOREST, 3)
            .add(ETHEREAL_ISLANDS, 3)
            .add(BULBIS_GARDENS, 3)
            .add(CRYPTIC_WASTES, 1)
            .add(IMPARIUS_GROVE, 3)
            .add(Biomes.SMALL_END_ISLANDS, 0)
            .add(VISCAL_ISLES, 0)
            .add(Biomes.THE_END, 0)
            .build(), 4);

    public static final LayersBiomeData DEFAULT_END_VOID = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.SMALL_END_ISLANDS, 2)
            .build(), 3);

    public static final LayersBiomeData DEFAULT_END_SKY = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(VISCAL_ISLES, 1)
            .add(Biomes.THE_END, 9)
            .build(), 3);

    public static final LayersBiomeData DEFAULT_NETHER_MIDDLE = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.CRIMSON_FOREST, 2)
            .add(Biomes.NETHER_WASTES, 2)
            .add(Biomes.SOUL_SAND_VALLEY, 2)
            .add(Biomes.BASALT_DELTAS, 2)
            .add(Biomes.WARPED_FOREST, 2)
            .add(BRIMSTONE_CAVERNS, 2)
            .add(WARPED_DESERT, 2)
            .add(MAGMA_WASTES, 2)
            .add(QUARTZ_DESERT, 2)
            .add(SYTHIAN_TORRIDS, 2)
            .add(WAILING_GARTH, 2)
            .build(), 4);

    public static final LayersBiomeData DEFAULT_NETHER_UPPER = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.CRIMSON_FOREST, 2)
            .add(Biomes.NETHER_WASTES, 2)
            .add(Biomes.SOUL_SAND_VALLEY, 2)
            .add(Biomes.BASALT_DELTAS, 2)
            .add(Biomes.WARPED_FOREST, 2)
            .add(BRIMSTONE_CAVERNS, 2)
            .add(WARPED_DESERT, 2)
            .add(QUARTZ_DESERT, 2)
            .add(MAGMA_WASTES, 2)
            .add(SYTHIAN_TORRIDS, 2)
            .add(WAILING_GARTH, 2)
            .build(), 4);


    public static final LayersBiomeData DEFAULT_NETHER_LOWER = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.CRIMSON_FOREST, 2)
            .add(Biomes.NETHER_WASTES, 2)
            .add(Biomes.SOUL_SAND_VALLEY, 2)
            .add(Biomes.BASALT_DELTAS, 2)
            .add(Biomes.WARPED_FOREST, 2)
            .add(BRIMSTONE_CAVERNS, 2)
            .add(WARPED_DESERT, 0)
            .add(MAGMA_WASTES, 2)
            .add(QUARTZ_DESERT, 0)
            .add(SYTHIAN_TORRIDS, 2)
            .add(WAILING_GARTH, 2)
            .build(), 4);
}