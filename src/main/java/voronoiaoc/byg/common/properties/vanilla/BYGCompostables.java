package voronoiaoc.byg.common.properties.vanilla;//package voronoiaoc.byg.common.properties.vanilla;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.world.item.Item;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGItemList;


public class BYGCompostables {
    public static void compostablesBYG() {
        BYG.LOGGER.debug("BYG: Adding Compostible Blocks...");

        //Leaves
        addCompostables(0.3f, BYGItemList.ASPEN_LEAVES);
        addCompostables(0.3f, BYGItemList.BAOBAB_LEAVES);
        addCompostables(0.3f, BYGItemList.BLOOMING_WITCH_HAZEL_LEAVES);
        addCompostables(0.3f, BYGItemList.BLUE_ENCHANTED_LEAVES);
        addCompostables(0.3f, BYGItemList.BLUE_SPRUCE_LEAVES);
        addCompostables(0.3f, BYGItemList.BROWN_BIRCH_LEAVES);
        addCompostables(0.3f, BYGItemList.BROWN_OAK_LEAVES);
        addCompostables(0.3f, BYGItemList.CIKA_LEAVES);
        addCompostables(0.3f, BYGItemList.CYPRESS_LEAVES);
        addCompostables(0.3f, BYGItemList.EBONY_LEAVES);
        addCompostables(0.3f, BYGItemList.FIR_LEAVES);
        addCompostables(0.3f, BYGItemList.FLOWERING_ORCHARD_LEAVES);
        addCompostables(0.3f, BYGItemList.FLOWERING_PALO_VERDE_LEAVES);
        addCompostables(0.3f, BYGItemList.GREEN_ENCHANTED_LEAVES);
        addCompostables(0.3f, BYGItemList.HOLLY_BERRY_LEAVES);
        addCompostables(0.3f, BYGItemList.HOLLY_LEAVES);
        addCompostables(0.3f, BYGItemList.JACARANDA_LEAVES);
        addCompostables(0.3f, BYGItemList.MAHOGANY_LEAVES);
        addCompostables(0.3f, BYGItemList.MANGROVE_LEAVES);
        addCompostables(0.3f, BYGItemList.ORANGE_BIRCH_LEAVES);
        addCompostables(0.3f, BYGItemList.ORANGE_OAK_LEAVES);
        addCompostables(0.3f, BYGItemList.ORANGE_SPRUCE_LEAVES);
        addCompostables(0.3f, BYGItemList.ORCHARD_LEAVES);
        addCompostables(0.3f, BYGItemList.PALO_VERDE_LEAVES);
        addCompostables(0.3f, BYGItemList.PINE_LEAVES);
        addCompostables(0.3f, BYGItemList.PINK_CHERRY_LEAVES);
        addCompostables(0.3f, BYGItemList.RAINBOW_EUCALYPTUS_LEAVES);
        addCompostables(0.3f, BYGItemList.REDWOOD_LEAVES);
        addCompostables(0.3f, BYGItemList.RED_MAPLE_LEAVES);
        addCompostables(0.6f, BYGItemList.RIPE_ORCHARD_LEAVES);
        addCompostables(0.3f, BYGItemList.SILVER_MAPLE_LEAVES);
        addCompostables(0.6f, BYGItemList.SKYRIS_LEAVES_GREEN_APPLE);
        addCompostables(0.3f, BYGItemList.SKYRIS_LEAVES);
        addCompostables(0.3f, BYGItemList.WHITE_CHERRY_LEAVES);
        addCompostables(0.3f, BYGItemList.WILLOW_LEAVES);
        addCompostables(0.3f, BYGItemList.WITCH_HAZEL_LEAVES);
        addCompostables(0.3f, BYGItemList.YELLOW_BIRCH_LEAVES);
        addCompostables(0.3f, BYGItemList.YELLOW_SPRUCE_LEAVES);
        addCompostables(0.3f, BYGItemList.RED_SPRUCE_LEAVES);

        //Saplings
        addCompostables(0.3f, BYGItemList.ASPEN_SAPLING);
        addCompostables(0.3f, BYGItemList.BAOBAB_SAPLING);
        addCompostables(0.3f, BYGItemList.BLUE_ENCHANTED_SAPLING);
        addCompostables(0.3f, BYGItemList.BLUE_SPRUCE_SAPLING);
        addCompostables(0.3f, BYGItemList.BROWN_BIRCH_SAPLING);
        addCompostables(0.3f, BYGItemList.BROWN_OAK_SAPLING);
        addCompostables(0.3f, BYGItemList.CIKA_SAPLING);
        addCompostables(0.3f, BYGItemList.CYPRESS_SAPLING);
        addCompostables(0.3f, BYGItemList.EBONY_SAPLING);
        addCompostables(0.3f, BYGItemList.FIR_SAPLING);
        addCompostables(0.3f, BYGItemList.GREEN_ENCHANTED_SAPLING);
        addCompostables(0.3f, BYGItemList.HOLLY_SAPLING);
        addCompostables(0.3f, BYGItemList.JACARANDA_SAPLING);
        addCompostables(0.3f, BYGItemList.MAHOGANY_SAPLING);
        addCompostables(0.3f, BYGItemList.MANGROVE_SAPLING);
        addCompostables(0.3f, BYGItemList.ORANGE_BIRCH_SAPLING);
        addCompostables(0.3f, BYGItemList.ORANGE_OAK_SAPLING);
        addCompostables(0.3f, BYGItemList.ORANGE_SPRUCE_SAPLING);
        addCompostables(0.3f, BYGItemList.ORCHARD_SAPLING);
        addCompostables(0.3f, BYGItemList.PALO_VERDE_SAPLING);
        addCompostables(0.3f, BYGItemList.PINE_SAPLING);
        addCompostables(0.3f, BYGItemList.PINK_CHERRY_SAPLING);
        addCompostables(0.3f, BYGItemList.RAINBOW_EUCALYPTUS_SAPLING);
        addCompostables(0.3f, BYGItemList.REDWOOD_SAPLING);
        addCompostables(0.3f, BYGItemList.RED_MAPLE_SAPLING);
        addCompostables(0.3f, BYGItemList.SILVER_MAPLE_SAPLING);
        addCompostables(0.3f, BYGItemList.SKYRIS_SAPLING);
        addCompostables(0.3f, BYGItemList.WHITE_CHERRY_SAPLING);
        addCompostables(0.3f, BYGItemList.WILLOW_SAPLING);
        addCompostables(0.3f, BYGItemList.WITCH_HAZEL_SAPLING);
        addCompostables(0.3f, BYGItemList.YELLOW_BIRCH_SAPLING);
        addCompostables(0.3f, BYGItemList.YELLOW_SPRUCE_SAPLING);
        addCompostables(0.3f, BYGItemList.RED_SPRUCE_SAPLING);


        //Flowers
        addCompostables(0.65f, BYGItemList.ALLIUM_FLOWER_BUSH);
        addCompostables(0.65f, BYGItemList.ALPINE_BELLFLOWER);
        addCompostables(0.65f, BYGItemList.AMARANTH);
        addCompostables(0.65f, BYGItemList.ANGELICA);
        addCompostables(0.65f, BYGItemList.AZALEA);
        addCompostables(0.65f, BYGItemList.BEGONIA);
        addCompostables(0.65f, BYGItemList.BISTORT);
        addCompostables(0.65f, BYGItemList.BLACK_ROSE);
        addCompostables(0.65f, BYGItemList.BLUE_SAGE);
        addCompostables(0.65f, BYGItemList.CALIFORNIA_POPPY);
        addCompostables(0.65f, BYGItemList.CROCUS);
        addCompostables(0.65f, BYGItemList.CYAN_AMARANTH);
        addCompostables(0.65f, BYGItemList.CYAN_ROSE);
        addCompostables(0.65f, BYGItemList.CYAN_TULIP);
        addCompostables(0.65f, BYGItemList.DAFFODIL);
        addCompostables(0.65f, BYGItemList.DELPHINIUM);
        addCompostables(0.65f, BYGItemList.FAIRY_SLIPPER);
        addCompostables(0.65f, BYGItemList.FIRECRACKER_FLOWER_BUSH);
        addCompostables(0.65f, BYGItemList.FOXGLOVE);
        addCompostables(0.65f, BYGItemList.GOLDEN_SPINED_CACTUS);
        addCompostables(0.65f, BYGItemList.GREEN_TULIP);
        addCompostables(0.65f, BYGItemList.GUZMANIA);
        addCompostables(0.65f, BYGItemList.INCAN_LILY);
        addCompostables(0.65f, BYGItemList.IRIS);
        addCompostables(0.65f, BYGItemList.JAPANESE_ORCHID);
        addCompostables(0.65f, BYGItemList.KOVAN_FLOWER);
        addCompostables(0.65f, BYGItemList.LAZARUS_BELLFLOWER);
        addCompostables(0.65f, BYGItemList.LOLIPOP_FLOWER);
        addCompostables(0.65f, BYGItemList.MAGENTA_AMARANTH);
        addCompostables(0.65f, BYGItemList.MAGENTA_TULIP);
        addCompostables(0.65f, BYGItemList.ORANGE_DAISY);
        addCompostables(0.65f, BYGItemList.ORSIRIA_ROSE);
        addCompostables(0.65f, BYGItemList.PEACH_LEATHER_FLOWER);
        addCompostables(0.65f, BYGItemList.PINK_ALLIUM);
        addCompostables(0.65f, BYGItemList.PINK_ALLIUM_FLOWER_BUSH);
        addCompostables(0.65f, BYGItemList.PINK_ANEMONE);
        addCompostables(0.65f, BYGItemList.PINK_DAFFODIL);
        addCompostables(0.65f, BYGItemList.PINK_ORCHID);
        addCompostables(0.65f, BYGItemList.PRAIRIE_GRASS);
        addCompostables(0.65f, BYGItemList.PROTEA_FLOWER);
        addCompostables(0.65f, BYGItemList.PURPLE_AMARANTH);
        addCompostables(0.65f, BYGItemList.PURPLE_ORCHID);
        addCompostables(0.65f, BYGItemList.PURPLE_SAGE);
        addCompostables(0.65f, BYGItemList.PURPLE_TULIP);
        addCompostables(0.65f, BYGItemList.RED_CORNFLOWER);
        addCompostables(0.65f, BYGItemList.RED_ORCHID);
        addCompostables(0.65f, BYGItemList.RICHEA);
        addCompostables(0.65f, BYGItemList.ROSE);
        addCompostables(0.65f, BYGItemList.SILVER_VASE_FLOWER);
        addCompostables(0.65f, BYGItemList.SNOWDROPS);
        addCompostables(0.65f, BYGItemList.TORCH_GINGER);
        addCompostables(0.65f, BYGItemList.VIOLET_LEATHER_FLOWER);
        addCompostables(0.65f, BYGItemList.WHITE_ANEMONE);
        addCompostables(0.65f, BYGItemList.WHITE_SAGE);
        addCompostables(0.65f, BYGItemList.WINTER_CYCLAMEN);
        addCompostables(0.65f, BYGItemList.WINTER_ROSE);
        addCompostables(0.65f, BYGItemList.WINTER_SCILLA);
        addCompostables(0.65f, BYGItemList.YELLOW_DAFFODIL);
        addCompostables(0.65f, BYGItemList.YELLOW_TULIP);

        //Mushroom BYGBlockRenders
        addCompostables(0.85f, BYGItemList.GREEN_MUSHROOM_BLOCK);
        addCompostables(0.85f, BYGItemList.MILKCAP_MUSHROOM_BLOCK);
        addCompostables(0.85f, BYGItemList.BLEWIT_MUSHROOM_BLOCK);
        addCompostables(0.85f, BYGItemList.PUFF_MUSHROOM_BLOCK);
        addCompostables(0.85f, BYGItemList.WHITE_MUSHROOM_STEM);
        addCompostables(0.85f, BYGItemList.BROWN_MUSHROOM_STEM);

        //Foods
        addCompostables(0.65f, BYGItemList.GREEN_APPLE);
        addCompostables(0.65f, BYGItemList.GREEN_MUSHSHROOM);
        addCompostables(0.65f, BYGItemList.BLACK_PUFF);
        addCompostables(0.65f, BYGItemList.WEEPING_MILKCAP);
        addCompostables(0.65f, BYGItemList.WOOD_BLEWIT);

        //Plants
        addCompostables(0.65f, BYGItemList.CATTAIL);
        addCompostables(0.65f, BYGItemList.REEDS);
        addCompostables(0.65f, BYGItemList.HORSEWEED);
        addCompostables(0.65f, BYGItemList.MINI_CACTUS);
        addCompostables(0.65f, BYGItemList.PRICKLY_PEAR_CACTUS);
        addCompostables(0.65f, BYGItemList.WINTER_SUCCULENT);
        addCompostables(0.35f, BYGItemList.SHORT_GRASS);
        addCompostables(0.75f, BYGItemList.POISON_IVY);
        addCompostables(0.65f, BYGItemList.TINY_LILYPADS);
    }

    public static void addCompostables(float value, Item item) {
        CompostingChanceRegistry addCompostables = CompostingChanceRegistry.INSTANCE;
        addCompostables.add(item, value);
    }
}
