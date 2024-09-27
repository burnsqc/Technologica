package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.world.inventory.AnnunciatorMenu;
import com.technologica.world.inventory.CarpentryWorkbenchMenu;
import com.technologica.world.inventory.MonitorMenu;
import com.technologica.world.inventory.SawmillMenu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Menu Types. The {@link #init} method
 * is called by {@link Technologica#initDeferredRegisters} and returns a
 * head-count to later be checked during registration and other setup
 * activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaMenuTypes extends MasterDeferredRegistrar {
	public static final RegistryObject<MenuType<AnnunciatorMenu>> ANNUNCIATOR = MENU_TYPES.register("annunciator_container", () -> IForgeMenuType.create((windowId, inv, data) -> new AnnunciatorMenu(windowId, inv.player.getCommandSenderWorld(), data.readBlockPos(), inv)));
	public static final RegistryObject<MenuType<MonitorMenu>> MONITOR = MENU_TYPES.register("monitor_container", () -> IForgeMenuType.create((windowId, inv, data) -> new MonitorMenu(windowId, inv.player.getCommandSenderWorld(), data.readBlockPos(), inv)));
	public static final RegistryObject<MenuType<SawmillMenu>> SAWMILL = MENU_TYPES.register("sawmill_container", () -> IForgeMenuType.create((windowId, inv, data) -> new SawmillMenu(windowId, inv.player.getCommandSenderWorld(), data.readBlockPos(), inv)));
	public static final RegistryObject<MenuType<CarpentryWorkbenchMenu>> CARPENTRY_WORKBENCH = MENU_TYPES.register("carpentry_workbench", () -> IForgeMenuType.create((windowId, inv, data) -> new CarpentryWorkbenchMenu(windowId, inv.player.getCommandSenderWorld(), data.readBlockPos(), inv)));
}
