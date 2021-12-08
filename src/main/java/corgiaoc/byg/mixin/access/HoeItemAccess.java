package corgiaoc.byg.mixin.access;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.HoeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(HoeItem.class)
public interface HoeItemAccess {

    @Accessor("TILLABLES")
    static Map<Block, BlockState> getTillables() {
        throw new Error("Mixin did not apply");
    }

    @Accessor("TILLABLES")
    static void setTillables(Map<Block, BlockState> newMap) {
        throw new Error("Mixin did not apply");
    }
}
