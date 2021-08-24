package corgiaoc.byg.common.properties.vanilla;

import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.mixin.access.ShovelItemAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.IdentityHashMap;
import java.util.Map;

public class BYGPaths {

    public static void addBYGPaths() {
        Map<Block, BlockState> flattenables = new IdentityHashMap<>(ShovelItemAccess.getFlattenables());
        flattenables.put(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.MEADOW_GRASS_PATH.defaultBlockState());
        ShovelItemAccess.setFlattenables(flattenables);
    }
}
