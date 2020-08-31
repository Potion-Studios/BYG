package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BYGOreBlock extends Block {
    public BYGOreBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void spawnAfterBreak(BlockState state, ServerLevel world, BlockPos pos, ItemStack stack) {
        super.spawnAfterBreak(this.defaultBlockState(), world, pos, stack);
    }

    @Override
    protected void popExperience(ServerLevel serverWorld, BlockPos pos, int size) {
        super.popExperience(serverWorld, pos, size);
    }
}
