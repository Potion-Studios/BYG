package corgiaoc.byg.common.properties.items;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.item.Item.Properties;

public class AnthraciteItem extends Item {
    public AnthraciteItem(Properties builder) {
        super(builder);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 2400;
    }
}
