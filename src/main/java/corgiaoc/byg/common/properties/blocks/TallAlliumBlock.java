package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class TallAlliumBlock extends TallGrassBlock implements IGrowable {

    protected TallAlliumBlock(Properties builder) {
        super(builder);

    }

    @Override
    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        DoublePlantBlock doubleplantblock = (DoublePlantBlock) (this == BYGBlocks.TALL_ALLIUM ? BYGBlocks.TALL_ALLIUM : BYGBlocks.TALL_ALLIUM);
        if (doubleplantblock.defaultBlockState().canSurvive(worldIn, pos) && worldIn.isEmptyBlock(pos.above())) {
            doubleplantblock.placeAt(worldIn, pos, 2);
        }

    }
}
