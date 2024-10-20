package com.technologica.client.gui.screens;

import java.util.Map;

import com.google.common.collect.Maps;
import com.technologica.client.gui.screens.inventory.AnnunciatorScreen;
import com.technologica.client.gui.screens.inventory.CarpentryWorkbenchScreen;
import com.technologica.client.gui.screens.inventory.MonitorScreen;
import com.technologica.client.gui.screens.inventory.SawmillScreen;
import com.technologica.registration.deferred.TechnologicaMenuTypes;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.MenuScreens.ScreenConstructor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class TechnologicaMenuScreens {
	public static final Map<MenuType<? extends AbstractContainerMenu>, MenuScreens.ScreenConstructor<AbstractContainerMenu, ?>> SCREENS = Maps.newHashMap();

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> void register(MenuType<? extends M> menu, MenuScreens.ScreenConstructor<M, U> screen) {
		MenuScreens.ScreenConstructor<?, ?> screenconstructor = SCREENS.put(menu, (ScreenConstructor<AbstractContainerMenu, ?>) screen);
		if (screenconstructor != null) {
			throw new IllegalStateException("Duplicate registration for " + BuiltInRegistries.MENU.getKey(menu));
		}
	}

	static {
		register(TechnologicaMenuTypes.ANNUNCIATOR.get(), AnnunciatorScreen::new);
		register(TechnologicaMenuTypes.MONITOR.get(), MonitorScreen::new);
		register(TechnologicaMenuTypes.SAWMILL.get(), SawmillScreen::new);
		register(TechnologicaMenuTypes.CARPENTRY_WORKBENCH.get(), CarpentryWorkbenchScreen::new);
	}
}
