package potionstudios.byg.common.world.biome;

import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import potionstudios.byg.mixin.access.OverworldBiomeBuilderAccess;

public class BYGOverworldBiomeBuilder {

//    private static final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
//            {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN}, // Deep oceans
//            {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN} // Oceans
//    };
//    // Left to right is humidity. Index 0 = Dry, Index 5 = Most humid. Hot seems to disregard humidity a whole.
//    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
//            {BYGBiomes.LUSH_TUNDRA, BYGBiomes.SNOWY_CONIFEROUS_FOREST, Biomes.SNOWY_PLAINS, BYGBiomes.FROSTED_TAIGA, Biomes.TAIGA}, // ICY
//            {BYGBiomes.BOREAL_FOREST, BYGBiomes.THE_BLACK_FOREST, BYGBiomes.AUTUMNAL_FOREST, BYGBiomes.AUTUMNAL_TAIGA, BYGBiomes.MAPLE_TAIGA}, // COOL
//            {BYGBiomes.THE_BLACK_FOREST, BYGBiomes.ALLIUM_FIELDS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST}, // NEUTRAL
//            {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE}, // Warm
//            {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT} // Hot
//    };
//
//    // Variant is used when weirdness is > 0 in the range’s max, null values are where MIDDLE_BIOMES place.
//    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
//            {BYGBiomes.SHATTERED_GLACIER, null, null, null, BYGBiomes.FROSTED_GIANT_TAIGA},
//            {BYGBiomes.AUTUMNAL_GIANT_TAIGA, null, BYGBiomes.SKYRIS_VALE, null, BYGBiomes.WEEPING_WITCH_FOREST},
//            {Biomes.SUNFLOWER_PLAINS, null, null, Biomes.OLD_GROWTH_BIRCH_FOREST, null},
//            {null, null, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
//            {null, null, null, null, null}
//    };
//
//    // Left to right is humidity. Index 0 = Dry, Index 5 = Most humid. Hot seems to disregard humidity a whole.
//    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
//            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
//            {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
//            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
//            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
//            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
//    };
//    // Variant is used when weirdness is > 0 in the range’s max, null values are where PLATEAU_BIOMES place.
//    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
//            {Biomes.ICE_SPIKES, null, null, null, null},
//            {null, null, Biomes.MEADOW, Biomes.MEADOW, Biomes.OLD_GROWTH_PINE_TAIGA},
//            {null, null, Biomes.FOREST, Biomes.BIRCH_FOREST, null},
//            {null, null, null, null, null}, {Biomes.ERODED_BADLANDS,
//            Biomes.ERODED_BADLANDS, null, null, null}
//    };
//
//    // Possibly appearing in the high, mid, or peak slices.
//    private static final ResourceKey<Biome>[][] EXTREME_HILLS = new ResourceKey[][]{
//            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
//            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
//            {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
//            {null, null, null, null, null},
//            {null, null, null, null, null}
//    };

    public static final OverworldBiomeBuilder BYG = Util.make(new OverworldBiomeBuilder(), (overworldBiomeBuilder -> {
//        final OverworldBiomeBuilderAccess overworldBiomeBuilderAccess = (OverworldBiomeBuilderAccess) (Object) overworldBiomeBuilder;
//        overworldBiomeBuilderAccess.setOCEANS(OCEANS);
//        overworldBiomeBuilderAccess.setMIDDLE_BIOMES(MIDDLE_BIOMES);
//        overworldBiomeBuilderAccess.setMIDDLE_BIOMES_VARIANT(MIDDLE_BIOMES_VARIANT);
//        overworldBiomeBuilderAccess.setPLATEAU_BIOMES(PLATEAU_BIOMES);
//        overworldBiomeBuilderAccess.setPLATEAU_BIOMES_VARIANT(PLATEAU_BIOMES_VARIANT);
    }));
}
