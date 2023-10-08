package potionstudios.byg.common.world.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class MLBiomeTags {

    // Forge
    public static final TagKey<Biome> IS_HOT = createForge("is_hot");
    public static final TagKey<Biome> IS_HOT_OVERWORLD = createForge("is_hot/overworld");
    public static final TagKey<Biome> IS_HOT_NETHER = createForge("is_hot/nether");
    public static final TagKey<Biome> IS_HOT_END = createForge("is_hot/end");

    public static final TagKey<Biome> IS_COLD = createForge("is_cold");
    public static final TagKey<Biome> IS_COLD_OVERWORLD = createForge("is_cold/overworld");
    public static final TagKey<Biome> IS_COLD_NETHER = createForge("is_cold/nether");
    public static final TagKey<Biome> IS_COLD_END = createForge("is_cold/end");

    public static final TagKey<Biome> IS_SPARSE = createForge("is_sparse");
    public static final TagKey<Biome> IS_SPARSE_OVERWORLD = createForge("is_sparse/overworld");
    public static final TagKey<Biome> IS_SPARSE_NETHER = createForge("is_sparse/nether");
    public static final TagKey<Biome> IS_SPARSE_END = createForge("is_sparse/end");
    public static final TagKey<Biome> IS_DENSE = createForge("is_dense");
    public static final TagKey<Biome> IS_DENSE_OVERWORLD = createForge("is_dense/overworld");
    public static final TagKey<Biome> IS_DENSE_NETHER = createForge("is_dense/nether");
    public static final TagKey<Biome> IS_DENSE_END = createForge("is_dense/end");

    public static final TagKey<Biome> IS_WET = createForge("is_wet");
    public static final TagKey<Biome> IS_WET_OVERWORLD = createForge("is_wet/overworld");
    public static final TagKey<Biome> IS_WET_NETHER = createForge("is_wet/nether");
    public static final TagKey<Biome> IS_WET_END = createForge("is_wet/end");
    public static final TagKey<Biome> IS_DRY = createForge("is_dry");
    public static final TagKey<Biome> IS_DRY_OVERWORLD = createForge("is_dry/overworld");
    public static final TagKey<Biome> IS_DRY_NETHER = createForge("is_dry/nether");
    public static final TagKey<Biome> IS_DRY_END = createForge("is_dry/end");

    public static final TagKey<Biome> IS_CONIFEROUS = createForge("is_coniferous");

    public static final TagKey<Biome> IS_SPOOKY = createForge("is_spooky");
    public static final TagKey<Biome> IS_DEAD = createForge("is_dead");
    public static final TagKey<Biome> IS_LUSH = createForge("is_lush");
    public static final TagKey<Biome> IS_MUSHROOM = createForge("is_mushroom");
    public static final TagKey<Biome> IS_MAGICAL = createForge("is_magical");
    public static final TagKey<Biome> IS_RARE = createForge("is_rare");
    public static final TagKey<Biome> IS_PLATEAU = createForge("is_plateau");
    public static final TagKey<Biome> IS_MODIFIED = createForge("is_modified");

    public static final TagKey<Biome> IS_WATER = createForge("is_water");
    public static final TagKey<Biome> IS_DESERT = createForge("is_desert");
    public static final TagKey<Biome> IS_PLAINS = createForge("is_plains");
    public static final TagKey<Biome> IS_SWAMP = createForge("is_swamp");
    public static final TagKey<Biome> IS_SANDY = createForge("is_sandy");
    public static final TagKey<Biome> IS_SNOWY = createForge("is_snowy");
    public static final TagKey<Biome> IS_WASTELAND = createForge("is_wasteland");
    public static final TagKey<Biome> IS_VOID = createForge("is_void");
    public static final TagKey<Biome> IS_UNDERGROUND = createForge("is_underground");

    public static final TagKey<Biome> IS_CAVE = createForge("is_cave");
    public static final TagKey<Biome> IS_PEAK = createForge("is_peak");
    public static final TagKey<Biome> IS_SLOPE = createForge("is_slope");
    public static final TagKey<Biome> IS_MOUNTAIN = createForge("is_mountain");


    // Fabric
    public static final TagKey<Biome> IN_OVERWORLD = createFabric("in_overworld");
    public static final TagKey<Biome> IN_THE_END = createFabric("in_the_end");
    public static final TagKey<Biome> IN_NETHER = createFabric("in_nether");
    public static final TagKey<Biome> TAIGA = createFabric("taiga");
    public static final TagKey<Biome> EXTREME_HILLS = createFabric("extreme_hills");
    public static final TagKey<Biome> WINDSWEPT = createFabric("windswept");
    public static final TagKey<Biome> JUNGLE = createFabric("jungle");
    public static final TagKey<Biome> MESA = createFabric("mesa");
    public static final TagKey<Biome> PLAINS = createFabric("plains");
    public static final TagKey<Biome> SAVANNA = createFabric("savanna");
    public static final TagKey<Biome> ICY = createFabric("icy");
    public static final TagKey<Biome> AQUATIC_ICY = createFabric("aquatic_icy");
    public static final TagKey<Biome> BEACH = createFabric("beach");
    public static final TagKey<Biome> FOREST = createFabric("forest");
    public static final TagKey<Biome> BIRCH_FOREST = createFabric("birch_forest");
    public static final TagKey<Biome> OCEAN = createFabric("ocean");
    public static final TagKey<Biome> DESERT = createFabric("desert");
    public static final TagKey<Biome> RIVER = createFabric("river");
    public static final TagKey<Biome> SWAMP = createFabric("swamp");
    public static final TagKey<Biome> MUSHROOM = createFabric("mushroom");
    public static final TagKey<Biome> UNDERGROUND = createFabric("underground");
    public static final TagKey<Biome> MOUNTAIN = createFabric("mountain");
    public static final TagKey<Biome> CLIMATE_HOT = createFabric("climate_hot");
    public static final TagKey<Biome> CLIMATE_TEMPERATE = createFabric("climate_temperate");
    public static final TagKey<Biome> CLIMATE_COLD = createFabric("climate_cold");
    public static final TagKey<Biome> CLIMATE_WET = createFabric("climate_wet");
    public static final TagKey<Biome> CLIMATE_DRY = createFabric("climate_dry");
    public static final TagKey<Biome> VEGETATION_SPARSE = createFabric("vegetation_sparse");
    public static final TagKey<Biome> VEGETATION_DENSE = createFabric("vegetation_dense");
    public static final TagKey<Biome> TREE_CONIFEROUS = createFabric("tree_coniferous");
    public static final TagKey<Biome> TREE_SAVANNA = createFabric("tree_savanna");
    public static final TagKey<Biome> TREE_JUNGLE = createFabric("tree_jungle");
    public static final TagKey<Biome> TREE_DECIDUOUS = createFabric("tree_deciduous");
    public static final TagKey<Biome> VOID = createFabric("void");
    public static final TagKey<Biome> MOUNTAIN_PEAK = createFabric("mountain_peak");
    public static final TagKey<Biome> MOUNTAIN_SLOPE = createFabric("mountain_slope");
    public static final TagKey<Biome> AQUATIC = createFabric("aquatic");
    public static final TagKey<Biome> WASTELAND = createFabric("wasteland");
    public static final TagKey<Biome> DEAD = createFabric("dead");
    public static final TagKey<Biome> FLORAL = createFabric("floral");
    public static final TagKey<Biome> SNOWY = createFabric("snowy");

    public static final TagKey<Biome> BADLANDS = createFabric("badlands");
    public static final TagKey<Biome> CAVES = createFabric("caves");

    public static final TagKey<Biome> END_ISLANDS = createFabric("end_islands");
    public static final TagKey<Biome> NETHER_FORESTS = createFabric("nether_forests");

    public static final TagKey<Biome> SNOWY_PLAINS = createFabric("snowy_plains");
    public static final TagKey<Biome> STONY_SHORES = createFabric("stony_shores");
    public static final TagKey<Biome> FLOWER_FORESTS = createFabric("flower_forests");
    public static final TagKey<Biome> DEEP_OCEAN = createFabric("deep_ocean");
    public static final TagKey<Biome> SHALLOW_OCEAN = createFabric("shallow_ocean");

    private static TagKey<Biome> createFabric(String path) {
        return TagKey.create(Registries.BIOME, new ResourceLocation("c", path));
    }

    private static TagKey<Biome> createForge(String path) {
        return TagKey.create(Registries.BIOME, new ResourceLocation("forge", path));
    }
}
