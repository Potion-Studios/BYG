package corgiaoc.byg.common.properties.vanilla;

import com.google.common.collect.Maps;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class BYGPaths {

    public static void addBYGPaths() {
        Map<Block, BlockState> SHOVEL_LOOKUP = new HashMap<>(ShovelItem.SHOVEL_LOOKUP);
        SHOVEL_LOOKUP.put(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.MEADOW_GRASS_PATH.getDefaultState());
        ShovelItem.SHOVEL_LOOKUP = SHOVEL_LOOKUP;
    }
}
