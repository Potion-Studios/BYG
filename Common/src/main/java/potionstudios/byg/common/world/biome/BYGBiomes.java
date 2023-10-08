package potionstudios.byg.common.world.biome;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.BYG;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.common.world.biome.end.BYGEndBiomes;
import potionstudios.byg.common.world.placement.BYGPlacementModifierType;
import potionstudios.byg.common.world.structure.BYGStructurePieceTypes;
import potionstudios.byg.common.world.structure.BYGStructureSets;
import potionstudios.byg.common.world.surfacerules.rulesource.BYGRuleSources;
import potionstudios.byg.reg.RegistrationProvider;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static net.minecraft.tags.BiomeTags.IS_MOUNTAIN;
import static net.minecraft.tags.BiomeTags.*;
import static potionstudios.byg.common.world.biome.BYGBiomeTags.*;
import static potionstudios.byg.common.world.biome.BYGOverworldBiomes.*;
import static potionstudios.byg.common.world.biome.MLBiomeTags.*;

public class BYGBiomes {

    public static final RegistrationProvider<Biome> PROVIDER = RegistrationProvider.get(Registries.BIOME, BYG.MOD_ID);
    public static final Multimap<TagKey<Biome>, ResourceKey<Biome>> BIOMES_BY_TAG = Multimaps.newSetMultimap(new HashMap<>(), HashSet::new);

    public static final Map<ResourceKey<Biome>, BiomeFactory> BIOME_FACTORIES = new Reference2ObjectOpenHashMap<>();

