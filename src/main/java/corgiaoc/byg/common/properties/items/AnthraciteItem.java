package corgiaoc.byg.common.properties.items;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AnthraciteItem extends Item {
    public AnthraciteItem(Settings builder) {
        super(builder);
    }

    public int getBurnTime(ItemStack itemStack) {
        return 2400;
    }
}
