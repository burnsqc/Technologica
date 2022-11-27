package com.technologica.client.gui.screens.inventory;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.Technologica;
import com.technologica.world.inventory.SawmillContainer;
import com.technologica.world.level.block.entity.SawmillBlockEntity;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SawmillScreen extends AbstractContainerScreen<SawmillContainer> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/gui/container/sawmill.png");
	private SawmillBlockEntity tileEntity;
	private int updateCounter;

	public SawmillScreen(SawmillContainer screenContainerIn, Inventory playerInventoryIn, Component titleIn) {
		super(screenContainerIn, playerInventoryIn, Component.literal("Sawmill"));
		this.passEvents = false;
		this.imageHeight = 165;
		this.tileEntity = (SawmillBlockEntity) screenContainerIn.getTileEntity();
	}

	@Override
	public void init() {
	      super.init();
	      this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
	   }
	
	@Override
	public void removed() {
		this.minecraft.keyboardHandler.setSendRepeatsToGui(false);
		ClientPacketListener clientplaynethandler = this.minecraft.getConnection();
	}

	@Override
	public void containerTick() {
		++this.updateCounter;
	}

	private void close() {
		this.tileEntity.setChanged();
		this.minecraft.setScreen((Screen) null);
	}

	@Override
	public void onClose() {
		this.close();
	}

	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		Lighting.setupForFlatItems();

		matrixStack.pushPose();
		boolean flag1 = this.updateCounter / 6 % 2 == 0;

		matrixStack.pushPose();
		MultiBufferSource.BufferSource irendertypebuffer$impl = this.minecraft.renderBuffers().bufferSource();
		matrixStack.popPose();

		matrixStack.translate(256.0D, 96.0D, 0.0D);

		

		matrixStack.popPose();
		Lighting.setupFor3DItems();
		this.renderTooltip(matrixStack, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack matrixStack, float partialTicks, int x, int y) {
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		int i = (this.width - this.imageWidth) / 2;
		int j = (this.height - this.imageHeight) / 2;
		this.blit(matrixStack, i, j, 0, 0, this.imageWidth, 125);
		this.blit(matrixStack, i, j + 125, 0, 126, this.imageWidth, 105);
	}
}
