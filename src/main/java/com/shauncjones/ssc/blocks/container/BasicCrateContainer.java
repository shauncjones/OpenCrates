package com.shauncjones.ssc.blocks.container;

import com.shauncjones.ssc.blocks.tile.TileEntityBasicCrate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BasicCrateContainer extends Container{

	private int numRows;
	private TileEntityBasicCrate te;

    public BasicCrateContainer(IInventory playerInventory, TileEntityBasicCrate te) {
        this.te = te;

        // This container references items out of our own inventory (the 9 slots we hold ourselves)
        // as well as the slots from the player inventory so that the user can transfer items between
        // both inventories. The two calls below make sure that slots are defined for both inventories.
        //addOwnSlots();
        //addPlayerSlots(playerInventory);
        addSlots(playerInventory);
    }

    private void addSlots(IInventory playerInventory) {
    	IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		this.numRows = te.SIZE/9;
		
		for(int y = 0; y < numRows; ++y) {
			for(int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new SlotItemHandler(itemHandler, x + y * 9, 8 + x * 18, 18 + y * 18));
			}
		}
		
		for(int y = 0; y < 3; y++){
			for(int x = 0; x < 9; x++){
				this.addSlotToContainer(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 140 + y * 18));
			}
		}
		
		for(int x = 0; x < 9; x++){
			this.addSlotToContainer(new Slot(playerInventory, x, 8 + x * 18, 198));
		}
		
	}

	private void addPlayerSlots(IInventory playerInventory) {
        // Slots for the main inventory
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                int x = 9 + col * 18;
                int y = row * 18 + 70;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 10, x, y));
            }
        }

        // Slots for the hotbar
        for (int row = 0; row < 9; ++row) {
            int x = 9 + row * 18;
            int y = 58 + 70;
            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
        }
    }

    private void addOwnSlots() {
    	IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
    	int numRows = te.SIZE / 9;
    	for(int i = 0; i < numRows; ++i){
			for(int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new SlotItemHandler(itemHandler, j + i*9, 8 + j*18, 18 + i*18));
			}
		}
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < TileEntityBasicCrate.SIZE) {
                if (!this.mergeItemStack(itemstack1, TileEntityBasicCrate.SIZE, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, TileEntityBasicCrate.SIZE, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return te.canInteractWith(playerIn);
    }
	
}
