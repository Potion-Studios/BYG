package potionstudios.byg.common.world.biome.overworld;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.util.codec.CodecUtil;
import potionstudios.byg.util.codec.FromFileCodec;
import potionstudios.byg.util.codec.Wrapped;
import potionstudios.byg.util.jankson.JanksonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static potionstudios.byg.util.BYGUtil.convert2DArray;

@SuppressWarnings("unchecked")
public class BYGOverworldBiomeSelectors {
    public static final FromFileCodec<List<List<ResourceKey<Biome>>>> BIOME_LAYOUT_CODEC = FromFileCodec.create(CodecUtil.wrapCodecForCollectionSerializing(Codec.list(Codec.list(CodecUtil.BIOME_CODEC))).xmap(CodecUtil.WrapForSerialization::value, CodecUtil::wrap), "biome_layout");
    public static final Codec<List<List<ResourceKey<Biome>>>> OLD_BIOME_LAYOUT_CODEC = Codec.list(Codec.list(CodecUtil.BIOME_CODEC));
    public static final Map<String, Pair<Map<String, String>, Wrapped<List<List<ResourceKey<Biome>>>>>> BIOME_LAYOUTS = new HashMap<>();

    public static final String BIOME_LAYOUT = """
        
        [ ARID-ICY, DRY-ICY, NEUTRAL-ICY, WET-ICY, HUMID-ICY ],
        [ ARID-COLD, DRY-COLD, NEUTRAL-COLD, WET-COLD, HUMID-COLD ],
        [ ARID-NEUTRAL, DRY-NEUTRAL, NEUTRAL-NEUTRAL, WET-NEUTRAL, HUMID-NEUTRAL ],
        [ ARID-WARM, DRY-WARM, NEUTRAL-WARM, WET-WARM, HUMID-WARM ],
        [ ARID-HOT, DRY-HOT, NEUTRAL-HOT, WET-HOT, HUMID-HOT ]
        
        """;

    public static final String OCEAN_BIOMES_LAYOUT =
        """
            [ SHALLOW-ICY, SHALLOW-COLD, SHALLOW-NEUTRAL, SHALLOW-WARM, SHALLOW-HOT ],
            [ DEEP-ICY, DEEP-COLD, DEEP-NEUTRAL, DEEP-WARM, DEEP-HOT ]
            
            """;

    public static final String REQUIRES_VALID_KEYS =
        """
            All keys passed in must be valid in the biome registry!
            "minecraft:the_void" is invalid as it represents a value of "NULL(nothing)" internally.
            """;

    public static final String SHATTERED_BIOMES_LAYOUT = "Appearing on shattered terrain here is the \"shattered_biomes\" layout:\n" + BIOME_LAYOUT +
        """
            All keys passed in must be valid in the biome registry!
            In slots containing "minecraft:the_void", biomes at the equivalent temperature/humidity index in "middle_biomes" will be used instead.
            """;

    public static final String PEAK_BIOMES_LAYOUT = "Appearing on mountainous terrain & BELOW weirdness 0, here is the \"peak_biomes\" layout:\n" + BIOME_LAYOUT + REQUIRES_VALID_KEYS;

    public static final String PEAK_BIOMES_VARIANT_LAYOUT = "Appearing on mountainous terrain & ABOVE weirdness 0, here is the \"peak_biome_variants\" layout:\n" + BIOME_LAYOUT + REQUIRES_VALID_KEYS;

    public static final String OCEANS_BIOMES_LAYOUT_COMMENT = "Appearing on terrain below sea level, here is the \"ocean_biomes\" layout:\n" + OCEAN_BIOMES_LAYOUT + REQUIRES_VALID_KEYS;

    public static final String PLATEAU_BIOMES_LAYOUT = "Appearing on elevated flat terrain BELOW weirdness 0 or in unfilled(\"NULL(nothing)\") spots in \"plateau_biome_variants\", here is the \"plateau_biomes\" layout:\n" + BIOME_LAYOUT + REQUIRES_VALID_KEYS;

    public static final String PLATEAU_BIOMES_VARIANT_LAYOUT = "Appearing on elevated flat terrain ABOVE weirdness 0, here is the \"plateau_biomes\" layout:\n" + BIOME_LAYOUT +
        """
            All keys passed in must be valid in the biome registry!
            In slots containing "minecraft:the_void", biomes at the equivalent temperature/humidity index in "plateau_biomes" will be used instead.
            """;

    public static final String MIDDLE_BIOMES_LAYOUT = "Appearing on terrain BELOW weirdness 0 or in unfilled(\"NULL(nothing)\") spots in \"middle_biomes_variants\", here is the \"middle_biomes\" layout:\n" + BIOME_LAYOUT + REQUIRES_VALID_KEYS;

    public static final String MIDDLE_BIOMES_VARIANT_LAYOUT = "Appearing on terrain ABOVE weirdness 0, here is the \"middle_biomes_variant\" layout:\n" + BIOME_LAYOUT +
        """
            All keys passed in must be valid in the biome registry!
            In slots containing "minecraft:the_void", biomes at the equivalent temperature/humidity index in "middle_biomes" will be used instead.
            """;

