package corgiaoc.byg.mixin.common.entity;


import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Predicate;

@Mixin(EatGrassGoal.class)
public class MixinEatGrassGoal {


    @Shadow
    @Final
    private static Predicate<BlockState> GRASS_PREDICATE;
    @Shadow
    @Final
    private MobEntity mob;
    @Shadow
    @Final
    private World world;

    @Inject(method = "canStart", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/MobEntity;getBlockPos()Lnet/minecraft/util/math/BlockPos;"), cancellable = true)
    private void addModdedGrass(CallbackInfoReturnable<Boolean> cir) {
        BlockPos blockpos = this.mob.getBlockPos();
        if (GRASS_PREDICATE.test(this.world.getBlockState(blockpos))) {
            cir.setReturnValue(true);
        } else {
            boolean flag = this.world.getBlockState(blockpos.down()).isOf(BYGBlocks.MEADOW_GRASSBLOCK);
            if (flag)
                cir.setReturnValue(true);
        }
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/BlockPos;down()Lnet/minecraft/util/math/BlockPos;"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void addModdedGrassChecks(CallbackInfo ci, BlockPos blockpos) {
        BlockPos blockpos1 = blockpos.down();
        if (this.world.getBlockState(blockpos1).isOf(BYGBlocks.MEADOW_GRASSBLOCK)) {
            if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                this.world.syncWorldEvent(2001, blockpos1, Block.getRawIdFromState(BYGBlocks.MEADOW_GRASSBLOCK.getDefaultState()));
                this.world.setBlockState(blockpos1, BYGBlocks.MEADOW_DIRT.getDefaultState(), 2);
            }

            this.mob.onEatingGrass();
        }
    }


}
