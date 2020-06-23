package voronoiaoc.byg.core.registries;

import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.fabricmc.fabric.api.biomes.v1.NetherBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

public class BYGBiomeRegistry {

    public static void registerBiomes() {
        registerBiome(BYGBiomeList.ALLIUMFIELDS, "allium_fields", true, 10,   OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ALPS, "alps", true, 10,  OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.AMARANTHFIELDS, "amaranth_fields", true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ASPENFOREST, "aspen_forest", true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.BAOBABSAVANNA, "baobab_savanna",  true, 10,  OverworldClimate.DRY);
        registerBiome(BYGBiomeList.BAYOU, "bayou",  true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.BLUETAIGA, "blue_taiga",  true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.BLUFFSTEEPS, "bluff_steeps",  true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.BOREALFOREST, "boreal_forest",  true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.COLDSWAMPLANDS, "cold_swamplands", true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.CRAGGARDENS, "crag_gardens",  true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.REDROCKCANYON, "red_rock_canyon", false, 10, OverworldClimate.DRY);
        registerBiome(BYGBiomeList.CONIFEROUSFOREST, "coniferous_forest",  true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.DOVERMOUNTAINS, "dover_mountains",true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.DEADSEA, "deadsea",  true, 10,  OverworldClimate.DRY);
        registerBiome(BYGBiomeList.DECIDUOUSFOREST, "deciduous_forest",  true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.DUNES, "dunes",  true, 10,  OverworldClimate.DRY);
        registerBiome(BYGBiomeList.GLOWSHROOMBAYOU, "glowshroom_bayou",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.GRASSLANDPLATEAU, "grassland_plateau",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.GREATLAKES, "great_lakes",true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.GUIANASHIELD, "guiana_shield",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.JACARANDAFOREST, "jacaranda_forest",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.MEADOW, "meadow",  true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.MOJAVE_DESERT, "mojave_desert",  true, 10,  OverworldClimate.DRY);
        registerBiome(BYGBiomeList.PRAIRIE, "prairie",  true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.REDDESERT, "red_desert",  true, 10,  OverworldClimate.DRY);
        registerBiome(BYGBiomeList.REDDESERTDUNES, "red_desert_dunes",  true, 10,  OverworldClimate.DRY);
        registerBiome(BYGBiomeList.REDOAKFOREST, "red_oak_forest",  true, 10,  OverworldClimate.TEMPERATE)  ;
        registerBiome(BYGBiomeList.RED_ROCK_MOUNTAINS, "red_rock_mountains",  true, 10,  OverworldClimate.DRY);
        registerBiome(BYGBiomeList.SEASONALBIRCHFOREST, "seasonal_birch_forest",  true, 10,  OverworldClimate.COOL)   ;
        registerBiome(BYGBiomeList.SEASONALDECIDUOUSFOREST, "seasonal_deciduous_forest",  true, 10,  OverworldClimate.COOL)  ;
        registerBiome(BYGBiomeList.SEASONALFOREST, "seasonal_forest", true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SEASONALTAIGA, "seasonal_taiga",  true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SHATTEREDGLACIER, "shattered_glacier",  true, 10,  OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.SHRUBLANDS, "shrublands",  true, 10,  OverworldClimate.DRY);
        registerBiome(BYGBiomeList.SKYRISHIGHLANDS, "skyris_highlands",  true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SNOWYBLUETAIGA, "snowy_blue_taiga",true, 10,  OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.SNOWYCONIFEROUSFOREST, "snowy_coniferous_forest",true, 10,  OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.SNOWYDECIDUOUSFOREST, "snowy_deciduous_forest",true, 10,  OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.TROPICALFUNGALRAINFOREST, "tropical_fungal_forest",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.TROPICALRAINFOREST, "tropical_rain_forest",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.VIBRANTSWAMPLANDS, "vibrant_swamplands",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.SIERRAVALLEY, "sierra_valley",true, 10,  OverworldClimate.DRY);
        registerBiome(BYGBiomeList.ZELKOVAFOREST, "zelkova_forest",true,  10, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.AUTUMNAL_VALLEY, "autumnal_valley",true,  10, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.CYPRESSSWAMPLANDS, "cypress_swamplands",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.CHERRYBLOSSOMFOREST, "cherry_blossom_forest",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.EBONYWOODS, "ebony_woods",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ENCHANTEDFOREST, "enchanted_forest",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.EVERGREENTAIGA, "evergreen_taiga",true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.ENCHANTED_GROVE, "enchanted_grove",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.GROVE, "grove",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.MANGROVEMARSHES, "mangrove_marshes",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.MAPLETAIGA, "maple_taiga",true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.LUSH_TUNDRA, "lush_tundra",true, 10,  OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.ORCHARD, "orchard",true, 10,  OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.SNOWYEVERGREENTAIGA, "snowy_evergreen_taiga",true, 10,  OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.THE_BLACK_FOREST, "the_black_forest",true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.WEEPINGWITCHFOREST, "weeping_witch_forest",true, 10,  OverworldClimate.COOL);
        registerBiome(BYGBiomeList.WOODLANDS, "woodlands",true, 10,  OverworldClimate.TEMPERATE);


        registerSubBiome(BYGBiomeList.LUSHREDDESERT, "lush_red_desert",true);
        registerSubBiome(BYGBiomeList.SIERRARANGE, "sierra_range",true);
        registerSubBiome(BYGBiomeList.ALPINEFOOTHILLS, "alpine_foothills",true);
        registerSubBiome(BYGBiomeList.ASPENFORESTHILLS, "aspen_forest_hills",true);
        registerSubBiome(BYGBiomeList.BLUETAIGAHILLS, "blue_taiga_hills",true);
        registerSubBiome(BYGBiomeList.BLUEGIANTTAIGA, "blue_giant_spruce_taiga",true);
        registerSubBiome(BYGBiomeList.BLUFFPEAKS, "bluff_peaks", true);
        registerSubBiome(BYGBiomeList.BOREALFORESTHILLS, "boreal_forest_hills",true);
        registerSubBiome(BYGBiomeList.BOG, "bog", true);
        registerSubBiome(BYGBiomeList.DECIDUOUSFORESTHILLS, "deciduous_forest_hills",true);
        registerSubBiome(BYGBiomeList.CONIFEROUSFORESTHILLS, "coniferousforesthills",true);
        registerSubBiome(BYGBiomeList.FRESHWATERLAKE, "fresh_water_lake",true);
        registerSubBiome(BYGBiomeList.FROZENLAKE, "frozen_lake", true);
        registerSubBiome(BYGBiomeList.GREATLAKEISLES, "great_lake_isles", true);
        registerSubBiome(BYGBiomeList.JACARANDAFORESTHILLS, "jacaranda_forest_hills",true);
        registerSubBiome(BYGBiomeList.MARSHLANDS, "marshlands", true);
        registerSubBiome(BYGBiomeList.OASIS, "oasis", true);
        registerSubBiome(BYGBiomeList.POLLUTEDLAKE, "polluted_lake", true);
        registerSubBiome(BYGBiomeList.PRAIRIECLEARING, "prairie_clearing", true);
        registerSubBiome(BYGBiomeList.REDOAKFORESTHILLS, "red_oak_forest_hills", true);
        registerSubBiome(BYGBiomeList.RED_ROCK_LOWLANDS, "red_rock_lowlands", true);
        registerSubBiome(BYGBiomeList.RED_ROCK_HIGHLANDS, "red_rock_highlands", true);
        registerSubBiome(BYGBiomeList.WOODEDREDROCKMOUNTAINS, "wooded_red_rock_mountains",true);
        registerSubBiome(BYGBiomeList.SEASONALBIRCHFORESTHILLS, "seasonal_birch_forest_hills",true);
        registerSubBiome(BYGBiomeList.SEASONALDECIDUOUSFORESTHILLS, "seasonal_deciduous_forest_hills",true);
        registerSubBiome(BYGBiomeList.SEASONALFORESTHILLS, "seasonal_forest_hills",true );
        registerSubBiome(BYGBiomeList.SEASONALGIANTTAIGA, "giant_seasonal_spruce_taiga",true);
        registerSubBiome(BYGBiomeList.SEASONALTAIGAHILLS, "seasonal_taiga_hills", true);
        registerSubBiome(BYGBiomeList.SNOWYBLUEGIANTTAIGA, "snowy_giant_blue_taiga",true);
        registerSubBiome(BYGBiomeList.SNOWYBLUETAIGAHILLS, "snowy_blue_taiga_hills", true);
        registerSubBiome(BYGBiomeList.SNOWYCONIFERFORESTHILLS, "snowy_coniferous_forest_hills", true);
        registerSubBiome(BYGBiomeList.SNOWYDECIDUOUSFORESTHILLS, "snowy_deciduous_forest_hills", true);
        registerSubBiome(BYGBiomeList.TROPICALFUNGALRAINFORESTHILLS, "tropical_fungal_rainforest_hills", true);
        registerSubBiome(BYGBiomeList.TROPICALRAINFORESTHILLS, "tropical_rainforest_hills", true);
        registerSubBiome(BYGBiomeList.WOODEDGRASSLANDPLATEAU, "wooded_grassland_plateau", true);
        registerSubBiome(BYGBiomeList.ZELKOVAFORESTHILLS, "zelkova_forest_hills", true);
        registerSubBiome(BYGBiomeList.FLOWERINGMEADOW, "flowering_meadow",  true);
        registerSubBiome(BYGBiomeList.WOODEDMEADOW, "wooded_meadow", true);
        registerSubBiome(BYGBiomeList.FUNGAL_PATCH, "fungal_patch", true);
        registerSubBiome(BYGBiomeList.MAPLE_HILLS, "maple_hills", true);
        registerSubBiome(BYGBiomeList.PUMPKIN_FOREST, "pumpkin_forest", true);
        registerSubBiome(BYGBiomeList.EBONY_HILLS, "ebony_hills", true);
        registerSubBiome(BYGBiomeList.SNOWY_EVERGREEN_CLEARING, "snowy_evergreen_clearing", true);
        registerSubBiome(BYGBiomeList.SNOWY_EVERGREEN_HILLS, "snowy_evergreen_hills", true);
        registerSubBiome(BYGBiomeList.WEEPING_WTICH_CLEARING, "weeping_witch_clearing", true);
        registerSubBiome(BYGBiomeList.ZELKOVA_CLEARING, "zelkova_clearing", true);
        registerSubBiome(BYGBiomeList.SEASONAL_DECIDUOUS_CLEARING, "seasonal_deciduous_clearing", true);
        registerSubBiome(BYGBiomeList.JACARANDA_CLEARING, "jacaranda_clearing", true);
        registerSubBiome(BYGBiomeList.SNOWY_CONIFEROUS_CLEARING, "snowy_coniferous_clearing", true);
        registerSubBiome(BYGBiomeList.SNOWY_DECIDUOUS_CLEARING, "snowy_deciduous_clearing", true);
        registerSubBiome(BYGBiomeList.RAINBOWBEACH, "rainbow_beach", true);
        registerSubBiome(BYGBiomeList.ROCKYBEACH, "rocky_beach", true);
        registerSubBiome(BYGBiomeList.SNOWYBLACKBEACH, "snowy_black_beach", true);
        registerSubBiome(BYGBiomeList.SNOWYROCKYBLACKBEACH, "snowy_rocky_black_beach", true);
        registerSubBiome(BYGBiomeList.WHITEBEACH, "white_beach", true);

        registerNetherBiome(BYGBiomeList.GLOWSTONEGARDENS, "glowstone_gardens");
        registerNetherBiome(BYGBiomeList.WARPEDDESERT, "warped_desert");
        registerNetherBiome(BYGBiomeList.SYTHIANTORRIDS, "sythian_torrids");

        registerEndBiome(BYGBiomeList.IVISFIELDS, "ivis_fields");
    }

