package corgiaoc.byg.common.properties.blocks.nether.sythian;

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
import corgiaoc.byg.core.BYGBlocks;

import java.util.Random;

public class HangingSythanRootsBlock extends AbstractTopPlantBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    protected HangingSythanRootsBlock(Properties properties) {
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
        return BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT;
    }

    protected boolean canGrowIn(BlockState state) {
        return PlantBlockHelper.isAir(state);
    }

//    @OnlyIn(Dist.CLIENT)
//    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
//        VoxelShape lvt_5_1_ = this.getShape(p_180655_1_, p_180655_2_, p_180655_3_, ISelectionContext.dummy());
//        Vector3d lvt_6_1_ = lvt_5_1_.getBoundingBox().getCenter();
//        double lvt_7_1_ = (double) p_180655_3_.getX() + lvt_6_1_.x;
//        double lvt_9_1_ = (double) p_180655_3_.getZ() + lvt_6_1_.z;
//
//        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
//            if (p_180655_4_.nextBoolean()) {
//                p_180655_2_.addParticle(ParticleTypes.END_ROD, lvt_7_1_ + (double) (p_180655_4_.nextFloat() / 5.0F), (double) p_180655_3_.getY() + (0.5D - (double) p_180655_4_.nextFloat()), lvt_9_1_ + (double) (p_180655_4_.nextFloat() / 5.0F), 0.0D, 0.0D, 0.0D);
//            }
//        }
//
//    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.setMotionMultiplier(state, new Vector3d(0.8F, 0.75D, 0.8F));
    }
}
