package voronoiaoc.byg.client.gui;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;

public class BYGCraftingTableScreen extends CraftingScreenHandler {
    private final ScreenHandlerContext context;
    private final Block workBench;


    public BYGCraftingTableScreen(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context, Block workBench) {
        super(syncId, playerInventory, context);
        this.context = context;
        this.workBench = workBench;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return isInUseDistance(this.context, player, this.workBench);
    }

    public static boolean isInUseDistance(ScreenHandlerContext context, PlayerEntity player, Block block) {
        return context.run((world, blockPos) ->
                world.getBlockState(blockPos).isOf(block) && player.squaredDistanceTo((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }
}
