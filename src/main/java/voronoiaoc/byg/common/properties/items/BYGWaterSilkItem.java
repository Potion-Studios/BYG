package voronoiaoc.byg.common.properties.items;//package voronoiaoc.byg.common.properties.items;


import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.RayTraceContext;
import net.minecraft.world.World;

//
public class BYGWaterSilkItem extends BlockItem {
    public BYGWaterSilkItem(Block blockIn, Settings builder) {
        super(blockIn, builder);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        return ActionResult.PASS;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        BlockHitResult blockHitResult = rayTrace(world, user, RayTraceContext.FluidHandling.SOURCE_ONLY);
        BlockHitResult blockHitResult2 = blockHitResult.method_29328(blockHitResult.getBlockPos().up());
        ActionResult actionResult = super.useOnBlock(new ItemUsageContext(user, hand, blockHitResult2));
        return new TypedActionResult(actionResult, user.getStackInHand(hand));
    }
}
