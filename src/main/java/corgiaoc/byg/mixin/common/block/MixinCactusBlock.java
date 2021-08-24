package corgiaoc.byg.mixin.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CactusBlock.class)
public class MixinCactusBlock {


    @Inject(method = "canSurvive", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelReader;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;", ordinal = 1), cancellable = true)
    private void addBYGSands(BlockState state, LevelReader worldIn, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockState blockState = worldIn.getBlockState(pos.below());
        if (blockState.getBlock().is(BlockTags.SAND) && !worldIn.getBlockState(pos.above()).getMaterial().isLiquid())
            cir.setReturnValue(true);
    }
}
