package potionstudios.byg.client.textures.renders;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class BYGCutoutRenders {
    public static void renderCutOuts(Consumer<Map<Block, RenderType>> mapConsumer) {
        BYG.LOGGER.debug("BYG: Rendering Texture Cutouts...");
        Map<Block, RenderType> map = new HashMap<>();
        //Plants

        map.put(BYGBlocks.WITCH_HAZEL_BLOSSOM, RenderType.cutoutMipped());
        map.put(BYGBlocks.WITCH_HAZEL_BRANCH, RenderType.cutoutMipped());
        map.put(BYGBlocks.ALOE_VERA, RenderType.cutoutMipped());
        map.put(BYGBlocks.BLOOMING_ALOE_VERA, RenderType.cutoutMipped());
        map.put(BYGBlocks.HORSEWEED, RenderType.cutoutMipped());
        map.put(BYGBlocks.BLUE_SAGE, RenderType.cutoutMipped());
        map.put(BYGBlocks.MINI_CACTUS, RenderType.cutoutMipped());
        map.put(BYGBlocks.PRICKLY_PEAR_CACTUS, RenderType.cutoutMipped());
        map.put(BYGBlocks.WINTER_SUCCULENT, RenderType.cutoutMipped());
        map.put(BYGBlocks.GLOWSTONE_LANTERN, RenderType.cutoutMipped());
        map.put(BYGBlocks.NETHER_BRISTLE, RenderType.cutoutMipped());
        map.put(BYGBlocks.WEEPING_ROOTS_PLANT, RenderType.cutoutMipped());
        map.put(BYGBlocks.WEEPING_ROOTS, RenderType.cutoutMipped());
        map.put(BYGBlocks.PINK_CHERRY_FOLIAGE, RenderType.cutoutMipped());
        map.put(BYGBlocks.WHITE_CHERRY_FOLIAGE, RenderType.cutoutMipped());
        map.put(BYGBlocks.TALL_PINK_ALLIUM, RenderType.cutoutMipped());
        map.put(BYGBlocks.TALL_ALLIUM, RenderType.cutoutMipped());
        map.put(BYGBlocks.EMBUR_ROOTS, RenderType.cutoutMipped());
        map.put(BYGBlocks.TALL_EMBUR_ROOTS, RenderType.cutoutMipped());
        map.put(BYGBlocks.EMBUR_WART, RenderType.cutoutMipped());
        map.put(BYGBlocks.EMBUR_GEL_BLOCK, RenderType.translucent());
        map.put(BYGBlocks.EMBUR_GEL_VINES, RenderType.translucent());
        map.put(BYGBlocks.EMBUR_GEL_VINES_PLANT, RenderType.translucent());
        map.put(BYGBlocks.EMBUR_GEL_BRANCH, RenderType.translucent());
        map.put(BYGBlocks.EMBUR_SPROUTS, RenderType.cutoutMipped());
        map.put(BYGBlocks.EMBUR_LILY, RenderType.cutoutMipped());
        map.put(BYGBlocks.HANGING_BONE, RenderType.cutoutMipped());
        map.put(BYGBlocks.QUARTZ_CRYSTAL, RenderType.cutoutMipped());
        map.put(BYGBlocks.WAILING_BELL_BLOSSOM, RenderType.cutoutMipped());
        map.put(BYGBlocks.WAILING_GRASS, RenderType.cutoutMipped());
        map.put(BYGBlocks.WAILING_VINES, RenderType.cutoutMipped());
        map.put(BYGBlocks.SCORCHED_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.SCORCHED_GRASS, RenderType.cutoutMipped());
        map.put(BYGBlocks.BORIC_CAMPFIRE, RenderType.cutoutMipped());
        //Nether
        map.put(BYGBlocks.OVERGROWN_NETHERRACK, RenderType.cutoutMipped());
        map.put(BYGBlocks.SOUL_SHROOM_SPORE, RenderType.cutoutMipped());
        map.put(BYGBlocks.SOUL_SHROOM_SPORE_END, RenderType.cutoutMipped());
        map.put(BYGBlocks.SOUL_SHROOM, RenderType.cutoutMipped());
        map.put(BYGBlocks.DEATH_CAP, RenderType.cutoutMipped());
        map.put(BYGBlocks.LAMENT_VINE, RenderType.cutoutMipped());
        map.put(BYGBlocks.LAMENT_VINE_PLANT, RenderType.cutoutMipped());
        map.put(BYGBlocks.LAMENT_SPROUTS, RenderType.cutoutMipped());

        map.put(BYGBlocks.SUBZERO_CRYSTAL_CLUSTER, RenderType.cutoutMipped());
        map.put(BYGBlocks.LARGE_SUBZERO_CRYSTAL_BUD, RenderType.cutoutMipped());
        map.put(BYGBlocks.MEDIUM_SUBZERO_CRYSTAL_BUD, RenderType.cutoutMipped());
        map.put(BYGBlocks.SMALL_SUBZERO_CRYSTAL_BUD, RenderType.cutoutMipped());

        map.put(BYGBlocks.ARISIAN_BLOOM_BRANCH, RenderType.cutoutMipped());

        map.put(BYGBlocks.TALL_CRIMSON_ROOTS, RenderType.cutoutMipped());
        map.put(BYGBlocks.CRIMSON_BERRY_BUSH, RenderType.cutoutMipped());

        map.put(BYGBlocks.WARPED_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.WARPED_CACTUS, RenderType.cutoutMipped());
        map.put(BYGBlocks.WARPED_CORAL_FAN, RenderType.cutoutMipped());
        map.put(BYGBlocks.WARPED_CORAL, RenderType.cutoutMipped());
        map.put(BYGBlocks.WARPED_CORAL_WALL_FAN, RenderType.cutoutMipped());

        map.put(BYGBlocks.SYTHIAN_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.SYTHIAN_ROOTS, RenderType.cutoutMipped());
        map.put(BYGBlocks.SYTHIAN_SPROUT, RenderType.cutoutMipped());
        map.put(BYGBlocks.SYTHIAN_STALK_BLOCK, RenderType.cutoutMipped());
        map.put(BYGBlocks.SYTHIAN_NYLIUM, RenderType.cutoutMipped());
        map.put(BYGBlocks.HANGING_SYTHIAN_ROOTS, RenderType.cutoutMipped());
        map.put(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT, RenderType.cutoutMipped());
        map.put(BYGBlocks.SYTHIAN_FUNGUS, RenderType.cutoutMipped());

        //End
        map.put(BYGBlocks.IVIS_ROOTS, RenderType.cutoutMipped());
        map.put(BYGBlocks.IVIS_SPROUT, RenderType.cutoutMipped());
        map.put(BYGBlocks.NIGHTSHADE_SPROUTS, RenderType.cutoutMipped());
        map.put(BYGBlocks.ETHER_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.ETHER_GRASS, RenderType.cutoutMipped());
        map.put(BYGBlocks.THEREAL_BELLFLOWER, RenderType.cutoutMipped());
        map.put(BYGBlocks.ETHER_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.NIGHTSHADE_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_BULBIS_ODDITY, RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_BULBIS_SHELL, RenderType.translucent());
        map.put(BYGBlocks.BULBIS_ODDITY, RenderType.cutoutMipped());
        map.put(BYGBlocks.BULBIS_SHELL, RenderType.translucent());
        map.put(BYGBlocks.NIGHTSHADE_BERRY_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.NIGHTSHADE_ROOTS, RenderType.cutoutMipped());
        map.put(BYGBlocks.VERMILION_SCULK_GROWTH, RenderType.cutoutMipped());
        map.put(BYGBlocks.THERIUM_LANTERN, RenderType.cutoutMipped());
        map.put(BYGBlocks.CRYPTIC_LANTERN, RenderType.cutoutMipped());
        map.put(BYGBlocks.BORIC_LANTERN, RenderType.cutoutMipped());
        map.put(BYGBlocks.CRYPTIC_END_ROD, RenderType.cutoutMipped());
        map.put(BYGBlocks.ODDITY_CACTUS, RenderType.cutoutMipped());
        map.put(BYGBlocks.ODDITY_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.THERIUM_CRYSTAL, RenderType.cutoutMipped());
        map.put(BYGBlocks.SHULKREN_MOSS_BLANKET, RenderType.cutoutMipped());
        map.put(BYGBlocks.SHULKREN_FUNGUS, RenderType.cutoutMipped());
        map.put(BYGBlocks.SHULKREN_VINE, RenderType.cutoutMipped());
        map.put(BYGBlocks.SHULKREN_VINE_PLANT, RenderType.cutoutMipped());
        map.put(BYGBlocks.CRYPTIC_CAMPFIRE, RenderType.cutoutMipped());
        map.put(BYGBlocks.ENDER_LILY, RenderType.cutoutMipped());
        map.put(BYGBlocks.CRYPTIC_BRAMBLE, RenderType.cutoutMipped());
        map.put(BYGBlocks.FUNGAL_IMPARIUS_FILAMENT, RenderType.cutoutMipped());
        map.put(BYGBlocks.IMPARIUS_MUSHROOM, RenderType.cutoutMipped());
        map.put(BYGBlocks.FUNGAL_IMPARIUS, RenderType.cutoutMipped());
        map.put(BYGBlocks.IMPARIUS_VINE, RenderType.cutoutMipped());
        map.put(BYGBlocks.IMPARIUS_VINE_PLANT, RenderType.cutoutMipped());
        map.put(BYGBlocks.IMPARIUS_MUSHROOM_BRANCH, RenderType.cutoutMipped());
        map.put(BYGBlocks.IMPARIUS_BUSH, RenderType.cutoutMipped());

        //Sea Plants
        map.put(BYGBlocks.CATTAIL_SPROUT, RenderType.cutoutMipped());
        map.put(BYGBlocks.CATTAIL, RenderType.cutoutMipped());
        map.put(BYGBlocks.TINY_LILYPADS, RenderType.cutoutMipped());
        map.put(BYGBlocks.WATER_SILK, RenderType.cutoutMipped());

        //Doors
        map.put(BYGBlocks.ASPEN_DOOR, RenderType.translucent());
        map.put(BYGBlocks.BAOBAB_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.BLUE_ENCHANTED_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.CHERRY_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.CIKA_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.CYPRESS_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.EBONY_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.FIR_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.GREEN_ENCHANTED_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.HOLLY_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.JACARANDA_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.MAHOGANY_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.MANGROVE_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.MAPLE_DOOR, RenderType.translucent());
        map.put(BYGBlocks.PALM_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.PINE_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.RAINBOW_EUCALYPTUS_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.REDWOOD_DOOR, RenderType.translucent());
        map.put(BYGBlocks.SKYRIS_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.WILLOW_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.WITCH_HAZEL_DOOR, RenderType.translucent());
        map.put(BYGBlocks.ZELKOVA_DOOR, RenderType.translucent());
        map.put(BYGBlocks.SYTHIAN_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.EMBUR_DOOR, RenderType.translucent());
        map.put(BYGBlocks.LAMENT_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.BULBIS_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.ETHER_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.NIGHTSHADE_DOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.IMPARIUS_DOOR, RenderType.cutoutMipped());

        //Trapdoors
        map.put(BYGBlocks.ASPEN_TRAPDOOR, RenderType.translucent());
        map.put(BYGBlocks.BAOBAB_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.BLUE_ENCHANTED_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.CHERRY_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.CIKA_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.CYPRESS_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.EBONY_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.FIR_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.GREEN_ENCHANTED_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.HOLLY_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.JACARANDA_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.MAHOGANY_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.MANGROVE_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.MAPLE_TRAPDOOR, RenderType.translucent());
        map.put(BYGBlocks.PALM_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.PINE_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.REDWOOD_TRAPDOOR, RenderType.translucent());
        map.put(BYGBlocks.SKYRIS_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.WILLOW_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.WITCH_HAZEL_TRAPDOOR, RenderType.translucent());
        map.put(BYGBlocks.ZELKOVA_TRAPDOOR, RenderType.translucent());
        map.put(BYGBlocks.SYTHIAN_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.EMBUR_TRAPDOOR, RenderType.translucent());
        map.put(BYGBlocks.LAMENT_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.BULBIS_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.ETHER_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.NIGHTSHADE_TRAPDOOR, RenderType.cutoutMipped());
        map.put(BYGBlocks.IMPARIUS_TRAPDOOR, RenderType.cutoutMipped());

        //Grass
        map.put(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES, RenderType.translucent());
        map.put(BYGBlocks.TALL_PRAIRIE_GRASS, RenderType.cutoutMipped());
        map.put(BYGBlocks.BEACH_GRASS, RenderType.cutoutMipped());
        map.put(BYGBlocks.LEAF_PILE, RenderType.cutoutMipped());
        map.put(BYGBlocks.CLOVER_PATCH, RenderType.cutoutMipped());
        map.put(BYGBlocks.FLOWER_PATCH, RenderType.cutoutMipped());
        map.put(BYGBlocks.SHRUB, RenderType.cutoutMipped());


        //Saplings
        map.put(BYGBlocks.ASPEN_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.BAOBAB_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.BLUE_ENCHANTED_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.BLUE_SPRUCE_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.BROWN_BIRCH_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.BROWN_OAK_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.CYPRESS_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.CIKA_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.EBONY_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.FIR_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.GREEN_ENCHANTED_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.HOLLY_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.JACARANDA_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.INDIGO_JACARANDA_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.FLOWERING_JACARANDA_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.JACARANDA_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.INDIGO_JACARANDA_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.JOSHUA_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.MAHOGANY_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.MANGROVE_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.MAPLE_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.ORANGE_BIRCH_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.ORANGE_OAK_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.ORANGE_SPRUCE_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.ORCHARD_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.PALM_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.PALO_VERDE_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.PINE_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.PINK_CHERRY_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.RED_BIRCH_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.RED_MAPLE_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.RED_OAK_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.RED_SPRUCE_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.REDWOOD_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.SILVER_MAPLE_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.SKYRIS_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.WHITE_CHERRY_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.WILLOW_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.WITCH_HAZEL_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.ZELKOVA_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.YELLOW_BIRCH_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.YELLOW_SPRUCE_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.BROWN_ZELKOVA_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.ARAUCARIA_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.LAMENT_SAPLING, RenderType.cutoutMipped());
        map.put(BYGBlocks.WITHERING_OAK_SAPLING, RenderType.cutoutMipped());

        //Mushrooms
        map.put(BYGBlocks.WHITE_PUFFBALL, RenderType.cutoutMipped());
        map.put(BYGBlocks.WEEPING_MILKCAP, RenderType.cutoutMipped());
        map.put(BYGBlocks.WOOD_BLEWIT, RenderType.cutoutMipped());
        map.put(BYGBlocks.GREEN_MUSHROOM, RenderType.cutoutMipped());


        //FlowerBlocks
        map.put(BYGBlocks.ALLIUM_FLOWER_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.ALPINE_BELLFLOWER, RenderType.cutoutMipped());
        map.put(BYGBlocks.AMARANTH, RenderType.cutoutMipped());
        map.put(BYGBlocks.ANGELICA, RenderType.cutoutMipped());
        map.put(BYGBlocks.HYDRANGEA_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.HYDRANGEA_HEDGE, RenderType.cutoutMipped());
        map.put(BYGBlocks.BEGONIA, RenderType.cutoutMipped());
        map.put(BYGBlocks.BISTORT, RenderType.cutoutMipped());
        map.put(BYGBlocks.CALIFORNIA_POPPY, RenderType.cutoutMipped());
        map.put(BYGBlocks.CROCUS, RenderType.cutoutMipped());
        map.put(BYGBlocks.BLACK_ROSE, RenderType.cutoutMipped());
        map.put(BYGBlocks.CYAN_AMARANTH, RenderType.cutoutMipped());
        map.put(BYGBlocks.CYAN_ROSE, RenderType.cutoutMipped());
        map.put(BYGBlocks.CYAN_TULIP, RenderType.cutoutMipped());
        map.put(BYGBlocks.DAFFODIL, RenderType.cutoutMipped());
        map.put(BYGBlocks.DELPHINIUM, RenderType.cutoutMipped());
        map.put(BYGBlocks.FAIRY_SLIPPER, RenderType.cutoutMipped());
        map.put(BYGBlocks.FIRECRACKER_FLOWER_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.FOXGLOVE, RenderType.cutoutMipped());
        map.put(BYGBlocks.GOLDEN_SPINED_CACTUS, RenderType.cutoutMipped());
        map.put(BYGBlocks.GREEN_TULIP, RenderType.cutoutMipped());
        map.put(BYGBlocks.GUZMANIA, RenderType.cutoutMipped());
        map.put(BYGBlocks.INCAN_LILY, RenderType.cutoutMipped());
        map.put(BYGBlocks.IRIS, RenderType.cutoutMipped());
        map.put(BYGBlocks.JAPANESE_ORCHID, RenderType.cutoutMipped());
        map.put(BYGBlocks.KOVAN_FLOWER, RenderType.cutoutMipped());
        map.put(BYGBlocks.LAZARUS_BELLFLOWER, RenderType.cutoutMipped());
        map.put(BYGBlocks.LOLLIPOP_FLOWER, RenderType.cutoutMipped());
        map.put(BYGBlocks.MAGENTA_AMARANTH, RenderType.cutoutMipped());
        map.put(BYGBlocks.MAGENTA_TULIP, RenderType.cutoutMipped());
        map.put(BYGBlocks.ORANGE_AMARANTH, RenderType.cutoutMipped());
        map.put(BYGBlocks.ORANGE_DAISY, RenderType.cutoutMipped());
        map.put(BYGBlocks.ORSIRIA_ROSE, RenderType.cutoutMipped());
        map.put(BYGBlocks.PEACH_LEATHER_FLOWER, RenderType.cutoutMipped());
        map.put(BYGBlocks.PINK_ALLIUM, RenderType.cutoutMipped());
        map.put(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.PINK_ANEMONE, RenderType.cutoutMipped());
        map.put(BYGBlocks.PINK_DAFFODIL, RenderType.cutoutMipped());
        map.put(BYGBlocks.PROTEA_FLOWER, RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_AMARANTH, RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_SAGE, RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_TULIP, RenderType.cutoutMipped());
        map.put(BYGBlocks.RICHEA, RenderType.cutoutMipped());
        map.put(BYGBlocks.ROSE, RenderType.cutoutMipped());
        map.put(BYGBlocks.SNOWDROPS, RenderType.cutoutMipped());
        map.put(BYGBlocks.SILVER_VASE_FLOWER, RenderType.cutoutMipped());
        map.put(BYGBlocks.TORCH_GINGER, RenderType.cutoutMipped());
        map.put(BYGBlocks.VIOLET_LEATHER_FLOWER, RenderType.cutoutMipped());
        map.put(BYGBlocks.WHITE_ANEMONE, RenderType.cutoutMipped());
        map.put(BYGBlocks.WHITE_SAGE, RenderType.cutoutMipped());
        map.put(BYGBlocks.WINTER_CYCLAMEN, RenderType.cutoutMipped());
        map.put(BYGBlocks.WINTER_ROSE, RenderType.cutoutMipped());
        map.put(BYGBlocks.WINTER_SCILLA, RenderType.cutoutMipped());
        map.put(BYGBlocks.YELLOW_DAFFODIL, RenderType.cutoutMipped());
        map.put(BYGBlocks.YELLOW_TULIP, RenderType.cutoutMipped());

        //Other renders
        map.put(BYGBlocks.AMETRINE_CLUSTER, RenderType.cutoutMipped());
        map.put(BYGBlocks.BORIC_FIRE, RenderType.cutoutMipped());
        map.put(BYGBlocks.CRYPTIC_FIRE, RenderType.cutoutMipped());
        map.put(BYGBlocks.THERIUM_GLASS, RenderType.translucent());
        map.put(BYGBlocks.THERIUM_GLASS_PANE, RenderType.translucent());
        map.put(BYGBlocks.ETHER_FOLIAGE, RenderType.cutoutMipped());
        map.put(BYGBlocks.VERMILION_SCULK_TENDRILS, RenderType.cutoutMipped());
        map.put(BYGBlocks.TALL_ETHER_GRASS, RenderType.cutoutMipped());
        map.put(BYGBlocks.BULBIS_SPROUTS, RenderType.cutoutMipped());
        map.put(BYGBlocks.BULBIS_ANOMALY, RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_BULBIS_ANOMALY, RenderType.cutoutMipped());
        map.put(BYGBlocks.ETHER_BULB, RenderType.cutoutMipped());
        map.put(BYGBlocks.BAOBAB_FRUIT_BLOCK, RenderType.cutoutMipped());
        map.put(BYGBlocks.BLACK_ICE, RenderType.translucent());
        map.put(BYGBlocks.AMETRINE_BLOCK, RenderType.translucent());
        map.put(BYGBlocks.BLUEBERRY_BUSH, RenderType.cutoutMipped());
        map.put(BYGBlocks.SYTHIAN_SCAFFOLDING, RenderType.cutoutMipped());
        map.put(BYGBlocks.OVERGROWN_STONE, RenderType.cutoutMipped());
        map.put(BYGBlocks.OVERGROWN_DACITE, RenderType.cutoutMipped());
        map.put(BYGBlocks.PRAIRIE_GRASS, RenderType.cutoutMipped());
        map.put(BYGBlocks.LUSH_GRASS_BLOCK, RenderType.cutoutMipped());
        map.put(BYGBlocks.POISON_IVY, RenderType.cutoutMipped());
        map.put(BYGBlocks.SKYRIS_VINE, RenderType.cutoutMipped());

        for (Block potBlock : BYGBlocks.flowerPotBlocks)
            map.put(potBlock, RenderType.cutoutMipped());

        BYG.LOGGER.debug("BYG: Texture Cutouts Rendered!");

        mapConsumer.accept(map);
    }
}
