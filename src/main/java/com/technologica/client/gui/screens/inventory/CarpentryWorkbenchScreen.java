package com.technologica.client.gui.screens.inventory;

import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.inventory.CarpentryWorkbenchMenu;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CarpentryWorkbenchScreen extends AbstractInventoryContainerScreen<CarpentryWorkbenchMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new TechnologicaLocation("textures/gui/container/carpentry_workbench.png");

	public CarpentryWorkbenchScreen(CarpentryWorkbenchMenu screenContainerIn, Inventory playerInventoryIn, Component titleIn) {
		super(screenContainerIn, playerInventoryIn, titleIn, 166, BACKGROUND_TEXTURE);
	}
}
