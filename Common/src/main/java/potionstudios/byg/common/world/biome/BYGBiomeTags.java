package potionstudios.byg.common.world.biome;

import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;

public class BYGBiomeTags {

    public static final TagKey<Biome> HAS_VILLAGE_SKYRIS = create("has_structure/village_skyris");
    public static final TagKey<Biome> HAS_VILLAGE_RUINS = create("has_structure/village_ruins");
    public static final TagKey<Biome> HAS_VILLAGE_TROPICAL = create("has_structure/village_tropical");
    public static final TagKey<Biome> HAS_VILLAGE_RED_ROCK = create("has_structure/village_red_rock");
    public static final TagKey<Biome> HAS_RED_ROCK_ARCH = create("has_structure/red_rock_arch");
    public static final TagKey<Biome> HAS_OVERGROWN_STONE_ARCH = create("has_structure/overgrown_stone_arch");
    public static final TagKey<Biome> HAS_STONE_ARCH = create("has_structure/stone_arch");

    public static final TagKey<Biome> HAS_PALM_TREES = create("has_feature/palm_trees");

    public static final TagKey<Biome> IS_BEACH = create("is_beach");
    public static final TagKey<Biome> IS_ICY = create("is_icy");
    public static final TagKey<Biome> IS_SNOWY = create("is_snowy");
    public static final TagKey<Biome> IS_SANDY = create("is_sandy");
    public static final TagKey<Biome> IS_DEEP_OCEAN = create("is_deep_ocean");
    public static final TagKey<Biome> IS_OCEAN = create("is_ocean");
    public static final TagKey<Biome> IS_SPOOKY = create("is_spooky");
    public static final TagKey<Biome> IS_SWAMP = create("is_swamp");
    public static final TagKey<Biome> IS_WASTELAND = create("is_wasteland");
    public static final TagKey<Biome> IS_DEAD = create("is_dead");
    public static final TagKey<Biome> IS_BADLANDS = create("is_badlands");

    private static TagKey<Biome> create(String id) {
        return TagKey.create(Registry.BIOME_REGISTRY, BYG.createLocation(id));
    }
}
