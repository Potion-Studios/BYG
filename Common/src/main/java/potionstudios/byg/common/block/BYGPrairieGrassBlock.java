package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class BYGPrairieGrassBlock extends TallGrassBlock implements BonemealableBlock {

    protected BYGPrairieGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void performBonemeal(ServerLevel world, Random rand, BlockPos pos, BlockState state) {
        DoublePlantBlock doubleplantblock = (DoublePlantBlock) (BYGBlocks.TALL_PRAIRIE_GRASS);
        if (doubleplantblock.defaultBlockState().canSurvive(world, pos) && world.isEmptyBlock(pos.above())) {
            DoublePlantBlock.placeAt(world, state, pos, 2);
        }

    }

}
