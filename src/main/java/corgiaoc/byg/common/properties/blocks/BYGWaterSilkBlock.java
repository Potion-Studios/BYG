package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BYGWaterSilkBlock extends LilyPadBlock {

    protected BYGWaterSilkBlock(Settings p_i48297_1_) {
        super(p_i48297_1_);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.COD && entityIn.getType() != EntityType.SQUID) {
            entityIn.slowMovement(state, new Vec3d(0.8F, 0.75D, 0.8F));
            double d0 = Math.abs(entityIn.getX() - entityIn.lastRenderX);
            double d1 = Math.abs(entityIn.getZ() - entityIn.lastRenderZ);
        }
    }
}
