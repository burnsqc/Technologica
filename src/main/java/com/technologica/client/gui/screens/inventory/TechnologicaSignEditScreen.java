package com.technologica.client.gui.screens.inventory;

import java.util.stream.IntStream;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Matrix4f;
import com.technologica.world.level.block.entity.VanillaSignTileEntity;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.font.TextFieldHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ServerboundSignUpdatePacket;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class TechnologicaSignEditScreen extends Screen {
	private final VanillaSignTileEntity sign;
	private int frame;
	private int editLine;
	private WoodType woodType;
	private TextFieldHelper textInputUtil;
	private SignRenderer.SignModel signModel;
	private final String[] messages;

	public TechnologicaSignEditScreen(VanillaSignTileEntity p_169811_, boolean p_169812_) {
		super(new TranslatableComponent("sign.edit"));
		this.messages = IntStream.range(0, 4).mapToObj((p_169818_) -> {
			return p_169811_.getMessage(p_169818_, p_169812_);
		}).map(Component::getString).toArray((p_169814_) -> {
			return new String[p_169814_];
		});
		this.sign = p_169811_;
	}

	protected void init() {
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.width / 2 - 100, this.height / 4 + 120, 200, 20, CommonComponents.GUI_DONE, (p_169820_) -> {
	         this.onDone();
	      }));
		this.sign.setEditable(false);
		this.textInputUtil = new TextFieldHelper(() -> {
			return this.messages[this.editLine];
		}, (p_238850_1_) -> {
			this.messages[this.editLine] = p_238850_1_;
			this.sign.setMessage(this.editLine, new TextComponent(p_238850_1_));
		}, TextFieldHelper.createClipboardGetter(this.minecraft), TextFieldHelper.createClipboardSetter(this.minecraft),
				(p_238848_1_) -> {
					return this.minecraft.font.width(p_238848_1_) <= 90;
				});
	}

	public void removed() {
		this.minecraft.keyboardHandler.setSendRepeatsToGui(false);
		ClientPacketListener clientplaynethandler = this.minecraft.getConnection();
		if (clientplaynethandler != null) {
			clientplaynethandler.send(new ServerboundSignUpdatePacket(this.sign.getBlockPos(), this.messages[0],
					this.messages[1], this.messages[2], this.messages[3]));
		}

		this.sign.setEditable(true);
	}

	public void tick() {
	      ++this.frame;
	      if (!this.sign.getType().isValid(this.sign.getBlockState())) {
	         this.onDone();
	      }

	   }

	private void onDone() {
	      this.sign.setChanged();
	      this.minecraft.setScreen((Screen)null);
	   }

	public boolean charTyped(char codePoint, int modifiers) {
		this.textInputUtil.charTyped(codePoint);
		return true;
	}

	public void onClose() {
		this.onDone();
	}

	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		if (keyCode == 265) {
			this.editLine = this.editLine - 1 & 3;
			this.textInputUtil.setCursorToEnd();
			return true;
		} else if (keyCode != 264 && keyCode != 257 && keyCode != 335) {
			return this.textInputUtil.keyPressed(keyCode) ? true : super.keyPressed(keyCode, scanCode, modifiers);
		} else {
			this.editLine = this.editLine + 1 & 3;
			this.textInputUtil.setCursorToEnd();
			return true;
		}
	}

	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		Lighting.setupForFlatItems();
		this.renderBackground(matrixStack);
		drawCenteredString(matrixStack, this.font, this.title, this.width / 2, 40, 16777215);
		matrixStack.pushPose();
		matrixStack.translate((double) (this.width / 2), 0.0D, 50.0D);
		float f = 93.75F;
		matrixStack.scale(f, -f, f);
		matrixStack.translate(0.0D, -1.3125D, 0.0D);
		BlockState blockstate = this.sign.getBlockState();
		boolean flag = blockstate.getBlock() instanceof StandingSignBlock;
		if (!flag) {
			matrixStack.translate(0.0D, -0.3125D, 0.0D);
		}

		boolean flag1 = this.frame / 6 % 2 == 0;
		float f1 = 0.6666667F;
		matrixStack.pushPose();
		matrixStack.scale(f1, -f1, -f1);
		MultiBufferSource.BufferSource irendertypebuffer$impl = this.minecraft.renderBuffers().bufferSource();
		Material material = Sheets.getSignMaterial(this.woodType);
		VertexConsumer ivertexbuilder = material.buffer(irendertypebuffer$impl, this.signModel::renderType);
		this.signModel.stick.visible = flag;
	    this.signModel.root.render(matrixStack, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY);
		matrixStack.popPose();
		float f2 = 0.010416667F;
		matrixStack.translate(0.0D, (double) 0.33333334F, (double) 0.046666667F);
		matrixStack.scale(f2, -f2, f2);
		int i = this.sign.getColor().getTextColor();
		int j = this.textInputUtil.getCursorPos();
		int k = this.textInputUtil.getSelectionPos();
		int l = this.editLine * 10 - this.messages.length * 5;
		Matrix4f matrix4f = matrixStack.last().pose();

		for (int i1 = 0; i1 < this.messages.length; ++i1) {
			String s = this.messages[i1];
			if (s != null) {
				if (this.font.isBidirectional()) {
					s = this.font.bidirectionalShaping(s);
				}

				float f3 = (float) (-this.minecraft.font.width(s) / 2);
				this.minecraft.font.drawInBatch(s, f3, (float) (i1 * 10 - this.messages.length * 5), i, false, matrix4f,
						irendertypebuffer$impl, false, 0, 15728880, false);
				if (i1 == this.editLine && j >= 0 && flag1) {
					int j1 = this.minecraft.font.width(s.substring(0, Math.max(Math.min(j, s.length()), 0)));
					int k1 = j1 - this.minecraft.font.width(s) / 2;
					if (j >= s.length()) {
						this.minecraft.font.drawInBatch("_", (float) k1, (float) l, i, false, matrix4f,
								irendertypebuffer$impl, false, 0, 15728880, false);
					}
				}
			}
		}

		irendertypebuffer$impl.endBatch();

		for (int i3 = 0; i3 < this.messages.length; ++i3) {
			String s1 = this.messages[i3];
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
					bufferbuilder.vertex(matrix4f, (float) k2, (float) (l + 9), 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, (float) l2, (float) (l + 9), 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, (float) l2, (float) l, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.vertex(matrix4f, (float) k2, (float) l, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.end();
					BufferUploader.end(bufferbuilder);
					RenderSystem.disableColorLogicOp();
					RenderSystem.enableTexture();
				}
			}
		}

		matrixStack.popPose();
		Lighting.setupFor3DItems();
		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}
}
