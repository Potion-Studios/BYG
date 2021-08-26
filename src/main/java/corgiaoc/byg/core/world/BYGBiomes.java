package corgiaoc.byg.core.world;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.BYGOverworldBiomes;
import corgiaoc.byg.common.world.biome.EndBiomes;
import corgiaoc.byg.common.world.biome.NetherBiomes;
import corgiaoc.byg.common.world.biome.end.*;
import corgiaoc.byg.common.world.biome.end.sub.*;
import corgiaoc.byg.common.world.biome.nether.*;
import corgiaoc.byg.common.world.biome.overworld.*;
import corgiaoc.byg.common.world.biome.overworld.sub.*;
import corgiaoc.byg.common.world.biome.overworld.sub.beach.*;
import corgiaoc.byg.common.world.biome.overworld.sub.clearings.*;
import corgiaoc.byg.config.WorldConfig;
import corgiaoc.byg.config.json.biomedata.BiomeData;
import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.mixin.access.BiomeGenerationSettingsAccess;
import corgiaoc.byg.mixin.access.BiomesAccess;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static corgiaoc.byg.common.world.biome.BYGOverworldBiomes.*;

@SuppressWarnings("deprecation")
public class BYGBiomes {
    public static List<PreserveBiomeOrder> biomeList = new ArrayList<>();

    /************Primary Biomes************/
    public static ResourceKey<Biome> ALLIUM_FIELDS = WorldGenRegistrationHelper.createBiome("allium_fields", alliumFields(), 1);
    public static ResourceKey<Biome> AMARANTH_FIELDS = WorldGenRegistrationHelper.createBiome("amaranth_fields", amaranthFields(), 2);
    public static ResourceKey<Biome> ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("ancient_forest", ancientForest(), 3);
    public static ResourceKey<Biome> ARAUCARIA_SAVANNA = WorldGenRegistrationHelper.createBiome("araucaria_savanna", araucariaSavanna(), 4);
    public static ResourceKey<Biome> ASPEN_FOREST = WorldGenRegistrationHelper.createBiome("aspen_forest", aspenForest(), 5);
    public static ResourceKey<Biome> AUTUMNAL_VALLEY = WorldGenRegistrationHelper.createBiome("autumnal_valley", autumnalValley(), 6);
    public static ResourceKey<Biome> BAOBAB_SAVANNA = WorldGenRegistrationHelper.createBiome("baobab_savanna", baobabSavanna(), 7);
    public static ResourceKey<Biome> BAYOU = WorldGenRegistrationHelper.createBiome("bayou", bayou(), 8);
    public static ResourceKey<Biome> BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("blue_taiga", blueTaiga(), 9);
    public static ResourceKey<Biome> BLUFF_STEEPS = WorldGenRegistrationHelper.createBiome("bluff_steeps", bluffSteeps(), 10);
    public static ResourceKey<Biome> BOREAL_FOREST = WorldGenRegistrationHelper.createBiome("boreal_forest", borealForest(), 11);
    public static ResourceKey<Biome> CHERRY_BLOSSOM_FOREST = WorldGenRegistrationHelper.createBiome("cherry_blossom_forest", cherryBlossomForest(), 15);
    public static ResourceKey<Biome> CIKA_WOODS = WorldGenRegistrationHelper.createBiome("cika_woods", cikaWoods(), 12);
    public static ResourceKey<Biome> CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("coniferous_forest", coniferousForest(false), 13);
    public static ResourceKey<Biome> CRAG_GARDENS = WorldGenRegistrationHelper.createBiome("crag_gardens", cragGardens(), 13);
    public static ResourceKey<Biome> CYPRESS_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("cypress_swamplands", cypressSwamplands(), 18);
    public static ResourceKey<Biome> DEAD_SEA = WorldGenRegistrationHelper.createBiome("dead_sea", deadSea(), 20);
    public static ResourceKey<Biome> DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("deciduous_forest", deciduousForest(false), 21);
    public static ResourceKey<Biome> DOVER_MOUNTAINS = WorldGenRegistrationHelper.createBiome("dover_mountains", doverMountains(), 19);
    public static ResourceKey<Biome> DUNES = WorldGenRegistrationHelper.createBiome("dunes", dunes(), 22);
    public static ResourceKey<Biome> EBONY_WOODS = WorldGenRegistrationHelper.createBiome("ebony_woods", ebonyWoods(), 23);
    public static ResourceKey<Biome> ENCHANTED_FOREST = WorldGenRegistrationHelper.createBiome("enchanted_forest", enchantedForest(), 24);
    public static ResourceKey<Biome> ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("enchanted_grove", enchantedGrove(), 30);

