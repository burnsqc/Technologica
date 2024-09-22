package com.technologica.world.inventory;

import com.technologica.registration.deferred.TechnologicaMenuTypes;
import com.technologica.world.level.block.entity.MonitorBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MonitorMenu extends AbstractContainerMenu {
	private final MonitorBlockEntity monitorBlockEntity;

	public MonitorMenu(int windowId, Level level, BlockPos blockPos, Inventory inventory) {
		super(TechnologicaMenuTypes.MONITOR.get(), windowId);
		monitorBlockEntity = (MonitorBlockEntity) level.getBlockEntity(blockPos);
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		return null;
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}

	@Override
	public MenuType<?> getType() {
		return TechnologicaMenuTypes.MONITOR.get();
	}

	public MonitorBlockEntity getTileEntity() {
		return monitorBlockEntity;
	}
}
