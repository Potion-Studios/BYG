package corgiaoc.byg.client.gui;

import corgiaoc.byg.common.entity.tileentities.HypogealImperiumTE;
import corgiaoc.byg.core.world.BYGContainerTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;

import java.util.Objects;

public class HypogealImperiumContainer extends Container {

    public final IInventory inventory;
    private final IIntArray fuelTime;


    public HypogealImperiumContainer(int windowId, PlayerInventory playerInv) {
        this(windowId, playerInv, new Inventory(3), new IntArray(2));
    }

    public HypogealImperiumContainer(int windowId, PlayerInventory playerInv, IInventory inventory, IIntArray fuelTime) {
        super(BYGContainerTypes.HYPOGEAL_CONTAINER, windowId);
        this.fuelTime = fuelTime;

        this.addSlot(new CrystalSlot(inventory, 0, 17, 17));
        this.addSlot(new Slot(inventory, 1, 79, 58));
        this.addSlot(new NumberSlot(inventory, 2, 79, 17));

        this.inventory = inventory;

        // Main Inventory
        int startX = 8;
        int startY = 84;
        int slotSizePlus2 = 18;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(playerInv, 9 + (row * 9) + column, startX + (column * slotSizePlus2),
                        startY + (row * slotSizePlus2)));
            }
        }

        // Hotbar
        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(playerInv, column, startX + (column * slotSizePlus2), 142));
        }

        this.addDataSlots(fuelTime);
    }

    private static HypogealImperiumTE getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
        Objects.requireNonNull(playerInv, "playerInv cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileAtPos = playerInv.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof HypogealImperiumTE) {
            return (HypogealImperiumTE) tileAtPos;
        }
        throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < 1) {
                if (!this.moveItemStackTo(itemstack1, 1, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemstack;
    }

    public void onContainerClosed(PlayerEntity playerIn) {
        super.removed(playerIn);
    }


    @Override
    public boolean stillValid(PlayerEntity playerIn) {
        return this.inventory.stillValid(playerIn);
    }

    public IIntArray getFuelTime() {
        return fuelTime;
    }

    static class CrystalSlot extends Slot {
        public CrystalSlot(IInventory p_i47069_1_, int p_i47069_2_, int p_i47069_3_, int p_i47069_4_) {
            super(p_i47069_1_, p_i47069_2_, p_i47069_3_, p_i47069_4_);
        }

        public boolean mayPlace(ItemStack stack) {
            return true;
        }

        public int getMaxStackSize() {
            return 64;
        }
    }

    static class NumberSlot extends Slot {
        public NumberSlot(IInventory p_i47069_1_, int p_i47069_2_, int p_i47069_3_, int p_i47069_4_) {
            super(p_i47069_1_, p_i47069_2_, p_i47069_3_, p_i47069_4_);
        }

        public boolean mayPlace(ItemStack stack) {
            return false;
        }

        public int getMaxStackSize() {
            return 18;
        }

        @Override
        public boolean mayPickup(PlayerEntity p_82869_1_) {
            return false;
        }
    }
}