package potionstudios.byg.common;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.common.block.BYGBlocks;

import java.util.Set;

public class BYGCarvableBlocks {

    @SuppressWarnings("deprecation")
    public static Set<Block> addCarverBlocks() {
        return ImmutableSet.of(BYGBlocks.OVERGROWN_DACITE, BYGBlocks.PODZOL_DACITE, BYGBlocks.SOAPSTONE, BYGBlocks.ROCKY_STONE, BYGBlocks.MOSSY_STONE, BYGBlocks.OVERGROWN_STONE, BYGBlocks.SCORIA_STONE, BYGBlocks.LUSH_DIRT, BYGBlocks.PEAT);
    }
}
