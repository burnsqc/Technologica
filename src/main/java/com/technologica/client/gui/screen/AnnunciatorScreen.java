package com.technologica.client.gui.screen;

import java.util.stream.IntStream;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.Technologica;
import com.technologica.inventory.container.AnnunciatorContainer;
import com.technologica.network.play.client.CUpdateAnnunciatorPacket;
import com.technologica.network.play.server.Packets;
import com.technologica.tileentity.AnnunciatorTileEntity;

import net.minecraft.client.gui.fonts.TextInputUtil;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class AnnunciatorScreen extends ContainerScreen<AnnunciatorContainer> {
	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/gui/container/annunciator_screen.png");
	private AnnunciatorTileEntity tileEntity;
	private TextInputUtil textInputUtil;
	private String[] multiLineText;
	private int editLine;
	private int updateCounter;

	public AnnunciatorScreen(AnnunciatorContainer screenContainerIn, PlayerInventory playerInventoryIn, ITextComponent titleIn) {
		super(screenContainerIn, playerInventoryIn, new StringTextComponent("Annunciator"));
		this.passEvents = false;
		this.ySize = 231;
		this.playerInventoryTitleY = 137;
		this.tileEntity = (AnnunciatorTileEntity) screenContainerIn.getTileEntity();
		this.multiLineText = IntStream.range(0, 8).mapToObj(tileEntity::getText).map(ITextComponent::getString).toArray((p_243354_0_) -> {
			return new String[p_243354_0_];
		});
	}

	@Override
	protected void init() {
		super.init();
		this.minecraft.keyboardListener.enableRepeatEvents(true);
		this.tileEntity.setEditable(false);
		this.textInputUtil = new TextInputUtil(() -> {
			return this.multiLineText[this.editLine];
		}, (p_238850_1_) -> {
			this.multiLineText[this.editLine] = p_238850_1_;
			this.tileEntity.setText(this.editLine, new StringTextComponent(p_238850_1_));
		}, TextInputUtil.getClipboardTextSupplier(this.minecraft), TextInputUtil.getClipboardTextSetter(this.minecraft), (p_238848_1_) -> {
			return this.minecraft.fontRenderer.getStringWidth(p_238848_1_) <= 90;
		});
	}

	@Override
	public void onClose() {
		this.minecraft.keyboardListener.enableRepeatEvents(false);
		ClientPlayNetHandler clientplaynethandler = this.minecraft.getConnection();
		
		if (clientplaynethandler != null) {
			Packets.INSTANCE.sendToServer(new CUpdateAnnunciatorPacket(this.tileEntity.getPos(), this.multiLineText[0], this.multiLineText[1], this.multiLineText[2], this.multiLineText[3], this.multiLineText[4], this.multiLineText[5], this.multiLineText[6], this.multiLineText[7]));
		}

		this.tileEntity.setEditable(true);
	}

	@Override
	public void tick() {
		++this.updateCounter;
		if (!this.tileEntity.getType().isValidBlock(this.tileEntity.getBlockState().getBlock())) {
			this.close();
		}
	}
	
	private void close() {
		this.tileEntity.markDirty();
		this.minecraft.displayGuiScreen((Screen) null);
	}
	
	@Override
	public boolean charTyped(char charIn, int modifiersIn) {
		this.textInputUtil.putChar(charIn);
		return true;
	}
	
	@Override
	public void closeScreen() {
		this.close();
	}
	
	@Override
	public boolean keyPressed(int keyCodeIn, int scanCodeIn, int modifiersIn) {
		if (keyCodeIn == 265) {
			this.editLine = this.editLine - 1 & 7;
			this.textInputUtil.moveCursorToEnd();
			return true;
		} else if (keyCodeIn != 264 && keyCodeIn != 257 && keyCodeIn != 335) {
			if (this.textInputUtil.specialKeyPressed(keyCodeIn)) {
				return true;
			} else {
				if (keyCodeIn == 256 && this.shouldCloseOnEsc()) {
					this.closeScreen();
					return true;
				} else if (keyCodeIn == 258) {
					boolean flag = !hasShiftDown();
					if (!this.changeFocus(flag)) {
						this.changeFocus(flag);
					}
					return false;
				} else {
					return this.getListener() != null && this.getListener().keyPressed(keyCodeIn, scanCodeIn, modifiersIn);
				}
			}
		} else {
			this.editLine = this.editLine + 1 & 7;
			this.textInputUtil.moveCursorToEnd();
			return true;
		}
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		RenderHelper.setupGuiFlatDiffuseLighting();

		matrixStack.push();
		boolean flag1 = this.updateCounter / 6 % 2 == 0;

		matrixStack.push();
		IRenderTypeBuffer.Impl irendertypebuffer$impl = this.minecraft.getRenderTypeBuffers().getBufferSource();
		matrixStack.pop();

		matrixStack.translate(256.0D, 96.0D, 0.0D);

		int i = 16383998;
		int j = this.textInputUtil.getSelectionEnd();
		int k = this.textInputUtil.getSelectionStart();
		int l = this.editLine * 10 - this.multiLineText.length * 5;
		Matrix4f matrix4f = matrixStack.getLast().getMatrix();

		for (int i1 = 0; i1 < this.multiLineText.length; ++i1) {
			String s = this.multiLineText[i1];
			
			if (s != null) {
				if (this.font.getBidiFlag()) {
					s = this.font.bidiReorder(s);
				}

				float f3 = (float) (-this.minecraft.fontRenderer.getStringWidth(s) / 2);
				this.minecraft.fontRenderer.drawBidiString(s, f3, (float) (i1 * 10 - this.multiLineText.length * 5), i, false, matrix4f, irendertypebuffer$impl, false, 0, 15728880, false);
				
				if (i1 == this.editLine && j >= 0 && flag1) {
					int j1 = this.minecraft.fontRenderer.getStringWidth(s.substring(0, Math.max(Math.min(j, s.length()), 0)));
					int k1 = j1 - this.minecraft.fontRenderer.getStringWidth(s) / 2;
					
					if (j >= s.length()) {
						this.minecraft.fontRenderer.drawBidiString("_", (float) k1, (float) l, i, false, matrix4f, irendertypebuffer$impl, false, 0, 15728880, false);
					}
				}
			}
		}

		irendertypebuffer$impl.finish();

		for (int i3 = 0; i3 < this.multiLineText.length; ++i3) {
			String s1 = this.multiLineText[i3];
			
			if (s1 != null && i3 == this.editLine && j >= 0) {
				int j3 = this.minecraft.fontRenderer.getStringWidth(s1.substring(0, Math.max(Math.min(j, s1.length()), 0)));
				int k3 = j3 - this.minecraft.fontRenderer.getStringWidth(s1) / 2;
				
				if (flag1 && j < s1.length()) {
					fill(matrixStack, k3, l - 1, k3 + 1, l + 9, -16777216 | i);
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

		matrixStack.pop();
		RenderHelper.setupGui3DDiffuseLighting();
		this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.blit(matrixStack, i, j, 0, 0, this.xSize, 125);
		this.blit(matrixStack, i, j + 125, 0, 126, this.xSize, 105);
	}
}
