package potionstudios.byg.common.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.BYG;
import potionstudios.byg.common.BYGTags;

import java.util.ArrayList;
import java.util.List;

public class BYGBlockTags {
    private static final List<String> LOCATIONS = new ArrayList<>();
    public static final List<TagKey<Block>> PLANT_TAGS = new ArrayList<>();
    public static final List<TagKey<Block>> MUSHROOM_TAGS = new ArrayList<>();
    public static final List<TagKey<Block>> SAND_PLANT_TAGS = new ArrayList<>();
    public static final List<TagKey<Block>> NETHER_PLANT_TAGS = new ArrayList<>();
    public static final List<TagKey<Block>> END_PLANT_TAGS = new ArrayList<>();

    public static final TagKey<Block> GROUND_WEEPING_MILK_CAP = createMushroomTag("may_place_on/weeping_milk_cap");
    public static final TagKey<Block> GROUND_WOOD_BLEWIT = createMushroomTag("may_place_on/wood_blewit");
    public static final TagKey<Block> GROUND_GREEN_MUSHROOM = createMushroomTag("may_place_on/green_mushroom");
    public static final TagKey<Block> GROUND_SYTHIAN_FUNGUS = createNetherPlantTag("may_place_on/sythian_fungus");
    public static final TagKey<Block> GROUND_SOUL_SHROOM = createNetherPlantTag("may_place_on/soul_shroom");
    public static final TagKey<Block> GROUND_DEATH_CAP = createNetherPlantTag("may_place_on/death_cap");
    public static final TagKey<Block> GROUND_BULBIS_ODDITY = createEndPlantTag("may_place_on/bulbis_oddity");
    public static final TagKey<Block> GROUND_PURPLE_BULBIS_ODDITY = createEndPlantTag("may_place_on/purple_bulbis_oddity");
    public static final TagKey<Block> GROUND_IMPARIUS_MUSHROOM = createEndPlantTag("may_place_on/imparius_mushroom");
    public static final TagKey<Block> GROUND_FUNGAL_IMPARIUS = createEndPlantTag("may_place_on/fungal_imparius");
    public static final TagKey<Block> GROUND_BEACH_GRASS = createDesertPlantTag("may_place_on/beach_grass");
    public static final TagKey<Block> GROUND_TALL_BEACH_GRASS = createDesertPlantTag("may_place_on/tall_beach_grass");
    public static final TagKey<Block> GROUND_AMARANTH = createPlantTag("may_place_on/amaranth");
    public static final TagKey<Block> GROUND_TALL_PRAIRIE_GRASS = createPlantTag("may_place_on/tall_prairie_grass");
    public static final TagKey<Block> GROUND_PRAIRIE_GRASS = createPlantTag("may_place_on/prairie_grass");
    public static final TagKey<Block> GROUND_CYAN_AMARANTH = createPlantTag("may_place_on/cyan_amaranth");
    public static final TagKey<Block> GROUND_MAGENTA_AMARANTH = createPlantTag("may_place_on/magenta_amaranth");
    public static final TagKey<Block> GROUND_ORANGE_AMARANTH = createPlantTag("may_place_on/orange_amaranth");
    public static final TagKey<Block> GROUND_PURPLE_AMARANTH = createPlantTag("may_place_on/purple_amaranth");
    public static final TagKey<Block> GROUND_ALLIUM_FLOWER_BUSH = createPlantTag("may_place_on/allium_flower_bush");
    public static final TagKey<Block> GROUND_FAIRY_SLIPPER = createPlantTag("may_place_on/fairy_slipper");
    public static final TagKey<Block> GROUND_CLOVER_PATCH = createPlantTag("may_place_on/clover_patch");
    public static final TagKey<Block> GROUND_FLOWER_PATCH = createPlantTag("may_place_on/flower_patch");
    public static final TagKey<Block> GROUND_PRICKLY_PEAR_CACTUS = createDesertPlantTag("may_place_on/prickly_pear_cactus");
    public static final TagKey<Block> GROUND_MINI_CACTUS = createDesertPlantTag("may_place_on/mini_cactus");
    public static final TagKey<Block> GROUND_GOLDEN_SPINED_CACTUS = createDesertPlantTag("may_place_on/golden_spined_cactus");
    public static final TagKey<Block> GROUND_HORSEWEED = createPlantTag("may_place_on/horseweed");
    public static final TagKey<Block> GROUND_WINTER_SUCCULENT = createPlantTag("may_place_on/winter_succulent");
    public static final TagKey<Block> GROUND_ALPINE_BELLFLOWER = createPlantTag("may_place_on/alpine_bellflower");
    public static final TagKey<Block> GROUND_ANGELICA = createPlantTag("may_place_on/angelica");
    public static final TagKey<Block> GROUND_BEGONIA = createPlantTag("may_place_on/begonia");
    public static final TagKey<Block> GROUND_BISTORT = createPlantTag("may_place_on/bistort");
    public static final TagKey<Block> GROUND_BLUE_ROSE_BUSH = createPlantTag("may_place_on/blue_rose_bush");
    public static final TagKey<Block> GROUND_BLUE_SAGE = createPlantTag("may_place_on/blue_sage");
    public static final TagKey<Block> GROUND_CALIFORNIA_POPPY = createPlantTag("may_place_on/california_poppy");
    public static final TagKey<Block> GROUND_CROCUS = createPlantTag("may_place_on/crocus");
    public static final TagKey<Block> GROUND_BLACK_ROSE = createPlantTag("may_place_on/black_rose");
    public static final TagKey<Block> GROUND_TALL_ALLIUM = createPlantTag("may_place_on/tall_allium");
    public static final TagKey<Block> GROUND_TALL_PINK_ALLIUM = createPlantTag("may_place_on/tall_pink_allium");
    public static final TagKey<Block> GROUND_DELPHINIUM = createPlantTag("may_place_on/delphinium");
    public static final TagKey<Block> GROUND_FIRECRACKER_FLOWER_BUSH = createPlantTag("may_place_on/firecracker_flower_bush");
    public static final TagKey<Block> GROUND_FOXGLOVE = createPlantTag("may_place_on/foxglove");
    public static final TagKey<Block> GROUND_GREEN_TULIP = createPlantTag("may_place_on/green_tulip");
    public static final TagKey<Block> GROUND_GUZMANIA = createPlantTag("may_place_on/guzmania");
    public static final TagKey<Block> GROUND_INCAN_LILY = createPlantTag("may_place_on/incan_lily");
    public static final TagKey<Block> GROUND_IRIS = createPlantTag("may_place_on/iris");
    public static final TagKey<Block> GROUND_JAPANESE_ORCHID = createPlantTag("may_place_on/japanese_orchid");
    public static final TagKey<Block> GROUND_KOVAN_FLOWER = createPlantTag("may_place_on/kovan_flower");
    public static final TagKey<Block> GROUND_LAZARUS_BELLFLOWER = createPlantTag("may_place_on/lazarus_bellflower");
    public static final TagKey<Block> GROUND_LOLLIPOP_FLOWER = createPlantTag("may_place_on/lollipop_flower");
    public static final TagKey<Block> GROUND_MAGENTA_TULIP = createPlantTag("may_place_on/magenta_tulip");
    public static final TagKey<Block> GROUND_ORANGE_DAISY = createPlantTag("may_place_on/orange_daisy");
    public static final TagKey<Block> GROUND_ORSIRIA_ROSE = createPlantTag("may_place_on/osiria_rose");
    public static final TagKey<Block> GROUND_PEACH_LEATHER_FLOWER = createPlantTag("may_place_on/peach_leather_flower");
    public static final TagKey<Block> GROUND_PINK_ALLIUM = createPlantTag("may_place_on/pink_allium");
    public static final TagKey<Block> GROUND_PINK_ALLIUM_BUSH = createPlantTag("may_place_on/pink_allium_bush");
    public static final TagKey<Block> GROUND_PINK_ANEMONE = createPlantTag("may_place_on/pink_anemone");
    public static final TagKey<Block> GROUND_PINK_DAFFODIL = createPlantTag("may_place_on/pink_daffodil");
    public static final TagKey<Block> GROUND_PROTEA_FLOWER = createPlantTag("may_place_on/protea_flower");
    public static final TagKey<Block> GROUND_PURPLE_SAGE = createPlantTag("may_place_on/purple_sage");
    public static final TagKey<Block> GROUND_PURPLE_TULIP = createPlantTag("may_place_on/purple_tulip");
    public static final TagKey<Block> GROUND_RICHEA = createPlantTag("may_place_on/richea");
    public static final TagKey<Block> GROUND_ROSE = createPlantTag("may_place_on/rose");
    public static final TagKey<Block> GROUND_SILVER_VASE_FLOWER = createPlantTag("may_place_on/silver_vase_flower");
    public static final TagKey<Block> GROUND_VIOLET_LEATHER_FLOWER = createPlantTag("may_place_on/violet_leather_flower");
    public static final TagKey<Block> GROUND_WHITE_ANEMONE = createPlantTag("may_place_on/white_anemone");
    public static final TagKey<Block> GROUND_WHITE_SAGE = createPlantTag("may_place_on/white_sage");
    public static final TagKey<Block> GROUND_YELLOW_DAFFODIL = createPlantTag("may_place_on/yellow_daffodil");
    public static final TagKey<Block> GROUND_YELLOW_TULIP = createPlantTag("may_place_on/yellow_tulip");
    public static final TagKey<Block> GROUND_HYDRANGEA_BUSH = createPlantTag("may_place_on/hydrangea_bush");

