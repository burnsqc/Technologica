package com.technologica.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class AnnunciatorContainer extends Container {
	private final TileEntity tileEntity;
	
	public AnnunciatorContainer(int windowIdIn, World worldIn, BlockPos posIn, PlayerInventory playerInventoryIn) {
		super(TechnologicaContainerType.ANNUNCIATOR.get(), windowIdIn);
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
			tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
				this.addSlot(new SlotItemHandler(h, 0, 80, 8)); 	
			});
		}
		
	}

	@Override
	public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
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
	public boolean stillValid(PlayerEntity playerIn) {
		return true;
	}

	@Override
	public ContainerType<?> getType() {
		return TechnologicaContainerType.ANNUNCIATOR.get();
	}
	
	public TileEntity getTileEntity() {
		return this.tileEntity;
	}
}
