package potionstudios.byg.common;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Set;

import static potionstudios.byg.common.block.BYGBlocks.*;

public class BYGCarvableBlocks {

    @SuppressWarnings("deprecation")
    public static Set<Block> addCarverBlocks() {
        return ImmutableSet.of(
            OVERGROWN_DACITE, PODZOL_DACITE, SOAPSTONE,
            ROCKY_STONE, MOSSY_STONE, OVERGROWN_STONE,
            SCORIA_STONE, LUSH_DIRT, PEAT,
            OVERGROWN_NETHERRACK, PERVADED_NETHERRACK, BLUE_NETHERRACK,
            MYCELIUM_NETHERRACK, EMBUR_NYLIUM, WAILING_NYLIUM,
            SYTHIAN_NYLIUM, OVERGROWN_CRIMSON_BLACKSTONE, SUBZERO_ASH_BLOCK,
            WARPED_SOUL_SAND, WARPED_SOUL_SOIL, BRIMSTONE,
            QUARTZITE_SAND, BLUE_NETHER_QUARTZ_ORE, BLUE_NETHER_GOLD_ORE,
            EMERALDITE_ORE, PENDORITE_ORE, AMETRINE_ORE,
            BUDDING_AMETRINE_ORE, CRYPTIC_REDSTONE_ORE, CRYPTIC_STONE,
            MAGMATIC_STONE, CRYPTIC_MAGMA_BLOCK, ETHER_STONE,
            VERMILION_SCULK, IMPARIUS_PHYLIUM, IVIS_PHYLIUM,
            SHULKREN_PHYLIUM, ETHER_PHYLIUM, NIGHTSHADE_PHYLIUM,
            Blocks.MAGMA_BLOCK
        );
    }
}
