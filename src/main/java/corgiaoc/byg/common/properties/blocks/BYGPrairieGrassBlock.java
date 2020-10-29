package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BYGPrairieGrassBlock extends TallGrassBlock implements IGrowable {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    protected BYGPrairieGrassBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        DoublePlantBlock doubleplantblock = (DoublePlantBlock) (this == BYGBlocks.PRAIRIE_GRASS ? BYGBlocks.TALL_PRAIRIE_GRASS : BYGBlocks.TALL_PRAIRIE_GRASS);
        if (doubleplantblock.getDefaultState().isValidPosition(world, pos) && world.isAirBlock(pos.up())) {
            doubleplantblock.placeAt(world, pos, 2);
        }

    }

}
