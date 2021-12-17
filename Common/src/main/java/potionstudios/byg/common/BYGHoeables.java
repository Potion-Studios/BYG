package potionstudios.byg.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.LushFarmBlock;
import potionstudios.byg.mixin.access.HoeItemAccess;

import java.util.IdentityHashMap;
import java.util.Map;

public class BYGHoeables {
    public static void hoeablesBYG() {
        BYG.LOGGER.debug("BYG: Adding Hoeable Blocks...");
        Map<Block, BlockState> tillables = new IdentityHashMap<>(HoeItemAccess.getTillables());
        tillables.put(BYGBlocks.LUSH_GRASS_BLOCK, BYGBlocks.LUSH_FARMLAND.defaultBlockState().setValue(LushFarmBlock.MOISTURE,7));
        tillables.put(BYGBlocks.LUSH_DIRT, BYGBlocks.LUSH_FARMLAND.defaultBlockState().setValue(LushFarmBlock.MOISTURE,7));
        tillables.put(BYGBlocks.PEAT, Blocks.FARMLAND.defaultBlockState());
        HoeItemAccess.setTillables(tillables);
        BYG.LOGGER.info("BYG: Added Hoeable Blocks!");
    }
}

