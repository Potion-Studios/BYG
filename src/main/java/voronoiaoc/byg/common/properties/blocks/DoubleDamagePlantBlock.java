package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DoubleDamagePlantBlock extends TallPlantBlock {

    protected DoubleDamagePlantBlock(Settings builder) {
        super(builder);
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.CAT && entityIn.getType() != EntityType.RABBIT) {
            entityIn.slowMovement(state, new Vec3d(0.8F, 0.75D, 0.8F));
            double d0 = Math.abs(entityIn.getX() - entityIn.lastRenderX);
            double d1 = Math.abs(entityIn.getZ() - entityIn.lastRenderZ);
            if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
                entityIn.damage(DamageSource.SWEET_BERRY_BUSH, 1.0F);
            }
        }

    }

}
