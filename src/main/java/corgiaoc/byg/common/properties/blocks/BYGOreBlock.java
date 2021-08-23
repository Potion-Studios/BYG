package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

import java.util.Random;

public class BYGOreBlock extends OreBlock implements IForgeBlock {

    public BYGOreBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    protected int xpOnDrop(Random rand) {
        if (this == BYGBlocks.AMETRINE_ORE) {
            return MathHelper.nextInt(rand, 3, 9);
        } else if (this == BYGBlocks.ANTHRACITE_ORE) {
            return MathHelper.nextInt(rand, 2, 5);
        } else if (this == BYGBlocks.CRYPTIC_REDSTONE_ORE) {
            return MathHelper.nextInt(rand, 3, 7);
        } else if (this == BYGBlocks.BLUE_NETHER_GOLD_ORE) {
            return MathHelper.nextInt(rand, 0, 1);
        } else if (this == BYGBlocks.BLUE_NETHER_QUARTZ_ORE) {
            return MathHelper.nextInt(rand, 2, 5);
        } else if (this == BYGBlocks.BRIMSTONE_NETHER_GOLD_ORE) {
            return MathHelper.nextInt(rand, 0, 1);
        } else if (this == BYGBlocks.BRIMSTONE_NETHER_QUARTZ_ORE) {
            return MathHelper.nextInt(rand, 2, 5);
        } else if (this == BYGBlocks.BUDDING_AMETRINE_ORE) {
            return MathHelper.nextInt(rand, 3, 9);
        } else {
            return this == BYGBlocks.EMERALDITE_ORE ? MathHelper.nextInt(rand, 4, 7) : 0;
        }
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 3;
    }

    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }
}
