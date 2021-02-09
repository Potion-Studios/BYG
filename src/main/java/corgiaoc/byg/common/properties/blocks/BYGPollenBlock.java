package corgiaoc.byg.common.properties.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

import java.util.Random;

public class BYGPollenBlock extends Block {

    protected BYGPollenBlock(Settings builder) {
        super(builder);

    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.BEE && entityIn.getType() != EntityType.BAT) {
            entityIn.slowMovement(state, new Vec3d(0.8F, 0.75D, 0.8F));
            double d0 = Math.abs(entityIn.getX() - entityIn.lastRenderX);
            double d1 = Math.abs(entityIn.getZ() - entityIn.lastRenderZ);
        }
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        VoxelShape lvt_5_1_ = this.getOutlineShape(stateIn, worldIn, pos, ShapeContext.absent());
        Vec3d lvt_6_1_ = lvt_5_1_.getBoundingBox().getCenter();
        double lvt_7_1_ = (double) pos.getX() + lvt_6_1_.x;
        double lvt_9_1_ = (double) pos.getZ() + lvt_6_1_.z;

        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
            if (rand.nextBoolean()) {
                worldIn.addParticle(ParticleTypes.FALLING_NECTAR, lvt_7_1_ + (double) (rand.nextFloat() / 5.0F), (double) pos.getY() + (0.5D - (double) rand.nextFloat()), lvt_9_1_ + (double) (rand.nextFloat() / 5.0F), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    @Override
    public boolean canMobSpawnInside() {
        return true;
    }
}
