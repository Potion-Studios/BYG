package potionstudios.byg.common.block.end.bulbisgardens;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TallBulbisBlock extends TallFlowerBlock {
    public TallBulbisBlock(Properties builder) {
        super(builder);
    }

    public void entityInside(@NotNull BlockState state, @NotNull Level worldIn, @NotNull BlockPos pos, @NotNull Entity entityIn) {
            if (entityIn instanceof LivingEntity livingentity && !EnchantmentHelper.hasSoulSpeed((LivingEntity)entityIn)) {
	            livingentity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 160, 0, false, false));
            }
    }
}
