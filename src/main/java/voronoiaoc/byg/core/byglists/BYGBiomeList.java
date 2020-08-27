package voronoiaoc.byg.core.byglists;

import net.minecraft.world.biome.Biome;
import voronoiaoc.byg.common.biomes.beachbiomes.*;
import voronoiaoc.byg.common.biomes.biomes.*;
import voronoiaoc.byg.common.biomes.endbiomes.IvisFields;
import voronoiaoc.byg.common.biomes.netherbiome.EmburBog;
import voronoiaoc.byg.common.biomes.netherbiome.GlowstoneGardens;
import voronoiaoc.byg.common.biomes.netherbiome.SythianTorrids;
import voronoiaoc.byg.common.biomes.netherbiome.WarpedDesert;
import voronoiaoc.byg.common.biomes.subbiomes.*;
import voronoiaoc.byg.common.biomes.subbiomes.clearings.*;
import voronoiaoc.byg.common.biomes.subbiomes.hills.*;
import voronoiaoc.byg.common.biomes.subbiomes.lakes.FreshWaterLake;
import voronoiaoc.byg.common.biomes.subbiomes.lakes.FrozenLake;
import voronoiaoc.byg.common.biomes.subbiomes.lakes.Oasis;
import voronoiaoc.byg.common.biomes.subbiomes.lakes.PollutedLake;

public class BYGBiomeList {

    public static final Biome ALLIUMFIELDS = new AlliumFields().getBiome();
    public static final Biome ALPS = new Alps().getBiome();
    public static final Biome AMARANTHFIELDS = new AmaranthFields().getBiome();
    public static final Biome ANCIENTFOREST = new AncientForest().getBiome();
    public static final Biome ASPENFOREST = new AspenForest().getBiome();
    public static final Biome AUTUMNAL_VALLEY = new AutumnalValley().getBiome();
    public static final Biome BAOBABSAVANNA = new BaobabSavanna().getBiome();
    public static final Biome BAYOU = new Bayou().getBiome();
    public static final Biome BLUEGIANTTAIGA = new BlueGiantTaiga().getBiome();
    public static final Biome BLUETAIGA = new BlueTaiga().getBiome();
    public static final Biome CIKA_WOODS = new CikaWoods().getBiome();
    public static final Biome BLUFFSTEEPS = new BluffSteeps().getBiome();
    public static final Biome BOG = new Bog().getBiome();
    public static final Biome BOREALFOREST = new BorealForest().getBiome();
    public static final Biome COLDSWAMPLANDS = new ColdSwamplands().getBiome();
    public static final Biome CRAGGARDENS = new CragGardens().getBiome();
    public static final Biome REDROCKCANYON = new Canyons().getBiome();
//    public static final Biome CANYONCORRIDORS = new CanyonCorridors().getBiome();
    public static final Biome CYPRESSSWAMPLANDS = new CypressSwampland().getBiome();
//    public static final Biome DUMMYBIOME = new DummyBiome().getBiome();
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
    public static final Biome SONORANDESERT = new SonoranDesert().getBiome();
    public static final Biome STONEBRUSHLANDS = new StoneBrushlands().getBiome();
    public static final Biome STONEFOREST = new StoneForest().getBiome();
    public static final Biome THE_BLACK_FOREST = new TheBlackForest().getBiome();
    public static final Biome TROPICALFUNGALRAINFOREST = new TropicalFungalRainForest().getBiome();
    public static final Biome TROPICALISLAND = new TropicalIslands().getBiome();
    public static final Biome TROPICALRAINFOREST = new TropicalRainForest().getBiome();
    public static final Biome VIBRANTSWAMPLANDS = new VibrantSwamplands().getBiome();
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
    //    public static final Biome VOLCANO = new Volcano().getBiome();
    public static final Biome ZELKOVAFORESTHILLS = new ZelkovaForestHills().getBiome();

    //Nether
    public static final Biome WARPEDDESERT = new WarpedDesert().getBiome();
    public static final Biome SYTHIANTORRIDS = new SythianTorrids().getBiome();
    public static final Biome GLOWSTONEGARDENS = new GlowstoneGardens().getBiome();
    public static final Biome EMBURBOG = new EmburBog().getBiome();

    //End
    public static final Biome IVISFIELDS = new IvisFields().getBiome();


}
