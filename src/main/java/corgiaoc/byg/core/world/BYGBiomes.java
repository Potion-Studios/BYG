package corgiaoc.byg.core.world;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.EndBiomes;
import corgiaoc.byg.common.world.biome.NetherBiomes;
import corgiaoc.byg.config.BYGBiomeWorldProperties;
import corgiaoc.byg.config.WorldConfig;
import corgiaoc.byg.config.json.BYGConfigHandler;
import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.mixin.access.BiomeGenerationSettingsAccess;
import corgiaoc.byg.mixin.access.BiomesAccess;
import corgiaoc.byg.util.MLClimate;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static corgiaoc.byg.common.world.biome.BYGOverworldBiomes.*;

@SuppressWarnings("deprecation")
public class BYGBiomes {
    public static List<PreserveBiomeOrder> biomeList = new ArrayList<>();

    public static final Map<ResourceKey<Biome>, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>>> OVERWORLD_HILLS = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceKey<Biome>, ResourceKey<Biome>> OVERWORLD_EDGES = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceKey<Biome>, ResourceKey<Biome>> OVERWORLD_BEACHES = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceKey<Biome>, ResourceKey<Biome>> OVERWORLD_RIVERS = new Object2ObjectOpenHashMap<>();

    /************Primary Biomes************/
    public static ResourceKey<Biome> ALLIUM_FIELDS = WorldGenRegistrationHelper.createBiome("allium_fields", alliumFields(), 1);
    public static ResourceKey<Biome> AMARANTH_FIELDS = WorldGenRegistrationHelper.createBiome("amaranth_fields", amaranthFields(), 2);
    public static ResourceKey<Biome> ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("ancient_forest", ancientForest(false, false), 3);
    public static ResourceKey<Biome> ARAUCARIA_SAVANNA = WorldGenRegistrationHelper.createBiome("araucaria_savanna", araucariaSavanna(false), 4);
    public static ResourceKey<Biome> ASPEN_FOREST = WorldGenRegistrationHelper.createBiome("aspen_forest", aspenForest(), 5);
    public static ResourceKey<Biome> AUTUMNAL_VALLEY = WorldGenRegistrationHelper.createBiome("autumnal_valley", autumnalValley(), 6);
    public static ResourceKey<Biome> BAOBAB_SAVANNA = WorldGenRegistrationHelper.createBiome("baobab_savanna", baobabSavanna(), 7);
    public static ResourceKey<Biome> BAYOU = WorldGenRegistrationHelper.createBiome("bayou", bayou(), 8);
    public static ResourceKey<Biome> BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("blue_taiga", blueTaiga(false, false), 9);
    public static ResourceKey<Biome> BLUFF_STEEPS = WorldGenRegistrationHelper.createBiome("bluff_steeps", bluffSteeps(false), 10);
    public static ResourceKey<Biome> BOREAL_FOREST = WorldGenRegistrationHelper.createBiome("boreal_forest", borealForest(), 11);
    public static ResourceKey<Biome> CHERRY_BLOSSOM_FOREST = WorldGenRegistrationHelper.createBiome("cherry_blossom_forest", cherryBlossomForest(), 15);
    public static ResourceKey<Biome> CIKA_WOODS = WorldGenRegistrationHelper.createBiome("cika_woods", cikaWoods(), 12);
    public static ResourceKey<Biome> CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("coniferous_forest", coniferousForest(false), 13);
    public static ResourceKey<Biome> CRAG_GARDENS = WorldGenRegistrationHelper.createBiome("crag_gardens", cragGardens(), 13);
    public static ResourceKey<Biome> CYPRESS_SWAMPLANDS = WorldGenRegistrationHelper.createBiome("cypress_swamplands", cypressSwamplands(), 18);
    public static ResourceKey<Biome> DEAD_SEA = WorldGenRegistrationHelper.createBiome("dead_sea", deadSea(), 20);
    public static ResourceKey<Biome> DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("deciduous_forest", deciduousForest(false), 21);
    public static ResourceKey<Biome> DOVER_MOUNTAINS = WorldGenRegistrationHelper.createBiome("dover_mountains", doverMountains(), 19);
    public static ResourceKey<Biome> DUNES = WorldGenRegistrationHelper.createBiome("dunes", dunes(false), 22);
    public static ResourceKey<Biome> EBONY_WOODS = WorldGenRegistrationHelper.createBiome("ebony_woods", ebonyWoods(), 23);
    public static ResourceKey<Biome> ENCHANTED_FOREST = WorldGenRegistrationHelper.createBiome("enchanted_forest", enchantedForest(), 24);
    public static ResourceKey<Biome> ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("enchanted_grove", enchantedGrove(false), 30);

