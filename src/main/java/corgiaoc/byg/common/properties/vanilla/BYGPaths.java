package corgiaoc.byg.common.properties.vanilla;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class BYGPaths {

    public static void addBYGPaths() {
        Map<Block, BlockState> SHOVEL_LOOKUP = new HashMap<>(ShovelItem.FLATTENABLES);
        SHOVEL_LOOKUP.put(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.MEADOW_GRASS_PATH.defaultBlockState());
        ShovelItem.FLATTENABLES = SHOVEL_LOOKUP;
    }
}
