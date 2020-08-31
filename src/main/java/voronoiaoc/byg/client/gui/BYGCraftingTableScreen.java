package voronoiaoc.byg.client.gui;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Block;

public class BYGCraftingTableScreen extends CraftingMenu {
    private final ContainerLevelAccess context;
    private final Block workBench;


    public BYGCraftingTableScreen(int syncId, Inventory playerInventory, ContainerLevelAccess context, Block workBench) {
        super(syncId, playerInventory, context);
        this.context = context;
        this.workBench = workBench;
    }

    @Override
    public boolean stillValid(Player player) {
        return isInUseDistance(this.context, player, this.workBench);
    }

    public static boolean isInUseDistance(ContainerLevelAccess context, Player player, Block block) {
        return context.evaluate((world, blockPos) ->
                world.getBlockState(blockPos).is(block) && player.distanceToSqr((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D) <= 64.0D, true);
    }
}
