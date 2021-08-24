package corgiaoc.byg.common.properties.vanilla;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.mixin.access.HoeItemAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.IdentityHashMap;
import java.util.Map;

public class BYGHoeables {
    public static void hoeablesBYG() {
        BYG.LOGGER.debug("BYG: Adding Hoeable Blocks...");
        Map<Block, BlockState> tillables = new IdentityHashMap<>(HoeItemAccess.getTillables());
        tillables.put(BYGBlocks.MEADOW_GRASSBLOCK, Blocks.FARMLAND.defaultBlockState());
        tillables.put(BYGBlocks.MEADOW_DIRT, Blocks.FARMLAND.defaultBlockState());
        tillables.put(BYGBlocks.PEAT, Blocks.FARMLAND.defaultBlockState());
        HoeItemAccess.setTillables(tillables);
        BYG.LOGGER.info("BYG: Added Hoeable Blocks!");
    }
}

