package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.entity.passive.BeaverEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BeaverModel<T extends BeaverEntity> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	/*
	
	private final ModelRenderer rabbitLeftFoot = new ModelRenderer(this, 26, 24);
	private final ModelRenderer rabbitRightFoot;
	private final ModelRenderer rabbitLeftThigh;
	private final ModelRenderer rabbitRightThigh;

	private final ModelRenderer rabbitLeftArm;
	private final ModelRenderer rabbitRightArm;
	private final ModelRenderer rabbitHead;
	private final ModelRenderer rabbitRightEar;
	private final ModelRenderer rabbitLeftEar;
	private final ModelRenderer rabbitTail;
	private final ModelRenderer rabbitNose;
	private float jumpRotation;
	*/

   public BeaverModel() {
	   this.body = new ModelRenderer(this, 0, 32);
	   this.body.addBox(-5.0F, -2.0F, -7.0F, 12.0F, 11.0F, 16.0F);
	   this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
	   
	   this.head = new ModelRenderer(this, 0, 32);
	   this.head.addBox(-3.0F, 2.0F, -4.0F, 4.0F, 3.0F, 3.0F);
	   this.head.setRotationPoint(0.0F, 19.0F, 8.0F);
	   this.body.addChild(this.head);
   }

   private void setRotationOffset(ModelRenderer renderer, float x, float y, float z) {
      renderer.rotateAngleX = x;
      renderer.rotateAngleY = y;
      renderer.rotateAngleZ = z;
   }

   public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
      if (this.isChild) {
         matrixStackIn.push();
         matrixStackIn.scale(0.56666666F, 0.56666666F, 0.56666666F);
         matrixStackIn.translate(0.0D, 1.375D, 0.125D);
         ImmutableList.of(this.head).forEach((p_228292_8_) -> {
            p_228292_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
         });
         matrixStackIn.pop();
         matrixStackIn.push();
         matrixStackIn.scale(0.4F, 0.4F, 0.4F);
         matrixStackIn.translate(0.0D, 2.25D, 0.0D);
         ImmutableList.of(this.body).forEach((p_228291_8_) -> {
            p_228291_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
         });
         matrixStackIn.pop();
      } else {
         matrixStackIn.push();
         matrixStackIn.scale(0.6F, 0.6F, 0.6F);
         matrixStackIn.translate(0.0D, 1.0D, 0.0D);
         ImmutableList.of(this.body, this.head).forEach((p_228290_8_) -> {
            p_228290_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
         });
         matrixStackIn.pop();
      }

   }

   /**
    * Sets this entity's model rotation angles
    */
   public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      
   }

   public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
      super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
   }
}