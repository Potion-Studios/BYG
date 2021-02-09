package corgiaoc.byg.common.properties.blocks.nether.weepingmire;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class LamentVinePlantBlock extends AbstractPlantBlock {
    public static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    protected LamentVinePlantBlock(Settings properties) {
        super(properties, Direction.DOWN, SHAPE, false);
    }

    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) BYGBlocks.LAMENT_VINE;
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.slowMovement(state, new Vec3d(0.8F, 0.75D, 0.8F));
    }
}

