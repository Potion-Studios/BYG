package corgiaoc.byg.mixin.access;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;

@Mixin(HoeItem.class)
public interface HoeItemAccess {

    @Invoker("<init>")
    static HoeItem create(Tier tier, int i, float f, Item.Properties properties) {
        throw new Error("Mixin did not apply");
    }

    @Accessor("TILLABLES")
    static Map<Block, BlockState> getTillables() {
        throw new Error("Mixin did not apply");
    }

    @Accessor("TILLABLES")
    static void setTillables(Map<Block, BlockState> newMap) {
        throw new Error("Mixin did not apply");
    }
}
