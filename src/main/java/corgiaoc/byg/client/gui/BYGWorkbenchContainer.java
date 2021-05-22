package corgiaoc.byg.client.gui;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

public class BYGWorkbenchContainer extends WorkbenchContainer {
    private final Block workbench;
    private final IWorldPosCallable worldPos;

    public BYGWorkbenchContainer(int id, PlayerInventory playerInv, IWorldPosCallable worldPos, Block workbench) {
        super(id, playerInv, worldPos);
        this.workbench = workbench;
        this.worldPos = worldPos;
    }

    protected static boolean isWithinUsableDistance(IWorldPosCallable worldPos, PlayerEntity playerIn, Block targetBlock) {
        return worldPos.evaluate((world, pos) ->
        {
            return world.getBlockState(pos).getBlock() == targetBlock && playerIn.distanceToSqr((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D) <= 64.0D;
        }, true);
    }

    @Override
    public boolean stillValid(PlayerEntity playerIn) {
        return isWithinUsableDistance(this.worldPos, playerIn, this.workbench);
    }
}
