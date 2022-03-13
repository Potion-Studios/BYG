package potionstudios.byg.common.world.biome;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.placement.BYGPlacementModifierType;
import potionstudios.byg.common.world.structure.BYGStructurePieceTypes;
import potionstudios.byg.common.world.structure.BYGStructureSets;
import potionstudios.byg.common.world.surfacerules.BYGRuleSources;
import potionstudios.byg.util.RegistryObject;
import potionstudios.byg.util.blendingfunction.BlendingFunction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static potionstudios.byg.common.world.biome.BYGOverworldBiomes.*;
import static potionstudios.byg.common.world.biome.end.BYGEndBiomes.*;

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
    public static ResourceKey<Biome> CRAG_GARDENS = createBiome("crag_gardens", cragGardens());
    public static ResourceKey<Biome> CYPRESS_SWAMPLANDS = createBiome("cypress_swamplands", cypressSwamplands());
    public static ResourceKey<Biome> LUSH_STACKS = createBiome("lush_stacks", lushStacks());
    public static ResourceKey<Biome> DEAD_SEA = createBiome("dead_sea", deadSea());
    public static ResourceKey<Biome> DACITE_RIDGES = createBiome("dacite_ridges", daciteRidges());
    public static ResourceKey<Biome> WINDSWEPT_DUNES = createBiome("windswept_dunes", windsweptDunes());
    public static ResourceKey<Biome> EBONY_WOODS = createBiome("ebony_woods", ebonyWoods());
    public static ResourceKey<Biome> FORGOTTEN_FOREST = createBiome("forgotten_forest", forgottenForest());
    public static ResourceKey<Biome> GROVE = createBiome("temperate_grove", temperateGrove(false));
    public static ResourceKey<Biome> GUIANA_SHIELD = createBiome("guiana_shield", guianaShield());
    public static ResourceKey<Biome> JACARANDA_FOREST = createBiome("jacaranda_forest", jacarandaForest());
    public static ResourceKey<Biome> MAPLE_TAIGA = createBiome("maple_taiga", mapleTaiga());
    public static ResourceKey<Biome> COCONINO_MEADOW = createBiome("coconino_meadow", coconinoMeadow(false, false));
    public static ResourceKey<Biome> MOJAVE_DESERT = createBiome("mojave_desert", mojaveDesert());
    public static ResourceKey<Biome> CARDINAL_TUNDRA = createBiome("cardinal_tundra", cardinalTundra());
    public static ResourceKey<Biome> ORCHARD = createBiome("orchard", orchard());
    public static ResourceKey<Biome> PRAIRIE = createBiome("prairie", prairie());
    public static ResourceKey<Biome> RED_OAK_FOREST = createBiome("red_oak_forest", redOakForest());
    public static ResourceKey<Biome> RED_ROCK_VALLEY = createBiome("red_rock_valley", redRockValley());
    public static ResourceKey<Biome> ROSE_FIELDS = createBiome("rose_fields", roseFields());
    public static ResourceKey<Biome> AUTUMNAL_FOREST = createBiome("autumnal_forest", autumnalForest());
    public static ResourceKey<Biome> AUTUMNAL_TAIGA = createBiome("autumnal_taiga", autumnalTaiga(false));
    public static ResourceKey<Biome> SHATTERED_GLACIER = createBiome("shattered_glacier", shatteredGlacier());
    public static ResourceKey<Biome> FIRECRACKER_SHRUBLAND = createBiome("firecracker_shrubland", firecrackerShrubland());
    public static ResourceKey<Biome> SIERRA_BADLANDS = createBiome("sierra_badlands", sierraBadlands());
    public static ResourceKey<Biome> SKYRIS_VALE = createBiome("skyris_vale", skyrisVale());
    public static ResourceKey<Biome> REDWOOD_THICKET = createBiome("redwood_thicket", redwoodThicket());
    public static ResourceKey<Biome> FROSTED_TAIGA = createBiome("frosted_taiga", frostedTaiga(true, false));
    public static ResourceKey<Biome> FROSTED_CONIFEROUS_FOREST = createBiome("frosted_coniferous_forest", coniferousForest(true));
    public static ResourceKey<Biome> FRAGMENT_FOREST = createBiome("fragment_forest", fragmentForest());
    //    public static ResourceKey<Biome> TROPICAL_ISLAND = createBiome("tropical_islands", tropicalRainforest());
    public static ResourceKey<Biome> TROPICAL_RAINFOREST = createBiome("tropical_rainforest", tropicalRainforest());
    public static ResourceKey<Biome> TWILIGHT_MEADOW = createBiome("twilight_meadow", twilightMeadow());
    public static ResourceKey<Biome> WEEPING_WITCH_FOREST = createBiome("weeping_witch_forest", weepingWitchForest());
