package voronoiaoc.byg.core.registries;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.event.registry.RegistryEntryRemovedCallback;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.newbiome.layer.BiomeInitLayer;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import voronoiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import voronoiaoc.byg.config.ConfigWeightManager;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BYGBiomeRegistry {
    public static List<Biome> biomeList = new ArrayList<>();

    public static List<Integer> HOT = new ArrayList<>();
    public static List<Integer> COOL = new ArrayList<>();
    public static List<Integer> WARM = new ArrayList<>();
    public static List<Integer> ICY = new ArrayList<>();

    //130
    public static void registerBiomes() {
        BYG.LOGGER.debug("BYG: Registering BuiltInBiomes...");
        registerBiome(BYGBiomeList.ALLIUMFIELDS, "allium_fields", true, ConfigWeightManager.ALLIUMFIELDS.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ALPS, "alps", true, ConfigWeightManager.ALPS.getWeight(), OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.AMARANTHFIELDS, "amaranth_fields", true, ConfigWeightManager.AMARANTHFIELDS.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ASPENFOREST, "aspen_forest", true, ConfigWeightManager.ASPENFOREST.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ANCIENTFOREST, "ancient_forest", true, ConfigWeightManager.ANCIENTFOREST.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.AUTUMNAL_VALLEY, "autumnal_valley", true, ConfigWeightManager.AUTUMNALVALLEY.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.BAOBABSAVANNA, "baobab_savanna", true, ConfigWeightManager.BAOBABSAVANNA.getWeight(), OverworldClimate.DRY);
        registerBiome(BYGBiomeList.BAYOU, "bayou", true, ConfigWeightManager.BAYOU.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.BLUETAIGA, "blue_taiga", true, ConfigWeightManager.BLUETAIGA.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.BLUFFSTEEPS, "bluff_steeps", true, ConfigWeightManager.BLUFFSTEEPS.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.BOREALFOREST, "boreal_forest", true, ConfigWeightManager.BOREALFOREST.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.CIKA_WOODS, "cika_woods", true, ConfigWeightManager.CIKA_WOODS.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.COLDSWAMPLANDS, "cold_swamplands", true, ConfigWeightManager.COLDSWAMPLANDS.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.CRAGGARDENS, "crag_gardens", true, ConfigWeightManager.CRAGGARDENS.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.CHERRYBLOSSOMFOREST, "cherry_blossom_forest", true, ConfigWeightManager.CHERRY_BLOSSOM_FOREST.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.CONIFEROUSFOREST, "coniferous_forest", true, ConfigWeightManager.CONIFEROUSFOREST.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.CYPRESSSWAMPLANDS, "cypress_swamplands", true, ConfigWeightManager.CYPRESS_SWAMPLAND.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.DOVERMOUNTAINS, "dover_mountains", true, ConfigWeightManager.DOVERMOUNTAINS.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.DEADSEA, "dead_sea", true, ConfigWeightManager.DEADSEA.getWeight(), OverworldClimate.DRY);
        registerBiome(BYGBiomeList.DECIDUOUSFOREST, "deciduous_forest", true, ConfigWeightManager.DECIDUOUSFOREST.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.DUNES, "dunes", true, ConfigWeightManager.DUNES.getWeight(), OverworldClimate.DRY);
        registerBiome(BYGBiomeList.EBONYWOODS, "ebony_woods", true, ConfigWeightManager.EBONY_WOODS.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ENCHANTEDFOREST, "enchanted_forest", true, ConfigWeightManager.ENCHANTED_FOREST.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ENCHANTED_GROVE, "enchanted_grove", true, ConfigWeightManager.ENCHANTED_GROVE.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.EVERGREENTAIGA, "evergreen_taiga", true, ConfigWeightManager.EVERGREEN_TAIGA.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.GLOWSHROOMBAYOU, "glowshroom_bayou", true, ConfigWeightManager.GLOWSHROOMBAYOU.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.GRASSLANDPLATEAU, "grassland_plateau", true, ConfigWeightManager.GRASSLANDPLATEAU.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.GREATLAKES, "great_lakes", true, ConfigWeightManager.GREATLAKES.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.GROVE, "grove", true, ConfigWeightManager.GROVE.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.GUIANASHIELD, "guiana_shield", true, ConfigWeightManager.GUIANASHIELD.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.JACARANDAFOREST, "jacaranda_forest", true, ConfigWeightManager.JACARANDAFOREST.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.MANGROVEMARSHES, "mangrove_marshes", true, ConfigWeightManager.MANGROVE_MARSHES.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.MAPLETAIGA, "maple_taiga", true, ConfigWeightManager.MAPLE_TAIGA.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.MEADOW, "meadow", true, ConfigWeightManager.MEADOW.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.MOJAVE_DESERT, "mojave_desert", true, ConfigWeightManager.MOJAVEDESERT.getWeight(), OverworldClimate.DRY);
        registerBiome(BYGBiomeList.LUSH_TUNDRA, "lush_tundra", true, ConfigWeightManager.LUSH_TUNDRA.getWeight(), OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.ORCHARD, "orchard", true, ConfigWeightManager.ORCHARD.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.PRAIRIE, "prairie", true, ConfigWeightManager.PRAIRIE.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.REDDESERT, "red_desert", true, ConfigWeightManager.REDDESERT.getWeight(), OverworldClimate.DRY);
        registerBiome(BYGBiomeList.REDOAKFOREST, "red_oak_forest", true, ConfigWeightManager.REDOAKFOREST.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.REDWOOD_TROPICS, "redwood_tropics", true, ConfigWeightManager.REDWOOD_TROPICS.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.RED_ROCK_MOUNTAINS, "red_rock_mountains", true, ConfigWeightManager.REDROCKMOUNTAINS.getWeight(), OverworldClimate.DRY);
        registerBiome(BYGBiomeList.SEASONALBIRCHFOREST, "seasonal_birch_forest", true, ConfigWeightManager.SEASONALBIRCHFOREST.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SEASONALDECIDUOUSFOREST, "seasonal_deciduous_forest", true, ConfigWeightManager.SEASONALDECIDUOUSFOREST.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SEASONALFOREST, "seasonal_forest", true, ConfigWeightManager.SEASONALFOREST.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SEASONALTAIGA, "seasonal_taiga", true, ConfigWeightManager.SEASONALTAIGA.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SHATTEREDGLACIER, "shattered_glacier", true, ConfigWeightManager.SHATTEREDGLACIER.getWeight(), OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.SHRUBLANDS, "shrublands", true, ConfigWeightManager.SHRUBLANDS.getWeight(), OverworldClimate.DRY);
        registerBiome(BYGBiomeList.SKYRISHIGHLANDS, "skyris_highlands", true, ConfigWeightManager.SKYRISHIGHLANDS.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.SNOWYBLUETAIGA, "snowy_blue_taiga", true, ConfigWeightManager.SNOWYBLUETAIGA.getWeight(), OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.SNOWYCONIFEROUSFOREST, "snowy_coniferous_forest", true, ConfigWeightManager.SNOWYCONIFEROUSFOREST.getWeight(), OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.SNOWYDECIDUOUSFOREST, "snowy_deciduous_forest", true, ConfigWeightManager.SNOWYDECIDUOUSFOREST.getWeight(), OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.SNOWYEVERGREENTAIGA, "snowy_evergreen_taiga", true, ConfigWeightManager.SNOWY_EVERGREEN_TAIGA.getWeight(), OverworldClimate.SNOWY);
        registerBiome(BYGBiomeList.THE_BLACK_FOREST, "the_black_forest", true, ConfigWeightManager.THE_BLACK_FOREST.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.TROPICALFUNGALRAINFOREST, "tropical_fungal_rainforest", true, ConfigWeightManager.TROPICALFUNGALFOREST.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.TROPICALRAINFOREST, "tropical_rainforest", true, ConfigWeightManager.TROPICALRAINFOREST.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.VIBRANTSWAMPLANDS, "vibrant_swamplands", true, ConfigWeightManager.VIBRANTSWAMPLANDS.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.SIERRAVALLEY, "sierra_valley", true, ConfigWeightManager.SIERRAVALLEY.getWeight(), OverworldClimate.DRY);
        registerBiome(BYGBiomeList.WEEPINGWITCHFOREST, "weeping_witch_forest", true, ConfigWeightManager.WEEPING_WITCH_FOREST.getWeight(), OverworldClimate.COOL);
        registerBiome(BYGBiomeList.WOODLANDS, "woodlands", true, ConfigWeightManager.WOODLANDS.getWeight(), OverworldClimate.TEMPERATE);
        registerBiome(BYGBiomeList.ZELKOVAFOREST, "zelkova_forest", true, ConfigWeightManager.ZELKOVAFOREST.getWeight(), OverworldClimate.COOL);

        //Islands
        registerIsland(BYGBiomeList.TROPICALISLAND, "tropical_island", true, BuiltinRegistries.BIOME.get(Biomes.DEEP_WARM_OCEAN), BuiltinRegistries.BIOME.get(Biomes.WARM_OCEAN));
        BYG.LOGGER.info("BYG: Registered Biomes!");

    }

    public enum OverworldClimate {
        SNOWY,
        COOL,
        TEMPERATE,
        DRY
    }

    public static void registerSubBiomes() {
        BYG.LOGGER.debug("BYG: Registering Sub BuiltInBiomes...");


        /***********************************SubBiomes***********************************/
        registerSubBiome(BYGBiomeList.REDWOOD_CLEARING, "redwood_clearing", true);
        registerSubBiome(BYGBiomeList.REDWOOD_MOUNTAINS, "redwood_mountains", true);
        registerSubBiome(BYGBiomeList.CORAL_MANGROVES, "coral_mangroves", true);
        registerSubBiome(BYGBiomeList.CIKA_MOUNTAINS, "cika_mountains", true);
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
        registerSubBiome(BYGBiomeList.BLACK_FOREST_CLEARING, "black_forest_clearing", true);
        registerSubBiome(BYGBiomeList.BOREALIS_CLEARING, "boreal_clearing", true);
        registerSubBiome(BYGBiomeList.CHERRY_BLOSSOM_CLEARING, "cherry_blossom_clearing", true);
        registerSubBiome(BYGBiomeList.CONIFEROUS_CLEARING, "coniferous_clearing", true);
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
        registerSubBiome(BYGBiomeList.ZELKOVA_CLEARING, "zelkova_clearing", true);

        //Hills - 23
        registerSubBiome(BYGBiomeList.ALPINEFOOTHILLS, "alpine_foothills", true);
        registerSubBiome(BYGBiomeList.ASPENFORESTHILLS, "aspen_forest_hills", true);
        registerSubBiome(BYGBiomeList.BLUETAIGAHILLS, "blue_taiga_hills", true);
        registerSubBiome(BYGBiomeList.BOREALFORESTHILLS, "boreal_forest_hills", true);
        registerSubBiome(BYGBiomeList.BLACK_FOREST_HILLS, "black_forest_hills", true);
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
        registerSubBiome(BYGBiomeList.SNOWYBLUEGIANTTAIGA, "snowy_blue_giant_taiga", true);

        //Bluff - 1
        registerSubBiome(BYGBiomeList.BLUFFPEAKS, "bluff_peaks", true);

        //Flowering - 3
        registerSubBiome(BYGBiomeList.FLOWERING_ENCHANTED_GROVE, "flowering_enchanted_grove", true);
        registerSubBiome(BYGBiomeList.FLOWERING_GROVE, "flowering_grove", true);
        registerSubBiome(BYGBiomeList.FLOWERINGMEADOW, "flowering_meadow", true);

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
        registerSubBiome(BYGBiomeList.FOREST_FAULT, "forest_fault", true);
        registerSubBiome(BYGBiomeList.FUNGAL_PATCH, "fungal_patch", true);
        registerSubBiome(BYGBiomeList.GREATLAKEISLES, "great_lake_isles", true);
        registerSubBiome(BYGBiomeList.LUSHREDDESERT, "lush_red_desert", true);
        registerSubBiome(BYGBiomeList.MARSHLANDS, "marshlands", true);
        registerSubBiome(BYGBiomeList.NORTHERN_FOREST, "northern_forest", true);
        registerSubBiome(BYGBiomeList.PUMPKIN_FOREST, "pumpkin_forest", true);
        registerSubBiome(BYGBiomeList.SIERRARANGE, "sierra_range", true);
        registerSubBiome(BYGBiomeList.REDDESERTDUNES, "red_desert_dunes", true);
        registerSubBiome(BYGBiomeList.SEASONALGIANTTAIGA, "seasonal_giant_taiga", true);
        BYG.LOGGER.info("BYG: Registered Sub Biomes!");
    }

    public static void registerNetherBiomes() {
        BYG.LOGGER.debug("BYG: Registering Nether BuiltInBiomes...");
        /**********NetherBiomes - 3**********/
        registerNetherBiome(BYGBiomeList.GLOWSTONEGARDENS, "glowstone_gardens");
        registerNetherBiome(BYGBiomeList.WARPEDDESERT, "warped_desert");
        registerNetherBiome(BYGBiomeList.SYTHIANTORRIDS, "sythian_torrids");
        registerNetherBiome(BYGBiomeList.EMBURBOG, "embur_bog");
        // newDecorator existing nether biomes
        BuiltinRegistries.BIOME.stream().filter(biome -> biome.getBiomeCategory().equals(Biome.BiomeCategory.NETHER)).forEach(biome -> BYGNetherBiomeProvider.biomeList.add(biome));
        // newDecorator future biomes
        RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((rawId, id, biome) -> {
            if (biome.getBiomeCategory().equals(Biome.BiomeCategory.NETHER)) {
                BYGNetherBiomeProvider.biomeList.add(biome);
            }
        });
        // this should never happen, but just in case...
        RegistryEntryRemovedCallback.event(BuiltinRegistries.BIOME).register((rawid, id, biome) -> {
            BYGNetherBiomeProvider.biomeList.removeIf(biome::equals);
        });
        BYG.LOGGER.info("BYG: Registered Nether Biomes!");
    }

    public static void registerEndBiomes() {
        //Avoid adding to the list with already spawning end biomes.
        List<Biome> endBiomeBlackList = new ArrayList<>();
        endBiomeBlackList.add(BuiltinRegistries.BIOME.get(Biomes.END_BARRENS));
        endBiomeBlackList.add(BuiltinRegistries.BIOME.get(Biomes.THE_END));
        endBiomeBlackList.add(BuiltinRegistries.BIOME.get(Biomes.SMALL_END_ISLANDS));

        BYG.LOGGER.debug("BYG: Registering End BuiltInBiomes...");
        /**********EndBiomes - 1**********/
        registerEndBiome(BYGBiomeList.IVISFIELDS, "ivis_fields");
        // Register existing End biomes
        BuiltinRegistries.BIOME.stream().filter(biome -> biome.getBiomeCategory().equals(Biome.BiomeCategory.THEEND)
                && !endBiomeBlackList.contains(biome)).forEach(BYGEndBiomeProvider.bygEndBiomeList::add);
        // newDecorator future biomes
        RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((rawId, id, biome) -> {
            if (biome.getBiomeCategory().equals(Biome.BiomeCategory.THEEND)&& !endBiomeBlackList.contains(biome)) {
                BYGEndBiomeProvider.bygEndBiomeList.add(biome);
            }
        });
        //This should never happen, but just in case...
        RegistryEntryRemovedCallback.event(BuiltinRegistries.BIOME).register((rawid, id, biome) -> {
            BYGEndBiomeProvider.bygEndBiomeList.removeIf(biome::equals);
        });
        BYG.LOGGER.info("BYG: Registered End Biomes!");
    }

    public static void addEndBiomeKeysToBiomeLayerSampler() {
        //Avoid adding to the list with already spawning end biomes.
        List<Biome> endBiomeBlackList = new ArrayList<>();
        endBiomeBlackList.add(BuiltinRegistries.BIOME.get(Biomes.END_BARRENS));
        endBiomeBlackList.add(BuiltinRegistries.BIOME.get(Biomes.THE_END));
        endBiomeBlackList.add(BuiltinRegistries.BIOME.get(Biomes.SMALL_END_ISLANDS));

        for (Biome biome : BuiltinRegistries.BIOME) {
            if (biome.getBiomeCategory().equals(Biome.BiomeCategory.THEEND) && !endBiomeBlackList.contains(biome)) {
                Optional<ResourceKey<Biome>> key = BuiltinRegistries.BIOME.getResourceKey(biome);
                if (key.isPresent())
                    key.ifPresent(biomeRegistryKey ->
                            net.minecraft.data.worldgen.biome.Biomes.TO_NAME.put(BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(key.get())), biomeRegistryKey));
            }
        }
        RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((rawId, id, biome) -> {
            if (biome.getBiomeCategory().equals(Biome.BiomeCategory.THEEND) && biome != BuiltinRegistries.BIOME.get(Biomes.END_HIGHLANDS)) {
                Optional<ResourceKey<Biome>> key = BuiltinRegistries.BIOME.getResourceKey(biome);
                if (key.isPresent())
                    key.ifPresent(biomeRegistryKey -> net.minecraft.data.worldgen.biome.Biomes.TO_NAME.put(BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(key.get())), biomeRegistryKey));
            }
        });
    }

    public static void addNetherBiomeKeysToBiomeLayerSampler() {
        for (Biome biome : BuiltinRegistries.BIOME) {
            if (biome.getBiomeCategory().equals(Biome.BiomeCategory.NETHER)) {
                Optional<ResourceKey<Biome>> key = BuiltinRegistries.BIOME.getResourceKey(biome);
                if (key.isPresent())
                    key.ifPresent(biomeRegistryKey ->
                            net.minecraft.data.worldgen.biome.Biomes.TO_NAME.put(BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(key.get())), biomeRegistryKey));
            }
        }
        RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((rawId, id, biome) -> {
            if (biome.getBiomeCategory().equals(Biome.BiomeCategory.NETHER) ) {
                Optional<ResourceKey<Biome>> key = BuiltinRegistries.BIOME.getResourceKey(biome);
                if (key.isPresent())
                    key.ifPresent(biomeRegistryKey -> net.minecraft.data.worldgen.biome.Biomes.TO_NAME.put(BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(key.get())), biomeRegistryKey));
            }
        });
    }


    private static void registerBiome(Biome biome, String id, boolean spawn, float weight, OverworldClimate type) {
        Registry.register(BuiltinRegistries.BIOME, new ResourceLocation(BYG.MODID, id), biome);
        biomeList.add(biome);
        if (weight > 0) {
            if (type == OverworldClimate.TEMPERATE)
                WARM.add(BuiltinRegistries.BIOME.getId(biome));
            if (type == OverworldClimate.COOL)
                COOL.add(BuiltinRegistries.BIOME.getId(biome));
            if (type == OverworldClimate.DRY)
                HOT.add(BuiltinRegistries.BIOME.getId(biome));
            if (type == OverworldClimate.SNOWY)
                ICY.add(BuiltinRegistries.BIOME.getId(biome));
        }
    }