    public static final TagKey<Block> GROUND_ARAUCARIA_SAPLING = createPlantTag("may_place_on/araucaria_sapling");
    public static final TagKey<Block> GROUND_ASPEN_SAPLING = createPlantTag("may_place_on/aspen_sapling");
    public static final TagKey<Block> GROUND_BAOBAB_SAPLING = createPlantTag("may_place_on/baobab_sapling");
    public static final TagKey<Block> GROUND_BLUE_ENCHANTED_SAPLING = createPlantTag("may_place_on/blue_enchanted_sapling");
    public static final TagKey<Block> GROUND_BLUE_SPRUCE_SAPLING = createPlantTag("may_place_on/blue_spruce_sapling");
    public static final TagKey<Block> GROUND_BROWN_BIRCH_SAPLING = createPlantTag("may_place_on/brown_birch_sapling");
    public static final TagKey<Block> GROUND_BROWN_OAK_SAPLING = createPlantTag("may_place_on/brown_oak_sapling");
    public static final TagKey<Block> GROUND_BROWN_ZELKOVA_SAPLING = createPlantTag("may_place_on/brown_zelkova_sapling");
    public static final TagKey<Block> GROUND_CIKA_SAPLING = createPlantTag("may_place_on/cika_sapling");
    public static final TagKey<Block> GROUND_CYPRESS_SAPLING = createPlantTag("may_place_on/cypress_sapling");
    public static final TagKey<Block> GROUND_EBONY_SAPLING = createPlantTag("may_place_on/ebony_sapling");
    public static final TagKey<Block> GROUND_FIR_SAPLING = createPlantTag("may_place_on/fir_sapling");
    public static final TagKey<Block> GROUND_GREEN_ENCHANTED_SAPLING = createPlantTag("may_place_on/green_enchanted_sapling");
    public static final TagKey<Block> GROUND_HOLLY_SAPLING = createPlantTag("may_place_on/holly_sapling");
    public static final TagKey<Block> GROUND_FLOWERING_JACARANDA_BUSH = createPlantTag("may_place_on/flowering_jacaranda_bush");
    public static final TagKey<Block> GROUND_FLOWERING_INDIGO_JACARANDA_BUSH = createPlantTag("may_place_on/flowering_indigo_jacaranda_bush");
    public static final TagKey<Block> GROUND_JACARANDA_SAPLING = createPlantTag("may_place_on/jacaranda_sapling");
    public static final TagKey<Block> GROUND_INDIGO_JACARANDA_SAPLING = createPlantTag("may_place_on/indigo_jacaranda_sapling");
    public static final TagKey<Block> GROUND_JOSHUA_SAPLING = createPlantTag("may_place_on/joshua_sapling");
    public static final TagKey<Block> GROUND_MAHOGANY_SAPLING = createPlantTag("may_place_on/mahogany_sapling");
    public static final TagKey<Block> GROUND_WHITE_MANGROVE_SAPLING = createPlantTag("may_place_on/white_mangrove_sapling");
    public static final TagKey<Block> GROUND_MAPLE_SAPLING = createPlantTag("may_place_on/maple_sapling");
    public static final TagKey<Block> GROUND_ORANGE_BIRCH_SAPLING = createPlantTag("may_place_on/orange_birch_sapling");
    public static final TagKey<Block> GROUND_ORANGE_OAK_SAPLING = createPlantTag("may_place_on/orange_oak_sapling");
    public static final TagKey<Block> GROUND_ORANGE_SPRUCE_SAPLING = createPlantTag("may_place_on/orange_spruce_sapling");
    public static final TagKey<Block> GROUND_ORCHARD_SAPLING = createPlantTag("may_place_on/orchard_sapling");
    public static final TagKey<Block> GROUND_PALO_VERDE_SAPLING = createPlantTag("may_place_on/palo_verde_sapling");
    public static final TagKey<Block> GROUND_PINE_SAPLING = createPlantTag("may_place_on/pine_sapling");
    public static final TagKey<Block> GROUND_RAINBOW_EUCALYPTUS_SAPLING = createPlantTag("may_place_on/rainbow_eucalyptus_sapling");
    public static final TagKey<Block> GROUND_RED_BIRCH_SAPLING = createPlantTag("may_place_on/red_birch_sapling");
    public static final TagKey<Block> GROUND_RED_MAPLE_SAPLING = createPlantTag("may_place_on/red_maple_sapling");
    public static final TagKey<Block> GROUND_RED_OAK_SAPLING = createPlantTag("may_place_on/red_oak_sapling");
    public static final TagKey<Block> GROUND_RED_SPRUCE_SAPLING = createPlantTag("may_place_on/red_spruce_sapling");
    public static final TagKey<Block> GROUND_REDWOOD_SAPLING = createPlantTag("may_place_on/redwood_sapling");
    public static final TagKey<Block> GROUND_SILVER_MAPLE_SAPLING = createPlantTag("may_place_on/silver_maple_sapling");
    public static final TagKey<Block> GROUND_SKYRIS_SAPLING = createPlantTag("may_place_on/skyris_sapling");
    public static final TagKey<Block> GROUND_WHITE_CHERRY_SAPLING = createPlantTag("may_place_on/white_cherry_sapling");
    public static final TagKey<Block> GROUND_WILLOW_SAPLING = createPlantTag("may_place_on/willow_sapling");
    public static final TagKey<Block> GROUND_WITCH_HAZEL_SAPLING = createPlantTag("may_place_on/witch_hazel_sapling");
    public static final TagKey<Block> GROUND_YELLOW_BIRCH_SAPLING = createPlantTag("may_place_on/yellow_birch_sapling");
    public static final TagKey<Block> GROUND_YELLOW_SPRUCE_SAPLING = createPlantTag("may_place_on/yellow_spruce_sapling");
    public static final TagKey<Block> GROUND_ZELKOVA_SAPLING = createPlantTag("may_place_on/zelkova_sapling");
    public static final TagKey<Block> GROUND_PALM_SAPLING = createTag("may_place_on/palm_sapling");
    public static final TagKey<Block> GROUND_ETHER_SAPLING = createPlantTag("may_place_on/ether_sapling");
    public static final TagKey<Block> GROUND_NIGHTSHADE_SAPLING = createEndPlantTag("may_place_on/nightshade_sapling");

