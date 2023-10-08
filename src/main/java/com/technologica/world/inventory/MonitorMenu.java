package com.technologica.world.inventory;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class MonitorMenu extends AbstractContainerMenu {
	private final BlockEntity tileEntity;

	public MonitorMenu(int windowIdIn, Level worldIn, BlockPos posIn, Inventory playerInventoryIn) {
		super(TechnologicaMenuType.MONITOR.get(), windowIdIn);
		this.tileEntity = worldIn.getBlockEntity(posIn);
	}

	@Override
	public boolean stillValid(Player playerIn) {
		return true;
	}

	@Override
	public MenuType<?> getType() {
		return TechnologicaMenuType.MONITOR.get();
	}

	public BlockEntity getTileEntity() {
		return this.tileEntity;
	}

	@Override
	public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
		return null;
	}
}
