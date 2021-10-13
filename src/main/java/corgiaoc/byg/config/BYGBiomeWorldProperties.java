package corgiaoc.byg.config;

import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.config.json.biomedata.OverworldPrimaryBiomeData;
import corgiaoc.byg.config.json.biomedata.WeightedBiomeData;
import corgiaoc.byg.util.MLClimate;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.biome.Biome;

import java.util.List;

import static corgiaoc.byg.core.world.BYGBiomes.*;
import static corgiaoc.byg.util.BiomeKeyUtil.EMPTY;
import static net.minecraft.world.level.biome.Biomes.*;

public class BYGBiomeWorldProperties {

    public static final BiomeDataHolders.OverworldPrimaryBiomeDataHolder OVERWORLD_DEFAULTS = new BiomeDataHolders.OverworldPrimaryBiomeDataHolder(Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {
        map.put(ALLIUM_FIELDS, new OverworldPrimaryBiomeData(MLClimate.WARM, 2, List.of("PLAINS", "RARE", "LUSH", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(RED_OAK_FOREST, 2).build()));
        map.put(AMARANTH_FIELDS, new OverworldPrimaryBiomeData(MLClimate.WARM, 2, List.of("PLAINS", "RARE", "LUSH", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(JACARANDA_FOREST, 2).build()));
        map.put(ANCIENT_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 1, List.of("FOREST", "MAGICAL", "RARE", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(FLOWERING_ANCIENT_FOREST, 5).add(GLOWING_ANCIENT_FOREST, 5).build(), EMPTY));
        map.put(ARAUCARIA_SAVANNA, new OverworldPrimaryBiomeData(MLClimate.HOT, 2, List.of("FOREST", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(ARAUCARIA_FOREST, 5).build()));
        map.put(ASPEN_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 6, List.of("FOREST", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(FLOWERING_GROVE, 1).add(GROVE, 7).build()));
        map.put(AUTUMNAL_VALLEY, new OverworldPrimaryBiomeData(MLClimate.COOL, 5, List.of("PLAINS", "DRY", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(CIKA_WOODS, 5).build()));
        map.put(BAOBAB_SAVANNA, new OverworldPrimaryBiomeData(MLClimate.HOT, 6, List.of("SAVANNA", "SPARSE", "DRY", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(SAVANNA, 5).build()));
        map.put(BAYOU, new OverworldPrimaryBiomeData(MLClimate.WARM, 5, List.of("SWAMP", "FOREST", "WET", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, BAYOU, BAYOU));
        map.put(FROSTED_TAIGA, new OverworldPrimaryBiomeData(MLClimate.COOL, 6, List.of("FOREST", "SNOWY", "CONIFEROUS", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(FROSTED_GIANT_TAIGA, 5).build()));
        map.put(BLUFF_STEEPS, new OverworldPrimaryBiomeData(MLClimate.COOL, 6, List.of("MOUNTAIN", "CONIFEROUS", "COLD", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(BLUFF_PEAKS, 10).build()));
        map.put(BOREAL_FOREST, new OverworldPrimaryBiomeData(MLClimate.COOL, 6, List.of("FOREST", "OVERWORLD")));
        map.put(CHERRY_BLOSSOM_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 6, List.of("FOREST", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(BAMBOO_FOREST, 2).add(GROVE, 5).add(FLOWERING_GROVE, 1).build()));
        map.put(CIKA_WOODS, new OverworldPrimaryBiomeData(MLClimate.COOL, 6, List.of("FOREST", "COLD", "CONIFEROUS", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(AUTUMNAL_VALLEY, 5).build()));
        map.put(CONIFEROUS_FOREST, new OverworldPrimaryBiomeData(MLClimate.COOL, 5, List.of("FOREST", "COLD", "CONIFEROUS", "OVERWORLD")));
        map.put(CRAG_GARDENS, new OverworldPrimaryBiomeData(MLClimate.WARM, 1, List.of("JUNGLE", "WET", "PLATEAU", "RARE", "MAGICAL", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), RIVER, EMPTY, CRAG_GARDENS));
        map.put(CYPRESS_SWAMPLANDS, new OverworldPrimaryBiomeData(MLClimate.WARM, 5, List.of("SWAMP", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, CYPRESS_SWAMPLANDS, CYPRESS_SWAMPLANDS));
        map.put(DEAD_SEA, new OverworldPrimaryBiomeData(MLClimate.HOT, 2, List.of("OCEAN", "WASTELAND", "SPOOKY", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, DEAD_SEA, DEAD_SEA));
        map.put(DECIDUOUS_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 6, List.of("FOREST", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(FLOWERING_GROVE, 1).add(GROVE, 7).build()));
        map.put(DOVER_MOUNTAINS, new OverworldPrimaryBiomeData(MLClimate.COOL, 3, List.of("MOUNTAIN", "COLD", "CONIFEROUS", "OVERWORLD")));
        map.put(WINDSWEPT_DUNES, new OverworldPrimaryBiomeData(MLClimate.HOT, 2, List.of("DRY", "HOT", "SANDY", "OVERWORLD")));
        map.put(EBONY_WOODS, new OverworldPrimaryBiomeData(MLClimate.WARM, 4, List.of("FOREST", "DENSE", "OVERWORLD")));
        map.put(ENCHANTED_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 1, List.of("FOREST", "RARE", "MAGICAL", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(ENCHANTED_GROVE, 10).add(FLOWERING_ENCHANTED_GROVE, 5).build()));
        map.put(ENCHANTED_GROVE, new OverworldPrimaryBiomeData(MLClimate.WARM, 1, List.of("PLAINS", "LUSH", "MAGICAL", "RARE", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(FLOWERING_ENCHANTED_GROVE, 1).build()));
        map.put(EVERGREEN_TAIGA, new OverworldPrimaryBiomeData(MLClimate.COOL, 6, List.of("CONIFEROUS", "FOREST", "COLD", "OVERWORLD")));
        map.put(GREAT_LAKES, new OverworldPrimaryBiomeData(MLClimate.COOL, 3, List.of("FOREST", "WATER", "CONIFEROUS", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(GREAT_LAKE_ISLES, 10).build(), EMPTY, GREAT_LAKE_ISLES, GREAT_LAKES));
        map.put(GROVE, new OverworldPrimaryBiomeData(MLClimate.WARM, 3, List.of("PLAINS", "LUSH", "OVERWORLD")));
        map.put(GUIANA_SHIELD, new OverworldPrimaryBiomeData(MLClimate.WARM, 3, List.of("JUNGLE", "HOT", "DENSE", "FOREST", "MOUNTAIN", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, EMPTY, GUIANA_SHIELD));
        map.put(JACARANDA_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 4, List.of("FOREST", "OVERWORLD")));
        map.put(LUSH_TUNDRA, new OverworldPrimaryBiomeData(MLClimate.COLD, 6, List.of("PLAINS", "COLD", "LUSH", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(NORTHERN_FOREST, 10).build(), EMPTY, BASALT_BARRERA, EMPTY));
        map.put(MANGROVE_MARSHES, new OverworldPrimaryBiomeData(MLClimate.WARM, 4, List.of("SWAMP", "FOREST", "WET", "DENSE", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(CORAL_MANGROVES, 10).build(), EMPTY, MANGROVE_MARSHES, MANGROVE_MARSHES));
        map.put(MAPLE_TAIGA, new OverworldPrimaryBiomeData(MLClimate.COOL, 5, List.of("FOREST", "COLD", "OVERWORLD")));
        map.put(COCONINO_MEADOW, new OverworldPrimaryBiomeData(MLClimate.COOL, 7, List.of("PLAINS", "LUSH", "COLD", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(WOODED_COCONINO_MEADOW, 1).add(FLOWERING_COCONINO_MEADOW, 2).build()));
        map.put(MOJAVE_DESERT, new OverworldPrimaryBiomeData(MLClimate.HOT, 3, List.of("DRY", "HOT", "SANDY", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(DESERT, 10).build()));
        map.put(ORCHARD, new OverworldPrimaryBiomeData(MLClimate.WARM, 3, List.of("PLAINS", "LUSH", "FOREST", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(GROVE, 6).add(FLOWERING_GROVE, 2).build()));
        map.put(PRAIRIE, new OverworldPrimaryBiomeData(MLClimate.WARM, 5, List.of("PLAINS", "DRY", "OVERWORLD")));
        map.put(RED_DESERT, new OverworldPrimaryBiomeData(MLClimate.HOT, 2, List.of("DRY", "HOT", "SANDY", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(LUSH_RED_DESERT, 5).build()));
        map.put(RED_OAK_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 7, List.of("FOREST", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(FLOWERING_GROVE, 2).add(GROVE, 4).build()));
        map.put(RED_ROCK_VALLEY, new OverworldPrimaryBiomeData(MLClimate.HOT, 4, List.of("DRY", "HOT", "MOUNTAIN", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, EMPTY, RED_ROCK_VALLEY));
        map.put(REDWOOD_THICKET, new OverworldPrimaryBiomeData(MLClimate.WARM, 1, List.of("FOREST", "DENSE", "RARE", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, ROCKY_BEACH, RED_ROCK_VALLEY));
        map.put(ROSE_FIELDS, new OverworldPrimaryBiomeData(MLClimate.WARM, 2, List.of("OVERWORLD", "PLAINS", "RARE", "LUSH"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(RED_SPRUCE_TAIGA, 10).build()));
        map.put(SEASONAL_BIRCH_FOREST, new OverworldPrimaryBiomeData(MLClimate.COOL, 7, List.of("FOREST", "COLD", "OVERWORLD")));
        map.put(SEASONAL_DECIDUOUS_FOREST, new OverworldPrimaryBiomeData(MLClimate.COOL, 6, List.of("FOREST", "COLD", "OVERWORLD")));
        map.put(SEASONAL_FOREST, new OverworldPrimaryBiomeData(MLClimate.COOL, 7, List.of("FOREST", "COLD", "OVERWORLD")));
        map.put(AUTUMNAL_TAIGA, new OverworldPrimaryBiomeData(MLClimate.COOL, 7, List.of("FOREST", "COLD", "CONIFEROUS", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(AUTUMNAL_GIANT_TAIGA, 5).build()));
        map.put(SHATTERED_GLACIER, new OverworldPrimaryBiomeData(MLClimate.COLD, 2, List.of("SNOWY", "OVERWORLD", "RARE"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, BASALT_BARRERA, SHATTERED_GLACIER));
        map.put(FIRE_CRACKER_SHRUBLANDS, new OverworldPrimaryBiomeData(MLClimate.HOT, 6, List.of("PLAINS", "DRY", "SPARSE", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, EMPTY, FIRE_CRACKER_SHRUBLANDS));
        map.put(SIERRA_VALLEY, new OverworldPrimaryBiomeData(MLClimate.HOT, 5, List.of("DRY", "HOT", "PLAINS", "OVERWORLD")));
        map.put(SKYRIS_VALE, new OverworldPrimaryBiomeData(MLClimate.COOL, 2, List.of("MAGICAL", "FOREST", "LUSH", "RARE", "OVERWORLD")));
        map.put(SNOWY_CONIFEROUS_FOREST, new OverworldPrimaryBiomeData(MLClimate.COLD, 5, List.of("FOREST", "SNOWY", "CONIFEROUS", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, SNOWY_ROCKY_BLACK_BEACH, FROZEN_RIVER));
        map.put(SNOWY_EVERGREEN_TAIGA, new OverworldPrimaryBiomeData(MLClimate.COLD, 5, List.of("CONIFEROUS", "FOREST", "SNOWY", "OVERWORLD")));
        map.put(STONE_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 1, List.of("OVERWORLD", "DENSE", "PLATEAU"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, ROCKY_BEACH, RIVER));
        map.put(THE_BLACK_FOREST, new OverworldPrimaryBiomeData(MLClimate.COOL, 4, List.of("OVERWORLD", "DENSE", "PLATEAU"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(FOREST_FAULT, 10).build(), EMPTY, ROCKY_BEACH, RIVER));
        map.put(TWILIGHT_VALLEY, new OverworldPrimaryBiomeData(MLClimate.COOL, 2, List.of("COLD", "WASTELAND", "MAGICAL", "OVERWORLD")));
        map.put(WEEPING_WITCH_FOREST, new OverworldPrimaryBiomeData(MLClimate.COOL, 1, List.of("FOREST", "COLD", "MAGICAL", "RARE", "SPOOKY", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(PUMPKIN_FOREST, 5).build()));
        map.put(WOODLANDS, new OverworldPrimaryBiomeData(MLClimate.WARM, 4, List.of("FOREST", "DENSE", "MAGICAL", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(FLOWERING_GROVE, 1).add(GROVE, 9).build()));
        map.put(ZELKOVA_FOREST, new OverworldPrimaryBiomeData(MLClimate.COOL, 5, List.of("CONIFEROUS", "COLD", "FOREST", "OVERWORLD")));
    }));

    public static final BiomeDataHolders.OverworldSubBiomeDataHolder OVERWORLD_SUB_DEFAULTS = new BiomeDataHolders.OverworldSubBiomeDataHolder(Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {

    }));

    public static final BiomeDataHolders.WeightedBiomeDataHolder NETHER_DEFAULTS = new BiomeDataHolders.WeightedBiomeDataHolder(Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {
        map.put(BRIMSTONE_CAVERNS, new WeightedBiomeData(6, List.of("NETHER"), BRIMSTONE_CAVERNS));
        map.put(CRIMSON_GARDENS, new WeightedBiomeData(6, List.of("NETHER"), CRIMSON_GARDENS));
        map.put(EMBUR_BOG, new WeightedBiomeData(6, List.of("NETHER"), EMBUR_BOG));
        map.put(GLOWSTONE_GARDENS, new WeightedBiomeData(6, List.of("NETHER"), GLOWSTONE_GARDENS));
        map.put(MAGMA_WASTES, new WeightedBiomeData(6, List.of("NETHER"), MAGMA_WASTES));
        map.put(QUARTZ_DESERT, new WeightedBiomeData(6, List.of("NETHER"), QUARTZ_DESERT));
        map.put(SUBZERO_HYPOGEAL, new WeightedBiomeData(6, List.of("NETHER"), SUBZERO_HYPOGEAL));
        map.put(SYTHIAN_TORRIDS, new WeightedBiomeData(6, List.of("NETHER"), SYTHIAN_TORRIDS));
        map.put(WAILING_GARTH, new WeightedBiomeData(6, List.of("NETHER"), WAILING_GARTH));
        map.put(WARPED_DESERT, new WeightedBiomeData(6, List.of("NETHER"), WARPED_DESERT));
        map.put(WEEPING_MIRE, new WeightedBiomeData(6, List.of("NETHER"), WEEPING_MIRE));
        map.put(WITHERING_WOODS, new WeightedBiomeData(6, List.of("NETHER"), WITHERING_WOODS));

    }));

    public static final BiomeDataHolders.EndBiomeDataHolder END_DEFAULTS = new BiomeDataHolders.EndBiomeDataHolder(Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {
        map.put(BULBIS_GARDENS, new WeightedBiomeData(6, List.of("END"), BULBIS_GARDENS));
        map.put(CRYPTIC_WASTES, new WeightedBiomeData(6, List.of("END"), CRYPTIC_WASTES));
        map.put(ETHEREAL_ISLANDS, new WeightedBiomeData(6, List.of("END"), ETHEREAL_ISLANDS));
        map.put(IMPARIUS_GROVE, new WeightedBiomeData(6, List.of("END"), IMPARIUS_GROVE));
        map.put(IVIS_FIELDS, new WeightedBiomeData(6, List.of("END"), IVIS_FIELDS));
        map.put(NIGHTSHADE_FOREST, new WeightedBiomeData(6, List.of("END"), NIGHTSHADE_FOREST));
        map.put(PURPUR_PEAKS, new WeightedBiomeData(6, List.of("END"), PURPUR_PEAKS));
        map.put(SHATTERED_DESERT, new WeightedBiomeData(6, List.of("END"), SHATTERED_DESERT));
        map.put(SHATTERED_DESERT_ISLES, new WeightedBiomeData(6, List.of("END"), SHATTERED_DESERT_ISLES));
        map.put(SHULKREN_FOREST, new WeightedBiomeData(6, List.of("END"), SHULKREN_FOREST));


    }), Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {
        map.put(VISCAL_ISLES, new WeightedBiomeData(6, List.of("END"), VISCAL_ISLES, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().add(SHATTERED_VISCAL_ISLES, 10).build()));

    }));

    public static final BiomeDataHolders.EndSubBiomeDataHolder END_SUB_DEFAULTS = new BiomeDataHolders.EndSubBiomeDataHolder(Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {
        map.put(BULBIS_GARDENS_EDGE, new WeightedBiomeData(6, List.of("END"), BULBIS_GARDENS_EDGE));
        map.put(ETHEREAL_CLEARING, new WeightedBiomeData(6, List.of("END"), ETHEREAL_CLEARING));
        map.put(ETHEREAL_FOREST, new WeightedBiomeData(6, List.of("END"), ETHEREAL_FOREST));
        map.put(IMPARIUS_CLEARING, new WeightedBiomeData(6, List.of("END"), IMPARIUS_CLEARING));
        map.put(SHATTERED_VISCAL_ISLES, new WeightedBiomeData(6, List.of("END"), SHATTERED_VISCAL_ISLES));

    }), Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {

    }));


}
