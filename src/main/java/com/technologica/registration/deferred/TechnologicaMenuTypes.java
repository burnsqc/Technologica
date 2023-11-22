package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.world.inventory.AnnunciatorMenu;
import com.technologica.world.inventory.MonitorMenu;
import com.technologica.world.inventory.SawmillMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaMenuTypes extends MasterDeferredRegistrar {
	
	public static int init() {
		MENU_TYPES.register(Technologica.MOD_EVENT_BUS);
		return MENU_TYPES.getEntries().size();
	}

	public static final RegistryObject<MenuType<AnnunciatorMenu>> ANNUNCIATOR = MENU_TYPES.register("annunciator_container", () -> IForgeMenuType.create((windowId, inv, data) -> {
		BlockPos pos = data.readBlockPos();
		Level world = inv.player.getCommandSenderWorld();
		return new AnnunciatorMenu(windowId, world, pos, inv);
	}));

	public static final RegistryObject<MenuType<MonitorMenu>> MONITOR = MENU_TYPES.register("monitor_container", () -> IForgeMenuType.create((windowId, inv, data) -> {
		BlockPos pos = data.readBlockPos();
		Level world = inv.player.getCommandSenderWorld();
		return new MonitorMenu(windowId, world, pos, inv);
	}));

	public static final RegistryObject<MenuType<SawmillMenu>> SAWMILL = MENU_TYPES.register("sawmill_container", () -> IForgeMenuType.create((windowId, inv, data) -> {
		BlockPos pos = data.readBlockPos();
		Level world = inv.player.getCommandSenderWorld();
		return new SawmillMenu(windowId, world, pos, inv);
	}));
}