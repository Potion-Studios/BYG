package corgiaoc.byg.mixin.common.block;

import corgiaoc.byg.mixin.access.StaticTagHelperWrapperAccess;
import corgiaoc.byg.util.MLBlockTags;
import net.minecraft.tags.StaticTagHelper;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class MixinAbstractBlockStateBookshelf {

    @Shadow public abstract boolean is(Tag<Block> tag);

    @SuppressWarnings("unchecked")
    @Inject(at = @At("HEAD"), method = "is(Lnet/minecraft/world/level/block/Block;)Z", cancellable = true)
    private void isBookshelf(Block block, CallbackInfoReturnable<Boolean> info) {
        // We need to make sure we're bounded first before using
        if (MLBlockTags.BOOKSHELVES instanceof StaticTagHelper.Wrapper<Block> bookShelves){
            if (((StaticTagHelperWrapperAccess<Block>) bookShelves).getTag() != null) {
                if (block.equals(Blocks.BOOKSHELF)) {
                    info.setReturnValue(this.is(bookShelves));
                }
            }
        }
    }
}