    public static ResourceKey<Biome> EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("evergreen_taiga", evergreenTaiga(false), 25);
    public static ResourceKey<Biome> GREAT_LAKES = WorldGenRegistrationHelper.createBiome("great_lakes", greatLakes(), 28);
    public static ResourceKey<Biome> GROVE = WorldGenRegistrationHelper.createBiome("grove", grove(false), 29);
    public static ResourceKey<Biome> GUIANA_SHIELD = WorldGenRegistrationHelper.createBiome("guiana_shield", guianaShield(), 31);
    public static ResourceKey<Biome> JACARANDA_FOREST = WorldGenRegistrationHelper.createBiome("jacaranda_forest", jacarandaForest(), 32);
    public static ResourceKey<Biome> MANGROVE_MARSHES = WorldGenRegistrationHelper.createBiome("mangrove_marshes", mangroveMarshes(), 33);
    public static ResourceKey<Biome> MAPLE_TAIGA = WorldGenRegistrationHelper.createBiome("maple_taiga", mapleTaiga(), 34);
    public static ResourceKey<Biome> MARSHLANDS = WorldGenRegistrationHelper.createBiome("marshlands", marshlands(), 112);
    public static ResourceKey<Biome> MEADOW = WorldGenRegistrationHelper.createBiome("meadow", meadow(false, false), 35);
    public static ResourceKey<Biome> MOJAVE_DESERT = WorldGenRegistrationHelper.createBiome("mojave_desert", mojaveDesert(), 36);
    public static ResourceKey<Biome> LUSH_TUNDRA = WorldGenRegistrationHelper.createBiome("lush_tundra", lushTundra(), 37);
    public static ResourceKey<Biome> ORCHARD = WorldGenRegistrationHelper.createBiome("orchard", orchard(), 38);
    public static ResourceKey<Biome> PRAIRIE = WorldGenRegistrationHelper.createBiome("prairie", prairie(), 39);
    public static ResourceKey<Biome> RED_DESERT = WorldGenRegistrationHelper.createBiome("red_desert", redDesert(false), 40);
    public static ResourceKey<Biome> RED_OAK_FOREST = WorldGenRegistrationHelper.createBiome("red_oak_forest", redOakForest(), 42);
    public static ResourceKey<Biome> RED_ROCK_VALLEY = WorldGenRegistrationHelper.createBiome("red_rock_valley", redRockValley(), 9495858);

