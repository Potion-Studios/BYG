package corgiaoc.byg.common.properties.blocks.end.shulkrenforest;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlockHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Random;

public class ShulkrenVineBlock extends AbstractTopPlantBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);



    public ShulkrenVineBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
    }

    /**
     * Used to determine how much to grow the plant when using bonemeal. Kelp always returns 1, where as the nether vines
     * return a random value at least 1.
     */
    protected int getGrowthAmount(Random rand) {
        return PlantBlockHelper.getGrowthAmount(rand);
    }

    protected Block getBodyPlantBlock() {
        return BYGBlocks.SHULKREN_VINE_PLANT;
    }

    protected boolean canGrowIn(BlockState state) {
        return PlantBlockHelper.isAir(state);
    }
}
