package corgiaoc.byg.mixin.common.block;

import corgiaoc.byg.common.properties.blocks.end.EndStoneGrowable;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Blocks.class)
public class MixinBlocks {

    @SuppressWarnings("deprecation")
    @Inject(method = "register", at = @At("HEAD"), cancellable = true)
    private static void swapEndStone(String string, Block block, CallbackInfoReturnable<Block> cir) {
        if (string.equals("end_stone")) {
            cir.setReturnValue(Registry.register(Registry.BLOCK, string, new EndStoneGrowable(block)));
        }
    }
}