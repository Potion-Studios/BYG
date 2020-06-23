package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class TallAlliumBlock extends FernBlock {

    protected TallAlliumBlock(Settings builder) {
        super(builder);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        TallPlantBlock tallPlantBlock = (TallPlantBlock)(this == BYGBlockList.TALL_ALLIUM ? BYGBlockList.TALL_ALLIUM : BYGBlockList.TALL_ALLIUM);
        if (tallPlantBlock.getDefaultState().canPlaceAt(world, pos) && world.isAir(pos.up())) {
            tallPlantBlock.placeAt(world, pos, 2);
        }

    }
}