//    public static ResourceKey<Biome> WHITE_MANGROVE_MARSHES = createBiome("white_mangrove_marshes", whiteMangroveMarshes()); //TODO: Trees are floating and need to be fixed.
    public static ResourceKey<Biome> TEMPERATE_RAINFOREST = createBiome("temperate_rainforest", temperateRainForest());
    public static ResourceKey<Biome> ZELKOVA_FOREST = createBiome("zelkova_forest", zelkovaForest());

    /************Nether Biomes************/
    public static ResourceKey<Biome> BRIMSTONE_CAVERNS = createBiome("brimstone_caverns", BYGNetherBiomes.brimstoneCaverns());
    public static ResourceKey<Biome> CRIMSON_GARDENS = createBiome("crimson_gardens", BYGNetherBiomes.crimsonGardens());
    public static ResourceKey<Biome> EMBUR_BOG = createBiome("embur_bog", BYGNetherBiomes.emburBog());
    public static ResourceKey<Biome> GLOWSTONE_GARDENS = createBiome("glowstone_gardens", BYGNetherBiomes.glowstoneGardens());
    public static ResourceKey<Biome> MAGMA_WASTES = createBiome("magma_wastes", BYGNetherBiomes.magmaWastes());
    public static ResourceKey<Biome> SUBZERO_HYPOGEAL = createBiome("subzero_hypogeal", BYGNetherBiomes.subzeroHypogeal());
    public static ResourceKey<Biome> SYTHIAN_TORRIDS = createBiome("sythian_torrids", BYGNetherBiomes.sythianTorrids());
    public static ResourceKey<Biome> WARPED_DESERT = createBiome("warped_desert", BYGNetherBiomes.warpedDesert());
    public static ResourceKey<Biome> WAILING_GARTH = createBiome("wailing_garth", BYGNetherBiomes.wailingGarth());
    public static ResourceKey<Biome> ARISIAN_UNDERGROWTH = createBiome("arisian_undergrowth", BYGNetherBiomes.arisianUndergrowth());
    public static ResourceKey<Biome> WEEPING_MIRE = createBiome("weeping_mire", BYGNetherBiomes.weepingMire());
    public static ResourceKey<Biome> QUARTZ_DESERT = createBiome("quartz_desert", BYGNetherBiomes.quartzDesert());

    /************End Biomes************/
    public static ResourceKey<Biome> IVIS_FIELDS = createBiome("ivis_fields", ivisFields());
    public static ResourceKey<Biome> NIGHTSHADE_FOREST = createBiome("nightshade_forest", nightshadeForest());
    public static ResourceKey<Biome> ETHEREAL_ISLANDS = createBiome("ethereal_islands", etherealIslands());
    public static ResourceKey<Biome> VISCAL_ISLES = createBiome("viscal_isles", viscalIsles());
    public static ResourceKey<Biome> BULBIS_GARDENS = createBiome("bulbis_gardens", bulbisGardens());
    //    public static ResourceKey<Biome> SHATTERED_DESERT = createBiome("shattered_desert", shatteredDesert());
    public static ResourceKey<Biome> SHULKREN_FOREST = createBiome("shulkren_forest", shulkrenForest());
    public static ResourceKey<Biome> CRYPTIC_WASTES = createBiome("cryptic_wastes", crypticWastes());
    public static ResourceKey<Biome> IMPARIUS_GROVE = createBiome("imparius_grove", impariusGrove());


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

    public static Collection<RegistryObject<Biome>> bootStrap() {
        BlendingFunction.bootStrap();
        BYGStructurePieceTypes.bootStrap();
        BYGStructureSets.bootStrap();
        BYGPlacementModifierType.bootStrap();
        BYGRuleSources.bootStrap();
        return BIOMES;
    }

    static {
        BYG.LOGGER.info("BYG Biomes class loaded.");
    }
}