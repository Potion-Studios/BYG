package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;

public class PoisonIvyBlock extends VineBlock {
    public PoisonIvyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.isClientSide && worldIn.getDifficulty() != Difficulty.PEACEFUL) {
            if (entityIn instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity) entityIn;
                if (!livingentity.isInvulnerableTo(entityIn.damageSources().magic())) {
                    livingentity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0));
                }
            }

        }
    }

}