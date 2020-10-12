package corgiaoc.byg.common.properties.items.itemtiers;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LigniteItem extends Item {
    public LigniteItem(Properties builder) {
        super(builder);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 1400;
    }
}
