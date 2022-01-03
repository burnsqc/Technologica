package com.technologica.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.client.renderer.entity.model.RaccoonModel;
import com.technologica.entity.passive.RaccoonEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class RaccoonHeldItemLayer extends LayerRenderer<RaccoonEntity, RaccoonModel<RaccoonEntity>> {
   public RaccoonHeldItemLayer(IEntityRenderer<RaccoonEntity, RaccoonModel<RaccoonEntity>> p_i50938_1_) {
      super(p_i50938_1_);
   }

   public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, RaccoonEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
      
      boolean flag1 = entitylivingbaseIn.isChild();
      matrixStackIn.push();
      
      if (flag1) {
         matrixStackIn.scale(0.75F, 0.75F, 0.75F);
         matrixStackIn.translate(0.0D, 1.5D, (double)0.209375F);
      }

      matrixStackIn.translate(0D, 1.3125D, -0.3125D);
      
      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(netHeadYaw/2));
      matrixStackIn.rotate(Vector3f.XP.rotationDegrees(headPitch/2));
      
      if (entitylivingbaseIn.isChild()) {
    	  matrixStackIn.translate((double)0.06F, (double)0.26F, -0.6D);
      } else {
         matrixStackIn.translate(0.0D, -0.13D, -0.55D);
      }

      matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
      
      ItemStack itemstack = entitylivingbaseIn.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
      Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.GROUND, false, matrixStackIn, bufferIn, packedLightIn);
      matrixStackIn.pop();
   }
}