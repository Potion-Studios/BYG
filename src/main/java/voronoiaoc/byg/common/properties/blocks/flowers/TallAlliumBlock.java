package voronoiaoc.byg.common.properties.blocks.flowers;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class TallAlliumBlock extends TallGrassBlock implements IGrowable, net.minecraftforge.common.IShearable {

    protected TallAlliumBlock(Properties builder) {
        super(builder);

    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        DoublePlantBlock doubleplantblock = (DoublePlantBlock) (this == BYGBlockList.TALL_ALLIUM ? BYGBlockList.TALL_ALLIUM : BYGBlockList.TALL_ALLIUM);
        if (doubleplantblock.getDefaultState().isValidPosition(worldIn, pos) && worldIn.isAirBlock(pos.up())) {
            doubleplantblock.placeAt(worldIn, pos, 2);
        }

    }
}
