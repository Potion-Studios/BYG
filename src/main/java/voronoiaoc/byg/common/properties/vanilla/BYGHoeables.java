package voronoiaoc.byg.common.properties.vanilla;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.HoeItem;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGBlockList;

public class BYGHoeables {
    public static void hoeableBlock(Block hoeableblockBYG, BlockState farmlandBYG) {
        HoeItem.HOE_LOOKUP = Maps.newHashMap(HoeItem.HOE_LOOKUP);
        HoeItem.HOE_LOOKUP.put(hoeableblockBYG, farmlandBYG);
    }

    public static void hoeablesBYG() {
        BYG.LOGGER.debug("BYG: Adding Hoeable Blocks...");

        hoeableBlock(BYGBlockList.OVERGROWN_STONE, Blocks.FARMLAND.getDefaultState());
        hoeableBlock(BYGBlockList.OVERGROWN_DACITE, Blocks.FARMLAND.getDefaultState());
        hoeableBlock(BYGBlockList.PODZOL_DACITE, Blocks.FARMLAND.getDefaultState());
        hoeableBlock(BYGBlockList.MEADOW_GRASSBLOCK, Blocks.FARMLAND.getDefaultState());
        hoeableBlock(BYGBlockList.MEADOW_DIRT, Blocks.FARMLAND.getDefaultState());
        hoeableBlock(BYGBlockList.PEAT, Blocks.FARMLAND.getDefaultState());

        BYG.LOGGER.info("BYG: Added Hoeable Blocks!");
    }
}

