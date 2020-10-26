package corgiaoc.byg.core.world;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.common.world.biome.BYGNetherBiome;
import corgiaoc.byg.common.world.biome.end.*;
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
import corgiaoc.byg.config.json.biomedata.BiomeData;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class BYGBiomes {
    public static List<Biome> biomeList = new ArrayList<>();

    public static Biome DUMMY_BIOME = WorldGenRegistrationHelper.createBiome("dummy", new DummySubBiome().getBiome());


    /************Primary Biomes************/
    public static Biome ALLIUM_FIELDS = WorldGenRegistrationHelper.createBiome("allium_fields", new AlliumFields().getBiome());
    public static Biome ALPS = WorldGenRegistrationHelper.createBiome("alps", new Alps().getBiome());
    public static Biome AMARANTH_FIELDS = WorldGenRegistrationHelper.createBiome("amaranth_fields", new AmaranthFields().getBiome());
    public static Biome ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("ancient_forest", new AncientForest().getBiome());
    public static Biome ARAUCARIA_SAVANNA = WorldGenRegistrationHelper.createBiome("araucaria_savanna", new AraucariaSavanna().getBiome());
    public static Biome ASPEN_FOREST = WorldGenRegistrationHelper.createBiome("aspen_forest", new AspenForest().getBiome());
    public static Biome AUTUMNAL_VALLEY = WorldGenRegistrationHelper.createBiome("autumnal_valley", new AutumnalValley().getBiome());
    public static Biome BAOBAB_SAVANNA = WorldGenRegistrationHelper.createBiome("baobab_savanna", new BaobabSavanna().getBiome());
    public static Biome BAYOU = WorldGenRegistrationHelper.createBiome("bayou", new Bayou().getBiome());
    public static Biome BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("blue_taiga", new BlueTaiga().getBiome());
    public static Biome BLUFF_STEEPS = WorldGenRegistrationHelper.createBiome("bluff_steeps", new BluffSteeps().getBiome());
    public static Biome BOG = WorldGenRegistrationHelper.createBiome("bog", new Bog().getBiome());
    public static Biome BOREAL_FOREST = WorldGenRegistrationHelper.createBiome("boreal_forest", new BorealForest().getBiome());
    public static Biome CANYONS = WorldGenRegistrationHelper.createBiome("canyons", new Canyons().getBiome());
    public static Biome CIKA_WOODS = WorldGenRegistrationHelper.createBiome("cika_woods", new CikaWoods().getBiome());
    public static Biome COLD_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("cold_swamplands", new ColdSwamplands().getBiome());
    public static Biome CRAG_GARDENS = WorldGenRegistrationHelper.createBiome("crag_gardens", new CragGardens().getBiome());
    public static Biome CYPRESS_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("cypress_swamplands", new CypressSwampland().getBiome());
    public static Biome CHERRY_BLOSSOM_FOREST = WorldGenRegistrationHelper.createBiome("cherry_blossom_forest", new CherryBlossomForest().getBiome());
    public static Biome CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("coniferous_forest", new ConiferousForest().getBiome());
    public static Biome DEAD_SEA = WorldGenRegistrationHelper.createBiome("dead_sea", new DeadSea().getBiome());
    public static Biome DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("deciduous_forest", new DeciduousForest().getBiome());
    public static Biome DOVER_MOUNTAINS = WorldGenRegistrationHelper.createBiome("dover_mountains", new DoverMountains().getBiome());
    public static Biome DUNES = WorldGenRegistrationHelper.createBiome("dunes", new Dunes().getBiome());
    public static Biome EBONY_WOODS = WorldGenRegistrationHelper.createBiome("ebony_woods", new EbonyWoods().getBiome());
    public static Biome ENCHANTED_FOREST = WorldGenRegistrationHelper.createBiome("enchanted_forest", new EnchantedForest().getBiome());
    public static Biome EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("evergreen_taiga", new EvergreenTaiga().getBiome());
    public static Biome GLOWSHROOM_BAYOU = WorldGenRegistrationHelper.createBiome("glowshroom_bayou", new GlowshroomBayou().getBiome());
    public static Biome GRASSLAND_PLATEAU = WorldGenRegistrationHelper.createBiome("grassland_plateau", new GrassLandPlateau().getBiome());
    public static Biome GREAT_LAKES = WorldGenRegistrationHelper.createBiome("great_lakes", new GreatLakes().getBiome());
    public static Biome ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("enchanted_grove", new EnchantedGrove().getBiome());
    public static Biome GROVE = WorldGenRegistrationHelper.createBiome("grove", new Grove().getBiome());
    public static Biome GUIANA_SHIELD = WorldGenRegistrationHelper.createBiome("guiana_shield", new GuianaShield().getBiome());
    public static Biome JACARANDA_FOREST = WorldGenRegistrationHelper.createBiome("jacaranda_forest", new JacarandaForest().getBiome());
    public static Biome MANGROVE_MARSHES = WorldGenRegistrationHelper.createBiome("mangrove_marshes", new MangroveMarshes().getBiome());
    public static Biome MAPLE_TAIGA = WorldGenRegistrationHelper.createBiome("maple_taiga", new MapleTaiga().getBiome());
    public static Biome MARSHLANDS = WorldGenRegistrationHelper.createBiome("marshlands", new MarshLands().getBiome());
    public static Biome MEADOW = WorldGenRegistrationHelper.createBiome("meadow", new Meadow().getBiome());
    public static Biome MOJAVE_DESERT = WorldGenRegistrationHelper.createBiome("mojave_desert", new MojaveDesert().getBiome());
    public static Biome LUSH_TUNDRA = WorldGenRegistrationHelper.createBiome("lush_tundra", new LushTundra().getBiome());
    public static Biome ORCHARD = WorldGenRegistrationHelper.createBiome("orchard", new Orchard().getBiome());
    public static Biome PRAIRIE = WorldGenRegistrationHelper.createBiome("prairie", new Prairie().getBiome());
    public static Biome RED_DESERT = WorldGenRegistrationHelper.createBiome("red_desert", new RedDesert().getBiome());
    public static Biome RED_DESERT_DUNES = WorldGenRegistrationHelper.createBiome("red_desert_dunes", new RedDesertDunes().getBiome());
    public static Biome RED_OAK_FOREST = WorldGenRegistrationHelper.createBiome("red_oak_forest", new RedOakForest().getBiome());
    public static Biome RED_ROCK_MOUNTAINS = WorldGenRegistrationHelper.createBiome("red_rock_mountains", new RedRockMountains().getBiome());
    public static Biome ROSE_FIELDS = WorldGenRegistrationHelper.createBiome("rose_fields", new RoseFields().getBiome());
    public static Biome SEASONAL_BIRCH_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_birch_forest", new SeasonalBirchForest().getBiome());
    public static Biome SEASONAL_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_forest", new SeasonalDeciduousForest().getBiome());
    public static Biome SEASONAL_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_forest", new SeasonalForest().getBiome());
    public static Biome SEASONAL_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_giant_taiga", new SeasonalGiantTaiga().getBiome());
    public static Biome SEASONAL_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_taiga", new SeasonalTaiga().getBiome());
    public static Biome SHATTERED_GLACIER = WorldGenRegistrationHelper.createBiome("shattered_glacier", new ShatteredGlacier().getBiome());
    public static Biome SHRUBLANDS = WorldGenRegistrationHelper.createBiome("shrublands", new ShrubLands().getBiome());
    public static Biome SIERRA_VALLEY = WorldGenRegistrationHelper.createBiome("sierra_valley", new SierraValley().getBiome());
    public static Biome SKYRIS_HIGHLANDS = WorldGenRegistrationHelper.createBiome("skyris_highlands", new SkyrisHighlands().getBiome());
    public static Biome REDWOOD_TROPICS = WorldGenRegistrationHelper.createBiome("redwood_tropics", new RedwoodTropics().getBiome());
    public static Biome SNOWY_BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_taiga", new SnowyBlueTaiga().getBiome());
    public static Biome SNOWY_CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_coniferous_forest", new SnowyConiferousForest().getBiome());
    public static Biome SNOWY_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_deciduous_forest", new SnowyDeciduousForest().getBiome());
    public static Biome SNOWY_EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_evergreen_taiga", new SnowyEvergreenTaiga().getBiome());
    public static Biome STONE_FOREST = WorldGenRegistrationHelper.createBiome("stone_forest", new StoneForest().getBiome());
    public static Biome THE_BLACK_FOREST = WorldGenRegistrationHelper.createBiome("the_black_forest", new TheBlackForest().getBiome());
    public static Biome TROPICAL_FUNGAL_RAINFOREST = WorldGenRegistrationHelper.createBiome("tropical_fungal_forest", new TropicalFungalRainForest().getBiome());
    public static Biome TROPICAL_ISLAND = WorldGenRegistrationHelper.createBiome("tropical_islands", new TropicalIslands().getBiome());
    public static Biome TROPICAL_RAINFOREST = WorldGenRegistrationHelper.createBiome("tropical_rainforest", new TropicalRainForest().getBiome());
    public static Biome TWILIGHT_VALLEY = WorldGenRegistrationHelper.createBiome("twilight_valley", new TwilightValley().getBiome());
//    public static Biome VALLE_DE_LUNA = WorldGenRegistrationHelper.createBiome("valle_de_luna", new ValleDeLuna().getBiome());
    public static Biome VIBRANT_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("vibrant_swamplands", new VibrantSwamplands().getBiome());
//    public static Biome VOLCANO = WorldGenRegistrationHelper.createBiome("volcano", new Volcano().getBiome());
    public static Biome WEEPING_WITCH_FOREST = WorldGenRegistrationHelper.createBiome("weeping_witch_forest", new WeepingWitchForest().getBiome());
    public static Biome WOODLANDS = WorldGenRegistrationHelper.createBiome("woodlands", new WoodLands().getBiome());
    public static Biome ZELKOVA_FOREST = WorldGenRegistrationHelper.createBiome("zelkova_forest", new ZelkovaForest().getBiome());


    /************Sub Biomes************/
    //Beaches
    public static Biome BASALT_BARRERA = WorldGenRegistrationHelper.createBiome("basalt_barrera", new BasaltBarrera().getBiome());
    public static Biome RAINBOW_BEACH = WorldGenRegistrationHelper.createBiome("rainbow_beach", new RainbowBeach().getBiome());
    public static Biome ROCKY_BEACH = WorldGenRegistrationHelper.createBiome("rocky_beach", new RockyBeach().getBiome());
    public static Biome SNOWY_ROCKY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_rocky_black_beach", new SnowyRockyBlackBeach().getBiome());
    public static Biome SNOWY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_black_beach", new SnowyBlackBeach().getBiome());
    public static Biome WHITE_BEACH = WorldGenRegistrationHelper.createBiome("white_beach", new WhiteBeach().getBiome());

    //Clearings
    public static Biome ASPEN_CLEARING = WorldGenRegistrationHelper.createBiome("aspen_clearing", new AspenClearing().getBiome());
    public static Biome BLACK_FOREST_CLEARING = WorldGenRegistrationHelper.createBiome("black_forest_clearing", new BlackForestClearing().getBiome());
    public static Biome BOREAL_CLEARING = WorldGenRegistrationHelper.createBiome("boreal_clearing", new BorealClearing().getBiome());
    public static Biome CHERRY_BLOSSOM_CLEARING = WorldGenRegistrationHelper.createBiome("cherry_blossom_clearing", new CherryBlossomClearing().getBiome());
    public static Biome CONIFEROUS_CLEARING = WorldGenRegistrationHelper.createBiome("coniferous_clearing", new ConiferousClearing().getBiome());
    public static Biome DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("deciduous_clearing", new DeciduousClearing().getBiome());
    public static Biome EVERGREEN_CLEARING = WorldGenRegistrationHelper.createBiome("evergreen_clearing", new EvergreenClearing().getBiome());
    public static Biome GUIANA_CLEARING = WorldGenRegistrationHelper.createBiome("guiana_clearing", new GuianaClearing().getBiome());
    public static Biome JACARANDA_CLEARING = WorldGenRegistrationHelper.createBiome("jacaranda_clearing", new JacarandaClearing().getBiome());
    public static Biome PRAIRIE_CLEARING = WorldGenRegistrationHelper.createBiome("prairie_clearing", new PrairieClearing().getBiome());
    public static Biome REDWOOD_CLEARING = WorldGenRegistrationHelper.createBiome("redwood_clearing", new RedwoodClearing().getBiome());
    public static Biome SEASONAL_DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_clearing", new SeasonalDeciduousClearing().getBiome());
    public static Biome SNOWY_CONIFEROUS_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_coniferous_clearing", new SnowyConiferousClearing().getBiome());
    public static Biome SNOWY_DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_deciduous_clearing", new SnowyDeciduousClearing().getBiome());
    public static Biome SNOWY_EVERGREEN_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_evergreen_clearing", new SnowyEvergreenClearing().getBiome());
    public static Biome WEEPING_WTICH_CLEARING = WorldGenRegistrationHelper.createBiome("weeping_witch_clearing", new WeepingWitchClearing().getBiome());
    public static Biome ZELKOVA_CLEARING = WorldGenRegistrationHelper.createBiome("zelkova_clearing", new ZelkovaClearing().getBiome());

    //Edges
    public static Biome CANYON_EDGE = WorldGenRegistrationHelper.createBiome("canyon_edge", new CanyonEdge().getBiome());

    //Flowering
    public static Biome FLOWERING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("flowering_ancient_forest", new FloweringAncientForest().getBiome());
    public static Biome FLOWERING_ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("flowering_enchanted_grove", new FloweringEnchantedGrove().getBiome());
    public static Biome FLOWERING_GROVE = WorldGenRegistrationHelper.createBiome("flowering_grove", new FloweringGrove().getBiome());
    public static Biome FLOWERING_MEADOW = WorldGenRegistrationHelper.createBiome("flowering_meadow", new FloweringMeadow().getBiome());

    //Forests
    public static Biome ARAUCARIA_FOREST = WorldGenRegistrationHelper.createBiome("araucaria_forest", new AraucariaForest().getBiome());
    public static Biome BAMBOO_FOREST = WorldGenRegistrationHelper.createBiome("bamboo_forest", new BambooForest().getBiome());
    public static Biome FOREST_FAULT = WorldGenRegistrationHelper.createBiome("forest_fault", new ForestFault().getBiome());
    public static Biome GLOWING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("glowing_ancient_forest", new GlowingAncientForest().getBiome());
    public static Biome NORTHERN_FOREST = WorldGenRegistrationHelper.createBiome("northern_forest", new NorthernForest().getBiome());
    public static Biome POINTY_STONE_FOREST = WorldGenRegistrationHelper.createBiome("pointed_stone_forest", new PointedStoneForest().getBiome());
    public static Biome PUMPKIN_FOREST = WorldGenRegistrationHelper.createBiome("pumpkin_forest", new PumpkinForest().getBiome());

    //Hills
    public static Biome ALPINE_FOOTHILLS = WorldGenRegistrationHelper.createBiome("alpine_foothills", new AlpineFoothills().getBiome());
    public static Biome ASPEN_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("aspen_forest_hills", new AspenForestHills().getBiome());
    public static Biome BLACK_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("black_forest_hills", new BlackForestHills().getBiome());
    public static Biome BLUE_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("blue_taiga_hills", new BlueTaigaHills().getBiome());
    public static Biome BOREAL_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("boreal_forest_hills", new BorealForestHills().getBiome());
    public static Biome CONIFEROUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("coniferous_forest_hills", new ConiferousForestHills().getBiome());
    public static Biome DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("deciduous_forest_hills", new DeciduousForestHills().getBiome());
    public static Biome EBONY_HILLS = WorldGenRegistrationHelper.createBiome("ebony_hills", new EbonyHills().getBiome());
    public static Biome ENCHANTED_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("enchanted_forest_hills", new EnchantedForestHills().getBiome());
    public static Biome EVERGREEN_HILLS = WorldGenRegistrationHelper.createBiome("evergreen_hills", new EvergreenHills().getBiome());
    public static Biome JACARANDA_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("jacaranda_forest_hills", new JacarandaForestHills().getBiome());
    public static Biome MAPLE_HILLS = WorldGenRegistrationHelper.createBiome("maple_hills", new MapleHills().getBiome());
    public static Biome RED_OAK_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("red_oak_forest_hills", new RedOakForestHills().getBiome());
    public static Biome SEASONAL_BIRCH_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_birch_forest_hills", new SeasonalBirchForestHills().getBiome());
    public static Biome SEASONAL_DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_forest_hills", new SeasonalDeciduousForestHills().getBiome());
    public static Biome SEASONAL_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_forest_hills", new SeasonalForestHills().getBiome());
    public static Biome SEASONAL_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_taiga_hills", new SeasonalTaigaHills().getBiome());
    public static Biome SNOWY_BLUE_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("snowy_blue_taiga_hills", new SnowyBlueTaigaHills().getBiome());
    public static Biome SNOWY_CONIFEROUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("snowy_coniferous_forest_hills", new SnowyConiferousForestHills().getBiome());
    public static Biome SNOWY_DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("snowy_deciduous_forest_hills", new SnowyDeciduousForestHills().getBiome());
    public static Biome SNOWY_EVERGREEN_HILLS = WorldGenRegistrationHelper.createBiome("snowy_evergreen_hills", new SnowyEvergreenHills().getBiome());
    public static Biome TROPICAL_FUNGAL_RAINFOREST_HILLS = WorldGenRegistrationHelper.createBiome("tropical_fungal_rainforest_hills", new TropicalFungalRainforestHills().getBiome());
    public static Biome TROPICAL_RAINFOREST_HILLS = WorldGenRegistrationHelper.createBiome("tropical_rainforest_hills", new TropicalRainForestHills().getBiome());
    public static Biome TWILIGHT_VALLEY_HILLS = WorldGenRegistrationHelper.createBiome("twilight_valley_hills", new TwilightValleyHills().getBiome());
    public static Biome ZELKOVA_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("zelkova_forest_hills", new ZelkovaForestHills().getBiome());

    //Lakes
    public static Biome FRESH_WATER_LAKE = WorldGenRegistrationHelper.createBiome("fresh_water_lake", new FreshWaterLake().getBiome());
    public static Biome FROZEN_LAKE = WorldGenRegistrationHelper.createBiome("frozen_lake", new FrozenLake().getBiome());
    public static Biome OASIS = WorldGenRegistrationHelper.createBiome("oasis", new Oasis().getBiome());
    public static Biome POLLUTED_LAKE = WorldGenRegistrationHelper.createBiome("polluted_lake", new PollutedLake().getBiome());

    //Mountains
    public static Biome BLUFF_PEAKS = WorldGenRegistrationHelper.createBiome("bluff_peaks", new BluffPeaks().getBiome());
    public static Biome CIKA_MOUNTAINS = WorldGenRegistrationHelper.createBiome("cika_mountains", new CikaMountains().getBiome());
    public static Biome REDWOOD_MOUNTAINS = WorldGenRegistrationHelper.createBiome("redwood_mountains", new RedwoodMountains().getBiome());
    public static Biome WOODED_RED_ROCK_MOUNTAINS = WorldGenRegistrationHelper.createBiome("wooded_red_rock_mountains", new WoodedRedRockMountains().getBiome());

    //Sub
    public static Biome BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("blue_giant_taiga", new BlueGiantTaiga().getBiome());
    public static Biome CORAL_MANGROVES = WorldGenRegistrationHelper.createBiome("coral_mangroves", new CoralMangroves().getBiome());
    public static Biome FUNGAL_PATCH = WorldGenRegistrationHelper.createBiome("fungal_patch", new FungalPatch().getBiome());
    public static Biome GREAT_LAKE_ISLES = WorldGenRegistrationHelper.createBiome("great_lake_isles", new GreatLakeIsles().getBiome());
    public static Biome LUSH_RED_DESERT = WorldGenRegistrationHelper.createBiome("lush_red_desert", new LushRedDesert().getBiome());
    public static Biome RED_ROCK_LOWLANDS = WorldGenRegistrationHelper.createBiome("red_rock_lowlands", new RedRockLowlands().getBiome());
    public static Biome RED_ROCK_HIGHLANDS = WorldGenRegistrationHelper.createBiome("red_rock_highlands", new RedRockHighlands().getBiome());
    public static Biome RED_SPRUCE_TAIGA = WorldGenRegistrationHelper.createBiome("red_spruce_taiga", new RedSpruceTaiga().getBiome());
    public static Biome SIERRA_RANGE = WorldGenRegistrationHelper.createBiome("sierra_range", new SierraRange().getBiome());
    public static Biome WOODED_GRASSLAND_PLATEAU = WorldGenRegistrationHelper.createBiome("wooded_grassland_plateau", new WoodedGrasslandPlateau().getBiome());
    public static Biome SNOWY_BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_giant_taiga", new SnowyBlueGiantTaiga().getBiome());
    public static Biome WOODED_MEADOW = WorldGenRegistrationHelper.createBiome("wooded_meadow", new WoodedMeadow().getBiome());


    /************Nether Biomes************/
    public static Biome BRIMSTONE_CAVERNS = WorldGenRegistrationHelper.createBiome("brimstone_caverns", new BrimstoneCaverns().getBiome());
    public static Biome CRIMSON_GARDENS = WorldGenRegistrationHelper.createBiome("crimson_gardens", new CrimsonGardens().getBiome());
    public static Biome EMBUR_BOG = WorldGenRegistrationHelper.createBiome("embur_bog", new EmburBog().getBiome());
    public static Biome GLOWSTONE_GARDENS = WorldGenRegistrationHelper.createBiome("glowstone_gardens", new GlowstoneGardens().getBiome());
    public static Biome MAGMA_WASTES = WorldGenRegistrationHelper.createBiome("magma_wastes", new MagmaWastes().getBiome());
    public static Biome SUBZERO_HYPOGEAL = WorldGenRegistrationHelper.createBiome("subzero_hypogeal", new SubzeroHypogeal().getBiome());
    public static Biome SYTHIAN_TORRIDS = WorldGenRegistrationHelper.createBiome("sythian_torrids", new SythianTorrids().getBiome());
    public static Biome WARPED_DESERT = WorldGenRegistrationHelper.createBiome("warped_desert", new WarpedDesert().getBiome());
    public static Biome WAILING_GARTH = WorldGenRegistrationHelper.createBiome("wailing_garth", new WailingGarth().getBiome());
    public static Biome WITHERING_WOODS = WorldGenRegistrationHelper.createBiome("withering_woods", new WitheringWoods().getBiome());
    public static Biome WEEPING_MIRE = WorldGenRegistrationHelper.createBiome("weeping_mire", new WeepingMire().getBiome());
    public static Biome QUARTZ_DESERT = WorldGenRegistrationHelper.createBiome("quartz_desert", new QuartzDesert().getBiome());


    /************End Biomes************/
    public static Biome IVIS_FIELDS = WorldGenRegistrationHelper.createBiome("ivis_fields", new IvisFields().getBiome());
    public static Biome NIGHTSHADE_FOREST = WorldGenRegistrationHelper.createBiome("nightshade_forest", new NightshadeForest().getBiome());
    public static Biome ETHEREAL_ISLANDS = WorldGenRegistrationHelper.createBiome("ethereal_islands", new EtherealIslands().getBiome());
    public static Biome VISCAL_ISLES = WorldGenRegistrationHelper.createBiome("viscal_isles", new ViscalIsles().getBiome());
    public static Biome BULBIS_GARDENS = WorldGenRegistrationHelper.createBiome("bulbis_gardens", new BulbisGardens().getBiome());
    public static Biome SHATTERED_DESERT = WorldGenRegistrationHelper.createBiome("shattered_desert", new ShatteredDesert().getBiome());
    public static Biome SHULKREN_FOREST = WorldGenRegistrationHelper.createBiome("shulkren_forest", new ShulkrenForest().getBiome());
    public static Biome PURPUR_PEAKS = WorldGenRegistrationHelper.createBiome("purpur_peaks", new PurpurPeaks().getBiome());
    public static Biome CRYPTIC_WASTES = WorldGenRegistrationHelper.createBiome("cryptic_wastes", new CrypticWastes().getBiome());


    public static void init() {//This was done desperately...
        ALLIUM_FIELDS = WorldGenRegistrationHelper.createBiome("allium_fields", new AlliumFields().getBiome());
        ALPS = WorldGenRegistrationHelper.createBiome("alps", new Alps().getBiome());
        AMARANTH_FIELDS = WorldGenRegistrationHelper.createBiome("amaranth_fields", new AmaranthFields().getBiome());
        ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("ancient_forest", new AncientForest().getBiome());
        ARAUCARIA_SAVANNA = WorldGenRegistrationHelper.createBiome("araucaria_savanna", new AraucariaSavanna().getBiome());
        ASPEN_FOREST = WorldGenRegistrationHelper.createBiome("aspen_forest", new AspenForest().getBiome());
        AUTUMNAL_VALLEY = WorldGenRegistrationHelper.createBiome("autumnal_valley", new AutumnalValley().getBiome());
        BAOBAB_SAVANNA = WorldGenRegistrationHelper.createBiome("baobab_savanna", new BaobabSavanna().getBiome());
        BAYOU = WorldGenRegistrationHelper.createBiome("bayou", new Bayou().getBiome());
        BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("blue_taiga", new BlueTaiga().getBiome());
        BLUFF_STEEPS = WorldGenRegistrationHelper.createBiome("bluff_steeps", new BluffSteeps().getBiome());
        BOG = WorldGenRegistrationHelper.createBiome("bog", new Bog().getBiome());
        BOREAL_FOREST = WorldGenRegistrationHelper.createBiome("boreal_forest", new BorealForest().getBiome());
        CANYONS = WorldGenRegistrationHelper.createBiome("canyons", new Canyons().getBiome());
        CIKA_WOODS = WorldGenRegistrationHelper.createBiome("cika_woods", new CikaWoods().getBiome());
        COLD_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("cold_swamplands", new ColdSwamplands().getBiome());
        CRAG_GARDENS = WorldGenRegistrationHelper.createBiome("crag_gardens", new CragGardens().getBiome());
        CYPRESS_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("cypress_swamplands", new CypressSwampland().getBiome());
        CHERRY_BLOSSOM_FOREST = WorldGenRegistrationHelper.createBiome("cherry_blossom_forest", new CherryBlossomForest().getBiome());
        CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("coniferous_forest", new ConiferousForest().getBiome());
        DEAD_SEA = WorldGenRegistrationHelper.createBiome("dead_sea", new DeadSea().getBiome());
        DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("deciduous_forest", new DeciduousForest().getBiome());
        DOVER_MOUNTAINS = WorldGenRegistrationHelper.createBiome("dover_mountains", new DoverMountains().getBiome());
        DUNES = WorldGenRegistrationHelper.createBiome("dunes", new Dunes().getBiome());
        EBONY_WOODS = WorldGenRegistrationHelper.createBiome("ebony_woods", new EbonyWoods().getBiome());
        ENCHANTED_FOREST = WorldGenRegistrationHelper.createBiome("enchanted_forest", new EnchantedForest().getBiome());
        EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("evergreen_taiga", new EvergreenTaiga().getBiome());
        GLOWSHROOM_BAYOU = WorldGenRegistrationHelper.createBiome("glowshroom_bayou", new GlowshroomBayou().getBiome());
        GRASSLAND_PLATEAU = WorldGenRegistrationHelper.createBiome("grassland_plateau", new GrassLandPlateau().getBiome());
        GREAT_LAKES = WorldGenRegistrationHelper.createBiome("great_lakes", new GreatLakes().getBiome());
        ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("enchanted_grove", new EnchantedGrove().getBiome());
        GROVE = WorldGenRegistrationHelper.createBiome("grove", new Grove().getBiome());
        GUIANA_SHIELD = WorldGenRegistrationHelper.createBiome("guiana_shield", new GuianaShield().getBiome());
        JACARANDA_FOREST = WorldGenRegistrationHelper.createBiome("jacaranda_forest", new JacarandaForest().getBiome());
        MANGROVE_MARSHES = WorldGenRegistrationHelper.createBiome("mangrove_marshes", new MangroveMarshes().getBiome());
        MAPLE_TAIGA = WorldGenRegistrationHelper.createBiome("maple_taiga", new MapleTaiga().getBiome());
        MARSHLANDS = WorldGenRegistrationHelper.createBiome("marshlands", new MarshLands().getBiome());
        MEADOW = WorldGenRegistrationHelper.createBiome("meadow", new Meadow().getBiome());
        MOJAVE_DESERT = WorldGenRegistrationHelper.createBiome("mojave_desert", new MojaveDesert().getBiome());
        LUSH_TUNDRA = WorldGenRegistrationHelper.createBiome("lush_tundra", new LushTundra().getBiome());
        ORCHARD = WorldGenRegistrationHelper.createBiome("orchard", new Orchard().getBiome());
        PRAIRIE = WorldGenRegistrationHelper.createBiome("prairie", new Prairie().getBiome());
        RED_DESERT = WorldGenRegistrationHelper.createBiome("red_desert", new RedDesert().getBiome());
        RED_DESERT_DUNES = WorldGenRegistrationHelper.createBiome("red_desert_dunes", new RedDesertDunes().getBiome());
        RED_OAK_FOREST = WorldGenRegistrationHelper.createBiome("red_oak_forest", new RedOakForest().getBiome());
        RED_ROCK_MOUNTAINS = WorldGenRegistrationHelper.createBiome("red_rock_mountains", new RedRockMountains().getBiome());
        ROSE_FIELDS = WorldGenRegistrationHelper.createBiome("rose_fields", new RoseFields().getBiome());
        SEASONAL_BIRCH_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_birch_forest", new SeasonalBirchForest().getBiome());
        SEASONAL_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_forest", new SeasonalDeciduousForest().getBiome());
        SEASONAL_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_forest", new SeasonalForest().getBiome());
        SEASONAL_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_giant_taiga", new SeasonalGiantTaiga().getBiome());
        SEASONAL_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_taiga", new SeasonalTaiga().getBiome());
        SHATTERED_GLACIER = WorldGenRegistrationHelper.createBiome("shattered_glacier", new ShatteredGlacier().getBiome());
        SHRUBLANDS = WorldGenRegistrationHelper.createBiome("shrublands", new ShrubLands().getBiome());
        SIERRA_VALLEY = WorldGenRegistrationHelper.createBiome("sierra_valley", new SierraValley().getBiome());
        SKYRIS_HIGHLANDS = WorldGenRegistrationHelper.createBiome("skyris_highlands", new SkyrisHighlands().getBiome());
        REDWOOD_TROPICS = WorldGenRegistrationHelper.createBiome("redwood_tropics", new RedwoodTropics().getBiome());
        SNOWY_BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_taiga", new SnowyBlueTaiga().getBiome());
        SNOWY_CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_coniferous_forest", new SnowyConiferousForest().getBiome());
        SNOWY_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_deciduous_forest", new SnowyDeciduousForest().getBiome());
        SNOWY_EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_evergreen_taiga", new SnowyEvergreenTaiga().getBiome());
        STONE_FOREST = WorldGenRegistrationHelper.createBiome("stone_forest", new StoneForest().getBiome());
        THE_BLACK_FOREST = WorldGenRegistrationHelper.createBiome("the_black_forest", new TheBlackForest().getBiome());
        TROPICAL_FUNGAL_RAINFOREST = WorldGenRegistrationHelper.createBiome("tropical_fungal_forest", new TropicalFungalRainForest().getBiome());
        TROPICAL_ISLAND = WorldGenRegistrationHelper.createBiome("tropical_islands", new TropicalIslands().getBiome());
        TROPICAL_RAINFOREST = WorldGenRegistrationHelper.createBiome("tropical_rainforest", new TropicalRainForest().getBiome());
        TWILIGHT_VALLEY = WorldGenRegistrationHelper.createBiome("twilight_valley", new TwilightValley().getBiome());
        VIBRANT_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("vibrant_swamplands", new VibrantSwamplands().getBiome());
        WEEPING_WITCH_FOREST = WorldGenRegistrationHelper.createBiome("weeping_witch_forest", new WeepingWitchForest().getBiome());
        WOODLANDS = WorldGenRegistrationHelper.createBiome("woodlands", new WoodLands().getBiome());
        ZELKOVA_FOREST = WorldGenRegistrationHelper.createBiome("zelkova_forest", new ZelkovaForest().getBiome());


        BASALT_BARRERA = WorldGenRegistrationHelper.createBiome("basalt_barrera", new BasaltBarrera().getBiome());
        RAINBOW_BEACH = WorldGenRegistrationHelper.createBiome("rainbow_beach", new RainbowBeach().getBiome());
        ROCKY_BEACH = WorldGenRegistrationHelper.createBiome("rocky_beach", new RockyBeach().getBiome());
        SNOWY_ROCKY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_rocky_black_beach", new SnowyRockyBlackBeach().getBiome());
        SNOWY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_black_beach", new SnowyBlackBeach().getBiome());
        WHITE_BEACH = WorldGenRegistrationHelper.createBiome("white_beach", new WhiteBeach().getBiome());


        ASPEN_CLEARING = WorldGenRegistrationHelper.createBiome("aspen_clearing", new AspenClearing().getBiome());
        BLACK_FOREST_CLEARING = WorldGenRegistrationHelper.createBiome("black_forest_clearing", new BlackForestClearing().getBiome());
        BOREAL_CLEARING = WorldGenRegistrationHelper.createBiome("boreal_clearing", new BorealClearing().getBiome());
        CHERRY_BLOSSOM_CLEARING = WorldGenRegistrationHelper.createBiome("cherry_blossom_clearing", new CherryBlossomClearing().getBiome());
        CONIFEROUS_CLEARING = WorldGenRegistrationHelper.createBiome("coniferous_clearing", new ConiferousClearing().getBiome());
        DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("deciduous_clearing", new DeciduousClearing().getBiome());
        EVERGREEN_CLEARING = WorldGenRegistrationHelper.createBiome("evergreen_clearing", new EvergreenClearing().getBiome());
        GUIANA_CLEARING = WorldGenRegistrationHelper.createBiome("guiana_clearing", new GuianaClearing().getBiome());
        JACARANDA_CLEARING = WorldGenRegistrationHelper.createBiome("jacaranda_clearing", new JacarandaClearing().getBiome());
        PRAIRIE_CLEARING = WorldGenRegistrationHelper.createBiome("prairie_clearing", new PrairieClearing().getBiome());
        REDWOOD_CLEARING = WorldGenRegistrationHelper.createBiome("redwood_clearing", new RedwoodClearing().getBiome());
        SEASONAL_DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_clearing", new SeasonalDeciduousClearing().getBiome());
        SNOWY_CONIFEROUS_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_coniferous_clearing", new SnowyConiferousClearing().getBiome());
        SNOWY_DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_deciduous_clearing", new SnowyDeciduousClearing().getBiome());
        SNOWY_EVERGREEN_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_evergreen_clearing", new SnowyEvergreenClearing().getBiome());
        WEEPING_WTICH_CLEARING = WorldGenRegistrationHelper.createBiome("weeping_witch_clearing", new WeepingWitchClearing().getBiome());
        ZELKOVA_CLEARING = WorldGenRegistrationHelper.createBiome("zelkova_clearing", new ZelkovaClearing().getBiome());


        CANYON_EDGE = WorldGenRegistrationHelper.createBiome("canyon_edge", new CanyonEdge().getBiome());


        FLOWERING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("flowering_ancient_forest", new FloweringAncientForest().getBiome());
        FLOWERING_ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("flowering_enchanted_grove", new FloweringEnchantedGrove().getBiome());
        FLOWERING_GROVE = WorldGenRegistrationHelper.createBiome("flowering_grove", new FloweringGrove().getBiome());
        FLOWERING_MEADOW = WorldGenRegistrationHelper.createBiome("flowering_meadow", new FloweringMeadow().getBiome());


        ARAUCARIA_FOREST = WorldGenRegistrationHelper.createBiome("araucaria_forest", new AraucariaForest().getBiome());
        BAMBOO_FOREST = WorldGenRegistrationHelper.createBiome("bamboo_forest", new BambooForest().getBiome());
        FOREST_FAULT = WorldGenRegistrationHelper.createBiome("forest_fault", new ForestFault().getBiome());
        GLOWING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("glowing_ancient_forest", new GlowingAncientForest().getBiome());
        NORTHERN_FOREST = WorldGenRegistrationHelper.createBiome("northern_forest", new NorthernForest().getBiome());
        POINTY_STONE_FOREST = WorldGenRegistrationHelper.createBiome("pointed_stone_forest", new PointedStoneForest().getBiome());
        PUMPKIN_FOREST = WorldGenRegistrationHelper.createBiome("pumpkin_forest", new PumpkinForest().getBiome());


        ALPINE_FOOTHILLS = WorldGenRegistrationHelper.createBiome("alpine_foothills", new AlpineFoothills().getBiome());
        ASPEN_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("aspen_forest_hills", new AspenForestHills().getBiome());
        BLACK_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("black_forest_hills", new BlackForestHills().getBiome());
        BLUE_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("blue_taiga_hills", new BlueTaigaHills().getBiome());
        BOREAL_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("boreal_forest_hills", new BorealForestHills().getBiome());
        CONIFEROUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("coniferous_forest_hills", new ConiferousForestHills().getBiome());
        DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("deciduous_forest_hills", new DeciduousForestHills().getBiome());
        EBONY_HILLS = WorldGenRegistrationHelper.createBiome("ebony_hills", new EbonyHills().getBiome());
        ENCHANTED_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("enchanted_forest_hills", new EnchantedForestHills().getBiome());
        EVERGREEN_HILLS = WorldGenRegistrationHelper.createBiome("evergreen_hills", new EvergreenHills().getBiome());
        JACARANDA_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("jacaranda_forest_hills", new JacarandaForestHills().getBiome());
        MAPLE_HILLS = WorldGenRegistrationHelper.createBiome("maple_hills", new MapleHills().getBiome());
        RED_OAK_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("red_oak_forest_hills", new RedOakForestHills().getBiome());
        SEASONAL_BIRCH_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_birch_forest_hills", new SeasonalBirchForestHills().getBiome());
        SEASONAL_DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_forest_hills", new SeasonalDeciduousForestHills().getBiome());
        SEASONAL_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_forest_hills", new SeasonalForestHills().getBiome());
        SEASONAL_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_taiga_hills", new SeasonalTaigaHills().getBiome());
        SNOWY_BLUE_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("snowy_blue_taiga_hills", new SnowyBlueTaigaHills().getBiome());
        SNOWY_CONIFEROUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("snowy_coniferous_forest_hills", new SnowyConiferousForestHills().getBiome());
        SNOWY_DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("snowy_deciduous_forest_hills", new SnowyDeciduousForestHills().getBiome());
        SNOWY_EVERGREEN_HILLS = WorldGenRegistrationHelper.createBiome("snowy_evergreen_hills", new SnowyEvergreenHills().getBiome());
        TROPICAL_FUNGAL_RAINFOREST_HILLS = WorldGenRegistrationHelper.createBiome("tropical_fungal_rainforest_hills", new TropicalFungalRainforestHills().getBiome());
        TROPICAL_RAINFOREST_HILLS = WorldGenRegistrationHelper.createBiome("tropical_rainforest_hills", new TropicalRainForestHills().getBiome());
        TWILIGHT_VALLEY_HILLS = WorldGenRegistrationHelper.createBiome("twilight_valley_hills", new TwilightValleyHills().getBiome());
        ZELKOVA_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("zelkova_forest_hills", new ZelkovaForestHills().getBiome());


        FRESH_WATER_LAKE = WorldGenRegistrationHelper.createBiome("fresh_water_lake", new FreshWaterLake().getBiome());
        FROZEN_LAKE = WorldGenRegistrationHelper.createBiome("frozen_lake", new FrozenLake().getBiome());
        OASIS = WorldGenRegistrationHelper.createBiome("oasis", new Oasis().getBiome());
        POLLUTED_LAKE = WorldGenRegistrationHelper.createBiome("polluted_lake", new PollutedLake().getBiome());


        BLUFF_PEAKS = WorldGenRegistrationHelper.createBiome("bluff_peaks", new BluffPeaks().getBiome());
        CIKA_MOUNTAINS = WorldGenRegistrationHelper.createBiome("cika_mountains", new CikaMountains().getBiome());
        REDWOOD_MOUNTAINS = WorldGenRegistrationHelper.createBiome("redwood_mountains", new RedwoodMountains().getBiome());
        WOODED_RED_ROCK_MOUNTAINS = WorldGenRegistrationHelper.createBiome("wooded_red_rock_mountains", new WoodedRedRockMountains().getBiome());


        BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("blue_giant_taiga", new BlueGiantTaiga().getBiome());
        CORAL_MANGROVES = WorldGenRegistrationHelper.createBiome("coral_mangroves", new CoralMangroves().getBiome());
        FUNGAL_PATCH = WorldGenRegistrationHelper.createBiome("fungal_patch", new FungalPatch().getBiome());
        GREAT_LAKE_ISLES = WorldGenRegistrationHelper.createBiome("great_lake_isles", new GreatLakeIsles().getBiome());
        LUSH_RED_DESERT = WorldGenRegistrationHelper.createBiome("lush_red_desert", new LushRedDesert().getBiome());
        RED_ROCK_LOWLANDS = WorldGenRegistrationHelper.createBiome("red_rock_lowlands", new RedRockLowlands().getBiome());
        RED_ROCK_HIGHLANDS = WorldGenRegistrationHelper.createBiome("red_rock_highlands", new RedRockHighlands().getBiome());
        RED_SPRUCE_TAIGA = WorldGenRegistrationHelper.createBiome("red_spruce_taiga", new RedSpruceTaiga().getBiome());
        SIERRA_RANGE = WorldGenRegistrationHelper.createBiome("sierra_range", new SierraRange().getBiome());
        WOODED_GRASSLAND_PLATEAU = WorldGenRegistrationHelper.createBiome("wooded_grassland_plateau", new WoodedGrasslandPlateau().getBiome());
        SNOWY_BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_giant_taiga", new SnowyBlueGiantTaiga().getBiome());
        WOODED_MEADOW = WorldGenRegistrationHelper.createBiome("wooded_meadow", new WoodedMeadow().getBiome());

        BRIMSTONE_CAVERNS = WorldGenRegistrationHelper.createBiome("brimstone_caverns", new BrimstoneCaverns().getBiome());
        CRIMSON_GARDENS = WorldGenRegistrationHelper.createBiome("crimson_gardens", new CrimsonGardens().getBiome());
        EMBUR_BOG = WorldGenRegistrationHelper.createBiome("embur_bog", new EmburBog().getBiome());
        GLOWSTONE_GARDENS = WorldGenRegistrationHelper.createBiome("glowstone_gardens", new GlowstoneGardens().getBiome());
        MAGMA_WASTES = WorldGenRegistrationHelper.createBiome("magma_wastes", new MagmaWastes().getBiome());
        SUBZERO_HYPOGEAL = WorldGenRegistrationHelper.createBiome("subzero_hypogeal", new SubzeroHypogeal().getBiome());
        SYTHIAN_TORRIDS = WorldGenRegistrationHelper.createBiome("sythian_torrids", new SythianTorrids().getBiome());
        WARPED_DESERT = WorldGenRegistrationHelper.createBiome("warped_desert", new WarpedDesert().getBiome());
        WAILING_GARTH = WorldGenRegistrationHelper.createBiome("wailing_garth", new WailingGarth().getBiome());
        WITHERING_WOODS = WorldGenRegistrationHelper.createBiome("withering_woods", new WitheringWoods().getBiome());
        WEEPING_MIRE = WorldGenRegistrationHelper.createBiome("weeping_mire", new WeepingMire().getBiome());
        QUARTZ_DESERT = WorldGenRegistrationHelper.createBiome("quartz_desert", new QuartzDesert().getBiome());

        IVIS_FIELDS = WorldGenRegistrationHelper.createBiome("ivis_fields", new IvisFields().getBiome());
        NIGHTSHADE_FOREST = WorldGenRegistrationHelper.createBiome("nightshade_forest", new NightshadeForest().getBiome());
        ETHEREAL_ISLANDS = WorldGenRegistrationHelper.createBiome("ethereal_islands", new EtherealIslands().getBiome());
        VISCAL_ISLES = WorldGenRegistrationHelper.createBiome("viscal_isles", new ViscalIsles().getBiome());
        BULBIS_GARDENS = WorldGenRegistrationHelper.createBiome("bulbis_gardens", new BulbisGardens().getBiome());
        SHATTERED_DESERT = WorldGenRegistrationHelper.createBiome("shattered_desert", new ShatteredDesert().getBiome());
        SHULKREN_FOREST = WorldGenRegistrationHelper.createBiome("shulkren_forest", new ShulkrenForest().getBiome());
        PURPUR_PEAKS = WorldGenRegistrationHelper.createBiome("purpur_peaks", new PurpurPeaks().getBiome());
        CRYPTIC_WASTES = WorldGenRegistrationHelper.createBiome("cryptic_wastes", new CrypticWastes().getBiome());
    }

    public static void addBiomeEntries() {
        for (BiomeData biomeData : BYGBiome.biomeData) {
            if (biomeData.getBiomeWeight() > 0) {
                BiomeManager.addBiome(biomeData.getBiomeType(), new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biomeData.getBiome())), biomeData.getBiomeWeight()));
            }
        }
    }

    public static void fillBiomeDictionary() {
        for (BiomeData bygBiome : BYGBiome.biomeData) {
            BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(bygBiome.getBiome())), bygBiome.getDictionaryTypes());
        }
        for (BYGNetherBiome bygNetherBiome : BYGNetherBiome.BYG_NETHER_BIOMES)
            BiomeDictionary.addTypes(bygNetherBiome.getKey(), bygNetherBiome.getBiomeDictionary());
        for (BYGEndBiome bygEndBiome : BYGEndBiome.BYG_END_BIOMES)
            BiomeDictionary.addTypes(bygEndBiome.getKey(), bygEndBiome.getBiomeDictionary());
    }

    public static void addBYGFeaturesToBiomes(Biome biome) {
            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NONE) {
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.ORE_ROCKY_STONE);
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.ORE_SCORIA_STONE);
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.ORE_SOAP_STONE);

                if (biome == WorldGenRegistries.BIOME.getValueForKey(Biomes.SOUL_SAND_VALLEY)) {
                    addFeatureToBiome(biome, GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SOUL_SHROOM_SPORES);
                }

                if (biome == WorldGenRegistries.BIOME.getValueForKey(Biomes.BEACH)) {
                    addFeatureToBiome(biome, GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PALM_TREE);
                }
            }
    }

    //Use these to add our features to vanilla's biomes.
    public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration feature, ConfiguredFeature<?, ?> configuredFeature) {
        ConvertImmutableFeatures(biome);
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = biome.getGenerationSettings().features;
        while (biomeFeatures.size() <= feature.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        biomeFeatures.get(feature.ordinal()).add(() -> configuredFeature);
    }

    private static void ConvertImmutableFeatures(Biome biome) {
        if (biome.getGenerationSettings().features instanceof ImmutableList) {
            biome.getGenerationSettings().features = biome.getGenerationSettings().features.stream().map(Lists::newArrayList).collect(Collectors.toList());
        }
    }
}
