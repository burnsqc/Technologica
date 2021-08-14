package com.technologica.client.gui.screen;

import java.util.stream.IntStream;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.block.ModStandingSignBlock;
import com.technologica.client.renderer.tileentity.ModSignTileEntityRenderer;
import com.technologica.tileentity.ModSignTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.client.gui.fonts.TextInputUtil;
import net.minecraft.client.gui.screen.EditSignScreen;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.text.ITextComponent;

public class ModEditSignScreen extends EditSignScreen {
	private final SignTileEntityRenderer.SignModel signModel = new SignTileEntityRenderer.SignModel();	  
	private final ModSignTileEntity tileSign;	
	private int updateCounter;	   
	private int editLine;
	private TextInputUtil textInputUtil;
	private final String[] field_238846_r_;
	
	
	public ModEditSignScreen(ModSignTileEntity teSign) {
		super(teSign);
		this.field_238846_r_ = IntStream.range(0, 4).mapToObj(teSign::getText).map(ITextComponent::getString).toArray((p_243354_0_) -> {
	         return new String[p_243354_0_];
	      });
	      this.tileSign = teSign;
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
	      RenderHelper.setupGuiFlatDiffuseLighting();
	      this.renderBackground(matrixStack);
	      drawCenteredString(matrixStack, this.font, this.title, this.width / 2, 40, 16777215);
	      matrixStack.push();
	      matrixStack.translate((double)(this.width / 2), 0.0D, 50.0D);	      
	      matrixStack.scale(93.75F, -93.75F, 93.75F);
	      matrixStack.translate(0.0D, -1.3125D, 0.0D);
	      BlockState blockstate = this.tileSign.getBlockState();
	      boolean flag = blockstate.getBlock() instanceof ModStandingSignBlock;
	      if (!flag) {
	         matrixStack.translate(0.0D, -0.3125D, 0.0D);
	      }

	      boolean flag1 = this.updateCounter / 6 % 2 == 0;
	     
	      matrixStack.push();
	      matrixStack.scale(0.6666667F, -0.6666667F, -0.6666667F);
	      IRenderTypeBuffer.Impl irendertypebuffer$impl = this.minecraft.getRenderTypeBuffers().getBufferSource();
	      RenderMaterial rendermaterial = ModSignTileEntityRenderer.getMaterial(blockstate.getBlock());
	      IVertexBuilder ivertexbuilder = rendermaterial.getBuffer(irendertypebuffer$impl, this.signModel::getRenderType);
	      this.signModel.signBoard.render(matrixStack, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY);
	      if (flag) {
	         this.signModel.signStick.render(matrixStack, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY);
	      }

	      matrixStack.pop();
	      
	      matrixStack.translate(0.0D, (double)0.33333334F, (double)0.046666667F);
	      matrixStack.scale(0.010416667F, -0.010416667F, 0.010416667F);
	      int i = this.tileSign.getTextColor().getTextColor();
	      int j = this.textInputUtil.getSelectionEnd();	    
	      int l = this.editLine * 10 - this.field_238846_r_.length * 5;
	      Matrix4f matrix4f = matrixStack.getLast().getMatrix();

	      for(int i1 = 0; i1 < this.field_238846_r_.length; ++i1) {
	         String s = this.field_238846_r_[i1];
	         if (s != null) {
	            if (this.font.getBidiFlag()) {
	               s = this.font.bidiReorder(s);
	            }

	            float f3 = (float)(-this.minecraft.fontRenderer.getStringWidth(s) / 2);
	            this.minecraft.fontRenderer.drawBidiString(s, f3, (float)(i1 * 10 - this.field_238846_r_.length * 5), i, false, matrix4f, irendertypebuffer$impl, false, 0, 15728880, false);
	            if (i1 == this.editLine && j >= 0 && flag1) {
	               int j1 = this.minecraft.fontRenderer.getStringWidth(s.substring(0, Math.max(Math.min(j, s.length()), 0)));
	               int k1 = j1 - this.minecraft.fontRenderer.getStringWidth(s) / 2;
	               if (j >= s.length()) {
	                  this.minecraft.fontRenderer.drawBidiString("_", (float)k1, (float)l, i, false, matrix4f, irendertypebuffer$impl, false, 0, 15728880, false);
	               }
	            }
	         }
	      }
	}
}
