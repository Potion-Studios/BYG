package corgiaoc.byg.core;

import corgiaoc.byg.BYG;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class BYGBlockTags {
    private static final List<String> LOCATIONS = new ArrayList<>();
    public static final List<ITag.INamedTag<Block>> PLANT_TAGS = new ArrayList<>();
    public static final List<ITag.INamedTag<Block>> DESERT_PLANT_TAGS = new ArrayList<>();

    public static final ITag.INamedTag<Block> GROUND_PRICKLY_PEAR_CACTUS = createDesertPlantTag("ground_prickly_pear_cactus");
    public static final ITag.INamedTag<Block> GROUND_MINI_CACTUS = createDesertPlantTag("ground_mini_cactus");
    public static final ITag.INamedTag<Block> GROUND_GOLDEN_SPINED_CACTUS = createDesertPlantTag("ground_golden_spined_cactus");
    public static final ITag.INamedTag<Block> GROUND_HORSEWEED = createPlantTag("ground_horseweed");
    public static final ITag.INamedTag<Block> GROUND_WINTER_SUCCULENT = createPlantTag("ground_winter_succulent");
    public static final ITag.INamedTag<Block> GROUND_ALPINE_BELLFLOWER = createPlantTag("ground_alpine_bellflower");
    public static final ITag.INamedTag<Block> GROUND_ANGELICA = createPlantTag("ground_angelica");
    public static final ITag.INamedTag<Block> GROUND_AZALEA = createPlantTag("ground_azalea");
    public static final ITag.INamedTag<Block> GROUND_BEGONIA = createPlantTag("ground_begonia");
    public static final ITag.INamedTag<Block> GROUND_BISTORT = createPlantTag("ground_bistort");
    public static final ITag.INamedTag<Block> GROUND_BLUE_SAGE = createPlantTag("ground_blue_sage");
    public static final ITag.INamedTag<Block> GROUND_CALIFORNIA_POPPY = createPlantTag("ground_california_poppy");
    public static final ITag.INamedTag<Block> GROUND_CROCUS = createPlantTag("ground_crocus");
    public static final ITag.INamedTag<Block> GROUND_BLACK_ROSE = createPlantTag("ground_black_rose");
    public static final ITag.INamedTag<Block> GROUND_TALL_PRAIRIE_GRASS = createPlantTag("ground_tall_prairie_grass");
    public static final ITag.INamedTag<Block> GROUND_TALL_ALLIUM = createPlantTag("ground_tall_allium");
    public static final ITag.INamedTag<Block> GROUND_TALL_PINK_ALLIUM = createPlantTag("ground_tall_pink_allium");
    public static final ITag.INamedTag<Block> GROUND_DELPHINIUM = createPlantTag("ground_delphinium");
    public static final ITag.INamedTag<Block> GROUND_FIRECRACKER_FLOWER_BUSH = createPlantTag("ground_firecracker_flower_bush");
    public static final ITag.INamedTag<Block> GROUND_FOXGLOVE = createPlantTag("ground_foxglove");
    public static final ITag.INamedTag<Block> GROUND_GREEN_TULIP = createPlantTag("ground_green_tulip");
    public static final ITag.INamedTag<Block> GROUND_GUZMANIA = createPlantTag("ground_guzmania");
    public static final ITag.INamedTag<Block> GROUND_INCAN_LILY = createPlantTag("ground_incan_lily");
    public static final ITag.INamedTag<Block> GROUND_IRIS = createPlantTag("ground_iris");
    public static final ITag.INamedTag<Block> GROUND_JAPANESE_ORCHID = createPlantTag("ground_japanese_orchid");
    public static final ITag.INamedTag<Block> GROUND_KOVAN_FLOWER = createPlantTag("ground_kovan_flower");
    public static final ITag.INamedTag<Block> GROUND_LAZARUS_BELLFLOWER = createPlantTag("ground_lazarus_bellflower");
    public static final ITag.INamedTag<Block> GROUND_LOLIPOP_FLOWER = createPlantTag("ground_lolipop_flower");
    public static final ITag.INamedTag<Block> GROUND_MAGENTA_TULIP = createPlantTag("ground_magenta_tulip");
    public static final ITag.INamedTag<Block> GROUND_ORANGE_DAISY = createPlantTag("ground_orange_daisy");
    public static final ITag.INamedTag<Block> GROUND_ORSIRIA_ROSE = createPlantTag("ground_osiria_rose");
    public static final ITag.INamedTag<Block> GROUND_PEACH_LEATHER_FLOWER = createPlantTag("ground_peach_leather_flower");
    public static final ITag.INamedTag<Block> GROUND_PINK_ALLIUM = createPlantTag("ground_pink_allium");
    public static final ITag.INamedTag<Block> GROUND_PINK_ANEMONE = createPlantTag("ground_pink_anemone");
    public static final ITag.INamedTag<Block> GROUND_PINK_DAFFODIL = createPlantTag("ground_pink_daffodil");
    public static final ITag.INamedTag<Block> GROUND_PINK_ORCHID = createPlantTag("ground_pink_orchid");
    public static final ITag.INamedTag<Block> GROUND_PROTEA_FLOWER = createPlantTag("ground_protea_flower");
    public static final ITag.INamedTag<Block> GROUND_PURPLE_ORCHID = createPlantTag("ground_purple_orchid");
    public static final ITag.INamedTag<Block> GROUND_PURPLE_SAGE = createPlantTag("ground_purple_sage");
    public static final ITag.INamedTag<Block> GROUND_PURPLE_TULIP = createPlantTag("ground_purple_tulip");
    public static final ITag.INamedTag<Block> GROUND_RED_CORNFLOWER = createPlantTag("ground_red_cornflower");
    public static final ITag.INamedTag<Block> GROUND_RED_ORCHID = createPlantTag("ground_red_orchid");
    public static final ITag.INamedTag<Block> GROUND_RICHEA = createPlantTag("ground_richea");
    public static final ITag.INamedTag<Block> GROUND_ROSE = createPlantTag("ground_rose");
    public static final ITag.INamedTag<Block> GROUND_SILVER_VASE_FLOWER = createPlantTag("ground_silver_vase_flower");
    public static final ITag.INamedTag<Block> GROUND_TORCH_GINGER = createPlantTag("ground_torch_ginger");
    public static final ITag.INamedTag<Block> GROUND_VIOLET_LEATHER_FLOWER = createPlantTag("ground_violet_leather_flower");
    public static final ITag.INamedTag<Block> GROUND_WHITE_ANEMONE = createPlantTag("ground_white_anemone");
    public static final ITag.INamedTag<Block> GROUND_WHITE_SAGE = createPlantTag("ground_white_sage");
    public static final ITag.INamedTag<Block> GROUND_YELLOW_DAFFODIL = createPlantTag("ground_yellow_daffodil");
    public static final ITag.INamedTag<Block> GROUND_YELLOW_TULIP = createPlantTag("ground_yellow_tulip");



    private static ITag.INamedTag<Block> createPlantTag(String location) {
        ITag.INamedTag<Block> blockTag = createTag(location);
        PLANT_TAGS.add(blockTag);
        return blockTag;
    }

    private static ITag.INamedTag<Block> createDesertPlantTag(String location) {
        ITag.INamedTag<Block> blockTag = createTag(location);
        PLANT_TAGS.add(blockTag);
        return blockTag;
    }

    private static ITag.INamedTag<Block> createTag(String location) {
        if (!LOCATIONS.contains(location)) {
            LOCATIONS.add(location);
            return createTag(new ResourceLocation(BYG.MOD_ID, location));
        } else {
            throw new RuntimeException("Duplicate key: " + location);
        }
    }

    private static ITag.INamedTag<Block> createTag(ResourceLocation location) {
        return BlockTags.createOptional(location);
    }
}
