package potionstudios.byg.common.world.biome;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.BiomeGenerationSettingsAccess;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static potionstudios.byg.common.world.biome.BYGOverworldBiomes.*;

@SuppressWarnings("deprecation")
public class BYGBiomes {

    public static final List<RegistryObject<Biome>> BIOMES = new ArrayList<>();

    /************Primary Biomes************/
    public static ResourceKey<Biome> ALLIUM_FIELDS = createBiome("allium_fields", alliumFields());
    public static ResourceKey<Biome> AMARANTH_FIELDS = createBiome("amaranth_fields", amaranthFields());
    public static ResourceKey<Biome> ARAUCARIA_SAVANNA = createBiome("araucaria_savanna", araucariaSavanna(false));
    public static ResourceKey<Biome> ASPEN_FOREST = createBiome("aspen_forest", aspenForest());
    public static ResourceKey<Biome> AUTUMNAL_VALLEY = createBiome("autumnal_valley", autumnalValley());
    public static ResourceKey<Biome> BAOBAB_SAVANNA = createBiome("baobab_savanna", baobabSavanna());
    public static ResourceKey<Biome> BAYOU = createBiome("bayou", bayou());
    public static ResourceKey<Biome> BLACK_FOREST = createBiome("black_forest", blackForest());
    public static ResourceKey<Biome> BOREALIS_GROVE = createBiome("borealis_grove", borealisGrove());
    public static ResourceKey<Biome> CANADIAN_SHIELD = createBiome("canadian_shield", canadianShield());
    public static ResourceKey<Biome> CHERRY_BLOSSOM_FOREST = createBiome("cherry_blossom_forest", cherryBlossomForest());
    public static ResourceKey<Biome> CIKA_WOODS = createBiome("cika_woods", cikaWoods());
    public static ResourceKey<Biome> CONIFEROUS_FOREST = createBiome("coniferous_forest", coniferousForest(false));
//    public static ResourceKey<Biome> CRAG_GARDENS = createBiome("crag_gardens", cragGardens());
    public static ResourceKey<Biome> CYPRESS_SWAMPLANDS = createBiome("cypress_swamplands", cypressSwamplands());
    public static ResourceKey<Biome> DEAD_SEA = createBiome("dead_sea", deadSea());
    public static ResourceKey<Biome> DACITE_RIDGES = createBiome("dacite_ridges", daciteRidges());
//    public static ResourceKey<Biome> WINDSWEPT_DUNES = createBiome("windswept_dunes", windsweptDunes());
    public static ResourceKey<Biome> EBONY_WOODS = createBiome("ebony_woods", ebonyWoods());
//    public static ResourceKey<Biome> ENCHANTED_GROVE = createBiome("enchanted_grove", enchantedGrove(false));
    public static ResourceKey<Biome> FORGOTTEN_FOREST = createBiome("forgotten_forest", forgottenForest());
//    public static ResourceKey<Biome> GREAT_LAKES = createBiome("great_lakes", greatLakes());
    public static ResourceKey<Biome> GROVE = createBiome("temperate_grove", temperateGrove(false));
    public static ResourceKey<Biome> GUIANA_SHIELD = createBiome("guiana_shield", guianaShield());
    public static ResourceKey<Biome> JACARANDA_FOREST = createBiome("jacaranda_forest", jacarandaForest());
    public static ResourceKey<Biome> MAPLE_TAIGA = createBiome("maple_taiga", mapleTaiga());
    public static ResourceKey<Biome> COCONINO_MEADOW = createBiome("coconino_meadow", coconinoMeadow(false, false));
    public static ResourceKey<Biome> MOJAVE_DESERT = createBiome("mojave_desert", mojaveDesert());
//    public static ResourceKey<Biome> LUSH_TUNDRA = createBiome("lush_tundra", lushTundra());
    public static ResourceKey<Biome> ORCHARD = createBiome("orchard", orchard());
    public static ResourceKey<Biome> PRAIRIE = createBiome("prairie", prairie());
    public static ResourceKey<Biome> RED_OAK_FOREST = createBiome("red_oak_forest", redOakForest());
//    public static ResourceKey<Biome> RED_ROCK_VALLEY = createBiome("red_rock_valley", redRockValley());
    public static ResourceKey<Biome> ROSE_FIELDS = createBiome("rose_fields", roseFields());
    public static ResourceKey<Biome> AUTUMNAL_FOREST = createBiome("autumnal_forest", autumnalForest());
//    public static ResourceKey<Biome> AUTUMNAL_TAIGA = createBiome("autumnal_taiga", autumnalTaiga(false));
//    public static ResourceKey<Biome> SHATTERED_GLACIER = createBiome("shattered_glacier", shatteredGlacier());
//    public static ResourceKey<Biome> FIRE_CRACKER_SHRUBLANDS = createBiome("firecracker_shrublands", firecrackerShrublands());
//    public static ResourceKey<Biome> SIERRA_VALLEY = createBiome("sierra_valley", sierraValley());
//    public static ResourceKey<Biome> SKYRIS_VALE = createBiome("skyris_vale", skyrisVale());
    public static ResourceKey<Biome> REDWOOD_THICKET = createBiome("redwood_thicket", redwoodThicket());
//    public static ResourceKey<Biome> FROSTED_TAIGA = createBiome("frosted_taiga", frostedTaiga(true, false));
//    public static ResourceKey<Biome> SNOWY_CONIFEROUS_FOREST = createBiome("snowy_coniferous_forest", coniferousForest(true));
//    public static ResourceKey<Biome> STONE_FOREST = createBiome("fragment_forest", fragmentForest(false));
//    public static ResourceKey<Biome> TROPICAL_ISLAND = createBiome("tropical_islands", tropicalForest());
//    public static ResourceKey<Biome> TROPICAL_RAINFOREST = createBiome("tropical_rainforest", tropicalForest());
//    public static ResourceKey<Biome> TWILIGHT_VALLEY = createBiome("twilight_valley", twilightValley());
//    public static ResourceKey<Biome> WEEPING_WITCH_FOREST = createBiome("weeping_witch_forest", weepingWitchForest());
//    public static ResourceKey<Biome> WHITE_MANGROVE_MARSHES = createBiome("white_mangrove_marshes", whiteMangroveMarshes()); //TODO: Trees are floating and need to be fixed.
//    public static ResourceKey<Biome> WOODLANDS = createBiome("woodlands", temperateRainForest());
//    public static ResourceKey<Biome> ZELKOVA_FOREST = createBiome("zelkova_forest", zelkovaForest());
//
//    /************Sub Biomes************/
//    //Beaches
//    public static ResourceKey<Biome> BASALT_BARRERA = createBiome("basalt_barrera", basaltBarrera());
//    public static ResourceKey<Biome> RAINBOW_BEACH = createBiome("rainbow_beach", rainbowBeach());
//    public static ResourceKey<Biome> ROCKY_BEACH = createBiome("rocky_beach", rockyBeach());
//    public static ResourceKey<Biome> SNOWY_ROCKY_BLACK_BEACH = createBiome("snowy_rocky_black_beach", snowyBlackBeach(true));
//    public static ResourceKey<Biome> SNOWY_BLACK_BEACH = createBiome("snowy_black_beach", snowyBlackBeach(false));
//    public static ResourceKey<Biome> WHITE_BEACH = createBiome("white_beach", whiteBeach());
//
//    //Flowering
//    public static ResourceKey<Biome> FLOWERING_ENCHANTED_GROVE = createBiome("flowering_enchanted_grove", enchantedGrove(true));
//    public static ResourceKey<Biome> FLOWERING_GROVE = createBiome("flowering_grove", grove(true));
//    public static ResourceKey<Biome> FLOWERING_COCONINO_MEADOW = createBiome("flowering_coconino_meadow", coconinoMeadow(true, false));
//
//    //Forests
//    public static ResourceKey<Biome> ARAUCARIA_FOREST = createBiome("araucaria_forest", araucariaSavanna(true));
//    public static ResourceKey<Biome> FOREST_FAULT = createBiome("forest_fault", forestFault());
//    public static ResourceKey<Biome> NORTHERN_FOREST = createBiome("northern_forest", northernForest());
//    public static ResourceKey<Biome> POINTY_STONE_FOREST = createBiome("pointed_fragment_forest", fragmentForest(true));
//    public static ResourceKey<Biome> PUMPKIN_FOREST = createBiome("pumpkin_forest", pumpkinForest());
//
//
//    //Mountains
//    public static ResourceKey<Biome> BLUFF_PEAKS = createBiome("bluff_peaks", bluffSteeps(true));
//
//    //Sub
//    public static ResourceKey<Biome> FROSTED_GIANT_TAIGA = createBiome("frosted_giant_taiga", frostedTaiga(true, true));
//    public static ResourceKey<Biome> CORAL_MANGROVES = createBiome("coral_mangroves", coralMangroves());
//    public static ResourceKey<Biome> FUNGAL_PATCH = createBiome("fungal_patch", fungalPatch());
//    public static ResourceKey<Biome> GREAT_LAKE_ISLES = createBiome("great_lake_isles", greatLakeIsles());
//    public static ResourceKey<Biome> LUSH_RED_DESERT = createBiome("lush_red_desert", redDesert(true));
//    public static ResourceKey<Biome> RED_SPRUCE_TAIGA = createBiome("red_spruce_taiga", redTaiga());
//    public static ResourceKey<Biome> WOODED_COCONINO_MEADOW = createBiome("wooded_coconino_meadow", coconinoMeadow(false, true));
//
//    //Mutations
//    public static ResourceKey<Biome> AUTUMNAL_GIANT_TAIGA = createBiome("autumnal_giant_taiga", autumnalTaiga(true));
//
//
//    /************Nether Biomes************/
//    public static ResourceKey<Biome> BRIMSTONE_CAVERNS = createBiome("brimstone_caverns", NetherBiomes.brimstoneCaverns());
//    public static ResourceKey<Biome> CRIMSON_GARDENS = createBiome("crimson_gardens", NetherBiomes.crimsonGardens());
//    public static ResourceKey<Biome> EMBUR_BOG = createBiome("embur_bog", NetherBiomes.emburBog());
//    public static ResourceKey<Biome> GLOWSTONE_GARDENS = createBiome("glowstone_gardens", NetherBiomes.glowstoneGardens());
//    public static ResourceKey<Biome> MAGMA_WASTES = createBiome("magma_wastes", NetherBiomes.magmaWastes());
//    public static ResourceKey<Biome> SUBZERO_HYPOGEAL = createBiome("subzero_hypogeal", NetherBiomes.subzeroHypogeal());
//    public static ResourceKey<Biome> SYTHIAN_TORRIDS = createBiome("sythian_torrids", NetherBiomes.sythianTorrids());
//    public static ResourceKey<Biome> WARPED_DESERT = createBiome("warped_desert", NetherBiomes.warpedDesert());
//    public static ResourceKey<Biome> WAILING_GARTH = createBiome("wailing_garth", NetherBiomes.wailingGarth());
//    public static ResourceKey<Biome> WITHERING_WOODS = createBiome("withering_woods", NetherBiomes.witheringWoods());
//    public static ResourceKey<Biome> WEEPING_MIRE = createBiome("weeping_mire", NetherBiomes.weepingMire());
//    public static ResourceKey<Biome> QUARTZ_DESERT = createBiome("quartz_desert", NetherBiomes.quartzDesert());
//
//
//    /************End Biomes************/
//    public static ResourceKey<Biome> IVIS_FIELDS = createBiome("ivis_fields", EndBiomes.ivisFields());
//    public static ResourceKey<Biome> NIGHTSHADE_FOREST = createBiome("nightshade_forest", EndBiomes.nightshadeForest());
//    public static ResourceKey<Biome> ETHEREAL_ISLANDS = createBiome("ethereal_islands", EndBiomes.etherealIslands());
//    public static ResourceKey<Biome> VISCAL_ISLES = createBiome("viscal_isles", EndBiomes.viscalIsles());
//    public static ResourceKey<Biome> BULBIS_GARDENS = createBiome("bulbis_gardens", EndBiomes.bulbisGardens());
//    public static ResourceKey<Biome> SHATTERED_DESERT = createBiome("shattered_desert", EndBiomes.shatteredDesert());
//    public static ResourceKey<Biome> SHULKREN_FOREST = createBiome("shulkren_forest", EndBiomes.shulkrenForest());
//    public static ResourceKey<Biome> PURPUR_PEAKS = createBiome("purpur_peaks", EndBiomes.purpurPeaks());
//    public static ResourceKey<Biome> CRYPTIC_WASTES = createBiome("cryptic_wastes", EndBiomes.crypticWastes());
//    public static ResourceKey<Biome> IMPARIUS_GROVE = createBiome("imparius_grove", EndBiomes.impariusGrove());
//
//    /************End Sub-Biomes************/
//    public static ResourceKey<Biome> SHATTERED_VISCAL_ISLES = createBiome("shattered_viscal_isles", EndBiomes.shatteredViscalIsles());
//    public static ResourceKey<Biome> BULBIS_GARDENS_EDGE = createBiome("bulbis_gardens_edge", EndBiomes.bulbisGardensEdge());
//    public static ResourceKey<Biome> ETHEREAL_FOREST = createBiome("ethereal_forest", EndBiomes.etherealForest());
//    public static ResourceKey<Biome> ETHEREAL_CLEARING = createBiome("ethereal_clearing", EndBiomes.etherealClearing());
//    public static ResourceKey<Biome> SHATTERED_DESERT_ISLES = createBiome("shattered_desert_isles", EndBiomes.shatteredDesertIsles());
//    public static ResourceKey<Biome> IMPARIUS_CLEARING = createBiome("imparius_clearing", EndBiomes.impariusClearing());

