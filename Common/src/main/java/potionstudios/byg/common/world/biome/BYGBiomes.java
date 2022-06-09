package potionstudios.byg.common.world.biome;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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

    /************Overworld Biomes************/
    public static final ResourceKey<Biome> ALLIUM_FIELDS = createBiome("allium_fields", BYGOverworldBiomes::alliumFields, IS_OVERWORLD, IS_OVERWORLD);
    public static final ResourceKey<Biome> AMARANTH_FIELDS = createBiome("amaranth_fields", BYGOverworldBiomes::amaranthFields, IS_OVERWORLD, IS_OVERWORLD);
    public static final ResourceKey<Biome> ARAUCARIA_SAVANNA = createBiome("araucaria_savanna", () -> araucariaSavanna(false), IS_OVERWORLD);
    public static final ResourceKey<Biome> ASPEN_FOREST = createBiome("aspen_forest", BYGOverworldBiomes::aspenForest, IS_OVERWORLD);
    public static final ResourceKey<Biome> ATACAMA_DESERT = createBiome("atacama_desert", BYGOverworldBiomes::atacamaDesert, IS_OVERWORLD);
    public static final ResourceKey<Biome> AUTUMNAL_VALLEY = createBiome("autumnal_valley", BYGOverworldBiomes::autumnalValley, IS_OVERWORLD);
    public static final ResourceKey<Biome> BAOBAB_SAVANNA = createBiome("baobab_savanna", BYGOverworldBiomes::baobabSavanna, IS_OVERWORLD);
    public static final ResourceKey<Biome> BAYOU = createBiome("bayou", BYGOverworldBiomes::bayou, IS_SWAMP, IS_OVERWORLD, ALLOWS_SURFACE_SLIME_SPAWNS);
    public static final ResourceKey<Biome> BLACK_FOREST = createBiome("black_forest", BYGOverworldBiomes::blackForest, IS_OVERWORLD);
    public static final ResourceKey<Biome> BOREALIS_GROVE = createBiome("borealis_grove", BYGOverworldBiomes::borealisGrove, IS_OVERWORLD);
    public static final ResourceKey<Biome> CANADIAN_SHIELD = createBiome("canadian_shield", BYGOverworldBiomes::canadianShield, IS_OVERWORLD);
    public static final ResourceKey<Biome> CHERRY_BLOSSOM_FOREST = createBiome("cherry_blossom_forest", BYGOverworldBiomes::cherryBlossomForest, IS_OVERWORLD);
    public static final ResourceKey<Biome> CIKA_WOODS = createBiome("cika_woods", BYGOverworldBiomes::cikaWoods, IS_OVERWORLD);
    public static final ResourceKey<Biome> CONIFEROUS_FOREST = createBiome("coniferous_forest", () -> coniferousForest(false), IS_OVERWORLD);
    public static final ResourceKey<Biome> CRAG_GARDENS = createBiome("crag_gardens", BYGOverworldBiomes::cragGardens, IS_OVERWORLD);
    public static final ResourceKey<Biome> CYPRESS_SWAMPLANDS = createBiome("cypress_swamplands", BYGOverworldBiomes::cypressSwamplands, IS_SWAMP, IS_OVERWORLD, ALLOWS_SURFACE_SLIME_SPAWNS);
    public static final ResourceKey<Biome> LUSH_STACKS = createBiome("lush_stacks", BYGOverworldBiomes::lushStacks, IS_DEEP_OCEAN, IS_OCEAN, IS_OVERWORLD);
    public static final ResourceKey<Biome> DEAD_SEA = createBiome("dead_sea", BYGOverworldBiomes::deadSea, IS_DEEP_OCEAN, IS_OCEAN, IS_WASTELAND, IS_DEAD, IS_OVERWORLD);
    public static final ResourceKey<Biome> DACITE_RIDGES = createBiome("dacite_ridges", BYGOverworldBiomes::daciteRidges, IS_OVERWORLD);
    public static final ResourceKey<Biome> WINDSWEPT_DESERT = createBiome("windswept_desert", () -> BYGOverworldBiomes.windsweptDesert(false), IS_OVERWORLD);
    public static final ResourceKey<Biome> EBONY_WOODS = createBiome("ebony_woods", BYGOverworldBiomes::ebonyWoods, IS_OVERWORLD);
    public static final ResourceKey<Biome> FORGOTTEN_FOREST = createBiome("forgotten_forest", BYGOverworldBiomes::forgottenForest, IS_OVERWORLD);
    public static final ResourceKey<Biome> GROVE = createBiome("temperate_grove", () -> temperateGrove(false), IS_OVERWORLD);
    public static final ResourceKey<Biome> GUIANA_SHIELD = createBiome("guiana_shield", BYGOverworldBiomes::guianaShield, IS_OVERWORLD);
    public static final ResourceKey<Biome> HOWLING_PEAKS = createBiome("howling_peaks", BYGOverworldBiomes::howlingPeaks, IS_OVERWORLD);
    public static final ResourceKey<Biome> JACARANDA_FOREST = createBiome("jacaranda_forest", BYGOverworldBiomes::jacarandaForest, IS_OVERWORLD);
    public static final ResourceKey<Biome> MAPLE_TAIGA = createBiome("maple_taiga", BYGOverworldBiomes::mapleTaiga, IS_OVERWORLD);
    public static final ResourceKey<Biome> COCONINO_MEADOW = createBiome("coconino_meadow", () -> coconinoMeadow(false, false), IS_OVERWORLD);
    public static final ResourceKey<Biome> MOJAVE_DESERT = createBiome("mojave_desert", BYGOverworldBiomes::mojaveDesert, IS_SANDY, IS_OVERWORLD);
    public static final ResourceKey<Biome> CARDINAL_TUNDRA = createBiome("cardinal_tundra", BYGOverworldBiomes::cardinalTundra, IS_OVERWORLD);
    public static final ResourceKey<Biome> ORCHARD = createBiome("orchard", BYGOverworldBiomes::orchard, IS_OVERWORLD);
    public static final ResourceKey<Biome> PRAIRIE = createBiome("prairie", BYGOverworldBiomes::prairie, IS_OVERWORLD);
    public static final ResourceKey<Biome> RED_OAK_FOREST = createBiome("red_oak_forest", BYGOverworldBiomes::redOakForest, IS_OVERWORLD);
    public static final ResourceKey<Biome> RED_ROCK_VALLEY = createBiome("red_rock_valley", BYGOverworldBiomes::redRockValley, IS_BADLANDS, IS_OVERWORLD);
    public static final ResourceKey<Biome> ROSE_FIELDS = createBiome("rose_fields", BYGOverworldBiomes::roseFields, IS_OVERWORLD);
    public static final ResourceKey<Biome> AUTUMNAL_FOREST = createBiome("autumnal_forest", BYGOverworldBiomes::autumnalForest, IS_OVERWORLD);
    public static final ResourceKey<Biome> AUTUMNAL_TAIGA = createBiome("autumnal_taiga", () -> autumnalTaiga(false), IS_OVERWORLD);
    public static final ResourceKey<Biome> SHATTERED_GLACIER = createBiome("shattered_glacier", BYGOverworldBiomes::shatteredGlacier, IS_ICY, IS_OVERWORLD);
    public static final ResourceKey<Biome> FIRECRACKER_SHRUBLAND = createBiome("firecracker_shrubland", BYGOverworldBiomes::firecrackerShrubland, IS_OVERWORLD);
    public static final ResourceKey<Biome> SIERRA_BADLANDS = createBiome("sierra_badlands", BYGOverworldBiomes::sierraBadlands, IS_BADLANDS, IS_OVERWORLD);
    public static final ResourceKey<Biome> SKYRIS_VALE = createBiome("skyris_vale", BYGOverworldBiomes::skyrisVale, IS_OVERWORLD);
    public static final ResourceKey<Biome> REDWOOD_THICKET = createBiome("redwood_thicket", BYGOverworldBiomes::redwoodThicket, IS_OVERWORLD);
    public static final ResourceKey<Biome> FROSTED_TAIGA = createBiome("frosted_taiga", () -> frostedTaiga(true, false), IS_SNOWY, IS_OVERWORLD);
    public static final ResourceKey<Biome> FROSTED_CONIFEROUS_FOREST = createBiome("frosted_coniferous_forest", () -> coniferousForest(true), IS_SNOWY, IS_OVERWORLD);
    public static final ResourceKey<Biome> FRAGMENT_FOREST = createBiome("fragment_forest", BYGOverworldBiomes::fragmentForest, IS_OVERWORLD);
    //    public static final ResourceKey<Biome> TROPICAL_ISLAND = createBiome("tropical_islands", tropicalRainfores, IS_OVERWORLDt());
    public static final ResourceKey<Biome> TROPICAL_RAINFOREST = createBiome("tropical_rainforest", BYGOverworldBiomes::tropicalRainforest, IS_OVERWORLD);
    public static final ResourceKey<Biome> TWILIGHT_MEADOW = createBiome("twilight_meadow", BYGOverworldBiomes::twilightMeadow, IS_OVERWORLD);
    public static final ResourceKey<Biome> WEEPING_WITCH_FOREST = createBiome("weeping_witch_forest", BYGOverworldBiomes::weepingWitchForest, IS_SPOOKY, IS_OVERWORLD);
    public static final ResourceKey<Biome> WHITE_MANGROVE_MARSHES = createBiome("white_mangrove_marshes", BYGOverworldBiomes::whiteMangroveMarshes, IS_OVERWORLD, ALLOWS_SURFACE_SLIME_SPAWNS);
    public static final ResourceKey<Biome> TEMPERATE_RAINFOREST = createBiome("temperate_rainforest", BYGOverworldBiomes::temperateRainForest, IS_OVERWORLD);
    public static final ResourceKey<Biome> ZELKOVA_FOREST = createBiome("zelkova_forest", BYGOverworldBiomes::zelkovaForest, IS_OVERWORLD);

    /************Beach Biomes*************/
    public static final ResourceKey<Biome> RAINBOW_BEACH = createBiome("rainbow_beach", BYGOverworldBiomes::rainbowBeach, IS_BEACH, IS_OVERWORLD);
    public static final ResourceKey<Biome> BASALT_BARRERA = createBiome("basalt_barrera", BYGOverworldBiomes::basaltBarrera, IS_OVERWORLD);
    public static final ResourceKey<Biome> DACITE_SHORE = createBiome("dacite_shore", BYGOverworldBiomes::daciteShore, IS_OVERWORLD);


    /************Nether Biomes************/
    public static final ResourceKey<Biome> BRIMSTONE_CAVERNS = createBiome("brimstone_caverns", BYGNetherBiomes::brimstoneCaverns, IS_NETHER);
    public static final ResourceKey<Biome> CRIMSON_GARDENS = createBiome("crimson_gardens", BYGNetherBiomes::crimsonGardens, IS_NETHER);
    public static final ResourceKey<Biome> EMBUR_BOG = createBiome("embur_bog", BYGNetherBiomes::emburBog, IS_NETHER);
    public static final ResourceKey<Biome> GLOWSTONE_GARDENS = createBiome("glowstone_gardens", BYGNetherBiomes::glowstoneGardens, IS_NETHER);
    public static final ResourceKey<Biome> MAGMA_WASTES = createBiome("magma_wastes", BYGNetherBiomes::magmaWastes, IS_NETHER);
    public static final ResourceKey<Biome> SUBZERO_HYPOGEAL = createBiome("subzero_hypogeal", BYGNetherBiomes::subzeroHypogeal, IS_NETHER);
    public static final ResourceKey<Biome> SYTHIAN_TORRIDS = createBiome("sythian_torrids", BYGNetherBiomes::sythianTorrids, IS_NETHER);
    public static final ResourceKey<Biome> WARPED_DESERT = createBiome("warped_desert", BYGNetherBiomes::warpedDesert, IS_NETHER);
    public static final ResourceKey<Biome> WAILING_GARTH = createBiome("wailing_garth", BYGNetherBiomes::wailingGarth, IS_NETHER);
    public static final ResourceKey<Biome> ARISIAN_UNDERGROWTH = createBiome("arisian_undergrowth", BYGNetherBiomes::arisianUndergrowth, IS_NETHER);
    public static final ResourceKey<Biome> WEEPING_MIRE = createBiome("weeping_mire", BYGNetherBiomes::weepingMire, IS_NETHER);
    public static final ResourceKey<Biome> QUARTZ_DESERT = createBiome("quartz_desert", BYGNetherBiomes::quartzDesert, IS_NETHER);

    /************End Biomes************/
    public static final ResourceKey<Biome> IVIS_FIELDS = createBiome("ivis_fields", BYGEndBiomes::ivisFields, IS_END);
    public static final ResourceKey<Biome> NIGHTSHADE_FOREST = createBiome("nightshade_forest", BYGEndBiomes::nightshadeForest, IS_END);
    public static final ResourceKey<Biome> ETHEREAL_ISLANDS = createBiome("ethereal_islands", BYGEndBiomes::etherealIslands, IS_END);
    public static final ResourceKey<Biome> VISCAL_ISLES = createBiome("viscal_isles", BYGEndBiomes::viscalIsles, IS_END);
    public static final ResourceKey<Biome> BULBIS_GARDENS = createBiome("bulbis_gardens", BYGEndBiomes::bulbisGardens, IS_END);
    //    public static final ResourceKey<Biome> SHATTERED_DESERT = createBiome("shattered_desert", , IS_ENDshatteredDesert());
    public static final ResourceKey<Biome> SHULKREN_FOREST = createBiome("shulkren_forest", BYGEndBiomes::shulkrenForest, IS_END);
    public static final ResourceKey<Biome> CRYPTIC_WASTES = createBiome("cryptic_wastes", BYGEndBiomes::crypticWastes, IS_END);
    public static final ResourceKey<Biome> IMPARIUS_GROVE = createBiome("imparius_grove", BYGEndBiomes::impariusGrove, IS_END);

    @SafeVarargs
    public static <B extends Biome> ResourceKey<Biome> createBiome(String id, Supplier<? extends B> biome, TagKey<Biome>... tags) {
        ResourceLocation bygID = BYG.createLocation(id);
        if (BuiltinRegistries.BIOME.keySet().contains(bygID)) {
            throw new IllegalStateException("Biome ID: \"" + bygID + "\" already exists in the Biome registry!");
        }
        if (BYGConstants.BIOMES) {
            final var reg = PROVIDER.<Biome>register(id, biome);
            for (TagKey<Biome> tag : tags) {
                if (!tag.location().getNamespace().equals(BYG.MOD_ID)) {
                    throw new IllegalArgumentException("Tag key must be from the BYG namespace");
                }
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