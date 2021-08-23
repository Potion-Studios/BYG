package corgiaoc.byg.common.properties.items;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AnthraciteItem extends Item {
    public AnthraciteItem(Properties builder) {
        super(builder);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 2400;
    }
}
