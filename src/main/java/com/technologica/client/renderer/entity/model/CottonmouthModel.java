package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CottonmouthModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer headUpper;
	private final ModelRenderer headLower;
	private final ModelRenderer fangLeft;
	private final ModelRenderer fangRight;
	private final ModelRenderer body1;
	private final ModelRenderer body2;
	private final ModelRenderer body3;
	private final ModelRenderer body4;
	private final ModelRenderer body5;
	private final ModelRenderer body6;
	private final ModelRenderer body7;
	private final ModelRenderer body8;
	private final ModelRenderer body9;
	private final ModelRenderer body10;
	private final ModelRenderer body11;
	private final ModelRenderer body12;
	private final ModelRenderer body13;
	private final ModelRenderer body14;

	public CottonmouthModel() {
		textureWidth = 16;
		textureHeight = 16;

		this.headLower = new ModelRenderer(this, 0, 8);
		this.headLower.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.headLower.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 1.0F, 3.0F);
		
		this.headUpper = new ModelRenderer(this, 0, 4);
		this.headUpper.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headUpper.addBox(-1.5F, -1.0F, -3.0F, 3.0F, 1.0F, 3.0F);
		this.headLower.addChild(this.headUpper);
		
		this.fangLeft = new ModelRenderer(this, 0, 4);
		this.fangLeft.addBox(1.0F, 0.0F, -2.5F, 0.0F, 1.0F, 1.0F);
		this.headUpper.addChild(this.fangLeft);
		
		this.fangRight = new ModelRenderer(this, 0, 4);
		this.fangRight.addBox(-1.0F, 0.0F, -2.5F, 0.0F, 1.0F, 1.0F);
		this.headUpper.addChild(this.fangRight);
		
		body1 = new ModelRenderer(this, 0, 0);
		body1.setRotationPoint(0.0F, 0.0F, 0.0F);
		body1.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);
		this.headLower.addChild(this.body1);
		
		body2 = new ModelRenderer(this, 0, 0);
		body2.setRotationPoint(0.0F, 0.0F, 2.0F);
		body2.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body1.addChild(this.body2);
		
		body3 = new ModelRenderer(this, 0, 0);
		body3.setRotationPoint(0.0F, 0.0F, 2.0F);
		body3.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body2.addChild(this.body3);
		
		body4 = new ModelRenderer(this, 0, 0);
		body4.setRotationPoint(0.0F, 0.0F, 2.0F);
		body4.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body3.addChild(this.body4);
		
		body5 = new ModelRenderer(this, 0, 0);
		body5.setRotationPoint(0.0F, 0.0F, 2.0F);
		body5.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body4.addChild(this.body5);
		
		body6 = new ModelRenderer(this, 0, 0);
		body6.setRotationPoint(0.0F, 0.0F, 2.0F);
		body6.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body5.addChild(this.body6);
		
		body7 = new ModelRenderer(this, 0, 0);
		body7.setRotationPoint(0.0F, 0.0F, 2.0F);
		body7.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body6.addChild(this.body7);
		
		body8 = new ModelRenderer(this, 0, 0);
		body8.setRotationPoint(0.0F, 0.0F, 2.0F);
		body8.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body7.addChild(this.body8);
		
		body9 = new ModelRenderer(this, 0, 0);
		body9.setRotationPoint(0.0F, 0.0F, 2.0F);
		body9.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body8.addChild(this.body9);
		
		body10 = new ModelRenderer(this, 0, 0);
		body10.setRotationPoint(0.0F, 0.0F, 2.0F);
		body10.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body9.addChild(this.body10);
		
		body11 = new ModelRenderer(this, 0, 0);
		body11.setRotationPoint(0.0F, 0.0F, 2.0F);
		body11.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body10.addChild(this.body11);
		
		body12 = new ModelRenderer(this, 0, 0);
		body12.setRotationPoint(0.0F, 0.0F, 2.0F);
		body12.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body11.addChild(this.body12);
		
		body13 = new ModelRenderer(this, 0, 0);
		body13.setRotationPoint(0.0F, 0.0F, 2.0F);
		body13.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body12.addChild(this.body13);
		
		body14 = new ModelRenderer(this, 0, 0);
		body14.setRotationPoint(0.0F, 0.0F, 2.0F);
		body14.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F);	
		this.body13.addChild(this.body14);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.headLower);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.headUpper.rotateAngleX = -(MathHelper.sin(ageInTicks / 10) * MathHelper.sin(ageInTicks / 10))/2;
		this.body1.rotateAngleY = -MathHelper.sin(ageInTicks / 10)/3;
		this.body2.rotateAngleY = -MathHelper.sin(ageInTicks / 10)/3;
		this.body3.rotateAngleY = -MathHelper.sin(ageInTicks / 10)/3;
		this.body4.rotateAngleY = -MathHelper.sin(ageInTicks / 10)/3;
		this.body5.rotateAngleY = MathHelper.sin(ageInTicks / 10)/3;
		this.body6.rotateAngleY = MathHelper.sin(ageInTicks / 10)/3;
		this.body7.rotateAngleY = MathHelper.sin(ageInTicks / 10)/3;
		this.body8.rotateAngleY = MathHelper.sin(ageInTicks / 10)/3;
		this.body9.rotateAngleY = -MathHelper.sin(ageInTicks / 10)/3;
		this.body10.rotateAngleY = -MathHelper.sin(ageInTicks / 10)/3;
		this.body11.rotateAngleY = -MathHelper.sin(ageInTicks / 10)/3;
		this.body12.rotateAngleY = -MathHelper.sin(ageInTicks / 10)/3;
		this.body13.rotateAngleY = MathHelper.sin(ageInTicks / 10)/3;
		this.body14.rotateAngleY = MathHelper.sin(ageInTicks / 10)/3;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}