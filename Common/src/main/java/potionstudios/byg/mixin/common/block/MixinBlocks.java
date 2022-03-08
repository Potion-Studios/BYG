package potionstudios.byg.mixin.common.block;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.common.block.end.EndStoneGrowable;

@Mixin(Blocks.class)
public class MixinBlocks {

    @SuppressWarnings("deprecation")
    @Inject(method = "register", at = @At("HEAD"), cancellable = true)
    private static void swapEndStone(String string, Block block, CallbackInfoReturnable<Block> cir) {
//        if (string.equals("end_stone")) {
//            cir.setReturnValue(Registry.register(Registry.BLOCK, string, new EndStoneGrowable(block)));
//        }
    }
}