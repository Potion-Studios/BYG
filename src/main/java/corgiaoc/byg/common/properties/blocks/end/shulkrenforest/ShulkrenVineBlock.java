package corgiaoc.byg.common.properties.blocks.end.shulkrenforest;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class ShulkrenVineBlock extends GrowingPlantHeadBlock {
    protected static final VoxelShape SHAPE = Block.box(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);



    public ShulkrenVineBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
    }

    /**
     * Used to determine how much to grow the plant when using bonemeal. Kelp always returns 1, where as the nether vines
     * return a random value at least 1.
     */
    protected int getBlocksToGrowWhenBonemealed(Random rand) {
        return NetherVines.getBlocksToGrowWhenBonemealed(rand);
    }

    protected Block getBodyBlock() {
        return BYGBlocks.SHULKREN_VINE_PLANT;
    }

    protected boolean canGrowInto(BlockState state) {
        return NetherVines.isValidGrowthState(state);
    }
}
