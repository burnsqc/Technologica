package com.technologica.world.inventory;

import com.technologica.registration.deferred.TechnologicaMenuTypes;
import com.technologica.world.level.block.entity.SawmillBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class SawmillMenu extends AbstractInventoryContainerMenu {
	private final SawmillBlockEntity sawmillBlockEntity;

	public SawmillMenu(int windowId, Level level, BlockPos blockPos, Inventory inventory) {
		super(TechnologicaMenuTypes.SAWMILL.get(), windowId, level, blockPos, inventory);
		sawmillBlockEntity = (SawmillBlockEntity) level.getBlockEntity(blockPos);
		if (sawmillBlockEntity != null) {
			sawmillBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(itemHandler -> {
				addSlot(new SlotItemHandler(itemHandler, 0, 80, 62));
				addSlot(new SlotItemHandler(itemHandler, 1, 44, 35));
				addSlot(new SlotItemHandler(itemHandler, 2, 116, 35));
				addSlot(new SlotItemHandler(itemHandler, 3, 107, 62));
				addSlot(new SlotItemHandler(itemHandler, 4, 125, 62));
			});
		}
		addInventorySlots(8, 84);
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index <= 4) {
				if (!moveItemStackTo(itemstack1, 5, slots.size(), false)) {
					return ItemStack.EMPTY;
				}
			} else if (!moveItemStackTo(itemstack1, 0, 2, false)) {
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
		return TechnologicaMenuTypes.SAWMILL.get();
	}

	public int getSawingTicks() {
		return sawmillBlockEntity.getSawingTicks();
	}

	public double getSawingProgress() {
		return sawmillBlockEntity.getSawingProgress();
	}
}
