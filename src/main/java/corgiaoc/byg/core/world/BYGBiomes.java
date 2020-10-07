package corgiaoc.byg.core.world;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.end.IvisFields;
import corgiaoc.byg.common.world.biome.nether.*;
import corgiaoc.byg.common.world.biome.overworld.*;
import corgiaoc.byg.common.world.biome.overworld.sub.*;
import corgiaoc.byg.common.world.biome.overworld.sub.beach.*;
import corgiaoc.byg.common.world.biome.overworld.sub.clearings.*;
import corgiaoc.byg.common.world.biome.overworld.sub.hills.*;
import corgiaoc.byg.common.world.biome.overworld.sub.lakes.FreshWaterLake;
import corgiaoc.byg.common.world.biome.overworld.sub.lakes.FrozenLake;
import corgiaoc.byg.common.world.biome.overworld.sub.lakes.Oasis;
import corgiaoc.byg.common.world.biome.overworld.sub.lakes.PollutedLake;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import corgiaoc.byg.config.biomeweight.ConfigWeightManager;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BYGBiomes {

    public static List<Biome> biomeList = new ArrayList<>();

    public static final Biome ALLIUMFIELDS = new AlliumFields().getBiome();
    public static final Biome ALPS = new Alps().getBiome();
    public static final Biome AMARANTHFIELDS = new AmaranthFields().getBiome();
    public static final Biome ANCIENTFOREST = new AncientForest().getBiome();
    public static final Biome ARAUCARIA_SAVANNA = new AraucariaSavanna().getBiome();
    public static final Biome ASPENFOREST = new AspenForest().getBiome();
    public static final Biome AUTUMNAL_VALLEY = new AutumnalValley().getBiome();
    public static final Biome BAOBABSAVANNA = new BaobabSavanna().getBiome();
    public static final Biome BAYOU = new Bayou().getBiome();
    public static final Biome BASALT_BARRERA = new BasaltBarrera().getBiome();
    public static final Biome BLUEGIANTTAIGA = new BlueGiantTaiga().getBiome();
    public static final Biome BLUETAIGA = new BlueTaiga().getBiome();
    public static final Biome CIKA_WOODS = new CikaWoods().getBiome();
    public static final Biome COLOSSAL_ICE_SPIKES = new ColossalIceSpikes().getBiome();
    public static final Biome BLUFFSTEEPS = new BluffSteeps().getBiome();
    public static final Biome BOG = new Bog().getBiome();
    public static final Biome BOREALFOREST = new BorealForest().getBiome();
    public static final Biome COLDSWAMPLANDS = new ColdSwamplands().getBiome();
    public static final Biome CRAGGARDENS = new CragGardens().getBiome();
    public static final Biome REDROCKCANYON = new Canyons().getBiome();
    public static final Biome CYPRESSSWAMPLANDS = new CypressSwampland().getBiome();
    public static final Biome CHERRYBLOSSOMFOREST = new CherryBlossomForest().getBiome();
    public static final Biome REDWOOD_TROPICS = new RedwoodTropics().getBiome();
    public static final Biome CONIFEROUSFOREST = new ConiferousForest().getBiome();
    public static final Biome DEADSEA = new DeadSea().getBiome();
    public static final Biome DECIDUOUSFOREST = new DeciduousForest().getBiome();
    public static final Biome DOVERMOUNTAINS = new DoverMountains().getBiome();
    public static final Biome DUNES = new Dunes().getBiome();
    public static final Biome EBONYWOODS = new EbonyWoods().getBiome();
    public static final Biome ENCHANTEDFOREST = new EnchantedForest().getBiome();
    public static final Biome EVERGREENTAIGA = new EvergreenTaiga().getBiome();
    public static final Biome GLOWSHROOMBAYOU = new GlowShroomBayou().getBiome();
    public static final Biome GRASSLANDPLATEAU = new GrassLandPlateau().getBiome();
    public static final Biome GREATLAKES = new GreatLakes().getBiome();
    public static final Biome ENCHANTED_GROVE = new EnchantedGrove().getBiome();
    public static final Biome GROVE = new Grove().getBiome();
    public static final Biome GUIANASHIELD = new GuianaShield().getBiome();
    public static final Biome JACARANDAFOREST = new JacarandaForest().getBiome();
    public static final Biome MANGROVEMARSHES = new MangroveMarshes().getBiome();
    public static final Biome MAPLETAIGA = new MapleTaiga().getBiome();
    public static final Biome MARSHLANDS = new MarshLands().getBiome();
    public static final Biome MEADOW = new Meadow().getBiome();
    public static final Biome MOJAVE_DESERT = new MojaveDesert().getBiome();
    public static final Biome LUSH_TUNDRA = new LushTundra().getBiome();
    public static final Biome ORCHARD = new Orchard().getBiome();
    public static final Biome PRAIRIE = new Prairie().getBiome();
    public static final Biome REDDESERT = new RedDesert().getBiome();
    public static final Biome REDDESERTDUNES = new RedDesertDunes().getBiome();
    public static final Biome REDOAKFOREST = new RedOakForest().getBiome();
    public static final Biome RED_ROCK_MOUNTAINS = new RedRockMountains().getBiome();
    public static final Biome ROSE_FIELDS = new RoseFields().getBiome();
    public static final Biome SAVANNACANOPY = new SavannaCanopy().getBiome();
    public static final Biome SEASONALBIRCHFOREST = new SeasonalBirchForest().getBiome();
    public static final Biome SEASONALDECIDUOUSFOREST = new SeasonalDeciduousForest().getBiome();
    public static final Biome SEASONALFOREST = new SeasonalForest().getBiome();
    public static final Biome SEASONALGIANTTAIGA = new SeasonalGiantTaiga().getBiome();
    public static final Biome SEASONALTAIGA = new SeasonalTaiga().getBiome();
    public static final Biome SHATTEREDGLACIER = new ShatteredGlacier().getBiome();
    public static final Biome SHRUBLANDS = new ShrubLands().getBiome();
    public static final Biome SIERRAVALLEY = new SierraValley().getBiome();
    public static final Biome SKYRISHIGHLANDS = new SkyrisHighlands().getBiome();
    public static final Biome SNOWYBLUEGIANTTAIGA = new SnowyBlueGiantTaiga().getBiome();
    public static final Biome SNOWYBLUETAIGA = new SnowyBlueTaiga().getBiome();
    public static final Biome SNOWYCONIFEROUSFOREST = new SnowyConiferousForest().getBiome();
    public static final Biome SNOWYDECIDUOUSFOREST = new SnowyDeciduousForest().getBiome();
    public static final Biome SNOWYEVERGREENTAIGA = new SnowyEvergreenTaiga().getBiome();
    public static final Biome STONE_FOREST = new StoneForest().getBiome();
    public static final Biome THE_BLACK_FOREST = new TheBlackForest().getBiome();
    public static final Biome TROPICALFUNGALRAINFOREST = new TropicalFungalRainForest().getBiome();
    public static final Biome TROPICALISLAND = new TropicalIslands().getBiome();
    public static final Biome TROPICALRAINFOREST = new TropicalRainForest().getBiome();
    public static final Biome TWILIGHT_VALLEY = new TwilightValley().getBiome();
    public static final Biome VALLE_DE_LUNA = new ValleDeLuna().getBiome();
    public static final Biome VIBRANTSWAMPLANDS = new VibrantSwamplands().getBiome();
    public static final Biome VOLCANO = new Volcano().getBiome();
    public static final Biome WEEPINGWITCHFOREST = new WeepingWitchForest().getBiome();
    public static final Biome WOODLANDS = new WoodLands().getBiome();
    public static final Biome ZELKOVAFOREST = new ZelkovaForest().getBiome();

    //Beaches
    public static final Biome SNOWYROCKYBLACKBEACH = new SnowyRockyBlackBeach().getBiome();
    public static final Biome SNOWYBLACKBEACH = new SnowyBlackBeach().getBiome();
    public static final Biome WHITEBEACH = new WhiteBeach().getBiome();
    public static final Biome RAINBOWBEACH = new RainbowBeach().getBiome();
    public static final Biome ROCKYBEACH = new RockyBeach().getBiome();

    //Sub Biomes
    public static final Biome RED_SPRUCE_TAIGA = new RedSpruceTaiga().getBiome();
    public static final Biome TWILIGHT_VALLEY_HILLS = new TwilightValleyHills().getBiome();
    public static final Biome ARAUCARIA_FOREST = new AraucariaForest().getBiome();
    public static final Biome FUNGAL_PATCH = new FungalPatch().getBiome();
    public static final Biome LUSHREDDESERT = new LushRedDesert().getBiome();
    public static final Biome SIERRARANGE = new SierraRange().getBiome();
    public static final Biome ALPINEFOOTHILLS = new AlpineFoothills().getBiome();
    public static final Biome ASPENFORESTHILLS = new AspenForestHills().getBiome();
    public static final Biome BLUETAIGAHILLS = new BlueTaigaHills().getBiome();
    public static final Biome BLUFFPEAKS = new BluffPeaks().getBiome();
    public static final Biome BOREALFORESTHILLS = new BorealForestHills().getBiome();
    public static final Biome CONIFEROUSFORESTHILLS = new ConiferousForestHills().getBiome();
    public static final Biome DECIDUOUSFORESTHILLS = new DeciduousForestHills().getBiome();
    public static final Biome FRESHWATERLAKE = new FreshWaterLake().getBiome();
    public static final Biome FROZENLAKE = new FrozenLake().getBiome();
    public static final Biome GREATLAKEISLES = new GreatLakeIsles().getBiome();
    public static final Biome WOODEDGRASSLANDPLATEAU = new WoodedGrasslandPlateau().getBiome();
    public static final Biome JACARANDAFORESTHILLS = new JacarandaForestHills().getBiome();
    public static final Biome NORTHERN_FOREST = new NorthernForest().getBiome();
    public static final Biome FOREST_FAULT = new ForestFault().getBiome();
    public static final Biome POINTY_STONE_FOREST = new PointedStoneForest().getBiome();
    public static final Biome BLACK_FOREST_HILLS = new BlackForestHills().getBiome();
    public static final Biome BAMBOO_FOREST = new BambooForest().getBiome();
    public static final Biome MAPLE_HILLS = new MapleHills().getBiome();
    public static final Biome PUMPKIN_FOREST = new PumpkinForest().getBiome();
    public static final Biome EBONY_HILLS = new EbonyHills().getBiome();
    public static final Biome EVERGREEN_HILLS = new EvergreenHills().getBiome();
    public static final Biome EVERGREEN_CLEARING = new EvergreenClearing().getBiome();
    public static final Biome ENCHANTED_FOREST_HILLS = new EnchantedForestHills().getBiome();
    public static final Biome SNOWY_EVERGREEN_CLEARING = new SnowyEvergreenClearing().getBiome();
    public static final Biome SNOWY_EVERGREEN_HILLS = new SnowyEvergreenHills().getBiome();
    public static final Biome REDWOOD_CLEARING = new RedwoodClearing().getBiome();
    public static final Biome REDWOOD_MOUNTAINS = new RedwoodMountains().getBiome();
    public static final Biome CORAL_MANGROVES = new CoralMangroves().getBiome();
    public static final Biome CIKA_MOUNTAINS = new CikaMountains().getBiome();

    public static final Biome WEEPING_WTICH_CLEARING = new WeepingWitchClearing().getBiome();
    public static final Biome CHERRY_BLOSSOM_CLEARING = new CherryBlossomClearing().getBiome();
    public static final Biome BLACK_FOREST_CLEARING = new BlackForestClearing().getBiome();
    public static final Biome CONIFEROUS_CLEARING = new ConiferousClearing().getBiome();
    public static final Biome ZELKOVA_CLEARING = new ZelkovaClearing().getBiome();
    public static final Biome ASPEN_CLEARING = new AspenClearing().getBiome();
    public static final Biome BOREALIS_CLEARING = new BorealisClearing().getBiome();
    public static final Biome DECIDUOUS_CLEARING = new DeciduousClearing().getBiome();
    public static final Biome SEASONAL_DECIDUOUS_CLEARING = new SeasonalDeciduousClearing().getBiome();
    public static final Biome GUIANA_CLEARING = new GuianaClearing().getBiome();
    public static final Biome JACARANDA_CLEARING = new JacarandaClearing().getBiome();
    public static final Biome SNOWY_CONIFEROUS_CLEARING = new SnowyConiferousClearing().getBiome();
    public static final Biome SNOWY_DECIDUOUS_CLEARING = new SnowyDeciduousClearing().getBiome();
    public static final Biome TROPICAL_ISLAND_CLEARING = new TropicalIslandClearing().getBiome();
    public static final Biome TROPICAL_ISLAND_MOUNTAINS = new TropicalIslandMountains().getBiome();

    public static final Biome WOODEDMEADOW = new WoodedMeadow().getBiome();
    public static final Biome FLOWERINGMEADOW = new FloweringMeadow().getBiome();
    public static final Biome FLOWERING_GROVE = new FloweringGrove().getBiome();
    public static final Biome FLOWERING_ENCHANTED_GROVE = new FloweringEnchantedGrove().getBiome();
    public static final Biome GLOWING_ANCIENT_FOREST = new GlowingAncientForest().getBiome();
    public static final Biome FLOWERING_ANCIENT_FOREST = new FloweringAncientForest().getBiome();

    public static final Biome OASIS = new Oasis().getBiome();
    public static final Biome POLLUTEDLAKE = new PollutedLake().getBiome();
    public static final Biome PRAIRIECLEARING = new PrairieClearing().getBiome();
    public static final Biome REDOAKFORESTHILLS = new RedOakForestHills().getBiome();
    public static final Biome RED_ROCK_LOWLANDS = new RedRockLowlands().getBiome();
    public static final Biome RED_ROCK_HIGHLANDS = new RedRockHighlands().getBiome();
    public static final Biome WOODEDREDROCKMOUNTAINS = new WoodedRedRockMountains().getBiome();
    public static final Biome SEASONALBIRCHFORESTHILLS = new SeasonalBirchForestHills().getBiome();
    public static final Biome SEASONALDECIDUOUSFORESTHILLS = new SeasonalDeciduousForestHills().getBiome();
    public static final Biome SEASONALFORESTHILLS = new SeasonalForestHills().getBiome();
    public static final Biome SEASONALTAIGAHILLS = new SeasonalTaigaHills().getBiome();
    public static final Biome SNOWYBLUETAIGAHILLS = new SnowyBlueTaigaHills().getBiome();
    public static final Biome SNOWYCONIFERFORESTHILLS = new SnowyConiferousForestHills().getBiome();
    public static final Biome SNOWYDECIDUOUSFORESTHILLS = new SnowyDeciduousForestHills().getBiome();
    public static final Biome TROPICALFUNGALRAINFORESTHILLS = new TropicalFungalRainforestHills().getBiome();
    public static final Biome TROPICALRAINFORESTHILLS = new TropicalRainForestHills().getBiome();
    public static final Biome ZELKOVAFORESTHILLS = new ZelkovaForestHills().getBiome();

    //Nether
    public static final Biome WARPEDDESERT = new WarpedDesert().getBiome();
    public static final Biome SYTHIANTORRIDS = new SythianTorrids().getBiome();
    public static final Biome GLOWSTONEGARDENS = new GlowstoneGardens().getBiome();
    public static final Biome EMBURBOG = new EmburBog().getBiome();
    public static final Biome WAILING_GARTH = new WailingGarth().getBiome();
    public static final Biome CRIMSON_GARDENS = new CrimsonGardens().getBiome();
    public static final Biome MAGMA_WASTES = new MagmaWastes().getBiome();
    public static final Biome BRIMSTONE_CAVERNS = new BrimstoneCaverns().getBiome();
    public static final Biome SUBZERO_HYPOGEAL = new SubzeroHypogeal().getBiome();

    public static final Biome WITHERING_WOODS = new WitheringWoods().getBiome();
    public static final Biome WEEPING_MIRE = new WeepingMire().getBiome();
    public static final Biome QUARTZ_DESERT = new QuartzDesert().getBiome();

    //End
    public static final Biome IVISFIELDS = new IvisFields().getBiome();


    public static void registerBYGBiomes() {
        registerBiome(BYGBiomes.ALLIUMFIELDS, "allium_fields");
        registerBiome(BYGBiomes.ALPS, "alps");
        registerBiome(BYGBiomes.AMARANTHFIELDS, "amaranth_fields");
        registerBiome(BYGBiomes.ANCIENTFOREST, "ancient_forest");
        registerBiome(BYGBiomes.ARAUCARIA_SAVANNA, "araucaria_savanna");
        registerBiome(BYGBiomes.ASPENFOREST, "aspen_forest");
        registerBiome(BYGBiomes.AUTUMNAL_VALLEY, "autumnal_valley");
        registerBiome(BYGBiomes.BAOBABSAVANNA, "baobab_savanna");
        registerBiome(BYGBiomes.BAYOU, "bayou");
        registerBiome(BYGBiomes.BLUETAIGA, "blue_taiga");
        registerBiome(BYGBiomes.BLUFFSTEEPS, "bluff_steeps");
        registerBiome(BYGBiomes.BOREALFOREST, "boreal_forest");
        registerBiome(BYGBiomes.REDROCKCANYON, "canyons");
        registerBiome(BYGBiomes.COLDSWAMPLANDS, "cold_swamplands");
        registerBiome(BYGBiomes.COLOSSAL_ICE_SPIKES, "colossal_ice_spikes");
        registerBiome(BYGBiomes.CRAGGARDENS, "crag_gardens");
        registerBiome(BYGBiomes.CIKA_WOODS, "cika_woods");
        registerBiome(BYGBiomes.CHERRYBLOSSOMFOREST, "cherry_blossom_forest");
        registerBiome(BYGBiomes.REDWOOD_TROPICS, "redwood_tropics");
        registerBiome(BYGBiomes.CONIFEROUSFOREST, "coniferous_forest");
        registerBiome(BYGBiomes.CYPRESSSWAMPLANDS, "cypress_swamplands");
        registerBiome(BYGBiomes.DOVERMOUNTAINS, "dover_mountains");
        registerBiome(BYGBiomes.DEADSEA, "dead_sea");
        registerBiome(BYGBiomes.DECIDUOUSFOREST, "deciduous_forest");
        registerBiome(BYGBiomes.DUNES, "dunes");
        registerBiome(BYGBiomes.EBONYWOODS, "ebony_woods");
        registerBiome(BYGBiomes.ENCHANTEDFOREST, "enchanted_forest");
        registerBiome(BYGBiomes.EVERGREENTAIGA, "evergreen_taiga");
        registerBiome(BYGBiomes.GLOWSHROOMBAYOU, "glowshroom_bayou");
        registerBiome(BYGBiomes.GRASSLANDPLATEAU, "grassland_plateau");
        registerBiome(BYGBiomes.GREATLAKES, "great_lakes");
        registerBiome(BYGBiomes.GROVE, "grove");
        registerBiome(BYGBiomes.ENCHANTED_GROVE, "enchanted_grove");
        registerBiome(BYGBiomes.GUIANASHIELD, "guiana_shield");
        registerBiome(BYGBiomes.JACARANDAFOREST, "jacaranda_forest");
        registerBiome(BYGBiomes.MANGROVEMARSHES, "mangrove_marshes");
        registerBiome(BYGBiomes.MAPLETAIGA, "maple_taiga");
        registerBiome(BYGBiomes.MEADOW, "meadow");
        registerBiome(BYGBiomes.MOJAVE_DESERT, "mojave_desert");
        registerBiome(BYGBiomes.LUSH_TUNDRA, "lush_tundra");
        registerBiome(BYGBiomes.ORCHARD, "orchard");
        registerBiome(BYGBiomes.PRAIRIE, "prairie");
        registerBiome(BYGBiomes.REDDESERT, "red_desert");
        registerBiome(BYGBiomes.REDDESERTDUNES, "red_desert_dunes");
        registerBiome(BYGBiomes.REDOAKFOREST, "red_oak_forest");
        registerBiome(BYGBiomes.RED_ROCK_MOUNTAINS, "red_rock_mountains");
        registerBiome(BYGBiomes.ROSE_FIELDS, "rose_fields");
        registerBiome(BYGBiomes.SEASONALBIRCHFOREST, "seasonal_birch_forest");
        registerBiome(BYGBiomes.SEASONALDECIDUOUSFOREST, "seasonal_deciduous_forest");
        registerBiome(BYGBiomes.SEASONALFOREST, "seasonal_forest");
        registerBiome(BYGBiomes.SEASONALTAIGA, "seasonal_taiga");
        registerBiome(BYGBiomes.SHATTEREDGLACIER, "shattered_glacier");
        registerBiome(BYGBiomes.SHRUBLANDS, "shrublands");
        registerBiome(BYGBiomes.SKYRISHIGHLANDS, "skyris_highlands");
        registerBiome(BYGBiomes.SNOWYBLUETAIGA, "snowy_blue_taiga");
        registerBiome(BYGBiomes.SNOWYCONIFEROUSFOREST, "snowy_coniferous_forest");
        registerBiome(BYGBiomes.SNOWYDECIDUOUSFOREST, "snowy_deciduous_forest");
        registerBiome(BYGBiomes.SNOWYEVERGREENTAIGA, "snowy_evergreen_taiga");
        registerBiome(BYGBiomes.STONE_FOREST, "stone_forest");
        registerBiome(BYGBiomes.THE_BLACK_FOREST, "the_black_forest");
        registerBiome(BYGBiomes.TROPICALFUNGALRAINFOREST, "tropical_fungal_forest");
        registerBiome(BYGBiomes.TROPICALRAINFOREST, "tropical_rainforest");
        registerBiome(BYGBiomes.TWILIGHT_VALLEY, "twilight_valley");
        registerBiome(BYGBiomes.VIBRANTSWAMPLANDS, "vibrant_swamplands");
        registerBiome(BYGBiomes.VALLE_DE_LUNA, "valle_de_luna");
        registerBiome(BYGBiomes.VOLCANO, "volcano");
        registerBiome(BYGBiomes.SIERRAVALLEY, "sierra_valley");
        registerBiome(BYGBiomes.WEEPINGWITCHFOREST, "weeping_witch_forest");
        registerBiome(BYGBiomes.WOODLANDS, "woodlands");
        registerBiome(BYGBiomes.ZELKOVAFOREST, "zelkova_forest");

        registerBYGSubBiome(BYGBiomes.REDWOOD_CLEARING, "redwood_clearing");
        registerBYGSubBiome(BYGBiomes.REDWOOD_MOUNTAINS, "redwood_mountains");
        registerBYGSubBiome(BYGBiomes.CORAL_MANGROVES, "coral_mangroves");
        registerBYGSubBiome(BYGBiomes.CIKA_MOUNTAINS, "cika_mountains");
        registerBYGSubBiome(BYGBiomes.GLOWING_ANCIENT_FOREST, "glowing_ancient_forest");
        registerBYGSubBiome(BYGBiomes.FLOWERING_ANCIENT_FOREST, "flowering_ancient_forest");

        //Sub Biomes
        registerBYGSubBiome(BYGBiomes.RED_SPRUCE_TAIGA, "red_spruce_taiga");
        registerBYGSubBiome(BYGBiomes.TWILIGHT_VALLEY_HILLS, "twilight_valley_hills");
        registerBYGSubBiome(BYGBiomes.ARAUCARIA_FOREST, "araucaria_forest");
        registerBYGSubBiome(BYGBiomes.SNOWY_EVERGREEN_CLEARING, "snowy_evergreen_clearing");
        registerBYGSubBiome(BYGBiomes.SNOWY_EVERGREEN_HILLS, "snowy_evergreen_hills");
        registerBYGSubBiome(BYGBiomes.ENCHANTED_FOREST_HILLS, "enchanted_forest_hills");
        registerBYGSubBiome(BYGBiomes.EBONY_HILLS, "ebony_hills");
        registerBYGSubBiome(BYGBiomes.EVERGREEN_CLEARING, "evergreen_clearing");
        registerBYGSubBiome(BYGBiomes.EVERGREEN_HILLS, "evergreen_hills");
        registerBYGSubBiome(BYGBiomes.FUNGAL_PATCH, "fungal_patch");
        registerBYGSubBiome(BYGBiomes.WEEPING_WTICH_CLEARING, "weeping_witch_clearing");
        registerBYGSubBiome(BYGBiomes.PUMPKIN_FOREST, "pumpkin_forest");
        registerBYGSubBiome(BYGBiomes.BAMBOO_FOREST, "bamboo_forest");
        registerBYGSubBiome(BYGBiomes.CHERRY_BLOSSOM_CLEARING, "cherry_blossom_clearing");
        registerBYGSubBiome(BYGBiomes.CONIFEROUS_CLEARING, "coniferous_clearing");
        registerBYGSubBiome(BYGBiomes.ZELKOVA_CLEARING, "zelkova_clearing");
        registerBYGSubBiome(BYGBiomes.ASPEN_CLEARING, "aspen_clearing");
        registerBYGSubBiome(BYGBiomes.BOREALIS_CLEARING, "boreal_clearing");
        registerBYGSubBiome(BYGBiomes.DECIDUOUS_CLEARING, "deciduous_clearing");
        registerBYGSubBiome(BYGBiomes.SEASONAL_DECIDUOUS_CLEARING, "seasonal_deciduous_clearing");
        registerBYGSubBiome(BYGBiomes.GUIANA_CLEARING, "guiana_clearing");
        registerBYGSubBiome(BYGBiomes.JACARANDA_CLEARING, "jacaranda_clearing");
        registerBYGSubBiome(BYGBiomes.SNOWY_CONIFEROUS_CLEARING, "snowy_coniferous_clearing");
        registerBYGSubBiome(BYGBiomes.SNOWY_DECIDUOUS_CLEARING, "snowy_deciduous_clearing");

        registerBYGSubBiome(BYGBiomes.MAPLE_HILLS, "maple_hills");
        registerBYGSubBiome(BYGBiomes.BLACK_FOREST_CLEARING, "black_forest_clearing");
        registerBYGSubBiome(BYGBiomes.BLACK_FOREST_HILLS, "black_forest_hills");
        registerBYGSubBiome(BYGBiomes.FOREST_FAULT, "forest_fault");
        registerBYGSubBiome(BYGBiomes.FLOWERING_GROVE, "flowering_grove");
        registerBYGSubBiome(BYGBiomes.FLOWERING_ENCHANTED_GROVE, "flowering_enchanted_grove");
        registerBYGSubBiome(BYGBiomes.NORTHERN_FOREST, "northern_forest");
        registerBYGSubBiome(BYGBiomes.LUSHREDDESERT, "lush_red_desert");
        registerBYGSubBiome(BYGBiomes.SIERRARANGE, "sierra_range");
        registerBYGSubBiome(BYGBiomes.ALPINEFOOTHILLS, "alpine_foothills");
        registerBYGSubBiome(BYGBiomes.ASPENFORESTHILLS, "aspen_forest_hills");
        registerBYGSubBiome(BYGBiomes.BLUETAIGAHILLS, "blue_taiga_hills");
        registerBYGSubBiome(BYGBiomes.BLUEGIANTTAIGA, "blue_giant_taiga");
        registerBYGSubBiome(BYGBiomes.BLUFFPEAKS, "bluff_peaks");
        registerBYGSubBiome(BYGBiomes.BOREALFORESTHILLS, "boreal_forest_hills");
        registerBYGSubBiome(BYGBiomes.BOG, "bog");
        registerBYGSubBiome(BYGBiomes.DECIDUOUSFORESTHILLS, "deciduous_forest_hills");
        registerBYGSubBiome(BYGBiomes.CONIFEROUSFORESTHILLS, "coniferous_forest_hills");
        registerBYGSubBiome(BYGBiomes.FRESHWATERLAKE, "fresh_water_lake");
        registerBYGSubBiome(BYGBiomes.FROZENLAKE, "frozen_lake");
        registerBYGSubBiome(BYGBiomes.GREATLAKEISLES, "great_lake_isles");
        registerBYGSubBiome(BYGBiomes.JACARANDAFORESTHILLS, "jacaranda_forest_hills");
        registerBYGSubBiome(BYGBiomes.MARSHLANDS, "marshlands");
        registerBYGSubBiome(BYGBiomes.OASIS, "oasis");
        registerBYGSubBiome(BYGBiomes.POLLUTEDLAKE, "polluted_lake");
        registerBYGSubBiome(BYGBiomes.PRAIRIECLEARING, "prairie_clearing");
        registerBYGSubBiome(BYGBiomes.REDOAKFORESTHILLS, "red_oak_forest_hills");
        registerBYGSubBiome(BYGBiomes.RED_ROCK_LOWLANDS, "red_rock_lowlands");
        registerBYGSubBiome(BYGBiomes.RED_ROCK_HIGHLANDS, "red_rock_highlands");
        registerBYGSubBiome(BYGBiomes.WOODEDREDROCKMOUNTAINS, "wooded_red_rock_mountains");
        registerBYGSubBiome(BYGBiomes.SEASONALBIRCHFORESTHILLS, "seasonal_birch_forest_hills");
        registerBYGSubBiome(BYGBiomes.SEASONALDECIDUOUSFORESTHILLS, "seasonal_deciduous_forest_hills");
        registerBYGSubBiome(BYGBiomes.SEASONALFORESTHILLS, "seasonal_forest_hills");
        registerBYGSubBiome(BYGBiomes.SEASONALGIANTTAIGA, "seasonal_giant_taiga");
        registerBYGSubBiome(BYGBiomes.POINTY_STONE_FOREST, "pointed_stone_forest");
        registerBYGSubBiome(BYGBiomes.SEASONALTAIGAHILLS, "seasonal_taiga_hills");
        registerBYGSubBiome(BYGBiomes.SNOWYBLUEGIANTTAIGA, "snowy_blue_giant_taiga");
        registerBYGSubBiome(BYGBiomes.SNOWYBLUETAIGAHILLS, "snowy_blue_taiga_hills");
        registerBYGSubBiome(BYGBiomes.SNOWYCONIFERFORESTHILLS, "snowy_coniferous_forest_hills");
        registerBYGSubBiome(BYGBiomes.SNOWYDECIDUOUSFORESTHILLS, "snowy_deciduous_forest_hills");
        registerBYGSubBiome(BYGBiomes.TROPICALFUNGALRAINFORESTHILLS, "tropical_fungal_rainforest_hills");
        registerBYGSubBiome(BYGBiomes.TROPICALRAINFORESTHILLS, "tropical_rainforest_hills");
        registerBYGSubBiome(BYGBiomes.WOODEDGRASSLANDPLATEAU, "wooded_grassland_plateau");
        registerBYGSubBiome(BYGBiomes.ZELKOVAFORESTHILLS, "zelkova_forest_hills");
        registerBYGSubBiome(BYGBiomes.FLOWERINGMEADOW, "flowering_meadow");
        registerBYGSubBiome(BYGBiomes.WOODEDMEADOW, "wooded_meadow");
        registerBYGSubBiome(BYGBiomes.TROPICAL_ISLAND_CLEARING, "tropical_island_clearing");
        registerBYGSubBiome(BYGBiomes.TROPICAL_ISLAND_MOUNTAINS, "tropical_island_mountains");


        //NonDefault Biomes.
        registerBYGBiome(BYGBiomes.ROCKYBEACH, "rocky_beach");
        registerBYGBiome(BYGBiomes.BASALT_BARRERA, "basalt_barrera");
        registerBYGBiome(BYGBiomes.SNOWYROCKYBLACKBEACH, "snowy_rocky_black_beach");
        registerBYGBiome(BYGBiomes.SNOWYBLACKBEACH, "snowy_black_beach");
        registerBYGBiome(BYGBiomes.WHITEBEACH, "white_beach");
        registerBYGBiome(BYGBiomes.RAINBOWBEACH, "rainbow_beach");
        registerBYGBiome(BYGBiomes.TROPICALISLAND, "tropical_island");

        //Nether
        registerNetherBiome(BYGBiomes.WARPEDDESERT, "warped_desert");
        registerNetherBiome(BYGBiomes.SYTHIANTORRIDS, "sythian_torrids");
        registerNetherBiome(BYGBiomes.GLOWSTONEGARDENS, "glowstone_gardens");
        registerNetherBiome(BYGBiomes.EMBURBOG, "embur_bog");
        registerNetherBiome(BYGBiomes.WAILING_GARTH, "wailing_garth");
        registerNetherBiome(BYGBiomes.CRIMSON_GARDENS, "crimson_gardens");
        registerNetherBiome(BYGBiomes.MAGMA_WASTES, "magma_wastes");
        registerNetherBiome(BYGBiomes.BRIMSTONE_CAVERNS, "brimstone_caverns");
        registerNetherBiome(BYGBiomes.SUBZERO_HYPOGEAL, "subzero_hypogeal");
        registerNetherBiome(BYGBiomes.WITHERING_WOODS, "withering_woods");
        registerNetherBiome(BYGBiomes.WEEPING_MIRE, "weeping_mire");
        registerNetherBiome(BYGBiomes.QUARTZ_DESERT, "quartz_desert");

        //End
        registerBYGEndBiome(BYGBiomes.IVISFIELDS, "ivis_fields");
    }

    private static void registerBiome(Biome biome, String name) {
        Registry.register(WorldGenRegistries.BIOME, new ResourceLocation(BYG.MOD_ID, name), biome);
        biomeList.add(biome);
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

    public static void addBiomesToWeightSystem() {
        ConfigWeightManager.loadConfig(ConfigWeightManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(BYG.MOD_ID + "-weights-common.toml"));
        BYG.LOGGER.debug("BYG: Adding biome entries with their respective weights...");
        addBiomeEntry(BYGBiomes.ALLIUMFIELDS, ConfigWeightManager.ALLIUMFIELDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.ALPS, ConfigWeightManager.ALPS.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.AMARANTHFIELDS, ConfigWeightManager.AMARANTHFIELDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.AUTUMNAL_VALLEY, ConfigWeightManager.AUTUMNALVALLEY.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.ANCIENTFOREST, ConfigWeightManager.ANCIENTFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.ASPENFOREST, ConfigWeightManager.ASPENFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.BAOBABSAVANNA, ConfigWeightManager.BAOBABSAVANNA.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.BAYOU, ConfigWeightManager.BAYOU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.BLUETAIGA, ConfigWeightManager.BLUETAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.BLUFFSTEEPS, ConfigWeightManager.BLUFFSTEEPS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.BOREALFOREST, ConfigWeightManager.BOREALFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.COLDSWAMPLANDS, ConfigWeightManager.COLDSWAMPLANDS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.CIKA_WOODS, ConfigWeightManager.CIKA_WOODS.getWeight(), BiomeManager.BiomeType.COOL);
//        addBiomeEntry(BYGBiomes.REDROCKCANYON, ConfigWeightManager.CANYONS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.CYPRESSSWAMPLANDS, ConfigWeightManager.CYPRESS_SWAMPLAND.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.CHERRYBLOSSOMFOREST, ConfigWeightManager.CHERRY_BLOSSOM_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.CONIFEROUSFOREST, ConfigWeightManager.CONIFEROUSFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.DOVERMOUNTAINS, ConfigWeightManager.DOVERMOUNTAINS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.DEADSEA, ConfigWeightManager.DEADSEA.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.DECIDUOUSFOREST, ConfigWeightManager.DECIDUOUSFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.DUNES, ConfigWeightManager.DUNES.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.EBONYWOODS, ConfigWeightManager.EBONY_WOODS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.ENCHANTEDFOREST, ConfigWeightManager.ENCHANTED_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.EVERGREENTAIGA, ConfigWeightManager.EVERGREEN_TAIGA.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.GLOWSHROOMBAYOU, ConfigWeightManager.GLOWSHROOMBAYOU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.GRASSLANDPLATEAU, ConfigWeightManager.GRASSLANDPLATEAU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.GREATLAKES, ConfigWeightManager.GREATLAKES.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.GUIANASHIELD, ConfigWeightManager.GUIANASHIELD.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.GROVE, ConfigWeightManager.GROVE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.ENCHANTED_GROVE, ConfigWeightManager.ENCHANTED_GROVE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.JACARANDAFOREST, ConfigWeightManager.JACARANDAFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.CRAGGARDENS, ConfigWeightManager.CRAGGARDENS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.MANGROVEMARSHES, ConfigWeightManager.MANGROVE_MARSHES.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.MAPLETAIGA, ConfigWeightManager.MAPLE_TAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.MEADOW, ConfigWeightManager.MEADOW.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.MOJAVE_DESERT, ConfigWeightManager.MOJAVEDESERT.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.LUSH_TUNDRA, ConfigWeightManager.LUSH_TUNDRA.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.ORCHARD, ConfigWeightManager.ORCHARD.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.PRAIRIE, ConfigWeightManager.PRAIRIE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.REDDESERT, ConfigWeightManager.REDDESERT.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.REDOAKFOREST, ConfigWeightManager.REDOAKFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.RED_ROCK_MOUNTAINS, ConfigWeightManager.REDROCKMOUNTAINS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.REDWOOD_TROPICS, ConfigWeightManager.REDWOOD_TROPICS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.SEASONALBIRCHFOREST, ConfigWeightManager.SEASONALBIRCHFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.SEASONALDECIDUOUSFOREST, ConfigWeightManager.SEASONALDECIDUOUSFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.SEASONALFOREST, ConfigWeightManager.SEASONALFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.SEASONALTAIGA, ConfigWeightManager.SEASONALTAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.SHATTEREDGLACIER, ConfigWeightManager.SHATTEREDGLACIER.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.SHRUBLANDS, ConfigWeightManager.SHRUBLANDS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.SKYRISHIGHLANDS, ConfigWeightManager.SKYRISHIGHLANDS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.SNOWYBLUETAIGA, ConfigWeightManager.SNOWYBLUETAIGA.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.SNOWYCONIFEROUSFOREST, ConfigWeightManager.SNOWYCONIFEROUSFOREST.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.SNOWYDECIDUOUSFOREST, ConfigWeightManager.SNOWYDECIDUOUSFOREST.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.SNOWYEVERGREENTAIGA, ConfigWeightManager.SNOWY_EVERGREEN_TAIGA.getWeight(), BiomeManager.BiomeType.ICY);
//        addBiomeEntry(BYGBiomes.SONORANDESERT, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomes.STONEBRUSHLANDS, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomes.STONEFOREST, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.THE_BLACK_FOREST, ConfigWeightManager.THE_BLACK_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.TROPICALFUNGALRAINFOREST, ConfigWeightManager.TROPICALFUNGALFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.TROPICALRAINFOREST, ConfigWeightManager.TROPICALRAINFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.VIBRANTSWAMPLANDS, ConfigWeightManager.VIBRANTSWAMPLANDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.SIERRAVALLEY, ConfigWeightManager.SIERRAVALLEY.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.WEEPINGWITCHFOREST, ConfigWeightManager.WEEPING_WITCH_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.WOODLANDS, ConfigWeightManager.WOODLANDS.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomes.VOLCANO, 1, BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.ZELKOVAFOREST, ConfigWeightManager.ZELKOVAFOREST.getWeight(), BiomeManager.BiomeType.COOL);

        BYG.LOGGER.debug("BYG: Added biome entries with their respective weights!");
    }

    public static void addBiomeEntry(Biome biome, int weight, BiomeManager.BiomeType type) {
        if (weight > 0) {
            BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome))), weight));
        }
    }
}
