package potionstudios.byg.mixin.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.BYG;
import potionstudios.byg.util.BYGUtil;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class MixinBlockBehaviourBlockStateBase {


    @Inject(at = @At("HEAD"), method = "is(Lnet/minecraft/world/level/block/Block;)Z", cancellable = true)
    private void byg_useIsReplacement(Block block, CallbackInfoReturnable<Boolean> info) {
        var replacements = BYG.getBlockstateIsReplacements();
        if (BYGUtil.useTagReplacements && replacements.containsKey(block) && replacements.get(block).test(asThis())) {
            info.setReturnValue(true);
        }
    }

    private BlockBehaviour.BlockStateBase asThis() {
        return (BlockBehaviour.BlockStateBase) (Object) this;
    }
}