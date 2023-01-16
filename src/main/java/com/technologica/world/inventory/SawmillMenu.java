package com.technologica.world.inventory;

import com.technologica.world.item.TechnologicaItems;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class SawmillMenu extends AbstractContainerMenu {
	private final Container sawmill;

	public SawmillMenu(int windowIdIn, Inventory inventoryIn) {
		this(windowIdIn, inventoryIn, new SimpleContainer(5), new SimpleContainerData(2));
	}

	public SawmillMenu(int windowIdIn, Inventory p_39094_, Container p_39095_, ContainerData p_39096_) {
		super(TechnologicaMenuType.SAWMILL.get(), windowIdIn);
		this.sawmill = p_39095_;

		for (int l = 0; l < 3; ++l) {
			for (int j1 = 0; j1 < 9; ++j1) {
				this.addSlot(new Slot(p_39094_, j1 + l * 9 + 9, 8 + j1 * 18, 48 + l * 18 + 36));
			}
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			this.addSlot(new Slot(p_39094_, i1, 8 + i1 * 18, 141));
		}

		this.addSlot(new SawbladeSlot(p_39095_, 0, 80, 62));
		this.addSlot(new IngredientsSlot(p_39095_, 1, 44, 35));
		this.addSlot(new Slot(p_39095_, 2, 116, 35));
		this.addSlot(new Slot(p_39095_, 3, 107, 62));
		this.addSlot(new Slot(p_39095_, 4, 125, 62));
	}

	@Override
	public boolean stillValid(Player playerIn) {
		return this.sawmill.stillValid(playerIn);
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

	static class SawbladeSlot extends Slot {
		public SawbladeSlot(Container p_39115_, int p_39116_, int p_39117_, int p_39118_) {
			super(p_39115_, p_39116_, p_39117_, p_39118_);
		}

		@Override
		public boolean mayPlace(ItemStack stack) {
			return stack.is(TechnologicaItems.SAWBLADE.get());
		}

		@Override
		public int getMaxStackSize() {
			return 1;
		}
	}

	static class IngredientsSlot extends Slot {
		public IngredientsSlot(Container p_39115_, int p_39116_, int p_39117_, int p_39118_) {
			super(p_39115_, p_39116_, p_39117_, p_39118_);
		}

		@Override
		public boolean mayPlace(ItemStack stack) {
			return ForgeRegistries.ITEMS.tags().getTag(ItemTags.LOGS).contains(stack.getItem()) || ForgeRegistries.ITEMS.tags().getTag(ItemTags.PLANKS).contains(stack.getItem());
		}

		@Override
		public int getMaxStackSize() {
			return 64;
		}
	}
}
