package corgiaoc.byg.mixin.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CactusBlock.class)
public class MixinCactusBlock {


    @Inject(method = "isValidPosition", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/IWorldReader;getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;", ordinal = 1), cancellable = true)
    private void addBYGSands(BlockState state, IWorldReader worldIn, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockState blockState = worldIn.getBlockState(pos.down());
        if (blockState.getBlock().isIn(BlockTags.SAND) && !worldIn.getBlockState(pos.up()).getMaterial().isLiquid())
            cir.setReturnValue(true);
    }
}
