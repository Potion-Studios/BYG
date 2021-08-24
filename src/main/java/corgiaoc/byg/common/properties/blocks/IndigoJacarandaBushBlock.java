package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class IndigoJacarandaBushBlock extends JacarandaBushBlock implements BonemealableBlock {

    public IndigoJacarandaBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void performBonemeal(ServerLevel world, Random rand, BlockPos pos, BlockState state) {
        JacarandaBushBlock flowering = (JacarandaBushBlock) (this == BYGBlocks.INDIGO_JACARANDA_BUSH ? BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH : BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH);
        if (flowering.defaultBlockState().canSurvive(world, pos)) {
            flowering.placeAt(world, pos, 1);
        }
    }
}
