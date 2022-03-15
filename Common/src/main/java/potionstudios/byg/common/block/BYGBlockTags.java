package potionstudios.byg.common.block;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.BYG;

import java.util.ArrayList;
import java.util.List;

public class BYGBlockTags {
    private static final List<String> LOCATIONS = new ArrayList<>();
    public static final List<TagKey<Block>> PLANT_TAGS = new ArrayList<>();
    public static final List<TagKey<Block>> SAND_PLANT_TAGS = new ArrayList<>();

    public static final TagKey<Block> GROUND_PRICKLY_PEAR_CACTUS = createDesertPlantTag("ground_prickly_pear_cactus");
    public static final TagKey<Block> GROUND_MINI_CACTUS = createDesertPlantTag("ground_mini_cactus");
    public static final TagKey<Block> GROUND_GOLDEN_SPINED_CACTUS = createDesertPlantTag("ground_golden_spined_cactus");
    public static final TagKey<Block> GROUND_HORSEWEED = createPlantTag("ground_horseweed");
    public static final TagKey<Block> GROUND_WINTER_SUCCULENT = createPlantTag("ground_winter_succulent");
    public static final TagKey<Block> GROUND_ALPINE_BELLFLOWER = createPlantTag("ground_alpine_bellflower");
    public static final TagKey<Block> GROUND_ANGELICA = createPlantTag("ground_angelica");
    public static final TagKey<Block> GROUND_BEGONIA = createPlantTag("ground_begonia");
    public static final TagKey<Block> GROUND_BISTORT = createPlantTag("ground_bistort");
    public static final TagKey<Block> GROUND_BLUE_SAGE = createPlantTag("ground_blue_sage");
    public static final TagKey<Block> GROUND_CALIFORNIA_POPPY = createPlantTag("ground_california_poppy");
    public static final TagKey<Block> GROUND_CROCUS = createPlantTag("ground_crocus");
    public static final TagKey<Block> GROUND_BLACK_ROSE = createPlantTag("ground_black_rose");
    public static final TagKey<Block> GROUND_TALL_PRAIRIE_GRASS = createPlantTag("ground_tall_prairie_grass");
    public static final TagKey<Block> GROUND_TALL_ALLIUM = createPlantTag("ground_tall_allium");
    public static final TagKey<Block> GROUND_TALL_PINK_ALLIUM = createPlantTag("ground_tall_pink_allium");
    public static final TagKey<Block> GROUND_DELPHINIUM = createPlantTag("ground_delphinium");
    public static final TagKey<Block> GROUND_FIRECRACKER_FLOWER_BUSH = createPlantTag("ground_firecracker_flower_bush");
    public static final TagKey<Block> GROUND_FOXGLOVE = createPlantTag("ground_foxglove");
    public static final TagKey<Block> GROUND_GREEN_TULIP = createPlantTag("ground_green_tulip");
    public static final TagKey<Block> GROUND_GUZMANIA = createPlantTag("ground_guzmania");
    public static final TagKey<Block> GROUND_INCAN_LILY = createPlantTag("ground_incan_lily");
    public static final TagKey<Block> GROUND_IRIS = createPlantTag("ground_iris");
    public static final TagKey<Block> GROUND_JAPANESE_ORCHID = createPlantTag("ground_japanese_orchid");
    public static final TagKey<Block> GROUND_KOVAN_FLOWER = createPlantTag("ground_kovan_flower");
    public static final TagKey<Block> GROUND_LAZARUS_BELLFLOWER = createPlantTag("ground_lazarus_bellflower");
    public static final TagKey<Block> GROUND_LOLLIPOP_FLOWER = createPlantTag("ground_lollipop_flower");
    public static final TagKey<Block> GROUND_MAGENTA_TULIP = createPlantTag("ground_magenta_tulip");
    public static final TagKey<Block> GROUND_ORANGE_DAISY = createPlantTag("ground_orange_daisy");
    public static final TagKey<Block> GROUND_ORSIRIA_ROSE = createPlantTag("ground_osiria_rose");
    public static final TagKey<Block> GROUND_PEACH_LEATHER_FLOWER = createPlantTag("ground_peach_leather_flower");
    public static final TagKey<Block> GROUND_PINK_ALLIUM = createPlantTag("ground_pink_allium");
    public static final TagKey<Block> GROUND_PINK_ANEMONE = createPlantTag("ground_pink_anemone");
    public static final TagKey<Block> GROUND_PINK_DAFFODIL = createPlantTag("ground_pink_daffodil");
    public static final TagKey<Block> GROUND_PROTEA_FLOWER = createPlantTag("ground_protea_flower");
    public static final TagKey<Block> GROUND_PURPLE_SAGE = createPlantTag("ground_purple_sage");
    public static final TagKey<Block> GROUND_PURPLE_TULIP = createPlantTag("ground_purple_tulip");
    public static final TagKey<Block> GROUND_RICHEA = createPlantTag("ground_richea");
    public static final TagKey<Block> GROUND_ROSE = createPlantTag("ground_rose");
    public static final TagKey<Block> GROUND_SILVER_VASE_FLOWER = createPlantTag("ground_silver_vase_flower");
    public static final TagKey<Block> GROUND_TORCH_GINGER = createPlantTag("ground_torch_ginger");
    public static final TagKey<Block> GROUND_VIOLET_LEATHER_FLOWER = createPlantTag("ground_violet_leather_flower");
    public static final TagKey<Block> GROUND_WHITE_ANEMONE = createPlantTag("ground_white_anemone");
    public static final TagKey<Block> GROUND_WHITE_SAGE = createPlantTag("ground_white_sage");
    public static final TagKey<Block> GROUND_YELLOW_DAFFODIL = createPlantTag("ground_yellow_daffodil");
    public static final TagKey<Block> GROUND_YELLOW_TULIP = createPlantTag("ground_yellow_tulip");
    public static final TagKey<Block> GROUND_HYDRANGEA_BUSH = createPlantTag("ground_hydrangea_bush");

