package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.OreBlock;

import java.util.Random;

public class BYGOreBlock extends OreBlock {

    public BYGOreBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected int xpOnDrop(Random rand) {
        if (this == BYGBlocks.AMETRINE_ORE) {
            return Mth.nextInt(rand, 3, 9);
        } else if (this == BYGBlocks.ANTHRACITE_ORE) {
            return Mth.nextInt(rand, 2, 5);
        } else if (this == BYGBlocks.CRYPTIC_REDSTONE_ORE) {
            return Mth.nextInt(rand, 3, 7);
        } else if (this == BYGBlocks.BLUE_NETHER_GOLD_ORE) {
            return Mth.nextInt(rand, 0, 1);
        } else if (this == BYGBlocks.BLUE_NETHER_QUARTZ_ORE) {
            return Mth.nextInt(rand, 2, 5);
        } else if (this == BYGBlocks.BRIMSTONE_NETHER_GOLD_ORE) {
            return Mth.nextInt(rand, 0, 1);
        } else if (this == BYGBlocks.BRIMSTONE_NETHER_QUARTZ_ORE) {
            return Mth.nextInt(rand, 2, 5);
        } else if (this == BYGBlocks.BUDDING_AMETRINE_ORE) {
            return Mth.nextInt(rand, 3, 9);
        } else {
            return this == BYGBlocks.EMERALDITE_ORE ? Mth.nextInt(rand, 4, 7) : 0;
        }
    }
}
