package potionstudios.byg.common.world.biome.overworld;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.util.codec.CodecUtil;
import potionstudios.byg.util.codec.FromFileCodec;
import potionstudios.byg.util.codec.Wrapped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static potionstudios.byg.util.BYGUtil.convert2DArray;

@SuppressWarnings("unchecked")
public class BYGOverworldBiomeBuilders {
    public static final FromFileCodec<List<List<ResourceKey<Biome>>>> BIOME_LAYOUT_CODEC = FromFileCodec.create(CodecUtil.wrapCodecForCollectionSerializing(Codec.list(Codec.list(CodecUtil.BIOME_CODEC))).xmap(CodecUtil.WrapForSerialization::value, CodecUtil::wrap), "biome_layout");

    public static final Map<String, Pair<Map<String, String>, Wrapped<List<List<ResourceKey<Biome>>>>>> BIOME_LAYOUTS = new HashMap<>();

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> OCEANS_EMPTY = create("oceans/oceans_empty", new ResourceKey[][]{
        {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN},
        {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_EMPTY = create("middle_biomes/middle_biomes_empty", new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
        {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.FLOWER_FOREST, Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
        {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
        {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_VARIANT_EMPTY = create("middle_biomes_variant/middle_biomes_variant_empty", new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.SUNFLOWER_PLAINS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });
    public static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_EMPTY = create("plateau_biomes/plateau_biomes_empty", new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_VARIANT_EMPTY = create("plateau_biomes_variant/plateau_biomes_variant_empty", new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.MEADOW, Biomes.MEADOW, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> EXTREME_HILLS_EMPTY = create("extreme_hills/extreme_hills_empty", new ResourceKey[][]{
        {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
        {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
        {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> BEACH_BIOMES_EMPTY = create("beach_biomes/beach_biomes_empty", new ResourceKey[][]{
        {Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH},
        {Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH},
        {Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH},
        {Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH},
        {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PEAK_BIOMES_EMPTY = create("peak_biomes/peak_biomes_empty", new ResourceKey[][]{
        {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
        {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
        {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
        {Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS},
        {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PEAK_BIOMES_VARIANT_EMPTY = create("peak_biomes_variant/peak_biomes_variant_empty", new ResourceKey[][]{
        {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS},
        {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS},
        {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS},
        {Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    public static final Wrapped<List<List<ResourceKey<Biome>>>> OCEANS = create("oceans/oceans_1", new ResourceKey[][]{
        {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, BYGBiomes.LUSH_STACKS},
        {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, BYGBiomes.LUSH_STACKS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> OCEANS_2 = create("oceans/oceans_2", new ResourceKey[][]{
        {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, BYGBiomes.DEAD_SEA},
        {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, BYGBiomes.DEAD_SEA}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES = create("middle_biomes/middle_biomes_1", new ResourceKey[][]{
        {BYGBiomes.SHATTERED_GLACIER, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, BYGBiomes.CARDINAL_TUNDRA, Biomes.TAIGA},
        {Biomes.PLAINS, Biomes.PLAINS, BYGBiomes.TWILIGHT_MEADOW, BYGBiomes.AUTUMNAL_VALLEY, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.FLOWER_FOREST, BYGBiomes.PRAIRIE, BYGBiomes.ALLIUM_FIELDS, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
        {Biomes.SAVANNA, BYGBiomes.BAOBAB_SAVANNA, BYGBiomes.CHERRY_BLOSSOM_FOREST, BYGBiomes.EBONY_WOODS, BYGBiomes.JACARANDA_FOREST},
        {Biomes.DESERT, BYGBiomes.RED_ROCK_VALLEY, BYGBiomes.MOJAVE_DESERT, Biomes.DESERT, BYGBiomes.TROPICAL_RAINFOREST}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_2 = create("middle_biomes/middle_biomes_2", new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
        {Biomes.PLAINS, BYGBiomes.WEEPING_WITCH_FOREST, BYGBiomes.ZELKOVA_FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.FLOWER_FOREST, Biomes.PLAINS, BYGBiomes.ORCHARD, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
        {Biomes.SAVANNA, BYGBiomes.FIRECRACKER_SHRUBLAND, BYGBiomes.FORGOTTEN_FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
        {Biomes.DESERT, Biomes.DESERT, BYGBiomes.SIERRA_BADLANDS, Biomes.DESERT, Biomes.DESERT}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_3 = create("middle_biomes/middle_biomes_3", new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
        {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.FLOWER_FOREST, Biomes.PLAINS, BYGBiomes.TEMPERATE_RAINFOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
        {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
        {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_VARIANT = create("middle_biomes_variant/middle_biomes_variant_1", new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, BYGBiomes.CARDINAL_TUNDRA, Biomes.THE_VOID},
        {Biomes.THE_VOID, BYGBiomes.WEEPING_WITCH_FOREST, BYGBiomes.ASPEN_FOREST, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.THE_VOID, BYGBiomes.PRAIRIE, BYGBiomes.ORCHARD, Biomes.BIRCH_FOREST, BYGBiomes.REDWOOD_THICKET},
        {Biomes.THE_VOID, BYGBiomes.ARAUCARIA_SAVANNA, Biomes.THE_VOID, BYGBiomes.AMARANTH_FIELDS, BYGBiomes.CRAG_GARDENS},
        {Biomes.ERODED_BADLANDS, BYGBiomes.RED_ROCK_VALLEY, BYGBiomes.SIERRA_BADLANDS, Biomes.THE_VOID, BYGBiomes.TROPICAL_RAINFOREST}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_VARIANT_2 = create("middle_biomes_variant/middle_biomes_variant_2", new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.TWILIGHT_MEADOW, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.SUNFLOWER_PLAINS, Biomes.THE_VOID, BYGBiomes.RED_OAK_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.THE_VOID},
        {Biomes.THE_VOID, BYGBiomes.FIRECRACKER_SHRUBLAND, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_VARIANT_3 = create("middle_biomes_variant/middle_biomes_variant_3", new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.ZELKOVA_FOREST, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.SUNFLOWER_PLAINS, Biomes.THE_VOID, BYGBiomes.TEMPERATE_RAINFOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES = create("plateau_biomes/plateau_biomes_1", new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, BYGBiomes.FROSTED_TAIGA, BYGBiomes.CARDINAL_TUNDRA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, BYGBiomes.MAPLE_TAIGA, BYGBiomes.CANADIAN_SHIELD, BYGBiomes.BLACK_FOREST},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, BYGBiomes.FRAGMENT_FOREST, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, BYGBiomes.RED_ROCK_VALLEY, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, BYGBiomes.GUIANA_SHIELD}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_2 = create("plateau_biomes/plateau_biomes_2", new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, BYGBiomes.FROSTED_CONIFEROUS_FOREST, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, BYGBiomes.CONIFEROUS_FOREST, BYGBiomes.CIKA_WOODS, BYGBiomes.SKYRIS_VALE},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_3 = create("plateau_biomes/plateau_biomes_3", new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.DACITE_RIDGES, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_4 = create("plateau_biomes/plateau_biomes_4", new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.COCONINO_MEADOW, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_5 = create("plateau_biomes/plateau_biomes_5", new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.ROSE_FIELDS, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_6 = create("plateau_biomes/plateau_biomes_6", new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.AUTUMNAL_FOREST, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_7 = create("plateau_biomes/plateau_biomes_7", new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.AUTUMNAL_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_VARIANT = create("plateau_biomes_variant/plateau_biomes_1", new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, BYGBiomes.FROSTED_TAIGA, BYGBiomes.CARDINAL_TUNDRA, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.CONIFEROUS_FOREST, Biomes.MEADOW, BYGBiomes.BOREALIS_GROVE},
        {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.GROVE, Biomes.BIRCH_FOREST, BYGBiomes.REDWOOD_THICKET},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_VARIANT_2 = create("plateau_biomes_variant/plateau_biomes_2", new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, BYGBiomes.FROSTED_CONIFEROUS_FOREST, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.MEADOW, BYGBiomes.MAPLE_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> EXTREME_HILLS = create("extreme_hills/extreme_hills_1", new ResourceKey[][]{
        {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
        {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
        {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static Wrapped<List<List<ResourceKey<Biome>>>> create(String id, ResourceKey<Biome>[][] biomeKeys) {
        return create(id, biomeKeys, new HashMap<>());
    }

    protected static Wrapped<List<List<ResourceKey<Biome>>>> create(String id, ResourceKey<Biome>[][] biomeKeys, Map<String, String> comments) {
        Wrapped<List<List<ResourceKey<Biome>>>> result = new Wrapped<>(Optional.of(id), convert2DArray(biomeKeys));
        BIOME_LAYOUTS.put(id, Pair.of(comments, result));
        return result;
    }
}