    public static final TagKey<Block> GROUND_ARAUCARIA_SAPLING = createPlantTag("ground_araucaria_sapling");
    public static final TagKey<Block> GROUND_ASPEN_SAPLING = createPlantTag("ground_aspen_sapling");
    public static final TagKey<Block> GROUND_BAOBAB_SAPLING = createPlantTag("ground_baobab_sapling");
    public static final TagKey<Block> GROUND_BLUE_ENCHANTED_SAPLING = createPlantTag("ground_blue_enchanted_sapling");
    public static final TagKey<Block> GROUND_BLUE_SPRUCE_SAPLING = createPlantTag("ground_blue_spruce_sapling");
    public static final TagKey<Block> GROUND_BROWN_BIRCH_SAPLING = createPlantTag("ground_brown_birch_sapling");
    public static final TagKey<Block> GROUND_BROWN_OAK_SAPLING = createPlantTag("ground_brown_oak_sapling");
    public static final TagKey<Block> GROUND_BROWN_ZELKOVA_SAPLING = createPlantTag("ground_brown_zelkova_sapling");
    public static final TagKey<Block> GROUND_CIKA_SAPLING = createPlantTag("ground_cika_sapling");
    public static final TagKey<Block> GROUND_CYPRESS_SAPLING = createPlantTag("ground_cypress_sapling");
    public static final TagKey<Block> GROUND_EBONY_SAPLING = createPlantTag("ground_ebony_sapling");
    public static final TagKey<Block> GROUND_FIR_SAPLING = createPlantTag("ground_fir_sapling");
    public static final TagKey<Block> GROUND_GREEN_ENCHANTED_SAPLING = createPlantTag("ground_green_enchanted_sapling");
    public static final TagKey<Block> GROUND_HOLLY_SAPLING = createPlantTag("ground_holly_sapling");
    public static final TagKey<Block> GROUND_FLOWERING_JACARANDA_BUSH = createPlantTag("ground_flowering_jacaranda_bush");
    public static final TagKey<Block> GROUND_FLOWERING_INDIGO_JACARANDA_BUSH = createPlantTag("ground_flowering_indigo_jacaranda_bush");
    public static final TagKey<Block> GROUND_JACARANDA_SAPLING = createPlantTag("ground_jacaranda_sapling");
    public static final TagKey<Block> GROUND_INDIGO_JACARANDA_SAPLING = createPlantTag("ground_indigo_jacaranda_sapling");
    public static final TagKey<Block> GROUND_JOSHUA_SAPLING = createPlantTag("ground_joshua_sapling");
    public static final TagKey<Block> GROUND_MAHOGANY_SAPLING = createPlantTag("ground_mahogany_sapling");
    public static final TagKey<Block> GROUND_MANGROVE_SAPLING = createPlantTag("ground_mangrove_sapling");
    public static final TagKey<Block> GROUND_MAPLE_SAPLING = createPlantTag("ground_maple_sapling");
    public static final TagKey<Block> GROUND_ORANGE_BIRCH_SAPLING = createPlantTag("ground_orange_birch_sapling");
    public static final TagKey<Block> GROUND_ORANGE_OAK_SAPLING = createPlantTag("ground_orange_oak_sapling");
    public static final TagKey<Block> GROUND_ORANGE_SPRUCE_SAPLING = createPlantTag("ground_orange_spruce_sapling");
    public static final TagKey<Block> GROUND_ORCHARD_SAPLING = createPlantTag("ground_orchard_sapling");
    public static final TagKey<Block> GROUND_PALO_VERDE_SAPLING = createPlantTag("ground_palo_verde_sapling");
    public static final TagKey<Block> GROUND_PINE_SAPLING = createPlantTag("ground_pine_sapling");
    public static final TagKey<Block> GROUND_PINK_CHERRY_SAPLING = createPlantTag("ground_pink_cherry_sapling");
    public static final TagKey<Block> GROUND_RAINBOW_EUCALYPTUS_SAPLING = createPlantTag("ground_rainbow_eucalyptus_sapling");
    public static final TagKey<Block> GROUND_RED_BIRCH_SAPLING = createPlantTag("ground_red_birch_sapling");
    public static final TagKey<Block> GROUND_RED_MAPLE_SAPLING = createPlantTag("ground_red_maple_sapling");
    public static final TagKey<Block> GROUND_RED_OAK_SAPLING = createPlantTag("ground_red_oak_sapling");
    public static final TagKey<Block> GROUND_RED_SPRUCE_SAPLING = createPlantTag("ground_red_spruce_sapling");
    public static final TagKey<Block> GROUND_REDWOOD_SAPLING = createPlantTag("ground_redwood_sapling");
    public static final TagKey<Block> GROUND_SILVER_MAPLE_SAPLING = createPlantTag("ground_silver_maple_sapling");
    public static final TagKey<Block> GROUND_SKYRIS_SAPLING = createPlantTag("ground_skyris_sapling");
    public static final TagKey<Block> GROUND_WHITE_CHERRY_SAPLING = createPlantTag("ground_white_cherry_sapling");
    public static final TagKey<Block> GROUND_WILLOW_SAPLING = createPlantTag("ground_willow_sapling");
    public static final TagKey<Block> GROUND_WITCH_HAZEL_SAPLING = createPlantTag("ground_witch_hazel_sapling");
    public static final TagKey<Block> GROUND_YELLOW_BIRCH_SAPLING = createPlantTag("ground_yellow_birch_sapling");
    public static final TagKey<Block> GROUND_YELLOW_SPRUCE_SAPLING = createPlantTag("ground_yellow_spruce_sapling");
    public static final TagKey<Block> GROUND_ZELKOVA_SAPLING = createPlantTag("ground_zelkova_sapling");
    public static final TagKey<Block> GROUND_PALM_SAPLING = createTag("ground_palm_sapling");
    public static final TagKey<Block> GROUND_LAMENT_SAPLING = createPlantTag("ground_lament_sapling");
    public static final TagKey<Block> GROUND_WITHERING_OAK_SAPLING = createPlantTag("ground_withering_oak_sapling");
    public static final TagKey<Block> GROUND_ETHER_SAPLING = createPlantTag("ground_ether_sapling");
    public static final TagKey<Block> GROUND_NIGHTSHADE_SAPLING = createPlantTag("ground_nightshade_sapling");

    public static final TagKey<Block> FARMLAND = createTag("farmland");
    public static final TagKey<Block> SPREADS_TO_END_STONE = createTag("spreads_to_end_stone");
    public static final TagKey<Block> SPREADS_TO_NETHERRACK = createTag("spreads_to_netherrack");


    private static TagKey<Block> createPlantTag(String location) {
        TagKey<Block> blockTag = createTag(location);
        PLANT_TAGS.add(blockTag);
        return blockTag;
    }

    private static TagKey<Block> createDesertPlantTag(String location) {
        TagKey<Block> blockTag = createTag(location);
        SAND_PLANT_TAGS.add(blockTag);
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
        return TagKey.create(Registry.BLOCK_REGISTRY, location);
    }
}
