package voronoiaoc.byg.common.properties.vanilla;//package voronoiaoc.byg.common.properties.vanilla;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Map;

//
public class BYGStrippables {
    public static void stripableBlock(Block logBYG, Block strippableBYG) {
        Map<Block, Block> effectiveBlocksSet = Maps.newHashMap(AxeItem.STRIPABLES);
        effectiveBlocksSet.put(logBYG, strippableBYG);
        AxeItem.STRIPABLES = ImmutableMap.copyOf(effectiveBlocksSet);
    }

    public static void stripableLogsBYG() {
        BYG.LOGGER.debug("BYG: Adding stripable Blocks...");
        stripableBlock(BYGBlockList.ASPEN_LOG, BYGBlockList.STRIPPED_ASPEN_LOG);
        stripableBlock(BYGBlockList.BAOBAB_LOG, BYGBlockList.STRIPPED_BAOBAB_LOG);
        stripableBlock(BYGBlockList.BLUE_ENCHANTED_LOG, BYGBlockList.STRIPPED_BLUE_ENCHANTED_LOG);
        stripableBlock(BYGBlockList.CHERRY_LOG, BYGBlockList.STRIPPED_CHERRY_LOG);
        stripableBlock(BYGBlockList.CIKA_LOG, BYGBlockList.STRIPPED_CIKA_LOG);
        stripableBlock(BYGBlockList.CYPRESS_LOG, BYGBlockList.STRIPPED_CYPRESS_LOG);
        stripableBlock(BYGBlockList.EBONY_LOG, BYGBlockList.STRIPPED_EBONY_LOG);
        stripableBlock(BYGBlockList.FIR_LOG, BYGBlockList.STRIPPED_FIR_LOG);
        stripableBlock(BYGBlockList.GREEN_ENCHANTED_LOG, BYGBlockList.STRIPPED_GREEN_ENCHANTED_LOG);
        stripableBlock(BYGBlockList.HOLLY_LOG, BYGBlockList.STRIPPED_HOLLY_LOG);
        stripableBlock(BYGBlockList.JACARANDA_LOG, BYGBlockList.STRIPPED_JACARANDA_LOG);
        stripableBlock(BYGBlockList.MAHOGANY_LOG, BYGBlockList.STRIPPED_MAHOGANY_LOG);
        stripableBlock(BYGBlockList.MANGROVE_LOG, BYGBlockList.STRIPPED_MANGROVE_LOG);
        stripableBlock(BYGBlockList.MAPLE_LOG, BYGBlockList.STRIPPED_MAPLE_LOG);
        stripableBlock(BYGBlockList.PALO_VERDE_LOG, BYGBlockList.STRIPPED_PALO_VERDE_LOG);
        stripableBlock(BYGBlockList.PINE_LOG, BYGBlockList.STRIPPED_PINE_LOG);
        stripableBlock(BYGBlockList.RAINBOW_EUCALYPTUS_LOG, BYGBlockList.STRIPPED_RAINBOW_EUCALYPTUS_LOG);
        stripableBlock(BYGBlockList.REDWOOD_LOG, BYGBlockList.STRIPPED_REDWOOD_LOG);
        stripableBlock(BYGBlockList.SKYRIS_LOG, BYGBlockList.STRIPPED_SKYRIS_LOG);
        stripableBlock(BYGBlockList.WILLOW_LOG, BYGBlockList.STRIPPED_WILLOW_LOG);
        stripableBlock(BYGBlockList.WITCH_HAZEL_LOG, BYGBlockList.STRIPPED_WITCH_HAZEL_LOG);
        stripableBlock(BYGBlockList.ZELKOVA_LOG, BYGBlockList.STRIPPED_ZELKOVA_LOG);
        stripableBlock(BYGBlockList.ASPEN_WOOD, BYGBlockList.STRIPPED_ASPEN_WOOD);
        stripableBlock(BYGBlockList.BAOBAB_WOOD, BYGBlockList.STRIPPED_BAOBAB_WOOD);
        stripableBlock(BYGBlockList.BLUE_ENCHANTED_WOOD, BYGBlockList.STRIPPED_BLUE_ENCHANTED_WOOD);
        stripableBlock(BYGBlockList.CHERRY_WOOD, BYGBlockList.STRIPPED_CHERRY_WOOD);
        stripableBlock(BYGBlockList.CIKA_WOOD, BYGBlockList.STRIPPED_CIKA_WOOD);
        stripableBlock(BYGBlockList.CYPRESS_WOOD, BYGBlockList.STRIPPED_CYPRESS_WOOD);
        stripableBlock(BYGBlockList.EBONY_WOOD, BYGBlockList.STRIPPED_EBONY_WOOD);
        stripableBlock(BYGBlockList.FIR_WOOD, BYGBlockList.STRIPPED_FIR_WOOD);
        stripableBlock(BYGBlockList.GREEN_ENCHANTED_WOOD, BYGBlockList.STRIPPED_GREEN_ENCHANTED_WOOD);
        stripableBlock(BYGBlockList.HOLLY_WOOD, BYGBlockList.STRIPPED_HOLLY_WOOD);
        stripableBlock(BYGBlockList.JACARANDA_WOOD, BYGBlockList.STRIPPED_JACARANDA_WOOD);
        stripableBlock(BYGBlockList.MAHOGANY_WOOD, BYGBlockList.STRIPPED_MAHOGANY_WOOD);
        stripableBlock(BYGBlockList.MANGROVE_WOOD, BYGBlockList.STRIPPED_MANGROVE_WOOD);
        stripableBlock(BYGBlockList.MAPLE_WOOD, BYGBlockList.STRIPPED_MAPLE_WOOD);
        stripableBlock(BYGBlockList.PALO_VERDE_WOOD, BYGBlockList.STRIPPED_PALO_VERDE_WOOD);
        stripableBlock(BYGBlockList.PINE_WOOD, BYGBlockList.STRIPPED_PINE_WOOD);
        stripableBlock(BYGBlockList.RAINBOW_EUCALYPTUS_WOOD, BYGBlockList.STRIPPED_RAINBOW_EUCALYPTUS_WOOD);
        stripableBlock(BYGBlockList.REDWOOD_WOOD, BYGBlockList.STRIPPED_REDWOOD_WOOD);
        stripableBlock(BYGBlockList.SKYRIS_WOOD, BYGBlockList.STRIPPED_SKYRIS_WOOD);
        stripableBlock(BYGBlockList.WILLOW_WOOD, BYGBlockList.STRIPPED_WILLOW_WOOD);
        stripableBlock(BYGBlockList.WITCH_HAZEL_WOOD, BYGBlockList.STRIPPED_WITCH_HAZEL_WOOD);
        stripableBlock(BYGBlockList.ZELKOVA_WOOD, BYGBlockList.STRIPPED_ZELKOVA_WOOD);

        BYG.LOGGER.info("BYG: Added stripable Blocks!");
    }
}
