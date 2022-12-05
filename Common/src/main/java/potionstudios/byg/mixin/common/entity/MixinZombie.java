package potionstudios.byg.mixin.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.common.entity.pumpkinwarden.PumpkinWarden;

@Mixin(Zombie.class)
public class MixinZombie extends Monster {

    protected MixinZombie(EntityType<? extends Monster> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Inject(method = "addBehaviourGoals", at = @At("HEAD"))
    public void addGoals(CallbackInfo ci) {
        NearestAttackableTargetGoal<PumpkinWarden> targetGoal = new NearestAttackableTargetGoal<>(this, PumpkinWarden.class, true) {
            @Override
            public boolean canContinueToUse() {
                if (((PumpkinWarden) this.target).isHiding()) {
                    return false;
                } else {
                    return super.canContinueToUse();
                }
            }
        };
        this.targetSelector.addGoal(3, targetGoal);
    }
}
