package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CrabModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer scorpionBody;
	private final ModelRenderer scorpionLeg1;
	private final ModelRenderer scorpionLeg2;
	private final ModelRenderer scorpionLeg3;
	private final ModelRenderer scorpionLeg4;
	private final ModelRenderer scorpionLeg5;
	private final ModelRenderer scorpionLeg6;
	private final ModelRenderer scorpionLeg7;
	private final ModelRenderer scorpionLeg8;
	private final ModelRenderer scorpionArmRight;
	private final ModelRenderer scorpionClawRight;
	private final ModelRenderer scorpionPincherRightInner;
	private final ModelRenderer scorpionPincherRightOuter;
	private final ModelRenderer scorpionArmLeft;
	private final ModelRenderer scorpionClawLeft;
	private final ModelRenderer scorpionPincherLeftInner;
	private final ModelRenderer scorpionPincherLeftOuter;

	public CrabModel() {
		textureWidth = 64;
		textureHeight = 32;

		scorpionBody = new ModelRenderer(this);
		scorpionBody.setRotationPoint(0.0F, 15.0F, -3.0F);
		scorpionBody.setTextureOffset(0, 12).addBox(-2.0F, 4.0F, 0.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
		
		scorpionLeg1 = new ModelRenderer(this);
		scorpionLeg1.setRotationPoint(-4.0F, 15.0F, 2.0F);
		scorpionLeg1.setTextureOffset(18, 0).addBox(2.0F, 7.0F, -1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg2 = new ModelRenderer(this);
		scorpionLeg2.setRotationPoint(4.0F, 15.0F, 2.0F);
		scorpionLeg2.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg3 = new ModelRenderer(this);
		scorpionLeg3.setRotationPoint(-4.0F, 15.0F, 1.0F);
		scorpionLeg3.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg4 = new ModelRenderer(this);
		scorpionLeg4.setRotationPoint(4.0F, 15.0F, 1.0F);
		scorpionLeg4.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg5 = new ModelRenderer(this);
		scorpionLeg5.setRotationPoint(-4.0F, 15.0F, 0.0F);
		scorpionLeg5.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg6 = new ModelRenderer(this);
		scorpionLeg6.setRotationPoint(4.0F, 15.0F, 0.0F);
		scorpionLeg6.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg7 = new ModelRenderer(this);
		scorpionLeg7.setRotationPoint(-4.0F, 15.0F, -1.0F);
		scorpionLeg7.setTextureOffset(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionLeg8 = new ModelRenderer(this);
		scorpionLeg8.setRotationPoint(4.0F, 15.0F, -1.0F);
		scorpionLeg8.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 1.0F, 1.0F, 0.0F, false);

		scorpionArmRight = new ModelRenderer(this);
		scorpionArmRight.setRotationPoint(-2.0F, 0.0F, 0.0F);
		scorpionArmRight.setTextureOffset(18, 0).addBox(-8.0F, -1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionBody.addChild(scorpionArmRight);

		scorpionClawRight = new ModelRenderer(this);
		scorpionClawRight.setRotationPoint(-7.0F, 0.0F, 0.0F);
		scorpionClawRight.setTextureOffset(18, 0).addBox(-1.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		scorpionArmRight.addChild(scorpionClawRight);
		
		scorpionPincherRightInner = new ModelRenderer(this);
		scorpionPincherRightInner.setRotationPoint(0.0F, 0.0F, 0.0F);
		scorpionPincherRightInner.setTextureOffset(18, 0).addBox(3.0F, -0.5F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		scorpionClawRight.addChild(scorpionPincherRightInner);
		
		scorpionPincherRightOuter = new ModelRenderer(this);
		scorpionPincherRightOuter.setRotationPoint(0.0F, 0.0F, 0.0F);
		scorpionPincherRightOuter.setTextureOffset(18, 0).addBox(3.0F, -0.5F, -2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionClawRight.addChild(scorpionPincherRightOuter);

		scorpionArmLeft = new ModelRenderer(this);
		scorpionArmLeft.setRotationPoint(2.0F, 0.0F, 0.0F);
		scorpionArmLeft.setTextureOffset(18, 0).addBox(0.0F, -1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionBody.addChild(scorpionArmLeft);

		scorpionClawLeft = new ModelRenderer(this);
		scorpionClawLeft.setRotationPoint(7.0F, 0.0F, 0.0F);
		scorpionClawLeft.setTextureOffset(18, 0).addBox(-1.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		scorpionArmLeft.addChild(scorpionClawLeft);
		
		scorpionPincherLeftInner = new ModelRenderer(this);
		scorpionPincherLeftInner.setRotationPoint(0.0F, 0.0F, 0.0F);
		scorpionPincherLeftInner.setTextureOffset(18, 0).addBox(3.0F, -0.5F, -2.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		scorpionClawLeft.addChild(scorpionPincherLeftInner);
		
		scorpionPincherLeftOuter = new ModelRenderer(this);
		scorpionPincherLeftOuter.setRotationPoint(0.0F, 0.0F, 0.0F);
		scorpionPincherLeftOuter.setTextureOffset(18, 0).addBox(3.0F, -0.5F, 1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		scorpionClawLeft.addChild(scorpionPincherLeftOuter);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.scorpionBody, this.scorpionLeg1, this.scorpionLeg2, this.scorpionLeg3, this.scorpionLeg4, this.scorpionLeg5, this.scorpionLeg6, this.scorpionLeg7, this.scorpionLeg8);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		scorpionArmRight.rotateAngleY = - (float) Math.PI / 4F;
		scorpionClawRight.rotateAngleY = 3 *(float) Math.PI / 4F;
		scorpionArmLeft.rotateAngleY = (float) Math.PI / 4F;
		scorpionClawLeft.rotateAngleY = (float) Math.PI / 4F;
		this.scorpionLeg1.rotateAngleZ = (-(float) Math.PI / 4F);
		this.scorpionLeg2.rotateAngleZ = ((float) Math.PI / 4F);
		this.scorpionLeg3.rotateAngleZ = -0.58119464F;
		this.scorpionLeg4.rotateAngleZ = 0.58119464F;
		this.scorpionLeg5.rotateAngleZ = -0.58119464F;
		this.scorpionLeg6.rotateAngleZ = 0.58119464F;
		this.scorpionLeg7.rotateAngleZ = (-(float) Math.PI / 4F);
		this.scorpionLeg8.rotateAngleZ = ((float) Math.PI / 4F);
		this.scorpionLeg1.rotateAngleY = ((float) Math.PI / 4F);
		this.scorpionLeg2.rotateAngleY = (-(float) Math.PI / 4F);
		this.scorpionLeg3.rotateAngleY = ((float) Math.PI / 8F);
		this.scorpionLeg4.rotateAngleY = (-(float) Math.PI / 8F);
		this.scorpionLeg5.rotateAngleY = (-(float) Math.PI / 8F);
		this.scorpionLeg6.rotateAngleY = ((float) Math.PI / 8F);
		this.scorpionLeg7.rotateAngleY = (-(float) Math.PI / 4F);
		this.scorpionLeg8.rotateAngleY = ((float) Math.PI / 4F);
		float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
		float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
		float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
		float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
		this.scorpionLeg1.rotateAngleY += f3;
		this.scorpionLeg2.rotateAngleY += -f3;
		this.scorpionLeg3.rotateAngleY += f4;
		this.scorpionLeg4.rotateAngleY += -f4;
		this.scorpionLeg5.rotateAngleY += f5;
		this.scorpionLeg6.rotateAngleY += -f5;
		this.scorpionLeg7.rotateAngleY += f6;
		this.scorpionLeg8.rotateAngleY += -f6;
		this.scorpionLeg1.rotateAngleZ += f7;
		this.scorpionLeg2.rotateAngleZ += -f7;
		this.scorpionLeg3.rotateAngleZ += f8;
		this.scorpionLeg4.rotateAngleZ += -f8;
		this.scorpionLeg5.rotateAngleZ += f9;
		this.scorpionLeg6.rotateAngleZ += -f9;
		this.scorpionLeg7.rotateAngleZ += f10;
		this.scorpionLeg8.rotateAngleZ += -f10;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}