    public static ResourceKey<Biome> EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("evergreen_taiga", evergreenTaiga(false), 25);
    public static ResourceKey<Biome> GREAT_LAKES = WorldGenRegistrationHelper.createBiome("great_lakes", new GreatLakes().getBiome(), 28);
    public static ResourceKey<Biome> GROVE = WorldGenRegistrationHelper.createBiome("grove", new Grove().getBiome(), 29);
    public static ResourceKey<Biome> GUIANA_SHIELD = WorldGenRegistrationHelper.createBiome("guiana_shield", new GuianaShield().getBiome(), 31);
    public static ResourceKey<Biome> JACARANDA_FOREST = WorldGenRegistrationHelper.createBiome("jacaranda_forest", new JacarandaForest().getBiome(), 32);
    public static ResourceKey<Biome> MANGROVE_MARSHES = WorldGenRegistrationHelper.createBiome("mangrove_marshes", new MangroveMarshes().getBiome(), 33);
    public static ResourceKey<Biome> MAPLE_TAIGA = WorldGenRegistrationHelper.createBiome("maple_taiga", new MapleTaiga().getBiome(), 34);
    public static ResourceKey<Biome> MARSHLANDS = WorldGenRegistrationHelper.createBiome("marshlands", new MarshLands().getBiome(), 112);
    public static ResourceKey<Biome> MEADOW = WorldGenRegistrationHelper.createBiome("meadow", new Meadow().getBiome(), 35);
    public static ResourceKey<Biome> MOJAVE_DESERT = WorldGenRegistrationHelper.createBiome("mojave_desert", new MojaveDesert().getBiome(), 36);
    public static ResourceKey<Biome> LUSH_TUNDRA = WorldGenRegistrationHelper.createBiome("lush_tundra", new LushTundra().getBiome(), 37);
    public static ResourceKey<Biome> ORCHARD = WorldGenRegistrationHelper.createBiome("orchard", new Orchard().getBiome(), 38);
    public static ResourceKey<Biome> PRAIRIE = WorldGenRegistrationHelper.createBiome("prairie", new Prairie().getBiome(), 39);
    public static ResourceKey<Biome> RED_DESERT = WorldGenRegistrationHelper.createBiome("red_desert", new RedDesert().getBiome(), 40);
    public static ResourceKey<Biome> RED_DESERT_DUNES = WorldGenRegistrationHelper.createBiome("red_desert_dunes", new RedDesertDunes().getBiome(), 41);
    public static ResourceKey<Biome> RED_OAK_FOREST = WorldGenRegistrationHelper.createBiome("red_oak_forest", new RedOakForest().getBiome(), 42);
    public static ResourceKey<Biome> RED_ROCK_MOUNTAINS = WorldGenRegistrationHelper.createBiome("red_rock_mountains", new RedRockMountains().getBiome(), 43);
    public static ResourceKey<Biome> ROSE_FIELDS = WorldGenRegistrationHelper.createBiome("rose_fields", new RoseFields().getBiome(), 147);
    public static ResourceKey<Biome> SEASONAL_BIRCH_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_birch_forest", new SeasonalBirchForest().getBiome(), 44);
    public static ResourceKey<Biome> SEASONAL_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_forest", new SeasonalDeciduousForest().getBiome(), 45);
    public static ResourceKey<Biome> SEASONAL_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_forest", new SeasonalForest().getBiome(), 46);
    public static ResourceKey<Biome> SEASONAL_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_taiga", new SeasonalTaiga().getBiome(), 47);
    public static ResourceKey<Biome> SHATTERED_GLACIER = WorldGenRegistrationHelper.createBiome("shattered_glacier", new ShatteredGlacier().getBiome(), 48);
    public static ResourceKey<Biome> SHRUBLANDS = WorldGenRegistrationHelper.createBiome("shrublands", new ShrubLands().getBiome(), 49);
    public static ResourceKey<Biome> SIERRA_VALLEY = WorldGenRegistrationHelper.createBiome("sierra_valley", new SierraValley().getBiome(), 59);
    public static ResourceKey<Biome> SKYRIS_HIGHLANDS = WorldGenRegistrationHelper.createBiome("skyris_highlands", new SkyrisHighlands().getBiome(), 50);
    public static ResourceKey<Biome> REDWOOD_TROPICS = WorldGenRegistrationHelper.createBiome("redwood_tropics", new RedwoodTropics().getBiome(), 16);
    public static ResourceKey<Biome> SNOWY_BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_taiga", new SnowyBlueTaiga().getBiome(), 51);
    public static ResourceKey<Biome> SNOWY_CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_coniferous_forest", new SnowyConiferousForest().getBiome(), 52);
    public static ResourceKey<Biome> SNOWY_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_deciduous_forest", new SnowyDeciduousForest().getBiome(), 53);
    public static ResourceKey<Biome> SNOWY_EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_evergreen_taiga", new SnowyEvergreenTaiga().getBiome(), 54);
    public static ResourceKey<Biome> STONE_FOREST = WorldGenRegistrationHelper.createBiome("stone_forest", new StoneForest().getBiome(), 148);
    public static ResourceKey<Biome> THE_BLACK_FOREST = WorldGenRegistrationHelper.createBiome("the_black_forest", new TheBlackForest().getBiome(), 55);
    public static ResourceKey<Biome> TROPICAL_FUNGAL_RAINFOREST = WorldGenRegistrationHelper.createBiome("tropical_fungal_forest", new TropicalFungalRainForest().getBiome(), 56);
    public static ResourceKey<Biome> TROPICAL_ISLAND = WorldGenRegistrationHelper.createBiome("tropical_islands", new TropicalIslands().getBiome(), 140);
    public static ResourceKey<Biome> TROPICAL_RAINFOREST = WorldGenRegistrationHelper.createBiome("tropical_rainforest", new TropicalRainForest().getBiome(), 57);
    public static ResourceKey<Biome> TWILIGHT_VALLEY = WorldGenRegistrationHelper.createBiome("twilight_valley", new TwilightValley().getBiome(), 149);
    public static ResourceKey<Biome> WEEPING_WITCH_FOREST = WorldGenRegistrationHelper.createBiome("weeping_witch_forest", new WeepingWitchForest().getBiome(), 60);
    public static ResourceKey<Biome> WOODLANDS = WorldGenRegistrationHelper.createBiome("woodlands", new WoodLands().getBiome(), 61);
    public static ResourceKey<Biome> ZELKOVA_FOREST = WorldGenRegistrationHelper.createBiome("zelkova_forest", new ZelkovaForest().getBiome(), 62);


