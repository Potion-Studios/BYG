package corgiaoc.byg.mixin.common.block;

import corgiaoc.byg.common.properties.blocks.BookshelfBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tag.Tag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public abstract class AbstractBlockStateBookshelfMixin {
    @Shadow
    public abstract boolean isIn(Tag<Block> tag);

    @Inject(at = @At("HEAD"), method = "isOf", cancellable = true)
    private void isBookshelf(Block block, CallbackInfoReturnable<Boolean> info) {
        if (block.equals(Blocks.BOOKSHELF)) {
            info.setReturnValue(this.isIn(BookshelfBlock.BOOKSHELF_TAG));
        }
    }
}