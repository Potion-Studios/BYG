package corgiaoc.byg.mixin.access;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.AxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(AxeItem.class)
public interface AxeItemAccess {

    @Accessor("STRIPABLES")
    static Map<Block, BlockState> getStripables() {
        throw new Error("Mixin did not apply");
    }

    @Accessor("STRIPABLES")
    static void setStripables(Map<Block, BlockState> newMap) {
        throw new Error("Mixin did not apply");
    }
}
