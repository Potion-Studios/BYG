package voronoiaoc.byg.common.properties.vanilla;//package voronoiaoc.byg.common.properties.vanilla;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGBlockList;

public class BYGFlammables {

    public static void flammablesBYG() {
        FlammableBlockRegistry flammableBlock = FlammableBlockRegistry.getDefaultInstance();
        BYG.LOGGER.debug("BYG: Adding Flammables...");
        //Logs
        flammableBlock.add(BYGBlockList.ASPEN_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.BAOBAB_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.BLUE_ENCHANTED_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.CHERRY_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.CIKA_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.EBONY_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.FIR_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.GREEN_ENCHANTED_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.HOLLY_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.JACARANDA_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.MAHOGANY_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.MANGROVE_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.MAPLE_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.PALO_VERDE_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.PINE_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.RAINBOW_EUCALYPTUS_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.REDWOOD_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.WILLOW_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.WITCH_HAZEL_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.ZELKOVA_LOG, 5, 5);

        //Stripped Logs
        flammableBlock.add(BYGBlockList.STRIPPED_ASPEN_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_BAOBAB_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_BLUE_ENCHANTED_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_CHERRY_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_CIKA_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_CYPRESS_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_EBONY_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_FIR_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_GREEN_ENCHANTED_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_HOLLY_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_JACARANDA_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_MAHOGANY_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_MANGROVE_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_MAPLE_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_PALO_VERDE_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_RAINBOW_EUCALYPTUS_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_SKYRIS_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_WILLOW_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_WITCH_HAZEL_LOG, 5, 5);
        flammableBlock.add(BYGBlockList.STRIPPED_ZELKOVA_LOG, 5, 5);

        //BookShelves
        flammableBlock.add(BYGBlockList.ASPEN_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.BAOBAB_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.BLUE_ENCHANTED_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.CHERRY_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.CIKA_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.CYPRESS_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.EBONY_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.FIR_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.GREEN_ENCHANTED_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.HOLLY_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.JACARANDA_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.MAHOGANY_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.MANGROVE_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.MAPLE_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.PINE_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.RAINBOW_EUCALYPTUS_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.REDWOOD_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.SKYRIS_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.WILLOW_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.WITCH_HAZEL_BOOKSHELF, 5, 20);
        flammableBlock.add(BYGBlockList.ZELKOVA_BOOKSHELF, 5, 20);

        //Slabs
        flammableBlock.add(BYGBlockList.ASPEN_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.BAOBAB_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.BLUE_ENCHANTED_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.CHERRY_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.CIKA_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.CYPRESS_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.EBONY_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.FIR_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.GREEN_ENCHANTED_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.HOLLY_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.JACARANDA_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.MAHOGANY_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.MANGROVE_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.MAPLE_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.PINE_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.RAINBOW_EUCALYPTUS_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.REDWOOD_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.SKYRIS_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.WILLOW_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.WITCH_HAZEL_SLAB, 5, 20);
        flammableBlock.add(BYGBlockList.ZELKOVA_SLAB, 5, 20);

        //Stairs
        flammableBlock.add(BYGBlockList.ASPEN_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.BAOBAB_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.BLUE_ENCHANTED_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.CHERRY_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.CIKA_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.CYPRESS_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.EBONY_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.FIR_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.GREEN_ENCHANTED_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.HOLLY_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.JACARANDA_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.MAHOGANY_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.MANGROVE_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.MAPLE_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.PINE_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.RAINBOW_EUCALYPTUS_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.REDWOOD_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.SKYRIS_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.WILLOW_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.WITCH_HAZEL_STAIRS, 5, 20);
        flammableBlock.add(BYGBlockList.ZELKOVA_STAIRS, 5, 20);

        //Planks
        flammableBlock.add(BYGBlockList.ASPEN_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.BAOBAB_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.BLUE_ENCHANTED_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.CHERRY_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.CIKA_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.CYPRESS_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.EBONY_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.FIR_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.GREEN_ENCHANTED_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.HOLLY_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.JACARANDA_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.MAHOGANY_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.MANGROVE_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.MAPLE_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.PINE_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.RAINBOW_EUCALYPTUS_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.REDWOOD_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.SKYRIS_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.WILLOW_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.WITCH_HAZEL_PLANKS, 5, 20);
        flammableBlock.add(BYGBlockList.ZELKOVA_PLANKS, 5, 20);

        //Fences
        flammableBlock.add(BYGBlockList.ASPEN_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.BAOBAB_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.BLUE_ENCHANTED_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.CHERRY_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.CIKA_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.CYPRESS_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.EBONY_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.FIR_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.GREEN_ENCHANTED_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.HOLLY_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.JACARANDA_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.MAHOGANY_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.MANGROVE_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.MAPLE_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.PINE_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.RAINBOW_EUCALYPTUS_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.REDWOOD_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.SKYRIS_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.WILLOW_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.WITCH_HAZEL_FENCE, 5, 20);
        flammableBlock.add(BYGBlockList.ZELKOVA_FENCE, 5, 20);

        //Leaves
        flammableBlock.add(BYGBlockList.ASPEN_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.BAOBAB_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.BLUE_ENCHANTED_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.BLUE_SPRUCE_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.BROWN_BIRCH_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.BROWN_OAK_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.CIKA_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.CYPRESS_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.EBONY_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.FIR_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.FLOWERING_ORCHARD_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.FLOWERING_PALO_VERDE_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.GREEN_ENCHANTED_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.HOLLY_BERRY_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.HOLLY_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.JACARANDA_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.MAHOGANY_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.MANGROVE_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.ORANGE_BIRCH_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.ORANGE_OAK_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.ORANGE_SPRUCE_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.ORCHARD_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.PALO_VERDE_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.PINE_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.PINK_CHERRY_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.RAINBOW_EUCALYPTUS_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.REDWOOD_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.RIPE_ORCHARD_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.SILVER_MAPLE_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE, 30, 60);
        flammableBlock.add(BYGBlockList.SKYRIS_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.WHITE_CHERRY_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.WILLOW_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.WITCH_HAZEL_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.YELLOW_BIRCH_LEAVES, 30, 60);
        flammableBlock.add(BYGBlockList.YELLOW_SPRUCE_LEAVES, 30, 60);

        //Flowers
        flammableBlock.add(BYGBlockList.ALLIUM_FLOWER_BUSH, 60, 100);
        flammableBlock.add(BYGBlockList.ALPINE_BELLFLOWER, 60, 100);
        flammableBlock.add(BYGBlockList.AMARANTH, 60, 100);
        flammableBlock.add(BYGBlockList.ANGELICA, 60, 100);
        flammableBlock.add(BYGBlockList.AZALEA, 60, 100);
        flammableBlock.add(BYGBlockList.BEGONIA, 60, 100);
        flammableBlock.add(BYGBlockList.BISTORT, 60, 100);
        flammableBlock.add(BYGBlockList.BLACK_ROSE, 60, 100);
        flammableBlock.add(BYGBlockList.BLUE_SAGE, 60, 100);
        flammableBlock.add(BYGBlockList.CALIFORNIA_POPPY, 60, 100);
        flammableBlock.add(BYGBlockList.CROCUS, 60, 100);
        flammableBlock.add(BYGBlockList.CYAN_AMARANTH, 60, 100);
        flammableBlock.add(BYGBlockList.CYAN_ROSE, 60, 100);
        flammableBlock.add(BYGBlockList.CYAN_TULIP, 60, 100);
        flammableBlock.add(BYGBlockList.DAFFODIL, 60, 100);
        flammableBlock.add(BYGBlockList.DELPHINIUM, 60, 100);
        flammableBlock.add(BYGBlockList.FAIRY_SLIPPER, 60, 100);
        flammableBlock.add(BYGBlockList.FIRECRACKER_FLOWER_BUSH, 60, 100);
        flammableBlock.add(BYGBlockList.FOXGLOVE, 60, 100);
        flammableBlock.add(BYGBlockList.GOLDEN_SPINED_CACTUS, 60, 100);
        flammableBlock.add(BYGBlockList.GREEN_TULIP, 60, 100);
        flammableBlock.add(BYGBlockList.GUZMANIA, 60, 100);
        flammableBlock.add(BYGBlockList.INCAN_LILY, 60, 100);
        flammableBlock.add(BYGBlockList.IRIS, 60, 100);
        flammableBlock.add(BYGBlockList.JAPANESE_ORCHID, 60, 100);
        flammableBlock.add(BYGBlockList.KOVAN_FLOWER, 60, 100);
        flammableBlock.add(BYGBlockList.LAZARUS_BELLFLOWER, 60, 100);
        flammableBlock.add(BYGBlockList.LOLIPOP_FLOWER, 60, 100);
        flammableBlock.add(BYGBlockList.MAGENTA_AMARANTH, 60, 100);
        flammableBlock.add(BYGBlockList.MAGENTA_TULIP, 60, 100);
        flammableBlock.add(BYGBlockList.ORANGE_DAISY, 60, 100);
        flammableBlock.add(BYGBlockList.ORSIRIA_ROSE, 60, 100);
        flammableBlock.add(BYGBlockList.PEACH_LEATHER_FLOWER, 60, 100);
        flammableBlock.add(BYGBlockList.PINK_ALLIUM, 60, 100);
        flammableBlock.add(BYGBlockList.PINK_ALLIUM_FLOWER_BUSH, 60, 100);
        flammableBlock.add(BYGBlockList.PINK_ANEMONE, 60, 100);
        flammableBlock.add(BYGBlockList.PINK_DAFFODIL, 60, 100);
        flammableBlock.add(BYGBlockList.PINK_ORCHID, 60, 100);
        flammableBlock.add(BYGBlockList.PRAIRIE_GRASS, 60, 100);
        flammableBlock.add(BYGBlockList.PROTEA_FLOWER, 60, 100);
        flammableBlock.add(BYGBlockList.PURPLE_AMARANTH, 60, 100);
        flammableBlock.add(BYGBlockList.PURPLE_ORCHID, 60, 100);
        flammableBlock.add(BYGBlockList.PURPLE_SAGE, 60, 100);
        flammableBlock.add(BYGBlockList.PURPLE_TULIP, 60, 100);
        flammableBlock.add(BYGBlockList.RED_CORNFLOWER, 60, 100);
        flammableBlock.add(BYGBlockList.RED_ORCHID, 60, 100);
        flammableBlock.add(BYGBlockList.RICHEA, 60, 100);
        flammableBlock.add(BYGBlockList.ROSE, 60, 100);
        flammableBlock.add(BYGBlockList.SILVER_VASE_FLOWER, 60, 100);
        flammableBlock.add(BYGBlockList.SNOWDROPS, 60, 100);
        flammableBlock.add(BYGBlockList.TORCH_GINGER, 60, 100);
        flammableBlock.add(BYGBlockList.VIOLET_LEATHER_FLOWER, 60, 100);
        flammableBlock.add(BYGBlockList.WHITE_ANEMONE, 60, 100);
        flammableBlock.add(BYGBlockList.WHITE_SAGE, 60, 100);
        flammableBlock.add(BYGBlockList.WINTER_CYCLAMEN, 60, 100);
        flammableBlock.add(BYGBlockList.WINTER_ROSE, 60, 100);
        flammableBlock.add(BYGBlockList.WINTER_SCILLA, 60, 100);
        flammableBlock.add(BYGBlockList.YELLOW_DAFFODIL, 60, 100);
        flammableBlock.add(BYGBlockList.YELLOW_TULIP, 60, 100);

        //Plants
        flammableBlock.add(BYGBlockList.HORSEWEED, 60, 100);
        flammableBlock.add(BYGBlockList.WINTER_SUCCULENT, 60, 100);
        flammableBlock.add(BYGBlockList.SHORT_GRASS, 60, 200);
        flammableBlock.add(BYGBlockList.POISON_IVY, 15, 100);

        BYG.LOGGER.info("BYG: Added Flammables!");
    }

}