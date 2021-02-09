package corgiaoc.byg.common.properties.items;


import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class LigniteBlockItem extends BlockItem {
    public LigniteBlockItem(Block blockIn, Settings builder) {
        super(blockIn, builder);
    }

    public int getBurnTime(ItemStack itemStack) {
        return 14000;
    }
}