    public static ResourceKey<Biome> ROSE_FIELDS = WorldGenRegistrationHelper.createBiome("rose_fields", roseFields(), 147);
    public static ResourceKey<Biome> SEASONAL_BIRCH_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_birch_forest", seasonalBirchForest(), 44);
    public static ResourceKey<Biome> SEASONAL_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_deciduous_forest", seasonalDeciduousForest(), 45);
    public static ResourceKey<Biome> SEASONAL_FOREST = WorldGenRegistrationHelper.createBiome("seasonal_forest", seasonalForest(), 46);
    public static ResourceKey<Biome> SEASONAL_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_taiga", seasonalTaiga(false), 47);
    public static ResourceKey<Biome> SHATTERED_GLACIER = WorldGenRegistrationHelper.createBiome("shattered_glacier", shatteredGlacier(), 48);
    public static ResourceKey<Biome> SHRUBLANDS = WorldGenRegistrationHelper.createBiome("shrublands", shrublands(), 49);
    public static ResourceKey<Biome> SIERRA_VALLEY = WorldGenRegistrationHelper.createBiome("sierra_valley", sierraValley(), 59);
    public static ResourceKey<Biome> SKYRIS_HIGHLANDS = WorldGenRegistrationHelper.createBiome("skyris_highlands", skyrisHighlands(), 50);
    public static ResourceKey<Biome> REDWOOD_THICKET = WorldGenRegistrationHelper.createBiome("redwood_thicket", redwoodThicket(), 16);
    public static ResourceKey<Biome> SNOWY_BLUE_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_taiga", blueTaiga(true, false), 51);
    public static ResourceKey<Biome> SNOWY_CONIFEROUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_coniferous_forest", coniferousForest(true), 52);
    public static ResourceKey<Biome> SNOWY_DECIDUOUS_FOREST = WorldGenRegistrationHelper.createBiome("snowy_deciduous_forest", deciduousForest(true), 53);
    public static ResourceKey<Biome> SNOWY_EVERGREEN_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_evergreen_taiga", evergreenTaiga(true), 54);
    public static ResourceKey<Biome> STONE_FOREST = WorldGenRegistrationHelper.createBiome("fragment_forest", fragmentForest(false), 148);
    public static ResourceKey<Biome> THE_BLACK_FOREST = WorldGenRegistrationHelper.createBiome("black_forest", blackForest(), 55);
    public static ResourceKey<Biome> TROPICAL_ISLAND = WorldGenRegistrationHelper.createBiome("tropical_islands", tropicalForest(), 140);
    public static ResourceKey<Biome> TROPICAL_RAINFOREST = WorldGenRegistrationHelper.createBiome("tropical_rainforest", tropicalForest(), 57);
    public static ResourceKey<Biome> TWILIGHT_VALLEY = WorldGenRegistrationHelper.createBiome("twilight_valley", twilightValley(), 149);
    public static ResourceKey<Biome> WEEPING_WITCH_FOREST = WorldGenRegistrationHelper.createBiome("weeping_witch_forest", weepingWitchForest(), 60);
    public static ResourceKey<Biome> WOODLANDS = WorldGenRegistrationHelper.createBiome("woodlands", temperateRainForest(), 61);
    public static ResourceKey<Biome> ZELKOVA_FOREST = WorldGenRegistrationHelper.createBiome("zelkova_forest", zelkovaForest(), 62);


    /************Sub Biomes************/
    //Beaches
    public static ResourceKey<Biome> BASALT_BARRERA = WorldGenRegistrationHelper.createBiome("basalt_barrera", basaltBarrera(), 150);
    public static ResourceKey<Biome> RAINBOW_BEACH = WorldGenRegistrationHelper.createBiome("rainbow_beach", rainbowBeach(), 139);
    public static ResourceKey<Biome> ROCKY_BEACH = WorldGenRegistrationHelper.createBiome("rocky_beach", rockyBeach(), 135);
    public static ResourceKey<Biome> SNOWY_ROCKY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_rocky_black_beach", snowyBlackBeach(true), 136);
    public static ResourceKey<Biome> SNOWY_BLACK_BEACH = WorldGenRegistrationHelper.createBiome("snowy_black_beach", snowyBlackBeach(false), 137);
    public static ResourceKey<Biome> WHITE_BEACH = WorldGenRegistrationHelper.createBiome("white_beach", whiteBeach(), 138);

    //Flowering
    public static ResourceKey<Biome> FLOWERING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("flowering_ancient_forest", ancientForest(true, false), 68);
    public static ResourceKey<Biome> FLOWERING_ENCHANTED_GROVE = WorldGenRegistrationHelper.createBiome("flowering_enchanted_grove", enchantedGrove(true), 95);
    public static ResourceKey<Biome> FLOWERING_GROVE = WorldGenRegistrationHelper.createBiome("flowering_grove", grove(true), 94);
    public static ResourceKey<Biome> FLOWERING_MEADOW = WorldGenRegistrationHelper.createBiome("flowering_meadow", meadow(true, false), 133);

    //Forests
    public static ResourceKey<Biome> ARAUCARIA_FOREST = WorldGenRegistrationHelper.createBiome("araucaria_forest", araucariaSavanna(true), 152);
    public static ResourceKey<Biome> BAMBOO_FOREST = WorldGenRegistrationHelper.createBiome("bamboo_forest", bambooForest(), 78);
    public static ResourceKey<Biome> FOREST_FAULT = WorldGenRegistrationHelper.createBiome("forest_fault", forestFault(), 93);
    public static ResourceKey<Biome> GLOWING_ANCIENT_FOREST = WorldGenRegistrationHelper.createBiome("glowing_ancient_forest", ancientForest(false, true), 67);
    public static ResourceKey<Biome> NORTHERN_FOREST = WorldGenRegistrationHelper.createBiome("northern_forest", northernForest(), 96);
    public static ResourceKey<Biome> POINTY_STONE_FOREST = WorldGenRegistrationHelper.createBiome("pointed_fragment_forest", fragmentForest(true), 153);
    public static ResourceKey<Biome> PUMPKIN_FOREST = WorldGenRegistrationHelper.createBiome("pumpkin_forest", pumpkinForest(), 77);


