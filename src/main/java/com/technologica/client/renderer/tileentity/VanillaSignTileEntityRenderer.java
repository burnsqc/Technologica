package com.technologica.client.renderer.tileentity;

import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.Technologica;
import com.technologica.tileentity.VanillaSignTileEntity;

import net.minecraft.block.AbstractSignBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VanillaSignTileEntityRenderer extends TileEntityRenderer<VanillaSignTileEntity> {
	private final SignTileEntityRenderer.SignModel model = new SignTileEntityRenderer.SignModel();

   public VanillaSignTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
      super(rendererDispatcherIn);
   }

   public void render(VanillaSignTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
      BlockState blockstate = tileEntityIn.getBlockState();
      matrixStackIn.push();
      if (blockstate.getBlock() instanceof StandingSignBlock) {
         matrixStackIn.translate(0.5D, 0.5D, 0.5D);
         float f1 = -((float)(blockstate.get(StandingSignBlock.ROTATION) * 360) / 16.0F);
         matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f1));
         this.model.signStick.showModel = true;
      } else {
         matrixStackIn.translate(0.5D, 0.5D, 0.5D);
         float f4 = -blockstate.get(WallSignBlock.FACING).getHorizontalAngle();
         matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f4));
         matrixStackIn.translate(0.0D, -0.3125D, -0.4375D);
         this.model.signStick.showModel = false;
      }

      matrixStackIn.push();
      matrixStackIn.scale(0.6666667F, -0.6666667F, -0.6666667F);
      RenderMaterial rendermaterial = getMaterial(blockstate.getBlock());
      IVertexBuilder ivertexbuilder = rendermaterial.getBuffer(bufferIn, this.model::getRenderType);
      this.model.signBoard.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
      this.model.signStick.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
      matrixStackIn.pop();
      FontRenderer fontrenderer = this.renderDispatcher.getFontRenderer();

      matrixStackIn.translate(0.0D, (double)0.33333334F, (double)0.046666667F);
      matrixStackIn.scale(0.010416667F, -0.010416667F, 0.010416667F);
      int i = tileEntityIn.getTextColor().getTextColor();

      int j = (int)((double)NativeImage.getRed(i) * 0.4D);
      int k = (int)((double)NativeImage.getGreen(i) * 0.4D);
      int l = (int)((double)NativeImage.getBlue(i) * 0.4D);
      int i1 = NativeImage.getCombined(0, l, k, j);


      for(int k1 = 0; k1 < 4; ++k1) {
         IReorderingProcessor ireorderingprocessor = tileEntityIn.reorderText(k1, (p_243502_1_) -> {
            List<IReorderingProcessor> list = fontrenderer.trimStringToWidth(p_243502_1_, 90);
            return list.isEmpty() ? IReorderingProcessor.field_242232_a : list.get(0);
         });
         if (ireorderingprocessor != null) {
            float f3 = (float)(-fontrenderer.func_243245_a(ireorderingprocessor) / 2);
            fontrenderer.drawEntityText(ireorderingprocessor, f3, (float)(k1 * 10 - 20), i1, false, matrixStackIn.getLast().getMatrix(), bufferIn, false, 0, combinedLightIn);
         }
      }

      matrixStackIn.pop();
   }

   public static RenderMaterial getMaterial(Block blockIn) {
	   
      WoodType woodType;
      if (blockIn instanceof AbstractSignBlock) {
         woodType = ((AbstractSignBlock)blockIn).getWoodType();
      } else {
         woodType = WoodType.OAK;
      }

      return new RenderMaterial(Atlases.SIGN_ATLAS, new ResourceLocation(Technologica.MODID, "entity/signs/" + woodType.getName()));
   }
}
