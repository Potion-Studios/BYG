package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class TallAlliumBlock extends TallGrassBlock implements BonemealableBlock {

    protected TallAlliumBlock(Properties builder) {
        super(builder);

    }

    @Override
    public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
        DoublePlantBlock doubleplantblock = (DoublePlantBlock) (this == BYGBlocks.TALL_ALLIUM ? BYGBlocks.TALL_ALLIUM : BYGBlocks.TALL_ALLIUM);
        if (doubleplantblock.defaultBlockState().canSurvive(worldIn, pos) && worldIn.isEmptyBlock(pos.above())) {
            doubleplantblock.placeAt(worldIn, pos, 2);
        }

    }
}