    //Mountains
    public static ResourceKey<Biome> BLUFF_PEAKS = WorldGenRegistrationHelper.createBiome("bluff_peaks", bluffSteeps(true), 103);

    //Sub
    public static ResourceKey<Biome> BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("blue_giant_taiga", blueTaiga(false, true), 102);
    public static ResourceKey<Biome> CORAL_MANGROVES = WorldGenRegistrationHelper.createBiome("coral_mangroves", coralMangroves(), 65);
    public static ResourceKey<Biome> FUNGAL_PATCH = WorldGenRegistrationHelper.createBiome("fungal_patch", fungalPatch(), 75);
    public static ResourceKey<Biome> GREAT_LAKE_ISLES = WorldGenRegistrationHelper.createBiome("great_lake_isles", greatLakeIsles(), 110);
    public static ResourceKey<Biome> LUSH_RED_DESERT = WorldGenRegistrationHelper.createBiome("lush_red_desert", redDesert(true), 97);
    public static ResourceKey<Biome> RED_SPRUCE_TAIGA = WorldGenRegistrationHelper.createBiome("red_spruce_taiga", redTaiga(), 155);
    public static ResourceKey<Biome> SNOWY_BLUE_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("snowy_blue_giant_taiga", blueTaiga(true, true), 125);
    public static ResourceKey<Biome> WOODED_MEADOW = WorldGenRegistrationHelper.createBiome("wooded_meadow", meadow(false, true), 134);

    //Mutations
    public static ResourceKey<Biome> SEASONAL_GIANT_TAIGA = WorldGenRegistrationHelper.createBiome("seasonal_giant_taiga", seasonalTaiga(true), 123);


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
    public static ResourceKey<Biome> CRYPTIC_WASTES = WorldGenRegistrationHelper.createBiome("cryptic_wastes", EndBiomes.crypticWastes(), 171);
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

    public static void handleOverworldEntries() {
        BiomeDataHolders.OverworldPrimaryBiomeDataHolder overworldPrimaryBiomeDataHolder = BYGConfigHandler.processAndGetFromCodec(BYG.CONFIG_PATH.resolve("byg-biomes.json"), BYGBiomeWorldProperties.OVERWORLD_DEFAULTS, BiomeDataHolders.OverworldPrimaryBiomeDataHolder.CODEC);
        overworldPrimaryBiomeDataHolder.getBiomeData().forEach(((key, overworldPrimaryBiomeData) -> {
            OverworldBiomes.addContinentalBiome(key, MLClimate.COOL.getClimate(), overworldPrimaryBiomeData.getWeight());
            OVERWORLD_HILLS.put(key, overworldPrimaryBiomeData.getSubBiomes());
            ResourceKey<Biome> beach = overworldPrimaryBiomeData.getBeach();
            if (beach != BYG.EMPTY) {
                OVERWORLD_BEACHES.put(key, beach);
            }
            ResourceKey<Biome> edgeBiome = overworldPrimaryBiomeData.getEdgeBiome();
            if (edgeBiome != BYG.EMPTY) {
                OVERWORLD_EDGES.put(key, edgeBiome);
            }

            ResourceKey<Biome> riverBiome = overworldPrimaryBiomeData.getRiver();
            if (riverBiome != BYG.EMPTY) {
                OVERWORLD_RIVERS.put(key, riverBiome);
            }
        }));

        addBiomeNumericalIDs();
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
            BiomesAccess.getIDNameMap().put(BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(biome.getKey())), biome.getKey());
        }
        BYG.LOGGER.info("Added Numerical Biome ID's!");

    }

    public static class PreserveBiomeOrder {
        private final ResourceKey<Biome> key;
        private final Biome biome;
        private final int orderPosition;

        public PreserveBiomeOrder(ResourceKey<Biome> key, Biome biome, int orderPosition) {
            this.key = key;

            this.biome = biome;
            this.orderPosition = orderPosition;
        }

        public Biome getBiome() {
            return biome;
        }

        public int getOrderPosition() {
            return orderPosition;
        }

        public ResourceKey<Biome> getKey() {
            return key;
        }
    }
}
