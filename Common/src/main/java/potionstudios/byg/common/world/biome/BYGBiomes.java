package potionstudios.byg.common.world.biome;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.common.entity.npc.VillagerTradeRegistry;
import potionstudios.byg.common.world.biome.end.BYGEndBiomes;
import potionstudios.byg.common.world.placement.BYGPlacementModifierType;
import potionstudios.byg.common.world.structure.BYGStructurePieceTypes;
import potionstudios.byg.common.world.structure.BYGStructureSets;
import potionstudios.byg.common.world.surfacerules.rulesource.BYGRuleSources;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;
import potionstudios.byg.util.blendingfunction.BlendingFunction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Supplier;

import static potionstudios.byg.common.world.biome.BYGBiomeTags.*;
import static potionstudios.byg.common.world.biome.BYGOverworldBiomes.*;

public class BYGBiomes {

    public static final RegistrationProvider<Biome> PROVIDER = RegistrationProvider.get(BuiltinRegistries.BIOME, BYG.MOD_ID);
    public static final Multimap<TagKey<Biome>, RegistryObject<Biome>> BIOMES_BY_TAG = Multimaps.newSetMultimap(new HashMap<>(), HashSet::new);

    /************Primary Biome, BiomeTags.IS_OVERWORLDs************/
    public static final ResourceKey<Biome> ALLIUM_FIELDS = createBiome("allium_fields", BYGOverworldBiomes::alliumFields, BiomeTags.IS_OVERWORLD, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> AMARANTH_FIELDS = createBiome("amaranth_fields", BYGOverworldBiomes::amaranthFields, BiomeTags.IS_OVERWORLD, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> ARAUCARIA_SAVANNA = createBiome("araucaria_savanna", () -> araucariaSavanna(false), BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> ASPEN_FOREST = createBiome("aspen_forest", BYGOverworldBiomes::aspenForest, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> ATACAMA_DESERT = createBiome("atacama_desert", BYGOverworldBiomes::atacamaDesert, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> AUTUMNAL_VALLEY = createBiome("autumnal_valley", BYGOverworldBiomes::autumnalValley, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> BAOBAB_SAVANNA = createBiome("baobab_savanna", BYGOverworldBiomes::baobabSavanna, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> BAYOU = createBiome("bayou", BYGOverworldBiomes::bayou, IS_SWAMP, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> BLACK_FOREST = createBiome("black_forest", BYGOverworldBiomes::blackForest, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> BOREALIS_GROVE = createBiome("borealis_grove", BYGOverworldBiomes::borealisGrove, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> CANADIAN_SHIELD = createBiome("canadian_shield", BYGOverworldBiomes::canadianShield, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> CHERRY_BLOSSOM_FOREST = createBiome("cherry_blossom_forest", BYGOverworldBiomes::cherryBlossomForest, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> CIKA_WOODS = createBiome("cika_woods", BYGOverworldBiomes::cikaWoods, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> CONIFEROUS_FOREST = createBiome("coniferous_forest", () -> coniferousForest(false), BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> CRAG_GARDENS = createBiome("crag_gardens", BYGOverworldBiomes::cragGardens, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> CYPRESS_SWAMPLANDS = createBiome("cypress_swamplands", BYGOverworldBiomes::cypressSwamplands, IS_SWAMP, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> LUSH_STACKS = createBiome("lush_stacks", BYGOverworldBiomes::lushStacks, IS_DEEP_OCEAN, IS_OCEAN, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> DEAD_SEA = createBiome("dead_sea", BYGOverworldBiomes::deadSea, IS_DEEP_OCEAN, IS_OCEAN, IS_WASTELAND, IS_DEAD, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> DACITE_RIDGES = createBiome("dacite_ridges", BYGOverworldBiomes::daciteRidges, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> WINDSWEPT_DUNES = createBiome("windswept_dunes", () -> BYGOverworldBiomes.windsweptDesert(true), IS_SANDY, IS_BADLANDS, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> WINDSWEPT_DESERT = createBiome("windswept_desert", () -> BYGOverworldBiomes.windsweptDesert(false), BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> EBONY_WOODS = createBiome("ebony_woods", BYGOverworldBiomes::ebonyWoods, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> FORGOTTEN_FOREST = createBiome("forgotten_forest", BYGOverworldBiomes::forgottenForest, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> GROVE = createBiome("temperate_grove", () -> temperateGrove(false), BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> GUIANA_SHIELD = createBiome("guiana_shield", BYGOverworldBiomes::guianaShield, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> HOWLING_PEAKS = createBiome("howling_peaks", BYGOverworldBiomes::howlingPeaks, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> JACARANDA_FOREST = createBiome("jacaranda_forest", BYGOverworldBiomes::jacarandaForest, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> MAPLE_TAIGA = createBiome("maple_taiga", BYGOverworldBiomes::mapleTaiga, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> COCONINO_MEADOW = createBiome("coconino_meadow", () -> coconinoMeadow(false, false), BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> MOJAVE_DESERT = createBiome("mojave_desert", BYGOverworldBiomes::mojaveDesert, IS_SANDY, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> CARDINAL_TUNDRA = createBiome("cardinal_tundra", BYGOverworldBiomes::cardinalTundra, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> ORCHARD = createBiome("orchard", BYGOverworldBiomes::orchard, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> PRAIRIE = createBiome("prairie", BYGOverworldBiomes::prairie, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> RED_OAK_FOREST = createBiome("red_oak_forest", BYGOverworldBiomes::redOakForest, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> RED_ROCK_VALLEY = createBiome("red_rock_valley", BYGOverworldBiomes::redRockValley, IS_BADLANDS, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> ROSE_FIELDS = createBiome("rose_fields", BYGOverworldBiomes::roseFields, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> AUTUMNAL_FOREST = createBiome("autumnal_forest", BYGOverworldBiomes::autumnalForest, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> AUTUMNAL_TAIGA = createBiome("autumnal_taiga", () -> autumnalTaiga(false), BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> SHATTERED_GLACIER = createBiome("shattered_glacier", BYGOverworldBiomes::shatteredGlacier, IS_ICY, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> FIRECRACKER_SHRUBLAND = createBiome("firecracker_shrubland", BYGOverworldBiomes::firecrackerShrubland, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> SIERRA_BADLANDS = createBiome("sierra_badlands", BYGOverworldBiomes::sierraBadlands, IS_BADLANDS, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> SKYRIS_VALE = createBiome("skyris_vale", BYGOverworldBiomes::skyrisVale, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> REDWOOD_THICKET = createBiome("redwood_thicket", BYGOverworldBiomes::redwoodThicket, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> FROSTED_TAIGA = createBiome("frosted_taiga", () -> frostedTaiga(true, false), IS_SNOWY, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> FROSTED_CONIFEROUS_FOREST = createBiome("frosted_coniferous_forest", () -> coniferousForest(true), IS_SNOWY, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> FRAGMENT_FOREST = createBiome("fragment_forest", BYGOverworldBiomes::fragmentForest, BiomeTags.IS_OVERWORLD);
    //    public static final ResourceKey<Biome> TROPICAL_ISLAND = createBiome("tropical_islands", tropicalRainfores, BiomeTags.IS_OVERWORLDt());
    public static final ResourceKey<Biome> TROPICAL_RAINFOREST = createBiome("tropical_rainforest", BYGOverworldBiomes::tropicalRainforest, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> TWILIGHT_MEADOW = createBiome("twilight_meadow", BYGOverworldBiomes::twilightMeadow, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> WEEPING_WITCH_FOREST = createBiome("weeping_witch_forest", BYGOverworldBiomes::weepingWitchForest, IS_SPOOKY, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> WHITE_MANGROVE_MARSHES = createBiome("white_mangrove_marshes", BYGOverworldBiomes::whiteMangroveMarshes, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> TEMPERATE_RAINFOREST = createBiome("temperate_rainforest", BYGOverworldBiomes::temperateRainForest, BiomeTags.IS_OVERWORLD);
    public static final ResourceKey<Biome> ZELKOVA_FOREST = createBiome("zelkova_forest", BYGOverworldBiomes::zelkovaForest, BiomeTags.IS_OVERWORLD);

    /************Beach Biomes*************/
    public static final ResourceKey<Biome> WINDSWEPT_BEACH = createBiome("windswept_beach", BYGOverworldBiomes::windsweptBeach);
    public static final ResourceKey<Biome> RAINBOW_BEACH = createBiome("rainbow_beach", BYGOverworldBiomes::rainbowBeach, IS_BEACH);
    public static final ResourceKey<Biome> BASALT_BARRERA = createBiome("basalt_barrera", BYGOverworldBiomes::basaltBarrera);
    public static final ResourceKey<Biome> DACITE_SHORE = createBiome("dacite_shore", BYGOverworldBiomes::daciteShore);


    /************Nether Biomes************/
    public static final ResourceKey<Biome> BRIMSTONE_CAVERNS = createBiome("brimstone_caverns", BYGNetherBiomes::brimstoneCaverns);
    public static final ResourceKey<Biome> CRIMSON_GARDENS = createBiome("crimson_gardens", BYGNetherBiomes::crimsonGardens);
    public static final ResourceKey<Biome> EMBUR_BOG = createBiome("embur_bog", BYGNetherBiomes::emburBog);
    public static final ResourceKey<Biome> GLOWSTONE_GARDENS = createBiome("glowstone_gardens", BYGNetherBiomes::glowstoneGardens);
    public static final ResourceKey<Biome> MAGMA_WASTES = createBiome("magma_wastes", BYGNetherBiomes::magmaWastes);
    public static final ResourceKey<Biome> SUBZERO_HYPOGEAL = createBiome("subzero_hypogeal", BYGNetherBiomes::subzeroHypogeal);
    public static final ResourceKey<Biome> SYTHIAN_TORRIDS = createBiome("sythian_torrids", BYGNetherBiomes::sythianTorrids);
    public static final ResourceKey<Biome> WARPED_DESERT = createBiome("warped_desert", BYGNetherBiomes::warpedDesert);
    public static final ResourceKey<Biome> WAILING_GARTH = createBiome("wailing_garth", BYGNetherBiomes::wailingGarth);
    public static final ResourceKey<Biome> ARISIAN_UNDERGROWTH = createBiome("arisian_undergrowth", BYGNetherBiomes::arisianUndergrowth);
    public static final ResourceKey<Biome> WEEPING_MIRE = createBiome("weeping_mire", BYGNetherBiomes::weepingMire);
    public static final ResourceKey<Biome> QUARTZ_DESERT = createBiome("quartz_desert", BYGNetherBiomes::quartzDesert);

    /************End Biomes************/
    public static final ResourceKey<Biome> IVIS_FIELDS = createBiome("ivis_fields", BYGEndBiomes::ivisFields);
    public static final ResourceKey<Biome> NIGHTSHADE_FOREST = createBiome("nightshade_forest", BYGEndBiomes::nightshadeForest);
    public static final ResourceKey<Biome> ETHEREAL_ISLANDS = createBiome("ethereal_islands", BYGEndBiomes::etherealIslands);
    public static final ResourceKey<Biome> VISCAL_ISLES = createBiome("viscal_isles", BYGEndBiomes::viscalIsles);
    public static final ResourceKey<Biome> BULBIS_GARDENS = createBiome("bulbis_gardens", BYGEndBiomes::bulbisGardens);
    //    public static final ResourceKey<Biome> SHATTERED_DESERT = createBiome("shattered_desert", shatteredDesert());
    public static final ResourceKey<Biome> SHULKREN_FOREST = createBiome("shulkren_forest", BYGEndBiomes::shulkrenForest);
    public static final ResourceKey<Biome> CRYPTIC_WASTES = createBiome("cryptic_wastes", BYGEndBiomes::crypticWastes);
    public static final ResourceKey<Biome> IMPARIUS_GROVE = createBiome("imparius_grove", BYGEndBiomes::impariusGrove);

    @SafeVarargs
    public static <B extends Biome> ResourceKey<Biome> createBiome(String id, Supplier<? extends B> biome, TagKey<Biome>... tags) {
        ResourceLocation bygID = BYG.createLocation(id);
        if (BuiltinRegistries.BIOME.keySet().contains(bygID)) {
            throw new IllegalStateException("Biome ID: \"" + bygID + "\" already exists in the Biome registry!");
        }
        if (BYGConstants.BIOMES) {
            final var reg = PROVIDER.<Biome>register(id, biome);
            for (TagKey<Biome> tag : tags) {
                BIOMES_BY_TAG.put(tag, reg);
            }
        }

        return ResourceKey.create(Registry.BIOME_REGISTRY, bygID);
    }

    public static void loadClass() {
        BlendingFunction.register();
        BYGStructurePieceTypes.bootStrap();
        BYGStructureSets.bootStrap();
        BYGPlacementModifierType.bootStrap();
        BYGRuleSources.bootStrap();
        VillagerTradeRegistry.register();
    }
}