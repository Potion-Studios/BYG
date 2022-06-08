package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class IndigoJacarandaBushBlock extends JacarandaBushBlock implements BonemealableBlock {

    public IndigoJacarandaBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource rand, BlockPos pos, BlockState state) {
        JacarandaBushBlock flowering = (JacarandaBushBlock) (this == BYGBlocks.INDIGO_JACARANDA_BUSH.get() ? BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH.get() : BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH.get());
        if (flowering.defaultBlockState().canSurvive(world, pos)) {
            flowering.placeAt(world, pos, 1);
        }
    }
}
