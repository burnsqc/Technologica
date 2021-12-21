package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.BuffaloEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BuffaloModel<T extends BuffaloEntity> extends QuadrupedModel<T> {

	protected ModelRenderer bodyMane;
	
	public BuffaloModel() {
		super(12, 0.0F, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		
		this.headModel = new ModelRenderer(this, 0, 0);
		this.headModel.addBox(-5.0F, -3.0F, -6.0F, 10.0F, 12.0F, 8.0F);
		this.headModel.setRotationPoint(0.0F, 0.0F, -16.0F);
		this.headModel.setTextureOffset(22, 0).addBox(-6.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F);
		this.headModel.setTextureOffset(22, 0).addBox(5.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F);
		this.headModel.setTextureOffset(22, 0).addBox(-7.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F);
		this.headModel.setTextureOffset(22, 0).addBox(6.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F);
		
		this.body = new ModelRenderer(this, 18, 4);
		this.body.addBox(-6.0F, -10.0F, -14.0F, 12.0F, 16.0F, 28.0F);
		this.body.setRotationPoint(0.0F, 6.0F, -0.0F);
		
		this.bodyMane = new ModelRenderer(this, 18, 4);
		this.bodyMane.addBox(-7.0F, -12.0F, -12.0F, 14.0F, 20.0F, 12.0F);
		this.body.addChild(this.bodyMane);
		
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
		this.headModel.rotateAngleY = 0;
	}
}
