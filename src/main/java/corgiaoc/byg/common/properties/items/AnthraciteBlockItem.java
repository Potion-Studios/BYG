package corgiaoc.byg.common.properties.items;


import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class AnthraciteBlockItem extends BlockItem {
    public AnthraciteBlockItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 20000;
    }
}
