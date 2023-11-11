package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class DoubleDamagePlantBlock extends BYGDoublePlantBlock {

    public DoubleDamagePlantBlock(Properties properties, TagKey<Block> mayPlaceOn) {
        super(properties, mayPlaceOn);
    }

    @Override
    public void entityInside(@NotNull BlockState state, @NotNull Level worldIn, @NotNull BlockPos pos, @NotNull Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.PIGLIN && entityIn.getType() != EntityType.MAGMA_CUBE && entityIn.getType() != EntityType.ZOMBIFIED_PIGLIN && entityIn.getType() != EntityType.GHAST) {
            entityIn.makeStuckInBlock(state, new Vec3(0.8F, 0.75D, 0.8F));
            double d0 = Math.abs(entityIn.getX() - entityIn.xOld);
            double d1 = Math.abs(entityIn.getZ() - entityIn.zOld);
            if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
                entityIn.hurt(entityIn.damageSources().cactus(), 1.0F);
            }
        }

    }
}
