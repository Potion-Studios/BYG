package potionstudios.byg.mixin.common.block;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.MLBlockTags;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class MixinBlockBehaviourBlockStateBase {


    @Shadow
    public abstract boolean is(TagKey<Block> $$0);

    @Inject(at = @At("HEAD"), method = "is(Lnet/minecraft/world/level/block/Block;)Z", cancellable = true)
    private void isBookshelf(Block block, CallbackInfoReturnable<Boolean> info) {
        if (BYGUtil.useTagReplacements) {
            if (block == Blocks.BOOKSHELF) {
                info.setReturnValue(this.is(MLBlockTags.BOOKSHELVES));
            }
            if (block == Blocks.FARMLAND) {
                info.setReturnValue(this.is(BYGBlockTags.FARMLAND));
            }
        }
    }
}