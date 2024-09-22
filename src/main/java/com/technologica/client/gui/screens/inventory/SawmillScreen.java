package com.technologica.client.gui.screens.inventory;

import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.inventory.SawmillMenu;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SawmillScreen extends AbstractInventoryContainerScreen<SawmillMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new TechnologicaLocation("textures/gui/container/sawmill.png");

	public SawmillScreen(SawmillMenu screenContainerIn, Inventory playerInventoryIn, Component titleIn) {
		super(screenContainerIn, playerInventoryIn, titleIn, 166, BACKGROUND_TEXTURE);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
		super.renderBg(guiGraphics, partialTicks, x, y);
		int sawingTicks = this.menu.getSawingTicks() % 16;
		int sawingProgress = (int) (Math.round(this.menu.getSawingProgress()) * 0.3);
		guiGraphics.blit(BACKGROUND_TEXTURE, startX + 81, startY + 33 - sawingTicks, 176, 14 - sawingTicks, 14, sawingTicks); // Sawdust
		guiGraphics.blit(BACKGROUND_TEXTURE, startX + 73, startY + 34, 176, 14, sawingProgress, 17); // Arrow
	}
}