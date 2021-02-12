package corgiaoc.byg.core.world;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import corgiaoc.byg.common.world.biome.*;
import corgiaoc.byg.common.world.biome.end.*;
import corgiaoc.byg.common.world.biome.end.sub.BulbisGardensEdge;
import corgiaoc.byg.common.world.biome.end.sub.EtherealClearing;
import corgiaoc.byg.common.world.biome.end.sub.EtherealForest;
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
import corgiaoc.byg.config.BYGWorldConfig;
import corgiaoc.byg.config.json.biomedata.BiomeData;
import corgiaoc.byg.config.json.endbiomedata.EndBiomeData;
import corgiaoc.byg.config.json.endbiomedata.sub.EndSubBiomeData;
import corgiaoc.byg.config.json.subbiomedata.SubBiomeData;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class BYGBiomes {
    public static List<PreserveBiomeOrder> biomeList = new ArrayList<>();

    public static Biome DUMMY_BIOME = WorldGenRegistrationHelper.createBiome("dummy", new DummySubBiome().getBiome(), 2000);


    /************Primary Biomes************/
    public static Biome ALLIUM_FIELDS = WorldGenRegistrationHelper.createBiome("allium_fields", new AlliumFields().getBiome(), 1);
    public static Biome ALPS = WorldGenRegistrationHelper.createBiome("alps", new Alps().getBiome(), 2);
    public static Biome AMARANTH_FIELDS = WorldGenRegistrationHelper.createBiome("amaranth_fields", new AmaranthFields().getBiome(), 3);
    public static Biome ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("ancient_forest", new AncientForest().getBiome(), 4);
    public static Biome ARAUCARIA_SAVANNA = WorldGenRegistrationHelper.createBiome("araucaria_savanna", new AraucariaSavanna().getBiome(), 146);
    public static Biome ASPEN_FOREST = WorldGenRegistrationHelper.createBiome("aspen_forest", new AspenForest().getBiome(), 5);
    public static Biome AUTUMNAL_VALLEY = WorldGenRegistrationHelper.createBiome("autumnal_valley", new AutumnalValley().getBiome(), 6);
    public static Biome BAOBAB_SAVANNA = WorldGenRegistrationHelper.createBiome("baobab_savanna", new BaobabSavanna().getBiome(), 7);
    public static Biome BAYOU = WorldGenRegistrationHelper.createBiome("bayou", new Bayou().getBiome(), 8);
    public static Biome BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("blue_taiga", new BlueTaiga().getBiome(), 9);
    public static Biome BLUFF_STEEPS = WorldGenRegistrationHelper.createBiome("bluff_steeps", new BluffSteeps().getBiome(), 10);
    public static Biome BOG = WorldGenRegistrationHelper.createBiome("bog", new Bog().getBiome(), 105);
    public static Biome BOREAL_FOREST = WorldGenRegistrationHelper.createBiome("boreal_forest", new BorealForest().getBiome(), 11);
    public static Biome CANYONS = WorldGenRegistrationHelper.createBiome("canyons", new Canyons().getBiome(), 172);
    public static Biome CIKA_WOODS = WorldGenRegistrationHelper.createBiome("cika_woods", new CikaWoods().getBiome(), 14);
    public static Biome COLD_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("cold_swamplands", new ColdSwamplands().getBiome(), 12);
    public static Biome CRAG_GARDENS = WorldGenRegistrationHelper.createBiome("crag_gardens", new CragGardens().getBiome(), 13);
    public static Biome CYPRESS_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("cypress_swamplands", new CypressSwampland().getBiome(), 18);
    public static Biome CHERRY_BLOSSOM_FOREST = WorldGenRegistrationHelper.createBiome("cherry_blossom_forest", new CherryBlossomForest().getBiome(), 15);
    public static Biome CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("coniferous_forest", new ConiferousForest().getBiome(), 17);
    public static Biome DEAD_SEA = WorldGenRegistrationHelper.createBiome("dead_sea", new DeadSea().getBiome(), 20);
    public static Biome DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("deciduous_forest", new DeciduousForest().getBiome(), 21);
    public static Biome DOVER_MOUNTAINS = WorldGenRegistrationHelper.createBiome("dover_mountains", new DoverMountains().getBiome(), 19);
    public static Biome DUNES = WorldGenRegistrationHelper.createBiome("dunes", new Dunes().getBiome(), 22);
    public static Biome EBONY_WOODS = WorldGenRegistrationHelper.createBiome("ebony_woods", new EbonyWoods().getBiome(), 23);
    public static Biome ENCHANTED_FOREST = WorldGenRegistrationHelper.createBiome("enchanted_forest", new EnchantedForest().getBiome(), 24);
    public static Biome EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("evergreen_taiga", new EvergreenTaiga().getBiome(), 25);
    public static Biome GLOWSHROOM_BAYOU = WorldGenRegistrationHelper.createBiome("glowshroom_bayou", new GlowshroomBayou().getBiome(), 26);
    public static Biome GRASSLAND_PLATEAU = WorldGenRegistrationHelper.createBiome("grassland_plateau", new GrassLandPlateau().getBiome(), 27);
    public static Biome GREAT_LAKES = WorldGenRegistrationHelper.createBiome("great_lakes", new GreatLakes().getBiome(), 28);
    public static Biome ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("enchanted_grove", new EnchantedGrove().getBiome(), 30);
    public static Biome GROVE = WorldGenRegistrationHelper.createBiome("grove", new Grove().getBiome(), 29);
    public static Biome GUIANA_SHIELD = WorldGenRegistrationHelper.createBiome("guiana_shield", new GuianaShield().getBiome(), 31);
    public static Biome JACARANDA_FOREST = WorldGenRegistrationHelper.createBiome("jacaranda_forest", new JacarandaForest().getBiome(), 32);
    public static Biome MANGROVE_MARSHES = WorldGenRegistrationHelper.createBiome("mangrove_marshes", new MangroveMarshes().getBiome(), 33);
    public static Biome MAPLE_TAIGA = WorldGenRegistrationHelper.createBiome("maple_taiga", new MapleTaiga().getBiome(), 34);
    public static Biome MARSHLANDS = WorldGenRegistrationHelper.createBiome("marshlands", new MarshLands().getBiome(), 112);
    public static Biome MEADOW = WorldGenRegistrationHelper.createBiome("meadow", new Meadow().getBiome(), 35);
    public static Biome MOJAVE_DESERT = WorldGenRegistrationHelper.createBiome("mojave_desert", new MojaveDesert().getBiome(), 36);
    public static Biome LUSH_TUNDRA = WorldGenRegistrationHelper.createBiome("lush_tundra", new LushTundra().getBiome(), 37);
    public static Biome ORCHARD = WorldGenRegistrationHelper.createBiome("orchard", new Orchard().getBiome(), 38);
    public static Biome PRAIRIE = WorldGenRegistrationHelper.createBiome("prairie", new Prairie().getBiome(), 39);
    public static Biome RED_DESERT = WorldGenRegistrationHelper.createBiome("red_desert", new RedDesert().getBiome(), 40);
    public static Biome RED_DESERT_DUNES = WorldGenRegistrationHelper.createBiome("red_desert_dunes", new RedDesertDunes().getBiome(), 41);
    public static Biome RED_OAK_FOREST = WorldGenRegistrationHelper.createBiome("red_oak_forest", new RedOakForest().getBiome(), 42);
    public static Biome RED_ROCK_MOUNTAINS = WorldGenRegistrationHelper.createBiome("red_rock_mountains", new RedRockMountains().getBiome(), 43);
    public static Biome ROSE_FIELDS = WorldGenRegistrationHelper.createBiome("rose_fields", new RoseFields().getBiome(), 147);
    public static Biome SEASONAL_BIRCH_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_birch_forest", new SeasonalBirchForest().getBiome(), 44);
    public static Biome SEASONAL_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_forest", new SeasonalDeciduousForest().getBiome(), 45);
    public static Biome SEASONAL_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_forest", new SeasonalForest().getBiome(), 46);
    public static Biome SEASONAL_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_taiga", new SeasonalTaiga().getBiome(), 47);
    public static Biome SHATTERED_GLACIER = WorldGenRegistrationHelper.createBiome("shattered_glacier", new ShatteredGlacier().getBiome(), 48);
    public static Biome SHRUBLANDS = WorldGenRegistrationHelper.createBiome("shrublands", new ShrubLands().getBiome(), 49);
    public static Biome SIERRA_VALLEY = WorldGenRegistrationHelper.createBiome("sierra_valley", new SierraValley().getBiome(), 59);
    public static Biome SKYRIS_HIGHLANDS = WorldGenRegistrationHelper.createBiome("skyris_highlands", new SkyrisHighlands().getBiome(), 50);
    public static Biome REDWOOD_TROPICS = WorldGenRegistrationHelper.createBiome("redwood_tropics", new RedwoodTropics().getBiome(), 16);
    public static Biome SNOWY_BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_taiga", new SnowyBlueTaiga().getBiome(), 51);
    public static Biome SNOWY_CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_coniferous_forest", new SnowyConiferousForest().getBiome(), 52);
    public static Biome SNOWY_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_deciduous_forest", new SnowyDeciduousForest().getBiome(), 53);
    public static Biome SNOWY_EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_evergreen_taiga", new SnowyEvergreenTaiga().getBiome(), 54);
    public static Biome STONE_FOREST = WorldGenRegistrationHelper.createBiome("stone_forest", new StoneForest().getBiome(), 148);
    public static Biome THE_BLACK_FOREST = WorldGenRegistrationHelper.createBiome("the_black_forest", new TheBlackForest().getBiome(), 55);
    public static Biome TROPICAL_FUNGAL_RAINFOREST = WorldGenRegistrationHelper.createBiome("tropical_fungal_forest", new TropicalFungalRainForest().getBiome(), 56);
    public static Biome TROPICAL_ISLAND = WorldGenRegistrationHelper.createBiome("tropical_islands", new TropicalIslands().getBiome(), 140);
    public static Biome TROPICAL_RAINFOREST = WorldGenRegistrationHelper.createBiome("tropical_rainforest", new TropicalRainForest().getBiome(), 57);
    public static Biome TWILIGHT_VALLEY = WorldGenRegistrationHelper.createBiome("twilight_valley", new TwilightValley().getBiome(), 149);
    public static Biome VIBRANT_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("vibrant_swamplands", new VibrantSwamplands().getBiome(), 58);
    public static Biome WEEPING_WITCH_FOREST = WorldGenRegistrationHelper.createBiome("weeping_witch_forest", new WeepingWitchForest().getBiome(), 60);
    public static Biome WOODLANDS = WorldGenRegistrationHelper.createBiome("woodlands", new WoodLands().getBiome(), 61);
    public static Biome ZELKOVA_FOREST = WorldGenRegistrationHelper.createBiome("zelkova_forest", new ZelkovaForest().getBiome(), 62);


    /************Sub Biomes************/
    //Beaches
    public static Biome BASALT_BARRERA = WorldGenRegistrationHelper.createBiome("basalt_barrera", new BasaltBarrera().getBiome(), 150);
    public static Biome RAINBOW_BEACH = WorldGenRegistrationHelper.createBiome("rainbow_beach", new RainbowBeach().getBiome(), 139);
    public static Biome ROCKY_BEACH = WorldGenRegistrationHelper.createBiome("rocky_beach", new RockyBeach().getBiome(), 135);
    public static Biome SNOWY_ROCKY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_rocky_black_beach", new SnowyRockyBlackBeach().getBiome(), 136);
    public static Biome SNOWY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_black_beach", new SnowyBlackBeach().getBiome(), 137);
    public static Biome WHITE_BEACH = WorldGenRegistrationHelper.createBiome("white_beach", new WhiteBeach().getBiome(), 138);

    //Clearings
    public static Biome ASPEN_CLEARING = WorldGenRegistrationHelper.createBiome("aspen_clearing", new AspenClearing().getBiome(), 82);
    public static Biome BLACK_FOREST_CLEARING = WorldGenRegistrationHelper.createBiome("black_forest_clearing", new BlackForestClearing().getBiome(), 91);
    public static Biome BOREAL_CLEARING = WorldGenRegistrationHelper.createBiome("boreal_clearing", new BorealClearing().getBiome(), 83);
    public static Biome CHERRY_BLOSSOM_CLEARING = WorldGenRegistrationHelper.createBiome("cherry_blossom_clearing", new CherryBlossomClearing().getBiome(), 79);
    public static Biome CONIFEROUS_CLEARING = WorldGenRegistrationHelper.createBiome("coniferous_clearing", new ConiferousClearing().getBiome(), 80);
    public static Biome DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("deciduous_clearing", new DeciduousClearing().getBiome(), 84);
    public static Biome EVERGREEN_CLEARING = WorldGenRegistrationHelper.createBiome("evergreen_clearing", new EvergreenClearing().getBiome(), 73);
    public static Biome GUIANA_CLEARING = WorldGenRegistrationHelper.createBiome("guiana_clearing", new GuianaClearing().getBiome(), 86);
    public static Biome JACARANDA_CLEARING = WorldGenRegistrationHelper.createBiome("jacaranda_clearing", new JacarandaClearing().getBiome(), 87);
    public static Biome PRAIRIE_CLEARING = WorldGenRegistrationHelper.createBiome("prairie_clearing", new PrairieClearing().getBiome(), 115);
    public static Biome REDWOOD_CLEARING = WorldGenRegistrationHelper.createBiome("redwood_clearing", new RedwoodClearing().getBiome(), 63);
    public static Biome SEASONAL_DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_clearing", new SeasonalDeciduousClearing().getBiome(), 85);
    public static Biome SNOWY_CONIFEROUS_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_coniferous_clearing", new SnowyConiferousClearing().getBiome(), 88);
    public static Biome SNOWY_DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_deciduous_clearing", new SnowyDeciduousClearing().getBiome(), 89);
    public static Biome SNOWY_EVERGREEN_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_evergreen_clearing", new SnowyEvergreenClearing().getBiome(), 69);
    public static Biome WEEPING_WTICH_CLEARING = WorldGenRegistrationHelper.createBiome("weeping_witch_clearing", new WeepingWitchClearing().getBiome(), 76);
    public static Biome ZELKOVA_CLEARING = WorldGenRegistrationHelper.createBiome("zelkova_clearing", new ZelkovaClearing().getBiome(), 81);

    //Edges
    public static Biome CANYON_EDGE = WorldGenRegistrationHelper.createBiome("canyon_edge", new CanyonEdge().getBiome(), 151);

    //Flowering
    public static Biome FLOWERING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("flowering_ancient_forest", new FloweringAncientForest().getBiome(), 68);
    public static Biome FLOWERING_ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("flowering_enchanted_grove", new FloweringEnchantedGrove().getBiome(), 95);
    public static Biome FLOWERING_GROVE = WorldGenRegistrationHelper.createBiome("flowering_grove", new FloweringGrove().getBiome(), 94);
    public static Biome FLOWERING_MEADOW = WorldGenRegistrationHelper.createBiome("flowering_meadow", new FloweringMeadow().getBiome(), 133);

    //Forests
    public static Biome ARAUCARIA_FOREST = WorldGenRegistrationHelper.createBiome("araucaria_forest", new AraucariaForest().getBiome(), 152);
    public static Biome BAMBOO_FOREST = WorldGenRegistrationHelper.createBiome("bamboo_forest", new BambooForest().getBiome(), 78);
    public static Biome FOREST_FAULT = WorldGenRegistrationHelper.createBiome("forest_fault", new ForestFault().getBiome(), 93);
    public static Biome GLOWING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("glowing_ancient_forest", new GlowingAncientForest().getBiome(), 67);
    public static Biome NORTHERN_FOREST = WorldGenRegistrationHelper.createBiome("northern_forest", new NorthernForest().getBiome(), 96);
    public static Biome POINTY_STONE_FOREST = WorldGenRegistrationHelper.createBiome("pointed_stone_forest", new PointedStoneForest().getBiome(), 153);
    public static Biome PUMPKIN_FOREST = WorldGenRegistrationHelper.createBiome("pumpkin_forest", new PumpkinForest().getBiome(), 77);

    //Hills
    public static Biome ALPINE_FOOTHILLS = WorldGenRegistrationHelper.createBiome("alpine_foothills", new AlpineFoothills().getBiome(), 99);
    public static Biome ASPEN_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("aspen_forest_hills", new AspenForestHills().getBiome(), 100);
    public static Biome BLACK_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("black_forest_hills", new BlackForestHills().getBiome(), 92);
    public static Biome BLUE_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("blue_taiga_hills", new BlueTaigaHills().getBiome(), 101);
    public static Biome BOREAL_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("boreal_forest_hills", new BorealForestHills().getBiome(), 104);
    public static Biome CONIFEROUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("coniferous_forest_hills", new ConiferousForestHills().getBiome(), 107);
    public static Biome DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("deciduous_forest_hills", new DeciduousForestHills().getBiome(), 106);
    public static Biome EBONY_HILLS = WorldGenRegistrationHelper.createBiome("ebony_hills", new EbonyHills().getBiome(), 72);
    public static Biome ENCHANTED_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("enchanted_forest_hills", new EnchantedForestHills().getBiome(), 71);
    public static Biome EVERGREEN_HILLS = WorldGenRegistrationHelper.createBiome("evergreen_hills", new EvergreenHills().getBiome(), 74);
    public static Biome JACARANDA_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("jacaranda_forest_hills", new JacarandaForestHills().getBiome(), 111);
    public static Biome MAPLE_HILLS = WorldGenRegistrationHelper.createBiome("maple_hills", new MapleHills().getBiome(), 90);
    public static Biome RED_OAK_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("red_oak_forest_hills", new RedOakForestHills().getBiome(), 116);
    public static Biome SEASONAL_BIRCH_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_birch_forest_hills", new SeasonalBirchForestHills().getBiome(), 120);
    public static Biome SEASONAL_DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_forest_hills", new SeasonalDeciduousForestHills().getBiome(), 121);
    public static Biome SEASONAL_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_forest_hills", new SeasonalForestHills().getBiome(), 122);
    public static Biome SEASONAL_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("seasonal_taiga_hills", new SeasonalTaigaHills().getBiome(), 124);
    public static Biome SNOWY_BLUE_TAIGA_HILLS = WorldGenRegistrationHelper.createBiome("snowy_blue_taiga_hills", new SnowyBlueTaigaHills().getBiome(), 126);
    public static Biome SNOWY_CONIFEROUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("snowy_coniferous_forest_hills", new SnowyConiferousForestHills().getBiome(), 127);
    public static Biome SNOWY_DECIDUOUS_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("snowy_deciduous_forest_hills", new SnowyDeciduousForestHills().getBiome(), 128);
    public static Biome SNOWY_EVERGREEN_HILLS = WorldGenRegistrationHelper.createBiome("snowy_evergreen_hills", new SnowyEvergreenHills().getBiome(), 70);
    public static Biome TROPICAL_FUNGAL_RAINFOREST_HILLS = WorldGenRegistrationHelper.createBiome("tropical_fungal_rainforest_hills", new TropicalFungalRainforestHills().getBiome(), 129);
    public static Biome TROPICAL_RAINFOREST_HILLS = WorldGenRegistrationHelper.createBiome("tropical_rainforest_hills", new TropicalRainForestHills().getBiome(), 130);
    public static Biome TWILIGHT_VALLEY_HILLS = WorldGenRegistrationHelper.createBiome("twilight_valley_hills", new TwilightValleyHills().getBiome(), 154);
    public static Biome ZELKOVA_FOREST_HILLS = WorldGenRegistrationHelper.createBiome("zelkova_forest_hills", new ZelkovaForestHills().getBiome(), 132);

    //Lakes
    public static Biome FRESH_WATER_LAKE = WorldGenRegistrationHelper.createBiome("fresh_water_lake", new FreshWaterLake().getBiome(), 108);
    public static Biome FROZEN_LAKE = WorldGenRegistrationHelper.createBiome("frozen_lake", new FrozenLake().getBiome(), 109);
    public static Biome OASIS = WorldGenRegistrationHelper.createBiome("oasis", new Oasis().getBiome(), 113);
    public static Biome POLLUTED_LAKE = WorldGenRegistrationHelper.createBiome("polluted_lake", new PollutedLake().getBiome(), 114);

    //Mountains
    public static Biome BLUFF_PEAKS = WorldGenRegistrationHelper.createBiome("bluff_peaks", new BluffPeaks().getBiome(), 103);
    public static Biome CIKA_MOUNTAINS = WorldGenRegistrationHelper.createBiome("cika_mountains", new CikaMountains().getBiome(), 66);
    public static Biome REDWOOD_MOUNTAINS = WorldGenRegistrationHelper.createBiome("redwood_mountains", new RedwoodMountains().getBiome(), 64);
    public static Biome WOODED_RED_ROCK_MOUNTAINS = WorldGenRegistrationHelper.createBiome("wooded_red_rock_mountains", new WoodedRedRockMountains().getBiome(), 119);

    //Sub
    public static Biome BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("blue_giant_taiga", new BlueGiantTaiga().getBiome(), 102);
    public static Biome CORAL_MANGROVES = WorldGenRegistrationHelper.createBiome("coral_mangroves", new CoralMangroves().getBiome(), 65);
    public static Biome FUNGAL_PATCH = WorldGenRegistrationHelper.createBiome("fungal_patch", new FungalPatch().getBiome(), 75);
    public static Biome GREAT_LAKE_ISLES = WorldGenRegistrationHelper.createBiome("great_lake_isles", new GreatLakeIsles().getBiome(), 110);
    public static Biome LUSH_RED_DESERT = WorldGenRegistrationHelper.createBiome("lush_red_desert", new LushRedDesert().getBiome(), 97);
    public static Biome RED_ROCK_LOWLANDS = WorldGenRegistrationHelper.createBiome("red_rock_lowlands", new RedRockLowlands().getBiome(), 117);
    public static Biome RED_ROCK_HIGHLANDS = WorldGenRegistrationHelper.createBiome("red_rock_highlands", new RedRockHighlands().getBiome(), 118);
    public static Biome RED_SPRUCE_TAIGA = WorldGenRegistrationHelper.createBiome("red_spruce_taiga", new RedSpruceTaiga().getBiome(), 155);
    public static Biome SIERRA_RANGE = WorldGenRegistrationHelper.createBiome("sierra_range", new SierraRange().getBiome(), 98);
    public static Biome WOODED_GRASSLAND_PLATEAU = WorldGenRegistrationHelper.createBiome("wooded_grassland_plateau", new WoodedGrasslandPlateau().getBiome(), 131);
    public static Biome SNOWY_BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_giant_taiga", new SnowyBlueGiantTaiga().getBiome(), 125);
    public static Biome WOODED_MEADOW = WorldGenRegistrationHelper.createBiome("wooded_meadow", new WoodedMeadow().getBiome(), 134);


    //Mutations
    public static Biome SEASONAL_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_giant_taiga", new SeasonalGiantTaiga().getBiome(), 123);


    /************Nether Biomes************/
    public static Biome BRIMSTONE_CAVERNS = WorldGenRegistrationHelper.createBiome("brimstone_caverns", new BrimstoneCaverns().getBiome(), 156);
    public static Biome CRIMSON_GARDENS = WorldGenRegistrationHelper.createBiome("crimson_gardens", new CrimsonGardens().getBiome(), 157);
    public static Biome EMBUR_BOG = WorldGenRegistrationHelper.createBiome("embur_bog", new EmburBog().getBiome(), 144);
    public static Biome GLOWSTONE_GARDENS = WorldGenRegistrationHelper.createBiome("glowstone_gardens", new GlowstoneGardens().getBiome(), 143);
    public static Biome MAGMA_WASTES = WorldGenRegistrationHelper.createBiome("magma_wastes", new MagmaWastes().getBiome(), 158);
    public static Biome SUBZERO_HYPOGEAL = WorldGenRegistrationHelper.createBiome("subzero_hypogeal", new SubzeroHypogeal().getBiome(), 159);
    public static Biome SYTHIAN_TORRIDS = WorldGenRegistrationHelper.createBiome("sythian_torrids", new SythianTorrids().getBiome(), 142);
    public static Biome WARPED_DESERT = WorldGenRegistrationHelper.createBiome("warped_desert", new WarpedDesert().getBiome(), 141);
    public static Biome WAILING_GARTH = WorldGenRegistrationHelper.createBiome("wailing_garth", new WailingGarth().getBiome(), 160);
    public static Biome WITHERING_WOODS = WorldGenRegistrationHelper.createBiome("withering_woods", new WitheringWoods().getBiome(), 161);
    public static Biome WEEPING_MIRE = WorldGenRegistrationHelper.createBiome("weeping_mire", new WeepingMire().getBiome(), 162);
    public static Biome QUARTZ_DESERT = WorldGenRegistrationHelper.createBiome("quartz_desert", new QuartzDesert().getBiome(), 163);


    /************End Biomes************/
    public static Biome IVIS_FIELDS = WorldGenRegistrationHelper.createBiome("ivis_fields", new IvisFields().getBiome(), 145);
    public static Biome NIGHTSHADE_FOREST = WorldGenRegistrationHelper.createBiome("nightshade_forest", new NightshadeForest().getBiome(), 164);
    public static Biome ETHEREAL_ISLANDS = WorldGenRegistrationHelper.createBiome("ethereal_islands", new EtherealIslands().getBiome(), 165);
    public static Biome VISCAL_ISLES = WorldGenRegistrationHelper.createBiome("viscal_isles", new ViscalIsles().getBiome(), 166);
    public static Biome BULBIS_GARDENS = WorldGenRegistrationHelper.createBiome("bulbis_gardens", new BulbisGardens().getBiome(), 167);
    public static Biome SHATTERED_DESERT = WorldGenRegistrationHelper.createBiome("shattered_desert", new ShatteredDesert().getBiome(), 168);
    public static Biome SHULKREN_FOREST = WorldGenRegistrationHelper.createBiome("shulkren_forest", new ShulkrenForest().getBiome(), 169);
    public static Biome PURPUR_PEAKS = WorldGenRegistrationHelper.createBiome("purpur_peaks", new PurpurPeaks().getBiome(), 170);
    public static Biome CRYPTIC_WASTES = WorldGenRegistrationHelper.createBiome("cryptic_wastes", new CrypticWastes().getBiome(), 171);
    public static Biome SHATTERED_DESERT_ISLES = WorldGenRegistrationHelper.createBiome("shattered_desert_isles", new ShatteredDesertIsles().getBiome(), 177);

    /************End Sub-Biomes************/
    public static Biome SHATTERED_VISCAL_ISLES = WorldGenRegistrationHelper.createBiome("shattered_viscal_isles", new ShatteredViscalIsles().getBiome(), 173);
    public static Biome BULBIS_GARDENS_EDGE = WorldGenRegistrationHelper.createBiome("bulbis_gardens_edge", new BulbisGardensEdge().getBiome(), 174);
    public static Biome ETHEREAL_FOREST = WorldGenRegistrationHelper.createBiome("ethereal_forest", new EtherealForest().getBiome(), 175);
    public static Biome ETHEREAL_CLEARING = WorldGenRegistrationHelper.createBiome("ethereal_clearing", new EtherealClearing().getBiome(), 176);

    public static void init() {
    }

    public static void addBiomeEntries() {
        for (BiomeData biomeData : BYGBiome.biomeData) {
            if (biomeData.getBiomeWeight() > 0) {
                BiomeManager.addBiome(biomeData.getBiomeType(), new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biomeData.getBiome())), biomeData.getBiomeWeight()));
            }
        }
    }

    public static void fillBiomeDictionary(Registry<Biome> biomeRegistry) {
        for (EndBiomeData endBiomeData : BYGEndBiome.endBiomeData) {
            RegistryKey<Biome> key = biomeRegistry.getOptionalKey(biomeRegistry.getOptional(endBiomeData.getBiome()).get()).get();
            for (int idx = 0; idx < endBiomeData.getDictionaryTypes().length; idx++) {
                BiomeDictionary.Type type = endBiomeData.getDictionaryTypes()[idx];
                if (!(BiomeDictionary.hasType(key, type)))
                    BiomeDictionary.addTypes(key, type);
            }
        }
        for (EndBiomeData endBiomeData : BYGEndBiome.voidBiomeData) {
            RegistryKey<Biome> key = biomeRegistry.getOptionalKey(biomeRegistry.getOptional(endBiomeData.getBiome()).get()).get();
            for (int idx = 0; idx < endBiomeData.getDictionaryTypes().length; idx++) {
                BiomeDictionary.Type type = endBiomeData.getDictionaryTypes()[idx];
                if (!(BiomeDictionary.hasType(key, type)))
                    BiomeDictionary.addTypes(key, type);
            }
        }

        for (EndSubBiomeData endBiomeData : BYGEndSubBiome.endSubBiomeData) {
            RegistryKey<Biome> key = biomeRegistry.getOptionalKey(biomeRegistry.getOptional(endBiomeData.getBiome()).get()).get();
            for (int idx = 0; idx < endBiomeData.getDictionaryTypes().length; idx++) {
                BiomeDictionary.Type type = endBiomeData.getDictionaryTypes()[idx];
                if (!(BiomeDictionary.hasType(key, type)))
                    BiomeDictionary.addTypes(key, type);
            }
        }

        for (EndSubBiomeData endBiomeData : BYGEndSubBiome.voidSubBiomeData) {
            RegistryKey<Biome> key = biomeRegistry.getOptionalKey(biomeRegistry.getOptional(endBiomeData.getBiome()).get()).get();
            for (int idx = 0; idx < endBiomeData.getDictionaryTypes().length; idx++) {
                BiomeDictionary.Type type = endBiomeData.getDictionaryTypes()[idx];
                if (!(BiomeDictionary.hasType(key, type)))
                    BiomeDictionary.addTypes(key, type);
            }
        }
    }

    public static void fillBiomeDictionary() {
        for (BiomeData bygBiome : BYGBiome.biomeData) {
            BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(bygBiome.getBiome())), bygBiome.getDictionaryTypes());
        }
        for (SubBiomeData bygSubBiome : BYGSubBiome.subBiomeData) {
            BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(bygSubBiome.getBiome())), bygSubBiome.getDictionaryTypes());
        }

        for (BYGNetherBiome bygNetherBiome : BYGNetherBiome.BYG_NETHER_BIOMES)
            BiomeDictionary.addTypes(bygNetherBiome.getKey(), bygNetherBiome.getBiomeDictionary());
    }

    //used in MixinMinecraftServer
    public static void addBYGFeaturesToBiomes(Biome biome, ResourceLocation locationKey) {
        if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NONE) {
            if (BYGWorldConfig.ROCKY_STONE_GEN.get()) {
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_ROCKY_STONE);
            }
            if (BYGWorldConfig.SCORIA_STONE_GEN.get()) {
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_SCORIA_STONE);
            }

            if (BYGWorldConfig.SOAP_STONE_GEN.get()) {
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_SOAP_STONE);
            }

            if (biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.SOUL_SAND_VALLEY)) {
                addFeatureToBiome(biome, GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SOUL_SHROOM_SPORES);
            }

            if (biome == WorldGenRegistries.BIOME.getOrThrow(Biomes.BEACH)) {
                addFeatureToBiome(biome, GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PALM_TREE);
            }

            if (BYGWorldConfig.AMETRINE_GEN.get()) {
                if (locationKey.equals(WorldGenRegistries.BIOME.getKey(POINTY_STONE_FOREST)) || locationKey.equals(WorldGenRegistries.BIOME.getKey(STONE_FOREST)) || locationKey.equals(WorldGenRegistries.BIOME.getKey(GUIANA_SHIELD)) || locationKey.equals(WorldGenRegistries.BIOME.getKey(GUIANA_CLEARING)))
                    addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_AMETRINE);
            }

            if (BYGWorldConfig.PENDORITE_GEN.get()) {
                if (locationKey.equals(WorldGenRegistries.BIOME.getKey(FOREST_FAULT)))
                    addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_PENDORITE);
            }

//                addStructureToBiome(biome, BYGConfiguredStructures.VOLCANO_STRUCTURE);
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

    //Use these to add our features to vanilla's biomes.
    public static void addStructureToBiome(Biome biome, StructureFeature<?, ?> configuredStructure) {
        convertImmutableStructures(biome);
        List<Supplier<StructureFeature<?, ?>>> biomeFeatures = biome.getGenerationSettings().structures;
        biomeFeatures.add(() -> configuredStructure);
    }

    private static void convertImmutableStructures(Biome biome) {
        biome.getGenerationSettings().structures = new ArrayList<>(biome.getGenerationSettings().structures);
    }

    public static class PreserveBiomeOrder {
        private final Biome biome;
        private final int orderPosition;

        public PreserveBiomeOrder(Biome biome, int orderPosition) {
            this.biome = biome;
            this.orderPosition = orderPosition;
        }

        public Biome getBiome() {
            return biome;
        }

        public int getOrderPosition() {
            return orderPosition;
        }
    }
}
