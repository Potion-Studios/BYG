package corgiaoc.byg.common.properties.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class BYGPollenBlock extends Block {

    protected BYGPollenBlock(Properties builder) {
        super(builder);

    }

    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.BEE && entityIn.getType() != EntityType.BAT) {
            entityIn.makeStuckInBlock(state, new Vec3(0.8F, 0.75D, 0.8F));
            double d0 = Math.abs(entityIn.getX() - entityIn.xOld);
            double d1 = Math.abs(entityIn.getZ() - entityIn.zOld);
        }
    }

    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        VoxelShape lvt_5_1_ = this.getShape(stateIn, worldIn, pos, CollisionContext.empty());
        Vec3 lvt_6_1_ = lvt_5_1_.bounds().getCenter();
        double lvt_7_1_ = (double) pos.getX() + lvt_6_1_.x;
        double lvt_9_1_ = (double) pos.getZ() + lvt_6_1_.z;

        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
            if (rand.nextBoolean()) {
                worldIn.addParticle(ParticleTypes.FALLING_NECTAR, lvt_7_1_ + (double) (rand.nextFloat() / 5.0F), (double) pos.getY() + (0.5D - (double) rand.nextFloat()), lvt_9_1_ + (double) (rand.nextFloat() / 5.0F), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    @Override
    public boolean isPossibleToRespawnInThis() {
        return true;
    }
}
