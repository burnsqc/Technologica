package com.technologica.inventory.container;

import com.technologica.state.properties.TechnologicaBlockStateProperties;
import com.technologica.util.AnnunciatorOverlay;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AnnunciatorContainer extends Container {
	private final IInventory annunciatorOverlay = new Inventory(1) {
		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
			return stack.getItem().getRegistryName().getPath().contains("overlay");
		}

		@Override
		public int getInventoryStackLimit() {
			return 1;
		}
	};

	public AnnunciatorContainer(int windowIdIn, PlayerInventory playerInventoryIn, PacketBuffer bufferIn) {
		this(windowIdIn, playerInventoryIn, null, null, null);
	}
	
	public AnnunciatorContainer(int windowIdIn, PlayerInventory playerInventoryIn, World worldIn, BlockPos pos, BlockState stateIn) {
		super(TechnologicaContainerType.ANNUNCIATOR.get(), windowIdIn);
		assertInventorySize(annunciatorOverlay, 1);

		this.addSlot(new Slot(annunciatorOverlay, 0, 8 + 8 * 18, 90) {
			
			@Override
			public boolean isItemValid(ItemStack stack) {
				return stack.getItem().getRegistryName().getPath().contains("overlay");
			}
			
			/*
			@Override
			public void onSlotChanged() {
				this.inventory.markDirty();
				if (this.getStack().getItem().getRegistryName().getPath().contains("info")) {
					worldIn.setBlockState(pos, stateIn.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.INFO), 2);
				} else if (this.getStack().getItem().getRegistryName().getPath().contains("fail")) {
					worldIn.setBlockState(pos, stateIn.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.FAIL), 2);
				} else if (this.getStack().getItem().getRegistryName().getPath().contains("pass")) {
					worldIn.setBlockState(pos, stateIn.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.PASS), 2);
				} else if (this.getStack().getItem().getRegistryName().getPath().contains("warn")) {
					worldIn.setBlockState(pos, stateIn.with(TechnologicaBlockStateProperties.ANNUNCIATOR_OVERLAY, AnnunciatorOverlay.WARN), 2);
				}
			}
			*/
		});

		for (int l = 0; l < 3; ++l) {
			for (int j1 = 0; j1 < 9; ++j1) {
				this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + 36));
			}
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 161 + 36));
		}
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index == 0) {
				if (!this.mergeItemStack(itemstack1, 1, this.inventorySlots.size(), false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
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

	@Override
	public ContainerType<?> getType() {
		return TechnologicaContainerType.ANNUNCIATOR.get();
	}
}
