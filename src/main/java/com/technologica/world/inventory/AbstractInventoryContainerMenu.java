package com.technologica.world.inventory;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class AbstractInventoryContainerMenu extends AbstractContainerMenu {
	protected Inventory inventory;
	protected int slotNumber = 0;
	protected int playerInventoryBegin;
	protected int playerHotbarBegin;
	protected int playerInventoryEnd;

	public AbstractInventoryContainerMenu(@Nullable MenuType<?> menuType, int containerId, Level level, BlockPos blockPos, Inventory inventory) {
		super(menuType, containerId);
		this.inventory = inventory;
	}

	/**
	 * This method should be called in the constructor after adding the menu's
	 * inventory slots. This will ensure that the menu's slots start at zero, and
	 * the player's inventory picks up where the menu left off.
	 */
	public void addInventorySlots(int xOffset, int yOffset) {
		playerInventoryBegin = slots.size();
		slotNumber = 0;
		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 9; ++column) {
				addSlot(new Slot(inventory, slotNumber++, (column * 18) + xOffset, (row * 18) + yOffset));
			}
		}
		playerHotbarBegin = slots.size() - 1;
		for (int column = 0; column < 9; ++column) {
			addSlot(new Slot(inventory, slotNumber++, (column * 18) + xOffset, yOffset + 58));
		}
		playerInventoryEnd = slots.size() - 1;
	}

	@Override
	public ItemStack quickMoveStack(Player player, int clickedSlotIndex) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot clickedSlot = slots.get(clickedSlotIndex);
		if (clickedSlot != null && clickedSlot.hasItem()) { // If clicked slot actually exists and has an item
			ItemStack clickedItemStack = clickedSlot.getItem();
			itemstack = clickedItemStack.copy();
			if (clickedSlotIndex == 0) { // If the clicked slot is the output slot
				// this.access.execute((p_39378_, p_39379_) -> {
				// itemstack1.getItem().onCraftedBy(itemstack1, p_39378_, player);
				// });
				if (!this.moveItemStackTo(clickedItemStack, playerInventoryBegin, playerInventoryEnd + 1, true)) { // Try to move stack to player's inventory in reverse order, but if you can't...
					return ItemStack.EMPTY; // Fail to move stack and exit
				}
				clickedSlot.onQuickCraft(clickedItemStack, itemstack);
			} else if (clickedSlotIndex >= playerInventoryBegin && clickedSlotIndex <= playerInventoryEnd) { // If the clicked slot is in the player's inventory
				if (!this.moveItemStackTo(clickedItemStack, 1, playerInventoryBegin - 1, false)) { // Try to move stack to input slot(s), but if you can't...
					if (clickedSlotIndex < playerHotbarBegin) { // If the clicked slot is in the player's main inventory
						if (!this.moveItemStackTo(clickedItemStack, playerHotbarBegin, playerInventoryEnd, false)) { // Try to move stack to player's hotbar, but if you can't...
							return ItemStack.EMPTY; // Fail to move stack and exit
						}
					} else if (!this.moveItemStackTo(clickedItemStack, playerInventoryBegin, playerHotbarBegin - 1, false)) { // Try to move stack to player's inventory, but if you can't...
						return ItemStack.EMPTY; // Fail to move stack and exit
					}
				}
			} else if (!this.moveItemStackTo(clickedItemStack, playerInventoryBegin, playerInventoryEnd, false)) { // Try to move stack to player's inventory, but if you can't...
				return ItemStack.EMPTY; // Fail to move stack and exit
			}

			if (clickedItemStack.isEmpty()) {
				clickedSlot.setByPlayer(ItemStack.EMPTY);
			} else {
				clickedSlot.setChanged();
			}

			if (clickedItemStack.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY; // Fail the stack move and exit
			}

			clickedSlot.onTake(player, clickedItemStack);
		}

		return itemstack;
	}
}
