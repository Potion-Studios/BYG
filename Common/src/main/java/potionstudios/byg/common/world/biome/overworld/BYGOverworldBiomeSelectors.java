package potionstudios.byg.common.world.biome.overworld;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.common.world.biome.BYGBiomes;
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
            [ DEEP-ICY, DEEP-COLD, DEEP-NEUTRAL, DEEP-WARM, DEEP-HOT ]
            [ SHALLOW-ICY, SHALLOW-COLD, SHALLOW-NEUTRAL, SHALLOW-WARM, SHALLOW-HOT ],
            
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

    private static String invalidKeysOkay(String fallback) {
        return String.format("""
            All keys passed in must be valid in the biome registry!
            In slots containing "minecraft:the_void", biomes at the equivalent temperature/humidity index in "%s" will be used instead.
            """, fallback);
    }

    public static final String PEAK_BIOMES_LAYOUT = "Appearing on mountainous terrain & BELOW weirdness 0, here is the \"peak_biomes\" layout:\n" + BIOME_LAYOUT + REQUIRES_VALID_KEYS;

    public static final String SLOPE_BIOMES_LAYOUT = "Appearing on sloped terrain, near mountainous terrain, & BELOW weirdness 0, here is the \"slope_biomes\" layout:\n" + BIOME_LAYOUT + REQUIRES_VALID_KEYS;
    public static final String SLOPE_BIOMES_VARIANT_LAYOUT = "Appearing on sloped terrain, near mountainous terrain, & ABOVE weirdness 0, here is the \"slope_biome_variants\" layout:\n" + BIOME_LAYOUT + invalidKeysOkay("slope_biomes");

    public static final String PEAK_BIOMES_VARIANT_LAYOUT = "Appearing on mountainous terrain & ABOVE weirdness 0, here is the \"peak_biome_variants\" layout:\n" + BIOME_LAYOUT + invalidKeysOkay("slope_biomes");

    public static final String OCEANS_BIOMES_LAYOUT_COMMENT = "Appearing on terrain below sea level, here is the \"ocean_biomes\" layout:\n" + OCEAN_BIOMES_LAYOUT + REQUIRES_VALID_KEYS;

    public static final String PLATEAU_BIOMES_LAYOUT = "Appearing on elevated flat terrain BELOW weirdness 0 or in unfilled(\"NULL(nothing)\") spots in \"plateau_biome_variants\", here is the \"plateau_biomes\" layout:\n" + BIOME_LAYOUT + REQUIRES_VALID_KEYS;

    public static final String PLATEAU_BIOMES_VARIANT_LAYOUT = "Appearing on elevated flat terrain ABOVE weirdness 0, here is the \"plateau_biomes_variant\" layout:\n" + BIOME_LAYOUT + invalidKeysOkay("plateau_biomes");

    public static final String MIDDLE_BIOMES_LAYOUT = "Appearing on terrain BELOW weirdness 0 or in unfilled(\"NULL(nothing)\") spots in \"middle_biomes_variants\", here is the \"middle_biomes\" layout:\n" + BIOME_LAYOUT + REQUIRES_VALID_KEYS;

    public static final String MIDDLE_BIOMES_VARIANT_LAYOUT = "Appearing on terrain ABOVE weirdness 0, here is the \"middle_biomes_variant\" layout:\n" + BIOME_LAYOUT + invalidKeysOkay("middle_biomes");

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

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PEAK_BIOMES_VANILLA = create("peak_biomes/peak_biomes_vanilla", PEAK_BIOMES_LAYOUT, new ResourceKey[][]{
            {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
            {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
            {Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS, Biomes.JAGGED_PEAKS},
            {Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS},
            {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
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

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PEAK_BIOMES_VARIANT_VANILLA = create("peak_biomes_variant/peak_biomes_variant_vanilla", PEAK_BIOMES_VARIANT_LAYOUT, new ResourceKey[][]{
            {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS},
            {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS},
            {Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, Biomes.FROZEN_PEAKS, BYGBiomes.DACITE_RIDGES, BYGBiomes.DACITE_RIDGES},
            {Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS, Biomes.STONY_PEAKS},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> BEACH_BIOMES_1 = create("beach_biomes/beach_biomes_1", BEACH_BIOMES_LAYOUT, new ResourceKey[][]{
            {Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH},
            {Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH, Biomes.BEACH},
            {BYGBiomes.BASALT_BARRERA, BYGBiomes.BASALT_BARRERA, BYGBiomes.BASALT_BARRERA, BYGBiomes.BASALT_BARRERA, BYGBiomes.BASALT_BARRERA},
            {BYGBiomes.RAINBOW_BEACH, BYGBiomes.RAINBOW_BEACH, BYGBiomes.RAINBOW_BEACH, BYGBiomes.RAINBOW_BEACH, BYGBiomes.RAINBOW_BEACH},
            {BYGBiomes.WINDSWEPT_BEACH, BYGBiomes.WINDSWEPT_BEACH, BYGBiomes.WINDSWEPT_BEACH, BYGBiomes.WINDSWEPT_BEACH, BYGBiomes.WINDSWEPT_BEACH}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PEAK_BIOMES_1 = create("peak_biomes/peak_biomes_1", PEAK_BIOMES_LAYOUT, new ResourceKey[][]{
            {BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS},
            {BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS},
            {BYGBiomes.CANADIAN_SHIELD, BYGBiomes.CANADIAN_SHIELD, BYGBiomes.DACITE_RIDGES, BYGBiomes.DACITE_RIDGES, BYGBiomes.DACITE_RIDGES},
            {BYGBiomes.CANADIAN_SHIELD, BYGBiomes.CANADIAN_SHIELD, BYGBiomes.GUIANA_SHIELD, BYGBiomes.GUIANA_SHIELD, BYGBiomes.GUIANA_SHIELD},
            {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> SLOPE_BIOMES_VANILLA = create("slope_biomes/slope_biomes_vanilla", SLOPE_BIOMES_LAYOUT, new ResourceKey[][]{
            {Biomes.SNOWY_SLOPES, Biomes.SNOWY_SLOPES, Biomes.GROVE, Biomes.GROVE, Biomes.GROVE},
            {Biomes.SNOWY_SLOPES, Biomes.SNOWY_SLOPES, Biomes.GROVE, Biomes.GROVE, Biomes.GROVE},
            {Biomes.SNOWY_SLOPES, Biomes.SNOWY_SLOPES, Biomes.GROVE, Biomes.GROVE, Biomes.GROVE},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> SLOPE_BIOMES_1 = create("slope_biomes/slope_biomes_1", SLOPE_BIOMES_LAYOUT, new ResourceKey[][]{
            {BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS},
            {BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS, BYGBiomes.HOWLING_PEAKS},
            {BYGBiomes.CANADIAN_SHIELD, BYGBiomes.CANADIAN_SHIELD, BYGBiomes.DACITE_RIDGES, BYGBiomes.DACITE_RIDGES, BYGBiomes.DACITE_RIDGES},
            {BYGBiomes.CANADIAN_SHIELD, BYGBiomes.CANADIAN_SHIELD, BYGBiomes.GUIANA_SHIELD, BYGBiomes.GUIANA_SHIELD, BYGBiomes.GUIANA_SHIELD},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> SLOPE_BIOMES_VARIANT_VANILLA = create("slope_biomes_variant/slope_biomes_variant_vanilla", SLOPE_BIOMES_VARIANT_LAYOUT, new ResourceKey[][]{
            {Biomes.SNOWY_SLOPES, Biomes.SNOWY_SLOPES, Biomes.GROVE, Biomes.GROVE, Biomes.GROVE},
            {Biomes.SNOWY_SLOPES, Biomes.SNOWY_SLOPES, Biomes.GROVE, Biomes.GROVE, Biomes.GROVE},
            {Biomes.SNOWY_SLOPES, Biomes.SNOWY_SLOPES, Biomes.GROVE, Biomes.GROVE, Biomes.GROVE},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    });

    public static final Wrapped<List<List<ResourceKey<Biome>>>> OCEANS = create("oceans/oceans_1", OCEANS_BIOMES_LAYOUT_COMMENT, new ResourceKey[][]{
        {Biomes.DEEP_FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, BYGBiomes.LUSH_STACKS, BYGBiomes.DEAD_SEA},
        {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, BYGBiomes.LUSH_STACKS, BYGBiomes.DEAD_SEA}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_1 = create("middle_biomes/middle_biomes_1", MIDDLE_BIOMES_LAYOUT, new ResourceKey[][]{
        {BYGBiomes.SHATTERED_GLACIER, BYGBiomes.CARDINAL_TUNDRA, BYGBiomes.CARDINAL_TUNDRA, BYGBiomes.SKYRIS_VALE, BYGBiomes.SKYRIS_VALE},
        {BYGBiomes.ROSE_FIELDS, BYGBiomes.WEEPING_WITCH_FOREST, BYGBiomes.TWILIGHT_MEADOW, BYGBiomes.AUTUMNAL_VALLEY, BYGBiomes.CIKA_WOODS},
        {BYGBiomes.FORGOTTEN_FOREST, BYGBiomes.PRAIRIE, BYGBiomes.ALLIUM_FIELDS, BYGBiomes.ASPEN_FOREST, BYGBiomes.TEMPERATE_RAINFOREST},
        {BYGBiomes.ARAUCARIA_SAVANNA, BYGBiomes.BAOBAB_SAVANNA, BYGBiomes.CHERRY_BLOSSOM_FOREST, BYGBiomes.EBONY_WOODS, BYGBiomes.JACARANDA_FOREST},
        {BYGBiomes.ATACAMA_DESERT, BYGBiomes.RED_ROCK_VALLEY, BYGBiomes.MOJAVE_DESERT, BYGBiomes.SIERRA_BADLANDS, BYGBiomes.WINDSWEPT_DESERT}
    });
    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_2 = create("middle_biomes/middle_biomes_2", MIDDLE_BIOMES_LAYOUT, new ResourceKey[][]{
        {BYGBiomes.FROSTED_CONIFEROUS_FOREST, BYGBiomes.FROSTED_CONIFEROUS_FOREST, BYGBiomes.FROSTED_TAIGA, BYGBiomes.AUTUMNAL_FOREST, BYGBiomes.AUTUMNAL_TAIGA},
        {BYGBiomes.ROSE_FIELDS, BYGBiomes.FRAGMENT_FOREST, BYGBiomes.ZELKOVA_FOREST, BYGBiomes.COCONINO_MEADOW, BYGBiomes.REDWOOD_THICKET},
        {BYGBiomes.GROVE, BYGBiomes.ORCHARD, BYGBiomes.ORCHARD, BYGBiomes.RED_OAK_FOREST, BYGBiomes.JACARANDA_FOREST},
        {BYGBiomes.FIRECRACKER_SHRUBLAND, BYGBiomes.FIRECRACKER_SHRUBLAND, BYGBiomes.AMARANTH_FIELDS, BYGBiomes.CRAG_GARDENS, BYGBiomes.TROPICAL_RAINFOREST},
        {BYGBiomes.ATACAMA_DESERT, BYGBiomes.ATACAMA_DESERT, BYGBiomes.SIERRA_BADLANDS, BYGBiomes.ATACAMA_DESERT, BYGBiomes.MOJAVE_DESERT}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> MIDDLE_BIOMES_3 = create("middle_biomes/middle_biomes_3", MIDDLE_BIOMES_LAYOUT, new ResourceKey[][]{
        {BYGBiomes.SHATTERED_GLACIER, BYGBiomes.CARDINAL_TUNDRA, BYGBiomes.BOREALIS_GROVE, BYGBiomes.BOREALIS_GROVE, BYGBiomes.BLACK_FOREST},
        {BYGBiomes.COCONINO_MEADOW, BYGBiomes.MAPLE_TAIGA, BYGBiomes.MAPLE_TAIGA, BYGBiomes.COCONINO_MEADOW, BYGBiomes.CONIFEROUS_FOREST},
        {BYGBiomes.GROVE, BYGBiomes.PRAIRIE, BYGBiomes.ALLIUM_FIELDS, BYGBiomes.ASPEN_FOREST, BYGBiomes.DACITE_RIDGES},
        {BYGBiomes.BAOBAB_SAVANNA, BYGBiomes.ARAUCARIA_SAVANNA,  BYGBiomes.CHERRY_BLOSSOM_FOREST, BYGBiomes.EBONY_WOODS, BYGBiomes.TROPICAL_RAINFOREST},
        {BYGBiomes.ATACAMA_DESERT, BYGBiomes.WINDSWEPT_DESERT, BYGBiomes.WINDSWEPT_DESERT, BYGBiomes.MOJAVE_DESERT, BYGBiomes.RED_ROCK_VALLEY}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_1 = create("plateau_biomes/plateau_biomes_1", PLATEAU_BIOMES_LAYOUT, new ResourceKey[][]{
        {BYGBiomes.FROSTED_CONIFEROUS_FOREST, BYGBiomes.CARDINAL_TUNDRA, BYGBiomes.FROSTED_TAIGA, BYGBiomes.BOREALIS_GROVE, BYGBiomes.BLACK_FOREST},
        {BYGBiomes.ROSE_FIELDS, BYGBiomes.COCONINO_MEADOW, BYGBiomes.ZELKOVA_FOREST, BYGBiomes.CANADIAN_SHIELD, BYGBiomes.SKYRIS_VALE},
        {BYGBiomes.GROVE, BYGBiomes.ORCHARD, BYGBiomes.ASPEN_FOREST, BYGBiomes.RED_OAK_FOREST, BYGBiomes.DACITE_RIDGES},
        {BYGBiomes.BAOBAB_SAVANNA, BYGBiomes.ARAUCARIA_SAVANNA, BYGBiomes.EBONY_WOODS, BYGBiomes.TROPICAL_RAINFOREST, BYGBiomes.GUIANA_SHIELD},
        {BYGBiomes.FIRECRACKER_SHRUBLAND, BYGBiomes.SIERRA_BADLANDS, BYGBiomes.SIERRA_BADLANDS, BYGBiomes.RED_ROCK_VALLEY, BYGBiomes.RED_ROCK_VALLEY}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_2 = create("plateau_biomes/plateau_biomes_2", PLATEAU_BIOMES_LAYOUT, new ResourceKey[][]{
            {BYGBiomes.FROSTED_CONIFEROUS_FOREST, BYGBiomes.CARDINAL_TUNDRA, BYGBiomes.FROSTED_TAIGA, BYGBiomes.BOREALIS_GROVE, BYGBiomes.BLACK_FOREST},
            {BYGBiomes.ROSE_FIELDS, BYGBiomes.COCONINO_MEADOW, BYGBiomes.TWILIGHT_MEADOW, BYGBiomes.CANADIAN_SHIELD, BYGBiomes.SKYRIS_VALE},
            {BYGBiomes.GROVE, BYGBiomes.ORCHARD, BYGBiomes.ASPEN_FOREST, BYGBiomes.ALLIUM_FIELDS, BYGBiomes.DACITE_RIDGES},
            {BYGBiomes.BAOBAB_SAVANNA, BYGBiomes.ARAUCARIA_SAVANNA, BYGBiomes.EBONY_WOODS, BYGBiomes.AMARANTH_FIELDS, BYGBiomes.GUIANA_SHIELD},
            {BYGBiomes.FIRECRACKER_SHRUBLAND, BYGBiomes.SIERRA_BADLANDS, BYGBiomes.SIERRA_BADLANDS, BYGBiomes.RED_ROCK_VALLEY, BYGBiomes.RED_ROCK_VALLEY}
    });

    protected static final Wrapped<List<List<ResourceKey<Biome>>>> PLATEAU_BIOMES_3 = create("plateau_biomes/plateau_biomes_3", PLATEAU_BIOMES_LAYOUT, new ResourceKey[][]{
            {BYGBiomes.FROSTED_CONIFEROUS_FOREST, BYGBiomes.CARDINAL_TUNDRA, BYGBiomes.FROSTED_TAIGA, BYGBiomes.BOREALIS_GROVE, BYGBiomes.BLACK_FOREST},
            {BYGBiomes.ROSE_FIELDS, BYGBiomes.COCONINO_MEADOW, BYGBiomes.TWILIGHT_MEADOW, BYGBiomes.CANADIAN_SHIELD, BYGBiomes.SKYRIS_VALE},
            {BYGBiomes.GROVE, BYGBiomes.ORCHARD, BYGBiomes.ASPEN_FOREST, BYGBiomes.ALLIUM_FIELDS, BYGBiomes.DACITE_RIDGES},
            {BYGBiomes.BAOBAB_SAVANNA, BYGBiomes.ARAUCARIA_SAVANNA, BYGBiomes.EBONY_WOODS, BYGBiomes.AMARANTH_FIELDS, BYGBiomes.GUIANA_SHIELD},
            {BYGBiomes.FIRECRACKER_SHRUBLAND, BYGBiomes.SIERRA_BADLANDS, BYGBiomes.SIERRA_BADLANDS, BYGBiomes.RED_ROCK_VALLEY, BYGBiomes.RED_ROCK_VALLEY}
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