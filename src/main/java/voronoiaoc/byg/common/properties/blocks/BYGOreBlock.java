package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.List;
import java.util.Random;

public class BYGOreBlock extends Block {

    public BYGOreBlock(Settings properties) {
        super(properties);
    }

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
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        return super.getDroppedStacks(state, builder);
    }

    @Override
    protected void dropExperience(ServerWorld serverWorld, BlockPos pos, int size) {
        super.dropExperience(serverWorld, pos, size);
    }
}
