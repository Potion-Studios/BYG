package potionstudios.byg.registration;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGScaffoldingBlock;

public class BYGForgeScaffoldingBlock extends BYGScaffoldingBlock {
    public BYGForgeScaffoldingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isScaffolding(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
        return true;
    }
}