    public static final String BEACH_BIOMES_LAYOUT = "Appearing on terrain bordering oceans, here is the \"beach_biomes\" layout:\n" + BIOME_LAYOUT + REQUIRES_VALID_KEYS;

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> OCEANS_VANILLA = create("oceans/oceans_vanilla", OCEANS_BIOMES_LAYOUT_COMMENT, new ResourceKey[][]{
        {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN},
        {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_VANILLA = create("middle_biomes/middle_biomes_vanilla", MIDDLE_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
        {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.FLOWER_FOREST, Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
        {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
        {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_VARIANT_VANILLA = create("middle_biomes_variant/middle_biomes_variant_vanilla", MIDDLE_BIOMES_VARIANT_LAYOUT, new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.SUNFLOWER_PLAINS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });
    public static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_VANILLA = create("plateau_biomes/plateau_biomes_vanilla", PLATEAU_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_VARIANT_VANILLA = create("plateau_biomes_variant/plateau_biomes_variant_vanilla", PLATEAU_BIOMES_VARIANT_LAYOUT, new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.MEADOW, Biomes.MEADOW, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> SHATTERED_BIOMES_VANILLA = create("shattered_biomes/shattered_biomes_vanilla", SHATTERED_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
        {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
        {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> BEACH_BIOMES_VANILLA = create("beach_biomes/beach_biomes_vanilla", BEACH_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH},
        {Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH},
        {Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH},
        {Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH},
        {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PEAK_BIOMES_VANILLA = create("peak_biomes/peak_biomes_vanilla", PEAK_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
        {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
        {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
        {Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS},
        {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PEAK_BIOMES_1 = create("peak_biomes/peak_biomes_1", PEAK_BIOMES_LAYOUT, new ResourceKey[][]{
            {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
            {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
            {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
            {Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, BYGBiomes.GUIANA_SHIELD},
            {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PEAK_BIOMES_VARIANT_VANILLA = create("peak_biomes_variant/peak_biomes_variant_vanilla", PEAK_BIOMES_VARIANT_LAYOUT, new ResourceKey[][]{
        {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS},
        {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS},
        {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS},
        {Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });


    public static final Wrapped<List<List<ResourceKey<Biome>>>> OCEANS = create("oceans/oceans_1", OCEANS_BIOMES_LAYOUT_COMMENT, new ResourceKey[][]{
        {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, BYGBiomes.LUSH_STACKS},
        {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, BYGBiomes.LUSH_STACKS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> OCEANS_2 = create("oceans/oceans_2", OCEANS_BIOMES_LAYOUT_COMMENT, new ResourceKey[][]{
        {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, BYGBiomes.DEAD_SEA},
        {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, BYGBiomes.DEAD_SEA}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES = create("middle_biomes/middle_biomes_1", MIDDLE_BIOMES_LAYOUT, new ResourceKey[][]{
        {BYGBiomes.SHATTERED_GLACIER, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, BYGBiomes.CARDINAL_TUNDRA, BYGBiomes.SKYRIS_VALE},
        {Biomes.PLAINS, Biomes.PLAINS, BYGBiomes.TWILIGHT_MEADOW, BYGBiomes.AUTUMNAL_VALLEY, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.FLOWER_FOREST, BYGBiomes.PRAIRIE, BYGBiomes.ALLIUM_FIELDS, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
        {Biomes.SAVANNA, BYGBiomes.BAOBAB_SAVANNA, BYGBiomes.CHERRY_BLOSSOM_FOREST, BYGBiomes.EBONY_WOODS, BYGBiomes.JACARANDA_FOREST},
        {Biomes.DESERT, BYGBiomes.RED_ROCK_VALLEY, BYGBiomes.MOJAVE_DESERT, Biomes.DESERT, BYGBiomes.TROPICAL_RAINFOREST}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_2 = create("middle_biomes/middle_biomes_2", MIDDLE_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
        {Biomes.PLAINS, BYGBiomes.WEEPING_WITCH_FOREST, BYGBiomes.ZELKOVA_FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.FLOWER_FOREST, Biomes.PLAINS, BYGBiomes.ORCHARD, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
        {Biomes.SAVANNA, BYGBiomes.FIRECRACKER_SHRUBLAND, BYGBiomes.FORGOTTEN_FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
        {Biomes.DESERT, Biomes.DESERT, BYGBiomes.SIERRA_BADLANDS, Biomes.DESERT, Biomes.DESERT}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_3 = create("middle_biomes/middle_biomes_3", MIDDLE_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
        {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.FLOWER_FOREST, Biomes.PLAINS, BYGBiomes.TEMPERATE_RAINFOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
        {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
        {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_VARIANT = create("middle_biomes_variant/middle_biomes_variant_1", MIDDLE_BIOMES_VARIANT_LAYOUT, new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, BYGBiomes.CARDINAL_TUNDRA, Biomes.THE_VOID},
        {Biomes.THE_VOID, BYGBiomes.WEEPING_WITCH_FOREST, BYGBiomes.ASPEN_FOREST, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.THE_VOID, BYGBiomes.PRAIRIE, BYGBiomes.ORCHARD, Biomes.BIRCH_FOREST, BYGBiomes.REDWOOD_THICKET},
        {Biomes.THE_VOID, BYGBiomes.ARAUCARIA_SAVANNA, Biomes.THE_VOID, BYGBiomes.AMARANTH_FIELDS, BYGBiomes.CRAG_GARDENS},
        {Biomes.ERODED_BADLANDS, BYGBiomes.RED_ROCK_VALLEY, BYGBiomes.SIERRA_BADLANDS, Biomes.THE_VOID, BYGBiomes.TROPICAL_RAINFOREST}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_VARIANT_2 = create("middle_biomes_variant/middle_biomes_variant_2", MIDDLE_BIOMES_VARIANT_LAYOUT, new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.TWILIGHT_MEADOW, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.SUNFLOWER_PLAINS, Biomes.THE_VOID, BYGBiomes.RED_OAK_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.THE_VOID},
        {Biomes.THE_VOID, BYGBiomes.FIRECRACKER_SHRUBLAND, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_VARIANT_3 = create("middle_biomes_variant/middle_biomes_variant_3", MIDDLE_BIOMES_VARIANT_LAYOUT, new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.ZELKOVA_FOREST, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.SUNFLOWER_PLAINS, Biomes.THE_VOID, BYGBiomes.TEMPERATE_RAINFOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES = create("plateau_biomes/plateau_biomes_1", PLATEAU_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, BYGBiomes.FROSTED_TAIGA, BYGBiomes.CARDINAL_TUNDRA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, BYGBiomes.MAPLE_TAIGA, BYGBiomes.CANADIAN_SHIELD, BYGBiomes.BLACK_FOREST},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, BYGBiomes.FRAGMENT_FOREST, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, BYGBiomes.GUIANA_SHIELD},
        {Biomes.BADLANDS, BYGBiomes.RED_ROCK_VALLEY, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_2 = create("plateau_biomes/plateau_biomes_2", PLATEAU_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, BYGBiomes.FROSTED_CONIFEROUS_FOREST, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, BYGBiomes.CONIFEROUS_FOREST, BYGBiomes.CIKA_WOODS, BYGBiomes.SKYRIS_VALE},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, BYGBiomes.GUIANA_SHIELD},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_3 = create("plateau_biomes/plateau_biomes_3", PLATEAU_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.DACITE_RIDGES, BYGBiomes.SKYRIS_VALE},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, BYGBiomes.GUIANA_SHIELD},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_4 = create("plateau_biomes/plateau_biomes_4", PLATEAU_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.COCONINO_MEADOW, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_5 = create("plateau_biomes/plateau_biomes_5", PLATEAU_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.ROSE_FIELDS, BYGBiomes.SKYRIS_VALE},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_6 = create("plateau_biomes/plateau_biomes_6", PLATEAU_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.AUTUMNAL_FOREST, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_7 = create("plateau_biomes/plateau_biomes_7", PLATEAU_BIOMES_LAYOUT, new ResourceKey[][]{
        {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.AUTUMNAL_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
        {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
        {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
        {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_VARIANT = create("plateau_biomes_variant/plateau_biomes_variant_1", PLATEAU_BIOMES_VARIANT_LAYOUT, new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, BYGBiomes.FROSTED_TAIGA, BYGBiomes.CARDINAL_TUNDRA, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.CONIFEROUS_FOREST, Biomes.MEADOW, BYGBiomes.BOREALIS_GROVE},
        {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.GROVE, Biomes.BIRCH_FOREST, BYGBiomes.REDWOOD_THICKET},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_VARIANT_2 = create("plateau_biomes_variant/plateau_biomes_variant_2", PLATEAU_BIOMES_VARIANT_LAYOUT, new ResourceKey[][]{
        {Biomes.ICE_SPIKES, Biomes.THE_VOID, BYGBiomes.FROSTED_CONIFEROUS_FOREST, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.MEADOW, BYGBiomes.MAPLE_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.THE_VOID},
        {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
        {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    protected static Wrapped<List<List<ResourceKey<Biome>>>> create(String id, String header, ResourceKey<Biome>[][] biomeKeys) {
        return create(id, biomeKeys, ImmutableMap.of("", JanksonUtil.HEADER_OPEN + "\n" + header + "*/"));
    }

    protected static Wrapped<List<List<ResourceKey<Biome>>>> create(String id, ResourceKey<Biome>[][] biomeKeys) {
        return create(id, biomeKeys, new HashMap<>());
    }

    protected static Wrapped<List<List<ResourceKey<Biome>>>> create(String id, ResourceKey<Biome>[][] biomeKeys, Map<String, String> comments) {
        Wrapped<List<List<ResourceKey<Biome>>>> result = new Wrapped<>(Optional.of(id), convert2DArray(biomeKeys));
        BIOME_LAYOUTS.put(id, Pair.of(comments, result));
        return result;
    }
}