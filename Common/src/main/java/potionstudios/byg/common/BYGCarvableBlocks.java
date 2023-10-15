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
            SCORIA_STONE, LUSH_DIRT, PEAT,
            WAILING_NYLIUM,
            SYTHIAN_NYLIUM, OVERGROWN_CRIMSON_BLACKSTONE, SUBZERO_ASH_BLOCK,
            WARPED_SOUL_SAND, WARPED_SOUL_SOIL, BRIMSTONE,
            QUARTZITE_SAND, EMERALDITE_ORE, AMETRINE_ORE,
            BUDDING_AMETRINE_ORE, CRYPTIC_REDSTONE_ORE, CRYPTIC_STONE,
            MAGMATIC_STONE, CRYPTIC_MAGMA_BLOCK, ETHER_STONE,
            VERMILION_SCULK, IMPARIUS_PHYLIUM, IVIS_PHYLIUM,
            SHULKREN_PHYLIUM, ETHER_PHYLIUM, NIGHTSHADE_PHYLIUM,
            () -> Blocks.MAGMA_BLOCK
        );
    }
}