    /************Sub Biomes************/
    //Beaches
    public static ResourceKey<Biome> BASALT_BARRERA = WorldGenRegistrationHelper.createBiome("basalt_barrera", new BasaltBarrera().getBiome(), 150);
    public static ResourceKey<Biome> RAINBOW_BEACH = WorldGenRegistrationHelper.createBiome("rainbow_beach", new RainbowBeach().getBiome(), 139);
    public static ResourceKey<Biome> ROCKY_BEACH = WorldGenRegistrationHelper.createBiome("rocky_beach", new RockyBeach().getBiome(), 135);
    public static ResourceKey<Biome> SNOWY_ROCKY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_rocky_black_beach", new SnowyRockyBlackBeach().getBiome(), 136);
    public static ResourceKey<Biome> SNOWY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_black_beach", new SnowyBlackBeach().getBiome(), 137);
    public static ResourceKey<Biome> WHITE_BEACH = WorldGenRegistrationHelper.createBiome("white_beach", new WhiteBeach().getBiome(), 138);

    //Clearings
    public static ResourceKey<Biome> ASPEN_CLEARING = WorldGenRegistrationHelper.createBiome("aspen_clearing", new AspenClearing().getBiome(), 82);
    public static ResourceKey<Biome> BLACK_FOREST_CLEARING = WorldGenRegistrationHelper.createBiome("black_forest_clearing", new BlackForestClearing().getBiome(), 91);
    public static ResourceKey<Biome> BOREAL_CLEARING = WorldGenRegistrationHelper.createBiome("boreal_clearing", new BorealClearing().getBiome(), 83);
    public static ResourceKey<Biome> CHERRY_BLOSSOM_CLEARING = WorldGenRegistrationHelper.createBiome("cherry_blossom_clearing", new CherryBlossomClearing().getBiome(), 79);
    public static ResourceKey<Biome> CONIFEROUS_CLEARING = WorldGenRegistrationHelper.createBiome("coniferous_clearing", new ConiferousClearing().getBiome(), 80);
    public static ResourceKey<Biome> DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("deciduous_clearing", new DeciduousClearing().getBiome(), 84);
    public static ResourceKey<Biome> EVERGREEN_CLEARING = WorldGenRegistrationHelper.createBiome("evergreen_clearing", new EvergreenClearing().getBiome(), 73);
    public static ResourceKey<Biome> GUIANA_CLEARING = WorldGenRegistrationHelper.createBiome("guiana_clearing", new GuianaClearing().getBiome(), 86);
    public static ResourceKey<Biome> JACARANDA_CLEARING = WorldGenRegistrationHelper.createBiome("jacaranda_clearing", new JacarandaClearing().getBiome(), 87);
    public static ResourceKey<Biome> PRAIRIE_CLEARING = WorldGenRegistrationHelper.createBiome("prairie_clearing", new PrairieClearing().getBiome(), 115);
    public static ResourceKey<Biome> REDWOOD_CLEARING = WorldGenRegistrationHelper.createBiome("redwood_clearing", new RedwoodClearing().getBiome(), 63);
    public static ResourceKey<Biome> SEASONAL_DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_clearing", new SeasonalDeciduousClearing().getBiome(), 85);
    public static ResourceKey<Biome> SNOWY_CONIFEROUS_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_coniferous_clearing", new SnowyConiferousClearing().getBiome(), 88);
    public static ResourceKey<Biome> SNOWY_DECIDUOUS_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_deciduous_clearing", new SnowyDeciduousClearing().getBiome(), 89);
    public static ResourceKey<Biome> SNOWY_EVERGREEN_CLEARING = WorldGenRegistrationHelper.createBiome("snowy_evergreen_clearing", new SnowyEvergreenClearing().getBiome(), 69);
    public static ResourceKey<Biome> WEEPING_WTICH_CLEARING = WorldGenRegistrationHelper.createBiome("weeping_witch_clearing", new WeepingWitchClearing().getBiome(), 76);
    public static ResourceKey<Biome> ZELKOVA_CLEARING = WorldGenRegistrationHelper.createBiome("zelkova_clearing", new ZelkovaClearing().getBiome(), 81);

