package potionstudios.byg.common.world.biome;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModLoaderBiomeTags {

    public static class Forge {
        public static final TagKey<Biome> IS_HOT = create("is_hot");
        public static final TagKey<Biome> IS_HOT_OVERWORLD = create("is_hot/overworld");
        public static final TagKey<Biome> IS_HOT_NETHER = create("is_hot/nether");
        public static final TagKey<Biome> IS_HOT_END = create("is_hot/end");

        public static final TagKey<Biome> IS_COLD = create("is_cold");
        public static final TagKey<Biome> IS_COLD_OVERWORLD = create("is_cold/overworld");
        public static final TagKey<Biome> IS_COLD_NETHER = create("is_cold/nether");
        public static final TagKey<Biome> IS_COLD_END = create("is_cold/end");

        public static final TagKey<Biome> IS_SPARSE = create("is_sparse");
        public static final TagKey<Biome> IS_SPARSE_OVERWORLD = create("is_sparse/overworld");
        public static final TagKey<Biome> IS_SPARSE_NETHER = create("is_sparse/nether");
        public static final TagKey<Biome> IS_SPARSE_END = create("is_sparse/end");
        public static final TagKey<Biome> IS_DENSE = create("is_dense");
        public static final TagKey<Biome> IS_DENSE_OVERWORLD = create("is_dense/overworld");
        public static final TagKey<Biome> IS_DENSE_NETHER = create("is_dense/nether");
        public static final TagKey<Biome> IS_DENSE_END = create("is_dense/end");

        public static final TagKey<Biome> IS_WET = create("is_wet");
        public static final TagKey<Biome> IS_WET_OVERWORLD = create("is_wet/overworld");
        public static final TagKey<Biome> IS_WET_NETHER = create("is_wet/nether");
        public static final TagKey<Biome> IS_WET_END = create("is_wet/end");
        public static final TagKey<Biome> IS_DRY = create("is_dry");
        public static final TagKey<Biome> IS_DRY_OVERWORLD = create("is_dry/overworld");
        public static final TagKey<Biome> IS_DRY_NETHER = create("is_dry/nether");
        public static final TagKey<Biome> IS_DRY_END = create("is_dry/end");

        public static final TagKey<Biome> IS_SAVANNA = create("is_savanna");
        public static final TagKey<Biome> IS_CONIFEROUS = create("is_coniferous");

        public static final TagKey<Biome> IS_SPOOKY = create("is_spooky");
        public static final TagKey<Biome> IS_DEAD = create("is_dead");
        public static final TagKey<Biome> IS_LUSH = create("is_lush");
        public static final TagKey<Biome> IS_MUSHROOM = create("is_mushroom");
        public static final TagKey<Biome> IS_MAGICAL = create("is_magical");
        public static final TagKey<Biome> IS_RARE = create("is_rare");
        public static final TagKey<Biome> IS_PLATEAU = create("is_plateau");
        public static final TagKey<Biome> IS_MODIFIED = create("is_modified");

        public static final TagKey<Biome> IS_WATER = create("is_water");

        public static final TagKey<Biome> IS_PLAINS = create("is_plains");
        public static final TagKey<Biome> IS_SWAMP = create("is_swamp");
        public static final TagKey<Biome> IS_SANDY = create("is_sandy");
        public static final TagKey<Biome> IS_SNOWY = create("is_snowy");
        public static final TagKey<Biome> IS_WASTELAND = create("is_wasteland");
        public static final TagKey<Biome> IS_BEACH = create("is_beach");
        public static final TagKey<Biome> IS_VOID = create("is_void");
        public static final TagKey<Biome> IS_UNDERGROUND = create("is_underground");

        public static final TagKey<Biome> IS_PEAK = create("is_peak");
        public static final TagKey<Biome> IS_SLOPE = create("is_slope");

        public static final TagKey<Biome> IS_OVERWORLD = create("is_overworld");
        public static final TagKey<Biome> IS_END = create("is_end");

        private static TagKey<Biome> create(String id) {
            return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("forge", id));
        }
    }
    public static class Fabric {

        public static final TagKey<Biome> IN_OVERWORLD = create("in_overworld");

        public static final TagKey<Biome> IN_THE_END = create("in_the_end");

        public static final TagKey<Biome> IN_NETHER = create("in_nether");
        public static final TagKey<Biome> TAIGA = create("taiga");
        public static final TagKey<Biome> EXTREME_HILLS = create("extreme_hills");
        public static final TagKey<Biome> JUNGLE = create("jungle");
        public static final TagKey<Biome> MESA = create("mesa");

        public static final TagKey<Biome> PLAINS = create("plains");
        public static final TagKey<Biome> SAVANNA = create("savanna");

        public static final TagKey<Biome> ICY = create("icy");

        public static final TagKey<Biome> BEACH = create("beach");

        public static final TagKey<Biome> FOREST = create("forest");
        public static final TagKey<Biome> OCEAN = create("ocean");
        public static final TagKey<Biome> DESERT = create("desert");
        public static final TagKey<Biome> RIVER = create("river");
        public static final TagKey<Biome> SWAMP = create("swamp");
        public static final TagKey<Biome> MUSHROOM = create("mushroom");
        public static final TagKey<Biome> UNDERGROUND = create("underground");
        public static final TagKey<Biome> MOUNTAIN = create("mountain");

        public static final TagKey<Biome> CLIMATE_HOT = create("climate_hot");
        public static final TagKey<Biome> CLIMATE_TEMPERATE = create("climate_temperate");
        public static final TagKey<Biome> CLIMATE_COLD = create("climate_cold");
        public static final TagKey<Biome> CLIMATE_WET = create("climate_wet");
        public static final TagKey<Biome> CLIMATE_DRY = create("climate_dry");
        public static final TagKey<Biome> VEGETATION_SPARSE = create("vegetation_sparse");
        public static final TagKey<Biome> VEGETATION_DENSE = create("vegetation_dense");
        public static final TagKey<Biome> TREE_CONIFEROUS = create("tree_coniferous");
        public static final TagKey<Biome> TREE_SAVANNA = create("tree_savanna");
        public static final TagKey<Biome> TREE_JUNGLE = create("tree_jungle");
        public static final TagKey<Biome> TREE_DECIDUOUS = create("tree_deciduous");
        public static final TagKey<Biome> VOID = create("void");
        public static final TagKey<Biome> MOUNTAIN_PEAK = create("mountain_peak");
        public static final TagKey<Biome> MOUNTAIN_SLOPE = create("mountain_slope");

        public static final TagKey<Biome> AQUATIC = create("aquatic");
        public static final TagKey<Biome> WASTELAND = create("wasteland");
        public static final TagKey<Biome> DEAD = create("dead");
        public static final TagKey<Biome> FLORAL = create("floral");
        public static final TagKey<Biome> SNOWY = create("snowy");
        public static final TagKey<Biome> BADLANDS = create("badlands");
        public static final TagKey<Biome> CAVES = create("caves");
        public static final TagKey<Biome> END_ISLANDS = create("end_islands");
        public static final TagKey<Biome> NETHER_FORESTS = create("nether_forests");
        public static final TagKey<Biome> SNOWY_PLAINS = create("snowy_plains");
        public static final TagKey<Biome> STONY_SHORES = create("stony_shores");
        public static final TagKey<Biome> FLOWER_FORESTS = create("flower_forests");
        public static final TagKey<Biome> DEEP_OCEAN = create("deep_ocean");
        public static final TagKey<Biome> SHALLOW_OCEAN = create("shallow_ocean");

        private static TagKey<Biome> create(String id) {
            return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("c", id));
        }
    }


}
