package com.technologica.client.gui.screens.inventory;

import java.util.stream.IntStream;

import org.joml.Matrix4f;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.technologica.Technologica;
import com.technologica.network.packets.ServerboundUpdateMonitorPacket;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.inventory.MonitorMenu;
import com.technologica.world.level.block.entity.MonitorBlockEntity;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.font.TextFieldHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MonitorScreen extends AbstractContainerScreen<MonitorMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new TechnologicaLocation("textures/gui/container/monitor_screen.png");
	private MonitorBlockEntity tileEntity;
	private TextFieldHelper textInputUtil;
	private String[] multiLineText;
	private static final ResourceLocation FULLSPACE_FONT = new TechnologicaLocation("full_space");
	private static final Style FULLSPACE_FONT_STYLE = Style.EMPTY.withFont(FULLSPACE_FONT);
	private int editLine;
	private int updateCounter;
	protected int imageWidth = 224;

	public MonitorScreen(MonitorMenu screenContainerIn, Inventory playerInventoryIn, Component titleIn) {
		super(screenContainerIn, playerInventoryIn, Component.literal("Monitor"));
		this.imageHeight = 231;
		this.inventoryLabelY = 137;
		this.tileEntity = (MonitorBlockEntity) screenContainerIn.getTileEntity();
		this.multiLineText = IntStream.range(0, 16).mapToObj(tileEntity::getText).map(Component::getString).toArray((p_243354_0_) -> {
			return new String[p_243354_0_];
		});
	}

	@Override
	protected void init() {
		super.init();
		this.tileEntity.setEditable(false);
		this.textInputUtil = new TextFieldHelper(() -> {
			return this.multiLineText[this.editLine];
		}, (p_238850_1_) -> {
			this.multiLineText[this.editLine] = p_238850_1_;
			this.tileEntity.setText(this.editLine, Component.literal(p_238850_1_).setStyle(FULLSPACE_FONT_STYLE));
		}, TextFieldHelper.createClipboardGetter(this.minecraft), TextFieldHelper.createClipboardSetter(this.minecraft), (p_238848_1_) -> {
			return this.minecraft.font.width(p_238848_1_) <= 192;
		});
	}

	@Override
	public void removed() {
		Connection clientplaynethandler = this.minecraft.getConnection().getConnection();
		if (clientplaynethandler != null) {
			Technologica.CHANNEL.sendToServer(new ServerboundUpdateMonitorPacket(this.tileEntity.getBlockPos(), this.multiLineText[0], this.multiLineText[1], this.multiLineText[2], this.multiLineText[3], this.multiLineText[4], this.multiLineText[5], this.multiLineText[6], this.multiLineText[7], this.multiLineText[8], this.multiLineText[9], this.multiLineText[10], this.multiLineText[11], this.multiLineText[12], this.multiLineText[13], this.multiLineText[14], this.multiLineText[15]));
		}
		this.tileEntity.setEditable(true);
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
	public boolean charTyped(char charIn, int modifiersIn) {
		this.textInputUtil.charTyped(charIn);
		return true;
	}

	@Override
	public void onClose() {
		this.close();
	}

	@Override
	public boolean keyPressed(int keyCodeIn, int scanCodeIn, int modifiersIn) {
		if (keyCodeIn == 265) {
			this.editLine = this.editLine - 1 & 15;
			this.textInputUtil.setCursorToEnd();
			return true;
		} else if (keyCodeIn != 264 && keyCodeIn != 257 && keyCodeIn != 335) {
			if (this.textInputUtil.keyPressed(keyCodeIn)) {
				return true;
			} else {
				if (keyCodeIn == 256 && this.shouldCloseOnEsc()) {
					this.onClose();
					return true;
				} else if (keyCodeIn == 258) {
					return false;
				} else {
					return this.getFocused() != null && this.getFocused().keyPressed(keyCodeIn, scanCodeIn, modifiersIn);
				}
			}
		} else {
			this.editLine = this.editLine + 1 & 15;
			this.textInputUtil.setCursorToEnd();
			return true;
		}
	}

	@Override
	public void render(GuiGraphics matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		this.renderBg(matrixStack, partialTicks, mouseX, mouseY);
		Lighting.setupForFlatItems();

		matrixStack.pose().pushPose();
		boolean flag1 = this.updateCounter / 12 % 2 == 0;

		matrixStack.pose().pushPose();
		MultiBufferSource.BufferSource irendertypebuffer$impl = this.minecraft.renderBuffers().bufferSource();
		matrixStack.pose().popPose();

		matrixStack.pose().translate(256.0D, 96.0D, 0.0D);

		int color = 0x00FF00;
		int j = this.textInputUtil.getCursorPos();
		int k = this.textInputUtil.getSelectionPos();
		int l = this.editLine * 9 - this.multiLineText.length * 5 + 24;
		Matrix4f matrix4f = matrixStack.pose().last().pose();

		for (int lineCount = 0; lineCount < this.multiLineText.length; ++lineCount) {
			String s = this.multiLineText[lineCount];

			if (s != null) {
				if (this.font.isBidirectional()) {
					s = this.font.bidirectionalShaping(s);
				}

				Component text = Component.literal(s).setStyle(FULLSPACE_FONT_STYLE);

				float posHorizontal = -96;
				this.minecraft.font.drawInBatch(text, posHorizontal, lineCount * 9 - this.multiLineText.length * 5 + 24, color, false, matrix4f, irendertypebuffer$impl, Font.DisplayMode.POLYGON_OFFSET, 0, 15728880);

				if (lineCount == this.editLine && j >= 0 && flag1) {
					int j1 = Math.max(Math.min(j, s.length()) * 6, 0);
					int k1 = j1 - 96;
					this.minecraft.font.drawInBatch("▊", k1, l, color, false, matrix4f, irendertypebuffer$impl, Font.DisplayMode.POLYGON_OFFSET, 0, 15728880, false);
				}
			}
		}

		irendertypebuffer$impl.endBatch();

		for (int i3 = 0; i3 < this.multiLineText.length; ++i3) {
			String s1 = this.multiLineText[i3];

			if (s1 != null && i3 == this.editLine && j >= 0) {
				if (k != j) {
					int l3 = Math.min(j, k);
					int l1 = Math.max(j, k);
					int i2 = this.minecraft.font.width(s1.substring(0, l3)) - this.minecraft.font.width(s1) / 2;
					int j2 = this.minecraft.font.width(s1.substring(0, l1)) - this.minecraft.font.width(s1) / 2;
					int k2 = Math.min(i2, j2);
					int l2 = Math.max(i2, j2);
					Tesselator tessellator = Tesselator.getInstance();
					BufferBuilder bufferbuilder = tessellator.getBuilder();
					RenderSystem.enableColorLogicOp();
					RenderSystem.logicOp(GlStateManager.LogicOp.OR_REVERSE);
					bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
					bufferbuilder.vertex(matrix4f, k2, l + 9, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, l2, l + 9, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, l2, l, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, k2, l, 0.0F).color(0, 0, 255, 255).endVertex();
					BufferUploader.drawWithShader(bufferbuilder.end());
					RenderSystem.disableColorLogicOp();
				}
			}
		}

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
		guiGraphics.blit(BACKGROUND_TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);
		guiGraphics.blit(BACKGROUND_TEXTURE, i, j + 125, 0, 126, this.imageWidth, this.imageHeight);
	}
}