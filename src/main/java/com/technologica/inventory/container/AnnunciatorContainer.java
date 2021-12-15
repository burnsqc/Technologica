package com.technologica.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class AnnunciatorContainer extends Container {
	private final IInventory annunciatorOverlay = new Inventory(1);
	final Slot inputInventorySlot;

	public AnnunciatorContainer(int windowIdIn, PlayerInventory playerInventoryIn, PacketBuffer bufferIn) {
		this(windowIdIn, playerInventoryIn);
	}

	public AnnunciatorContainer(int windowIdIn, PlayerInventory playerInventoryIn) {
		super(TechnologicaContainerType.ANNUNCIATOR.get(), windowIdIn);
		assertInventorySize(annunciatorOverlay, 1);
		
		this.inputInventorySlot = this.addSlot(new Slot(annunciatorOverlay, 0, 8 + 8 * 18, 18));

		for (int l = 0; l < 3; ++l) {
			for (int j1 = 0; j1 < 9; ++j1) {
				this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + 36));
			}
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 161 + 36));
		}
	}

	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index < 6 * 9) {
				if (!this.mergeItemStack(itemstack1, 9, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, 9, false)) {
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
	public boolean canInteractWith(PlayerEntity playerIn) {
		return true;
	}

	public ContainerType<?> getType() {
		return TechnologicaContainerType.ANNUNCIATOR.get();
	}

}
