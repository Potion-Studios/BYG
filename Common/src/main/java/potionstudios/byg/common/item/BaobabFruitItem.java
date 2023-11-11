package potionstudios.byg.common.item;


import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class BaobabFruitItem extends BlockItem {
    public BaobabFruitItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    public int getUseDuration(@NotNull ItemStack stack) {
        return 32;
    }

    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.EAT;
    }

    public @NotNull String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}


