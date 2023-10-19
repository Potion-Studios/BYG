package potionstudios.byg.mixin.common;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.common.block.BYGBlocks;

@Mixin(WalkNodeEvaluator.class)
public class MixinWalkNodeProcessor {

    @Inject(method = "getBlockPathTypeRaw", at = @At("RETURN"), cancellable = true)
    private static void byg_avoidQuartzCrystals(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<BlockPathTypes> cir) {
        BlockState blockState = blockGetter.getBlockState(blockPos);
        if (blockState.is(BYGBlocks.QUARTZ_CRYSTAL.get())) {
            cir.setReturnValue(BlockPathTypes.DAMAGE_OTHER);
        }
    }

}
