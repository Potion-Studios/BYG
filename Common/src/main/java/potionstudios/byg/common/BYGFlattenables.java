package potionstudios.byg.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.mixin.access.ShovelItemAccess;

import java.util.IdentityHashMap;
import java.util.Map;

public class BYGFlattenables {

    public static void addFlattenables() {
        Map<Block, BlockState> flattenables = new IdentityHashMap<>(ShovelItemAccess.byg_getFLATTENABLES());
        flattenables.put(BYGBlocks.LUSH_GRASS_BLOCK, BYGBlocks.LUSH_GRASS_PATH.defaultBlockState());
        flattenables.put(BYGBlocks.LUSH_DIRT, BYGBlocks.LUSH_GRASS_PATH.defaultBlockState());
        ShovelItemAccess.byg_setFLATTENABLES(flattenables);
    }
}
