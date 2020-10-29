package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.FernBlock;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import java.util.Random;

public class TallAlliumBlock extends FernBlock implements Fertilizable {

    protected TallAlliumBlock(Settings builder) {
        super(builder);

    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        TallPlantBlock doubleplantblock = (TallPlantBlock) (this == BYGBlocks.TALL_ALLIUM ? BYGBlocks.TALL_ALLIUM : BYGBlocks.TALL_ALLIUM);
        if (doubleplantblock.getDefaultState().canPlaceAt(worldIn, pos) && worldIn.isAir(pos.up())) {
            doubleplantblock.placeAt(worldIn, pos, 2);
        }

    }
}
