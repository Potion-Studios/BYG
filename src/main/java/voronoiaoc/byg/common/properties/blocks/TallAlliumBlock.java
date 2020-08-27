package voronoiaoc.byg.common.properties.blocks;

import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TallAlliumBlock extends TallGrassBlock {

    protected TallAlliumBlock(Properties builder) {
        super(builder);
    }

    @Override
    public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
        DoublePlantBlock tallPlantBlock = (DoublePlantBlock) (this == BYGBlockList.TALL_ALLIUM ? BYGBlockList.TALL_ALLIUM : BYGBlockList.TALL_ALLIUM);
        if (tallPlantBlock.defaultBlockState().canSurvive(world, pos) && world.isEmptyBlock(pos.above())) {
            tallPlantBlock.placeAt(world, pos, 2);
        }

    }
}
