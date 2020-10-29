package corgiaoc.byg.mixin.common.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.feature.BasaltColumnsFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BasaltColumnsFeature.class)
public abstract class MixinBasaltColumnFeature {

    @Inject(at = @At("HEAD"), method = "method_27095(Lnet/minecraft/world/WorldAccess;ILnet/minecraft/util/math/BlockPos;)Z", cancellable = true)
    private static void injectWater(WorldAccess world, int topY, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (world.getDimension() == DimensionType.OVERWORLD) {
            cir.cancel();
            BlockState blockstate = world.getBlockState(pos);
            cir.setReturnValue(blockstate.isAir() || blockstate.isOf(Blocks.WATER) || blockstate.isOf(Blocks.LAVA) && pos.getY() <= topY);
        }
    }
}