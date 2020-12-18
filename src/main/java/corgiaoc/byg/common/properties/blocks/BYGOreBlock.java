package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

import java.util.Random;

import net.minecraft.block.AbstractBlock;

public class BYGOreBlock extends OreBlock implements IForgeBlock {

    public BYGOreBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    protected int getExperience(Random rand) {
        if (this == BYGBlocks.AMETRINE_ORE) {
            return MathHelper.nextInt(rand, 3, 9);
        } else if (this == BYGBlocks.ANTHRACITE_ORE) {
            return MathHelper.nextInt(rand, 2, 5);
        } else if (this == BYGBlocks.CRYPTIC_REDSTONE_ORE) {
            return MathHelper.nextInt(rand, 3, 7);
        } else if (this == Blocks.LAPIS_ORE) {
            return MathHelper.nextInt(rand, 2, 5);
        } else {
            return this == Blocks.NETHER_QUARTZ_ORE ? MathHelper.nextInt(rand, 2, 5) : 0;
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
