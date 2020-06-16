package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

import java.util.Random;

@SuppressWarnings("deprecation")
public class BYGFrostMagmaBlock extends Block {
    public BYGFrostMagmaBlock(Settings properties) {
        super(properties);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        if (!entity.isFireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
            entity.damage(DamageSource.HOT_FLOOR, 1.0F);
        }

        if (entity instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity) entity;
            if (!entity.isFireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
                livingentity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 20, 30));
            }
        }


        super.onSteppedOn(world, pos, entity);
    }

    public void randomDisplayTick(BlockState blockstate, World world, BlockPos pos, Random rand) {
        VoxelShape shape = this.getVisualShape(blockstate, world, pos, ShapeContext.absent());
        Vec3d vec3d = shape.getBoundingBox().getCenter();
        double getX = (double) pos.getX() + vec3d.x;
        double getZ = (double) pos.getZ() + vec3d.z;

        for (int idx = 0; idx < 3; ++idx) {
            if (rand.nextBoolean()) {
                world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, getX + (double) (rand.nextFloat() / 5.0F), (double) pos.getY() + (0.5D - (double) rand.nextFloat()), getZ + (double) (rand.nextFloat() / 5.0F), 0.0D, 0.04D, 0.0D);
            }
        }

    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.getBlockTickScheduler().schedule(pos, this, 20);
    }
}
