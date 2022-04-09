package potionstudios.byg.mixin.access.world.entity.npc.villagertrades;

import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(VillagerTrades.EmeraldForItems.class)
public interface EmeraldForItemsAccess {

    @Accessor("item")
    Item byg_getItem();

    @Accessor("cost")
    int byg_getCost();

    @Accessor("maxUses")
    int byg_getMaxUses();

    @Accessor("villagerXp")
    int byg_getVillagerXp();

    @Accessor("priceMultiplier")
    float byg_getPriceMultiplier();
}
