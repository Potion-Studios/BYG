package voronoiaoc.byg.common.properties.blocks;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation")
public class BYGFrostMagmaBlock extends Block {
    public BYGFrostMagmaBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level world, BlockPos pos, Entity entity) {
        if (!entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
            entity.hurt(DamageSource.HOT_FLOOR, 1.0F);
        }

//        if (entity instanceof LivingEntity) {
//            LivingEntity livingentity = (LivingEntity) entity;
//            if (!entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
//                livingentity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 30));
//            }
//        }

        super.stepOn(world, pos, entity);
    }

//    public void animateTick(BlockState blockstate, Level world, BlockPos pos, Random rand) {
//        VoxelShape shape = this.getVisualShape(blockstate, world, pos, CollisionContext.empty());
//        Vec3 vec3d = shape.bounds().getCenter();
//        double getX = (double) pos.getX() + vec3d.x;
//        double getZ = (double) pos.getZ() + vec3d.z;
//
//        for (int idx = 0; idx < 3; ++idx) {
//            if (rand.nextBoolean()) {
//                world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, getX + (double) (rand.nextFloat() / 5.0F), (double) pos.getY() + (0.5D - (double) rand.nextFloat()), getZ + (double) (rand.nextFloat() / 5.0F), 0.0D, 0.04D, 0.0D);
//            }
//        }
//
//    }

    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify) {
        world.getBlockTicks().scheduleTick(pos, this, 20);
    }
}
