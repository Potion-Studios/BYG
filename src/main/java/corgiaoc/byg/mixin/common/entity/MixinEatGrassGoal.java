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


    @Shadow @Final private MobEntity grassEaterEntity;

    @Shadow @Final private World entityWorld;

    @Shadow public static Predicate<BlockState> IS_GRASS;

    @Inject(method = "shouldExecute", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/MobEntity;getPosition()Lnet/minecraft/util/math/BlockPos;"), cancellable = true)
    private void addModdedGrass(CallbackInfoReturnable<Boolean> cir) {
        BlockPos blockpos = this.grassEaterEntity.getPosition();
        if (IS_GRASS.test(this.entityWorld.getBlockState(blockpos))) {
            cir.setReturnValue(true);
        } else {
            boolean flag = this.entityWorld.getBlockState(blockpos.down()).isIn(BYGBlocks.MEADOW_GRASSBLOCK);
            if (flag)
                cir.setReturnValue(true);
        }
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/BlockPos;down()Lnet/minecraft/util/math/BlockPos;"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void addModdedGrassChecks(CallbackInfo ci, BlockPos blockpos) {
        BlockPos blockpos1 = blockpos.down();
        if (this.entityWorld.getBlockState(blockpos1).isIn(BYGBlocks.MEADOW_GRASSBLOCK)) {
            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entityWorld, this.grassEaterEntity)) {
                this.entityWorld.playEvent(2001, blockpos1, Block.getStateId(BYGBlocks.MEADOW_GRASSBLOCK.getDefaultState()));
                this.entityWorld.setBlockState(blockpos1, BYGBlocks.MEADOW_DIRT.getDefaultState(), 2);
            }

            this.grassEaterEntity.eatGrassBonus();
        }
    }


}
