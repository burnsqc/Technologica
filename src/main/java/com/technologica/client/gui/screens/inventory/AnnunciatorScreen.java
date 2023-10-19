package com.technologica.client.gui.screens.inventory;

import java.util.stream.IntStream;

import org.joml.Matrix4f;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.technologica.Technologica;
import com.technologica.network.play.client.CUpdateAnnunciatorPacket;
import com.technologica.network.play.server.Packets;
import com.technologica.world.inventory.AnnunciatorMenu;
import com.technologica.world.level.block.entity.AnnunciatorBlockEntity;

import net.minecraft.client.gui.font.TextFieldHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AnnunciatorScreen extends AbstractContainerScreen<AnnunciatorMenu> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/gui/container/annunciator_screen.png");
	private AnnunciatorBlockEntity tileEntity;
	private TextFieldHelper textInputUtil;
	private String[] multiLineText;
	private int editLine;
	private int updateCounter;

	public AnnunciatorScreen(AnnunciatorMenu screenContainerIn, Inventory playerInventoryIn, Component titleIn) {
		super(screenContainerIn, playerInventoryIn, Component.literal("Annunciator"));
		this.passEvents = false;
		this.imageHeight = 231;
		this.inventoryLabelY = 137;
		this.tileEntity = (AnnunciatorBlockEntity) screenContainerIn.getTileEntity();
		this.multiLineText = IntStream.range(0, 8).mapToObj(tileEntity::getText).map(Component::getString).toArray((p_243354_0_) -> {
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
			this.tileEntity.setText(this.editLine, Component.literal(p_238850_1_));
		}, TextFieldHelper.createClipboardGetter(this.minecraft), TextFieldHelper.createClipboardSetter(this.minecraft), (p_238848_1_) -> {
			return this.minecraft.font.width(p_238848_1_) <= 90;
		});
	}

	@Override
	public void removed() {
		ClientPacketListener clientplaynethandler = this.minecraft.getConnection();

		if (clientplaynethandler != null) {
			Packets.INSTANCE.sendToServer(new CUpdateAnnunciatorPacket(this.tileEntity.getBlockPos(), this.multiLineText[0], this.multiLineText[1], this.multiLineText[2], this.multiLineText[3], this.multiLineText[4], this.multiLineText[5], this.multiLineText[6], this.multiLineText[7]));
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
			this.editLine = this.editLine - 1 & 7;
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
					boolean flag = !hasShiftDown();
					if (!this.changeFocus(flag)) {
						this.changeFocus(flag);
					}
					return false;
				} else {
					return this.getFocused() != null && this.getFocused().keyPressed(keyCodeIn, scanCodeIn, modifiersIn);
				}
			}
		} else {
			this.editLine = this.editLine + 1 & 7;
			this.textInputUtil.setCursorToEnd();
			return true;
		}
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

		int i = 16383998;
		int j = this.textInputUtil.getCursorPos();
		int k = this.textInputUtil.getSelectionPos();
		int l = this.editLine * 10 - this.multiLineText.length * 5;
		Matrix4f matrix4f = matrixStack.last().pose();

		for (int i1 = 0; i1 < this.multiLineText.length; ++i1) {
			String s = this.multiLineText[i1];

			if (s != null) {
				if (this.font.isBidirectional()) {
					s = this.font.bidirectionalShaping(s);
				}

				float f3 = -this.minecraft.font.width(s) / 2;
				this.minecraft.font.drawInBatch(s, f3, i1 * 10 - this.multiLineText.length * 5, i, false, matrix4f, irendertypebuffer$impl, false, 0, 15728880, false);

				if (i1 == this.editLine && j >= 0 && flag1) {
					int j1 = this.minecraft.font.width(s.substring(0, Math.max(Math.min(j, s.length()), 0)));
					int k1 = j1 - this.minecraft.font.width(s) / 2;

					if (j >= s.length()) {
						this.minecraft.font.drawInBatch("_", k1, l, i, false, matrix4f, irendertypebuffer$impl, false, 0, 15728880, false);
					}
				}
			}
		}

		irendertypebuffer$impl.endBatch();

		for (int i3 = 0; i3 < this.multiLineText.length; ++i3) {
			String s1 = this.multiLineText[i3];

			if (s1 != null && i3 == this.editLine && j >= 0) {
				int j3 = this.minecraft.font.width(s1.substring(0, Math.max(Math.min(j, s1.length()), 0)));
				int k3 = j3 - this.minecraft.font.width(s1) / 2;

				if (flag1 && j < s1.length()) {
					fill(matrixStack, k3, l - 1, k3 + 1, l + 9, -16777216 | i);
				}

				if (k != j) {
					int l3 = Math.min(j, k);
					int l1 = Math.max(j, k);
					int i2 = this.minecraft.font.width(s1.substring(0, l3)) - this.minecraft.font.width(s1) / 2;
					int j2 = this.minecraft.font.width(s1.substring(0, l1)) - this.minecraft.font.width(s1) / 2;
					int k2 = Math.min(i2, j2);
					int l2 = Math.max(i2, j2);
					Tesselator tessellator = Tesselator.getInstance();
					BufferBuilder bufferbuilder = tessellator.getBuilder();
					RenderSystem.disableTexture();
					RenderSystem.enableColorLogicOp();
					RenderSystem.logicOp(GlStateManager.LogicOp.OR_REVERSE);
					bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
					bufferbuilder.vertex(matrix4f, k2, l + 9, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, l2, l + 9, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, l2, l, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, k2, l, 0.0F).color(0, 0, 255, 255).endVertex();
					BufferUploader.drawWithShader(bufferbuilder.end());
					RenderSystem.disableColorLogicOp();
					RenderSystem.enableTexture();
				}
			}
		}

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