    //Flowering
    public static ResourceKey<Biome> FLOWERING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("flowering_ancient_forest", new FloweringAncientForest().getBiome(), 68);
    public static ResourceKey<Biome> FLOWERING_ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("flowering_enchanted_grove", new FloweringEnchantedGrove().getBiome(), 95);
    public static ResourceKey<Biome> FLOWERING_GROVE = WorldGenRegistrationHelper.createBiome("flowering_grove", new FloweringGrove().getBiome(), 94);
    public static ResourceKey<Biome> FLOWERING_MEADOW = WorldGenRegistrationHelper.createBiome("flowering_meadow", new FloweringMeadow().getBiome(), 133);

    //Forests
    public static ResourceKey<Biome> ARAUCARIA_FOREST = WorldGenRegistrationHelper.createBiome("araucaria_forest", new AraucariaForest().getBiome(), 152);
    public static ResourceKey<Biome> BAMBOO_FOREST = WorldGenRegistrationHelper.createBiome("bamboo_forest", new BambooForest().getBiome(), 78);
    public static ResourceKey<Biome> FOREST_FAULT = WorldGenRegistrationHelper.createBiome("forest_fault", new ForestFault().getBiome(), 93);
    public static ResourceKey<Biome> GLOWING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("glowing_ancient_forest", new GlowingAncientForest().getBiome(), 67);
    public static ResourceKey<Biome> NORTHERN_FOREST = WorldGenRegistrationHelper.createBiome("northern_forest", new NorthernForest().getBiome(), 96);
    public static ResourceKey<Biome> POINTY_STONE_FOREST = WorldGenRegistrationHelper.createBiome("pointed_stone_forest", new PointedStoneForest().getBiome(), 153);
    public static ResourceKey<Biome> PUMPKIN_FOREST = WorldGenRegistrationHelper.createBiome("pumpkin_forest", new PumpkinForest().getBiome(), 77);


