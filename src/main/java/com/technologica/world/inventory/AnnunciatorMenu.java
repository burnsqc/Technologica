package com.technologica.world.inventory;

import com.technologica.registration.deferred.TechnologicaMenuTypes;
import com.technologica.world.level.block.entity.AnnunciatorBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class AnnunciatorMenu extends AbstractInventoryContainerMenu {
	private final AnnunciatorBlockEntity annunciatorBlockEntity;

	public AnnunciatorMenu(int windowId, Level level, BlockPos blockPos, Inventory inventory) {
		super(TechnologicaMenuTypes.ANNUNCIATOR.get(), windowId, level, blockPos, inventory);
		annunciatorBlockEntity = (AnnunciatorBlockEntity) level.getBlockEntity(blockPos);
		if (annunciatorBlockEntity != null) {
			annunciatorBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(itemHandler -> {
				addSlot(new SlotItemHandler(itemHandler, 0, 80, 8));
			});
		}
		addInventorySlots(8, 148);
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index == 0) {
				if (!moveItemStackTo(itemstack1, 1, slots.size(), false)) {
					return ItemStack.EMPTY;
				}
			} else if (!moveItemStackTo(itemstack1, 0, 1, false)) {
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

	@Override
	public boolean stillValid(Player player) {
		return true;
	}

	@Override
	public MenuType<?> getType() {
		return TechnologicaMenuTypes.ANNUNCIATOR.get();
	}

	public AnnunciatorBlockEntity getTileEntity() {
		return annunciatorBlockEntity;
	}
}
