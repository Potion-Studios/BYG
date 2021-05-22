package corgiaoc.byg.mixin.common.block;

import corgiaoc.byg.common.properties.blocks.end.CrypticFireBlock;
import corgiaoc.byg.common.properties.blocks.nether.BoricFireBlock;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFireBlock.class)
public abstract class MixinAbstractFireBlock {

    @Inject(at = @At("HEAD"), method = "getState", cancellable = true)
    private static void addBoricFire(IBlockReader reader, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
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
