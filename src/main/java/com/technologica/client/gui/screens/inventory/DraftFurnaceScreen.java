package com.technologica.client.gui.screens.inventory;

import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.inventory.DraftFurnaceMenu;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class DraftFurnaceScreen extends AbstractInventoryContainerScreen<DraftFurnaceMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new TechnologicaLocation("textures/gui/container/carpentry_workbench.png");

	public DraftFurnaceScreen(DraftFurnaceMenu screenContainerIn, Inventory playerInventoryIn, Component titleIn) {
		super(screenContainerIn, playerInventoryIn, titleIn, 166, BACKGROUND_TEXTURE);
	}
}
