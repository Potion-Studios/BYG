package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class BYGOreBlock extends OreBlock {

    public BYGOreBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    protected int getExperienceWhenMined(Random p_220281_1_) {
        if (this == BYGBlocks.AMETRINE_ORE) {
            return MathHelper.nextInt(p_220281_1_, 3, 9);
        } else if (this == BYGBlocks.ANTHRACITE_ORE) {
            return MathHelper.nextInt(p_220281_1_, 2, 5);
        } else if (this == Blocks.EMERALD_ORE) {
            return MathHelper.nextInt(p_220281_1_, 3, 7);
        } else if (this == Blocks.LAPIS_ORE) {
            return MathHelper.nextInt(p_220281_1_, 2, 5);
        } else {
            return this == Blocks.NETHER_QUARTZ_ORE ? MathHelper.nextInt(p_220281_1_, 2, 5) : 0;
        }
    }
}
