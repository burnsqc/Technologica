package com.technologica.world.inventory;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class AnnunciatorMenu extends AbstractContainerMenu {
	private final BlockEntity tileEntity;

	public AnnunciatorMenu(int windowIdIn, Level worldIn, BlockPos posIn, Inventory playerInventoryIn) {
		super(TechnologicaMenuType.ANNUNCIATOR.get(), windowIdIn);
		this.tileEntity = worldIn.getBlockEntity(posIn);

		for (int l = 0; l < 3; ++l) {
			for (int j1 = 0; j1 < 9; ++j1) {
				this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 112 + l * 18 + 36));
			}
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 206));
		}

		if (tileEntity != null) {
			tileEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(h -> {
				this.addSlot(new SlotItemHandler(h, 0, 80, 8));
			});
		}

	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index == 0) {
				if (!this.moveItemStackTo(itemstack1, 1, this.slots.size(), false)) {
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

	@Override
	public boolean stillValid(Player playerIn) {
		return true;
	}

	@Override
	public MenuType<?> getType() {
		return TechnologicaMenuType.ANNUNCIATOR.get();
	}

	public BlockEntity getTileEntity() {
		return this.tileEntity;
	}
}
