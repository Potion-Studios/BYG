package potionstudios.byg.common.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.CodecUtil;

import java.util.*;

public class BYGOverworldBiomeBuilder {

    private static final ResourceKey<Biome>[][] OCEANS_EMPTY = new ResourceKey[][]{
            {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN},
            {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN}
    };
    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES_EMPTY = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
            {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.FLOWER_FOREST, Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
            {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}
    };
    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT_EMPTY = new ResourceKey[][]{
            {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.SUNFLOWER_PLAINS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };
    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_EMPTY = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    };
    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT_EMPTY = new ResourceKey[][]{
            {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.MEADOW, Biomes.MEADOW, Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };

    private static final ResourceKey<Biome>[][] EXTREME_HILLS_EMPTY = new ResourceKey[][]{
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };


    private static final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
            {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, BYGBiomes.LUSH_STACKS},
            {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, BYGBiomes.LUSH_STACKS}
    };

    private static final ResourceKey<Biome>[][] OCEANS_2 = new ResourceKey[][]{
        {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, BYGBiomes.DEAD_SEA},
        {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, BYGBiomes.DEAD_SEA}
    };
    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            {BYGBiomes.SHATTERED_GLACIER, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
            {Biomes.PLAINS, Biomes.PLAINS, BYGBiomes.TWILIGHT_MEADOW, BYGBiomes.AUTUMNAL_VALLEY, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.FLOWER_FOREST, BYGBiomes.PRAIRIE, BYGBiomes.ALLIUM_FIELDS, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA, BYGBiomes.BAOBAB_SAVANNA, BYGBiomes.CHERRY_BLOSSOM_FOREST, BYGBiomes.EBONY_WOODS, BYGBiomes.JACARANDA_FOREST},
            {Biomes.DESERT, BYGBiomes.RED_ROCK_VALLEY, BYGBiomes.MOJAVE_DESERT, Biomes.DESERT, BYGBiomes.TROPICAL_RAINFOREST}
    };
    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES_2 = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
            {Biomes.PLAINS, BYGBiomes.WEEPING_WITCH_FOREST, BYGBiomes.ZELKOVA_FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.FLOWER_FOREST, Biomes.PLAINS, BYGBiomes.ORCHARD, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA, BYGBiomes.FIRECRACKER_SHRUBLAND, BYGBiomes.FORGOTTEN_FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
            {Biomes.DESERT, Biomes.DESERT, BYGBiomes.SIERRA_BADLANDS, Biomes.DESERT, Biomes.DESERT}
    };

    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES_3 = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
            {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.FLOWER_FOREST, Biomes.PLAINS, BYGBiomes.TEMPERATE_RAINFOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
            {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}
    };

    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, BYGBiomes.WEEPING_WITCH_FOREST, BYGBiomes.ASPEN_FOREST, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.THE_VOID, BYGBiomes.PRAIRIE, BYGBiomes.ORCHARD, Biomes.BIRCH_FOREST, BYGBiomes.REDWOOD_THICKET},
            {Biomes.THE_VOID, BYGBiomes.ARAUCARIA_SAVANNA, Biomes.THE_VOID, BYGBiomes.AMARANTH_FIELDS, BYGBiomes.CRAG_GARDENS},
            {Biomes.ERODED_BADLANDS, BYGBiomes.RED_ROCK_VALLEY, BYGBiomes.SIERRA_BADLANDS, Biomes.THE_VOID, BYGBiomes.TROPICAL_RAINFOREST}
    };
    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT_2 = new ResourceKey[][]{
            {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.TWILIGHT_MEADOW, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.SUNFLOWER_PLAINS, Biomes.THE_VOID, BYGBiomes.RED_OAK_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.THE_VOID},
            {Biomes.THE_VOID, BYGBiomes.FIRECRACKER_SHRUBLAND, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };

    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT_3 = new ResourceKey[][]{
            {Biomes.ICE_SPIKES, Biomes.THE_VOID, Biomes.SNOWY_TAIGA, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.ZELKOVA_FOREST, Biomes.THE_VOID, Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.SUNFLOWER_PLAINS, Biomes.THE_VOID, BYGBiomes.TEMPERATE_RAINFOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };

    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, BYGBiomes.FROSTED_TAIGA, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, BYGBiomes.MAPLE_TAIGA, BYGBiomes.CANADIAN_SHIELD, BYGBiomes.BLACK_FOREST},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, BYGBiomes.FRAGMENT_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.BADLANDS, BYGBiomes.RED_ROCK_VALLEY, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, BYGBiomes.GUIANA_SHIELD}
    };

    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_2 = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, BYGBiomes.FROSTED_CONIFEROUS_FOREST, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, BYGBiomes.CONIFEROUS_FOREST, BYGBiomes.CIKA_WOODS, BYGBiomes.SKYRIS_VALE},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    };

    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_3 = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.DACITE_RIDGES, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    };

    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_4 = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.COCONINO_MEADOW, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    };
    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_5 = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.ROSE_FIELDS, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    };

    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_6 = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.AUTUMNAL_FOREST, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    };

    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_7 = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, BYGBiomes.AUTUMNAL_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    };

    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {Biomes.ICE_SPIKES, Biomes.THE_VOID, BYGBiomes.FROSTED_TAIGA, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.CONIFEROUS_FOREST, Biomes.MEADOW, BYGBiomes.BOREALIS_GROVE},
            {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.GROVE, Biomes.BIRCH_FOREST, BYGBiomes.REDWOOD_THICKET},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };

    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT_2 = new ResourceKey[][]{
            {Biomes.ICE_SPIKES, Biomes.THE_VOID, BYGBiomes.FROSTED_CONIFEROUS_FOREST, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.MEADOW, BYGBiomes.MAPLE_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };

    private static final ResourceKey<Biome>[][] EXTREME_HILLS = new ResourceKey[][]{
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };

    public static final List<BiomeProviderData> OVERWORLD_DEFAULTS = Util.make(new ArrayList<>(), list -> {
        int overworldWeight = 6;
        list.add(new BiomeProviderData(overworldWeight, OCEANS, MIDDLE_BIOMES, MIDDLE_BIOMES_VARIANT, PLATEAU_BIOMES, PLATEAU_BIOMES_VARIANT, EXTREME_HILLS, Util.make(new IdentityHashMap<>(), map -> map.put(Biomes.SWAMP, BYGBiomes.BAYOU))));
        list.add(new BiomeProviderData(overworldWeight, OCEANS_2, MIDDLE_BIOMES_2, MIDDLE_BIOMES_VARIANT_2, PLATEAU_BIOMES_2, PLATEAU_BIOMES_VARIANT_2, EXTREME_HILLS_EMPTY, Util.make(new IdentityHashMap<>(), map -> map.put(Biomes.SWAMP, BYGBiomes.CYPRESS_SWAMPLANDS))));
        list.add(new BiomeProviderData(overworldWeight, OCEANS_EMPTY, MIDDLE_BIOMES_3, MIDDLE_BIOMES_VARIANT_3, PLATEAU_BIOMES_3, PLATEAU_BIOMES_VARIANT_EMPTY, EXTREME_HILLS_EMPTY, new IdentityHashMap<>()));
        list.add(new BiomeProviderData(overworldWeight, OCEANS_EMPTY, MIDDLE_BIOMES_EMPTY, MIDDLE_BIOMES_VARIANT_EMPTY, PLATEAU_BIOMES_4, PLATEAU_BIOMES_VARIANT_EMPTY, EXTREME_HILLS_EMPTY, new IdentityHashMap<>()));
        list.add(new BiomeProviderData(overworldWeight, OCEANS_EMPTY, MIDDLE_BIOMES_EMPTY, MIDDLE_BIOMES_VARIANT_EMPTY, PLATEAU_BIOMES_5, PLATEAU_BIOMES_VARIANT_EMPTY, EXTREME_HILLS_EMPTY, new IdentityHashMap<>()));
        // Broken beyond this point atm.
        list.add(new BiomeProviderData(overworldWeight, OCEANS_EMPTY, MIDDLE_BIOMES_EMPTY, MIDDLE_BIOMES_VARIANT_EMPTY, PLATEAU_BIOMES_6, PLATEAU_BIOMES_VARIANT_EMPTY, EXTREME_HILLS_EMPTY, new IdentityHashMap<>()));
        list.add(new BiomeProviderData(overworldWeight, OCEANS_EMPTY, MIDDLE_BIOMES_EMPTY, MIDDLE_BIOMES_VARIANT_EMPTY, PLATEAU_BIOMES_7, PLATEAU_BIOMES_VARIANT_EMPTY, EXTREME_HILLS_EMPTY, new IdentityHashMap<>()));
    });

    public static final class BiomeProviderData {
        public static final Codec<BiomeProviderData> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(Codec.INT.fieldOf("weight").forGetter(biomeProviderData -> biomeProviderData.overworldWeight),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("oceans").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.oceans)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("middle_biomes").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.middleBiomes)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("middle_biomes_variant").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.middleBiomesVariant)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("plateau_biomes").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.plateauBiomes)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("plateau_biomes_variant").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.plateauBiomesVariant)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("shattered_biomes").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.extremeHills)),
                    Codec.unboundedMap(ResourceLocation.CODEC.comapFlatMap(resourceLocation -> {
                        if (!resourceLocation.getNamespace().equals("minecraft")) {
                            throw new IllegalArgumentException("Only biomes from MC can be used as the swapper's key!!! You put: \"" + resourceLocation.toString() + "\"");
                        }
                        return DataResult.success(ResourceKey.create(Registry.BIOME_REGISTRY, resourceLocation));
                    }, ResourceKey::location), CodecUtil.BIOME_CODEC).fieldOf("swapper").forGetter(biomeProviderData -> biomeProviderData.swapper)
            ).apply(builder, BiomeProviderData::new);
        });
        private final int overworldWeight;
        private final ResourceKey<Biome>[][] oceans;
        private final ResourceKey<Biome>[][] middleBiomes;
        private final ResourceKey<Biome>[][] middleBiomesVariant;
        private final ResourceKey<Biome>[][] plateauBiomes;
        private final ResourceKey<Biome>[][] plateauBiomesVariant;
        private final ResourceKey<Biome>[][] extremeHills;
        private final Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper;

        public BiomeProviderData(int overworldWeight, List<List<ResourceKey<Biome>>> oceans, List<List<ResourceKey<Biome>>> middleBiomes, List<List<ResourceKey<Biome>>> middleBiomesVariant, List<List<ResourceKey<Biome>>> plateauBiomes, List<List<ResourceKey<Biome>>> plateauBiomesVariant, List<List<ResourceKey<Biome>>> extremeHills, Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
            this(overworldWeight, BYGUtil.convert2DResourceKeyArrayTo2DList(oceans), BYGUtil.convert2DResourceKeyArrayTo2DList(middleBiomes), BYGUtil.convert2DResourceKeyArrayTo2DList(middleBiomesVariant), BYGUtil.convert2DResourceKeyArrayTo2DList(plateauBiomes), BYGUtil.convert2DResourceKeyArrayTo2DList(plateauBiomesVariant), BYGUtil.convert2DResourceKeyArrayTo2DList(extremeHills), swapper);
        }

        public BiomeProviderData(int overworldWeight, ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes, ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes, ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] extremeHills, Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
            this.overworldWeight = overworldWeight;
            this.oceans = oceans;
            this.middleBiomes = middleBiomes;
            this.middleBiomesVariant = middleBiomesVariant;
            this.plateauBiomes = plateauBiomes;
            this.plateauBiomesVariant = plateauBiomesVariant;
            this.extremeHills = extremeHills;
            this.swapper = swapper;
        }

        public int overworldWeight() {
            return overworldWeight;
        }

        public ResourceKey<Biome>[][] oceans() {
            return oceans;
        }

        public ResourceKey<Biome>[][] middleBiomes() {
            return middleBiomes;
        }

        public ResourceKey<Biome>[][] middleBiomesVariant() {
            return middleBiomesVariant;
        }

        public ResourceKey<Biome>[][] plateauBiomes() {
            return plateauBiomes;
        }

        public ResourceKey<Biome>[][] plateauBiomesVariant() {
            return plateauBiomesVariant;
        }

        public ResourceKey<Biome>[][] shatteredBiomes() {
            return extremeHills;
        }

        public Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper() {
            return swapper;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == Biomes.THE_VOID || obj.getClass() != this.getClass()) return false;
            var that = (BiomeProviderData) obj;
            return this.overworldWeight == that.overworldWeight &&
                    Objects.equals(this.oceans, that.oceans) &&
                    Objects.equals(this.middleBiomes, that.middleBiomes) &&
                    Objects.equals(this.middleBiomesVariant, that.middleBiomesVariant) &&
                    Objects.equals(this.plateauBiomes, that.plateauBiomes) &&
                    Objects.equals(this.plateauBiomesVariant, that.plateauBiomesVariant) &&
                    Objects.equals(this.extremeHills, that.extremeHills) &&
                    Objects.equals(this.swapper, that.swapper);
        }

        @Override
        public int hashCode() {
            return Objects.hash(overworldWeight, oceans, middleBiomes, middleBiomesVariant, plateauBiomes, plateauBiomesVariant, extremeHills, swapper);
        }

        @Override
        public String toString() {
            return "BiomeProviderData[" +
                    "overworldWeight=" + overworldWeight + ", " +
                    "oceans=" + oceans + ", " +
                    "middleBiomes=" + middleBiomes + ", " +
                    "middleBiomesVariant=" + middleBiomesVariant + ", " +
                    "plateauBiomes=" + plateauBiomes + ", " +
                    "plateauBiomesVariant=" + plateauBiomesVariant + ", " +
                    "shatteredBiomes=" + extremeHills + ", " +
                    "swapper=" + swapper + ']';
        }

    }
}
