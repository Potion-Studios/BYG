package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class BYGOreBlock extends OreBlock implements IForgeBlock {

    public BYGOreBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    protected int getExperience(Random p_220281_1_) {
        if (this == BYGBlockList.AMETRINE_ORE) {
            return MathHelper.nextInt(p_220281_1_, 3, 9);
        } else if (this == Blocks.DIAMOND_ORE) {
            return MathHelper.nextInt(p_220281_1_, 3, 7);
        } else if (this == Blocks.EMERALD_ORE) {
            return MathHelper.nextInt(p_220281_1_, 3, 7);
        } else if (this == Blocks.LAPIS_ORE) {
            return MathHelper.nextInt(p_220281_1_, 2, 5);
        } else {
            return this == Blocks.NETHER_QUARTZ_ORE ? MathHelper.nextInt(p_220281_1_, 2, 5) : 0;
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



