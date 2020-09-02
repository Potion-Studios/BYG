package voronoiaoc.byg.common.properties.vanilla;

import net.minecraft.block.ComposterBlock;
import net.minecraft.util.IItemProvider;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGItemList;

public class BYGCompostables {
    public static void compostibleBlocks(float chance, IItemProvider item) {
        ComposterBlock.CHANCES.put(item.asItem(), chance);
    }

    public static void compostablesBYG() {
        BYG.LOGGER.debug("BYG: Adding Compostible Blocks...");

        //Leaves
        compostibleBlocks(0.3f, BYGItemList.ASPEN_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.BAOBAB_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.BLOOMING_WITCH_HAZEL_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.BLUE_ENCHANTED_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.BLUE_SPRUCE_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.BROWN_BIRCH_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.BROWN_OAK_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.CIKA_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.CYPRESS_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.EBONY_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.FIR_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.FLOWERING_ORCHARD_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.FLOWERING_PALO_VERDE_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.GREEN_ENCHANTED_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.HOLLY_BERRY_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.HOLLY_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.JACARANDA_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.MAHOGANY_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.MANGROVE_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.ORANGE_BIRCH_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.ORANGE_OAK_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.ORANGE_SPRUCE_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.ORCHARD_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.PALO_VERDE_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.PINE_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.PINK_CHERRY_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.RAINBOW_EUCALYPTUS_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.REDWOOD_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.RED_MAPLE_LEAVES);
        compostibleBlocks(0.6f, BYGItemList.RIPE_ORCHARD_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.SILVER_MAPLE_LEAVES);
        compostibleBlocks(0.6f, BYGItemList.SKYRIS_LEAVES_GREEN_APPLE);
        compostibleBlocks(0.3f, BYGItemList.SKYRIS_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.WHITE_CHERRY_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.WILLOW_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.WITCH_HAZEL_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.YELLOW_BIRCH_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.YELLOW_SPRUCE_LEAVES);
        compostibleBlocks(0.3f, BYGItemList.RED_SPRUCE_LEAVES);

        //Saplings
        compostibleBlocks(0.3f, BYGItemList.ASPEN_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.BAOBAB_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.BLUE_ENCHANTED_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.BLUE_SPRUCE_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.BROWN_BIRCH_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.BROWN_OAK_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.CIKA_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.CYPRESS_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.EBONY_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.FIR_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.GREEN_ENCHANTED_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.HOLLY_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.JACARANDA_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.MAHOGANY_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.MANGROVE_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.ORANGE_BIRCH_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.ORANGE_OAK_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.ORANGE_SPRUCE_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.ORCHARD_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.PALO_VERDE_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.PINE_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.PINK_CHERRY_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.RAINBOW_EUCALYPTUS_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.REDWOOD_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.RED_MAPLE_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.SILVER_MAPLE_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.SKYRIS_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.WHITE_CHERRY_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.WILLOW_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.WITCH_HAZEL_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.YELLOW_BIRCH_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.YELLOW_SPRUCE_SAPLING);
        compostibleBlocks(0.3f, BYGItemList.RED_SPRUCE_SAPLING);


        //Flowers
        compostibleBlocks(0.65f, BYGItemList.ALLIUM_FLOWER_BUSH);
        compostibleBlocks(0.65f, BYGItemList.ALPINE_BELLFLOWER);
        compostibleBlocks(0.65f, BYGItemList.AMARANTH);
        compostibleBlocks(0.65f, BYGItemList.ANGELICA);
        compostibleBlocks(0.65f, BYGItemList.AZALEA);
        compostibleBlocks(0.65f, BYGItemList.BEGONIA);
        compostibleBlocks(0.65f, BYGItemList.BISTORT);
        compostibleBlocks(0.65f, BYGItemList.BLACK_ROSE);
        compostibleBlocks(0.65f, BYGItemList.BLUE_SAGE);
        compostibleBlocks(0.65f, BYGItemList.CALIFORNIA_POPPY);
        compostibleBlocks(0.65f, BYGItemList.CROCUS);
        compostibleBlocks(0.65f, BYGItemList.CYAN_AMARANTH);
        compostibleBlocks(0.65f, BYGItemList.CYAN_ROSE);
        compostibleBlocks(0.65f, BYGItemList.CYAN_TULIP);
        compostibleBlocks(0.65f, BYGItemList.DAFFODIL);
        compostibleBlocks(0.65f, BYGItemList.DELPHINIUM);
        compostibleBlocks(0.65f, BYGItemList.FAIRY_SLIPPER);
        compostibleBlocks(0.65f, BYGItemList.FIRECRACKER_FLOWER_BUSH);
        compostibleBlocks(0.65f, BYGItemList.FOXGLOVE);
        compostibleBlocks(0.65f, BYGItemList.GOLDEN_SPINED_CACTUS);
        compostibleBlocks(0.65f, BYGItemList.GREEN_TULIP);
        compostibleBlocks(0.65f, BYGItemList.GUZMANIA);
        compostibleBlocks(0.65f, BYGItemList.INCAN_LILY);
        compostibleBlocks(0.65f, BYGItemList.IRIS);
        compostibleBlocks(0.65f, BYGItemList.JAPANESE_ORCHID);
        compostibleBlocks(0.65f, BYGItemList.KOVAN_FLOWER);
        compostibleBlocks(0.65f, BYGItemList.LAZARUS_BELLFLOWER);
        compostibleBlocks(0.65f, BYGItemList.LOLIPOP_FLOWER);
        compostibleBlocks(0.65f, BYGItemList.MAGENTA_AMARANTH);
        compostibleBlocks(0.65f, BYGItemList.MAGENTA_TULIP);
        compostibleBlocks(0.65f, BYGItemList.ORANGE_DAISY);
        compostibleBlocks(0.65f, BYGItemList.ORSIRIA_ROSE);
        compostibleBlocks(0.65f, BYGItemList.PEACH_LEATHER_FLOWER);
        compostibleBlocks(0.65f, BYGItemList.PINK_ALLIUM);
        compostibleBlocks(0.65f, BYGItemList.PINK_ALLIUM_FLOWER_BUSH);
        compostibleBlocks(0.65f, BYGItemList.PINK_ANEMONE);
        compostibleBlocks(0.65f, BYGItemList.PINK_DAFFODIL);
        compostibleBlocks(0.65f, BYGItemList.PINK_ORCHID);
        compostibleBlocks(0.65f, BYGItemList.PRAIRIE_GRASS);
        compostibleBlocks(0.65f, BYGItemList.PROTEA_FLOWER);
        compostibleBlocks(0.65f, BYGItemList.PURPLE_AMARANTH);
        compostibleBlocks(0.65f, BYGItemList.PURPLE_ORCHID);
        compostibleBlocks(0.65f, BYGItemList.PURPLE_SAGE);
        compostibleBlocks(0.65f, BYGItemList.PURPLE_TULIP);
        compostibleBlocks(0.65f, BYGItemList.RED_CORNFLOWER);
        compostibleBlocks(0.65f, BYGItemList.RED_ORCHID);
        compostibleBlocks(0.65f, BYGItemList.RICHEA);
        compostibleBlocks(0.65f, BYGItemList.ROSE);
        compostibleBlocks(0.65f, BYGItemList.SILVER_VASE_FLOWER);
        compostibleBlocks(0.65f, BYGItemList.SNOWDROPS);
        compostibleBlocks(0.65f, BYGItemList.TORCH_GINGER);
        compostibleBlocks(0.65f, BYGItemList.VIOLET_LEATHER_FLOWER);
        compostibleBlocks(0.65f, BYGItemList.WHITE_ANEMONE);
        compostibleBlocks(0.65f, BYGItemList.WHITE_SAGE);
        compostibleBlocks(0.65f, BYGItemList.WINTER_CYCLAMEN);
        compostibleBlocks(0.65f, BYGItemList.WINTER_ROSE);
        compostibleBlocks(0.65f, BYGItemList.WINTER_SCILLA);
        compostibleBlocks(0.65f, BYGItemList.YELLOW_DAFFODIL);
        compostibleBlocks(0.65f, BYGItemList.YELLOW_TULIP);

        //Mushroom Blocks
        compostibleBlocks(0.85f, BYGItemList.GREEN_MUSHROOM_BLOCK);
        compostibleBlocks(0.85f, BYGItemList.MILKCAP_MUSHROOM_BLOCK);
        compostibleBlocks(0.85f, BYGItemList.BLEWIT_MUSHROOM_BLOCK);
        compostibleBlocks(0.85f, BYGItemList.PUFF_MUSHROOM_BLOCK);
        compostibleBlocks(0.85f, BYGItemList.WHITE_MUSHROOM_STEM);
        compostibleBlocks(0.85f, BYGItemList.BROWN_MUSHROOM_STEM);

        //Foods
        compostibleBlocks(0.65f, BYGItemList.CRIMSON_BERRIES);
        compostibleBlocks(0.65f, BYGItemList.GREEN_APPLE);
        compostibleBlocks(0.65f, BYGItemList.GREEN_MUSHSHROOM);
        compostibleBlocks(0.65f, BYGItemList.BLACK_PUFF);
        compostibleBlocks(0.65f, BYGItemList.WEEPING_MILKCAP);
        compostibleBlocks(0.65f, BYGItemList.WOOD_BLEWIT);

        //Plants
        compostibleBlocks(0.65f, BYGItemList.CATTAIL);
        compostibleBlocks(0.65f, BYGItemList.REEDS);
        compostibleBlocks(0.65f, BYGItemList.HORSEWEED);
        compostibleBlocks(0.65f, BYGItemList.MINI_CACTUS);
        compostibleBlocks(0.65f, BYGItemList.PRICKLY_PEAR_CACTUS);
        compostibleBlocks(0.65f, BYGItemList.WINTER_SUCCULENT);
        compostibleBlocks(0.35f, BYGItemList.SHORT_GRASS);
        compostibleBlocks(0.75f, BYGItemList.POISON_IVY);
        compostibleBlocks(0.65f, BYGItemList.TINY_LILYPADS);

        BYG.LOGGER.info("BYG: Compostible Blocks Added!");
    }
}
