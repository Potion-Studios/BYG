package corgiaoc.byg.mixin.common.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.BasaltColumnFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BasaltColumnFeature.class)
public abstract class MixinBasaltColumnFeature {

    @Inject(at = @At("HEAD"), method = "isAirOrLavaOcean(Lnet/minecraft/world/IWorld;ILnet/minecraft/util/math/BlockPos;)Z", cancellable = true)
    private static void injectWater(IWorld world, int topY, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (world.dimensionType().hasSkyLight()) {
            cir.cancel();
            BlockState blockstate = world.getBlockState(pos);
            cir.setReturnValue(blockstate.isAir() || blockstate.is(Blocks.WATER) || blockstate.is(Blocks.LAVA) && pos.getY() <= topY);
        }
    }
}