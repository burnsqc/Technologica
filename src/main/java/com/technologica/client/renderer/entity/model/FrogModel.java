package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.FrogEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class FrogModel<T extends FrogEntity> extends QuadrupedModel<T> {

	public FrogModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.textureWidth = 32;
		this.textureHeight = 16;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F);
		this.body.setRotationPoint(0.0F, 21.0F, 0.0F);
		
		this.headModel = new ModelRenderer(this, 0, 7);
		this.headModel.addBox(-1.5F, -1.0F, -3.0F, 3.0F, 2.0F, 3.0F);
		this.headModel.setRotationPoint(0.0F, 20.0F, -1.0F);
		
		this.headModel.setTextureOffset(0, 12).addBox(-1.5F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		this.headModel.setTextureOffset(0, 12).addBox(0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 2.0F);
		
		this.legBackRight = new ModelRenderer(this, 12, 0);
	    this.legBackRight.addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F);
	    this.legBackRight.setRotationPoint(-2.0F, 21.0F, 1.0F);
	    this.legBackRight.addBox(-0.5F, 3.0F, -1.0F, 2.0F, 0.0F, 2.0F);
	    
	    this.legBackLeft = new ModelRenderer(this, 12, 0);
	    this.legBackLeft.addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F);
	    this.legBackLeft.setRotationPoint(1.0F, 21.0F, 1.0F);
	    this.legBackLeft.addBox(-0.5F, 3.0F, -1.0F, 2.0F, 0.0F, 2.0F);
	    
	    this.legFrontRight = new ModelRenderer(this, 12, 0);
	    this.legFrontRight.addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F);
	    this.legFrontRight.setRotationPoint(-2.0F, 21.0F, -2.0F);
	    this.legFrontRight.addBox(-0.5F, 3.0F, -1.0F, 2.0F, 0.0F, 2.0F);
	    
	    this.legFrontLeft = new ModelRenderer(this, 12, 0);
	    this.legFrontLeft.addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F);
	    this.legFrontLeft.setRotationPoint(1.0F, 21.0F, -2.0F);
	    this.legFrontLeft.addBox(-0.5F, 3.0F, -1.0F, 2.0F, 0.0F, 2.0F);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.rotateAngleX = -((float) Math.PI / 8F);
		this.headModel.rotateAngleX = 0;
	}
}
