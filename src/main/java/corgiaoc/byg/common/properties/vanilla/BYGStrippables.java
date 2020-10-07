package corgiaoc.byg.common.properties.vanilla;

import com.google.common.collect.Maps;
import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.AxeItem;

public class BYGStrippables {
    public static void strippableBlock(Block logBYG, Block strippableBYG) {
        AxeItem.BLOCK_STRIPPING_MAP = Maps.newHashMap(AxeItem.BLOCK_STRIPPING_MAP);
        AxeItem.BLOCK_STRIPPING_MAP.put(logBYG, strippableBYG);
    }

    public static void strippableLogsBYG() {
        BYG.LOGGER.debug("BYG: Adding strippable Blocks...");

        strippableBlock(BYGBlocks.ASPEN_LOG, BYGBlocks.STRIPPED_ASPEN_LOG);
        strippableBlock(BYGBlocks.BAOBAB_LOG, BYGBlocks.STRIPPED_BAOBAB_LOG);
        strippableBlock(BYGBlocks.BLUE_ENCHANTED_LOG, BYGBlocks.STRIPPED_BLUE_ENCHANTED_LOG);
        strippableBlock(BYGBlocks.CHERRY_LOG, BYGBlocks.STRIPPED_CHERRY_LOG);
        strippableBlock(BYGBlocks.CIKA_LOG, BYGBlocks.STRIPPED_CIKA_LOG);
        strippableBlock(BYGBlocks.CYPRESS_LOG, BYGBlocks.STRIPPED_CYPRESS_LOG);
        strippableBlock(BYGBlocks.EBONY_LOG, BYGBlocks.STRIPPED_EBONY_LOG);
        strippableBlock(BYGBlocks.FIR_LOG, BYGBlocks.STRIPPED_FIR_LOG);
        strippableBlock(BYGBlocks.GREEN_ENCHANTED_LOG, BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG);
        strippableBlock(BYGBlocks.HOLLY_LOG, BYGBlocks.STRIPPED_HOLLY_LOG);
        strippableBlock(BYGBlocks.JACARANDA_LOG, BYGBlocks.STRIPPED_JACARANDA_LOG);
        strippableBlock(BYGBlocks.MAHOGANY_LOG, BYGBlocks.STRIPPED_MAHOGANY_LOG);
        strippableBlock(BYGBlocks.MANGROVE_LOG, BYGBlocks.STRIPPED_MANGROVE_LOG);
        strippableBlock(BYGBlocks.MAPLE_LOG, BYGBlocks.STRIPPED_MAPLE_LOG);
        strippableBlock(BYGBlocks.PALO_VERDE_LOG, BYGBlocks.STRIPPED_PALO_VERDE_LOG);
        strippableBlock(BYGBlocks.PINE_LOG, BYGBlocks.STRIPPED_PINE_LOG);
        strippableBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LOG, BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG);
        strippableBlock(BYGBlocks.REDWOOD_LOG, BYGBlocks.STRIPPED_REDWOOD_LOG);
        strippableBlock(BYGBlocks.SKYRIS_LOG, BYGBlocks.STRIPPED_SKYRIS_LOG);
        strippableBlock(BYGBlocks.WILLOW_LOG, BYGBlocks.STRIPPED_WILLOW_LOG);
        strippableBlock(BYGBlocks.WITCH_HAZEL_LOG, BYGBlocks.STRIPPED_WITCH_HAZEL_LOG);
        strippableBlock(BYGBlocks.ZELKOVA_LOG, BYGBlocks.STRIPPED_ZELKOVA_LOG);
        strippableBlock(BYGBlocks.SYTHIAN_STEM, BYGBlocks.STRIPPED_SYTHIAN_STEM);
        strippableBlock(BYGBlocks.PALM_LOG, BYGBlocks.STRIPPED_PALM_LOG);
        strippableBlock(BYGBlocks.LAMENT_LOG, BYGBlocks.STRIPPED_LAMENT_LOG);
        strippableBlock(BYGBlocks.WITHERING_OAK_LOG, Blocks.STRIPPED_OAK_LOG);

