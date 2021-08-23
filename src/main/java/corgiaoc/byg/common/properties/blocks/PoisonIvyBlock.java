package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class PoisonIvyBlock extends VineBlock {
    public PoisonIvyBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.isClientSide && worldIn.getDifficulty() != Difficulty.PEACEFUL) {
            if (entityIn instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity) entityIn;
                if (!livingentity.isInvulnerableTo(DamageSource.MAGIC)) {
                    livingentity.addEffect(new EffectInstance(Effects.POISON, 900, 1));
                }
            }

        }
    }

}