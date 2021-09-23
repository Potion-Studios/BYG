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
import static net.minecraft.world.level.biome.Biomes.RIVER;
import static net.minecraft.world.level.biome.Biomes.SAVANNA;

public class BYGBiomeWorldProperties {

    public static final BiomeDataHolders.OverworldPrimaryBiomeDataHolder OVERWORLD_DEFAULTS = new BiomeDataHolders.OverworldPrimaryBiomeDataHolder(Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {
        map.put(ALLIUM_FIELDS, new OverworldPrimaryBiomeData(MLClimate.WARM, 2, List.of("PLAINS", "RARE", "LUSH", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> builder.add(JACARANDA_FOREST, 5))).build()));
        map.put(AMARANTH_FIELDS, new OverworldPrimaryBiomeData(MLClimate.WARM, 2, List.of("PLAINS", "RARE", "LUSH", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> builder.add(RED_OAK_FOREST, 5))).build()));
        map.put(ANCIENT_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 1, List.of("FOREST", "MAGICAL", "RARE", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> {
            builder.add(FLOWERING_ANCIENT_FOREST, 5);
            builder.add(GLOWING_ANCIENT_FOREST, 5);
        })).build(), EMPTY));
        map.put(ARAUCARIA_SAVANNA, new OverworldPrimaryBiomeData(MLClimate.HOT, 2, List.of("FOREST", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> builder.add(ARAUCARIA_FOREST, 5))).build()));
        map.put(ASPEN_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 6, List.of("FOREST", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> {
            builder.add(FLOWERING_GROVE, 1);
            builder.add(GROVE, 7);
        })).build()));
        map.put(AUTUMNAL_VALLEY, new OverworldPrimaryBiomeData(MLClimate.COOL, 5, List.of("PLAINS", "DRY", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> builder.add(CIKA_WOODS, 5))).build()));
        map.put(BAOBAB_SAVANNA, new OverworldPrimaryBiomeData(MLClimate.HOT, 6, List.of("SAVANNA", "SPARSE", "DRY", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> builder.add(SAVANNA, 5))).build()));
        map.put(BAYOU, new OverworldPrimaryBiomeData(MLClimate.WARM, 5, List.of("SWAMP", "FOREST", "WET", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, BAYOU, BAYOU));
        map.put(BLUE_TAIGA, new OverworldPrimaryBiomeData(MLClimate.COOL, 6, List.of("FOREST", "COLD", "CONIFEROUS", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> builder.add(BLUE_GIANT_TAIGA, 5))).build()));
        map.put(BLUFF_STEEPS, new OverworldPrimaryBiomeData(MLClimate.COOL, 6, List.of("MOUNTAIN", "CONIFEROUS", "COLD", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> builder.add(BLUFF_PEAKS, 10))).build()));
        map.put(BOREAL_FOREST, new OverworldPrimaryBiomeData(MLClimate.COOL, 6, List.of("FOREST", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(CHERRY_BLOSSOM_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 6, List.of("FOREST", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> {
            builder.add(BAMBOO_FOREST, 2);
            builder.add(GROVE, 5);
            builder.add(FLOWERING_GROVE, 1);
        })).build()));
        map.put(CIKA_WOODS, new OverworldPrimaryBiomeData(MLClimate.COOL, 6, List.of("FOREST", "COLD", "CONIFEROUS", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> builder.add(AUTUMNAL_VALLEY, 5))).build()));
        map.put(CONIFEROUS_FOREST, new OverworldPrimaryBiomeData(MLClimate.COOL, 5, List.of("FOREST", "COLD", "CONIFEROUS", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(CRAG_GARDENS, new OverworldPrimaryBiomeData(MLClimate.WARM, 1, List.of("JUNGLE", "WET", "PLATEAU", "RARE", "MAGICAL", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), RIVER, EMPTY, CRAG_GARDENS));
        map.put(CYPRESS_SWAMPLANDS, new OverworldPrimaryBiomeData(MLClimate.WARM, 5, List.of("SWAMP", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, CYPRESS_SWAMPLANDS, CYPRESS_SWAMPLANDS));
        map.put(DEAD_SEA, new OverworldPrimaryBiomeData(MLClimate.HOT, 2, List.of("OCEAN", "WASTELAND", "SPOOKY", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build(), EMPTY, DEAD_SEA, DEAD_SEA));
        map.put(DECIDUOUS_FOREST, new OverworldPrimaryBiomeData(MLClimate.WARM, 6, List.of("FOREST", "OVERWORLD"), Util.make(new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>(), (builder -> {
            builder.add(FLOWERING_GROVE, 1);
            builder.add(GROVE, 7);
        })).build()));
        map.put(DOVER_MOUNTAINS, new OverworldPrimaryBiomeData(MLClimate.COOL, 3, List.of("MOUNTAIN", "COLD", "CONIFEROUS", "OVERWORLD"), new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
    }));

    public static final BiomeDataHolders.OverworldSubBiomeDataHolder OVERWORLD_SUB_DEFAULTS = new BiomeDataHolders.OverworldSubBiomeDataHolder(Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {

    }));

    public static final BiomeDataHolders.WeightedBiomeDataHolder NETHER_DEFAULTS = new BiomeDataHolders.WeightedBiomeDataHolder(Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {
        map.put(BRIMSTONE_CAVERNS, new WeightedBiomeData(6, List.of("NETHER"), BRIMSTONE_CAVERNS, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(CRIMSON_GARDENS, new WeightedBiomeData(6, List.of("NETHER"), CRIMSON_GARDENS, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(EMBUR_BOG, new WeightedBiomeData(6, List.of("NETHER"), EMBUR_BOG, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(GLOWSTONE_GARDENS, new WeightedBiomeData(6, List.of("NETHER"), GLOWSTONE_GARDENS, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(MAGMA_WASTES, new WeightedBiomeData(6, List.of("NETHER"), MAGMA_WASTES, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(QUARTZ_DESERT, new WeightedBiomeData(6, List.of("NETHER"), QUARTZ_DESERT, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(SUBZERO_HYPOGEAL, new WeightedBiomeData(6, List.of("NETHER"), SUBZERO_HYPOGEAL, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(SYTHIAN_TORRIDS, new WeightedBiomeData(6, List.of("NETHER"), SYTHIAN_TORRIDS, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(WAILING_GARTH, new WeightedBiomeData(6, List.of("NETHER"), WAILING_GARTH, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(WARPED_DESERT, new WeightedBiomeData(6, List.of("NETHER"), WARPED_DESERT, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(WEEPING_MIRE, new WeightedBiomeData(6, List.of("NETHER"), WEEPING_MIRE, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(WITHERING_WOODS, new WeightedBiomeData(6, List.of("NETHER"), WITHERING_WOODS, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));

    }));

    public static final BiomeDataHolders.EndBiomeDataHolder END_DEFAULTS = new BiomeDataHolders.EndBiomeDataHolder(Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {
        map.put(BULBIS_GARDENS, new WeightedBiomeData(6, List.of("END"), BULBIS_GARDENS, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(CRYPTIC_WASTES, new WeightedBiomeData(6, List.of("END"), CRYPTIC_WASTES, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(ETHEREAL_ISLANDS, new WeightedBiomeData(6, List.of("END"), ETHEREAL_ISLANDS, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(IMPARIUS_GROVE, new WeightedBiomeData(6, List.of("END"), IMPARIUS_GROVE, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(IVIS_FIELDS, new WeightedBiomeData(6, List.of("END"), IVIS_FIELDS, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(NIGHTSHADE_FOREST, new WeightedBiomeData(6, List.of("END"), NIGHTSHADE_FOREST, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(PURPUR_PEAKS, new WeightedBiomeData(6, List.of("END"), PURPUR_PEAKS, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(SHATTERED_DESERT, new WeightedBiomeData(6, List.of("END"), SHATTERED_DESERT, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(SHATTERED_DESERT_ISLES, new WeightedBiomeData(6, List.of("END"), SHATTERED_DESERT_ISLES, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(SHULKREN_FOREST, new WeightedBiomeData(6, List.of("END"), SHULKREN_FOREST, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(VISCAL_ISLES, new WeightedBiomeData(6, List.of("END"), VISCAL_ISLES, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));


    }), Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {

    }));

    public static final BiomeDataHolders.EndSubBiomeDataHolder END_SUB_DEFAULTS = new BiomeDataHolders.EndSubBiomeDataHolder(Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {
        map.put(BULBIS_GARDENS_EDGE, new WeightedBiomeData(6, List.of("END"), BULBIS_GARDENS_EDGE, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(ETHEREAL_CLEARING, new WeightedBiomeData(6, List.of("END"), ETHEREAL_CLEARING, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(ETHEREAL_FOREST, new WeightedBiomeData(6, List.of("END"), ETHEREAL_FOREST, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(IMPARIUS_CLEARING, new WeightedBiomeData(6, List.of("END"), IMPARIUS_CLEARING, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));
        map.put(SHATTERED_VISCAL_ISLES, new WeightedBiomeData(6, List.of("END"), SHATTERED_VISCAL_ISLES, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build()));

    }), Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {

    }));


}
