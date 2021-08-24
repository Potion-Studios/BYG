package corgiaoc.byg.common.properties.blocks.end.bulbisgardens;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TallBulbisBlock extends TallFlowerBlock {
    public TallBulbisBlock(Properties builder) {
        super(builder);
    }

    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
            if (entityIn instanceof LivingEntity && !EnchantmentHelper.hasSoulSpeed((LivingEntity)entityIn)) {
                LivingEntity livingentity = (LivingEntity)entityIn;
                    livingentity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 160, 0, false, false));
            }
    }
}
