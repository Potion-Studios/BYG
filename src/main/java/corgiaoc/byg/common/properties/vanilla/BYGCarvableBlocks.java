package corgiaoc.byg.common.properties.vanilla;

import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.mixin.access.WorldCarverAccess;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

import java.util.HashSet;
import java.util.Set;

public class BYGCarvableBlocks {

    @SuppressWarnings("deprecation")
    public static void addCarverBlocks() {
        for (WorldCarver<?> worldCarver : Registry.CARVER) {
            Set<Block> blocks = new HashSet<>(((WorldCarverAccess) worldCarver).getReplaceableBlocks());
            blocks.add(BYGBlocks.OVERGROWN_DACITE);
            blocks.add(BYGBlocks.PODZOL_DACITE);
            blocks.add(BYGBlocks.SOAPSTONE);
            blocks.add(BYGBlocks.ROCKY_STONE);
            blocks.add(BYGBlocks.MOSSY_STONE);
            blocks.add(BYGBlocks.OVERGROWN_STONE);
            blocks.add(BYGBlocks.SCORIA_STONE);
            blocks.add(BYGBlocks.MEADOW_DIRT);
            blocks.add(BYGBlocks.PEAT);
            ((WorldCarverAccess) worldCarver).setReplaceableBlocks(blocks);
        }
    }
}
