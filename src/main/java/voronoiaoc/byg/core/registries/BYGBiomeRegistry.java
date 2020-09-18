package voronoiaoc.byg.core.registries;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BYGBiomeRegistry {

    public static List<Biome> biomeList = new ArrayList<>();

    public static void registerBYGBiomes() {
        BYG.LOGGER.debug("BYG: Registering Biomes...");
        registerBiome(BYGBiomeList.DUMMY_BIOME, "dummy_biome");
        registerBiome(BYGBiomeList.ALLIUMFIELDS, "allium_fields");
        registerBiome(BYGBiomeList.ALPS, "alps");
        registerBiome(BYGBiomeList.AMARANTHFIELDS, "amaranth_fields");
        registerBiome(BYGBiomeList.ANCIENTFOREST, "ancient_forest");
        registerBiome(BYGBiomeList.ASPENFOREST, "aspen_forest");
        registerBiome(BYGBiomeList.AUTUMNAL_VALLEY, "autumnal_valley");
        registerBiome(BYGBiomeList.BAOBABSAVANNA, "baobab_savanna");
        registerBiome(BYGBiomeList.BAYOU, "bayou");
        registerBiome(BYGBiomeList.BLUETAIGA, "blue_taiga");
        registerBiome(BYGBiomeList.BLUFFSTEEPS, "bluff_steeps");
        registerBiome(BYGBiomeList.BOREALFOREST, "boreal_forest");
        registerBiome(BYGBiomeList.REDROCKCANYON, "canyons");
        registerBiome(BYGBiomeList.COLDSWAMPLANDS, "cold_swamplands");
        registerBiome(BYGBiomeList.CRAGGARDENS, "crag_gardens");
        registerBiome(BYGBiomeList.CIKA_WOODS, "cika_woods");
        registerBiome(BYGBiomeList.CHERRYBLOSSOMFOREST, "cherry_blossom_forest");
        registerBiome(BYGBiomeList.REDWOOD_TROPICS, "redwood_tropics");
        registerBiome(BYGBiomeList.CONIFEROUSFOREST, "coniferous_forest");
        registerBiome(BYGBiomeList.CYPRESSSWAMPLANDS, "cypress_swamplands");
        registerBiome(BYGBiomeList.DOVERMOUNTAINS, "dover_mountains");
        registerBiome(BYGBiomeList.DEADSEA, "dead_sea");
        registerBiome(BYGBiomeList.DECIDUOUSFOREST, "deciduous_forest");
        registerBiome(BYGBiomeList.DUNES, "dunes");
        registerBiome(BYGBiomeList.EBONYWOODS, "ebony_woods");
        registerBiome(BYGBiomeList.ENCHANTEDFOREST, "enchanted_forest");
        registerBiome(BYGBiomeList.EVERGREENTAIGA, "evergreen_taiga");
        registerBiome(BYGBiomeList.GLOWSHROOMBAYOU, "glowshroom_bayou");
        registerBiome(BYGBiomeList.GRASSLANDPLATEAU, "grassland_plateau");
        registerBiome(BYGBiomeList.GREATLAKES, "great_lakes");
        registerBiome(BYGBiomeList.GROVE, "grove");
        registerBiome(BYGBiomeList.ENCHANTED_GROVE, "enchanted_grove");
        registerBiome(BYGBiomeList.GUIANASHIELD, "guiana_shield");
        registerBiome(BYGBiomeList.JACARANDAFOREST, "jacaranda_forest");
        registerBiome(BYGBiomeList.MANGROVEMARSHES, "mangrove_marshes");
        registerBiome(BYGBiomeList.MAPLETAIGA, "maple_taiga");
        registerBiome(BYGBiomeList.MEADOW, "meadow");
        registerBiome(BYGBiomeList.MOJAVE_DESERT, "mojave_desert");
        registerBiome(BYGBiomeList.LUSH_TUNDRA, "lush_tundra");
        registerBiome(BYGBiomeList.ORCHARD, "orchard");
        registerBiome(BYGBiomeList.PRAIRIE, "prairie");
        registerBiome(BYGBiomeList.REDDESERT, "red_desert");
        registerBiome(BYGBiomeList.REDDESERTDUNES, "red_desert_dunes");
        registerBiome(BYGBiomeList.REDOAKFOREST, "red_oak_forest");
        registerBiome(BYGBiomeList.RED_ROCK_MOUNTAINS, "red_rock_mountains");
        registerBiome(BYGBiomeList.SEASONALBIRCHFOREST, "seasonal_birch_forest");
        registerBiome(BYGBiomeList.SEASONALDECIDUOUSFOREST, "seasonal_deciduous_forest");
        registerBiome(BYGBiomeList.SEASONALFOREST, "seasonal_forest");
        registerBiome(BYGBiomeList.SEASONALTAIGA, "seasonal_taiga");
        registerBiome(BYGBiomeList.SHATTEREDGLACIER, "shattered_glacier");
        registerBiome(BYGBiomeList.SHRUBLANDS, "shrublands");
        registerBiome(BYGBiomeList.SKYRISHIGHLANDS, "skyris_highlands");
        registerBiome(BYGBiomeList.SNOWYBLUETAIGA, "snowy_blue_taiga");
        registerBiome(BYGBiomeList.SNOWYCONIFEROUSFOREST, "snowy_coniferous_forest");
        registerBiome(BYGBiomeList.SNOWYDECIDUOUSFOREST, "snowy_deciduous_forest");
//        registerBiome(registry, BYGBiomeList.SAVANNACANOPY, "savanna_canopy",  true, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);

        registerBiome(BYGBiomeList.SNOWYEVERGREENTAIGA, "snowy_evergreen_taiga");
        //registerBiome(registry, BYGBiomeList.SONORANDESERT, "sonorandesert", ConfigWeightManager.sonorandesert.getWeight(), true, BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY);
        //registerBiome(registry, BYGBiomeList.STONEBRUSHLANDS, "stonebrushlands", ConfigWeightManager.stonebrushlands.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.COLD);
//        registerBiome(registry, BYGBiomeList.STONEFOREST, "stoneforest", ConfigWeightManager.stoneforest.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.COLD);
        registerBiome(BYGBiomeList.STONE_FOREST, "stone_forest");
        registerBiome(BYGBiomeList.THE_BLACK_FOREST, "the_black_forest");
        registerBiome(BYGBiomeList.TROPICALFUNGALRAINFOREST, "tropical_fungal_forest");
        registerBiome(BYGBiomeList.TROPICALRAINFOREST, "tropical_rainforest");
        registerBiome(BYGBiomeList.VIBRANTSWAMPLANDS, "vibrant_swamplands");
//        registerBiome(BYGBiomeList.VOLCANO, "volcano");
        registerBiome(BYGBiomeList.SIERRAVALLEY, "sierra_valley");
        registerBiome(BYGBiomeList.WEEPINGWITCHFOREST, "weeping_witch_forest");
        registerBiome(BYGBiomeList.WOODLANDS, "woodlands");
        registerBiome(BYGBiomeList.ZELKOVAFOREST, "zelkova_forest");

        registerBYGSubBiome(BYGBiomeList.REDWOOD_CLEARING, "redwood_clearing");
        registerBYGSubBiome(BYGBiomeList.REDWOOD_MOUNTAINS, "redwood_mountains");
        registerBYGSubBiome(BYGBiomeList.CORAL_MANGROVES, "coral_mangroves");
        registerBYGSubBiome(BYGBiomeList.CIKA_MOUNTAINS, "cika_mountains");
        registerBYGSubBiome(BYGBiomeList.GLOWING_ANCIENT_FOREST, "glowing_ancient_forest");
        registerBYGSubBiome(BYGBiomeList.FLOWERING_ANCIENT_FOREST, "flowering_ancient_forest");

        //Sub Biomes
        registerBYGSubBiome(BYGBiomeList.SNOWY_EVERGREEN_CLEARING, "snowy_evergreen_clearing");
        registerBYGSubBiome(BYGBiomeList.SNOWY_EVERGREEN_HILLS, "snowy_evergreen_hills");
        registerBYGSubBiome(BYGBiomeList.ENCHANTED_FOREST_HILLS, "enchanted_forest_hills");
        registerBYGSubBiome(BYGBiomeList.EBONY_HILLS, "ebony_hills");
        registerBYGSubBiome(BYGBiomeList.EVERGREEN_CLEARING, "evergreen_clearing");
        registerBYGSubBiome(BYGBiomeList.EVERGREEN_HILLS, "evergreen_hills");
        registerBYGSubBiome(BYGBiomeList.FUNGAL_PATCH, "fungal_patch");
        registerBYGSubBiome(BYGBiomeList.WEEPING_WTICH_CLEARING, "weeping_witch_clearing");
        registerBYGSubBiome(BYGBiomeList.PUMPKIN_FOREST, "pumpkin_forest");
        registerBYGSubBiome(BYGBiomeList.BAMBOO_FOREST, "bamboo_forest");
        registerBYGSubBiome(BYGBiomeList.CHERRY_BLOSSOM_CLEARING, "cherry_blossom_clearing");
        registerBYGSubBiome(BYGBiomeList.CONIFEROUS_CLEARING, "coniferous_clearing");
        registerBYGSubBiome(BYGBiomeList.ZELKOVA_CLEARING, "zelkova_clearing");
        registerBYGSubBiome(BYGBiomeList.ASPEN_CLEARING, "aspen_clearing");
        registerBYGSubBiome(BYGBiomeList.BOREALIS_CLEARING, "boreal_clearing");
        registerBYGSubBiome(BYGBiomeList.DECIDUOUS_CLEARING, "deciduous_clearing");
        registerBYGSubBiome(BYGBiomeList.SEASONAL_DECIDUOUS_CLEARING, "seasonal_deciduous_clearing");
        registerBYGSubBiome(BYGBiomeList.GUIANA_CLEARING, "guiana_clearing");
        registerBYGSubBiome(BYGBiomeList.JACARANDA_CLEARING, "jacaranda_clearing");
        registerBYGSubBiome(BYGBiomeList.SNOWY_CONIFEROUS_CLEARING, "snowy_coniferous_clearing");
        registerBYGSubBiome(BYGBiomeList.SNOWY_DECIDUOUS_CLEARING, "snowy_deciduous_clearing");

        registerBYGSubBiome(BYGBiomeList.MAPLE_HILLS, "maple_hills");
        registerBYGSubBiome(BYGBiomeList.BLACK_FOREST_CLEARING, "black_forest_clearing");
        registerBYGSubBiome(BYGBiomeList.BLACK_FOREST_HILLS, "black_forest_hills");
        registerBYGSubBiome(BYGBiomeList.FOREST_FAULT, "forest_fault");
        registerBYGSubBiome(BYGBiomeList.FLOWERING_GROVE, "flowering_grove");
        registerBYGSubBiome(BYGBiomeList.FLOWERING_ENCHANTED_GROVE, "flowering_enchanted_grove");
        registerBYGSubBiome(BYGBiomeList.NORTHERN_FOREST, "northern_forest");
        registerBYGSubBiome(BYGBiomeList.LUSHREDDESERT, "lush_red_desert");
        registerBYGSubBiome(BYGBiomeList.SIERRARANGE, "sierra_range");
        registerBYGSubBiome(BYGBiomeList.ALPINEFOOTHILLS, "alpine_foothills");
        registerBYGSubBiome(BYGBiomeList.ASPENFORESTHILLS, "aspen_forest_hills");
        registerBYGSubBiome(BYGBiomeList.BLUETAIGAHILLS, "blue_taiga_hills");
        registerBYGSubBiome(BYGBiomeList.BLUEGIANTTAIGA, "blue_giant_taiga");
        registerBYGSubBiome(BYGBiomeList.BLUFFPEAKS, "bluff_peaks");
        registerBYGSubBiome(BYGBiomeList.BOREALFORESTHILLS, "boreal_forest_hills");
        registerBYGSubBiome(BYGBiomeList.BOG, "bog");
        registerBYGSubBiome(BYGBiomeList.DECIDUOUSFORESTHILLS, "deciduous_forest_hills");
        registerBYGSubBiome(BYGBiomeList.CONIFEROUSFORESTHILLS, "coniferous_forest_hills");
        registerBYGSubBiome(BYGBiomeList.FRESHWATERLAKE, "fresh_water_lake");
        registerBYGSubBiome(BYGBiomeList.FROZENLAKE, "frozen_lake");
        registerBYGSubBiome(BYGBiomeList.GREATLAKEISLES, "great_lake_isles");
        registerBYGSubBiome(BYGBiomeList.JACARANDAFORESTHILLS, "jacaranda_forest_hills");
        registerBYGSubBiome(BYGBiomeList.MARSHLANDS, "marshlands");
        registerBYGSubBiome(BYGBiomeList.OASIS, "oasis");
        registerBYGSubBiome(BYGBiomeList.POLLUTEDLAKE, "polluted_lake");
        registerBYGSubBiome(BYGBiomeList.PRAIRIECLEARING, "prairie_clearing");
        registerBYGSubBiome(BYGBiomeList.REDOAKFORESTHILLS, "red_oak_forest_hills");
        registerBYGSubBiome(BYGBiomeList.RED_ROCK_LOWLANDS, "red_rock_lowlands");
        registerBYGSubBiome(BYGBiomeList.RED_ROCK_HIGHLANDS, "red_rock_highlands");
        registerBYGSubBiome(BYGBiomeList.WOODEDREDROCKMOUNTAINS, "wooded_red_rock_mountains");
        registerBYGSubBiome(BYGBiomeList.SEASONALBIRCHFORESTHILLS, "seasonal_birch_forest_hills");
        registerBYGSubBiome(BYGBiomeList.SEASONALDECIDUOUSFORESTHILLS, "seasonal_deciduous_forest_hills");
        registerBYGSubBiome(BYGBiomeList.SEASONALFORESTHILLS, "seasonal_forest_hills");
        registerBYGSubBiome(BYGBiomeList.SEASONALGIANTTAIGA, "seasonal_giant_taiga");
        registerBYGSubBiome(BYGBiomeList.SEASONALTAIGAHILLS, "seasonal_taiga_hills");
        registerBYGSubBiome(BYGBiomeList.SNOWYBLUEGIANTTAIGA, "snowy_blue_giant_taiga");
        registerBYGSubBiome(BYGBiomeList.SNOWYBLUETAIGAHILLS, "snowy_blue_taiga_hills");
        registerBYGSubBiome(BYGBiomeList.SNOWYCONIFERFORESTHILLS, "snowy_coniferous_forest_hills");
        registerBYGSubBiome(BYGBiomeList.SNOWYDECIDUOUSFORESTHILLS, "snowy_deciduous_forest_hills");
        registerBYGSubBiome(BYGBiomeList.TROPICALFUNGALRAINFORESTHILLS, "tropical_fungal_rainforest_hills");
        registerBYGSubBiome(BYGBiomeList.TROPICALRAINFORESTHILLS, "tropical_rainforest_hills");
        registerBYGSubBiome(BYGBiomeList.WOODEDGRASSLANDPLATEAU, "wooded_grassland_plateau");
        registerBYGSubBiome(BYGBiomeList.ZELKOVAFORESTHILLS, "zelkova_forest_hills");
        registerBYGSubBiome(BYGBiomeList.FLOWERINGMEADOW, "flowering_meadow");
        registerBYGSubBiome(BYGBiomeList.WOODEDMEADOW, "wooded_meadow");
        registerBYGSubBiome(BYGBiomeList.TROPICAL_ISLAND_CLEARING, "tropical_island_clearing");
        registerBYGSubBiome(BYGBiomeList.TROPICAL_ISLAND_MOUNTAINS, "tropical_island_mountains");


        //NonDefault Biomes.
        registerBYGBiome(BYGBiomeList.ROCKYBEACH, "rocky_beach");
        registerBYGBiome(BYGBiomeList.BASALT_BARRERA, "basalt_barrera");
        registerBYGBiome(BYGBiomeList.SNOWYROCKYBLACKBEACH, "snowy_rocky_black_beach");
        registerBYGBiome(BYGBiomeList.SNOWYBLACKBEACH, "snowy_black_beach");
        registerBYGBiome(BYGBiomeList.WHITEBEACH, "white_beach");
        registerBYGBiome(BYGBiomeList.RAINBOWBEACH, "rainbow_beach");
        registerBYGBiome(BYGBiomeList.TROPICALISLAND, "tropical_island");

        //Nether
        registerNetherBiome(BYGBiomeList.WARPEDDESERT, "warped_desert");
        registerNetherBiome(BYGBiomeList.SYTHIANTORRIDS, "sythian_torrids");
        registerNetherBiome(BYGBiomeList.GLOWSTONEGARDENS, "glowstone_gardens");
        registerNetherBiome(BYGBiomeList.EMBURBOG, "embur_bog");
        registerNetherBiome(BYGBiomeList.WAILING_GARTH, "wailing_garth");
        registerNetherBiome(BYGBiomeList.CRIMSON_GARDENS, "crimson_gardens");

        //End
        registerBYGEndBiome(BYGBiomeList.IVISFIELDS, "ivis_fields");

        BYG.LOGGER.info("BYG: Biomes Registered!");

    }

    private static void registerBiome(Biome biome, String name) {
        Registry.register(WorldGenRegistries.BIOME, new ResourceLocation(BYG.MOD_ID, name), biome);
        biomeList.add(biome);

//        if (withSpawner) {
//            BiomeManager.addSpawnBiome(biome);
//        }
    }

    private static void registerBYGBiome(Biome biome, String name) {
        Registry.register(WorldGenRegistries.BIOME, new ResourceLocation(BYG.MOD_ID, name), biome);
        biomeList.add(biome);

    }

    private static void registerBYGEndBiome(Biome biome, String name) {
        Registry.register(WorldGenRegistries.BIOME, new ResourceLocation(BYG.MOD_ID, name), biome);
        BYGEndBiomeProvider.bygEndBiomeList.add(biome);
        biomeList.add(biome);
    }

    private static void registerNetherBiome(Biome biome, String name) {
        Registry.register(WorldGenRegistries.BIOME, new ResourceLocation(BYG.MOD_ID, name), biome);
        biomeList.add(biome);
    }


    private static void registerBYGSubBiome(Biome biome, String name) {
        Registry.register(WorldGenRegistries.BIOME, new ResourceLocation(BYG.MOD_ID, name), biome);
        biomeList.add(biome);
    }

    public static void addBiomeNumericalIDsForLayerSampler() {
        for (Biome biome : biomeList) {
            Optional<RegistryKey<Biome>> key = WorldGenRegistries.BIOME.getOptionalKey(biome);
            if (key.isPresent())
                key.ifPresent(biomeRegistryKey -> BiomeRegistry.idToKeyMap.put(WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(key.get())), biomeRegistryKey));
        }
    }
}
