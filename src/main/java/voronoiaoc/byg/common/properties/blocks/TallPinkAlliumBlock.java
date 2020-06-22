package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class TallPinkAlliumBlock extends TallGrassBlock implements IGrowable, net.minecraftforge.common.IShearable {

    protected TallPinkAlliumBlock(Properties builder) {
        super(builder);

    }
    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        DoublePlantBlock doubleplantblock = (DoublePlantBlock)(this == BYGBlockList.TALL_PINK_ALLIUM ? BYGBlockList.TALL_PINK_ALLIUM : BYGBlockList.TALL_PINK_ALLIUM);
        if (doubleplantblock.getDefaultState().isValidPosition(worldIn, pos) && worldIn.isAirBlock(pos.up())) {
            doubleplantblock.placeAt(worldIn, pos, 2);
        }

    }
}
