package com.technologica.client.gui.screen;

import java.util.stream.IntStream;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.client.renderer.tileentity.VanillaSignTileEntityRenderer;
import com.technologica.tileentity.AnnunciatorTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.fonts.TextInputUtil;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.network.play.client.CUpdateSignPacket;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class EditAnnunciatorScreen extends Screen {
	private final SignTileEntityRenderer.SignModel signModel = new SignTileEntityRenderer.SignModel();
	private final AnnunciatorTileEntity tile;
	private int updateCounter;
	private int editLine;
	private TextInputUtil textInputUtil;
	private final String[] field_238846_r_;

	public EditAnnunciatorScreen(AnnunciatorTileEntity tileIn) {
		super(new TranslationTextComponent("sign.edit"));
		this.field_238846_r_ = IntStream.range(0, 4).mapToObj(tileIn::getText).map(ITextComponent::getString).toArray((p_243354_0_) -> {
					return new String[p_243354_0_];
				});
		this.tile = tileIn;
	}

	protected void init() {
		this.minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.width / 2 - 100, this.height / 4 + 120, 200, 20, DialogTexts.GUI_DONE, (p_238847_1_) -> {
			this.close();
		}));
		this.tile.setEditable(false);
		this.textInputUtil = new TextInputUtil(() -> {
			return this.field_238846_r_[this.editLine];
		}, (p_238850_1_) -> {
			this.field_238846_r_[this.editLine] = p_238850_1_;
			this.tile.setText(this.editLine, new StringTextComponent(p_238850_1_));
		}, TextInputUtil.getClipboardTextSupplier(this.minecraft), TextInputUtil.getClipboardTextSetter(this.minecraft), (p_238848_1_) -> {
			return this.minecraft.fontRenderer.getStringWidth(p_238848_1_) <= 90;
		});
	}

	public void onClose() {
		this.minecraft.keyboardListener.enableRepeatEvents(false);
		ClientPlayNetHandler clientplaynethandler = this.minecraft.getConnection();
		if (clientplaynethandler != null) {
			clientplaynethandler.sendPacket(new CUpdateSignPacket(this.tile.getPos(), this.field_238846_r_[0], this.field_238846_r_[1], this.field_238846_r_[2], this.field_238846_r_[3]));
		}

		this.tile.setEditable(true);
	}

	public void tick() {
		++this.updateCounter;
		if (!this.tile.getType().isValidBlock(this.tile.getBlockState().getBlock())) {
			this.close();
		}

	}

	private void close() {
		this.tile.markDirty();
		this.minecraft.displayGuiScreen((Screen) null);
	}

	public boolean charTyped(char codePoint, int modifiers) {
		this.textInputUtil.putChar(codePoint);
		return true;
	}

	public void closeScreen() {
		this.close();
	}

	public boolean keyPressed(int keyCodeIn, int scanCodeIn, int modifiersIn) {
		if (keyCodeIn == 265) {
			this.editLine = this.editLine - 1 & 3;
			this.textInputUtil.moveCursorToEnd();
			return true;
		} else if (keyCodeIn != 264 && keyCodeIn != 257 && keyCodeIn != 335) {
			return this.textInputUtil.specialKeyPressed(keyCodeIn) ? true: super.keyPressed(keyCodeIn, scanCodeIn, modifiersIn);
		} else {
			this.editLine = this.editLine + 1 & 3;
			this.textInputUtil.moveCursorToEnd();
			return true;
		}
	}

	public void render(MatrixStack matrixStackIn, int mouseXIn, int mouseYIn, float partialTicksIn) {
		RenderHelper.setupGuiFlatDiffuseLighting();
		this.renderBackground(matrixStackIn);
		drawCenteredString(matrixStackIn, this.font, this.title, this.width / 2, 40, 16777215);
		
		matrixStackIn.push();
		matrixStackIn.translate((double) (this.width / 2), 0.0D, 50.0D);
		matrixStackIn.scale(93.75F, -93.75F, 93.75F);
		matrixStackIn.translate(0.0D, -1.3125D, 0.0D);
		
		BlockState blockstate = this.tile.getBlockState();
		boolean flag1 = this.updateCounter / 6 % 2 == 0;
		
		matrixStackIn.push();
		matrixStackIn.scale(0.6666667F, -0.6666667F, -0.6666667F);
		
		IRenderTypeBuffer.Impl irendertypebuffer$impl = this.minecraft.getRenderTypeBuffers().getBufferSource();
		RenderMaterial rendermaterial = VanillaSignTileEntityRenderer.getMaterial(blockstate.getBlock());
		IVertexBuilder ivertexbuilder = rendermaterial.getBuffer(irendertypebuffer$impl, this.signModel::getRenderType);
		this.signModel.signBoard.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY);
		matrixStackIn.pop();
		
		
		matrixStackIn.translate(0.0D, (double) 0.33333334F, (double) 0.046666667F);
		matrixStackIn.scale(0.010416667F, -0.010416667F, 0.010416667F);
		
		int i = this.tile.getTextColor().getTextColor();
		int j = this.textInputUtil.getSelectionEnd();
		int k = this.textInputUtil.getSelectionStart();
		int l = this.editLine * 10 - this.field_238846_r_.length * 5;
		
		Matrix4f matrix4f = matrixStackIn.getLast().getMatrix();

		for (int i1 = 0; i1 < this.field_238846_r_.length; ++i1) {
			String s = this.field_238846_r_[i1];
			
			if (s != null) {
				if (this.font.getBidiFlag()) {
					s = this.font.bidiReorder(s);
				}

				float f3 = (float) (-this.minecraft.fontRenderer.getStringWidth(s) / 2);
				this.minecraft.fontRenderer.drawBidiString(s, f3, (float) (i1 * 10 - this.field_238846_r_.length * 5), i, false, matrix4f, irendertypebuffer$impl, false, 0, 15728880, false);
				
				if (i1 == this.editLine && j >= 0 && flag1) {
					int j1 = this.minecraft.fontRenderer.getStringWidth(s.substring(0, Math.max(Math.min(j, s.length()), 0)));
					int k1 = j1 - this.minecraft.fontRenderer.getStringWidth(s) / 2;
					
					if (j >= s.length()) {
						this.minecraft.fontRenderer.drawBidiString("_", (float) k1, (float) l, i, false, matrix4f,
								irendertypebuffer$impl, false, 0, 15728880, false);
					}
				}
			}
		}

		irendertypebuffer$impl.finish();

		for (int i3 = 0; i3 < this.field_238846_r_.length; ++i3) {
			String s1 = this.field_238846_r_[i3];
			
			if (s1 != null && i3 == this.editLine && j >= 0) {
				int j3 = this.minecraft.fontRenderer.getStringWidth(s1.substring(0, Math.max(Math.min(j, s1.length()), 0)));
				int k3 = j3 - this.minecraft.fontRenderer.getStringWidth(s1) / 2;
				
				if (flag1 && j < s1.length()) {
					fill(matrixStackIn, k3, l - 1, k3 + 1, l + 9, -16777216 | i);
				}

				if (k != j) {
					int l3 = Math.min(j, k);
					int l1 = Math.max(j, k);
					int i2 = this.minecraft.fontRenderer.getStringWidth(s1.substring(0, l3)) - this.minecraft.fontRenderer.getStringWidth(s1) / 2;
					int j2 = this.minecraft.fontRenderer.getStringWidth(s1.substring(0, l1)) - this.minecraft.fontRenderer.getStringWidth(s1) / 2;
					int k2 = Math.min(i2, j2);
					int l2 = Math.max(i2, j2);
					Tessellator tessellator = Tessellator.getInstance();
					BufferBuilder bufferbuilder = tessellator.getBuffer();
					RenderSystem.disableTexture();
					RenderSystem.enableColorLogicOp();
					RenderSystem.logicOp(GlStateManager.LogicOp.OR_REVERSE);
					bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
					bufferbuilder.pos(matrix4f, (float) k2, (float) (l + 9), 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.pos(matrix4f, (float) l2, (float) (l + 9), 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.pos(matrix4f, (float) l2, (float) l, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.pos(matrix4f, (float) k2, (float) l, 0.0F).color(0, 0, 255, 255).endVertex();
					bufferbuilder.finishDrawing();
					WorldVertexBufferUploader.draw(bufferbuilder);
					RenderSystem.disableColorLogicOp();
					RenderSystem.enableTexture();
				}
			}
		}

		matrixStackIn.pop();
		RenderHelper.setupGui3DDiffuseLighting();
		super.render(matrixStackIn, mouseXIn, mouseYIn, partialTicksIn);
	}
}