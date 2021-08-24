package corgiaoc.byg.common.properties.items;


import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.block.Block;

public class BaobabFruitItem extends BlockItem {
    public BaobabFruitItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}


