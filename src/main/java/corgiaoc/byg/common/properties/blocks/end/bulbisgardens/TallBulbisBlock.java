package corgiaoc.byg.common.properties.blocks.end.bulbisgardens;

import net.minecraft.block.BlockState;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TallBulbisBlock extends TallFlowerBlock {
    public TallBulbisBlock(Settings builder) {
        super(builder);
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && !EnchantmentHelper.hasSoulSpeed((LivingEntity) entityIn)) {
            LivingEntity livingentity = (LivingEntity) entityIn;
            livingentity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 160, 0, false, false));
        }
    }
}
