package voronoiaoc.byg.core.registries;

import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.fabricmc.fabric.api.biomes.v1.NetherBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.event.registry.RegistryEntryRemovedCallback;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import voronoiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BYGBiomeRegistry {
    public static List<Biome> biomeList = new ArrayList<>();

    //130
    public static void registerBiomes() {
        BYG.LOGGER.debug("BYG: Registering Biomes...");
        registerBiome(BYGBiomeList.ALLIUMFIELDS, "allium_fields", true, 2, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ALPS, "alps", true, 5, OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.AMARANTHFIELDS, "amaranth_fields", true, 2, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ASPENFOREST, "aspen_forest", true, 6, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ANCIENTFOREST, "ancient_forest", true, 1, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.AUTUMNAL_VALLEY, "autumnal_valley", true, 5, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.BAOBABSAVANNA, "baobab_savanna", true, 6, OverworldClimate.DRY);
        registerBiome(BYGBiomeList.BAYOU, "bayou", true, 5, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.BLUETAIGA, "blue_taiga", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.BLUFFSTEEPS, "bluff_steeps", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.BOREALFOREST, "boreal_forest", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.CIKA_WOODS, "cika_woods", true, 4, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.COLDSWAMPLANDS, "cold_swamplands", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.CRAGGARDENS, "crag_gardens", true, 1, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.CHERRYBLOSSOMFOREST, "cherry_blossom_forest", true, 6, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.CONIFEROUSFOREST, "coniferous_forest", true, 5, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.CYPRESSSWAMPLANDS, "cypress_swamplands", true, 6, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.DOVERMOUNTAINS, "dover_mountains", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.DEADSEA, "dead_sea", true, 2, OverworldClimate.DRY);
        registerBiome(BYGBiomeList.DECIDUOUSFOREST, "deciduous_forest", true, 6, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.DUNES, "dunes", true, 6, OverworldClimate.DRY);
        registerBiome(BYGBiomeList.EBONYWOODS, "ebony_woods", true, 5, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ENCHANTEDFOREST, "enchanted_forest", true, 5, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ENCHANTED_GROVE, "enchanted_grove", true, 1, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.EVERGREENTAIGA, "evergreen_taiga", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.GLOWSHROOMBAYOU, "glowshroom_bayou", true, 1, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.GRASSLANDPLATEAU, "grassland_plateau", true, 5, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.GREATLAKES, "great_lakes", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.GROVE, "grove", true, 5, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.GUIANASHIELD, "guiana_shield", true, 5, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.JACARANDAFOREST, "jacaranda_forest", true, 6, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.MANGROVEMARSHES, "mangrove_marshes", true, 5, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.MAPLETAIGA, "maple_taiga", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.MEADOW, "meadow", true, 6, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.MOJAVE_DESERT, "mojave_desert", true, 6, OverworldClimate.DRY);
        registerBiome(BYGBiomeList.LUSH_TUNDRA, "lush_tundra", true, 6, OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.ORCHARD, "orchard", true, 5, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.PRAIRIE, "prairie", true, 6, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.REDDESERT, "red_desert", true, 6, OverworldClimate.DRY);
        registerBiome(BYGBiomeList.REDOAKFOREST, "red_oak_forest", true, 6, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.REDWOOD_TROPICS, "redwood_tropics", true, 4, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.RED_ROCK_MOUNTAINS, "red_rock_mountains", true, 5, OverworldClimate.DRY);
        registerBiome(BYGBiomeList.SEASONALBIRCHFOREST, "seasonal_birch_forest", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SEASONALDECIDUOUSFOREST, "seasonal_deciduous_forest", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SEASONALFOREST, "seasonal_forest", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SEASONALTAIGA, "seasonal_taiga", true, 6, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SHATTEREDGLACIER, "shattered_glacier", true, 4, OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.SHRUBLANDS, "shrublands", true, 5, OverworldClimate.DRY);
        registerBiome(BYGBiomeList.SKYRISHIGHLANDS, "skyris_highlands", true, 2, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SNOWYBLUETAIGA, "snowy_blue_taiga", true, 6, OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.SNOWYCONIFEROUSFOREST, "snowy_coniferous_forest", true, 6, OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.SNOWYDECIDUOUSFOREST, "snowy_deciduous_forest", true, 6, OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.SNOWYEVERGREENTAIGA, "snowy_evergreen_taiga", true, 6, OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.THE_BLACK_FOREST, "the_black_forest", true, 5, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.TROPICALFUNGALRAINFOREST, "tropical_fungal_forest", true, 5, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.TROPICALRAINFOREST, "tropical_rainforest", true, 1, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.VIBRANTSWAMPLANDS, "vibrant_swamplands", true, 6, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.SIERRAVALLEY, "sierra_valley", true, 6, OverworldClimate.DRY);
        registerBiome(BYGBiomeList.WEEPINGWITCHFOREST, "weeping_witch_forest", true, 1, OverworldClimate.COOL);
        registerBiome(BYGBiomeList.WOODLANDS, "woodlands", true, 4, OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ZELKOVAFOREST, "zelkova_forest", true, 6, OverworldClimate.COOL);

        //Islands
        registerIsland(BYGBiomeList.TROPICALISLAND, "tropical_island", true, Biomes.DEEP_WARM_OCEAN, Biomes.WARM_OCEAN);

        BYG.LOGGER.info("BYG: Registered Biomes!");

    }

    public static void registerSubBiomes() {
        BYG.LOGGER.debug("BYG: Registering Sub Biomes...");


        /***********************************SubBiomes***********************************/
        registerSubBiome(BYGBiomeList.REDWOOD_CLEARING, "redwood_clearing", true);
        registerSubBiome(BYGBiomeList.REDWOOD_MOUNTAINS, "redwood_mountains", true);
        registerSubBiome(BYGBiomeList.CORAL_MANGROVES, "coral_mangroves", true);
        registerSubBiome(BYGBiomeList.CIKA_MOUNTAINS, "cika_mountains",  true);
        registerSubBiome(BYGBiomeList.GLOWING_ANCIENT_FOREST, "glowing_ancient_forest", true);
        registerSubBiome(BYGBiomeList.FLOWERING_ANCIENT_FOREST, "flowering_ancient_forest", true);


        //Beaches - 5
        registerSubBiome(BYGBiomeList.RAINBOWBEACH, "rainbow_beach", true);
        registerSubBiome(BYGBiomeList.ROCKYBEACH, "rocky_beach", true);
        registerSubBiome(BYGBiomeList.SNOWYBLACKBEACH, "snowy_black_beach", true);
        registerSubBiome(BYGBiomeList.SNOWYROCKYBLACKBEACH, "snowy_rocky_black_beach", true);
        registerSubBiome(BYGBiomeList.WHITEBEACH, "white_beach", true);

        //Clearings - 15
        registerSubBiome(BYGBiomeList.ASPEN_CLEARING, "aspen_clearing", true);
        registerSubBiome(BYGBiomeList.BLACK_FOREST_CLEARING, "black_forest_clearing",  true);
        registerSubBiome(BYGBiomeList.BOREALIS_CLEARING, "boreal_clearing", true);
        registerSubBiome(BYGBiomeList.CHERRY_BLOSSOM_CLEARING, "cherry_blossom_clearing", true);
        registerSubBiome(BYGBiomeList.CONIFEROUS_CLEARING, "coniferous_clearing",  true);
        registerSubBiome(BYGBiomeList.DECIDUOUS_CLEARING, "deciduous_clearing", true);
        registerSubBiome(BYGBiomeList.EVERGREEN_CLEARING, "evergreen_clearing", true);
        registerSubBiome(BYGBiomeList.GUIANA_CLEARING, "guiana_clearing", true);
        registerSubBiome(BYGBiomeList.JACARANDA_CLEARING, "jacaranda_clearing", true);
        registerSubBiome(BYGBiomeList.PRAIRIECLEARING, "prairie_clearing", true);
        registerSubBiome(BYGBiomeList.SNOWY_CONIFEROUS_CLEARING, "snowy_coniferous_clearing", true);
        registerSubBiome(BYGBiomeList.SEASONAL_DECIDUOUS_CLEARING, "seasonal_deciduous_clearing", true);
        registerSubBiome(BYGBiomeList.SNOWY_DECIDUOUS_CLEARING, "snowy_deciduous_clearing", true);
        registerSubBiome(BYGBiomeList.SNOWY_EVERGREEN_CLEARING, "snowy_evergreen_clearing", true);
        registerSubBiome(BYGBiomeList.WEEPING_WTICH_CLEARING, "weeping_witch_clearing", true);
        registerSubBiome(BYGBiomeList.ZELKOVA_CLEARING, "zelkova_clearing",  true);

        //Hills - 23
        registerSubBiome(BYGBiomeList.ALPINEFOOTHILLS, "alpine_foothills",true);
        registerSubBiome(BYGBiomeList.ASPENFORESTHILLS, "aspen_forest_hills", true);
        registerSubBiome(BYGBiomeList.BLUETAIGAHILLS, "blue_taiga_hills", true);
        registerSubBiome(BYGBiomeList.BOREALFORESTHILLS, "boreal_forest_hills", true);
        registerSubBiome(BYGBiomeList.BLACK_FOREST_HILLS, "black_forest_hills",  true);
        registerSubBiome(BYGBiomeList.CONIFEROUSFORESTHILLS, "coniferous_forest_hills", true);
        registerSubBiome(BYGBiomeList.DECIDUOUSFORESTHILLS, "deciduous_forest_hills", true);
        registerSubBiome(BYGBiomeList.EBONY_HILLS, "ebony_hills", true);
        registerSubBiome(BYGBiomeList.ENCHANTED_FOREST_HILLS, "enchanted_forest_hills", true);
        registerSubBiome(BYGBiomeList.EVERGREEN_HILLS, "evergreen_hills", true);
        registerSubBiome(BYGBiomeList.JACARANDAFORESTHILLS, "jacaranda_forest_hills", true);
        registerSubBiome(BYGBiomeList.MAPLE_HILLS, "maple_hills", true);
        registerSubBiome(BYGBiomeList.SEASONALBIRCHFORESTHILLS, "seasonal_birch_forest_hills", true);
        registerSubBiome(BYGBiomeList.SEASONALDECIDUOUSFORESTHILLS, "seasonal_deciduous_forest_hills", true);
        registerSubBiome(BYGBiomeList.SEASONALFORESTHILLS, "seasonal_forest_hills", true);
        registerSubBiome(BYGBiomeList.SEASONALTAIGAHILLS, "seasonal_taiga_hills", true);
        registerSubBiome(BYGBiomeList.SNOWYBLUETAIGAHILLS, "snowy_blue_taiga_hills", true);
        registerSubBiome(BYGBiomeList.SNOWYCONIFERFORESTHILLS, "snowy_coniferous_forest_hills", true);
        registerSubBiome(BYGBiomeList.SNOWYDECIDUOUSFORESTHILLS, "snowy_deciduous_forest_hills", true);
        registerSubBiome(BYGBiomeList.SNOWY_EVERGREEN_HILLS, "snowy_evergreen_hills", true);
        registerSubBiome(BYGBiomeList.REDOAKFORESTHILLS, "red_oak_forest_hills", true);
        registerSubBiome(BYGBiomeList.TROPICALFUNGALRAINFORESTHILLS, "tropical_fungal_rainforest_hills", true);
        registerSubBiome(BYGBiomeList.TROPICALRAINFORESTHILLS, "tropical_rainforest_hills", true);
        registerSubBiome(BYGBiomeList.ZELKOVAFORESTHILLS, "zelkova_forest_hills", true);

        //Lakes - 4
        registerSubBiome(BYGBiomeList.FRESHWATERLAKE, "fresh_water_lake", true);
        registerSubBiome(BYGBiomeList.FROZENLAKE, "frozen_lake", true);
        registerSubBiome(BYGBiomeList.OASIS, "oasis", true);
        registerSubBiome(BYGBiomeList.POLLUTEDLAKE, "polluted_lake", true);


        /*************Misc SubBiomes***************/
        //Blue - 2
        registerSubBiome(BYGBiomeList.BLUEGIANTTAIGA, "blue_giant_taiga", true);
        registerSubBiome(BYGBiomeList.SNOWYBLUEGIANTTAIGA, "snowy_blue_giant_taiga",true);

        //Bluff - 1
        registerSubBiome(BYGBiomeList.BLUFFPEAKS, "bluff_peaks", true);

        //Flowering - 3
        registerSubBiome(BYGBiomeList.FLOWERING_ENCHANTED_GROVE, "flowering_enchanted_grove",  true);
        registerSubBiome(BYGBiomeList.FLOWERING_GROVE, "flowering_grove",  true);
        registerSubBiome(BYGBiomeList.FLOWERINGMEADOW, "flowering_meadow",  true);

        //RedRock - 3
        registerSubBiome(BYGBiomeList.RED_ROCK_LOWLANDS, "red_rock_lowlands", true);
        registerSubBiome(BYGBiomeList.RED_ROCK_HIGHLANDS, "red_rock_highlands", true);
        registerSubBiome(BYGBiomeList.WOODEDREDROCKMOUNTAINS, "wooded_red_rock_mountains", true);

        //Wooded - 2
        registerSubBiome(BYGBiomeList.WOODEDGRASSLANDPLATEAU, "wooded_grassland_plateau", true);
        registerSubBiome(BYGBiomeList.WOODEDMEADOW, "wooded_meadow", true);

        //Misc - 11
        registerSubBiome(BYGBiomeList.BAMBOO_FOREST, "bamboo_forest", true);
        registerSubBiome(BYGBiomeList.BOG, "bog", true);
        registerSubBiome(BYGBiomeList.FOREST_FAULT, "forest_fault",  true);
        registerSubBiome(BYGBiomeList.FUNGAL_PATCH, "fungal_patch",  true);
        registerSubBiome(BYGBiomeList.GREATLAKEISLES, "great_lake_isles", true);
        registerSubBiome(BYGBiomeList.LUSHREDDESERT, "lush_red_desert", true);
        registerSubBiome(BYGBiomeList.MARSHLANDS, "marshlands", true);
        registerSubBiome(BYGBiomeList.NORTHERN_FOREST, "northern_forest",  true);
        registerSubBiome(BYGBiomeList.PUMPKIN_FOREST, "pumpkin_forest", true);
        registerSubBiome(BYGBiomeList.SIERRARANGE, "sierra_range", true);
        registerSubBiome(BYGBiomeList.REDDESERTDUNES, "red_desert_dunes", true);
        registerSubBiome(BYGBiomeList.SEASONALGIANTTAIGA, "seasonal_giant_taiga", true);


        BYG.LOGGER.info("BYG: Registered Sub Biomes!");
    }

    public static void registerNetherBiomes() {
        BYG.LOGGER.debug("BYG: Registering Nether Biomes...");
        /**********NetherBiomes - 3**********/
        registerNetherBiome(BYGBiomeList.GLOWSTONEGARDENS, "glowstone_gardens");
        registerNetherBiome(BYGBiomeList.WARPEDDESERT, "warped_desert");
        registerNetherBiome(BYGBiomeList.SYTHIANTORRIDS, "sythian_torrids");
        registerNetherBiome(BYGBiomeList.EMBURBOG, "embur_bog");
        // register existing nether biomes
        Registry.BIOME.stream().filter(biome->biome.getCategory().equals(Biome.Category.NETHER)).forEach(biome->BYGNetherBiomeProvider.biomeList.add(biome));
        // register future biomes
        RegistryEntryAddedCallback.event(Registry.BIOME).register((rawId,id,biome)->{
            if (biome.getCategory().equals(Biome.Category.NETHER)) {
                BYGNetherBiomeProvider.biomeList.add(biome);
            }
        });
        // this should never happen, but just in case...
        RegistryEntryRemovedCallback.event(Registry.BIOME).register((rawid,id,biome)->{
            BYGNetherBiomeProvider.biomeList.removeIf(biome::equals);
        });
        BYG.LOGGER.info("BYG: Registered Nether Biomes!");
    }

    public static void registerEndBiomes() {
        BYG.LOGGER.debug("BYG: Registering End Biomes...");
        /**********EndBiomes - 1**********/
        registerEndBiome(BYGBiomeList.IVISFIELDS, "ivis_fields");
        // Register existing End biomes
        Registry.BIOME.stream().filter(biome->biome.getCategory().equals(Biome.Category.THEEND)).forEach(biome-> BYGEndBiomeProvider.bygEndBiomeList.add(biome));
        // register future biomes
        RegistryEntryAddedCallback.event(Registry.BIOME).register((rawId,id,biome)->{
            if (biome.getCategory().equals(Biome.Category.THEEND)) {
                BYGEndBiomeProvider.bygEndBiomeList.add(biome);
            }
        });
        //This should never happen, but just in case...
        RegistryEntryRemovedCallback.event(Registry.BIOME).register((rawid, id, biome)->{
            BYGEndBiomeProvider.bygEndBiomeList.removeIf(biome::equals);
        });
        BYG.LOGGER.info("BYG: Registered End Biomes!");
    }

    static int idx = 0;


    private static void registerBiome(Biome biome, String id, boolean spawn, float weight, OverworldClimate climate) {
        Registry.register(Registry.BIOME, new Identifier(BYG.MODID, id), biome);

        if (spawn)
            FabricBiomes.addSpawnBiome(biome);
        if (weight > 0)
            OverworldBiomes.addContinentalBiome(biome, climate, weight / 10.0F);

        if (biome instanceof BiomeTools) {
            ((BiomeTools)biome).getBeaches().forEach((subbiome,subWeight)->
            {
                OverworldBiomes.addShoreBiome(biome,subbiome,subWeight);
            });

            ((BiomeTools)biome).getEdges().forEach((subbiome,subWeight)->
            {
                OverworldBiomes.addEdgeBiome(biome,subbiome,subWeight);
            });

            ((BiomeTools)biome).getHills().forEach((subbiome,subWeight)->
            {
                OverworldBiomes.addHillsBiome(biome,subbiome,subWeight);
            });

            ((BiomeTools)biome).getMutations().forEach((subbiome,subWeight)->
            {
                OverworldBiomes.addBiomeVariant(biome,subbiome,subWeight);
            });
            Biome RiverBiome =  ((BiomeTools)biome).getRiver();
            if (RiverBiome == null) {
                RiverBiome = Biomes.RIVER;
            }
            OverworldBiomes.setRiverBiome(biome,RiverBiome);

        }

        biomeList.add(biome);

    }


    private static void registerNetherBiome(Biome biome, String id) {
        Registry.register(Registry.BIOME, new Identifier(BYG.MODID, id), biome);
        NetherBiomes.addNetherBiome(biome);
    }

    private static void registerEndBiome(Biome biome, String id) {
        Registry.register(Registry.BIOME, new Identifier(BYG.MODID, id), biome);
    }

    public static void addBeachesCategorically() {
        for (Biome biome : Registry.BIOME) {
            if (!(biome instanceof BiomeTools)) {
                if (Objects.requireNonNull(Registry.BIOME.getId(biome)).toString().contains("byg")) {
                    if (biome.getPrecipitation() == Biome.Precipitation.SNOW && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH)
                        OverworldBiomes.addShoreBiome(biome, BYGBiomeList.SNOWYBLACKBEACH, 1);
                }
            }
            if (Objects.requireNonNull(Registry.BIOME.getId(biome)).toString().contains("byg")) {
                if (biome.getCategory() == Biome.Category.JUNGLE)
                    OverworldBiomes.addShoreBiome(biome, BYGBiomeList.RAINBOWBEACH, 1);
            }
        }
    }

    private static void registerSubBiome(Biome biome, String id, boolean spawn) {
        Registry.register(Registry.BIOME, new Identifier(BYG.MODID, id), biome);
        if (spawn) {
            if (Registry.BIOME.getId(biome) == null) {
            }
            else {
                FabricBiomes.addSpawnBiome(biome);
            }
        }
        idx++;
    }

    private static void registerIsland(Biome island, String id, boolean spawn, Biome... oceanClimates) {
        Registry.register(Registry.BIOME, new Identifier(BYG.MODID, id), island);
        if (spawn)
            FabricBiomes.addSpawnBiome(island);
        for (Biome oceanBiomeIdx : oceanClimates) {
            OverworldBiomes.addBiomeVariant(oceanBiomeIdx, island, 0.1F);
        }
    }


}
