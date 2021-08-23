package corgiaoc.byg.common.properties.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.world.World;

public class EmburLilyItem extends BlockItem {
    public EmburLilyItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    /**
     * Called when this item is used when targetting a Block
     */
    public ActionResultType useOn(ItemUseContext context) {
        return ActionResultType.PASS;
    }

    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     * {@link #onItemUse}.
     */
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        BlockRayTraceResult blockraytraceresult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
        BlockRayTraceResult blockraytraceresult1 = blockraytraceresult.withPosition(blockraytraceresult.getBlockPos().above());
        ActionResultType actionresulttype = super.useOn(new ItemUseContext(playerIn, handIn, blockraytraceresult1));
        return new ActionResult<>(actionresulttype, playerIn.getItemInHand(handIn));
    }
}
