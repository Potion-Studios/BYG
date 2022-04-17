package potionstudios.byg.mixin.access.world.entity.npc.villagertrades;

import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(VillagerTrades.ItemsAndEmeraldsToItems.class)
public interface ItemsAndEmeraldsForItemsAccess {
    @Accessor("fromItem")
    ItemStack byg_getFromItem();

    @Accessor("fromCount")
    int byg_getFromCount();

    @Accessor("emeraldCost")
    int byg_getEmeraldCost();

    @Accessor("toItem")
    ItemStack byg_getToItem();

    @Accessor("toCount")
    int byg_getToCount();

    @Accessor("maxUses")
    int byg_getMaxUses();

    @Accessor("villagerXp")
    int byg_getVillagerXp();

    @Accessor("priceMultiplier")
    float byg_getPriceMultiplier();
}