//        if (spawn)
//            //FabricBuiltInBiomes.addSpawnBiome(biome);
//        if (weight > 0)
//            //OverworldBuiltInBiomes.addContinentalBiome(biome, climate, weight / 10.0F);
//
//        if (((BiomeTools) biome).getEdge() != null) {
//            if (BuiltinRegistries.BIOME.getId(((BiomeTools) biome).getEdge()) == null) {
////                throw new NullPointerException();
//            }
//            else {
//                //OverworldBuiltInBiomes.addEdgeBiome(biome, ((BiomeTools) biome).getEdge(), 1);
//            }
//        }
//
//
//        if (((BiomeTools) biome).getBeach() != null) {
//            if (BuiltinRegistries.BIOME.getId(((BiomeTools) biome).getBeach()) == null) {
////                throw new NullPointerException();
//            }
//            else {
//                //OverworldBuiltInBiomes.addShoreBiome(biome, ((BiomeTools) biome).getBeach(), 1);
//            }
//        }
//
//
//        if (((BiomeTools) biome).getHill() != null) {
//            if (BuiltinRegistries.BIOME.getId(((BiomeTools) biome).getHill()) == null) {
////                throw new NullPointerException();
//            }
//            else {
//                //OverworldBuiltInBiomes.addHillsBiome(biome, ((BiomeTools) biome).getHill(), 1);
//            }
//        }
//
//
//        if (((BiomeTools) biome).getMutation() != null) {
//            if (BuiltinRegistries.BIOME.getId(((BiomeTools) biome).getMutation()) == null) {
////                throw new NullPointerException();
//            }
//            else {
//                //OverworldBuiltInBiomes.addBiomeVariant(biome, ((BiomeTools) biome).getMutation(), 1);
//            }
//        }
//
//
//        if (((BiomeTools) biome).getRiver() != null) {
//            if (BuiltinRegistries.BIOME.getId(((BiomeTools) biome).getRiver()) == null) {
////                throw new NullPointerException();
//            }
//            else {
//                //OverworldBuiltInBiomes.setRiverBiome(biome, ((BiomeTools) biome).getRiver());
//            }
//        }
//
//        biomeList.add(biome);
//
//    }


    private static void registerNetherBiome(Biome biome, String id) {
        Registry.register(BuiltinRegistries.BIOME, new ResourceLocation(BYG.MODID, id), biome);
//        NetherBuiltInBiomes.addNetherBiome(biome);
        biomeList.add(biome);
    }

    private static void registerEndBiome(Biome biome, String id) {
        if (biome != null) {
            Registry.register(BuiltinRegistries.BIOME, new ResourceLocation(BYG.MODID, id), biome);
//            biomeList.add(biome);
        }
    }

    public static void addBeachesCategorically() {
//        for (Biome biome : class_5458.field_25933) {
//            if (!(biome instanceof BiomeTools)) {
//                if (Objects.requireNonNull(BuiltinRegistries.BIOME.getId(biome)).toString().contains("byg")) {
//                    if (biome.getPrecipitation() == Biome.Precipitation.SNOW && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH)
//                        //OverworldBuiltInBiomes.addShoreBiome(biome, BYGBiomeList.SNOWYBLACKBEACH, 1);
//                }
//            }
//            if (Objects.requireNonNull(BuiltinRegistries.BIOME.getId(biome)).toString().contains("byg")) {
//                if (biome.getCategory() == Biome.Category.JUNGLE)
//                    //OverworldBuiltInBiomes.addShoreBiome(biome, BYGBiomeList.RAINBOWBEACH, 1);
//            }
//        }
    }

    private static void registerSubBiome(Biome biome, String id, boolean spawn) {
        Registry.register(BuiltinRegistries.BIOME, new ResourceLocation(BYG.MODID, id), biome);
        biomeList.add(biome);
//        if (spawn) {
//            if (BuiltinRegistries.BIOME.getId(biome) == null) {
//            }
//            else {
//                //FabricBuiltInBiomes.addSpawnBiome(biome);
//            }
//        }
    }

    //
    private static void registerIsland(Biome island, String id, boolean spawn, Biome... oceanClimates) {
        if (island != null) {
            Registry.register(BuiltinRegistries.BIOME, new ResourceLocation(BYG.MODID, id), island);
            biomeList.add(island);
            if (spawn)
                //FabricBuiltInBiomes.addSpawnBiome(island);
                for (Biome oceanBiomeIdx : oceanClimates) {
                    //OverworldBuiltInBiomes.addBiomeVariant(oceanBiomeIdx, island, 0.1F);
                }
        }
    }

    //Why? This is how worldtype's using the BiomeLayerSampler get the numerical ID's to sample.
    public static void addBiomeNumericalIDs() {
        BYG.LOGGER.debug("Adding Numerical Biome IDs...");
        for (Biome biome : biomeList) {
            Optional<ResourceKey<Biome>> key = BuiltinRegistries.BIOME.getResourceKey(biome);
            if (key.isPresent())
                key.ifPresent(biomeRegistryKey -> net.minecraft.data.worldgen.biome.Biomes.TO_NAME.put(BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(key.get())), biomeRegistryKey));
        }
        BYG.LOGGER.info("Added Numerical Biome IDs!");

    }

    //We add our biomes to the public static int arrays for each category and this lets us spawn our biomes in vanilla worldtypes.
    public static void addBYGBiomesToVanillaOverworld() {
        for (int integer : BYGBiomeRegistry.HOT)
            BiomeInitLayer.WARM_BIOMES = addElement(BiomeInitLayer.WARM_BIOMES, integer);
        for (int integer : BYGBiomeRegistry.WARM)
            BiomeInitLayer.MEDIUM_BIOMES = addElement(BiomeInitLayer.MEDIUM_BIOMES, integer);
        for (int integer : BYGBiomeRegistry.COOL)
            BiomeInitLayer.COLD_BIOMES = addElement(BiomeInitLayer.COLD_BIOMES, integer);
        for (int integer : BYGBiomeRegistry.ICY)
            BiomeInitLayer.ICE_BIOMES = addElement(BiomeInitLayer.ICE_BIOMES, integer);
    }


    static int[] addElement(int[] a, int e) {
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }
}