    private static void registerBiome(Biome biome, String id, boolean spawn, int weight, OverworldClimate climate) {
        Registry.register(Registry.BIOME, new Identifier(BYG.MODID, id), biome);
        if (spawn)
            FabricBiomes.addSpawnBiome(biome);

            OverworldBiomes.addContinentalBiome(biome, climate, weight);

            if (((BiomeTools)biome).getEdge() != null)
                OverworldBiomes.addEdgeBiome(biome, ((BiomeTools) biome).getEdge(), weight);
            if (((BiomeTools)biome).getBeach() != null)
                OverworldBiomes.addShoreBiome(biome, ((BiomeTools) biome).getBeach(), weight);
            if (((BiomeTools)biome).getHill() != null)
                OverworldBiomes.addHillsBiome(biome, ((BiomeTools) biome).getHill(), weight);
            if (((BiomeTools)biome).getMutation() != null)
                OverworldBiomes.addBiomeVariant(biome, ((BiomeTools) biome).getMutation(), weight);
            if (((BiomeTools)biome).getRiver() != null)
                OverworldBiomes.addBiomeVariant(biome, ((BiomeTools) biome).getRiver(), weight);
    }

    private static void registerSubBiome(Biome biome, String id, boolean spawn) {
        Registry.register(Registry.BIOME, new Identifier(BYG.MODID, id), biome);
        if (spawn) {
            FabricBiomes.addSpawnBiome(biome);
        }
    }

    private static void registerNetherBiome(Biome biome, String id) {
        Registry.register(Registry.BIOME, new Identifier(BYG.MODID, id), biome);
        NetherBiomes.addNetherBiome(biome);
    }

    private static void registerEndBiome(Biome biome, String id) {
        Registry.register(Registry.BIOME, new Identifier(BYG.MODID, id), biome);
    }
}
