package com.technologica.client.gui.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.world.inventory.AbstractInventoryContainerMenu;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public abstract class AbstractInventoryContainerScreen<T extends AbstractInventoryContainerMenu> extends AbstractContainerScreen<T> {
	private static ResourceLocation BACKGROUND_TEXTURE;
	protected int startX;
	protected int startY;

	public AbstractInventoryContainerScreen(T inventoryContainerMenu, Inventory inventory, Component title, int imageHeight, ResourceLocation background) {
		super(inventoryContainerMenu, inventory, title);
		this.imageHeight = imageHeight;
		BACKGROUND_TEXTURE = background;
	}

	@Override
	public void init() {
		super.init();
		titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
		startX = (this.width - this.imageWidth) / 2;
		startY = (this.height - this.imageHeight) / 2;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		guiGraphics.blit(BACKGROUND_TEXTURE, startX, startY, 0, 0, this.imageWidth, this.imageHeight);
	}
}
