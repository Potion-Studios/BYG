package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

@SuppressWarnings("deprecation")
public class BYGFrostMagmaBlock extends Block {
    public BYGFrostMagmaBlock(Properties properties) {
        super(properties);
    }

    public void onEntityWalk(World block, BlockPos pos, Entity entity) {
        if (!entity.isImmuneToFire() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
            entity.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
        }

//        if (entity instanceof LivingEntity) {
//            LivingEntity livingentity = (LivingEntity) entity;
//            if (!entity.isImmuneToFire() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
//                livingentity.addPotionEffect(new EffectInstance(Effects.LEVITATION, 20, 30));
//            }
//        }


        super.onEntityWalk(block, pos, entity);
    }

//    @OnlyIn(Dist.CLIENT)
//    public void animateTick(BlockState blockstate, World world, BlockPos pos, Random rand) {
//        VoxelShape shape = this.getShape(blockstate, world, pos, ISelectionContext.dummy());
//        Vector3d Vector3d = shape.getBoundingBox().getCenter();
//        double getX = (double) pos.getX() + Vector3d.x;
//        double getZ = (double) pos.getZ() + Vector3d.z;
//
//        for (int idx = 0; idx < 3; ++idx) {
//            if (rand.nextBoolean()) {
//                world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, getX + (double) (rand.nextFloat() / 5.0F), (double) pos.getY() + (0.5D - (double) rand.nextFloat()), getZ + (double) (rand.nextFloat() / 5.0F), 0.0D, 0.04D, 0.0D);
//            }
//        }
//
//    }

    public int tickRate(IWorldReader worldReader) {
        return 20;
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState state2, boolean isMoving) {
        world.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(world));
    }

    public boolean canEntitySpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entityType) {
        return entityType.isImmuneToFire();
    }

    public boolean needsPostProcessing(BlockState state, IBlockReader blockReader, BlockPos pos) {
        return true;
    }
}
