package voronoiaoc.byg.core.registries;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.dimension.end.biome.BYGEndBiomeProvider;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGBiomeRegistry {
    public static List<String> biomeList = new ArrayList<>();


    @SubscribeEvent
    public static void registerBYGBiomes(RegistryEvent.Register<Biome> event) {
        BYG.LOGGER.debug("BYG: Registering Biomes...");
        IForgeRegistry<Biome> registry = event.getRegistry();
//        registerBiome(registry, BYGBiomeList.DUMMYBIOME, "dummy", true, BiomeDictionary.Type.PLAINS);

        registerBiome(registry, BYGBiomeList.ALLIUMFIELDS, "alliumfields", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.RARE, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.ALPS, "alps", true, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.AMARANTHFIELDS, "amaranthfields", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.RARE, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.ANCIENTFOREST, "ancient_forest", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.ASPENFOREST, "aspenforest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.AUTUMNAL_VALLEY, "autumnal_valley",  true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.BAOBABSAVANNA, "baobabsavanna",  true, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.BAYOU, "bayou",  true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.BLUETAIGA, "bluetaiga",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.BLUFFSTEEPS, "bluffsteeps",  true, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.BOREALFOREST, "borealforest",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.COLDSWAMPLANDS, "coldswamplands", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.CRAGGARDENS, "crag_gardens",  true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.WET, BiomeDictionary.Type.PLATEAU, BiomeDictionary.Type.RARE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.CIKA_WOODS, "cika_woods",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);

//        registerBiome(registry, BYGBiomeList.REDROCKCANYON, "red_rock_canyon", false,  BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.PLATEAU);
        registerBiome(registry, BYGBiomeList.CHERRYBLOSSOMFOREST, "cherry_blossom_forest", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.REDWOOD_TROPICS, "redwood_tropics", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.CONIFEROUSFOREST, "coniferousforest",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.CYPRESSSWAMPLANDS, "cypress_swamplands", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.DOVERMOUNTAINS, "dovermountains",  true, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.DEADSEA, "deadsea",  true, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.DECIDUOUSFOREST, "deciduousforest",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.DUNES, "dunes",  true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.EBONYWOODS, "ebony_woods", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.ENCHANTEDFOREST, "enchanted_forest", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.RARE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.EVERGREENTAIGA, "evergreen_taiga", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.GLOWSHROOMBAYOU, "glowshroombayou",  true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET,BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.GRASSLANDPLATEAU, "grasslandplateau",  true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.GREATLAKES, "greatlakes",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WATER, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.GROVE, "grove",  true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.ENCHANTED_GROVE, "enchanted_grove",  true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.GUIANASHIELD, "guianashield",  true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.JACARANDAFOREST, "jacarandaforest",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.MANGROVEMARSHES, "mangrove_marshes", true,  BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.MAPLETAIGA, "maple_taiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.MEADOW, "meadow",  true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.MOJAVE_DESERT, "mojave_desert",  true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.LUSH_TUNDRA, "lush_tundra",  true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.ORCHARD, "orchard", true,  BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.PRAIRIE, "prairie",  true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.REDDESERT, "reddesert",  true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.REDDESERTDUNES, "reddesertdunes",  true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.REDOAKFOREST, "redoakforest",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.RED_ROCK_MOUNTAINS, "red_rock_mountains",  true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SEASONALBIRCHFOREST, "seasonalbirchforest",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SEASONALDECIDUOUSFOREST, "seasonaldeciduousforest",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SEASONALFOREST, "seasonalforest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SEASONALTAIGA, "seasonaltaiga",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SHATTEREDGLACIER, "shatteredglacier",  true, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SHRUBLANDS, "shrublands",  true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SKYRISHIGHLANDS, "skyrishighlands",  true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SNOWYBLUETAIGA, "snowybluetaiga",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SNOWYCONIFEROUSFOREST, "snowyconiferousforest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SNOWYDECIDUOUSFOREST, "snowydeciduousforest",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);
//        registerBiome(registry, BYGBiomeList.SAVANNACANOPY, "savanna_canopy",  true, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SNOWYEVERGREENTAIGA, "snowy_evergreen_taiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        //registerBiome(registry, BYGBiomeList.SONORANDESERT, "sonorandesert", ConfigWeightManager.sonorandesert.getWeight(), true, BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY);
        //registerBiome(registry, BYGBiomeList.STONEBRUSHLANDS, "stonebrushlands", ConfigWeightManager.stonebrushlands.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.COLD);
//        registerBiome(registry, BYGBiomeList.STONEFOREST, "stoneforest", ConfigWeightManager.stoneforest.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.COLD);
        registerBiome(registry, BYGBiomeList.THE_BLACK_FOREST, "the_black_forest",  true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.TROPICALFUNGALRAINFOREST, "tropicalfungalforest",  true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.TROPICALRAINFOREST, "tropicalrainforest",  true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.VIBRANTSWAMPLANDS, "vibrantswamplands",  true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WET, BiomeDictionary.Type.WATER, BiomeDictionary.Type.OVERWORLD);
//        registerBiome(registry, BYGBiomeList.VOLCANO, "volcano",  false, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.SIERRAVALLEY, "sierravalley",  true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.WEEPINGWITCHFOREST, "weeping_witch_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.WOODLANDS, "woodlands", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBiome(registry, BYGBiomeList.ZELKOVAFOREST, "zelkovaforest",  true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);

        //Sub Biomes
        registerBYGSubBiome(registry, BYGBiomeList.REDWOOD_CLEARING, "redwood_clearing", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.REDWOOD_MOUNTAINS, "redwood_mountains", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE,BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.CORAL_MANGROVES, "coral_mangroves", true,  BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.CIKA_MOUNTAINS, "cika_mountains",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.GLOWING_ANCIENT_FOREST, "glowing_ancient_forest", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FLOWERING_ANCIENT_FOREST, "flowering_ancient_forest", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);

        registerBYGSubBiome(registry, BYGBiomeList.SNOWY_EVERGREEN_CLEARING, "snowy_evergreen_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWY_EVERGREEN_HILLS, "snowy_evergreen_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ENCHANTED_FOREST_HILLS, "enchanted_forest_hills", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.RARE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.EBONY_HILLS, "ebony_hills", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE);
        registerBYGSubBiome(registry, BYGBiomeList.EVERGREEN_CLEARING, "evergreen_clearing", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.EVERGREEN_HILLS, "evergreen_hills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FUNGAL_PATCH, "fungal_patch",  true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.WEEPING_WTICH_CLEARING, "weeping_witch_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.PUMPKIN_FOREST, "pumpkin_forest", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BAMBOO_FOREST, "bamboo_forest", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.CHERRY_BLOSSOM_CLEARING, "cherry_blossom_clearing", true,  BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.CONIFEROUS_CLEARING, "coniferous_clearing",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ZELKOVA_CLEARING, "zelkova_clearing",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ASPEN_CLEARING, "aspen_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BOREALIS_CLEARING, "boreal_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.DECIDUOUS_CLEARING, "deciduous_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONAL_DECIDUOUS_CLEARING, "seasonal_deciduous_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.GUIANA_CLEARING, "guiana_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.JACARANDA_CLEARING, "jacaranda_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWY_CONIFEROUS_CLEARING, "snowy_coniferous_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWY_DECIDUOUS_CLEARING, "snowy_deciduous_clearing", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);

        registerBYGSubBiome(registry, BYGBiomeList.MAPLE_HILLS, "maple_hills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BLACK_FOREST_CLEARING, "black_forest_clearing",  true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BLACK_FOREST_HILLS, "black_forest_hills",  true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FOREST_FAULT, "forest_fault",  true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FLOWERING_GROVE, "flowering_grove",  true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FLOWERING_ENCHANTED_GROVE, "flowering_enchanted_grove",  true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.NORTHERN_FOREST, "northern_forest",  true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.LUSHREDDESERT, "lushreddesert", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SIERRARANGE, "sierrarange", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ALPINEFOOTHILLS, "alpinefoothills",true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ASPENFORESTHILLS, "aspenforesthills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BLUETAIGAHILLS, "bluetaigahills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BLUEGIANTTAIGA, "giantbluesprucetaiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BLUFFPEAKS, "bluffpeaks", true, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BOREALFORESTHILLS, "borealforesthills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.BOG, "bog", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.DECIDUOUSFORESTHILLS, "deciduousforesthills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.CONIFEROUSFORESTHILLS, "coniferousforesthills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FRESHWATERLAKE, "freshwaterlake", true, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FROZENLAKE, "frozenlake", true, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.GREATLAKEISLES, "greatlakeisles", true, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.JACARANDAFORESTHILLS, "jacarandaforesthills", true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.MARSHLANDS, "marshlands", true, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.OASIS, "oasis", true, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.POLLUTEDLAKE, "pollutedlake", true, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.PRAIRIECLEARING, "prairieclearing", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.REDOAKFORESTHILLS, "redoakforesthills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.RED_ROCK_LOWLANDS, "red_rock_lowlands", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.RED_ROCK_HIGHLANDS, "red_rock_highlands", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.WOODEDREDROCKMOUNTAINS, "wooded_red_rock_mountains", true, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONALBIRCHFORESTHILLS, "seasonalbirchforesthills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONALDECIDUOUSFORESTHILLS, "seasonaldeciduousforesthills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONALFORESTHILLS, "seasonalforesthills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONALGIANTTAIGA, "giantseasonalsprucetaiga", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SEASONALTAIGAHILLS, "seasonaltaigahills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWYBLUEGIANTTAIGA, "snowygiantbluetaiga",true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWYBLUETAIGAHILLS, "snowybluetaigahills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWYCONIFERFORESTHILLS, "snowyconiferousforesthills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWYDECIDUOUSFORESTHILLS, "snowydeciduousforesthills", true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.TROPICALFUNGALRAINFORESTHILLS, "tropicalfungalrainforesthills", true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.TROPICALRAINFORESTHILLS, "tropicalrainforesthills", true, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.WOODEDGRASSLANDPLATEAU, "woodedgrasslandplateau", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.FOREST,BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ZELKOVAFORESTHILLS, "zelkovaforesthills", true, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.FLOWERINGMEADOW, "floweringmeadow",  true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.WOODEDMEADOW, "woodedmeadow", true, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.ROCKYBEACH, "rockybeach", true, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWYROCKYBLACKBEACH, "snowyrockyblackbeach", true, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.SNOWYBLACKBEACH, "snowyblackbeach", true, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.WHITEBEACH, "whitebeach", true, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.RAINBOWBEACH, "rainbowbeach", true, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
        registerBYGSubBiome(registry, BYGBiomeList.TROPICALISLAND, "tropicalisland", true, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.JUNGLE);

        //Nether
        registerNetherBiome(registry, BYGBiomeList.WARPEDDESERT, "warpeddesert",  BiomeDictionary.Type.NETHER);
        registerNetherBiome(registry, BYGBiomeList.SYTHIANTORRIDS, "sythiantorrids",  BiomeDictionary.Type.NETHER);
        registerNetherBiome(registry, BYGBiomeList.GLOWSTONEGARDENS, "glowstonegardens",  BiomeDictionary.Type.NETHER);
        registerNetherBiome(registry, BYGBiomeList.EMBURBOG, "embur_bog", BiomeDictionary.Type.NETHER);

        //End
        registerBYGEndBiome(registry, BYGBiomeList.IVISFIELDS, "ivis_fields",  BiomeDictionary.Type.END);

//        BYGBiomeGroup.initBYGBiomes();
        BYG.LOGGER.info("BYG: Biomes Registered!");

    }
    static int idx = 0;


    private static void registerBiome(IForgeRegistry<Biome> registry, Biome biome, String name, boolean spawn, BiomeDictionary.Type... types) {
        registry.register(biome.setRegistryName(BYG.MOD_ID, name));
            if (spawn) {
                BiomeManager.addSpawnBiome(biome);
            }
            BiomeDictionary.addTypes(biome, types);
        biomeList.add(name);
    }

    private static void registerBYGEndBiome(IForgeRegistry<Biome> registry, Biome biome, String name, BiomeDictionary.Type... types) {
        registry.register(biome.setRegistryName(BYG.MOD_ID, name));
        BYGEndBiomeProvider.biomeList.add(biome);
        BiomeDictionary.addTypes(biome, types);
    }

    private static void registerNetherBiome(IForgeRegistry<Biome> registry, Biome biome, String name, BiomeDictionary.Type... types) {
        registry.register(biome.setRegistryName(BYG.MOD_ID, name));
        BiomeDictionary.addTypes(biome, types);
    }


    private static void registerBYGSubBiome(IForgeRegistry<Biome> registry, Biome biome, String name, boolean spawn, BiomeDictionary.Type... types) {
        registry.register(biome.setRegistryName(BYG.MOD_ID, name));
        if (spawn) {
            BiomeManager.addSpawnBiome(biome);
        }
        BiomeDictionary.addTypes(biome, types);
        idx++;
        biomeList.add(name);
    }
}
