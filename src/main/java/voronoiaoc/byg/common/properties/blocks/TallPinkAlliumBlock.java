package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FernBlock;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class TallPinkAlliumBlock extends FernBlock {

    protected TallPinkAlliumBlock(Settings builder) {
        super(builder);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        TallPlantBlock tallPlantBlock = (TallPlantBlock)(this == BYGBlockList.TALL_PINK_ALLIUM ? BYGBlockList.TALL_PINK_ALLIUM : BYGBlockList.TALL_PINK_ALLIUM);
        if (tallPlantBlock.getDefaultState().canPlaceAt(world, pos) && world.isAir(pos.up())) {
            tallPlantBlock.placeAt(world, pos, 2);
        }

    }
}
