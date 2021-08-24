package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class BYGPrairieGrassBlock extends TallGrassBlock implements BonemealableBlock {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    protected BYGPrairieGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void performBonemeal(ServerLevel world, Random rand, BlockPos pos, BlockState state) {
        DoublePlantBlock doubleplantblock = (DoublePlantBlock) (this == BYGBlocks.PRAIRIE_GRASS ? BYGBlocks.TALL_PRAIRIE_GRASS : BYGBlocks.TALL_PRAIRIE_GRASS);
        if (doubleplantblock.defaultBlockState().canSurvive(world, pos) && world.isEmptyBlock(pos.above())) {
            doubleplantblock.placeAt(world, pos, 2);
        }

    }

}
