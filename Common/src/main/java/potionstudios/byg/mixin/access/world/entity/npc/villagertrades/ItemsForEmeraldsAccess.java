package potionstudios.byg.mixin.access.world.entity.npc.villagertrades;

import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(VillagerTrades.ItemsForEmeralds.class)
public interface ItemsForEmeraldsAccess {


    @Accessor("itemStack")
    ItemStack byg_getItemStack();

    @Accessor("emeraldCost")
    int byg_getEmeraldCost();

    @Accessor("numberOfItems")
    int byg_getNumberOfItems();

    @Accessor("maxUses")
    int byg_getMaxUses();

    @Accessor("villagerXp")
    int byg_getVillagerXp();

    @Accessor("priceMultiplier")
    float byg_getPriceMultiplier();

}
