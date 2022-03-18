package potionstudios.byg.common.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.util.codec.CodecUtil;

import static potionstudios.byg.common.world.biome.BYGBiomes.*;

public record LayersBiomeData(SimpleWeightedRandomList<ResourceKey<Biome>> biomeWeights, int biomeSize) {
    public static final Codec<LayersBiomeData> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
            SimpleWeightedRandomList.wrappedCodec(CodecUtil.BIOME_CODEC).fieldOf("biomeWeights").forGetter(layersBiomeData -> layersBiomeData.biomeWeights),
            Codec.INT.fieldOf("biomeSize").forGetter(layersBiomeData -> layersBiomeData.biomeSize)
        ).apply(builder, LayersBiomeData::new);
    });

    public static final LayersBiomeData DEFAULT_END_ISLANDS = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.END_MIDLANDS, 2)
            .add(Biomes.END_BARRENS, 2)
            .add(Biomes.END_HIGHLANDS, 2)
            .add(IVIS_FIELDS, 1)
            .add(NIGHTSHADE_FOREST, 3)
            .add(ETHEREAL_ISLANDS, 3)
            .add(BULBIS_GARDENS, 3)
            .add(SHULKREN_FOREST, 3)
            .add(CRYPTIC_WASTES, 1)
            .add(IMPARIUS_GROVE, 3)
            .build(), 3);

    public static final LayersBiomeData DEFAULT_END_VOID = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.SMALL_END_ISLANDS, 2)
            .build(), 2);

    public static final LayersBiomeData DEFAULT_SKY = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(VISCAL_ISLES, 1)
            .add(Biomes.THE_END, 9)
            .build(), 2);

    public static final LayersBiomeData DEFAULT_NETHER_MIDDLE = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.CRIMSON_FOREST, 2)
            .add(Biomes.NETHER_WASTES, 2)
            .add(Biomes.SOUL_SAND_VALLEY, 2)
            .add(Biomes.BASALT_DELTAS, 2)
            .add(Biomes.WARPED_FOREST, 2)
            .add(BRIMSTONE_CAVERNS, 2)
            .add(SUBZERO_HYPOGEAL, 2)
            .add(WARPED_DESERT, 2)
            .add(WEEPING_MIRE, 0)
            .add(MAGMA_WASTES, 2)
            .add(EMBUR_BOG, 2)
            .add(QUARTZ_DESERT, 2)
            .add(CRIMSON_GARDENS, 2)
            .add(GLOWSTONE_GARDENS, 2)
            .add(SYTHIAN_TORRIDS, 2)
            .add(WAILING_GARTH, 2)
            .add(ARISIAN_UNDERGROWTH, 2)
            .build(), 3);

    public static final LayersBiomeData DEFAULT_NETHER_UPPER = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.CRIMSON_FOREST, 2)
            .add(Biomes.NETHER_WASTES, 2)
            .add(Biomes.SOUL_SAND_VALLEY, 2)
            .add(Biomes.BASALT_DELTAS, 2)
            .add(Biomes.WARPED_FOREST, 2)
            .add(BRIMSTONE_CAVERNS, 2)
            .add(SUBZERO_HYPOGEAL, 2)
            .add(EMBUR_BOG, 0)
            .add(WEEPING_MIRE, 0)
            .add(WARPED_DESERT, 2)
            .add(QUARTZ_DESERT, 2)
            .add(CRIMSON_GARDENS, 2)
            .add(MAGMA_WASTES, 2)
            .add(GLOWSTONE_GARDENS, 2)
            .add(SYTHIAN_TORRIDS, 2)
            .add(WAILING_GARTH, 2)
            .add(ARISIAN_UNDERGROWTH, 2)
            .build(), 3);


    public static final LayersBiomeData DEFAULT_NETHER_LOWER = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.CRIMSON_FOREST, 2)
            .add(Biomes.NETHER_WASTES, 2)
            .add(Biomes.SOUL_SAND_VALLEY, 2)
            .add(Biomes.BASALT_DELTAS, 2)
            .add(Biomes.WARPED_FOREST, 2)
            .add(WEEPING_MIRE, 2)
            .add(EMBUR_BOG, 2)
            .add(BRIMSTONE_CAVERNS, 0)
            .add(SUBZERO_HYPOGEAL, 0)
            .add(WARPED_DESERT, 0)
            .add(MAGMA_WASTES, 0)
            .add(QUARTZ_DESERT, 0)
            .add(CRIMSON_GARDENS, 0)
            .add(GLOWSTONE_GARDENS, 0)
            .add(SYTHIAN_TORRIDS, 0)
            .add(WAILING_GARTH, 0)
            .add(ARISIAN_UNDERGROWTH, 0)
            .build(), 3);
}