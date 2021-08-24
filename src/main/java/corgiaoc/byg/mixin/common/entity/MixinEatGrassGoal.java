package corgiaoc.byg.mixin.common.entity;


import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Predicate;

@Mixin(EatBlockGoal.class)
public class MixinEatGrassGoal {


    @Shadow
    @Final
    private Mob mob;

    @Shadow
    @Final
    private static Predicate<BlockState> IS_TALL_GRASS;

    @Shadow
    @Final
    private Level level;

    @Inject(method = "canUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Mob;blockPosition()Lnet/minecraft/core/BlockPos;"), cancellable = true)
    private void addModdedGrass(CallbackInfoReturnable<Boolean> cir) {
        BlockPos blockpos = this.mob.blockPosition();
        if (IS_TALL_GRASS.test(this.level.getBlockState(blockpos))) {
            cir.setReturnValue(true);
        } else {
            boolean flag = this.level.getBlockState(blockpos.below()).is(BYGBlocks.MEADOW_GRASSBLOCK);
            if (flag)
                cir.setReturnValue(true);
        }
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/BlockPos;below()Lnet/minecraft/core/BlockPos;"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void addModdedGrassChecks(CallbackInfo ci, BlockPos pos) {
        BlockPos blockpos1 = pos.below();
        if (this.level.getBlockState(blockpos1).is(BYGBlocks.MEADOW_GRASSBLOCK)) {
            if (this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                this.level.levelEvent(2001, blockpos1, Block.getId(BYGBlocks.MEADOW_GRASSBLOCK.defaultBlockState()));
                this.level.setBlock(blockpos1, BYGBlocks.MEADOW_DIRT.defaultBlockState(), 2);
                this.mob.ate();
            }
        }
    }


}
