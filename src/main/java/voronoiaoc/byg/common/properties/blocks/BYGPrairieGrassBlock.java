package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class BYGPrairieGrassBlock extends PlantBlock implements Fertilizable {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    protected BYGPrairieGrassBlock(Settings properties) {
        super(properties);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld p_225535_1_, Random p_225535_2_, BlockPos p_225535_3_, BlockState p_225535_4_) {
        TallPlantBlock TallPlantBlock = (TallPlantBlock) (this == BYGBlockList.PRAIRIE_GRASS ? BYGBlockList.TALL_PRAIRIE_GRASS : BYGBlockList.TALL_PRAIRIE_GRASS);
        if (TallPlantBlock.getDefaultState().canPlaceAt(p_225535_1_, p_225535_3_) && p_225535_1_.isAir
                (p_225535_3_.up())) {
            TallPlantBlock.placeAt(p_225535_1_, p_225535_3_, 2);
        }

    }

    /**
     * Get the OffsetType for this Block. Determines if the model is rendered slightly offset.
     */
    public OffsetType getOffsetType() {
        return OffsetType.XYZ;
    }
}
