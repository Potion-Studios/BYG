package potionstudios.byg.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import potionstudios.byg.util.lazy.LazyCollection;

import java.util.stream.Collectors;

import static potionstudios.byg.common.block.BYGBlocks.*;

public class BYGCarvableBlocks {

    public static LazyCollection<Block> addCarverBlocks() {
        return LazyCollection.of(
            Collectors.toSet(),
            OVERGROWN_DACITE, PODZOL_DACITE, SOAPSTONE,
            ROCKY_STONE, MOSSY_STONE, OVERGROWN_STONE,
            LUSH_DIRT, PEAT,
            WAILING_NYLIUM,
            SYTHIAN_NYLIUM,
            WARPED_SOUL_SAND, WARPED_SOUL_SOIL, BRIMSTONE,
            QUARTZITE_SAND, AMETRINE_ORE,
            BUDDING_AMETRINE_ORE, CRYPTIC_REDSTONE_ORE, CRYPTIC_STONE,
            MAGMATIC_STONE, CRYPTIC_MAGMA_BLOCK, ETHER_STONE,
            VERMILION_SCULK, IMPARIUS_PHYLIUM, IVIS_PHYLIUM,
            ETHER_PHYLIUM, NIGHTSHADE_PHYLIUM,
            () -> Blocks.MAGMA_BLOCK
        );
    }
}
