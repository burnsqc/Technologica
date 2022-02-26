package com.technologica.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.client.model.RaccoonModel;
import com.technologica.world.entity.animal.RaccoonEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import com.mojang.math.Vector3f;

public class RaccoonHeldItemLayer extends RenderLayer<RaccoonEntity, RaccoonModel<RaccoonEntity>> {
   public RaccoonHeldItemLayer(RenderLayerParent<RaccoonEntity, RaccoonModel<RaccoonEntity>> p_i50938_1_) {
      super(p_i50938_1_);
   }

   public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, RaccoonEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
      
      boolean flag1 = entitylivingbaseIn.isBaby();
      matrixStackIn.pushPose();
      
      if (flag1) {
         matrixStackIn.scale(0.75F, 0.75F, 0.75F);
         matrixStackIn.translate(0.0D, 1.5D, (double)0.209375F);
      }

      matrixStackIn.translate(0D, 1.3125D, -0.3125D);
      
      matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(netHeadYaw/2));
      matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(headPitch/2));
      
      if (entitylivingbaseIn.isBaby()) {
    	  matrixStackIn.translate((double)0.06F, (double)0.26F, -0.6D);
      } else {
         matrixStackIn.translate(0.0D, -0.13D, -0.55D);
      }

      matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90.0F));
      
      ItemStack itemstack = entitylivingbaseIn.getItemBySlot(EquipmentSlot.MAINHAND);
      Minecraft.getInstance().getItemInHandRenderer().renderItem(entitylivingbaseIn, itemstack, ItemTransforms.TransformType.GROUND, false, matrixStackIn, bufferIn, packedLightIn);
      matrixStackIn.popPose();
   }
}