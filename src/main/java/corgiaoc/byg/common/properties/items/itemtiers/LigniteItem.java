package corgiaoc.byg.common.properties.items.itemtiers;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.item.Item.Properties;

public class LigniteItem extends Item {
    public LigniteItem(Properties builder) {
        super(builder);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 1400;
    }
}