    public static final TagKey<Block> FARMLAND = createTag("farmland");
    public static final TagKey<Block> SPREADS_TO_END_STONE = createTag("spreads_to_end_stone");
    public static final TagKey<Block> END_STONE = createTag("end_stone");
    public static final TagKey<Block> SPREADS_TO_NETHERRACK = createTag("spreads_to_netherrack");
    public static final TagKey<Block> SCAFFOLDING = BYGTags.SCAFFOLDING.all(BYGTags.RegistryType.BLOCKS);
    public static final TagKey<Block> MUSHROOMS = createTag("mushrooms");
    public static final TagKey<Block> WOODEN_FENCE_GATES = createTag("fence_gates/wooden");

    public static final TagKey<Block> SYTHIAN_STALK_PLANTABLE_ON = createTag("sythian_stalk_plantable_on");

    public static final TagKey<Block> LUSH = createTag("lush");
    public static final TagKey<Block> SLABS = createTag("slabs");

    private static TagKey<Block> createPlantTag(String location) {
        TagKey<Block> blockTag = createTag(location);
        PLANT_TAGS.add(blockTag);
        return blockTag;
    }

    private static TagKey<Block> createMushroomTag(String location) {
        TagKey<Block> blockTag = createTag(location);
        MUSHROOM_TAGS.add(blockTag);
        return blockTag;
    }

    private static TagKey<Block> createDesertPlantTag(String location) {
        TagKey<Block> blockTag = createTag(location);
        SAND_PLANT_TAGS.add(blockTag);
        return blockTag;
    }

    private static TagKey<Block> createNetherPlantTag(String location) {
        TagKey<Block> blockTag = createTag(location);
        NETHER_PLANT_TAGS.add(blockTag);
        return blockTag;
    }

    private static TagKey<Block> createEndPlantTag(String location) {
        TagKey<Block> blockTag = createTag(location);
        END_PLANT_TAGS.add(blockTag);
        return blockTag;
    }

    private static TagKey<Block> createTag(String location) {
        if (!LOCATIONS.contains(location)) {
            LOCATIONS.add(location);
            return createTag(BYG.createLocation(location));
        } else {
            throw new RuntimeException("Duplicate key: " + location);
        }
    }

    private static TagKey<Block> createTag(ResourceLocation location) {
        return TagKey.create(Registries.BLOCK, location);
    }
}