    //Mountains
    public static ResourceKey<Biome> BLUFF_PEAKS = WorldGenRegistrationHelper.createBiome("bluff_peaks", new BluffPeaks().getBiome(), 103);
    public static ResourceKey<Biome> WOODED_RED_ROCK_MOUNTAINS = WorldGenRegistrationHelper.createBiome("wooded_red_rock_mountains", new WoodedRedRockMountains().getBiome(), 119);

    //Sub
    public static ResourceKey<Biome> BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("blue_giant_taiga", new BlueGiantTaiga().getBiome(), 102);
    public static ResourceKey<Biome> CORAL_MANGROVES = WorldGenRegistrationHelper.createBiome("coral_mangroves", new CoralMangroves().getBiome(), 65);
    public static ResourceKey<Biome> FUNGAL_PATCH = WorldGenRegistrationHelper.createBiome("fungal_patch", new FungalPatch().getBiome(), 75);
    public static ResourceKey<Biome> GREAT_LAKE_ISLES = WorldGenRegistrationHelper.createBiome("great_lake_isles", new GreatLakeIsles().getBiome(), 110);
    public static ResourceKey<Biome> LUSH_RED_DESERT = WorldGenRegistrationHelper.createBiome("lush_red_desert", new LushRedDesert().getBiome(), 97);
    public static ResourceKey<Biome> RED_ROCK_LOWLANDS = WorldGenRegistrationHelper.createBiome("red_rock_lowlands", new RedRockLowlands().getBiome(), 117);
    public static ResourceKey<Biome> RED_ROCK_HIGHLANDS = WorldGenRegistrationHelper.createBiome("red_rock_highlands", new RedRockHighlands().getBiome(), 118);
    public static ResourceKey<Biome> RED_SPRUCE_TAIGA = WorldGenRegistrationHelper.createBiome("red_spruce_taiga", new RedSpruceTaiga().getBiome(), 155);
    public static ResourceKey<Biome> SIERRA_RANGE = WorldGenRegistrationHelper.createBiome("sierra_range", new SierraRange().getBiome(), 98);
    public static ResourceKey<Biome> WOODED_GRASSLAND_PLATEAU = WorldGenRegistrationHelper.createBiome("wooded_grassland_plateau", new WoodedGrasslandPlateau().getBiome(), 131);
    public static ResourceKey<Biome> SNOWY_BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_giant_taiga", new SnowyBlueGiantTaiga().getBiome(), 125);
    public static ResourceKey<Biome> WOODED_MEADOW = WorldGenRegistrationHelper.createBiome("wooded_meadow", new WoodedMeadow().getBiome(), 134);
    public static ResourceKey<Biome> SKYRIS_HIGHLANDS_CLEARING = WorldGenRegistrationHelper.createBiome("skyris_highlands_clearing", new SkyrisHighlandsClearing().getBiome(), 180);
    public static ResourceKey<Biome> SKYRIS_PEAKS = WorldGenRegistrationHelper.createBiome("skyris_peaks", new SkyrisPeaks().getBiome(), 181);
    public static ResourceKey<Biome> SKYRIS_STEEPS = WorldGenRegistrationHelper.createBiome("skyris_steeps", new SkyrisSteeps().getBiome(), 182);
    public static ResourceKey<Biome> GUIANA_SPRINGS = WorldGenRegistrationHelper.createBiome("guiana_springs", new GuianaSprings().getBiome(), 183);

