package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ScorpionModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer spiderHead;
	private final ModelRenderer spiderNeck;
	private final ModelRenderer spiderBody;
	private final ModelRenderer spiderBody_r1;
	private final ModelRenderer spiderBody_r2;
	private final ModelRenderer spiderBody_r3;
	private final ModelRenderer spiderLeg1;
	private final ModelRenderer spiderLeg2;
	private final ModelRenderer spiderLeg3;
	private final ModelRenderer spiderLeg4;
	private final ModelRenderer spiderLeg5;
	private final ModelRenderer spiderLeg6;
	private final ModelRenderer spiderLeg7;
	private final ModelRenderer spiderLeg10_r1;
	private final ModelRenderer spiderLeg8_r1;
	private final ModelRenderer spiderLeg8;
	private final ModelRenderer spiderLeg9_r1;

	public ScorpionModel() {
		textureWidth = 64;
		textureHeight = 32;
		spiderHead = new ModelRenderer(this);
		spiderHead.setRotationPoint(0.0F, 15.0F, -3.0F);
		spiderHead.setTextureOffset(32, 4).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 8.0F, 20.0F, 0.0F, false);

		spiderNeck = new ModelRenderer(this);
		spiderNeck.setRotationPoint(0.0F, 15.0F, 0.0F);
		

		spiderBody = new ModelRenderer(this);
		spiderBody.setRotationPoint(0.0F, 15.0F, 9.0F);
		spiderBody.setTextureOffset(0, 12).addBox(-1.0F, -29.0F, -7.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		spiderBody_r1 = new ModelRenderer(this);
		spiderBody_r1.setRotationPoint(0.0F, 9.0F, -9.0F);
		spiderBody.addChild(spiderBody_r1);
		setRotationAngle(spiderBody_r1, 2.3562F, 0.0F, 0.0F);
		spiderBody_r1.setTextureOffset(0, 12).addBox(-1.0F, 35.0F, 5.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		spiderBody_r2 = new ModelRenderer(this);
		spiderBody_r2.setRotationPoint(0.0F, 9.0F, -9.0F);
		spiderBody.addChild(spiderBody_r2);
		setRotationAngle(spiderBody_r2, 1.5708F, 0.0F, 0.0F);
		spiderBody_r2.setTextureOffset(0, 12).addBox(-2.0F, 19.0F, 18.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);

		spiderBody_r3 = new ModelRenderer(this);
		spiderBody_r3.setRotationPoint(0.0F, 9.0F, -9.0F);
		spiderBody.addChild(spiderBody_r3);
		setRotationAngle(spiderBody_r3, 0.7854F, 0.0F, 0.0F);
		spiderBody_r3.setTextureOffset(0, 12).addBox(-2.0F, 0.0F, 17.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);

		spiderLeg1 = new ModelRenderer(this);
		spiderLeg1.setRotationPoint(-4.0F, 15.0F, 2.0F);
		spiderLeg1.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		spiderLeg2 = new ModelRenderer(this);
		spiderLeg2.setRotationPoint(4.0F, 15.0F, 2.0F);
		spiderLeg2.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		spiderLeg3 = new ModelRenderer(this);
		spiderLeg3.setRotationPoint(-4.0F, 15.0F, 1.0F);
		spiderLeg3.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		spiderLeg4 = new ModelRenderer(this);
		spiderLeg4.setRotationPoint(4.0F, 15.0F, 1.0F);
		spiderLeg4.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		spiderLeg5 = new ModelRenderer(this);
		spiderLeg5.setRotationPoint(-4.0F, 15.0F, 0.0F);
		spiderLeg5.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		spiderLeg6 = new ModelRenderer(this);
		spiderLeg6.setRotationPoint(4.0F, 15.0F, 0.0F);
		spiderLeg6.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		spiderLeg7 = new ModelRenderer(this);
		spiderLeg7.setRotationPoint(-4.0F, 15.0F, -1.0F);
		spiderLeg7.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		spiderLeg10_r1 = new ModelRenderer(this);
		spiderLeg10_r1.setRotationPoint(4.0F, 9.0F, 1.0F);
		spiderLeg7.addChild(spiderLeg10_r1);
		setRotationAngle(spiderLeg10_r1, 0.0F, -1.5708F, 0.0F);
		spiderLeg10_r1.setTextureOffset(18, 0).addBox(-14.0F, -10.0F, -9.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
		spiderLeg10_r1.setTextureOffset(18, 0).addBox(-14.0F, -10.0F, 7.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		spiderLeg8_r1 = new ModelRenderer(this);
		spiderLeg8_r1.setRotationPoint(4.0F, 9.0F, 1.0F);
		spiderLeg7.addChild(spiderLeg8_r1);
		setRotationAngle(spiderLeg8_r1, 0.0F, -0.6109F, 0.0F);
		spiderLeg8_r1.setTextureOffset(18, 0).addBox(-11.0F, -10.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		spiderLeg8 = new ModelRenderer(this);
		spiderLeg8.setRotationPoint(4.0F, 15.0F, -1.0F);
		spiderLeg8.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

		spiderLeg9_r1 = new ModelRenderer(this);
		spiderLeg9_r1.setRotationPoint(-4.0F, 9.0F, 1.0F);
		spiderLeg8.addChild(spiderLeg9_r1);
		setRotationAngle(spiderLeg9_r1, 0.0F, 0.6109F, 0.0F);
		spiderLeg9_r1.setTextureOffset(18, 0).addBox(3.0F, -10.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
	   }

	   public Iterable<ModelRenderer> getParts() {
	      return ImmutableList.of(this.spiderHead, this.spiderNeck, this.spiderBody, this.spiderLeg1, this.spiderLeg2, this.spiderLeg3, this.spiderLeg4, this.spiderLeg5, this.spiderLeg6, this.spiderLeg7, this.spiderLeg8, this.spiderLeg9_r1, this.spiderLeg8_r1, this.spiderLeg10_r1, this.spiderBody_r1, this.spiderBody_r2, this.spiderBody_r3);
	   }

	   /**
	    * Sets this entity's model rotation angles
	    */
	   public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	      this.spiderHead.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
	      this.spiderHead.rotateAngleX = headPitch * ((float)Math.PI / 180F);
	      this.spiderLeg1.rotateAngleZ = (-(float)Math.PI / 4F);
	      this.spiderLeg2.rotateAngleZ = ((float)Math.PI / 4F);
	      this.spiderLeg3.rotateAngleZ = -0.58119464F;
	      this.spiderLeg4.rotateAngleZ = 0.58119464F;
	      this.spiderLeg5.rotateAngleZ = -0.58119464F;
	      this.spiderLeg6.rotateAngleZ = 0.58119464F;
	      this.spiderLeg7.rotateAngleZ = (-(float)Math.PI / 4F);
	      this.spiderLeg8.rotateAngleZ = ((float)Math.PI / 4F);
	      this.spiderLeg1.rotateAngleY = ((float)Math.PI / 4F);
	      this.spiderLeg2.rotateAngleY = (-(float)Math.PI / 4F);
	      this.spiderLeg3.rotateAngleY = ((float)Math.PI / 8F);
	      this.spiderLeg4.rotateAngleY = (-(float)Math.PI / 8F);
	      this.spiderLeg5.rotateAngleY = (-(float)Math.PI / 8F);
	      this.spiderLeg6.rotateAngleY = ((float)Math.PI / 8F);
	      this.spiderLeg7.rotateAngleY = (-(float)Math.PI / 4F);
	      this.spiderLeg8.rotateAngleY = ((float)Math.PI / 4F);
	      float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
	      float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
	      float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
	      float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
	      float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
	      float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
	      float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
	      float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
	      this.spiderLeg1.rotateAngleY += f3;
	      this.spiderLeg2.rotateAngleY += -f3;
	      this.spiderLeg3.rotateAngleY += f4;
	      this.spiderLeg4.rotateAngleY += -f4;
	      this.spiderLeg5.rotateAngleY += f5;
	      this.spiderLeg6.rotateAngleY += -f5;
	      this.spiderLeg7.rotateAngleY += f6;
	      this.spiderLeg8.rotateAngleY += -f6;
	      this.spiderLeg1.rotateAngleZ += f7;
	      this.spiderLeg2.rotateAngleZ += -f7;
	      this.spiderLeg3.rotateAngleZ += f8;
	      this.spiderLeg4.rotateAngleZ += -f8;
	      this.spiderLeg5.rotateAngleZ += f9;
	      this.spiderLeg6.rotateAngleZ += -f9;
	      this.spiderLeg7.rotateAngleZ += f10;
	      this.spiderLeg8.rotateAngleZ += -f10;
	   }
	   
	   public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
}