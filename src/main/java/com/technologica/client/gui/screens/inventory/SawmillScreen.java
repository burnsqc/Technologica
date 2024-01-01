package com.technologica.client.gui.screens.inventory;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.inventory.SawmillMenu;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SawmillScreen extends AbstractContainerScreen<SawmillMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new TechnologicaLocation("textures/gui/container/sawmill.png");

	public SawmillScreen(SawmillMenu screenContainerIn, Inventory playerInventoryIn, Component titleIn) {
		super(screenContainerIn, playerInventoryIn, Component.literal("Sawmill"));
		this.imageHeight = 165;
	}

	@Override
	public void init() {
		super.init();
		this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
	}

	@Override
	public void render(GuiGraphics matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		Lighting.setupForFlatItems();
		matrixStack.pose().pushPose();
		matrixStack.pose().popPose();
		matrixStack.pose().translate(256.0D, 96.0D, 0.0D);
		matrixStack.pose().popPose();
		Lighting.setupFor3DItems();
		this.renderTooltip(matrixStack, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		int i = (this.width - this.imageWidth) / 2;
		int j = (this.height - this.imageHeight) / 2;
		guiGraphics.blit(BACKGROUND_TEXTURE, i, j, 0, 0, this.imageWidth, 125);
		guiGraphics.blit(BACKGROUND_TEXTURE, i, j + 125, 0, 126, this.imageWidth, 105);
		int sawingTicks = this.menu.getSawingTicks() % 16;
		int sawingProgress = (int) (Math.round(this.menu.getSawingProgress()) * 0.3);
		guiGraphics.blit(BACKGROUND_TEXTURE, i + 81, j + 33 - sawingTicks, 176, 14 - sawingTicks, 14, sawingTicks); // Sawdust
		guiGraphics.blit(BACKGROUND_TEXTURE, i + 73, j + 34, 176, 14, sawingProgress, 17); // Arrow
	}
}