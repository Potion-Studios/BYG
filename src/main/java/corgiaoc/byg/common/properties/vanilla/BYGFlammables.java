package corgiaoc.byg.common.properties.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import corgiaoc.byg.BYG;
import corgiaoc.byg.core.byglists.BYGBlockList;

public class BYGFlammables {
    public static void flammableBlock(Block block, int encouragement, int flammability) {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFireInfo(block, encouragement, flammability);
    }

    public static void flammablesBYG() {
        BYG.LOGGER.debug("BYG: Adding Flammables...");
        //Logs
        flammableBlock(BYGBlockList.ASPEN_LOG, 5, 5);
        flammableBlock(BYGBlockList.BAOBAB_LOG, 5, 5);
        flammableBlock(BYGBlockList.BLUE_ENCHANTED_LOG, 5, 5);
        flammableBlock(BYGBlockList.CHERRY_LOG, 5, 5);
        flammableBlock(BYGBlockList.CIKA_LOG, 5, 5);
        flammableBlock(BYGBlockList.EBONY_LOG, 5, 5);
        flammableBlock(BYGBlockList.FIR_LOG, 5, 5);
        flammableBlock(BYGBlockList.GREEN_ENCHANTED_LOG, 5, 5);
        flammableBlock(BYGBlockList.HOLLY_LOG, 5, 5);
        flammableBlock(BYGBlockList.JACARANDA_LOG, 5, 5);
        flammableBlock(BYGBlockList.MAHOGANY_LOG, 5, 5);
        flammableBlock(BYGBlockList.MANGROVE_LOG, 5, 5);
        flammableBlock(BYGBlockList.MAPLE_LOG, 5, 5);
        flammableBlock(BYGBlockList.PALO_VERDE_LOG, 5, 5);
        flammableBlock(BYGBlockList.PINE_LOG, 5, 5);
        flammableBlock(BYGBlockList.RAINBOW_EUCALYPTUS_LOG, 5, 5);
        flammableBlock(BYGBlockList.REDWOOD_LOG, 5, 5);
        flammableBlock(BYGBlockList.WILLOW_LOG, 5, 5);
        flammableBlock(BYGBlockList.WITCH_HAZEL_LOG, 5, 5);
        flammableBlock(BYGBlockList.ZELKOVA_LOG, 5, 5);
        flammableBlock(BYGBlockList.PALM_LOG, 5, 5);

        //Stripped Logs
        flammableBlock(BYGBlockList.STRIPPED_ASPEN_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_BAOBAB_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_BLUE_ENCHANTED_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_CHERRY_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_CIKA_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_CYPRESS_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_EBONY_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_FIR_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_GREEN_ENCHANTED_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_HOLLY_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_JACARANDA_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_MAHOGANY_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_MANGROVE_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_MAPLE_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_PALO_VERDE_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_RAINBOW_EUCALYPTUS_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_SKYRIS_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_WILLOW_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_WITCH_HAZEL_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_ZELKOVA_LOG, 5, 5);
        flammableBlock(BYGBlockList.STRIPPED_PALM_LOG, 5, 5);

        //BookShelves
        flammableBlock(BYGBlockList.ASPEN_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.BAOBAB_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.BLUE_ENCHANTED_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.CHERRY_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.CIKA_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.CYPRESS_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.EBONY_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.FIR_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.GREEN_ENCHANTED_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.HOLLY_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.JACARANDA_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.MAHOGANY_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.MANGROVE_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.MAPLE_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.PINE_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.RAINBOW_EUCALYPTUS_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.REDWOOD_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.SKYRIS_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.WILLOW_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.WITCH_HAZEL_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.ZELKOVA_BOOKSHELF, 5, 20);
        flammableBlock(BYGBlockList.PALM_BOOKSHELF, 5, 20);

        //Slabs
        flammableBlock(BYGBlockList.ASPEN_SLAB, 5, 20);
        flammableBlock(BYGBlockList.BAOBAB_SLAB, 5, 20);
        flammableBlock(BYGBlockList.BLUE_ENCHANTED_SLAB, 5, 20);
        flammableBlock(BYGBlockList.CHERRY_SLAB, 5, 20);
        flammableBlock(BYGBlockList.CIKA_SLAB, 5, 20);
        flammableBlock(BYGBlockList.CYPRESS_SLAB, 5, 20);
        flammableBlock(BYGBlockList.EBONY_SLAB, 5, 20);
        flammableBlock(BYGBlockList.FIR_SLAB, 5, 20);
        flammableBlock(BYGBlockList.GREEN_ENCHANTED_SLAB, 5, 20);
        flammableBlock(BYGBlockList.HOLLY_SLAB, 5, 20);
        flammableBlock(BYGBlockList.JACARANDA_SLAB, 5, 20);
        flammableBlock(BYGBlockList.MAHOGANY_SLAB, 5, 20);
        flammableBlock(BYGBlockList.MANGROVE_SLAB, 5, 20);
        flammableBlock(BYGBlockList.MAPLE_SLAB, 5, 20);
        flammableBlock(BYGBlockList.PINE_SLAB, 5, 20);
        flammableBlock(BYGBlockList.RAINBOW_EUCALYPTUS_SLAB, 5, 20);
        flammableBlock(BYGBlockList.REDWOOD_SLAB, 5, 20);
        flammableBlock(BYGBlockList.SKYRIS_SLAB, 5, 20);
        flammableBlock(BYGBlockList.WILLOW_SLAB, 5, 20);
        flammableBlock(BYGBlockList.WITCH_HAZEL_SLAB, 5, 20);
        flammableBlock(BYGBlockList.ZELKOVA_SLAB, 5, 20);
        flammableBlock(BYGBlockList.PALM_SLAB, 5, 20);

        //Stairs
        flammableBlock(BYGBlockList.ASPEN_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.BAOBAB_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.BLUE_ENCHANTED_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.CHERRY_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.CIKA_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.CYPRESS_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.EBONY_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.FIR_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.GREEN_ENCHANTED_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.HOLLY_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.JACARANDA_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.MAHOGANY_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.MANGROVE_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.MAPLE_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.PINE_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.RAINBOW_EUCALYPTUS_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.REDWOOD_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.SKYRIS_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.WILLOW_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.WITCH_HAZEL_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.ZELKOVA_STAIRS, 5, 20);
        flammableBlock(BYGBlockList.ZELKOVA_STAIRS, 5, 20);

        //Planks
        flammableBlock(BYGBlockList.ASPEN_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.BAOBAB_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.BLUE_ENCHANTED_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.CHERRY_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.CIKA_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.CYPRESS_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.EBONY_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.FIR_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.GREEN_ENCHANTED_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.HOLLY_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.JACARANDA_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.MAHOGANY_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.MANGROVE_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.MAPLE_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.PINE_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.RAINBOW_EUCALYPTUS_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.REDWOOD_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.SKYRIS_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.WILLOW_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.WITCH_HAZEL_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.ZELKOVA_PLANKS, 5, 20);
        flammableBlock(BYGBlockList.PALM_PLANKS, 5, 20);

        //Fences
        flammableBlock(BYGBlockList.ASPEN_FENCE, 5, 20);
        flammableBlock(BYGBlockList.BAOBAB_FENCE, 5, 20);
        flammableBlock(BYGBlockList.BLUE_ENCHANTED_FENCE, 5, 20);
        flammableBlock(BYGBlockList.CHERRY_FENCE, 5, 20);
        flammableBlock(BYGBlockList.CIKA_FENCE, 5, 20);
        flammableBlock(BYGBlockList.CYPRESS_FENCE, 5, 20);
        flammableBlock(BYGBlockList.EBONY_FENCE, 5, 20);
        flammableBlock(BYGBlockList.FIR_FENCE, 5, 20);
        flammableBlock(BYGBlockList.GREEN_ENCHANTED_FENCE, 5, 20);
        flammableBlock(BYGBlockList.HOLLY_FENCE, 5, 20);
        flammableBlock(BYGBlockList.JACARANDA_FENCE, 5, 20);
        flammableBlock(BYGBlockList.MAHOGANY_FENCE, 5, 20);
        flammableBlock(BYGBlockList.MANGROVE_FENCE, 5, 20);
        flammableBlock(BYGBlockList.MAPLE_FENCE, 5, 20);
        flammableBlock(BYGBlockList.PINE_FENCE, 5, 20);
        flammableBlock(BYGBlockList.RAINBOW_EUCALYPTUS_FENCE, 5, 20);
        flammableBlock(BYGBlockList.REDWOOD_FENCE, 5, 20);
        flammableBlock(BYGBlockList.SKYRIS_FENCE, 5, 20);
        flammableBlock(BYGBlockList.WILLOW_FENCE, 5, 20);
        flammableBlock(BYGBlockList.WITCH_HAZEL_FENCE, 5, 20);
        flammableBlock(BYGBlockList.ZELKOVA_FENCE, 5, 20);
        flammableBlock(BYGBlockList.ZELKOVA_FENCE, 5, 20);

        //Leaves
        flammableBlock(BYGBlockList.ASPEN_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.BAOBAB_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.BLUE_ENCHANTED_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.BLUE_SPRUCE_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.BROWN_BIRCH_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.BROWN_OAK_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.CIKA_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.CYPRESS_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.EBONY_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.FIR_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.FLOWERING_ORCHARD_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.FLOWERING_PALO_VERDE_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.GREEN_ENCHANTED_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.HOLLY_BERRY_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.HOLLY_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.JACARANDA_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.MAHOGANY_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.MANGROVE_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.ORANGE_BIRCH_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.ORANGE_OAK_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.ORANGE_SPRUCE_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.ORCHARD_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.PALO_VERDE_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.PINE_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.PINK_CHERRY_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.RAINBOW_EUCALYPTUS_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.REDWOOD_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.RIPE_ORCHARD_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.SILVER_MAPLE_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE, 30, 60);
        flammableBlock(BYGBlockList.SKYRIS_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.WHITE_CHERRY_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.WILLOW_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.WITCH_HAZEL_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.YELLOW_BIRCH_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.YELLOW_SPRUCE_LEAVES, 30, 60);
        flammableBlock(BYGBlockList.PALM_LEAVES, 30, 60);

        //Flowers
        flammableBlock(BYGBlockList.ALLIUM_FLOWER_BUSH, 60, 100);
        flammableBlock(BYGBlockList.ALPINE_BELLFLOWER, 60, 100);
        flammableBlock(BYGBlockList.AMARANTH, 60, 100);
        flammableBlock(BYGBlockList.ANGELICA, 60, 100);
        flammableBlock(BYGBlockList.AZALEA, 60, 100);
        flammableBlock(BYGBlockList.BEGONIA, 60, 100);
        flammableBlock(BYGBlockList.BISTORT, 60, 100);
        flammableBlock(BYGBlockList.BLACK_ROSE, 60, 100);
        flammableBlock(BYGBlockList.BLUE_SAGE, 60, 100);
        flammableBlock(BYGBlockList.CALIFORNIA_POPPY, 60, 100);
        flammableBlock(BYGBlockList.CROCUS, 60, 100);
        flammableBlock(BYGBlockList.CYAN_AMARANTH, 60, 100);
        flammableBlock(BYGBlockList.CYAN_ROSE, 60, 100);
        flammableBlock(BYGBlockList.CYAN_TULIP, 60, 100);
        flammableBlock(BYGBlockList.DAFFODIL, 60, 100);
        flammableBlock(BYGBlockList.DELPHINIUM, 60, 100);
        flammableBlock(BYGBlockList.FAIRY_SLIPPER, 60, 100);
        flammableBlock(BYGBlockList.FIRECRACKER_FLOWER_BUSH, 60, 100);
        flammableBlock(BYGBlockList.FOXGLOVE, 60, 100);
        flammableBlock(BYGBlockList.GOLDEN_SPINED_CACTUS, 60, 100);
        flammableBlock(BYGBlockList.GREEN_TULIP, 60, 100);
        flammableBlock(BYGBlockList.GUZMANIA, 60, 100);
        flammableBlock(BYGBlockList.INCAN_LILY, 60, 100);
        flammableBlock(BYGBlockList.IRIS, 60, 100);
        flammableBlock(BYGBlockList.JAPANESE_ORCHID, 60, 100);
        flammableBlock(BYGBlockList.KOVAN_FLOWER, 60, 100);
        flammableBlock(BYGBlockList.LAZARUS_BELLFLOWER, 60, 100);
        flammableBlock(BYGBlockList.LOLIPOP_FLOWER, 60, 100);
        flammableBlock(BYGBlockList.MAGENTA_AMARANTH, 60, 100);
        flammableBlock(BYGBlockList.MAGENTA_TULIP, 60, 100);
        flammableBlock(BYGBlockList.ORANGE_DAISY, 60, 100);
        flammableBlock(BYGBlockList.ORSIRIA_ROSE, 60, 100);
        flammableBlock(BYGBlockList.PEACH_LEATHER_FLOWER, 60, 100);
        flammableBlock(BYGBlockList.PINK_ALLIUM, 60, 100);
        flammableBlock(BYGBlockList.PINK_ALLIUM_FLOWER_BUSH, 60, 100);
        flammableBlock(BYGBlockList.PINK_ANEMONE, 60, 100);
        flammableBlock(BYGBlockList.PINK_DAFFODIL, 60, 100);
        flammableBlock(BYGBlockList.PINK_ORCHID, 60, 100);
        flammableBlock(BYGBlockList.PRAIRIE_GRASS, 60, 100);
        flammableBlock(BYGBlockList.PROTEA_FLOWER, 60, 100);
        flammableBlock(BYGBlockList.PURPLE_AMARANTH, 60, 100);
        flammableBlock(BYGBlockList.PURPLE_ORCHID, 60, 100);
        flammableBlock(BYGBlockList.PURPLE_SAGE, 60, 100);
        flammableBlock(BYGBlockList.PURPLE_TULIP, 60, 100);
        flammableBlock(BYGBlockList.RED_CORNFLOWER, 60, 100);
        flammableBlock(BYGBlockList.RED_ORCHID, 60, 100);
        flammableBlock(BYGBlockList.RICHEA, 60, 100);
        flammableBlock(BYGBlockList.ROSE, 60, 100);
        flammableBlock(BYGBlockList.SILVER_VASE_FLOWER, 60, 100);
        flammableBlock(BYGBlockList.SNOWDROPS, 60, 100);
        flammableBlock(BYGBlockList.TORCH_GINGER, 60, 100);
        flammableBlock(BYGBlockList.VIOLET_LEATHER_FLOWER, 60, 100);
        flammableBlock(BYGBlockList.WHITE_ANEMONE, 60, 100);
        flammableBlock(BYGBlockList.WHITE_SAGE, 60, 100);
        flammableBlock(BYGBlockList.WINTER_CYCLAMEN, 60, 100);
        flammableBlock(BYGBlockList.WINTER_ROSE, 60, 100);
        flammableBlock(BYGBlockList.WINTER_SCILLA, 60, 100);
        flammableBlock(BYGBlockList.YELLOW_DAFFODIL, 60, 100);
        flammableBlock(BYGBlockList.YELLOW_TULIP, 60, 100);

        //Plants
        flammableBlock(BYGBlockList.HORSEWEED, 60, 100);
        flammableBlock(BYGBlockList.WINTER_SUCCULENT, 60, 100);
        flammableBlock(BYGBlockList.SHORT_GRASS, 60, 200);
        flammableBlock(BYGBlockList.POISON_IVY, 15, 100);

        BYG.LOGGER.info("BYG: Added Flammables!");
    }
}
