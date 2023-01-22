package com.technologica.world.inventory;

import com.technologica.world.level.block.entity.SawmillBlockEntity;

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

public class SawmillMenu extends AbstractContainerMenu {
	private final SawmillBlockEntity sawmillBlockEntity;

	public SawmillMenu(int windowIdIn, Level worldIn, BlockPos posIn, Inventory playerInventoryIn) {
		super(TechnologicaMenuType.SAWMILL.get(), windowIdIn);
		this.sawmillBlockEntity = (SawmillBlockEntity) worldIn.getBlockEntity(posIn);
		if (sawmillBlockEntity != null) {
			sawmillBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
				this.addSlot(new SlotItemHandler(handler, 0, 80, 62));
				this.addSlot(new SlotItemHandler(handler, 1, 44, 35));
				this.addSlot(new SlotItemHandler(handler, 2, 116, 35));
				this.addSlot(new SlotItemHandler(handler, 3, 107, 62));
				this.addSlot(new SlotItemHandler(handler, 4, 125, 62));
			});
		}
		for (int l = 0; l < 3; ++l) {
			for (int j1 = 0; j1 < 9; ++j1) {
				this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 48 + l * 18 + 36));
			}
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 141));
		}

	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index <= 4) {
				if (!this.moveItemStackTo(itemstack1, 5, this.slots.size(), false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemstack1, 0, 2, false)) {
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
		return TechnologicaMenuType.SAWMILL.get();
	}

	public BlockEntity getTileEntity() {
		return this.sawmillBlockEntity;
	}

	public int getSawingTicks() {
		return this.sawmillBlockEntity.getSawingTicks();
	}

	public double getSawingProgress() {
		return this.sawmillBlockEntity.getSawingProgress();
	}
}