        strippableBlock(BYGBlocks.ASPEN_WOOD, BYGBlocks.STRIPPED_ASPEN_WOOD);
        strippableBlock(BYGBlocks.BAOBAB_WOOD, BYGBlocks.STRIPPED_BAOBAB_WOOD);
        strippableBlock(BYGBlocks.BLUE_ENCHANTED_WOOD, BYGBlocks.STRIPPED_BLUE_ENCHANTED_WOOD);
        strippableBlock(BYGBlocks.CHERRY_WOOD, BYGBlocks.STRIPPED_CHERRY_WOOD);
        strippableBlock(BYGBlocks.CIKA_WOOD, BYGBlocks.STRIPPED_CIKA_WOOD);
        strippableBlock(BYGBlocks.CYPRESS_WOOD, BYGBlocks.STRIPPED_CYPRESS_WOOD);
        strippableBlock(BYGBlocks.EBONY_WOOD, BYGBlocks.STRIPPED_EBONY_WOOD);
        strippableBlock(BYGBlocks.FIR_WOOD, BYGBlocks.STRIPPED_FIR_WOOD);
        strippableBlock(BYGBlocks.GREEN_ENCHANTED_WOOD, BYGBlocks.STRIPPED_GREEN_ENCHANTED_WOOD);
        strippableBlock(BYGBlocks.HOLLY_WOOD, BYGBlocks.STRIPPED_HOLLY_WOOD);
        strippableBlock(BYGBlocks.JACARANDA_WOOD, BYGBlocks.STRIPPED_JACARANDA_WOOD);
        strippableBlock(BYGBlocks.MAHOGANY_WOOD, BYGBlocks.STRIPPED_MAHOGANY_WOOD);
        strippableBlock(BYGBlocks.MANGROVE_WOOD, BYGBlocks.STRIPPED_MANGROVE_WOOD);
        strippableBlock(BYGBlocks.MAPLE_WOOD, BYGBlocks.STRIPPED_MAPLE_WOOD);
        strippableBlock(BYGBlocks.PALO_VERDE_WOOD, BYGBlocks.STRIPPED_PALO_VERDE_WOOD);
        strippableBlock(BYGBlocks.PINE_WOOD, BYGBlocks.STRIPPED_PINE_WOOD);
        strippableBlock(BYGBlocks.RAINBOW_EUCALYPTUS_WOOD, BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD);
        strippableBlock(BYGBlocks.REDWOOD_WOOD, BYGBlocks.STRIPPED_REDWOOD_WOOD);
        strippableBlock(BYGBlocks.SKYRIS_WOOD, BYGBlocks.STRIPPED_SKYRIS_WOOD);
        strippableBlock(BYGBlocks.WILLOW_WOOD, BYGBlocks.STRIPPED_WILLOW_WOOD);
        strippableBlock(BYGBlocks.WITCH_HAZEL_WOOD, BYGBlocks.STRIPPED_WITCH_HAZEL_WOOD);
        strippableBlock(BYGBlocks.ZELKOVA_WOOD, BYGBlocks.STRIPPED_ZELKOVA_WOOD);
        strippableBlock(BYGBlocks.SYTHIAN_HYPHAE, BYGBlocks.STRIPPED_SYTHIAN_HYPHAE);
        strippableBlock(BYGBlocks.PALM_WOOD, BYGBlocks.STRIPPED_PALM_WOOD);
        strippableBlock(BYGBlocks.LAMENT_WOOD, BYGBlocks.STRIPPED_LAMENT_WOOD);
        strippableBlock(BYGBlocks.WITHERING_OAK_WOOD, Blocks.STRIPPED_OAK_WOOD);

        BYG.LOGGER.info("BYG: Added strippable Blocks...");

    }
}
