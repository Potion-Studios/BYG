package potionstudios.byg.mixin.access;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PickaxeItem.class)
public interface PickaxeItemAccess {

    @Invoker("<init>")
    static PickaxeItem byg_create(Tier tier, int i, float f, Item.Properties properties) {
        throw new Error("Mixin did not apply");
    }
}
