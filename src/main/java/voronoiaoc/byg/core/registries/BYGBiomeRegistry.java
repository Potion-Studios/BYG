package voronoiaoc.byg.core.registries;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGBiomeRegistry {


    @SubscribeEvent
    public static void registerBYGBiomes(RegistryEvent.Register<Biome> event) {
        BYG.LOGGER.debug("BYG: Registering Biomes...");
        IForgeRegistry<Biome> registry = event.getRegistry();
//        registerBiome(registry, BYGBiomeList.DUMMYBIOME, "dummy", true, BiomeDictionary.Type.PLAINS);

        registerBiome(registry, BYGBiomeList.ALLIUMFIELDS, "allium_fields", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.RARE, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.ALPS, "alps", true, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.AMARANTHFIELDS, "amaranth_fields", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.RARE, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        //registerBiome(registry, BYGBiomeList.ANCIENTFOREST, "ancientforest", ConfigWeightManager.ancientForest.getWeight(), true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE);
        registerBiome(registry, BYGBiomeList.ASPENFOREST, "aspen_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.AUTUMNAL_VALLEY, "autumnal_valley", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.BAOBABSAVANNA, "baobab_savanna", true, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.BAYOU, "bayou", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);
        registerBiome(registry, BYGBiomeList.BLUETAIGA, "blue_taiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.BLUFFSTEEPS, "bluff_steeps", true, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.BOREALFOREST, "boreal_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.COLDSWAMPLANDS, "cold_swamplands", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.CRAGGARDENS, "crag_gardens", true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.WET, BiomeDictionary.Type.PLATEAU, BiomeDictionary.Type.RARE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
//        registerBiome(registry, BYGBiomeList.REDROCKCANYON, "red_rock_canyon", false,  BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.PLATEAU);
        registerBiome(registry, BYGBiomeList.CHERRYBLOSSOMFOREST, "cherry_blossom_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
//        registerBiome(registry, BYGBiomeList.COASTALREDWOODTROPICS, "coastalredwoodtropics", ConfigWeightManager.coastalredwoodtropics.getWeight(), true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.CONIFEROUSFOREST, "coniferous_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.CYPRESSSWAMPLANDS, "cypress_swamplands", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.DOVERMOUNTAINS, "dover_mountains", true, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.DEADSEA, "dead_sea", true, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.DECIDUOUSFOREST, "deciduous_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.DUNES, "dunes", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.EBONYWOODS, "ebony_woods", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE);
        registerBiome(registry, BYGBiomeList.ENCHANTEDFOREST, "enchanted_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.RARE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.EVERGREENTAIGA, "evergreen_taiga", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.GLOWSHROOMBAYOU, "glowshroom_bayou", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.GRASSLANDPLATEAU, "grassland_plateau", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.GREATLAKES, "great_lakes", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WATER, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.GROVE, "grove", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.ENCHANTED_GROVE, "enchanted_grove", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.GUIANASHIELD, "guiana_shield", true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.JACARANDAFOREST, "jacaranda_forest", true, BiomeDictionary.Type.FOREST);
        registerBiome(registry, BYGBiomeList.MANGROVEMARSHES, "mangrove_marshes", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.MAPLETAIGA, "maple_taiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.MEADOW, "meadow", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.MOJAVE_DESERT, "mojave_desert", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.LUSH_TUNDRA, "lush_tundra", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.ORCHARD, "orchard", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.PRAIRIE, "prairie", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.REDDESERT, "red_desert", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.REDDESERTDUNES, "red_desert_dunes", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.REDOAKFOREST, "red_oak_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.RED_ROCK_MOUNTAINS, "red_rock_mountains", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SEASONALBIRCHFOREST, "seasonal_birch_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SEASONALDECIDUOUSFOREST, "seasonal_deciduous_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SEASONALFOREST, "seasonal_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD);
        registerBiome(registry, BYGBiomeList.SEASONALTAIGA, "seasonal_taiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SHATTEREDGLACIER, "shattered_glacier", true, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SHRUBLANDS, "shrublands", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SKYRISHIGHLANDS, "skyris_highlands", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SNOWYBLUETAIGA, "snowy_blue_taiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SNOWYCONIFEROUSFOREST, "snowy_coniferous_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SNOWYDECIDUOUSFOREST, "snowy_deciduous_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);
//        registerBiome(registry, BYGBiomeList.SAVANNACANOPY, "savanna_canopy",  true, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);

        registerBiome(registry, BYGBiomeList.SNOWYEVERGREENTAIGA, "snowy_evergreen_taiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        //registerBiome(registry, BYGBiomeList.SONORANDESERT, "sonorandesert", ConfigWeightManager.sonorandesert.getWeight(), true, BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY);
        //registerBiome(registry, BYGBiomeList.STONEBRUSHLANDS, "stonebrushlands", ConfigWeightManager.stonebrushlands.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.COLD);
//        registerBiome(registry, BYGBiomeList.STONEFOREST, "stoneforest", ConfigWeightManager.stoneforest.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.COLD);
        registerBiome(registry, BYGBiomeList.THE_BLACK_FOREST, "the_black_forest", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.TROPICALFUNGALRAINFOREST, "tropical_fungal_forest", true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.TROPICALRAINFOREST, "tropical_rainforest", true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.VIBRANTSWAMPLANDS, "vibrant_swamplands", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WET, BiomeDictionary.Type.WATER, BiomeDictionary.Type.OVERWORLD);
//        registerBiome(registry, BYGBiomeList.VOLCANO, "volcano",  false, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SIERRAVALLEY, "sierra_valley", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.WEEPINGWITCHFOREST, "weeping_witch_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.WOODLANDS, "woodlands", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.MAGICAL);
        registerBiome(registry, BYGBiomeList.ZELKOVAFOREST, "zelkova_forest", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);

        //Sub Biomes
        registerBYGSubBiome(registry, BYGBiomeList.SNOWY_EVERGREEN_CLEARING, "snowy_evergreen_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWY_EVERGREEN_HILLS, "snowy_evergreen_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ENCHANTED_FOREST_HILLS, "enchanted_forest_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.RARE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.EBONY_HILLS, "ebony_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE);
        registerBYGSubBiome(registry, BYGBiomeList.EVERGREEN_CLEARING, "evergreen_clearing", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.EVERGREEN_HILLS, "evergreen_hills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FUNGAL_PATCH, "fungal_patch", true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.WEEPING_WTICH_CLEARING, "weeping_witch_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.PUMPKIN_FOREST, "pumpkin_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BAMBOO_FOREST, "bamboo_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.CHERRY_BLOSSOM_CLEARING, "cherry_blossom_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.CONIFEROUS_CLEARING, "coniferous_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ZELKOVA_CLEARING, "zelkova_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ASPEN_CLEARING, "aspen_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BOREALIS_CLEARING, "boreal_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.DECIDUOUS_CLEARING, "deciduous_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONAL_DECIDUOUS_CLEARING, "seasonal_deciduous_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.GUIANA_CLEARING, "guiana_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.JACARANDA_CLEARING, "jacaranda_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWY_CONIFEROUS_CLEARING, "snowy_coniferous_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWY_DECIDUOUS_CLEARING, "snowy_deciduous_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);

        registerBYGSubBiome(registry, BYGBiomeList.MAPLE_HILLS, "maple_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BLACK_FOREST_CLEARING, "black_forest_clearing", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BLACK_FOREST_HILLS, "black_forest_hills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FOREST_FAULT, "forest_fault", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FLOWERING_GROVE, "flowering_grove", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FLOWERING_ENCHANTED_GROVE, "flowering_enchanted_grove", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.NORTHERN_FOREST, "northern_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.LUSHREDDESERT, "lush_red_desert", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SIERRARANGE, "sierra_range", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ALPINEFOOTHILLS, "alpine_foothills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ASPENFORESTHILLS, "aspen_foresthills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BLUETAIGAHILLS, "blue_taiga_hills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BLUEGIANTTAIGA, "blue_giant_taiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BLUFFPEAKS, "bluff_peaks", true, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BOREALFORESTHILLS, "boreal_forest_hills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BOG, "bog", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.DECIDUOUSFORESTHILLS, "deciduous_forest_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.CONIFEROUSFORESTHILLS, "coniferous_forest_hills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FRESHWATERLAKE, "freshwater_lake", true, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FROZENLAKE, "frozen_lake", true, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.GREATLAKEISLES, "great_lake_isles", true, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.JACARANDAFORESTHILLS, "jacaranda_forest_hills", true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.MARSHLANDS, "marshlands", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.OASIS, "oasis", true, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.POLLUTEDLAKE, "polluted_lake", true, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.PRAIRIECLEARING, "prairie_clearing", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.REDOAKFORESTHILLS, "red_oak_forest_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.RED_ROCK_LOWLANDS, "red_rock_lowlands", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.RED_ROCK_HIGHLANDS, "red_rock_highlands", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.WOODEDREDROCKMOUNTAINS, "wooded_red_rock_mountains", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONALBIRCHFORESTHILLS, "seasonal_birch_forest_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONALDECIDUOUSFORESTHILLS, "seasonal_deciduous_forest_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONALFORESTHILLS, "seasonal_forest_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONALGIANTTAIGA, "seasonal_giant_taiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONALTAIGAHILLS, "seasonal_taiga_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWYBLUEGIANTTAIGA, "snowy_blue_giant_taiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWYBLUETAIGAHILLS, "snowy_blue_taiga_hills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWYCONIFERFORESTHILLS, "snowy_coniferous_forest_hills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWYDECIDUOUSFORESTHILLS, "snowy_deciduous_forest_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.TROPICALFUNGALRAINFORESTHILLS, "tropical_fungal_rainforest_hills", true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.TROPICALRAINFORESTHILLS, "tropical_rainforest_hills", true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.WOODEDGRASSLANDPLATEAU, "wooded_grassland_plateau", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ZELKOVAFORESTHILLS, "zelkova_forest_hills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FLOWERINGMEADOW, "flowering_meadow", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.WOODEDMEADOW, "wooded_meadow", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);


        //NonDefault Biomes.
        registerBYGBiome(registry, BYGBiomeList.ROCKYBEACH, "rocky_beach", true, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.OVERWORLD);
        registerBYGBiome(registry, BYGBiomeList.SNOWYROCKYBLACKBEACH, "snowy_rocky_blackbeach", true, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);
        registerBYGBiome(registry, BYGBiomeList.SNOWYBLACKBEACH, "snowy_black_beach", true, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);
        registerBYGBiome(registry, BYGBiomeList.WHITEBEACH, "white_beach", true, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.OVERWORLD);
        registerBYGBiome(registry, BYGBiomeList.RAINBOWBEACH, "rainbow_beach", true, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
        registerBYGBiome(registry, BYGBiomeList.TROPICALISLAND, "tropical_island", true, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.JUNGLE);

        //Nether
        registerBYGBiome(registry, BYGBiomeList.WARPEDDESERT, "warped_desert", false, BiomeDictionary.Type.NETHER);
        registerBYGBiome(registry, BYGBiomeList.SYTHIANTORRIDS, "sythian_torrids", false, BiomeDictionary.Type.NETHER);
        registerBYGBiome(registry, BYGBiomeList.GLOWSTONEGARDENS, "glowstone_gardens", false, BiomeDictionary.Type.NETHER);

        //End
        registerBYGEndBiome(registry, BYGBiomeList.IVISFIELDS, "ivis_fields", BiomeDictionary.Type.END);

//        BYGBiomeGroup.initBYGBiomes();
        BYG.LOGGER.info("BYG: Biomes Registered!");

//        if (BYGWorldConfig.vanillaBiomes.get()) {
//            BYGBiomeGroup.initDefaultBiomes();
//        }
    }

    private static void registerBiome(IForgeRegistry<Biome> registry, Biome biome, String name, boolean spawn, BiomeDictionary.Type... types) {
        registry.register(biome.setRegistryName(BYG.MOD_ID, name));
        if (spawn) {
            BiomeManager.addSpawnBiome(biome);
        }
        BiomeDictionary.addTypes(biome, types);
    }

    private static void registerBYGBiome(IForgeRegistry<Biome> registry, Biome biome, String name, boolean spawn, BiomeDictionary.Type... types) {
        registry.register(biome.setRegistryName(BYG.MOD_ID, name));
        if (spawn) {
            BiomeManager.addSpawnBiome(biome);
        }
        BiomeDictionary.addTypes(biome, types);
    }

    private static void registerBYGEndBiome(IForgeRegistry<Biome> registry, Biome biome, String name, BiomeDictionary.Type... types) {
        registry.register(biome.setRegistryName(BYG.MOD_ID, name));
//        BYGEndBiomeProvider.biomeList.add(biome);
        BiomeDictionary.addTypes(biome, types);
    }


    private static void registerBYGSubBiome(IForgeRegistry<Biome> registry, Biome biome, String name, boolean spawn, BiomeDictionary.Type... types) {
        registry.register(biome.setRegistryName(BYG.MOD_ID, name));
        if (spawn) {
            BiomeManager.addSpawnBiome(biome);
        }
        BiomeDictionary.addTypes(biome, types);
    }
}
