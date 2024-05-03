package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.world.inventory.AnnunciatorMenu;
import com.technologica.world.inventory.MonitorMenu;
import com.technologica.world.inventory.SawmillMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Menu Types.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaMenuTypes extends MasterDeferredRegistrar {

	public static int init() {
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