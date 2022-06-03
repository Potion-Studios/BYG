package potionstudios.byg.mixin.common.world.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.BasaltColumnsFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BasaltColumnsFeature.class)
public abstract class MixinBasaltColumnFeature {

    @Inject(at = @At("HEAD"), method = "isAirOrLavaOcean", cancellable = true)
    private static void byg$injectWater(LevelAccessor world, int topY, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (world.dimensionType().hasSkyLight()) {
            cir.cancel();
            BlockState blockstate = world.getBlockState(pos);
            cir.setReturnValue(blockstate.isAir() || blockstate.is(Blocks.WATER) || blockstate.is(Blocks.LAVA) && pos.getY() <= topY);
        }
    }

    @Inject(method = "canPlaceAt", at = @At(value = "TAIL"), cancellable = true)
    private static void byg$allowWater(LevelAccessor accessor, int y, BlockPos.MutableBlockPos mutableBlockPos, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            cir.setReturnValue(accessor.getFluidState(mutableBlockPos).is(FluidTags.WATER));
        }
    }
}