package corgiaoc.byg.client.gui;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;

public class BYGWorkbenchContainer extends CraftingScreenHandler {
    private final Block workbench;
    private final ScreenHandlerContext worldPos;

    public BYGWorkbenchContainer(int id, PlayerInventory playerInv, ScreenHandlerContext worldPos, Block workbench) {
        super(id, playerInv, worldPos);
        this.workbench = workbench;
        this.worldPos = worldPos;
    }

    protected static boolean canUse(ScreenHandlerContext worldPos, PlayerEntity playerIn, Block targetBlock) {
        return worldPos.run((world, pos) ->
        {
            return world.getBlockState(pos).getBlock() == targetBlock && playerIn.squaredDistanceTo((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D) <= 64.0D;
        }, true);
    }

    @Override
    public boolean canUse(PlayerEntity playerIn) {
        return canUse(this.worldPos, playerIn, this.workbench);
    }
}
