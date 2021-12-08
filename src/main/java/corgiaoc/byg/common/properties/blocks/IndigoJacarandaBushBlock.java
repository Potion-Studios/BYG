package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class IndigoJacarandaBushBlock extends JacarandaBushBlock implements IGrowable {

    public IndigoJacarandaBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void performBonemeal(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        JacarandaBushBlock flowering = (JacarandaBushBlock) (this == BYGBlocks.INDIGO_JACARANDA_BUSH ? BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH : BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH);
        if (flowering.defaultBlockState().canSurvive(world, pos)) {
            flowering.placeAt(world, pos, 1);
        }
    }
}