    /************Overworld Biomes************/
    public static final ResourceKey<Biome> ALLIUM_FIELDS = createBiome("allium_fields", BYGOverworldBiomes::alliumFields,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_PLAINS,
            IS_LUSH,
            FLORAL,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> AMARANTH_FIELDS = createBiome("amaranth_fields", BYGOverworldBiomes::amaranthFields,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_PLAINS,
            IS_LUSH,
            FLORAL,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> ARAUCARIA_SAVANNA = createBiome("araucaria_savanna", (placedFeatureHolderGetter, carverHolderGetter) -> araucariaSavanna(placedFeatureHolderGetter, carverHolderGetter, false),
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_SAVANNA,
            SAVANNA,
            // Vegetation Properties
            TREE_SAVANNA,
            // Climate
            IS_HOT,
            IS_HOT_OVERWORLD,
            CLIMATE_HOT,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_SAVANNA
    );

    public static final ResourceKey<Biome> ASPEN_FOREST = createBiome("aspen_forest", BYGOverworldBiomes::aspenForest,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_FOREST,
            FOREST,
            // Climate Settings
            CLIMATE_COLD,
            IS_COLD_OVERWORLD,
            IS_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> ATACAMA_DESERT = createBiome("atacama_desert", BYGOverworldBiomes::atacamaDesert,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            DESERT,
            IS_DESERT,
            // Climate
            IS_DRY,
            IS_DRY_OVERWORLD,
            IS_HOT,
            CLIMATE_HOT,
            CLIMATE_DRY,
            // Structures
            HAS_MINESHAFT,
            HAS_VILLAGE_DESERT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_DESERT,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> AUTUMNAL_VALLEY = createBiome("autumnal_valley", BYGOverworldBiomes::autumnalValley,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_PLAINS,
            // Climate
            IS_COLD,
            IS_COLD_OVERWORLD,
            CLIMATE_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_PUMPKIN_PATCH
    );

    public static final ResourceKey<Biome> BAOBAB_SAVANNA = createBiome("baobab_savanna", BYGOverworldBiomes::baobabSavanna,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_SAVANNA,
            SAVANNA,
            TREE_SAVANNA,
            // Climate
            IS_HOT,
            IS_HOT_OVERWORLD,
            CLIMATE_DRY,
            IS_DRY_OVERWORLD,
            IS_DRY,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_SAVANNA
    );

    public static final ResourceKey<Biome> BAYOU = createBiome("bayou", BYGOverworldBiomes::bayou,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_SWAMP,
            SWAMP,
            // Water
            IS_WATER,
            IS_WET_OVERWORLD,
            IS_WET,
            CLIMATE_WET,
            CLIMATE_TEMPERATE,
            // Vegetation
            VEGETATION_DENSE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_SWAMP,
            HAS_STRONGHOLD,
            HAS_SWAMP_HUT,
            // Spawns
            ALLOWS_SURFACE_SLIME_SPAWNS
    );

    public static final ResourceKey<Biome> BLACK_FOREST = createBiome("black_forest", BYGOverworldBiomes::blackForest,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_TAIGA,
            TAIGA,
            IS_CONIFEROUS,
            // Vegetation
            TREE_CONIFEROUS,
            // Climate
            CLIMATE_COLD,
            IS_COLD_OVERWORLD,
            IS_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_TAIGA
    );

    public static final ResourceKey<Biome> BOREALIS_GROVE = createBiome("borealis_grove", BYGOverworldBiomes::borealisGrove,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_TAIGA,
            TAIGA,
            IS_CONIFEROUS,
            // Vegetation
            TREE_CONIFEROUS,
            // Climate
            CLIMATE_COLD,
            IS_COLD,
            IS_COLD_OVERWORLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> CANADIAN_SHIELD = createBiome("canadian_shield", BYGOverworldBiomes::canadianShield,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_MOUNTAIN,
            IS_TAIGA,
            IS_CONIFEROUS,
            MOUNTAIN,
            IS_SLOPE,
            MOUNTAIN_SLOPE,
            // Vegetation
            TREE_CONIFEROUS,
            // Climate
            IS_COLD,
            IS_COLD_OVERWORLD,
            CLIMATE_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_MOUNTAIN,
            HAS_STRONGHOLD,
            HAS_VILLAGE_TAIGA
    );

    public static final ResourceKey<Biome> SAKURA_GROVE = createBiome("sakura_grove", BYGOverworldBiomes::sakuraGrove,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_FOREST,
            FLORAL,
            FOREST,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> CIKA_WOODS = createBiome("cika_woods", BYGOverworldBiomes::cikaWoods,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_FOREST,
            FOREST,
            // Climate
            IS_COLD,
            IS_COLD_OVERWORLD,
            CLIMATE_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_PUMPKIN_PATCH,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> CONIFEROUS_FOREST = createBiome("coniferous_forest", (placedFeatureHolderGetter, carverHolderGetter) -> coniferousForest(placedFeatureHolderGetter, carverHolderGetter, false),
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_TAIGA,
            IS_CONIFEROUS,
            IS_COLD,
            // Vegetation Properties
            TREE_CONIFEROUS,
            // Climate
            IS_COLD_OVERWORLD,
            IS_COLD,
            CLIMATE_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_TAIGA
    );

    public static final ResourceKey<Biome> CRAG_GARDENS = createBiome("crag_gardens", BYGOverworldBiomes::cragGardens,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_JUNGLE,
            JUNGLE,
            IS_MOUNTAIN,
            // Vegetation
            TREE_JUNGLE,
            // Climate
            IS_WET,
            IS_WET_OVERWORLD,
            CLIMATE_WET,
            IS_HOT,
            IS_HOT_OVERWORLD,
            CLIMATE_HOT,
            // Structures
            HAS_RUINED_PORTAL_JUNGLE,
            HAS_JUNGLE_TEMPLE,
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_STRONGHOLD,
            // Spawns
            SPAWNS_WARM_VARIANT_FROGS
    );

    public static final ResourceKey<Biome> CYPRESS_SWAMPLANDS = createBiome("cypress_swamplands", BYGOverworldBiomes::cypressSwamplands,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_SWAMP,
            AQUATIC,
            IS_WATER,
            // Vegetation Properties
            VEGETATION_DENSE,
            IS_DENSE,
            IS_DENSE_OVERWORLD,
            // Climate
            CLIMATE_WET,
            IS_WET,
            IS_WET_OVERWORLD,
            CLIMATE_HOT,
            IS_HOT,
            IS_HOT_OVERWORLD,
            // Structures
            HAS_SWAMP_HUT,
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_SWAMP,
            HAS_STRONGHOLD,
            // Spawns
            ALLOWS_SURFACE_SLIME_SPAWNS
    );

    public static final ResourceKey<Biome> LUSH_STACKS = createBiome("lush_stacks", BYGOverworldBiomes::lushStacks,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_DEEP_OCEAN,
            IS_OCEAN,
            IS_LUSH,
            IS_WATER,
            // Climate
            IS_WET,
            IS_WET_OVERWORLD,
            CLIMATE_WET,
            CLIMATE_TEMPERATE,
            // Structures
            HAS_OCEAN_RUIN_WARM,
            HAS_RUINED_PORTAL_OCEAN,
            HAS_MINESHAFT,
            HAS_SHIPWRECK_BEACHED,
            HAS_STRONGHOLD,
            // Misc
            PLAYS_UNDERWATER_MUSIC,
            WATER_ON_MAP_OUTLINES
    );

    public static final ResourceKey<Biome> DEAD_SEA = createBiome("dead_sea", BYGOverworldBiomes::deadSea,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_DEEP_OCEAN,
            DEEP_OCEAN,
            IS_OCEAN,
            OCEAN,
            IS_WASTELAND,
            IS_DEAD,
            DEAD,
            AQUATIC,
            WASTELAND,
            IS_WATER,
            // Climate
            CLIMATE_WET,
            IS_WET,
            IS_WET_OVERWORLD,
            IS_HOT,
            IS_HOT_OVERWORLD,
            CLIMATE_HOT,
            // Structures
            HAS_MINESHAFT,
            HAS_OCEAN_RUIN_WARM,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_OCEAN,
            HAS_SHIPWRECK_BEACHED,
            HAS_STRONGHOLD,
            // Misc
            PLAYS_UNDERWATER_MUSIC,
            REQUIRED_OCEAN_MONUMENT_SURROUNDING,
            WATER_ON_MAP_OUTLINES
    );

    public static final ResourceKey<Biome> DACITE_RIDGES = createBiome("dacite_ridges", BYGOverworldBiomes::daciteRidges,
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_MOUNTAIN,
            MOUNTAIN,
            // Climate
            CLIMATE_COLD,
            IS_COLD_OVERWORLD,
            IS_COLD,
            // Vegetation
            TREE_CONIFEROUS,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_MOUNTAIN,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> WINDSWEPT_DESERT = createBiome("windswept_desert", (placedFeatureHolderGetter, carverHolderGetter) -> BYGOverworldBiomes.windsweptDesert(placedFeatureHolderGetter, carverHolderGetter, false),
            // Dimension Properties
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_DESERT,
            DESERT,
            // Climate
            CLIMATE_DRY,
            CLIMATE_HOT,
            IS_DRY,
            IS_DRY_OVERWORLD,
            IS_HOT,
            IS_HOT_OVERWORLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_DESERT
    );

    public static final ResourceKey<Biome> EBONY_WOODS = createBiome("ebony_woods", BYGOverworldBiomes::ebonyWoods,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_FOREST,
            FOREST,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> ENCHANTED_TANGLE = createBiome("enchanted_tangle", BYGOverworldBiomes::enchantedTangle,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_FOREST,
            IS_MAGICAL,
            FOREST,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> GROVE = createBiome("temperate_grove", (placedFeatureHolderGetter, carverHolderGetter) -> temperateGrove(placedFeatureHolderGetter, carverHolderGetter, false),
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_PLAINS,
            IS_LUSH,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> GUIANA_SHIELD = createBiome("guiana_shield", BYGOverworldBiomes::guianaShield,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_JUNGLE,
            JUNGLE,
            // Vegetation Properties
            TREE_JUNGLE,
            // Climate
            CLIMATE_HOT,
            IS_HOT,
            IS_HOT_OVERWORLD,
            IS_WET,
            CLIMATE_WET,
            // Structures
            HAS_JUNGLE_TEMPLE,
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_JUNGLE,
            HAS_STRONGHOLD,
            // Spawns
            SPAWNS_WARM_VARIANT_FROGS
    );

    public static final ResourceKey<Biome> HOWLING_PEAKS = createBiome("howling_peaks", BYGOverworldBiomes::howlingPeaks,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_MOUNTAIN,
            MOUNTAIN,
            IS_PEAK,
            MOUNTAIN_PEAK,
            // Climate
            IS_COLD,
            IS_COLD_OVERWORLD,
            CLIMATE_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_MOUNTAIN,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> JACARANDA_JUNGLE = createBiome("jacaranda_jungle", BYGOverworldBiomes::jacarandaJungle,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_JUNGLE,
            JUNGLE,
            // Climate
            IS_HOT,
            IS_HOT_OVERWORLD,
            CLIMATE_HOT,
            CLIMATE_WET,
            IS_WET,
            IS_WET_OVERWORLD,
            // Vegetation
            TREE_JUNGLE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> MAPLE_TAIGA = createBiome("maple_taiga", BYGOverworldBiomes::mapleTaiga,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            TAIGA,
            IS_TAIGA,
            IS_CONIFEROUS,
            // Vegetation Properties
            TREE_CONIFEROUS,
            // Climate
            CLIMATE_COLD,
            IS_COLD,
            IS_COLD_END,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_TAIGA
    );
    public static final ResourceKey<Biome> COCONINO_MEADOW = createBiome("coconino_meadow", BYGOverworldBiomes::coconinoMeadow,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_PLAINS,
            PLAINS,
            IS_LUSH,
            // Climate
            IS_COLD,
            IS_COLD_OVERWORLD,
            CLIMATE_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );
    public static final ResourceKey<Biome> MOJAVE_DESERT = createBiome("mojave_desert", BYGOverworldBiomes::mojaveDesert,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_SANDY,
            IS_DESERT,
            DESERT,
            // Climate Settings
            CLIMATE_DRY,
            CLIMATE_HOT,
            IS_DRY,
            IS_HOT,
            IS_HOT_OVERWORLD,
            IS_DRY_OVERWORLD,
            // Structures
            HAS_DESERT_PYRAMID,
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_DESERT,
            HAS_STRONGHOLD,
            HAS_VILLAGE_DESERT
    );

    public static final ResourceKey<Biome> CARDINAL_TUNDRA = createBiome("cardinal_tundra", BYGOverworldBiomes::cardinalTundra,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_SNOWY,
            IS_PLAINS,
            // Climate
            IS_COLD_OVERWORLD,
            IS_COLD,
            CLIMATE_COLD,
            ICY,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> ORCHARD = createBiome("orchard", BYGOverworldBiomes::orchard,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_FOREST,
            FLORAL,
            FOREST,
            IS_LUSH,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_PLAINS
    );

    public static final ResourceKey<Biome> PRAIRIE = createBiome("prairie", BYGOverworldBiomes::prairie,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_PLAINS,
            // Climate
            CLIMATE_HOT,
            IS_HOT,
            IS_HOT_OVERWORLD,
            IS_DRY_OVERWORLD,
            IS_DRY,
            CLIMATE_DRY,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> RED_OAK_FOREST = createBiome("red_oak_forest", BYGOverworldBiomes::redOakForest,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_FOREST,
            FOREST,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_PLAINS
    );

    public static final ResourceKey<Biome> RED_ROCK_VALLEY = createBiome("red_rock_valley", BYGOverworldBiomes::redRockValley,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_BADLANDS,
            BADLANDS,
            MESA,
            // Climate
            IS_DRY,
            IS_DRY_OVERWORLD,
            IS_HOT_OVERWORLD,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_MINESHAFT,
            HAS_MINESHAFT_MESA,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_MOUNTAIN,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_RED_ROCK
    );

    public static final ResourceKey<Biome> ROSE_FIELDS = createBiome("rose_fields", BYGOverworldBiomes::roseFields,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_PLAINS,
            FLORAL,
            IS_LUSH,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> AUTUMNAL_FOREST = createBiome("autumnal_forest", BYGOverworldBiomes::autumnalForest,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            FOREST,
            IS_FOREST,
            // Climate
            CLIMATE_COLD,
            IS_COLD,
            IS_COLD_OVERWORLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> AUTUMNAL_TAIGA = createBiome("autumnal_taiga", (placedFeatureHolderGetter, carverHolderGetter) -> autumnalTaiga(placedFeatureHolderGetter, carverHolderGetter, false),
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_TAIGA,
            TAIGA,
            IS_CONIFEROUS,
            // Climate
            CLIMATE_COLD,
            IS_COLD,
            IS_COLD_OVERWORLD,
            // Vegetation
            TREE_CONIFEROUS,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_STRONGHOLD,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_VILLAGE_TAIGA
    );

    public static final ResourceKey<Biome> SHATTERED_GLACIER = createBiome("shattered_glacier", BYGOverworldBiomes::shatteredGlacier,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            ICY,
            IS_SNOWY,
            IS_SNOWY,
            SNOWY,
            // Climate
            CLIMATE_COLD,
            IS_COLD,
            IS_COLD_OVERWORLD,
            // Structures
            HAS_IGLOO,
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_SNOWY
    );

    public static final ResourceKey<Biome> FIRECRACKER_SHRUBLAND = createBiome("firecracker_shrubland", BYGOverworldBiomes::firecrackerShrubland,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            PLAINS,
            IS_PLAINS,
            // Climate
            CLIMATE_TEMPERATE,
            // Structure
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> SIERRA_BADLANDS = createBiome("sierra_badlands", BYGOverworldBiomes::sierraBadlands,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_BADLANDS,
            BADLANDS,
            IS_BADLANDS,
            MESA,
            // Climate
            CLIMATE_DRY,
            CLIMATE_HOT,
            IS_HOT,
            IS_HOT_OVERWORLD,
            IS_DRY_OVERWORLD,
            IS_DRY,
            // Structures
            HAS_MINESHAFT_MESA,
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_MOUNTAIN,
            HAS_RUINED_PORTAL_STANDARD
    );

    public static final ResourceKey<Biome> SKYRIS_VALE = createBiome("skyris_vale", BYGOverworldBiomes::skyrisVale,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_LUSH,
            // Climate
            CLIMATE_COLD,
            IS_COLD,
            IS_COLD_OVERWORLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_SKYRIS
    );

    public static final ResourceKey<Biome> REDWOOD_THICKET = createBiome("redwood_thicket", BYGOverworldBiomes::redwoodThicket,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_FOREST,
            FOREST,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_ANCIENT_SEQUOIA
    );

    public static final ResourceKey<Biome> FROSTED_TAIGA = createBiome("frosted_taiga", (placedFeatureHolderGetter, carverHolderGetter) -> frostedTaiga(placedFeatureHolderGetter, carverHolderGetter, true, false),
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            ICY,
            SNOWY,
            IS_SNOWY,
            TAIGA,
            IS_TAIGA,
            // Vegetation
            TREE_CONIFEROUS,
            // Climate
            CLIMATE_COLD,
            IS_COLD,
            IS_COLD_OVERWORLD,
            // Structures
            HAS_VILLAGE_SNOWY,
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> FROSTED_CONIFEROUS_FOREST = createBiome("frosted_coniferous_forest", (placedFeatureHolderGetter, carverHolderGetter) -> coniferousForest(placedFeatureHolderGetter, carverHolderGetter, true),
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_SNOWY,
            ICY,
            SNOWY,
            TAIGA,
            IS_TAIGA,
            // Vegetation
            TREE_CONIFEROUS,
            // Climate
            CLIMATE_COLD,
            IS_COLD_OVERWORLD,
            IS_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_SNOWY,
            HAS_VILLAGE_TAIGA
    );

    public static final ResourceKey<Biome> FRAGMENT_FOREST = createBiome("fragment_forest", BYGOverworldBiomes::fragmentForest,
            // Dimensions
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_FOREST,
            FOREST,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> TROPICAL_RAINFOREST = createBiome("tropical_rainforest", BYGOverworldBiomes::tropicalRainforest,
            // Dimension
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            FOREST,
            IS_FOREST,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> TWILIGHT_MEADOW = createBiome("twilight_meadow", BYGOverworldBiomes::twilightMeadow,
            // Dimensions
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_MAGICAL,
            // Climate
            IS_COLD_OVERWORLD,
            IS_COLD,
            CLIMATE_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> WEEPING_WITCH_FOREST = createBiome("weeping_witch_forest", BYGOverworldBiomes::weepingWitchForest,
            // Dimensions
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_SPOOKY,
            // Climate
            IS_COLD,
            IS_COLD_OVERWORLD,
            CLIMATE_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> WHITE_MANGROVE_MARSHES = createBiome("white_mangrove_marshes", BYGOverworldBiomes::whiteMangroveMarshes,
            // Dimensions
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_SWAMP,
            SWAMP,
            IS_LUSH,
            // Vegetation
            VEGETATION_DENSE,
            IS_DENSE,
            // Climate
            CLIMATE_WET,
            IS_WET_OVERWORLD,
            IS_WET,
            // Structures
            HAS_SWAMP_HUT,
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_SWAMP,
            HAS_STRONGHOLD,
            // Spawns
            SPAWNS_WARM_VARIANT_FROGS,
            ALLOWS_SURFACE_SLIME_SPAWNS
    );

    public static final ResourceKey<Biome> FORGOTTEN_FOREST = createBiome("forgotten_forest", BYGOverworldBiomes::forgottenForest,
            // Dimensions
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_FOREST,
            FOREST,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD,
            HAS_VILLAGE_PLAINS
    );

    public static final ResourceKey<Biome> ZELKOVA_FOREST = createBiome("zelkova_forest", BYGOverworldBiomes::zelkovaForest,
            // Dimensions
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_FOREST,
            FOREST,
            // Climate
            IS_COLD,
            IS_COLD_OVERWORLD,
            CLIMATE_COLD,
            // Structures
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    /************Beach Biomes*************/
    public static final ResourceKey<Biome> RAINBOW_BEACH = createBiome("rainbow_beach", BYGOverworldBiomes::rainbowBeach,
            // Dimensions
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_BEACH,
            BEACH,
            IS_SANDY,
            IS_MAGICAL,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_SHIPWRECK_BEACHED,
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> BASALT_BARRERA = createBiome("basalt_barrera", BYGOverworldBiomes::basaltBarrera,
            // Dimensions
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_BEACH,
            BEACH,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_SHIPWRECK_BEACHED,
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );

    public static final ResourceKey<Biome> DACITE_SHORE = createBiome("dacite_shore", BYGOverworldBiomes::daciteShore,
            // Dimensions
            IS_OVERWORLD,
            IN_OVERWORLD,
            // Properties
            IS_BEACH,
            BEACH,
            IS_SANDY,
            // Climate
            CLIMATE_TEMPERATE,
            // Structures
            HAS_SHIPWRECK_BEACHED,
            HAS_MINESHAFT,
            HAS_PILLAGER_OUTPOST,
            HAS_RUINED_PORTAL_STANDARD,
            HAS_STRONGHOLD
    );


    /************Nether Biomes************/
    public static final ResourceKey<Biome> BRIMSTONE_CAVERNS = createBiome("brimstone_caverns", BYGNetherBiomes::brimstoneCaverns,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_HOT_NETHER,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );

    public static final ResourceKey<Biome> CRIMSON_GARDENS = createBiome("crimson_gardens", BYGNetherBiomes::crimsonGardens,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_HOT_NETHER,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );

    public static final ResourceKey<Biome> EMBUR_BOG = createBiome("embur_bog", BYGNetherBiomes::emburBog,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_HOT_NETHER,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );

    public static final ResourceKey<Biome> GLOWSTONE_GARDENS = createBiome("glowstone_gardens", BYGNetherBiomes::glowstoneGardens,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_HOT_NETHER,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );

    public static final ResourceKey<Biome> MAGMA_WASTES = createBiome("magma_wastes", BYGNetherBiomes::magmaWastes, IS_NETHER,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_HOT_NETHER,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );

    public static final ResourceKey<Biome> SUBZERO_HYPOGEAL = createBiome("subzero_hypogeal", BYGNetherBiomes::subzeroHypogeal,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_COLD_NETHER,
            IS_COLD,
            CLIMATE_COLD,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );
    public static final ResourceKey<Biome> SYTHIAN_TORRIDS = createBiome("sythian_torrids", BYGNetherBiomes::sythianTorrids,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_HOT_NETHER,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );

    public static final ResourceKey<Biome> WARPED_DESERT = createBiome("warped_desert", BYGNetherBiomes::warpedDesert,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_HOT_NETHER,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );

    public static final ResourceKey<Biome> WAILING_GARTH = createBiome("wailing_garth", BYGNetherBiomes::wailingGarth,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_HOT_NETHER,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );

    public static final ResourceKey<Biome> ARISIAN_UNDERGROWTH = createBiome("arisian_undergrowth", BYGNetherBiomes::arisianUndergrowth,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_HOT_NETHER,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );

    public static final ResourceKey<Biome> WEEPING_MIRE = createBiome("weeping_mire", BYGNetherBiomes::weepingMire,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_HOT_NETHER,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );

    public static final ResourceKey<Biome> QUARTZ_DESERT = createBiome("quartz_desert", BYGNetherBiomes::quartzDesert,
            // Dimensions
            IS_NETHER,
            IN_NETHER,
            // Climate
            IS_HOT_NETHER,
            IS_HOT,
            CLIMATE_HOT,
            // Structures
            HAS_NETHER_FORTRESS,
            HAS_BASTION_REMNANT,
            HAS_RUINED_PORTAL_NETHER
    );

    /************End Biomes************/
    public static final ResourceKey<Biome> IVIS_FIELDS = createBiome("ivis_fields", BYGEndBiomes::ivisFields,
            // Dimensions
            IS_END,
            // Climate
            IS_COLD_END,
            IS_COLD,
            CLIMATE_COLD
    );

    public static final ResourceKey<Biome> NIGHTSHADE_FOREST = createBiome("nightshade_forest", BYGEndBiomes::nightshadeForest,
            // Dimensions
            IS_END,
            // Climate
            IS_COLD_END,
            IS_COLD,
            CLIMATE_COLD
    );

    public static final ResourceKey<Biome> ETHEREAL_ISLANDS = createBiome("ethereal_islands", BYGEndBiomes::etherealIslands,
            // Dimensions
            IS_END,
            // Climate
            IS_COLD_END,
            IS_COLD,
            CLIMATE_COLD
    );
    public static final ResourceKey<Biome> VISCAL_ISLES = createBiome("viscal_isles", BYGEndBiomes::viscalIsles,
            // Dimensions
            IS_END,
            // Climate
            IS_COLD_END,
            IS_COLD,
            CLIMATE_COLD
    );

    public static final ResourceKey<Biome> BULBIS_GARDENS = createBiome("bulbis_gardens", BYGEndBiomes::bulbisGardens,
            // Dimensions
            IS_END,
            // Climate
            IS_COLD_END,
            IS_COLD,
            CLIMATE_COLD
    );

    public static final ResourceKey<Biome> SHULKREN_FOREST = createBiome("shulkren_forest", BYGEndBiomes::shulkrenForest,
            // Dimensions
            IS_END,
            // Climate
            IS_COLD_END,
            IS_COLD,
            CLIMATE_COLD
    );

    public static final ResourceKey<Biome> CRYPTIC_WASTES = createBiome("cryptic_wastes", BYGEndBiomes::crypticWastes,
            // Dimensions
            IS_END,
            // Climate
            IS_COLD_END,
            IS_COLD,
            CLIMATE_COLD
    );

    public static final ResourceKey<Biome> IMPARIUS_GROVE = createBiome("imparius_grove", BYGEndBiomes::impariusGrove,
            // Dimensions
            IS_END,
            // Climate
            IS_COLD_END,
            IS_COLD,
            CLIMATE_COLD
    );

    @SafeVarargs
    public static <B extends Biome> ResourceKey<Biome> createBiome(String id, BiomeFactory biomeFactory, TagKey<Biome>... tags) {
        ResourceKey<Biome> biomeResourceKey = ResourceKey.create(Registries.BIOME, BYG.createLocation(id));
        BIOME_FACTORIES.put(biomeResourceKey, biomeFactory);


        if (BYGConstants.BIOMES) {
            for (TagKey<Biome> tag : tags) {
                BIOMES_BY_TAG.put(tag, biomeResourceKey);
            }
        }


        return biomeResourceKey;
    }

    public static void loadClass() {
        BYGStructurePieceTypes.bootStrap();
        BYGStructureSets.bootStrap();
        BYGPlacementModifierType.bootStrap();
        BYGRuleSources.bootStrap();
    }


    @FunctionalInterface
    public interface BiomeFactory {

        Biome generate(HolderGetter<PlacedFeature> placedFeatureHolderGetter, HolderGetter<ConfiguredWorldCarver<?>> worldCarverHolderGetter);
    }
}