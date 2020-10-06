package corgiaoc.byg.common.properties.vanilla;

import com.google.common.collect.Maps;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.HoeItem;
import corgiaoc.byg.BYG;

public class BYGHoeables {
    public static void hoeableBlock(Block hoeableblockBYG, BlockState farmlandBYG) {
        HoeItem.HOE_LOOKUP = Maps.newHashMap(HoeItem.HOE_LOOKUP);
        HoeItem.HOE_LOOKUP.put(hoeableblockBYG, farmlandBYG);
    }

    public static void hoeablesBYG() {
        BYG.LOGGER.debug("BYG: Adding Hoeable Blocks...");

        hoeableBlock(BYGBlocks.OVERGROWN_STONE, Blocks.FARMLAND.getDefaultState());
        hoeableBlock(BYGBlocks.OVERGROWN_DACITE, Blocks.FARMLAND.getDefaultState());
        hoeableBlock(BYGBlocks.PODZOL_DACITE, Blocks.FARMLAND.getDefaultState());
        hoeableBlock(BYGBlocks.MEADOW_GRASSBLOCK, Blocks.FARMLAND.getDefaultState());
        hoeableBlock(BYGBlocks.MEADOW_DIRT, Blocks.FARMLAND.getDefaultState());
        hoeableBlock(BYGBlocks.PEAT, Blocks.FARMLAND.getDefaultState());

        BYG.LOGGER.info("BYG: Added Hoeable Blocks!");
    }
}

