package corgiaoc.byg.common.properties.blocks.end.shulkrenforest;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractBodyPlantBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class ShulkrenVinePlantBlock extends AbstractBodyPlantBlock {
    public static final VoxelShape field_235637_d_ = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public ShulkrenVinePlantBlock(Properties properties) {
        super(properties, Direction.DOWN, field_235637_d_, false);
    }

    protected AbstractTopPlantBlock getTopPlantBlock() {
        return (AbstractTopPlantBlock) BYGBlocks.SHULKREN_VINE;
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.setMotionMultiplier(state, new Vector3d(0.8F, 0.75D, 0.8F));
    }
}

