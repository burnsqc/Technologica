package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.world.inventory.AnnunciatorMenu;
import com.technologica.world.inventory.CarpentryWorkbenchMenu;
import com.technologica.world.inventory.MonitorMenu;
import com.technologica.world.inventory.SawmillMenu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaMenuTypes {
	public static final RegistryObject<MenuType<AnnunciatorMenu>> ANNUNCIATOR = Technologica.MENU_TYPES.register("annunciator_container", () -> IForgeMenuType.create((windowId, inv, data) -> new AnnunciatorMenu(windowId, inv.player.getCommandSenderWorld(), data.readBlockPos(), inv)));
	public static final RegistryObject<MenuType<MonitorMenu>> MONITOR = Technologica.MENU_TYPES.register("monitor_container", () -> IForgeMenuType.create((windowId, inv, data) -> new MonitorMenu(windowId, inv.player.getCommandSenderWorld(), data.readBlockPos(), inv)));
	public static final RegistryObject<MenuType<SawmillMenu>> SAWMILL = Technologica.MENU_TYPES.register("sawmill_container", () -> IForgeMenuType.create((windowId, inv, data) -> new SawmillMenu(windowId, inv.player.getCommandSenderWorld(), data.readBlockPos(), inv)));
	public static final RegistryObject<MenuType<CarpentryWorkbenchMenu>> CARPENTRY_WORKBENCH = Technologica.MENU_TYPES.register("carpentry_workbench", () -> IForgeMenuType.create((windowId, inv, data) -> new CarpentryWorkbenchMenu(windowId, inv.player.getCommandSenderWorld(), data.readBlockPos(), inv)));
}
