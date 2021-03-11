package corgiaoc.byg.mixin.common.entity;


import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.util.math.BlockPos;
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


    @Shadow @Final private MobEntity mob;

    @Shadow @Final private static Predicate<BlockState> IS_TALL_GRASS;

    @Shadow @Final private World level;

    @Inject(method = "canUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/MobEntity;blockPosition()Lnet/minecraft/util/math/BlockPos;"), cancellable = true)
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

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/BlockPos;below()Lnet/minecraft/util/math/BlockPos;"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void addModdedGrassChecks(CallbackInfo ci, BlockPos pos) {
        BlockPos blockpos1 = pos.below();
        if (this.level.getBlockState(blockpos1).is(BYGBlocks.MEADOW_GRASSBLOCK)) {
            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.mob)) {
                this.level.levelEvent(2001, blockpos1, Block.getId(BYGBlocks.MEADOW_GRASSBLOCK.defaultBlockState()));
                this.level.setBlock(blockpos1, BYGBlocks.MEADOW_DIRT.defaultBlockState(), 2);
            }

            this.mob.ate();
        }
    }


}
