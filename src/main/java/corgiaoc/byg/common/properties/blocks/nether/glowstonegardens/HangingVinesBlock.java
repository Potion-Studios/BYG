package corgiaoc.byg.common.properties.blocks.nether.glowstonegardens;

import corgiaoc.byg.core.BYGBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

import java.util.Random;

public class HangingVinesBlock extends AbstractPlantStemBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    protected HangingVinesBlock(AbstractBlock.Settings properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
    }

    /**
     * Used to determine how much to grow the plant when using bonemeal. Kelp always returns 1, where as the nether vines
     * return a random value at least 1.
     */
    protected int method_26376(Random rand) {
        return VineLogic.method_26381(rand);
    }

    protected Block getPlant() {
        return BYGBlocks.WEEPING_ROOTS_PLANT;
    }

    protected boolean chooseStemState(BlockState state) {
        return VineLogic.isValidForWeepingStem(state);
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
        VoxelShape lvt_5_1_ = this.getOutlineShape(p_180655_1_, p_180655_2_, p_180655_3_, ShapeContext.absent());
        Vec3d lvt_6_1_ = lvt_5_1_.getBoundingBox().getCenter();
        double lvt_7_1_ = (double) p_180655_3_.getX() + lvt_6_1_.x;
        double lvt_9_1_ = (double) p_180655_3_.getZ() + lvt_6_1_.z;

        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
            if (p_180655_4_.nextBoolean()) {
                p_180655_2_.addParticle(ParticleTypes.END_ROD, lvt_7_1_ + (double) (p_180655_4_.nextFloat() / 5.0F), (double) p_180655_3_.getY() + (0.5D - (double) p_180655_4_.nextFloat()), lvt_9_1_ + (double) (p_180655_4_.nextFloat() / 5.0F), 0.0D, 0.0D, 0.0D);
            }
        }

    }
}
