package voronoiaoc.byg.mixin.common;

import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static voronoiaoc.byg.common.properties.blocks.BookshelfBlock.BOOKSHELF_TAG;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class AbstractBlockStateBookshelfMixin {
    @Shadow
    public abstract boolean is(Tag<Block> tag);

    @Inject(at = @At("HEAD"), method = "is(Lnet/minecraft/world/level/block/Block;)Z", cancellable = true)
    private void isBookshelf(Block block, CallbackInfoReturnable<Boolean> info) {
        if (block.equals(Blocks.BOOKSHELF)) {
            info.setReturnValue(this.is(BOOKSHELF_TAG));
        }
    }
}