    //Mutations
    public static ResourceKey<Biome> SEASONAL_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_giant_taiga", new SeasonalGiantTaiga().getBiome(), 123);


    /************Nether Biomes************/
    public static ResourceKey<Biome> BRIMSTONE_CAVERNS = WorldGenRegistrationHelper.createBiome("brimstone_caverns", NetherBiomes.brimstoneCaverns(), 156);
    public static ResourceKey<Biome> CRIMSON_GARDENS = WorldGenRegistrationHelper.createBiome("crimson_gardens", NetherBiomes.crimsonGardens(), 157);
    public static ResourceKey<Biome> EMBUR_BOG = WorldGenRegistrationHelper.createBiome("embur_bog", NetherBiomes.emburBog(), 144);
    public static ResourceKey<Biome> GLOWSTONE_GARDENS = WorldGenRegistrationHelper.createBiome("glowstone_gardens", NetherBiomes.glowstoneGardens(), 143);
    public static ResourceKey<Biome> MAGMA_WASTES = WorldGenRegistrationHelper.createBiome("magma_wastes", NetherBiomes.magmaWastes(), 158);
    public static ResourceKey<Biome> SUBZERO_HYPOGEAL = WorldGenRegistrationHelper.createBiome("subzero_hypogeal", NetherBiomes.subzeroHypogeal(), 159);
    public static ResourceKey<Biome> SYTHIAN_TORRIDS = WorldGenRegistrationHelper.createBiome("sythian_torrids", NetherBiomes.sythianTorrids(), 142);
    public static ResourceKey<Biome> WARPED_DESERT = WorldGenRegistrationHelper.createBiome("warped_desert", NetherBiomes.warpedDesert(), 141);
    public static ResourceKey<Biome> WAILING_GARTH = WorldGenRegistrationHelper.createBiome("wailing_garth", NetherBiomes.wailingGarth(), 160);
    public static ResourceKey<Biome> WITHERING_WOODS = WorldGenRegistrationHelper.createBiome("withering_woods", NetherBiomes.witheringWoods(), 161);
    public static ResourceKey<Biome> WEEPING_MIRE = WorldGenRegistrationHelper.createBiome("weeping_mire", NetherBiomes.weepingMire(), 162);
    public static ResourceKey<Biome> QUARTZ_DESERT = WorldGenRegistrationHelper.createBiome("quartz_desert", NetherBiomes.quartzDesert(), 163);


    /************End Biomes************/
    public static ResourceKey<Biome> IVIS_FIELDS = WorldGenRegistrationHelper.createBiome("ivis_fields", EndBiomes.ivisFields(), 145);
    public static ResourceKey<Biome> NIGHTSHADE_FOREST = WorldGenRegistrationHelper.createBiome("nightshade_forest", EndBiomes.nightshadeForest(), 164);
    public static ResourceKey<Biome> ETHEREAL_ISLANDS = WorldGenRegistrationHelper.createBiome("ethereal_islands", EndBiomes.etherealIslands(), 165);
    public static ResourceKey<Biome> VISCAL_ISLES = WorldGenRegistrationHelper.createBiome("viscal_isles", EndBiomes.viscalIsles(), 166);
    public static ResourceKey<Biome> BULBIS_GARDENS = WorldGenRegistrationHelper.createBiome("bulbis_gardens", EndBiomes.bulbisGardens(), 167);
    public static ResourceKey<Biome> SHATTERED_DESERT = WorldGenRegistrationHelper.createBiome("shattered_desert", EndBiomes.shatteredDesert(), 168);
    public static ResourceKey<Biome> SHULKREN_FOREST = WorldGenRegistrationHelper.createBiome("shulkren_forest", EndBiomes.shulkrenForest(), 169);
    public static ResourceKey<Biome> PURPUR_PEAKS = WorldGenRegistrationHelper.createBiome("purpur_peaks", EndBiomes.purpurPeaks(), 170);
    public static ResourceKey<Biome> CRYPTIC_WASTES = WorldGenRegistrationHelper.createBiome("cryptic_wastes",EndBiomes.crypticWastes(), 171);
    public static ResourceKey<Biome> IMPARIUS_GROVE = WorldGenRegistrationHelper.createBiome("imparius_grove", EndBiomes.impariusGrove(), 178);

