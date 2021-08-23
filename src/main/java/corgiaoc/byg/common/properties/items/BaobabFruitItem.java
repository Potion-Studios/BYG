package corgiaoc.byg.common.properties.items;


import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;

public class BaobabFruitItem extends BlockItem {
    public BaobabFruitItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.EAT;
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}


