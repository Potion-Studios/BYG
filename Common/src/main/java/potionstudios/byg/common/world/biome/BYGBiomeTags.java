package potionstudios.byg.common.world.biome;

import com.google.common.base.Suppliers;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.Registry;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class BYGBiomeTags {

    public static final TagKey<Biome> HAS_VILLAGE_SKYRIS = create("has_structure/village_skyris");
    public static final TagKey<Biome> HAS_VILLAGE_RUINS = create("has_structure/village_ruins");
    public static final TagKey<Biome> HAS_VILLAGE_TROPICAL = create("has_structure/village_tropical");
    public static final TagKey<Biome> HAS_VILLAGE_RED_ROCK = create("has_structure/village_red_rock");
    public static final TagKey<Biome> HAS_VILLAGE_SALEM = create("has_structure/village_salem");
    public static final TagKey<Biome> HAS_PUMPKIN_PATCH = create("has_structure/pumpkin_patch");
    public static final TagKey<Biome> HAS_RED_ROCK_ARCH = create("has_structure/red_rock_arch");
    public static final TagKey<Biome> HAS_OVERGROWN_STONE_ARCH = create("has_structure/overgrown_stone_arch");
    public static final TagKey<Biome> HAS_STONE_ARCH = create("has_structure/stone_arch");
    public static final TagKey<Biome> HAS_ANCIENT_SEQUOIA = create("has_structure/ancient_sequoia");

    public static final TagKey<Biome> HAS_PALM_TREES = create("has_feature/palm_trees");

    public static final TagKey<Biome> IS_DESERT = create("is_desert");
    public static final TagKey<Biome> IS_PLAIN = create("is_plain");


    // Vanilla
    public static final TagKey<Biome> IS_DEEP_OCEAN = create("is_deep_ocean");
    public static final TagKey<Biome> IS_OCEAN = create("is_ocean");
    public static final TagKey<Biome> IS_BEACH = create("is_beach");
    public static final TagKey<Biome> IS_RIVER = create("is_river");
    public static final TagKey<Biome> IS_MOUNTAIN = create("is_mountain");
    public static final TagKey<Biome> IS_BADLANDS = create("is_badlands");
    public static final TagKey<Biome> IS_HILL = create("is_hill");
    public static final TagKey<Biome> IS_TAIGA = create("is_taiga");
    public static final TagKey<Biome> IS_JUNGLE = create("is_jungle");
    public static final TagKey<Biome> IS_FOREST = create("is_forest");
    public static final TagKey<Biome> IS_SAVANNA = create("is_savanna");
    public static final TagKey<Biome> IS_OVERWORLD = create("is_overworld");
    public static final TagKey<Biome> IS_NETHER = create("is_nether");
    public static final TagKey<Biome> IS_END = create("is_end");
    public static final TagKey<Biome> STRONGHOLD_BIASED_TO = create("stronghold_biased_to");
    public static final TagKey<Biome> HAS_BURIED_TREASURE = create("has_structure/buried_treasure");
    public static final TagKey<Biome> HAS_DESERT_PYRAMID = create("has_structure/desert_pyramid");
    public static final TagKey<Biome> HAS_IGLOO = create("has_structure/igloo");
    public static final TagKey<Biome> HAS_JUNGLE_TEMPLE = create("has_structure/jungle_temple");
    public static final TagKey<Biome> HAS_MINESHAFT = create("has_structure/mineshaft");
    public static final TagKey<Biome> HAS_MINESHAFT_MESA = create("has_structure/mineshaft_mesa");
    public static final TagKey<Biome> HAS_OCEAN_MONUMENT = create("has_structure/ocean_monument");
    public static final TagKey<Biome> HAS_OCEAN_RUIN_COLD = create("has_structure/ocean_ruin_cold");
    public static final TagKey<Biome> HAS_OCEAN_RUIN_WARM = create("has_structure/ocean_ruin_warm");
    public static final TagKey<Biome> HAS_PILLAGER_OUTPOST = create("has_structure/pillager_outpost");
    public static final TagKey<Biome> HAS_RUINED_PORTAL_DESERT = create("has_structure/ruined_portal_desert");
    public static final TagKey<Biome> HAS_RUINED_PORTAL_JUNGLE = create("has_structure/ruined_portal_jungle");
    public static final TagKey<Biome> HAS_RUINED_PORTAL_OCEAN = create("has_structure/ruined_portal_ocean");
    public static final TagKey<Biome> HAS_RUINED_PORTAL_SWAMP = create("has_structure/ruined_portal_swamp");
    public static final TagKey<Biome> HAS_RUINED_PORTAL_MOUNTAIN = create("has_structure/ruined_portal_mountain");
    public static final TagKey<Biome> HAS_RUINED_PORTAL_STANDARD = create("has_structure/ruined_portal_standard");
    public static final TagKey<Biome> HAS_SHIPWRECK_BEACHED = create("has_structure/shipwreck_beached");
    public static final TagKey<Biome> HAS_SHIPWRECK = create("has_structure/shipwreck");
    public static final TagKey<Biome> HAS_STRONGHOLD = create("has_structure/stronghold");
    public static final TagKey<Biome> HAS_SWAMP_HUT = create("has_structure/swamp_hut");
    public static final TagKey<Biome> HAS_VILLAGE_DESERT = create("has_structure/village_desert");
    public static final TagKey<Biome> HAS_VILLAGE_PLAINS = create("has_structure/village_plains");
    public static final TagKey<Biome> HAS_VILLAGE_SAVANNA = create("has_structure/village_savanna");
    public static final TagKey<Biome> HAS_VILLAGE_SNOWY = create("has_structure/village_snowy");
    public static final TagKey<Biome> HAS_VILLAGE_TAIGA = create("has_structure/village_taiga");
    public static final TagKey<Biome> HAS_WOODLAND_MANSION = create("has_structure/woodland_mansion");
    public static final TagKey<Biome> HAS_NETHER_FORTRESS = create("has_structure/nether_fortress");
    public static final TagKey<Biome> HAS_NETHER_FOSSIL = create("has_structure/nether_fossil");
    public static final TagKey<Biome> HAS_BASTION_REMNANT = create("has_structure/bastion_remnant");
    public static final TagKey<Biome> HAS_ANCIENT_CITY = create("has_structure/ancient_city");
    public static final TagKey<Biome> HAS_RUINED_PORTAL_NETHER = create("has_structure/ruined_portal_nether");
    public static final TagKey<Biome> HAS_END_CITY = create("has_structure/end_city");
    public static final TagKey<Biome> REQUIRED_OCEAN_MONUMENT_SURROUNDING = create("required_ocean_monument_surrounding");
    public static final TagKey<Biome> MINESHAFT_BLOCKING = create("mineshaft_blocking");
    public static final TagKey<Biome> PLAYS_UNDERWATER_MUSIC = create("plays_underwater_music");
    public static final TagKey<Biome> HAS_CLOSER_WATER_FOG = create("has_closer_water_fog");
    public static final TagKey<Biome> WATER_ON_MAP_OUTLINES = create("water_on_map_outlines");
    public static final TagKey<Biome> PRODUCES_CORALS_FROM_BONEMEAL = create("produces_corals_from_bonemeal");
    public static final TagKey<Biome> WITHOUT_ZOMBIE_SIEGES = create("without_zombie_sieges");
    public static final TagKey<Biome> WITHOUT_PATROL_SPAWNS = create("without_patrol_spawns");
    public static final TagKey<Biome> WITHOUT_WANDERING_TRADER_SPAWNS = create("without_wandering_trader_spawns");
    public static final TagKey<Biome> SPAWNS_COLD_VARIANT_FROGS = create("spawns_cold_variant_frogs");
    public static final TagKey<Biome> SPAWNS_WARM_VARIANT_FROGS = create("spawns_warm_variant_frogs");
    public static final TagKey<Biome> ONLY_ALLOWS_SNOW_AND_GOLD_RABBITS = create("only_allows_snow_and_gold_rabbits");
    public static final TagKey<Biome> REDUCED_WATER_AMBIENT_SPAWNS = create("reduce_water_ambient_spawns");
    public static final TagKey<Biome> ALLOWS_TROPICAL_FISH_SPAWNS_AT_ANY_HEIGHT = create("allows_tropical_fish_spawns_at_any_height");
    public static final TagKey<Biome> POLAR_BEARS_SPAWN_ON_ALTERNATE_BLOCKS = create("polar_bears_spawn_on_alternate_blocks");
    public static final TagKey<Biome> MORE_FREQUENT_DROWNED_SPAWNS = create("more_frequent_drowned_spawns");
    public static final TagKey<Biome> ALLOWS_SURFACE_SLIME_SPAWNS = create("allows_surface_slime_spawns");


    // Climate
    public static final TagKey<Biome> CLIMATE_HOT_OVERWORLD = create("overworld/climate/hot");
    public static final TagKey<Biome> CLIMATE_TEMPERATE_OVERWORLD = create("overworld/climate/temperate");
    public static final TagKey<Biome> CLIMATE_COLD_OVERWORLD = create("overworld/climate/cold");
    public static final TagKey<Biome> CLIMATE_WET_OVERWORLD = create("overworld/climate/wet");
    public static final TagKey<Biome> CLIMATE_DRY_OVERWORLD = create("overworld/climate/dry");

    public static final TagKey<Biome> CLIMATE_HOT_NETHER = create("nether/climate/hot");
    public static final TagKey<Biome> CLIMATE_TEMPERATE_NETHER = create("nether/climate/temperate");
    public static final TagKey<Biome> CLIMATE_COLD_NETHER = create("nether/climate/cold");
    public static final TagKey<Biome> CLIMATE_WET_NETHER = create("nether/climate/wet");
    public static final TagKey<Biome> CLIMATE_DRY_NETHER = create("nether/climate/dry");

    public static final TagKey<Biome> CLIMATE_HOT_END = create("end/climate/hot");
    public static final TagKey<Biome> CLIMATE_TEMPERATE_END = create("end/climate/temperate");
    public static final TagKey<Biome> CLIMATE_COLD_END = create("end/climate/cold");
    public static final TagKey<Biome> CLIMATE_WET_END = create("end/climate/wet");
    public static final TagKey<Biome> CLIMATE_DRY_END = create("end/climate/dry");

    // Vegetation
    public static final TagKey<Biome> IS_VEGETATION_SPARSE_OVERWORLD = create("overworld/vegetation/is_sparse");
    public static final TagKey<Biome> IS_VEGETATION_SPARSE_NETHER = create("nether/vegetation/is_sparse");
    public static final TagKey<Biome> IS_VEGETATION_SPARSE_END = create("end/vegetation/is_sparse");

    public static final TagKey<Biome> IS_VEGETATION_DENSE_OVERWORLD = create("overworld/vegetation/is_dense");
    public static final TagKey<Biome> IS_VEGETATION_DENSE_NETHER = create("nether/vegetation/is_dense");
    public static final TagKey<Biome> IS_VEGETATION_DENSE_END = create("end/vegetation/is_dense");


    public static final TagKey<Biome> IS_ICY = create("is_icy");
    public static final TagKey<Biome> IS_SNOWY = create("is_snowy");
    public static final TagKey<Biome> IS_SANDY = create("is_sandy");
    public static final TagKey<Biome> IS_SWAMP = create("is_swamp");
    public static final TagKey<Biome> IS_WASTELAND = create("is_wasteland");
    public static final TagKey<Biome> IS_DEAD = create("is_dead");


    public static final TagKey<Biome> IS_SPOOKY = create("is_spooky");
    public static final TagKey<Biome> IS_MAGICAL = create("is_magical");


    private static TagKey<Biome> create(String id) {
        return TagKey.create(Registry.BIOME_REGISTRY, BYG.createLocation(id));
    }

    // Biome tag and what tags from vanilla or a mod loader to append to.
    public static final Supplier<Map<TagKey<Biome>, Set<TagKey<Biome>>>> BYG_BIOME_TAGS_TO_TAGS = Suppliers.memoize(() -> {
        Map<TagKey<Biome>, Set<TagKey<Biome>>> map = new Object2ObjectOpenHashMap<>();
        map.put(IS_DESERT, Set.of(ModLoaderBiomeTags.Fabric.DESERT, ModLoaderBiomeTags.Forge.IS_DESERT));
        map.put(IS_PLAIN, Set.of(ModLoaderBiomeTags.Forge.IS_PLAINS, ModLoaderBiomeTags.Fabric.PLAINS));
        map.put(IS_OCEAN, Set.of(BiomeTags.IS_OCEAN, ModLoaderBiomeTags.Fabric.OCEAN));
        map.put(IS_DEEP_OCEAN, Set.of(BiomeTags.IS_DEEP_OCEAN, ModLoaderBiomeTags.Fabric.DEEP_OCEAN));
        map.put(IS_BEACH, Set.of(BiomeTags.IS_BEACH, ModLoaderBiomeTags.Fabric.BEACH, ModLoaderBiomeTags.Forge.IS_BEACH));
        map.put(IS_RIVER, Set.of(BiomeTags.IS_RIVER, ModLoaderBiomeTags.Fabric.RIVER));
        map.put(IS_MOUNTAIN, Set.of(BiomeTags.IS_MOUNTAIN, ModLoaderBiomeTags.Fabric.MOUNTAIN));
        map.put(IS_BADLANDS, Set.of(BiomeTags.IS_BADLANDS, ModLoaderBiomeTags.Fabric.BADLANDS));
        map.put(IS_TAIGA, Set.of(BiomeTags.IS_TAIGA, ModLoaderBiomeTags.Fabric.TAIGA));
        map.put(IS_JUNGLE, Set.of(BiomeTags.IS_JUNGLE, ModLoaderBiomeTags.Fabric.JUNGLE));
        map.put(IS_FOREST, Set.of(BiomeTags.IS_FOREST, ModLoaderBiomeTags.Fabric.FOREST));
        map.put(IS_HILL, Set.of(BiomeTags.IS_HILL, ModLoaderBiomeTags.Fabric.EXTREME_HILLS));
        map.put(IS_SAVANNA, Set.of(BiomeTags.IS_SAVANNA, ModLoaderBiomeTags.Fabric.SAVANNA, ModLoaderBiomeTags.Forge.IS_SAVANNA));
        map.put(IS_OVERWORLD, Set.of(BiomeTags.IS_OVERWORLD, ModLoaderBiomeTags.Fabric.IN_OVERWORLD, ModLoaderBiomeTags.Forge.IS_OVERWORLD));
        map.put(IS_NETHER, Set.of(BiomeTags.IS_NETHER, ModLoaderBiomeTags.Fabric.IN_NETHER, ModLoaderBiomeTags.Forge.IS_OVERWORLD));
        map.put(IS_END, Set.of(BiomeTags.IS_END, ModLoaderBiomeTags.Fabric.IN_THE_END, ModLoaderBiomeTags.Forge.IS_END));
        map.put(STRONGHOLD_BIASED_TO, Set.of(BiomeTags.STRONGHOLD_BIASED_TO));
        map.put(HAS_BURIED_TREASURE, Set.of(BiomeTags.HAS_BURIED_TREASURE));
        map.put(HAS_DESERT_PYRAMID, Set.of(BiomeTags.HAS_DESERT_PYRAMID));
        map.put(HAS_IGLOO, Set.of(BiomeTags.HAS_IGLOO));
        map.put(HAS_JUNGLE_TEMPLE, Set.of(BiomeTags.HAS_JUNGLE_TEMPLE));
        map.put(HAS_MINESHAFT, Set.of(BiomeTags.HAS_MINESHAFT));
        map.put(HAS_MINESHAFT_MESA, Set.of(BiomeTags.HAS_MINESHAFT_MESA));
        map.put(HAS_OCEAN_MONUMENT, Set.of(BiomeTags.HAS_OCEAN_MONUMENT));
        map.put(HAS_OCEAN_RUIN_COLD, Set.of(BiomeTags.HAS_OCEAN_RUIN_COLD));
        map.put(HAS_OCEAN_RUIN_WARM, Set.of(BiomeTags.HAS_OCEAN_RUIN_WARM));
        map.put(HAS_PILLAGER_OUTPOST, Set.of(BiomeTags.HAS_PILLAGER_OUTPOST));
        map.put(HAS_RUINED_PORTAL_DESERT, Set.of(BiomeTags.HAS_RUINED_PORTAL_DESERT));
        map.put(HAS_RUINED_PORTAL_JUNGLE, Set.of(BiomeTags.HAS_RUINED_PORTAL_JUNGLE));
        map.put(HAS_RUINED_PORTAL_OCEAN, Set.of(BiomeTags.HAS_RUINED_PORTAL_OCEAN));
        map.put(HAS_RUINED_PORTAL_SWAMP, Set.of(BiomeTags.HAS_RUINED_PORTAL_SWAMP));
        map.put(HAS_RUINED_PORTAL_MOUNTAIN, Set.of(BiomeTags.HAS_RUINED_PORTAL_MOUNTAIN));
        map.put(HAS_RUINED_PORTAL_STANDARD, Set.of(BiomeTags.HAS_RUINED_PORTAL_STANDARD));
        map.put(HAS_SHIPWRECK_BEACHED, Set.of(BiomeTags.HAS_SHIPWRECK_BEACHED));
        map.put(HAS_SHIPWRECK, Set.of(BiomeTags.HAS_SHIPWRECK));
        map.put(HAS_STRONGHOLD, Set.of(BiomeTags.HAS_STRONGHOLD));
        map.put(HAS_SWAMP_HUT, Set.of(BiomeTags.HAS_SWAMP_HUT));
        map.put(HAS_VILLAGE_DESERT, Set.of(BiomeTags.HAS_VILLAGE_DESERT));
        map.put(HAS_VILLAGE_PLAINS, Set.of(BiomeTags.HAS_VILLAGE_PLAINS));
        map.put(HAS_VILLAGE_SAVANNA, Set.of(BiomeTags.HAS_VILLAGE_SAVANNA));
        map.put(HAS_VILLAGE_SNOWY, Set.of(BiomeTags.HAS_VILLAGE_SNOWY));
        map.put(HAS_VILLAGE_TAIGA, Set.of(BiomeTags.HAS_VILLAGE_TAIGA));
        map.put(HAS_WOODLAND_MANSION, Set.of(BiomeTags.HAS_WOODLAND_MANSION));
        map.put(HAS_NETHER_FORTRESS, Set.of(BiomeTags.HAS_NETHER_FORTRESS));
        map.put(HAS_NETHER_FOSSIL, Set.of(BiomeTags.HAS_NETHER_FOSSIL));
        map.put(HAS_BASTION_REMNANT, Set.of(BiomeTags.HAS_BASTION_REMNANT));
        map.put(HAS_ANCIENT_CITY, Set.of(BiomeTags.HAS_ANCIENT_CITY));
        map.put(HAS_RUINED_PORTAL_NETHER, Set.of(BiomeTags.HAS_RUINED_PORTAL_NETHER));
        map.put(HAS_END_CITY, Set.of(BiomeTags.HAS_END_CITY));
        map.put(REQUIRED_OCEAN_MONUMENT_SURROUNDING, Set.of(BiomeTags.REQUIRED_OCEAN_MONUMENT_SURROUNDING));
        map.put(MINESHAFT_BLOCKING, Set.of(BiomeTags.MINESHAFT_BLOCKING));
        map.put(PLAYS_UNDERWATER_MUSIC, Set.of(BiomeTags.PLAYS_UNDERWATER_MUSIC));
        map.put(HAS_CLOSER_WATER_FOG, Set.of(BiomeTags.HAS_CLOSER_WATER_FOG));
        map.put(WATER_ON_MAP_OUTLINES, Set.of(BiomeTags.WATER_ON_MAP_OUTLINES));
        map.put(PRODUCES_CORALS_FROM_BONEMEAL, Set.of(BiomeTags.PRODUCES_CORALS_FROM_BONEMEAL));
        map.put(WITHOUT_ZOMBIE_SIEGES, Set.of(BiomeTags.WITHOUT_ZOMBIE_SIEGES));
        map.put(WITHOUT_PATROL_SPAWNS, Set.of(BiomeTags.WITHOUT_PATROL_SPAWNS));
        map.put(WITHOUT_WANDERING_TRADER_SPAWNS, Set.of(BiomeTags.WITHOUT_WANDERING_TRADER_SPAWNS));
        map.put(SPAWNS_COLD_VARIANT_FROGS, Set.of(BiomeTags.SPAWNS_COLD_VARIANT_FROGS));
        map.put(SPAWNS_WARM_VARIANT_FROGS, Set.of(BiomeTags.SPAWNS_WARM_VARIANT_FROGS));
        map.put(ONLY_ALLOWS_SNOW_AND_GOLD_RABBITS, Set.of(BiomeTags.ONLY_ALLOWS_SNOW_AND_GOLD_RABBITS));
        map.put(REDUCED_WATER_AMBIENT_SPAWNS, Set.of(BiomeTags.REDUCED_WATER_AMBIENT_SPAWNS));
        map.put(ALLOWS_TROPICAL_FISH_SPAWNS_AT_ANY_HEIGHT, Set.of(BiomeTags.ALLOWS_TROPICAL_FISH_SPAWNS_AT_ANY_HEIGHT));
        map.put(POLAR_BEARS_SPAWN_ON_ALTERNATE_BLOCKS, Set.of(BiomeTags.POLAR_BEARS_SPAWN_ON_ALTERNATE_BLOCKS));
        map.put(MORE_FREQUENT_DROWNED_SPAWNS, Set.of(BiomeTags.MORE_FREQUENT_DROWNED_SPAWNS));
        map.put(ALLOWS_SURFACE_SLIME_SPAWNS, Set.of(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS));
        
        map.put(CLIMATE_HOT_OVERWORLD, Set.of(ModLoaderBiomeTags.Forge.IS_HOT_OVERWORLD, ModLoaderBiomeTags.Fabric.CLIMATE_HOT));
        map.put(CLIMATE_TEMPERATE_OVERWORLD, Set.of(ModLoaderBiomeTags.Fabric.CLIMATE_TEMPERATE));
        map.put(CLIMATE_COLD_OVERWORLD, Set.of(ModLoaderBiomeTags.Forge.IS_COLD_OVERWORLD, ModLoaderBiomeTags.Fabric.CLIMATE_COLD));
        map.put(CLIMATE_WET_OVERWORLD, Set.of(ModLoaderBiomeTags.Forge.IS_WET_OVERWORLD, ModLoaderBiomeTags.Fabric.CLIMATE_WET));
        map.put(CLIMATE_DRY_OVERWORLD, Set.of(ModLoaderBiomeTags.Forge.IS_DRY_OVERWORLD, ModLoaderBiomeTags.Fabric.CLIMATE_DRY));

        map.put(CLIMATE_HOT_NETHER, Set.of(ModLoaderBiomeTags.Forge.IS_HOT_NETHER));
        map.put(CLIMATE_TEMPERATE_NETHER, Set.of());
        map.put(CLIMATE_COLD_NETHER, Set.of(ModLoaderBiomeTags.Forge.IS_COLD_NETHER));
        map.put(CLIMATE_WET_NETHER, Set.of(ModLoaderBiomeTags.Forge.IS_WET_NETHER));
        map.put(CLIMATE_DRY_NETHER, Set.of(ModLoaderBiomeTags.Forge.IS_DRY_NETHER));

        map.put(CLIMATE_HOT_END, Set.of(ModLoaderBiomeTags.Forge.IS_HOT_END));
        map.put(CLIMATE_TEMPERATE_END, Set.of());
        map.put(CLIMATE_COLD_END, Set.of(ModLoaderBiomeTags.Forge.IS_COLD_END));
        map.put(CLIMATE_WET_END, Set.of(ModLoaderBiomeTags.Forge.IS_WET_END));
        map.put(CLIMATE_DRY_END, Set.of(ModLoaderBiomeTags.Forge.IS_DRY_END));

        map.put(IS_VEGETATION_SPARSE_OVERWORLD, Set.of(ModLoaderBiomeTags.Forge.IS_SPARSE_OVERWORLD, ModLoaderBiomeTags.Fabric.VEGETATION_SPARSE));
        map.put(IS_VEGETATION_SPARSE_NETHER, Set.of(ModLoaderBiomeTags.Forge.IS_SPARSE_NETHER));
        map.put(IS_VEGETATION_SPARSE_END, Set.of(ModLoaderBiomeTags.Forge.IS_SPARSE_END));

        map.put(IS_VEGETATION_DENSE_OVERWORLD, Set.of(ModLoaderBiomeTags.Forge.IS_DENSE_OVERWORLD, ModLoaderBiomeTags.Fabric.VEGETATION_SPARSE));
        map.put(IS_VEGETATION_DENSE_NETHER, Set.of(ModLoaderBiomeTags.Forge.IS_DENSE_NETHER));
        map.put(IS_VEGETATION_DENSE_END, Set.of(ModLoaderBiomeTags.Forge.IS_DENSE_END));

        map.put(IS_SNOWY, Set.of(ModLoaderBiomeTags.Forge.IS_SNOWY, ModLoaderBiomeTags.Fabric.SNOWY));
        map.put(IS_ICY, Set.of(ModLoaderBiomeTags.Fabric.ICY));
        map.put(IS_SPOOKY, Set.of(ModLoaderBiomeTags.Forge.IS_SPOOKY));
        map.put(IS_WASTELAND, Set.of(ModLoaderBiomeTags.Forge.IS_WASTELAND, ModLoaderBiomeTags.Fabric.WASTELAND));
        map.put(IS_DEAD, Set.of(ModLoaderBiomeTags.Forge.IS_DEAD, ModLoaderBiomeTags.Fabric.DEAD));
        map.put(IS_MAGICAL, Set.of(ModLoaderBiomeTags.Forge.IS_MAGICAL));

        return map;
    });
}