    /************End Sub-Biomes************/
    public static ResourceKey<Biome> SHATTERED_VISCAL_ISLES = WorldGenRegistrationHelper.createBiome("shattered_viscal_isles", EndBiomes.shatteredViscalIsles(), 173);
    public static ResourceKey<Biome> BULBIS_GARDENS_EDGE = WorldGenRegistrationHelper.createBiome("bulbis_gardens_edge", EndBiomes.bulbisGardensEdge(), 174);
    public static ResourceKey<Biome> ETHEREAL_FOREST = WorldGenRegistrationHelper.createBiome("ethereal_forest", EndBiomes.etherealForest(), 175);
    public static ResourceKey<Biome> ETHEREAL_CLEARING = WorldGenRegistrationHelper.createBiome("ethereal_clearing", EndBiomes.etherealClearing(), 176);
    public static ResourceKey<Biome> SHATTERED_DESERT_ISLES = WorldGenRegistrationHelper.createBiome("shattered_desert_isles", EndBiomes.shatteredDesertIsles(), 177);
    public static ResourceKey<Biome> IMPARIUS_CLEARING = WorldGenRegistrationHelper.createBiome("imparius_clearing", EndBiomes.impariusClearing(), 179);

    public static ResourceKey<Biome> CANYON_KEY;


    public static void init() {

    }

    @SuppressWarnings("ConstantConditions")
    public static void handleOverworldEntries(BiomeDataHolders.OverworldPrimaryBiomeDataHolder overworldPrimaryBiomeDataHolder) {
        overworldPrimaryBiomeDataHolder.getBiomeData().forEach(((biome, biomeData) -> {
            if (biomeData.getWeight() > 0) {
                OverworldBiomes.addContinentalBiome(ResourceKey.create(Registry.BIOME_REGISTRY, biome), biomeData.getClimate().getClimate(), biomeData.getWeight());
            }
        }));

        fillBiomeDictionary(overworldPrimaryBiomeDataHolder.getBiomeData());
        addBiomeNumericalIDs();
    }

    public static void fillBiomeDictionary(Map<ResourceLocation, ? extends BiomeData> biomeDataList) {
//        biomeDataList.forEach(((biome, biomeData) -> {
//            ResourceKey<Biome> biomeRegistryKey = ResourceKey.create(Registry.BIOME_REGISTRY, biome);
//            for (String dictionaryType : biomeData.getDictionaryTypes()) {
//                BiomeDictionary.addTypes(biomeRegistryKey, BiomeDictionary.Type.getType(dictionaryType));
//            }
//        }));
    }

    //used in MixinMinecraftServer
    public static void addBYGFeaturesToBiomes(Biome biome, ResourceKey<Biome> biomeKey) {
        ResourceLocation locationKey = biomeKey.location();

        if (biome.getBiomeCategory() != Biome.BiomeCategory.NETHER && biome.getBiomeCategory() != Biome.BiomeCategory.THEEND && biome.getBiomeCategory() != Biome.BiomeCategory.NONE) {
            if (locationKey.equals(Biomes.SOUL_SAND_VALLEY.location())) {
                addFeatureToBiome(biome, GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SOUL_SHROOM_SPORES);
            }

            if (biome.getBiomeCategory() == Biome.BiomeCategory.BEACH && biome.getBaseTemperature() > 0.15F) {
                addFeatureToBiome(biome, GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PALM_TREE);
            }

            if (biome.getBiomeCategory() != Biome.BiomeCategory.NETHER && biome.getBiomeCategory() != Biome.BiomeCategory.THEEND && biome.getBiomeCategory() != Biome.BiomeCategory.NONE) {
                addFeatureToBiome(biome, GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.REEDS);
                addFeatureToBiome(biome, GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.CATTAILS);
            }
        }
        if (WorldConfig.conditionPasses(BYG.worldConfig().pendoriteSpawns, biomeKey, biome)) {
            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_PENDORITE);
        }

