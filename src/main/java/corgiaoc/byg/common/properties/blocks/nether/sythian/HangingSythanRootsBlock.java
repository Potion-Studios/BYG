package corgiaoc.byg.common.properties.blocks.nether.sythian;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class HangingSythanRootsBlock extends GrowingPlantHeadBlock {
    protected static final VoxelShape SHAPE = Block.box(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    protected HangingSythanRootsBlock(Properties properties) {
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
        return BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT;
    }

    protected boolean canGrowInto(BlockState state) {
        return NetherVines.isValidGrowthState(state);
    }

//    @Environment(EnvType.CLIENT)
//    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
//        VoxelShape lvt_5_1_ = this.getShape(stateIn, worldIn, pos, ISelectionContext.dummy());
//        Vector3d lvt_6_1_ = lvt_5_1_.getBoundingBox().getCenter();
//        double lvt_7_1_ = (double) pos.getX() + lvt_6_1_.x;
//        double lvt_9_1_ = (double) pos.getZ() + lvt_6_1_.z;
//
//        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
//            if (rand.nextBoolean()) {
//                worldIn.addParticle(ParticleTypes.END_ROD, lvt_7_1_ + (double) (rand.nextFloat() / 5.0F), (double) pos.getY() + (0.5D - (double) rand.nextFloat()), lvt_9_1_ + (double) (rand.nextFloat() / 5.0F), 0.0D, 0.0D, 0.0D);
//            }
//        }
//
//    }

    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        entityIn.makeStuckInBlock(state, new Vec3(0.8F, 0.75D, 0.8F));
    }
}