    public static ResourceKey<Biome> CANYON_KEY;

    public static ResourceKey<Biome> createBiome(String id, Biome biome) {
        ResourceLocation bygID = BYG.createLocation(id);
        if (BuiltinRegistries.BIOME.keySet().contains(bygID)) {
            throw new IllegalStateException("Biome ID: \"" + bygID.toString() + "\" already exists in the Biome registry!");
        }
        if (BYG.BIOMES) {
            BIOMES.add(new RegistryObject<>(biome, id));
        }

        return ResourceKey.create(Registry.BIOME_REGISTRY, bygID);
    }

    public static void bootStrap(Consumer<Collection<RegistryObject<Biome>>> registryStrategy) {
        registryStrategy.accept(BIOMES);
    }

    public static Collection<RegistryObject<Biome>> bootStrap() {
        return BIOMES;
    }

    //used in MixinMinecraftServer
    public static void addBYGFeaturesToBiomes(Biome biome, ResourceKey<Biome> biomeKey) {
        ResourceLocation locationKey = biomeKey.location();

        if (biome.getBiomeCategory() != Biome.BiomeCategory.NETHER && biome.getBiomeCategory() != Biome.BiomeCategory.THEEND && biome.getBiomeCategory() != Biome.BiomeCategory.NONE) {
            if (locationKey.equals(Biomes.SOUL_SAND_VALLEY.location())) {
//                addFeatureToBiome(biome, GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SOUL_SHROOM_SPORES);
            }

            if (biome.getBiomeCategory() == Biome.BiomeCategory.BEACH && biome.getBaseTemperature() > 0.15F) {
//                addFeatureToBiome(biome, GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.RANDOM_PALM_TREE);
            }

            if (biome.getBiomeCategory() != Biome.BiomeCategory.NETHER && biome.getBiomeCategory() != Biome.BiomeCategory.THEEND && biome.getBiomeCategory() != Biome.BiomeCategory.NONE) {
//                addFeatureToBiome(biome, GenerationStep.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.CATTAILS);
            }
        }
//        if (WorldConfig.conditionPasses(BYG.worldConfig().pendoriteSpawns, biomeKey, biome)) {
////            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_PENDORITE);
//        }
//
//        if (WorldConfig.conditionPasses(BYG.worldConfig().emeralditeSpawns, biomeKey, biome)) {
////            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_EMERALDITE);
//        }
//
//        if (WorldConfig.conditionPasses(BYG.worldConfig().rockyStoneSpawns, biomeKey, biome)) {
////            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_ROCKY_STONE);
//        }
//        if (WorldConfig.conditionPasses(BYG.worldConfig().ametrineSpawns, biomeKey, biome)) {
////            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_AMETRINE);
//        }
//        if (WorldConfig.conditionPasses(BYG.worldConfig().buddingAmetrineSpawns, biomeKey, biome)) {
////            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_AMETRINE_BUDDING);
//        }
//        if (WorldConfig.conditionPasses(BYG.worldConfig().scoriaSpawns, biomeKey, biome)) {
////            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_SCORIA_STONE);
//        }
//
//        if (WorldConfig.conditionPasses(BYG.worldConfig().soapStoneSpawns, biomeKey, biome)) {
////            addFeatureToBiome(biome, GenerationStep.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.OreConfigs.ORE_SOAP_STONE);
//        }
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
}
