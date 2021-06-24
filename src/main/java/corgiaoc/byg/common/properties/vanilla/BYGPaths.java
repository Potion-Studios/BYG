package corgiaoc.byg.common.properties.vanilla;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class BYGPaths {

    public static void addBYGPaths() {
        Map<Block, BlockState> SHOVEL_LOOKUP = new HashMap<>(ShovelItem.PATH_STATES);
        SHOVEL_LOOKUP.put(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.MEADOW_DIRT_PATH.getDefaultState());
        ShovelItem.PATH_STATES = SHOVEL_LOOKUP;
    }
}
