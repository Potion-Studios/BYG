package potionstudios.byg.mixin.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.end.CrypticFireBlock;
import potionstudios.byg.common.block.nether.BoricFireBlock;

@Mixin(BaseFireBlock.class)
public abstract class MixinAbstractFireBlock {

    @Inject(at = @At("HEAD"), method = "getState", cancellable = true)
    private static void addBoricFire(BlockGetter reader, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
        BlockPos blockpos = pos.below();
        BlockState blockstate = reader.getBlockState(blockpos);
        if (BoricFireBlock.shouldLightBoricFire(blockstate.getBlock())) {
            cir.cancel();
            cir.setReturnValue(BYGBlocks.BORIC_FIRE.defaultBlockState());
        }
        if (CrypticFireBlock.shouldLightCrypticFire(blockstate.getBlock())) {
            cir.cancel();
            cir.setReturnValue(BYGBlocks.CRYPTIC_FIRE.defaultBlockState());
        }
    }
}
