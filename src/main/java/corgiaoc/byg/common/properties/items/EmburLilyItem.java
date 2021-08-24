package corgiaoc.byg.common.properties.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;

public class EmburLilyItem extends BlockItem {
    public EmburLilyItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    /**
     * Called when this item is used when targetting a Block
     */
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }

    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     * {@link #onItemUse}.
     */
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        BlockHitResult blockraytraceresult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.SOURCE_ONLY);
        BlockHitResult blockraytraceresult1 = blockraytraceresult.withPosition(blockraytraceresult.getBlockPos().above());
        InteractionResult actionresulttype = super.useOn(new UseOnContext(playerIn, handIn, blockraytraceresult1));
        return new InteractionResultHolder<>(actionresulttype, playerIn.getItemInHand(handIn));
    }
}
