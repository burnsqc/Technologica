package com.technologica.client.gui.screens.inventory;

import org.joml.Matrix4f;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.Technologica;
import com.technologica.network.packets.serverbound.UpdateMonitor;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.inventory.MonitorMenu;
import com.technologica.world.level.block.entity.MonitorBlockEntity;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.font.TextFieldHelper;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MonitorScreen extends AbstractContainerScreen<MonitorMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new TechnologicaLocation("textures/gui/container/monitor_screen.png");
	private MonitorBlockEntity blockEntity;
	private TextFieldHelper textInputUtil;
	private String[] text;
	private static final ResourceLocation FULLSPACE_FONT = new TechnologicaLocation("full_space");
	private static final Style FULLSPACE_FONT_STYLE = Style.EMPTY.withFont(FULLSPACE_FONT);
	private int cursorRow;
	private int cursorColumn;
	private int updateCounter;
	protected int imageWidth = 224;

	public MonitorScreen(MonitorMenu screenContainerIn, Inventory playerInventoryIn, Component titleIn) {
		super(screenContainerIn, playerInventoryIn, titleIn);
		imageHeight = 231;
		this.inventoryLabelY = 137;
		this.blockEntity = screenContainerIn.getTileEntity();
		this.text = blockEntity.getText();
	}

	@Override
	protected void init() {
		super.init();
		this.blockEntity.setEditable(false);
		this.textInputUtil = new TextFieldHelper(() -> this.text[this.cursorRow], (string) -> {
			this.text[this.cursorRow] = string;
			this.blockEntity.setText(this.text);
		}, TextFieldHelper.createClipboardGetter(this.minecraft), TextFieldHelper.createClipboardSetter(this.minecraft), (string) -> this.text[this.cursorRow].length() < 80);
		textInputUtil.setCursorPos(0);
		this.cursorRow = 31;
	}

	@Override
	public void removed() {
		if (this.minecraft.getConnection().getConnection() != null) {
			Technologica.CHANNEL.sendToServer(new UpdateMonitor(this.blockEntity.getBlockPos(), this.text));
		}
		this.blockEntity.setEditable(true);
	}

	@Override
	public void containerTick() {
		++this.updateCounter;
	}

	private void close() {
		this.blockEntity.setChanged();
		this.minecraft.setScreen(null);
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
		if (keyCodeIn == 264) {
			if (this.cursorRow == 31) {
				this.cursorRow = 0;
			} else {
				this.cursorRow = this.cursorRow + 1;
			}
			return true;
		} else if (keyCodeIn == 265) {
			if (this.cursorRow == 0) {
				this.cursorRow = 31;
			} else {
				this.cursorRow = this.cursorRow - 1;
			}
			return true;
		} else if (keyCodeIn != 257 && keyCodeIn != 335) {
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
			return true;
		}
	}

	@Override
	public void render(GuiGraphics matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		this.renderBg(matrixStack, partialTicks, mouseX, mouseY);
		Lighting.setupForFlatItems();

		matrixStack.pose().pushPose();
		MultiBufferSource.BufferSource irendertypebuffer$impl = this.minecraft.renderBuffers().bufferSource();
		matrixStack.pose().popPose();

		matrixStack.pose().translate(256.0D, 96.0D, 0.0D);

		int color = 0x00FF00;
		int j = this.textInputUtil.getCursorPos();
		int k = this.textInputUtil.getSelectionPos();
		int l = this.cursorRow * 9 - this.text.length * 5 + 24;
		Matrix4f matrix4f = matrixStack.pose().last().pose();
		matrix4f.scale(0.9f, 0.9f, 0.9f);
		boolean flashingFlag = this.updateCounter / 12 % 2 == 0;

		for (int row = 0; row < this.text.length; ++row) {

			String character = this.text[row];

			if (character != null) {
				Component text = Component.literal(character).setStyle(FULLSPACE_FONT_STYLE);
					float posHorizontal = -240;
					this.minecraft.font.drawInBatch(text, posHorizontal, -92 + row * 9, color, false, matrix4f, irendertypebuffer$impl, Font.DisplayMode.POLYGON_OFFSET, 0, 15728880);
	
					char block = '\u2587';
					Component blockText = Component.literal(String.valueOf(block)).setStyle(FULLSPACE_FONT_STYLE);
					if (row == this.cursorRow && flashingFlag) {
						this.minecraft.font.drawInBatch(blockText, posHorizontal + j * 6, -92 + row * 9, color, false, matrix4f, irendertypebuffer$impl, Font.DisplayMode.POLYGON_OFFSET, 0, 15728880);
					}
				}

		}

		irendertypebuffer$impl.endBatch();
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
