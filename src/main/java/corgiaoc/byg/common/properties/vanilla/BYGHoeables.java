package corgiaoc.byg.common.properties.vanilla;

import com.google.common.collect.Maps;
import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.HoeItem;

public class BYGHoeables {
    public static void hoeableBlock(Block hoeableblockBYG, BlockState farmlandBYG) {
        HoeItem.TILLABLES = Maps.newHashMap(HoeItem.TILLABLES);
        HoeItem.TILLABLES.put(hoeableblockBYG, farmlandBYG);
    }

    public static void hoeablesBYG() {
        BYG.LOGGER.debug("BYG: Adding Hoeable Blocks...");
        hoeableBlock(BYGBlocks.MEADOW_GRASSBLOCK, Blocks.FARMLAND.defaultBlockState());
        hoeableBlock(BYGBlocks.MEADOW_DIRT, Blocks.FARMLAND.defaultBlockState());
        hoeableBlock(BYGBlocks.PEAT, Blocks.FARMLAND.defaultBlockState());
        BYG.LOGGER.info("BYG: Added Hoeable Blocks!");
    }
}

