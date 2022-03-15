package potionstudios.byg.mixin.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.common.block.end.EndStoneGrowable;

@Mixin(BoneMealItem.class)
public class MixinBoneMealItem {

    @Inject(method = "growCrop", at = @At("HEAD"), cancellable = true)
    private static void endStoneBoneMeal(ItemStack stack, Level level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (level.getBlockState(pos).is(Blocks.END_STONE)) {
            if (level instanceof ServerLevel) {
                if (EndStoneGrowable.isValidBonemealTarget(level, pos)) {
                    EndStoneGrowable.performBonemeal((ServerLevel) level, pos);
                    stack.shrink(1);
                    cir.setReturnValue(true);
                }
            }
        }
    }
}
