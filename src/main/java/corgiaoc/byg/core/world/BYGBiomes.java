package corgiaoc.byg.core.world;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.end.*;
import corgiaoc.byg.common.world.biome.end.sub.ShatteredViscalIsles;
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
import corgiaoc.byg.config.biomeweight.ConfigWeightManager;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class BYGBiomes {
    public static List<Biome> biomeList = new ArrayList<>();

//    public static final Biome DUMMY_BIOME = WorldGenRegistrationHelper.createBiome("dummy", new DummyBiome().getBiome());


    /************Primary Biomes************/
    public static final Biome ALLIUM_FIELDS = WorldGenRegistrationHelper.createBiome("allium_fields", new AlliumFields().getBiome());
    public static final Biome ALPS = WorldGenRegistrationHelper.createBiome("alps", new Alps().getBiome());
    public static final Biome AMARANTH_FIELDS = WorldGenRegistrationHelper.createBiome("amaranth_fields", new AmaranthFields().getBiome());
    public static final Biome ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("ancient_forest", new AncientForest().getBiome());
    public static final Biome ARAUCARIA_SAVANNA = WorldGenRegistrationHelper.createBiome("araucaria_savanna", new AraucariaSavanna().getBiome());
    public static final Biome ASPEN_FOREST = WorldGenRegistrationHelper.createBiome("aspen_forest", new AspenForest().getBiome());
    public static final Biome AUTUMNAL_VALLEY = WorldGenRegistrationHelper.createBiome("autumnal_valley", new AutumnalValley().getBiome());
    public static final Biome BAOBAB_SAVANNA = WorldGenRegistrationHelper.createBiome("baobab_savanna", new BaobabSavanna().getBiome());
    public static final Biome BAYOU = WorldGenRegistrationHelper.createBiome("bayou", new Bayou().getBiome());
    public static final Biome BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("blue_taiga", new BlueTaiga().getBiome());
    //    public static final Biome COLOSSAL_ICE_SPIKES = WorldGenRegistrationHelper.createBiome("colossal_ice_spikes", new ColossalIceSpikes().getBiome());
    public static final Biome BLUFF_STEEPS = WorldGenRegistrationHelper.createBiome("bluff_steeps", new BluffSteeps().getBiome());
    public static final Biome BOG = WorldGenRegistrationHelper.createBiome("bog", new Bog().getBiome());
    public static final Biome BOREAL_FOREST = WorldGenRegistrationHelper.createBiome("boreal_forest", new BorealForest().getBiome());
    public static final Biome CANYONS = WorldGenRegistrationHelper.createBiome("canyons", new Canyons().getBiome());
    public static final Biome CIKA_WOODS = WorldGenRegistrationHelper.createBiome("cika_woods", new CikaWoods().getBiome());
    public static final Biome COLD_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("cold_swamplands", new ColdSwamplands().getBiome());
    public static final Biome CRAG_GARDENS = WorldGenRegistrationHelper.createBiome("crag_gardens", new CragGardens().getBiome());
    public static final Biome CYPRESS_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("cypress_swamplands", new CypressSwampland().getBiome());
    public static final Biome CHERRY_BLOSSOM_FOREST = WorldGenRegistrationHelper.createBiome("cherry_blossom_forest", new CherryBlossomForest().getBiome());
    public static final Biome CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("coniferous_forest", new ConiferousForest().getBiome());
    public static final Biome DEAD_SEA = WorldGenRegistrationHelper.createBiome("dead_sea", new DeadSea().getBiome());
    public static final Biome DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("deciduous_forest", new DeciduousForest().getBiome());
    public static final Biome DOVER_MOUNTAINS = WorldGenRegistrationHelper.createBiome("dover_mountains", new DoverMountains().getBiome());
    public static final Biome DUNES = WorldGenRegistrationHelper.createBiome("dunes", new Dunes().getBiome());
    public static final Biome EBONY_WOODS = WorldGenRegistrationHelper.createBiome("ebony_woods", new EbonyWoods().getBiome());
    public static final Biome ENCHANTED_FOREST = WorldGenRegistrationHelper.createBiome("enchanted_forest", new EnchantedForest().getBiome());
    public static final Biome EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("evergreen_taiga", new EvergreenTaiga().getBiome());
    public static final Biome GLOWSHROOM_BAYOU = WorldGenRegistrationHelper.createBiome("glowshroom_bayou", new GlowShroomBayou().getBiome());
    public static final Biome GRASSLAND_PLATEAU = WorldGenRegistrationHelper.createBiome("grassland_plateau", new GrassLandPlateau().getBiome());
    public static final Biome GREAT_LAKES = WorldGenRegistrationHelper.createBiome("great_lakes", new GreatLakes().getBiome());
    public static final Biome ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("enchanted_grove", new EnchantedGrove().getBiome());
    public static final Biome GROVE = WorldGenRegistrationHelper.createBiome("grove", new Grove().getBiome());
    public static final Biome GUIANA_SHIELD = WorldGenRegistrationHelper.createBiome("guiana_shield", new GuianaShield().getBiome());
    public static final Biome JACARANDA_FOREST = WorldGenRegistrationHelper.createBiome("jacaranda_forest", new JacarandaForest().getBiome());
    public static final Biome MANGROVE_MARSHES = WorldGenRegistrationHelper.createBiome("mangrove_marshes", new MangroveMarshes().getBiome());
    public static final Biome MAPLE_TAIGA = WorldGenRegistrationHelper.createBiome("maple_taiga", new MapleTaiga().getBiome());
    public static final Biome MARSHLANDS = WorldGenRegistrationHelper.createBiome("marshlands", new MarshLands().getBiome());
    public static final Biome MEADOW = WorldGenRegistrationHelper.createBiome("meadow", new Meadow().getBiome());
    public static final Biome MOJAVE_DESERT = WorldGenRegistrationHelper.createBiome("mojave_desert", new MojaveDesert().getBiome());
    public static final Biome LUSH_TUNDRA = WorldGenRegistrationHelper.createBiome("lush_tundra", new LushTundra().getBiome());
    public static final Biome ORCHARD = WorldGenRegistrationHelper.createBiome("orchard", new Orchard().getBiome());
    public static final Biome PRAIRIE = WorldGenRegistrationHelper.createBiome("prairie", new Prairie().getBiome());
    public static final Biome RED_DESERT = WorldGenRegistrationHelper.createBiome("red_desert", new RedDesert().getBiome());
    public static final Biome RED_DESERT_DUNES = WorldGenRegistrationHelper.createBiome("red_desert_dunes", new RedDesertDunes().getBiome());
    public static final Biome RED_OAK_FOREST = WorldGenRegistrationHelper.createBiome("red_oak_forest", new RedOakForest().getBiome());
    public static final Biome RED_ROCK_MOUNTAINS = WorldGenRegistrationHelper.createBiome("red_rock_mountains", new RedRockMountains().getBiome());
    public static final Biome ROSE_FIELDS = WorldGenRegistrationHelper.createBiome("rose_fields", new RoseFields().getBiome());
    public static final Biome SEASONAL_BIRCH_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_birch_forest", new SeasonalBirchForest().getBiome());
    public static final Biome SEASONAL_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_forest", new SeasonalDeciduousForest().getBiome());
    public static final Biome SEASONAL_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_forest", new SeasonalForest().getBiome());
    public static final Biome SEASONAL_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_giant_taiga", new SeasonalGiantTaiga().getBiome());
    public static final Biome SEASONAL_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_taiga", new SeasonalTaiga().getBiome());
    public static final Biome SHATTERED_GLACIER = WorldGenRegistrationHelper.createBiome("shattered_glacier", new ShatteredGlacier().getBiome());
    public static final Biome SHRUBLANDS = WorldGenRegistrationHelper.createBiome("shrublands", new ShrubLands().getBiome());
    public static final Biome SIERRA_VALLEY = WorldGenRegistrationHelper.createBiome("sierra_valley", new SierraValley().getBiome());
    public static final Biome SKYRIS_HIGHLANDS = WorldGenRegistrationHelper.createBiome("skyris_highlands", new SkyrisHighlands().getBiome());
    public static final Biome REDWOOD_TROPICS = WorldGenRegistrationHelper.createBiome("redwood_tropics", new RedwoodTropics().getBiome());
    public static final Biome SNOWY_BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_taiga", new SnowyBlueTaiga().getBiome());
    public static final Biome SNOWY_CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_coniferous_forest", new SnowyConiferousForest().getBiome());
    public static final Biome SNOWY_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_deciduous_forest", new SnowyDeciduousForest().getBiome());
    public static final Biome SNOWY_EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_evergreen_taiga", new SnowyEvergreenTaiga().getBiome());
    public static final Biome STONE_FOREST = WorldGenRegistrationHelper.createBiome("stone_forest", new StoneForest().getBiome());
    public static final Biome THE_BLACK_FOREST = WorldGenRegistrationHelper.createBiome("the_black_forest", new TheBlackForest().getBiome());
    public static final Biome TROPICAL_FUNGAL_RAINFOREST = WorldGenRegistrationHelper.createBiome("tropical_fungal_forest", new TropicalFungalRainForest().getBiome());
    public static final Biome TROPICAL_ISLAND = WorldGenRegistrationHelper.createBiome("tropical_islands", new TropicalIslands().getBiome());
    public static final Biome TROPICAL_RAINFOREST = WorldGenRegistrationHelper.createBiome("tropical_rainforest", new TropicalRainForest().getBiome());
    public static final Biome TWILIGHT_VALLEY = WorldGenRegistrationHelper.createBiome("twilight_valley", new TwilightValley().getBiome());
//    public static final Biome VALLE_DE_LUNA = WorldGenRegistrationHelper.createBiome("valle_de_luna", new ValleDeLuna().getBiome());
    public static final Biome VIBRANT_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("vibrant_swamplands", new VibrantSwamplands().getBiome());
    //    public static final Biome VOLCANO = WorldGenRegistrationHelper.createBiome("volcano", new Volcano().getBiome());
    public static final Biome WEEPING_WITCH_FOREST = WorldGenRegistrationHelper.createBiome("weeping_witch_forest", new WeepingWitchForest().getBiome());
    public static final Biome WOODLANDS = WorldGenRegistrationHelper.createBiome("woodlands", new WoodLands().getBiome());
    public static final Biome ZELKOVA_FOREST = WorldGenRegistrationHelper.createBiome("zelkova_forest", new ZelkovaForest().getBiome());


    /************Sub Biomes************/
    //Beaches
    public static final Biome BASALT_BARRERA = WorldGenRegistrationHelper.createBiome("basalt_barrera", new BasaltBarrera().getBiome());
    public static final Biome RAINBOW_BEACH = WorldGenRegistrationHelper.createBiome("rainbow_beach", new RainbowBeach().getBiome());
    public static final Biome ROCKY_BEACH = WorldGenRegistrationHelper.createBiome("rocky_beach", new RockyBeach().getBiome());
    public static final Biome SNOWY_ROCKY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_rocky_black_beach", new SnowyRockyBlackBeach().getBiome());
    public static final Biome SNOWY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_black_beach", new SnowyBlackBeach().getBiome());
    public static final Biome WHITE_BEACH = WorldGenRegistrationHelper.createBiome("white_beach", new WhiteBeach().getBiome());

    //Clearings
    public static final Biome ASPEN_CLEARING = WorldGenRegistrationHelper.createBiome("aspen_clearing", new AspenClearing().getBiome());
    public static final Biome BLACK_FOREST_CLEARING = WorldGenRegistrationHelper.createBiome("black_forest_clearing", new BlackForestClearing().getBiome());
    public static final Biome BOREAL_CLEARING = WorldGenRegistrationHelper.createBiome("boreal_clearing", new BorealClearing().getBiome());
    public static final Biome CHERRY_BLOSSOM_CLEARING = WorldGenRegistrationHelper.createBiome("cherry_blossom_clearing", new CherryBlossomClearing().getBiome());
    public static final Biome CONIFEROUS_CLEARING = WorldGenRegistrationHelper.createBiome("coniferous_clearing", new ConiferousClearing().getBiome());
    public static final Biome DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("deciduous_clearing", new DeciduousClearing().getBiome());
    public static final Biome EVERGREEN_CLEARING = WorldGenRegistrationHelper.createBiome("evergreen_clearing", new EvergreenClearing().getBiome());
    public static final Biome GUIANA_CLEARING = WorldGenRegistrationHelper.createBiome("guiana_clearing", new GuianaClearing().getBiome());
    public static final Biome JACARANDA_CLEARING = WorldGenRegistrationHelper.createBiome("jacaranda_clearing", new JacarandaClearing().getBiome());
    public static final Biome PRAIRIE_CLEARING = WorldGenRegistrationHelper.createBiome("prairie_clearing", new PrairieClearing().getBiome());
    public static final Biome REDWOOD_CLEARING = WorldGenRegistrationHelper.createBiome("redwood_clearing", new RedwoodClearing().getBiome());
    public static final Biome SEASONAL_DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_clearing", new SeasonalDeciduousClearing().getBiome());
    public static final Biome SNOWY_CONIFEROUS_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_coniferous_clearing", new SnowyConiferousClearing().getBiome());
    public static final Biome SNOWY_DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_deciduous_clearing", new SnowyDeciduousClearing().getBiome());
    public static final Biome SNOWY_EVERGREEN_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_evergreen_clearing", new SnowyEvergreenClearing().getBiome());
    public static final Biome TROPICAL_ISLAND_CLEARING = WorldGenRegistrationHelper.createBiome("tropical_island_clearing", new TropicalIslandClearing().getBiome());
    public static final Biome WEEPING_WTICH_CLEARING = WorldGenRegistrationHelper.createBiome("weeping_witch_clearing", new WeepingWitchClearing().getBiome());
    public static final Biome ZELKOVA_CLEARING = WorldGenRegistrationHelper.createBiome("zelkova_clearing", new ZelkovaClearing().getBiome());

    //Edges
    public static final Biome CANYON_EDGE = WorldGenRegistrationHelper.createBiome("canyon_edge", new CanyonEdge().getBiome());

    //Flowering
    public static final Biome FLOWERING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("flowering_ancient_forest", new FloweringAncientForest().getBiome());
    public static final Biome FLOWERING_ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("flowering_enchanted_grove", new FloweringEnchantedGrove().getBiome());
    public static final Biome FLOWERING_GROVE = WorldGenRegistrationHelper.createBiome("flowering_grove", new FloweringGrove().getBiome());
    public static final Biome FLOWERING_MEADOW = WorldGenRegistrationHelper.createBiome("flowering_meadow", new FloweringMeadow().getBiome());

    //Forests
    public static final Biome ARAUCARIA_FOREST = WorldGenRegistrationHelper.createBiome("araucaria_forest", new AraucariaForest().getBiome());
    public static final Biome BAMBOO_FOREST = WorldGenRegistrationHelper.createBiome("bamboo_forest", new BambooForest().getBiome());
    public static final Biome FOREST_FAULT = WorldGenRegistrationHelper.createBiome("forest_fault", new ForestFault().getBiome());
    public static final Biome GLOWING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("glowing_ancient_forest", new GlowingAncientForest().getBiome());
    public static final Biome NORTHERN_FOREST = WorldGenRegistrationHelper.createBiome("northern_forest", new NorthernForest().getBiome());
    public static final Biome POINTY_STONE_FOREST = WorldGenRegistrationHelper.createBiome("pointed_stone_forest", new PointedStoneForest().getBiome());
    public static final Biome PUMPKIN_FOREST = WorldGenRegistrationHelper.createBiome("pumpkin_forest", new PumpkinForest().getBiome());

    //Hills
    public static final Biome ALPINE_FOOTHILLS = WorldGenRegistrationHelper.createBiome("alpine_foothills", new AlpineFoothills().getBiome());
    public static final Biome ASPEN_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("aspen_forest_hills", new AspenForestHills().getBiome());
    public static final Biome BLACK_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("black_forest_hills", new BlackForestHills().getBiome());
    public static final Biome BLUE_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("blue_taiga_hills", new BlueTaigaHills().getBiome());
    public static final Biome BOREAL_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("boreal_forest_hills", new BorealForestHills().getBiome());
    public static final Biome CONIFEROUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("coniferous_forest_hills", new ConiferousForestHills().getBiome());
    public static final Biome DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("deciduous_forest_hills", new DeciduousForestHills().getBiome());
    public static final Biome EBONY_HILLS = WorldGenRegistrationHelper.createBiome("ebony_hills", new EbonyHills().getBiome());
    public static final Biome ENCHANTED_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("enchanted_forest_hills", new EnchantedForestHills().getBiome());
    public static final Biome EVERGREEN_HILLS = WorldGenRegistrationHelper.createBiome("evergreen_hills", new EvergreenHills().getBiome());
    public static final Biome JACARANDA_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("jacaranda_forest_hills", new JacarandaForestHills().getBiome());
    public static final Biome MAPLE_HILLS = WorldGenRegistrationHelper.createBiome("maple_hills", new MapleHills().getBiome());
    public static final Biome RED_OAK_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("red_oak_forest_hills", new RedOakForestHills().getBiome());
    public static final Biome SEASONAL_BIRCH_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_birch_forest_hills", new SeasonalBirchForestHills().getBiome());
    public static final Biome SEASONAL_DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_forest_hills", new SeasonalDeciduousForestHills().getBiome());
    public static final Biome SEASONAL_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_forest_hills", new SeasonalForestHills().getBiome());
    public static final Biome SEASONAL_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_taiga_hills", new SeasonalTaigaHills().getBiome());
    public static final Biome SNOWY_BLUE_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("snowy_blue_taiga_hills", new SnowyBlueTaigaHills().getBiome());
    public static final Biome SNOWY_CONIFEROUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("snowy_coniferous_forest_hills", new SnowyConiferousForestHills().getBiome());
    public static final Biome SNOWY_DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("snowy_deciduous_forest_hills", new SnowyDeciduousForestHills().getBiome());
    public static final Biome SNOWY_EVERGREEN_HILLS = WorldGenRegistrationHelper.createBiome("snowy_evergreen_hills", new SnowyEvergreenHills().getBiome());
    public static final Biome TROPICAL_FUNGAL_RAINFOREST_HILLS = WorldGenRegistrationHelper.createBiome("tropical_fungal_rainforest_hills", new TropicalFungalRainforestHills().getBiome());
    public static final Biome TROPICAL_RAINFOREST_HILLS = WorldGenRegistrationHelper.createBiome("tropical_rainforest_hills", new TropicalRainForestHills().getBiome());
    public static final Biome TWILIGHT_VALLEY_HILLS = WorldGenRegistrationHelper.createBiome("twilight_valley_hills", new TwilightValleyHills().getBiome());
    public static final Biome ZELKOVA_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("zelkova_forest_hills", new ZelkovaForestHills().getBiome());

    //Lakes
    public static final Biome FRESH_WATER_LAKE = WorldGenRegistrationHelper.createBiome("fresh_water_lake", new FreshWaterLake().getBiome());
    public static final Biome FROZEN_LAKE = WorldGenRegistrationHelper.createBiome("frozen_lake", new FrozenLake().getBiome());
    public static final Biome OASIS = WorldGenRegistrationHelper.createBiome("oasis", new Oasis().getBiome());
    public static final Biome POLLUTED_LAKE = WorldGenRegistrationHelper.createBiome("polluted_lake", new PollutedLake().getBiome());

    //Mountains
    public static final Biome BLUFF_PEAKS = WorldGenRegistrationHelper.createBiome("bluff_peaks", new BluffPeaks().getBiome());
    public static final Biome CIKA_MOUNTAINS = WorldGenRegistrationHelper.createBiome("cika_mountains", new CikaMountains().getBiome());
    public static final Biome REDWOOD_MOUNTAINS = WorldGenRegistrationHelper.createBiome("redwood_mountains", new RedwoodMountains().getBiome());
    public static final Biome TROPICAL_ISLAND_MOUNTAINS = WorldGenRegistrationHelper.createBiome("tropical_island_mountains", new TropicalIslandMountains().getBiome());
    public static final Biome WOODED_RED_ROCK_MOUNTAINS = WorldGenRegistrationHelper.createBiome("wooded_red_rock_mountains", new WoodedRedRockMountains().getBiome());

    //Sub
    public static final Biome BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("blue_giant_taiga", new BlueGiantTaiga().getBiome());
    public static final Biome CORAL_MANGROVES = WorldGenRegistrationHelper.createBiome("coral_mangroves", new CoralMangroves().getBiome());
    public static final Biome FUNGAL_PATCH = WorldGenRegistrationHelper.createBiome("fungal_patch", new FungalPatch().getBiome());
    public static final Biome GREAT_LAKE_ISLES = WorldGenRegistrationHelper.createBiome("great_lake_isles", new GreatLakeIsles().getBiome());
    public static final Biome LUSH_RED_DESERT = WorldGenRegistrationHelper.createBiome("lush_red_desert", new LushRedDesert().getBiome());
    public static final Biome RED_ROCK_LOWLANDS = WorldGenRegistrationHelper.createBiome("red_rock_lowlands", new RedRockLowlands().getBiome());
    public static final Biome RED_ROCK_HIGHLANDS = WorldGenRegistrationHelper.createBiome("red_rock_highlands", new RedRockHighlands().getBiome());
    public static final Biome RED_SPRUCE_TAIGA = WorldGenRegistrationHelper.createBiome("red_spruce_taiga", new RedSpruceTaiga().getBiome());
    public static final Biome SIERRA_RANGE = WorldGenRegistrationHelper.createBiome("sierra_range", new SierraRange().getBiome());
    public static final Biome WOODED_GRASSLAND_PLATEAU = WorldGenRegistrationHelper.createBiome("wooded_grassland_plateau", new WoodedGrasslandPlateau().getBiome());
    public static final Biome SNOWY_BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_giant_taiga", new SnowyBlueGiantTaiga().getBiome());
    public static final Biome WOODED_MEADOW = WorldGenRegistrationHelper.createBiome("wooded_meadow", new WoodedMeadow().getBiome());

    //Ocean
    public static final Biome ICEBURG_OCEAN = WorldGenRegistrationHelper.createBiome("iceburg_ocean", new IceburgOcean().getBiome());

    /************Nether Biomes************/
    public static final Biome BRIMSTONE_CAVERNS = WorldGenRegistrationHelper.createBiome("brimstone_caverns", new BrimstoneCaverns().getBiome());
    public static final Biome CRIMSON_GARDENS = WorldGenRegistrationHelper.createBiome("crimson_gardens", new CrimsonGardens().getBiome());
    public static final Biome EMBUR_BOG = WorldGenRegistrationHelper.createBiome("embur_bog", new EmburBog().getBiome());
    public static final Biome GLOWSTONE_GARDENS = WorldGenRegistrationHelper.createBiome("glowstone_gardens", new GlowstoneGardens().getBiome());
    public static final Biome MAGMA_WASTES = WorldGenRegistrationHelper.createBiome("magma_wastes", new MagmaWastes().getBiome());
    public static final Biome SUBZERO_HYPOGEAL = WorldGenRegistrationHelper.createBiome("subzero_hypogeal", new SubzeroHypogeal().getBiome());
    public static final Biome SYTHIAN_TORRIDS = WorldGenRegistrationHelper.createBiome("sythian_torrids", new SythianTorrids().getBiome());
    public static final Biome WARPED_DESERT = WorldGenRegistrationHelper.createBiome("warped_desert", new WarpedDesert().getBiome());
    public static final Biome WAILING_GARTH = WorldGenRegistrationHelper.createBiome("wailing_garth", new WailingGarth().getBiome());
    public static final Biome WITHERING_WOODS = WorldGenRegistrationHelper.createBiome("withering_woods", new WitheringWoods().getBiome());
    public static final Biome WEEPING_MIRE = WorldGenRegistrationHelper.createBiome("weeping_mire", new WeepingMire().getBiome());
    public static final Biome QUARTZ_DESERT = WorldGenRegistrationHelper.createBiome("quartz_desert", new QuartzDesert().getBiome());


    /************End Biomes************/
    public static final Biome IVIS_FIELDS = WorldGenRegistrationHelper.createBiome("ivis_fields", new IvisFields().getBiome());
    public static final Biome NIGHTSHADE_FOREST = WorldGenRegistrationHelper.createBiome("nightshade_forest", new NightshadeForest().getBiome());
    public static final Biome ETHEREAL_ISLANDS = WorldGenRegistrationHelper.createBiome("ethereal_islands", new EtherealIslands().getBiome());
    public static final Biome VISCAL_ISLES = WorldGenRegistrationHelper.createBiome("viscal_isles", new ViscalIsles().getBiome());
    public static final Biome SHATTERED_VISCAL_ISLES = WorldGenRegistrationHelper.createBiome("shattered_viscal_isles", new ShatteredViscalIsles().getBiome());
    public static final Biome SHATTERED_DESERT = WorldGenRegistrationHelper.createBiome("shattered_desert", new ShatteredDesert().getBiome());


    public static void init() {
    }

    public static void addBiomesToWeightSystem() {
        ConfigWeightManager.loadConfig(ConfigWeightManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(BYG.MOD_ID + "-weights-common.toml"));
        BYG.LOGGER.debug("BYG: Adding biome entries with their respective weights...");
        addBiomeEntry(ALLIUM_FIELDS, ConfigWeightManager.ALLIUM_FIELDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(ALPS, ConfigWeightManager.ALPS.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(AMARANTH_FIELDS, ConfigWeightManager.AMARANTH_FIELDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(AUTUMNAL_VALLEY, ConfigWeightManager.AUTUMNAL_VALLEY.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(ARAUCARIA_SAVANNA, ConfigWeightManager.ARAUCARIA_SAVANNA.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(ANCIENT_FOREST, ConfigWeightManager.ANCIENT_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(ASPEN_FOREST, ConfigWeightManager.ASPEN_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BAOBAB_SAVANNA, ConfigWeightManager.BAOBAB_SAVANNA.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BAYOU, ConfigWeightManager.BAYOU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BLUE_TAIGA, ConfigWeightManager.BLUE_TAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BLUFF_STEEPS, ConfigWeightManager.BLUFF_STEEPS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BOREAL_FOREST, ConfigWeightManager.BOREAL_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(COLD_SWAMPLANDS, ConfigWeightManager.COLD_SWAMPLANDS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(CANYONS, ConfigWeightManager.CANYONS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(CIKA_WOODS, ConfigWeightManager.CIKA_WOODS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(CYPRESS_SWAMPLANDS, ConfigWeightManager.CYPRESS_SWAMPLAND.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(CHERRY_BLOSSOM_FOREST, ConfigWeightManager.CHERRY_BLOSSOM_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(CONIFEROUS_FOREST, ConfigWeightManager.CONIFEROUS_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(DOVER_MOUNTAINS, ConfigWeightManager.DOVER_MOUNTAINS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(DEAD_SEA, ConfigWeightManager.DEAD_SEA.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(DECIDUOUS_FOREST, ConfigWeightManager.DECIDUOUS_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(DUNES, ConfigWeightManager.DUNES.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(EBONY_WOODS, ConfigWeightManager.EBONY_WOODS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(ENCHANTED_FOREST, ConfigWeightManager.ENCHANTED_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(EVERGREEN_TAIGA, ConfigWeightManager.EVERGREEN_TAIGA.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(GLOWSHROOM_BAYOU, ConfigWeightManager.GLOWSHROOM_BAYOU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(GRASSLAND_PLATEAU, ConfigWeightManager.GRASSLAND_PLATEAU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(GREAT_LAKES, ConfigWeightManager.GREAT_LAKE.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(GUIANA_SHIELD, ConfigWeightManager.GUIANA_SHIELD.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(GROVE, ConfigWeightManager.GROVE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(ENCHANTED_GROVE, ConfigWeightManager.ENCHANTED_GROVE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(JACARANDA_FOREST, ConfigWeightManager.JACARANDA_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(CRAG_GARDENS, ConfigWeightManager.CRAG_GARDENS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(MANGROVE_MARSHES, ConfigWeightManager.MANGROVE_MARSHES.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(MAPLE_TAIGA, ConfigWeightManager.MAPLE_TAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(MEADOW, ConfigWeightManager.MEADOW.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(MOJAVE_DESERT, ConfigWeightManager.MOJAVE_DESERT.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(LUSH_TUNDRA, ConfigWeightManager.LUSH_TUNDRA.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(ORCHARD, ConfigWeightManager.ORCHARD.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(PRAIRIE, ConfigWeightManager.PRAIRIE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(RED_DESERT, ConfigWeightManager.RED_DESERT.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(ROSE_FIELDS, ConfigWeightManager.ROSE_FIELDS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(RED_OAK_FOREST, ConfigWeightManager.RED_OAK_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(RED_ROCK_MOUNTAINS, ConfigWeightManager.RED_ROCK_MOUNTAINS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(REDWOOD_TROPICS, ConfigWeightManager.REDWOOD_TROPICS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(SEASONAL_BIRCH_FOREST, ConfigWeightManager.SEASONAL_BIRCH_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(SEASONAL_DECIDUOUS_FOREST, ConfigWeightManager.SEASONAL_DECIDUOUS_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(SEASONAL_FOREST, ConfigWeightManager.SEASONAL_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(SEASONAL_TAIGA, ConfigWeightManager.SEASONAL_TAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(SHATTERED_GLACIER, ConfigWeightManager.SHATTERED_GLACIER.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(SHRUBLANDS, ConfigWeightManager.SHRUBLANDS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(SKYRIS_HIGHLANDS, ConfigWeightManager.SKYRIS_HIGHLANDS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(SNOWY_BLUE_TAIGA, ConfigWeightManager.SNOWY_BLUE_TAIGA.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(SNOWY_CONIFEROUS_FOREST, ConfigWeightManager.SNOWY_CONIFEROUS_FOREST.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(SNOWY_DECIDUOUS_FOREST, ConfigWeightManager.SNOWY_DECIDUOUS_FOREST.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(SNOWY_EVERGREEN_TAIGA, ConfigWeightManager.SNOWY_EVERGREEN_TAIGA.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(THE_BLACK_FOREST, ConfigWeightManager.THE_BLACK_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(TROPICAL_FUNGAL_RAINFOREST, ConfigWeightManager.TROPICAL_FUNGAL_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(TROPICAL_RAINFOREST, ConfigWeightManager.TROPICAL_RAIN_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(TWILIGHT_VALLEY, ConfigWeightManager.TWILIGHT_VALLEY.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(VIBRANT_SWAMPLANDS, ConfigWeightManager.VIBRANT_SWAMPLANDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(SIERRA_VALLEY, ConfigWeightManager.SIERRA_VALLEY.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(STONE_FOREST, ConfigWeightManager.STONE_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(WEEPING_WITCH_FOREST, ConfigWeightManager.WEEPING_WITCH_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(WOODLANDS, ConfigWeightManager.WOODLANDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(ZELKOVA_FOREST, ConfigWeightManager.ZELKOVA_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        BYG.LOGGER.debug("BYG: Added biome entries with their respective weights!");
    }

    public static void addBiomeEntry(Biome biome, int weight, BiomeManager.BiomeType type) {
        if (weight > 0) {
            BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome))), weight));
        }
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
