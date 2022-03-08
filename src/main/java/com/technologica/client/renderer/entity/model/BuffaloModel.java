package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.BuffaloEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BuffaloModel<T extends BuffaloEntity> extends QuadrupedModel<T> {

	protected ModelRenderer bodyMane;
	
	public BuffaloModel() {
		super(12, 0.0F, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		this.headModel = new ModelRenderer(this, 12, 0);
		this.headModel.addBox(-5.0F, -3.0F, -6.0F, 10.0F, 12.0F, 8.0F);
		this.headModel.setRotationPoint(0.0F, 0.0F, -16.0F);
		this.headModel.setTextureOffset(0, 0).addBox(-6.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F);
		this.headModel.setTextureOffset(0, 0).addBox(5.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F);
		this.headModel.setTextureOffset(0, 2).addBox(-7.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F);
		this.headModel.setTextureOffset(0, 2).addBox(6.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F);
		
		this.body = new ModelRenderer(this, 0, 20);
		this.body.addBox(-6.0F, -10.0F, -14.0F, 12.0F, 16.0F, 28.0F);
		this.body.setRotationPoint(0.0F, 6.0F, -0.0F);
		
		this.bodyMane = new ModelRenderer(this, 52, 0);
		this.bodyMane.addBox(-7.0F, -12.0F, -12.0F, 14.0F, 20.0F, 12.0F);
		this.body.addChild(this.bodyMane);
		
		this.legBackRight = new ModelRenderer(this, 0, 16);
	      this.legBackRight.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.legBackRight.setRotationPoint(-3.0F, 12.0F, 7.0F);
	      this.legBackLeft = new ModelRenderer(this, 0, 16);
	      this.legBackLeft.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.legBackLeft.setRotationPoint(3.0F, 12.0F, 7.0F);
	      this.legFrontRight = new ModelRenderer(this, 0, 16);
	      this.legFrontRight.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.legFrontRight.setRotationPoint(-3.0F, 12.0F, -5.0F);
	      this.legFrontLeft = new ModelRenderer(this, 0, 16);
	      this.legFrontLeft.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
	      this.legFrontLeft.setRotationPoint(3.0F, 12.0F, -5.0F);
		
		--this.legBackRight.rotationPointX;
		++this.legBackLeft.rotationPointX;
		this.legBackRight.rotationPointZ = 12.0F;
		this.legBackLeft.rotationPointZ = 12.0F;
		--this.legFrontRight.rotationPointX;
		++this.legFrontLeft.rotationPointX;
		this.legFrontRight.rotationPointZ = -8.0F;
		this.legFrontLeft.rotationPointZ = -8.0F;
	}
	
	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