        if (WorldConfig.conditionPasses(BYG.worldConfig().emeralditeSpawns, biomeKey, biome)) {
            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_EMERALDITE);
        }

        if (WorldConfig.conditionPasses(BYG.worldConfig().rockyStoneSpawns, biomeKey, biome)) {
            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_ROCKY_STONE);
        }
        if (WorldConfig.conditionPasses(BYG.worldConfig().ametrineSpawns, biomeKey, biome)) {
            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_AMETRINE);
        }
        if (WorldConfig.conditionPasses(BYG.worldConfig().buddingAmetrineSpawns, biomeKey, biome)) {
            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_AMETRINE_BUDDING);
        }
        if (WorldConfig.conditionPasses(BYG.worldConfig().scoriaSpawns, biomeKey, biome)) {
            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_SCORIA_STONE);
        }

        if (WorldConfig.conditionPasses(BYG.worldConfig().soapStoneSpawns, biomeKey, biome)) {
            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_SOAP_STONE);
        }
    }

    public static void addFeatureToBiomeFirst(Biome biome, ConfiguredFeature<?, ?> configuredFeature) {
        convertImmutableFeatures(biome);
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = ((BiomeGenerationSettingsAccess) biome.getGenerationSettings()).getFeatures();

        List<Supplier<ConfiguredFeature<?, ?>>> suppliers = biomeFeatures.get(GenerationStep.Decoration.RAW_GENERATION.ordinal());

        List<Supplier<ConfiguredFeature<?, ?>>> suppliersCopy = new ArrayList<>(suppliers);
        suppliers.clear();
        suppliers.add(() -> configuredFeature);
        suppliers.addAll(suppliersCopy);
    }

    //Use these to add our features to vanilla's biomes.
    public static void addFeatureToBiome(Biome biome, GenerationStep.Decoration feature, ConfiguredFeature<?, ?> configuredFeature) {
        convertImmutableFeatures(biome);
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = ((BiomeGenerationSettingsAccess) biome.getGenerationSettings()).getFeatures();
        while (biomeFeatures.size() <= feature.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        biomeFeatures.get(feature.ordinal()).add(() -> configuredFeature);
    }

    private static void convertImmutableFeatures(Biome biome) {
        List<List<Supplier<ConfiguredFeature<?, ?>>>> features = ((BiomeGenerationSettingsAccess) biome.getGenerationSettings()).getFeatures();
        if (features instanceof ImmutableList) {
            ((BiomeGenerationSettingsAccess) biome.getGenerationSettings()).setFeatures(features.stream().map(Lists::newArrayList).collect(Collectors.toList()));
        }
    }

    //Use these to add our features to vanilla's biomes.
    public static void addStructureToBiome(Biome biome, ConfiguredStructureFeature<?, ?> configuredStructure) {
        convertImmutableStructures(biome);
        List<Supplier<ConfiguredStructureFeature<?, ?>>> biomeFeatures = ((BiomeGenerationSettingsAccess) biome.getGenerationSettings()).getStructureStarts();
        biomeFeatures.add(() -> configuredStructure);
    }

    private static void convertImmutableStructures(Biome biome) {
        ((BiomeGenerationSettingsAccess) biome.getGenerationSettings()).setStructureStarts(new ArrayList<>(((BiomeGenerationSettingsAccess) biome.getGenerationSettings()).getStructureStarts()));
    }

    //Why? This is how worldtype's using the BiomeLayerSampler get the numerical ID's to sample.
    public static void addBiomeNumericalIDs() {
        BYG.LOGGER.info("Adding Numerical Biome ID's");
        for (PreserveBiomeOrder biome : biomeList) {
            Optional<ResourceKey<Biome>> key = BuiltinRegistries.BIOME.getResourceKey(biome.getBiome());
            if (key.isPresent())
                key.ifPresent(biomeRegistryKey -> BiomesAccess.getIDNameMap().put(BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(key.get())), biomeRegistryKey));
        }
        BYG.LOGGER.info("Added Numerical Biome ID's!");

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
