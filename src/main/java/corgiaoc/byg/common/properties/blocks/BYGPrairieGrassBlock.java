package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;

import java.util.Random;

public class BYGPrairieGrassBlock extends FernBlock implements Fertilizable {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    protected BYGPrairieGrassBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        TallPlantBlock doubleplantblock = (TallPlantBlock) (this == BYGBlocks.PRAIRIE_GRASS ? BYGBlocks.TALL_PRAIRIE_GRASS : BYGBlocks.TALL_PRAIRIE_GRASS);
        if (doubleplantblock.getDefaultState().canPlaceAt(world, pos) && world.isAir(pos.up())) {
            doubleplantblock.placeAt(world, pos, 2);
        }

    }

}
