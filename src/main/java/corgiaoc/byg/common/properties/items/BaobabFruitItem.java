package corgiaoc.byg.common.properties.items;


import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class BaobabFruitItem extends BlockItem {
    public BaobabFruitItem(Block blockIn, Settings builder) {
        super(blockIn, builder);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    public String getTranslationKey() {
        return this.getOrCreateTranslationKey();
    }
}


